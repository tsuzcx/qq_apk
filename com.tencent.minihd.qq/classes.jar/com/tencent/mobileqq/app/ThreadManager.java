package com.tencent.mobileqq.app;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import hqc;
import hqe;
import hqg;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.Timer;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class ThreadManager
{
  private static Handler jdField_a_of_type_AndroidOsHandler;
  private static HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private static ThreadLocal jdField_a_of_type_JavaLangThreadLocal = new ThreadLocal();
  private static Timer jdField_a_of_type_JavaUtilTimer;
  public static final Executor a;
  public static final boolean a = false;
  private static Handler jdField_b_of_type_AndroidOsHandler;
  private static HandlerThread jdField_b_of_type_AndroidOsHandlerThread;
  private static Handler c;
  private static Handler d;
  private static Handler e;
  private static Handler f;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentExecutor = b();
  }
  
  public static Handler a()
  {
    if (jdField_b_of_type_AndroidOsHandler == null) {}
    try
    {
      jdField_b_of_type_AndroidOsHandlerThread = new HandlerThread("QQ_FILE_RW");
      jdField_b_of_type_AndroidOsHandlerThread.start();
      jdField_b_of_type_AndroidOsHandler = new Handler(jdField_b_of_type_AndroidOsHandlerThread.getLooper());
      return jdField_b_of_type_AndroidOsHandler;
    }
    finally {}
  }
  
  public static Looper a()
  {
    return a().getLooper();
  }
  
  public static Thread a()
  {
    if (jdField_a_of_type_AndroidOsHandlerThread == null) {
      b();
    }
    return jdField_a_of_type_AndroidOsHandlerThread;
  }
  
  public static Timer a()
  {
    if (jdField_a_of_type_JavaUtilTimer == null) {}
    try
    {
      jdField_a_of_type_JavaUtilTimer = new hqc("QQ_Timer");
      return jdField_a_of_type_JavaUtilTimer;
    }
    finally {}
  }
  
  public static Executor a()
  {
    return new hqe(null);
  }
  
  public static void a() {}
  
  public static void a(Runnable paramRunnable)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        jdField_a_of_type_JavaUtilConcurrentExecutor.execute(new hqg(paramRunnable, "NetWorkThread"));
        return;
      }
      jdField_a_of_type_JavaUtilConcurrentExecutor.execute(paramRunnable);
      return;
    }
    catch (RejectedExecutionException paramRunnable) {}
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      LinkedList localLinkedList2 = (LinkedList)jdField_a_of_type_JavaLangThreadLocal.get();
      LinkedList localLinkedList1 = localLinkedList2;
      if (localLinkedList2 == null)
      {
        localLinkedList1 = new LinkedList();
        jdField_a_of_type_JavaLangThreadLocal.set(localLinkedList1);
      }
      localLinkedList1.addFirst(Long.valueOf(SystemClock.uptimeMillis()));
      QLog.i(paramString1, 2, paramString2);
    }
  }
  
  public static Handler b()
  {
    if (jdField_a_of_type_AndroidOsHandler == null) {}
    try
    {
      if (jdField_a_of_type_AndroidOsHandler == null)
      {
        jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("QQ_SUB");
        jdField_a_of_type_AndroidOsHandlerThread.start();
        jdField_a_of_type_AndroidOsHandler = new Handler(jdField_a_of_type_AndroidOsHandlerThread.getLooper());
      }
      return jdField_a_of_type_AndroidOsHandler;
    }
    finally {}
  }
  
  public static Looper b()
  {
    return b().getLooper();
  }
  
  @TargetApi(11)
  private static Executor b()
  {
    Object localObject;
    if (VersionUtils.e()) {
      localObject = AsyncTask.THREAD_POOL_EXECUTOR;
    }
    for (;;)
    {
      if ((localObject instanceof ThreadPoolExecutor))
      {
        ThreadPoolExecutor localThreadPoolExecutor2 = (ThreadPoolExecutor)localObject;
        localThreadPoolExecutor2.setCorePoolSize(3);
        localThreadPoolExecutor2.setRejectedExecutionHandler(new ThreadManager.ShowQueueAbortPolicy());
      }
      return localObject;
      try
      {
        localObject = AsyncTask.class.getDeclaredField("sExecutor");
        ((Field)localObject).setAccessible(true);
        localObject = (Executor)((Field)localObject).get(null);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ThreadManager", 2, localException.getMessage(), localException);
          }
          ThreadPoolExecutor localThreadPoolExecutor1 = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        }
      }
    }
  }
  
  public static void b(Runnable paramRunnable)
  {
    if (QLog.isColorLevel())
    {
      b().post(new hqg(paramRunnable, "SubThread"));
      return;
    }
    b().post(paramRunnable);
  }
  
  public static void b(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      Object localObject2 = (LinkedList)jdField_a_of_type_JavaLangThreadLocal.get();
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new LinkedList();
        jdField_a_of_type_JavaLangThreadLocal.set(localObject1);
        ((LinkedList)localObject1).addFirst(Long.valueOf(SystemClock.uptimeMillis()));
      }
      localObject2 = new StringBuilder();
      int i = 1;
      while (i < ((LinkedList)localObject1).size())
      {
        ((StringBuilder)localObject2).append("    ");
        i += 1;
      }
      ((StringBuilder)localObject2).append(paramString2);
      ((StringBuilder)localObject2).append(":cost ");
      ((StringBuilder)localObject2).append(SystemClock.uptimeMillis() - ((Long)((LinkedList)jdField_a_of_type_JavaLangThreadLocal.get()).removeFirst()).longValue());
      ((StringBuilder)localObject2).append("ms");
      QLog.i(paramString1, 2, ((StringBuilder)localObject2).toString());
    }
  }
  
  public static Handler c()
  {
    if (e == null) {}
    try
    {
      if (e == null) {
        e = new Handler(Looper.getMainLooper());
      }
      return e;
    }
    finally {}
  }
  
  public static Looper c()
  {
    if (d == null) {}
    try
    {
      HandlerThread localHandlerThread = new HandlerThread("Recent_Handler");
      localHandlerThread.start();
      d = new Handler(localHandlerThread.getLooper());
      return d.getLooper();
    }
    finally {}
  }
  
  public static void c(Runnable paramRunnable)
  {
    if (QLog.isColorLevel())
    {
      a().post(new hqg(paramRunnable, "FileThread"));
      return;
    }
    a().post(paramRunnable);
  }
  
  public static Handler d()
  {
    if (c == null) {}
    try
    {
      HandlerThread localHandlerThread = new HandlerThread("Msg_Handler");
      localHandlerThread.start();
      c = new Handler(localHandlerThread.getLooper());
      return c;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThreadManager
 * JD-Core Version:    0.7.0.1
 */