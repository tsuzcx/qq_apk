package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.NotificationChannel;
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
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.s.b;
import android.support.v4.app.s.c;
import android.util.TypedValue;
import android.view.View;
import android.widget.ProgressBar;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.GooglePlayServicesUpdatedReceiver;
import com.google.android.gms.common.api.internal.GooglePlayServicesUpdatedReceiver.Callback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.api.internal.zzbt;
import com.google.android.gms.common.api.internal.zzh;
import com.google.android.gms.common.api.internal.zzk;
import com.google.android.gms.common.internal.ConnectionErrorMessages;
import com.google.android.gms.common.internal.DialogRedirect;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class GoogleApiAvailability
  extends GoogleApiAvailabilityLight
{
  public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
  public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE;
  private static final Object mLock;
  private static final GoogleApiAvailability zzas;
  private String zzat;
  
  static
  {
    AppMethodBeat.i(60450);
    mLock = new Object();
    zzas = new GoogleApiAvailability();
    GOOGLE_PLAY_SERVICES_VERSION_CODE = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    AppMethodBeat.o(60450);
  }
  
  public static GoogleApiAvailability getInstance()
  {
    return zzas;
  }
  
  static Dialog zza(Context paramContext, int paramInt, DialogRedirect paramDialogRedirect, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AlertDialog.Builder localBuilder = null;
    AppMethodBeat.i(60445);
    if (paramInt == 0)
    {
      AppMethodBeat.o(60445);
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
    ((AlertDialog.Builder)localObject).setMessage(ConnectionErrorMessages.getErrorMessage(paramContext, paramInt));
    if (paramOnCancelListener != null) {
      ((AlertDialog.Builder)localObject).setOnCancelListener(paramOnCancelListener);
    }
    paramOnCancelListener = ConnectionErrorMessages.getErrorDialogButtonMessage(paramContext, paramInt);
    if (paramOnCancelListener != null) {
      ((AlertDialog.Builder)localObject).setPositiveButton(paramOnCancelListener, paramDialogRedirect);
    }
    paramContext = ConnectionErrorMessages.getErrorTitle(paramContext, paramInt);
    if (paramContext != null) {
      ((AlertDialog.Builder)localObject).setTitle(paramContext);
    }
    paramContext = ((AlertDialog.Builder)localObject).create();
    AppMethodBeat.o(60445);
    return paramContext;
  }
  
  @TargetApi(26)
  private final String zza(Context paramContext, NotificationManager paramNotificationManager)
  {
    AppMethodBeat.i(60448);
    Preconditions.checkState(PlatformVersion.isAtLeastO());
    String str2 = zzb();
    String str1 = str2;
    NotificationChannel localNotificationChannel;
    if (str2 == null)
    {
      str2 = "com.google.android.gms.availability";
      localNotificationChannel = paramNotificationManager.getNotificationChannel("com.google.android.gms.availability");
      paramContext = ConnectionErrorMessages.getDefaultNotificationChannelName(paramContext);
      if (localNotificationChannel != null) {
        break label72;
      }
      paramNotificationManager.createNotificationChannel(new NotificationChannel("com.google.android.gms.availability", paramContext, 4));
      str1 = str2;
    }
    for (;;)
    {
      AppMethodBeat.o(60448);
      return str1;
      label72:
      str1 = str2;
      if (!paramContext.equals(localNotificationChannel.getName()))
      {
        localNotificationChannel.setName(paramContext);
        paramNotificationManager.createNotificationChannel(localNotificationChannel);
        str1 = str2;
      }
    }
  }
  
  static void zza(Activity paramActivity, Dialog paramDialog, String paramString, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(60446);
    if ((paramActivity instanceof FragmentActivity))
    {
      paramActivity = ((FragmentActivity)paramActivity).getSupportFragmentManager();
      SupportErrorDialogFragment.newInstance(paramDialog, paramOnCancelListener).show(paramActivity, paramString);
      AppMethodBeat.o(60446);
      return;
    }
    paramActivity = paramActivity.getFragmentManager();
    ErrorDialogFragment.newInstance(paramDialog, paramOnCancelListener).show(paramActivity, paramString);
    AppMethodBeat.o(60446);
  }
  
  @TargetApi(20)
  private final void zza(Context paramContext, int paramInt, String paramString, PendingIntent paramPendingIntent)
  {
    AppMethodBeat.i(60447);
    if (paramInt == 18)
    {
      zza(paramContext);
      AppMethodBeat.o(60447);
      return;
    }
    if (paramPendingIntent == null)
    {
      AppMethodBeat.o(60447);
      return;
    }
    String str = ConnectionErrorMessages.getErrorNotificationTitle(paramContext, paramInt);
    Object localObject1 = ConnectionErrorMessages.getErrorNotificationMessage(paramContext, paramInt);
    Object localObject2 = paramContext.getResources();
    NotificationManager localNotificationManager = (NotificationManager)paramContext.getSystemService("notification");
    if (DeviceProperties.isWearable(paramContext))
    {
      Preconditions.checkState(PlatformVersion.isAtLeastKitKatWatch());
      localObject1 = new Notification.Builder(paramContext).setSmallIcon(paramContext.getApplicationInfo().icon).setPriority(2).setAutoCancel(true).setContentTitle(str).setStyle(new Notification.BigTextStyle().bigText((CharSequence)localObject1));
      if (DeviceProperties.isWearableWithoutPlayStore(paramContext))
      {
        ((Notification.Builder)localObject1).addAction(2130838448, ((Resources)localObject2).getString(2131296301), paramPendingIntent);
        if ((PlatformVersion.isAtLeastO()) && (PlatformVersion.isAtLeastO())) {
          ((Notification.Builder)localObject1).setChannelId(zza(paramContext, localNotificationManager));
        }
        paramContext = ((Notification.Builder)localObject1).build();
        switch (paramInt)
        {
        default: 
          label182:
          paramInt = 39789;
        }
      }
    }
    for (;;)
    {
      if (paramString != null) {
        break label370;
      }
      localNotificationManager.notify(paramInt, paramContext);
      AppMethodBeat.o(60447);
      return;
      ((Notification.Builder)localObject1).setContentIntent(paramPendingIntent);
      break;
      localObject2 = new s.c(paramContext).Y(17301642).h(((Resources)localObject2).getString(2131296293)).g(System.currentTimeMillis()).z(true);
      ((s.c)localObject2).ya = paramPendingIntent;
      paramPendingIntent = ((s.c)localObject2).e(str).f((CharSequence)localObject1);
      paramPendingIntent.yr = true;
      paramPendingIntent = paramPendingIntent.a(new s.b().d((CharSequence)localObject1));
      if ((PlatformVersion.isAtLeastO()) && (PlatformVersion.isAtLeastO())) {
        paramPendingIntent.mChannelId = zza(paramContext, localNotificationManager);
      }
      paramContext = paramPendingIntent.build();
      break label182;
      paramInt = 10436;
      GooglePlayServicesUtilLight.zzbt.set(false);
    }
    label370:
    localNotificationManager.notify(paramString, paramInt, paramContext);
    AppMethodBeat.o(60447);
  }
  
  private final String zzb()
  {
    synchronized (mLock)
    {
      String str = this.zzat;
      return str;
    }
  }
  
  public Task<Void> checkApiAvailability(GoogleApi<?> paramGoogleApi, GoogleApi<?>... paramVarArgs)
  {
    AppMethodBeat.i(60429);
    paramGoogleApi = checkApiAvailabilityAndPackages(paramGoogleApi, paramVarArgs).continueWith(new zza(this));
    AppMethodBeat.o(60429);
    return paramGoogleApi;
  }
  
  public Task<Map<zzh<?>, String>> checkApiAvailabilityAndPackages(GoogleApi<?> paramGoogleApi, GoogleApi<?>... paramVarArgs)
  {
    AppMethodBeat.i(60430);
    Preconditions.checkNotNull(paramGoogleApi, "Requested API must not be null.");
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      Preconditions.checkNotNull(paramVarArgs[i], "Requested API must not be null.");
      i += 1;
    }
    ArrayList localArrayList = new ArrayList(paramVarArgs.length + 1);
    localArrayList.add(paramGoogleApi);
    localArrayList.addAll(Arrays.asList(paramVarArgs));
    paramGoogleApi = GoogleApiManager.zzbf().zza(localArrayList);
    AppMethodBeat.o(60430);
    return paramGoogleApi;
  }
  
  public int getApkVersion(Context paramContext)
  {
    AppMethodBeat.i(60441);
    int i = super.getApkVersion(paramContext);
    AppMethodBeat.o(60441);
    return i;
  }
  
  public int getClientVersion(Context paramContext)
  {
    AppMethodBeat.i(60440);
    int i = super.getClientVersion(paramContext);
    AppMethodBeat.o(60440);
    return i;
  }
  
  public Dialog getErrorDialog(Activity paramActivity, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(60418);
    paramActivity = getErrorDialog(paramActivity, paramInt1, paramInt2, null);
    AppMethodBeat.o(60418);
    return paramActivity;
  }
  
  public Dialog getErrorDialog(Activity paramActivity, int paramInt1, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(60419);
    paramActivity = zza(paramActivity, paramInt1, DialogRedirect.getInstance(paramActivity, getErrorResolutionIntent(paramActivity, paramInt1, "d"), paramInt2), paramOnCancelListener);
    AppMethodBeat.o(60419);
    return paramActivity;
  }
  
  @Deprecated
  public Intent getErrorResolutionIntent(int paramInt)
  {
    AppMethodBeat.i(60435);
    Intent localIntent = super.getErrorResolutionIntent(paramInt);
    AppMethodBeat.o(60435);
    return localIntent;
  }
  
  public Intent getErrorResolutionIntent(Context paramContext, int paramInt, String paramString)
  {
    AppMethodBeat.i(60436);
    paramContext = super.getErrorResolutionIntent(paramContext, paramInt, paramString);
    AppMethodBeat.o(60436);
    return paramContext;
  }
  
  public PendingIntent getErrorResolutionPendingIntent(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(60437);
    paramContext = super.getErrorResolutionPendingIntent(paramContext, paramInt1, paramInt2);
    AppMethodBeat.o(60437);
    return paramContext;
  }
  
  public PendingIntent getErrorResolutionPendingIntent(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(60439);
    paramContext = super.getErrorResolutionPendingIntent(paramContext, paramInt1, paramInt2, paramString);
    AppMethodBeat.o(60439);
    return paramContext;
  }
  
  public PendingIntent getErrorResolutionPendingIntent(Context paramContext, ConnectionResult paramConnectionResult)
  {
    AppMethodBeat.i(60438);
    if (paramConnectionResult.hasResolution())
    {
      paramContext = paramConnectionResult.getResolution();
      AppMethodBeat.o(60438);
      return paramContext;
    }
    paramContext = getErrorResolutionPendingIntent(paramContext, paramConnectionResult.getErrorCode(), 0);
    AppMethodBeat.o(60438);
    return paramContext;
  }
  
  public final String getErrorString(int paramInt)
  {
    AppMethodBeat.i(60444);
    String str = super.getErrorString(paramInt);
    AppMethodBeat.o(60444);
    return str;
  }
  
  public int isGooglePlayServicesAvailable(Context paramContext)
  {
    AppMethodBeat.i(60432);
    int i = super.isGooglePlayServicesAvailable(paramContext);
    AppMethodBeat.o(60432);
    return i;
  }
  
  public int isGooglePlayServicesAvailable(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(60433);
    paramInt = super.isGooglePlayServicesAvailable(paramContext, paramInt);
    AppMethodBeat.o(60433);
    return paramInt;
  }
  
  public boolean isPlayServicesPossiblyUpdating(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(60442);
    boolean bool = super.isPlayServicesPossiblyUpdating(paramContext, paramInt);
    AppMethodBeat.o(60442);
    return bool;
  }
  
  public boolean isPlayStorePossiblyUpdating(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(60443);
    boolean bool = super.isPlayStorePossiblyUpdating(paramContext, paramInt);
    AppMethodBeat.o(60443);
    return bool;
  }
  
  public final boolean isUserResolvableError(int paramInt)
  {
    AppMethodBeat.i(60434);
    boolean bool = super.isUserResolvableError(paramInt);
    AppMethodBeat.o(60434);
    return bool;
  }
  
  public Task<Void> makeGooglePlayServicesAvailable(Activity paramActivity)
  {
    AppMethodBeat.i(60417);
    Preconditions.checkMainThread("makeGooglePlayServicesAvailable must be called from the main thread");
    int i = isGooglePlayServicesAvailable(paramActivity);
    if (i == 0)
    {
      paramActivity = Tasks.forResult(null);
      AppMethodBeat.o(60417);
      return paramActivity;
    }
    paramActivity = zzbt.zzd(paramActivity);
    paramActivity.zzb(new ConnectionResult(i, null), 0);
    paramActivity = paramActivity.getTask();
    AppMethodBeat.o(60417);
    return paramActivity;
  }
  
  public GooglePlayServicesUpdatedReceiver registerCallbackOnUpdate(Context paramContext, GooglePlayServicesUpdatedReceiver.Callback paramCallback)
  {
    AppMethodBeat.i(60428);
    IntentFilter localIntentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
    localIntentFilter.addDataScheme("package");
    GooglePlayServicesUpdatedReceiver localGooglePlayServicesUpdatedReceiver = new GooglePlayServicesUpdatedReceiver(paramCallback);
    paramContext.registerReceiver(localGooglePlayServicesUpdatedReceiver, localIntentFilter);
    localGooglePlayServicesUpdatedReceiver.zzc(paramContext);
    if (!isUninstalledAppPossiblyUpdating(paramContext, "com.google.android.gms"))
    {
      paramCallback.zzv();
      localGooglePlayServicesUpdatedReceiver.unregister();
      AppMethodBeat.o(60428);
      return null;
    }
    AppMethodBeat.o(60428);
    return localGooglePlayServicesUpdatedReceiver;
  }
  
  @TargetApi(26)
  public void setDefaultNotificationChannelId(Context arg1, String paramString)
  {
    AppMethodBeat.i(60431);
    if (PlatformVersion.isAtLeastO()) {
      Preconditions.checkNotNull(((NotificationManager)???.getSystemService("notification")).getNotificationChannel(paramString));
    }
    synchronized (mLock)
    {
      this.zzat = paramString;
      AppMethodBeat.o(60431);
      return;
    }
  }
  
  public boolean showErrorDialogFragment(Activity paramActivity, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(60420);
    boolean bool = showErrorDialogFragment(paramActivity, paramInt1, paramInt2, null);
    AppMethodBeat.o(60420);
    return bool;
  }
  
  public boolean showErrorDialogFragment(Activity paramActivity, int paramInt1, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(60422);
    Dialog localDialog = getErrorDialog(paramActivity, paramInt1, paramInt2, paramOnCancelListener);
    if (localDialog == null)
    {
      AppMethodBeat.o(60422);
      return false;
    }
    zza(paramActivity, localDialog, "GooglePlayServicesErrorDialog", paramOnCancelListener);
    AppMethodBeat.o(60422);
    return true;
  }
  
  public boolean showErrorDialogFragment(Activity paramActivity, LifecycleFragment paramLifecycleFragment, int paramInt1, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(60421);
    paramLifecycleFragment = zza(paramActivity, paramInt1, DialogRedirect.getInstance(paramLifecycleFragment, getErrorResolutionIntent(paramActivity, paramInt1, "d"), paramInt2), paramOnCancelListener);
    if (paramLifecycleFragment == null)
    {
      AppMethodBeat.o(60421);
      return false;
    }
    zza(paramActivity, paramLifecycleFragment, "GooglePlayServicesErrorDialog", paramOnCancelListener);
    AppMethodBeat.o(60421);
    return true;
  }
  
  public void showErrorNotification(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(60423);
    showErrorNotification(paramContext, paramInt, null);
    AppMethodBeat.o(60423);
  }
  
  public void showErrorNotification(Context paramContext, int paramInt, String paramString)
  {
    AppMethodBeat.i(60424);
    zza(paramContext, paramInt, paramString, getErrorResolutionPendingIntent(paramContext, paramInt, 0, "n"));
    AppMethodBeat.o(60424);
  }
  
  public void showErrorNotification(Context paramContext, ConnectionResult paramConnectionResult)
  {
    AppMethodBeat.i(60425);
    PendingIntent localPendingIntent = getErrorResolutionPendingIntent(paramContext, paramConnectionResult);
    zza(paramContext, paramConnectionResult.getErrorCode(), null, localPendingIntent);
    AppMethodBeat.o(60425);
  }
  
  public Dialog showUpdatingDialog(Activity paramActivity, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(60427);
    Object localObject = new ProgressBar(paramActivity, null, 16842874);
    ((ProgressBar)localObject).setIndeterminate(true);
    ((ProgressBar)localObject).setVisibility(0);
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramActivity);
    localBuilder.setView((View)localObject);
    localBuilder.setMessage(ConnectionErrorMessages.getErrorMessage(paramActivity, 18));
    localBuilder.setPositiveButton("", null);
    localObject = localBuilder.create();
    zza(paramActivity, (Dialog)localObject, "GooglePlayServicesUpdatingDialog", paramOnCancelListener);
    AppMethodBeat.o(60427);
    return localObject;
  }
  
  public boolean showWrappedErrorNotification(Context paramContext, ConnectionResult paramConnectionResult, int paramInt)
  {
    AppMethodBeat.i(60426);
    PendingIntent localPendingIntent = getErrorResolutionPendingIntent(paramContext, paramConnectionResult);
    if (localPendingIntent != null)
    {
      zza(paramContext, paramConnectionResult.getErrorCode(), null, GoogleApiActivity.zza(paramContext, localPendingIntent, paramInt));
      AppMethodBeat.o(60426);
      return true;
    }
    AppMethodBeat.o(60426);
    return false;
  }
  
  final void zza(Context paramContext)
  {
    AppMethodBeat.i(60449);
    new zza(paramContext).sendEmptyMessageDelayed(1, 120000L);
    AppMethodBeat.o(60449);
  }
  
  @SuppressLint({"HandlerLeak"})
  final class zza
    extends Handler
  {
    private final Context zzau;
    
    public zza(Context paramContext) {}
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(60416);
      int i;
      switch (paramMessage.what)
      {
      default: 
        i = paramMessage.what;
        new StringBuilder(50).append("Don't know how to handle this message: ").append(i);
      }
      do
      {
        AppMethodBeat.o(60416);
        return;
        i = GoogleApiAvailability.this.isGooglePlayServicesAvailable(this.zzau);
      } while (!GoogleApiAvailability.this.isUserResolvableError(i));
      GoogleApiAvailability.this.showErrorNotification(this.zzau, i);
      AppMethodBeat.o(60416);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.GoogleApiAvailability
 * JD-Core Version:    0.7.0.1
 */