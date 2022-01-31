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
  private final Context bfj;
  private final Intent bgc;
  private final ScheduledExecutorService bgd;
  private final Queue<u> bge;
  private w bgf;
  private boolean bgg;
  
  public y(Context paramContext, String paramString)
  {
    this(paramContext, paramString, new ScheduledThreadPoolExecutor(0));
    AppMethodBeat.i(108778);
    AppMethodBeat.o(108778);
  }
  
  private y(Context paramContext, String paramString, ScheduledExecutorService paramScheduledExecutorService)
  {
    AppMethodBeat.i(108779);
    this.bge = new ArrayDeque();
    this.bgg = false;
    this.bfj = paramContext.getApplicationContext();
    this.bgc = new Intent(paramString).setPackage(this.bfj.getPackageName());
    this.bgd = paramScheduledExecutorService;
    AppMethodBeat.o(108779);
  }
  
  private final void zzc()
  {
    for (;;)
    {
      w localw;
      try
      {
        AppMethodBeat.i(108781);
        Log.isLoggable("EnhancedIntentService", 3);
        if (this.bge.isEmpty()) {
          break label287;
        }
        Log.isLoggable("EnhancedIntentService", 3);
        if ((this.bgf == null) || (!this.bgf.isBinderAlive())) {
          break;
        }
        Log.isLoggable("EnhancedIntentService", 3);
        Object localObject = (u)this.bge.poll();
        localw = this.bgf;
        if (Binder.getCallingUid() != Process.myUid())
        {
          localObject = new SecurityException("Binding only allowed within app");
          AppMethodBeat.o(108781);
          throw ((Throwable)localObject);
        }
      }
      finally {}
      Log.isLoggable("EnhancedIntentService", 3);
      if (localw.bfZ.i(localu.intent))
      {
        localu.finish();
      }
      else
      {
        Log.isLoggable("EnhancedIntentService", 3);
        localw.bfZ.bfP.execute(new x(localw, localu));
      }
    }
    boolean bool;
    if (Log.isLoggable("EnhancedIntentService", 3))
    {
      if (!this.bgg)
      {
        bool = true;
        new StringBuilder(39).append("binder is dead. start connection? ").append(bool);
      }
    }
    else
    {
      if (this.bgg) {
        break label279;
      }
      this.bgg = true;
    }
    for (;;)
    {
      try
      {
        bool = ConnectionTracker.getInstance().bindService(this.bfj, this.bgc, this, 65);
        if (!bool) {
          continue;
        }
        AppMethodBeat.o(108781);
        return;
      }
      catch (SecurityException localSecurityException)
      {
        label279:
        label287:
        continue;
      }
      bool = false;
      break;
      if (!this.bge.isEmpty())
      {
        ((u)this.bge.poll()).finish();
      }
      else
      {
        AppMethodBeat.o(108781);
        continue;
        AppMethodBeat.o(108781);
      }
    }
  }
  
  public final void a(Intent paramIntent, BroadcastReceiver.PendingResult paramPendingResult)
  {
    try
    {
      AppMethodBeat.i(108780);
      Log.isLoggable("EnhancedIntentService", 3);
      this.bge.add(new u(paramIntent, paramPendingResult, this.bgd));
      zzc();
      AppMethodBeat.o(108780);
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
    AppMethodBeat.i(108782);
    try
    {
      this.bgg = false;
      this.bgf = ((w)paramIBinder);
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
      AppMethodBeat.o(108782);
    }
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    AppMethodBeat.i(108783);
    if (Log.isLoggable("EnhancedIntentService", 3))
    {
      paramComponentName = String.valueOf(paramComponentName);
      new StringBuilder(String.valueOf(paramComponentName).length() + 23).append("onServiceDisconnected: ").append(paramComponentName);
    }
    zzc();
    AppMethodBeat.o(108783);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.firebase.iid.y
 * JD-Core Version:    0.7.0.1
 */