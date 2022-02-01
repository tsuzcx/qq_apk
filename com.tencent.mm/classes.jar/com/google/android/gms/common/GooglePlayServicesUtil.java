package com.google.android.gms.common;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import com.google.android.gms.common.internal.DialogRedirect;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class GooglePlayServicesUtil
  extends GooglePlayServicesUtilLight
{
  public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";
  @Deprecated
  public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
  @Deprecated
  public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
  public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
  
  @Deprecated
  public static Dialog getErrorDialog(int paramInt1, Activity paramActivity, int paramInt2)
  {
    AppMethodBeat.i(10943);
    paramActivity = getErrorDialog(paramInt1, paramActivity, paramInt2, null);
    AppMethodBeat.o(10943);
    return paramActivity;
  }
  
  @Deprecated
  public static Dialog getErrorDialog(int paramInt1, Activity paramActivity, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(10944);
    int i = paramInt1;
    if (GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(paramActivity, paramInt1)) {
      i = 18;
    }
    paramActivity = GoogleApiAvailability.getInstance().getErrorDialog(paramActivity, i, paramInt2, paramOnCancelListener);
    AppMethodBeat.o(10944);
    return paramActivity;
  }
  
  @Deprecated
  public static PendingIntent getErrorPendingIntent(int paramInt1, Context paramContext, int paramInt2)
  {
    AppMethodBeat.i(10951);
    paramContext = GooglePlayServicesUtilLight.getErrorPendingIntent(paramInt1, paramContext, paramInt2);
    AppMethodBeat.o(10951);
    return paramContext;
  }
  
  @Deprecated
  @VisibleForTesting
  public static String getErrorString(int paramInt)
  {
    AppMethodBeat.i(10949);
    String str = GooglePlayServicesUtilLight.getErrorString(paramInt);
    AppMethodBeat.o(10949);
    return str;
  }
  
  public static Context getRemoteContext(Context paramContext)
  {
    AppMethodBeat.i(10954);
    paramContext = GooglePlayServicesUtilLight.getRemoteContext(paramContext);
    AppMethodBeat.o(10954);
    return paramContext;
  }
  
  public static Resources getRemoteResource(Context paramContext)
  {
    AppMethodBeat.i(10953);
    paramContext = GooglePlayServicesUtilLight.getRemoteResource(paramContext);
    AppMethodBeat.o(10953);
    return paramContext;
  }
  
  @Deprecated
  public static int isGooglePlayServicesAvailable(Context paramContext)
  {
    AppMethodBeat.i(10950);
    int i = GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(paramContext);
    AppMethodBeat.o(10950);
    return i;
  }
  
  @Deprecated
  public static boolean isUserRecoverableError(int paramInt)
  {
    AppMethodBeat.i(10952);
    boolean bool = GooglePlayServicesUtilLight.isUserRecoverableError(paramInt);
    AppMethodBeat.o(10952);
    return bool;
  }
  
  @Deprecated
  public static boolean showErrorDialogFragment(int paramInt1, Activity paramActivity, int paramInt2)
  {
    AppMethodBeat.i(10948);
    boolean bool = showErrorDialogFragment(paramInt1, paramActivity, paramInt2, null);
    AppMethodBeat.o(10948);
    return bool;
  }
  
  @Deprecated
  public static boolean showErrorDialogFragment(int paramInt1, Activity paramActivity, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(10945);
    boolean bool = showErrorDialogFragment(paramInt1, paramActivity, null, paramInt2, paramOnCancelListener);
    AppMethodBeat.o(10945);
    return bool;
  }
  
  public static boolean showErrorDialogFragment(int paramInt1, Activity paramActivity, Fragment paramFragment, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(10946);
    int i = paramInt1;
    if (GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(paramActivity, paramInt1)) {
      i = 18;
    }
    GoogleApiAvailability localGoogleApiAvailability = GoogleApiAvailability.getInstance();
    if (paramFragment == null)
    {
      boolean bool = localGoogleApiAvailability.showErrorDialogFragment(paramActivity, i, paramInt2, paramOnCancelListener);
      AppMethodBeat.o(10946);
      return bool;
    }
    paramFragment = GoogleApiAvailability.zza(paramActivity, i, DialogRedirect.getInstance(paramFragment, GoogleApiAvailability.getInstance().getErrorResolutionIntent(paramActivity, i, "d"), paramInt2), paramOnCancelListener);
    if (paramFragment == null)
    {
      AppMethodBeat.o(10946);
      return false;
    }
    GoogleApiAvailability.zza(paramActivity, paramFragment, "GooglePlayServicesErrorDialog", paramOnCancelListener);
    AppMethodBeat.o(10946);
    return true;
  }
  
  @Deprecated
  public static void showErrorNotification(int paramInt, Context paramContext)
  {
    AppMethodBeat.i(10947);
    GoogleApiAvailability localGoogleApiAvailability = GoogleApiAvailability.getInstance();
    if ((GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(paramContext, paramInt)) || (GooglePlayServicesUtilLight.isPlayStorePossiblyUpdating(paramContext, paramInt)))
    {
      localGoogleApiAvailability.zza(paramContext);
      AppMethodBeat.o(10947);
      return;
    }
    localGoogleApiAvailability.showErrorNotification(paramContext, paramInt);
    AppMethodBeat.o(10947);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.GooglePlayServicesUtil
 * JD-Core Version:    0.7.0.1
 */