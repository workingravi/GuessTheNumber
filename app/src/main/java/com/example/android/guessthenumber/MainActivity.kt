package com.example.android.guessthenumber

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import java.util.Random
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var chosen_number = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGuess.setOnClickListener {
            chosen_number = Random().nextInt(100) + 1
            label1.text = "I've chosen a number. Now you guess it!"
        }

        btnSubmit.setOnClickListener {
            val user_guess_str = ipText.text.toString()
            val user_guess = Integer.parseInt(user_guess_str)
            ipText.setText("")

            when{
                chosen_number > user_guess -> label1.text = "Guess Higher!"
                chosen_number == user_guess -> label1.text = "You guessed it!!"
                else -> label1.text = "Guess lower!"
            }
        }
    }
}
