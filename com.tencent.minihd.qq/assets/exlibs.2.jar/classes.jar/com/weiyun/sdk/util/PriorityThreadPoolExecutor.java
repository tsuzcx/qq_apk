package com.weiyun.sdk.util;

import android.os.Build.VERSION;
import com.weiyun.sdk.log.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PriorityThreadPoolExecutor
  extends ThreadPoolExecutor
{
  public static final int ABOVE_NORMAL = 1;
  public static final int BELOW_NORMAL = -1;
  public static final int HIGH = 2;
  public static final int IDEL = -2;
  public static final int NORMAL = 0;
  private static final String TAG = "PriorityThreadPoolExecutor";
  
  public PriorityThreadPoolExecutor(int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, ThreadFactory paramThreadFactory)
  {
    super(paramInt1, paramInt2, paramLong, paramTimeUnit, new PriorityBlockingQueue(), paramThreadFactory);
  }
  
  public PriorityThreadPoolExecutor(int paramInt1, int paramInt2, ThreadFactory paramThreadFactory)
  {
    super(paramInt1, paramInt2, 15L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), paramThreadFactory);
  }
  
  public void execute(Runnable paramRunnable)
  {
    if ((paramRunnable instanceof ComparableFutureTask))
    {
      super.execute(paramRunnable);
      return;
    }
    submit(paramRunnable);
  }
  
  protected <T> RunnableFuture<T> newTaskFor(Runnable paramRunnable, T paramT)
  {
    return new ComparableFutureTask(paramRunnable, paramT);
  }
  
  protected <T> RunnableFuture<T> newTaskFor(Callable<T> paramCallable)
  {
    return new ComparableFutureTask(paramCallable);
  }
  
  public boolean remove(Runnable paramRunnable)
  {
    return super.remove(new PriorityRunnable(paramRunnable));
  }
  
  public Future<?> submit(Runnable paramRunnable)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      return super.submit(new PriorityRunnable(paramRunnable));
    }
    paramRunnable = newTaskFor(new PriorityRunnable(paramRunnable), null);
    execute(paramRunnable);
    return paramRunnable;
  }
  
  public Future<?> submit(Runnable paramRunnable, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      return super.submit(new PriorityRunnable(paramRunnable, paramInt));
    }
    paramRunnable = newTaskFor(new PriorityRunnable(paramRunnable, paramInt), null);
    execute(paramRunnable);
    return paramRunnable;
  }
  
  public <T> Future<T> submit(Runnable paramRunnable, T paramT)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      return super.submit(new PriorityRunnable(paramRunnable), paramT);
    }
    paramRunnable = newTaskFor(new PriorityRunnable(paramRunnable), paramT);
    execute(paramRunnable);
    return paramRunnable;
  }
  
  public <T> Future<?> submit(Runnable paramRunnable, T paramT, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      return super.submit(new PriorityRunnable(paramRunnable, paramInt), paramT);
    }
    paramRunnable = newTaskFor(new PriorityRunnable(paramRunnable, paramInt), paramT);
    execute(paramRunnable);
    return paramRunnable;
  }
  
  public <T> Future<T> submit(Callable<T> paramCallable)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      return super.submit(new PriorityCallable(paramCallable));
    }
    paramCallable = newTaskFor(new PriorityCallable(paramCallable));
    execute(paramCallable);
    return paramCallable;
  }
  
  public <T> Future<T> submit(Callable<T> paramCallable, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      return submit(new PriorityCallable(paramCallable, paramInt));
    }
    paramCallable = newTaskFor(new PriorityCallable(paramCallable, paramInt));
    execute(paramCallable);
    return paramCallable;
  }
  
  private static class ComparableFutureTask<V>
    extends FutureTask<V>
    implements Comparable<ComparableFutureTask<V>>
  {
    private Object object;
    
    public ComparableFutureTask(Runnable paramRunnable, V paramV)
    {
      super(paramV);
      this.object = paramRunnable;
    }
    
    public ComparableFutureTask(Callable<V> paramCallable)
    {
      super();
      this.object = paramCallable;
    }
    
    public int compareTo(ComparableFutureTask<V> paramComparableFutureTask)
    {
      if (this == paramComparableFutureTask) {}
      do
      {
        return 0;
        if (paramComparableFutureTask == null) {
          return -1;
        }
      } while ((this.object == null) || (paramComparableFutureTask.object == null) || (!this.object.getClass().equals(paramComparableFutureTask.object.getClass())) || (!(this.object instanceof Comparable)));
      return ((Comparable)this.object).compareTo(paramComparableFutureTask.object);
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject == null) || (!(paramObject instanceof ComparableFutureTask))) {
        return false;
      }
      paramObject = (ComparableFutureTask)paramObject;
      return this.object.equals(paramObject.object);
    }
  }
  
  private static class PriorityCallable<T>
    extends PriorityThreadPoolExecutor.PriorityTask
    implements Callable<T>
  {
    protected Callable<T> mC;
    
    public PriorityCallable(Callable<T> paramCallable)
    {
      this.mC = paramCallable;
    }
    
    public PriorityCallable(Callable<T> paramCallable, int paramInt)
    {
      super();
      this.mC = paramCallable;
    }
    
    public T call()
      throws Exception
    {
      if (System.currentTimeMillis() - this.mPostTime > 30000L) {
        Log.w("PriorityThreadPoolExecutor", "this job hangury too long. job:" + this + ". job:" + this.mC);
      }
      Object localObject = this.mC.call();
      this.mC = null;
      return localObject;
    }
  }
  
  private static class PriorityRunnable
    extends PriorityThreadPoolExecutor.PriorityTask
    implements Runnable
  {
    protected Runnable mR;
    
    public PriorityRunnable(Runnable paramRunnable)
    {
      this.mR = paramRunnable;
    }
    
    public PriorityRunnable(Runnable paramRunnable, int paramInt)
    {
      super();
      this.mR = paramRunnable;
    }
    
    public void run()
    {
      if (System.currentTimeMillis() - this.mPostTime > 30000L) {
        Log.w("PriorityThreadPoolExecutor", "this job hangury too long. job:" + this + ". job:" + this.mR);
      }
      try
      {
        this.mR.run();
        this.mR = null;
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Log.w("PriorityThreadPoolExecutor", localThrowable);
        }
      }
    }
  }
  
  private static class PriorityTask
    implements Comparable<PriorityTask>
  {
    protected long mPostTime = System.currentTimeMillis();
    protected int mPriority = 0;
    
    public PriorityTask() {}
    
    public PriorityTask(int paramInt)
    {
      this.mPriority = paramInt;
    }
    
    public int compareTo(PriorityTask paramPriorityTask)
    {
      int i;
      if (this == paramPriorityTask) {
        i = 0;
      }
      int j;
      do
      {
        return i;
        j = paramPriorityTask.mPriority - this.mPriority;
        i = j;
      } while (j != 0);
      return (int)(this.mPostTime - paramPriorityTask.mPostTime);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.util.PriorityThreadPoolExecutor
 * JD-Core Version:    0.7.0.1
 */