package com.tencent.mars.ilink.comm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.mars.ilink.xlog.Log;

public class WakerLock
{
  private static final String TAG = "MicroMsg.WakerLock";
  private Handler mHandler = null;
  private Runnable mReleaser = new Runnable()
  {
    public void run()
    {
      WakerLock.this.unLock();
    }
  };
  private PowerManager.WakeLock wakeLock = null;
  
  @SuppressLint({"InvalidWakeLockTag"})
  public WakerLock(Context paramContext)
  {
    this.wakeLock = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(1, "MicroMsg.WakerLock");
    this.wakeLock.setReferenceCounted(false);
    this.mHandler = new Handler(paramContext.getMainLooper());
  }
  
  protected void finalize()
  {
    unLock();
  }
  
  public boolean isLocking()
  {
    try
    {
      boolean bool = this.wakeLock.isHeld();
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public void lock()
  {
    try
    {
      this.mHandler.removeCallbacks(this.mReleaser);
      lock(-1L);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void lock(long paramLong)
  {
    if (paramLong == -1L) {}
    try
    {
      this.wakeLock.acquire();
      Log.w("MicroMsg.WakerLock", "acquire wakelock without timeout, msg:");
      return;
    }
    catch (Exception localException) {}
    this.wakeLock.acquire(paramLong);
    return;
  }
  
  public void unLock()
  {
    try
    {
      this.mHandler.removeCallbacks(this.mReleaser);
      if (this.wakeLock.isHeld()) {
        this.wakeLock.release();
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mars.ilink.comm.WakerLock
 * JD-Core Version:    0.7.0.1
 */