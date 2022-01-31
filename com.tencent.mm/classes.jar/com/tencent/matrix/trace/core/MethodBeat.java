package com.tencent.matrix.trace.core;

import android.app.Activity;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import com.tencent.matrix.trace.c.c;
import java.util.Iterator;
import java.util.LinkedList;

public class MethodBeat
  implements a.a
{
  private static final int RELEASE_BUFFER_MSG_ID = 512;
  private static final String TAG = "Matrix.MethodBeat";
  private static final int UPDATE_TIME_MSG_ID = 256;
  private static volatile boolean isBackground;
  private static volatile boolean isCreated = false;
  private static boolean isRealTrace;
  private static String sApplicationOnCreateMethodId;
  private static long[] sBuffer;
  private static volatile long sCurrentDiffTime;
  private static volatile long sFirstDiffTime;
  private static volatile int sIndex;
  private static boolean sIsIn;
  private static volatile long sLastDiffTime;
  private static LinkedList<c> sListeners = new LinkedList();
  private static Thread sMainThread;
  private static Handler sReleaseBufferHandler;
  private static Handler sTimeUpdateHandler;
  private static HandlerThread sTimerUpdateThread;
  private int lockCount;
  private long mLastLockBufferTime;
  
  static
  {
    sIndex = 0;
    sApplicationOnCreateMethodId = "";
    sBuffer = new long[10000];
    sIsIn = false;
    sMainThread = Looper.getMainLooper().getThread();
    sTimerUpdateThread = com.tencent.matrix.d.a.bA("matrix_time_update_thread");
    sTimeUpdateHandler = new Handler(sTimerUpdateThread.getLooper(), new Handler.Callback()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        if (paramAnonymousMessage.what == 256)
        {
          MethodBeat.access$002(System.nanoTime() / 1000000L - MethodBeat.sLastDiffTime);
          MethodBeat.sTimeUpdateHandler.sendEmptyMessageDelayed(256, 5L);
        }
        return true;
      }
    });
    sReleaseBufferHandler = new Handler(Looper.getMainLooper(), new Handler.Callback()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        if ((paramAnonymousMessage.what == 512) && (!MethodBeat.isCreated))
        {
          com.tencent.matrix.d.b.i("Matrix.MethodBeat", "Plugin is never init, release buffer!", new Object[0]);
          MethodBeat.access$402(null);
        }
        return true;
      }
    });
    com.tencent.matrix.trace.b.b.rp();
    sFirstDiffTime = System.nanoTime() / 1000000L;
    long l = System.nanoTime() / 1000000L;
    sLastDiffTime = l;
    sCurrentDiffTime = l;
    sTimeUpdateHandler.sendEmptyMessage(256);
    sReleaseBufferHandler.sendEmptyMessageDelayed(512, 60000L);
  }
  
  public static void at(Activity paramActivity, boolean paramBoolean)
  {
    com.tencent.matrix.d.b.i("Matrix.MethodBeat", "[AT] activity: %s, isCreated: %b sListener size: %d，isFocus: %b", new Object[] { paramActivity.getClass().getSimpleName(), Boolean.valueOf(isCreated), Integer.valueOf(sListeners.size()), Boolean.valueOf(paramBoolean) });
    if ((isCreated) && (Thread.currentThread() == sMainThread))
    {
      Iterator localIterator = sListeners.iterator();
      while (localIterator.hasNext()) {
        ((c)localIterator.next()).a(paramActivity, paramBoolean, sIndex - 1, sBuffer);
      }
    }
  }
  
  public static long[] getBuffer()
  {
    return sBuffer;
  }
  
  public static int getCurIndex()
  {
    return sIndex;
  }
  
  public static void i(int paramInt)
  {
    if (isBackground) {}
    do
    {
      return;
      isRealTrace = true;
      if ((!isCreated) || (Thread.currentThread() != sMainThread)) {
        break;
      }
    } while (sIsIn);
    sIsIn = true;
    if (sIndex >= 1000000)
    {
      Iterator localIterator = sListeners.iterator();
      while (localIterator.hasNext()) {
        ((c)localIterator.next()).b(sBuffer);
      }
      sIndex = 0;
      label84:
      sIndex += 1;
    }
    for (;;)
    {
      sIsIn = false;
      return;
      mergeData(paramInt, sIndex, true);
      break label84;
      if ((isCreated) || (Thread.currentThread() != sMainThread) || (sIsIn)) {
        break;
      }
      sIsIn = true;
      if (sIndex < 10000)
      {
        mergeData(paramInt, sIndex, true);
        sIndex += 1;
      }
    }
  }
  
  private static void mergeData(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    long l1 = 0L;
    if (paramBoolean) {
      l1 = -9223372036854775808L;
    }
    long l2 = paramInt1;
    long l3 = sCurrentDiffTime;
    sBuffer[paramInt2] = (l1 | l2 << 43 | l3 & 0xFFFFFFFF);
  }
  
  public static void o(int paramInt)
  {
    if (isBackground) {}
    do
    {
      return;
      if ((isCreated) && (Thread.currentThread() == sMainThread))
      {
        if (sIndex < 1000000) {
          mergeData(paramInt, sIndex, false);
        }
        for (;;)
        {
          sIndex += 1;
          return;
          Iterator localIterator = sListeners.iterator();
          while (localIterator.hasNext()) {
            ((c)localIterator.next()).b(sBuffer);
          }
          sIndex = 0;
        }
      }
    } while ((isCreated) || (Thread.currentThread() != sMainThread) || (sIndex >= 10000));
    mergeData(paramInt, sIndex, false);
    sIndex += 1;
  }
  
  public long getLastDiffTime()
  {
    return sLastDiffTime;
  }
  
  public boolean isLockBuffer()
  {
    boolean bool = false;
    if (System.currentTimeMillis() - this.mLastLockBufferTime > 20000L) {
      this.lockCount = 0;
    }
    if (this.lockCount > 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean isRealTrace()
  {
    return isRealTrace;
  }
  
  public void lockBuffer(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mLastLockBufferTime = System.currentTimeMillis();
      this.lockCount += 1;
      return;
    }
    int i = this.lockCount;
    this.lockCount = (i - 1);
    this.lockCount = Math.max(0, i);
  }
  
  public void onActivityCreated(Activity paramActivity)
  {
    com.tencent.matrix.d.b.i("Matrix.MethodBeat", "[onActivityCreated]: %s", new Object[] { paramActivity.getClass().getSimpleName() });
    if ((isBackground) && (!sTimeUpdateHandler.hasMessages(256))) {
      sTimeUpdateHandler.sendEmptyMessage(256);
    }
  }
  
  public void onActivityPause(Activity paramActivity)
  {
    com.tencent.matrix.d.b.i("Matrix.MethodBeat", "[onActivityStarted]: %s", new Object[] { paramActivity.getClass().getSimpleName() });
  }
  
  public void onActivityResume(Activity paramActivity)
  {
    com.tencent.matrix.d.b.i("Matrix.MethodBeat", "[onActivityResume]: %s", new Object[] { paramActivity.getClass().getSimpleName() });
  }
  
  public void onActivityStarted(Activity paramActivity)
  {
    com.tencent.matrix.d.b.i("Matrix.MethodBeat", "[onActivityStarted]: %s", new Object[] { paramActivity.getClass().getSimpleName() });
    if ((isBackground) && (!sTimeUpdateHandler.hasMessages(256))) {
      sTimeUpdateHandler.sendEmptyMessage(256);
    }
  }
  
  public void onBackground(Activity paramActivity)
  {
    com.tencent.matrix.d.b.i("Matrix.MethodBeat", "[onBackground]: %s", new Object[] { paramActivity.getClass().getSimpleName() });
    sTimeUpdateHandler.removeMessages(256);
    isBackground = true;
  }
  
  public void onChange(Activity paramActivity, Fragment paramFragment) {}
  
  public void onCreate()
  {
    if (!isCreated)
    {
      com.tencent.matrix.d.b.i("Matrix.MethodBeat", "[onCreate] sApplicationOnCreateMethodId:%s", new Object[] { sApplicationOnCreateMethodId });
      sTimeUpdateHandler.removeMessages(512);
      a.rn().a(this);
      isCreated = true;
      if ((sBuffer != null) && (sBuffer.length < 1000000))
      {
        long[] arrayOfLong = sBuffer;
        sBuffer = new long[1000000];
        System.arraycopy(arrayOfLong, 0, sBuffer, 0, sIndex);
      }
    }
    else
    {
      return;
    }
    sBuffer = new long[1000000];
  }
  
  public void onDestroy()
  {
    if (isCreated)
    {
      com.tencent.matrix.d.b.i("Matrix.MethodBeat", "[onDestroy]", new Object[0]);
      sListeners.clear();
      isCreated = false;
      sIndex = 0;
      sBuffer = null;
      sTimeUpdateHandler.removeMessages(256);
      sTimeUpdateHandler.removeMessages(512);
      sTimerUpdateThread.quit();
      a.rn().b(this);
    }
  }
  
  public void onFront(Activity paramActivity)
  {
    com.tencent.matrix.d.b.i("Matrix.MethodBeat", "[onFront]: %s", new Object[] { paramActivity.getClass().getSimpleName() });
    if (!sTimeUpdateHandler.hasMessages(256)) {
      sTimeUpdateHandler.sendEmptyMessage(256);
    }
    isBackground = false;
  }
  
  public void registerListener(c paramc)
  {
    if (!sListeners.contains(paramc)) {
      sListeners.add(paramc);
    }
  }
  
  public void resetIndex()
  {
    if (!isLockBuffer()) {
      sIndex = 0;
    }
  }
  
  public void unregisterListener(c paramc)
  {
    if (sListeners.contains(paramc)) {
      sListeners.remove(paramc);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.trace.core.MethodBeat
 * JD-Core Version:    0.7.0.1
 */