package com.tencent.matrix.openglleak.a;

import android.os.Handler;

public final class c
{
  private static final c eYd = new c();
  private final Handler mHandler = new Handler(d.ayV().getLooper());
  
  public static c ayU()
  {
    return eYd;
  }
  
  public final void post(Runnable paramRunnable)
  {
    this.mHandler.post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.openglleak.a.c
 * JD-Core Version:    0.7.0.1
 */