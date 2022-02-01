package com.weiyun.sdk.job.transfer;

import com.weiyun.sdk.job.BaseDownloadJob;
import com.weiyun.sdk.job.DownloadJobContext;
import com.weiyun.sdk.job.af.AddressFetcher.DownloadAddress;
import java.net.HttpURLConnection;
import java.net.ProtocolException;

public class DownloadTransfer
  extends BaseDownloadTransfer
{
  public DownloadTransfer(AddressFetcher.DownloadAddress paramDownloadAddress, DownloadJobContext paramDownloadJobContext, BaseDownloadJob paramBaseDownloadJob)
  {
    super(paramDownloadAddress, paramDownloadJobContext, paramBaseDownloadJob);
  }
  
  protected boolean isSupportContinueInterruption()
  {
    return true;
  }
  
  protected boolean isSupportSplitDownload()
  {
    return true;
  }
  
  protected void setHttpHeader(HttpURLConnection paramHttpURLConnection)
    throws ProtocolException
  {
    super.setHttpHeader(paramHttpURLConnection);
    AddressFetcher.DownloadAddress localDownloadAddress = (AddressFetcher.DownloadAddress)this.mDownloadAddress;
    long l;
    if (usingSplitDownload())
    {
      l = this.mContext.getCurSize() + getSplitSize() - 1L;
      if ((this.mContext.getTotalSize() > 0L) && (l >= this.mContext.getTotalSize())) {
        paramHttpURLConnection.setRequestProperty("Range", "bytes=" + this.mContext.getCurSize() + "-");
      }
    }
    for (;;)
    {
      paramHttpURLConnection.setRequestProperty("Cookie", localDownloadAddress.getCookieName() + "=" + localDownloadAddress.getCookieValue());
      return;
      paramHttpURLConnection.setRequestProperty("Range", "bytes=" + this.mContext.getCurSize() + "-" + l);
      continue;
      paramHttpURLConnection.setRequestProperty("Range", "bytes=" + this.mContext.getCurSize() + "-");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.job.transfer.DownloadTransfer
 * JD-Core Version:    0.7.0.1
 */