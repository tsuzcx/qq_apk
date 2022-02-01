package com.weiyun.sdk.job.af.pb;

import com.weiyun.sdk.IWyFileSystem.ThumbnailType;
import com.weiyun.sdk.job.af.AddressFetcher.DownloadAddress;
import com.weiyun.sdk.job.af.AddressFetcher.OfflineFileThumbnailDownloadAddress;
import com.weiyun.sdk.util.ThumbnailUtils;

public class PbOfflineFileThunbnailAddressFetcher
  extends PbOfflineFileAddressFetcher
{
  protected final IWyFileSystem.ThumbnailType mThumbnailType;
  
  public PbOfflineFileThunbnailAddressFetcher(long paramLong, String paramString, int paramInt, IWyFileSystem.ThumbnailType paramThumbnailType)
  {
    super(paramLong, paramString, paramInt);
    this.mThumbnailType = paramThumbnailType;
  }
  
  protected AddressFetcher.DownloadAddress createDownloadAddress(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    return new AddressFetcher.OfflineFileThumbnailDownloadAddress(paramString1, paramInt, paramString3, paramString2, ThumbnailUtils.getThumbnailSpec(this.mThumbnailType));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.job.af.pb.PbOfflineFileThunbnailAddressFetcher
 * JD-Core Version:    0.7.0.1
 */