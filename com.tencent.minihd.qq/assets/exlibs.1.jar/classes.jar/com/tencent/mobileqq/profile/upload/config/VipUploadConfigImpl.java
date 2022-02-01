package com.tencent.mobileqq.profile.upload.config;

import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.uinterface.IUploadConfig.UploadImageSize;
import common.config.service.QzoneConfig;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.QUA;

public class VipUploadConfigImpl
  implements IUploadConfig
{
  private long a;
  
  public VipUploadConfigImpl(long paramLong)
  {
    this.a = paramLong;
  }
  
  public int getAlbumMaxPhotoCount()
  {
    return QzoneConfig.a().a("PhotoUpload", "AlbumMaxPhotoCount", 10000);
  }
  
  public int getAppId()
  {
    return 1000027;
  }
  
  public String getBackupIp1()
  {
    return QzoneConfig.a().a("PhotoSvrList", "BackupIP1");
  }
  
  public String getBackupIp2()
  {
    return QzoneConfig.a().a("PhotoSvrList", "BackupIP2");
  }
  
  public int getCompressToWebpFlag()
  {
    return QzoneConfig.a().a("PhotoUpload", "CompressToWebp", 0);
  }
  
  public int getConnectTimeout()
  {
    return QzoneConfig.a().a("PhotoUpload", "ConnectTimeout", 20);
  }
  
  public long getCurrentUin()
  {
    return this.a;
  }
  
  public int getDataTimeout()
  {
    return QzoneConfig.a().a("PhotoUpload", "DataTimeout", 60);
  }
  
  public String getDescription()
  {
    return QzoneConfig.a().a("PhotoUpload", "Description", null);
  }
  
  public String getDeviceInfo()
  {
    return PlatformInfor.a().e();
  }
  
  public int getDoNotFragment()
  {
    return QzoneConfig.a().a("WNSSettting", "ip_no_pmtu_disc", 1);
  }
  
  public String getExifTagCode(String paramString)
  {
    return null;
  }
  
  public int getMaxConcurrentNum()
  {
    return QzoneConfig.a().a("PhotoUpload", "MaxConcurrentNum", 1);
  }
  
  public int getMaxNum()
  {
    return QzoneConfig.a().a("PhotoUpload", "MaxNum", 50);
  }
  
  public String getMaxSegmentSizeArray()
  {
    return null;
  }
  
  public String getOptimumIp1()
  {
    return QzoneConfig.a().a("PhotoSvrList", "OptimumIP1");
  }
  
  public String getOptimumIp2()
  {
    return QzoneConfig.a().a("PhotoSvrList", "OptimumIP2");
  }
  
  public String getPhotoUrl1()
  {
    return QzoneConfig.a().a("PhotoSvrList", "PhotoURL1", "qzfileup.qq.com");
  }
  
  public String getPhotoUrl2()
  {
    return QzoneConfig.a().a("PhotoSvrList", "PhotoURL2", "up.upqzfile.com");
  }
  
  public String getPhotoUrl3()
  {
    return QzoneConfig.a().a("PhotoSvrList", "PhotoURL3", "up.upqzfilebk.com");
  }
  
  public float getPictureQuality(String paramString)
  {
    return 0.0F;
  }
  
  public String getQUA3()
  {
    return QUA.a();
  }
  
  public long getRecentRouteExpire()
  {
    return 604800000L;
  }
  
  public int getResendCount()
  {
    return QzoneConfig.a().a("PhotoUpload", "RetryMaxNum", 3);
  }
  
  public int getTestServer()
  {
    return 0;
  }
  
  public int getTimeoutRetryCount()
  {
    return QzoneConfig.a().a("PhotoUpload", "TimeoutRetryCount", 3);
  }
  
  public IUploadConfig.UploadImageSize getUploadImageSize(IUploadConfig.UploadImageSize paramUploadImageSize, int paramInt, AbstractUploadTask paramAbstractUploadTask)
  {
    return new IUploadConfig.UploadImageSize(640, 1136, 100);
  }
  
  public String getUploadPort()
  {
    return QzoneConfig.a().a("PhotoSvrList", "UploadPort", "80,443,8080,14000");
  }
  
  public int getVideoFileRetryCount()
  {
    return QzoneConfig.a().a("PhotoUpload", "VideoFileRetryCount", 3);
  }
  
  public int getVideoPartConcurrentCount()
  {
    return QzoneConfig.a().a("PhotoUpload", "VideoPartConcurrentCount", 2);
  }
  
  public int getVideoPartRetryCount()
  {
    return QzoneConfig.a().a("PhotoUpload", "VideoPartRetryCount", 3);
  }
  
  public int getVideoPartSize()
  {
    return QzoneConfig.a().a("PhotoUpload", "VideoPartSize", 262144);
  }
  
  public int getVideoPartSizeFor2G()
  {
    return QzoneConfig.a().a("PhotoUpload", "VideoPartSizeFor2G", 65536);
  }
  
  public int getVideoPartSizeFor3G()
  {
    return QzoneConfig.a().a("PhotoUpload", "VideoPartSizeFor3G", 131072);
  }
  
  public int getWifiOperator()
  {
    return QzoneConfig.a().a("ExtraConfig", "WifiCarrierType", 0);
  }
  
  public boolean isReleaseMode()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.profile.upload.config.VipUploadConfigImpl
 * JD-Core Version:    0.7.0.1
 */