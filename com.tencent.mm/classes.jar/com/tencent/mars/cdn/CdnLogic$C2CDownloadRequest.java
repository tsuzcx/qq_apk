package com.tencent.mars.cdn;

public class CdnLogic$C2CDownloadRequest
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
  public String customHttpHeader = "";
  public String[] dcIpList = null;
  public int dcIpListSource = 2;
  public int expectImageFormat = 1;
  public String fakeBigfileSignature = "";
  public String fakeBigfileSignatureAeskey = "";
  public String feedId = "";
  public int feedPicCount;
  public String fileKey = "";
  public int fileSize = 0;
  public int fileType = 0;
  public String fileid = "";
  public String host = "";
  public boolean isAutoStart = false;
  public boolean isColdSnsData = false;
  public boolean isLargeSVideo = false;
  public boolean isSilentTask = false;
  public boolean isSmallVideo = false;
  public boolean isStorageMode = false;
  public boolean is_resume_task = false;
  public int limitRate = 0;
  public int marscdnAppType = -1;
  public int marscdnBizType = -1;
  public int maxHttpRedirectCount = 3;
  public String msgExtra = "";
  public int msgType = 1;
  public String[] ocIpList = null;
  public int ocIpListSource = 2;
  public int preloadRatio = 30;
  public int queueTimeoutSeconds = 1800;
  public String referer = "";
  public int requestVideoFormat = 1;
  public String savePath = "";
  public String serialized_verify_headers = "";
  public String signalQuality = "";
  public String snsCipherKey = "";
  public String snsScene = "";
  public String statePath = "";
  public int transforTimeoutSeconds = 600;
  public String url = "";
  public boolean useMultithread = false;
  public String videofileid = "";
  public boolean wifiAutoStart = false;
  
  public static C2CDownloadRequest createC2C(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    C2CDownloadRequest localC2CDownloadRequest = new C2CDownloadRequest();
    localC2CDownloadRequest.fileid = paramString1;
    localC2CDownloadRequest.aeskey = paramString2;
    localC2CDownloadRequest.fileType = paramInt;
    localC2CDownloadRequest.savePath = paramString3;
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
    localC2CDownloadRequest.savePath = paramString3;
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
    localC2CDownloadRequest.savePath = paramString3;
    localC2CDownloadRequest.marscdnBizType = 2;
    localC2CDownloadRequest.marscdnAppType = 10;
    return localC2CDownloadRequest;
  }
  
  public static C2CDownloadRequest createHttp(String paramString1, String paramString2)
  {
    C2CDownloadRequest localC2CDownloadRequest = new C2CDownloadRequest();
    localC2CDownloadRequest.url = paramString1;
    localC2CDownloadRequest.savePath = paramString2;
    localC2CDownloadRequest.marscdnBizType = 4;
    localC2CDownloadRequest.marscdnAppType = 102;
    return localC2CDownloadRequest;
  }
  
  public static C2CDownloadRequest createHttpVideo(String paramString1, String paramString2)
  {
    C2CDownloadRequest localC2CDownloadRequest = new C2CDownloadRequest();
    localC2CDownloadRequest.url = paramString1;
    localC2CDownloadRequest.savePath = paramString2;
    localC2CDownloadRequest.marscdnBizType = 4;
    localC2CDownloadRequest.marscdnAppType = 102;
    return localC2CDownloadRequest;
  }
  
  public static C2CDownloadRequest createSNS(String paramString1, int paramInt, String paramString2)
  {
    C2CDownloadRequest localC2CDownloadRequest = new C2CDownloadRequest();
    localC2CDownloadRequest.url = paramString1;
    localC2CDownloadRequest.fileType = paramInt;
    localC2CDownloadRequest.savePath = paramString2;
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
  
  public C2CDownloadRequest customHttpHeader(String paramString)
  {
    this.customHttpHeader = paramString;
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
    this.statePath = paramString;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest
 * JD-Core Version:    0.7.0.1
 */