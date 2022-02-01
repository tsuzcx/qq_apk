package com.tencent.matrix.resource.e;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public final class e
{
  private final Handler cJA;
  long cJB;
  private final Handler mMainHandler;
  
  public e(long paramLong, HandlerThread paramHandlerThread)
  {
    this.cJA = new Handler(paramHandlerThread.getLooper());
    this.mMainHandler = new Handler(Looper.getMainLooper());
    this.cJB = paramLong;
  }
  
  public final void IY()
  {
    this.cJA.removeCallbacksAndMessages(null);
    this.mMainHandler.removeCallbacksAndMessages(null);
  }
  
  public final void a(final a parama, final int paramInt)
  {
    this.cJA.postDelayed(new Runnable()
    {
      public final void run()
      {
        if (parama.IT() == e.a.a.cJG) {
          e.this.a(parama, paramInt + 1);
        }
      }
    }, this.cJB);
  }
  
  public static abstract interface a
  {
    public abstract a IT();
    
    public static enum a
    {
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.resource.e.e
 * JD-Core Version:    0.7.0.1
 */