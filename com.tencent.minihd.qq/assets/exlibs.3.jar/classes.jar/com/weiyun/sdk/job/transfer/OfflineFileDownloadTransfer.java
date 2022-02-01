package com.weiyun.sdk.job.transfer;

import com.weiyun.sdk.job.BaseDownloadJob;
import com.weiyun.sdk.job.DownloadJobContext;
import com.weiyun.sdk.job.af.AddressFetcher.TransferAddress;
import java.net.HttpURLConnection;
import java.net.ProtocolException;

public class OfflineFileDownloadTransfer
  extends BaseDownloadTransfer
{
  public OfflineFileDownloadTransfer(AddressFetcher.TransferAddress paramTransferAddress, DownloadJobContext paramDownloadJobContext, BaseDownloadJob paramBaseDownloadJob)
  {
    super(paramTransferAddress, paramDownloadJobContext, paramBaseDownloadJob);
  }
  
  protected void setHttpHeader(HttpURLConnection paramHttpURLConnection)
    throws ProtocolException
  {
    super.setHttpHeader(paramHttpURLConnection);
    paramHttpURLConnection.setRequestProperty("Range", this.mContext.getCurSize() + "-");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.job.transfer.OfflineFileDownloadTransfer
 * JD-Core Version:    0.7.0.1
 */