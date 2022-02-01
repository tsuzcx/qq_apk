package com.weiyun.sdk.job.pb;

import com.weiyun.sdk.job.BaseDownloadJob;
import com.weiyun.sdk.job.DownloadJobContext;
import com.weiyun.sdk.job.af.AddressFetcher;
import com.weiyun.sdk.job.af.AddressFetcher.TransferAddress;
import com.weiyun.sdk.job.af.pb.PbOfflineFileAddressFetcher;
import com.weiyun.sdk.job.transfer.OfflineFileDownloadTransfer;
import com.weiyun.sdk.job.transfer.Transfer;

public class OfflineFileDownloadJob
  extends BaseDownloadJob
{
  protected final int mOfflineFileType;
  
  public OfflineFileDownloadJob(long paramLong, DownloadJobContext paramDownloadJobContext, int paramInt)
  {
    super(paramLong, paramDownloadJobContext);
    this.mOfflineFileType = paramInt;
  }
  
  protected boolean checkContent()
  {
    if ((this.mJobContext == null) || (this.mJobContext.getFileId() == null) || (this.mJobContext.getFileName() == null) || (this.mJobContext.getDestDirectoryPath() == null) || (this.mJobContext.getDestFileName() == null) || (this.mJobContext.getDestFilePath() == null) || (this.mJobContext.getDataFilePath() == null))
    {
      setLastErrorNo(-10001);
      return false;
    }
    return true;
  }
  
  protected AddressFetcher createDownloadAddressFetcher()
  {
    return new PbOfflineFileAddressFetcher(this.mJobContext.getUin(), this.mJobContext.getFileId(), this.mOfflineFileType);
  }
  
  protected Transfer createTransfer(AddressFetcher.TransferAddress paramTransferAddress)
  {
    return new OfflineFileDownloadTransfer(paramTransferAddress, this.mJobContext, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.job.pb.OfflineFileDownloadJob
 * JD-Core Version:    0.7.0.1
 */