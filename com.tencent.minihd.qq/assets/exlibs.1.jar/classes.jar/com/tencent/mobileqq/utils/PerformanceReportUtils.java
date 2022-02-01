package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.etrump.mixlayout.FontManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kry;
import krz;

public class PerformanceReportUtils
{
  private static final String A = "param_FPS";
  private static final String B = "aioBusiness";
  public static final int a = 0;
  private static long jdField_a_of_type_Long = 0L;
  public static final String a = "actFPSRecent";
  static String[] jdField_a_of_type_ArrayOfJavaLangString = { p, q, r, s, t, u, v };
  public static final int b = 1;
  private static long b = 0L;
  public static final String b = "actFPSFriend";
  public static final int c = 3000;
  private static long c = 0L;
  public static final String c = "actFPSAIO";
  public static final int d = 3;
  private static long d = 0L;
  public static final String d = "actFPSQZoneFriendFeed";
  public static final int e = 4;
  private static long e = 0L;
  public static final String e = "actFPSQZoneMyFeed";
  public static final int f = 5;
  private static long f = 0L;
  public static final String f = "actFPSQZoneUserHome";
  public static final int g = 6;
  private static long g = 0L;
  public static final String g = "actFPSQZoneMoodList";
  public static final int h = 7;
  private static long h = 0L;
  public static final String h = "actFPSFriendSystemMsg";
  public static final int i = 8;
  public static final String i = "actFPSFriendSystemMsg";
  public static final int j = 9;
  private static final String j = PerformanceReportUtils.class.getSimpleName();
  private static String k;
  private static String l;
  private static String m;
  private static String n;
  private static final String o = "1";
  private static String p;
  private static String q;
  private static String r;
  private static String s;
  private static String t;
  private static String u;
  private static String v;
  private static String w;
  private static String x;
  private static String y;
  private static String z;
  
  static
  {
    jdField_a_of_type_Long = 14400000L;
    k = "uiswitchinterval";
    l = "uiswitchflag";
    m = "fpsinterval";
    n = "fpsflag";
    p = "actUISwitchC2C";
    q = "actUISwitchGroup";
    r = "actUISwitchDiscuss";
    s = "actUISwitchQzone";
    t = "actUISwitchUserAlbum";
    u = "actUISwitchQunAlbum";
    v = "actUISwitchUserHome";
    w = "actUISwitchPushBannerMyfeed";
    x = "actUISwitchNotificationMyfeed";
    y = "actUISwitchMyfeed";
    z = "";
  }
  
  public static String a()
  {
    long l2 = 0L;
    if (FontManager.d) {
      l2 = 0L | 0x200;
    }
    long l1 = l2;
    if (BubbleManager.a) {
      l1 = l2 | 0x100;
    }
    l2 = l1;
    if (AvatarPendantManager.b) {
      l2 = l1 | 0x400;
    }
    return String.valueOf(l2);
  }
  
  public static void a()
  {
    FontManager.d = false;
    AvatarPendantManager.b = false;
    BubbleManager.a = false;
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, long paramLong)
  {
    new kry(paramInt, paramLong, paramString).execute(new Void[0]);
  }
  
  public static void a(Intent paramIntent, int paramInt, String paramString)
  {
    long l1 = System.currentTimeMillis();
    long l2 = paramIntent.getLongExtra("key_time_record", -1L);
    if (l2 != -1L)
    {
      paramIntent.removeExtra("key_time_record");
      a(BaseApplicationImpl.getContext(), paramString, paramInt, l1 - l2);
    }
  }
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    new krz(paramString1, paramInt, paramString2).execute(new Void[0]);
  }
  
  public static void a(String paramString, long paramLong)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(j, 4, "reportFPS saveCompleteTime ：tag:" + paramString + ",time:" + paramLong);
    }
    if ("actFPSAIO".equals(paramString)) {
      b = paramLong;
    }
    do
    {
      return;
      if ("actFPSRecent".equals(paramString))
      {
        c = paramLong;
        return;
      }
      if ("actFPSFriend".equals(paramString))
      {
        d = paramLong;
        return;
      }
      if ("actFPSQZoneFriendFeed".equals(paramString))
      {
        e = paramLong;
        return;
      }
      if ("actFPSQZoneMyFeed".equals(paramString))
      {
        f = paramLong;
        return;
      }
      if ("actFPSQZoneUserHome".equals(paramString))
      {
        g = paramLong;
        return;
      }
    } while (!"actFPSQZoneMoodList".equals(paramString));
    h = paramLong;
  }
  
  private static SharedPreferences b()
  {
    Context localContext = BaseApplication.getContext();
    String str = j;
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i1 = 4;; i1 = 0) {
      return localContext.getSharedPreferences(str, i1);
    }
  }
  
  private static boolean b(String paramString)
  {
    long l1;
    if ("actFPSAIO".equals(paramString)) {
      l1 = b;
    }
    for (;;)
    {
      if (l1 == 0L) {}
      while ((float)(SystemClock.uptimeMillis() - l1) / 1000.0F >= 10.0F)
      {
        return false;
        if ("actFPSRecent".equals(paramString))
        {
          l1 = c;
          break;
        }
        if (!"actFPSFriend".equals(paramString)) {
          break label72;
        }
        l1 = d;
        break;
      }
      return true;
      label72:
      l1 = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.PerformanceReportUtils
 * JD-Core Version:    0.7.0.1
 */