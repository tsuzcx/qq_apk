package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.GmsIntents;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GoogleApiAvailabilityLight
{
  public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
  public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE;
  public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
  private static final GoogleApiAvailabilityLight zzaw;
  
  static
  {
    AppMethodBeat.i(4399);
    GOOGLE_PLAY_SERVICES_VERSION_CODE = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    zzaw = new GoogleApiAvailabilityLight();
    AppMethodBeat.o(4399);
  }
  
  public static GoogleApiAvailabilityLight getInstance()
  {
    return zzaw;
  }
  
  @VisibleForTesting
  private static String zza(Context paramContext, String paramString)
  {
    AppMethodBeat.i(4398);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("gcore_");
    localStringBuilder.append(GOOGLE_PLAY_SERVICES_VERSION_CODE);
    localStringBuilder.append("-");
    if (!TextUtils.isEmpty(paramString)) {
      localStringBuilder.append(paramString);
    }
    localStringBuilder.append("-");
    if (paramContext != null) {
      localStringBuilder.append(paramContext.getPackageName());
    }
    localStringBuilder.append("-");
    if (paramContext != null) {}
    try
    {
      localStringBuilder.append(Wrappers.packageManager(paramContext).getPackageInfo(paramContext.getPackageName(), 0).versionCode);
      label100:
      paramContext = localStringBuilder.toString();
      AppMethodBeat.o(4398);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      break label100;
    }
  }
  
  public void cancelAvailabilityErrorNotifications(Context paramContext)
  {
    AppMethodBeat.i(4391);
    GooglePlayServicesUtilLight.cancelAvailabilityErrorNotifications(paramContext);
    AppMethodBeat.o(4391);
  }
  
  public int getApkVersion(Context paramContext)
  {
    AppMethodBeat.i(4393);
    int i = GooglePlayServicesUtilLight.getApkVersion(paramContext);
    AppMethodBeat.o(4393);
    return i;
  }
  
  public int getClientVersion(Context paramContext)
  {
    AppMethodBeat.i(4392);
    int i = GooglePlayServicesUtilLight.getClientVersion(paramContext);
    AppMethodBeat.o(4392);
    return i;
  }
  
  @Deprecated
  public Intent getErrorResolutionIntent(int paramInt)
  {
    AppMethodBeat.i(4387);
    Intent localIntent = getErrorResolutionIntent(null, paramInt, null);
    AppMethodBeat.o(4387);
    return localIntent;
  }
  
  public Intent getErrorResolutionIntent(Context paramContext, int paramInt, String paramString)
  {
    AppMethodBeat.i(4388);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(4388);
      return null;
    case 1: 
    case 2: 
      if ((paramContext != null) && (DeviceProperties.isWearableWithoutPlayStore(paramContext)))
      {
        paramContext = GmsIntents.createAndroidWearUpdateIntent();
        AppMethodBeat.o(4388);
        return paramContext;
      }
      paramContext = GmsIntents.createPlayStoreIntent("com.google.android.gms", zza(paramContext, paramString));
      AppMethodBeat.o(4388);
      return paramContext;
    }
    paramContext = GmsIntents.createSettingsIntent("com.google.android.gms");
    AppMethodBeat.o(4388);
    return paramContext;
  }
  
  public PendingIntent getErrorResolutionPendingIntent(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(4389);
    paramContext = getErrorResolutionPendingIntent(paramContext, paramInt1, paramInt2, null);
    AppMethodBeat.o(4389);
    return paramContext;
  }
  
  public PendingIntent getErrorResolutionPendingIntent(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(4390);
    paramString = getErrorResolutionIntent(paramContext, paramInt1, paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(4390);
      return null;
    }
    paramContext = PendingIntent.getActivity(paramContext, paramInt2, paramString, 134217728);
    AppMethodBeat.o(4390);
    return paramContext;
  }
  
  public String getErrorString(int paramInt)
  {
    AppMethodBeat.i(4397);
    String str = GooglePlayServicesUtilLight.getErrorString(paramInt);
    AppMethodBeat.o(4397);
    return str;
  }
  
  public int isGooglePlayServicesAvailable(Context paramContext)
  {
    AppMethodBeat.i(4382);
    int i = isGooglePlayServicesAvailable(paramContext, GOOGLE_PLAY_SERVICES_VERSION_CODE);
    AppMethodBeat.o(4382);
    return i;
  }
  
  public int isGooglePlayServicesAvailable(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(4383);
    int i = GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(paramContext, paramInt);
    paramInt = i;
    if (GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(paramContext, i)) {
      paramInt = 18;
    }
    AppMethodBeat.o(4383);
    return paramInt;
  }
  
  public boolean isPlayServicesPossiblyUpdating(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(4394);
    boolean bool = GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(paramContext, paramInt);
    AppMethodBeat.o(4394);
    return bool;
  }
  
  public boolean isPlayStorePossiblyUpdating(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(4395);
    boolean bool = GooglePlayServicesUtilLight.isPlayStorePossiblyUpdating(paramContext, paramInt);
    AppMethodBeat.o(4395);
    return bool;
  }
  
  public boolean isUninstalledAppPossiblyUpdating(Context paramContext, String paramString)
  {
    AppMethodBeat.i(4396);
    boolean bool = GooglePlayServicesUtilLight.isUninstalledAppPossiblyUpdating(paramContext, paramString);
    AppMethodBeat.o(4396);
    return bool;
  }
  
  public boolean isUserResolvableError(int paramInt)
  {
    AppMethodBeat.i(4386);
    boolean bool = GooglePlayServicesUtilLight.isUserRecoverableError(paramInt);
    AppMethodBeat.o(4386);
    return bool;
  }
  
  public void verifyGooglePlayServicesIsAvailable(Context paramContext)
  {
    AppMethodBeat.i(4384);
    GooglePlayServicesUtilLight.ensurePlayServicesAvailable(paramContext);
    AppMethodBeat.o(4384);
  }
  
  public void verifyGooglePlayServicesIsAvailable(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(4385);
    GooglePlayServicesUtilLight.ensurePlayServicesAvailable(paramContext, paramInt);
    AppMethodBeat.o(4385);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.GoogleApiAvailabilityLight
 * JD-Core Version:    0.7.0.1
 */