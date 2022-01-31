package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.internal.zzac;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class zza
  implements ServiceConnection
{
  boolean zzayh = false;
  private final BlockingQueue<IBinder> zzayi = new LinkedBlockingQueue();
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.zzayi.add(paramIBinder);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName) {}
  
  public IBinder zza(long paramLong, TimeUnit paramTimeUnit)
  {
    zzac.zzdk("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
    if (this.zzayh) {
      throw new IllegalStateException("Cannot call get on this connection more than once");
    }
    this.zzayh = true;
    paramTimeUnit = (IBinder)this.zzayi.poll(paramLong, paramTimeUnit);
    if (paramTimeUnit == null) {
      throw new TimeoutException("Timed out waiting for the service connection");
    }
    return paramTimeUnit;
  }
  
  public IBinder zzuX()
  {
    zzac.zzdk("BlockingServiceConnection.getService() called on main thread");
    if (this.zzayh) {
      throw new IllegalStateException("Cannot call get on this connection more than once");
    }
    this.zzayh = true;
    return (IBinder)this.zzayi.take();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.zza
 * JD-Core Version:    0.7.0.1
 */