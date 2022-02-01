package com.tencent.mars.ilink.comm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.mars.ilink.xlog.Log;
import com.tencent.mm.hellhoundlib.b.c;

public class WakerLock
{
  private static final String TAG = "MicroMsg.WakerLock";
  private byte _hellAccFlag_;
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
      localWakeLock = this.wakeLock;
      com.tencent.mm.hellhoundlib.a.a.b(localWakeLock, "com/tencent/mars/ilink/comm/WakerLock", "lock", "(J)V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
      localWakeLock.acquire();
      com.tencent.mm.hellhoundlib.a.a.c(localWakeLock, "com/tencent/mars/ilink/comm/WakerLock", "lock", "(J)V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
      Log.w("MicroMsg.WakerLock", "acquire wakelock without timeout, msg:");
      return;
    }
    catch (Exception localException) {}
    PowerManager.WakeLock localWakeLock = this.wakeLock;
    com.tencent.mm.hellhoundlib.b.a locala = c.a(paramLong, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(localWakeLock, locala.aFh(), "com/tencent/mars/ilink/comm/WakerLock", "lock", "(J)V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "(J)V");
    paramLong = ((Long)c.a(locala).sf(0)).longValue();
    c.aFj();
    localWakeLock.acquire(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c(localWakeLock, "com/tencent/mars/ilink/comm/WakerLock", "lock", "(J)V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "(J)V");
    return;
  }
  
  public void unLock()
  {
    try
    {
      this.mHandler.removeCallbacks(this.mReleaser);
      if (this.wakeLock.isHeld())
      {
        PowerManager.WakeLock localWakeLock = this.wakeLock;
        com.tencent.mm.hellhoundlib.a.a.b(localWakeLock, "com/tencent/mars/ilink/comm/WakerLock", "unLock", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
        localWakeLock.release();
        com.tencent.mm.hellhoundlib.a.a.c(localWakeLock, "com/tencent/mars/ilink/comm/WakerLock", "unLock", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
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