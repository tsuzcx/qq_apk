package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecSvcHandler;
import com.tencent.mobileqq.app.SecSvcObserver;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import dhg;
import dhh;
import dhi;
import dhj;
import dhk;

public class AuthDevRenameActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, TextView.OnEditorActionListener
{
  public static String a;
  public static String b = "appname";
  public static String c = "appid";
  public static String d = "sub_appid";
  public static String e = "device_guid";
  public static String f = "target_name";
  public static String g = "target_type_info";
  public static String h = "target_desc";
  public static String i = "index";
  private Handler jdField_a_of_type_AndroidOsHandler = new dhi(this);
  private SecSvcObserver jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver = new dhh(this);
  private ClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  
  static
  {
    jdField_a_of_type_JavaLangString = "uin";
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new dhj(this));
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new dhk(this));
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130903916);
    super.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver);
    super.setRightButton(2131368915, this);
    this.leftView.setText(2131365736);
    this.leftView.setOnClickListener(this);
    if ((this.centerView != null) && ((this.centerView instanceof TextView))) {
      this.centerView.setVisibility(8);
    }
    paramBundle = super.getIntent();
    String str;
    if (paramBundle != null)
    {
      str = paramBundle.getStringExtra(f);
      paramBundle = paramBundle.getStringExtra(g);
    }
    for (;;)
    {
      Object localObject = super.findViewById(2131297354);
      if (localObject != null)
      {
        ((View)localObject).setVisibility(0);
        TextView localTextView = (TextView)((View)localObject).findViewById(2131297355);
        if (localTextView != null) {
          localTextView.setText(2131368919);
        }
        localObject = (TextView)((View)localObject).findViewById(2131297356);
        if ((localObject != null) && (!TextUtils.isEmpty(paramBundle))) {
          ((TextView)localObject).setText(paramBundle);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)super.findViewById(2131300092));
        if (!TextUtils.isEmpty(str)) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setHint(str);
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setImeOptions(6);
        this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setOnEditorActionListener(this);
        this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setImeActionLabel(getString(2131365920), 6);
        this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setFilters(new InputFilter[] { new dhg(this) });
        return true;
        super.setTitle(2131368919);
      }
      paramBundle = null;
      str = null;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    Object localObject;
    do
    {
      String str;
      do
      {
        do
        {
          super.finish();
          return;
          if (!NetworkUtil.e(this))
          {
            QQToast.a(this, getString(2131365730), 0).b(getTitleBarHeight());
            return;
          }
          paramView = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getEditableText().toString();
          if (TextUtils.isEmpty(paramView))
          {
            QQToast.a(this, getString(2131368920), 0).b(getTitleBarHeight());
            return;
          }
          localObject = super.getIntent();
        } while (localObject == null);
        str = ((Intent)localObject).getStringExtra(f);
      } while ((TextUtils.isEmpty(str)) || (TextUtils.equals(str, paramView)));
      localObject = ((Intent)localObject).getExtras();
      ((Bundle)localObject).putString(f, paramView);
      ((Bundle)localObject).putString(jdField_a_of_type_JavaLangString, this.app.a());
      paramView = (SecSvcHandler)this.app.a(36);
    } while (paramView == null);
    a();
    paramView.a((Bundle)localObject);
  }
  
  protected void onDestroy()
  {
    b();
    super.onDestroy();
    super.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver);
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6)
    {
      onClick(this.rightViewText);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevRenameActivity
 * JD-Core Version:    0.7.0.1
 */