package com.tencent.av.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.view.View;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

public class UITools1
{
  public static final String a = "UITools";
  public static boolean a = true;
  
  public static Bitmap a(Context paramContext, int paramInt)
  {
    try
    {
      paramContext = ((BitmapDrawable)paramContext.getResources().getDrawable(paramInt)).getBitmap();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UITools", 2, "getBitmapFromResourceId", paramContext);
      }
      return null;
    }
    catch (OutOfMemoryError paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UITools", 2, "getBitmapFromResourceId", paramContext);
      }
    }
    return null;
  }
  
  public static String a(long paramLong)
  {
    String str = "00:00";
    long l1;
    long l2;
    if (paramLong > 0L)
    {
      l1 = paramLong % 60L;
      l2 = paramLong / 60L;
      paramLong = l2 / 60L;
      l2 %= 60L;
      if (paramLong > 0L) {
        str = String.format(Locale.CHINA, "%02d:%02d:%02d", new Object[] { Long.valueOf(paramLong), Long.valueOf(l2), Long.valueOf(l1) });
      }
    }
    else
    {
      return str;
    }
    return String.format(Locale.CHINA, "%02d:%02d", new Object[] { Long.valueOf(l2), Long.valueOf(l1) });
  }
  
  public static String a(String paramString)
  {
    int j = 0;
    String str = "已进行通话时长,";
    String[] arrayOfString = paramString.split(":");
    int k;
    int i;
    if (arrayOfString.length == 3)
    {
      k = Integer.valueOf(arrayOfString[0]).intValue();
      j = Integer.valueOf(arrayOfString[1]).intValue();
      i = Integer.valueOf(arrayOfString[2]).intValue();
    }
    for (;;)
    {
      if ((k > 0) || (j > 0) || (i > 0))
      {
        if (k > 0) {
          str = "已进行通话时长," + k + "小时,";
        }
        paramString = str;
        if (j > 0) {
          paramString = str + j + "分,";
        }
        str = paramString;
        if (i > 0) {
          str = paramString + i + "秒";
        }
        return str;
        if (arrayOfString.length == 2)
        {
          j = Integer.valueOf(arrayOfString[0]).intValue();
          i = Integer.valueOf(arrayOfString[1]).intValue();
          k = 0;
        }
      }
      else
      {
        return "已进行通话时长," + paramString;
      }
      i = 0;
      k = 0;
    }
  }
  
  public static void a(Activity paramActivity)
  {
    Object localObject = paramActivity.getPackageName();
    Intent localIntent;
    if (SmallScreenUtils.a(paramActivity, "miui.intent.action.APP_PERM_EDITOR"))
    {
      localIntent = new Intent("miui.intent.action.APP_PERM_EDITOR");
      localIntent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
      localIntent.putExtra("extra_pkgname", (String)localObject);
    }
    for (;;)
    {
      try
      {
        paramActivity.startActivity(localIntent);
        j = 1;
        bool1 = true;
      }
      catch (Exception localException3)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("UITools", 2, "openPermissionActivity e = " + localException3);
        j = 1;
        bool1 = false;
        continue;
      }
      int i = j;
      boolean bool2 = bool1;
      if (!bool1)
      {
        i = j;
        bool2 = bool1;
        if (SmallScreenUtils.a(paramActivity, "com.meizu.safe.security.SHOW_APPSEC"))
        {
          localIntent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
          localIntent.setClassName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity");
          localIntent.putExtra("packageName", (String)localObject);
        }
      }
      try
      {
        paramActivity.startActivity(localIntent);
        i = 2;
        bool2 = true;
      }
      catch (Exception localException4)
      {
        if (!QLog.isColorLevel()) {
          break label452;
        }
        QLog.e("UITools", 2, "openPermissionActivity e = " + localException4);
        i = 2;
        bool2 = false;
        continue;
      }
      int j = i;
      boolean bool1 = bool2;
      if (!bool2)
      {
        j = i;
        bool1 = bool2;
        if (SmallScreenUtils.a(paramActivity, "huawei.intent.action.NOTIFICATIONMANAGER"))
        {
          i = 3;
          localIntent = new Intent();
          localIntent.setClassName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity");
          localIntent.addFlags(268435456);
        }
      }
      try
      {
        paramActivity.startActivity(localIntent);
        bool2 = true;
      }
      catch (Exception localException5)
      {
        if (!QLog.isColorLevel()) {
          break label494;
        }
        QLog.e("UITools", 2, "openPermissionActivity e = " + localException5);
        bool2 = false;
        continue;
      }
      j = i;
      bool1 = bool2;
      if (!bool2) {
        localIntent = new Intent("huawei.intent.action.NOTIFICATIONMANAGER");
      }
      try
      {
        paramActivity.startActivity(localIntent);
        bool1 = true;
        j = i;
      }
      catch (Exception localException6)
      {
        if (!QLog.isColorLevel()) {
          break label534;
        }
        QLog.e("UITools", 2, "openPermissionActivity e = " + localException6);
        bool1 = false;
        j = i;
        continue;
      }
      i = j;
      bool2 = bool1;
      if (!bool1) {
        localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      }
      try
      {
        localIntent.setData(Uri.fromParts("package", (String)localObject, null));
        paramActivity.startActivity(localIntent);
        i = 4;
        bool2 = true;
      }
      catch (Exception localException1)
      {
        if (!QLog.isColorLevel()) {
          break label575;
        }
        QLog.e("UITools", 2, "openPermissionActivity e = " + localException1);
        i = 4;
        bool2 = false;
        continue;
        bool1 = bool2;
        continue;
      }
      if ((!bool2) && (SmallScreenUtils.a(paramActivity, "android.settings.action.MANAGE_OVERLAY_PERMISSION")))
      {
        i = 5;
        localObject = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        try
        {
          paramActivity.startActivity((Intent)localObject);
          bool1 = true;
        }
        catch (Exception localException2)
        {
          if (!QLog.isColorLevel()) {
            break label617;
          }
          QLog.e("UITools", 2, "openPermissionActivity e = " + localException2);
          bool1 = false;
          continue;
        }
        if (!bool1)
        {
          localObject = new Intent(paramActivity, QQBrowserActivity.class);
          ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
          VasWebviewUtil.a(paramActivity, "https://view.yutu.qq.com/yutu/activity/3857.html", 524288L, (Intent)localObject, false, -1);
          i = 6;
        }
        QLog.w("UITools", 1, "请求相机权限, which[" + i + "], openSuccess[" + bool1 + "]");
        return;
      }
      label452:
      label494:
      j = 0;
      label534:
      label575:
      label617:
      bool1 = false;
    }
  }
  
  public static void a(View paramView, String paramString)
  {
    if (a)
    {
      if (QLog.isColorLevel()) {
        QLog.i("UITools", 2, "SetAccText: " + paramString);
      }
      if (paramView != null) {}
    }
    else
    {
      return;
    }
    paramView.setFocusable(true);
    paramView.setContentDescription(paramString);
  }
  
  public static boolean a(Activity paramActivity)
  {
    return (SmallScreenUtils.a(paramActivity, "miui.intent.action.APP_PERM_EDITOR")) || (SmallScreenUtils.a(paramActivity, "com.meizu.safe.security.SHOW_APPSEC")) || (SmallScreenUtils.a(paramActivity, "huawei.intent.action.NOTIFICATIONMANAGER")) || (SmallScreenUtils.a(paramActivity, "android.settings.action.MANAGE_OVERLAY_PERMISSION"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.av.utils.UITools1
 * JD-Core Version:    0.7.0.1
 */