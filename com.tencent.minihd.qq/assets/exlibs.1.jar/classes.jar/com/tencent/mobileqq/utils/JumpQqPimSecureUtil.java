package com.tencent.mobileqq.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Bundle;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.List;

public class JumpQqPimSecureUtil
{
  public static final String a = "com.tencent.qqpimsecure";
  public static final String b = "platform_Id";
  public static final String c = "launchParam";
  public static final String d = "dest_view";
  public static final String e = "dest_apk";
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    if (paramContext != null)
    {
      Intent localIntent = paramContext.getPackageManager().getLaunchIntentForPackage("com.tencent.qqpimsecure");
      if (localIntent != null)
      {
        Bundle localBundle = new Bundle();
        if ((paramString != null) && (paramString.length() > 0)) {
          localBundle.putString("platform_Id", paramString);
        }
        if (paramInt > 0) {
          localBundle.putInt("dest_view", paramInt);
        }
        localIntent.putExtras(localBundle);
        localIntent.setFlags(402653184);
        paramContext.startActivity(localIntent);
      }
    }
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool1 = false;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.tencent.qqpimsecure", 64).signatures;
      Object localObject = MessageDigest.getInstance("MD5");
      if ((paramContext != null) && (paramContext.length > 0)) {
        ((MessageDigest)localObject).update(paramContext[0].toByteArray());
      }
      paramContext = ((MessageDigest)localObject).digest();
      localObject = new char[16];
      Object tmp58_56 = localObject;
      tmp58_56[0] = 48;
      Object tmp63_58 = tmp58_56;
      tmp63_58[1] = 49;
      Object tmp68_63 = tmp63_58;
      tmp68_63[2] = 50;
      Object tmp73_68 = tmp68_63;
      tmp73_68[3] = 51;
      Object tmp78_73 = tmp73_68;
      tmp78_73[4] = 52;
      Object tmp83_78 = tmp78_73;
      tmp83_78[5] = 53;
      Object tmp88_83 = tmp83_78;
      tmp88_83[6] = 54;
      Object tmp94_88 = tmp88_83;
      tmp94_88[7] = 55;
      Object tmp100_94 = tmp94_88;
      tmp100_94[8] = 56;
      Object tmp106_100 = tmp100_94;
      tmp106_100[9] = 57;
      Object tmp112_106 = tmp106_100;
      tmp112_106[10] = 65;
      Object tmp118_112 = tmp112_106;
      tmp118_112[11] = 66;
      Object tmp124_118 = tmp118_112;
      tmp124_118[12] = 67;
      Object tmp130_124 = tmp124_118;
      tmp130_124[13] = 68;
      Object tmp136_130 = tmp130_124;
      tmp136_130[14] = 69;
      Object tmp142_136 = tmp136_130;
      tmp142_136[15] = 70;
      tmp142_136;
      StringBuilder localStringBuilder = new StringBuilder(paramContext.length * 2);
      int i = 0;
      while (i < paramContext.length)
      {
        localStringBuilder.append(localObject[((paramContext[i] & 0xF0) >>> 4)]);
        localStringBuilder.append(localObject[(paramContext[i] & 0xF)]);
        i += 1;
      }
      if (!"00B1208638DE0FCD3E920886D658DAF6".equalsIgnoreCase(localStringBuilder.toString()))
      {
        boolean bool2 = "7CC749CFC0FB5677E6ABA342EDBDBA5A".equalsIgnoreCase(localStringBuilder.toString());
        if (!bool2) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static boolean b(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      if (paramContext != null)
      {
        paramContext = paramContext.iterator();
        while (paramContext.hasNext()) {
          if ("com.tencent.qqpimsecure".equalsIgnoreCase(((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName)) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public static boolean c(Context paramContext)
  {
    boolean bool2 = false;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.tencent.qqpimsecure", 0);
      boolean bool1 = bool2;
      if (paramContext != null)
      {
        paramContext = paramContext.versionName;
        bool1 = bool2;
        if (paramContext != null)
        {
          boolean bool3 = paramContext.contains("mini");
          bool1 = bool2;
          if (bool3) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static boolean d(Context paramContext)
  {
    boolean bool2 = false;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.tencent.qqpimsecure", 0);
      boolean bool1 = bool2;
      if (paramContext != null)
      {
        paramContext = paramContext.versionName;
        bool1 = bool2;
        if (paramContext != null)
        {
          boolean bool3 = paramContext.contains("minipay");
          bool1 = bool2;
          if (bool3) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static boolean e(Context paramContext)
  {
    boolean bool2 = false;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.tencent.qqpimsecure", 0);
      boolean bool1 = bool2;
      if (paramContext != null)
      {
        int i = paramContext.versionCode;
        bool1 = bool2;
        if (i >= 198) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static boolean f(Context paramContext)
  {
    return ((a(paramContext)) && (e(paramContext)) && (!c(paramContext))) || (d(paramContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpQqPimSecureUtil
 * JD-Core Version:    0.7.0.1
 */