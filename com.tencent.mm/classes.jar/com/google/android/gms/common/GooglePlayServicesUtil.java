package com.google.android.gms.common;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import com.google.android.gms.common.internal.zzi;

public final class GooglePlayServicesUtil
  extends zzg
{
  public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";
  @Deprecated
  public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
  @Deprecated
  public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = zzg.GOOGLE_PLAY_SERVICES_VERSION_CODE;
  public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
  
  @Deprecated
  public static Dialog getErrorDialog(int paramInt1, Activity paramActivity, int paramInt2)
  {
    return getErrorDialog(paramInt1, paramActivity, paramInt2, null);
  }
  
  @Deprecated
  public static Dialog getErrorDialog(int paramInt1, Activity paramActivity, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    int i = paramInt1;
    if (zzd(paramActivity, paramInt1)) {
      i = 18;
    }
    return GoogleApiAvailability.getInstance().getErrorDialog(paramActivity, i, paramInt2, paramOnCancelListener);
  }
  
  @Deprecated
  public static PendingIntent getErrorPendingIntent(int paramInt1, Context paramContext, int paramInt2)
  {
    return zzg.getErrorPendingIntent(paramInt1, paramContext, paramInt2);
  }
  
  @Deprecated
  public static String getErrorString(int paramInt)
  {
    return zzg.getErrorString(paramInt);
  }
  
  @Deprecated
  public static String getOpenSourceSoftwareLicenseInfo(Context paramContext)
  {
    return zzg.getOpenSourceSoftwareLicenseInfo(paramContext);
  }
  
  public static Context getRemoteContext(Context paramContext)
  {
    return zzg.getRemoteContext(paramContext);
  }
  
  public static Resources getRemoteResource(Context paramContext)
  {
    return zzg.getRemoteResource(paramContext);
  }
  
  @Deprecated
  public static int isGooglePlayServicesAvailable(Context paramContext)
  {
    return zzg.isGooglePlayServicesAvailable(paramContext);
  }
  
  @Deprecated
  public static boolean isUserRecoverableError(int paramInt)
  {
    return zzg.isUserRecoverableError(paramInt);
  }
  
  @Deprecated
  public static boolean showErrorDialogFragment(int paramInt1, Activity paramActivity, int paramInt2)
  {
    return showErrorDialogFragment(paramInt1, paramActivity, paramInt2, null);
  }
  
  @Deprecated
  public static boolean showErrorDialogFragment(int paramInt1, Activity paramActivity, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return showErrorDialogFragment(paramInt1, paramActivity, null, paramInt2, paramOnCancelListener);
  }
  
  public static boolean showErrorDialogFragment(int paramInt1, Activity paramActivity, Fragment paramFragment, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    int i = paramInt1;
    if (zzd(paramActivity, paramInt1)) {
      i = 18;
    }
    GoogleApiAvailability localGoogleApiAvailability = GoogleApiAvailability.getInstance();
    if (paramFragment == null) {
      return localGoogleApiAvailability.showErrorDialogFragment(paramActivity, i, paramInt2, paramOnCancelListener);
    }
    paramFragment = localGoogleApiAvailability.zza(paramActivity, i, zzi.zza(paramFragment, GoogleApiAvailability.getInstance().zzb(paramActivity, i, "d"), paramInt2), paramOnCancelListener);
    if (paramFragment == null) {
      return false;
    }
    localGoogleApiAvailability.zza(paramActivity, paramFragment, "GooglePlayServicesErrorDialog", paramOnCancelListener);
    return true;
  }
  
  @Deprecated
  public static void showErrorNotification(int paramInt, Context paramContext)
  {
    GoogleApiAvailability localGoogleApiAvailability = GoogleApiAvailability.getInstance();
    if ((zzd(paramContext, paramInt)) || (zze(paramContext, paramInt)))
    {
      localGoogleApiAvailability.zzaD(paramContext);
      return;
    }
    localGoogleApiAvailability.showErrorNotification(paramContext, paramInt);
  }
  
  @Deprecated
  public static boolean zzd(Context paramContext, int paramInt)
  {
    return zzg.zzd(paramContext, paramInt);
  }
  
  @Deprecated
  public static boolean zze(Context paramContext, int paramInt)
  {
    return zzg.zze(paramContext, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.common.GooglePlayServicesUtil
 * JD-Core Version:    0.7.0.1
 */