package com.tencent.mm.ak;

import android.os.HandlerThread;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadResult;
import com.tencent.mars.cdn.CdnLogic.C2CUploadRequest;
import com.tencent.mars.cdn.CdnLogic.C2CUploadResult;
import com.tencent.mars.cdn.CdnLogic.CdnInfo;
import com.tencent.mars.cdn.CdnLogic.CheckFileIDResult;
import com.tencent.mars.cdn.CdnLogic.Config;
import com.tencent.mars.cdn.CdnLogic.ICallback;
import com.tencent.mm.j.b.a;
import com.tencent.mm.j.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.b;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.ld;
import com.tencent.mm.protocal.c.le;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayOutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
  implements CdnLogic.ICallback
{
  private static int eip = 7340033;
  private static int eiq = 100;
  private static int eir = 101;
  private static int eis = 102;
  private static int eit = 103;
  public a.a eiA;
  private ld eiu = null;
  b.a eiv = null;
  private int eiw = 0;
  private int eix = 0;
  private String eiy = "";
  private am eiz = null;
  
  public a(String paramString, b.a parama)
  {
    if (com.tencent.mm.sdk.platformtools.ae.cqV()) {
      this.eiz = new am(g.DS().mnU.getLooper(), new a.1(this), true);
    }
    this.eiv = parama;
    CdnLogic.setCallBack(this);
    CdnLogic.onCreate(paramString);
    CdnLogic.setRSAPublicKeyParams("1", "BFEDFFB5EA28509F9C89ED83FA7FDDA8881435D444E984D53A98AD8E9410F1145EDD537890E10456190B22E6E5006455EFC6C12E41FDA985F38FBBC7213ECB810E3053D4B8D74FFBC70B4600ABD728202322AFCE1406046631261BD5EE3D44721082FEAB74340D73645DC0D02A293B962B9D47E4A64100BD7524DE00D9D3B5C1", "010001");
    CdnLogic.setToUserCiper("cdnwx2013usrname");
    y.i("MicroMsg.CdnTransportEngine", "summersafecdn CdnTransportEngine init[%s] infoPath[%s], stack[%s]", new Object[] { Integer.valueOf(hashCode()), paramString, bk.csb() });
  }
  
  public static String MW()
  {
    return CdnLogic.createAeskey();
  }
  
  public static int a(com.tencent.mm.j.f paramf, int paramInt)
  {
    return CdnLogic.startVideoStreamingDownload(a(paramf), paramInt);
  }
  
  public static int a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String[] paramArrayOfString, boolean paramBoolean)
  {
    int i = 0;
    if (paramArrayOfString == null) {}
    CdnLogic.C2CDownloadRequest localC2CDownloadRequest;
    for (;;)
    {
      y.i("MicroMsg.CdnTransportEngine", "startURLDownload: mediaid:%s, savepath:%s, filetype:%d, timeout:%d, %d, ip.size:%d, gzip:%b", new Object[] { paramString1, paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(i), Boolean.valueOf(paramBoolean) });
      localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
      localC2CDownloadRequest.fileKey = paramString1;
      localC2CDownloadRequest.url = paramString2;
      localC2CDownloadRequest.savePath = paramString3;
      localC2CDownloadRequest.queueTimeoutSeconds = paramInt2;
      localC2CDownloadRequest.transforTimeoutSeconds = paramInt3;
      localC2CDownloadRequest.ocIpList = paramArrayOfString;
      if (!paramBoolean) {
        localC2CDownloadRequest.customHttpHeader = "Accept-Encoding:  ";
      }
      localC2CDownloadRequest.fileType = paramInt1;
      if (com.tencent.mm.j.a.dlx != localC2CDownloadRequest.fileType) {
        break;
      }
      return CdnLogic.startHttpsDownload(localC2CDownloadRequest);
      i = paramArrayOfString.length;
    }
    return CdnLogic.startURLDownload(localC2CDownloadRequest);
  }
  
  public static int a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5)
  {
    y.i("MicroMsg.CdnTransportEngine", "startURLDownload: mediaid:%s, savepath:%s", new Object[] { paramString1, paramString3 });
    CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
    localC2CDownloadRequest.fileKey = paramString1;
    localC2CDownloadRequest.url = paramString2;
    localC2CDownloadRequest.savePath = paramString3;
    localC2CDownloadRequest.aeskey = paramString4;
    localC2CDownloadRequest.customHttpHeader = ("authkey: " + paramString5 + "\r\n");
    localC2CDownloadRequest.fileType = paramInt;
    return CdnLogic.startSNSDownload(localC2CDownloadRequest, 0);
  }
  
  public static int a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3)
  {
    CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
    localC2CDownloadRequest.fileKey = paramString1;
    localC2CDownloadRequest.fileType = 90;
    localC2CDownloadRequest.url = paramString2;
    localC2CDownloadRequest.referer = paramString3;
    localC2CDownloadRequest.savePath = paramString4;
    localC2CDownloadRequest.preloadRatio = paramInt2;
    localC2CDownloadRequest.concurrentCount = paramInt3;
    localC2CDownloadRequest.maxHttpRedirectCount = 100;
    return CdnLogic.startHttpVideoStreamingDownload(localC2CDownloadRequest, paramInt1);
  }
  
  public static int a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String[] paramArrayOfString, int paramInt2, int paramInt3, int paramInt4)
  {
    CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
    localC2CDownloadRequest.fileKey = paramString1;
    localC2CDownloadRequest.url = paramString2;
    localC2CDownloadRequest.referer = paramString3;
    localC2CDownloadRequest.savePath = paramString4;
    localC2CDownloadRequest.fileSize = 0;
    localC2CDownloadRequest.initialDownloadOffset = paramInt2;
    localC2CDownloadRequest.initialDownloadLength = paramInt3;
    if (paramArrayOfString != null) {}
    for (localC2CDownloadRequest.ocIpList = ((String[])paramArrayOfString.clone());; localC2CDownloadRequest.ocIpList = null)
    {
      localC2CDownloadRequest.preloadRatio = paramInt4;
      return CdnLogic.startHttpVideoStreamingDownload(localC2CDownloadRequest, paramInt1);
    }
  }
  
  public static int a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String[] paramArrayOfString, int paramInt2, int paramInt3, boolean paramBoolean, String paramString5, String paramString6, int paramInt4, int paramInt5)
  {
    CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
    localC2CDownloadRequest.fileType = 20202;
    localC2CDownloadRequest.fileKey = paramString1;
    localC2CDownloadRequest.url = paramString2;
    localC2CDownloadRequest.referer = paramString3;
    localC2CDownloadRequest.savePath = paramString4;
    localC2CDownloadRequest.fileSize = 0;
    localC2CDownloadRequest.initialDownloadOffset = paramInt2;
    localC2CDownloadRequest.initialDownloadLength = paramInt3;
    if (paramArrayOfString != null) {}
    for (localC2CDownloadRequest.ocIpList = ((String[])paramArrayOfString.clone());; localC2CDownloadRequest.ocIpList = null)
    {
      localC2CDownloadRequest.isColdSnsData = paramBoolean;
      localC2CDownloadRequest.signalQuality = paramString5;
      localC2CDownloadRequest.snsScene = paramString6;
      localC2CDownloadRequest.preloadRatio = paramInt4;
      localC2CDownloadRequest.requestVideoFormat = paramInt5;
      return CdnLogic.startSNSDownload(localC2CDownloadRequest, paramInt1);
    }
  }
  
  public static int a(String paramString1, String paramString2, String paramString3, String paramString4, Map<String, String> paramMap, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, boolean paramBoolean3, String[] paramArrayOfString)
  {
    y.i("MicroMsg.CdnTransportEngine", "startGamePackageDownload: mediaid:" + paramString1);
    CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
    localC2CDownloadRequest.fileKey = paramString1;
    localC2CDownloadRequest.url = paramString3;
    localC2CDownloadRequest.bakup_url = paramString4;
    localC2CDownloadRequest.savePath = paramString2;
    localC2CDownloadRequest.queueTimeoutSeconds = paramInt1;
    localC2CDownloadRequest.transforTimeoutSeconds = paramInt2;
    localC2CDownloadRequest.ocIpList = paramArrayOfString;
    localC2CDownloadRequest.is_resume_task = paramBoolean2;
    if (paramMap != null)
    {
      paramString1 = paramMap.entrySet().iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (Map.Entry)paramString1.next();
        localC2CDownloadRequest.serialized_verify_headers += (String)paramString2.getKey();
        localC2CDownloadRequest.serialized_verify_headers += ":";
        localC2CDownloadRequest.serialized_verify_headers += (String)paramString2.getValue();
        localC2CDownloadRequest.serialized_verify_headers += ";";
      }
    }
    localC2CDownloadRequest.allow_mobile_net_download = paramBoolean1;
    localC2CDownloadRequest.wifiAutoStart = paramBoolean3;
    return CdnLogic.startHttpMultiSocketDownloadTask(localC2CDownloadRequest);
  }
  
  public static int a(String paramString1, String paramString2, String paramString3, String paramString4, String[] paramArrayOfString1, String[] paramArrayOfString2, int paramInt1, int paramInt2, boolean paramBoolean, String paramString5, String paramString6, String paramString7, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((bk.bl(paramString1)) || (bk.bl(paramString2)) || (bk.bl(paramString4)))
    {
      y.e("MicroMsg.CdnTransportEngine", "invalid param.");
      return -1;
    }
    CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
    localC2CDownloadRequest.fileType = 20201;
    localC2CDownloadRequest.fileKey = paramString1;
    localC2CDownloadRequest.url = paramString2;
    localC2CDownloadRequest.referer = paramString3;
    localC2CDownloadRequest.savePath = paramString4;
    localC2CDownloadRequest.fileSize = 0;
    if (paramArrayOfString1 != null)
    {
      paramString1 = (String[])paramArrayOfString1.clone();
      localC2CDownloadRequest.ocIpList = paramString1;
      localC2CDownloadRequest.ocIpListSource = paramInt1;
      if (paramArrayOfString2 == null) {
        break label200;
      }
    }
    label200:
    for (paramString1 = (String[])paramArrayOfString2.clone();; paramString1 = null)
    {
      localC2CDownloadRequest.dcIpList = paramString1;
      localC2CDownloadRequest.dcIpListSource = paramInt2;
      localC2CDownloadRequest.isColdSnsData = paramBoolean;
      localC2CDownloadRequest.signalQuality = paramString5;
      localC2CDownloadRequest.snsScene = paramString6;
      localC2CDownloadRequest.snsCipherKey = paramString7;
      localC2CDownloadRequest.concurrentCount = 6;
      localC2CDownloadRequest.marscdnBizType = paramInt3;
      localC2CDownloadRequest.marscdnAppType = paramInt4;
      localC2CDownloadRequest.fileType = paramInt5;
      return CdnLogic.startSNSDownload(localC2CDownloadRequest, 0);
      paramString1 = null;
      break;
    }
  }
  
  public static CdnLogic.C2CDownloadRequest a(com.tencent.mm.j.f paramf)
  {
    boolean bool2 = true;
    CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
    localC2CDownloadRequest.fileid = paramf.field_fileId;
    localC2CDownloadRequest.aeskey = paramf.field_aesKey;
    localC2CDownloadRequest.fileType = paramf.field_fileType;
    localC2CDownloadRequest.fileKey = paramf.field_mediaId;
    localC2CDownloadRequest.fileSize = paramf.field_totalLen;
    localC2CDownloadRequest.savePath = paramf.field_fullpath;
    localC2CDownloadRequest.isStorageMode = paramf.field_needStorage;
    if (paramf.field_smallVideoFlag == 1)
    {
      bool1 = true;
      localC2CDownloadRequest.isSmallVideo = bool1;
      if (paramf.field_largesvideo <= 0) {
        break label328;
      }
    }
    label328:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localC2CDownloadRequest.isLargeSVideo = bool1;
      localC2CDownloadRequest.limitRate = paramf.field_limitrate;
      localC2CDownloadRequest.isAutoStart = paramf.field_autostart;
      localC2CDownloadRequest.chatType = paramf.field_chattype;
      localC2CDownloadRequest.isSilentTask = paramf.field_isSilentTask;
      localC2CDownloadRequest.requestVideoFormat = paramf.field_requestVideoFormat;
      localC2CDownloadRequest.isColdSnsData = paramf.field_isColdSnsData;
      localC2CDownloadRequest.signalQuality = paramf.field_signalQuality;
      localC2CDownloadRequest.snsScene = paramf.field_snsScene;
      localC2CDownloadRequest.requestVideoFormat = paramf.field_requestVideoFormat;
      localC2CDownloadRequest.videofileid = paramf.field_videoFileId;
      localC2CDownloadRequest.bigfileSignature = paramf.field_svr_signature;
      if (bk.bl(localC2CDownloadRequest.bigfileSignature)) {
        localC2CDownloadRequest.bigfileSignature = "";
      }
      localC2CDownloadRequest.fakeBigfileSignature = paramf.field_fake_bigfile_signature;
      if (bk.bl(localC2CDownloadRequest.fakeBigfileSignature)) {
        localC2CDownloadRequest.fakeBigfileSignature = "";
      }
      localC2CDownloadRequest.fakeBigfileSignatureAeskey = paramf.field_fake_bigfile_signature_aeskey;
      if (bk.bl(localC2CDownloadRequest.fakeBigfileSignatureAeskey)) {
        localC2CDownloadRequest.fakeBigfileSignatureAeskey = "";
      }
      localC2CDownloadRequest.msgExtra = paramf.field_wxmsgparam;
      if (bk.bl(localC2CDownloadRequest.msgExtra)) {
        localC2CDownloadRequest.msgExtra = "";
      }
      localC2CDownloadRequest.queueTimeoutSeconds = 0;
      localC2CDownloadRequest.transforTimeoutSeconds = 0;
      localC2CDownloadRequest.initialDownloadLength = paramf.initialDownloadLength;
      localC2CDownloadRequest.initialDownloadOffset = paramf.initialDownloadOffset;
      localC2CDownloadRequest.preloadRatio = paramf.field_preloadRatio;
      localC2CDownloadRequest.certificateVerifyPolicy = paramf.certificateVerifyPolicy;
      localC2CDownloadRequest.expectImageFormat = paramf.expectImageFormat;
      return localC2CDownloadRequest;
      bool1 = false;
      break;
    }
  }
  
  private static CdnLogic.CdnInfo a(ld paramld)
  {
    CdnLogic.CdnInfo localCdnInfo = new CdnLogic.CdnInfo();
    if (paramld == null) {
      return localCdnInfo;
    }
    localCdnInfo.ver = paramld.sGp;
    localCdnInfo.uin = paramld.jwX;
    localCdnInfo.frontid = paramld.sGr;
    localCdnInfo.zoneid = paramld.sGw;
    localCdnInfo.nettype = c.bw(com.tencent.mm.sdk.platformtools.ae.getContext());
    localCdnInfo.authkey = aa.a(paramld.sGv);
    if (paramld.sGs >= 2)
    {
      localCdnInfo.frontip1 = aa.a((bml)paramld.sGt.get(0));
      localCdnInfo.frontip2 = aa.a((bml)paramld.sGt.get(1));
      y.i("MicroMsg.CdnTransportEngine", "frontip %s, %s", new Object[] { localCdnInfo.frontip1, localCdnInfo.frontip2 });
    }
    if (paramld.sGx >= 2)
    {
      localCdnInfo.zoneip1 = aa.a((bml)paramld.sGy.get(0));
      localCdnInfo.zoneip2 = aa.a((bml)paramld.sGy.get(1));
      y.i("MicroMsg.CdnTransportEngine", "zoneip %s, %s", new Object[] { localCdnInfo.frontip1, localCdnInfo.frontip2 });
    }
    int j;
    int i;
    if (paramld.sGB > 0)
    {
      j = ((le)paramld.sGz.get(0)).sGD;
      localCdnInfo.frontports = new int[j];
      i = 0;
      while (i < j)
      {
        localCdnInfo.frontports[i] = ((Integer)((le)paramld.sGz.get(0)).sGE.get(i)).intValue();
        i += 1;
      }
    }
    if (paramld.sGC > 0)
    {
      j = ((le)paramld.sGA.get(0)).sGD;
      localCdnInfo.zoneports = new int[j];
      i = 0;
      while (i < j)
      {
        localCdnInfo.zoneports[i] = ((Integer)((le)paramld.sGA.get(0)).sGE.get(i)).intValue();
        i += 1;
      }
    }
    return localCdnInfo;
  }
  
  private static d a(CdnLogic.C2CDownloadResult paramC2CDownloadResult, d paramd)
  {
    d locald = paramd;
    if (paramd == null) {
      locald = new d();
    }
    locald.field_retCode = paramC2CDownloadResult.errorCode;
    locald.field_argInfo = paramC2CDownloadResult.argInfo;
    locald.field_fileLength = paramC2CDownloadResult.fileSize;
    locald.field_fileId = paramC2CDownloadResult.fileid;
    locald.field_transInfo = paramC2CDownloadResult.transforMsg;
    locald.field_convert2baseline = false;
    locald.field_recvedBytes = paramC2CDownloadResult.recvedBytes;
    locald.field_videoFormat = paramC2CDownloadResult.videoFormat;
    locald.field_enQueueTime = paramC2CDownloadResult.enQueueTime;
    locald.field_startTime = paramC2CDownloadResult.startTime;
    locald.field_endTime = paramC2CDownloadResult.endTime;
    locald.field_firstRequestCost = paramC2CDownloadResult.firstRequestCost;
    locald.field_firstRequestSize = paramC2CDownloadResult.firstRequestSize;
    locald.field_firstRequestDownloadSize = paramC2CDownloadResult.firstRequestDownloadSize;
    locald.field_firstRequestCompleted = paramC2CDownloadResult.firstRequestCompleted;
    locald.field_averageSpeed = paramC2CDownloadResult.averageSpeed;
    locald.field_averageConnectCost = paramC2CDownloadResult.averageConnectCost;
    locald.field_firstConnectCost = paramC2CDownloadResult.firstConnectCost;
    locald.field_netConnectTimes = paramC2CDownloadResult.netConnectTimes;
    locald.field_moovRequestTimes = paramC2CDownloadResult.moovRequestTimes;
    locald.field_moovCost = paramC2CDownloadResult.moovCost;
    locald.field_moovSize = paramC2CDownloadResult.moovSize;
    locald.field_moovCompleted = paramC2CDownloadResult.moovCompleted;
    locald.field_moovFailReason = paramC2CDownloadResult.moovFailReason;
    locald.field_httpStatusCode = paramC2CDownloadResult.httpStatusCode;
    locald.field_httpResponseHeader = paramC2CDownloadResult.httpResponseHeader;
    locald.field_delayTime = paramC2CDownloadResult.delayTime;
    locald.field_dnsCostTime = paramC2CDownloadResult.dnsCostTime;
    locald.field_connectCostTime = paramC2CDownloadResult.connectCostTime;
    locald.field_waitResponseCostTime = paramC2CDownloadResult.waitResponseCostTime;
    locald.field_receiveCostTime = paramC2CDownloadResult.receiveCostTime;
    locald.field_clientIP = paramC2CDownloadResult.clientIP;
    locald.field_serverIP = paramC2CDownloadResult.serverIP;
    locald.field_clientHostIP = lK(paramC2CDownloadResult.clientIP);
    locald.field_serverHostIP = lK(paramC2CDownloadResult.serverIP);
    locald.field_xErrorNo = paramC2CDownloadResult.xErrorNo;
    locald.field_cSeqCheck = paramC2CDownloadResult.cSeqCheck;
    locald.field_usePrivateProtocol = paramC2CDownloadResult.usePrivateProtocol;
    locald.field_isCrossNet = paramC2CDownloadResult.crossNet;
    locald.field_clientIP = paramC2CDownloadResult.clientIP;
    if (paramC2CDownloadResult.usedSvrIps != null) {
      locald.field_usedSvrIps = ((String[])paramC2CDownloadResult.usedSvrIps.clone());
    }
    locald.field_isResume = paramC2CDownloadResult.isResume;
    return locald;
  }
  
  public static void a(a.b paramb)
  {
    y.i("MicroMsg.CdnTransportEngine", "set WXConfig:" + paramb);
    CdnLogic.Config localConfig = new CdnLogic.Config();
    localConfig.AckSlice = paramb.field_AckSlice;
    localConfig.UseDynamicETL = paramb.field_UseDynamicETL;
    localConfig.UseStreamCDN = paramb.field_UseStreamCDN;
    localConfig.C2COverloadDelaySeconds = paramb.field_C2COverloadDelaySeconds;
    localConfig.SNSOverloadDelaySeconds = paramb.field_SNSOverloadDelaySeconds;
    localConfig.EnableCDNVerifyConnect = paramb.field_EnableCDNVerifyConnect;
    localConfig.EnableCDNVideoRedirectOC = paramb.field_EnableCDNVideoRedirectOC;
    localConfig.EnableStreamUploadVideo = paramb.field_EnableStreamUploadVideo;
    localConfig.EnableSafeCDN = paramb.field_EnableSafeCDN;
    localConfig.EnableSnsStreamDownload = paramb.field_EnableSnsStreamDownload;
    localConfig.EnableSnsImageDownload = paramb.field_EnableSnsImageDownload;
    if (!bk.bl(paramb.field_ApprovedVideoHosts)) {
      localConfig.ApprovedVideoHosts = paramb.field_ApprovedVideoHosts;
    }
    localConfig.WifiEtl = paramb.field_WifiEtl;
    localConfig.MobileEtl = paramb.field_noWifiEtl;
    localConfig.onlyrecvPtl = paramb.field_onlyrecvPtl;
    localConfig.onlysendETL = paramb.field_onlysendETL;
    localConfig.Ptl = paramb.field_Ptl;
    CdnLogic.setConfig(localConfig);
  }
  
  private static void a(d paramd)
  {
    if ((paramd != null) && (!bk.bl(paramd.field_transInfo)))
    {
      int i = paramd.field_transInfo.indexOf("@,");
      if (i > 0)
      {
        paramd.dlG = paramd.field_transInfo.substring(i + 2);
        paramd.field_transInfo = paramd.field_transInfo.substring(0, i);
      }
      y.v("MicroMsg.CdnTransportEngine", "transinfo:%s, report_part2:%s", new Object[] { paramd.field_transInfo, paramd.dlG });
    }
  }
  
  public static int b(com.tencent.mm.j.f paramf)
  {
    boolean bool2 = true;
    CdnLogic.C2CUploadRequest localC2CUploadRequest = new CdnLogic.C2CUploadRequest();
    localC2CUploadRequest.fileKey = paramf.field_mediaId;
    localC2CUploadRequest.filePath = paramf.field_fullpath;
    localC2CUploadRequest.thumbfilePath = paramf.field_thumbpath;
    localC2CUploadRequest.fileSize = paramf.field_totalLen;
    localC2CUploadRequest.fileType = paramf.field_fileType;
    localC2CUploadRequest.forwardAeskey = paramf.field_aesKey;
    localC2CUploadRequest.forwardFileid = paramf.field_fileId;
    localC2CUploadRequest.midfileSize = paramf.field_midFileLength;
    localC2CUploadRequest.queueTimeoutSeconds = 0;
    localC2CUploadRequest.transforTimeoutSeconds = 0;
    localC2CUploadRequest.toUser = paramf.field_talker;
    localC2CUploadRequest.sendmsgFromCDN = paramf.field_sendmsg_viacdn;
    localC2CUploadRequest.needCompressImage = paramf.field_needCompressImage;
    localC2CUploadRequest.chatType = paramf.field_chattype;
    localC2CUploadRequest.apptype = paramf.field_appType;
    localC2CUploadRequest.bizscene = paramf.field_bzScene;
    localC2CUploadRequest.checkExistOnly = paramf.field_onlycheckexist;
    if (paramf.field_smallVideoFlag == 1)
    {
      bool1 = true;
      localC2CUploadRequest.isSmallVideo = bool1;
      localC2CUploadRequest.isLargeSVideo = paramf.field_largesvideo;
      localC2CUploadRequest.videoSource = paramf.field_videosource;
      if (paramf.field_advideoflag != 1) {
        break label324;
      }
    }
    label324:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localC2CUploadRequest.isSnsAdVideo = bool1;
      localC2CUploadRequest.isStorageMode = paramf.field_needStorage;
      localC2CUploadRequest.isStreamMedia = paramf.field_isStreamMedia;
      localC2CUploadRequest.enableHitCheck = paramf.field_enable_hitcheck;
      localC2CUploadRequest.forceNoSafeCdn = paramf.field_force_aeskeycdn;
      localC2CUploadRequest.trySafeCdn = paramf.field_trysafecdn;
      localC2CUploadRequest.midimgPath = paramf.field_midimgpath;
      localC2CUploadRequest.bigfileSignature = paramf.field_svr_signature;
      if (bk.bl(localC2CUploadRequest.bigfileSignature)) {
        localC2CUploadRequest.bigfileSignature = "";
      }
      localC2CUploadRequest.fakeBigfileSignature = paramf.field_fake_bigfile_signature;
      if (bk.bl(localC2CUploadRequest.fakeBigfileSignature)) {
        localC2CUploadRequest.fakeBigfileSignature = "";
      }
      localC2CUploadRequest.fakeBigfileSignatureAeskey = paramf.field_fake_bigfile_signature_aeskey;
      if (bk.bl(localC2CUploadRequest.fakeBigfileSignatureAeskey)) {
        localC2CUploadRequest.fakeBigfileSignatureAeskey = "";
      }
      localC2CUploadRequest.lastError = paramf.lastError;
      return CdnLogic.startC2CUpload(localC2CUploadRequest);
      bool1 = false;
      break;
    }
  }
  
  public static int b(String paramString, d paramd)
  {
    CdnLogic.C2CDownloadResult localC2CDownloadResult = new CdnLogic.C2CDownloadResult();
    int i = CdnLogic.cancelDownloadTaskWithResult(paramString, localC2CDownloadResult);
    a(localC2CDownloadResult, paramd);
    return i;
  }
  
  public static int h(String paramString, int paramInt1, int paramInt2)
  {
    return CdnLogic.requestVideoData(paramString, paramInt1, paramInt2, 0);
  }
  
  public static boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
  {
    return CdnLogic.isVideoDataAvailable(paramString, paramInt1, paramInt2);
  }
  
  public static int keep_callFromJni(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    if (paramInt1 == eiq) {
      c.outputJniLog(paramArrayOfByte, "MicroMsg.CdnEngine", paramInt2);
    }
    return 0;
  }
  
  public static int lD(String paramString)
  {
    CdnLogic.cancelTask(paramString);
    return 0;
  }
  
  public static int lE(String paramString)
  {
    CdnLogic.cancelTask(paramString);
    return 0;
  }
  
  public static String lF(String paramString)
  {
    return CdnLogic.getFileMD5(paramString);
  }
  
  public static int lG(String paramString)
  {
    return CdnLogic.getFileCrc32(paramString);
  }
  
  public static String lH(String paramString)
  {
    return CdnLogic.getMP4IdentifyMD5(paramString);
  }
  
  public static int lI(String paramString)
  {
    y.i("MicroMsg.CdnTransportEngine", "stopHttpsDownload: mediaid:" + paramString);
    CdnLogic.cancelTask(paramString);
    return 0;
  }
  
  public static int lJ(String paramString)
  {
    y.i("MicroMsg.CdnTransportEngine", "stopGamePackageDownload: mediaid:" + paramString);
    CdnLogic.cancelTask(paramString);
    return 0;
  }
  
  private static int lK(String paramString)
  {
    y.i("MicroMsg.CdnTransportEngine", "ipFromString %s", new Object[] { paramString });
    try
    {
      paramString = InetAddress.getByName(paramString).getAddress();
      int m = paramString.length;
      int j = 0;
      int i = 0;
      int k;
      for (;;)
      {
        k = i;
        if (j >= m) {
          break;
        }
        i = i << 8 | paramString[j] & 0xFF;
        j += 1;
      }
      return k;
    }
    catch (UnknownHostException paramString)
    {
      k = 0;
    }
  }
  
  public final boolean MX()
  {
    return this.eiu == null;
  }
  
  public final void ReportFlow(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!com.tencent.mm.sdk.platformtools.ae.cqV()) {
      return;
    }
    y.i("MicroMsg.CdnTransportEngine", "ReportFlow, wifi:s:%d, r:%d, mobile:s:%d, r:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt4), Integer.valueOf(paramInt3) });
    keep_cdnSendAndRecvData("dummy clientmsgid", paramInt2 + paramInt4, paramInt1 + paramInt3);
  }
  
  public final void RequestGetCDN(int paramInt)
  {
    if (!com.tencent.mm.sdk.platformtools.ae.cqV()) {
      return;
    }
    y.i("MicroMsg.CdnTransportEngine", "requestgetcdn %d", new Object[] { Integer.valueOf(paramInt) });
    keep_OnRequestDoGetCdnDnsInfo(paramInt);
  }
  
  public final boolean a(ld paramld1, ld paramld2, ld paramld3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, ld paramld4)
  {
    y.i("MicroMsg.CdnTransportEngine", "summersafecdn cdntra setCDNDnsInfo old [%s]  new [%s], safecdn [%s], stack[%s]", new Object[] { this.eiu, paramld1, paramld4, bk.csb() });
    if ((paramld1 == null) && (paramArrayOfByte1 == null)) {
      return false;
    }
    this.eiu = paramld1;
    try
    {
      paramld1 = a(paramld1);
      paramld2 = a(paramld2);
      paramld3 = a(paramld3);
      paramld4 = a(paramld4);
      CdnLogic.setLegacyCdnInfo(paramld1, paramld2, paramld3, paramld4, paramArrayOfByte1, paramArrayOfByte2);
      CdnLogic.setDebugIP("");
      if ((com.tencent.mm.platformtools.ae.eTi) && (com.tencent.mm.platformtools.ae.eSZ != null) && (com.tencent.mm.platformtools.ae.eSZ.length() >= 7))
      {
        y.w("MicroMsg.CdnTransportEngine", "setcdndns use debugip %s", new Object[] { com.tencent.mm.platformtools.ae.eSZ });
        CdnLogic.setDebugIP(com.tencent.mm.platformtools.ae.eSZ);
      }
      return true;
    }
    catch (Exception paramld1)
    {
      y.e("MicroMsg.CdnTransportEngine", "tocdninfo failed:" + paramld1.getLocalizedMessage());
    }
    return false;
  }
  
  public final byte[] decodeSessionResponseBuf(String paramString, byte[] paramArrayOfByte)
  {
    if (!com.tencent.mm.sdk.platformtools.ae.cqV()) {
      return null;
    }
    return keep_cdnDecodePrepareResponse(paramString, paramArrayOfByte);
  }
  
  public final byte[] getSessionRequestBuf(String paramString, byte[] paramArrayOfByte)
  {
    if (!com.tencent.mm.sdk.platformtools.ae.cqV()) {}
    do
    {
      return null;
      paramArrayOfByte = new ByteArrayOutputStream();
      keep_cdnGetSkeyBuf(paramString, paramArrayOfByte);
    } while (paramArrayOfByte.size() <= 0);
    return paramArrayOfByte.toByteArray();
  }
  
  public final void keep_OnRequestDoGetCdnDnsInfo(int paramInt)
  {
    g.DN();
    if (com.tencent.mm.kernel.a.Db()) {
      f.Na().is(paramInt + 1000);
    }
  }
  
  public final byte[] keep_cdnDecodePrepareResponse(String paramString, byte[] paramArrayOfByte)
  {
    if (this.eiv != null) {
      return this.eiv.f(paramString, paramArrayOfByte);
    }
    return null;
  }
  
  public final void keep_cdnGetSkeyBuf(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    if (this.eiv != null) {
      this.eiv.a(paramString, paramByteArrayOutputStream);
    }
  }
  
  public final void keep_cdnSendAndRecvData(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt2 < 0)) {}
    do
    {
      return;
      this.eiw += paramInt1;
      this.eix += paramInt2;
      if (!bk.bl(paramString)) {
        this.eiy = paramString;
      }
    } while ((this.eiw + this.eix <= 51200) || (this.eiz == null));
    this.eiz.S(500L, 500L);
  }
  
  public final void keep_onDataAvailable(String paramString, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.CdnTransportEngine", "keep_onDataAvailable %s, %d, %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.eiA != null) {
      this.eiA.onDataAvailable(paramString, paramInt1, paramInt2);
    }
  }
  
  public final int keep_onDownloadError(String paramString, d paramd)
  {
    if (this.eiA != null) {}
    for (int i = this.eiA.a(paramString, null, paramd);; i = 0)
    {
      if ((i == 0) && (this.eiv != null))
      {
        a(paramd);
        this.eiv.a(paramString, null, paramd);
      }
      return 0;
    }
  }
  
  public final int keep_onDownloadProgress(String paramString, com.tencent.mm.j.c paramc)
  {
    paramc.field_isUploadTask = false;
    if (this.eiA != null) {}
    for (int i = this.eiA.a(paramString, paramc, null);; i = 0)
    {
      if ((i == 0) && (this.eiv != null))
      {
        y.v("MicroMsg.CdnTransportEngine", "klem keep_onDownloadProgress mediaId:%s", new Object[] { paramString });
        this.eiv.a(paramString, paramc, null);
      }
      return 0;
    }
  }
  
  public final int keep_onDownloadSuccessed(String paramString, d paramd)
  {
    if (this.eiA != null) {}
    for (int i = this.eiA.a(paramString, null, paramd);; i = 0)
    {
      if ((i == 0) && (this.eiv != null))
      {
        a(paramd);
        this.eiv.a(paramString, null, paramd);
      }
      return 0;
    }
  }
  
  public final void keep_onDownloadToEnd(String paramString, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.CdnTransportEngine", "keep_onDownloadToEnd %s, %d, %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.eiA != null) {
      this.eiA.onDownloadToEnd(paramString, paramInt1, paramInt2);
    }
  }
  
  public final void keep_onMoovReady(String paramString, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.CdnTransportEngine", "keep_onMoovReady %s, %d, %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.eiA != null) {
      this.eiA.onMoovReady(paramString, paramInt1, paramInt2);
    }
  }
  
  public final int keep_onUploadError(String paramString, d paramd)
  {
    if (this.eiv != null)
    {
      a(paramd);
      this.eiv.a(paramString, null, paramd);
    }
    return 0;
  }
  
  public final int keep_onUploadProgress(String paramString, com.tencent.mm.j.c paramc)
  {
    paramc.field_isUploadTask = true;
    if (this.eiv != null)
    {
      y.v("MicroMsg.CdnTransportEngine", "klem keep_onUploadProgress mediaId:%s, totalLen%d, offset%d", new Object[] { paramString, Integer.valueOf(paramc.field_toltalLength), Integer.valueOf(paramc.field_finishedLength) });
      this.eiv.a(paramString, paramc, null);
    }
    return 0;
  }
  
  public final int keep_onUploadSuccessed(String paramString, d paramd)
  {
    if (this.eiv != null)
    {
      y.v("MicroMsg.CdnTransportEngine", "klem keep_onUploadSuccessed mediaId:%s", new Object[] { paramString });
      a(paramd);
      this.eiv.a(paramString, null, paramd);
    }
    return 0;
  }
  
  public final void onC2CDownloadCompleted(String paramString, CdnLogic.C2CDownloadResult paramC2CDownloadResult)
  {
    paramC2CDownloadResult = a(paramC2CDownloadResult, null);
    if (paramC2CDownloadResult.field_retCode != 0)
    {
      keep_onDownloadError(paramString, paramC2CDownloadResult);
      return;
    }
    keep_onDownloadSuccessed(paramString, paramC2CDownloadResult);
  }
  
  public final void onC2CUploadCompleted(String paramString, CdnLogic.C2CUploadResult paramC2CUploadResult)
  {
    d locald = new d();
    locald.field_retCode = paramC2CUploadResult.errorCode;
    locald.field_toUser = paramC2CUploadResult.touser;
    locald.field_UploadHitCacheType = paramC2CUploadResult.hitCache;
    locald.field_fileId = paramC2CUploadResult.fileid;
    locald.field_aesKey = paramC2CUploadResult.aeskey;
    locald.field_filemd5 = paramC2CUploadResult.filemd5;
    locald.field_thumbfilemd5 = paramC2CUploadResult.thumbfilemd5;
    locald.field_mp4identifymd5 = paramC2CUploadResult.mp4identifymd5;
    locald.field_transInfo = paramC2CUploadResult.transforMsg;
    locald.field_fileLength = paramC2CUploadResult.fileSize;
    locald.field_midimgLength = paramC2CUploadResult.midfileSize;
    locald.field_thumbimgLength = paramC2CUploadResult.thumbfileSize;
    if (!paramC2CUploadResult.sendmsgFromCDN) {}
    for (boolean bool = true;; bool = false)
    {
      locald.field_needSendMsgField = bool;
      locald.field_exist_whencheck = paramC2CUploadResult.existOnSvr;
      if (paramC2CUploadResult.skeyrespbuf != null) {
        locald.field_sKeyrespbuf = ((byte[])paramC2CUploadResult.skeyrespbuf.clone());
      }
      locald.field_videoFileId = paramC2CUploadResult.videofileid;
      locald.field_filecrc = paramC2CUploadResult.fileCrc32;
      locald.field_upload_by_safecdn = paramC2CUploadResult.uploadBySafecdn;
      locald.field_isVideoReduced = paramC2CUploadResult.isVideoReduced;
      if (paramC2CUploadResult.usedSvrIps != null) {
        locald.field_usedSvrIps = ((String[])paramC2CUploadResult.usedSvrIps.clone());
      }
      locald.field_fileUrl = paramC2CUploadResult.fileUrl;
      locald.field_thumbUrl = paramC2CUploadResult.thumbfileUrl;
      locald.field_isResume = paramC2CUploadResult.isResume;
      locald.field_delayTime = paramC2CUploadResult.delayTime;
      locald.field_connectCostTime = paramC2CUploadResult.connectCostTime;
      locald.field_waitResponseCostTime = paramC2CUploadResult.waitResponseCostTime;
      locald.field_receiveCostTime = paramC2CUploadResult.receiveCostTime;
      locald.field_clientIP = paramC2CUploadResult.clientIP;
      locald.field_serverIP = paramC2CUploadResult.serverIP;
      locald.field_clientHostIP = lK(paramC2CUploadResult.clientIP);
      locald.field_serverHostIP = lK(paramC2CUploadResult.serverIP);
      if (locald.field_retCode == 0) {
        break;
      }
      keep_onUploadError(paramString, locald);
      return;
    }
    keep_onUploadSuccessed(paramString, locald);
  }
  
  public final void onCheckFileidCompleted(String paramString, CdnLogic.CheckFileIDResult paramCheckFileIDResult) {}
  
  public final void onDataAvailable(String paramString, int paramInt1, int paramInt2)
  {
    keep_onDataAvailable(paramString, paramInt1, paramInt2);
  }
  
  public final void onDownloadToEnd(String paramString, int paramInt1, int paramInt2)
  {
    keep_onDownloadToEnd(paramString, paramInt1, paramInt2);
  }
  
  public final void onMoovReady(String paramString, int paramInt1, int paramInt2)
  {
    keep_onMoovReady(paramString, paramInt1, paramInt2);
  }
  
  public final void onPreloadCompleted(String paramString, int paramInt1, int paramInt2) {}
  
  public final void onPreloadCompletedWithResult(String paramString, int paramInt1, int paramInt2, CdnLogic.C2CDownloadResult paramC2CDownloadResult)
  {
    if (this.eiv != null)
    {
      paramC2CDownloadResult = a(paramC2CDownloadResult, null);
      this.eiv.a(paramString, paramC2CDownloadResult);
    }
  }
  
  public final void onProgressChanged(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    com.tencent.mm.j.c localc = new com.tencent.mm.j.c();
    localc.field_finishedLength = paramInt1;
    localc.field_toltalLength = paramInt2;
    localc.field_status = 0;
    localc.field_mtlnotify = paramBoolean;
    keep_onDownloadProgress(paramString, localc);
    keep_onUploadProgress(paramString, localc);
  }
  
  public final void onRecvedData(String paramString, int paramInt, byte[] paramArrayOfByte) {}
  
  public final String[] resolveHost(String paramString, boolean paramBoolean, int[] paramArrayOfInt)
  {
    if (!com.tencent.mm.sdk.platformtools.ae.cqV()) {
      return null;
    }
    y.i("MicroMsg.CdnTransportEngine", "try resolve host %s, isdc %b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    ArrayList localArrayList = new ArrayList();
    paramArrayOfInt[0] = b.a(paramString, paramBoolean, localArrayList);
    paramString = (String[])localArrayList.toArray(new String[0]);
    y.i("MicroMsg.CdnTransportEngine", "resolved dnstype %d iplist %s", new Object[] { Integer.valueOf(paramArrayOfInt[0]), Arrays.toString(paramString) });
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ak.a
 * JD-Core Version:    0.7.0.1
 */