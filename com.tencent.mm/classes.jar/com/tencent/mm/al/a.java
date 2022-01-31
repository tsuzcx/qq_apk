package com.tencent.mm.al;

import android.os.HandlerThread;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.AppCallback;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadResult;
import com.tencent.mars.cdn.CdnLogic.C2CUploadRequest;
import com.tencent.mars.cdn.CdnLogic.C2CUploadResult;
import com.tencent.mars.cdn.CdnLogic.CdnInfo;
import com.tencent.mars.cdn.CdnLogic.Config;
import com.tencent.mars.cdn.CdnLogic.DownloadCallback;
import com.tencent.mars.cdn.CdnLogic.SessionCallback;
import com.tencent.mars.cdn.CdnLogic.UploadCallback;
import com.tencent.mars.cdn.CdnLogic.VideoStreamingCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.b.a;
import com.tencent.mm.i.d;
import com.tencent.mm.network.b;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.nr;
import com.tencent.mm.protocal.protobuf.ns;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
  implements CdnLogic.AppCallback, CdnLogic.DownloadCallback, CdnLogic.SessionCallback, CdnLogic.UploadCallback, CdnLogic.VideoStreamingCallback
{
  private static int fyt = 7340033;
  private static int fyu = 100;
  private static int fyv = 101;
  private static int fyw = 102;
  private static int fyx = 103;
  private int fyA;
  private int fyB;
  private String fyC;
  private ap fyD;
  public a.a fyE;
  private nr fyy;
  b.a fyz;
  
  public a(String paramString, b.a parama)
  {
    AppMethodBeat.i(77970);
    this.fyy = null;
    this.fyz = null;
    this.fyA = 0;
    this.fyB = 0;
    this.fyC = "";
    this.fyD = null;
    if (ah.brt()) {
      this.fyD = new ap(com.tencent.mm.kernel.g.RO().oNc.getLooper(), new a.1(this), true);
    }
    this.fyz = parama;
    CdnLogic.Initialize(paramString, this, "1", "BFEDFFB5EA28509F9C89ED83FA7FDDA8881435D444E984D53A98AD8E9410F1145EDD537890E10456190B22E6E5006455EFC6C12E41FDA985F38FBBC7213ECB810E3053D4B8D74FFBC70B4600ABD728202322AFCE1406046631261BD5EE3D44721082FEAB74340D73645DC0D02A293B962B9D47E4A64100BD7524DE00D9D3B5C1", "010001", "cdnwx2013usrname");
    ab.i("MicroMsg.CdnTransportEngine", "summersafecdn CdnTransportEngine init[%s] infoPath[%s], stack[%s]", new Object[] { Integer.valueOf(hashCode()), paramString, bo.dtY() });
    AppMethodBeat.o(77970);
  }
  
  private static CdnLogic.C2CDownloadRequest a(com.tencent.mm.i.g paramg)
  {
    boolean bool2 = true;
    AppMethodBeat.i(77972);
    CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
    localC2CDownloadRequest.fileid = paramg.field_fileId;
    localC2CDownloadRequest.aeskey = paramg.field_aesKey;
    localC2CDownloadRequest.fileType = paramg.field_fileType;
    localC2CDownloadRequest.fileKey = paramg.field_mediaId;
    localC2CDownloadRequest.fileSize = paramg.field_totalLen;
    localC2CDownloadRequest.savePath = paramg.field_fullpath;
    localC2CDownloadRequest.isStorageMode = paramg.field_needStorage;
    if (paramg.field_smallVideoFlag == 1)
    {
      bool1 = true;
      localC2CDownloadRequest.isSmallVideo = bool1;
      if (paramg.field_largesvideo <= 0) {
        break label322;
      }
    }
    label322:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localC2CDownloadRequest.isLargeSVideo = bool1;
      localC2CDownloadRequest.limitRate = paramg.field_limitrate;
      localC2CDownloadRequest.isAutoStart = paramg.field_autostart;
      localC2CDownloadRequest.chatType = paramg.field_chattype;
      localC2CDownloadRequest.isSilentTask = paramg.field_isSilentTask;
      localC2CDownloadRequest.requestVideoFormat = paramg.field_requestVideoFormat;
      localC2CDownloadRequest.isColdSnsData = paramg.field_isColdSnsData;
      localC2CDownloadRequest.signalQuality = paramg.field_signalQuality;
      localC2CDownloadRequest.snsScene = paramg.field_snsScene;
      localC2CDownloadRequest.requestVideoFormat = paramg.field_requestVideoFormat;
      localC2CDownloadRequest.videofileid = paramg.field_videoFileId;
      localC2CDownloadRequest.bigfileSignature = paramg.field_svr_signature;
      if (bo.isNullOrNil(localC2CDownloadRequest.bigfileSignature)) {
        localC2CDownloadRequest.bigfileSignature = "";
      }
      localC2CDownloadRequest.fakeBigfileSignature = paramg.field_fake_bigfile_signature;
      if (bo.isNullOrNil(localC2CDownloadRequest.fakeBigfileSignature)) {
        localC2CDownloadRequest.fakeBigfileSignature = "";
      }
      localC2CDownloadRequest.fakeBigfileSignatureAeskey = paramg.field_fake_bigfile_signature_aeskey;
      if (bo.isNullOrNil(localC2CDownloadRequest.fakeBigfileSignatureAeskey)) {
        localC2CDownloadRequest.fakeBigfileSignatureAeskey = "";
      }
      localC2CDownloadRequest.msgExtra = paramg.field_wxmsgparam;
      if (bo.isNullOrNil(localC2CDownloadRequest.msgExtra)) {
        localC2CDownloadRequest.msgExtra = "";
      }
      localC2CDownloadRequest.queueTimeoutSeconds = 0;
      localC2CDownloadRequest.transforTimeoutSeconds = 0;
      localC2CDownloadRequest.preloadRatio = paramg.field_preloadRatio;
      localC2CDownloadRequest.certificateVerifyPolicy = paramg.certificateVerifyPolicy;
      localC2CDownloadRequest.expectImageFormat = paramg.expectImageFormat;
      AppMethodBeat.o(77972);
      return localC2CDownloadRequest;
      bool1 = false;
      break;
    }
  }
  
  private static CdnLogic.CdnInfo a(nr paramnr)
  {
    AppMethodBeat.i(77996);
    CdnLogic.CdnInfo localCdnInfo = new CdnLogic.CdnInfo();
    if (paramnr == null)
    {
      AppMethodBeat.o(77996);
      return localCdnInfo;
    }
    localCdnInfo.ver = paramnr.wCN;
    localCdnInfo.uin = paramnr.lGw;
    localCdnInfo.frontid = paramnr.wCP;
    localCdnInfo.zoneid = paramnr.wCU;
    localCdnInfo.nettype = c.ca(ah.getContext());
    localCdnInfo.authkey = aa.a(paramnr.wCT);
    if (paramnr.wCQ >= 2)
    {
      localCdnInfo.frontip1 = aa.a((bwc)paramnr.wCR.get(0));
      localCdnInfo.frontip2 = aa.a((bwc)paramnr.wCR.get(1));
      ab.i("MicroMsg.CdnTransportEngine", "frontip %s, %s", new Object[] { localCdnInfo.frontip1, localCdnInfo.frontip2 });
    }
    if (paramnr.wCV >= 2)
    {
      localCdnInfo.zoneip1 = aa.a((bwc)paramnr.wCW.get(0));
      localCdnInfo.zoneip2 = aa.a((bwc)paramnr.wCW.get(1));
      ab.i("MicroMsg.CdnTransportEngine", "zoneip %s, %s", new Object[] { localCdnInfo.frontip1, localCdnInfo.frontip2 });
    }
    int j;
    int i;
    if (paramnr.wCZ > 0)
    {
      j = ((ns)paramnr.wCX.get(0)).wDb;
      localCdnInfo.frontports = new int[j];
      i = 0;
      while (i < j)
      {
        localCdnInfo.frontports[i] = ((Integer)((ns)paramnr.wCX.get(0)).wDc.get(i)).intValue();
        i += 1;
      }
    }
    if (paramnr.wDa > 0)
    {
      j = ((ns)paramnr.wCY.get(0)).wDb;
      localCdnInfo.zoneports = new int[j];
      i = 0;
      while (i < j)
      {
        localCdnInfo.zoneports[i] = ((Integer)((ns)paramnr.wCY.get(0)).wDc.get(i)).intValue();
        i += 1;
      }
    }
    AppMethodBeat.o(77996);
    return localCdnInfo;
  }
  
  private static d a(CdnLogic.C2CDownloadResult paramC2CDownloadResult, d paramd)
  {
    AppMethodBeat.i(78001);
    d locald = paramd;
    if (paramd == null) {
      locald = new d();
    }
    locald.field_retCode = paramC2CDownloadResult.errorCode;
    locald.field_argInfo = paramC2CDownloadResult.argInfo;
    locald.field_fileLength = ((int)paramC2CDownloadResult.fileSize);
    locald.field_fileId = paramC2CDownloadResult.fileid;
    locald.field_transInfo = paramC2CDownloadResult.transforMsg;
    locald.field_convert2baseline = false;
    locald.field_recvedBytes = ((int)paramC2CDownloadResult.recvedBytes);
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
    locald.field_previousCompletedSize = paramC2CDownloadResult.previousCompletedSize;
    locald.field_averageRequestSize = paramC2CDownloadResult.averageRequestSize;
    locald.field_averageRequestCost = paramC2CDownloadResult.averageRequestCost;
    locald.field_requestTotalCount = paramC2CDownloadResult.requestTotalCount;
    locald.field_requestCompletedCount = paramC2CDownloadResult.requestCompletedCount;
    locald.field_requestTimeoutCount = paramC2CDownloadResult.requestTimeoutCount;
    locald.field_httpStatusCode = paramC2CDownloadResult.httpStatusCode;
    locald.field_httpResponseHeader = paramC2CDownloadResult.httpResponseHeader;
    locald.field_delayTime = paramC2CDownloadResult.delayTime;
    locald.field_dnsCostTime = paramC2CDownloadResult.dnsCostTime;
    locald.field_connectCostTime = paramC2CDownloadResult.connectCostTime;
    locald.field_waitResponseCostTime = paramC2CDownloadResult.waitResponseCostTime;
    locald.field_receiveCostTime = paramC2CDownloadResult.receiveCostTime;
    locald.field_clientIP = paramC2CDownloadResult.clientIP;
    locald.field_serverIP = paramC2CDownloadResult.serverIP;
    locald.field_clientHostIP = sH(paramC2CDownloadResult.clientIP);
    locald.field_serverHostIP = sH(paramC2CDownloadResult.serverIP);
    locald.field_xErrorNo = paramC2CDownloadResult.xErrorNo;
    locald.field_cSeqCheck = paramC2CDownloadResult.cSeqCheck;
    locald.field_usePrivateProtocol = paramC2CDownloadResult.usePrivateProtocol;
    locald.field_isCrossNet = paramC2CDownloadResult.crossNet;
    locald.field_clientIP = paramC2CDownloadResult.clientIP;
    locald.field_detailErrorType = paramC2CDownloadResult.detailErrorType;
    locald.field_detailErrorCode = paramC2CDownloadResult.detailErrorCode;
    if (paramC2CDownloadResult.usedSvrIps != null) {
      locald.field_usedSvrIps = ((String[])paramC2CDownloadResult.usedSvrIps.clone());
    }
    locald.field_isResume = paramC2CDownloadResult.isResume;
    locald.edd = paramC2CDownloadResult.isSnsImageProtocolAvailable;
    locald.index = paramC2CDownloadResult.picIndex;
    locald.cachePath = paramC2CDownloadResult.picCachePath;
    locald.czw = paramC2CDownloadResult.batchPicFeedId;
    locald.fileKey = paramC2CDownloadResult.batchImageFileKey;
    locald.ede = paramC2CDownloadResult.batchImageNeedRetry;
    AppMethodBeat.o(78001);
    return locald;
  }
  
  public static void a(a.b paramb)
  {
    AppMethodBeat.i(77999);
    ab.i("MicroMsg.CdnTransportEngine", "set WXConfig:".concat(String.valueOf(paramb)));
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
    if (!bo.isNullOrNil(paramb.field_ApprovedVideoHosts)) {
      localConfig.ApprovedVideoHosts = paramb.field_ApprovedVideoHosts;
    }
    localConfig.WifiEtl = paramb.field_WifiEtl;
    localConfig.MobileEtl = paramb.field_noWifiEtl;
    localConfig.onlyrecvPtl = paramb.field_onlyrecvPtl;
    localConfig.onlysendETL = paramb.field_onlysendETL;
    localConfig.Ptl = paramb.field_Ptl;
    CdnLogic.setConfig(localConfig);
    AppMethodBeat.o(77999);
  }
  
  private static void a(d paramd)
  {
    AppMethodBeat.i(78014);
    if ((paramd != null) && (!bo.isNullOrNil(paramd.field_transInfo)))
    {
      int i = paramd.field_transInfo.indexOf("@,");
      if (i > 0)
      {
        paramd.edb = paramd.field_transInfo.substring(i + 2);
        paramd.field_transInfo = paramd.field_transInfo.substring(0, i);
      }
      ab.v("MicroMsg.CdnTransportEngine", "transinfo:%s, report_part2:%s", new Object[] { paramd.field_transInfo, paramd.edb });
    }
    AppMethodBeat.o(78014);
  }
  
  public static String afG()
  {
    AppMethodBeat.i(77978);
    String str = CdnLogic.createAeskey();
    AppMethodBeat.o(77978);
    return str;
  }
  
  public static int b(String paramString, d paramd)
  {
    AppMethodBeat.i(77993);
    CdnLogic.C2CDownloadResult localC2CDownloadResult = new CdnLogic.C2CDownloadResult();
    int i = CdnLogic.cancelDownloadTaskWithResult(paramString, localC2CDownloadResult);
    a(localC2CDownloadResult, paramd);
    AppMethodBeat.o(77993);
    return i;
  }
  
  public static boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(77995);
    boolean bool = CdnLogic.isVideoDataAvailable(paramString, paramInt1, paramInt2);
    AppMethodBeat.o(77995);
    return bool;
  }
  
  public static int keep_callFromJni(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(77971);
    if (paramInt1 == fyu) {
      c.outputJniLog(paramArrayOfByte, "MicroMsg.CdnEngine", paramInt2);
    }
    AppMethodBeat.o(77971);
    return 0;
  }
  
  public static int r(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(77994);
    paramInt1 = CdnLogic.requestVideoData(paramString, paramInt1, paramInt2, 0);
    AppMethodBeat.o(77994);
    return paramInt1;
  }
  
  public static int sA(String paramString)
  {
    AppMethodBeat.i(77974);
    CdnLogic.cancelTask(paramString);
    AppMethodBeat.o(77974);
    return 0;
  }
  
  public static int sB(String paramString)
  {
    AppMethodBeat.i(77976);
    CdnLogic.cancelTask(paramString);
    AppMethodBeat.o(77976);
    return 0;
  }
  
  public static String sC(String paramString)
  {
    AppMethodBeat.i(77977);
    paramString = CdnLogic.calcFileMD5(paramString);
    AppMethodBeat.o(77977);
    return paramString;
  }
  
  public static int sD(String paramString)
  {
    AppMethodBeat.i(77979);
    int i = CdnLogic.calcFileCrc32(paramString);
    AppMethodBeat.o(77979);
    return i;
  }
  
  public static String sE(String paramString)
  {
    AppMethodBeat.i(77980);
    paramString = CdnLogic.calcMP4IdentifyMD5(paramString);
    AppMethodBeat.o(77980);
    return paramString;
  }
  
  public static int sF(String paramString)
  {
    AppMethodBeat.i(77987);
    ab.i("MicroMsg.CdnTransportEngine", "stopHttpsDownload: mediaid:".concat(String.valueOf(paramString)));
    CdnLogic.cancelTask(paramString);
    AppMethodBeat.o(77987);
    return 0;
  }
  
  public static int sG(String paramString)
  {
    AppMethodBeat.i(77989);
    ab.i("MicroMsg.CdnTransportEngine", "stopGamePackageDownload: mediaid:".concat(String.valueOf(paramString)));
    CdnLogic.cancelTask(paramString);
    AppMethodBeat.o(77989);
    return 0;
  }
  
  /* Error */
  private static int sH(String paramString)
  {
    // Byte code:
    //   0: ldc_w 1002
    //   3: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 125
    //   8: ldc_w 1004
    //   11: iconst_1
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: aload_0
    //   18: aastore
    //   19: invokestatic 148	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   22: aload_0
    //   23: ldc_w 1006
    //   26: invokevirtual 1010	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   29: ifne +29 -> 58
    //   32: aload_0
    //   33: ldc_w 1012
    //   36: invokevirtual 1010	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   39: ifne +19 -> 58
    //   42: ldc 125
    //   44: ldc_w 1014
    //   47: invokestatic 1017	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: ldc_w 1002
    //   53: invokestatic 151	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: iconst_0
    //   57: ireturn
    //   58: aload_0
    //   59: invokestatic 1023	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
    //   62: invokevirtual 1027	java/net/InetAddress:getAddress	()[B
    //   65: astore 5
    //   67: aload 5
    //   69: arraylength
    //   70: istore 4
    //   72: iconst_0
    //   73: istore_3
    //   74: iconst_0
    //   75: istore_1
    //   76: iload_1
    //   77: istore_2
    //   78: iload_3
    //   79: iload 4
    //   81: if_icmpge +28 -> 109
    //   84: iload_1
    //   85: bipush 8
    //   87: ishl
    //   88: aload 5
    //   90: iload_3
    //   91: baload
    //   92: sipush 255
    //   95: iand
    //   96: ior
    //   97: istore_1
    //   98: iload_3
    //   99: iconst_1
    //   100: iadd
    //   101: istore_3
    //   102: goto -26 -> 76
    //   105: astore 5
    //   107: iconst_0
    //   108: istore_2
    //   109: ldc 125
    //   111: ldc_w 1029
    //   114: iconst_2
    //   115: anewarray 4	java/lang/Object
    //   118: dup
    //   119: iconst_0
    //   120: aload_0
    //   121: aastore
    //   122: dup
    //   123: iconst_1
    //   124: iload_2
    //   125: invokestatic 137	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   128: aastore
    //   129: invokestatic 148	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   132: ldc_w 1002
    //   135: invokestatic 151	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: iload_2
    //   139: ireturn
    //   140: astore 5
    //   142: iconst_0
    //   143: istore_2
    //   144: goto -35 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	paramString	String
    //   75	23	1	i	int
    //   77	67	2	j	int
    //   73	29	3	k	int
    //   70	12	4	m	int
    //   65	24	5	arrayOfByte	byte[]
    //   105	1	5	localNullPointerException	java.lang.NullPointerException
    //   140	1	5	localUnknownHostException	java.net.UnknownHostException
    // Exception table:
    //   from	to	target	type
    //   22	50	105	java/lang/NullPointerException
    //   58	72	105	java/lang/NullPointerException
    //   22	50	140	java/net/UnknownHostException
    //   58	72	140	java/net/UnknownHostException
  }
  
  public final int a(com.tencent.mm.i.f paramf)
  {
    AppMethodBeat.i(77985);
    CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
    localC2CDownloadRequest.fileType = 20201;
    localC2CDownloadRequest.fileKey = paramf.field_mediaId;
    localC2CDownloadRequest.url = paramf.url;
    localC2CDownloadRequest.referer = paramf.referer;
    if (paramf.edh != null)
    {
      arrayOfString = (String[])paramf.edh.clone();
      localC2CDownloadRequest.ocIpList = arrayOfString;
      localC2CDownloadRequest.ocIpListSource = paramf.edj;
      if (paramf.edi == null) {
        break label232;
      }
    }
    label232:
    for (String[] arrayOfString = (String[])paramf.edi.clone();; arrayOfString = null)
    {
      localC2CDownloadRequest.dcIpList = arrayOfString;
      localC2CDownloadRequest.dcIpListSource = paramf.edk;
      localC2CDownloadRequest.isColdSnsData = paramf.isColdSnsData;
      localC2CDownloadRequest.signalQuality = paramf.signalQuality;
      localC2CDownloadRequest.snsScene = paramf.snsScene;
      localC2CDownloadRequest.concurrentCount = 6;
      localC2CDownloadRequest.marscdnBizType = paramf.dqS;
      localC2CDownloadRequest.marscdnAppType = paramf.edl;
      localC2CDownloadRequest.fileType = paramf.fileType;
      localC2CDownloadRequest.msgType = 2;
      localC2CDownloadRequest.feedId = paramf.czw;
      localC2CDownloadRequest.feedPicCount = paramf.edm;
      localC2CDownloadRequest.batchSnsReqImageDatas = paramf.ede;
      int i = CdnLogic.startSNSDownload(localC2CDownloadRequest, this, this, 0);
      AppMethodBeat.o(77985);
      return i;
      arrayOfString = null;
      break;
    }
  }
  
  public final int a(com.tencent.mm.i.g paramg, int paramInt)
  {
    AppMethodBeat.i(77990);
    paramInt = CdnLogic.startVideoStreamingDownload(a(paramg), this, this, paramInt);
    AppMethodBeat.o(77990);
    return paramInt;
  }
  
  public final int a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String[] paramArrayOfString, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(77982);
    if (paramArrayOfString == null) {}
    CdnLogic.C2CDownloadRequest localC2CDownloadRequest;
    for (;;)
    {
      ab.i("MicroMsg.CdnTransportEngine", "startURLDownload: mediaid:%s, savepath:%s, filetype:%d, timeout:%d, %d, ip.size:%d, gzip:%b", new Object[] { paramString1, paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(i), Boolean.valueOf(paramBoolean) });
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
      if (com.tencent.mm.i.a.ecS != localC2CDownloadRequest.fileType) {
        break;
      }
      paramInt1 = CdnLogic.startHttpsDownload(localC2CDownloadRequest, this);
      AppMethodBeat.o(77982);
      return paramInt1;
      i = paramArrayOfString.length;
    }
    paramInt1 = CdnLogic.startURLDownload(localC2CDownloadRequest, this);
    AppMethodBeat.o(77982);
    return paramInt1;
  }
  
  public final int a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5)
  {
    AppMethodBeat.i(77981);
    ab.i("MicroMsg.CdnTransportEngine", "startURLDownload: mediaid:%s, savepath:%s", new Object[] { paramString1, paramString3 });
    CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
    localC2CDownloadRequest.fileKey = paramString1;
    localC2CDownloadRequest.url = paramString2;
    localC2CDownloadRequest.savePath = paramString3;
    localC2CDownloadRequest.aeskey = paramString4;
    localC2CDownloadRequest.customHttpHeader = ("authkey: " + paramString5 + "\r\n");
    localC2CDownloadRequest.fileType = paramInt;
    paramInt = CdnLogic.startSNSDownload(localC2CDownloadRequest, this, this, 0);
    AppMethodBeat.o(77981);
    return paramInt;
  }
  
  public final int a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(77992);
    CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
    localC2CDownloadRequest.fileKey = paramString1;
    localC2CDownloadRequest.fileType = 90;
    localC2CDownloadRequest.url = paramString2;
    localC2CDownloadRequest.referer = paramString3;
    localC2CDownloadRequest.savePath = paramString4;
    localC2CDownloadRequest.preloadRatio = paramInt2;
    localC2CDownloadRequest.concurrentCount = paramInt3;
    localC2CDownloadRequest.maxHttpRedirectCount = 100;
    paramInt1 = CdnLogic.startHttpVideoStreamingDownload(localC2CDownloadRequest, this, this, paramInt1);
    AppMethodBeat.o(77992);
    return paramInt1;
  }
  
  public final int a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String[] paramArrayOfString, int paramInt2)
  {
    AppMethodBeat.i(77991);
    CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
    localC2CDownloadRequest.fileKey = paramString1;
    localC2CDownloadRequest.url = paramString2;
    localC2CDownloadRequest.referer = paramString3;
    localC2CDownloadRequest.savePath = paramString4;
    localC2CDownloadRequest.fileSize = 0;
    localC2CDownloadRequest.fileType = 20210;
    localC2CDownloadRequest.concurrentCount = 10;
    if (paramArrayOfString != null) {}
    for (localC2CDownloadRequest.ocIpList = ((String[])paramArrayOfString.clone());; localC2CDownloadRequest.ocIpList = null)
    {
      localC2CDownloadRequest.preloadRatio = paramInt2;
      paramInt1 = CdnLogic.startHttpVideoStreamingDownload(localC2CDownloadRequest, this, this, paramInt1);
      AppMethodBeat.o(77991);
      return paramInt1;
    }
  }
  
  public final int a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String[] paramArrayOfString, boolean paramBoolean, String paramString5, String paramString6, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(77984);
    CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
    localC2CDownloadRequest.fileType = 20302;
    localC2CDownloadRequest.fileKey = paramString1;
    localC2CDownloadRequest.url = paramString2;
    localC2CDownloadRequest.referer = paramString3;
    localC2CDownloadRequest.savePath = paramString4;
    localC2CDownloadRequest.fileSize = 0;
    if (paramArrayOfString != null) {}
    for (localC2CDownloadRequest.ocIpList = ((String[])paramArrayOfString.clone());; localC2CDownloadRequest.ocIpList = null)
    {
      localC2CDownloadRequest.isColdSnsData = paramBoolean;
      localC2CDownloadRequest.signalQuality = paramString5;
      localC2CDownloadRequest.snsScene = paramString6;
      localC2CDownloadRequest.preloadRatio = paramInt2;
      localC2CDownloadRequest.requestVideoFormat = paramInt3;
      localC2CDownloadRequest.connectionCount = paramInt4;
      localC2CDownloadRequest.marscdnAppType = 205;
      paramInt1 = CdnLogic.startSNSDownload(localC2CDownloadRequest, this, this, paramInt1);
      AppMethodBeat.o(77984);
      return paramInt1;
    }
  }
  
  public final int a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String[] paramArrayOfString, boolean paramBoolean, String paramString5, String paramString6, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(151545);
    CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
    localC2CDownloadRequest.fileType = 20202;
    localC2CDownloadRequest.fileKey = paramString1;
    localC2CDownloadRequest.url = paramString2;
    localC2CDownloadRequest.referer = paramString3;
    localC2CDownloadRequest.savePath = paramString4;
    localC2CDownloadRequest.fileSize = 0;
    if (paramArrayOfString != null) {}
    for (localC2CDownloadRequest.ocIpList = ((String[])paramArrayOfString.clone());; localC2CDownloadRequest.ocIpList = null)
    {
      localC2CDownloadRequest.isColdSnsData = paramBoolean;
      localC2CDownloadRequest.signalQuality = paramString5;
      localC2CDownloadRequest.snsScene = paramString6;
      localC2CDownloadRequest.preloadRatio = paramInt2;
      localC2CDownloadRequest.requestVideoFormat = paramInt3;
      localC2CDownloadRequest.connectionCount = paramInt4;
      localC2CDownloadRequest.concurrentCount = paramInt5;
      paramInt1 = CdnLogic.startSNSDownload(localC2CDownloadRequest, this, this, paramInt1);
      AppMethodBeat.o(151545);
      return paramInt1;
    }
  }
  
  public final int a(String paramString1, String paramString2, String paramString3, String paramString4, Map<String, String> paramMap, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, boolean paramBoolean3, String[] paramArrayOfString)
  {
    AppMethodBeat.i(77988);
    ab.i("MicroMsg.CdnTransportEngine", "startGamePackageDownload: mediaid:".concat(String.valueOf(paramString1)));
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
    localC2CDownloadRequest.maxHttpRedirectCount = 18;
    paramInt1 = CdnLogic.startHttpMultiSocketDownloadTask(localC2CDownloadRequest, this);
    AppMethodBeat.o(77988);
    return paramInt1;
  }
  
  public final int a(String paramString1, String paramString2, String paramString3, String paramString4, String[] paramArrayOfString1, String[] paramArrayOfString2, int paramInt1, int paramInt2, boolean paramBoolean, String paramString5, String paramString6, String paramString7, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(77986);
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)) || (bo.isNullOrNil(paramString4)))
    {
      ab.e("MicroMsg.CdnTransportEngine", "invalid param.");
      AppMethodBeat.o(77986);
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
        break label226;
      }
    }
    label226:
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
      paramInt1 = CdnLogic.startSNSDownload(localC2CDownloadRequest, this, this, 0);
      AppMethodBeat.o(77986);
      return paramInt1;
      paramString1 = null;
      break;
    }
  }
  
  public final boolean a(nr paramnr1, nr paramnr2, nr paramnr3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, nr paramnr4)
  {
    AppMethodBeat.i(77997);
    ab.i("MicroMsg.CdnTransportEngine", "summersafecdn cdntra setCDNDnsInfo old [%s]  new [%s], safecdn [%s], stack[%s]", new Object[] { this.fyy, paramnr1, paramnr4, bo.dtY() });
    if ((paramnr1 == null) && (paramArrayOfByte1 == null))
    {
      AppMethodBeat.o(77997);
      return false;
    }
    this.fyy = paramnr1;
    try
    {
      paramnr1 = a(paramnr1);
      paramnr2 = a(paramnr2);
      paramnr3 = a(paramnr3);
      paramnr4 = a(paramnr4);
      CdnLogic.setLegacyCdnInfo(paramnr1, paramnr2, paramnr3, paramnr4, paramArrayOfByte1, paramArrayOfByte2);
      CdnLogic.setDebugIP("");
      if ((ae.gld) && (ae.gkU != null) && (ae.gkU.length() >= 7))
      {
        ab.w("MicroMsg.CdnTransportEngine", "setcdndns use debugip %s", new Object[] { ae.gkU });
        CdnLogic.setDebugIP(ae.gkU);
      }
      AppMethodBeat.o(77997);
      return true;
    }
    catch (Exception paramnr1)
    {
      ab.e("MicroMsg.CdnTransportEngine", "tocdninfo failed:" + paramnr1.getLocalizedMessage());
      AppMethodBeat.o(77997);
    }
    return false;
  }
  
  public final boolean afH()
  {
    return this.fyy == null;
  }
  
  public final a.b afI()
  {
    AppMethodBeat.i(77998);
    a.b localb = new a.b(this);
    AppMethodBeat.o(77998);
    return localb;
  }
  
  public final int b(com.tencent.mm.i.g paramg)
  {
    boolean bool2 = true;
    AppMethodBeat.i(77973);
    CdnLogic.C2CUploadRequest localC2CUploadRequest = new CdnLogic.C2CUploadRequest();
    localC2CUploadRequest.fileKey = paramg.field_mediaId;
    localC2CUploadRequest.filePath = paramg.field_fullpath;
    localC2CUploadRequest.thumbfilePath = paramg.field_thumbpath;
    localC2CUploadRequest.fileSize = paramg.field_totalLen;
    localC2CUploadRequest.fileType = paramg.field_fileType;
    localC2CUploadRequest.forwardAeskey = paramg.field_aesKey;
    localC2CUploadRequest.forwardFileid = paramg.field_fileId;
    localC2CUploadRequest.midfileSize = paramg.field_midFileLength;
    localC2CUploadRequest.queueTimeoutSeconds = 0;
    localC2CUploadRequest.transforTimeoutSeconds = 0;
    localC2CUploadRequest.toUser = paramg.field_talker;
    localC2CUploadRequest.sendmsgFromCDN = paramg.field_sendmsg_viacdn;
    localC2CUploadRequest.needCompressImage = paramg.field_needCompressImage;
    localC2CUploadRequest.chatType = paramg.field_chattype;
    localC2CUploadRequest.apptype = paramg.field_appType;
    localC2CUploadRequest.bizscene = paramg.field_bzScene;
    localC2CUploadRequest.checkExistOnly = paramg.field_onlycheckexist;
    if (paramg.field_smallVideoFlag == 1)
    {
      bool1 = true;
      localC2CUploadRequest.isSmallVideo = bool1;
      localC2CUploadRequest.isLargeSVideo = paramg.field_largesvideo;
      localC2CUploadRequest.videoSource = paramg.field_videosource;
      if (paramg.field_advideoflag != 1) {
        break label389;
      }
    }
    label389:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localC2CUploadRequest.isSnsAdVideo = bool1;
      localC2CUploadRequest.isStorageMode = paramg.field_needStorage;
      localC2CUploadRequest.isStreamMedia = paramg.field_isStreamMedia;
      localC2CUploadRequest.enableHitCheck = paramg.field_enable_hitcheck;
      localC2CUploadRequest.forceNoSafeCdn = paramg.field_force_aeskeycdn;
      localC2CUploadRequest.trySafeCdn = paramg.field_trysafecdn;
      localC2CUploadRequest.midimgPath = paramg.field_midimgpath;
      localC2CUploadRequest.bigfileSignature = paramg.field_svr_signature;
      if (bo.isNullOrNil(localC2CUploadRequest.bigfileSignature)) {
        localC2CUploadRequest.bigfileSignature = "";
      }
      localC2CUploadRequest.fakeBigfileSignature = paramg.field_fake_bigfile_signature;
      if (bo.isNullOrNil(localC2CUploadRequest.fakeBigfileSignature)) {
        localC2CUploadRequest.fakeBigfileSignature = "";
      }
      localC2CUploadRequest.fakeBigfileSignatureAeskey = paramg.field_fake_bigfile_signature_aeskey;
      if (bo.isNullOrNil(localC2CUploadRequest.fakeBigfileSignatureAeskey)) {
        localC2CUploadRequest.fakeBigfileSignatureAeskey = "";
      }
      localC2CUploadRequest.lastError = paramg.lastError;
      if (!localC2CUploadRequest.sendmsgFromCDN) {
        break label394;
      }
      i = CdnLogic.startSSUpload(localC2CUploadRequest, this, this);
      AppMethodBeat.o(77973);
      return i;
      bool1 = false;
      break;
    }
    label394:
    int i = CdnLogic.startC2CUpload(localC2CUploadRequest, this);
    AppMethodBeat.o(77973);
    return i;
  }
  
  public final int c(com.tencent.mm.i.g paramg)
  {
    AppMethodBeat.i(77975);
    int i = CdnLogic.startC2CDownload(a(paramg), this);
    AppMethodBeat.o(77975);
    return i;
  }
  
  public final byte[] decodeSessionResponseBuf(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78023);
    if (!ah.brt())
    {
      AppMethodBeat.o(78023);
      return null;
    }
    paramString = keep_cdnDecodePrepareResponse(paramString, paramArrayOfByte);
    AppMethodBeat.o(78023);
    return paramString;
  }
  
  public final byte[] getSessionRequestBuf(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78022);
    if (!ah.brt())
    {
      AppMethodBeat.o(78022);
      return null;
    }
    paramArrayOfByte = new ByteArrayOutputStream();
    keep_cdnGetSkeyBuf(paramString, paramArrayOfByte);
    if (paramArrayOfByte.size() > 0)
    {
      paramString = paramArrayOfByte.toByteArray();
      AppMethodBeat.o(78022);
      return paramString;
    }
    AppMethodBeat.o(78022);
    return null;
  }
  
  public final void keep_OnRequestDoGetCdnDnsInfo(int paramInt)
  {
    AppMethodBeat.i(78016);
    com.tencent.mm.kernel.g.RJ();
    if (com.tencent.mm.kernel.a.QT()) {
      f.afL().le(paramInt);
    }
    AppMethodBeat.o(78016);
  }
  
  public final byte[] keep_cdnDecodePrepareResponse(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78009);
    if (this.fyz != null)
    {
      paramString = this.fyz.l(paramString, paramArrayOfByte);
      AppMethodBeat.o(78009);
      return paramString;
    }
    AppMethodBeat.o(78009);
    return null;
  }
  
  public final void keep_cdnGetSkeyBuf(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    AppMethodBeat.i(78008);
    if (this.fyz != null) {
      this.fyz.a(paramString, paramByteArrayOutputStream);
    }
    AppMethodBeat.o(78008);
  }
  
  public final void keep_cdnSendAndRecvData(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(78015);
    if ((paramInt1 < 0) || (paramInt2 < 0))
    {
      AppMethodBeat.o(78015);
      return;
    }
    this.fyA += paramInt1;
    this.fyB += paramInt2;
    if (!bo.isNullOrNil(paramString)) {
      this.fyC = paramString;
    }
    if ((this.fyA + this.fyB > 51200) && (this.fyD != null)) {
      this.fyD.ag(500L, 500L);
    }
    AppMethodBeat.o(78015);
  }
  
  public final void keep_onDataAvailable(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(151547);
    ab.i("MicroMsg.CdnTransportEngine", "keep_onDataAvailable %s, %d, %d", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if (this.fyE != null) {
      this.fyE.m(paramString, (int)paramLong1, (int)paramLong2);
    }
    AppMethodBeat.o(151547);
  }
  
  public final int keep_onDownloadError(String paramString, d paramd)
  {
    AppMethodBeat.i(78006);
    if (this.fyE != null) {}
    for (int i = this.fyE.a(paramString, null, paramd);; i = 0)
    {
      if ((i == 0) && (this.fyz != null))
      {
        a(paramd);
        this.fyz.a(paramString, null, paramd);
      }
      AppMethodBeat.o(78006);
      return 0;
    }
  }
  
  public final int keep_onDownloadProgress(String paramString, com.tencent.mm.i.c paramc)
  {
    AppMethodBeat.i(78005);
    paramc.field_isUploadTask = false;
    if (this.fyE != null) {}
    for (int i = this.fyE.a(paramString, paramc, null);; i = 0)
    {
      if ((i == 0) && (this.fyz != null))
      {
        ab.v("MicroMsg.CdnTransportEngine", "klem keep_onDownloadProgress mediaId:%s", new Object[] { paramString });
        this.fyz.a(paramString, paramc, null);
      }
      AppMethodBeat.o(78005);
      return 0;
    }
  }
  
  public final int keep_onDownloadSuccessed(String paramString, d paramd)
  {
    AppMethodBeat.i(78007);
    if (this.fyE != null) {}
    for (int i = this.fyE.a(paramString, null, paramd);; i = 0)
    {
      if ((i == 0) && (this.fyz != null))
      {
        a(paramd);
        this.fyz.a(paramString, null, paramd);
      }
      AppMethodBeat.o(78007);
      return 0;
    }
  }
  
  public final void keep_onDownloadToEnd(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(151548);
    ab.i("MicroMsg.CdnTransportEngine", "keep_onDownloadToEnd %s, %d, %d", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if (this.fyE != null) {
      this.fyE.s(paramString, (int)paramLong1, (int)paramLong2);
    }
    AppMethodBeat.o(151548);
  }
  
  public final void keep_onMoovReady(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(151546);
    ab.i("MicroMsg.CdnTransportEngine", "keep_onMoovReady %s, %d, %d, hash[%d]", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(hashCode()) });
    if (this.fyE != null)
    {
      this.fyE.l(paramString, (int)paramLong1, (int)paramLong2);
      AppMethodBeat.o(151546);
      return;
    }
    ab.e("MicroMsg.CdnTransportEngine", "cdn call on moov ready but onlineVideoCallback is null.hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
    h.qsU.cT(354, 29);
    AppMethodBeat.o(151546);
  }
  
  public final int keep_onUploadError(String paramString, d paramd)
  {
    AppMethodBeat.i(78003);
    if (this.fyz != null)
    {
      a(paramd);
      this.fyz.a(paramString, null, paramd);
    }
    AppMethodBeat.o(78003);
    return 0;
  }
  
  public final int keep_onUploadProgress(String paramString, com.tencent.mm.i.c paramc)
  {
    AppMethodBeat.i(78002);
    paramc.field_isUploadTask = true;
    if (this.fyz != null)
    {
      ab.v("MicroMsg.CdnTransportEngine", "klem keep_onUploadProgress mediaId:%s, totalLen%d, offset%d", new Object[] { paramString, Integer.valueOf(paramc.field_toltalLength), Integer.valueOf(paramc.field_finishedLength) });
      this.fyz.a(paramString, paramc, null);
    }
    AppMethodBeat.o(78002);
    return 0;
  }
  
  public final int keep_onUploadSuccessed(String paramString, d paramd)
  {
    AppMethodBeat.i(78004);
    if (this.fyz != null)
    {
      ab.v("MicroMsg.CdnTransportEngine", "klem keep_onUploadSuccessed mediaId:%s", new Object[] { paramString });
      a(paramd);
      this.fyz.a(paramString, null, paramd);
    }
    AppMethodBeat.o(78004);
    return 0;
  }
  
  public final void onC2CDownloadCompleted(String paramString, CdnLogic.C2CDownloadResult paramC2CDownloadResult)
  {
    AppMethodBeat.i(78025);
    d locald = a(paramC2CDownloadResult, null);
    if (locald.field_retCode != 0)
    {
      com.tencent.mm.g.b.a.g localg1 = new com.tencent.mm.g.b.a.g();
      com.tencent.mm.g.b.a.g localg2 = localg1.eR(paramString);
      localg2.cPS = 1;
      localg2.cPT = paramC2CDownloadResult.detailErrorType;
      localg2.cPU = paramC2CDownloadResult.detailErrorCode;
      localg2.cPV = paramC2CDownloadResult.errorCode;
      localg2.cPX = paramC2CDownloadResult.fileType;
      localg2.cPY = paramC2CDownloadResult.tryWritenBytes;
      localg2.cPZ = paramC2CDownloadResult.availableBytes;
      localg2.eS(paramC2CDownloadResult.systemErrorDescribe).cQb = paramC2CDownloadResult.currentFileSize;
      localg1.ake();
      ab.i("MicroMsg.CdnTransportEngine", "reportstr %s", new Object[] { localg1.Fg() });
      keep_onDownloadError(paramString, locald);
      AppMethodBeat.o(78025);
      return;
    }
    keep_onDownloadSuccessed(paramString, locald);
    AppMethodBeat.o(78025);
  }
  
  public final void onC2CUploadCompleted(String paramString, CdnLogic.C2CUploadResult paramC2CUploadResult)
  {
    AppMethodBeat.i(78021);
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
      locald.field_clientHostIP = sH(paramC2CUploadResult.clientIP);
      locald.field_serverHostIP = sH(paramC2CUploadResult.serverIP);
      locald.field_detailErrorType = paramC2CUploadResult.detailErrorType;
      locald.field_detailErrorCode = paramC2CUploadResult.detailErrorCode;
      if (locald.field_retCode == 0) {
        break;
      }
      com.tencent.mm.g.b.a.g localg1 = new com.tencent.mm.g.b.a.g();
      com.tencent.mm.g.b.a.g localg2 = localg1.eR(paramString);
      localg2.cPS = 0;
      localg2.cPT = paramC2CUploadResult.detailErrorType;
      localg2.cPU = paramC2CUploadResult.detailErrorCode;
      localg2.cPV = paramC2CUploadResult.errorCode;
      localg2.cPX = paramC2CUploadResult.filetype;
      localg2.cPY = 0L;
      localg2.cPZ = 0L;
      localg2.eS(paramC2CUploadResult.systemErrorDescribe);
      localg1.ake();
      ab.i("MicroMsg.CdnTransportEngine", "reportstr %s", new Object[] { localg1.Fg() });
      keep_onUploadError(paramString, locald);
      AppMethodBeat.o(78021);
      return;
    }
    keep_onUploadSuccessed(paramString, locald);
    AppMethodBeat.o(78021);
  }
  
  public final void onDataAvailable(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(151552);
    keep_onDataAvailable(paramString, paramLong1, paramLong2);
    AppMethodBeat.o(151552);
  }
  
  public final void onDownloadProgressChanged(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(151550);
    com.tencent.mm.i.c localc = new com.tencent.mm.i.c();
    localc.field_finishedLength = ((int)paramLong1);
    localc.field_toltalLength = ((int)paramLong2);
    localc.field_status = 0;
    localc.field_mtlnotify = paramBoolean;
    keep_onDownloadProgress(paramString, localc);
    AppMethodBeat.o(151550);
  }
  
  public final void onDownloadToEnd(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(151553);
    keep_onDownloadToEnd(paramString, paramLong1, paramLong2);
    AppMethodBeat.o(151553);
  }
  
  public final void onMoovReady(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(151551);
    keep_onMoovReady(paramString, paramLong1, paramLong2);
    AppMethodBeat.o(151551);
  }
  
  public final void onPreloadCompletedWithResult(String paramString, long paramLong1, long paramLong2, CdnLogic.C2CDownloadResult paramC2CDownloadResult)
  {
    AppMethodBeat.i(151554);
    if (this.fyz != null)
    {
      paramC2CDownloadResult.recvedBytes = ((int)paramLong1);
      paramC2CDownloadResult = a(paramC2CDownloadResult, null);
      this.fyz.a(paramString, paramC2CDownloadResult);
    }
    AppMethodBeat.o(151554);
  }
  
  public final void onUploadProgressChanged(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(151549);
    com.tencent.mm.i.c localc = new com.tencent.mm.i.c();
    localc.field_finishedLength = ((int)paramLong1);
    localc.field_toltalLength = ((int)paramLong2);
    localc.field_status = 0;
    localc.field_mtlnotify = false;
    keep_onUploadProgress(paramString, localc);
    AppMethodBeat.o(151549);
  }
  
  public final void reportFlow(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(78018);
    if (!ah.brt())
    {
      AppMethodBeat.o(78018);
      return;
    }
    ab.i("MicroMsg.CdnTransportEngine", "ReportFlow, wifi:s:%d, r:%d, mobile:s:%d, r:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt4), Integer.valueOf(paramInt3) });
    keep_cdnSendAndRecvData("dummy clientmsgid", paramInt2 + paramInt4, paramInt1 + paramInt3);
    AppMethodBeat.o(78018);
  }
  
  public final void requestGetCDN(int paramInt)
  {
    AppMethodBeat.i(78017);
    if (!ah.brt())
    {
      AppMethodBeat.o(78017);
      return;
    }
    ab.i("MicroMsg.CdnTransportEngine", "requestgetcdn scene %d", new Object[] { Integer.valueOf(paramInt) });
    keep_OnRequestDoGetCdnDnsInfo(paramInt);
    AppMethodBeat.o(78017);
  }
  
  public final String[] resolveHost(String paramString, boolean paramBoolean, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(78019);
    if (!ah.brt())
    {
      AppMethodBeat.o(78019);
      return null;
    }
    ab.i("MicroMsg.CdnTransportEngine", "try resolve host %s, isdc %b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    ArrayList localArrayList = new ArrayList();
    paramArrayOfInt[0] = b.a(paramString, paramBoolean, localArrayList);
    paramString = (String[])localArrayList.toArray(new String[0]);
    ab.i("MicroMsg.CdnTransportEngine", "resolved dnstype %d iplist %s", new Object[] { Integer.valueOf(paramArrayOfInt[0]), Arrays.toString(paramString) });
    AppMethodBeat.o(78019);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.al.a
 * JD-Core Version:    0.7.0.1
 */