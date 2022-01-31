package com.tencent.mars.cdn;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mars.Mars;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.vfs.b;
import java.io.File;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class CdnLogic
{
  public static final int HIT_FILEID = 1;
  public static final int HIT_UPLOADCHECKMD5 = 2;
  public static final int HIT_UPLOADWITHMD5 = 3;
  public static final int ImageFormat_HEVC = 2;
  public static final int ImageFormat_JPEG = 1;
  public static final int MediaTypeAppImage = 20301;
  public static final int MediaTypeFriendsADImageThumb = 20204;
  public static final int MediaTypeFriendsImageThumb = 20205;
  public static final int MediaTypeFriendsVideoThumbImage = 20250;
  public static final int MediaType_FAVORITE_FILE = 10001;
  public static final int MediaType_FAVORITE_VIDEO = 10002;
  public static final int MediaType_FILE = 5;
  public static final int MediaType_FRIENDS = 20201;
  public static final int MediaType_FRIENDS_Video = 20202;
  public static final int MediaType_FULLSIZEIMAGE = 1;
  public static final int MediaType_GlanceVideo = 90;
  public static final int MediaType_IMAGE = 2;
  public static final int MediaType_SnsAdLangdingPageVideo = 100;
  public static final int MediaType_THUMBIMAGE = 3;
  public static final int MediaType_TinyVideo = 6;
  public static final int MediaType_VIDEO = 4;
  public static final int MediaType_WIMDownload = 19;
  public static final int NO_ERROR = 0;
  public static final int NO_HITCACHE = 0;
  public static final int PreloadMode = 2;
  public static final int StorageMode = 0;
  private static final String TAG = "mars.CdnLogic";
  public static final int VideoFormat_Unknown = 0;
  public static final int VideoFormat_X264 = 1;
  public static final int VideoFormat_X265 = 2;
  public static final int VideoPlayMode = 1;
  public static final String defaultApprovedVideoHosts = "vweixinf.tc.qq.com,szwbwxsns.video.qq.com,szxzwxsns.video.qq.com,szzjwxsns.video.qq.com,shwbwxsns.video.qq.com,shxzwxsns.video.qq.com,shzjwxsns.video.qq.com,wxsnsdy.wxs.qq.com,vweixinthumb.tc.qq.com,wxsnsdythumb.wxs.qq.com,wxappthumb.tc.qq.com,wxapp.tc.qq.com";
  public static final int kAppTypeAdImage = 109;
  public static final int kAppTypeAdVideo = 105;
  public static final int kAppTypeAny = 0;
  public static final int kAppTypeC2C = 1;
  public static final int kAppTypeC2CGroupChat = 2;
  public static final int kAppTypeFavorite = 10;
  public static final int kAppTypeHDVideo = 205;
  public static final int kAppTypeHwPage = 200;
  public static final int kAppTypeMultiJpeg = 101;
  public static final int kAppTypeMultiVCodec = 108;
  public static final int kAppTypeMultiWebp = 104;
  public static final int kAppTypeNearEvent = 201;
  public static final int kAppTypeShop = 200;
  public static final int kAppTypeSingleJpeg = 100;
  public static final int kAppTypeSingleVCodec = 107;
  public static final int kAppTypeSingleWebp = 103;
  public static final int kAppTypeUnknown = -1;
  public static final int kAppTypeVideo = 102;
  public static final int kAppTypeVideoThumb = 150;
  public static final int kAppTypeYunStorage = 202;
  public static final int kBizAny = 0;
  public static final int kBizApp = 4;
  public static final int kBizC2C = 1;
  public static final int kBizFavorite = 2;
  public static final int kBizGeneric = 65535;
  public static final int kBizSns = 3;
  public static final int kBizUnknown = -1;
  public static final int kErrSafeProtoNoAeskey = -21111;
  public static final int kErrUploadHevcIllegal = -5103237;
  public static final int kIpSource_NewDNS = 1;
  public static final int kIpSource_None = 0;
  public static final int kIpSource_SysDNS = 2;
  public static final int kMediaGamePacket = 30002;
  public static final int kMediaLittleAppPacket = 30001;
  public static final int kMediaTypeAdImage = 20204;
  public static final int kMediaTypeAdVideo = 20210;
  public static final int kMediaTypeAny = 0;
  public static final int kMediaTypeAppFile = 20303;
  public static final int kMediaTypeAppVideo = 20302;
  public static final int kMediaTypeBackupFile = 20001;
  public static final int kMediaTypeBeatificFile = 10011;
  public static final int kMediaTypeBigFile = 7;
  public static final int kMediaTypeExposeImage = 11000;
  public static final int kMediaTypeFavoriteBigFile = 10007;
  public static final int kMediaTypeFavoriteFile = 10001;
  public static final int kMediaTypeFavoriteVideo = 10002;
  public static final int kMediaTypeFile = 5;
  public static final int kMediaTypeFriends = 20201;
  public static final int kMediaTypeFriendsVideo = 20202;
  public static final int kMediaTypeFriendsVideoThumbImage = 20250;
  public static final int kMediaTypeFullSizeImage = 1;
  public static final int kMediaTypeHWDevice = 20322;
  public static final int kMediaTypeHWDeviceFile = 20303;
  public static final int kMediaTypeImage = 2;
  public static final int kMediaTypeNearEvent = 20310;
  public static final int kMediaTypeShop = 20301;
  public static final int kMediaTypeSmartHwPage = 20321;
  public static final int kMediaTypeStoryAudio = 40001;
  public static final int kMediaTypeThumbImage = 3;
  public static final int kMediaTypeTinyVideo = 6;
  public static final int kMediaTypeVideo = 4;
  public static final int kMultiImageDownload = 2;
  public static final int kSingleImageDownload = 1;
  
  static
  {
    Object localObject = null;
    try
    {
      ArrayList localArrayList = getLoadLibraries();
      localObject = localArrayList;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        Mars.loadDefaultMarsLibrary();
      }
    }
    Mars.checkLoadedModules(localObject, "mars.CdnLogic");
  }
  
  public static void Initialize(String paramString1, CdnLogic.AppCallback paramAppCallback, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    ab.i("mars.CdnLogic", "init cdnlogic");
    setAppCallback(paramAppCallback);
    onCreate(paramString1);
    setRSAPublicKeyParams(paramString2, paramString3, paramString4);
    setToUserCiper(paramString5);
  }
  
  public static void UnInitialize()
  {
    ab.w("mars.CdnLogic", "uninit cdnlogic");
    setAppCallback(null);
  }
  
  public static native int calcFileCrc32(String paramString);
  
  public static native String calcFileMD5(String paramString);
  
  public static native String calcMP4IdentifyMD5(String paramString);
  
  public static native int cancelDownloadTaskWithResult(String paramString, C2CDownloadResult paramC2CDownloadResult);
  
  public static native void cancelTask(String paramString);
  
  public static native int cancelUploadTaskWithResult(String paramString, CdnLogic.C2CUploadResult paramC2CUploadResult);
  
  public static native String createAeskey();
  
  public static native String createUniqueFilekey(String paramString1, String paramString2);
  
  public static int doCertificateVerify(String paramString, byte[][] paramArrayOfByte)
  {
    ab.i("mars.CdnLogic", "certifivate verify for %s", new Object[] { paramString });
    try
    {
      paramArrayOfByte = X509Util.verifyServerCertificates(paramArrayOfByte, "RSA", paramString);
      ab.i("mars.CdnLogic", "host %s verify result %d, isknownroots %b", new Object[] { paramString, Integer.valueOf(paramArrayOfByte.getStatus()), Boolean.valueOf(paramArrayOfByte.isIssuedByKnownRoot()) });
      int i = paramArrayOfByte.getStatus();
      return i;
    }
    catch (KeyStoreException paramString)
    {
      ab.e("mars.CdnLogic", paramString.getLocalizedMessage());
      return -1;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      ab.e("mars.CdnLogic", paramString.getLocalizedMessage());
      return -1;
    }
    catch (IllegalArgumentException paramString)
    {
      ab.e("mars.CdnLogic", paramString.getLocalizedMessage());
      return -1;
    }
    catch (Exception paramString)
    {
      ab.e("mars.CdnLogic", paramString.getLocalizedMessage());
    }
    return -1;
  }
  
  private static native ArrayList<String> getLoadLibraries();
  
  public static native int getRecentAverageSpeed(int paramInt);
  
  public static native boolean getSnsImagePrivateProtocolAvalible();
  
  public static int getUSBState()
  {
    Object localObject = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    localObject = ah.getContext().registerReceiver(null, (IntentFilter)localObject);
    if (localObject != null) {
      try
      {
        int i = ((Intent)localObject).getIntExtra("plugged", 0);
        return i;
      }
      catch (Exception localException)
      {
        ab.e("mars.CdnLogic", "err:%s", new Object[] { localException.getMessage() });
      }
    }
    return -1;
  }
  
  public static native CdnLogic.CdnTaskStateInfo httpMultiSocketDownloadTaskState(String paramString);
  
  public static int isFileReady(String paramString)
  {
    int i;
    if (!new File(paramString).exists()) {
      i = -1;
    }
    int j;
    do
    {
      return i;
      ab.i("mars.CdnLogic", "checkFileProperty sdcard state ".concat(String.valueOf(h.getExternalStorageState())));
      j = getUSBState();
      i = j;
    } while (2 != j);
    ab.i("mars.CdnLogic", "checkFileProperty usb is connecting PC");
    return j;
  }
  
  public static native boolean isVideoDataAvailable(String paramString, long paramLong1, long paramLong2);
  
  private static native void onCreate(String paramString);
  
  public static native int pauseHttpMultiSocketDownloadTask(String paramString);
  
  public static native int queryDownloadedSize(String paramString, long[] paramArrayOfLong);
  
  public static native long queryFilesizeLimit(int paramInt1, int paramInt2);
  
  public static long queryFreeSpace(String paramString)
  {
    b localb = new b(paramString);
    paramString = localb;
    if (!localb.isDirectory()) {
      paramString = localb.dQI();
    }
    do
    {
      long l = paramString.getUsableSpace();
      if (l > 0L) {
        return l;
      }
      localb = paramString.dQI();
      paramString = localb;
    } while (localb != null);
    return 0L;
  }
  
  public static native boolean queryVideoMoovInfo(CdnLogic.C2CDownloadRequest paramC2CDownloadRequest, long[] paramArrayOfLong);
  
  public static native int requestVideoData(String paramString, long paramLong1, long paramLong2, int paramInt);
  
  public static native int resumeHttpMultiSocketDownloadTask(String paramString);
  
  private static native void setAppCallback(CdnLogic.AppCallback paramAppCallback);
  
  public static native void setCdnInfo(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public static native void setCdnInfoParams(CdnLogic.CdnInfoParams paramCdnInfoParams1, CdnLogic.CdnInfoParams paramCdnInfoParams2, int paramInt);
  
  public static native void setConfig(CdnLogic.Config paramConfig);
  
  public static native void setDebugIP(String paramString);
  
  public static native void setFlowLimitPerHour(int paramInt);
  
  public static native void setLegacyCdnInfo(CdnLogic.CdnInfo paramCdnInfo1, CdnLogic.CdnInfo paramCdnInfo2, CdnLogic.CdnInfo paramCdnInfo3, CdnLogic.CdnInfo paramCdnInfo4, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  private static native void setRSAPublicKeyParams(String paramString1, String paramString2, String paramString3);
  
  public static native void setSnsImagePrivateProtocolAvalible(boolean paramBoolean);
  
  private static native void setToUserCiper(String paramString);
  
  public static native void setUseIPv6Cdn(boolean paramBoolean);
  
  public static native int startC2CDownload(CdnLogic.C2CDownloadRequest paramC2CDownloadRequest, CdnLogic.DownloadCallback paramDownloadCallback);
  
  public static native int startC2CUpload(CdnLogic.C2CUploadRequest paramC2CUploadRequest, CdnLogic.UploadCallback paramUploadCallback);
  
  public static native int startHttpMultiSocketDownloadTask(CdnLogic.C2CDownloadRequest paramC2CDownloadRequest, CdnLogic.DownloadCallback paramDownloadCallback);
  
  public static native int startHttpVideoStreamingDownload(CdnLogic.C2CDownloadRequest paramC2CDownloadRequest, VideoStreamingCallback paramVideoStreamingCallback, CdnLogic.DownloadCallback paramDownloadCallback, int paramInt);
  
  public static native int startHttpsDownload(CdnLogic.C2CDownloadRequest paramC2CDownloadRequest, CdnLogic.DownloadCallback paramDownloadCallback);
  
  public static native int startSNSDownload(CdnLogic.C2CDownloadRequest paramC2CDownloadRequest, VideoStreamingCallback paramVideoStreamingCallback, CdnLogic.DownloadCallback paramDownloadCallback, int paramInt);
  
  public static native int startSSUpload(CdnLogic.C2CUploadRequest paramC2CUploadRequest, CdnLogic.SessionCallback paramSessionCallback, CdnLogic.UploadCallback paramUploadCallback);
  
  public static native int startURLDownload(CdnLogic.C2CDownloadRequest paramC2CDownloadRequest, CdnLogic.DownloadCallback paramDownloadCallback);
  
  public static native int startVideoStreamingDownload(CdnLogic.C2CDownloadRequest paramC2CDownloadRequest, VideoStreamingCallback paramVideoStreamingCallback, CdnLogic.DownloadCallback paramDownloadCallback, int paramInt);
  
  public static native boolean taskExist(String paramString);
  
  public static native void triggerPreConnect(String paramString, String[] paramArrayOfString, boolean paramBoolean);
  
  public static class C2CDownloadResult
  {
    public String argInfo = "";
    public long availableBytes = 0L;
    public int averageConnectCost = 0;
    public int averageRequestCost = 0;
    public int averageRequestSize = 0;
    public int averageSpeed = 0;
    public String batchImageFileKey = "";
    public CdnLogic.BatchSnsReqImageData[] batchImageNeedRetry = null;
    public String batchPicFeedId = "";
    public int cSeqCheck = 0;
    public String clientIP = "";
    public int connectCostTime = 0;
    public boolean crossNet = false;
    public long currentFileSize = 0L;
    public int delayTime = 0;
    public int detailErrorCode = 0;
    public int detailErrorType = 0;
    public int dnsCostTime = 0;
    public long enQueueTime = 0L;
    public long endTime = 0L;
    public int errorCode = 0;
    public long fileSize = 0L;
    public int fileType = 0;
    public String fileid = "";
    public int firstConnectCost = 0;
    public boolean firstRequestCompleted = false;
    public int firstRequestCost = 0;
    public int firstRequestDownloadSize = 0;
    public int firstRequestSize = 0;
    public String httpResponseHeader = "";
    public int httpStatusCode = 0;
    public boolean isResume = false;
    public boolean isSnsImageProtocolAvailable;
    public boolean moovCompleted = false;
    public int moovCost = 0;
    public int moovFailReason = 0;
    public int moovRequestTimes = 0;
    public int moovSize = 0;
    public int netConnectTimes = 0;
    public String picCachePath = "";
    public int picIndex = -1;
    public int previousCompletedSize = 0;
    public String realUsedURL = "";
    public int receiveCostTime = 0;
    public long recvedBytes = 0L;
    public int requestCompletedCount = 0;
    public int requestTimeoutCount = 0;
    public int requestTotalCount = 0;
    public String serverIP = "";
    public long startTime = 0L;
    public String systemErrorDescribe = "";
    public String transforMsg = "";
    public long tryWritenBytes = 0L;
    public boolean usePrivateProtocol = false;
    public String[] usedSvrIps;
    public int videoFormat = 0;
    public int waitResponseCostTime = 0;
    public String xErrorNo = "";
  }
  
  public static abstract interface VideoStreamingCallback
  {
    public abstract void onDataAvailable(String paramString, long paramLong1, long paramLong2);
    
    public abstract void onDownloadToEnd(String paramString, long paramLong1, long paramLong2);
    
    public abstract void onMoovReady(String paramString, long paramLong1, long paramLong2);
    
    public abstract void onPreloadCompletedWithResult(String paramString, long paramLong1, long paramLong2, CdnLogic.C2CDownloadResult paramC2CDownloadResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mars.cdn.CdnLogic
 * JD-Core Version:    0.7.0.1
 */