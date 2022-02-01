package com.tencent.mobileqq.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.QLog;

public class StatisticTroopAssist
{
  public static final String a = "Click_grp_asst";
  public static final String b = "grp_setting_asst";
  public static final String c = "grp_setting_msg";
  public static final String d = "grp_msg_equ";
  public static final String e = "grp_msg_dec";
  public static final String f = "grp_msg_inc";
  private static String g = "fightReport";
  
  public static int a(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, "Click_grp_asst");
  }
  
  public static int a(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = paramString1 + paramString2;
    return paramContext.getSharedPreferences("mobileQQ", 0).getInt(paramString1, 0);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("mobileQQ", 0).edit();
    localEditor.putInt(paramString + "Click_grp_asst", 0);
    localEditor.putInt(paramString + "grp_setting_asst", 0);
    localEditor.putInt(paramString + "grp_setting_msg", 0);
    localEditor.putInt(paramString + "grp_msg_equ", 0);
    localEditor.putInt(paramString + "grp_msg_dec", 0);
    localEditor.putInt(paramString + "grp_msg_inc", 0);
    localEditor.commit();
    if (QLog.isColorLevel()) {
      QLog.d(g, 2, "+++++++++++++++++reset+++++++++++++++++++++++++++");
    }
    h(paramContext, paramString);
    if (QLog.isColorLevel()) {
      QLog.d(g, 2, "+++++++++++++++++reset+++++++++++++++++++++++++++");
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = paramString1 + paramString2;
    paramContext = paramContext.getSharedPreferences("mobileQQ", 0);
    int i = paramContext.getInt(paramString1, 0);
    paramContext.edit().putInt(paramString1, i + 1).commit();
  }
  
  public static int b(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, "grp_setting_asst");
  }
  
  public static void b(Context paramContext, String paramString)
  {
    a(paramContext, paramString, "Click_grp_asst");
  }
  
  public static int c(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, "grp_setting_msg");
  }
  
  public static void c(Context paramContext, String paramString)
  {
    a(paramContext, paramString, "grp_setting_asst");
  }
  
  public static int d(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, "grp_msg_equ");
  }
  
  public static void d(Context paramContext, String paramString)
  {
    a(paramContext, paramString, "grp_setting_msg");
  }
  
  public static int e(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, "grp_msg_dec");
  }
  
  public static void e(Context paramContext, String paramString)
  {
    a(paramContext, paramString, "grp_msg_equ");
  }
  
  public static int f(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, "grp_msg_inc");
  }
  
  public static void f(Context paramContext, String paramString)
  {
    a(paramContext, paramString, "grp_msg_dec");
  }
  
  public static void g(Context paramContext, String paramString)
  {
    a(paramContext, paramString, "grp_msg_inc");
  }
  
  public static void h(Context paramContext, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.StatisticTroopAssist
 * JD-Core Version:    0.7.0.1
 */