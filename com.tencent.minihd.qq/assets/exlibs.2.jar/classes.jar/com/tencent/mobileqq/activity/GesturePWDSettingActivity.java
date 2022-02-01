package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import ecz;
import eda;

public class GesturePWDSettingActivity
  extends IphoneTitleBarActivity
{
  static final int jdField_a_of_type_Int = 11;
  public static final String a = "key_reset";
  private static final int jdField_b_of_type_Int = 10;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new eda(this);
  private View jdField_a_of_type_AndroidViewView;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private boolean jdField_a_of_type_Boolean = false;
  private View jdField_b_of_type_AndroidViewView;
  private int jdField_c_of_type_Int = 0;
  private View jdField_c_of_type_AndroidViewView;
  private int jdField_d_of_type_Int = 0;
  private View jdField_d_of_type_AndroidViewView;
  private View e;
  private View f;
  
  private void a(int paramInt, String paramString)
  {
    QQToast.a(this, paramInt, paramString, 0).b(getTitleBarHeight());
  }
  
  private void b()
  {
    setTitle(2131368423);
    this.b = findViewById(2131297761);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131297765);
    this.jdField_d_of_type_AndroidViewView = findViewById(2131297768);
    this.e = findViewById(2131297762);
    this.f = findViewById(2131297766);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131297764);
    this.b.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131297760));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new ecz(this));
  }
  
  private void c()
  {
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("key_reset", false);
    this.jdField_c_of_type_Int = GesturePWDUtils.getGesturePWDState(this, this.app.a());
    switch (this.jdField_c_of_type_Int)
    {
    default: 
      return;
    case 0: 
      if (this.jdField_a_of_type_Boolean)
      {
        if ((this.leftView != null) && ((this.leftView instanceof TextView))) {
          this.leftView.setText(2131367743);
        }
        startActivityForResult(new Intent(this, GesturePWDCreateActivity.class), 10);
        overridePendingTransition(2130968595, 2130968592);
        return;
      }
      startActivityForResult(new Intent(this, GesturePWDGuideActivity.class), 10);
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
      a(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
    a(true);
    a();
  }
  
  private void d()
  {
    this.jdField_c_of_type_Int = GesturePWDUtils.getGesturePWDState(this, this.app.a());
    switch (this.jdField_c_of_type_Int)
    {
    default: 
      return;
    case 0: 
    case 1: 
      a(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
      return;
    }
    a(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
  }
  
  public void a()
  {
    this.jdField_d_of_type_Int = GesturePWDUtils.getGesturePWDMode(this, this.app.a());
    if (this.jdField_d_of_type_Int == 21)
    {
      this.e.setVisibility(4);
      this.f.setVisibility(0);
      return;
    }
    this.e.setVisibility(0);
    this.f.setVisibility(4);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ((View)this.b.getParent()).setVisibility(8);
      ((View)this.jdField_d_of_type_AndroidViewView.getParent()).setVisibility(0);
    }
    for (;;)
    {
      GesturePWDUtils.setGesturePWDMode(this, this.app.a(), 21);
      a();
      return;
      ((View)this.b.getParent()).setVisibility(8);
      ((View)this.jdField_d_of_type_AndroidViewView.getParent()).setVisibility(8);
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 10)
    {
      if (paramInt2 != -1) {
        break label38;
      }
      d();
      a();
      if (this.jdField_a_of_type_Boolean) {
        finish();
      }
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    return;
    label38:
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903336);
    b();
    c();
    return true;
  }
  
  protected boolean onBackEvent()
  {
    return super.onBackEvent();
  }
  
  protected String setLastActivityName()
  {
    if (this.jdField_c_of_type_Int == 0) {
      return getString(2131369097);
    }
    return getString(2131368423);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GesturePWDSettingActivity
 * JD-Core Version:    0.7.0.1
 */