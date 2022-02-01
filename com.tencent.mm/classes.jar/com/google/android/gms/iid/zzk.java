package com.google.android.gms.iid;

import android.content.BroadcastReceiver.PendingResult;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public final class zzk
  implements ServiceConnection
{
  private final Intent zzbl;
  private final ScheduledExecutorService zzbm;
  private final Queue<zzg> zzbn;
  private zzi zzbo;
  private boolean zzbp;
  private final Context zzk;
  
  public zzk(Context paramContext, String paramString)
  {
    this(paramContext, paramString, new ScheduledThreadPoolExecutor(0));
    AppMethodBeat.i(2523);
    AppMethodBeat.o(2523);
  }
  
  private zzk(Context paramContext, String paramString, ScheduledExecutorService paramScheduledExecutorService)
  {
    AppMethodBeat.i(2524);
    this.zzbn = new ArrayDeque();
    this.zzbp = false;
    this.zzk = paramContext.getApplicationContext();
    this.zzbl = new Intent(paramString).setPackage(this.zzk.getPackageName());
    this.zzbm = paramScheduledExecutorService;
    AppMethodBeat.o(2524);
  }
  
  private final void zzl()
  {
    try
    {
      AppMethodBeat.i(2526);
      Log.isLoggable("EnhancedIntentService", 3);
      for (;;)
      {
        if (this.zzbn.isEmpty()) {
          break label211;
        }
        Log.isLoggable("EnhancedIntentService", 3);
        if ((this.zzbo == null) || (!this.zzbo.isBinderAlive())) {
          break;
        }
        Log.isLoggable("EnhancedIntentService", 3);
        zzg localzzg = (zzg)this.zzbn.poll();
        this.zzbo.zzd(localzzg);
      }
      if (!Log.isLoggable("EnhancedIntentService", 3)) {
        break label124;
      }
    }
    finally {}
    boolean bool;
    if (!this.zzbp)
    {
      bool = true;
      new StringBuilder(39).append("binder is dead. start connection? ").append(bool);
      label124:
      if (this.zzbp) {
        break label202;
      }
      this.zzbp = true;
    }
    for (;;)
    {
      try
      {
        bool = ConnectionTracker.getInstance().bindService(this.zzk, this.zzbl, this, 65);
        if (!bool) {
          continue;
        }
        AppMethodBeat.o(2526);
        return;
      }
      catch (SecurityException localSecurityException)
      {
        label202:
        label211:
        continue;
      }
      bool = false;
      break;
      if (!this.zzbn.isEmpty())
      {
        ((zzg)this.zzbn.poll()).finish();
      }
      else
      {
        AppMethodBeat.o(2526);
        continue;
        AppMethodBeat.o(2526);
      }
    }
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    AppMethodBeat.i(2527);
    try
    {
      this.zzbp = false;
      this.zzbo = ((zzi)paramIBinder);
      if (Log.isLoggable("EnhancedIntentService", 3))
      {
        paramComponentName = String.valueOf(paramComponentName);
        new StringBuilder(String.valueOf(paramComponentName).length() + 20).append("onServiceConnected: ").append(paramComponentName);
      }
      zzl();
      return;
    }
    finally
    {
      AppMethodBeat.o(2527);
    }
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    AppMethodBeat.i(2528);
    if (Log.isLoggable("EnhancedIntentService", 3))
    {
      paramComponentName = String.valueOf(paramComponentName);
      new StringBuilder(String.valueOf(paramComponentName).length() + 23).append("onServiceDisconnected: ").append(paramComponentName);
    }
    zzl();
    AppMethodBeat.o(2528);
  }
  
  public final void zzd(Intent paramIntent, BroadcastReceiver.PendingResult paramPendingResult)
  {
    try
    {
      AppMethodBeat.i(2525);
      Log.isLoggable("EnhancedIntentService", 3);
      this.zzbn.add(new zzg(paramIntent, paramPendingResult, this.zzbm));
      zzl();
      AppMethodBeat.o(2525);
      return;
    }
    finally
    {
      paramIntent = finally;
      throw paramIntent;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.iid.zzk
 * JD-Core Version:    0.7.0.1
 */