package com.weiyun.sdk.job.transfer;

import com.weiyun.sdk.job.BaseDownloadJob;
import com.weiyun.sdk.job.DownloadJobContext;
import com.weiyun.sdk.job.af.AddressFetcher.DownloadAddress;
import com.weiyun.sdk.job.af.AddressFetcher.TransferAddress;
import com.weiyun.sdk.log.Log;
import com.weiyun.sdk.util.HttpDownloader;
import com.weiyun.sdk.util.HttpReader;
import com.weiyun.sdk.util.IoPipe.ProgressListener;
import com.weiyun.sdk.util.Utils;
import java.io.File;

public class HttpDownloadTransfer
  implements Transfer, IoPipe.ProgressListener
{
  private static final String TAG = "HttpDownloadTransfer";
  protected final AddressFetcher.TransferAddress mAddress;
  protected final DownloadJobContext mContext;
  protected final BaseDownloadJob mJob;
  
  public HttpDownloadTransfer(AddressFetcher.TransferAddress paramTransferAddress, DownloadJobContext paramDownloadJobContext, BaseDownloadJob paramBaseDownloadJob)
  {
    this.mAddress = paramTransferAddress;
    this.mContext = paramDownloadJobContext;
    this.mJob = paramBaseDownloadJob;
  }
  
  public int doTransfer()
  {
    File localFile = new File(this.mContext.getDataFilePath());
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if ((this.mAddress instanceof AddressFetcher.DownloadAddress))
    {
      AddressFetcher.DownloadAddress localDownloadAddress = (AddressFetcher.DownloadAddress)this.mAddress;
      localObject1 = localObject2;
      if (localDownloadAddress.getCookieName() != null)
      {
        localObject1 = localObject2;
        if (localDownloadAddress.getCookieValue() != null) {
          localObject1 = localDownloadAddress.getCookieName() + "=" + localDownloadAddress.getCookieValue();
        }
      }
    }
    localObject1 = new HttpDownloader(new HttpReader(this.mAddress, (String)localObject1), localFile);
    ((HttpDownloader)localObject1).setProgressListener(this);
    return ((HttpDownloader)localObject1).download();
  }
  
  protected int moveToTarget()
  {
    Utils.checkDirAndCreate(this.mContext.getDestDirectoryPath());
    if (!new File(this.mContext.getDataFilePath()).renameTo(new File(this.mContext.getDestFilePath())))
    {
      if (Utils.checkFileExist(this.mContext.getDestFilePath()) == true)
      {
        String str = Utils.generateNewFilename(this.mContext.getDestFileName());
        this.mJob.renameDestFile(str);
      }
    }
    else {
      return 0;
    }
    Log.e("HttpDownloadTransfer", "rename to target file failed. target =" + this.mContext.getDestFilePath());
    return -10008;
  }
  
  public void onProgressChanged(long paramLong1, long paramLong2)
  {
    this.mContext.setCurSize(paramLong1);
    this.mContext.setTotalSize(paramLong2);
    this.mJob.notifyProgressChanged(paramLong1, paramLong2);
  }
  
  public int transfer()
  {
    int j = doTransfer();
    int i = j;
    if (j == -10002)
    {
      i = j;
      if (this.mContext.getTotalSize() != 0L)
      {
        i = j;
        if (this.mContext.getTotalSize() == this.mContext.getCurSize())
        {
          Log.i("HttpDownloadTransfer", "user canceled a finished job!");
          i = 0;
        }
      }
    }
    j = i;
    if (i == 0) {
      j = moveToTarget();
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.job.transfer.HttpDownloadTransfer
 * JD-Core Version:    0.7.0.1
 */