package com.tencent.mars.cdn;

public class CdnLogic$C2CUploadRequest
{
  public int apptype = 0;
  public String bigfileSignature = "";
  public int bizscene = 0;
  public int chatType = 0;
  public boolean checkExistOnly = false;
  public int connectionCount = 1;
  public boolean enableHitCheck = true;
  public String fakeBigfileSignature = "";
  public String fakeBigfileSignatureAeskey = "";
  public String fileKey = "";
  public String filePath = "";
  public int fileSize = 0;
  public int fileType = 0;
  public String filemd5 = "";
  public boolean forceNoSafeCdn = false;
  public String forwardAeskey = "";
  public String forwardFileid = "";
  public int isLargeSVideo = 0;
  public boolean isSmallVideo = false;
  public boolean isSnsAdVideo = false;
  public boolean isStorageMode = false;
  public boolean isStreamMedia = false;
  public int lastError = 0;
  public int midfileSize = 0;
  public String midimgPath = "";
  public boolean needCompressImage = false;
  public boolean onlyCheckExist = false;
  public int queueTimeoutSeconds = 1800;
  public boolean sendmsgFromCDN = false;
  public String statePath = "";
  public String thumbfilePath = "";
  public String toUser = "";
  public int transforTimeoutSeconds = 600;
  public boolean trySafeCdn = false;
  public boolean useMultithread = false;
  public int videoSource = 0;
  
  public static C2CUploadRequest createApp(int paramInt1, int paramInt2, String paramString)
  {
    paramString = new C2CUploadRequest();
    paramString.bizscene = 4;
    paramString.apptype = paramInt1;
    paramString.fileType = paramInt2;
    paramString.trySafeCdn = true;
    paramString.forceNoSafeCdn = false;
    return paramString;
  }
  
  public static C2CUploadRequest createC2C(int paramInt, String paramString)
  {
    C2CUploadRequest localC2CUploadRequest = new C2CUploadRequest();
    localC2CUploadRequest.bizscene = 1;
    localC2CUploadRequest.apptype = 1;
    localC2CUploadRequest.fileType = paramInt;
    localC2CUploadRequest.filePath = paramString;
    localC2CUploadRequest.trySafeCdn = true;
    localC2CUploadRequest.forceNoSafeCdn = false;
    return localC2CUploadRequest;
  }
  
  public static C2CUploadRequest createC2CExistCheck(String paramString1, String paramString2, int paramInt)
  {
    C2CUploadRequest localC2CUploadRequest = new C2CUploadRequest();
    localC2CUploadRequest.bizscene = 1;
    localC2CUploadRequest.apptype = 1;
    localC2CUploadRequest.fileType = paramInt;
    localC2CUploadRequest.forwardFileid = paramString1;
    localC2CUploadRequest.forwardAeskey = paramString2;
    localC2CUploadRequest.trySafeCdn = true;
    localC2CUploadRequest.forceNoSafeCdn = false;
    localC2CUploadRequest.enableHitCheck = true;
    localC2CUploadRequest.onlyCheckExist = true;
    return localC2CUploadRequest;
  }
  
  public static C2CUploadRequest createFavorite(int paramInt, String paramString)
  {
    paramString = new C2CUploadRequest();
    paramString.bizscene = 2;
    paramString.apptype = 10;
    paramString.fileType = paramInt;
    paramString.trySafeCdn = true;
    paramString.forceNoSafeCdn = false;
    paramString.isStorageMode = true;
    return paramString;
  }
  
  public static C2CUploadRequest createSNS(int paramInt, String paramString)
  {
    paramString = new C2CUploadRequest();
    paramString.bizscene = 3;
    paramString.apptype = 100;
    paramString.fileType = paramInt;
    paramString.trySafeCdn = true;
    paramString.forceNoSafeCdn = false;
    return paramString;
  }
  
  public C2CUploadRequest bigfileSignature(String paramString)
  {
    this.bigfileSignature = paramString;
    return this;
  }
  
  public C2CUploadRequest chatType(int paramInt)
  {
    this.chatType = paramInt;
    return this;
  }
  
  public C2CUploadRequest connectionCount(int paramInt)
  {
    this.connectionCount = paramInt;
    return this;
  }
  
  public C2CUploadRequest enableHitCheck(boolean paramBoolean)
  {
    this.enableHitCheck = paramBoolean;
    return this;
  }
  
  public C2CUploadRequest fakeBigfileSignature(String paramString)
  {
    this.fakeBigfileSignature = paramString;
    return this;
  }
  
  public C2CUploadRequest fakeBigfileSignatureAeskey(String paramString)
  {
    this.fakeBigfileSignatureAeskey = paramString;
    return this;
  }
  
  public C2CUploadRequest filemd5(String paramString)
  {
    this.filemd5 = paramString;
    return this;
  }
  
  public C2CUploadRequest forceNoSafeCdn(boolean paramBoolean)
  {
    this.forceNoSafeCdn = paramBoolean;
    return this;
  }
  
  public C2CUploadRequest forwardAeskey(String paramString)
  {
    this.forwardAeskey = paramString;
    return this;
  }
  
  public C2CUploadRequest forwardFileid(String paramString)
  {
    this.forwardFileid = paramString;
    return this;
  }
  
  public C2CUploadRequest isLargeSVideo(int paramInt)
  {
    this.isLargeSVideo = paramInt;
    return this;
  }
  
  public C2CUploadRequest isSmallVideo(boolean paramBoolean)
  {
    this.isSmallVideo = paramBoolean;
    return this;
  }
  
  public C2CUploadRequest isSnsAdVideo(boolean paramBoolean)
  {
    this.isSnsAdVideo = paramBoolean;
    return this;
  }
  
  public C2CUploadRequest isStreamMedia(boolean paramBoolean)
  {
    this.isStreamMedia = paramBoolean;
    return this;
  }
  
  public C2CUploadRequest lastError(int paramInt)
  {
    this.lastError = paramInt;
    return this;
  }
  
  public C2CUploadRequest midimgPath(String paramString)
  {
    this.midimgPath = paramString;
    return this;
  }
  
  public C2CUploadRequest queueTimeoutSeconds(int paramInt)
  {
    this.queueTimeoutSeconds = paramInt;
    return this;
  }
  
  public C2CUploadRequest sendmsgFromCDN(boolean paramBoolean)
  {
    this.sendmsgFromCDN = paramBoolean;
    return this;
  }
  
  public C2CUploadRequest statePath(String paramString)
  {
    this.statePath = paramString;
    return this;
  }
  
  public C2CUploadRequest thumbfilePath(String paramString)
  {
    this.thumbfilePath = paramString;
    return this;
  }
  
  public C2CUploadRequest toUser(String paramString)
  {
    this.toUser = paramString;
    return this;
  }
  
  public C2CUploadRequest transforTimeoutSeconds(int paramInt)
  {
    this.transforTimeoutSeconds = paramInt;
    return this;
  }
  
  public C2CUploadRequest videoSource(int paramInt)
  {
    this.videoSource = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mars.cdn.CdnLogic.C2CUploadRequest
 * JD-Core Version:    0.7.0.1
 */