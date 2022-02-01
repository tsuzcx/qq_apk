package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class SharedPreUtils
{
  public static final String a = "SharedPreUtils_preference";
  
  public static int a(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("eqq_config_version_code", 0);
  }
  
  public static int a(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("enter_config_verion_code_" + paramString, 0);
  }
  
  public static int a(Context paramContext, String paramString1, String paramString2)
  {
    return paramContext.getSharedPreferences(paramString1, 0).getInt(paramString2, 0);
  }
  
  public static SharedPreferences a(Context paramContext)
  {
    return paramContext.getSharedPreferences("qav_SP", 4);
  }
  
  public static SharedPreferences a(String paramString)
  {
    return BaseApplicationImpl.getContext().getSharedPreferences("lightalk_tips_sp_" + paramString, 0);
  }
  
  public static String a(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("last_loginuin_for_birthday_uin", "");
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramString1 = String.format(Locale.getDefault(), "%s_%s_sharedpreutil", new Object[] { paramString1, paramString2 });
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramString1, paramString3);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("eqq_config_version_code", paramInt);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("enter_config_verion_code_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("splash_version_code", paramInt);
    paramContext.putString("splash_effectivetime", paramString1);
    paramContext.putString("splash_md5value", paramString2);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("last_loginuin_for_birthday_uin", paramString);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("keyword_and_remark_version_code" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramContext == null)) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 11) {}
    for (paramContext = paramContext.getSharedPreferences("SharedPreUtils_preference" + paramString1, 4).edit();; paramContext = paramContext.getSharedPreferences("SharedPreUtils_preference" + paramString1, 0).edit())
    {
      paramContext.putInt(paramString2, paramInt);
      paramContext.commit();
      return;
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramContext == null) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    paramContext = paramContext.getSharedPreferences("LabaSetting_" + paramString2, 0).edit();
    paramContext.putInt(paramString1, 1);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      if (QLog.isColorLevel()) {
        QLog.d("SharedPreUtils", 2, "CNR setAutoLoginSharePre uin is null");
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SharedPreUtils", 2, "CNR setAutoLoginSharePre auto =" + paramBoolean);
      }
      paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
      paramContext.putBoolean("login_auto" + paramString, paramBoolean);
      paramBoolean = paramContext.commit();
    } while (!QLog.isColorLevel());
    QLog.d("SharedPreUtils", 2, "CNR setAutoLoginSharePre isOK =" + paramBoolean);
  }
  
  public static void a(Context paramContext, ArrayList paramArrayList, String paramString)
  {
    if ((paramArrayList == null) || (paramContext == null)) {
      return;
    }
    paramContext = paramContext.getSharedPreferences("LabaSetting_" + paramString, 0).edit();
    paramContext.clear();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      paramContext.putInt((String)paramArrayList.next(), 1);
    }
    paramContext.commit();
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    boolean bool1;
    if ((paramString == null) || (paramString.length() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SharedPreUtils", 2, "CNR getAutoLoginSharePre uin is null");
      }
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("login_auto" + paramString, true);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("SharedPreUtils", 2, "CNR getAutoLoginSharePre auto =" + bool2);
    return bool2;
  }
  
  public static boolean a(Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramContext == null)) {
      return false;
    }
    if (Build.VERSION.SDK_INT >= 11) {}
    for (paramContext = paramContext.getSharedPreferences("SharedPreUtils_preference" + paramString1, 4); paramInt > paramContext.getInt(paramString2, 0); paramContext = paramContext.getSharedPreferences("SharedPreUtils_preference" + paramString1, 0)) {
      return true;
    }
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    boolean bool = true;
    if ((TextUtils.isEmpty(paramString1)) || (paramContext == null)) {
      bool = false;
    }
    while (paramContext.getSharedPreferences("LabaSetting_" + paramString2, 0).getInt(paramString1, 0) == 1) {
      return bool;
    }
    return false;
  }
  
  public static int b(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("splash_version_code", 0);
  }
  
  public static int b(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "pushbanner_ad_version_code", 0);
  }
  
  public static String b(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("birthday_user", "");
  }
  
  public static void b(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "pushbanner_ad_version_code", paramInt);
    paramContext.commit();
  }
  
  public static void b(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString2 + "_" + "birthday_splash_version_code", paramInt);
    paramContext.putString("birthday_splash_md5value", paramString1);
    paramContext.commit();
  }
  
  public static void b(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("birthday_user", paramString);
    paramContext.commit();
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramContext == null)) {
      return;
    }
    paramContext.getSharedPreferences("LabaSetting_" + paramString2, 0).edit().remove(paramString1).commit();
  }
  
  public static void b(Context paramContext, String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("acount_first_login_app" + paramString, paramBoolean);
    paramContext.commit();
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("acount_first_login_app" + paramString, true);
  }
  
  public static int c(Context paramContext)
  {
    int i = 0;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      if (paramContext != null) {
        i = paramContext.versionCode;
      }
      return i;
    }
    catch (Exception paramContext) {}
    return 0;
  }
  
  public static int c(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "birthday_splash_version_code", 0);
  }
  
  public static String c(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("splash_md5value", "");
  }
  
  public static void c(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("general_configs_version_code_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void c(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("eqq-config-data", paramString);
    paramContext.commit();
  }
  
  public static boolean c(Context paramContext, String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("translate_bubble_first_time", true);
  }
  
  public static int d(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("keyword_and_remark_version_code" + paramString, 0);
  }
  
  public static String d(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("eqq-config-data", null);
  }
  
  public static void d(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "lightalk_config_version", paramInt);
    paramContext.commit();
  }
  
  public static void d(Context paramContext, String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("translate_bubble_first_time", false);
    paramContext.commit();
  }
  
  public static int e(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("general_configs_version_code_" + paramString, 0);
  }
  
  public static String e(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("splash_effectivetime", "");
  }
  
  public static int f(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "lightalk_config_version", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SharedPreUtils
 * JD-Core Version:    0.7.0.1
 */