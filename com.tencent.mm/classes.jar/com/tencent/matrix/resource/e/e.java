package com.tencent.matrix.resource.e;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public final class e
{
  private final Handler bQn;
  private final long bQo;
  private final Handler mMainHandler;
  
  public e(long paramLong, HandlerThread paramHandlerThread)
  {
    this.bQn = new Handler(paramHandlerThread.getLooper());
    this.mMainHandler = new Handler(Looper.getMainLooper());
    this.bQo = paramLong;
  }
  
  public final void a(final a parama, final int paramInt)
  {
    this.bQn.postDelayed(new Runnable()
    {
      public final void run()
      {
        if (parama.zm() == e.a.a.bQt) {
          e.this.a(parama, paramInt + 1);
        }
      }
    }, this.bQo);
  }
  
  public final void zp()
  {
    this.bQn.removeCallbacksAndMessages(null);
    this.mMainHandler.removeCallbacksAndMessages(null);
  }
  
  public static abstract interface a
  {
    public abstract a zm();
    
    public static enum a
    {
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.resource.e.e
 * JD-Core Version:    0.7.0.1
 */