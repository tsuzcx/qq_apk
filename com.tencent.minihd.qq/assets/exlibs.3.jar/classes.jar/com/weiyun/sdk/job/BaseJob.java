package com.weiyun.sdk.job;

import com.weiyun.sdk.log.Log;
import com.weiyun.sdk.log.LogTag;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

public abstract class BaseJob
  extends Job
{
  private static final String TAG = "BaseJob";
  protected volatile boolean mCanceled = false;
  protected Future<?> mFuture = null;
  protected final JobContext mJobContext;
  protected volatile boolean mSuspended = false;
  protected ThreadPoolExecutor mThreadPool;
  
  public BaseJob(long paramLong, JobContext paramJobContext)
  {
    super(paramLong);
    this.mJobContext = paramJobContext;
  }
  
  private boolean running()
  {
    System.currentTimeMillis();
    getJobContext().getCurSize();
    StringBuilder localStringBuilder = new StringBuilder();
    setState(2);
    if (!checkCondition())
    {
      localStringBuilder.append("check condition failed. task id=").append(getId());
      localStringBuilder.append(", last error code=").append(getLastErrorNo());
      Log.w("BaseJob", localStringBuilder.toString());
      if (LogTag.NeedSpecialLog()) {
        Log.w("FM-TransferFile", localStringBuilder.toString());
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
          } while (!isAlive());
          setState(3);
          if (fetchUrl()) {
            break;
          }
          localStringBuilder.append("fetch url failed. task id=").append(getId());
          localStringBuilder.append(", last error code=").append(getLastErrorNo());
          Log.w("BaseJob", localStringBuilder.toString());
        } while (!LogTag.NeedSpecialLog());
        Log.w("FM-TransferFile", localStringBuilder.toString());
        return false;
      } while (!isAlive());
      setState(4);
      if (doTransfer()) {
        break;
      }
      localStringBuilder.append("transfer data failed. task id=").append(getId());
      localStringBuilder.append(", last error code=").append(getLastErrorNo());
      Log.w("BaseJob", localStringBuilder.toString());
    } while (!LogTag.NeedSpecialLog());
    Log.w("FM-TransferFile", localStringBuilder.toString());
    return false;
    Log.i("BaseJob", "task success. task id=" + getId());
    return true;
  }
  
  private boolean terminateJob(Future<?> paramFuture)
  {
    if ((paramFuture.cancel(true) == true) && (paramFuture.isCancelled()))
    {
      Log.i("BaseJob", "task is canceled. task id=" + getId());
      int i = getState();
      if ((i == 1) || (i == 0))
      {
        if (this.mCanceled) {
          setState(7);
        }
      }
      else {
        return true;
      }
      setState(8);
      return true;
    }
    Log.w("BaseJob", "task can not be canceled. task id=" + getId());
    return false;
  }
  
  public void bindThreadPool(ThreadPoolExecutor paramThreadPoolExecutor)
  {
    this.mThreadPool = paramThreadPoolExecutor;
  }
  
  /* Error */
  public boolean cancel()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 25	com/weiyun/sdk/job/BaseJob:mFuture	Ljava/util/concurrent/Future;
    //   6: astore_2
    //   7: aload_0
    //   8: monitorexit
    //   9: aload_2
    //   10: ifnonnull +48 -> 58
    //   13: ldc 8
    //   15: new 51	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   22: ldc 143
    //   24: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_0
    //   28: invokevirtual 70	com/weiyun/sdk/job/BaseJob:getId	()J
    //   31: invokevirtual 73	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   34: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 146	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: aload_0
    //   41: iconst_1
    //   42: putfield 27	com/weiyun/sdk/job/BaseJob:mCanceled	Z
    //   45: aload_0
    //   46: bipush 7
    //   48: invokevirtual 58	com/weiyun/sdk/job/BaseJob:setState	(I)V
    //   51: iconst_1
    //   52: ireturn
    //   53: astore_2
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_2
    //   57: athrow
    //   58: aload_2
    //   59: invokeinterface 149 1 0
    //   64: ifeq +46 -> 110
    //   67: ldc 8
    //   69: new 51	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   76: ldc 151
    //   78: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload_0
    //   82: invokevirtual 70	com/weiyun/sdk/job/BaseJob:getId	()J
    //   85: invokevirtual 73	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   88: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokestatic 117	com/weiyun/sdk/log/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: aload_0
    //   95: monitorenter
    //   96: aload_0
    //   97: aconst_null
    //   98: putfield 25	com/weiyun/sdk/job/BaseJob:mFuture	Ljava/util/concurrent/Future;
    //   101: aload_0
    //   102: monitorexit
    //   103: iconst_1
    //   104: ireturn
    //   105: astore_2
    //   106: aload_0
    //   107: monitorexit
    //   108: aload_2
    //   109: athrow
    //   110: aload_0
    //   111: iconst_1
    //   112: putfield 27	com/weiyun/sdk/job/BaseJob:mCanceled	Z
    //   115: aload_0
    //   116: aload_2
    //   117: invokespecial 153	com/weiyun/sdk/job/BaseJob:terminateJob	(Ljava/util/concurrent/Future;)Z
    //   120: istore_1
    //   121: aload_0
    //   122: monitorenter
    //   123: aload_0
    //   124: aconst_null
    //   125: putfield 25	com/weiyun/sdk/job/BaseJob:mFuture	Ljava/util/concurrent/Future;
    //   128: aload_0
    //   129: monitorexit
    //   130: iload_1
    //   131: ireturn
    //   132: astore_2
    //   133: aload_0
    //   134: monitorexit
    //   135: aload_2
    //   136: athrow
    //   137: astore_2
    //   138: aload_0
    //   139: monitorenter
    //   140: aload_0
    //   141: aconst_null
    //   142: putfield 25	com/weiyun/sdk/job/BaseJob:mFuture	Ljava/util/concurrent/Future;
    //   145: aload_0
    //   146: monitorexit
    //   147: aload_2
    //   148: athrow
    //   149: astore_2
    //   150: aload_0
    //   151: monitorexit
    //   152: aload_2
    //   153: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	BaseJob
    //   120	11	1	bool	boolean
    //   6	4	2	localFuture1	Future
    //   53	6	2	localObject1	Object
    //   105	12	2	localFuture2	Future
    //   132	4	2	localObject2	Object
    //   137	11	2	localObject3	Object
    //   149	4	2	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   2	9	53	finally
    //   54	56	53	finally
    //   96	103	105	finally
    //   106	108	105	finally
    //   123	130	132	finally
    //   133	135	132	finally
    //   110	121	137	finally
    //   140	147	149	finally
    //   150	152	149	finally
  }
  
  protected abstract boolean checkCondition();
  
  protected abstract boolean doTransfer();
  
  protected abstract boolean fetchUrl();
  
  public JobContext getJobContext()
  {
    return this.mJobContext;
  }
  
  public boolean isAlive()
  {
    return (!this.mCanceled) && (!this.mSuspended);
  }
  
  public boolean restart()
  {
    return start();
  }
  
  public void run()
  {
    try
    {
      if (running() == true) {
        setState(5);
      }
      for (;;)
      {
        try
        {
          this.mFuture = null;
          return;
        }
        finally {}
        if ((!Thread.interrupted()) && (isAlive())) {
          break label91;
        }
        if (!this.mCanceled) {
          break;
        }
        setState(7);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.w("BaseJob", localThrowable);
        if (getLastErrorNo() == 0) {
          setLastErrorNo(-10014);
        }
        setState(6);
        continue;
        setState(8);
        continue;
        label91:
        setState(6);
      }
    }
  }
  
  public boolean start()
  {
    if (this.mThreadPool == null)
    {
      Log.e("BaseJob", "thread pool is null!");
      return false;
    }
    try
    {
      if (this.mFuture != null) {
        return false;
      }
    }
    finally {}
    try
    {
      this.mCanceled = false;
      this.mSuspended = false;
      setState(1);
      Future localFuture = submit(this.mThreadPool);
      if (localFuture == null)
      {
        Log.w("BaseJob", "submit task failed! task id=" + getId());
        return false;
      }
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      Log.w("BaseJob", localRejectedExecutionException);
      return false;
    }
    try
    {
      if (!localRejectedExecutionException.isDone()) {
        this.mFuture = localRejectedExecutionException;
      }
      Log.i("BaseJob", "submit task ok. task id=" + getId());
      return true;
    }
    finally {}
  }
  
  protected Future<?> submit(ThreadPoolExecutor paramThreadPoolExecutor)
  {
    return paramThreadPoolExecutor.submit(this);
  }
  
  /* Error */
  public boolean suspend()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 25	com/weiyun/sdk/job/BaseJob:mFuture	Ljava/util/concurrent/Future;
    //   6: astore_2
    //   7: aload_0
    //   8: monitorexit
    //   9: aload_2
    //   10: ifnonnull +48 -> 58
    //   13: ldc 8
    //   15: new 51	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   22: ldc 143
    //   24: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_0
    //   28: invokevirtual 70	com/weiyun/sdk/job/BaseJob:getId	()J
    //   31: invokevirtual 73	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   34: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 146	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: aload_0
    //   41: iconst_1
    //   42: putfield 29	com/weiyun/sdk/job/BaseJob:mSuspended	Z
    //   45: aload_0
    //   46: bipush 8
    //   48: invokevirtual 58	com/weiyun/sdk/job/BaseJob:setState	(I)V
    //   51: iconst_1
    //   52: ireturn
    //   53: astore_2
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_2
    //   57: athrow
    //   58: aload_2
    //   59: invokeinterface 149 1 0
    //   64: ifeq +46 -> 110
    //   67: ldc 8
    //   69: new 51	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   76: ldc 151
    //   78: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload_0
    //   82: invokevirtual 70	com/weiyun/sdk/job/BaseJob:getId	()J
    //   85: invokevirtual 73	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   88: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokestatic 117	com/weiyun/sdk/log/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: aload_0
    //   95: monitorenter
    //   96: aload_0
    //   97: aconst_null
    //   98: putfield 25	com/weiyun/sdk/job/BaseJob:mFuture	Ljava/util/concurrent/Future;
    //   101: aload_0
    //   102: monitorexit
    //   103: iconst_1
    //   104: ireturn
    //   105: astore_2
    //   106: aload_0
    //   107: monitorexit
    //   108: aload_2
    //   109: athrow
    //   110: aload_0
    //   111: iconst_1
    //   112: putfield 29	com/weiyun/sdk/job/BaseJob:mSuspended	Z
    //   115: aload_0
    //   116: aload_2
    //   117: invokespecial 153	com/weiyun/sdk/job/BaseJob:terminateJob	(Ljava/util/concurrent/Future;)Z
    //   120: istore_1
    //   121: aload_0
    //   122: monitorenter
    //   123: aload_0
    //   124: aconst_null
    //   125: putfield 25	com/weiyun/sdk/job/BaseJob:mFuture	Ljava/util/concurrent/Future;
    //   128: aload_0
    //   129: monitorexit
    //   130: iload_1
    //   131: ireturn
    //   132: astore_2
    //   133: aload_0
    //   134: monitorexit
    //   135: aload_2
    //   136: athrow
    //   137: astore_2
    //   138: aload_0
    //   139: monitorenter
    //   140: aload_0
    //   141: aconst_null
    //   142: putfield 25	com/weiyun/sdk/job/BaseJob:mFuture	Ljava/util/concurrent/Future;
    //   145: aload_0
    //   146: monitorexit
    //   147: aload_2
    //   148: athrow
    //   149: astore_2
    //   150: aload_0
    //   151: monitorexit
    //   152: aload_2
    //   153: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	BaseJob
    //   120	11	1	bool	boolean
    //   6	4	2	localFuture1	Future
    //   53	6	2	localObject1	Object
    //   105	12	2	localFuture2	Future
    //   132	4	2	localObject2	Object
    //   137	11	2	localObject3	Object
    //   149	4	2	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   2	9	53	finally
    //   54	56	53	finally
    //   96	103	105	finally
    //   106	108	105	finally
    //   123	130	132	finally
    //   133	135	132	finally
    //   110	121	137	finally
    //   140	147	149	finally
    //   150	152	149	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.job.BaseJob
 * JD-Core Version:    0.7.0.1
 */