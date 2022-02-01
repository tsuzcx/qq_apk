package com.tencent.component.network.utils.thread;

import cwi;
import cwj;
import cwk;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool
{
  protected static final int a = 4;
  public static final ThreadPool.JobContext a;
  protected static final int b = 10;
  public static final int c = 0;
  public static final int d = 1;
  public static final int e = 2;
  public cwj a;
  private final Executor a;
  public cwj b = new cwj(2);
  
  static
  {
    jdField_a_of_type_ComTencentComponentNetworkUtilsThreadThreadPool$JobContext = new cwi(null);
  }
  
  public ThreadPool()
  {
    this("thread-pool", 4);
  }
  
  public ThreadPool(String paramString, int paramInt)
  {
    this(paramString, paramInt, paramInt, new LinkedBlockingQueue());
  }
  
  public ThreadPool(String paramString, int paramInt1, int paramInt2, BlockingQueue paramBlockingQueue)
  {
    this.jdField_a_of_type_Cwj = new cwj(2);
    if (paramInt1 <= 0) {
      paramInt1 = 1;
    }
    for (;;)
    {
      if (paramInt2 <= paramInt1) {
        paramInt2 = paramInt1;
      }
      for (;;)
      {
        this.jdField_a_of_type_JavaUtilConcurrentExecutor = new ThreadPoolExecutor(paramInt1, paramInt2, 10L, TimeUnit.SECONDS, paramBlockingQueue, new PriorityThreadFactory(paramString, 10));
        return;
      }
    }
  }
  
  public ThreadPool(Executor paramExecutor)
  {
    this.jdField_a_of_type_Cwj = new cwj(2);
    if (paramExecutor != null) {}
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilConcurrentExecutor = paramExecutor;
      return;
      paramExecutor = new ThreadPoolExecutor(2, 2, 10L, TimeUnit.SECONDS, new PriorityBlockingQueue(), new PriorityThreadFactory("thread_pool", 10));
    }
  }
  
  public Future a(ThreadPool.Job paramJob)
  {
    return a(paramJob, null);
  }
  
  public Future a(ThreadPool.Job paramJob, FutureListener paramFutureListener)
  {
    paramJob = new cwk(this, paramJob, paramFutureListener);
    this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute(paramJob);
    return paramJob;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.utils.thread.ThreadPool
 * JD-Core Version:    0.7.0.1
 */