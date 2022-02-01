package com.tencent.mobileqq.app;

import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;

public class ThreadManager$ShowQueueAbortPolicy
  extends ThreadPoolExecutor.AbortPolicy
{
  public void rejectedExecution(Runnable paramRunnable, ThreadPoolExecutor paramThreadPoolExecutor)
  {
    paramRunnable = paramThreadPoolExecutor.getQueue();
    if ((paramRunnable != null) && (!paramRunnable.isEmpty())) {}
    try
    {
      paramRunnable = paramRunnable.iterator();
      while (paramRunnable.hasNext())
      {
        paramThreadPoolExecutor = (Runnable)paramRunnable.next();
        try
        {
          Field localField = paramThreadPoolExecutor.getClass().getDeclaredField("this$0");
          localField.setAccessible(true);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ThreadManager", 2, "Queue details." + localField.get(paramThreadPoolExecutor).getClass());
        }
        catch (NoSuchFieldException localNoSuchFieldException) {}
        if (QLog.isColorLevel()) {
          QLog.d("ThreadManager", 2, "Queue details." + paramThreadPoolExecutor.getClass());
        }
      }
      return;
    }
    catch (IllegalArgumentException paramRunnable)
    {
      paramRunnable.printStackTrace();
      return;
    }
    catch (IllegalAccessException paramRunnable)
    {
      paramRunnable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThreadManager.ShowQueueAbortPolicy
 * JD-Core Version:    0.7.0.1
 */