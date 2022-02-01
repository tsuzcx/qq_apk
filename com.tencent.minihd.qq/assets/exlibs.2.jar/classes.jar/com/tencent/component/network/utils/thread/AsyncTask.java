package com.tencent.component.network.utils.thread;

import android.os.Message;
import cwa;
import cwb;
import cwc;
import cwd;
import cwe;
import cwl;
import cwo;
import cwp;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class AsyncTask
{
  private static final BlockingQueue jdField_a_of_type_JavaUtilConcurrentBlockingQueue;
  public static final Executor a;
  private static final ThreadFactory jdField_a_of_type_JavaUtilConcurrentThreadFactory = new cwl();
  public static final Executor b;
  private static volatile Executor c = jdField_b_of_type_JavaUtilConcurrentExecutor;
  private volatile AsyncTask.Status jdField_a_of_type_ComTencentComponentNetworkUtilsThreadAsyncTask$Status = AsyncTask.Status.PENDING;
  private final cwe jdField_a_of_type_Cwe = new cwo(this);
  private final FutureTask jdField_a_of_type_JavaUtilConcurrentFutureTask = new cwp(this, this.jdField_a_of_type_Cwe);
  private final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
  private final AtomicBoolean b;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentBlockingQueue = new LinkedBlockingQueue(10);
    jdField_a_of_type_JavaUtilConcurrentExecutor = new ThreadPoolExecutor(1, 128, 1L, TimeUnit.SECONDS, jdField_a_of_type_JavaUtilConcurrentBlockingQueue, jdField_a_of_type_JavaUtilConcurrentThreadFactory);
    jdField_b_of_type_JavaUtilConcurrentExecutor = new cwd(null);
  }
  
  public AsyncTask()
  {
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
  }
  
  private Object a(Object paramObject)
  {
    cwb.a.obtainMessage(1, new cwa(this, new Object[] { paramObject })).sendToTarget();
    return paramObject;
  }
  
  public static void a(Runnable paramRunnable)
  {
    c.execute(paramRunnable);
  }
  
  private void c(Object paramObject)
  {
    if (!this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      a(paramObject);
    }
  }
  
  private void d(Object paramObject)
  {
    if (a()) {
      b(paramObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadAsyncTask$Status = AsyncTask.Status.FINISHED;
      return;
      a(paramObject);
    }
  }
  
  public final AsyncTask.Status a()
  {
    return this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadAsyncTask$Status;
  }
  
  public final AsyncTask a(Executor paramExecutor, Object... paramVarArgs)
  {
    if (this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadAsyncTask$Status != AsyncTask.Status.PENDING) {}
    switch (cvz.a[this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadAsyncTask$Status.ordinal()])
    {
    default: 
      this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadAsyncTask$Status = AsyncTask.Status.RUNNING;
      a();
      this.jdField_a_of_type_Cwe.a = paramVarArgs;
      paramExecutor.execute(this.jdField_a_of_type_JavaUtilConcurrentFutureTask);
      return this;
    case 1: 
      throw new IllegalStateException("Cannot execute task: the task is already running.");
    }
    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
  }
  
  public final AsyncTask a(Object... paramVarArgs)
  {
    return a(c, paramVarArgs);
  }
  
  public final Object a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentFutureTask.get();
  }
  
  public final Object a(long paramLong, TimeUnit paramTimeUnit)
  {
    return this.jdField_a_of_type_JavaUtilConcurrentFutureTask.get(paramLong, paramTimeUnit);
  }
  
  public abstract Object a(Object... paramVarArgs);
  
  protected void a() {}
  
  protected void a(Object paramObject) {}
  
  public void a(Object... paramVarArgs) {}
  
  public final boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public final boolean a(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    return this.jdField_a_of_type_JavaUtilConcurrentFutureTask.cancel(paramBoolean);
  }
  
  protected void b() {}
  
  protected void b(Object paramObject)
  {
    b();
  }
  
  protected final void b(Object... paramVarArgs)
  {
    if (!a()) {
      cwb.a.obtainMessage(2, new cwa(this, paramVarArgs)).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.utils.thread.AsyncTask
 * JD-Core Version:    0.7.0.1
 */