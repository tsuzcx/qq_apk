package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.equipmentlock.DevlockPhoneStatus;
import com.tencent.mobileqq.equipmentlock.EquipLockWebEntrance;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import oicq.wlogin_sdk.devicelock.DevlockInfo;

public class AuthDevConfirmPhoneNoActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static final int a = 1001;
  public static final String a = "from_login";
  public static final int b = 1002;
  public static final String b = "phone_num";
  public static final int c = 1003;
  public static final String c = "country_code";
  public static final String d = "auth_dev_open";
  public static final String e = "allow_set";
  public static final String f = "user_guide";
  public static final String g = "user_uin";
  public static final String h = "seq";
  public static final String i = "DevlockInfo";
  private static final String j = "Q.devlock.AuthDevConfirmPhoneNoActivity";
  private static final String k = "UserBehavior";
  private static final String l = "Manually";
  private static final String m = "Push";
  private Button jdField_a_of_type_AndroidWidgetButton = null;
  private TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private DevlockInfo jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo = null;
  private Button jdField_b_of_type_AndroidWidgetButton = null;
  private TextView jdField_b_of_type_AndroidWidgetTextView = null;
  private TextView c = null;
  private String n = null;
  private String o = null;
  private String p = null;
  private String q;
  private String r;
  private String s;
  
  private void a()
  {
    setContentView(2130903918);
    setTitle(2131368856);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300093));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300096));
    this.c = ((TextView)findViewById(2131300097));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131300098));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131300099));
    if ((QLog.isColorLevel()) && ((this.jdField_a_of_type_AndroidWidgetTextView == null) || (this.jdField_b_of_type_AndroidWidgetTextView == null) || (this.c == null) || (this.jdField_a_of_type_AndroidWidgetButton == null) || (this.jdField_b_of_type_AndroidWidgetButton == null)))
    {
      QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "one or more controls is null! ");
      return;
    }
    onCreateRightView();
    setRightButton(2131368907, this);
    Object localObject = (TextView)findViewById(2131297357);
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    if (this.n != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.n);
    }
    if (this.o != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.o);
    }
    if (this.p != null) {
      this.c.setText(this.p);
    }
    localObject = getString(2131368911);
    String str = getString(2131368912);
    this.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject);
    this.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setText(str);
    this.jdField_b_of_type_AndroidWidgetButton.setClickable(true);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    try
    {
      str = this.app.a();
      if (EquipmentLockImpl.a().c()) {}
      for (localObject = "Push";; localObject = "Manually")
      {
        ReportController.b(null, "P_CliOper", "Safe_DeviceLock", str, "UserBehavior", (String)localObject, 0, 6, "", "", "", "");
        return;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    setResult(paramInt, paramIntent);
    finish();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (QLog.isColorLevel()) {
              QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "verify page call back resultCode = " + paramInt2);
            }
            if (paramInt2 == -1)
            {
              if (paramIntent != null) {}
              for (paramIntent = new Intent(paramIntent);; paramIntent = new Intent())
              {
                paramIntent.putExtra("requestCode", paramInt1);
                setResult(-1, paramIntent);
                finish();
                return;
              }
            }
          } while (paramInt2 != 0);
          return;
        } while (paramIntent == null);
        localObject = paramIntent.getExtras();
      } while (localObject == null);
      paramInt2 = ((Bundle)localObject).getInt("resultState", 1);
      localObject = ((Bundle)localObject).getString("resultMobileMask");
    } while (paramInt2 == 1);
    if (paramInt2 == 2) {
      DevlockPhoneStatus.a().a(DevlockPhoneStatus.e);
    }
    for (;;)
    {
      paramIntent = new Intent(paramIntent);
      paramIntent.putExtra("requestCode", paramInt1);
      paramIntent.putExtra("phone_num", (String)localObject);
      setResult(-1, paramIntent);
      finish();
      return;
      if (paramInt2 == 3)
      {
        DevlockPhoneStatus.a().a(DevlockPhoneStatus.d);
        DevlockPhoneStatus.a().a(0L);
      }
    }
  }
  
  protected boolean onBackEvent()
  {
    finish();
    overridePendingTransition(0, 2130968596);
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131300098: 
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "click confirm mobile phone button! ");
      }
      for (;;)
      {
        try
        {
          str = this.app.a();
          if (!EquipmentLockImpl.a().c()) {
            continue;
          }
          paramView = "Push";
          ReportController.b(null, "P_CliOper", "Safe_DeviceLock", str, "UserBehavior", paramView, 0, 7, "", "", "", "");
        }
        catch (Exception paramView)
        {
          String str;
          continue;
        }
        paramView = new Intent(this, AuthDevVerifyCodeActivity.class);
        paramView.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
        paramView.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
        paramView.putExtra("mobile_type", 0);
        startActivityForResult(paramView, 1001);
        return;
        paramView = "Manually";
      }
    case 2131300099: 
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "click modify mobile phone button! ");
      }
      for (;;)
      {
        try
        {
          str = this.app.a();
          if (!EquipmentLockImpl.a().c()) {
            continue;
          }
          paramView = "Push";
          ReportController.b(null, "P_CliOper", "Safe_DeviceLock", str, "UserBehavior", paramView, 0, 8, "", "", "", "");
        }
        catch (Exception paramView)
        {
          continue;
        }
        if (this.app != null) {
          this.app.sendWirelessMeibaoReq(1);
        }
        if ((TextUtils.isEmpty(this.r)) || (!this.r.equals("subaccount"))) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "subaccount enter webview mUin=" + this.q + " mMainAccount=" + this.s);
        }
        if ((TextUtils.isEmpty(this.q)) && (QLog.isColorLevel())) {
          QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "mUin is empty.");
        }
        EquipLockWebEntrance.a(this, this.s, this.q, EquipLockWebEntrance.c, 1002, null);
        return;
        paramView = "Manually";
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "mainaccount enter webview mUin=" + this.q);
      }
      if ((TextUtils.isEmpty(this.q)) && (QLog.isColorLevel())) {
        QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "mUin is empty.");
      }
      EquipLockWebEntrance.a(this, this.q, this.q, EquipLockWebEntrance.c, 1002, null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "onClick right cancel button! ");
    }
    finish();
    overridePendingTransition(0, 2130968596);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Object localObject = getIntent();
    if (localObject == null)
    {
      super.onCreate(paramBundle);
      finish();
      return;
    }
    localObject = ((Intent)localObject).getExtras();
    if (localObject == null)
    {
      super.onCreate(paramBundle);
      finish();
      return;
    }
    this.n = ((Bundle)localObject).getString("ParaTextUp");
    this.o = ((Bundle)localObject).getString("ParaTextDown");
    this.p = ((Bundle)localObject).getString("PhoneNO");
    this.q = ((Bundle)localObject).getString("uin");
    this.r = ((Bundle)localObject).getString("from_where");
    this.s = ((Bundle)localObject).getString("mainaccount");
    this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo = ((DevlockInfo)((Bundle)localObject).get("DevlockInfo"));
    if (QLog.isColorLevel())
    {
      QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "on Create strParaGraphUp : " + this.n);
      QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "on Create strParaGraphDown : " + this.o);
    }
    super.onCreate(paramBundle);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevConfirmPhoneNoActivity
 * JD-Core Version:    0.7.0.1
 */