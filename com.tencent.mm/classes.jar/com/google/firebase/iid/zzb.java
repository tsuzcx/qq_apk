package com.google.firebase.iid;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class zzb
  extends Service
{
  final ExecutorService bJF;
  private Binder bJG;
  private int bJH;
  private int bJI;
  private final Object lock;
  
  public zzb()
  {
    String str = String.valueOf(getClass().getSimpleName());
    if (str.length() != 0) {}
    for (str = "Firebase-".concat(str);; str = new String("Firebase-"))
    {
      this.bJF = Executors.newSingleThreadExecutor(new NamedThreadFactory(str));
      this.lock = new Object();
      this.bJI = 0;
      return;
    }
  }
  
  private final void g(Intent arg1)
  {
    if (??? != null) {
      WakefulBroadcastReceiver.completeWakefulIntent(???);
    }
    synchronized (this.lock)
    {
      this.bJI -= 1;
      if (this.bJI == 0) {
        stopSelfResult(this.bJH);
      }
      return;
    }
  }
  
  protected Intent e(Intent paramIntent)
  {
    return paramIntent;
  }
  
  public abstract void f(Intent paramIntent);
  
  public boolean h(Intent paramIntent)
  {
    return false;
  }
  
  public final IBinder onBind(Intent paramIntent)
  {
    try
    {
      Log.isLoggable("EnhancedIntentService", 3);
      if (this.bJG == null) {
        this.bJG = new w(this);
      }
      paramIntent = this.bJG;
      return paramIntent;
    }
    finally {}
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    synchronized (this.lock)
    {
      this.bJH = paramInt2;
      this.bJI += 1;
      ??? = e(paramIntent);
      if (??? == null)
      {
        g(paramIntent);
        return 2;
      }
    }
    if (h((Intent)???))
    {
      g(paramIntent);
      return 2;
    }
    this.bJF.execute(new t(this, (Intent)???, paramIntent));
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.firebase.iid.zzb
 * JD-Core Version:    0.7.0.1
 */