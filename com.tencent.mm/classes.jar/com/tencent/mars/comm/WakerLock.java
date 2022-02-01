package com.tencent.mars.comm;

import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.mm.jni.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;

public class WakerLock
{
  private static final String TAG = "MicroMsg.WakerLock";
  private static long lastChecktime = 0L;
  private static Boolean shouldLock = null;
  private IAutoUnlockCallback autoUnlockCallback = null;
  private Context context;
  private String mCreatePosStackLine = null;
  private ap mHandler = null;
  private Runnable mReleaser = new Runnable()
  {
    public void run()
    {
      if (WakerLock.this.wakeLock.isHeld())
      {
        ad.w("MicroMsg.WakerLock", "unlock by fucking handler! [%d,%d] @[%s]", new Object[] { Integer.valueOf(WakerLock.this.hashCode()), Integer.valueOf(WakerLock.this.wakeLock.hashCode()), WakerLock.this.mCreatePosStackLine });
        WakerLock.this.unLock();
        if (WakerLock.this.autoUnlockCallback != null) {
          WakerLock.this.autoUnlockCallback.autoUnlockCallback();
        }
      }
    }
  };
  private PowerManager.WakeLock wakeLock = null;
  
  public WakerLock(Context paramContext, String paramString)
  {
    this.wakeLock = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(1, paramString);
    this.wakeLock.setReferenceCounted(false);
    this.mHandler = new ap(paramContext.getMainLooper());
    this.context = paramContext;
    ad.i("MicroMsg.WakerLock", "init [%d,%d] @[%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.wakeLock.hashCode()), this.mCreatePosStackLine });
  }
  
  public WakerLock(Context paramContext, String paramString, IAutoUnlockCallback paramIAutoUnlockCallback)
  {
    this(paramContext, paramString);
    this.autoUnlockCallback = paramIAutoUnlockCallback;
  }
  
  private String getCallerStack()
  {
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    int j = arrayOfStackTraceElement.length;
    int i = 0;
    while (i < j)
    {
      StackTraceElement localStackTraceElement = arrayOfStackTraceElement[i];
      if (!localStackTraceElement.getClassName().contains(WakerLock.class.getName())) {
        return localStackTraceElement.toString();
      }
      i += 1;
    }
    return "<native>";
  }
  
  protected void finalize()
  {
    ad.i("MicroMsg.WakerLock", "finalize unlock [%d,%d] @[%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.wakeLock.hashCode()), this.mCreatePosStackLine });
    unLock();
    super.finalize();
  }
  
  public String getCreatePosStackLine()
  {
    return this.mCreatePosStackLine;
  }
  
  public int innerWakeLockHashCode()
  {
    return this.wakeLock.hashCode();
  }
  
  public boolean isLocking()
  {
    try
    {
      boolean bool = this.wakeLock.isHeld();
      ad.i("MicroMsg.WakerLock", "check is held [%d,%d] :%b caller:[%s] @[%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.wakeLock.hashCode()), Boolean.valueOf(bool), getCallerStack(), getCreatePosStackLine() });
      return bool;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.WakerLock", localException, "", new Object[] { "" });
    }
    return false;
  }
  
  public void lock()
  {
    lock(getCallerStack());
  }
  
  public void lock(long paramLong)
  {
    lock(paramLong, getCallerStack());
  }
  
  public void lock(long paramLong, String paramString)
  {
    try
    {
      if (this.wakeLock.isHeld()) {
        unLock();
      }
      a.a(this, paramString);
      ad.i("MicroMsg.WakerLock", "lock [%d,%d] traceMsg:[%s] @[%s] limit time:%d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.wakeLock.hashCode()), paramString, getCreatePosStackLine(), Long.valueOf(paramLong) });
      this.wakeLock.acquire();
      if (paramLong == -1L)
      {
        this.mHandler.removeCallbacks(this.mReleaser);
        return;
      }
      this.mHandler.postDelayed(this.mReleaser, paramLong);
      return;
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("MicroMsg.WakerLock", paramString, "", new Object[] { "" });
    }
  }
  
  public void lock(String paramString)
  {
    lock(-1L, paramString);
  }
  
  public void unLock()
  {
    if (this.wakeLock.isHeld())
    {
      this.mHandler.removeCallbacks(this.mReleaser);
      a.c(this);
      ad.i("MicroMsg.WakerLock", "unlock [%d,%d] caller:[%s] @[%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.wakeLock.hashCode()), getCallerStack(), getCreatePosStackLine() });
    }
    try
    {
      this.wakeLock.release();
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.WakerLock", localException, "", new Object[] { "" });
    }
  }
  
  public static abstract interface IAutoUnlockCallback
  {
    public abstract void autoUnlockCallback();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mars.comm.WakerLock
 * JD-Core Version:    0.7.0.1
 */