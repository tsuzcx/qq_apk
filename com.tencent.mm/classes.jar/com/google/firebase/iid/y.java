package com.google.firebase.iid;

import android.content.BroadcastReceiver.PendingResult;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import android.util.Log;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public final class y
  implements ServiceConnection
{
  private final Intent bLX;
  private final ScheduledExecutorService bLY;
  private final Queue<u> bLZ;
  private final Context bLf;
  private w bMa;
  private boolean bMb;
  
  public y(Context paramContext, String paramString)
  {
    this(paramContext, paramString, new ScheduledThreadPoolExecutor(0));
    AppMethodBeat.i(4214);
    AppMethodBeat.o(4214);
  }
  
  private y(Context paramContext, String paramString, ScheduledExecutorService paramScheduledExecutorService)
  {
    AppMethodBeat.i(4215);
    this.bLZ = new ArrayDeque();
    this.bMb = false;
    this.bLf = paramContext.getApplicationContext();
    this.bLX = new Intent(paramString).setPackage(this.bLf.getPackageName());
    this.bLY = paramScheduledExecutorService;
    AppMethodBeat.o(4215);
  }
  
  private final void zzc()
  {
    for (;;)
    {
      w localw;
      try
      {
        AppMethodBeat.i(4217);
        Log.isLoggable("EnhancedIntentService", 3);
        if (this.bLZ.isEmpty()) {
          break label291;
        }
        Log.isLoggable("EnhancedIntentService", 3);
        if ((this.bMa == null) || (!this.bMa.isBinderAlive())) {
          break;
        }
        Log.isLoggable("EnhancedIntentService", 3);
        Object localObject = (u)this.bLZ.poll();
        localw = this.bMa;
        if (Binder.getCallingUid() != Process.myUid())
        {
          localObject = new SecurityException("Binding only allowed within app");
          AppMethodBeat.o(4217);
          throw ((Throwable)localObject);
        }
      }
      finally {}
      Log.isLoggable("EnhancedIntentService", 3);
      if (localw.bLU.h(localu.intent))
      {
        localu.finish();
      }
      else
      {
        Log.isLoggable("EnhancedIntentService", 3);
        localw.bLU.bLK.execute(new x(localw, localu));
      }
    }
    boolean bool;
    if (Log.isLoggable("EnhancedIntentService", 3))
    {
      if (!this.bMb)
      {
        bool = true;
        new StringBuilder(39).append("binder is dead. start connection? ").append(bool);
      }
    }
    else
    {
      if (this.bMb) {
        break label282;
      }
      this.bMb = true;
    }
    for (;;)
    {
      try
      {
        bool = ConnectionTracker.getInstance().bindService(this.bLf, this.bLX, this, 65);
        if (!bool) {
          continue;
        }
        AppMethodBeat.o(4217);
        return;
      }
      catch (SecurityException localSecurityException)
      {
        label282:
        label291:
        continue;
      }
      bool = false;
      break;
      if (!this.bLZ.isEmpty())
      {
        ((u)this.bLZ.poll()).finish();
      }
      else
      {
        AppMethodBeat.o(4217);
        continue;
        AppMethodBeat.o(4217);
      }
    }
  }
  
  public final void a(Intent paramIntent, BroadcastReceiver.PendingResult paramPendingResult)
  {
    try
    {
      AppMethodBeat.i(4216);
      Log.isLoggable("EnhancedIntentService", 3);
      this.bLZ.add(new u(paramIntent, paramPendingResult, this.bLY));
      zzc();
      AppMethodBeat.o(4216);
      return;
    }
    finally
    {
      paramIntent = finally;
      throw paramIntent;
    }
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    AppMethodBeat.i(4218);
    try
    {
      this.bMb = false;
      this.bMa = ((w)paramIBinder);
      if (Log.isLoggable("EnhancedIntentService", 3))
      {
        paramComponentName = String.valueOf(paramComponentName);
        new StringBuilder(String.valueOf(paramComponentName).length() + 20).append("onServiceConnected: ").append(paramComponentName);
      }
      zzc();
      return;
    }
    finally
    {
      AppMethodBeat.o(4218);
    }
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    AppMethodBeat.i(4219);
    if (Log.isLoggable("EnhancedIntentService", 3))
    {
      paramComponentName = String.valueOf(paramComponentName);
      new StringBuilder(String.valueOf(paramComponentName).length() + 23).append("onServiceDisconnected: ").append(paramComponentName);
    }
    zzc();
    AppMethodBeat.o(4219);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.firebase.iid.y
 * JD-Core Version:    0.7.0.1
 */