package com.tencent.mobileqq.activity.phone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import gra;
import grb;

public class PhoneFrameActivity
  extends IphoneTitleBarActivity
{
  public static final int a = 0;
  public static final String a = "key_req_type";
  public static final int b = 1;
  public static final String b = "key_reserved_mobile";
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public View a;
  public ImageView a;
  public TextView a;
  public PhoneFrame a;
  boolean a;
  public View b;
  boolean b;
  private int f = 0;
  
  public PhoneFrameActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame = null;
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewView = ((View)findViewById(2131297347).getParent());
    this.b = ((View)this.jdField_a_of_type_AndroidViewView.getParent());
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297357));
    this.leftView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297358));
    this.rightViewText = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297360));
    this.rightViewText.setText(2131369363);
    this.rightViewText.setOnClickListener(new gra(this));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297361));
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("设置");
    IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_AndroidViewView);
    IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_AndroidWidgetTextView);
    IphoneTitleBarActivity.setLayerType(this.leftView);
    IphoneTitleBarActivity.setLayerType(this.rightViewText);
    IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_AndroidWidgetImageView);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame = ((PhoneFrame)findViewById(2131298111));
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame.setActivity(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame.setPhoneContext(new grb(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame.a(null);
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_req_type", this.f);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame.b(localBundle);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 20001)
    {
      if (paramInt2 == -1)
      {
        setResult(-1, paramIntent);
        finish();
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame.a(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawable(null);
    setContentView(2130903402);
    this.f = getIntent().getIntExtra("key_req_type", 0);
    a();
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame.c();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame.d();
    super.doOnDestroy();
  }
  
  protected void doOnPause()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame.b();
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneFrame.a();
  }
  
  public void finish()
  {
    Intent localIntent;
    if ((this.app.isLogin()) && (this.f == 0))
    {
      localIntent = new Intent(this, SplashActivity.class);
      localIntent.setFlags(67108864);
      localIntent.putExtra("tab_index", 3);
      startActivity(localIntent);
    }
    for (;;)
    {
      super.finish();
      return;
      if ((this.app.isLogin()) && (this.f == 4))
      {
        ReportController.b(this.app, "CliOper", "", "", "0X8004F83", "0X8004F83", 0, 0, "", "", "", "");
        localIntent = new Intent(this, SplashActivity.class);
        localIntent.setFlags(67108864);
        localIntent.putExtra("tab_index", 2);
        startActivity(localIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneFrameActivity
 * JD-Core Version:    0.7.0.1
 */