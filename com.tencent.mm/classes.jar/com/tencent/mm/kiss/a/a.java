package com.tencent.mm.kiss.a;

import android.os.Handler;
import android.os.HandlerThread;

public final class a
{
  private static a dNf = new a();
  public HandlerThread dNe = new HandlerThread("InflateThread", 5);
  private Handler mHandler;
  
  private a()
  {
    this.dNe.start();
    this.mHandler = new Handler(this.dNe.getLooper());
  }
  
  public static a EC()
  {
    return dNf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.kiss.a.a
 * JD-Core Version:    0.7.0.1
 */