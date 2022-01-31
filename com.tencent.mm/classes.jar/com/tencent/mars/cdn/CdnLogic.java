package com.tencent.mars.cdn;

import com.tencent.mars.Mars;
import com.tencent.mm.sdk.platformtools.y;
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
  private static CdnLogic.ICallback callBack;
  public static final String defaultApprovedVideoHosts = "vweixinf.tc.qq.com,szwbwxsns.video.qq.com,szxzwxsns.video.qq.com,szzjwxsns.video.qq.com,shwbwxsns.video.qq.com,shxzwxsns.video.qq.com,shzjwxsns.video.qq.com,wxsnsdy.wxs.qq.com,vweixinthumb.tc.qq.com,wxsnsdythumb.wxs.qq.com,wxappthumb.tc.qq.com,wxapp.tc.qq.com";
  public static final int kAppTypeAdImage = 109;
  public static final int kAppTypeAdVideo = 105;
  public static final int kAppTypeAny = 0;
  public static final int kAppTypeC2C = 1;
  public static final int kAppTypeC2CGroupChat = 2;
  public static final int kAppTypeFavorite = 10;
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
  public static final int kMediaTypeThumbImage = 3;
  public static final int kMediaTypeTinyVideo = 6;
  public static final int kMediaTypeVideo = 4;
  
  static
  {
    try
    {
      ArrayList localArrayList = getLoadLibraries();
      Mars.checkLoadedModules(localArrayList, "mars.CdnLogic");
      callBack = null;
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        Object localObject = null;
        Mars.loadDefaultMarsLibrary();
      }
    }
  }
  
  public static void ReportFlow(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (callBack == null) {
      return;
    }
    callBack.ReportFlow(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static void RequestGetCDN(int paramInt)
  {
    if (callBack == null) {
      return;
    }
    callBack.RequestGetCDN(paramInt);
  }
  
  public static native int cancelDownloadTaskWithResult(String paramString, CdnLogic.C2CDownloadResult paramC2CDownloadResult);
  
  public static native void cancelTask(String paramString);
  
  public static native int cancelUploadTaskWithResult(String paramString, CdnLogic.C2CUploadResult paramC2CUploadResult);
  
  public static native String createAeskey();
  
  private static byte[] decodeSessionResponseBuf(String paramString, byte[] paramArrayOfByte)
  {
    if (callBack == null) {
      return null;
    }
    return callBack.decodeSessionResponseBuf(paramString, paramArrayOfByte);
  }
  
  public static int doCertificateVerify(String paramString, byte[][] paramArrayOfByte)
  {
    y.i("mars.CdnLogic", "certifivate verify for %s", new Object[] { paramString });
    try
    {
      paramArrayOfByte = X509Util.verifyServerCertificates(paramArrayOfByte, "RSA", paramString);
      y.i("mars.CdnLogic", "host %s verify result %d, isknownroots %b", new Object[] { paramString, Integer.valueOf(paramArrayOfByte.getStatus()), Boolean.valueOf(paramArrayOfByte.isIssuedByKnownRoot()) });
      int i = paramArrayOfByte.getStatus();
      return i;
    }
    catch (KeyStoreException paramString)
    {
      y.e("mars.CdnLogic", paramString.getLocalizedMessage());
      return -1;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      y.e("mars.CdnLogic", paramString.getLocalizedMessage());
      return -1;
    }
    catch (IllegalArgumentException paramString)
    {
      y.e("mars.CdnLogic", paramString.getLocalizedMessage());
      return -1;
    }
    catch (Exception paramString)
    {
      y.e("mars.CdnLogic", paramString.getLocalizedMessage());
    }
    return -1;
  }
  
  public static native int getFileCrc32(String paramString);
  
  public static native String getFileMD5(String paramString);
  
  private static native ArrayList<String> getLoadLibraries();
  
  public static native String getMP4IdentifyMD5(String paramString);
  
  private static byte[] getSessionRequestBuf(String paramString, byte[] paramArrayOfByte)
  {
    if (callBack == null) {
      return null;
    }
    return callBack.getSessionRequestBuf(paramString, paramArrayOfByte);
  }
  
  public static native CdnLogic.CdnTaskStateInfo httpMultiSocketDownloadTaskState(String paramString);
  
  public static native boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2);
  
  private static void onC2CDownloadCompleted(String paramString, CdnLogic.C2CDownloadResult paramC2CDownloadResult)
  {
    if (callBack == null) {
      return;
    }
    callBack.onC2CDownloadCompleted(paramString, paramC2CDownloadResult);
  }
  
  private static void onC2CUploadCompleted(String paramString, CdnLogic.C2CUploadResult paramC2CUploadResult)
  {
    if (callBack == null) {
      return;
    }
    callBack.onC2CUploadCompleted(paramString, paramC2CUploadResult);
  }
  
  private static void onCheckFileIDCompleted(String paramString, CheckFileIDResult paramCheckFileIDResult)
  {
    if (callBack == null) {
      return;
    }
    callBack.onCheckFileidCompleted(paramString, paramCheckFileIDResult);
  }
  
  public static native void onCreate(String paramString);
  
  public static void onDataAvailable(String paramString, int paramInt1, int paramInt2)
  {
    if (callBack == null) {
      return;
    }
    callBack.onDataAvailable(paramString, paramInt1, paramInt2);
  }
  
  public static void onDownloadToEnd(String paramString, int paramInt1, int paramInt2)
  {
    if (callBack == null) {
      return;
    }
    callBack.onDownloadToEnd(paramString, paramInt1, paramInt2);
  }
  
  public static void onMoovReady(String paramString, int paramInt1, int paramInt2)
  {
    if (callBack == null) {
      return;
    }
    callBack.onMoovReady(paramString, paramInt1, paramInt2);
  }
  
  public static void onPreloadCompleted(String paramString, int paramInt1, int paramInt2)
  {
    if (callBack == null) {
      return;
    }
    callBack.onPreloadCompleted(paramString, paramInt1, paramInt2);
  }
  
  public static void onPreloadCompletedWithResult(String paramString, int paramInt1, int paramInt2, CdnLogic.C2CDownloadResult paramC2CDownloadResult)
  {
    if (callBack == null) {
      return;
    }
    callBack.onPreloadCompletedWithResult(paramString, paramInt1, paramInt2, paramC2CDownloadResult);
  }
  
  private static void onProgressChanged(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (callBack == null) {
      return;
    }
    callBack.onProgressChanged(paramString, paramInt1, paramInt2, paramBoolean);
  }
  
  private static void onRecvedData(String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    if (callBack == null) {
      return;
    }
    callBack.onRecvedData(paramString, paramInt, paramArrayOfByte);
  }
  
  public static native int pauseHttpMultiSocketDownloadTask(String paramString);
  
  public static native boolean queryVideoMoovInfo(CdnLogic.C2CDownloadRequest paramC2CDownloadRequest, long[] paramArrayOfLong);
  
  public static native int requestVideoData(String paramString, int paramInt1, int paramInt2, int paramInt3);
  
  public static String[] resolveHost(String paramString, boolean paramBoolean, int[] paramArrayOfInt)
  {
    if (callBack == null) {
      return null;
    }
    return callBack.resolveHost(paramString, paramBoolean, paramArrayOfInt);
  }
  
  public static native int resumeHttpMultiSocketDownloadTask(String paramString);
  
  public static void setCallBack(CdnLogic.ICallback paramICallback)
  {
    callBack = paramICallback;
  }
  
  public static native void setCdnInfo(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public static native void setCdnInfoParams(CdnLogic.CdnInfoParams paramCdnInfoParams1, CdnLogic.CdnInfoParams paramCdnInfoParams2, int paramInt);
  
  public static native void setConfig(Config paramConfig);
  
  public static native void setDebugIP(String paramString);
  
  public static native void setFlowLimitPerHour(int paramInt);
  
  public static native void setLegacyCdnInfo(CdnLogic.CdnInfo paramCdnInfo1, CdnLogic.CdnInfo paramCdnInfo2, CdnLogic.CdnInfo paramCdnInfo3, CdnLogic.CdnInfo paramCdnInfo4, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public static native void setRSAPublicKeyParams(String paramString1, String paramString2, String paramString3);
  
  public static native void setToUserCiper(String paramString);
  
  public static native int startC2CDownload(CdnLogic.C2CDownloadRequest paramC2CDownloadRequest);
  
  public static native int startC2CUpload(CdnLogic.C2CUploadRequest paramC2CUploadRequest);
  
  public static native int startCheckFileId(CdnLogic.CheckFileIdRequest paramCheckFileIdRequest);
  
  public static native int startHttpMultiSocketDownloadTask(CdnLogic.C2CDownloadRequest paramC2CDownloadRequest);
  
  public static native int startHttpVideoStreamingDownload(CdnLogic.C2CDownloadRequest paramC2CDownloadRequest, int paramInt);
  
  public static native int startHttpsDownload(CdnLogic.C2CDownloadRequest paramC2CDownloadRequest);
  
  public static native int startSNSDownload(CdnLogic.C2CDownloadRequest paramC2CDownloadRequest, int paramInt);
  
  public static native int startURLDownload(CdnLogic.C2CDownloadRequest paramC2CDownloadRequest);
  
  public static native int startVideoStreamingDownload(CdnLogic.C2CDownloadRequest paramC2CDownloadRequest, int paramInt);
  
  public static native void triggerPreConnect(String paramString, String[] paramArrayOfString, boolean paramBoolean);
  
  public static class CheckFileIDResult
  {
    public int errorCode = 0;
    public int[] existFlags = null;
    public CdnLogic.CheckFileidItem[] fileItems = null;
    public String fileKey = "";
    public String[] newFileids = null;
  }
  
  public static class Config
  {
    public int AckSlice = 8192;
    public String ApprovedVideoHosts = "vweixinf.tc.qq.com,szwbwxsns.video.qq.com,szxzwxsns.video.qq.com,szzjwxsns.video.qq.com,shwbwxsns.video.qq.com,shxzwxsns.video.qq.com,shzjwxsns.video.qq.com,wxsnsdy.wxs.qq.com,vweixinthumb.tc.qq.com,wxsnsdythumb.wxs.qq.com,wxappthumb.tc.qq.com,wxapp.tc.qq.com";
    public int C2COverloadDelaySeconds = 10;
    public int EnableCDNVerifyConnect = 1;
    public int EnableCDNVideoRedirectOC = 1;
    public int EnableSafeCDN = 0;
    public int EnableSnsImageDownload = 0;
    public int EnableSnsStreamDownload = 0;
    public int EnableStreamUploadVideo = 1;
    public int MobileEtl = 70;
    public int Ptl = 35;
    public int SNSOverloadDelaySeconds = 60;
    public int UseDynamicETL = 0;
    public int UseStreamCDN = 1;
    public int WifiEtl = 90;
    public boolean onlyrecvPtl = false;
    public boolean onlysendETL = false;
    
    public String toString()
    {
      return String.format("wifietl:%d, nowifietl:%d,ptl:%d,UseStreamCDN:%d,onlysendetl:%b,onlyrecvptl:%b,ackslice:%d,enableverify:%d,enableoc:%d,enablevideo:%d,dynamicetl:%b,c2coverload:%d,snsoverload:%d,safecdn:%d,snsstream:%d, snsimage:%d", new Object[] { Integer.valueOf(this.WifiEtl), Integer.valueOf(this.MobileEtl), Integer.valueOf(this.Ptl), Integer.valueOf(this.UseStreamCDN), Boolean.valueOf(this.onlysendETL), Boolean.valueOf(this.onlyrecvPtl), Integer.valueOf(this.AckSlice), Integer.valueOf(this.EnableCDNVerifyConnect), Integer.valueOf(this.EnableCDNVideoRedirectOC), Integer.valueOf(this.EnableStreamUploadVideo), Integer.valueOf(this.UseDynamicETL), Integer.valueOf(this.C2COverloadDelaySeconds), Integer.valueOf(this.SNSOverloadDelaySeconds), Integer.valueOf(this.EnableSafeCDN), Integer.valueOf(this.EnableSnsStreamDownload), Integer.valueOf(this.EnableSnsImageDownload) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mars.cdn.CdnLogic
 * JD-Core Version:    0.7.0.1
 */