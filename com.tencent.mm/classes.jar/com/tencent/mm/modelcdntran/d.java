package com.tencent.mm.modelcdntran;

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
import com.tencent.mm.autogen.mmdata.rpt.al;
import com.tencent.mm.g.a;
import com.tencent.mm.g.b.a;
import com.tencent.mm.g.g;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.e;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.misc.a.a.a;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.uu;
import com.tencent.mm.protocal.protobuf.uv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class d
  implements CdnLogic.AppCallback, CdnLogic.DownloadCallback, CdnLogic.SessionCallback, CdnLogic.UploadCallback, CdnLogic.VideoStreamingCallback
{
  private static int ozr = 7340033;
  private static int ozs = 100;
  private static int ozt = 101;
  private static int ozu = 102;
  private static int ozv = 103;
  private int ozA;
  private String ozB;
  private MTimerHandler ozC;
  private boolean ozD;
  f ozE;
  private a.a ozF;
  a ozG;
  public a ozH;
  private uu ozw;
  private b.a ozx;
  b.a ozy;
  private int ozz;
  
  public d(String paramString, b.a parama)
  {
    AppMethodBeat.i(150333);
    this.ozw = null;
    this.ozx = null;
    this.ozy = null;
    this.ozz = 0;
    this.ozA = 0;
    this.ozB = "";
    this.ozC = null;
    this.ozD = false;
    this.ozE = new f();
    this.ozF = new d.1(this);
    if (MMApplicationContext.isMMProcess()) {
      this.ozC = new MTimerHandler(com.tencent.mm.kernel.h.baH().getLooper(), new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(237820);
          if ((d.a(d.this) == 0) && (d.b(d.this) == 0))
          {
            AppMethodBeat.o(237820);
            return false;
          }
          Log.i("MicroMsg.CdnTransportEngine", "CdnDataFlowStat id:%s send:%d recv:%d", new Object[] { d.c(d.this), Integer.valueOf(d.a(d.this)), Integer.valueOf(d.b(d.this)) });
          if (az.a.okQ == null)
          {
            Log.e("MicroMsg.CdnTransportEngine", "getNetStat null");
            AppMethodBeat.o(237820);
            return false;
          }
          az.a.okQ.eB(d.b(d.this), d.a(d.this));
          d.d(d.this);
          d.e(d.this);
          AppMethodBeat.o(237820);
          return true;
        }
      }, true);
    }
    this.ozy = parama;
    CdnLogic.Initialize(paramString, this, "1", "BFEDFFB5EA28509F9C89ED83FA7FDDA8881435D444E984D53A98AD8E9410F1145EDD537890E10456190B22E6E5006455EFC6C12E41FDA985F38FBBC7213ECB810E3053D4B8D74FFBC70B4600ABD728202322AFCE1406046631261BD5EE3D44721082FEAB74340D73645DC0D02A293B962B9D47E4A64100BD7524DE00D9D3B5C1", "010001", "cdnwx2013usrname");
    Log.i("MicroMsg.CdnTransportEngine", "summersafecdn CdnTransportEngine init[%s] infoPath[%s], stack[%s]", new Object[] { Integer.valueOf(hashCode()), paramString, Util.getStack() });
    AppMethodBeat.o(150333);
  }
  
  public static int Nq(String paramString)
  {
    AppMethodBeat.i(150337);
    CdnLogic.cancelTask(paramString);
    AppMethodBeat.o(150337);
    return 0;
  }
  
  public static int Nr(String paramString)
  {
    AppMethodBeat.i(150339);
    CdnLogic.cancelTask(paramString);
    AppMethodBeat.o(150339);
    return 0;
  }
  
  public static String Ns(String paramString)
  {
    AppMethodBeat.i(150340);
    paramString = CdnLogic.calcFileMD5(y.n(paramString, false));
    AppMethodBeat.o(150340);
    return paramString;
  }
  
  public static int Nt(String paramString)
  {
    AppMethodBeat.i(150342);
    int i = CdnLogic.calcFileCrc32(y.n(paramString, false));
    AppMethodBeat.o(150342);
    return i;
  }
  
  public static String Nu(String paramString)
  {
    AppMethodBeat.i(150343);
    paramString = CdnLogic.calcMP4IdentifyMD5(y.n(paramString, false));
    AppMethodBeat.o(150343);
    return paramString;
  }
  
  public static int Nv(String paramString)
  {
    AppMethodBeat.i(150350);
    Log.i("MicroMsg.CdnTransportEngine", "stopHttpsDownload: mediaid:".concat(String.valueOf(paramString)));
    CdnLogic.cancelTask(paramString);
    AppMethodBeat.o(150350);
    return 0;
  }
  
  public static int Nw(String paramString)
  {
    AppMethodBeat.i(150352);
    Log.i("MicroMsg.CdnTransportEngine", "stopGamePackageDownload: mediaid:".concat(String.valueOf(paramString)));
    CdnLogic.cancelTask(paramString);
    AppMethodBeat.o(150352);
    return 0;
  }
  
  /* Error */
  private static int Nx(String paramString)
  {
    // Byte code:
    //   0: ldc 222
    //   2: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 140
    //   7: ldc 224
    //   9: iconst_1
    //   10: anewarray 4	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: aload_0
    //   16: aastore
    //   17: invokestatic 163	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   20: aload_0
    //   21: ldc 226
    //   23: invokevirtual 230	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   26: ifne +26 -> 52
    //   29: aload_0
    //   30: ldc 232
    //   32: invokevirtual 230	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   35: ifne +17 -> 52
    //   38: ldc 140
    //   40: ldc 234
    //   42: invokestatic 237	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: ldc 222
    //   47: invokestatic 166	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: iconst_0
    //   51: ireturn
    //   52: aload_0
    //   53: invokestatic 243	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
    //   56: invokevirtual 247	java/net/InetAddress:getAddress	()[B
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
    //   103: ldc 140
    //   105: ldc 249
    //   107: iconst_2
    //   108: anewarray 4	java/lang/Object
    //   111: dup
    //   112: iconst_0
    //   113: aload_0
    //   114: aastore
    //   115: dup
    //   116: iconst_1
    //   117: iload_2
    //   118: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   121: aastore
    //   122: invokestatic 163	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   125: ldc 222
    //   127: invokestatic 166	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static int a(String paramString1, String paramString2, String paramString3, CdnLogic.DownloadCallback paramDownloadCallback)
  {
    AppMethodBeat.i(237922);
    CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
    localC2CDownloadRequest.fileKey = paramString1;
    localC2CDownloadRequest.url = paramString2;
    localC2CDownloadRequest.setSavePath(paramString3);
    localC2CDownloadRequest.fileType = 20303;
    localC2CDownloadRequest.taskStartTime = System.currentTimeMillis();
    localC2CDownloadRequest.maxHttpRedirectCount = 10;
    int i = CdnLogic.startHttpsDownload(localC2CDownloadRequest, paramDownloadCallback);
    AppMethodBeat.o(237922);
    return i;
  }
  
  public static int a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, CdnLogic.DownloadCallback paramDownloadCallback)
  {
    AppMethodBeat.i(237940);
    Log.i("MicroMsg.CdnTransportEngine", "startLanDownload: mediaid:".concat(String.valueOf(paramString1)));
    CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
    localC2CDownloadRequest.fileKey = paramString1;
    localC2CDownloadRequest.url = paramString2;
    localC2CDownloadRequest.aeskey = paramString3;
    localC2CDownloadRequest.setSavePath(paramString4);
    localC2CDownloadRequest.queueTimeoutSeconds = paramInt;
    localC2CDownloadRequest.transforTimeoutSeconds = 600;
    localC2CDownloadRequest.needEchoAfterDownSucc = true;
    paramInt = CdnLogic.startHttpMultiSocketDownloadTask(localC2CDownloadRequest, paramDownloadCallback);
    AppMethodBeat.o(237940);
    return paramInt;
  }
  
  private static CdnLogic.CdnInfo a(uu paramuu)
  {
    AppMethodBeat.i(150359);
    CdnLogic.CdnInfo localCdnInfo = new CdnLogic.CdnInfo();
    if (paramuu == null)
    {
      AppMethodBeat.o(150359);
      return localCdnInfo;
    }
    localCdnInfo.ver = paramuu.Zam;
    localCdnInfo.uin = paramuu.yth;
    localCdnInfo.frontid = paramuu.Zao;
    localCdnInfo.zoneid = paramuu.Zat;
    MMApplicationContext.getContext();
    localCdnInfo.nettype = h.bHP();
    localCdnInfo.authkey = w.a(paramuu.Zas);
    if (paramuu.Zap >= 2)
    {
      localCdnInfo.frontip1 = w.a((etl)paramuu.Zaq.get(0));
      localCdnInfo.frontip2 = w.a((etl)paramuu.Zaq.get(1));
      Log.i("MicroMsg.CdnTransportEngine", "frontip %s, %s", new Object[] { localCdnInfo.frontip1, localCdnInfo.frontip2 });
    }
    if (paramuu.Zau >= 2)
    {
      localCdnInfo.zoneip1 = w.a((etl)paramuu.Zav.get(0));
      localCdnInfo.zoneip2 = w.a((etl)paramuu.Zav.get(1));
      Log.i("MicroMsg.CdnTransportEngine", "zoneip %s, %s", new Object[] { localCdnInfo.frontip1, localCdnInfo.frontip2 });
    }
    int j;
    int i;
    if (paramuu.Zay > 0)
    {
      j = ((uv)paramuu.Zaw.get(0)).ZaA;
      localCdnInfo.frontports = new int[j];
      i = 0;
      while (i < j)
      {
        localCdnInfo.frontports[i] = ((Integer)((uv)paramuu.Zaw.get(0)).ZaB.get(i)).intValue();
        i += 1;
      }
    }
    if (paramuu.Zaz > 0)
    {
      j = ((uv)paramuu.Zax.get(0)).ZaA;
      localCdnInfo.zoneports = new int[j];
      i = 0;
      while (i < j)
      {
        localCdnInfo.zoneports[i] = ((Integer)((uv)paramuu.Zax.get(0)).ZaB.get(i)).intValue();
        i += 1;
      }
    }
    AppMethodBeat.o(150359);
    return localCdnInfo;
  }
  
  private static com.tencent.mm.g.d a(CdnLogic.C2CDownloadResult paramC2CDownloadResult, com.tencent.mm.g.d paramd)
  {
    AppMethodBeat.i(150362);
    com.tencent.mm.g.d locald = paramd;
    if (paramd == null) {
      locald = new com.tencent.mm.g.d();
    }
    locald.field_retCode = paramC2CDownloadResult.errorCode;
    locald.field_argInfo = paramC2CDownloadResult.argInfo;
    locald.field_fileLength = paramC2CDownloadResult.fileSize;
    locald.field_fileId = paramC2CDownloadResult.fileid;
    locald.field_transInfo = paramC2CDownloadResult.transforMsg;
    locald.traceMsg = paramC2CDownloadResult.traceMsg;
    locald.field_convert2baseline = false;
    locald.field_recvedBytes = paramC2CDownloadResult.recvedBytes;
    locald.field_videoFormat = paramC2CDownloadResult.videoFormat;
    locald.field_videoFlag = paramC2CDownloadResult.videoFlag;
    locald.field_videoCdnMsg = paramC2CDownloadResult.videoCdnMsg;
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
    locald.svrFallbackCount = paramC2CDownloadResult.svrFallbackCount;
    locald.field_httpStatusCode = paramC2CDownloadResult.httpStatusCode;
    locald.field_httpResponseHeader = paramC2CDownloadResult.httpResponseHeader;
    locald.field_delayTime = paramC2CDownloadResult.delayTime;
    locald.field_dnsCostTime = paramC2CDownloadResult.dnsCostTime;
    locald.field_connectCostTime = paramC2CDownloadResult.connectCostTime;
    locald.field_waitResponseCostTime = paramC2CDownloadResult.waitResponseCostTime;
    locald.field_receiveCostTime = paramC2CDownloadResult.receiveCostTime;
    locald.field_clientIP = paramC2CDownloadResult.clientIP;
    locald.field_serverIP = paramC2CDownloadResult.serverIP;
    locald.field_clientHostIP = Nx(paramC2CDownloadResult.clientIP);
    locald.field_serverHostIP = Nx(paramC2CDownloadResult.serverIP);
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
      locald.lwz = paramC2CDownloadResult.usedSvrIps[(paramC2CDownloadResult.usedSvrIps.length - 1)];
      locald.lastSvrPort = paramC2CDownloadResult.lastSvrPort;
      locald.lastNetType = paramC2CDownloadResult.lastNetType;
    }
    locald.field_isResume = paramC2CDownloadResult.isResume;
    locald.lwA = paramC2CDownloadResult.isSnsImageProtocolAvailable;
    locald.index = paramC2CDownloadResult.picIndex;
    locald.cachePath = paramC2CDownloadResult.picCachePath;
    locald.hQX = paramC2CDownloadResult.batchPicFeedId;
    locald.fileKey = paramC2CDownloadResult.batchImageFileKey;
    locald.lwB = paramC2CDownloadResult.batchImageNeedRetry;
    locald.transportProtocol = paramC2CDownloadResult.transportProtocol;
    locald.transportProtocolError = paramC2CDownloadResult.transportProtocolError;
    locald.traceId = paramC2CDownloadResult.traceId;
    locald.profile = paramC2CDownloadResult.profile;
    Log.d("MicroMsg.CdnTransportEngine", "trace_id " + locald.traceId + " flag " + locald.field_videoFlag + " msg " + locald.field_videoCdnMsg + " " + locald.svrFallbackCount);
    AppMethodBeat.o(150362);
    return locald;
  }
  
  private static void a(com.tencent.mm.g.d paramd)
  {
    AppMethodBeat.i(150374);
    if ((paramd != null) && (!Util.isNullOrNil(paramd.field_transInfo)))
    {
      int i = paramd.field_transInfo.indexOf("@,");
      if (i > 0)
      {
        paramd.lwx = paramd.field_transInfo.substring(i + 2);
        paramd.field_transInfo = paramd.field_transInfo.substring(0, i);
      }
      Log.v("MicroMsg.CdnTransportEngine", "transinfo:%s, report_part2:%s", new Object[] { paramd.field_transInfo, paramd.lwx });
    }
    AppMethodBeat.o(150374);
  }
  
  private static CdnLogic.C2CUploadRequest b(g paramg)
  {
    boolean bool2 = true;
    AppMethodBeat.i(237888);
    CdnLogic.C2CUploadRequest localC2CUploadRequest = new CdnLogic.C2CUploadRequest();
    localC2CUploadRequest.fileKey = paramg.field_mediaId;
    localC2CUploadRequest.setFilePath(paramg.field_fullpath);
    localC2CUploadRequest.setThumbfilePath(paramg.field_thumbpath);
    localC2CUploadRequest.fileSize = paramg.field_totalLen;
    localC2CUploadRequest.fileType = paramg.field_fileType;
    localC2CUploadRequest.forwardAeskey = paramg.field_aesKey;
    localC2CUploadRequest.forwardFileid = paramg.field_fileId;
    localC2CUploadRequest.midfileSize = paramg.field_midFileLength;
    localC2CUploadRequest.queueTimeoutSeconds = paramg.lwP;
    localC2CUploadRequest.transforTimeoutSeconds = paramg.lwQ;
    localC2CUploadRequest.toUser = paramg.field_talker;
    localC2CUploadRequest.sendmsgFromCDN = paramg.field_sendmsg_viacdn;
    localC2CUploadRequest.needCompressImage = paramg.field_needCompressImage;
    localC2CUploadRequest.chatType = paramg.field_chattype;
    localC2CUploadRequest.apptype = paramg.field_appType;
    localC2CUploadRequest.bizscene = paramg.field_bzScene;
    localC2CUploadRequest.marscdnBizType = paramg.hyY;
    localC2CUploadRequest.checkExistOnly = paramg.field_onlycheckexist;
    if (paramg.field_smallVideoFlag == 1)
    {
      bool1 = true;
      localC2CUploadRequest.isSmallVideo = bool1;
      localC2CUploadRequest.isLargeSVideo = paramg.field_largesvideo;
      localC2CUploadRequest.videoSource = paramg.field_videosource;
      if (paramg.field_advideoflag != 1) {
        break label395;
      }
    }
    label395:
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
      if (Util.isNullOrNil(localC2CUploadRequest.bigfileSignature)) {
        localC2CUploadRequest.bigfileSignature = "";
      }
      localC2CUploadRequest.fakeBigfileSignature = paramg.field_fake_bigfile_signature;
      if (Util.isNullOrNil(localC2CUploadRequest.fakeBigfileSignature)) {
        localC2CUploadRequest.fakeBigfileSignature = "";
      }
      localC2CUploadRequest.fakeBigfileSignatureAeskey = paramg.field_fake_bigfile_signature_aeskey;
      if (Util.isNullOrNil(localC2CUploadRequest.fakeBigfileSignatureAeskey)) {
        localC2CUploadRequest.fakeBigfileSignatureAeskey = "";
      }
      localC2CUploadRequest.lastError = paramg.lastError;
      localC2CUploadRequest.emojiExtinfo = paramg.emojiExtinfo;
      localC2CUploadRequest.snsVersion = paramg.snsVersion;
      localC2CUploadRequest.fileBuffer = paramg.fileBuffer;
      localC2CUploadRequest.thumbnailBuffer = paramg.thumbnailBuffer;
      localC2CUploadRequest.customHeader = paramg.customHeader;
      localC2CUploadRequest.useMultithread = paramg.field_use_multithread;
      AppMethodBeat.o(237888);
      return localC2CUploadRequest;
      bool1 = false;
      break;
    }
  }
  
  public static String bHI()
  {
    AppMethodBeat.i(150341);
    String str = CdnLogic.createAeskey();
    AppMethodBeat.o(150341);
    return str;
  }
  
  public static int bHK()
  {
    return 0;
  }
  
  public static int c(String paramString, com.tencent.mm.g.d paramd)
  {
    AppMethodBeat.i(150356);
    Log.i("MicroMsg.CdnTransportEngine", "[stopVideoStreamingDownload] mediaId=%s %s", new Object[] { paramString, Util.getStack() });
    CdnLogic.C2CDownloadResult localC2CDownloadResult = new CdnLogic.C2CDownloadResult();
    int i = CdnLogic.cancelDownloadTaskWithResult(paramString, localC2CDownloadResult);
    a(localC2CDownloadResult, paramd);
    AppMethodBeat.o(150356);
    return i;
  }
  
  private static CdnLogic.C2CDownloadRequest c(g paramg)
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
        break label370;
      }
    }
    label370:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localC2CDownloadRequest.isLargeSVideo = bool1;
      localC2CDownloadRequest.limitRate = paramg.field_limitrate;
      localC2CDownloadRequest.isAutoStart = paramg.field_autostart;
      localC2CDownloadRequest.chatType = paramg.field_chattype;
      localC2CDownloadRequest.isSilentTask = paramg.field_isSilentTask;
      localC2CDownloadRequest.requestVideoFormat = paramg.field_requestVideoFormat;
      localC2CDownloadRequest.isColdSnsData = paramg.isColdSnsData;
      localC2CDownloadRequest.isHotSnsVideo = paramg.isHotSnsVideo;
      localC2CDownloadRequest.signalQuality = paramg.field_signalQuality;
      localC2CDownloadRequest.snsScene = paramg.field_snsScene;
      localC2CDownloadRequest.requestVideoFormat = paramg.field_requestVideoFormat;
      localC2CDownloadRequest.isHLSVideo = paramg.isHLSVideo;
      localC2CDownloadRequest.hlsVideoFlag = paramg.hlsVideoFlag;
      localC2CDownloadRequest.videofileid = paramg.field_videoFileId;
      localC2CDownloadRequest.bigfileSignature = paramg.field_svr_signature;
      if (Util.isNullOrNil(localC2CDownloadRequest.bigfileSignature)) {
        localC2CDownloadRequest.bigfileSignature = "";
      }
      localC2CDownloadRequest.fakeBigfileSignature = paramg.field_fake_bigfile_signature;
      if (Util.isNullOrNil(localC2CDownloadRequest.fakeBigfileSignature)) {
        localC2CDownloadRequest.fakeBigfileSignature = "";
      }
      localC2CDownloadRequest.fakeBigfileSignatureAeskey = paramg.field_fake_bigfile_signature_aeskey;
      if (Util.isNullOrNil(localC2CDownloadRequest.fakeBigfileSignatureAeskey)) {
        localC2CDownloadRequest.fakeBigfileSignatureAeskey = "";
      }
      localC2CDownloadRequest.msgExtra = paramg.field_wxmsgparam;
      if (Util.isNullOrNil(localC2CDownloadRequest.msgExtra)) {
        localC2CDownloadRequest.msgExtra = "";
      }
      localC2CDownloadRequest.queueTimeoutSeconds = paramg.lwP;
      localC2CDownloadRequest.transforTimeoutSeconds = paramg.lwQ;
      localC2CDownloadRequest.preloadRatio = paramg.field_preloadRatio;
      localC2CDownloadRequest.certificateVerifyPolicy = paramg.certificateVerifyPolicy;
      localC2CDownloadRequest.expectImageFormat = paramg.expectImageFormat;
      localC2CDownloadRequest.marscdnBizType = paramg.hyY;
      localC2CDownloadRequest.useMultithread = paramg.field_use_multithread;
      AppMethodBeat.o(150335);
      return localC2CDownloadRequest;
      bool1 = false;
      break;
    }
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
    if (paramInt1 == ozs) {
      h.outputJniLog(paramArrayOfByte, "MicroMsg.CdnEngine", paramInt2);
    }
    AppMethodBeat.o(150334);
    return 0;
  }
  
  public static int requestVideoData(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(237961);
    paramInt = CdnLogic.requestVideoData(paramString, paramLong1, paramLong2, paramInt);
    AppMethodBeat.o(237961);
    return paramInt;
  }
  
  public final int a(com.tencent.mm.g.e parame)
  {
    AppMethodBeat.i(238114);
    if ((Util.isNullOrNil(parame.field_mediaId)) || (Util.isNullOrNil(parame.url)) || (Util.isNullOrNil(parame.lwD)))
    {
      Log.e("MicroMsg.CdnTransportEngine", "invalid param.");
      AppMethodBeat.o(238114);
      return -1;
    }
    CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
    localC2CDownloadRequest.fileType = 20201;
    localC2CDownloadRequest.fileKey = parame.field_mediaId;
    localC2CDownloadRequest.url = parame.url;
    localC2CDownloadRequest.referer = parame.referer;
    localC2CDownloadRequest.setSavePath(parame.lwD);
    localC2CDownloadRequest.fileSize = 0;
    localC2CDownloadRequest.isColdSnsData = parame.isColdSnsData;
    localC2CDownloadRequest.signalQuality = parame.signalQuality;
    localC2CDownloadRequest.snsScene = parame.snsScene;
    localC2CDownloadRequest.snsCipherKey = parame.snsCipherKey;
    localC2CDownloadRequest.concurrentCount = 6;
    localC2CDownloadRequest.marscdnBizType = parame.hyY;
    localC2CDownloadRequest.marscdnAppType = parame.appType;
    localC2CDownloadRequest.fileType = parame.fileType;
    localC2CDownloadRequest.requestVideoFormat = parame.field_requestVideoFormat;
    if ((z.pCF) && (z.pCK.length() > 0))
    {
      localC2CDownloadRequest.debugIP = z.pCK;
      Log.w("MicroMsg.CdnTransportEngine", "debugip " + localC2CDownloadRequest.debugIP);
    }
    int i = CdnLogic.startSNSDownload(localC2CDownloadRequest, this, this, 0);
    AppMethodBeat.o(238114);
    return i;
  }
  
  public final int a(com.tencent.mm.g.f paramf)
  {
    AppMethodBeat.i(150348);
    CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
    localC2CDownloadRequest.fileType = 20201;
    localC2CDownloadRequest.fileKey = paramf.field_mediaId;
    localC2CDownloadRequest.url = paramf.url;
    localC2CDownloadRequest.referer = paramf.referer;
    localC2CDownloadRequest.isColdSnsData = paramf.isColdSnsData;
    localC2CDownloadRequest.signalQuality = paramf.signalQuality;
    localC2CDownloadRequest.snsScene = paramf.snsScene;
    localC2CDownloadRequest.concurrentCount = 6;
    localC2CDownloadRequest.marscdnBizType = paramf.hyY;
    localC2CDownloadRequest.marscdnAppType = paramf.appType;
    localC2CDownloadRequest.fileType = paramf.fileType;
    localC2CDownloadRequest.msgType = 2;
    localC2CDownloadRequest.feedId = paramf.hQX;
    localC2CDownloadRequest.feedPicCount = paramf.lwI;
    localC2CDownloadRequest.batchSnsReqImageDatas = paramf.lwB;
    if ((z.pCF) && (z.pCK.length() > 0))
    {
      localC2CDownloadRequest.debugIP = z.pCK;
      Log.w("MicroMsg.CdnTransportEngine", "debugip " + localC2CDownloadRequest.debugIP);
    }
    int i = CdnLogic.startSNSDownload(localC2CDownloadRequest, this, this, 0);
    AppMethodBeat.o(150348);
    return i;
  }
  
  public final int a(g paramg, int paramInt)
  {
    AppMethodBeat.i(150353);
    paramg = c(paramg);
    if ((z.pCF) && (z.pCK.length() > 0))
    {
      paramg.debugIP = z.pCK;
      Log.w("MicroMsg.CdnTransportEngine", "debugip " + paramg.debugIP);
    }
    paramInt = CdnLogic.startVideoStreamingDownload(paramg, this, this, paramInt);
    AppMethodBeat.o(150353);
    return paramInt;
  }
  
  public final int a(com.tencent.mm.g.h paramh)
  {
    AppMethodBeat.i(238101);
    CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
    localC2CDownloadRequest.fileType = 20202;
    localC2CDownloadRequest.fileKey = paramh.field_mediaId;
    localC2CDownloadRequest.url = paramh.url;
    localC2CDownloadRequest.referer = paramh.referer;
    localC2CDownloadRequest.setSavePath(paramh.field_fullpath);
    localC2CDownloadRequest.fileSize = 0;
    localC2CDownloadRequest.isColdSnsData = paramh.isColdSnsData;
    localC2CDownloadRequest.isHotSnsVideo = paramh.isHotSnsVideo;
    localC2CDownloadRequest.isHLSVideo = paramh.isHLSVideo;
    localC2CDownloadRequest.hlsVideoFlag = paramh.hlsVideoFlag;
    localC2CDownloadRequest.signalQuality = paramh.signalQuality;
    localC2CDownloadRequest.snsScene = paramh.snsScene;
    localC2CDownloadRequest.preloadRatio = paramh.field_preloadRatio;
    localC2CDownloadRequest.preloadMinSize = paramh.preloadMinSize;
    localC2CDownloadRequest.requestVideoFormat = paramh.field_requestVideoFormat;
    localC2CDownloadRequest.connectionCount = paramh.connectionCount;
    localC2CDownloadRequest.concurrentCount = paramh.concurrentCount;
    if ((z.pCF) && (z.pCK.length() > 0))
    {
      localC2CDownloadRequest.debugIP = z.pCK;
      Log.w("MicroMsg.CdnTransportEngine", "debugip " + localC2CDownloadRequest.debugIP);
    }
    int i = CdnLogic.startSNSDownload(localC2CDownloadRequest, this, this, paramh.lxi);
    AppMethodBeat.o(238101);
    return i;
  }
  
  public final int a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String[] paramArrayOfString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(238091);
    if (paramArrayOfString == null) {}
    CdnLogic.C2CDownloadRequest localC2CDownloadRequest;
    for (int i = 0;; i = paramArrayOfString.length)
    {
      Log.i("MicroMsg.CdnTransportEngine", "startURLDownload: mediaid:%s, savepath:%s, filetype:%d, timeout:%d, %d, ip.size:%d, gzip:%b", new Object[] { paramString1, paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(i), Boolean.valueOf(paramBoolean1) });
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
      if (a.lwn != localC2CDownloadRequest.fileType) {
        break label261;
      }
      if (paramBoolean3) {
        localC2CDownloadRequest.useNewdns = true;
      }
      if (!paramBoolean2) {
        break;
      }
      Log.i("MicroMsg.CdnTransportEngine", "use cronet download pkg mediaId:%s, url:%s", new Object[] { paramString1, paramString2 });
      paramInt1 = CdnLogic.startCronetFileDownload(localC2CDownloadRequest, this);
      AppMethodBeat.o(238091);
      return paramInt1;
    }
    Log.i("MicroMsg.CdnTransportEngine", "use normal download pkg mediaId:%s, url:%s", new Object[] { paramString1, paramString2 });
    paramInt1 = CdnLogic.startHttpsDownload(localC2CDownloadRequest, this);
    AppMethodBeat.o(238091);
    return paramInt1;
    label261:
    if ((paramInt1 == a.lwp) && (!this.ozD))
    {
      localC2CDownloadRequest.pcdnAppID = 30002;
      localC2CDownloadRequest.maxPCDNConnections = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zhR, 0);
      Log.i("MicroMsg.CdnTransportEngine", "pcdn maxconn %d for patch", new Object[] { Integer.valueOf(localC2CDownloadRequest.maxPCDNConnections) });
    }
    paramInt1 = CdnLogic.startURLDownload(localC2CDownloadRequest, this);
    AppMethodBeat.o(238091);
    return paramInt1;
  }
  
  public final int a(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(238083);
    Log.i("MicroMsg.CdnTransportEngine", "startURLDownload: mediaid:%s, savepath:%s", new Object[] { paramString1, paramString3 });
    CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
    localC2CDownloadRequest.fileKey = paramString1;
    localC2CDownloadRequest.url = paramString2;
    localC2CDownloadRequest.setSavePath(paramString3);
    localC2CDownloadRequest.aeskey = paramString4;
    localC2CDownloadRequest.customHeader = ("authkey:" + paramString5 + "\r\n");
    localC2CDownloadRequest.fileSize = paramInt2;
    localC2CDownloadRequest.useCronet = paramBoolean;
    localC2CDownloadRequest.fileType = paramInt1;
    paramInt1 = CdnLogic.startSNSDownload(localC2CDownloadRequest, this, this, 0);
    AppMethodBeat.o(238083);
    return paramInt1;
  }
  
  public final int a(String paramString1, String paramString2, String paramString3, String paramString4, Map<String, String> paramMap, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, boolean paramBoolean3, String[] paramArrayOfString)
  {
    AppMethodBeat.i(150351);
    Log.i("MicroMsg.CdnTransportEngine", "startGamePackageDownload: mediaid:".concat(String.valueOf(paramString1)));
    CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
    localC2CDownloadRequest.fileKey = paramString1;
    localC2CDownloadRequest.url = paramString3;
    localC2CDownloadRequest.bakup_url = paramString4;
    localC2CDownloadRequest.setSavePath(paramString2);
    localC2CDownloadRequest.queueTimeoutSeconds = paramInt1;
    localC2CDownloadRequest.transforTimeoutSeconds = paramInt2;
    localC2CDownloadRequest.ocIpList = paramArrayOfString;
    localC2CDownloadRequest.is_resume_task = paramBoolean2;
    localC2CDownloadRequest.fileType = a.lwo;
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
    localC2CDownloadRequest.customHeader = String.format("X-Forwarded-Access-Type:%s\r\n", new Object[] { NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext()) });
    if (!this.ozD)
    {
      localC2CDownloadRequest.pcdnAppID = 30003;
      localC2CDownloadRequest.maxPCDNConnections = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zhT, 0);
      Log.i("MicroMsg.CdnTransportEngine", "pcdn maxconn %d for game", new Object[] { Integer.valueOf(localC2CDownloadRequest.maxPCDNConnections) });
    }
    paramInt1 = CdnLogic.startHttpMultiSocketDownloadTask(localC2CDownloadRequest, this);
    AppMethodBeat.o(150351);
    return paramInt1;
  }
  
  public final void a(b.a parama)
  {
    int i = 0;
    AppMethodBeat.i(238067);
    this.ozx = parama;
    int j = hashCode();
    if (parama != null) {
      i = parama.hashCode();
    }
    Log.i("MicroMsg.CdnTransportEngine", "set tp player cdn callback hash[%d] cdnTransCallback[%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
    AppMethodBeat.o(238067);
  }
  
  public final void a(a parama)
  {
    int i = 0;
    AppMethodBeat.i(238060);
    this.ozG = parama;
    int j = hashCode();
    if (parama != null) {
      i = parama.hashCode();
    }
    Log.i("MicroMsg.CdnTransportEngine", "set tp player cdn callback hash[%d] onlineVideoCallback[%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
    AppMethodBeat.o(238060);
  }
  
  public final boolean a(uu paramuu1, uu paramuu2, uu paramuu3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, uu paramuu4)
  {
    AppMethodBeat.i(150360);
    Log.i("MicroMsg.CdnTransportEngine", "summersafecdn cdntra setCDNDnsInfo old [%s]  new [%s], safecdn [%s], stack[%s]", new Object[] { this.ozw, paramuu1, paramuu4, Util.getStack() });
    if ((paramuu1 == null) && (paramArrayOfByte1 == null))
    {
      AppMethodBeat.o(150360);
      return false;
    }
    this.ozw = paramuu1;
    try
    {
      paramuu1 = a(paramuu1);
      paramuu2 = a(paramuu2);
      paramuu3 = a(paramuu3);
      paramuu4 = a(paramuu4);
      CdnLogic.setLegacyCdnInfo(paramuu1, paramuu2, paramuu3, paramuu4, paramArrayOfByte1, paramArrayOfByte2);
      AppMethodBeat.o(150360);
      return true;
    }
    catch (Exception paramuu1)
    {
      Log.e("MicroMsg.CdnTransportEngine", "tocdninfo failed:" + paramuu1.getLocalizedMessage());
      AppMethodBeat.o(150360);
    }
    return false;
  }
  
  public final int b(com.tencent.mm.g.h paramh)
  {
    AppMethodBeat.i(238106);
    CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
    localC2CDownloadRequest.fileType = 20302;
    localC2CDownloadRequest.fileKey = paramh.field_mediaId;
    localC2CDownloadRequest.url = paramh.url;
    localC2CDownloadRequest.referer = paramh.referer;
    localC2CDownloadRequest.setSavePath(paramh.field_fullpath);
    localC2CDownloadRequest.fileSize = 0;
    localC2CDownloadRequest.isColdSnsData = paramh.isColdSnsData;
    localC2CDownloadRequest.isHotSnsVideo = paramh.isHotSnsVideo;
    localC2CDownloadRequest.isHLSVideo = paramh.isHLSVideo;
    localC2CDownloadRequest.hlsVideoFlag = paramh.hlsVideoFlag;
    localC2CDownloadRequest.signalQuality = paramh.signalQuality;
    localC2CDownloadRequest.snsScene = paramh.snsScene;
    localC2CDownloadRequest.preloadRatio = paramh.field_preloadRatio;
    localC2CDownloadRequest.preloadMinSize = paramh.preloadMinSize;
    localC2CDownloadRequest.requestVideoFormat = paramh.field_requestVideoFormat;
    localC2CDownloadRequest.connectionCount = paramh.connectionCount;
    localC2CDownloadRequest.marscdnAppType = 205;
    if ((z.pCF) && (z.pCK.length() > 0))
    {
      localC2CDownloadRequest.debugIP = z.pCK;
      Log.w("MicroMsg.CdnTransportEngine", "debugip " + localC2CDownloadRequest.debugIP);
    }
    int i = CdnLogic.startSNSDownload(localC2CDownloadRequest, this, this, paramh.lxi);
    AppMethodBeat.o(238106);
    return i;
  }
  
  public final boolean bHJ()
  {
    return this.ozw == null;
  }
  
  public final int c(com.tencent.mm.g.h paramh)
  {
    AppMethodBeat.i(238111);
    CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
    localC2CDownloadRequest.fileType = 20302;
    localC2CDownloadRequest.fileKey = paramh.field_mediaId;
    localC2CDownloadRequest.url = paramh.url;
    localC2CDownloadRequest.referer = paramh.referer;
    localC2CDownloadRequest.setSavePath(paramh.field_fullpath);
    localC2CDownloadRequest.fileSize = 0;
    localC2CDownloadRequest.isColdSnsData = paramh.isColdSnsData;
    localC2CDownloadRequest.isHotSnsVideo = paramh.isHotSnsVideo;
    localC2CDownloadRequest.isHLSVideo = paramh.isHLSVideo;
    localC2CDownloadRequest.hlsVideoFlag = paramh.hlsVideoFlag;
    localC2CDownloadRequest.signalQuality = paramh.signalQuality;
    localC2CDownloadRequest.snsScene = paramh.snsScene;
    localC2CDownloadRequest.preloadRatio = paramh.field_preloadRatio;
    localC2CDownloadRequest.preloadMinSize = paramh.preloadMinSize;
    localC2CDownloadRequest.requestVideoFormat = paramh.field_requestVideoFormat;
    localC2CDownloadRequest.connectionCount = paramh.connectionCount;
    localC2CDownloadRequest.snsCipherKey = paramh.snsCipherKey;
    localC2CDownloadRequest.marscdnAppType = 251;
    localC2CDownloadRequest.videoflagPolicy = paramh.lxp;
    localC2CDownloadRequest.concurrentCount = paramh.concurrentCount;
    if ((paramh.videoFlag != null) && ((paramh.videoFlag.indexOf('x') >= 0) || (paramh.videoFlag.indexOf('X') >= 0))) {}
    for (localC2CDownloadRequest.requestVideoFlag = paramh.videoFlag.substring(1);; localC2CDownloadRequest.requestVideoFlag = paramh.videoFlag)
    {
      if ((z.pCF) && (z.pCK.length() > 0))
      {
        localC2CDownloadRequest.debugIP = z.pCK;
        Log.w("MicroMsg.CdnTransportEngine", "debugip " + localC2CDownloadRequest.debugIP);
      }
      int i = CdnLogic.startSNSDownload(localC2CDownloadRequest, this, this, paramh.lxi);
      AppMethodBeat.o(238111);
      return i;
    }
  }
  
  public final int d(g paramg)
  {
    AppMethodBeat.i(150336);
    paramg = b(paramg);
    if ((z.pCF) && (z.pCK.length() > 0))
    {
      paramg.debugIP = z.pCK;
      Log.w("MicroMsg.CdnTransportEngine", "debugip " + paramg.debugIP);
    }
    if (paramg.sendmsgFromCDN)
    {
      i = CdnLogic.startSSUpload(paramg, this, this);
      AppMethodBeat.o(150336);
      return i;
    }
    int i = CdnLogic.startC2CUpload(paramg, this);
    AppMethodBeat.o(150336);
    return i;
  }
  
  public final int d(com.tencent.mm.g.h paramh)
  {
    AppMethodBeat.i(238124);
    CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
    localC2CDownloadRequest.fileKey = paramh.field_mediaId;
    localC2CDownloadRequest.fileType = 90;
    localC2CDownloadRequest.url = paramh.url;
    localC2CDownloadRequest.referer = paramh.referer;
    localC2CDownloadRequest.setSavePath(paramh.field_fullpath);
    localC2CDownloadRequest.preloadRatio = paramh.field_preloadRatio;
    localC2CDownloadRequest.preloadMinSize = paramh.preloadMinSize;
    localC2CDownloadRequest.concurrentCount = paramh.concurrentCount;
    localC2CDownloadRequest.maxHttpRedirectCount = 20;
    if ((z.pCF) && (z.pCK.length() > 0))
    {
      localC2CDownloadRequest.debugIP = z.pCK;
      Log.w("MicroMsg.CdnTransportEngine", "debugip " + localC2CDownloadRequest.debugIP);
    }
    int i = CdnLogic.startHttpVideoStreamingDownload(localC2CDownloadRequest, this, this, paramh.lxi);
    AppMethodBeat.o(238124);
    return i;
  }
  
  public final byte[] decodeSessionResponseBuf(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150384);
    if (!MMApplicationContext.isMMProcess())
    {
      AppMethodBeat.o(150384);
      return null;
    }
    paramString = keep_cdnDecodePrepareResponse(paramString, paramArrayOfByte);
    AppMethodBeat.o(150384);
    return paramString;
  }
  
  public final int e(g paramg)
  {
    AppMethodBeat.i(150338);
    paramg = c(paramg);
    if ((z.pCF) && (z.pCK.length() > 0))
    {
      paramg.debugIP = z.pCK;
      Log.w("MicroMsg.CdnTransportEngine", "debugip " + paramg.debugIP);
    }
    int i = CdnLogic.startC2CDownload(paramg, this);
    AppMethodBeat.o(150338);
    return i;
  }
  
  protected final void finalize() {}
  
  public final byte[] getSessionRequestBuf(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150383);
    if (!MMApplicationContext.isMMProcess())
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
    com.tencent.mm.kernel.h.baC();
    if (b.aZM()) {
      k.bHT().vX(paramInt);
    }
    AppMethodBeat.o(150376);
  }
  
  public final byte[] keep_cdnDecodePrepareResponse(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150370);
    if (this.ozy != null)
    {
      paramString = this.ozy.h(paramString, paramArrayOfByte);
      AppMethodBeat.o(150370);
      return paramString;
    }
    AppMethodBeat.o(150370);
    return null;
  }
  
  public final void keep_cdnGetSkeyBuf(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    AppMethodBeat.i(150369);
    if (this.ozy != null) {
      this.ozy.a(paramString, paramByteArrayOutputStream);
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
    this.ozz += paramInt1;
    this.ozA += paramInt2;
    if (!Util.isNullOrNil(paramString)) {
      this.ozB = paramString;
    }
    if ((this.ozz + this.ozA > 51200) && (this.ozC != null)) {
      this.ozC.startTimer(500L);
    }
    AppMethodBeat.o(150375);
  }
  
  public final void keep_onDataAvailable(String paramString, long paramLong1, long paramLong2)
  {
    int i = 0;
    AppMethodBeat.i(150372);
    Log.i("MicroMsg.CdnTransportEngine", "keep_onDataAvailable %s, %d, %d", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if (this.ozG != null) {
      i = this.ozG.t(paramString, (int)paramLong1, (int)paramLong2);
    }
    if ((i == 0) && (this.ozH != null)) {
      this.ozH.t(paramString, (int)paramLong1, (int)paramLong2);
    }
    AppMethodBeat.o(150372);
  }
  
  public final int keep_onDownloadError(String paramString, com.tencent.mm.g.d paramd)
  {
    AppMethodBeat.i(150367);
    if (!Util.isNullOrNil(paramString))
    {
      e locale = new e(e.a.ozN, paramString);
      if (paramd != null) {
        locale.ret = paramd.field_retCode;
      }
      locale.mxU = paramd;
      this.ozE.notify(locale);
    }
    if (this.ozG != null) {}
    for (int j = this.ozG.a(paramString, null, paramd);; j = 0)
    {
      int i = j;
      if (j == 0)
      {
        i = j;
        if (this.ozH != null) {
          i = this.ozH.a(paramString, null, paramd);
        }
      }
      j = i;
      if (i == 0)
      {
        j = i;
        if (this.ozx != null) {
          j = this.ozx.a(paramString, null, paramd);
        }
      }
      if ((j == 0) && (this.ozy != null))
      {
        a(paramd);
        this.ozy.a(paramString, null, paramd);
      }
      AppMethodBeat.o(150367);
      return 0;
    }
  }
  
  public final int keep_onDownloadProgress(String paramString, com.tencent.mm.g.c paramc)
  {
    AppMethodBeat.i(150366);
    paramc.field_isUploadTask = false;
    if (!Util.isNullOrNil(paramString))
    {
      e locale = new e(e.a.ozP, paramString);
      locale.ozM = paramc;
      this.ozE.notify(locale);
    }
    if (this.ozG != null) {}
    for (int j = this.ozG.a(paramString, paramc, null);; j = 0)
    {
      int i = j;
      if (j == 0)
      {
        i = j;
        if (this.ozH != null) {
          i = this.ozH.a(paramString, paramc, null);
        }
      }
      j = i;
      if (i == 0)
      {
        j = i;
        if (this.ozx != null) {
          j = this.ozx.a(paramString, paramc, null);
        }
      }
      if ((j == 0) && (this.ozy != null)) {
        this.ozy.a(paramString, paramc, null);
      }
      AppMethodBeat.o(150366);
      return 0;
    }
  }
  
  public final int keep_onDownloadSuccessed(String paramString, com.tencent.mm.g.d paramd)
  {
    AppMethodBeat.i(150368);
    if (!Util.isNullOrNil(paramString))
    {
      e locale = new e(e.a.ozO, paramString);
      locale.mxU = paramd;
      this.ozE.notify(locale);
    }
    if (this.ozG != null) {}
    for (int j = this.ozG.a(paramString, null, paramd);; j = 0)
    {
      int i = j;
      if (j == 0)
      {
        i = j;
        if (this.ozH != null) {
          i = this.ozH.a(paramString, null, paramd);
        }
      }
      j = i;
      if (i == 0)
      {
        j = i;
        if (this.ozx != null) {
          j = this.ozx.a(paramString, null, paramd);
        }
      }
      if ((j == 0) && (this.ozy != null))
      {
        a(paramd);
        this.ozy.a(paramString, null, paramd);
      }
      AppMethodBeat.o(150368);
      return 0;
    }
  }
  
  public final void keep_onDownloadToEnd(String paramString, long paramLong1, long paramLong2)
  {
    int i = 0;
    AppMethodBeat.i(150373);
    Log.i("MicroMsg.CdnTransportEngine", "keep_onDownloadToEnd %s, %d, %d", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if (this.ozG != null) {
      i = this.ozG.t(paramString, (int)paramLong1, (int)paramLong2);
    }
    if ((i == 0) && (this.ozH != null)) {
      this.ozH.u(paramString, (int)paramLong1, (int)paramLong2);
    }
    AppMethodBeat.o(150373);
  }
  
  public final void keep_onMoovReady(String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    AppMethodBeat.i(184253);
    Log.i("MicroMsg.CdnTransportEngine", "keep_onMoovReady %s, %d, %d, %s, hash[%d]", new Object[] { paramString1, Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString2, Integer.valueOf(hashCode()) });
    if (this.ozG != null) {}
    for (int i = this.ozG.d(paramString1, (int)paramLong1, (int)paramLong2, paramString2);; i = 0)
    {
      int j = i;
      if (i == 0)
      {
        j = i;
        if (this.ozH != null) {
          j = this.ozH.d(paramString1, (int)paramLong1, (int)paramLong2, paramString2);
        }
      }
      if (j == 0)
      {
        Log.e("MicroMsg.CdnTransportEngine", "cdn call on moov ready but onlineVideoCallback is null.hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
        com.tencent.mm.plugin.report.service.h.OAn.kJ(354, 29);
      }
      AppMethodBeat.o(184253);
      return;
    }
  }
  
  public final int keep_onUploadError(String paramString, com.tencent.mm.g.d paramd)
  {
    AppMethodBeat.i(150364);
    if (!Util.isNullOrNil(paramString))
    {
      e locale = new e(e.a.ozQ, paramString);
      if (paramd != null) {
        locale.ret = paramd.field_retCode;
      }
      locale.mxU = paramd;
      this.ozE.notify(locale);
    }
    if (this.ozy != null)
    {
      a(paramd);
      this.ozy.a(paramString, null, paramd);
    }
    AppMethodBeat.o(150364);
    return 0;
  }
  
  public final int keep_onUploadProgress(String paramString, com.tencent.mm.g.c paramc)
  {
    AppMethodBeat.i(150363);
    paramc.field_isUploadTask = true;
    if (!Util.isNullOrNil(paramString))
    {
      e locale = new e(e.a.ozS, paramString);
      locale.ozM = paramc;
      this.ozE.notify(locale);
    }
    if (this.ozy != null)
    {
      Log.v("MicroMsg.CdnTransportEngine", "klem keep_onUploadProgress mediaId:%s, totalLen%d, offset%d", new Object[] { paramString, Long.valueOf(paramc.field_toltalLength), Long.valueOf(paramc.field_finishedLength) });
      this.ozy.a(paramString, paramc, null);
    }
    AppMethodBeat.o(150363);
    return 0;
  }
  
  public final int keep_onUploadSuccessed(String paramString, com.tencent.mm.g.d paramd)
  {
    AppMethodBeat.i(150365);
    if (!Util.isNullOrNil(paramString))
    {
      e locale = new e(e.a.ozR, paramString);
      locale.mxU = paramd;
      this.ozE.notify(locale);
    }
    if (this.ozy != null)
    {
      Log.v("MicroMsg.CdnTransportEngine", "klem keep_onUploadSuccessed mediaId:%s", new Object[] { paramString });
      a(paramd);
      this.ozy.a(paramString, null, paramd);
    }
    AppMethodBeat.o(150365);
    return 0;
  }
  
  public final void onBadNetworkProbed()
  {
    AppMethodBeat.i(150380);
    Log.w("MicroMsg.CdnTransportEngine", "bad network probed by CDN, try analyze STN network.");
    StnLogic.startNetworkAnalysis();
    AppMethodBeat.o(150380);
  }
  
  public final void onC2CDownloadCompleted(String paramString, CdnLogic.C2CDownloadResult paramC2CDownloadResult)
  {
    AppMethodBeat.i(150386);
    Log.i("MicroMsg.CdnTransportEngine", "onC2CDownloadCompleted filekey %s error %d", new Object[] { paramString, Integer.valueOf(paramC2CDownloadResult.errorCode) });
    com.tencent.mm.g.d locald = a(paramC2CDownloadResult, null);
    Object localObject1;
    Object localObject2;
    label83:
    long l;
    if ((paramC2CDownloadResult.fromCronet) && (paramC2CDownloadResult.cronetTaskResult != null))
    {
      if (paramC2CDownloadResult.cronetTaskResult.useHttp2)
      {
        localObject1 = "true";
        if (!paramC2CDownloadResult.cronetTaskResult.useQuic) {
          break label536;
        }
        localObject2 = "true";
        Log.i("MicroMsg.CdnTransportEngine", "cronet this task is from cronet ,use http2 %s, use quic %s, status code %d ", new Object[] { localObject1, localObject2, Integer.valueOf(paramC2CDownloadResult.cronetTaskResult.statusCode) });
        Log.i("MicroMsg.CdnTransportEngine", "cronet webperformance ip:%s, protocol:%s", new Object[] { paramC2CDownloadResult.cronetTaskResult.performance.peerIP, paramC2CDownloadResult.cronetTaskResult.performance.protocol });
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
      if (a.lwn == paramC2CDownloadResult.fileType)
      {
        if (!paramC2CDownloadResult.fromCronet) {
          break label642;
        }
        Log.i("MicroMsg.CdnTransportEngine", "cronet task use cronet download time ".concat(String.valueOf(l)));
        com.tencent.mm.plugin.report.service.h.OAn.p(1173L, 97L, 1L);
        com.tencent.mm.plugin.report.service.h.OAn.p(1173L, 99L, l);
        if (paramC2CDownloadResult.cronetTaskResult != null)
        {
          if (!paramC2CDownloadResult.cronetTaskResult.useQuic) {
            break label544;
          }
          com.tencent.mm.plugin.report.service.h.OAn.p(1173L, 94L, 1L);
          com.tencent.mm.plugin.report.service.h.OAn.p(1173L, 95L, l);
          Log.i("MicroMsg.CdnTransportEngine", "cronet task use cronet quic download time ".concat(String.valueOf(l)));
        }
      }
    }
    label642:
    for (;;)
    {
      if (locald.field_retCode == 0) {
        break label686;
      }
      localObject1 = new al();
      localObject2 = ((al)localObject1).kz(paramString);
      ((al)localObject2).ioI = 1;
      ((al)localObject2).ioJ = paramC2CDownloadResult.detailErrorType;
      ((al)localObject2).ioK = paramC2CDownloadResult.detailErrorCode;
      ((al)localObject2).ioL = paramC2CDownloadResult.errorCode;
      ((al)localObject2).ioN = paramC2CDownloadResult.fileType;
      ((al)localObject2).ioO = paramC2CDownloadResult.tryWritenBytes;
      ((al)localObject2).ioP = paramC2CDownloadResult.availableBytes;
      ((al)localObject2).kA(paramC2CDownloadResult.systemErrorDescribe).ioR = paramC2CDownloadResult.currentFileSize;
      ((al)localObject1).bMH();
      Log.i("MicroMsg.CdnTransportEngine", "reportstr %s", new Object[] { ((al)localObject1).aIF() });
      keep_onDownloadError(paramString, locald);
      AppMethodBeat.o(150386);
      return;
      localObject1 = "false";
      break;
      label536:
      localObject2 = "false";
      break label83;
      label544:
      if (paramC2CDownloadResult.cronetTaskResult.useHttp2)
      {
        com.tencent.mm.plugin.report.service.h.OAn.p(1173L, 91L, 1L);
        com.tencent.mm.plugin.report.service.h.OAn.p(1173L, 92L, l);
        Log.i("MicroMsg.CdnTransportEngine", "cronet task use cronet http2 download time ".concat(String.valueOf(l)));
      }
      else
      {
        com.tencent.mm.plugin.report.service.h.OAn.p(1173L, 88L, 1L);
        com.tencent.mm.plugin.report.service.h.OAn.p(1173L, 89L, l);
        Log.i("MicroMsg.CdnTransportEngine", "cronet task use cronet http1.x download time ".concat(String.valueOf(l)));
        continue;
        Log.i("MicroMsg.CdnTransportEngine", "cronet task use normal download time ".concat(String.valueOf(l)));
        com.tencent.mm.plugin.report.service.h.OAn.p(1173L, 100L, 1L);
        com.tencent.mm.plugin.report.service.h.OAn.p(1173L, 98L, l);
      }
    }
    label686:
    keep_onDownloadSuccessed(paramString, locald);
    AppMethodBeat.o(150386);
  }
  
  public final void onC2CUploadCompleted(String paramString, CdnLogic.C2CUploadResult paramC2CUploadResult)
  {
    AppMethodBeat.i(150382);
    Log.i("MicroMsg.CdnTransportEngine", "onC2CUploadCompleted filekey %s error %d", new Object[] { paramString, Integer.valueOf(paramC2CUploadResult.errorCode) });
    com.tencent.mm.g.d locald = new com.tencent.mm.g.d();
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
      locald.field_clientHostIP = Nx(paramC2CUploadResult.clientIP);
      locald.field_serverHostIP = Nx(paramC2CUploadResult.serverIP);
      locald.transportProtocol = paramC2CUploadResult.transportProtocol;
      locald.transportProtocolError = paramC2CUploadResult.transportProtocolError;
      locald.field_detailErrorType = paramC2CUploadResult.detailErrorType;
      locald.field_detailErrorCode = paramC2CUploadResult.detailErrorCode;
      if (locald.field_retCode == 0) {
        break;
      }
      al localal1 = new al();
      al localal2 = localal1.kz(paramString);
      localal2.ioI = 0;
      localal2.ioJ = paramC2CUploadResult.detailErrorType;
      localal2.ioK = paramC2CUploadResult.detailErrorCode;
      localal2.ioL = paramC2CUploadResult.errorCode;
      localal2.ioN = paramC2CUploadResult.filetype;
      localal2.ioO = 0L;
      localal2.ioP = 0L;
      localal2.kA(paramC2CUploadResult.systemErrorDescribe);
      localal1.bMH();
      Log.i("MicroMsg.CdnTransportEngine", "reportstr %s", new Object[] { localal1.aIF() });
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
    com.tencent.mm.g.c localc = new com.tencent.mm.g.c();
    localc.field_finishedLength = paramLong1;
    localc.field_toltalLength = paramLong2;
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
  
  public final void onM3U8Ready(String paramString1, String paramString2)
  {
    AppMethodBeat.i(238234);
    Log.i("MicroMsg.CdnTransportEngine", "onM3U8Ready %s, %d, hash[%d]", new Object[] { paramString1, Integer.valueOf(paramString2.length()), Integer.valueOf(hashCode()) });
    if (this.ozG != null) {}
    for (int i = this.ozG.bHL();; i = 0)
    {
      int j = i;
      if (i == 0)
      {
        j = i;
        if (this.ozH != null) {
          j = this.ozH.bHL();
        }
      }
      if (j == 0)
      {
        Log.e("MicroMsg.CdnTransportEngine", "cdn call on m3u8 ready but onlineVideoCallback is null.hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
        com.tencent.mm.plugin.report.service.h.OAn.kJ(354, 29);
      }
      AppMethodBeat.o(238234);
      return;
    }
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
    if (this.ozx != null) {
      i = this.ozx.a(paramString, paramC2CDownloadResult);
    }
    if ((i == 0) && (this.ozy != null)) {
      this.ozy.a(paramString, paramC2CDownloadResult);
    }
    AppMethodBeat.o(150390);
  }
  
  public final void onUploadProgressChanged(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(150381);
    com.tencent.mm.g.c localc = new com.tencent.mm.g.c();
    localc.field_finishedLength = paramLong1;
    localc.field_toltalLength = paramLong2;
    localc.field_status = 0;
    localc.field_mtlnotify = false;
    keep_onUploadProgress(paramString, localc);
    AppMethodBeat.o(150381);
  }
  
  public final void reportFlow(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(150378);
    if (!MMApplicationContext.isMMProcess())
    {
      AppMethodBeat.o(150378);
      return;
    }
    Log.i("MicroMsg.CdnTransportEngine", "ReportFlow, wifi:s:%d, r:%d, mobile:s:%d, r:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt4), Integer.valueOf(paramInt3) });
    keep_cdnSendAndRecvData("dummy clientmsgid", paramInt2 + paramInt4, paramInt1 + paramInt3);
    AppMethodBeat.o(150378);
  }
  
  public final void requestGetCDN(int paramInt)
  {
    AppMethodBeat.i(150377);
    if (!MMApplicationContext.isMMProcess())
    {
      AppMethodBeat.o(150377);
      return;
    }
    Log.i("MicroMsg.CdnTransportEngine", "requestgetcdn scene %d", new Object[] { Integer.valueOf(paramInt) });
    keep_OnRequestDoGetCdnDnsInfo(paramInt);
    AppMethodBeat.o(150377);
  }
  
  public final String[] resolveHost(String paramString, boolean paramBoolean, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(150379);
    if (!MMApplicationContext.isMMProcess())
    {
      AppMethodBeat.o(150379);
      return null;
    }
    Log.i("MicroMsg.CdnTransportEngine", "try resolve host %s, isdc %b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    ArrayList localArrayList = new ArrayList();
    paramArrayOfInt[0] = com.tencent.mm.network.d.a(paramString, paramBoolean, localArrayList);
    paramString = (String[])localArrayList.toArray(new String[0]);
    Log.i("MicroMsg.CdnTransportEngine", "resolved dnstype %d iplist %s", new Object[] { Integer.valueOf(paramArrayOfInt[0]), Arrays.toString(paramString) });
    AppMethodBeat.o(150379);
    return paramString;
  }
  
  public static abstract interface a
  {
    public abstract int a(String paramString, com.tencent.mm.g.c paramc, com.tencent.mm.g.d paramd);
    
    public abstract int bHL();
    
    public abstract int d(String paramString1, int paramInt1, int paramInt2, String paramString2);
    
    public abstract int t(String paramString, int paramInt1, int paramInt2);
    
    public abstract int u(String paramString, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelcdntran.d
 * JD-Core Version:    0.7.0.1
 */