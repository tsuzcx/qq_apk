package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.smtt.sdk.WebView;

public class k
{
  private static String a = null;
  private static String b = "GA";
  private static String c = "GE";
  private static String d = "9422";
  private static String e = "0";
  private static String f = "";
  private static boolean g = false;
  private static boolean h = false;
  private static boolean i = false;
  
  public static String a(Context paramContext)
  {
    return a(paramContext, "0");
  }
  
  public static String a(Context paramContext, String paramString)
  {
    if (!TextUtils.isEmpty(a)) {
      return a;
    }
    a = a(paramContext, String.valueOf(WebView.getTbsSDKVersion(paramContext)), paramString, b, c, d, e, f, g);
    return a;
  }
  
  private static String a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = b(paramContext) + "*" + c(paramContext);
    for (;;)
    {
      try
      {
        localObject1 = paramContext.getApplicationContext().getApplicationInfo();
        localObject3 = paramContext.getPackageManager().getPackageInfo(((ApplicationInfo)localObject1).packageName, 0);
        localObject1 = ((ApplicationInfo)localObject1).packageName;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException1)
      {
        Object localObject1;
        boolean bool;
        String str2;
        paramString7 = "";
        localNameNotFoundException1.printStackTrace();
        Object localObject3 = "";
        localObject2 = paramString7;
        continue;
        if (e(paramContext))
        {
          paramString7 = "PAD";
          continue;
        }
      }
      try
      {
        bool = TextUtils.isEmpty(paramString7);
        if (bool) {
          continue;
        }
        localObject3 = paramString7;
        str2 = a((String)localObject1);
        if (!"QB".equals(str2)) {
          continue;
        }
        if (!paramBoolean) {
          break label473;
        }
        paramString7 = "PAD";
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException2)
      {
        paramString7 = (String)localObject2;
        localObject2 = localNameNotFoundException2;
        continue;
        paramString7 = "PHONE";
        continue;
      }
      localStringBuilder.append("QV").append("=").append("3");
      a(localStringBuilder, "PL", "ADR");
      a(localStringBuilder, "PR", str2);
      a(localStringBuilder, "PP", (String)localObject1);
      a(localStringBuilder, "PPVN", (String)localObject3);
      if (!TextUtils.isEmpty(paramString1)) {
        a(localStringBuilder, "TBSVC", paramString1);
      }
      a(localStringBuilder, "CO", "SYS");
      if ((!TextUtils.isEmpty(paramString2)) && (!paramString2.equals("0"))) {
        a(localStringBuilder, "CO", "BK");
      }
      if (!TextUtils.isEmpty(paramString2)) {
        a(localStringBuilder, "COVC", paramString2);
      }
      a(localStringBuilder, "PB", paramString4);
      a(localStringBuilder, "VE", paramString3);
      a(localStringBuilder, "DE", paramString7);
      paramString1 = paramString6;
      if (TextUtils.isEmpty(paramString6)) {
        paramString1 = "0";
      }
      a(localStringBuilder, "CHID", paramString1);
      a(localStringBuilder, "LCID", paramString5);
      paramContext = d(paramContext);
      try
      {
        paramString1 = new String(paramContext.getBytes("UTF-8"), "ISO8859-1");
        paramContext = paramString1;
      }
      catch (Exception paramString1)
      {
        continue;
      }
      if (!TextUtils.isEmpty(paramContext)) {
        a(localStringBuilder, "MO", paramContext);
      }
      a(localStringBuilder, "RL", str1);
      paramContext = Build.VERSION.RELEASE;
      try
      {
        paramString1 = new String(paramContext.getBytes("UTF-8"), "ISO8859-1");
        paramContext = paramString1;
      }
      catch (Exception paramString1)
      {
        continue;
      }
      if (!TextUtils.isEmpty(paramContext)) {
        a(localStringBuilder, "OS", paramContext);
      }
      a(localStringBuilder, "API", Build.VERSION.SDK_INT + "");
      return localStringBuilder.toString();
      paramString7 = ((PackageInfo)localObject3).versionName;
    }
  }
  
  private static String a(String paramString)
  {
    if ("com.tencent.mm".equals(paramString)) {
      return "WX";
    }
    if ("com.tencent.mobileqq".equals(paramString)) {
      return "QQ";
    }
    if ("com.qzone".equals(paramString)) {
      return "QZ";
    }
    if ("com.tencent.mtt".equals(paramString)) {
      return "QB";
    }
    return "TRD";
  }
  
  private static void a(StringBuilder paramStringBuilder, String paramString1, String paramString2)
  {
    paramStringBuilder.append("&").append(paramString1).append("=").append(paramString2);
  }
  
  private static int b(Context paramContext)
  {
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    if (paramContext != null) {
      return paramContext.getWidth();
    }
    return -1;
  }
  
  private static int c(Context paramContext)
  {
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    if (paramContext != null) {
      return paramContext.getHeight();
    }
    return -1;
  }
  
  private static String d(Context paramContext)
  {
    paramContext = q.d(paramContext);
    return " " + paramContext.replaceAll("[ |\\/|\\_|\\&|\\|]", "") + " ";
  }
  
  private static boolean e(Context paramContext)
  {
    boolean bool = true;
    if (h) {
      return i;
    }
    try
    {
      if (Math.min(b(paramContext), c(paramContext)) * 160 / f(paramContext) >= 700) {}
      for (;;)
      {
        i = bool;
        h = true;
        return i;
        bool = false;
      }
      return false;
    }
    catch (Throwable paramContext) {}
  }
  
  private static int f(Context paramContext)
  {
    Object localObject = (WindowManager)paramContext.getSystemService("window");
    paramContext = new DisplayMetrics();
    localObject = ((WindowManager)localObject).getDefaultDisplay();
    if (localObject != null)
    {
      ((Display)localObject).getMetrics(paramContext);
      return paramContext.densityDpi;
    }
    return 160;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.utils.k
 * JD-Core Version:    0.7.0.1
 */