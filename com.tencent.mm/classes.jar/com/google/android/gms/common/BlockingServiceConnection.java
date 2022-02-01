package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class BlockingServiceConnection
  implements ServiceConnection
{
  private boolean zzaj;
  private final BlockingQueue<IBinder> zzak;
  
  public BlockingServiceConnection()
  {
    AppMethodBeat.i(4360);
    this.zzaj = false;
    this.zzak = new LinkedBlockingQueue();
    AppMethodBeat.o(4360);
  }
  
  public IBinder getService()
  {
    AppMethodBeat.i(4363);
    Preconditions.checkNotMainThread("BlockingServiceConnection.getService() called on main thread");
    if (this.zzaj)
    {
      localObject = new IllegalStateException("Cannot call get on this connection more than once");
      AppMethodBeat.o(4363);
      throw ((Throwable)localObject);
    }
    this.zzaj = true;
    Object localObject = (IBinder)this.zzak.take();
    AppMethodBeat.o(4363);
    return localObject;
  }
  
  public IBinder getServiceWithTimeout(long paramLong, TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(4362);
    Preconditions.checkNotMainThread("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
    if (this.zzaj)
    {
      paramTimeUnit = new IllegalStateException("Cannot call get on this connection more than once");
      AppMethodBeat.o(4362);
      throw paramTimeUnit;
    }
    this.zzaj = true;
    paramTimeUnit = (IBinder)this.zzak.poll(paramLong, paramTimeUnit);
    if (paramTimeUnit == null)
    {
      paramTimeUnit = new TimeoutException("Timed out waiting for the service connection");
      AppMethodBeat.o(4362);
      throw paramTimeUnit;
    }
    AppMethodBeat.o(4362);
    return paramTimeUnit;
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    AppMethodBeat.i(4361);
    this.zzak.add(paramIBinder);
    AppMethodBeat.o(4361);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.BlockingServiceConnection
 * JD-Core Version:    0.7.0.1
 */