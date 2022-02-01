package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.sso.SsosvrrHandler;
import com.tencent.mobileqq.utils.sso.SsosvrrObserver;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import eos;
import eot;
import eou;
import eov;

public class OpenidToUinActivity
  extends BaseActivity
{
  private static final int jdField_a_of_type_Int = 1;
  public static final String a = "OpenidToUinActivity";
  private static final int b = 2;
  public static final String b = "mqqwpa://";
  private static final int c = 3;
  public static final String c = "mqqwpaopenid://";
  private static final String jdField_d_of_type_JavaLangString = "Pb_account_lifeservice";
  private static final String jdField_e_of_type_JavaLangString = "WPA";
  private static final String jdField_f_of_type_JavaLangString = "0X8004C19";
  private static final String g = "0X8004C17";
  private static final String h = "0X8004C18";
  private long jdField_a_of_type_Long;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private SsosvrrObserver jdField_a_of_type_ComTencentMobileqqUtilsSsoSsosvrrObserver;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private Drawable[] jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
  private int jdField_d_of_type_Int;
  private int jdField_e_of_type_Int;
  private int jdField_f_of_type_Int;
  private String i;
  private String j;
  
  private String a(int paramInt)
  {
    Object localObject1 = "mqqwpa://" + this.j.split("\\?")[0].substring("mqqwpaopenid://".length()) + "?";
    String[] arrayOfString = this.j.split("\\?")[1].split("&");
    int k = 0;
    if (k < arrayOfString.length)
    {
      if (arrayOfString[k].startsWith("chat_type")) {
        localObject1 = (String)localObject1 + arrayOfString[k].split("=")[0] + "=wpa";
      }
      for (;;)
      {
        label116:
        Object localObject2 = localObject1;
        if (k != arrayOfString.length - 1) {
          localObject2 = (String)localObject1 + "&";
        }
        do
        {
          k += 1;
          localObject1 = localObject2;
          break;
          if (arrayOfString[k].startsWith("openid"))
          {
            localObject1 = (String)localObject1 + "uin=" + String.valueOf(paramInt);
            break label116;
          }
          localObject2 = localObject1;
        } while (arrayOfString[k].startsWith("appid"));
        localObject1 = (String)localObject1 + arrayOfString[k];
      }
    }
    return localObject1;
  }
  
  private void a()
  {
    a(0L, 3);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getResources().getDimensionPixelSize(2131492923));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(new eot(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getString(2131369957));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2130838254);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    new Handler().postDelayed(new eou(this), 3000L);
  }
  
  private void a(long paramLong, int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          ReportController.b(this.app, "CliOper", "", "", "0X8004C19", "0X8004C19", 0, 0, "" + paramLong, "", "", "");
        } while (!QLog.isColorLevel());
        QLog.d("OpenidToUinActivity", 2, "Openid loading time" + paramLong);
        return;
        ReportController.b(this.app, "CliOper", "", "", "0X8004C17", "0X8004C17", 0, 0, "", "", "", "");
      } while (!QLog.isColorLevel());
      QLog.d("OpenidToUinActivity", 2, "Openid load count");
      return;
      ReportController.b(this.app, "CliOper", "", "", "0X8004C18", "0X8004C18", 0, 0, "", "", "", "");
    } while (!QLog.isColorLevel());
    QLog.d("OpenidToUinActivity", 2, "Openid load fail");
  }
  
  private void a(String paramString)
  {
    JumpParser.a(this.app, this, paramString).b();
    finish();
  }
  
  private void b()
  {
    ((SsosvrrHandler)this.app.a(55)).a(this.i, this.e);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsSsoSsosvrrObserver = new eov(this);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqUtilsSsoSsosvrrObserver);
  }
  
  private void d()
  {
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqUtilsSsoSsosvrrObserver);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    this.i = paramBundle.getStringExtra("openid");
    this.e = paramBundle.getIntExtra("appid", -1);
    this.j = paramBundle.getStringExtra("source");
    this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131558902);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(true);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2130903413);
    this.jdField_a_of_type_AndroidAppDialog.show();
    this.jdField_a_of_type_AndroidAppDialog.setOnCancelListener(new eos(this));
    c();
    b();
    a(0L, 2);
    return true;
  }
  
  protected void doOnDestroy()
  {
    d();
    super.doOnDestroy();
  }
  
  public void onBackPressed()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    if (isFinishing()) {
      return;
    }
    finish();
    moveTaskToBack(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.OpenidToUinActivity
 * JD-Core Version:    0.7.0.1
 */