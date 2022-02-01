package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class PackageUtil
{
  private static final String a = "current_uin";
  private static String b = "PackageUtil";
  
  public static String a(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString.trim(), 0);
      if (paramContext == null) {
        return "0";
      }
      paramContext = paramContext.versionName;
      return paramContext;
    }
    catch (Exception paramContext) {}
    return "0";
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(paramString.trim(), 0);
        if (paramContext != null) {
          return true;
        }
      }
      catch (Exception paramContext) {}
    }
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d(b, 2, "<--startAppWithPkgName pkgName=" + paramString1 + ",openid=" + paramString2);
      }
      paramString1 = paramContext.getPackageManager().getLaunchIntentForPackage(paramString1.trim());
      paramString1.setFlags(268435456);
      if ((paramString2 != null) && (paramString2.length() > 4)) {
        paramString1.putExtra("current_uin", paramString2);
      }
      paramString1.putExtra("platformId", "qq_m");
      paramContext.startActivity(paramString1);
      return true;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static String b(Context paramContext, String paramString)
  {
    if (paramString == null) {
      return "0";
    }
    paramContext = paramContext.getPackageManager();
    paramString = paramString.split("\\|");
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    for (;;)
    {
      if (i < paramString.length)
      {
        if (i != 0) {
          localStringBuffer.append("|");
        }
        try
        {
          PackageInfo localPackageInfo = paramContext.getPackageInfo(paramString[i].trim(), 0);
          if (localPackageInfo == null) {
            localStringBuffer.append(0);
          } else {
            localStringBuffer.append(localPackageInfo.versionName);
          }
        }
        catch (Exception localException)
        {
          localStringBuffer.append(0);
        }
      }
      else
      {
        return localStringBuffer.toString();
      }
      i += 1;
    }
  }
  
  public static String c(Context paramContext, String paramString)
  {
    if (paramString == null) {
      return "0";
    }
    paramContext = paramContext.getPackageManager();
    paramString = paramString.split("\\|");
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    for (;;)
    {
      if (i < paramString.length)
      {
        if (i != 0) {
          localStringBuffer.append("|");
        }
        try
        {
          if (paramContext.getPackageInfo(paramString[i].trim(), 0) == null) {
            localStringBuffer.append(0);
          } else {
            localStringBuffer.append(1);
          }
        }
        catch (Exception localException)
        {
          localStringBuffer.append(0);
        }
      }
      else
      {
        return localStringBuffer.toString();
      }
      i += 1;
    }
  }
  
  public static String d(Context paramContext, String paramString)
  {
    if (paramString == null) {
      return "0";
    }
    paramContext = paramContext.getPackageManager();
    paramString = paramString.split("\\|");
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    for (;;)
    {
      if (i < paramString.length)
      {
        if (i != 0) {
          localStringBuffer.append("|");
        }
        try
        {
          PackageInfo localPackageInfo = paramContext.getPackageInfo(paramString[i].trim(), 0);
          if (localPackageInfo == null) {
            localStringBuffer.append(0);
          } else {
            localStringBuffer.append(localPackageInfo.versionCode);
          }
        }
        catch (Exception localException)
        {
          localStringBuffer.append(0);
        }
      }
      else
      {
        return localStringBuffer.toString();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.PackageUtil
 * JD-Core Version:    0.7.0.1
 */