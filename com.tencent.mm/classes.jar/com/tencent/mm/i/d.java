package com.tencent.mm.i;

import com.tencent.mars.cdn.CdnLogic.BatchSnsReqImageData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public final class d
{
  protected static final char[] edf;
  public String cBO;
  public String cachePath;
  public String czw;
  public String edb = "";
  public String edc = ",,,,,,";
  public boolean edd;
  public CdnLogic.BatchSnsReqImageData[] ede;
  public int field_UploadHitCacheType = 0;
  public String field_aesKey;
  public String field_arg;
  public String field_argInfo;
  public int field_averageConnectCost = 0;
  public int field_averageRequestCost = 0;
  public int field_averageRequestSize = 0;
  public int field_averageSpeed = 0;
  public int field_cSeqCheck = 0;
  public int field_clientHostIP = 0;
  public String field_clientIP = "";
  public int field_connectCostTime = 0;
  public boolean field_convert2baseline = false;
  public int field_delayTime = 0;
  public int field_detailErrorCode = 0;
  public int field_detailErrorType = 0;
  public int field_dnsCostTime = 0;
  public long field_enQueueTime = 0L;
  public long field_endTime = 0L;
  public boolean field_exist_whencheck = false;
  public String field_fileId;
  public int field_fileLength;
  public String field_fileUrl = "";
  public int field_filecrc;
  public String field_filemd5 = "";
  public int field_firstConnectCost = 0;
  public boolean field_firstRequestCompleted = false;
  public int field_firstRequestCost = 0;
  public int field_firstRequestDownloadSize = 0;
  public int field_firstRequestSize = 0;
  public String field_httpResponseHeader = "";
  public int field_httpStatusCode = 0;
  public boolean field_isCrossNet = false;
  public boolean field_isResume = false;
  public boolean field_isVideoReduced = false;
  public int field_midimgLength;
  public boolean field_moovCompleted = false;
  public int field_moovCost = 0;
  public int field_moovFailReason = 0;
  public int field_moovRequestTimes = 0;
  public int field_moovSize = 0;
  public String field_mp4identifymd5 = "";
  public boolean field_needSendMsgField = true;
  public int field_netConnectTimes = 0;
  public int field_previousCompletedSize = 0;
  public int field_receiveCostTime = 0;
  public int field_recvedBytes = 0;
  public int field_requestCompletedCount = 0;
  public int field_requestTimeoutCount = 0;
  public int field_requestTotalCount = 0;
  public int field_retCode;
  public byte[] field_sKeyrespbuf;
  public int field_serverHostIP = 0;
  public String field_serverIP = "";
  public long field_startTime = 0L;
  public String field_thumbUrl = "";
  public String field_thumbfilemd5 = "";
  public int field_thumbimgLength;
  public String field_toUser;
  public String field_transInfo;
  public boolean field_upload_by_safecdn;
  public boolean field_usePrivateProtocol = true;
  public String[] field_usedSvrIps;
  public String field_videoFileId;
  public int field_videoFormat = 0;
  public int field_waitResponseCostTime = 0;
  public String field_xErrorNo = "";
  public String fileKey;
  public int index;
  
  static
  {
    AppMethodBeat.i(128593);
    edf = "0123456789ABCDEF".toCharArray();
    AppMethodBeat.o(128593);
  }
  
  private static String bytesToHex(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(128590);
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      arrayOfChar[(i * 2)] = edf[(j >>> 4)];
      arrayOfChar[(i * 2 + 1)] = edf[(j & 0xF)];
      i += 1;
    }
    paramArrayOfByte = new String(arrayOfChar);
    AppMethodBeat.o(128590);
    return paramArrayOfByte;
  }
  
  public final boolean Jm()
  {
    return (this.field_upload_by_safecdn) && ((2 == this.field_UploadHitCacheType) || (3 == this.field_UploadHitCacheType));
  }
  
  public final String Jn()
  {
    AppMethodBeat.i(128592);
    Object localObject = "";
    if (this.field_usedSvrIps != null)
    {
      localObject = new StringBuffer();
      String[] arrayOfString = this.field_usedSvrIps;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        ((StringBuffer)localObject).append(arrayOfString[i]).append("|");
        i += 1;
      }
      localObject = ((StringBuffer)localObject).toString();
    }
    AppMethodBeat.o(128592);
    return localObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(128591);
    String str2 = String.format("id:%s file:%s filelen:%d midlen:%d thlen:%d transInfo:%s retCode:%d toUser:%s arg:%s videoFileId:%s argInfo:%s hitcache:%d needsend:%b msgid:%d convert2baseline:%b thumbUrl:%s fileUrl:%s filemd5:%s thumbfilemd5:%s,mp4identifymd5:%s, exist_whencheck[%b], aesKey[%s], crc[%s], safecdn:%b", new Object[] { this.cBO, this.field_fileId, Integer.valueOf(this.field_fileLength), Integer.valueOf(this.field_midimgLength), Integer.valueOf(this.field_thumbimgLength), this.field_transInfo, Integer.valueOf(this.field_retCode), this.field_toUser, this.field_arg, this.field_videoFileId, this.field_argInfo, Integer.valueOf(this.field_UploadHitCacheType), Boolean.valueOf(this.field_needSendMsgField), Integer.valueOf(0), Boolean.valueOf(this.field_convert2baseline), this.field_thumbUrl, this.field_fileUrl, this.field_filemd5, this.field_thumbfilemd5, this.field_mp4identifymd5, Boolean.valueOf(this.field_exist_whencheck), bo.aqg(this.field_aesKey), Integer.valueOf(this.field_filecrc), Boolean.valueOf(this.field_upload_by_safecdn) });
    String str1 = str2;
    if (this.field_sKeyrespbuf != null) {
      str1 = str2 + String.format("skeyrespbuf:%s", new Object[] { bytesToHex(this.field_sKeyrespbuf) });
    }
    AppMethodBeat.o(128591);
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.i.d
 * JD-Core Version:    0.7.0.1
 */