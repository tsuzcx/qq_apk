package com.tencent.mm.modelcdntran;

import android.os.Looper;
import android.os.SystemClock;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.mars.cdn.CdnLogic.DownloadCallback;
import com.tencent.mars.cdn.CdnLogic.VideoStreamingCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.oi;
import com.tencent.mm.autogen.a.ra;
import com.tencent.mm.autogen.a.ra.a;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.autogen.mmdata.rpt.le;
import com.tencent.mm.autogen.mmdata.rpt.ny;
import com.tencent.mm.autogen.mmdata.rpt.oq;
import com.tencent.mm.autogen.mmdata.rpt.ru;
import com.tencent.mm.g.g.a;
import com.tencent.mm.g.h.a;
import com.tencent.mm.model.br.b;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.modelvideo.aa;
import com.tencent.mm.modelvideo.ab;
import com.tencent.mm.modelvideo.ag.a;
import com.tencent.mm.plugin.aw.a.a;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.sight.base.ABAPrams;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat.Companion;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cb;
import com.tencent.mm.storage.cc;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public final class j
  implements com.tencent.mm.am.h, d.a
{
  private MMHandler mRi;
  private final MMHandler mainHandler;
  private Queue<String> oAp;
  private Map<String, com.tencent.mm.g.h> oAq;
  public Map<String, com.tencent.mm.g.h> oAr;
  private Map<String, com.tencent.mm.g.h> oBd;
  private Map<String, com.tencent.mm.g.d> oBe;
  
  public j()
  {
    AppMethodBeat.i(126721);
    this.oAp = new LinkedList();
    this.oAq = new HashMap();
    this.oAr = new HashMap();
    this.oBd = new HashMap();
    this.oBe = new HashMap();
    this.mainHandler = new MMHandler(Looper.getMainLooper());
    this.mRi = new MMHandler(Looper.getMainLooper());
    com.tencent.mm.kernel.h.aZW().a(379, this);
    AppMethodBeat.o(126721);
  }
  
  public static com.tencent.mm.g.h NA(String paramString)
  {
    AppMethodBeat.i(126737);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(126737);
      return null;
    }
    com.tencent.mm.modelvideo.z localz = ab.Qo(paramString);
    if (localz == null)
    {
      AppMethodBeat.o(126737);
      return null;
    }
    Object localObject1 = XmlParser.parseXml(localz.bOu(), "msg", null);
    if (localObject1 == null)
    {
      Log.w("MicroMsg.OnlineVideoService", "cdntra parse video recv xml failed");
      AppMethodBeat.o(126737);
      return null;
    }
    Object localObject2 = (String)((Map)localObject1).get(".msg.videomsg.$cdnvideourl");
    if (Util.isNullOrNil((String)localObject2))
    {
      Log.w("MicroMsg.OnlineVideoService", "cdntra parse video recv xml failed");
      AppMethodBeat.o(126737);
      return null;
    }
    int j = Util.getInt((String)((Map)localObject1).get(".msg.videomsg.$length"), 0);
    String str1 = (String)((Map)localObject1).get(".msg.videomsg.$md5");
    String str2 = (String)((Map)localObject1).get(".msg.videomsg.$aeskey");
    String str3 = (String)((Map)localObject1).get(".msg.videomsg.$fileparam");
    String str4 = h.a("downvideo", localz.createTime, localz.bOs(), localz.getFileName());
    if (Util.isNullOrNil(str4))
    {
      Log.w("MicroMsg.OnlineVideoService", "cdntra genClientId failed not use cdn file:%s", new Object[] { localz.getFileName() });
      AppMethodBeat.o(126737);
      return null;
    }
    com.tencent.mm.modelvideo.v.bOh();
    String str5 = aa.PX(paramString);
    localObject1 = new com.tencent.mm.g.h();
    ((com.tencent.mm.g.h)localObject1).taskName = "task_OnlineVideoService_1";
    ((com.tencent.mm.g.h)localObject1).filename = paramString;
    ((com.tencent.mm.g.h)localObject1).lxg = str1;
    ((com.tencent.mm.g.h)localObject1).lxh = j;
    ((com.tencent.mm.g.h)localObject1).lxi = 1;
    ((com.tencent.mm.g.h)localObject1).hQQ = localz.bOq();
    ((com.tencent.mm.g.h)localObject1).lxj = localz.bOs();
    if (au.bwE(localz.bOs()))
    {
      i = com.tencent.mm.model.v.getMembersCountByChatRoomName(localz.bOs());
      ((com.tencent.mm.g.h)localObject1).hQS = i;
      ((com.tencent.mm.g.h)localObject1).field_mediaId = str4;
      ((com.tencent.mm.g.h)localObject1).field_fullpath = str5;
      ((com.tencent.mm.g.h)localObject1).field_fileType = com.tencent.mm.g.a.MediaType_VIDEO;
      ((com.tencent.mm.g.h)localObject1).field_totalLen = j;
      ((com.tencent.mm.g.h)localObject1).field_aesKey = str2;
      ((com.tencent.mm.g.h)localObject1).field_fileId = ((String)localObject2);
      ((com.tencent.mm.g.h)localObject1).field_priority = com.tencent.mm.g.a.lvZ;
      ((com.tencent.mm.g.h)localObject1).field_wxmsgparam = str3;
      if (!au.bwE(localz.bOs())) {
        break label529;
      }
      i = 1;
      label375:
      ((com.tencent.mm.g.h)localObject1).field_chattype = i;
      ((com.tencent.mm.g.h)localObject1).lxk = localz.lxk;
      paramString = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aU(localz.bOs(), localz.hTh);
      if (paramString != null)
      {
        localObject2 = com.tencent.mm.model.br.JP(paramString.jUr);
        ((com.tencent.mm.g.h)localObject1).lwM = 0;
        ((com.tencent.mm.g.h)localObject1).lwN = 0;
        ((com.tencent.mm.g.h)localObject1).lxm = paramString.getCreateTime();
        ((com.tencent.mm.g.h)localObject1).hTh = paramString.field_msgSvrId;
        if (localObject2 == null) {
          break label534;
        }
      }
    }
    label529:
    label534:
    for (int i = ((br.b)localObject2).omg;; i = 0)
    {
      ((com.tencent.mm.g.h)localObject1).lxn = i;
      if (((com.tencent.mm.g.h)localObject1).lwM > 0) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 36L, 1L, false);
      }
      ((com.tencent.mm.g.h)localObject1).field_autostart = false;
      ((com.tencent.mm.g.h)localObject1).field_requestVideoFormat = e.a(1, localz);
      AppMethodBeat.o(126737);
      return localObject1;
      i = 0;
      break;
      i = 0;
      break label375;
    }
  }
  
  public static com.tencent.mm.g.h a(com.tencent.mm.storage.br parambr, String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(237898);
    if (parambr == null)
    {
      Log.w("MicroMsg.OnlineVideoService", "check can sns online video, scene is null.");
      AppMethodBeat.o(237898);
      return null;
    }
    if (Util.isNullOrNil(paramString1))
    {
      Log.w("MicroMsg.OnlineVideoService", "check can sns online video, url is null.");
      AppMethodBeat.o(237898);
      return null;
    }
    Object localObject = ab.Qo(paramString3);
    if (localObject == null)
    {
      Log.w("MicroMsg.OnlineVideoService", "check can sns online video, video info is null. %s", new Object[] { paramString3 });
      AppMethodBeat.o(237898);
      return null;
    }
    String str1 = h.a("snsvideo", parambr.time, "sns", paramString1);
    if (Util.isNullOrNil(str1))
    {
      Log.w("MicroMsg.OnlineVideoService", "check can http online video, can not create media id. url %s ", new Object[] { paramString1 });
      AppMethodBeat.o(237898);
      return null;
    }
    com.tencent.mm.g.h localh = new com.tencent.mm.g.h();
    localh.taskName = "task_OnlineVideoService_2";
    localh.filename = paramString3;
    localh.field_fullpath = paramString2;
    localh.field_mediaId = str1;
    localh.lxc = 2;
    localh.lxi = paramInt;
    localh.lxk = ((com.tencent.mm.modelvideo.z)localObject).lxk;
    if (parambr == null) {
      paramString3 = "";
    }
    for (;;)
    {
      str1 = "https://" + WeChatHosts.domainString(a.a.host_weixin_qq_com) + "/?version=%d&uin=%s&nettype=%d&signal=%d%s";
      int i = com.tencent.mm.protocal.d.Yxh;
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baC();
      String str2 = com.tencent.mm.b.p.getString(com.tencent.mm.kernel.b.getUin());
      int j = NetStatusUtil.getNetTypeForStat(MMApplicationContext.getContext());
      int k = ConnectivityCompat.Companion.getCompatMixStrength();
      label286:
      boolean bool;
      if (!Util.isNullOrNil(paramString3))
      {
        localObject = "&scene=".concat(String.valueOf(paramString3));
        localh.referer = String.format(str1, new Object[] { Integer.valueOf(i), str2, Integer.valueOf(j), Integer.valueOf(k), localObject });
        localh.url = paramString1;
        localObject = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getValue("SnsSightDomainList");
        long l2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getInt("SnsSightMainStandbyIpSwitchTime", 0);
        Log.i("MicroMsg.OnlineVideoService", "hostvalue %s dcipTime %s scene.time[%d]", new Object[] { localObject, Long.valueOf(l2), Integer.valueOf(parambr.time) });
        long l1 = l2;
        if (l2 <= 0L) {
          l1 = 259200L;
        }
        if (Util.secondsToNow(parambr.time) <= l1) {
          break label705;
        }
        bool = true;
        label454:
        localh.isColdSnsData = bool;
        localh.signalQuality = ConnectivityCompat.Companion.getCompatMixStrength();
        localh.snsScene = paramString3;
        localh.concurrentCount = 5;
        if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yGH, true)) {
          if (!paramBoolean) {
            break label711;
          }
        }
      }
      label705:
      label711:
      for (localh.field_requestVideoFormat = e.m(paramInt, paramString2, paramString1);; localh.field_requestVideoFormat = e.R(paramInt, paramString2))
      {
        AppMethodBeat.o(237898);
        return localh;
        if (parambr.equals(com.tencent.mm.storage.br.adjW))
        {
          paramString3 = "album_friend";
          break;
        }
        if (parambr.equals(com.tencent.mm.storage.br.adjX))
        {
          paramString3 = "album_self";
          break;
        }
        if (parambr.equals(com.tencent.mm.storage.br.adjY))
        {
          paramString3 = "album_stranger";
          break;
        }
        if (parambr.equals(com.tencent.mm.storage.br.adjZ))
        {
          paramString3 = "profile_friend";
          break;
        }
        if (parambr.equals(com.tencent.mm.storage.br.adka))
        {
          paramString3 = "profile_stranger";
          break;
        }
        if (parambr.equals(com.tencent.mm.storage.br.adkb))
        {
          paramString3 = "comment";
          break;
        }
        if (parambr.equals(com.tencent.mm.storage.br.adjV))
        {
          paramString3 = "timeline";
          break;
        }
        if (parambr.equals(com.tencent.mm.storage.br.adke))
        {
          paramString3 = "snssight";
          break;
        }
        if (!parambr.equals(com.tencent.mm.storage.br.adkg)) {
          break label725;
        }
        paramString3 = "storysight";
        break;
        localObject = "";
        break label286;
        bool = false;
        break label454;
      }
      label725:
      paramString3 = "";
    }
  }
  
  private static void a(com.tencent.mm.modelvideo.z paramz, int paramInt, String paramString)
  {
    AppMethodBeat.i(126735);
    Log.i("MicroMsg.OnlineVideoService", "download finish. totalLen %d ", new Object[] { Integer.valueOf(paramInt) });
    if (paramz != null)
    {
      ab.be(paramz.getFileName(), paramInt);
      l(paramInt, paramString, paramz.getFileName());
    }
    AppMethodBeat.o(126735);
  }
  
  public static void a(ABAPrams paramABAPrams)
  {
    AppMethodBeat.i(237903);
    if (paramABAPrams == null)
    {
      AppMethodBeat.o(237903);
      return;
    }
    com.tencent.mm.plugin.report.service.h.OAn.b(17891, new Object[] { Integer.valueOf(paramABAPrams.sceneCase), Integer.valueOf(paramABAPrams.inputWidth), Integer.valueOf(paramABAPrams.inputHeight), Integer.valueOf(paramABAPrams.inputKbps), Integer.valueOf(paramABAPrams.inputFps), Integer.valueOf(paramABAPrams.averageQP), Integer.valueOf(paramABAPrams.averageMV), Integer.valueOf(paramABAPrams.skipMode), Integer.valueOf(paramABAPrams.intraMode), Integer.valueOf(paramABAPrams.interMode), Integer.valueOf(paramABAPrams.outputKbps), Integer.valueOf(paramABAPrams.outputWidth), Integer.valueOf(paramABAPrams.outputHeight), Integer.valueOf(paramABAPrams.bitrateAdaptiveUP), Integer.valueOf(paramABAPrams.bitrateAdaptiveDown), Integer.valueOf(paramABAPrams.resolutionAdjust), Integer.valueOf(paramABAPrams.SkipReadQP), Integer.valueOf(paramABAPrams.consumingtime), Integer.valueOf(paramABAPrams.codecID), Integer.valueOf(paramABAPrams.transcosingKbps), Integer.valueOf(paramABAPrams.isEnableHEVC), Integer.valueOf(paramABAPrams.enableABA), Integer.valueOf(paramABAPrams.use1080pC2CSNS), Integer.valueOf(paramABAPrams.startTime), Integer.valueOf(paramABAPrams.duration), Integer.valueOf(paramABAPrams.ratiosBitrateQP), Integer.valueOf(paramABAPrams.textureComplexity), Integer.valueOf(paramABAPrams.qualityLevel), Integer.valueOf(paramABAPrams.platform), Integer.valueOf(paramABAPrams.oriAudioBitrate), Integer.valueOf(paramABAPrams.oriAudioChannel), Integer.valueOf(paramABAPrams.compAudioBitrate), Integer.valueOf(paramABAPrams.compAudioChannel), Integer.valueOf(paramABAPrams.addStickers), Integer.valueOf(paramABAPrams.enableSWHEVCTrans), Integer.valueOf(paramABAPrams.skipVideoCompress) });
    AppMethodBeat.o(237903);
  }
  
  private static void a(PInt paramPInt1, PInt paramPInt2, String paramString, int paramInt)
  {
    AppMethodBeat.i(126743);
    int j = 0;
    paramString = ab.Qo(paramString);
    if (paramString != null) {
      j = paramString.hQV;
    }
    for (int k = paramString.osy;; k = 0)
    {
      if (paramInt <= 0)
      {
        i = 1;
        paramPInt1.value = j;
        paramPInt2.value = i;
        Log.d("MicroMsg.OnlineVideoService", "getPreloadVideoInfo pHadPreloadSize[%d] pHadPreloadCompletion[%d]", new Object[] { Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value) });
        AppMethodBeat.o(126743);
        return;
      }
      int m = (int)(paramInt / 100.0F * k);
      if (j < m) {}
      for (int i = 2;; i = 3)
      {
        Log.d("MicroMsg.OnlineVideoService", "getPreloadVideoInfo %d * %d = configSize[%d] preloadSize[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j) });
        break;
      }
    }
  }
  
  private static void a(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, long paramLong1, long paramLong2, String paramString4, String[] paramArrayOfString, String paramString5, int paramInt3, int paramInt4, String paramString6)
  {
    AppMethodBeat.i(126744);
    oi localoi = new oi();
    localoi.hQP.hQQ = paramString1;
    localoi.hQP.hQR = paramString2;
    localoi.hQP.hQS = paramInt1;
    localoi.hQP.fileId = paramString3;
    localoi.hQP.netType = paramInt2;
    localoi.hQP.startTime = paramLong1;
    localoi.hQP.endTime = paramLong2;
    localoi.hQP.path = paramString4;
    localoi.hQP.hQT = paramArrayOfString;
    localoi.hQP.hQU = paramString5;
    localoi.hQP.hQV = paramInt3;
    localoi.hQP.hQW = paramInt4;
    localoi.hQP.hQX = paramString6;
    localoi.publish();
    AppMethodBeat.o(126744);
  }
  
  public static void a(Object[] paramArrayOfObject, com.tencent.mm.g.d paramd, com.tencent.mm.g.h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(126742);
    if ((paramh == null) || (paramd == null))
    {
      Log.w("MicroMsg.OnlineVideoService", "video task info is null or download result is null.");
      AppMethodBeat.o(126742);
      return;
    }
    if ((!paramh.aLJ()) && (!paramh.aLL()) && (!paramh.aLO()))
    {
      AppMethodBeat.o(126742);
      return;
    }
    String str2 = paramd.field_clientIP;
    int i4;
    if (paramd.field_isCrossNet)
    {
      i4 = 1;
      Log.i("MicroMsg.OnlineVideoService", "rpt online video format[%d] clientIp[%s] isCrossNet[%d]", new Object[] { Integer.valueOf(paramd.field_videoFormat), str2, Integer.valueOf(i4) });
      if (paramd.field_videoFormat == 2) {
        ab.Qr(paramh.filename);
      }
      if (!Util.isNullOrNil(str2)) {
        break label236;
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 45L, 1L, false);
      label146:
      if (!paramd.field_isCrossNet) {
        break label253;
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 47L, 1L, false);
    }
    boolean bool1;
    boolean bool2;
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      bool1 = paramh.aLL();
      bool2 = paramh.aLO();
      localObject1 = new PInt();
      localObject2 = new PInt();
      ((PInt)localObject2).value = 0;
      ((PInt)localObject1).value = 0;
      if (ab.a(paramh.field_fullpath, (PInt)localObject1, (PInt)localObject2)) {
        break label270;
      }
      AppMethodBeat.o(126742);
      return;
      i4 = 0;
      break;
      label236:
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 46L, 1L, false);
      break label146;
      label253:
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 48L, 1L, false);
    }
    label270:
    int i15 = ((PInt)localObject1).value * 1000;
    int i16 = ((PInt)localObject2).value;
    int i6 = 0;
    int i5 = 0;
    int i2;
    int j;
    int i3;
    int m;
    int i;
    int n;
    int i1;
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 6))
    {
      i2 = ((Integer)paramArrayOfObject[0]).intValue() * 1000;
      j = ((Integer)paramArrayOfObject[1]).intValue();
      i3 = ((Integer)paramArrayOfObject[2]).intValue();
      m = ((Integer)paramArrayOfObject[3]).intValue();
      i = ((Integer)paramArrayOfObject[4]).intValue();
      n = ((Integer)paramArrayOfObject[5]).intValue();
      i1 = ((Integer)paramArrayOfObject[6]).intValue();
      if ((!bool2) && (!bool1) && (paramArrayOfObject.length > 10))
      {
        i6 = ((Integer)paramArrayOfObject[7]).intValue();
        localObject1 = (String)paramArrayOfObject[8];
        i5 = ((Long)paramArrayOfObject[9]).intValue();
      }
    }
    for (;;)
    {
      int i7 = paramh.lxk;
      int k = i7;
      int i17;
      String str1;
      PInt localPInt2;
      StringBuffer localStringBuffer;
      if (i7 <= 0)
      {
        if (bool1) {
          k = 10;
        }
      }
      else
      {
        i17 = NetStatusUtil.getIOSNetType(MMApplicationContext.getContext());
        str1 = paramd.aLH();
        PInt localPInt1 = new PInt();
        localPInt2 = new PInt();
        a(localPInt1, localPInt2, paramh.filename, paramh.lxn);
        localStringBuffer = new StringBuffer();
        if (!bool1) {
          break label1580;
        }
        localStringBuffer.append(paramh.field_fileId).append(",").append(paramh.field_aesKey).append(",");
        label551:
        localStringBuffer.append(paramd.field_fileLength).append(",").append(i15).append(",");
        localStringBuffer.append(paramd.field_recvedBytes).append(",");
        localStringBuffer.append(i2 + ",").append(j + ",").append(i3 + ",");
        localStringBuffer.append(m + ",").append(i + ",");
        localStringBuffer.append(i17).append(",");
        localStringBuffer.append(k).append(",");
        localStringBuffer.append(paramd.field_startTime).append(",");
        localStringBuffer.append(paramd.field_endTime).append(",");
        if (!bool1) {
          break label1627;
        }
        if (paramh.lxj == null) {
          break label1612;
        }
        localObject2 = com.tencent.mm.b.g.getMessageDigest(paramh.lxj.getBytes());
        label804:
        localStringBuffer.append(localObject2).append(",");
        if (!au.bwE(paramh.lxj)) {
          break label1621;
        }
        k = 1;
        label831:
        localStringBuffer.append(k).append(",");
        label845:
        localStringBuffer.append(paramd.field_retCode).append(",");
        localStringBuffer.append(paramd.field_enQueueTime).append(",");
        localStringBuffer.append(paramd.field_firstRequestCost).append(",");
        localStringBuffer.append(paramd.field_firstRequestSize).append(",");
        localStringBuffer.append(paramd.field_firstRequestDownloadSize).append(",");
        if (!paramd.field_firstRequestCompleted) {
          break label1659;
        }
        k = 1;
        label935:
        localStringBuffer.append(k).append(",");
        localStringBuffer.append(paramd.field_averageSpeed).append(",");
        localStringBuffer.append(paramd.field_averageConnectCost).append(",");
        localStringBuffer.append(paramd.field_firstConnectCost).append(",");
        localStringBuffer.append(paramd.field_netConnectTimes).append(",");
        localStringBuffer.append(paramd.field_moovRequestTimes).append(",");
        localStringBuffer.append(paramd.field_moovCost).append(",");
        localStringBuffer.append(paramd.field_moovSize).append(",");
        if (!paramd.field_moovCompleted) {
          break label1665;
        }
        k = 1;
        label1071:
        localStringBuffer.append(k).append(",");
        localStringBuffer.append(paramd.field_moovFailReason).append(",");
        localStringBuffer.append(n).append(",");
        localStringBuffer.append(i1).append(",");
        if (!bool1) {
          break label1671;
        }
        localStringBuffer.append(i16).append(",");
        localStringBuffer.append(str1).append(",");
        if (!bool1) {
          break label1730;
        }
        localStringBuffer.append(paramh.lxm).append(",");
        localStringBuffer.append(paramh.hTh).append(",");
        localStringBuffer.append(paramh.lwM).append(",");
        localStringBuffer.append(paramd.field_videoFormat).append(",");
        label1231:
        localStringBuffer.append(str2).append(",");
        localStringBuffer.append(i4).append(",");
        localStringBuffer.append(paramh.lxo).append(",");
        localStringBuffer.append(localPInt1.value).append(",");
        localStringBuffer.append(localPInt2.value).append(",");
        localStringBuffer.append(paramd.transportProtocol).append(",");
        localStringBuffer.append(paramd.transportProtocolError);
        if (!bool1) {
          break label1752;
        }
        k = 13570;
        label1345:
        if (bool2) {
          k = 13570;
        }
        localObject2 = localStringBuffer.toString();
        Log.i("MicroMsg.OnlineVideoService", "report online video %d:%s", new Object[] { Integer.valueOf(k), localObject2 });
        if (!bool1) {
          break label1760;
        }
        new le((String)localObject2).bMH();
        if (paramBoolean) {
          a(paramh.hQQ, paramh.lxj, paramh.hQS, paramd.field_fileId, i17, paramd.field_startTime, paramd.field_endTime, paramh.field_fullpath, paramd.field_usedSvrIps, paramh.url, localPInt1.value, localPInt2.value, paramh.hQX);
        }
        if (bool1)
        {
          if (paramd.field_videoFormat != 2) {
            break label3076;
          }
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 132L, 1L, false);
        }
      }
      for (;;)
      {
        paramArrayOfObject = ab.Qo(paramh.filename);
        if (paramArrayOfObject != null)
        {
          paramArrayOfObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(paramArrayOfObject.pbc);
          if (paramArrayOfObject != null) {
            ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(new i.c(paramArrayOfObject.field_talker, "update", paramArrayOfObject));
          }
        }
        AppMethodBeat.o(126742);
        return;
        k = 31;
        break;
        label1580:
        localStringBuffer.append(paramh.url).append(",").append(paramh.lxl).append(",");
        break label551;
        label1612:
        localObject2 = Integer.valueOf(0);
        break label804;
        label1621:
        k = 0;
        break label831;
        label1627:
        localStringBuffer.append(0).append(",");
        localStringBuffer.append(paramd.field_httpStatusCode).append(",");
        break label845;
        label1659:
        k = 0;
        break label935;
        label1665:
        k = 0;
        break label1071;
        label1671:
        localStringBuffer.append(i16).append(",");
        if (paramh.lxj != null) {}
        for (localObject2 = com.tencent.mm.b.g.getMessageDigest(paramh.lxj.getBytes());; localObject2 = Integer.valueOf(0))
        {
          localStringBuffer.append(localObject2).append(",");
          break;
        }
        label1730:
        localStringBuffer.append(com.tencent.mm.plugin.video.c.beW(paramh.hQX)).append(",");
        break label1231;
        label1752:
        k = 13790;
        break label1345;
        label1760:
        long l2;
        long l1;
        if (bool2)
        {
          int i9 = 0;
          int i10 = 0;
          localObject2 = "";
          l2 = 0L;
          int i11 = 0;
          int i12 = 0;
          int i13 = 0;
          int i14 = 0;
          l1 = l2;
          localObject1 = localObject2;
          int i8 = i10;
          i7 = i14;
          i6 = i13;
          i5 = i12;
          i4 = i11;
          k = i9;
          if (paramArrayOfObject != null)
          {
            l1 = l2;
            localObject1 = localObject2;
            i8 = i10;
            i7 = i14;
            i6 = i13;
            i5 = i12;
            i4 = i11;
            k = i9;
            if (paramArrayOfObject.length >= 11)
            {
              k = Util.getInt(paramArrayOfObject[7].toString(), 0);
              Util.getInt(paramArrayOfObject[8].toString(), 0);
              i8 = Util.getInt(paramArrayOfObject[9].toString(), 0);
              localObject1 = paramArrayOfObject[11].toString();
              i4 = Util.getInt(paramArrayOfObject[12].toString(), 0);
              l1 = Util.getLong(paramArrayOfObject[13].toString(), 0L);
              i5 = Util.getInt(paramArrayOfObject[14].toString(), 0);
              i6 = Util.getInt(paramArrayOfObject[15].toString(), 0);
              i7 = Util.getInt(paramArrayOfObject[16].toString(), 0);
            }
          }
          paramArrayOfObject = new ru();
          localObject1 = paramArrayOfObject.ys((String)localObject1);
          ((ru)localObject1).jwd = i4;
          ((ru)localObject1).jwe = i6;
          ((ru)localObject1).jwf = i5;
          ((ru)localObject1).irv = i15;
          ((ru)localObject1).jwg = (i2 / 1000);
          ((ru)localObject1).iYV = j;
          ((ru)localObject1).iYW = i3;
          ((ru)localObject1).iRU = m;
          ((ru)localObject1).iRV = i;
          ((ru)localObject1).jwh = 0L;
          ((ru)localObject1).iZq = n;
          ((ru)localObject1).jwi = i1;
          localObject1 = ((ru)localObject1).yt("");
          ((ru)localObject1).irw = (i16 * 1000);
          localObject1 = ((ru)localObject1).yu(paramh.field_requestVideoFormat);
          ((ru)localObject1).iIE = paramd.field_fileLength;
          ((ru)localObject1).jwl = paramd.field_recvedBytes;
          ((ru)localObject1).iYZ = paramd.field_startTime;
          ((ru)localObject1).iZa = paramd.field_endTime;
          ((ru)localObject1).jwm = paramd.field_retCode;
          ((ru)localObject1).jwn = paramd.field_enQueueTime;
          ((ru)localObject1).jwo = paramd.field_moovRequestTimes;
          ((ru)localObject1).jwp = paramd.field_moovCost;
          ((ru)localObject1).iZn = paramd.field_moovSize;
          if (paramd.field_moovCompleted)
          {
            l2 = 1L;
            label2233:
            ((ru)localObject1).jwq = l2;
            ((ru)localObject1).jwr = paramd.field_moovFailReason;
            ((ru)localObject1).jws = paramd.field_firstConnectCost;
            ((ru)localObject1).jwt = paramd.field_firstRequestCost;
            ((ru)localObject1).jwu = paramd.field_firstRequestSize;
            ((ru)localObject1).jwv = paramd.field_firstRequestDownloadSize;
            if (!paramd.field_firstRequestCompleted) {
              break label2718;
            }
            l2 = 1L;
            label2300:
            ((ru)localObject1).jww = l2;
            ((ru)localObject1).jwx = paramd.field_averageSpeed;
            ((ru)localObject1).jwy = paramd.field_averageConnectCost;
            ((ru)localObject1).iZk = paramd.field_netConnectTimes;
            localObject1 = ((ru)localObject1).yv(paramd.aLH()).yw(paramd.field_clientIP);
            if (!paramd.field_isCrossNet) {
              break label2724;
            }
            l2 = 1L;
            label2365:
            ((ru)localObject1).jwA = l2;
            ((ru)localObject1).iZy = paramh.lxo;
            ((ru)localObject1).jwB = i8;
            ((ru)localObject1).itb = i17;
            ((ru)localObject1).jwC = l1;
            ((ru)localObject1).irD = k;
            ((ru)localObject1).jwD = i7;
            ((ru)localObject1).iZz = paramd.transportProtocol;
            ((ru)localObject1).iZA = paramd.transportProtocolError;
            ((ru)localObject1).iZB = paramd.traceId;
            localObject1 = ((ru)localObject1).yx("").yy(paramd.field_videoFlag).yz(paramd.field_videoCdnMsg);
            if (paramd.svrFallbackCount <= 0) {
              break label2730;
            }
          }
          label2718:
          label2724:
          label2730:
          for (i = 1;; i = 0)
          {
            ((ru)localObject1).iZD = i;
            Log.d("MicroMsg.OnlineVideoService", "time distance %d", new Object[] { Long.valueOf(System.currentTimeMillis() - paramArrayOfObject.jwC) });
            if (System.currentTimeMillis() - paramArrayOfObject.jwC > 500L) {
              paramArrayOfObject.bMH();
            }
            if (!bool2) {
              break;
            }
            paramArrayOfObject = new oq();
            localObject1 = com.tencent.mm.plugin.sight.base.f.aVX(paramh.field_fullpath);
            if (localObject1 != null)
            {
              paramArrayOfObject.irv = ((com.tencent.mm.plugin.sight.base.b)localObject1).videoDuration;
              paramArrayOfObject.irw = ((com.tencent.mm.plugin.sight.base.b)localObject1).videoBitrate;
              paramArrayOfObject.irx = ((com.tencent.mm.plugin.sight.base.b)localObject1).audioBitrate;
              paramArrayOfObject.iry = ((com.tencent.mm.plugin.sight.base.b)localObject1).frameRate;
              paramArrayOfObject.irz = ((com.tencent.mm.plugin.sight.base.b)localObject1).width;
              paramArrayOfObject.irA = ((com.tencent.mm.plugin.sight.base.b)localObject1).height;
              paramArrayOfObject.irC = ((com.tencent.mm.plugin.sight.base.b)localObject1).audioChannel;
            }
            paramArrayOfObject.iru = paramd.field_fileLength;
            paramArrayOfObject = paramArrayOfObject.wt(paramh.url);
            k.bHX();
            paramArrayOfObject = paramArrayOfObject.wu(d.Nu(paramh.field_fullpath));
            paramArrayOfObject.irs = paramd.field_startTime;
            paramArrayOfObject.irt = paramd.field_endTime;
            paramArrayOfObject = paramArrayOfObject.wv(str1);
            paramArrayOfObject.irD = k;
            paramArrayOfObject.irE = localPInt2.value;
            paramArrayOfObject.bMH();
            break;
            l2 = 0L;
            break label2233;
            l2 = 0L;
            break label2300;
            l2 = 0L;
            break label2365;
          }
        }
        localObject2 = new ny((String)localObject2);
        ((ny)localObject2).jgQ = i5;
        ((ny)localObject2).vX((String)localObject1);
        ((ny)localObject2).jgO = i6;
        ((ny)localObject2).iZB = paramd.traceId;
        ((ny)localObject2).vY(paramd.field_videoFlag);
        ((ny)localObject2).vZ(paramd.field_videoCdnMsg);
        if (paramd.svrFallbackCount > 0) {}
        for (i = 1;; i = 0)
        {
          ((ny)localObject2).iZD = i;
          Log.d("13790", "report 13790 value: " + ((ny)localObject2).aIE());
          Log.d("13790", "trace id  " + (paramd.traceId & 0xFFFFFFFF) + " videoflag " + ((ny)localObject2).iZC + " " + ((ny)localObject2).iMV + " " + ((ny)localObject2).iZD);
          if ((paramArrayOfObject != null) && (paramArrayOfObject.length >= 20))
          {
            l1 = Util.getLong(paramArrayOfObject[14].toString(), 0L);
            l2 = Util.getLong(paramArrayOfObject[15].toString(), 0L);
            ((ny)localObject2).jgR = l1;
            ((ny)localObject2).jgS = l2;
            ((ny)localObject2).jgT = Util.getLong(paramArrayOfObject[16].toString(), 0L);
            ((ny)localObject2).jgU = Util.getLong(paramArrayOfObject[17].toString(), 0L);
            ((ny)localObject2).jgX = Util.getInt(paramArrayOfObject[18].toString(), 0);
            ((ny)localObject2).jgY = Util.getLong(paramArrayOfObject[19].toString(), 0L);
            ((ny)localObject2).wa(l1 + "x" + l2);
          }
          ((ny)localObject2).bMH();
          break;
        }
        label3076:
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 133L, 1L, false);
      }
      localObject1 = "";
      continue;
      localObject1 = "";
      m = 0;
      i = 0;
      n = 0;
      i1 = 0;
      i2 = 0;
      j = 0;
      i3 = 0;
    }
  }
  
  private static boolean l(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(126736);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(126736);
      return false;
    }
    com.tencent.mm.modelvideo.v.bOh();
    paramString2 = aa.PX(paramString2);
    if ((Util.isNullOrNil(paramString1)) || (paramInt <= 0) || (Util.isNullOrNil(paramString2)))
    {
      Log.w("MicroMsg.OnlineVideoService", "insert media duplication but args is error.[%d, %s, %s]", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
      AppMethodBeat.o(126736);
      return false;
    }
    boolean bool = ((com.tencent.mm.plugin.r.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.r.a.a.class)).bzI().W(paramString1, paramInt, paramString2);
    AppMethodBeat.o(126736);
    return bool;
  }
  
  public static int v(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126729);
    k.bHX();
    int i = d.requestVideoData(paramString, paramInt1, paramInt2, 0);
    Log.i("MicroMsg.OnlineVideoService", "request video video[%s], offset[%d], length[%d] duration[%d] ret[%d]", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0), Integer.valueOf(i) });
    AppMethodBeat.o(126729);
    return i;
  }
  
  public final int a(final String paramString, final com.tencent.mm.g.c paramc, final com.tencent.mm.g.d paramd)
  {
    AppMethodBeat.i(126734);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.OnlineVideoService", "cdn callback mediaid is null.");
      AppMethodBeat.o(126734);
      return -1;
    }
    if ((paramc == null) && (paramd == null))
    {
      Log.e("MicroMsg.OnlineVideoService", "cdn callback info all null.");
      AppMethodBeat.o(126734);
      return -2;
    }
    com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(169094);
        Object localObject = (com.tencent.mm.g.h)j.d(j.this).get(paramString);
        if (localObject == null)
        {
          if (paramString.contains("AdLandingGeneralVideo_"))
          {
            com.tencent.mm.plugin.report.service.h.OAn.kJ(1579, 11);
            Log.e("MicroMsg.OnlineVideoService", "download adLandingGeneralVideo task callback but task is null, %s, %s", new Object[] { paramString, Integer.valueOf(j.this.hashCode()) });
          }
          AppMethodBeat.o(169094);
          return;
        }
        if (((com.tencent.mm.g.h)localObject).lxs != null)
        {
          Log.i("MicroMsg.OnlineVideoService", "cdn callback %s route to videoCallback", new Object[] { paramString });
          if (paramc != null)
          {
            ((com.tencent.mm.g.h)localObject).lxs.h(paramString, paramc.field_finishedLength, paramc.field_toltalLength);
            AppMethodBeat.o(169094);
            return;
          }
          if (paramd != null)
          {
            Log.i("MicroMsg.OnlineVideoService", "cdn callback %s route to videoCallback, sceneResult.retCode:%s", new Object[] { paramString, Integer.valueOf(paramd.field_retCode) });
            ((com.tencent.mm.g.h)localObject).lxs.a(paramString, paramd.field_retCode, paramd);
            j.d(j.this).remove(paramString);
            if (paramd.field_retCode == 0)
            {
              j.e(j.this).put(((com.tencent.mm.g.h)localObject).field_mediaId, localObject);
              j.f(j.this).put(((com.tencent.mm.g.h)localObject).field_mediaId, paramd);
            }
            AppMethodBeat.o(169094);
            return;
          }
          AppMethodBeat.o(169094);
          return;
        }
        com.tencent.mm.modelvideo.z localz = ab.Qo(((com.tencent.mm.g.h)localObject).filename);
        if (localz == null)
        {
          Log.w("MicroMsg.OnlineVideoService", "stream download video callback, but video info is null.[%s]", new Object[] { ((com.tencent.mm.g.h)localObject).filename });
          AppMethodBeat.o(169094);
          return;
        }
        if (((com.tencent.mm.g.h)localObject).lwL != null)
        {
          ((com.tencent.mm.g.h)localObject).lwL.a(paramString, 0, paramc, paramd, ((com.tencent.mm.g.h)localObject).field_onlycheckexist);
          if (paramd != null) {
            j.d(j.this).remove(paramString);
          }
          AppMethodBeat.o(169094);
          return;
        }
        if (paramc != null)
        {
          if (paramc.field_finishedLength == localz.osy)
          {
            Log.i("MicroMsg.OnlineVideoService", "stream download finish.");
            AppMethodBeat.o(169094);
            return;
          }
          if ((localz.status != 130) && (localz.paX > paramc.field_finishedLength))
          {
            Log.w("MicroMsg.OnlineVideoService", "set video error. db now size %d, cdn callback %d.", new Object[] { Integer.valueOf(localz.paX), Long.valueOf(paramc.field_finishedLength) });
            AppMethodBeat.o(169094);
            return;
          }
          Log.i("MicroMsg.OnlineVideoService", "callback progress info " + paramc.field_finishedLength);
          localz.pba = Util.nowSecond();
          localz.paX = ((int)paramc.field_finishedLength);
          localz.eQp = 1040;
          ab.f(localz);
          localObject = new ra();
          ((ra)localObject).hTZ.hId = 5;
          ((ra)localObject).hTZ.mediaId = paramString;
          ((ra)localObject).hTZ.offset = ((int)paramc.field_finishedLength);
          ((ra)localObject).hTZ.length = ((int)paramc.field_toltalLength);
          ((ra)localObject).publish();
          AppMethodBeat.o(169094);
          return;
        }
        if (paramd != null)
        {
          Log.i("MicroMsg.OnlineVideoService", "callback result info " + paramd.field_retCode + ", filesize:" + paramd.field_fileLength + ",recved:" + paramd.field_recvedBytes);
          if (paramd.field_retCode == 0) {
            break label828;
          }
          if (paramd.field_retCode != -10012) {
            ab.Qf(localz.getFileName());
          }
          j.e(((com.tencent.mm.g.h)localObject).aLL(), paramd.field_retCode, ((com.tencent.mm.g.h)localObject).lxi);
        }
        for (;;)
        {
          localObject = new ra();
          ((ra)localObject).hTZ.hId = 4;
          ((ra)localObject).hTZ.mediaId = paramString;
          ((ra)localObject).hTZ.offset = 0;
          ((ra)localObject).hTZ.retCode = paramd.field_retCode;
          ((ra)localObject).hTZ.length = ((int)paramd.field_fileLength);
          ((ra)localObject).publish();
          j.d(j.this).remove(paramString);
          AppMethodBeat.o(169094);
          return;
          label828:
          j.b(localz, (int)paramd.field_fileLength, ((com.tencent.mm.g.h)localObject).lxg);
          j.e(j.this).put(((com.tencent.mm.g.h)localObject).field_mediaId, localObject);
          j.f(j.this).put(((com.tencent.mm.g.h)localObject).field_mediaId, paramd);
        }
      }
    });
    if (this.oAr.get(paramString) != null)
    {
      AppMethodBeat.o(126734);
      return 1;
    }
    AppMethodBeat.o(126734);
    return 0;
  }
  
  public final boolean a(final com.tencent.mm.g.h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(126724);
    if (paramh == null)
    {
      Log.e("MicroMsg.OnlineVideoService", "add download task, but task is null.");
      AppMethodBeat.o(126724);
      return false;
    }
    if (Util.isNullOrNil(paramh.field_mediaId))
    {
      Log.e("MicroMsg.OnlineVideoService", "add download task, but task mediaId is null.");
      AppMethodBeat.o(126724);
      return false;
    }
    Log.i("MicroMsg.OnlineVideoService", "add download task : " + paramh.field_mediaId + " delay : " + paramBoolean);
    if (paramh.field_fileId == null) {
      paramh.field_fileId = "";
    }
    if (paramh.field_aesKey == null) {
      paramh.field_aesKey = "";
    }
    paramh.ihD = false;
    if ((l(paramh.field_mediaId, null)) || (paramBoolean)) {
      com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126713);
          j.a(j.this).add(paramh.field_mediaId);
          j.b(j.this).put(paramh.field_mediaId, paramh);
          j.this.hf(false);
          AppMethodBeat.o(126713);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(126724);
      return true;
      com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126714);
          j.a(j.this).add(paramh.field_mediaId);
          j.b(j.this).put(paramh.field_mediaId, paramh);
          j.this.hf(false);
          AppMethodBeat.o(126714);
        }
      });
    }
  }
  
  public final int bHL()
  {
    return 0;
  }
  
  public final int d(final String paramString1, final int paramInt1, final int paramInt2, final String paramString2)
  {
    AppMethodBeat.i(238097);
    this.mainHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126719);
        Log.i("MicroMsg.OnlineVideoService", "onMoovReady mediaId[%s]", new Object[] { paramString1 });
        if (Util.isNullOrNil(paramString1))
        {
          AppMethodBeat.o(126719);
          return;
        }
        com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
        {
          public final void run()
          {
            boolean bool2 = true;
            AppMethodBeat.i(169095);
            com.tencent.mm.g.h localh = (com.tencent.mm.g.h)j.d(j.this).get(j.10.this.bJZ);
            Object localObject = new StringBuilder("info=").append(localh).append(" mediaId=").append(j.10.this.bJZ).append(" info.videoCallback=");
            if ((localh != null) && (localh.lxs == null)) {}
            for (boolean bool1 = true;; bool1 = false)
            {
              Log.w("MicroMsg.OnlineVideoService", bool1);
              if (localh == null) {
                break label499;
              }
              localh.lxo = j.10.this.oBg;
              if (localh.lxs == null) {
                break;
              }
              localh.lxs.a(j.10.this.bJZ, j.10.this.oBg, j.10.this.oBh, j.10.this.oBl);
              AppMethodBeat.o(169095);
              return;
            }
            if (com.tencent.mm.modelvideo.y.PK(localh.field_fullpath))
            {
              Log.w("MicroMsg.OnlineVideoService", "it is qt video, need finish all file. isPlayMode" + localh.lxi);
              if (localh.lxi == 1)
              {
                j.v(localh.field_mediaId, 0, localh.field_totalLen);
                j.bHS();
              }
              AppMethodBeat.o(169095);
              return;
            }
            localObject = new ra();
            ((ra)localObject).hTZ.hId = 1;
            ((ra)localObject).hTZ.retCode = 0;
            ((ra)localObject).hTZ.mediaId = j.10.this.bJZ;
            ((ra)localObject).hTZ.offset = j.10.this.oBg;
            ((ra)localObject).hTZ.length = j.10.this.oBh;
            ((ra)localObject).hTZ.hUa = localh.lxf;
            ra.a locala = ((ra)localObject).hTZ;
            if (localh.lwM > 0) {}
            for (bool1 = bool2;; bool1 = false)
            {
              locala.hUb = bool1;
              ((ra)localObject).publish();
              localObject = ab.Qo(localh.filename);
              if (localObject == null) {
                break label493;
              }
              Log.i("MicroMsg.OnlineVideoService", "on moov ready info: " + ((com.tencent.mm.modelvideo.z)localObject).getFileName() + " status : " + ((com.tencent.mm.modelvideo.z)localObject).status);
              if (((com.tencent.mm.modelvideo.z)localObject).status != 130) {
                break;
              }
              AppMethodBeat.o(169095);
              return;
            }
            if (((com.tencent.mm.modelvideo.z)localObject).status != 122)
            {
              localObject = ab.Qo(localh.filename);
              if (localObject != null)
              {
                ((com.tencent.mm.modelvideo.z)localObject).status = 121;
                ((com.tencent.mm.modelvideo.z)localObject).eQp = 256;
                com.tencent.mm.modelvideo.v.bOh().c((com.tencent.mm.modelvideo.z)localObject);
              }
              if (localh.lxi == 0)
              {
                Log.i("MicroMsg.OnlineVideoService", "stop download video");
                com.tencent.mm.modelvideo.v.bOm().bOJ();
                com.tencent.mm.modelvideo.v.bOm().run();
              }
            }
            label493:
            AppMethodBeat.o(169095);
            return;
            label499:
            if (j.10.this.bJZ.contains("AdLandingGeneralVideo_"))
            {
              com.tencent.mm.plugin.report.service.h.OAn.kJ(1579, 12);
              Log.e("MicroMsg.OnlineVideoService", "download adLandingGeneralVideo task onMoovReady but task is null, %s, %s", new Object[] { j.10.this.bJZ, Integer.valueOf(j.this.hashCode()) });
            }
            AppMethodBeat.o(169095);
          }
        });
        AppMethodBeat.o(126719);
      }
    });
    if (this.oAr.containsKey(paramString1))
    {
      AppMethodBeat.o(238097);
      return 1;
    }
    AppMethodBeat.o(238097);
    return 0;
  }
  
  public final boolean e(final com.tencent.mm.g.h paramh)
  {
    AppMethodBeat.i(126725);
    if (paramh == null)
    {
      Log.e("MicroMsg.OnlineVideoService", "add download task, but task is null.");
      AppMethodBeat.o(126725);
      return false;
    }
    if (Util.isNullOrNil(paramh.field_mediaId))
    {
      Log.e("MicroMsg.OnlineVideoService", "add download task, but task mediaId is null.");
      AppMethodBeat.o(126725);
      return false;
    }
    Log.i("MicroMsg.OnlineVideoService", "add download task : " + paramh.field_mediaId);
    if (paramh.field_fileId == null) {
      paramh.field_fileId = "";
    }
    if (paramh.field_aesKey == null) {
      paramh.field_aesKey = "";
    }
    paramh.ihD = false;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126715);
          j.c(j.this).removeCallbacksAndMessages(paramh.field_mediaId);
          j.a(j.this).add(paramh.field_mediaId);
          j.b(j.this).put(paramh.field_mediaId, paramh);
          j.this.hf(false);
          AppMethodBeat.o(126715);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(126725);
      return true;
      this.mRi.removeCallbacksAndMessages(paramh.field_mediaId);
      this.oAp.add(paramh.field_mediaId);
      this.oAq.put(paramh.field_mediaId, paramh);
      hf(false);
    }
  }
  
  public final void hf(boolean paramBoolean)
  {
    AppMethodBeat.i(126730);
    if (!com.tencent.mm.kernel.h.baz())
    {
      AppMethodBeat.o(126730);
      return;
    }
    if ((!paramBoolean) && (k.bHX().bHJ()))
    {
      com.tencent.mm.kernel.h.baC();
      if (com.tencent.mm.kernel.b.aZM())
      {
        Log.w("MicroMsg.OnlineVideoService", "cdn engine not init cdn dnsinfo , will retry after set info");
        k.bHW().hf(paramBoolean);
        AppMethodBeat.o(126730);
        return;
      }
    }
    k.bHW().bHM();
    while (!this.oAp.isEmpty())
    {
      String str = (String)this.oAp.poll();
      Object localObject1 = (com.tencent.mm.g.h)this.oAq.remove(str);
      if (localObject1 != null)
      {
        ((com.tencent.mm.g.h)localObject1).field_startTime = Util.nowMilliSecond();
        if (!((com.tencent.mm.g.h)localObject1).ihD)
        {
          if (((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acNY, Integer.valueOf(-1))).intValue() == 2) {
            Log.i("MicroMsg.OnlineVideoService", "command set do not check media duplication.");
          }
          label167:
          Object localObject3;
          int j;
          for (int i = 0;; i = 1)
          {
            if (i == 0) {
              break label418;
            }
            localObject1 = new ra();
            ((ra)localObject1).hTZ.hId = 6;
            ((ra)localObject1).hTZ.mediaId = str;
            ((ra)localObject1).publish();
            break;
            if (((com.tencent.mm.g.h)localObject1).aLM()) {
              break label167;
            }
            localObject2 = ((com.tencent.mm.g.h)localObject1).lxg;
            i = ((com.tencent.mm.g.h)localObject1).lxh;
            localObject3 = ((com.tencent.mm.plugin.r.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.r.a.a.class)).bzI().iI((String)localObject2, i);
            j = i - (int)com.tencent.mm.vfs.y.bEl((String)localObject3);
            if ((Util.isNullOrNil((String)localObject3)) || (j < 0) || (j > 16)) {
              break label167;
            }
            Log.i("MicroMsg.OnlineVideoService", "it had download this video[%d, %s, %s].", new Object[] { Integer.valueOf(i), localObject2, localObject3 });
            com.tencent.mm.vfs.y.O((String)localObject3, ((com.tencent.mm.g.h)localObject1).field_fullpath, false);
            localObject3 = ab.Qo(((com.tencent.mm.g.h)localObject1).filename);
            a((com.tencent.mm.modelvideo.z)localObject3, i, (String)localObject2);
            if (localObject3 == null) {
              break label167;
            }
            localObject2 = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(((com.tencent.mm.modelvideo.z)localObject3).pbc);
            if (localObject2 != null) {
              ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(new i.c(((fi)localObject2).field_talker, "update", (cc)localObject2));
            }
          }
          label418:
          if (((com.tencent.mm.g.h)localObject1).aLL())
          {
            i = k.bHX().a((com.tencent.mm.g.g)localObject1, ((com.tencent.mm.g.h)localObject1).lxi);
            label440:
            Log.i("MicroMsg.OnlineVideoService", "start task %s streaming download. ret %d ", new Object[] { localObject1, Integer.valueOf(i) });
            if (i == 0) {
              break label1312;
            }
            Log.w("MicroMsg.OnlineVideoService", "start stream video error. ret : " + i + " media id: " + ((com.tencent.mm.g.h)localObject1).field_mediaId);
            paramBoolean = ((com.tencent.mm.g.h)localObject1).aLL();
            j = ((com.tencent.mm.g.h)localObject1).lxi;
            if (!paramBoolean) {
              break label1222;
            }
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 3L, 1L, false);
            if (j != 1) {
              break label1157;
            }
            if (i != -21006) {
              break label1116;
            }
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 100L, 1L, false);
          }
          label1157:
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.OAn.b(13836, new Object[] { Integer.valueOf(100), Long.valueOf(Util.nowSecond()), "" });
            break;
            if (((com.tencent.mm.g.h)localObject1).aLJ())
            {
              ((com.tencent.mm.g.h)localObject1).connectionCount = 2;
              i = k.bHX().a((com.tencent.mm.g.h)localObject1);
              break label440;
            }
            if (((com.tencent.mm.g.h)localObject1).aLO())
            {
              ((com.tencent.mm.g.h)localObject1).connectionCount = 4;
              i = k.bHX().b((com.tencent.mm.g.h)localObject1);
              break label440;
            }
            if (((com.tencent.mm.g.h)localObject1).aLP())
            {
              i = k.bHX().c((com.tencent.mm.g.h)localObject1);
              break label440;
            }
            if (((com.tencent.mm.g.h)localObject1).aLK())
            {
              i = k.bHX().d((com.tencent.mm.g.h)localObject1);
              break label440;
            }
            if ((((com.tencent.mm.g.h)localObject1).aLN()) && (((com.tencent.mm.g.h)localObject1).aLR()))
            {
              localObject2 = k.bHX();
              localObject3 = new CdnLogic.C2CDownloadRequest();
              ((CdnLogic.C2CDownloadRequest)localObject3).fileType = 20210;
              ((CdnLogic.C2CDownloadRequest)localObject3).fileKey = ((com.tencent.mm.g.h)localObject1).field_mediaId;
              ((CdnLogic.C2CDownloadRequest)localObject3).url = ((com.tencent.mm.g.h)localObject1).url;
              ((CdnLogic.C2CDownloadRequest)localObject3).referer = ((com.tencent.mm.g.h)localObject1).referer;
              ((CdnLogic.C2CDownloadRequest)localObject3).setSavePath(((com.tencent.mm.g.h)localObject1).field_fullpath);
              ((CdnLogic.C2CDownloadRequest)localObject3).fileSize = 0;
              ((CdnLogic.C2CDownloadRequest)localObject3).isColdSnsData = ((com.tencent.mm.g.h)localObject1).isColdSnsData;
              ((CdnLogic.C2CDownloadRequest)localObject3).isHotSnsVideo = ((com.tencent.mm.g.h)localObject1).isHotSnsVideo;
              ((CdnLogic.C2CDownloadRequest)localObject3).isHLSVideo = ((com.tencent.mm.g.h)localObject1).isHLSVideo;
              ((CdnLogic.C2CDownloadRequest)localObject3).hlsVideoFlag = ((com.tencent.mm.g.h)localObject1).hlsVideoFlag;
              ((CdnLogic.C2CDownloadRequest)localObject3).signalQuality = ((com.tencent.mm.g.h)localObject1).signalQuality;
              ((CdnLogic.C2CDownloadRequest)localObject3).snsScene = ((com.tencent.mm.g.h)localObject1).snsScene;
              ((CdnLogic.C2CDownloadRequest)localObject3).preloadRatio = ((com.tencent.mm.g.h)localObject1).field_preloadRatio;
              ((CdnLogic.C2CDownloadRequest)localObject3).preloadMinSize = ((com.tencent.mm.g.h)localObject1).preloadMinSize;
              ((CdnLogic.C2CDownloadRequest)localObject3).requestVideoFormat = ((com.tencent.mm.g.h)localObject1).field_requestVideoFormat;
              ((CdnLogic.C2CDownloadRequest)localObject3).connectionCount = ((com.tencent.mm.g.h)localObject1).connectionCount;
              ((CdnLogic.C2CDownloadRequest)localObject3).concurrentCount = ((com.tencent.mm.g.h)localObject1).concurrentCount;
              if ((com.tencent.mm.platformtools.z.pCF) && (com.tencent.mm.platformtools.z.pCK.length() > 0))
              {
                ((CdnLogic.C2CDownloadRequest)localObject3).debugIP = com.tencent.mm.platformtools.z.pCK;
                Log.w("MicroMsg.CdnTransportEngine", "debugip " + ((CdnLogic.C2CDownloadRequest)localObject3).debugIP);
              }
              i = CdnLogic.startSNSDownload((CdnLogic.C2CDownloadRequest)localObject3, (CdnLogic.VideoStreamingCallback)localObject2, (CdnLogic.DownloadCallback)localObject2, ((com.tencent.mm.g.h)localObject1).lxi);
              break label440;
            }
            localObject2 = k.bHX();
            localObject3 = new CdnLogic.C2CDownloadRequest();
            ((CdnLogic.C2CDownloadRequest)localObject3).fileKey = ((com.tencent.mm.g.h)localObject1).field_mediaId;
            ((CdnLogic.C2CDownloadRequest)localObject3).url = ((com.tencent.mm.g.h)localObject1).url;
            ((CdnLogic.C2CDownloadRequest)localObject3).referer = ((com.tencent.mm.g.h)localObject1).referer;
            ((CdnLogic.C2CDownloadRequest)localObject3).setSavePath(((com.tencent.mm.g.h)localObject1).field_fullpath);
            ((CdnLogic.C2CDownloadRequest)localObject3).fileSize = 0;
            ((CdnLogic.C2CDownloadRequest)localObject3).fileType = 20210;
            ((CdnLogic.C2CDownloadRequest)localObject3).concurrentCount = 10;
            ((CdnLogic.C2CDownloadRequest)localObject3).preloadRatio = ((com.tencent.mm.g.h)localObject1).field_preloadRatio;
            ((CdnLogic.C2CDownloadRequest)localObject3).preloadMinSize = ((com.tencent.mm.g.h)localObject1).preloadMinSize;
            if ((com.tencent.mm.platformtools.z.pCF) && (com.tencent.mm.platformtools.z.pCK.length() > 0))
            {
              ((CdnLogic.C2CDownloadRequest)localObject3).debugIP = com.tencent.mm.platformtools.z.pCK;
              Log.w("MicroMsg.CdnTransportEngine", "debugip " + ((CdnLogic.C2CDownloadRequest)localObject3).debugIP);
            }
            i = CdnLogic.startHttpVideoStreamingDownload((CdnLogic.C2CDownloadRequest)localObject3, (CdnLogic.VideoStreamingCallback)localObject2, (CdnLogic.DownloadCallback)localObject2, ((com.tencent.mm.g.h)localObject1).lxi);
            break label440;
            label1116:
            if (i == -20003)
            {
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 101L, 1L, false);
            }
            else
            {
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 102L, 1L, false);
              continue;
              if (i == -21006) {
                com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 106L, 1L, false);
              } else if (i == -20003) {
                com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 107L, 1L, false);
              } else {
                com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 108L, 1L, false);
              }
            }
          }
          label1222:
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 210L, 1L, false);
          if (j == 1) {
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 211L, 1L, false);
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.OAn.b(13836, new Object[] { Integer.valueOf(200), Long.valueOf(Util.nowSecond()), "" });
            break;
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 212L, 1L, false);
          }
          label1312:
          ((com.tencent.mm.g.h)localObject1).lxf = Util.nowMilliSecond();
          if (((com.tencent.mm.g.h)localObject1).aLL())
          {
            localObject2 = ab.Qo(((com.tencent.mm.g.h)localObject1).filename);
            if (localObject2 != null)
            {
              i = ((com.tencent.mm.modelvideo.z)localObject2).status;
              if ((i != 120) && (i != 122) && (i != 121))
              {
                ((com.tencent.mm.modelvideo.z)localObject2).status = 120;
                ((com.tencent.mm.modelvideo.z)localObject2).eQp = 256;
                com.tencent.mm.modelvideo.v.bOh().c((com.tencent.mm.modelvideo.z)localObject2);
              }
            }
          }
          this.oAr.put(((com.tencent.mm.g.h)localObject1).field_mediaId, localObject1);
          Object localObject2 = new ra();
          ((ra)localObject2).hTZ.hId = 7;
          ((ra)localObject2).hTZ.mediaId = str;
          ((ra)localObject2).hTZ.hUa = ((com.tencent.mm.g.h)localObject1).lxf;
          ((ra)localObject2).publish();
        }
      }
    }
    AppMethodBeat.o(126730);
  }
  
  public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126728);
    if ((com.tencent.mm.g.h)this.oAr.get(paramString) == null)
    {
      Log.i("MicroMsg.OnlineVideoService", "this media[%s] don't download now.", new Object[] { paramString });
      AppMethodBeat.o(126728);
      return false;
    }
    k.bHX();
    boolean bool = d.isVideoDataAvailable(paramString, paramInt1, paramInt2);
    Log.i("MicroMsg.OnlineVideoService", "is video[%s] data[%d, %d] available[%b]", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
    AppMethodBeat.o(126728);
    return bool;
  }
  
  public final boolean k(final String paramString, final Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(126726);
    boolean bool;
    if (!Util.isNullOrNil(paramString)) {
      if (this.oAr.containsKey(paramString))
      {
        bool = true;
        if ((!bool) || (Looper.myLooper() == Looper.getMainLooper())) {
          break label121;
        }
        this.mRi.postAtTime(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(126716);
            com.tencent.mm.g.h localh = (com.tencent.mm.g.h)j.d(j.this).remove(paramString);
            com.tencent.mm.g.d locald;
            int i;
            if (localh != null)
            {
              locald = new com.tencent.mm.g.d();
              k.bHX();
              i = d.c(localh.field_mediaId, locald);
              if (i == 0) {
                j.a(paramArrayOfObject, locald, localh, false);
              }
            }
            for (;;)
            {
              j.b(j.this).remove(paramString);
              AppMethodBeat.o(126716);
              return;
              Log.w("MicroMsg.OnlineVideoService", "stop video stream download error. ret %d, mediaId %s", new Object[] { Integer.valueOf(i), localh.field_mediaId });
              continue;
              localh = (com.tencent.mm.g.h)j.e(j.this).remove(paramString);
              locald = (com.tencent.mm.g.d)j.f(j.this).remove(paramString);
              if ((localh != null) && (locald != null)) {
                j.a(paramArrayOfObject, locald, localh, true);
              }
            }
          }
        }, paramString, SystemClock.uptimeMillis());
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.OnlineVideoService", "cancelDownloadTaskInMainThread mediaId : " + paramString + " remove : " + bool);
      AppMethodBeat.o(126726);
      return bool;
      k.bHW().Nz(paramString);
      bool = false;
      break;
      label121:
      this.mRi.removeCallbacksAndMessages(paramString);
      com.tencent.mm.g.h localh = (com.tencent.mm.g.h)this.oAr.remove(paramString);
      com.tencent.mm.g.d locald;
      int i;
      if (localh != null)
      {
        locald = new com.tencent.mm.g.d();
        k.bHX();
        i = d.c(localh.field_mediaId, locald);
        if (i == 0) {
          a(paramArrayOfObject, locald, localh, false);
        }
      }
      for (;;)
      {
        this.oAq.remove(paramString);
        break;
        Log.w("MicroMsg.OnlineVideoService", "stop video stream download error. ret %d, mediaId %s", new Object[] { Integer.valueOf(i), localh.field_mediaId });
        continue;
        localh = (com.tencent.mm.g.h)this.oBd.remove(paramString);
        locald = (com.tencent.mm.g.d)this.oBe.remove(paramString);
        if ((localh != null) && (locald != null)) {
          a(paramArrayOfObject, locald, localh, true);
        }
      }
      bool = false;
    }
  }
  
  public final boolean l(final String paramString, final Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(126727);
    boolean bool1 = false;
    boolean bool2 = false;
    if (!Util.isNullOrNil(paramString)) {
      if (!this.oAr.containsKey(paramString)) {
        break label90;
      }
    }
    for (bool1 = true;; bool1 = bool2)
    {
      com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126717);
          com.tencent.mm.g.h localh = (com.tencent.mm.g.h)j.d(j.this).remove(paramString);
          com.tencent.mm.g.d locald;
          int i;
          if (localh != null)
          {
            locald = new com.tencent.mm.g.d();
            k.bHX();
            i = d.c(localh.field_mediaId, locald);
            if (i == 0) {
              j.a(paramArrayOfObject, locald, localh, false);
            }
          }
          for (;;)
          {
            j.b(j.this).remove(paramString);
            AppMethodBeat.o(126717);
            return;
            Log.w("MicroMsg.OnlineVideoService", "stop video stream download error. ret %d, mediaId %s", new Object[] { Integer.valueOf(i), localh.field_mediaId });
            continue;
            localh = (com.tencent.mm.g.h)j.e(j.this).remove(paramString);
            locald = (com.tencent.mm.g.d)j.f(j.this).remove(paramString);
            if ((localh != null) && (locald != null)) {
              j.a(paramArrayOfObject, locald, localh, true);
            }
          }
        }
      });
      Log.i("MicroMsg.OnlineVideoService", "cancelDownloadTask mediaId : " + paramString + " remove : " + bool1);
      AppMethodBeat.o(126727);
      return bool1;
      label90:
      k.bHW().Nz(paramString);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(126723);
    if (paramp.getType() != 379)
    {
      AppMethodBeat.o(126723);
      return;
    }
    Log.i("MicroMsg.OnlineVideoService", "it get cdn dns success[%d, %d], try to start.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (com.tencent.mm.kernel.h.baC().aZN()) {
      com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126711);
          j.this.hf(true);
          AppMethodBeat.o(126711);
        }
      });
    }
    AppMethodBeat.o(126723);
  }
  
  public final void release()
  {
    AppMethodBeat.i(126722);
    com.tencent.mm.kernel.h.aZW().b(379, this);
    AppMethodBeat.o(126722);
  }
  
  public final int t(final String paramString, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(238104);
    Log.i("MicroMsg.OnlineVideoService", "onDataAvailable. offset %d, length %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(238104);
      return 0;
    }
    com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126720);
        Object localObject = (com.tencent.mm.g.h)j.d(j.this).get(paramString);
        if (localObject != null)
        {
          if (((com.tencent.mm.g.h)localObject).lxs != null) {
            ((com.tencent.mm.g.h)localObject).lxs.onDataAvailable(paramString, paramInt1, paramInt2);
          }
          localObject = new ra();
          ((ra)localObject).hTZ.hId = 2;
          ((ra)localObject).hTZ.retCode = 0;
          ((ra)localObject).hTZ.mediaId = paramString;
          ((ra)localObject).hTZ.offset = paramInt1;
          ((ra)localObject).hTZ.length = paramInt2;
          ((ra)localObject).publish();
        }
        AppMethodBeat.o(126720);
      }
    });
    if (this.oAr.containsKey(paramString))
    {
      AppMethodBeat.o(238104);
      return 1;
    }
    AppMethodBeat.o(238104);
    return 0;
  }
  
  public final int u(final String paramString, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(238108);
    Log.i("MicroMsg.OnlineVideoService", "onDownloadToEnd. offset %d, length %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(238108);
      return 0;
    }
    com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126712);
        com.tencent.mm.g.h localh = (com.tencent.mm.g.h)j.d(j.this).get(paramString);
        if (localh != null)
        {
          ra localra = new ra();
          localra.hTZ.hId = 3;
          localra.hTZ.retCode = 0;
          localra.hTZ.mediaId = paramString;
          localra.hTZ.offset = paramInt1;
          localra.hTZ.length = paramInt2;
          localra.publish();
          if ((paramInt1 == 0) && (paramInt2 >= localh.lxh)) {
            j.b(ab.Qo(localh.filename), localh.lxh, localh.lxg);
          }
        }
        AppMethodBeat.o(126712);
      }
    });
    if (this.oAr.containsKey(paramString))
    {
      AppMethodBeat.o(238108);
      return 1;
    }
    AppMethodBeat.o(238108);
    return 0;
  }
  
  public static abstract interface a
  {
    public abstract void onStop(int paramInt, com.tencent.mm.g.h paramh, com.tencent.mm.g.d paramd, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelcdntran.j
 * JD-Core Version:    0.7.0.1
 */