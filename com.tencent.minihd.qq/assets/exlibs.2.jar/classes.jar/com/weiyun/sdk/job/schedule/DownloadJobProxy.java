package com.weiyun.sdk.job.schedule;

import com.weiyun.sdk.IWyTaskManager.DownloadTask;
import com.weiyun.sdk.job.BaseDownloadJob;
import com.weiyun.sdk.job.DownloadJobContext;
import com.weiyun.sdk.job.Job;

public class DownloadJobProxy
  extends JobProxy
  implements IWyTaskManager.DownloadTask
{
  private volatile String mFilePath = null;
  
  public DownloadJobProxy(BaseDownloadJob paramBaseDownloadJob, Object paramObject, JobManager paramJobManager)
  {
    super(paramBaseDownloadJob, paramObject, paramJobManager);
  }
  
  public String getFilePath()
  {
    return this.mFilePath;
  }
  
  public void notifyStateChanged(int paramInt, Job paramJob)
  {
    if (paramInt == 5) {
      this.mFilePath = ((BaseDownloadJob)paramJob).getDownloadJobContext().getDestFilePath();
    }
    super.notifyStateChanged(paramInt, paramJob);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.job.schedule.DownloadJobProxy
 * JD-Core Version:    0.7.0.1
 */