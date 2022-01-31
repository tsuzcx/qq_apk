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
import com.tencent.matrix.trace.core.AppMethodBeat;

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
    AppMethodBeat.i(117191);
    int i = -1;
    try
    {
      int j = paramContext.getPackageManager().getPackageInfo("com.samsung.android.providers.context", 128).versionCode;
      i = j;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      label25:
      ContentValues localContentValues;
      Object localObject;
      String str;
      break label25;
    }
    if (i > 1)
    {
      if (paramContext.checkCallingOrSelfPermission("com.samsung.android.providers.context.permission.WRITE_USE_APP_FEATURE_SURVEY") != 0)
      {
        paramContext = new SecurityException();
        AppMethodBeat.o(117191);
        throw paramContext;
      }
    }
    else
    {
      AppMethodBeat.o(117191);
      return;
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
    AppMethodBeat.o(117191);
  }
  
  public final int getVersionCode()
  {
    AppMethodBeat.i(117188);
    int i;
    if (mVersionCode != -1)
    {
      i = mVersionCode;
      AppMethodBeat.o(117188);
      return i;
    }
    try
    {
      mVersionCode = SystemProperties.getInt("ro.slook.ver", 0);
      i = mVersionCode;
      AppMethodBeat.o(117188);
      return i;
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
    AppMethodBeat.i(117189);
    if (!SsdkVendorCheck.isSamsungDevice())
    {
      paramContext = new SsdkUnsupportedException("This device is not samsung product.", 0);
      AppMethodBeat.o(117189);
      throw paramContext;
    }
    if (getVersionCode() <= 0)
    {
      paramContext = new SsdkUnsupportedException("This device is not supported.", 1);
      AppMethodBeat.o(117189);
      throw paramContext;
    }
    try
    {
      insertLog(paramContext);
      AppMethodBeat.o(117189);
      return;
    }
    catch (SecurityException paramContext)
    {
      paramContext = new SecurityException("com.samsung.android.providers.context.permission.WRITE_USE_APP_FEATURE_SURVEY permission is required.");
      AppMethodBeat.o(117189);
      throw paramContext;
    }
  }
  
  public final boolean isFeatureEnabled(int paramInt)
  {
    AppMethodBeat.i(117190);
    switch (paramInt)
    {
    default: 
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("The type(" + paramInt + ") is not supported.");
      AppMethodBeat.o(117190);
      throw localIllegalArgumentException;
    }
    if (getVersionCode() > 0)
    {
      boolean bool = SlookImpl.isFeatureEnabled(paramInt);
      AppMethodBeat.o(117190);
      return bool;
    }
    AppMethodBeat.o(117190);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.samsung.android.sdk.look.Slook
 * JD-Core Version:    0.7.0.1
 */