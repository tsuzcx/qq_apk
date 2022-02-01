package com.tencent.mars.cdn;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
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
  public static final int MediaType_ChatVoice = 15;
  public static final int MediaType_F2F_VOICE_RESOURCE = 101;
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
  public static final int kAppTypeEmoji = 110;
  public static final int kAppTypeFavorite = 10;
  public static final int kAppTypeFestivalImage = 257;
  public static final int kAppTypeFestivalVideo = 258;
  public static final int kAppTypeFinderVideo = 251;
  public static final int kAppTypeHDVideo = 205;
  public static final int kAppTypeHwPage = 200;
  public static final int kAppTypeMultiJpeg = 101;
  public static final int kAppTypeMultiVCodec = 108;
  public static final int kAppTypeMultiWebp = 104;
  public static final int kAppTypeNearEvent = 201;
  public static final int kAppTypeP2021 = 255;
  public static final int kAppTypeSelfieEmoji = 111;
  public static final int kAppTypeShop = 200;
  public static final int kAppTypeSingleJpeg = 100;
  public static final int kAppTypeSingleVCodec = 107;
  public static final int kAppTypeSingleWebp = 103;
  public static final int kAppTypeUnknown = -1;
  public static final int kAppTypeUserStatus = 256;
  public static final int kAppTypeVideo = 102;
  public static final int kAppTypeVideoThumb = 150;
  public static final int kAppTypeYunStorage = 202;
  public static final int kBizAny = 0;
  public static final int kBizApp = 4;
  public static final int kBizC2C = 1;
  public static final int kBizDC = 5;
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
  public static final int kMediaTypeAppImageStorage = 20304;
  public static final int kMediaTypeAppVideo = 20302;
  public static final int kMediaTypeBackupFile = 20001;
  public static final int kMediaTypeBeatificFile = 10011;
  public static final int kMediaTypeBigFile = 7;
  public static final int kMediaTypeEmojiGIF = 20402;
  public static final int kMediaTypeEmojiNormal = 20401;
  public static final int kMediaTypeEmojiWXAM = 20403;
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
  public static final int kNetTypeDisconnected = -1;
  public static final int kNetTypeMobile = 2;
  public static final int kNetTypeOther = 3;
  public static final int kNetTypeWifi = 1;
  public static final int kSingleImageDownload = 1;
  
  public static void InitSavePath(String paramString, AppCallback paramAppCallback)
  {
    setAppCallback(paramAppCallback);
    onCreate(paramString);
  }
  
  public static void Initialize(String paramString1, AppCallback paramAppCallback, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    Log.i("mars.CdnLogic", "init cdnlogic");
    setAppCallback(paramAppCallback);
    onCreate(y.n(paramString1, true));
    setRSAPublicKeyParams(paramString2, paramString3, paramString4);
    setToUserCiper(paramString5);
  }
  
  public static void UnInitialize()
  {
    Log.w("mars.CdnLogic", "uninit cdnlogic");
    setAppCallback(null);
  }
  
  public static native boolean allowBatchImageDownload();
  
  public static native int calcFileCrc32(String paramString);
  
  public static native String calcFileMD5(String paramString);
  
  public static native String calcMP4IdentifyMD5(String paramString);
  
  public static native int cancelDownloadTaskWithResult(String paramString, C2CDownloadResult paramC2CDownloadResult);
  
  public static native void cancelTask(String paramString);
  
  public static native int cancelUploadTaskWithResult(String paramString, C2CUploadResult paramC2CUploadResult);
  
  public static native String createAeskey();
  
  public static native String createUniqueFilekey(String paramString1, String paramString2);
  
  public static int doCertificateVerify(String paramString, byte[][] paramArrayOfByte)
  {
    Log.i("mars.CdnLogic", "certifivate verify for %s", new Object[] { paramString });
    try
    {
      paramArrayOfByte = X509Util.verifyServerCertificates(paramArrayOfByte, "RSA", paramString);
      Log.i("mars.CdnLogic", "host %s verify result %d, isknownroots %b", new Object[] { paramString, Integer.valueOf(paramArrayOfByte.getStatus()), Boolean.valueOf(paramArrayOfByte.isIssuedByKnownRoot()) });
      int i = paramArrayOfByte.getStatus();
      return i;
    }
    catch (KeyStoreException paramString)
    {
      Log.e("mars.CdnLogic", paramString.getLocalizedMessage());
      return -1;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      Log.e("mars.CdnLogic", paramString.getLocalizedMessage());
      return -1;
    }
    catch (IllegalArgumentException paramString)
    {
      Log.e("mars.CdnLogic", paramString.getLocalizedMessage());
      return -1;
    }
    catch (Exception paramString)
    {
      Log.e("mars.CdnLogic", paramString.getLocalizedMessage());
    }
    return -1;
  }
  
  public static CertVerifyResult doCertificateVerifyWithDetail(String paramString, byte[][] paramArrayOfByte)
  {
    Log.i("mars.CdnLogic", "certifivate verify for %s", new Object[] { paramString });
    try
    {
      paramArrayOfByte = X509Util.verifyServerCertificates(paramArrayOfByte, "RSA", paramString);
      CertVerifyResult localCertVerifyResult = new CertVerifyResult();
      localCertVerifyResult.status = paramArrayOfByte.getStatus();
      localCertVerifyResult.isIssuedByKnownRoot = paramArrayOfByte.isIssuedByKnownRoot();
      localCertVerifyResult.certificateChain = paramArrayOfByte.getCertificateChainEncoded();
      paramArrayOfByte.getCertificateChainEncoded();
      Log.i("mars.CdnLogic", "host %s verify result %d, isknownroots %b", new Object[] { paramString, Integer.valueOf(paramArrayOfByte.getStatus()), Boolean.valueOf(paramArrayOfByte.isIssuedByKnownRoot()) });
      return localCertVerifyResult;
    }
    catch (KeyStoreException paramString)
    {
      Log.e("mars.CdnLogic", paramString.getLocalizedMessage());
      paramString = new CertVerifyResult();
      paramString.status = -1;
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      Log.e("mars.CdnLogic", paramString.getLocalizedMessage());
      paramString = new CertVerifyResult();
      paramString.status = -1;
      return paramString;
    }
    catch (IllegalArgumentException paramString)
    {
      Log.e("mars.CdnLogic", paramString.getLocalizedMessage());
      paramString = new CertVerifyResult();
      paramString.status = -1;
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.e("mars.CdnLogic", paramString.getLocalizedMessage());
      paramString = new CertVerifyResult();
      paramString.status = -1;
    }
    return paramString;
  }
  
  private static native ArrayList<String> getLoadLibraries();
  
  public static native int getRecentAverageSpeed(int paramInt);
  
  public static native int getRecentAverageSpeed2(int paramInt1, int paramInt2);
  
  public static native CdnLogic.DownloadInfo getRecentDownloadInfo(int paramInt1, int paramInt2, int paramInt3);
  
  public static native boolean getSnsImagePrivateProtocolAvalible();
  
  public static String getSystemProperty(String paramString)
  {
    return System.getProperty(paramString);
  }
  
  public static native int getTaskRecentAverageSpeed(String paramString, int paramInt1, int paramInt2);
  
  public static int getUSBState()
  {
    Object localObject = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    localObject = MMApplicationContext.getContext().registerReceiver(null, (IntentFilter)localObject);
    if (localObject != null) {
      try
      {
        int i = ((Intent)localObject).getIntExtra("plugged", 0);
        return i;
      }
      catch (Exception localException)
      {
        Log.e("mars.CdnLogic", "err:%s", new Object[] { localException.getMessage() });
      }
    }
    return -1;
  }
  
  public static native CdnLogic.CdnTaskStateInfo httpMultiSocketDownloadTaskState(String paramString);
  
  public static int isFileReady(String paramString)
  {
    int i;
    if (!new u(paramString).jKS()) {
      i = -1;
    }
    int j;
    do
    {
      return i;
      Log.i("mars.CdnLogic", "checkFileProperty sdcard state ".concat(String.valueOf(g.aQd())));
      j = getUSBState();
      i = j;
    } while (2 != j);
    Log.i("mars.CdnLogic", "checkFileProperty usb is connecting PC");
    return j;
  }
  
  public static native boolean isVideoDataAvailable(String paramString, long paramLong1, long paramLong2);
  
  private static native void onCreate(String paramString);
  
  public static native int pauseHttpMultiSocketDownloadTask(String paramString);
  
  public static native int queryContinuousSize(String paramString, long paramLong, long[] paramArrayOfLong);
  
  public static native int queryDownloadedSize(String paramString, long[] paramArrayOfLong);
  
  public static native long queryFilesizeLimit(int paramInt1, int paramInt2);
  
  public static long queryFreeSpace(String paramString)
  {
    u localu = new u(paramString);
    paramString = localu;
    if (!localu.isDirectory()) {
      paramString = localu.jKP();
    }
    do
    {
      long l = paramString.jLa();
      if (l > 0L) {
        return l;
      }
      localu = paramString.jKP();
      paramString = localu;
    } while (localu != null);
    return 0L;
  }
  
  public static native String queryM3U8Data(String paramString);
  
  public static native boolean queryVideoMoovInfo(C2CDownloadRequest paramC2CDownloadRequest, long[] paramArrayOfLong);
  
  public static native int requestVideoData(String paramString, long paramLong1, long paramLong2, int paramInt);
  
  public static native int resumeHttpMultiSocketDownloadTask(String paramString);
  
  private static native void setAppCallback(AppCallback paramAppCallback);
  
  public static native void setCdnInfo(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public static native void setCdnInfoParams(CdnLogic.CdnInfoParams paramCdnInfoParams1, CdnLogic.CdnInfoParams paramCdnInfoParams2, int paramInt);
  
  public static native void setConfig(Config paramConfig);
  
  public static native void setDebugIP(String paramString);
  
  public static native void setFlowLimitPerHour(int paramInt);
  
  public static native void setLegacyCdnInfo(CdnInfo paramCdnInfo1, CdnInfo paramCdnInfo2, CdnInfo paramCdnInfo3, CdnInfo paramCdnInfo4, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  private static native void setRSAPublicKeyParams(String paramString1, String paramString2, String paramString3);
  
  public static native void setSnsImagePrivateProtocolAvalible(boolean paramBoolean);
  
  public static native void setSnsImageStreamProtocolAvalible(boolean paramBoolean);
  
  private static native void setToUserCiper(String paramString);
  
  public static native void setUseIPv6Cdn(boolean paramBoolean);
  
  public static native int startC2CDownload(C2CDownloadRequest paramC2CDownloadRequest, CdnLogic.DownloadCallback paramDownloadCallback);
  
  public static native int startC2CUpload(C2CUploadRequest paramC2CUploadRequest, UploadCallback paramUploadCallback);
  
  public static native int startCronetFileDownload(C2CDownloadRequest paramC2CDownloadRequest, CdnLogic.DownloadCallback paramDownloadCallback);
  
  public static native int startCronetSimpleRequest(C2CDownloadRequest paramC2CDownloadRequest, CdnLogic.DownloadCallback paramDownloadCallback);
  
  public static native int startFtnUpload(C2CUploadRequest paramC2CUploadRequest, UploadCallback paramUploadCallback);
  
  public static native int startHttpMultiSocketDownloadTask(C2CDownloadRequest paramC2CDownloadRequest, CdnLogic.DownloadCallback paramDownloadCallback);
  
  public static native int startHttpVideoStreamingDownload(C2CDownloadRequest paramC2CDownloadRequest, VideoStreamingCallback paramVideoStreamingCallback, CdnLogic.DownloadCallback paramDownloadCallback, int paramInt);
  
  public static native int startHttpsDownload(C2CDownloadRequest paramC2CDownloadRequest, CdnLogic.DownloadCallback paramDownloadCallback);
  
  public static native int startSNSDownload(C2CDownloadRequest paramC2CDownloadRequest, VideoStreamingCallback paramVideoStreamingCallback, CdnLogic.DownloadCallback paramDownloadCallback, int paramInt);
  
  public static native int startSSUpload(C2CUploadRequest paramC2CUploadRequest, SessionCallback paramSessionCallback, UploadCallback paramUploadCallback);
  
  public static native int startURLDownload(C2CDownloadRequest paramC2CDownloadRequest, CdnLogic.DownloadCallback paramDownloadCallback);
  
  public static native int startVideoStreamingDownload(C2CDownloadRequest paramC2CDownloadRequest, VideoStreamingCallback paramVideoStreamingCallback, CdnLogic.DownloadCallback paramDownloadCallback, int paramInt);
  
  public static native boolean taskExist(String paramString);
  
  public static native void triggerPreConnect(String paramString, String[] paramArrayOfString, boolean paramBoolean);
  
  public static abstract interface AppCallback
  {
    public abstract void onBadNetworkProbed();
    
    public abstract void reportFlow(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
    
    public abstract void requestGetCDN(int paramInt);
    
    public abstract String[] resolveHost(String paramString, boolean paramBoolean, int[] paramArrayOfInt);
  }
  
  public static class BatchSnsReqImageData
  {
    public String decryptKey = "";
    public String fileKey = "";
    public String imageCachePath = "";
    public int picIndex = 0;
    public boolean retry = true;
    public int totalFileSize = 0;
    public String url = "";
  }
  
  public static class C2CDownloadRequest
  {
    public String aeskey = "";
    public boolean allow_mobile_net_download = false;
    public String argInfo = "";
    public String bakup_url = "";
    public CdnLogic.BatchSnsReqImageData[] batchSnsReqImageDatas = null;
    public String bigfileSignature = "";
    public int certificateVerifyPolicy = 2;
    public int chatType = 0;
    public int concurrentCount = 1;
    public int connectionCount = 1;
    public String customHeader = "";
    public String[] dcIpList = null;
    public int dcIpListSource = 2;
    public String debugIP = "";
    public String expectFileMD5 = "";
    public long expectFileSize = 0L;
    public int expectImageFormat = 1;
    public String fakeBigfileSignature = "";
    public String fakeBigfileSignatureAeskey = "";
    public String feedId = "";
    public int feedPicCount;
    public String fileKey = "";
    public int fileSize = 0;
    public int fileType = 0;
    public String fileid = "";
    public String hlsVideoFlag = "";
    public String host = "";
    public CdnLogic.HostIPHint hostIPHint = null;
    public String httpMethod = "";
    public boolean isAutoStart = false;
    public boolean isColdSnsData = false;
    public boolean isHLSVideo = false;
    public boolean isHotSnsVideo = false;
    public boolean isLargeSVideo = false;
    public boolean isSilentTask = false;
    public boolean isSmallVideo = false;
    public boolean isStorageMode = false;
    public boolean is_resume_task = false;
    public int limitRate = 0;
    public int marscdnAppType = -1;
    public int marscdnBizType = -1;
    public int maxHttpRedirectCount = 3;
    public int maxPCDNConnections = 0;
    public String msgExtra = "";
    public int msgType = 1;
    public boolean needEchoAfterDownSucc = false;
    public String[] ocIpList = null;
    public int ocIpListSource = 2;
    public int pcdnAppID = 0;
    public long preloadMinSize = 0L;
    public int preloadRatio = 30;
    public int queueTimeoutSeconds = 1800;
    public CronetLogic.QuicTaskParams quicTaskParams = null;
    public String referer = "";
    public String requestVideoFlag = "";
    public int requestVideoFormat = 1;
    private String savePath = "";
    public String serialized_verify_headers = "";
    public String signalQuality = "";
    public String snsCipherKey = "";
    public String snsScene = "";
    private String statePath = "";
    public long taskStartTime = 0L;
    public int transforTimeoutSeconds = 600;
    public String url = "";
    public boolean useCronet = false;
    public boolean useMultithread = false;
    public boolean useNewdns = false;
    public String videofileid = "";
    public int videoflagPolicy = 1;
    public boolean wifiAutoStart = false;
    
    public static C2CDownloadRequest createC2C(String paramString1, String paramString2, int paramInt, String paramString3)
    {
      C2CDownloadRequest localC2CDownloadRequest = new C2CDownloadRequest();
      localC2CDownloadRequest.fileid = paramString1;
      localC2CDownloadRequest.aeskey = paramString2;
      localC2CDownloadRequest.fileType = paramInt;
      localC2CDownloadRequest.setSavePath(paramString3);
      localC2CDownloadRequest.marscdnBizType = 1;
      localC2CDownloadRequest.marscdnAppType = 1;
      return localC2CDownloadRequest;
    }
    
    public static C2CDownloadRequest createC2CVideo(String paramString1, String paramString2, int paramInt, String paramString3)
    {
      C2CDownloadRequest localC2CDownloadRequest = new C2CDownloadRequest();
      localC2CDownloadRequest.fileid = paramString1;
      localC2CDownloadRequest.aeskey = paramString2;
      localC2CDownloadRequest.fileType = paramInt;
      localC2CDownloadRequest.setSavePath(paramString3);
      localC2CDownloadRequest.marscdnBizType = 1;
      localC2CDownloadRequest.marscdnAppType = 1;
      return localC2CDownloadRequest;
    }
    
    public static C2CDownloadRequest createFavorite(String paramString1, String paramString2, int paramInt, String paramString3)
    {
      C2CDownloadRequest localC2CDownloadRequest = new C2CDownloadRequest();
      localC2CDownloadRequest.fileid = paramString1;
      localC2CDownloadRequest.aeskey = paramString2;
      localC2CDownloadRequest.fileType = paramInt;
      localC2CDownloadRequest.setSavePath(paramString3);
      localC2CDownloadRequest.marscdnBizType = 2;
      localC2CDownloadRequest.marscdnAppType = 10;
      return localC2CDownloadRequest;
    }
    
    public static C2CDownloadRequest createHttp(String paramString1, String paramString2)
    {
      C2CDownloadRequest localC2CDownloadRequest = new C2CDownloadRequest();
      localC2CDownloadRequest.url = paramString1;
      localC2CDownloadRequest.setSavePath(paramString2);
      localC2CDownloadRequest.marscdnBizType = 4;
      localC2CDownloadRequest.marscdnAppType = 102;
      return localC2CDownloadRequest;
    }
    
    public static C2CDownloadRequest createHttpVideo(String paramString1, String paramString2)
    {
      C2CDownloadRequest localC2CDownloadRequest = new C2CDownloadRequest();
      localC2CDownloadRequest.url = paramString1;
      localC2CDownloadRequest.setSavePath(paramString2);
      localC2CDownloadRequest.marscdnBizType = 4;
      localC2CDownloadRequest.marscdnAppType = 102;
      return localC2CDownloadRequest;
    }
    
    public static C2CDownloadRequest createSNS(String paramString1, int paramInt, String paramString2)
    {
      C2CDownloadRequest localC2CDownloadRequest = new C2CDownloadRequest();
      localC2CDownloadRequest.url = paramString1;
      localC2CDownloadRequest.fileType = paramInt;
      localC2CDownloadRequest.setSavePath(paramString2);
      localC2CDownloadRequest.marscdnBizType = 3;
      localC2CDownloadRequest.marscdnAppType = 100;
      return localC2CDownloadRequest;
    }
    
    public C2CDownloadRequest allow_mobile_net_download(boolean paramBoolean)
    {
      this.allow_mobile_net_download = paramBoolean;
      return this;
    }
    
    public C2CDownloadRequest argInfo(String paramString)
    {
      this.argInfo = paramString;
      return this;
    }
    
    public C2CDownloadRequest bakup_url(String paramString)
    {
      this.bakup_url = paramString;
      return this;
    }
    
    public C2CDownloadRequest bigfileSignature(String paramString)
    {
      this.bigfileSignature = paramString;
      return this;
    }
    
    public C2CDownloadRequest certificateVerifyPolicy(int paramInt)
    {
      this.certificateVerifyPolicy = paramInt;
      return this;
    }
    
    public C2CDownloadRequest chatType(int paramInt)
    {
      this.chatType = paramInt;
      return this;
    }
    
    public C2CDownloadRequest concurrentCount(int paramInt)
    {
      this.concurrentCount = paramInt;
      return this;
    }
    
    public C2CDownloadRequest connectionCount(int paramInt)
    {
      this.connectionCount = paramInt;
      return this;
    }
    
    public C2CDownloadRequest customHeader(String paramString)
    {
      this.customHeader = paramString;
      return this;
    }
    
    public C2CDownloadRequest dcIpList(String[] paramArrayOfString)
    {
      this.dcIpList = paramArrayOfString;
      return this;
    }
    
    public C2CDownloadRequest dcIpListSource(int paramInt)
    {
      this.dcIpListSource = paramInt;
      return this;
    }
    
    public C2CDownloadRequest expectImageFormat(int paramInt)
    {
      this.expectImageFormat = paramInt;
      return this;
    }
    
    public C2CDownloadRequest fakeBigfileSignature(String paramString)
    {
      this.fakeBigfileSignature = paramString;
      return this;
    }
    
    public C2CDownloadRequest fakeBigfileSignatureAeskey(String paramString)
    {
      this.fakeBigfileSignatureAeskey = paramString;
      return this;
    }
    
    public C2CDownloadRequest host(String paramString)
    {
      this.host = paramString;
      return this;
    }
    
    public C2CDownloadRequest isAutoStart(boolean paramBoolean)
    {
      this.isAutoStart = paramBoolean;
      return this;
    }
    
    public C2CDownloadRequest isColdSnsData(boolean paramBoolean)
    {
      this.isColdSnsData = paramBoolean;
      return this;
    }
    
    public C2CDownloadRequest isLargeSVideo(boolean paramBoolean)
    {
      this.isLargeSVideo = paramBoolean;
      return this;
    }
    
    public C2CDownloadRequest isSilentTask(boolean paramBoolean)
    {
      this.isSilentTask = paramBoolean;
      return this;
    }
    
    public C2CDownloadRequest isSmallVideo(boolean paramBoolean)
    {
      this.isSmallVideo = paramBoolean;
      return this;
    }
    
    public C2CDownloadRequest isStorageMode(boolean paramBoolean)
    {
      this.isStorageMode = paramBoolean;
      return this;
    }
    
    public C2CDownloadRequest is_resume_task(boolean paramBoolean)
    {
      this.is_resume_task = paramBoolean;
      return this;
    }
    
    public C2CDownloadRequest limitRate(int paramInt)
    {
      this.limitRate = paramInt;
      return this;
    }
    
    public C2CDownloadRequest maxHttpRedirectCount(int paramInt)
    {
      this.maxHttpRedirectCount = paramInt;
      return this;
    }
    
    public C2CDownloadRequest msgExtra(String paramString)
    {
      this.msgExtra = paramString;
      return this;
    }
    
    public C2CDownloadRequest ocIpList(String[] paramArrayOfString)
    {
      this.ocIpList = paramArrayOfString;
      return this;
    }
    
    public C2CDownloadRequest ocIpListSource(int paramInt)
    {
      this.ocIpListSource = paramInt;
      return this;
    }
    
    public C2CDownloadRequest preloadRatio(int paramInt)
    {
      this.preloadRatio = paramInt;
      return this;
    }
    
    public C2CDownloadRequest queueTimeoutSeconds(int paramInt)
    {
      this.queueTimeoutSeconds = paramInt;
      return this;
    }
    
    public C2CDownloadRequest referer(String paramString)
    {
      this.referer = paramString;
      return this;
    }
    
    public C2CDownloadRequest requestVideoFormat(int paramInt)
    {
      this.requestVideoFormat = paramInt;
      return this;
    }
    
    public C2CDownloadRequest serialized_verify_headers(String paramString)
    {
      this.serialized_verify_headers = paramString;
      return this;
    }
    
    public void setSavePath(String paramString)
    {
      this.savePath = y.n(paramString, false);
    }
    
    public void setStatePath(String paramString)
    {
      this.statePath = y.n(paramString, false);
    }
    
    public C2CDownloadRequest signalQuality(String paramString)
    {
      this.signalQuality = paramString;
      return this;
    }
    
    public C2CDownloadRequest snsCipherKey(String paramString)
    {
      this.snsCipherKey = paramString;
      return this;
    }
    
    public C2CDownloadRequest snsScene(String paramString)
    {
      this.snsScene = paramString;
      return this;
    }
    
    public C2CDownloadRequest statePath(String paramString)
    {
      setStatePath(paramString);
      return this;
    }
    
    public C2CDownloadRequest transforTimeoutSeconds(int paramInt)
    {
      this.transforTimeoutSeconds = paramInt;
      return this;
    }
    
    public C2CDownloadRequest useMultithread(boolean paramBoolean)
    {
      this.useMultithread = paramBoolean;
      return this;
    }
    
    public C2CDownloadRequest videofileid(String paramString)
    {
      this.videofileid = paramString;
      return this;
    }
    
    public C2CDownloadRequest wifiAutoStart(boolean paramBoolean)
    {
      this.wifiAutoStart = paramBoolean;
      return this;
    }
  }
  
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
    public CdnLogic.CronetTaskResult cronetTaskResult = null;
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
    public boolean fromCronet = false;
    public String httpResponseHeader = "";
    public int httpStatusCode = 0;
    public boolean isResume = false;
    public boolean isSnsImageProtocolAvailable;
    public int lastNetType = -1;
    public int lastSvrPort = 0;
    public boolean moovCompleted = false;
    public int moovCost = 0;
    public int moovFailReason = 0;
    public int moovRequestTimes = 0;
    public int moovSize = 0;
    public int netConnectTimes = 0;
    public String picCachePath = "";
    public int picIndex = -1;
    public int previousCompletedSize = 0;
    public String profile = "";
    public String realUsedURL = "";
    public int receiveCostTime = 0;
    public long recvedBytes = 0L;
    public int requestCompletedCount = 0;
    public int requestTimeoutCount = 0;
    public int requestTotalCount = 0;
    public String serverIP = "";
    public long startTime = 0L;
    public int svrFallbackCount = 0;
    public String systemErrorDescribe = "";
    public long taskStartTime = 0L;
    public long traceId = 0L;
    public String traceMsg = "";
    public String transforMsg = "";
    public int transportProtocol = 0;
    public int transportProtocolError = 0;
    public long tryWritenBytes = 0L;
    public boolean usePrivateProtocol = false;
    public String[] usedSvrIps;
    public String videoCdnMsg = "";
    public String videoFlag = "";
    public int videoFormat = 0;
    public int waitResponseCostTime = 0;
    public String xErrorNo = "";
  }
  
  public static class C2CUploadRequest
  {
    public int apptype = 0;
    public String bigfileSignature = "";
    public int bizscene = 0;
    public int chatType = 0;
    public boolean checkExistOnly = false;
    public int concurrentCount = 1;
    public int connectionCount = 1;
    public String customHeader = "";
    public String debugIP = "";
    public String emojiExtinfo = "";
    public boolean enableHitCheck = true;
    public String fakeBigfileSignature = "";
    public String fakeBigfileSignatureAeskey = "";
    public byte[] fileBuffer;
    public String fileKey = "";
    private String filePath = "";
    public int fileSize = 0;
    public int fileType = 0;
    public String filemd5 = "";
    public boolean forceNoSafeCdn = false;
    public String forwardAeskey = "";
    public String forwardFileid = "";
    public String host = "";
    public int isLargeSVideo = 0;
    public boolean isSmallVideo = false;
    public boolean isSnsAdVideo = false;
    public boolean isStorageMode = false;
    public boolean isStreamMedia = false;
    public int lastError = 0;
    public int marscdnBizType = -1;
    public int midfileSize = 0;
    public String midimgPath = "";
    public boolean needCompressImage = false;
    public boolean onlyCheckExist = false;
    public int queueTimeoutSeconds = 1800;
    public boolean sendmsgFromCDN = false;
    public int snsVersion = 0;
    public String statePath = "";
    private String thumbfilePath = "";
    public byte[] thumbnailBuffer;
    public String toUser = "";
    public int transforTimeoutSeconds = 600;
    public boolean trySafeCdn = false;
    public boolean useMultithread = false;
    public int videoSource = 0;
    
    public void setFilePath(String paramString)
    {
      this.filePath = y.n(paramString, false);
      if (Util.isNullOrNil(this.filePath)) {
        this.filePath = "";
      }
    }
    
    public void setMidimgPath(String paramString)
    {
      this.midimgPath = y.n(paramString, false);
      if (Util.isNullOrNil(this.midimgPath)) {
        this.midimgPath = "";
      }
    }
    
    public void setThumbfilePath(String paramString)
    {
      this.thumbfilePath = y.n(paramString, false);
      if (Util.isNullOrNil(this.thumbfilePath)) {
        this.thumbfilePath = "";
      }
    }
  }
  
  public static class C2CUploadResult
  {
    public String aeskey = "";
    public String clientIP = "";
    public int connectCostTime = 0;
    public boolean crossNet = false;
    public int delayTime = 0;
    public int detailErrorCode = 0;
    public int detailErrorType = 0;
    public String emojiMD5 = "";
    public int errorCode = 0;
    public boolean existOnSvr = false;
    public int fileCrc32 = 0;
    public int fileSize = 0;
    public String fileUrl = "";
    public String fileid = "";
    public String filemd5 = "";
    public int filetype = 0;
    public int hitCache = 0;
    public boolean isResume = false;
    public boolean isVideoReduced = false;
    public int midfileSize = 0;
    public String mp4identifymd5 = "";
    public int receiveCostTime = 0;
    public boolean sendmsgFromCDN = false;
    public String serverIP = "";
    public byte[] skeyrespbuf = null;
    public String systemErrorDescribe = "";
    public int thumbfileSize = 0;
    public String thumbfileUrl = "";
    public String thumbfilemd5 = "";
    public String touser = "";
    public String transforMsg = "";
    public int transportProtocol = 0;
    public int transportProtocolError = 0;
    public boolean uploadBySafecdn = false;
    public String[] usedSvrIps;
    public String videofileid = "";
    public int waitResponseCostTime = 0;
  }
  
  public static class CdnInfo
  {
    public byte[] authkey = null;
    public int frontid = 0;
    public String frontip1 = null;
    public String frontip2 = null;
    public int[] frontports = null;
    public int nettype = 0;
    public int uin = 0;
    public int ver = 0;
    public int zoneid = 0;
    public String zoneip1 = null;
    public String zoneip2 = null;
    public int[] zoneports = null;
  }
  
  public static class CertVerifyResult
  {
    public byte[][] certificateChain = null;
    public boolean isIssuedByKnownRoot = false;
    public int status = 0;
  }
  
  public static class Config
  {
    public int AckSlice = 8192;
    public String ApprovedVideoHosts = "vweixinf.tc.qq.com,szwbwxsns.video.qq.com,szxzwxsns.video.qq.com,szzjwxsns.video.qq.com,shwbwxsns.video.qq.com,shxzwxsns.video.qq.com,shzjwxsns.video.qq.com,wxsnsdy.wxs.qq.com,vweixinthumb.tc.qq.com,wxsnsdythumb.wxs.qq.com,wxappthumb.tc.qq.com,wxapp.tc.qq.com";
    public int C2COverloadDelaySeconds = 10;
    public int EnableCDNVerifyConnect = 1;
    public int EnableCDNVideoRedirectOC = 1;
    public int EnableConnectionReuse = 0;
    public int EnableSafeCDN = 0;
    public int EnableSnsImageDownload = 0;
    public int EnableSnsStreamDownload = 0;
    public int EnableSnsVideoRedirect = 0;
    public int EnableStreamUploadVideo = 1;
    public String MiscellaneousExptValues = "";
    public int MobileEtl = 70;
    public int Ptl = 35;
    public String QuicExptValues = "";
    public int SNSOverloadDelaySeconds = 60;
    public int UseDynamicETL = 0;
    public int UseStreamCDN = 1;
    public int WifiEtl = 90;
    
    public String toString()
    {
      return String.format("UseStreamCDN:%d,enableverify:%d,enableoc:%d,enablevideo:%d,c2coverload:%d,snsoverload:%d,safecdn:%d,snsstream:%d, snsimage:%d, snsvideo redirect:%d", new Object[] { Integer.valueOf(this.UseStreamCDN), Integer.valueOf(this.EnableCDNVerifyConnect), Integer.valueOf(this.EnableCDNVideoRedirectOC), Integer.valueOf(this.EnableStreamUploadVideo), Integer.valueOf(this.C2COverloadDelaySeconds), Integer.valueOf(this.SNSOverloadDelaySeconds), Integer.valueOf(this.EnableSafeCDN), Integer.valueOf(this.EnableSnsStreamDownload), Integer.valueOf(this.EnableSnsImageDownload), Integer.valueOf(this.EnableSnsVideoRedirect) });
    }
  }
  
  public static abstract interface SessionCallback
  {
    public abstract byte[] decodeSessionResponseBuf(String paramString, byte[] paramArrayOfByte);
    
    public abstract byte[] getSessionRequestBuf(String paramString, byte[] paramArrayOfByte);
  }
  
  public static abstract interface UploadCallback
  {
    public abstract void onC2CUploadCompleted(String paramString, CdnLogic.C2CUploadResult paramC2CUploadResult);
    
    public abstract void onUploadProgressChanged(String paramString, long paramLong1, long paramLong2);
  }
  
  public static abstract interface VideoStreamingCallback
  {
    public abstract void onDataAvailable(String paramString, long paramLong1, long paramLong2);
    
    public abstract void onDownloadToEnd(String paramString, long paramLong1, long paramLong2);
    
    public abstract void onM3U8Ready(String paramString1, String paramString2);
    
    public abstract void onMoovReadyWithFlag(String paramString1, long paramLong1, long paramLong2, String paramString2);
    
    public abstract void onPreloadCompletedWithResult(String paramString, long paramLong1, long paramLong2, CdnLogic.C2CDownloadResult paramC2CDownloadResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mars.cdn.CdnLogic
 * JD-Core Version:    0.7.0.1
 */