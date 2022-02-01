package com.tencent.mapsdk.internal;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ConfigurationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.tencent.map.tools.Util;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.URLEncoder;

public final class ha
{
  public static final int a = 400;
  public static final String b = "TencentMapSDK";
  private static final int c = 65537;
  
  public static float a(Context paramContext)
  {
    AppMethodBeat.i(225629);
    if (paramContext == null)
    {
      AppMethodBeat.o(225629);
      return 1.0F;
    }
    float f = paramContext.getResources().getDisplayMetrics().density;
    AppMethodBeat.o(225629);
    return f;
  }
  
  private static Rect a(View paramView)
  {
    AppMethodBeat.i(225726);
    if (paramView == null)
    {
      paramView = new Rect();
      AppMethodBeat.o(225726);
      return paramView;
    }
    int[] arrayOfInt = new int[2];
    paramView.getLocationInWindow(arrayOfInt);
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    paramView = new Rect(i, j, i + paramView.getMeasuredWidth(), j + paramView.getMeasuredHeight());
    AppMethodBeat.o(225726);
    return paramView;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    AppMethodBeat.i(225687);
    if (paramContext == null)
    {
      AppMethodBeat.o(225687);
      return "";
    }
    String str = paramContext.getPackageName();
    Object localObject = null;
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(str, 128);
      if (paramContext == null)
      {
        AppMethodBeat.o(225687);
        return "";
      }
      if (paramContext.metaData == null)
      {
        AppMethodBeat.o(225687);
        return "";
      }
      paramContext = paramContext.metaData.getString(paramString);
      AppMethodBeat.o(225687);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext = localObject;
      }
    }
  }
  
  private static boolean a(View paramView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(225715);
    if (paramView == null)
    {
      AppMethodBeat.o(225715);
      return false;
    }
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    int k = paramView.getMeasuredWidth();
    int m = paramView.getMeasuredHeight();
    if ((paramFloat2 >= j) && (paramFloat2 <= m + j) && (paramFloat1 >= i) && (paramFloat1 <= k + i))
    {
      AppMethodBeat.o(225715);
      return true;
    }
    AppMethodBeat.o(225715);
    return false;
  }
  
  public static int b(Context paramContext)
  {
    AppMethodBeat.i(225636);
    int i = paramContext.getResources().getDisplayMetrics().widthPixels;
    AppMethodBeat.o(225636);
    return i;
  }
  
  public static int c(Context paramContext)
  {
    AppMethodBeat.i(225643);
    int i = paramContext.getResources().getDisplayMetrics().heightPixels;
    AppMethodBeat.o(225643);
    return i;
  }
  
  public static String d(Context paramContext)
  {
    AppMethodBeat.i(225674);
    if (paramContext == null)
    {
      AppMethodBeat.o(225674);
      return "";
    }
    String str1 = "";
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      String str2 = paramContext.versionName;
      int i = paramContext.versionCode;
      paramContext = str2 + i;
      AppMethodBeat.o(225674);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = str1;
      }
    }
  }
  
  public static String e(Context paramContext)
  {
    AppMethodBeat.i(225703);
    if (paramContext == null)
    {
      AppMethodBeat.o(225703);
      return "";
    }
    PackageManager localPackageManager = paramContext.getPackageManager();
    Object localObject = null;
    try
    {
      paramContext = localPackageManager.getApplicationInfo(paramContext.getPackageName(), 128);
      if (paramContext != null)
      {
        paramContext = paramContext.loadLabel(localPackageManager);
        try
        {
          paramContext = URLEncoder.encode(paramContext.toString(), "utf-8");
          AppMethodBeat.o(225703);
          return paramContext;
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            paramContext = "";
          }
        }
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext = localObject;
        continue;
        paramContext = "can't find app name";
      }
    }
  }
  
  public static String f(Context paramContext)
  {
    AppMethodBeat.i(225708);
    if (paramContext == null)
    {
      AppMethodBeat.o(225708);
      return "";
    }
    String str = "";
    try
    {
      paramContext = paramContext.getResources().getDisplayMetrics();
      paramContext = paramContext.widthPixels + "*" + paramContext.heightPixels;
      AppMethodBeat.o(225708);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = str;
      }
    }
  }
  
  private static int[] g(Context paramContext)
  {
    AppMethodBeat.i(225653);
    paramContext = (WindowManager)paramContext.getSystemService("window");
    Point localPoint = new Point();
    paramContext.getDefaultDisplay().getSize(localPoint);
    int i = localPoint.x;
    int j = localPoint.y;
    AppMethodBeat.o(225653);
    return new int[] { i, j };
  }
  
  private static int h(Context paramContext)
  {
    AppMethodBeat.i(225662);
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getDeviceConfigurationInfo();
    if (paramContext != null)
    {
      int i = paramContext.reqGlEsVersion;
      AppMethodBeat.o(225662);
      return i;
    }
    AppMethodBeat.o(225662);
    return 65537;
  }
  
  private static String i(Context paramContext)
  {
    AppMethodBeat.i(225693);
    paramContext = Util.getMD5String(Util.getIMei(paramContext));
    AppMethodBeat.o(225693);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ha
 * JD-Core Version:    0.7.0.1
 */