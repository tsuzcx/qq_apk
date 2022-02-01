package com.tencent.mm.an;

import android.os.HandlerThread;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.AppCallback;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadResult;
import com.tencent.mars.cdn.CdnLogic.C2CUploadRequest;
import com.tencent.mars.cdn.CdnLogic.C2CUploadResult;
import com.tencent.mars.cdn.CdnLogic.CdnInfo;
import com.tencent.mars.cdn.CdnLogic.CronetTaskResult;
import com.tencent.mars.cdn.CdnLogic.DownloadCallback;
import com.tencent.mars.cdn.CdnLogic.SessionCallback;
import com.tencent.mars.cdn.CdnLogic.UploadCallback;
import com.tencent.mars.cdn.CdnLogic.VideoStreamingCallback;
import com.tencent.mars.cdn.CdnLogic.WebPageProfile;
import com.tencent.mars.stn.StnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.e;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.qg;
import com.tencent.mm.protocal.protobuf.qh;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
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
  private static int hAQ = 7340033;
  private static int hAR = 100;
  private static int hAS = 101;
  private static int hAT = 102;
  private static int hAU = 103;
  private qg hAV;
  private com.tencent.mm.i.b.a hAW;
  com.tencent.mm.i.b.a hAX;
  private int hAY;
  private int hAZ;
  private String hBa;
  private au hBb;
  a hBc;
  public a hBd;
  
  public a(String paramString, com.tencent.mm.i.b.a parama)
  {
    AppMethodBeat.i(150333);
    this.hAV = null;
    this.hAW = null;
    this.hAX = null;
    this.hAY = 0;
    this.hAZ = 0;
    this.hBa = "";
    this.hBb = null;
    if (ai.ciE()) {
      this.hBb = new au(com.tencent.mm.kernel.g.agU().GrZ.getLooper(), new au.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(150332);
          if ((a.a(a.this) == 0) && (a.b(a.this) == 0))
          {
            AppMethodBeat.o(150332);
            return false;
          }
          ac.i("MicroMsg.CdnTransportEngine", "CdnDataFlowStat id:%s send:%d recv:%d", new Object[] { a.c(a.this), Integer.valueOf(a.a(a.this)), Integer.valueOf(a.b(a.this)) });
          if (ar.a.hnx == null)
          {
            ac.e("MicroMsg.CdnTransportEngine", "getNetStat null");
            AppMethodBeat.o(150332);
            return false;
          }
          ar.a.hnx.cZ(a.b(a.this), a.a(a.this));
          a.d(a.this);
          a.e(a.this);
          AppMethodBeat.o(150332);
          return true;
        }
      }, true);
    }
    this.hAX = parama;
    CdnLogic.Initialize(paramString, this, "1", "BFEDFFB5EA28509F9C89ED83FA7FDDA8881435D444E984D53A98AD8E9410F1145EDD537890E10456190B22E6E5006455EFC6C12E41FDA985F38FBBC7213ECB810E3053D4B8D74FFBC70B4600ABD728202322AFCE1406046631261BD5EE3D44721082FEAB74340D73645DC0D02A293B962B9D47E4A64100BD7524DE00D9D3B5C1", "010001", "cdnwx2013usrname");
    ac.i("MicroMsg.CdnTransportEngine", "summersafecdn CdnTransportEngine init[%s] infoPath[%s], stack[%s]", new Object[] { Integer.valueOf(hashCode()), paramString, bs.eWi() });
    AppMethodBeat.o(150333);
  }
  
  public static int BI(String paramString)
  {
    AppMethodBeat.i(150337);
    CdnLogic.cancelTask(paramString);
    AppMethodBeat.o(150337);
    return 0;
  }
  
  public static int BJ(String paramString)
  {
    AppMethodBeat.i(150339);
    CdnLogic.cancelTask(paramString);
    AppMethodBeat.o(150339);
    return 0;
  }
  
  public static String BK(String paramString)
  {
    AppMethodBeat.i(150340);
    paramString = CdnLogic.calcFileMD5(com.tencent.mm.vfs.i.k(paramString, false));
    AppMethodBeat.o(150340);
    return paramString;
  }
  
  public static int BL(String paramString)
  {
    AppMethodBeat.i(150342);
    int i = CdnLogic.calcFileCrc32(com.tencent.mm.vfs.i.k(paramString, false));
    AppMethodBeat.o(150342);
    return i;
  }
  
  public static String BM(String paramString)
  {
    AppMethodBeat.i(150343);
    paramString = CdnLogic.calcMP4IdentifyMD5(com.tencent.mm.vfs.i.k(paramString, false));
    AppMethodBeat.o(150343);
    return paramString;
  }
  
  public static int BN(String paramString)
  {
    AppMethodBeat.i(150350);
    ac.i("MicroMsg.CdnTransportEngine", "stopHttpsDownload: mediaid:".concat(String.valueOf(paramString)));
    CdnLogic.cancelTask(paramString);
    AppMethodBeat.o(150350);
    return 0;
  }
  
  public static int BO(String paramString)
  {
    AppMethodBeat.i(150352);
    ac.i("MicroMsg.CdnTransportEngine", "stopGamePackageDownload: mediaid:".concat(String.valueOf(paramString)));
    CdnLogic.cancelTask(paramString);
    AppMethodBeat.o(150352);
    return 0;
  }
  
  /* Error */
  private static int BP(String paramString)
  {
    // Byte code:
    //   0: ldc 210
    //   2: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 128
    //   7: ldc 212
    //   9: iconst_1
    //   10: anewarray 4	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: aload_0
    //   16: aastore
    //   17: invokestatic 151	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   20: aload_0
    //   21: ldc 214
    //   23: invokevirtual 218	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   26: ifne +26 -> 52
    //   29: aload_0
    //   30: ldc 220
    //   32: invokevirtual 218	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   35: ifne +17 -> 52
    //   38: ldc 128
    //   40: ldc 222
    //   42: invokestatic 225	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: ldc 210
    //   47: invokestatic 154	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: iconst_0
    //   51: ireturn
    //   52: aload_0
    //   53: invokestatic 231	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
    //   56: invokevirtual 235	java/net/InetAddress:getAddress	()[B
    //   59: astore 5
    //   61: aload 5
    //   63: arraylength
    //   64: istore 4
    //   66: iconst_0
    //   67: istore_3
    //   68: iconst_0
    //   69: istore_1
    //   70: iload_1
    //   71: istore_2
    //   72: iload_3
    //   73: iload 4
    //   75: if_icmpge +28 -> 103
    //   78: iload_1
    //   79: bipush 8
    //   81: ishl
    //   82: aload 5
    //   84: iload_3
    //   85: baload
    //   86: sipush 255
    //   89: iand
    //   90: ior
    //   91: istore_1
    //   92: iload_3
    //   93: iconst_1
    //   94: iadd
    //   95: istore_3
    //   96: goto -26 -> 70
    //   99: astore 5
    //   101: iconst_0
    //   102: istore_2
    //   103: ldc 128
    //   105: ldc 237
    //   107: iconst_2
    //   108: anewarray 4	java/lang/Object
    //   111: dup
    //   112: iconst_0
    //   113: aload_0
    //   114: aastore
    //   115: dup
    //   116: iconst_1
    //   117: iload_2
    //   118: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   121: aastore
    //   122: invokestatic 151	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   125: ldc 210
    //   127: invokestatic 154	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   130: iload_2
    //   131: ireturn
    //   132: astore 5
    //   134: iconst_0
    //   135: istore_2
    //   136: goto -33 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	paramString	String
    //   69	23	1	i	int
    //   71	65	2	j	int
    //   67	29	3	k	int
    //   64	12	4	m	int
    //   59	24	5	arrayOfByte	byte[]
    //   99	1	5	localNullPointerException	java.lang.NullPointerException
    //   132	1	5	localUnknownHostException	java.net.UnknownHostException
    // Exception table:
    //   from	to	target	type
    //   20	45	99	java/lang/NullPointerException
    //   52	66	99	java/lang/NullPointerException
    //   20	45	132	java/net/UnknownHostException
    //   52	66	132	java/net/UnknownHostException
  }
  
  private static CdnLogic.C2CDownloadRequest a(com.tencent.mm.i.g paramg)
  {
    boolean bool2 = true;
    AppMethodBeat.i(150335);
    CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
    localC2CDownloadRequest.fileid = paramg.field_fileId;
    localC2CDownloadRequest.aeskey = paramg.field_aesKey;
    localC2CDownloadRequest.fileType = paramg.field_fileType;
    localC2CDownloadRequest.fileKey = paramg.field_mediaId;
    localC2CDownloadRequest.fileSize = paramg.field_totalLen;
    localC2CDownloadRequest.setSavePath(paramg.field_fullpath);
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
      if (bs.isNullOrNil(localC2CDownloadRequest.bigfileSignature)) {
        localC2CDownloadRequest.bigfileSignature = "";
      }
      localC2CDownloadRequest.fakeBigfileSignature = paramg.field_fake_bigfile_signature;
      if (bs.isNullOrNil(localC2CDownloadRequest.fakeBigfileSignature)) {
        localC2CDownloadRequest.fakeBigfileSignature = "";
      }
      localC2CDownloadRequest.fakeBigfileSignatureAeskey = paramg.field_fake_bigfile_signature_aeskey;
      if (bs.isNullOrNil(localC2CDownloadRequest.fakeBigfileSignatureAeskey)) {
        localC2CDownloadRequest.fakeBigfileSignatureAeskey = "";
      }
      localC2CDownloadRequest.msgExtra = paramg.field_wxmsgparam;
      if (bs.isNullOrNil(localC2CDownloadRequest.msgExtra)) {
        localC2CDownloadRequest.msgExtra = "";
      }
      localC2CDownloadRequest.queueTimeoutSeconds = 0;
      localC2CDownloadRequest.transforTimeoutSeconds = 0;
      localC2CDownloadRequest.preloadRatio = paramg.field_preloadRatio;
      localC2CDownloadRequest.certificateVerifyPolicy = paramg.certificateVerifyPolicy;
      localC2CDownloadRequest.expectImageFormat = paramg.expectImageFormat;
      AppMethodBeat.o(150335);
      return localC2CDownloadRequest;
      bool1 = false;
      break;
    }
  }
  
  private static CdnLogic.CdnInfo a(qg paramqg)
  {
    AppMethodBeat.i(150359);
    CdnLogic.CdnInfo localCdnInfo = new CdnLogic.CdnInfo();
    if (paramqg == null)
    {
      AppMethodBeat.o(150359);
      return localCdnInfo;
    }
    localCdnInfo.ver = paramqg.EgZ;
    localCdnInfo.uin = paramqg.pAs;
    localCdnInfo.frontid = paramqg.Ehb;
    localCdnInfo.zoneid = paramqg.Ehg;
    localCdnInfo.nettype = c.cC(ai.getContext());
    localCdnInfo.authkey = z.a(paramqg.Ehf);
    if (paramqg.Ehc >= 2)
    {
      localCdnInfo.frontip1 = z.a((crm)paramqg.Ehd.get(0));
      localCdnInfo.frontip2 = z.a((crm)paramqg.Ehd.get(1));
      ac.i("MicroMsg.CdnTransportEngine", "frontip %s, %s", new Object[] { localCdnInfo.frontip1, localCdnInfo.frontip2 });
    }
    if (paramqg.Ehh >= 2)
    {
      localCdnInfo.zoneip1 = z.a((crm)paramqg.Ehi.get(0));
      localCdnInfo.zoneip2 = z.a((crm)paramqg.Ehi.get(1));
      ac.i("MicroMsg.CdnTransportEngine", "zoneip %s, %s", new Object[] { localCdnInfo.frontip1, localCdnInfo.frontip2 });
    }
    int j;
    int i;
    if (paramqg.Ehl > 0)
    {
      j = ((qh)paramqg.Ehj.get(0)).Ehn;
      localCdnInfo.frontports = new int[j];
      i = 0;
      while (i < j)
      {
        localCdnInfo.frontports[i] = ((Integer)((qh)paramqg.Ehj.get(0)).Eho.get(i)).intValue();
        i += 1;
      }
    }
    if (paramqg.Ehm > 0)
    {
      j = ((qh)paramqg.Ehk.get(0)).Ehn;
      localCdnInfo.zoneports = new int[j];
      i = 0;
      while (i < j)
      {
        localCdnInfo.zoneports[i] = ((Integer)((qh)paramqg.Ehk.get(0)).Eho.get(i)).intValue();
        i += 1;
      }
    }
    AppMethodBeat.o(150359);
    return localCdnInfo;
  }
  
  private static d a(CdnLogic.C2CDownloadResult paramC2CDownloadResult, d paramd)
  {
    AppMethodBeat.i(150362);
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
    locald.field_videoFlag = paramC2CDownloadResult.videoFlag;
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
    locald.field_clientHostIP = BP(paramC2CDownloadResult.clientIP);
    locald.field_serverHostIP = BP(paramC2CDownloadResult.serverIP);
    locald.field_xErrorNo = paramC2CDownloadResult.xErrorNo;
    locald.field_cSeqCheck = paramC2CDownloadResult.cSeqCheck;
    locald.field_usePrivateProtocol = paramC2CDownloadResult.usePrivateProtocol;
    locald.field_isCrossNet = paramC2CDownloadResult.crossNet;
    locald.field_clientIP = paramC2CDownloadResult.clientIP;
    locald.field_detailErrorType = paramC2CDownloadResult.detailErrorType;
    locald.field_detailErrorCode = paramC2CDownloadResult.detailErrorCode;
    if ((paramC2CDownloadResult.usedSvrIps != null) && (paramC2CDownloadResult.usedSvrIps.length > 0))
    {
      locald.field_usedSvrIps = ((String[])paramC2CDownloadResult.usedSvrIps.clone());
      locald.fqO = paramC2CDownloadResult.usedSvrIps[(paramC2CDownloadResult.usedSvrIps.length - 1)];
      locald.lastSvrPort = paramC2CDownloadResult.lastSvrPort;
      locald.lastNetType = paramC2CDownloadResult.lastNetType;
    }
    locald.field_isResume = paramC2CDownloadResult.isResume;
    locald.fqP = paramC2CDownloadResult.isSnsImageProtocolAvailable;
    locald.index = paramC2CDownloadResult.picIndex;
    locald.cachePath = paramC2CDownloadResult.picCachePath;
    locald.dnn = paramC2CDownloadResult.batchPicFeedId;
    locald.fileKey = paramC2CDownloadResult.batchImageFileKey;
    locald.fqQ = paramC2CDownloadResult.batchImageNeedRetry;
    locald.transportProtocol = paramC2CDownloadResult.transportProtocol;
    locald.transportProtocolError = paramC2CDownloadResult.transportProtocolError;
    AppMethodBeat.o(150362);
    return locald;
  }
  
  private static void a(d paramd)
  {
    AppMethodBeat.i(150374);
    if ((paramd != null) && (!bs.isNullOrNil(paramd.field_transInfo)))
    {
      int i = paramd.field_transInfo.indexOf("@,");
      if (i > 0)
      {
        paramd.fqM = paramd.field_transInfo.substring(i + 2);
        paramd.field_transInfo = paramd.field_transInfo.substring(0, i);
      }
      ac.v("MicroMsg.CdnTransportEngine", "transinfo:%s, report_part2:%s", new Object[] { paramd.field_transInfo, paramd.fqM });
    }
    AppMethodBeat.o(150374);
  }
  
  public static String aDw()
  {
    AppMethodBeat.i(150341);
    String str = CdnLogic.createAeskey();
    AppMethodBeat.o(150341);
    return str;
  }
  
  public static int c(String paramString, d paramd)
  {
    AppMethodBeat.i(150356);
    ac.i("MicroMsg.CdnTransportEngine", "[stopVideoStreamingDownload] mediaId=%s %s", new Object[] { paramString, bs.eWi() });
    CdnLogic.C2CDownloadResult localC2CDownloadResult = new CdnLogic.C2CDownloadResult();
    int i = CdnLogic.cancelDownloadTaskWithResult(paramString, localC2CDownloadResult);
    a(localC2CDownloadResult, paramd);
    AppMethodBeat.o(150356);
    return i;
  }
  
  public static boolean isVideoDataAvailable(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(150358);
    boolean bool = CdnLogic.isVideoDataAvailable(paramString, paramLong1, paramLong2);
    AppMethodBeat.o(150358);
    return bool;
  }
  
  public static int keep_callFromJni(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150334);
    if (paramInt1 == hAR) {
      c.outputJniLog(paramArrayOfByte, "MicroMsg.CdnEngine", paramInt2);
    }
    AppMethodBeat.o(150334);
    return 0;
  }
  
  public static int requestVideoData(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(192607);
    paramInt = CdnLogic.requestVideoData(paramString, paramLong1, paramLong2, paramInt);
    AppMethodBeat.o(192607);
    return paramInt;
  }
  
  public final int a(com.tencent.mm.i.f paramf)
  {
    AppMethodBeat.i(150348);
    CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
    localC2CDownloadRequest.fileType = 20201;
    localC2CDownloadRequest.fileKey = paramf.field_mediaId;
    localC2CDownloadRequest.url = paramf.url;
    localC2CDownloadRequest.referer = paramf.referer;
    if (paramf.fqT != null)
    {
      arrayOfString = (String[])paramf.fqT.clone();
      localC2CDownloadRequest.ocIpList = arrayOfString;
      localC2CDownloadRequest.ocIpListSource = paramf.fqV;
      if (paramf.fqU == null) {
        break label281;
      }
    }
    label281:
    for (String[] arrayOfString = (String[])paramf.fqU.clone();; arrayOfString = null)
    {
      localC2CDownloadRequest.dcIpList = arrayOfString;
      localC2CDownloadRequest.dcIpListSource = paramf.fqW;
      localC2CDownloadRequest.isColdSnsData = paramf.isColdSnsData;
      localC2CDownloadRequest.signalQuality = paramf.signalQuality;
      localC2CDownloadRequest.snsScene = paramf.snsScene;
      localC2CDownloadRequest.concurrentCount = 6;
      localC2CDownloadRequest.marscdnBizType = paramf.eyd;
      localC2CDownloadRequest.marscdnAppType = paramf.appType;
      localC2CDownloadRequest.fileType = paramf.fileType;
      localC2CDownloadRequest.msgType = 2;
      localC2CDownloadRequest.feedId = paramf.dnn;
      localC2CDownloadRequest.feedPicCount = paramf.fqX;
      localC2CDownloadRequest.batchSnsReqImageDatas = paramf.fqQ;
      if ((ab.ivZ) && (ab.iwe.length() > 0))
      {
        localC2CDownloadRequest.debugIP = ab.iwe;
        ac.w("MicroMsg.CdnTransportEngine", "debugip " + localC2CDownloadRequest.debugIP);
      }
      int i = CdnLogic.startSNSDownload(localC2CDownloadRequest, this, this, 0);
      AppMethodBeat.o(150348);
      return i;
      arrayOfString = null;
      break;
    }
  }
  
  public final int a(com.tencent.mm.i.g paramg, int paramInt)
  {
    AppMethodBeat.i(150353);
    paramg = a(paramg);
    if ((ab.ivZ) && (ab.iwe.length() > 0))
    {
      paramg.debugIP = ab.iwe;
      ac.w("MicroMsg.CdnTransportEngine", "debugip " + paramg.debugIP);
    }
    paramInt = CdnLogic.startVideoStreamingDownload(paramg, this, this, paramInt);
    AppMethodBeat.o(150353);
    return paramInt;
  }
  
  public final int a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String[] paramArrayOfString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(169183);
    if (paramArrayOfString == null) {}
    CdnLogic.C2CDownloadRequest localC2CDownloadRequest;
    for (int i = 0;; i = paramArrayOfString.length)
    {
      ac.i("MicroMsg.CdnTransportEngine", "startURLDownload: mediaid:%s, savepath:%s, filetype:%d, timeout:%d, %d, ip.size:%d, gzip:%b", new Object[] { paramString1, paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(i), Boolean.valueOf(paramBoolean1) });
      localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
      localC2CDownloadRequest.fileKey = paramString1;
      localC2CDownloadRequest.url = paramString2;
      localC2CDownloadRequest.setSavePath(paramString3);
      localC2CDownloadRequest.queueTimeoutSeconds = paramInt2;
      localC2CDownloadRequest.transforTimeoutSeconds = paramInt3;
      localC2CDownloadRequest.ocIpList = paramArrayOfString;
      if (!paramBoolean1) {
        localC2CDownloadRequest.customHeader = "Accept-Encoding:";
      }
      localC2CDownloadRequest.fileType = paramInt1;
      localC2CDownloadRequest.taskStartTime = System.currentTimeMillis();
      if (com.tencent.mm.i.a.fqD != localC2CDownloadRequest.fileType) {
        break label309;
      }
      if (!paramBoolean2) {
        break;
      }
      paramBoolean1 = true;
      if (!paramBoolean1) {
        break label272;
      }
      ac.i("MicroMsg.CdnTransportEngine", "use cronet download pkg mediaId:%s, url:%s", new Object[] { paramString1, paramString2 });
      paramInt1 = CdnLogic.startCronetFileDownload(localC2CDownloadRequest, this);
      AppMethodBeat.o(169183);
      return paramInt1;
    }
    if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE) || (com.tencent.mm.sdk.platformtools.h.DEBUG)) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      paramBoolean1 = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.qaw, paramBoolean1);
      break;
    }
    label272:
    ac.i("MicroMsg.CdnTransportEngine", "use normal download pkg mediaId:%s, url:%s", new Object[] { paramString1, paramString2 });
    paramInt1 = CdnLogic.startHttpsDownload(localC2CDownloadRequest, this);
    AppMethodBeat.o(169183);
    return paramInt1;
    label309:
    paramInt1 = CdnLogic.startURLDownload(localC2CDownloadRequest, this);
    AppMethodBeat.o(169183);
    return paramInt1;
  }
  
  public final int a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5)
  {
    AppMethodBeat.i(150344);
    ac.i("MicroMsg.CdnTransportEngine", "startURLDownload: mediaid:%s, savepath:%s", new Object[] { paramString1, paramString3 });
    CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
    localC2CDownloadRequest.fileKey = paramString1;
    localC2CDownloadRequest.url = paramString2;
    localC2CDownloadRequest.setSavePath(paramString3);
    localC2CDownloadRequest.aeskey = paramString4;
    localC2CDownloadRequest.customHeader = ("authkey:" + paramString5 + "\r\n");
    localC2CDownloadRequest.fileType = paramInt;
    paramInt = CdnLogic.startSNSDownload(localC2CDownloadRequest, this, this, 0);
    AppMethodBeat.o(150344);
    return paramInt;
  }
  
  public final int a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    AppMethodBeat.i(177671);
    CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
    localC2CDownloadRequest.fileKey = paramString1;
    localC2CDownloadRequest.fileType = 90;
    localC2CDownloadRequest.url = paramString2;
    localC2CDownloadRequest.referer = paramString3;
    localC2CDownloadRequest.setSavePath(paramString4);
    localC2CDownloadRequest.preloadRatio = paramInt2;
    localC2CDownloadRequest.preloadMinSize = paramLong;
    localC2CDownloadRequest.concurrentCount = paramInt3;
    localC2CDownloadRequest.maxHttpRedirectCount = 100;
    paramInt1 = CdnLogic.startHttpVideoStreamingDownload(localC2CDownloadRequest, this, this, paramInt1);
    AppMethodBeat.o(177671);
    return paramInt1;
  }
  
  public final int a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String[] paramArrayOfString, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(177670);
    CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
    localC2CDownloadRequest.fileKey = paramString1;
    localC2CDownloadRequest.url = paramString2;
    localC2CDownloadRequest.referer = paramString3;
    localC2CDownloadRequest.setSavePath(paramString4);
    localC2CDownloadRequest.fileSize = 0;
    localC2CDownloadRequest.fileType = 20210;
    localC2CDownloadRequest.concurrentCount = 10;
    if (paramArrayOfString != null) {}
    for (localC2CDownloadRequest.ocIpList = ((String[])paramArrayOfString.clone());; localC2CDownloadRequest.ocIpList = null)
    {
      localC2CDownloadRequest.preloadRatio = paramInt2;
      localC2CDownloadRequest.preloadMinSize = paramLong;
      paramInt1 = CdnLogic.startHttpVideoStreamingDownload(localC2CDownloadRequest, this, this, paramInt1);
      AppMethodBeat.o(177670);
      return paramInt1;
    }
  }
  
  public final int a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String[] paramArrayOfString, boolean paramBoolean, String paramString5, String paramString6, int paramInt2, long paramLong, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(177668);
    CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
    localC2CDownloadRequest.fileType = 20302;
    localC2CDownloadRequest.fileKey = paramString1;
    localC2CDownloadRequest.url = paramString2;
    localC2CDownloadRequest.referer = paramString3;
    localC2CDownloadRequest.setSavePath(paramString4);
    localC2CDownloadRequest.fileSize = 0;
    if (paramArrayOfString != null) {}
    for (localC2CDownloadRequest.ocIpList = ((String[])paramArrayOfString.clone());; localC2CDownloadRequest.ocIpList = null)
    {
      localC2CDownloadRequest.isColdSnsData = paramBoolean;
      localC2CDownloadRequest.signalQuality = paramString5;
      localC2CDownloadRequest.snsScene = paramString6;
      localC2CDownloadRequest.preloadRatio = paramInt2;
      localC2CDownloadRequest.preloadMinSize = paramLong;
      localC2CDownloadRequest.requestVideoFormat = paramInt3;
      localC2CDownloadRequest.connectionCount = paramInt4;
      localC2CDownloadRequest.marscdnAppType = 205;
      if ((ab.ivZ) && (ab.iwe.length() > 0))
      {
        localC2CDownloadRequest.debugIP = ab.iwe;
        ac.w("MicroMsg.CdnTransportEngine", "debugip " + localC2CDownloadRequest.debugIP);
      }
      paramInt1 = CdnLogic.startSNSDownload(localC2CDownloadRequest, this, this, paramInt1);
      AppMethodBeat.o(177668);
      return paramInt1;
    }
  }
  
  public final int a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String[] paramArrayOfString, boolean paramBoolean, String paramString5, String paramString6, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(177667);
    CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
    localC2CDownloadRequest.fileType = 20202;
    localC2CDownloadRequest.fileKey = paramString1;
    localC2CDownloadRequest.url = paramString2;
    localC2CDownloadRequest.referer = paramString3;
    localC2CDownloadRequest.setSavePath(paramString4);
    localC2CDownloadRequest.fileSize = 0;
    if (paramArrayOfString != null) {}
    for (localC2CDownloadRequest.ocIpList = ((String[])paramArrayOfString.clone());; localC2CDownloadRequest.ocIpList = null)
    {
      localC2CDownloadRequest.isColdSnsData = paramBoolean;
      localC2CDownloadRequest.signalQuality = paramString5;
      localC2CDownloadRequest.snsScene = paramString6;
      localC2CDownloadRequest.preloadRatio = paramInt2;
      localC2CDownloadRequest.preloadMinSize = paramLong;
      localC2CDownloadRequest.requestVideoFormat = paramInt3;
      localC2CDownloadRequest.connectionCount = paramInt4;
      localC2CDownloadRequest.concurrentCount = paramInt5;
      if ((ab.ivZ) && (ab.iwe.length() > 0))
      {
        localC2CDownloadRequest.debugIP = ab.iwe;
        ac.w("MicroMsg.CdnTransportEngine", "debugip " + localC2CDownloadRequest.debugIP);
      }
      paramInt1 = CdnLogic.startSNSDownload(localC2CDownloadRequest, this, this, paramInt1);
      AppMethodBeat.o(177667);
      return paramInt1;
    }
  }
  
  public final int a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String[] paramArrayOfString, boolean paramBoolean, String paramString5, String paramString6, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5, String paramString7, String paramString8)
  {
    AppMethodBeat.i(192606);
    CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
    localC2CDownloadRequest.fileType = 20302;
    localC2CDownloadRequest.fileKey = paramString1;
    localC2CDownloadRequest.url = paramString2;
    localC2CDownloadRequest.referer = paramString3;
    localC2CDownloadRequest.setSavePath(paramString4);
    localC2CDownloadRequest.fileSize = 0;
    if (paramArrayOfString != null)
    {
      localC2CDownloadRequest.ocIpList = ((String[])paramArrayOfString.clone());
      localC2CDownloadRequest.isColdSnsData = paramBoolean;
      localC2CDownloadRequest.signalQuality = paramString5;
      localC2CDownloadRequest.snsScene = paramString6;
      localC2CDownloadRequest.preloadRatio = paramInt2;
      localC2CDownloadRequest.preloadMinSize = paramLong;
      localC2CDownloadRequest.requestVideoFormat = paramInt3;
      localC2CDownloadRequest.connectionCount = paramInt4;
      localC2CDownloadRequest.snsCipherKey = paramString8;
      localC2CDownloadRequest.marscdnAppType = 251;
      localC2CDownloadRequest.videoflagPolicy = paramInt5;
      if ((paramString7 == null) || ((paramString7.indexOf('x') < 0) && (paramString7.indexOf('X') < 0))) {
        break label257;
      }
    }
    label257:
    for (localC2CDownloadRequest.requestVideoFlag = paramString7.substring(1);; localC2CDownloadRequest.requestVideoFlag = paramString7)
    {
      if ((ab.ivZ) && (ab.iwe.length() > 0))
      {
        localC2CDownloadRequest.debugIP = ab.iwe;
        ac.w("MicroMsg.CdnTransportEngine", "debugip " + localC2CDownloadRequest.debugIP);
      }
      paramInt1 = CdnLogic.startSNSDownload(localC2CDownloadRequest, this, this, paramInt1);
      AppMethodBeat.o(192606);
      return paramInt1;
      localC2CDownloadRequest.ocIpList = null;
      break;
    }
  }
  
  public final int a(String paramString1, String paramString2, String paramString3, String paramString4, Map<String, String> paramMap, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, boolean paramBoolean3, String[] paramArrayOfString)
  {
    AppMethodBeat.i(150351);
    ac.i("MicroMsg.CdnTransportEngine", "startGamePackageDownload: mediaid:".concat(String.valueOf(paramString1)));
    CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
    localC2CDownloadRequest.fileKey = paramString1;
    localC2CDownloadRequest.url = paramString3;
    localC2CDownloadRequest.bakup_url = paramString4;
    localC2CDownloadRequest.setSavePath(paramString2);
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
    AppMethodBeat.o(150351);
    return paramInt1;
  }
  
  public final int a(String paramString1, String paramString2, String paramString3, String paramString4, String[] paramArrayOfString1, String[] paramArrayOfString2, int paramInt1, int paramInt2, boolean paramBoolean, String paramString5, String paramString6, String paramString7, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(150349);
    if ((bs.isNullOrNil(paramString1)) || (bs.isNullOrNil(paramString2)) || (bs.isNullOrNil(paramString4)))
    {
      ac.e("MicroMsg.CdnTransportEngine", "invalid param.");
      AppMethodBeat.o(150349);
      return -1;
    }
    CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
    localC2CDownloadRequest.fileType = 20201;
    localC2CDownloadRequest.fileKey = paramString1;
    localC2CDownloadRequest.url = paramString2;
    localC2CDownloadRequest.referer = paramString3;
    localC2CDownloadRequest.setSavePath(paramString4);
    localC2CDownloadRequest.fileSize = 0;
    if (paramArrayOfString1 != null)
    {
      paramString1 = (String[])paramArrayOfString1.clone();
      localC2CDownloadRequest.ocIpList = paramString1;
      localC2CDownloadRequest.ocIpListSource = paramInt1;
      if (paramArrayOfString2 == null) {
        break label275;
      }
    }
    label275:
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
      if ((ab.ivZ) && (ab.iwe.length() > 0))
      {
        localC2CDownloadRequest.debugIP = ab.iwe;
        ac.w("MicroMsg.CdnTransportEngine", "debugip " + localC2CDownloadRequest.debugIP);
      }
      paramInt1 = CdnLogic.startSNSDownload(localC2CDownloadRequest, this, this, 0);
      AppMethodBeat.o(150349);
      return paramInt1;
      paramString1 = null;
      break;
    }
  }
  
  public final void a(a parama)
  {
    int i = 0;
    AppMethodBeat.i(192604);
    this.hBc = parama;
    int j = hashCode();
    if (parama != null) {
      i = parama.hashCode();
    }
    ac.i("MicroMsg.CdnTransportEngine", "set tp player cdn callback hash[%d] onlineVideoCallback[%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
    AppMethodBeat.o(192604);
  }
  
  public final void a(com.tencent.mm.i.b.a parama)
  {
    int i = 0;
    AppMethodBeat.i(192605);
    this.hAW = parama;
    int j = hashCode();
    if (parama != null) {
      i = parama.hashCode();
    }
    ac.i("MicroMsg.CdnTransportEngine", "set tp player cdn callback hash[%d] cdnTransCallback[%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
    AppMethodBeat.o(192605);
  }
  
  public final boolean a(qg paramqg1, qg paramqg2, qg paramqg3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, qg paramqg4)
  {
    AppMethodBeat.i(150360);
    ac.i("MicroMsg.CdnTransportEngine", "summersafecdn cdntra setCDNDnsInfo old [%s]  new [%s], safecdn [%s], stack[%s]", new Object[] { this.hAV, paramqg1, paramqg4, bs.eWi() });
    if ((paramqg1 == null) && (paramArrayOfByte1 == null))
    {
      AppMethodBeat.o(150360);
      return false;
    }
    this.hAV = paramqg1;
    try
    {
      paramqg1 = a(paramqg1);
      paramqg2 = a(paramqg2);
      paramqg3 = a(paramqg3);
      paramqg4 = a(paramqg4);
      CdnLogic.setLegacyCdnInfo(paramqg1, paramqg2, paramqg3, paramqg4, paramArrayOfByte1, paramArrayOfByte2);
      CdnLogic.setDebugIP("");
      AppMethodBeat.o(150360);
      return true;
    }
    catch (Exception paramqg1)
    {
      ac.e("MicroMsg.CdnTransportEngine", "tocdninfo failed:" + paramqg1.getLocalizedMessage());
      AppMethodBeat.o(150360);
    }
    return false;
  }
  
  public final boolean aDx()
  {
    return this.hAV == null;
  }
  
  public final int b(com.tencent.mm.i.g paramg)
  {
    boolean bool2 = true;
    AppMethodBeat.i(150336);
    CdnLogic.C2CUploadRequest localC2CUploadRequest = new CdnLogic.C2CUploadRequest();
    localC2CUploadRequest.fileKey = paramg.field_mediaId;
    localC2CUploadRequest.setFilePath(paramg.field_fullpath);
    localC2CUploadRequest.setThumbfilePath(paramg.field_thumbpath);
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
        break label483;
      }
    }
    label483:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localC2CUploadRequest.isSnsAdVideo = bool1;
      localC2CUploadRequest.isStorageMode = paramg.field_needStorage;
      localC2CUploadRequest.isStreamMedia = paramg.field_isStreamMedia;
      localC2CUploadRequest.enableHitCheck = paramg.field_enable_hitcheck;
      localC2CUploadRequest.forceNoSafeCdn = paramg.field_force_aeskeycdn;
      localC2CUploadRequest.trySafeCdn = paramg.field_trysafecdn;
      localC2CUploadRequest.setMidimgPath(paramg.field_midimgpath);
      localC2CUploadRequest.bigfileSignature = paramg.field_svr_signature;
      if (bs.isNullOrNil(localC2CUploadRequest.bigfileSignature)) {
        localC2CUploadRequest.bigfileSignature = "";
      }
      localC2CUploadRequest.fakeBigfileSignature = paramg.field_fake_bigfile_signature;
      if (bs.isNullOrNil(localC2CUploadRequest.fakeBigfileSignature)) {
        localC2CUploadRequest.fakeBigfileSignature = "";
      }
      localC2CUploadRequest.fakeBigfileSignatureAeskey = paramg.field_fake_bigfile_signature_aeskey;
      if (bs.isNullOrNil(localC2CUploadRequest.fakeBigfileSignatureAeskey)) {
        localC2CUploadRequest.fakeBigfileSignatureAeskey = "";
      }
      localC2CUploadRequest.lastError = paramg.lastError;
      localC2CUploadRequest.emojiExtinfo = paramg.emojiExtinfo;
      localC2CUploadRequest.snsVersion = paramg.snsVersion;
      localC2CUploadRequest.fileBuffer = paramg.fileBuffer;
      localC2CUploadRequest.thumbnailBuffer = paramg.thumbnailBuffer;
      localC2CUploadRequest.customHeader = paramg.customHeader;
      if ((ab.ivZ) && (ab.iwe.length() > 0))
      {
        localC2CUploadRequest.debugIP = ab.iwe;
        ac.w("MicroMsg.CdnTransportEngine", "debugip " + localC2CUploadRequest.debugIP);
      }
      if (!localC2CUploadRequest.sendmsgFromCDN) {
        break label488;
      }
      i = CdnLogic.startSSUpload(localC2CUploadRequest, this, this);
      AppMethodBeat.o(150336);
      return i;
      bool1 = false;
      break;
    }
    label488:
    int i = CdnLogic.startC2CUpload(localC2CUploadRequest, this);
    AppMethodBeat.o(150336);
    return i;
  }
  
  public final int c(com.tencent.mm.i.g paramg)
  {
    AppMethodBeat.i(150338);
    paramg = a(paramg);
    if ((ab.ivZ) && (ab.iwe.length() > 0))
    {
      paramg.debugIP = ab.iwe;
      ac.w("MicroMsg.CdnTransportEngine", "debugip " + paramg.debugIP);
    }
    int i = CdnLogic.startC2CDownload(paramg, this);
    AppMethodBeat.o(150338);
    return i;
  }
  
  public final byte[] decodeSessionResponseBuf(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150384);
    if (!ai.ciE())
    {
      AppMethodBeat.o(150384);
      return null;
    }
    paramString = keep_cdnDecodePrepareResponse(paramString, paramArrayOfByte);
    AppMethodBeat.o(150384);
    return paramString;
  }
  
  public final byte[] getSessionRequestBuf(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150383);
    if (!ai.ciE())
    {
      AppMethodBeat.o(150383);
      return null;
    }
    paramArrayOfByte = new ByteArrayOutputStream();
    keep_cdnGetSkeyBuf(paramString, paramArrayOfByte);
    if (paramArrayOfByte.size() > 0)
    {
      paramString = paramArrayOfByte.toByteArray();
      AppMethodBeat.o(150383);
      return paramString;
    }
    AppMethodBeat.o(150383);
    return null;
  }
  
  public final void keep_OnRequestDoGetCdnDnsInfo(int paramInt)
  {
    AppMethodBeat.i(150376);
    com.tencent.mm.kernel.g.agP();
    if (com.tencent.mm.kernel.a.afX()) {
      f.aDA().oB(paramInt);
    }
    AppMethodBeat.o(150376);
  }
  
  public final byte[] keep_cdnDecodePrepareResponse(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150370);
    if (this.hAX != null)
    {
      paramString = this.hAX.f(paramString, paramArrayOfByte);
      AppMethodBeat.o(150370);
      return paramString;
    }
    AppMethodBeat.o(150370);
    return null;
  }
  
  public final void keep_cdnGetSkeyBuf(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    AppMethodBeat.i(150369);
    if (this.hAX != null) {
      this.hAX.a(paramString, paramByteArrayOutputStream);
    }
    AppMethodBeat.o(150369);
  }
  
  public final void keep_cdnSendAndRecvData(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150375);
    if ((paramInt1 < 0) || (paramInt2 < 0))
    {
      AppMethodBeat.o(150375);
      return;
    }
    this.hAY += paramInt1;
    this.hAZ += paramInt2;
    if (!bs.isNullOrNil(paramString)) {
      this.hBa = paramString;
    }
    if ((this.hAY + this.hAZ > 51200) && (this.hBb != null)) {
      this.hBb.au(500L, 500L);
    }
    AppMethodBeat.o(150375);
  }
  
  public final void keep_onDataAvailable(String paramString, long paramLong1, long paramLong2)
  {
    int i = 0;
    AppMethodBeat.i(150372);
    ac.i("MicroMsg.CdnTransportEngine", "keep_onDataAvailable %s, %d, %d", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if (this.hBc != null) {
      i = this.hBc.n(paramString, (int)paramLong1, (int)paramLong2);
    }
    if ((i == 0) && (this.hBd != null)) {
      this.hBd.n(paramString, (int)paramLong1, (int)paramLong2);
    }
    AppMethodBeat.o(150372);
  }
  
  public final int keep_onDownloadError(String paramString, d paramd)
  {
    AppMethodBeat.i(150367);
    if (this.hBc != null) {}
    for (int j = this.hBc.a(paramString, null, paramd);; j = 0)
    {
      int i = j;
      if (j == 0)
      {
        i = j;
        if (this.hBd != null) {
          i = this.hBd.a(paramString, null, paramd);
        }
      }
      j = i;
      if (i == 0)
      {
        j = i;
        if (this.hAW != null) {
          j = this.hAW.a(paramString, null, paramd);
        }
      }
      if ((j == 0) && (this.hAX != null))
      {
        a(paramd);
        this.hAX.a(paramString, null, paramd);
      }
      AppMethodBeat.o(150367);
      return 0;
    }
  }
  
  public final int keep_onDownloadProgress(String paramString, com.tencent.mm.i.c paramc)
  {
    AppMethodBeat.i(150366);
    paramc.field_isUploadTask = false;
    if (this.hBc != null) {}
    for (int j = this.hBc.a(paramString, paramc, null);; j = 0)
    {
      int i = j;
      if (j == 0)
      {
        i = j;
        if (this.hBd != null) {
          i = this.hBd.a(paramString, paramc, null);
        }
      }
      j = i;
      if (i == 0)
      {
        j = i;
        if (this.hAW != null) {
          j = this.hAW.a(paramString, paramc, null);
        }
      }
      if ((j == 0) && (this.hAX != null)) {
        this.hAX.a(paramString, paramc, null);
      }
      AppMethodBeat.o(150366);
      return 0;
    }
  }
  
  public final int keep_onDownloadSuccessed(String paramString, d paramd)
  {
    AppMethodBeat.i(150368);
    if (this.hBc != null) {}
    for (int j = this.hBc.a(paramString, null, paramd);; j = 0)
    {
      int i = j;
      if (j == 0)
      {
        i = j;
        if (this.hBd != null) {
          i = this.hBd.a(paramString, null, paramd);
        }
      }
      j = i;
      if (i == 0)
      {
        j = i;
        if (this.hAW != null) {
          j = this.hAW.a(paramString, null, paramd);
        }
      }
      if ((j == 0) && (this.hAX != null))
      {
        a(paramd);
        this.hAX.a(paramString, null, paramd);
      }
      AppMethodBeat.o(150368);
      return 0;
    }
  }
  
  public final void keep_onDownloadToEnd(String paramString, long paramLong1, long paramLong2)
  {
    int i = 0;
    AppMethodBeat.i(150373);
    ac.i("MicroMsg.CdnTransportEngine", "keep_onDownloadToEnd %s, %d, %d", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if (this.hBc != null) {
      i = this.hBc.n(paramString, (int)paramLong1, (int)paramLong2);
    }
    if ((i == 0) && (this.hBd != null)) {
      this.hBd.o(paramString, (int)paramLong1, (int)paramLong2);
    }
    AppMethodBeat.o(150373);
  }
  
  public final void keep_onMoovReady(String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    AppMethodBeat.i(184253);
    ac.i("MicroMsg.CdnTransportEngine", "keep_onMoovReady %s, %d, %d, %s, hash[%d]", new Object[] { paramString1, Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString2, Integer.valueOf(hashCode()) });
    if (this.hBc != null) {}
    for (int i = this.hBc.d(paramString1, (int)paramLong1, (int)paramLong2, paramString2);; i = 0)
    {
      int j = i;
      if (i == 0)
      {
        j = i;
        if (this.hBd != null) {
          j = this.hBd.d(paramString1, (int)paramLong1, (int)paramLong2, paramString2);
        }
      }
      if (j == 0)
      {
        ac.e("MicroMsg.CdnTransportEngine", "cdn call on moov ready but onlineVideoCallback is null.hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
        com.tencent.mm.plugin.report.service.h.wUl.dB(354, 29);
      }
      AppMethodBeat.o(184253);
      return;
    }
  }
  
  public final int keep_onUploadError(String paramString, d paramd)
  {
    AppMethodBeat.i(150364);
    if (this.hAX != null)
    {
      a(paramd);
      this.hAX.a(paramString, null, paramd);
    }
    AppMethodBeat.o(150364);
    return 0;
  }
  
  public final int keep_onUploadProgress(String paramString, com.tencent.mm.i.c paramc)
  {
    AppMethodBeat.i(150363);
    paramc.field_isUploadTask = true;
    if (this.hAX != null)
    {
      ac.v("MicroMsg.CdnTransportEngine", "klem keep_onUploadProgress mediaId:%s, totalLen%d, offset%d", new Object[] { paramString, Long.valueOf(paramc.field_toltalLength), Long.valueOf(paramc.field_finishedLength) });
      this.hAX.a(paramString, paramc, null);
    }
    AppMethodBeat.o(150363);
    return 0;
  }
  
  public final int keep_onUploadSuccessed(String paramString, d paramd)
  {
    AppMethodBeat.i(150365);
    if (this.hAX != null)
    {
      ac.v("MicroMsg.CdnTransportEngine", "klem keep_onUploadSuccessed mediaId:%s", new Object[] { paramString });
      a(paramd);
      this.hAX.a(paramString, null, paramd);
    }
    AppMethodBeat.o(150365);
    return 0;
  }
  
  public final void onBadNetworkProbed()
  {
    AppMethodBeat.i(150380);
    ac.w("MicroMsg.CdnTransportEngine", "bad network probed by CDN, try analyze STN network.");
    StnLogic.startNetworkAnalysis();
    AppMethodBeat.o(150380);
  }
  
  public final void onC2CDownloadCompleted(String paramString, CdnLogic.C2CDownloadResult paramC2CDownloadResult)
  {
    AppMethodBeat.i(150386);
    d locald = a(paramC2CDownloadResult, null);
    Object localObject1;
    Object localObject2;
    label57:
    long l;
    if ((paramC2CDownloadResult.fromCronet) && (paramC2CDownloadResult.cronetTaskResult != null))
    {
      if (paramC2CDownloadResult.cronetTaskResult.useHttp2)
      {
        localObject1 = "true";
        if (!paramC2CDownloadResult.cronetTaskResult.useQuic) {
          break label510;
        }
        localObject2 = "true";
        ac.i("MicroMsg.CdnTransportEngine", "cronet this task is from cronet ,use http2 %s, use quic %s, status code %d ", new Object[] { localObject1, localObject2, Integer.valueOf(paramC2CDownloadResult.cronetTaskResult.statusCode) });
        ac.i("MicroMsg.CdnTransportEngine", "cronet webperformance ip:%s, protocol:%s", new Object[] { paramC2CDownloadResult.cronetTaskResult.performance.peerIP, paramC2CDownloadResult.cronetTaskResult.performance.protocol });
        locald.fromCronet = true;
        locald.cronetTaskResult = new CdnLogic.CronetTaskResult();
        locald.cronetTaskResult.useQuic = paramC2CDownloadResult.cronetTaskResult.useQuic;
        locald.cronetTaskResult.useHttp2 = paramC2CDownloadResult.cronetTaskResult.useHttp2;
        locald.cronetTaskResult.statusCode = paramC2CDownloadResult.cronetTaskResult.statusCode;
        locald.cronetTaskResult.statusText = paramC2CDownloadResult.cronetTaskResult.statusText;
        locald.cronetTaskResult.performance = paramC2CDownloadResult.cronetTaskResult.performance;
        locald.field_httpStatusCode = paramC2CDownloadResult.cronetTaskResult.statusCode;
      }
    }
    else
    {
      l = System.currentTimeMillis() - paramC2CDownloadResult.taskStartTime;
      if (com.tencent.mm.i.a.fqD == paramC2CDownloadResult.fileType)
      {
        if (!paramC2CDownloadResult.fromCronet) {
          break label616;
        }
        ac.i("MicroMsg.CdnTransportEngine", "cronet task use cronet download time ".concat(String.valueOf(l)));
        com.tencent.mm.plugin.report.service.h.wUl.n(1173L, 97L, 1L);
        com.tencent.mm.plugin.report.service.h.wUl.n(1173L, 99L, l);
        if (paramC2CDownloadResult.cronetTaskResult != null)
        {
          if (!paramC2CDownloadResult.cronetTaskResult.useQuic) {
            break label518;
          }
          com.tencent.mm.plugin.report.service.h.wUl.n(1173L, 94L, 1L);
          com.tencent.mm.plugin.report.service.h.wUl.n(1173L, 95L, l);
          ac.i("MicroMsg.CdnTransportEngine", "cronet task use cronet quic download time ".concat(String.valueOf(l)));
        }
      }
    }
    for (;;)
    {
      if (locald.field_retCode == 0) {
        break label660;
      }
      localObject1 = new com.tencent.mm.g.b.a.i();
      localObject2 = ((com.tencent.mm.g.b.a.i)localObject1).fJ(paramString);
      ((com.tencent.mm.g.b.a.i)localObject2).dET = 1;
      ((com.tencent.mm.g.b.a.i)localObject2).dEU = paramC2CDownloadResult.detailErrorType;
      ((com.tencent.mm.g.b.a.i)localObject2).dEV = paramC2CDownloadResult.detailErrorCode;
      ((com.tencent.mm.g.b.a.i)localObject2).dEW = paramC2CDownloadResult.errorCode;
      ((com.tencent.mm.g.b.a.i)localObject2).dEY = paramC2CDownloadResult.fileType;
      ((com.tencent.mm.g.b.a.i)localObject2).dEZ = paramC2CDownloadResult.tryWritenBytes;
      ((com.tencent.mm.g.b.a.i)localObject2).dFa = paramC2CDownloadResult.availableBytes;
      ((com.tencent.mm.g.b.a.i)localObject2).fK(paramC2CDownloadResult.systemErrorDescribe).dFc = paramC2CDownloadResult.currentFileSize;
      ((com.tencent.mm.g.b.a.i)localObject1).aHZ();
      ac.i("MicroMsg.CdnTransportEngine", "reportstr %s", new Object[] { ((com.tencent.mm.g.b.a.i)localObject1).PS() });
      keep_onDownloadError(paramString, locald);
      AppMethodBeat.o(150386);
      return;
      localObject1 = "false";
      break;
      label510:
      localObject2 = "false";
      break label57;
      label518:
      if (paramC2CDownloadResult.cronetTaskResult.useHttp2)
      {
        com.tencent.mm.plugin.report.service.h.wUl.n(1173L, 91L, 1L);
        com.tencent.mm.plugin.report.service.h.wUl.n(1173L, 92L, l);
        ac.i("MicroMsg.CdnTransportEngine", "cronet task use cronet http2 download time ".concat(String.valueOf(l)));
      }
      else
      {
        com.tencent.mm.plugin.report.service.h.wUl.n(1173L, 88L, 1L);
        com.tencent.mm.plugin.report.service.h.wUl.n(1173L, 89L, l);
        ac.i("MicroMsg.CdnTransportEngine", "cronet task use cronet http1.x download time ".concat(String.valueOf(l)));
        continue;
        label616:
        ac.i("MicroMsg.CdnTransportEngine", "cronet task use normal download time ".concat(String.valueOf(l)));
        com.tencent.mm.plugin.report.service.h.wUl.n(1173L, 100L, 1L);
        com.tencent.mm.plugin.report.service.h.wUl.n(1173L, 98L, l);
      }
    }
    label660:
    keep_onDownloadSuccessed(paramString, locald);
    AppMethodBeat.o(150386);
  }
  
  public final void onC2CUploadCompleted(String paramString, CdnLogic.C2CUploadResult paramC2CUploadResult)
  {
    AppMethodBeat.i(150382);
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
      locald.emojiMD5 = paramC2CUploadResult.emojiMD5;
      locald.field_isResume = paramC2CUploadResult.isResume;
      locald.field_delayTime = paramC2CUploadResult.delayTime;
      locald.field_connectCostTime = paramC2CUploadResult.connectCostTime;
      locald.field_waitResponseCostTime = paramC2CUploadResult.waitResponseCostTime;
      locald.field_receiveCostTime = paramC2CUploadResult.receiveCostTime;
      locald.field_clientIP = paramC2CUploadResult.clientIP;
      locald.field_serverIP = paramC2CUploadResult.serverIP;
      locald.field_clientHostIP = BP(paramC2CUploadResult.clientIP);
      locald.field_serverHostIP = BP(paramC2CUploadResult.serverIP);
      locald.transportProtocol = paramC2CUploadResult.transportProtocol;
      locald.transportProtocolError = paramC2CUploadResult.transportProtocolError;
      locald.field_detailErrorType = paramC2CUploadResult.detailErrorType;
      locald.field_detailErrorCode = paramC2CUploadResult.detailErrorCode;
      if (locald.field_retCode == 0) {
        break;
      }
      com.tencent.mm.g.b.a.i locali1 = new com.tencent.mm.g.b.a.i();
      com.tencent.mm.g.b.a.i locali2 = locali1.fJ(paramString);
      locali2.dET = 0;
      locali2.dEU = paramC2CUploadResult.detailErrorType;
      locali2.dEV = paramC2CUploadResult.detailErrorCode;
      locali2.dEW = paramC2CUploadResult.errorCode;
      locali2.dEY = paramC2CUploadResult.filetype;
      locali2.dEZ = 0L;
      locali2.dFa = 0L;
      locali2.fK(paramC2CUploadResult.systemErrorDescribe);
      locali1.aHZ();
      ac.i("MicroMsg.CdnTransportEngine", "reportstr %s", new Object[] { locali1.PS() });
      keep_onUploadError(paramString, locald);
      AppMethodBeat.o(150382);
      return;
    }
    keep_onUploadSuccessed(paramString, locald);
    AppMethodBeat.o(150382);
  }
  
  public final void onDataAvailable(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(150388);
    keep_onDataAvailable(paramString, paramLong1, paramLong2);
    AppMethodBeat.o(150388);
  }
  
  public final void onDownloadProgressChanged(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(150385);
    com.tencent.mm.i.c localc = new com.tencent.mm.i.c();
    localc.field_finishedLength = ((int)paramLong1);
    localc.field_toltalLength = ((int)paramLong2);
    localc.field_status = 0;
    localc.field_mtlnotify = paramBoolean;
    keep_onDownloadProgress(paramString, localc);
    AppMethodBeat.o(150385);
  }
  
  public final void onDownloadToEnd(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(150389);
    keep_onDownloadToEnd(paramString, paramLong1, paramLong2);
    AppMethodBeat.o(150389);
  }
  
  public final void onMoovReadyWithFlag(String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    AppMethodBeat.i(184254);
    keep_onMoovReady(paramString1, paramLong1, paramLong2, paramString2);
    AppMethodBeat.o(184254);
  }
  
  public final void onPreloadCompletedWithResult(String paramString, long paramLong1, long paramLong2, CdnLogic.C2CDownloadResult paramC2CDownloadResult)
  {
    AppMethodBeat.i(150390);
    paramC2CDownloadResult.recvedBytes = ((int)paramLong1);
    paramC2CDownloadResult = a(paramC2CDownloadResult, null);
    int i = 0;
    if (this.hAW != null) {
      i = this.hAW.a(paramString, paramC2CDownloadResult);
    }
    if ((i == 0) && (this.hAX != null)) {
      this.hAX.a(paramString, paramC2CDownloadResult);
    }
    AppMethodBeat.o(150390);
  }
  
  public final void onUploadProgressChanged(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(150381);
    com.tencent.mm.i.c localc = new com.tencent.mm.i.c();
    localc.field_finishedLength = ((int)paramLong1);
    localc.field_toltalLength = ((int)paramLong2);
    localc.field_status = 0;
    localc.field_mtlnotify = false;
    keep_onUploadProgress(paramString, localc);
    AppMethodBeat.o(150381);
  }
  
  public final void reportFlow(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(150378);
    if (!ai.ciE())
    {
      AppMethodBeat.o(150378);
      return;
    }
    ac.i("MicroMsg.CdnTransportEngine", "ReportFlow, wifi:s:%d, r:%d, mobile:s:%d, r:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt4), Integer.valueOf(paramInt3) });
    keep_cdnSendAndRecvData("dummy clientmsgid", paramInt2 + paramInt4, paramInt1 + paramInt3);
    AppMethodBeat.o(150378);
  }
  
  public final void requestGetCDN(int paramInt)
  {
    AppMethodBeat.i(150377);
    if (!ai.ciE())
    {
      AppMethodBeat.o(150377);
      return;
    }
    ac.i("MicroMsg.CdnTransportEngine", "requestgetcdn scene %d", new Object[] { Integer.valueOf(paramInt) });
    keep_OnRequestDoGetCdnDnsInfo(paramInt);
    AppMethodBeat.o(150377);
  }
  
  public final String[] resolveHost(String paramString, boolean paramBoolean, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(150379);
    if (!ai.ciE())
    {
      AppMethodBeat.o(150379);
      return null;
    }
    ac.i("MicroMsg.CdnTransportEngine", "try resolve host %s, isdc %b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    ArrayList localArrayList = new ArrayList();
    paramArrayOfInt[0] = com.tencent.mm.network.b.a(paramString, paramBoolean, localArrayList);
    paramString = (String[])localArrayList.toArray(new String[0]);
    ac.i("MicroMsg.CdnTransportEngine", "resolved dnstype %d iplist %s", new Object[] { Integer.valueOf(paramArrayOfInt[0]), Arrays.toString(paramString) });
    AppMethodBeat.o(150379);
    return paramString;
  }
  
  public static abstract interface a
  {
    public abstract int a(String paramString, com.tencent.mm.i.c paramc, d paramd);
    
    public abstract int d(String paramString1, int paramInt1, int paramInt2, String paramString2);
    
    public abstract int n(String paramString, int paramInt1, int paramInt2);
    
    public abstract int o(String paramString, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.an.a
 * JD-Core Version:    0.7.0.1
 */