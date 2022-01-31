package com.tencent.magicbrush.handler;

import android.support.annotation.Keep;
import com.tencent.magicbrush.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MBJsThreadHandler
  implements a
{
  private a bJF;
  private final ReadWriteLock bJG;
  private volatile boolean mDestroyed;
  private long mNativeInst;
  
  public MBJsThreadHandler(a parama)
  {
    AppMethodBeat.i(115898);
    this.mDestroyed = false;
    this.bJG = new ReentrantReadWriteLock();
    this.bJF = parama;
    AppMethodBeat.o(115898);
  }
  
  private native long nativeCreate(long paramLong);
  
  private native void nativeHandleMessage(long paramLong, int paramInt);
  
  public final <T> T a(Callable<T> paramCallable)
  {
    AppMethodBeat.i(115902);
    paramCallable = new b(paramCallable);
    i(paramCallable);
    paramCallable = paramCallable.get();
    AppMethodBeat.o(115902);
    return paramCallable;
  }
  
  @Keep
  public void destroy()
  {
    AppMethodBeat.i(115899);
    this.bJG.writeLock().lock();
    try
    {
      this.mDestroyed = true;
      this.mNativeInst = 0L;
      return;
    }
    finally
    {
      this.bJG.writeLock().unlock();
      AppMethodBeat.o(115899);
    }
  }
  
  public final void i(Runnable paramRunnable)
  {
    AppMethodBeat.i(115903);
    if (this.bJF.uB())
    {
      paramRunnable.run();
      AppMethodBeat.o(115903);
      return;
    }
    this.bJF.post(paramRunnable);
    AppMethodBeat.o(115903);
  }
  
  public final void post(Runnable paramRunnable)
  {
    AppMethodBeat.i(115900);
    this.bJF.post(paramRunnable);
    AppMethodBeat.o(115900);
  }
  
  @Keep
  public void sendMessage(int paramInt) {}
  
  public final boolean uB()
  {
    AppMethodBeat.i(115901);
    boolean bool = this.bJF.uB();
    AppMethodBeat.o(115901);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.magicbrush.handler.MBJsThreadHandler
 * JD-Core Version:    0.7.0.1
 */