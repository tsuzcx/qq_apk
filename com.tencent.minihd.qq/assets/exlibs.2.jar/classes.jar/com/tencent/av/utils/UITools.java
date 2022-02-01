package com.tencent.av.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.qav.QavSDK;

public class UITools
{
  private static final int HEIGHT = 880;
  private static final int H_W_RATION = 1201;
  private static final int WIDTH = 750;
  
  public static int computeRealWidth(int paramInt)
  {
    return (paramInt << 16) / 1201 >> 6;
  }
  
  public static float dp2px(Context paramContext, float paramFloat)
  {
    return paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F;
  }
  
  public static int getQQVersion()
  {
    try
    {
      Object localObject = QavSDK.getInstance().getContext();
      localObject = ((Context)localObject).getPackageManager().getPackageInfo(((Context)localObject).getPackageName(), 0).versionName;
      return strVersionToInt((String)localObject);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str = "";
      }
    }
  }
  
  public static float getScreenDensity(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().density;
  }
  
  public static int getScreenHeight(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().heightPixels;
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  public static float px2dp(Context paramContext, float paramFloat)
  {
    return paramFloat / paramContext.getResources().getDisplayMetrics().density + 0.5F;
  }
  
  public static int strVersionToInt(String paramString)
  {
    int j = 0;
    try
    {
      paramString = paramString.split("\\.");
      if (paramString.length > 0) {
        j = 0 + Integer.valueOf(paramString[0]).intValue() * 10000;
      }
      int i = j;
      if (paramString.length > 1) {
        i = j + Integer.valueOf(paramString[1]).intValue() * 100;
      }
      j = i;
      if (paramString.length > 2)
      {
        j = Integer.valueOf(paramString[2]).intValue();
        j = i + j;
      }
      return j;
    }
    catch (Exception paramString) {}
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.av.utils.UITools
 * JD-Core Version:    0.7.0.1
 */