package com.tencent.magicbrush.engine;

import android.os.Handler;
import android.support.annotation.Keep;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;

public class AppBrandContext
  extends c
{
  private int bkn;
  private HashMap<Integer, AppBrandContext.a> bko;
  private long bkp;
  private boolean bkq;
  private ArrayList<Integer> bkr;
  private Handler mHandler;
  private Timer mTimer;
  
  static {}
  
  public static native void notifyClearTimer(long paramLong, int paramInt);
  
  public static native boolean notifyRunTimer(long paramLong1, long paramLong2, int paramInt);
  
  @Keep
  public void clearTimer(int paramInt)
  {
    if (!this.bko.containsKey(Integer.valueOf(paramInt))) {
      return;
    }
    ((AppBrandContext.a)this.bko.get(Integer.valueOf(paramInt))).cancel();
    this.bko.remove(Integer.valueOf(paramInt));
  }
  
  public final void dispose()
  {
    nativeFinalize(this.bkp);
  }
  
  public native long nativeCreated(long paramLong);
  
  public native void nativeFinalize(long paramLong);
  
  @Keep
  public void onLog(int paramInt, String paramString) {}
  
  @Keep
  public int setTimer(int paramInt, boolean paramBoolean)
  {
    int i = this.bkn + 1;
    this.bkn = i;
    AppBrandContext.a locala = new AppBrandContext.a(this, i, paramBoolean);
    this.bko.put(Integer.valueOf(i), locala);
    if (paramBoolean)
    {
      this.mTimer.schedule(locala, paramInt, paramInt);
      return i;
    }
    this.mTimer.schedule(locala, paramInt);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.magicbrush.engine.AppBrandContext
 * JD-Core Version:    0.7.0.1
 */