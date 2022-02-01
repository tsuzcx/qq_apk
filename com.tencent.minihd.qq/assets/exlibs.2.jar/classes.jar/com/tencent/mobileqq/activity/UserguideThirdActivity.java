package com.tencent.mobileqq.activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import fne;

public class UserguideThirdActivity
  extends UserguideBaseActivity
  implements View.OnClickListener
{
  public static final int a = 1;
  public static final long a = 500L;
  public static final int b = 2;
  private static final String jdField_b_of_type_JavaLangString = "UserguideThirdActivity";
  public static final int e = 3;
  private Handler jdField_a_of_type_AndroidOsHandler = null;
  private View jdField_a_of_type_AndroidViewView;
  private View jdField_b_of_type_AndroidViewView;
  private View c;
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130904060);
    paramBundle = findViewById(2131300661);
    paramBundle.setOnClickListener(this);
    a(paramBundle, 2130840609);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131300664);
    this.b = findViewById(2131300663);
    this.c = findViewById(2131300662);
    this.jdField_a_of_type_AndroidOsHandler = new fne(this);
    if (a()) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 500L);
    }
    for (;;)
    {
      ReportController.a((QQAppInterface)getAppRuntime(), "CliOper", "", "", "0X80051F2", "0X80051F2", 0, 0, "", "", "", "");
      return true;
      b(this.jdField_a_of_type_AndroidViewView);
      b(this.b);
      b(this.c);
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    UserguideActivity.c = false;
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(1)) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      }
      if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(2)) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      }
      if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(3)) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.UserguideThirdActivity
 * JD-Core Version:    0.7.0.1
 */