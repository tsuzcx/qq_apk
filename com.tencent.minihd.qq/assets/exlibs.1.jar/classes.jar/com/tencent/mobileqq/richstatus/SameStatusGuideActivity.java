package com.tencent.mobileqq.richstatus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;

public class SameStatusGuideActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    SameStatusActivity.a(this, false, getIntent().getIntExtra("k_action", 0), getIntent().getIntExtra("k_data", 0), getIntent().getStringExtra("k_friend"));
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentViewB(2130904447);
    setTitle("做相同事情的人");
    findViewById(2131302231).setOnClickListener(this);
  }
  
  protected String setLastActivityName()
  {
    return this.leftView.getText().toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SameStatusGuideActivity
 * JD-Core Version:    0.7.0.1
 */