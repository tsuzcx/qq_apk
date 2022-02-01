package com.weiyun.sdk.job.schedule;

import com.weiyun.sdk.job.BaseJob;
import com.weiyun.sdk.job.Job;
import com.weiyun.sdk.job.Job.JobListener;
import com.weiyun.sdk.log.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class JobManager
  implements Job.JobListener
{
  private static final int DEFAULT_MAX_RUNNING_JOB = 1;
  private static final String TAG = "JobManager";
  private final HashMap<Long, JobProxy> mDoneList;
  private final boolean mKeepDoneTask;
  private final Lock mLock;
  private final int mMaxRunningJob;
  private JobQueueListener mQueueListener = null;
  private final LinkedList<JobProxy> mRunningList;
  private volatile boolean mSuspend = false;
  private final ThreadPoolExecutor mThreadPool;
  private final LinkedList<JobProxy> mWaitingList;
  
  public JobManager(ThreadPoolExecutor paramThreadPoolExecutor)
  {
    this(paramThreadPoolExecutor, false);
  }
  
  public JobManager(ThreadPoolExecutor paramThreadPoolExecutor, boolean paramBoolean)
  {
    this(paramThreadPoolExecutor, paramBoolean, 1);
  }
  
  public JobManager(ThreadPoolExecutor paramThreadPoolExecutor, boolean paramBoolean, int paramInt)
  {
    this.mThreadPool = paramThreadPoolExecutor;
    this.mKeepDoneTask = paramBoolean;
    this.mLock = new ReentrantLock();
    this.mWaitingList = new LinkedList();
    this.mRunningList = new LinkedList();
    this.mDoneList = new HashMap();
    this.mMaxRunningJob = paramInt;
  }
  
  private void dispatchTaskInternal()
  {
    this.mLock.lock();
    try
    {
      int i = this.mRunningList.size();
      int j = this.mMaxRunningJob;
      if (i >= j) {
        return;
      }
      this.mLock.unlock();
      this.mThreadPool.submit(new DispatchTask(null));
      return;
    }
    finally
    {
      this.mLock.unlock();
    }
  }
  
  private JobProxy findTaskInternal(long paramLong)
  {
    Iterator localIterator = this.mRunningList.iterator();
    JobProxy localJobProxy;
    while (localIterator.hasNext())
    {
      localJobProxy = (JobProxy)localIterator.next();
      if (localJobProxy.getId() == paramLong) {
        return localJobProxy;
      }
    }
    localIterator = this.mWaitingList.iterator();
    while (localIterator.hasNext())
    {
      localJobProxy = (JobProxy)localIterator.next();
      if (localJobProxy.getId() == paramLong) {
        return localJobProxy;
      }
    }
    if (this.mKeepDoneTask) {
      return (JobProxy)this.mDoneList.get(Long.valueOf(paramLong));
    }
    return null;
  }
  
  private JobProxy removeRunningJobInternal(long paramLong)
  {
    Iterator localIterator = this.mRunningList.iterator();
    while (localIterator.hasNext())
    {
      JobProxy localJobProxy = (JobProxy)localIterator.next();
      if (paramLong == localJobProxy.getId())
      {
        localIterator.remove();
        return localJobProxy;
      }
    }
    return null;
  }
  
  private boolean removeTaskInternal(long paramLong)
  {
    boolean bool2 = true;
    Iterator localIterator = this.mRunningList.iterator();
    boolean bool1;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        JobProxy localJobProxy = (JobProxy)localIterator.next();
        if (paramLong == localJobProxy.getId()) {
          if (!localJobProxy.getJob().cancel())
          {
            Log.w("JobManager", "cancel task failed. id = " + paramLong);
            bool1 = false;
          }
        }
      }
    }
    do
    {
      do
      {
        return bool1;
        localIterator.remove();
        return true;
        localIterator = this.mWaitingList.iterator();
        while (localIterator.hasNext()) {
          if (paramLong == ((JobProxy)localIterator.next()).getId())
          {
            localIterator.remove();
            return true;
          }
        }
        bool1 = bool2;
      } while (!this.mKeepDoneTask);
      bool1 = bool2;
    } while ((JobProxy)this.mDoneList.remove(Long.valueOf(paramLong)) != null);
    return false;
  }
  
  private void submitTaskInternal()
  {
    this.mLock.lock();
    JobQueueListener localJobQueueListener;
    do
    {
      int i;
      do
      {
        try
        {
          i = this.mRunningList.size();
          int j = this.mMaxRunningJob;
          if (i >= j) {
            return;
          }
          while ((this.mRunningList.size() < this.mMaxRunningJob) && (this.mWaitingList.size() > 0))
          {
            JobProxy localJobProxy = (JobProxy)this.mWaitingList.removeFirst();
            this.mRunningList.add(localJobProxy);
            localJobProxy.getJob().addListener(this);
            if (!localJobProxy.submit(this.mThreadPool)) {
              Log.w("JobManager", "start task failed! task = " + localJobProxy.getId());
            }
          }
          i = this.mRunningList.size();
        }
        finally
        {
          this.mLock.unlock();
        }
        this.mLock.unlock();
      } while (i > 0);
      localJobQueueListener = this.mQueueListener;
    } while (localJobQueueListener == null);
    localJobQueueListener.onQueueEmpty();
  }
  
  public boolean addTask(JobProxy paramJobProxy)
  {
    this.mLock.lock();
    try
    {
      if (findTaskInternal(paramJobProxy.getId()) == null)
      {
        this.mWaitingList.add(paramJobProxy);
        this.mLock.unlock();
        dispatchTaskInternal();
        return true;
      }
      return false;
    }
    finally
    {
      this.mLock.unlock();
    }
  }
  
  public void cancelTasks()
  {
    Object localObject1 = new LinkedList();
    this.mLock.lock();
    ((LinkedList)localObject1).addAll(this.mRunningList);
    try
    {
      this.mWaitingList.clear();
      localObject1 = ((LinkedList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((JobProxy)((Iterator)localObject1).next()).cancel();
      }
    }
    finally
    {
      this.mLock.unlock();
    }
  }
  
  protected abstract boolean checkCondition();
  
  public void dispatchTask()
  {
    this.mSuspend = false;
    dispatchTaskInternal();
  }
  
  public JobProxy findTask(long paramLong)
  {
    this.mLock.lock();
    try
    {
      JobProxy localJobProxy = findTaskInternal(paramLong);
      return localJobProxy;
    }
    finally
    {
      this.mLock.unlock();
    }
  }
  
  public int getUnDoneTaskSize()
  {
    this.mLock.lock();
    try
    {
      int i = this.mRunningList.size();
      int j = this.mWaitingList.size();
      return i + j;
    }
    finally
    {
      this.mLock.unlock();
    }
  }
  
  public void notifyProgressChanged(long paramLong1, long paramLong2, Job paramJob) {}
  
  public void notifyStateChanged(int paramInt, Job paramJob)
  {
    Log.d("JobManager", "task id " + paramJob.getId() + " new state " + paramInt);
    switch (paramInt)
    {
    default: 
      return;
    case 5: 
    case 6: 
    case 7: 
      paramJob.removeListener(this);
      this.mLock.lock();
      try
      {
        removeRunningJobInternal(paramJob.getId());
        this.mLock.unlock();
        dispatchTaskInternal();
        return;
      }
      finally
      {
        this.mLock.unlock();
      }
    }
    paramJob.removeListener(this);
    this.mLock.lock();
    try
    {
      paramJob = removeRunningJobInternal(paramJob.getId());
      if (paramJob != null) {
        this.mWaitingList.add(paramJob);
      }
      return;
    }
    finally
    {
      this.mLock.unlock();
    }
  }
  
  public boolean removeTask(long paramLong)
  {
    this.mLock.lock();
    try
    {
      boolean bool = removeTaskInternal(paramLong);
      return bool;
    }
    finally
    {
      this.mLock.unlock();
    }
  }
  
  public void setJobQueueListener(JobQueueListener paramJobQueueListener)
  {
    this.mQueueListener = paramJobQueueListener;
  }
  
  public void suspendTasks()
  {
    this.mSuspend = true;
    this.mLock.lock();
    try
    {
      Iterator localIterator = this.mRunningList.iterator();
      while (localIterator.hasNext()) {
        ((JobProxy)localIterator.next()).suspend();
      }
    }
    finally
    {
      this.mLock.unlock();
    }
  }
  
  private class DispatchTask
    implements Runnable
  {
    private DispatchTask() {}
    
    public void run()
    {
      if ((!JobManager.this.mSuspend) && (JobManager.this.checkCondition())) {
        JobManager.this.submitTaskInternal();
      }
      JobManager.JobQueueListener localJobQueueListener;
      do
      {
        return;
        localJobQueueListener = JobManager.this.mQueueListener;
      } while (localJobQueueListener == null);
      localJobQueueListener.onQueueSuspend();
    }
  }
  
  public static abstract interface JobQueueListener
  {
    public abstract void onQueueEmpty();
    
    public abstract void onQueueSuspend();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.job.schedule.JobManager
 * JD-Core Version:    0.7.0.1
 */