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
  final ExecutorService dDn;
  private Binder dDo;
  private int dDp;
  private int dDq;
  private final Object lock;
  
  public zzb()
  {
    String str = String.valueOf(getClass().getSimpleName());
    if (str.length() != 0) {}
    for (str = "Firebase-".concat(str);; str = new String("Firebase-"))
    {
      this.dDn = Executors.newSingleThreadExecutor(new NamedThreadFactory(str));
      this.lock = new Object();
      this.dDq = 0;
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
      this.dDq -= 1;
      if (this.dDq == 0) {
        stopSelfResult(this.dDp);
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
      if (this.dDo == null) {
        this.dDo = new w(this);
      }
      paramIntent = this.dDo;
      return paramIntent;
    }
    finally {}
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    synchronized (this.lock)
    {
      this.dDp = paramInt2;
      this.dDq += 1;
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
    this.dDn.execute(new t(this, (Intent)???, paramIntent));
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.firebase.iid.zzb
 * JD-Core Version:    0.7.0.1
 */