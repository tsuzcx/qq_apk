package com.samsung.android.sdk.look;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.SystemProperties;
import com.samsung.android.sdk.SsdkInterface;
import com.samsung.android.sdk.SsdkUnsupportedException;
import com.samsung.android.sdk.SsdkVendorCheck;

public final class Slook
  implements SsdkInterface
{
  public static final int AIRBUTTON = 1;
  private static final int NOT_ASSIGN = -1;
  public static final int SMARTCLIP = 2;
  public static final int SPEN_BEZEL_INTERACTION = 5;
  public static final int SPEN_HOVER_ICON = 4;
  private static final String TAG = "Slook";
  public static final int WRITINGBUDDY = 3;
  private static int mVersionCode = -1;
  
  private void insertLog(Context paramContext)
  {
    int i = -1;
    try
    {
      int j = paramContext.getPackageManager().getPackageInfo("com.samsung.android.providers.context", 128).versionCode;
      i = j;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      label20:
      ContentValues localContentValues;
      Object localObject;
      String str;
      break label20;
    }
    if (i > 1)
    {
      if (paramContext.checkCallingOrSelfPermission("com.samsung.android.providers.context.permission.WRITE_USE_APP_FEATURE_SURVEY") != 0) {
        throw new SecurityException();
      }
      localContentValues = new ContentValues();
      localObject = getClass().getPackage().getName();
      str = paramContext.getPackageName() + "#" + getVersionCode();
      localContentValues.put("app_id", (String)localObject);
      localContentValues.put("feature", str);
      localObject = new Intent();
      ((Intent)localObject).setAction("com.samsung.android.providers.context.log.action.USE_APP_FEATURE_SURVEY");
      ((Intent)localObject).putExtra("data", localContentValues);
      ((Intent)localObject).setPackage("com.samsung.android.providers.context");
      paramContext.sendBroadcast((Intent)localObject);
    }
  }
  
  public final int getVersionCode()
  {
    if (mVersionCode != -1) {
      return mVersionCode;
    }
    try
    {
      mVersionCode = SystemProperties.getInt("ro.slook.ver", 0);
      return mVersionCode;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        mVersionCode = 0;
      }
    }
  }
  
  public final String getVersionName()
  {
    return "1.0.1";
  }
  
  public final void initialize(Context paramContext)
  {
    if (!SsdkVendorCheck.isSamsungDevice()) {
      throw new SsdkUnsupportedException("This device is not samsung product.", 0);
    }
    if (getVersionCode() <= 0) {
      throw new SsdkUnsupportedException("This device is not supported.", 1);
    }
    try
    {
      insertLog(paramContext);
      return;
    }
    catch (SecurityException paramContext)
    {
      throw new SecurityException("com.samsung.android.providers.context.permission.WRITE_USE_APP_FEATURE_SURVEY permission is required.");
    }
  }
  
  public final boolean isFeatureEnabled(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("The type(" + paramInt + ") is not supported.");
    }
    if (getVersionCode() > 0) {
      return SlookImpl.isFeatureEnabled(paramInt);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.samsung.android.sdk.look.Slook
 * JD-Core Version:    0.7.0.1
 */