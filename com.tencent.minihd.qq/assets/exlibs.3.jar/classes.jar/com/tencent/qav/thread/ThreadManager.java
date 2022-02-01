package com.tencent.qav.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public class ThreadManager
{
  private static Handler sSubHandler = new Handler(sSubThread.getLooper());
  private static HandlerThread sSubThread = new HandlerThread("qav_sdk_thread_sub");
  private static Handler sUIHandler;
  
  static
  {
    sSubThread.start();
    sUIHandler = new Handler(Looper.getMainLooper());
  }
  
  public static void executeOnSubThread(Runnable paramRunnable)
  {
    sSubHandler.post(paramRunnable);
  }
  
  public static void executeOnSubThreadDelay(Runnable paramRunnable, long paramLong)
  {
    sSubHandler.postDelayed(paramRunnable, paramLong);
  }
  
  public static void executeOnUIThread(Runnable paramRunnable)
  {
    sUIHandler.post(paramRunnable);
  }
  
  public static void executeOnUIThreadDelay(Runnable paramRunnable, long paramLong)
  {
    sUIHandler.postDelayed(paramRunnable, paramLong);
  }
  
  public static Handler getSubThreadHandler()
  {
    return sSubHandler;
  }
  
  public static Handler getUIHandler()
  {
    return sUIHandler;
  }
  
  public static void removeSubThreadCallbacks(Runnable paramRunnable)
  {
    sSubHandler.removeCallbacks(paramRunnable);
  }
  
  public static void removeUIThreadCallbacks(Runnable paramRunnable)
  {
    sUIHandler.removeCallbacks(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.qav.thread.ThreadManager
 * JD-Core Version:    0.7.0.1
 */