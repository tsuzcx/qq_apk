package com.tencent.matrix.resource.e;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public final class e
{
  final Handler bqj;
  private final long bqk;
  final Handler mMainHandler;
  
  public e(long paramLong, HandlerThread paramHandlerThread)
  {
    this.bqj = new Handler(paramHandlerThread.getLooper());
    this.mMainHandler = new Handler(Looper.getMainLooper());
    this.bqk = paramLong;
  }
  
  public final void a(final a parama, final int paramInt)
  {
    this.bqj.postDelayed(new Runnable()
    {
      public final void run()
      {
        if (parama.rj() == e.a.a.bqp) {
          e.this.a(parama, paramInt + 1);
        }
      }
    }, this.bqk);
  }
  
  public static abstract interface a
  {
    public abstract a rj();
    
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