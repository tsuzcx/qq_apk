package com.tencent.device.msg.activities;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.smartdevice.SmartDevicePluginLoader;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;
import dbe;
import java.util.Observable;
import java.util.Observer;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;

public class DeviceShareAgentActivity
  extends AppActivity
  implements Observer
{
  private static String jdField_a_of_type_JavaLangString = "DeviceShareAgentActivity";
  private Intent jdField_a_of_type_AndroidContentIntent;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  
  private void a()
  {
    SmartDevicePluginLoader.a().a(this, getAppRuntime(), getAppRuntime().getAccount(), this.jdField_a_of_type_AndroidContentIntent, "com.tencent.device.activities.DeviceShareConfirmActivity", 0, null, SmartDevicePluginProxyActivity.class);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, super.getResources().getDimensionPixelSize(2131492923));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131362346);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnDismissListener(new dbe(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentIntent = getIntent();
    this.jdField_a_of_type_AndroidContentIntent.putExtra("uinname", ContactUtils.h((QQAppInterface)getAppRuntime(), this.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin")));
    if (SmartDevicePluginLoader.a().a((QQAppInterface)getAppRuntime()))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "start SmartDevicePlugin to goshare");
      }
      a();
      finish();
    }
    for (;;)
    {
      return true;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "download install SmartDevicePlugin");
      }
      SmartDevicePluginLoader.a().addObserver(this);
      SmartDevicePluginLoader.a().a();
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    SmartDevicePluginLoader.a().deleteObserver(this);
    c();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = (Integer)paramObject;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "deviceshare : plugin install finished with code " + paramObservable);
    }
    if (paramObservable.intValue() == 0) {
      a();
    }
    for (;;)
    {
      finish();
      return;
      ToastUtil.a().a(getString(2131362345));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.device.msg.activities.DeviceShareAgentActivity
 * JD-Core Version:    0.7.0.1
 */