package com.tencent.component.network.utils.thread;

import cwf;
import cwg;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityThreadPool
  extends ThreadPool
{
  public PriorityThreadPool()
  {
    this("priority-thread-pool", 4);
  }
  
  public PriorityThreadPool(String paramString, int paramInt)
  {
    super(paramString, paramInt, paramInt, new PriorityBlockingQueue());
  }
  
  public PriorityThreadPool(Executor paramExecutor)
  {
    super(paramExecutor);
  }
  
  public static PriorityThreadPool a()
  {
    return cwf.a;
  }
  
  public Future a(ThreadPool.Job paramJob)
  {
    return a(paramJob, null, null);
  }
  
  public Future a(ThreadPool.Job paramJob, FutureListener paramFutureListener)
  {
    return a(paramJob, paramFutureListener, null);
  }
  
  public Future a(ThreadPool.Job paramJob, FutureListener paramFutureListener, PriorityThreadPool.Priority paramPriority)
  {
    PriorityThreadPool.Priority localPriority = paramPriority;
    if (paramPriority == null) {
      localPriority = PriorityThreadPool.Priority.b;
    }
    return super.a(new cwg(paramJob, localPriority.jdField_a_of_type_Int, localPriority.jdField_a_of_type_Boolean), paramFutureListener);
  }
  
  public Future a(ThreadPool.Job paramJob, PriorityThreadPool.Priority paramPriority)
  {
    return a(paramJob, null, paramPriority);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.utils.thread.PriorityThreadPool
 * JD-Core Version:    0.7.0.1
 */