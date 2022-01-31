package com.facebook.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

final class AttributionIdentifiers$GoogleAdServiceConnection
  implements ServiceConnection
{
  private AtomicBoolean consumed;
  private final BlockingQueue<IBinder> queue;
  
  private AttributionIdentifiers$GoogleAdServiceConnection()
  {
    AppMethodBeat.i(72234);
    this.consumed = new AtomicBoolean(false);
    this.queue = new LinkedBlockingDeque();
    AppMethodBeat.o(72234);
  }
  
  public final IBinder getBinder()
  {
    AppMethodBeat.i(72236);
    if (this.consumed.compareAndSet(true, true))
    {
      localObject = new IllegalStateException("Binder already consumed");
      AppMethodBeat.o(72236);
      throw ((Throwable)localObject);
    }
    Object localObject = (IBinder)this.queue.take();
    AppMethodBeat.o(72236);
    return localObject;
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    AppMethodBeat.i(72235);
    if (paramIBinder != null) {}
    try
    {
      this.queue.put(paramIBinder);
      AppMethodBeat.o(72235);
      return;
    }
    catch (InterruptedException paramComponentName)
    {
      AppMethodBeat.o(72235);
    }
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.facebook.internal.AttributionIdentifiers.GoogleAdServiceConnection
 * JD-Core Version:    0.7.0.1
 */