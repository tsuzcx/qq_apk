package com.tencent.matrix.resource.f;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public final class c
{
  private final Handler fda;
  public long fdb;
  private final Handler mMainHandler;
  
  public c(long paramLong, HandlerThread paramHandlerThread)
  {
    this.fda = new Handler(paramHandlerThread.getLooper());
    this.mMainHandler = new Handler(Looper.getMainLooper());
    this.fdb = paramLong;
  }
  
  public final void a(final a parama, final int paramInt)
  {
    this.fda.postDelayed(new Runnable()
    {
      public final void run()
      {
        if (parama.azy() == c.a.a.fdg) {
          c.this.a(parama, paramInt + 1);
        }
      }
    }, this.fdb);
  }
  
  public final void azz()
  {
    this.fda.removeCallbacksAndMessages(null);
    this.mMainHandler.removeCallbacksAndMessages(null);
  }
  
  public static abstract interface a
  {
    public abstract c.a.a azy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.resource.f.c
 * JD-Core Version:    0.7.0.1
 */