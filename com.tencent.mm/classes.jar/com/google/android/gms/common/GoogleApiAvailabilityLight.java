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
    AppMethodBeat.i(89377);
    GOOGLE_PLAY_SERVICES_VERSION_CODE = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    zzaw = new GoogleApiAvailabilityLight();
    AppMethodBeat.o(89377);
  }
  
  public static GoogleApiAvailabilityLight getInstance()
  {
    return zzaw;
  }
  
  @VisibleForTesting
  private static String zza(Context paramContext, String paramString)
  {
    AppMethodBeat.i(89376);
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
      label99:
      paramContext = localStringBuilder.toString();
      AppMethodBeat.o(89376);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      break label99;
    }
  }
  
  public void cancelAvailabilityErrorNotifications(Context paramContext)
  {
    AppMethodBeat.i(89369);
    GooglePlayServicesUtilLight.cancelAvailabilityErrorNotifications(paramContext);
    AppMethodBeat.o(89369);
  }
  
  public int getApkVersion(Context paramContext)
  {
    AppMethodBeat.i(89371);
    int i = GooglePlayServicesUtilLight.getApkVersion(paramContext);
    AppMethodBeat.o(89371);
    return i;
  }
  
  public int getClientVersion(Context paramContext)
  {
    AppMethodBeat.i(89370);
    int i = GooglePlayServicesUtilLight.getClientVersion(paramContext);
    AppMethodBeat.o(89370);
    return i;
  }
  
  @Deprecated
  public Intent getErrorResolutionIntent(int paramInt)
  {
    AppMethodBeat.i(89365);
    Intent localIntent = getErrorResolutionIntent(null, paramInt, null);
    AppMethodBeat.o(89365);
    return localIntent;
  }
  
  public Intent getErrorResolutionIntent(Context paramContext, int paramInt, String paramString)
  {
    AppMethodBeat.i(89366);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(89366);
      return null;
    case 1: 
    case 2: 
      if ((paramContext != null) && (DeviceProperties.isWearableWithoutPlayStore(paramContext)))
      {
        paramContext = GmsIntents.createAndroidWearUpdateIntent();
        AppMethodBeat.o(89366);
        return paramContext;
      }
      paramContext = GmsIntents.createPlayStoreIntent("com.google.android.gms", zza(paramContext, paramString));
      AppMethodBeat.o(89366);
      return paramContext;
    }
    paramContext = GmsIntents.createSettingsIntent("com.google.android.gms");
    AppMethodBeat.o(89366);
    return paramContext;
  }
  
  public PendingIntent getErrorResolutionPendingIntent(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89367);
    paramContext = getErrorResolutionPendingIntent(paramContext, paramInt1, paramInt2, null);
    AppMethodBeat.o(89367);
    return paramContext;
  }
  
  public PendingIntent getErrorResolutionPendingIntent(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(89368);
    paramString = getErrorResolutionIntent(paramContext, paramInt1, paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(89368);
      return null;
    }
    paramContext = PendingIntent.getActivity(paramContext, paramInt2, paramString, 134217728);
    AppMethodBeat.o(89368);
    return paramContext;
  }
  
  public String getErrorString(int paramInt)
  {
    AppMethodBeat.i(89375);
    String str = GooglePlayServicesUtilLight.getErrorString(paramInt);
    AppMethodBeat.o(89375);
    return str;
  }
  
  public int isGooglePlayServicesAvailable(Context paramContext)
  {
    AppMethodBeat.i(89360);
    int i = isGooglePlayServicesAvailable(paramContext, GOOGLE_PLAY_SERVICES_VERSION_CODE);
    AppMethodBeat.o(89360);
    return i;
  }
  
  public int isGooglePlayServicesAvailable(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(89361);
    int i = GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(paramContext, paramInt);
    paramInt = i;
    if (GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(paramContext, i)) {
      paramInt = 18;
    }
    AppMethodBeat.o(89361);
    return paramInt;
  }
  
  public boolean isPlayServicesPossiblyUpdating(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(89372);
    boolean bool = GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(paramContext, paramInt);
    AppMethodBeat.o(89372);
    return bool;
  }
  
  public boolean isPlayStorePossiblyUpdating(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(89373);
    boolean bool = GooglePlayServicesUtilLight.isPlayStorePossiblyUpdating(paramContext, paramInt);
    AppMethodBeat.o(89373);
    return bool;
  }
  
  public boolean isUninstalledAppPossiblyUpdating(Context paramContext, String paramString)
  {
    AppMethodBeat.i(89374);
    boolean bool = GooglePlayServicesUtilLight.isUninstalledAppPossiblyUpdating(paramContext, paramString);
    AppMethodBeat.o(89374);
    return bool;
  }
  
  public boolean isUserResolvableError(int paramInt)
  {
    AppMethodBeat.i(89364);
    boolean bool = GooglePlayServicesUtilLight.isUserRecoverableError(paramInt);
    AppMethodBeat.o(89364);
    return bool;
  }
  
  public void verifyGooglePlayServicesIsAvailable(Context paramContext)
  {
    AppMethodBeat.i(89362);
    GooglePlayServicesUtilLight.ensurePlayServicesAvailable(paramContext);
    AppMethodBeat.o(89362);
  }
  
  public void verifyGooglePlayServicesIsAvailable(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(89363);
    GooglePlayServicesUtilLight.ensurePlayServicesAvailable(paramContext, paramInt);
    AppMethodBeat.o(89363);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.GoogleApiAvailabilityLight
 * JD-Core Version:    0.7.0.1
 */