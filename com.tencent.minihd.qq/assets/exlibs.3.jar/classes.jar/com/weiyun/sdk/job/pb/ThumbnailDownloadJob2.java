package com.weiyun.sdk.job.pb;

import com.weiyun.sdk.IWyFileSystem.ThumbnailType;
import com.weiyun.sdk.job.DownloadJobContext;
import com.weiyun.sdk.job.af.AddressFetcher.DownloadAddress;
import com.weiyun.sdk.job.af.AddressFetcher.TransferAddress;
import com.weiyun.sdk.job.af.DownloadAddressFetcher;
import com.weiyun.sdk.job.af.pb.PbThumbnailAddressFetcher2;
import com.weiyun.sdk.job.transfer.ThumbnailDownloadTransfer;
import com.weiyun.sdk.job.transfer.Transfer;

public class ThumbnailDownloadJob2
  extends DownloadJob
{
  protected final IWyFileSystem.ThumbnailType mThumbnailType;
  
  public ThumbnailDownloadJob2(long paramLong, DownloadJobContext paramDownloadJobContext, int paramInt, IWyFileSystem.ThumbnailType paramThumbnailType)
  {
    super(paramLong, paramDownloadJobContext, paramInt);
    this.mThumbnailType = paramThumbnailType;
  }
  
  public ThumbnailDownloadJob2(long paramLong, DownloadJobContext paramDownloadJobContext, IWyFileSystem.ThumbnailType paramThumbnailType)
  {
    super(paramLong, paramDownloadJobContext);
    this.mThumbnailType = paramThumbnailType;
  }
  
  protected DownloadAddressFetcher createDownloadAddressFetcher()
  {
    return new PbThumbnailAddressFetcher2(this.mJobContext.getFileId(), this.mJobContext.getFileName(), this.mSource, this.mThumbnailType);
  }
  
  protected Transfer createTransfer(AddressFetcher.TransferAddress paramTransferAddress)
  {
    return new ThumbnailDownloadTransfer((AddressFetcher.DownloadAddress)paramTransferAddress, this.mJobContext, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.job.pb.ThumbnailDownloadJob2
 * JD-Core Version:    0.7.0.1
 */