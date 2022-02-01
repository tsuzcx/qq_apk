package com.tencent.matrix.resource.f;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public final class c
{
  private final Handler dep;
  public long deq;
  private final Handler mMainHandler;
  
  public c(long paramLong, HandlerThread paramHandlerThread)
  {
    this.dep = new Handler(paramHandlerThread.getLooper());
    this.mMainHandler = new Handler(Looper.getMainLooper());
    this.deq = paramLong;
  }
  
  public final void XV()
  {
    this.dep.removeCallbacksAndMessages(null);
    this.mMainHandler.removeCallbacksAndMessages(null);
  }
  
  public final void a(final a parama, final int paramInt)
  {
    this.dep.postDelayed(new Runnable()
    {
      public final void run()
      {
        if (parama.XU() == c.a.a.dew) {
          c.this.a(parama, paramInt + 1);
        }
      }
    }, this.deq);
  }
  
  public static abstract interface a
  {
    public abstract a XU();
    
    public static enum a
    {
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.resource.f.c
 * JD-Core Version:    0.7.0.1
 */