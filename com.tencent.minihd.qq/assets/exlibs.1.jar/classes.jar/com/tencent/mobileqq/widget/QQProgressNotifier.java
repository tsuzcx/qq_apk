package com.tencent.mobileqq.widget;

import android.content.DialogInterface.OnCancelListener;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import kyp;

public class QQProgressNotifier
{
  public static final int a = 0;
  public static final String a = "QQProgressNotifier";
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = 6;
  protected static final int h = 1;
  protected static final int i = 2;
  protected Handler a;
  public BaseActivity a;
  protected QQProgressDialog a;
  
  public QQProgressNotifier(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_AndroidOsHandler = new kyp(this, Looper.getMainLooper());
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramInt1, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(paramInt2), paramInt3);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    a(paramInt1, paramString, paramInt2, null);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    if ((paramInt1 == 0) && (paramInt2 > 0))
    {
      paramOnCancelListener = Message.obtain();
      paramOnCancelListener.what = 1;
      paramOnCancelListener.arg1 = paramInt1;
      paramOnCancelListener.arg2 = 0;
      paramOnCancelListener.obj = paramString;
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramOnCancelListener, paramInt2);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
    }
    if (paramInt1 == 0)
    {
      if (paramOnCancelListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnCancelListener(paramOnCancelListener);
      }
      if ((paramString == null) || ("".equals(paramString.trim()))) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131366988));
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(true);
        if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) {
          break label225;
        }
        if (!QLog.isDevelopLevel()) {
          break;
        }
        QLog.d("QQProgressNotifier", 4, "[" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing() + "]");
        return;
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
      }
      label225:
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      return;
    }
    if ((paramInt1 == 2) || (paramInt1 == 4) || (paramInt1 == 6))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2130838242);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(false);
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) {
          break label402;
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("QQProgressNotifier", 4, "[" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing() + "]");
        }
      }
      label344:
      paramString = Message.obtain();
      paramString.what = 2;
      paramString.arg1 = paramInt1;
      paramOnCancelListener = this.jdField_a_of_type_AndroidOsHandler;
      if (paramInt2 <= 0) {
        break label412;
      }
    }
    label402:
    label412:
    for (long l = paramInt2;; l = 1000L)
    {
      paramOnCancelListener.sendMessageDelayed(paramString, l);
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2130838252);
      break;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      break label344;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQProgressNotifier
 * JD-Core Version:    0.7.0.1
 */