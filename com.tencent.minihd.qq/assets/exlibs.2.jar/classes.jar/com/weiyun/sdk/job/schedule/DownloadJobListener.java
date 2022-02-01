package com.weiyun.sdk.job.schedule;

import com.weiyun.sdk.job.BaseDownloadJob;
import com.weiyun.sdk.job.DownloadJobContext;
import com.weiyun.sdk.job.Job;
import com.weiyun.sdk.job.Job.JobListener;
import com.weiyun.sdk.log.Log;
import com.weiyun.sdk.store.TaskDBHelper;

public class DownloadJobListener
  implements Job.JobListener
{
  private static final String TAG = "DownloadJobListener";
  
  public void notifyProgressChanged(long paramLong1, long paramLong2, Job paramJob) {}
  
  public void notifyStateChanged(int paramInt, Job paramJob)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 4: 
    case 6: 
    case 7: 
    case 8: 
      onMidway(paramInt, paramJob);
      return;
    }
    onSuccess(paramJob);
  }
  
  protected void onMidway(int paramInt, Job paramJob)
  {
    DownloadJobContext localDownloadJobContext = ((BaseDownloadJob)paramJob).getDownloadJobContext();
    TaskDBHelper.newDBHelper().updateDownloadContext(localDownloadJobContext.getId(), localDownloadJobContext.getCurSize(), localDownloadJobContext.getTotalSize(), localDownloadJobContext.getDestFileName(), localDownloadJobContext.getMd5());
    Log.i("DownloadJobListener", "task " + paramJob.getId() + " new state:" + paramInt);
  }
  
  protected void onSuccess(Job paramJob)
  {
    paramJob = ((BaseDownloadJob)paramJob).getDownloadJobContext();
    TaskDBHelper.newDBHelper().deleteItem(paramJob.getId());
    Log.i("DownloadJobListener", "download successful. file id=" + paramJob.getFileId());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.job.schedule.DownloadJobListener
 * JD-Core Version:    0.7.0.1
 */