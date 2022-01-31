package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.x.b;
import android.support.v4.app.x.c;
import android.util.TypedValue;
import android.view.View;
import android.widget.ProgressBar;
import com.google.android.gms.R.drawable;
import com.google.android.gms.R.string;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzh;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.common.util.zzj;
import com.google.android.gms.common.util.zzt;
import com.google.android.gms.internal.zzaaz;
import com.google.android.gms.internal.zzaaz.zza;
import com.google.android.gms.internal.zzabf;
import com.google.android.gms.internal.zzabj;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.atomic.AtomicBoolean;

public class GoogleApiAvailability
  extends zze
{
  public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
  public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = zze.GOOGLE_PLAY_SERVICES_VERSION_CODE;
  private static final GoogleApiAvailability zzaym = new GoogleApiAvailability();
  
  public static GoogleApiAvailability getInstance()
  {
    return zzaym;
  }
  
  public Dialog getErrorDialog(Activity paramActivity, int paramInt1, int paramInt2)
  {
    return getErrorDialog(paramActivity, paramInt1, paramInt2, null);
  }
  
  public Dialog getErrorDialog(Activity paramActivity, int paramInt1, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return zza(paramActivity, paramInt1, zzi.zza(paramActivity, zzb(paramActivity, paramInt1, "d"), paramInt2), paramOnCancelListener);
  }
  
  public PendingIntent getErrorResolutionPendingIntent(Context paramContext, int paramInt1, int paramInt2)
  {
    return super.getErrorResolutionPendingIntent(paramContext, paramInt1, paramInt2);
  }
  
  public PendingIntent getErrorResolutionPendingIntent(Context paramContext, ConnectionResult paramConnectionResult)
  {
    if (paramConnectionResult.hasResolution()) {
      return paramConnectionResult.getResolution();
    }
    return getErrorResolutionPendingIntent(paramContext, paramConnectionResult.getErrorCode(), 0);
  }
  
  public final String getErrorString(int paramInt)
  {
    return super.getErrorString(paramInt);
  }
  
  public String getOpenSourceSoftwareLicenseInfo(Context paramContext)
  {
    return super.getOpenSourceSoftwareLicenseInfo(paramContext);
  }
  
  public int isGooglePlayServicesAvailable(Context paramContext)
  {
    return super.isGooglePlayServicesAvailable(paramContext);
  }
  
  public final boolean isUserResolvableError(int paramInt)
  {
    return super.isUserResolvableError(paramInt);
  }
  
  public Task<Void> makeGooglePlayServicesAvailable(Activity paramActivity)
  {
    zzac.zzdj("makeGooglePlayServicesAvailable must be called from the main thread");
    int i = isGooglePlayServicesAvailable(paramActivity);
    if (i == 0) {
      return Tasks.forResult(null);
    }
    paramActivity = zzabj.zzu(paramActivity);
    paramActivity.zzk(new ConnectionResult(i, null));
    return paramActivity.getTask();
  }
  
  public boolean showErrorDialogFragment(Activity paramActivity, int paramInt1, int paramInt2)
  {
    return showErrorDialogFragment(paramActivity, paramInt1, paramInt2, null);
  }
  
  public boolean showErrorDialogFragment(Activity paramActivity, int paramInt1, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    Dialog localDialog = getErrorDialog(paramActivity, paramInt1, paramInt2, paramOnCancelListener);
    if (localDialog == null) {
      return false;
    }
    zza(paramActivity, localDialog, "GooglePlayServicesErrorDialog", paramOnCancelListener);
    return true;
  }
  
  public void showErrorNotification(Context paramContext, int paramInt)
  {
    zza(paramContext, paramInt, null);
  }
  
  public void showErrorNotification(Context paramContext, ConnectionResult paramConnectionResult)
  {
    PendingIntent localPendingIntent = getErrorResolutionPendingIntent(paramContext, paramConnectionResult);
    zza(paramContext, paramConnectionResult.getErrorCode(), null, localPendingIntent);
  }
  
  public Dialog zza(Activity paramActivity, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    Object localObject = new ProgressBar(paramActivity, null, 16842874);
    ((ProgressBar)localObject).setIndeterminate(true);
    ((ProgressBar)localObject).setVisibility(0);
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramActivity);
    localBuilder.setView((View)localObject);
    localBuilder.setMessage(zzh.zzi(paramActivity, 18));
    localBuilder.setPositiveButton("", null);
    localObject = localBuilder.create();
    zza(paramActivity, (Dialog)localObject, "GooglePlayServicesUpdatingDialog", paramOnCancelListener);
    return localObject;
  }
  
  Dialog zza(Context paramContext, int paramInt, zzi paramzzi, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AlertDialog.Builder localBuilder = null;
    if (paramInt == 0) {
      return null;
    }
    Object localObject = new TypedValue();
    paramContext.getTheme().resolveAttribute(16843529, (TypedValue)localObject, true);
    if ("Theme.Dialog.Alert".equals(paramContext.getResources().getResourceEntryName(((TypedValue)localObject).resourceId))) {
      localBuilder = new AlertDialog.Builder(paramContext, 5);
    }
    localObject = localBuilder;
    if (localBuilder == null) {
      localObject = new AlertDialog.Builder(paramContext);
    }
    ((AlertDialog.Builder)localObject).setMessage(zzh.zzi(paramContext, paramInt));
    if (paramOnCancelListener != null) {
      ((AlertDialog.Builder)localObject).setOnCancelListener(paramOnCancelListener);
    }
    paramOnCancelListener = zzh.zzk(paramContext, paramInt);
    if (paramOnCancelListener != null) {
      ((AlertDialog.Builder)localObject).setPositiveButton(paramOnCancelListener, paramzzi);
    }
    paramContext = zzh.zzg(paramContext, paramInt);
    if (paramContext != null) {
      ((AlertDialog.Builder)localObject).setTitle(paramContext);
    }
    return ((AlertDialog.Builder)localObject).create();
  }
  
  public PendingIntent zza(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    return super.zza(paramContext, paramInt1, paramInt2, paramString);
  }
  
  public zzaaz zza(Context paramContext, zzaaz.zza paramzza)
  {
    Object localObject = new IntentFilter("android.intent.action.PACKAGE_ADDED");
    ((IntentFilter)localObject).addDataScheme("package");
    zzaaz localzzaaz = new zzaaz(paramzza);
    paramContext.registerReceiver(localzzaaz, (IntentFilter)localObject);
    localzzaaz.setContext(paramContext);
    localObject = localzzaaz;
    if (!zzz(paramContext, "com.google.android.gms"))
    {
      paramzza.zzvE();
      localzzaaz.unregister();
      localObject = null;
    }
    return localObject;
  }
  
  void zza(Activity paramActivity, Dialog paramDialog, String paramString, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    if ((paramActivity instanceof FragmentActivity))
    {
      paramActivity = ((FragmentActivity)paramActivity).getSupportFragmentManager();
      SupportErrorDialogFragment.newInstance(paramDialog, paramOnCancelListener).show(paramActivity, paramString);
      return;
    }
    paramActivity = paramActivity.getFragmentManager();
    ErrorDialogFragment.newInstance(paramDialog, paramOnCancelListener).show(paramActivity, paramString);
  }
  
  public void zza(Context paramContext, int paramInt, String paramString)
  {
    zza(paramContext, paramInt, paramString, zza(paramContext, paramInt, 0, "n"));
  }
  
  @TargetApi(20)
  void zza(Context paramContext, int paramInt, String paramString, PendingIntent paramPendingIntent)
  {
    if (paramInt == 18) {
      zzaD(paramContext);
    }
    while (paramPendingIntent == null) {
      return;
    }
    String str2 = zzh.zzh(paramContext, paramInt);
    String str1 = zzh.zzj(paramContext, paramInt);
    Object localObject = paramContext.getResources();
    if (zzj.zzba(paramContext))
    {
      zzac.zzaw(zzt.zzzm());
      paramPendingIntent = new Notification.Builder(paramContext).setSmallIcon(paramContext.getApplicationInfo().icon).setPriority(2).setAutoCancel(true).setContentTitle(str2).setStyle(new Notification.BigTextStyle().bigText(str1)).addAction(R.drawable.common_full_open_on_phone, ((Resources)localObject).getString(R.string.common_open_on_phone), paramPendingIntent).build();
      switch (paramInt)
      {
      }
    }
    for (paramInt = 39789;; paramInt = 10436)
    {
      paramContext = (NotificationManager)paramContext.getSystemService("notification");
      if (paramString != null) {
        break label275;
      }
      paramContext.notify(paramInt, paramPendingIntent);
      return;
      localObject = new x.c(paramContext, (byte)0).ah(17301642).e(((Resources)localObject).getString(R.string.common_google_play_services_notification_ticker)).j(System.currentTimeMillis()).z(true);
      ((x.c)localObject).xz = paramPendingIntent;
      paramPendingIntent = ((x.c)localObject).c(str2).d(str1);
      paramPendingIntent.xQ = true;
      paramPendingIntent = paramPendingIntent.a(new x.b().b(str1)).build();
      break;
      zzg.zzayB.set(false);
    }
    label275:
    paramContext.notify(paramString, paramInt, paramPendingIntent);
  }
  
  public boolean zza(Activity paramActivity, zzabf paramzzabf, int paramInt1, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    paramzzabf = zza(paramActivity, paramInt1, zzi.zza(paramzzabf, zzb(paramActivity, paramInt1, "d"), paramInt2), paramOnCancelListener);
    if (paramzzabf == null) {
      return false;
    }
    zza(paramActivity, paramzzabf, "GooglePlayServicesErrorDialog", paramOnCancelListener);
    return true;
  }
  
  public boolean zza(Context paramContext, ConnectionResult paramConnectionResult, int paramInt)
  {
    PendingIntent localPendingIntent = getErrorResolutionPendingIntent(paramContext, paramConnectionResult);
    if (localPendingIntent != null)
    {
      zza(paramContext, paramConnectionResult.getErrorCode(), null, GoogleApiActivity.zza(paramContext, localPendingIntent, paramInt));
      return true;
    }
    return false;
  }
  
  public int zzaC(Context paramContext)
  {
    return super.zzaC(paramContext);
  }
  
  void zzaD(Context paramContext)
  {
    new GoogleApiAvailability.zza(this, paramContext).sendEmptyMessageDelayed(1, 120000L);
  }
  
  public Intent zzb(Context paramContext, int paramInt, String paramString)
  {
    return super.zzb(paramContext, paramInt, paramString);
  }
  
  @Deprecated
  public Intent zzcw(int paramInt)
  {
    return super.zzcw(paramInt);
  }
  
  public boolean zzd(Context paramContext, int paramInt)
  {
    return super.zzd(paramContext, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.GoogleApiAvailability
 * JD-Core Version:    0.7.0.1
 */