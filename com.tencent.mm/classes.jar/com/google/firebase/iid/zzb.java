package com.google.firebase.iid;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class zzb
  extends Service
{
  final ExecutorService bfP;
  private Binder bfQ;
  private int bfR;
  private int bfS;
  private final Object lock;
  
  public zzb()
  {
    String str = String.valueOf(getClass().getSimpleName());
    if (str.length() != 0) {}
    for (str = "Firebase-".concat(str);; str = new String("Firebase-"))
    {
      this.bfP = Executors.newSingleThreadExecutor(new NamedThreadFactory(str));
      this.lock = new Object();
      this.bfS = 0;
      return;
    }
  }
  
  private final void h(Intent arg1)
  {
    if (??? != null) {
      WakefulBroadcastReceiver.completeWakefulIntent(???);
    }
    synchronized (this.lock)
    {
      this.bfS -= 1;
      if (this.bfS == 0) {
        stopSelfResult(this.bfR);
      }
      return;
    }
  }
  
  protected Intent f(Intent paramIntent)
  {
    return paramIntent;
  }
  
  public abstract void g(Intent paramIntent);
  
  public boolean i(Intent paramIntent)
  {
    return false;
  }
  
  public final IBinder onBind(Intent paramIntent)
  {
    try
    {
      Log.isLoggable("EnhancedIntentService", 3);
      if (this.bfQ == null) {
        this.bfQ = new w(this);
      }
      paramIntent = this.bfQ;
      return paramIntent;
    }
    finally {}
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    synchronized (this.lock)
    {
      this.bfR = paramInt2;
      this.bfS += 1;
      ??? = f(paramIntent);
      if (??? == null)
      {
        h(paramIntent);
        return 2;
      }
    }
    if (i((Intent)???))
    {
      h(paramIntent);
      return 2;
    }
    this.bfP.execute(new t(this, (Intent)???, paramIntent));
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.firebase.iid.zzb
 * JD-Core Version:    0.7.0.1
 */