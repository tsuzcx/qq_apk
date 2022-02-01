package com.tencent.mm.aq;

import android.os.Looper;
import android.os.SystemClock;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.mars.cdn.CdnLogic.DownloadCallback;
import com.tencent.mars.cdn.CdnLogic.VideoStreamingCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.b.p;
import com.tencent.mm.f.a.nb;
import com.tencent.mm.f.a.pn;
import com.tencent.mm.f.a.pn.a;
import com.tencent.mm.f.b.a.iu;
import com.tencent.mm.f.b.a.kz;
import com.tencent.mm.f.b.a.lq;
import com.tencent.mm.f.b.a.oc;
import com.tencent.mm.f.c.et;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.h.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bq.b;
import com.tencent.mm.modelvideo.ac.a;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.w;
import com.tencent.mm.modelvideo.x;
import com.tencent.mm.modelvideo.y;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
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
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bz;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.u;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class e
  implements com.tencent.mm.an.i, a.a
{
  private MMHandler knk;
  private Queue<String> lHQ;
  private Map<String, com.tencent.mm.i.h> lHR;
  private Map<String, com.tencent.mm.i.h> lHS;
  private Map<String, com.tencent.mm.i.h> lID;
  private Map<String, com.tencent.mm.i.d> lIE;
  private final MMHandler mainHandler;
  
  public e()
  {
    AppMethodBeat.i(126721);
    this.lHQ = new LinkedList();
    this.lHR = new HashMap();
    this.lHS = new HashMap();
    this.lID = new HashMap();
    this.lIE = new HashMap();
    this.mainHandler = new MMHandler(Looper.getMainLooper());
    this.knk = new MMHandler(Looper.getMainLooper());
    com.tencent.mm.kernel.h.aGY().a(379, this);
    AppMethodBeat.o(126721);
  }
  
  public static com.tencent.mm.i.h VB(String paramString)
  {
    AppMethodBeat.i(126737);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(126737);
      return null;
    }
    w localw = y.Yk(paramString);
    if (localw == null)
    {
      AppMethodBeat.o(126737);
      return null;
    }
    Object localObject1 = XmlParser.parseXml(localw.bqO(), "msg", null);
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
    String str4 = c.a("downvideo", localw.createTime, localw.bqM(), localw.getFileName());
    if (Util.isNullOrNil(str4))
    {
      Log.w("MicroMsg.OnlineVideoService", "cdntra genClientId failed not use cdn file:%s", new Object[] { localw.getFileName() });
      AppMethodBeat.o(126737);
      return null;
    }
    s.bqB();
    String str5 = x.XT(paramString);
    localObject1 = new com.tencent.mm.i.h();
    ((com.tencent.mm.i.h)localObject1).taskName = "task_OnlineVideoService_1";
    ((com.tencent.mm.i.h)localObject1).filename = paramString;
    ((com.tencent.mm.i.h)localObject1).iVb = str1;
    ((com.tencent.mm.i.h)localObject1).iVc = j;
    ((com.tencent.mm.i.h)localObject1).iVd = 1;
    ((com.tencent.mm.i.h)localObject1).fLi = localw.bqK();
    ((com.tencent.mm.i.h)localObject1).iVe = localw.bqM();
    if (ab.Lj(localw.bqM()))
    {
      i = com.tencent.mm.model.v.Pu(localw.bqM());
      ((com.tencent.mm.i.h)localObject1).fLk = i;
      ((com.tencent.mm.i.h)localObject1).field_mediaId = str4;
      ((com.tencent.mm.i.h)localObject1).field_fullpath = str5;
      ((com.tencent.mm.i.h)localObject1).field_fileType = com.tencent.mm.i.a.MediaType_VIDEO;
      ((com.tencent.mm.i.h)localObject1).field_totalLen = j;
      ((com.tencent.mm.i.h)localObject1).field_aesKey = str2;
      ((com.tencent.mm.i.h)localObject1).field_fileId = ((String)localObject2);
      ((com.tencent.mm.i.h)localObject1).field_priority = com.tencent.mm.i.a.iTU;
      ((com.tencent.mm.i.h)localObject1).field_wxmsgparam = str3;
      if (!ab.Lj(localw.bqM())) {
        break label525;
      }
      i = 1;
      label375:
      ((com.tencent.mm.i.h)localObject1).field_chattype = i;
      ((com.tencent.mm.i.h)localObject1).iVf = localw.iVf;
      paramString = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aL(localw.bqM(), localw.fNu);
      localObject2 = bq.RR(paramString.hxy);
      ((com.tencent.mm.i.h)localObject1).iUH = 0;
      ((com.tencent.mm.i.h)localObject1).iUI = 0;
      ((com.tencent.mm.i.h)localObject1).iVh = paramString.field_createTime;
      ((com.tencent.mm.i.h)localObject1).fNu = paramString.field_msgSvrId;
      if (localObject2 == null) {
        break label530;
      }
    }
    label525:
    label530:
    for (int i = ((bq.b)localObject2).luI;; i = 0)
    {
      ((com.tencent.mm.i.h)localObject1).iVi = i;
      if (((com.tencent.mm.i.h)localObject1).iUH > 0) {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 36L, 1L, false);
      }
      ((com.tencent.mm.i.h)localObject1).field_autostart = false;
      ((com.tencent.mm.i.h)localObject1).field_requestVideoFormat = com.tencent.mm.modelcontrol.e.a(1, localw);
      AppMethodBeat.o(126737);
      return localObject1;
      i = 0;
      break;
      i = 0;
      break label375;
    }
  }
  
  public static com.tencent.mm.i.h a(bp parambp, String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(216017);
    if (parambp == null)
    {
      Log.w("MicroMsg.OnlineVideoService", "check can sns online video, scene is null.");
      AppMethodBeat.o(216017);
      return null;
    }
    if (Util.isNullOrNil(paramString1))
    {
      Log.w("MicroMsg.OnlineVideoService", "check can sns online video, url is null.");
      AppMethodBeat.o(216017);
      return null;
    }
    Object localObject = y.Yk(paramString3);
    if (localObject == null)
    {
      Log.w("MicroMsg.OnlineVideoService", "check can sns online video, video info is null. %s", new Object[] { paramString3 });
      AppMethodBeat.o(216017);
      return null;
    }
    String str1 = c.a("snsvideo", parambp.time, "sns", paramString1);
    if (Util.isNullOrNil(str1))
    {
      Log.w("MicroMsg.OnlineVideoService", "check can http online video, can not create media id. url %s ", new Object[] { paramString1 });
      AppMethodBeat.o(216017);
      return null;
    }
    com.tencent.mm.i.h localh = new com.tencent.mm.i.h();
    localh.taskName = "task_OnlineVideoService_2";
    localh.filename = paramString3;
    localh.field_fullpath = paramString2;
    localh.field_mediaId = str1;
    localh.iUX = 2;
    localh.iVd = paramInt;
    localh.iVf = ((w)localObject).iVf;
    if (parambp == null) {
      paramString3 = "";
    }
    for (;;)
    {
      str1 = "https://" + WeChatHosts.domainString(com.tencent.mm.plugin.au.a.a.host_weixin_qq_com) + "/?version=%d&uin=%s&nettype=%d&signal=%d%s";
      int i = com.tencent.mm.protocal.d.RAD;
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHE();
      String str2 = p.getString(com.tencent.mm.kernel.b.getUin());
      int j = NetStatusUtil.getNetTypeForStat(MMApplicationContext.getContext());
      int k = ConnectivityCompat.Companion.getCompatMixStrength();
      label286:
      long l1;
      boolean bool;
      if (!Util.isNullOrNil(paramString3))
      {
        localObject = "&scene=".concat(String.valueOf(paramString3));
        localh.referer = String.format(str1, new Object[] { Integer.valueOf(i), str2, Integer.valueOf(j), Integer.valueOf(k), localObject });
        localh.url = paramString1;
        localObject = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getValue("SnsSightDomainList");
        long l2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getInt("SnsSightMainStandbyIpSwitchTime", 0);
        Log.i("MicroMsg.OnlineVideoService", "hostvalue %s dcipTime %s scene.time[%d]", new Object[] { localObject, Long.valueOf(l2), Integer.valueOf(parambp.time) });
        l1 = l2;
        if (l2 <= 0L) {
          l1 = 259200L;
        }
        bool = a(parambp, localh.url, l1, (String)localObject);
      }
      for (;;)
      {
        try
        {
          localh.host = new URL(localh.url).getHost();
          localObject = new ArrayList();
          com.tencent.mm.network.d.b(bool, (List)localObject, localh.host);
          localh.iUz = new String[((List)localObject).size()];
          ((List)localObject).toArray(localh.iUz);
          if (Util.secondsToNow(parambp.time) <= l1) {
            break label817;
          }
          bool = true;
          localh.isColdSnsData = bool;
          localh.signalQuality = ConnectivityCompat.Companion.getCompatMixStrength();
          localh.snsScene = paramString3;
          localh.concurrentCount = 5;
          if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vud, false))
          {
            if (!paramBoolean) {
              break label823;
            }
            localh.field_requestVideoFormat = com.tencent.mm.modelcontrol.e.j(paramInt, paramString2, paramString1);
          }
          AppMethodBeat.o(216017);
          return localh;
        }
        catch (Exception parambp)
        {
          Log.printErrStackTrace("MicroMsg.OnlineVideoService", parambp, "check can sns online video error taskInfo %s", new Object[] { localh });
          AppMethodBeat.o(216017);
          return null;
        }
        if (parambp.equals(bp.VGi))
        {
          paramString3 = "album_friend";
          break;
        }
        if (parambp.equals(bp.VGj))
        {
          paramString3 = "album_self";
          break;
        }
        if (parambp.equals(bp.VGk))
        {
          paramString3 = "album_stranger";
          break;
        }
        if (parambp.equals(bp.VGl))
        {
          paramString3 = "profile_friend";
          break;
        }
        if (parambp.equals(bp.VGm))
        {
          paramString3 = "profile_stranger";
          break;
        }
        if (parambp.equals(bp.VGn))
        {
          paramString3 = "comment";
          break;
        }
        if (parambp.equals(bp.VGh))
        {
          paramString3 = "timeline";
          break;
        }
        if (parambp.equals(bp.VGq))
        {
          paramString3 = "snssight";
          break;
        }
        if (!parambp.equals(bp.VGs)) {
          break label837;
        }
        paramString3 = "storysight";
        break;
        localObject = "";
        break label286;
        label817:
        bool = false;
        continue;
        label823:
        localh.field_requestVideoFormat = com.tencent.mm.modelcontrol.e.M(paramInt, paramString2);
      }
      label837:
      paramString3 = "";
    }
  }
  
  private static void a(w paramw, int paramInt, String paramString)
  {
    AppMethodBeat.i(126735);
    Log.i("MicroMsg.OnlineVideoService", "download finish. totalLen %d ", new Object[] { Integer.valueOf(paramInt) });
    if (paramw != null)
    {
      y.aQ(paramw.getFileName(), paramInt);
      i(paramInt, paramString, paramw.getFileName());
    }
    AppMethodBeat.o(126735);
  }
  
  private static void a(PInt paramPInt1, PInt paramPInt2, String paramString, int paramInt)
  {
    AppMethodBeat.i(126743);
    int j = 0;
    paramString = y.Yk(paramString);
    if (paramString != null) {
      j = paramString.fLn;
    }
    for (int k = paramString.lAW;; k = 0)
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
    nb localnb = new nb();
    localnb.fLh.fLi = paramString1;
    localnb.fLh.fLj = paramString2;
    localnb.fLh.fLk = paramInt1;
    localnb.fLh.fileId = paramString3;
    localnb.fLh.netType = paramInt2;
    localnb.fLh.startTime = paramLong1;
    localnb.fLh.endTime = paramLong2;
    localnb.fLh.path = paramString4;
    localnb.fLh.fLl = paramArrayOfString;
    localnb.fLh.fLm = paramString5;
    localnb.fLh.fLn = paramInt3;
    localnb.fLh.fLo = paramInt4;
    localnb.fLh.fLp = paramString6;
    EventCenter.instance.publish(localnb);
    AppMethodBeat.o(126744);
  }
  
  public static void a(Object[] paramArrayOfObject, com.tencent.mm.i.d paramd, com.tencent.mm.i.h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(126742);
    if ((paramh == null) || (paramd == null))
    {
      Log.w("MicroMsg.OnlineVideoService", "video task info is null or download result is null.");
      AppMethodBeat.o(126742);
      return;
    }
    if ((!paramh.arN()) && (!paramh.arP()) && (!paramh.arS()))
    {
      AppMethodBeat.o(126742);
      return;
    }
    String str2 = paramd.field_clientIP;
    int i4;
    label146:
    label167:
    boolean bool1;
    boolean bool2;
    Object localObject1;
    Object localObject2;
    int i15;
    int i16;
    int i6;
    int i5;
    int i2;
    int j;
    int i3;
    int m;
    int i;
    int n;
    int i1;
    if (paramd.field_isCrossNet)
    {
      i4 = 1;
      Log.i("MicroMsg.OnlineVideoService", "rpt online video format[%d] clientIp[%s] isCrossNet[%d]", new Object[] { Integer.valueOf(paramd.field_videoFormat), str2, Integer.valueOf(i4) });
      if (paramd.field_videoFormat == 2) {
        y.Yn(paramh.filename);
      }
      if (!Util.isNullOrNil(str2)) {
        break label1526;
      }
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 45L, 1L, false);
      if (!paramd.field_isCrossNet) {
        break label1543;
      }
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 47L, 1L, false);
      bool1 = paramh.arP();
      bool2 = paramh.arS();
      localObject1 = new PInt();
      localObject2 = new PInt();
      ((PInt)localObject2).value = 0;
      ((PInt)localObject1).value = 0;
      y.a(paramh.field_fullpath, (PInt)localObject1, (PInt)localObject2);
      i15 = ((PInt)localObject1).value * 1000;
      i16 = ((PInt)localObject2).value;
      i6 = 0;
      i5 = 0;
      if ((paramArrayOfObject == null) || (paramArrayOfObject.length <= 6)) {
        break label2928;
      }
      i2 = ((Integer)paramArrayOfObject[0]).intValue() * 1000;
      j = ((Integer)paramArrayOfObject[1]).intValue();
      i3 = ((Integer)paramArrayOfObject[2]).intValue();
      m = ((Integer)paramArrayOfObject[3]).intValue();
      i = ((Integer)paramArrayOfObject[4]).intValue();
      n = ((Integer)paramArrayOfObject[5]).intValue();
      i1 = ((Integer)paramArrayOfObject[6]).intValue();
      if ((bool2) || (bool1) || (paramArrayOfObject.length <= 10)) {
        break label2920;
      }
      i6 = ((Integer)paramArrayOfObject[7]).intValue();
      localObject1 = (String)paramArrayOfObject[8];
      i5 = ((Long)paramArrayOfObject[9]).intValue();
    }
    for (;;)
    {
      int i7 = paramh.iVf;
      int k = i7;
      label412:
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
        str1 = paramd.arL();
        PInt localPInt1 = new PInt();
        localPInt2 = new PInt();
        a(localPInt1, localPInt2, paramh.filename, paramh.iVi);
        localStringBuffer = new StringBuffer();
        if (!bool1) {
          break label1567;
        }
        localStringBuffer.append(paramh.field_fileId).append(",").append(paramh.field_aesKey).append(",");
        label502:
        localStringBuffer.append(paramd.field_fileLength).append(",").append(i15).append(",");
        localStringBuffer.append(paramd.field_recvedBytes).append(",");
        localStringBuffer.append(i2 + ",").append(j + ",").append(i3 + ",");
        localStringBuffer.append(m + ",").append(i + ",");
        localStringBuffer.append(i17).append(",");
        localStringBuffer.append(k).append(",");
        localStringBuffer.append(paramd.field_startTime).append(",");
        localStringBuffer.append(paramd.field_endTime).append(",");
        if (!bool1) {
          break label1614;
        }
        if (paramh.iVe == null) {
          break label1599;
        }
        localObject2 = com.tencent.mm.b.g.getMessageDigest(paramh.iVe.getBytes());
        label755:
        localStringBuffer.append(localObject2).append(",");
        if (!ab.Lj(paramh.iVe)) {
          break label1608;
        }
        k = 1;
        label782:
        localStringBuffer.append(k).append(",");
        label796:
        localStringBuffer.append(paramd.field_retCode).append(",");
        localStringBuffer.append(paramd.field_enQueueTime).append(",");
        localStringBuffer.append(paramd.field_firstRequestCost).append(",");
        localStringBuffer.append(paramd.field_firstRequestSize).append(",");
        localStringBuffer.append(paramd.field_firstRequestDownloadSize).append(",");
        if (!paramd.field_firstRequestCompleted) {
          break label1646;
        }
        k = 1;
        label886:
        localStringBuffer.append(k).append(",");
        localStringBuffer.append(paramd.field_averageSpeed).append(",");
        localStringBuffer.append(paramd.field_averageConnectCost).append(",");
        localStringBuffer.append(paramd.field_firstConnectCost).append(",");
        localStringBuffer.append(paramd.field_netConnectTimes).append(",");
        localStringBuffer.append(paramd.field_moovRequestTimes).append(",");
        localStringBuffer.append(paramd.field_moovCost).append(",");
        localStringBuffer.append(paramd.field_moovSize).append(",");
        if (!paramd.field_moovCompleted) {
          break label1652;
        }
        k = 1;
        label1022:
        localStringBuffer.append(k).append(",");
        localStringBuffer.append(paramd.field_moovFailReason).append(",");
        localStringBuffer.append(n).append(",");
        localStringBuffer.append(i1).append(",");
        if (!bool1) {
          break label1658;
        }
        localStringBuffer.append(i16).append(",");
        localStringBuffer.append(str1).append(",");
        if (!bool1) {
          break label1717;
        }
        localStringBuffer.append(paramh.iVh).append(",");
        localStringBuffer.append(paramh.fNu).append(",");
        localStringBuffer.append(paramh.iUH).append(",");
        localStringBuffer.append(paramd.field_videoFormat).append(",");
        label1182:
        localStringBuffer.append(str2).append(",");
        localStringBuffer.append(i4).append(",");
        localStringBuffer.append(paramh.iVj).append(",");
        localStringBuffer.append(localPInt1.value).append(",");
        localStringBuffer.append(localPInt2.value).append(",");
        localStringBuffer.append(paramd.transportProtocol).append(",");
        localStringBuffer.append(paramd.transportProtocolError);
        if (!bool1) {
          break label1739;
        }
        k = 13570;
        label1296:
        if (bool2) {
          k = 13570;
        }
        localObject2 = localStringBuffer.toString();
        Log.i("MicroMsg.OnlineVideoService", "report online video %d:%s", new Object[] { Integer.valueOf(k), localObject2 });
        if (!bool1) {
          break label1747;
        }
        new iu((String)localObject2).bpa();
        if (paramBoolean) {
          a(paramh.fLi, paramh.iVe, paramh.fLk, paramd.field_fileId, i17, paramd.field_startTime, paramd.field_endTime, paramh.field_fullpath, paramd.field_usedSvrIps, paramh.url, localPInt1.value, localPInt2.value, paramh.fLp);
        }
        if (bool1)
        {
          if (paramd.field_videoFormat != 2) {
            break label2903;
          }
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 132L, 1L, false);
        }
      }
      for (;;)
      {
        paramArrayOfObject = y.Yk(paramh.filename);
        if (paramArrayOfObject != null)
        {
          paramArrayOfObject = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(paramArrayOfObject.mhR);
          ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(new i.c(paramArrayOfObject.field_talker, "update", paramArrayOfObject));
        }
        AppMethodBeat.o(126742);
        return;
        i4 = 0;
        break;
        label1526:
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 46L, 1L, false);
        break label146;
        label1543:
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 48L, 1L, false);
        break label167;
        k = 31;
        break label412;
        label1567:
        localStringBuffer.append(paramh.url).append(",").append(paramh.iVg).append(",");
        break label502;
        label1599:
        localObject2 = Integer.valueOf(0);
        break label755;
        label1608:
        k = 0;
        break label782;
        label1614:
        localStringBuffer.append(0).append(",");
        localStringBuffer.append(paramd.field_httpStatusCode).append(",");
        break label796;
        label1646:
        k = 0;
        break label886;
        label1652:
        k = 0;
        break label1022;
        label1658:
        localStringBuffer.append(i16).append(",");
        if (paramh.iVe != null) {}
        for (localObject2 = com.tencent.mm.b.g.getMessageDigest(paramh.iVe.getBytes());; localObject2 = Integer.valueOf(0))
        {
          localStringBuffer.append(localObject2).append(",");
          break;
        }
        label1717:
        localStringBuffer.append(com.tencent.mm.plugin.video.c.bfp(paramh.fLp)).append(",");
        break label1182;
        label1739:
        k = 13790;
        break label1296;
        label1747:
        if (bool2)
        {
          int i9 = 0;
          int i10 = 0;
          localObject2 = "";
          long l2 = 0L;
          int i11 = 0;
          int i12 = 0;
          int i13 = 0;
          int i14 = 0;
          long l1 = l2;
          int i8 = i14;
          i7 = i13;
          i6 = i12;
          i5 = i11;
          localObject1 = localObject2;
          i4 = i10;
          k = i9;
          if (paramArrayOfObject != null)
          {
            l1 = l2;
            i8 = i14;
            i7 = i13;
            i6 = i12;
            i5 = i11;
            localObject1 = localObject2;
            i4 = i10;
            k = i9;
            if (paramArrayOfObject.length >= 11)
            {
              k = Util.getInt(paramArrayOfObject[7].toString(), 0);
              Util.getInt(paramArrayOfObject[8].toString(), 0);
              i4 = Util.getInt(paramArrayOfObject[9].toString(), 0);
              localObject1 = paramArrayOfObject[11].toString();
              i5 = Util.getInt(paramArrayOfObject[12].toString(), 0);
              l1 = Util.getLong(paramArrayOfObject[13].toString(), 0L);
              i6 = Util.getInt(paramArrayOfObject[14].toString(), 0);
              i7 = Util.getInt(paramArrayOfObject[15].toString(), 0);
              i8 = Util.getInt(paramArrayOfObject[16].toString(), 0);
            }
          }
          paramArrayOfObject = new oc();
          localObject1 = paramArrayOfObject.EK((String)localObject1);
          ((oc)localObject1).hat = i5;
          ((oc)localObject1).hau = i7;
          ((oc)localObject1).hav = i6;
          ((oc)localObject1).gki = i15;
          ((oc)localObject1).haw = (i2 / 1000);
          ((oc)localObject1).gJF = j;
          ((oc)localObject1).gJG = i3;
          ((oc)localObject1).gEU = m;
          ((oc)localObject1).gEV = i;
          ((oc)localObject1).hax = 0L;
          ((oc)localObject1).gKa = n;
          ((oc)localObject1).hay = i1;
          localObject1 = ((oc)localObject1).EL("");
          ((oc)localObject1).gkj = (i16 * 1000);
          localObject1 = ((oc)localObject1).EM(paramh.field_requestVideoFormat);
          ((oc)localObject1).ggS = paramd.field_fileLength;
          ((oc)localObject1).haB = paramd.field_recvedBytes;
          ((oc)localObject1).gJJ = paramd.field_startTime;
          ((oc)localObject1).gJK = paramd.field_endTime;
          ((oc)localObject1).haC = paramd.field_retCode;
          ((oc)localObject1).haD = paramd.field_enQueueTime;
          ((oc)localObject1).haE = paramd.field_moovRequestTimes;
          ((oc)localObject1).haF = paramd.field_moovCost;
          ((oc)localObject1).gJX = paramd.field_moovSize;
          if (paramd.field_moovCompleted)
          {
            l2 = 1L;
            ((oc)localObject1).haG = l2;
            ((oc)localObject1).haH = paramd.field_moovFailReason;
            ((oc)localObject1).haI = paramd.field_firstConnectCost;
            ((oc)localObject1).haJ = paramd.field_firstRequestCost;
            ((oc)localObject1).haK = paramd.field_firstRequestSize;
            ((oc)localObject1).haL = paramd.field_firstRequestDownloadSize;
            if (!paramd.field_firstRequestCompleted) {
              break label2705;
            }
            l2 = 1L;
            label2287:
            ((oc)localObject1).haM = l2;
            ((oc)localObject1).haN = paramd.field_averageSpeed;
            ((oc)localObject1).haO = paramd.field_averageConnectCost;
            ((oc)localObject1).gJU = paramd.field_netConnectTimes;
            localObject1 = ((oc)localObject1).EN(paramd.arL()).EO(paramd.field_clientIP);
            if (!paramd.field_isCrossNet) {
              break label2711;
            }
            l2 = 1L;
            ((oc)localObject1).haQ = l2;
            ((oc)localObject1).gKi = paramh.iVj;
            ((oc)localObject1).haR = i4;
            ((oc)localObject1).ggQ = i17;
            ((oc)localObject1).haS = l1;
            ((oc)localObject1).gkq = k;
            ((oc)localObject1).haT = i8;
            ((oc)localObject1).gKj = paramd.transportProtocol;
            ((oc)localObject1).gKk = paramd.transportProtocolError;
            ((oc)localObject1).gKl = paramd.traceId;
            localObject1 = ((oc)localObject1).EP("").EQ(paramd.field_videoFlag).ER(paramd.field_videoCdnMsg);
            if (paramd.svrFallbackCount <= 0) {
              break label2717;
            }
          }
          for (i = 1;; i = 0)
          {
            ((oc)localObject1).gKn = i;
            Log.d("MicroMsg.OnlineVideoService", "time distance %d", new Object[] { Long.valueOf(System.currentTimeMillis() - paramArrayOfObject.haS) });
            if (System.currentTimeMillis() - paramArrayOfObject.haS > 500L) {
              paramArrayOfObject.bpa();
            }
            if (!bool2) {
              break;
            }
            paramArrayOfObject = new lq();
            localObject1 = com.tencent.mm.plugin.sight.base.f.aYg(paramh.field_fullpath);
            if (localObject1 != null)
            {
              paramArrayOfObject.gki = ((com.tencent.mm.plugin.sight.base.b)localObject1).videoDuration;
              paramArrayOfObject.gkj = ((com.tencent.mm.plugin.sight.base.b)localObject1).videoBitrate;
              paramArrayOfObject.gkk = ((com.tencent.mm.plugin.sight.base.b)localObject1).audioBitrate;
              paramArrayOfObject.gkl = ((com.tencent.mm.plugin.sight.base.b)localObject1).frameRate;
              paramArrayOfObject.gkm = ((com.tencent.mm.plugin.sight.base.b)localObject1).width;
              paramArrayOfObject.gkn = ((com.tencent.mm.plugin.sight.base.b)localObject1).height;
              paramArrayOfObject.gkp = ((com.tencent.mm.plugin.sight.base.b)localObject1).audioChannel;
            }
            paramArrayOfObject.gkh = paramd.field_fileLength;
            paramArrayOfObject = paramArrayOfObject.Cl(paramh.url);
            f.bkh();
            paramArrayOfObject = paramArrayOfObject.Cm(a.Vu(paramh.field_fullpath));
            paramArrayOfObject.gkf = paramd.field_startTime;
            paramArrayOfObject.gkg = paramd.field_endTime;
            paramArrayOfObject = paramArrayOfObject.Cn(str1);
            paramArrayOfObject.gkq = k;
            paramArrayOfObject.gkr = localPInt2.value;
            paramArrayOfObject.bpa();
            break;
            l2 = 0L;
            break label2220;
            l2 = 0L;
            break label2287;
            l2 = 0L;
            break label2352;
          }
        }
        label2220:
        label2352:
        paramArrayOfObject = new kz((String)localObject2);
        label2705:
        label2711:
        label2717:
        paramArrayOfObject.gPT = i5;
        paramArrayOfObject.BO((String)localObject1);
        paramArrayOfObject.gPR = i6;
        paramArrayOfObject.gKl = paramd.traceId;
        paramArrayOfObject.BP(paramd.field_videoFlag);
        paramArrayOfObject.BQ(paramd.field_videoCdnMsg);
        if (paramd.svrFallbackCount > 0) {}
        for (i = 1;; i = 0)
        {
          paramArrayOfObject.gKn = i;
          Log.d("13790", "report 13790 value: " + paramArrayOfObject.agH());
          Log.d("13790", "trace id  " + (paramd.traceId & 0xFFFFFFFF) + " videoflag " + paramArrayOfObject.gKm + " " + paramArrayOfObject.gAG + " " + paramArrayOfObject.gKn);
          paramArrayOfObject.bpa();
          break;
        }
        label2903:
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 133L, 1L, false);
      }
      label2920:
      localObject1 = "";
      continue;
      label2928:
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
  
  private static boolean a(bp parambp, String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(126739);
    if (paramString1 == null)
    {
      AppMethodBeat.o(126739);
      return false;
    }
    try
    {
      paramString1 = new URL(paramString1);
      if (parambp == null)
      {
        AppMethodBeat.o(126739);
        return false;
      }
      if (paramString2 == null)
      {
        AppMethodBeat.o(126739);
        return false;
      }
      int i = paramString2.indexOf(paramString1.getHost());
      if (i == -1)
      {
        AppMethodBeat.o(126739);
        return false;
      }
      i = parambp.time;
      if (i == 0)
      {
        AppMethodBeat.o(126739);
        return false;
      }
      long l = Util.secondsToNow(parambp.time);
      if (l > paramLong)
      {
        AppMethodBeat.o(126739);
        return true;
      }
      AppMethodBeat.o(126739);
      return false;
    }
    catch (Exception parambp)
    {
      Log.e("MicroMsg.OnlineVideoService", "error for check dcip %s", new Object[] { parambp.getMessage() });
      AppMethodBeat.o(126739);
    }
    return false;
  }
  
  private static boolean i(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(126736);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(126736);
      return false;
    }
    s.bqB();
    paramString2 = x.XT(paramString2);
    if ((Util.isNullOrNil(paramString1)) || (paramInt <= 0) || (Util.isNullOrNil(paramString2)))
    {
      Log.w("MicroMsg.OnlineVideoService", "insert media duplication but args is error.[%d, %s, %s]", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
      AppMethodBeat.o(126736);
      return false;
    }
    boolean bool = ((com.tencent.mm.plugin.s.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.s.a.a.class)).bbT().U(paramString1, paramInt, paramString2);
    AppMethodBeat.o(126736);
    return bool;
  }
  
  public static int s(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126729);
    f.bkh();
    int i = a.requestVideoData(paramString, paramInt1, paramInt2, 0);
    Log.i("MicroMsg.OnlineVideoService", "request video video[%s], offset[%d], length[%d] duration[%d] ret[%d]", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0), Integer.valueOf(i) });
    AppMethodBeat.o(126729);
    return i;
  }
  
  public static void s(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(126740);
    if (paramArrayOfInt == null)
    {
      AppMethodBeat.o(126740);
      return;
    }
    com.tencent.mm.plugin.report.service.h.IzE.a(17891, new Object[] { Integer.valueOf(paramArrayOfInt[6]), Integer.valueOf(paramArrayOfInt[8]), Integer.valueOf(paramArrayOfInt[9]), Integer.valueOf(paramArrayOfInt[7]), Integer.valueOf(paramArrayOfInt[10]), Integer.valueOf(paramArrayOfInt[11]), Integer.valueOf(paramArrayOfInt[12]), Integer.valueOf(paramArrayOfInt[13]), Integer.valueOf(paramArrayOfInt[14]), Integer.valueOf(paramArrayOfInt[15]), Integer.valueOf(paramArrayOfInt[0]), Integer.valueOf(paramArrayOfInt[1]), Integer.valueOf(paramArrayOfInt[2]), Integer.valueOf(paramArrayOfInt[3]), Integer.valueOf(paramArrayOfInt[4]), Integer.valueOf(paramArrayOfInt[5]), Integer.valueOf(paramArrayOfInt[16]), Integer.valueOf(paramArrayOfInt[17]), Integer.valueOf(paramArrayOfInt[18]), Integer.valueOf(paramArrayOfInt[19]), Integer.valueOf(paramArrayOfInt[20]), Integer.valueOf(paramArrayOfInt[21]), Integer.valueOf(paramArrayOfInt[22]), Integer.valueOf(paramArrayOfInt[23]), Integer.valueOf(paramArrayOfInt[24]), Integer.valueOf(paramArrayOfInt[25]), Integer.valueOf(paramArrayOfInt[26]), Integer.valueOf(paramArrayOfInt[27]), Integer.valueOf(paramArrayOfInt[28]), Integer.valueOf(paramArrayOfInt[29]), Integer.valueOf(paramArrayOfInt[30]), Integer.valueOf(paramArrayOfInt[31]), Integer.valueOf(paramArrayOfInt[32]), Integer.valueOf(paramArrayOfInt[33]) });
    AppMethodBeat.o(126740);
  }
  
  public final int a(final String paramString, final com.tencent.mm.i.c paramc, final com.tencent.mm.i.d paramd)
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
    com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(169094);
        Object localObject = (com.tencent.mm.i.h)e.d(e.this).get(paramString);
        if (localObject == null)
        {
          if (paramString.contains("AdLandingGeneralVideo_"))
          {
            com.tencent.mm.plugin.report.service.h.IzE.el(1579, 11);
            Log.e("MicroMsg.OnlineVideoService", "download adLandingGeneralVideo task callback but task is null, %s, %s", new Object[] { paramString, Integer.valueOf(e.this.hashCode()) });
          }
          AppMethodBeat.o(169094);
          return;
        }
        if (((com.tencent.mm.i.h)localObject).iVn != null)
        {
          Log.i("MicroMsg.OnlineVideoService", "cdn callback %s route to videoCallback", new Object[] { paramString });
          if (paramc != null)
          {
            ((com.tencent.mm.i.h)localObject).iVn.h(paramString, paramc.field_finishedLength, paramc.field_toltalLength);
            AppMethodBeat.o(169094);
            return;
          }
          if (paramd != null)
          {
            Log.i("MicroMsg.OnlineVideoService", "cdn callback %s route to videoCallback, sceneResult.retCode:%s", new Object[] { paramString, Integer.valueOf(paramd.field_retCode) });
            ((com.tencent.mm.i.h)localObject).iVn.a(paramString, paramd.field_retCode, paramd);
            e.d(e.this).remove(paramString);
            if (paramd.field_retCode == 0)
            {
              e.e(e.this).put(((com.tencent.mm.i.h)localObject).field_mediaId, localObject);
              e.f(e.this).put(((com.tencent.mm.i.h)localObject).field_mediaId, paramd);
            }
            AppMethodBeat.o(169094);
            return;
          }
          AppMethodBeat.o(169094);
          return;
        }
        w localw = y.Yk(((com.tencent.mm.i.h)localObject).filename);
        if (localw == null)
        {
          Log.w("MicroMsg.OnlineVideoService", "stream download video callback, but video info is null.[%s]", new Object[] { ((com.tencent.mm.i.h)localObject).filename });
          AppMethodBeat.o(169094);
          return;
        }
        if (((com.tencent.mm.i.h)localObject).iUG != null)
        {
          ((com.tencent.mm.i.h)localObject).iUG.a(paramString, 0, paramc, paramd, ((com.tencent.mm.i.h)localObject).field_onlycheckexist);
          if (paramd != null) {
            e.d(e.this).remove(paramString);
          }
          AppMethodBeat.o(169094);
          return;
        }
        if (paramc != null)
        {
          if (paramc.field_finishedLength == localw.lAW)
          {
            Log.i("MicroMsg.OnlineVideoService", "stream download finish.");
            AppMethodBeat.o(169094);
            return;
          }
          if ((localw.status != 130) && (localw.mhM > paramc.field_finishedLength))
          {
            Log.w("MicroMsg.OnlineVideoService", "set video error. db now size %d, cdn callback %d.", new Object[] { Integer.valueOf(localw.mhM), Long.valueOf(paramc.field_finishedLength) });
            AppMethodBeat.o(169094);
            return;
          }
          Log.i("MicroMsg.OnlineVideoService", "callback progress info " + paramc.field_finishedLength);
          localw.mhP = Util.nowSecond();
          localw.mhM = ((int)paramc.field_finishedLength);
          localw.cUP = 1040;
          y.f(localw);
          localObject = new pn();
          ((pn)localObject).fOh.fDn = 5;
          ((pn)localObject).fOh.mediaId = paramString;
          ((pn)localObject).fOh.offset = ((int)paramc.field_finishedLength);
          ((pn)localObject).fOh.length = ((int)paramc.field_toltalLength);
          EventCenter.instance.publish((IEvent)localObject);
          AppMethodBeat.o(169094);
          return;
        }
        if (paramd != null)
        {
          Log.i("MicroMsg.OnlineVideoService", "callback result info " + paramd.field_retCode + ", filesize:" + paramd.field_fileLength + ",recved:" + paramd.field_recvedBytes);
          if (paramd.field_retCode == 0) {
            break label836;
          }
          if (paramd.field_retCode != -10012) {
            y.Yb(localw.getFileName());
          }
          e.e(((com.tencent.mm.i.h)localObject).arP(), paramd.field_retCode, ((com.tencent.mm.i.h)localObject).iVd);
        }
        for (;;)
        {
          localObject = new pn();
          ((pn)localObject).fOh.fDn = 4;
          ((pn)localObject).fOh.mediaId = paramString;
          ((pn)localObject).fOh.offset = 0;
          ((pn)localObject).fOh.retCode = paramd.field_retCode;
          ((pn)localObject).fOh.length = ((int)paramd.field_fileLength);
          EventCenter.instance.publish((IEvent)localObject);
          e.d(e.this).remove(paramString);
          AppMethodBeat.o(169094);
          return;
          label836:
          e.b(localw, (int)paramd.field_fileLength, ((com.tencent.mm.i.h)localObject).iVb);
          e.e(e.this).put(((com.tencent.mm.i.h)localObject).field_mediaId, localObject);
          e.f(e.this).put(((com.tencent.mm.i.h)localObject).field_mediaId, paramd);
        }
      }
    });
    if (this.lHS.get(paramString) != null)
    {
      AppMethodBeat.o(126734);
      return 1;
    }
    AppMethodBeat.o(126734);
    return 0;
  }
  
  public final boolean a(final com.tencent.mm.i.h paramh, boolean paramBoolean)
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
    paramh.gbt = false;
    if ((l(paramh.field_mediaId, null)) || (paramBoolean)) {
      com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126713);
          e.a(e.this).add(paramh.field_mediaId);
          e.b(e.this).put(paramh.field_mediaId, paramh);
          e.this.go(false);
          AppMethodBeat.o(126713);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(126724);
      return true;
      com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126714);
          e.a(e.this).add(paramh.field_mediaId);
          e.b(e.this).put(paramh.field_mediaId, paramh);
          e.this.go(false);
          AppMethodBeat.o(126714);
        }
      });
    }
  }
  
  public final boolean a(final String paramString, final e.a parama)
  {
    AppMethodBeat.i(169096);
    boolean bool1 = false;
    boolean bool2 = false;
    if (!Util.isNullOrNil(paramString)) {
      if (!this.lHS.containsKey(paramString)) {
        break label90;
      }
    }
    for (bool1 = true;; bool1 = bool2)
    {
      com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126718);
          Object localObject1 = (com.tencent.mm.i.h)e.d(e.this).remove(paramString);
          Object localObject2;
          int i;
          if (localObject1 != null)
          {
            localObject2 = new com.tencent.mm.i.d();
            f.bkh();
            i = a.c(((com.tencent.mm.i.h)localObject1).field_mediaId, (com.tencent.mm.i.d)localObject2);
            if (i == 0) {
              e.a(this.lIJ, (com.tencent.mm.i.d)localObject2, (com.tencent.mm.i.h)localObject1, false);
            }
          }
          for (;;)
          {
            e.b(e.this).remove(paramString);
            if (parama != null) {
              parama.a((com.tencent.mm.i.h)localObject1, (com.tencent.mm.i.d)localObject2);
            }
            AppMethodBeat.o(126718);
            return;
            Log.w("MicroMsg.OnlineVideoService", "stop video stream download error. ret %d, mediaId %s", new Object[] { Integer.valueOf(i), ((com.tencent.mm.i.h)localObject1).field_mediaId });
            continue;
            com.tencent.mm.i.h localh = (com.tencent.mm.i.h)e.e(e.this).remove(paramString);
            com.tencent.mm.i.d locald = (com.tencent.mm.i.d)e.f(e.this).remove(paramString);
            localObject1 = localh;
            localObject2 = locald;
            if (localh != null)
            {
              localObject1 = localh;
              localObject2 = locald;
              if (locald != null)
              {
                e.a(this.lIJ, locald, localh, true);
                localObject1 = localh;
                localObject2 = locald;
              }
            }
          }
        }
      });
      Log.i("MicroMsg.OnlineVideoService", "cancelDownloadTaskWithCallback mediaId : " + paramString + " remove : " + bool1);
      AppMethodBeat.o(169096);
      return bool1;
      label90:
      f.bkg().Vz(paramString);
    }
  }
  
  public final int d(final String paramString1, final int paramInt1, final int paramInt2, final String paramString2)
  {
    AppMethodBeat.i(216011);
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
        com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
        {
          public final void run()
          {
            boolean bool2 = true;
            AppMethodBeat.i(169095);
            com.tencent.mm.i.h localh = (com.tencent.mm.i.h)e.d(e.this).get(e.10.this.acq);
            Object localObject = new StringBuilder("info=").append(localh).append(" mediaId=").append(e.10.this.acq).append(" info.videoCallback=");
            if ((localh != null) && (localh.iVn == null)) {}
            for (boolean bool1 = true;; bool1 = false)
            {
              Log.w("MicroMsg.OnlineVideoService", bool1);
              if (localh == null) {
                break label502;
              }
              localh.iVj = e.10.this.lIG;
              if (localh.iVn == null) {
                break;
              }
              localh.iVn.a(e.10.this.acq, e.10.this.lIG, e.10.this.lIH, e.10.this.lIL);
              AppMethodBeat.o(169095);
              return;
            }
            if (com.tencent.mm.modelvideo.v.XI(localh.field_fullpath))
            {
              Log.w("MicroMsg.OnlineVideoService", "it is qt video, need finish all file. isPlayMode" + localh.iVd);
              if (localh.iVd == 1)
              {
                e.s(localh.field_mediaId, 0, localh.field_totalLen);
                e.bkc();
              }
              AppMethodBeat.o(169095);
              return;
            }
            localObject = new pn();
            ((pn)localObject).fOh.fDn = 1;
            ((pn)localObject).fOh.retCode = 0;
            ((pn)localObject).fOh.mediaId = e.10.this.acq;
            ((pn)localObject).fOh.offset = e.10.this.lIG;
            ((pn)localObject).fOh.length = e.10.this.lIH;
            ((pn)localObject).fOh.fOi = localh.iVa;
            pn.a locala = ((pn)localObject).fOh;
            if (localh.iUH > 0) {}
            for (bool1 = bool2;; bool1 = false)
            {
              locala.fOj = bool1;
              EventCenter.instance.publish((IEvent)localObject);
              localObject = y.Yk(localh.filename);
              if (localObject == null) {
                break label496;
              }
              Log.i("MicroMsg.OnlineVideoService", "on moov ready info: " + ((w)localObject).getFileName() + " status : " + ((w)localObject).status);
              if (((w)localObject).status != 130) {
                break;
              }
              AppMethodBeat.o(169095);
              return;
            }
            if (((w)localObject).status != 122)
            {
              localObject = y.Yk(localh.filename);
              if (localObject != null)
              {
                ((w)localObject).status = 121;
                ((w)localObject).cUP = 256;
                s.bqB().c((w)localObject);
              }
              if (localh.iVd == 0)
              {
                Log.i("MicroMsg.OnlineVideoService", "stop download video");
                s.bqG().brd();
                s.bqG().run();
              }
            }
            label496:
            AppMethodBeat.o(169095);
            return;
            label502:
            if (e.10.this.acq.contains("AdLandingGeneralVideo_"))
            {
              com.tencent.mm.plugin.report.service.h.IzE.el(1579, 12);
              Log.e("MicroMsg.OnlineVideoService", "download adLandingGeneralVideo task onMoovReady but task is null, %s, %s", new Object[] { e.10.this.acq, Integer.valueOf(e.this.hashCode()) });
            }
            AppMethodBeat.o(169095);
          }
        });
        AppMethodBeat.o(126719);
      }
    });
    if (this.lHS.containsKey(paramString1))
    {
      AppMethodBeat.o(216011);
      return 1;
    }
    AppMethodBeat.o(216011);
    return 0;
  }
  
  public final boolean e(final com.tencent.mm.i.h paramh)
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
    paramh.gbt = false;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126715);
          e.c(e.this).removeCallbacksAndMessages(paramh.field_mediaId);
          e.a(e.this).add(paramh.field_mediaId);
          e.b(e.this).put(paramh.field_mediaId, paramh);
          e.this.go(false);
          AppMethodBeat.o(126715);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(126725);
      return true;
      this.knk.removeCallbacksAndMessages(paramh.field_mediaId);
      this.lHQ.add(paramh.field_mediaId);
      this.lHR.put(paramh.field_mediaId, paramh);
      go(false);
    }
  }
  
  public final void go(boolean paramBoolean)
  {
    AppMethodBeat.i(126730);
    if (!com.tencent.mm.kernel.h.aHB())
    {
      AppMethodBeat.o(126730);
      return;
    }
    if ((!paramBoolean) && (f.bkh().bjW()))
    {
      com.tencent.mm.kernel.h.aHE();
      if (com.tencent.mm.kernel.b.aGL())
      {
        Log.w("MicroMsg.OnlineVideoService", "cdn engine not init cdn dnsinfo , will retry after set info");
        f.bkg().go(paramBoolean);
        AppMethodBeat.o(126730);
        return;
      }
    }
    f.bkg().bjX();
    while (!this.lHQ.isEmpty())
    {
      String str = (String)this.lHQ.poll();
      Object localObject1 = (com.tencent.mm.i.h)this.lHR.remove(str);
      if (localObject1 != null)
      {
        ((com.tencent.mm.i.h)localObject1).field_startTime = Util.nowMilliSecond();
        if (!((com.tencent.mm.i.h)localObject1).gbt)
        {
          if (((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VmD, Integer.valueOf(-1))).intValue() == 2) {
            Log.i("MicroMsg.OnlineVideoService", "command set do not check media duplication.");
          }
          label167:
          Object localObject3;
          int j;
          for (int i = 0;; i = 1)
          {
            if (i == 0) {
              break label410;
            }
            localObject1 = new pn();
            ((pn)localObject1).fOh.fDn = 6;
            ((pn)localObject1).fOh.mediaId = str;
            EventCenter.instance.publish((IEvent)localObject1);
            break;
            if (((com.tencent.mm.i.h)localObject1).arQ()) {
              break label167;
            }
            localObject2 = ((com.tencent.mm.i.h)localObject1).iVb;
            i = ((com.tencent.mm.i.h)localObject1).iVc;
            localObject3 = ((com.tencent.mm.plugin.s.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.s.a.a.class)).bbT().hA((String)localObject2, i);
            j = i - (int)u.bBQ((String)localObject3);
            if ((Util.isNullOrNil((String)localObject3)) || (j < 0) || (j > 16)) {
              break label167;
            }
            Log.i("MicroMsg.OnlineVideoService", "it had download this video[%d, %s, %s].", new Object[] { Integer.valueOf(i), localObject2, localObject3 });
            u.on((String)localObject3, ((com.tencent.mm.i.h)localObject1).field_fullpath);
            localObject3 = y.Yk(((com.tencent.mm.i.h)localObject1).filename);
            a((w)localObject3, i, (String)localObject2);
            localObject2 = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(((w)localObject3).mhR);
            ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(new i.c(((et)localObject2).field_talker, "update", (ca)localObject2));
          }
          label410:
          if (((com.tencent.mm.i.h)localObject1).arP())
          {
            i = f.bkh().a((com.tencent.mm.i.g)localObject1, ((com.tencent.mm.i.h)localObject1).iVd);
            label432:
            Log.i("MicroMsg.OnlineVideoService", "start task %s streaming download. ret %d ", new Object[] { localObject1, Integer.valueOf(i) });
            if (i == 0) {
              break label1304;
            }
            Log.w("MicroMsg.OnlineVideoService", "start stream video error. ret : " + i + " media id: " + ((com.tencent.mm.i.h)localObject1).field_mediaId);
            paramBoolean = ((com.tencent.mm.i.h)localObject1).arP();
            j = ((com.tencent.mm.i.h)localObject1).iVd;
            if (!paramBoolean) {
              break label1214;
            }
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 3L, 1L, false);
            if (j != 1) {
              break label1149;
            }
            if (i != -21006) {
              break label1108;
            }
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 100L, 1L, false);
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.IzE.a(13836, new Object[] { Integer.valueOf(100), Long.valueOf(Util.nowSecond()), "" });
            break;
            if (((com.tencent.mm.i.h)localObject1).arN())
            {
              ((com.tencent.mm.i.h)localObject1).connectionCount = 2;
              i = f.bkh().a((com.tencent.mm.i.h)localObject1);
              break label432;
            }
            if (((com.tencent.mm.i.h)localObject1).arS())
            {
              ((com.tencent.mm.i.h)localObject1).connectionCount = 4;
              i = f.bkh().b((com.tencent.mm.i.h)localObject1);
              break label432;
            }
            if (((com.tencent.mm.i.h)localObject1).arT())
            {
              i = f.bkh().c((com.tencent.mm.i.h)localObject1);
              break label432;
            }
            if (((com.tencent.mm.i.h)localObject1).arO())
            {
              i = f.bkh().d((com.tencent.mm.i.h)localObject1);
              break label432;
            }
            if ((((com.tencent.mm.i.h)localObject1).arR()) && (((com.tencent.mm.i.h)localObject1).arV()))
            {
              localObject2 = f.bkh();
              localObject3 = new CdnLogic.C2CDownloadRequest();
              ((CdnLogic.C2CDownloadRequest)localObject3).fileType = 20210;
              ((CdnLogic.C2CDownloadRequest)localObject3).fileKey = ((com.tencent.mm.i.h)localObject1).field_mediaId;
              ((CdnLogic.C2CDownloadRequest)localObject3).url = ((com.tencent.mm.i.h)localObject1).url;
              ((CdnLogic.C2CDownloadRequest)localObject3).referer = ((com.tencent.mm.i.h)localObject1).referer;
              ((CdnLogic.C2CDownloadRequest)localObject3).setSavePath(((com.tencent.mm.i.h)localObject1).field_fullpath);
              ((CdnLogic.C2CDownloadRequest)localObject3).fileSize = 0;
              ((CdnLogic.C2CDownloadRequest)localObject3).isColdSnsData = ((com.tencent.mm.i.h)localObject1).isColdSnsData;
              ((CdnLogic.C2CDownloadRequest)localObject3).isHotSnsVideo = ((com.tencent.mm.i.h)localObject1).isHotSnsVideo;
              ((CdnLogic.C2CDownloadRequest)localObject3).isHLSVideo = ((com.tencent.mm.i.h)localObject1).isHLSVideo;
              ((CdnLogic.C2CDownloadRequest)localObject3).hlsVideoFlag = ((com.tencent.mm.i.h)localObject1).hlsVideoFlag;
              ((CdnLogic.C2CDownloadRequest)localObject3).signalQuality = ((com.tencent.mm.i.h)localObject1).signalQuality;
              ((CdnLogic.C2CDownloadRequest)localObject3).snsScene = ((com.tencent.mm.i.h)localObject1).snsScene;
              ((CdnLogic.C2CDownloadRequest)localObject3).preloadRatio = ((com.tencent.mm.i.h)localObject1).field_preloadRatio;
              ((CdnLogic.C2CDownloadRequest)localObject3).preloadMinSize = ((com.tencent.mm.i.h)localObject1).preloadMinSize;
              ((CdnLogic.C2CDownloadRequest)localObject3).requestVideoFormat = ((com.tencent.mm.i.h)localObject1).field_requestVideoFormat;
              ((CdnLogic.C2CDownloadRequest)localObject3).connectionCount = ((com.tencent.mm.i.h)localObject1).connectionCount;
              ((CdnLogic.C2CDownloadRequest)localObject3).concurrentCount = ((com.tencent.mm.i.h)localObject1).concurrentCount;
              if ((ac.mGf) && (ac.mGk.length() > 0))
              {
                ((CdnLogic.C2CDownloadRequest)localObject3).debugIP = ac.mGk;
                Log.w("MicroMsg.CdnTransportEngine", "debugip " + ((CdnLogic.C2CDownloadRequest)localObject3).debugIP);
              }
              i = CdnLogic.startSNSDownload((CdnLogic.C2CDownloadRequest)localObject3, (CdnLogic.VideoStreamingCallback)localObject2, (CdnLogic.DownloadCallback)localObject2, ((com.tencent.mm.i.h)localObject1).iVd);
              break label432;
            }
            localObject2 = f.bkh();
            localObject3 = new CdnLogic.C2CDownloadRequest();
            ((CdnLogic.C2CDownloadRequest)localObject3).fileKey = ((com.tencent.mm.i.h)localObject1).field_mediaId;
            ((CdnLogic.C2CDownloadRequest)localObject3).url = ((com.tencent.mm.i.h)localObject1).url;
            ((CdnLogic.C2CDownloadRequest)localObject3).referer = ((com.tencent.mm.i.h)localObject1).referer;
            ((CdnLogic.C2CDownloadRequest)localObject3).setSavePath(((com.tencent.mm.i.h)localObject1).field_fullpath);
            ((CdnLogic.C2CDownloadRequest)localObject3).fileSize = 0;
            ((CdnLogic.C2CDownloadRequest)localObject3).fileType = 20210;
            ((CdnLogic.C2CDownloadRequest)localObject3).concurrentCount = 10;
            ((CdnLogic.C2CDownloadRequest)localObject3).preloadRatio = ((com.tencent.mm.i.h)localObject1).field_preloadRatio;
            ((CdnLogic.C2CDownloadRequest)localObject3).preloadMinSize = ((com.tencent.mm.i.h)localObject1).preloadMinSize;
            if ((ac.mGf) && (ac.mGk.length() > 0))
            {
              ((CdnLogic.C2CDownloadRequest)localObject3).debugIP = ac.mGk;
              Log.w("MicroMsg.CdnTransportEngine", "debugip " + ((CdnLogic.C2CDownloadRequest)localObject3).debugIP);
            }
            i = CdnLogic.startHttpVideoStreamingDownload((CdnLogic.C2CDownloadRequest)localObject3, (CdnLogic.VideoStreamingCallback)localObject2, (CdnLogic.DownloadCallback)localObject2, ((com.tencent.mm.i.h)localObject1).iVd);
            break label432;
            label1108:
            if (i == -20003)
            {
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 101L, 1L, false);
            }
            else
            {
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 102L, 1L, false);
              continue;
              label1149:
              if (i == -21006) {
                com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 106L, 1L, false);
              } else if (i == -20003) {
                com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 107L, 1L, false);
              } else {
                com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 108L, 1L, false);
              }
            }
          }
          label1214:
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 210L, 1L, false);
          if (j == 1) {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 211L, 1L, false);
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.IzE.a(13836, new Object[] { Integer.valueOf(200), Long.valueOf(Util.nowSecond()), "" });
            break;
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 212L, 1L, false);
          }
          label1304:
          ((com.tencent.mm.i.h)localObject1).iVa = Util.nowMilliSecond();
          if (((com.tencent.mm.i.h)localObject1).arP())
          {
            localObject2 = y.Yk(((com.tencent.mm.i.h)localObject1).filename);
            if (localObject2 != null)
            {
              i = ((w)localObject2).status;
              if ((i != 120) && (i != 122) && (i != 121))
              {
                ((w)localObject2).status = 120;
                ((w)localObject2).cUP = 256;
                s.bqB().c((w)localObject2);
              }
            }
          }
          this.lHS.put(((com.tencent.mm.i.h)localObject1).field_mediaId, localObject1);
          Object localObject2 = new pn();
          ((pn)localObject2).fOh.fDn = 7;
          ((pn)localObject2).fOh.mediaId = str;
          ((pn)localObject2).fOh.fOi = ((com.tencent.mm.i.h)localObject1).iVa;
          EventCenter.instance.publish((IEvent)localObject2);
        }
      }
    }
    AppMethodBeat.o(126730);
  }
  
  public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126728);
    if ((com.tencent.mm.i.h)this.lHS.get(paramString) == null)
    {
      Log.i("MicroMsg.OnlineVideoService", "this media[%s] don't download now.", new Object[] { paramString });
      AppMethodBeat.o(126728);
      return false;
    }
    f.bkh();
    boolean bool = a.isVideoDataAvailable(paramString, paramInt1, paramInt2);
    Log.i("MicroMsg.OnlineVideoService", "is video[%s] data[%d, %d] available[%b]", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
    AppMethodBeat.o(126728);
    return bool;
  }
  
  public final boolean k(final String paramString, final Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(126726);
    boolean bool;
    if (!Util.isNullOrNil(paramString)) {
      if (this.lHS.containsKey(paramString))
      {
        bool = true;
        if ((!bool) || (Looper.myLooper() == Looper.getMainLooper())) {
          break label121;
        }
        this.knk.postAtTime(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(126716);
            com.tencent.mm.i.h localh = (com.tencent.mm.i.h)e.d(e.this).remove(paramString);
            com.tencent.mm.i.d locald;
            int i;
            if (localh != null)
            {
              locald = new com.tencent.mm.i.d();
              f.bkh();
              i = a.c(localh.field_mediaId, locald);
              if (i == 0) {
                e.a(paramArrayOfObject, locald, localh, false);
              }
            }
            for (;;)
            {
              e.b(e.this).remove(paramString);
              AppMethodBeat.o(126716);
              return;
              Log.w("MicroMsg.OnlineVideoService", "stop video stream download error. ret %d, mediaId %s", new Object[] { Integer.valueOf(i), localh.field_mediaId });
              continue;
              localh = (com.tencent.mm.i.h)e.e(e.this).remove(paramString);
              locald = (com.tencent.mm.i.d)e.f(e.this).remove(paramString);
              if ((localh != null) && (locald != null)) {
                e.a(paramArrayOfObject, locald, localh, true);
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
      f.bkg().Vz(paramString);
      bool = false;
      break;
      label121:
      this.knk.removeCallbacksAndMessages(paramString);
      com.tencent.mm.i.h localh = (com.tencent.mm.i.h)this.lHS.remove(paramString);
      com.tencent.mm.i.d locald;
      int i;
      if (localh != null)
      {
        locald = new com.tencent.mm.i.d();
        f.bkh();
        i = a.c(localh.field_mediaId, locald);
        if (i == 0) {
          a(paramArrayOfObject, locald, localh, false);
        }
      }
      for (;;)
      {
        this.lHR.remove(paramString);
        break;
        Log.w("MicroMsg.OnlineVideoService", "stop video stream download error. ret %d, mediaId %s", new Object[] { Integer.valueOf(i), localh.field_mediaId });
        continue;
        localh = (com.tencent.mm.i.h)this.lID.remove(paramString);
        locald = (com.tencent.mm.i.d)this.lIE.remove(paramString);
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
      if (!this.lHS.containsKey(paramString)) {
        break label90;
      }
    }
    for (bool1 = true;; bool1 = bool2)
    {
      com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126717);
          com.tencent.mm.i.h localh = (com.tencent.mm.i.h)e.d(e.this).remove(paramString);
          com.tencent.mm.i.d locald;
          int i;
          if (localh != null)
          {
            locald = new com.tencent.mm.i.d();
            f.bkh();
            i = a.c(localh.field_mediaId, locald);
            if (i == 0) {
              e.a(paramArrayOfObject, locald, localh, false);
            }
          }
          for (;;)
          {
            e.b(e.this).remove(paramString);
            AppMethodBeat.o(126717);
            return;
            Log.w("MicroMsg.OnlineVideoService", "stop video stream download error. ret %d, mediaId %s", new Object[] { Integer.valueOf(i), localh.field_mediaId });
            continue;
            localh = (com.tencent.mm.i.h)e.e(e.this).remove(paramString);
            locald = (com.tencent.mm.i.d)e.f(e.this).remove(paramString);
            if ((localh != null) && (locald != null)) {
              e.a(paramArrayOfObject, locald, localh, true);
            }
          }
        }
      });
      Log.i("MicroMsg.OnlineVideoService", "cancelDownloadTask mediaId : " + paramString + " remove : " + bool1);
      AppMethodBeat.o(126727);
      return bool1;
      label90:
      f.bkg().Vz(paramString);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(126723);
    if (paramq.getType() != 379)
    {
      AppMethodBeat.o(126723);
      return;
    }
    Log.i("MicroMsg.OnlineVideoService", "it get cdn dns success[%d, %d], try to start.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (com.tencent.mm.kernel.h.aHE().aGM()) {
      com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126711);
          e.this.go(true);
          AppMethodBeat.o(126711);
        }
      });
    }
    AppMethodBeat.o(126723);
  }
  
  public final int q(final String paramString, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(216012);
    Log.i("MicroMsg.OnlineVideoService", "onDataAvailable. offset %d, length %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(216012);
      return 0;
    }
    com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126720);
        Object localObject = (com.tencent.mm.i.h)e.d(e.this).get(paramString);
        if (localObject != null)
        {
          if (((com.tencent.mm.i.h)localObject).iVn != null) {
            ((com.tencent.mm.i.h)localObject).iVn.onDataAvailable(paramString, paramInt1, paramInt2);
          }
          localObject = new pn();
          ((pn)localObject).fOh.fDn = 2;
          ((pn)localObject).fOh.retCode = 0;
          ((pn)localObject).fOh.mediaId = paramString;
          ((pn)localObject).fOh.offset = paramInt1;
          ((pn)localObject).fOh.length = paramInt2;
          EventCenter.instance.publish((IEvent)localObject);
        }
        AppMethodBeat.o(126720);
      }
    });
    if (this.lHS.containsKey(paramString))
    {
      AppMethodBeat.o(216012);
      return 1;
    }
    AppMethodBeat.o(216012);
    return 0;
  }
  
  public final int r(final String paramString, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(216013);
    Log.i("MicroMsg.OnlineVideoService", "onDownloadToEnd. offset %d, length %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(216013);
      return 0;
    }
    com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126712);
        com.tencent.mm.i.h localh = (com.tencent.mm.i.h)e.d(e.this).get(paramString);
        if (localh != null)
        {
          pn localpn = new pn();
          localpn.fOh.fDn = 3;
          localpn.fOh.retCode = 0;
          localpn.fOh.mediaId = paramString;
          localpn.fOh.offset = paramInt1;
          localpn.fOh.length = paramInt2;
          EventCenter.instance.publish(localpn);
          if ((paramInt1 == 0) && (paramInt2 >= localh.iVc)) {
            e.b(y.Yk(localh.filename), localh.iVc, localh.iVb);
          }
        }
        AppMethodBeat.o(126712);
      }
    });
    if (this.lHS.containsKey(paramString))
    {
      AppMethodBeat.o(216013);
      return 1;
    }
    AppMethodBeat.o(216013);
    return 0;
  }
  
  public final void release()
  {
    AppMethodBeat.i(126722);
    com.tencent.mm.kernel.h.aGY().b(379, this);
    AppMethodBeat.o(126722);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.aq.e
 * JD-Core Version:    0.7.0.1
 */