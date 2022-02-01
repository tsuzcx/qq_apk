package com.tencent.av.smallscreen;

import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.BadTokenException;
import byx;
import byy;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qav.app.QavAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.BaseActivity;

public class SmallScreenDialogActivity
  extends BaseActivity
  implements DialogInterface.OnClickListener
{
  public static final String a = "miui.intent.action.APP_PERM_EDITOR";
  public static final String b = "com.meizu.safe.security.SHOW_APPSEC";
  public static final String c = "huawei.intent.action.NOTIFICATIONMANAGER";
  public static final String d = "permission.intent.action.softPermissionDetail";
  public static final String e = "android.settings.action.MANAGE_OVERLAY_PERMISSION";
  public static final String f = "com.miui.securitycenter";
  public static final String g = "com.meizu.safe";
  public static final String h = "com.huawei.systemmanager";
  public static final String i = "com.miui.permcenter.permissions.AppPermissionsEditorActivity";
  public static final String j = "com.meizu.safe.security.AppSecActivity";
  public static final String k = "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity";
  public static final String l = "extra_pkgname";
  public static final String m = "packageName";
  private static final String n = "SmallScreenDialogActivity";
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new byx(this);
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  public QavAppInterface a;
  private QQCustomDialog b = null;
  
  private QQCustomDialog a()
  {
    QQCustomDialog localQQCustomDialog;
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
    {
      localQQCustomDialog = DialogUtil.a(this, 230).setMessage(2131363202).setNegativeButton(2131365736, this);
      if (!b()) {
        break label76;
      }
    }
    label76:
    for (int i1 = 2131363227;; i1 = 2131363203)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = localQQCustomDialog.setPositiveButton(i1, this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(2131363201);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCanceledOnTouchOutside(false);
      return this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    }
  }
  
  private QQCustomDialog b()
  {
    if (this.b == null)
    {
      this.b = DialogUtil.a(this, 230).setMessage(2131363228).setNegativeButton(2131365736, this).setPositiveButton(2131366209, this);
      this.b.setTitle(2131363229);
      this.b.setCancelable(false);
      this.b.setCanceledOnTouchOutside(false);
    }
    return this.b;
  }
  
  private void b() {}
  
  private boolean b()
  {
    return (SmallScreenUtils.a(this, "miui.intent.action.APP_PERM_EDITOR")) || (SmallScreenUtils.a(this, "com.meizu.safe.security.SHOW_APPSEC")) || ((SmallScreenUtils.a(this, "huawei.intent.action.NOTIFICATIONMANAGER")) && (!a())) || (SmallScreenUtils.a(this, "android.settings.action.MANAGE_OVERLAY_PERMISSION"));
  }
  
  void a()
  {
    boolean bool3 = false;
    String str3 = getPackageName();
    Object localObject1 = null;
    if (SmallScreenUtils.a(this, "android.settings.action.MANAGE_OVERLAY_PERMISSION")) {
      localObject1 = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + str3));
    }
    for (;;)
    {
      try
      {
        startActivity((Intent)localObject1);
        localObject1 = "ACTION_ANDROID";
        bool2 = true;
      }
      catch (Exception localException1)
      {
        Object localObject3;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("SmallScreenDialogActivity", 2, "openPermissionActivity Exception", localException1);
        str1 = "Exception:" + localException1.getMessage();
        bool2 = false;
        continue;
      }
      boolean bool1 = bool2;
      localObject3 = localObject1;
      if (!bool2)
      {
        bool1 = bool2;
        localObject3 = localObject1;
        if (SmallScreenUtils.a(this, "miui.intent.action.APP_PERM_EDITOR"))
        {
          localObject3 = new Intent("miui.intent.action.APP_PERM_EDITOR");
          ((Intent)localObject3).setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
          ((Intent)localObject3).putExtra("extra_pkgname", str3);
        }
      }
      try
      {
        startActivity((Intent)localObject3);
        localObject3 = "ACTION_MIUI";
        bool1 = true;
      }
      catch (Exception localException3)
      {
        if (!QLog.isColorLevel()) {
          break label476;
        }
        QLog.e("SmallScreenDialogActivity", 2, "openPermissionActivity Exception", localException3);
        bool1 = false;
        str2 = str1;
        continue;
      }
      boolean bool2 = bool1;
      localObject1 = localObject3;
      if (!bool1)
      {
        bool2 = bool1;
        localObject1 = localObject3;
        if (SmallScreenUtils.a(this, "com.meizu.safe.security.SHOW_APPSEC"))
        {
          localObject1 = new Intent("com.meizu.safe.security.SHOW_APPSEC");
          ((Intent)localObject1).setClassName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity");
          ((Intent)localObject1).putExtra("packageName", str3);
        }
      }
      try
      {
        startActivity((Intent)localObject1);
        localObject1 = "ACTION_MEIZU";
        bool2 = true;
      }
      catch (Exception localException2)
      {
        label476:
        if (!QLog.isColorLevel()) {
          break label503;
        }
        QLog.e("SmallScreenDialogActivity", 2, "openPermissionActivity Exception", localException2);
        label503:
        bool2 = false;
        localObject2 = str2;
        continue;
        label530:
        label553:
        bool1 = bool2;
        continue;
      }
      if ((!bool2) && ("vivo".equalsIgnoreCase(DeviceInfoUtil.g())) && (SmallScreenUtils.a(this, "permission.intent.action.softPermissionDetail")))
      {
        localObject3 = new Intent("permission.intent.action.softPermissionDetail");
        try
        {
          ((Intent)localObject3).putExtra("packagename", str3);
          startActivity((Intent)localObject3);
          localObject1 = "ACTION_VIVO";
          bool1 = true;
        }
        catch (Exception localException4)
        {
          if (!QLog.isColorLevel()) {
            break label530;
          }
          QLog.e("SmallScreenDialogActivity", 2, "openPermissionActivity Exception", localException4);
          bool1 = false;
          continue;
          bool1 = bool2;
          continue;
        }
        localObject3 = localObject1;
        bool2 = bool1;
        if (!bool1)
        {
          localObject3 = localObject1;
          bool2 = bool1;
          if (SmallScreenUtils.a(this, "huawei.intent.action.NOTIFICATIONMANAGER"))
          {
            localObject3 = localObject1;
            bool2 = bool1;
            if (!a())
            {
              localObject3 = new Intent();
              ((Intent)localObject3).setClassName("com.huawei.systemmanager", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity");
              try
              {
                startActivity((Intent)localObject3);
                localObject1 = "ACTION_HUAWEI_1";
                bool1 = true;
              }
              catch (Exception localException5)
              {
                if (!QLog.isColorLevel()) {
                  break label553;
                }
                QLog.e("SmallScreenDialogActivity", 2, "openPermissionActivity Exception", localException5);
                bool1 = false;
                continue;
              }
              localObject3 = localObject1;
              bool2 = bool1;
              if (!bool1)
              {
                localObject3 = new Intent("huawei.intent.action.NOTIFICATIONMANAGER");
                try
                {
                  startActivity((Intent)localObject3);
                  localObject3 = "ACTION_HUAWEI_2";
                  bool1 = true;
                }
                catch (Exception localException6)
                {
                  String str1;
                  String str2;
                  Object localObject2;
                  Object localObject4 = localObject2;
                  bool1 = bool3;
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.e("SmallScreenDialogActivity", 2, "openPermissionActivity Exception", localException6);
                  localObject4 = localObject2;
                  bool1 = bool3;
                  continue;
                }
                QLog.w("SmallScreenDialogActivity", 1, "openPermissionActivity, openSuccess[" + bool1 + "], code[" + (String)localObject3 + "]");
                if (!bool1) {
                  b();
                }
                return;
              }
            }
          }
        }
      }
      bool2 = false;
    }
  }
  
  public void a(String paramString, QQCustomDialog paramQQCustomDialog)
  {
    try
    {
      QLog.w("SmallScreenDialogActivity", 1, "showDialog, from[" + paramString + "]");
      paramQQCustomDialog.show();
      return;
    }
    catch (WindowManager.BadTokenException localBadTokenException)
    {
      QLog.w("SmallScreenDialogActivity", 1, "showDialog BadTokenException, from[" + paramString + "]", localBadTokenException);
      getWindow().getDecorView().post(new byy(this, paramString, paramQQCustomDialog));
    }
  }
  
  boolean a()
  {
    return Build.MODEL.equals("H60-L01");
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface.equals(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog)) {
      switch (paramInt)
      {
      }
    }
    while (!paramDialogInterface.equals(this.b))
    {
      return;
      boolean bool = getIntent().getBooleanExtra("is_video", false);
      paramDialogInterface = this.jdField_a_of_type_ComTencentQavAppQavAppInterface.a();
      SmallScreenUtils.a(paramDialogInterface, SmallScreenUtils.a(paramDialogInterface, bool) + 1, bool);
      finish();
      return;
      if (b())
      {
        a();
        return;
      }
      b();
      finish();
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      if (SmallScreenUtils.b(this))
      {
        QLog.w("SmallScreenDialogActivity", 1, "锁屏中，不弹2");
        finish();
        return;
      }
      a("clickCancel", this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog);
      return;
    }
    b();
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.requestWindowFeature(1);
    this.jdField_a_of_type_ComTencentQavAppQavAppInterface = ((QavAppInterface)super.getAppRuntime());
    paramBundle = new IntentFilter();
    paramBundle.addAction("tencent.video.v2q.SmallScreenState");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    if (SmallScreenUtils.a(this.jdField_a_of_type_ComTencentQavAppQavAppInterface.a())) {
      finish();
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
  
  protected void onResume()
  {
    super.onResume();
    if (SmallScreenUtils.b(this))
    {
      QLog.w("SmallScreenDialogActivity", 1, "锁屏中，不弹1");
      finish();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
    {
      a();
      a("onResume.1", this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog);
      return;
    }
    if (!SmallScreenUtils.a(this.jdField_a_of_type_ComTencentQavAppQavAppInterface.a()))
    {
      b();
      a("onResume.1", this.b);
      return;
    }
    QLog.w("SmallScreenDialogActivity", 1, "onResume, finish");
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenDialogActivity
 * JD-Core Version:    0.7.0.1
 */