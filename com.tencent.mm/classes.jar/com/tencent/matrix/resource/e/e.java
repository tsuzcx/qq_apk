package com.tencent.matrix.resource.e;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public final class e
{
  private final Handler cxW;
  long cxX;
  private final Handler mMainHandler;
  
  public e(long paramLong, HandlerThread paramHandlerThread)
  {
    this.cxW = new Handler(paramHandlerThread.getLooper());
    this.mMainHandler = new Handler(Looper.getMainLooper());
    this.cxX = paramLong;
  }
  
  public final void Hv()
  {
    this.cxW.removeCallbacksAndMessages(null);
    this.mMainHandler.removeCallbacksAndMessages(null);
  }
  
  public final void a(final a parama, final int paramInt)
  {
    this.cxW.postDelayed(new Runnable()
    {
      public final void run()
      {
        if (parama.Hq() == e.a.a.cyc) {
          e.this.a(parama, paramInt + 1);
        }
      }
    }, this.cxX);
  }
  
  public static abstract interface a
  {
    public abstract e.a.a Hq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.resource.e.e
 * JD-Core Version:    0.7.0.1
 */