package com.google.android.gms.stats;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import com.google.android.gms.common.stats.StatsUtils;
import com.google.android.gms.common.stats.WakeLockTracker;
import javax.annotation.Nonnull;

public abstract class GCoreWakefulBroadcastReceiver
  extends WakefulBroadcastReceiver
{
  private static String TAG = "GCoreWakefulBroadcastReceiver";
  
  @SuppressLint({"UnwrappedWakefulBroadcastReceiver"})
  public static boolean completeWakefulIntent(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return false;
    }
    if (paramContext != null) {
      WakeLockTracker.getInstance().registerReleaseEvent(paramContext, paramIntent);
    }
    for (;;)
    {
      return WakefulBroadcastReceiver.completeWakefulIntent(paramIntent);
      paramContext = String.valueOf(paramIntent.toUri(0));
      if (paramContext.length() != 0) {
        "context shouldn't be null. intent: ".concat(paramContext);
      } else {
        new String("context shouldn't be null. intent: ");
      }
    }
  }
  
  public static ComponentName startWakefulService(Context paramContext, Intent paramIntent)
  {
    ComponentName localComponentName = zza(paramContext, paramIntent);
    if (localComponentName == null) {
      return null;
    }
    WakeLockTracker localWakeLockTracker = WakeLockTracker.getInstance();
    String str = String.valueOf(localComponentName.flattenToShortString());
    if (str.length() != 0) {}
    for (str = "wake:".concat(str);; str = new String("wake:"))
    {
      localWakeLockTracker.registerAcquireEvent(paramContext, paramIntent, str, TAG, null, 1, "com.google.android.gms");
      return localComponentName;
    }
  }
  
  public static ComponentName startWakefulService(Context paramContext, Intent paramIntent, @Nonnull String paramString)
  {
    return startWakefulService(paramContext, paramIntent, paramString, paramContext.getPackageName());
  }
  
  public static ComponentName startWakefulService(Context paramContext, Intent paramIntent, @Nonnull String paramString1, String paramString2)
  {
    ComponentName localComponentName = zza(paramContext, paramIntent);
    if (localComponentName == null) {
      return null;
    }
    WakeLockTracker.getInstance().registerAcquireEvent(paramContext, paramIntent, paramString1, TAG, null, 1, paramString2);
    return localComponentName;
  }
  
  @SuppressLint({"UnwrappedWakefulBroadcastReceiver"})
  private static ComponentName zza(Context paramContext, Intent paramIntent)
  {
    paramIntent.putExtra("WAKE_LOCK_KEY", StatsUtils.getEventKey(paramContext, paramIntent));
    return WakefulBroadcastReceiver.startWakefulService(paramContext, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.stats.GCoreWakefulBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */