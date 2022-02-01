package com.tencent.matrix.resource.e;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public final class e
{
  private final Handler cIR;
  long cIS;
  private final Handler mMainHandler;
  
  public e(long paramLong, HandlerThread paramHandlerThread)
  {
    this.cIR = new Handler(paramHandlerThread.getLooper());
    this.mMainHandler = new Handler(Looper.getMainLooper());
    this.cIS = paramLong;
  }
  
  public final void IQ()
  {
    this.cIR.removeCallbacksAndMessages(null);
    this.mMainHandler.removeCallbacksAndMessages(null);
  }
  
  public final void a(final a parama, final int paramInt)
  {
    this.cIR.postDelayed(new Runnable()
    {
      public final void run()
      {
        if (parama.IL() == e.a.a.cIX) {
          e.this.a(parama, paramInt + 1);
        }
      }
    }, this.cIS);
  }
  
  public static abstract interface a
  {
    public abstract e.a.a IL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.resource.e.e
 * JD-Core Version:    0.7.0.1
 */