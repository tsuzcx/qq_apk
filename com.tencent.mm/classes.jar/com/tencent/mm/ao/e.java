package com.tencent.mm.ao;

import android.os.Looper;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.b.p;
import com.tencent.mm.g.a.lt;
import com.tencent.mm.g.a.nx;
import com.tencent.mm.g.a.nx.a;
import com.tencent.mm.g.b.a.dl;
import com.tencent.mm.g.b.a.fd;
import com.tencent.mm.g.b.a.fr;
import com.tencent.mm.g.b.a.hn;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.h;
import com.tencent.mm.i.h.a;
import com.tencent.mm.model.bj.b;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.modelvideo.y.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.bu;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class e
  implements com.tencent.mm.al.f, a.a
{
  ap gIf;
  Queue<String> hTI;
  Map<String, h> hTJ;
  Map<String, h> hTK;
  Map<String, h> hUv;
  Map<String, com.tencent.mm.i.d> hUw;
  private final ap hUx;
  
  public e()
  {
    AppMethodBeat.i(126721);
    this.hTI = new LinkedList();
    this.hTJ = new HashMap();
    this.hTK = new HashMap();
    this.hUv = new HashMap();
    this.hUw = new HashMap();
    this.hUx = new ap(Looper.getMainLooper());
    this.gIf = new ap(Looper.getMainLooper());
    com.tencent.mm.kernel.g.aiU().a(379, this);
    AppMethodBeat.o(126721);
  }
  
  public static h ES(String paramString)
  {
    AppMethodBeat.i(126737);
    if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(126737);
      return null;
    }
    s locals = u.Hy(paramString);
    if (locals == null)
    {
      AppMethodBeat.o(126737);
      return null;
    }
    Object localObject1 = bw.M(locals.aMV(), "msg");
    if (localObject1 == null)
    {
      ad.w("MicroMsg.OnlineVideoService", "cdntra parse video recv xml failed");
      AppMethodBeat.o(126737);
      return null;
    }
    Object localObject2 = (String)((Map)localObject1).get(".msg.videomsg.$cdnvideourl");
    if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil((String)localObject2))
    {
      ad.w("MicroMsg.OnlineVideoService", "cdntra parse video recv xml failed");
      AppMethodBeat.o(126737);
      return null;
    }
    int j = com.tencent.mm.sdk.platformtools.bt.getInt((String)((Map)localObject1).get(".msg.videomsg.$length"), 0);
    String str1 = (String)((Map)localObject1).get(".msg.videomsg.$md5");
    String str2 = (String)((Map)localObject1).get(".msg.videomsg.$aeskey");
    String str3 = (String)((Map)localObject1).get(".msg.videomsg.$fileparam");
    String str4 = c.a("downvideo", locals.createTime, locals.getUser(), locals.getFileName());
    if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(str4))
    {
      ad.w("MicroMsg.OnlineVideoService", "cdntra genClientId failed not use cdn file:%s", new Object[] { locals.getFileName() });
      AppMethodBeat.o(126737);
      return null;
    }
    o.aMJ();
    String str5 = t.Hh(paramString);
    localObject1 = new h();
    ((h)localObject1).fJi = "task_OnlineVideoService_1";
    ((h)localObject1).filename = paramString;
    ((h)localObject1).fJD = str1;
    ((h)localObject1).fJE = j;
    ((h)localObject1).fJF = 1;
    ((h)localObject1).dyU = locals.aMS();
    ((h)localObject1).fJG = locals.getUser();
    if (w.vF(locals.getUser()))
    {
      i = com.tencent.mm.model.q.yS(locals.getUser());
      ((h)localObject1).dyW = i;
      ((h)localObject1).field_mediaId = str4;
      ((h)localObject1).field_fullpath = str5;
      ((h)localObject1).field_fileType = com.tencent.mm.i.a.MediaType_VIDEO;
      ((h)localObject1).field_totalLen = j;
      ((h)localObject1).field_aesKey = str2;
      ((h)localObject1).field_fileId = ((String)localObject2);
      ((h)localObject1).field_priority = com.tencent.mm.i.a.fIw;
      ((h)localObject1).field_wxmsgparam = str3;
      if (!w.vF(locals.getUser())) {
        break label524;
      }
      i = 1;
      label374:
      ((h)localObject1).field_chattype = i;
      ((h)localObject1).fJH = locals.fJH;
      paramString = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().aI(locals.getUser(), locals.dAY);
      localObject2 = com.tencent.mm.model.bj.Bq(paramString.eLs);
      ((h)localObject1).fJk = 0;
      ((h)localObject1).fJl = 0;
      ((h)localObject1).fJJ = paramString.field_createTime;
      ((h)localObject1).dAY = paramString.field_msgSvrId;
      if (localObject2 == null) {
        break label529;
      }
    }
    label524:
    label529:
    for (int i = ((bj.b)localObject2).hHe;; i = 0)
    {
      ((h)localObject1).fJK = i;
      if (((h)localObject1).fJk > 0) {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 36L, 1L, false);
      }
      ((h)localObject1).field_autostart = false;
      ((h)localObject1).field_requestVideoFormat = com.tencent.mm.modelcontrol.d.a(1, locals);
      AppMethodBeat.o(126737);
      return localObject1;
      i = 0;
      break;
      i = 0;
      break label374;
    }
  }
  
  public static h a(com.tencent.mm.storage.bj parambj, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(126738);
    if (parambj == null)
    {
      ad.w("MicroMsg.OnlineVideoService", "check can sns online video, scene is null.");
      AppMethodBeat.o(126738);
      return null;
    }
    if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramString1))
    {
      ad.w("MicroMsg.OnlineVideoService", "check can sns online video, url is null.");
      AppMethodBeat.o(126738);
      return null;
    }
    Object localObject = u.Hy(paramString3);
    if (localObject == null)
    {
      ad.w("MicroMsg.OnlineVideoService", "check can sns online video, video info is null. %s", new Object[] { paramString3 });
      AppMethodBeat.o(126738);
      return null;
    }
    String str = c.a("snsvideo", parambj.hbR, "sns", paramString1);
    if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(str))
    {
      ad.w("MicroMsg.OnlineVideoService", "check can http online video, can not create media id. url %s ", new Object[] { paramString1 });
      AppMethodBeat.o(126738);
      return null;
    }
    h localh = new h();
    localh.fJi = "task_OnlineVideoService_2";
    localh.filename = paramString3;
    localh.field_fullpath = paramString2;
    localh.field_mediaId = str;
    localh.fJA = 2;
    localh.fJF = paramInt;
    localh.fJH = ((s)localObject).fJH;
    if (parambj == null) {
      paramString3 = "";
    }
    for (;;)
    {
      int i = com.tencent.mm.protocal.d.Fnj;
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajA();
      str = p.getString(com.tencent.mm.kernel.a.getUin());
      int j = ay.getNetTypeForStat(aj.getContext());
      int k = ay.getStrength(aj.getContext());
      label256:
      long l1;
      if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramString3))
      {
        localObject = "&scene=".concat(String.valueOf(paramString3));
        localh.referer = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d%s", new Object[] { Integer.valueOf(i), str, Integer.valueOf(j), Integer.valueOf(k), localObject });
        localh.url = paramString1;
        paramString1 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getValue("SnsSightDomainList");
        long l2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getInt("SnsSightMainStandbyIpSwitchTime", 0);
        ad.i("MicroMsg.OnlineVideoService", "hostvalue %s dcipTime %s scene.time[%d]", new Object[] { paramString1, Long.valueOf(l2), Integer.valueOf(parambj.hbR) });
        l1 = l2;
        if (l2 <= 0L) {
          l1 = 259200L;
        }
      }
      for (boolean bool = a(parambj, localh.url, l1, paramString1);; bool = false)
      {
        try
        {
          localh.host = new URL(localh.url).getHost();
          paramString1 = new ArrayList();
          com.tencent.mm.network.b.b(bool, paramString1, localh.host);
          localh.fJa = new String[paramString1.size()];
          paramString1.toArray(localh.fJa);
          if (com.tencent.mm.sdk.platformtools.bt.rM(parambj.hbR) <= l1) {
            continue;
          }
          bool = true;
          localh.isColdSnsData = bool;
          localh.signalQuality = ay.getStrength(aj.getContext());
          localh.snsScene = paramString3;
          localh.concurrentCount = 5;
          if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qpR, false)) {
            localh.field_requestVideoFormat = com.tencent.mm.modelcontrol.d.H(paramInt, paramString2);
          }
          AppMethodBeat.o(126738);
          return localh;
        }
        catch (Exception parambj)
        {
          ad.printErrStackTrace("MicroMsg.OnlineVideoService", parambj, "check can sns online video error taskInfo %s", new Object[] { localh });
          AppMethodBeat.o(126738);
          return null;
        }
        if (parambj.equals(com.tencent.mm.storage.bj.ILO))
        {
          paramString3 = "album_friend";
          break;
        }
        if (parambj.equals(com.tencent.mm.storage.bj.ILP))
        {
          paramString3 = "album_self";
          break;
        }
        if (parambj.equals(com.tencent.mm.storage.bj.ILQ))
        {
          paramString3 = "album_stranger";
          break;
        }
        if (parambj.equals(com.tencent.mm.storage.bj.ILR))
        {
          paramString3 = "profile_friend";
          break;
        }
        if (parambj.equals(com.tencent.mm.storage.bj.ILS))
        {
          paramString3 = "profile_stranger";
          break;
        }
        if (parambj.equals(com.tencent.mm.storage.bj.ILT))
        {
          paramString3 = "comment";
          break;
        }
        if (parambj.equals(com.tencent.mm.storage.bj.ILN))
        {
          paramString3 = "timeline";
          break;
        }
        if (parambj.equals(com.tencent.mm.storage.bj.ILW))
        {
          paramString3 = "snssight";
          break;
        }
        if (!parambj.equals(com.tencent.mm.storage.bj.ILY)) {
          break label781;
        }
        paramString3 = "storysight";
        break;
        localObject = "";
        break label256;
      }
      label781:
      paramString3 = "";
    }
  }
  
  static void a(s params, int paramInt, String paramString)
  {
    AppMethodBeat.i(126735);
    ad.i("MicroMsg.OnlineVideoService", "download finish. totalLen %d ", new Object[] { Integer.valueOf(paramInt) });
    if (params != null)
    {
      u.at(params.getFileName(), paramInt);
      i(paramInt, paramString, params.getFileName());
    }
    AppMethodBeat.o(126735);
  }
  
  private static void a(PInt paramPInt1, PInt paramPInt2, String paramString, int paramInt)
  {
    AppMethodBeat.i(126743);
    int j = 0;
    paramString = u.Hy(paramString);
    if (paramString != null) {
      j = paramString.dyZ;
    }
    for (int k = paramString.hMP;; k = 0)
    {
      if (paramInt <= 0)
      {
        i = 1;
        paramPInt1.value = j;
        paramPInt2.value = i;
        ad.d("MicroMsg.OnlineVideoService", "getPreloadVideoInfo pHadPreloadSize[%d] pHadPreloadCompletion[%d]", new Object[] { Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value) });
        AppMethodBeat.o(126743);
        return;
      }
      int m = (int)(paramInt / 100.0F * k);
      if (j < m) {}
      for (int i = 2;; i = 3)
      {
        ad.d("MicroMsg.OnlineVideoService", "getPreloadVideoInfo %d * %d = configSize[%d] preloadSize[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j) });
        break;
      }
    }
  }
  
  private static void a(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, long paramLong1, long paramLong2, String paramString4, String[] paramArrayOfString, String paramString5, int paramInt3, int paramInt4, String paramString6)
  {
    AppMethodBeat.i(126744);
    lt locallt = new lt();
    locallt.dyT.dyU = paramString1;
    locallt.dyT.dyV = paramString2;
    locallt.dyT.dyW = paramInt1;
    locallt.dyT.fileId = paramString3;
    locallt.dyT.netType = paramInt2;
    locallt.dyT.startTime = paramLong1;
    locallt.dyT.endTime = paramLong2;
    locallt.dyT.path = paramString4;
    locallt.dyT.dyX = paramArrayOfString;
    locallt.dyT.dyY = paramString5;
    locallt.dyT.dyZ = paramInt3;
    locallt.dyT.dza = paramInt4;
    locallt.dyT.dzb = paramString6;
    com.tencent.mm.sdk.b.a.IbL.l(locallt);
    AppMethodBeat.o(126744);
  }
  
  public static void a(Object[] paramArrayOfObject, com.tencent.mm.i.d paramd, h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(126742);
    if ((paramh == null) || (paramd == null))
    {
      ad.w("MicroMsg.OnlineVideoService", "video task info is null or download result is null.");
      AppMethodBeat.o(126742);
      return;
    }
    if ((!paramh.XR()) && (!paramh.XT()) && (!paramh.XV()))
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
      ad.i("MicroMsg.OnlineVideoService", "rpt online video format[%d] clientIp[%s] isCrossNet[%d]", new Object[] { Integer.valueOf(paramd.field_videoFormat), str2, Integer.valueOf(i4) });
      if (paramd.field_videoFormat == 2) {
        u.HC(paramh.filename);
      }
      if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(str2)) {
        break label1526;
      }
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 45L, 1L, false);
      if (!paramd.field_isCrossNet) {
        break label1543;
      }
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 47L, 1L, false);
      bool1 = paramh.XT();
      bool2 = paramh.XV();
      localObject1 = new PInt();
      localObject2 = new PInt();
      ((PInt)localObject2).value = 0;
      ((PInt)localObject1).value = 0;
      u.a(paramh.field_fullpath, (PInt)localObject1, (PInt)localObject2);
      i15 = ((PInt)localObject1).value * 1000;
      i16 = ((PInt)localObject2).value;
      i6 = 0;
      i5 = 0;
      if ((paramArrayOfObject == null) || (paramArrayOfObject.length <= 6)) {
        break label2729;
      }
      i2 = ((Integer)paramArrayOfObject[0]).intValue() * 1000;
      j = ((Integer)paramArrayOfObject[1]).intValue();
      i3 = ((Integer)paramArrayOfObject[2]).intValue();
      m = ((Integer)paramArrayOfObject[3]).intValue();
      i = ((Integer)paramArrayOfObject[4]).intValue();
      n = ((Integer)paramArrayOfObject[5]).intValue();
      i1 = ((Integer)paramArrayOfObject[6]).intValue();
      if ((bool2) || (bool1) || (paramArrayOfObject.length <= 10)) {
        break label2721;
      }
      i6 = ((Integer)paramArrayOfObject[7]).intValue();
      localObject1 = (String)paramArrayOfObject[8];
      i5 = ((Long)paramArrayOfObject[9]).intValue();
    }
    for (;;)
    {
      int i7 = paramh.fJH;
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
        i17 = ay.iS(aj.getContext());
        str1 = paramd.XP();
        PInt localPInt1 = new PInt();
        localPInt2 = new PInt();
        a(localPInt1, localPInt2, paramh.filename, paramh.fJK);
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
        if (paramh.fJG == null) {
          break label1599;
        }
        localObject2 = com.tencent.mm.b.g.getMessageDigest(paramh.fJG.getBytes());
        label755:
        localStringBuffer.append(localObject2).append(",");
        if (!w.vF(paramh.fJG)) {
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
        localStringBuffer.append(paramh.fJJ).append(",");
        localStringBuffer.append(paramh.dAY).append(",");
        localStringBuffer.append(paramh.fJk).append(",");
        localStringBuffer.append(paramd.field_videoFormat).append(",");
        label1182:
        localStringBuffer.append(str2).append(",");
        localStringBuffer.append(i4).append(",");
        localStringBuffer.append(paramh.fJL).append(",");
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
        ad.i("MicroMsg.OnlineVideoService", "report online video %d:%s", new Object[] { Integer.valueOf(k), localObject2 });
        if (!bool1) {
          break label1747;
        }
        new dl((String)localObject2).aLk();
        label1356:
        if (paramBoolean) {
          a(paramh.dyU, paramh.fJG, paramh.dyW, paramd.field_fileId, i17, paramd.field_startTime, paramd.field_endTime, paramh.field_fullpath, paramd.field_usedSvrIps, paramh.url, localPInt1.value, localPInt2.value, paramh.dzb);
        }
        if (bool1)
        {
          if (paramd.field_videoFormat != 2) {
            break label2704;
          }
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 132L, 1L, false);
        }
      }
      for (;;)
      {
        paramArrayOfObject = u.Hy(paramh.filename);
        if (paramArrayOfObject != null)
        {
          paramArrayOfObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().xY(paramArrayOfObject.iuf);
          ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().a(new i.c(paramArrayOfObject.field_talker, "update", paramArrayOfObject));
        }
        AppMethodBeat.o(126742);
        return;
        i4 = 0;
        break;
        label1526:
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 46L, 1L, false);
        break label146;
        label1543:
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 48L, 1L, false);
        break label167;
        k = 31;
        break label412;
        label1567:
        localStringBuffer.append(paramh.url).append(",").append(paramh.fJI).append(",");
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
        if (paramh.fJG != null) {}
        for (localObject2 = com.tencent.mm.b.g.getMessageDigest(paramh.fJG.getBytes());; localObject2 = Integer.valueOf(0))
        {
          localStringBuffer.append(localObject2).append(",");
          break;
        }
        label1717:
        localStringBuffer.append(com.tencent.mm.plugin.video.c.aDi(paramh.dzb)).append(",");
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
              k = com.tencent.mm.sdk.platformtools.bt.getInt(paramArrayOfObject[7].toString(), 0);
              com.tencent.mm.sdk.platformtools.bt.getInt(paramArrayOfObject[8].toString(), 0);
              i4 = com.tencent.mm.sdk.platformtools.bt.getInt(paramArrayOfObject[9].toString(), 0);
              localObject1 = paramArrayOfObject[11].toString();
              i5 = com.tencent.mm.sdk.platformtools.bt.getInt(paramArrayOfObject[12].toString(), 0);
              l1 = com.tencent.mm.sdk.platformtools.bt.getLong(paramArrayOfObject[13].toString(), 0L);
              i6 = com.tencent.mm.sdk.platformtools.bt.getInt(paramArrayOfObject[14].toString(), 0);
              i7 = com.tencent.mm.sdk.platformtools.bt.getInt(paramArrayOfObject[15].toString(), 0);
              i8 = com.tencent.mm.sdk.platformtools.bt.getInt(paramArrayOfObject[16].toString(), 0);
            }
          }
          paramArrayOfObject = new hn();
          localObject1 = paramArrayOfObject.qd((String)localObject1);
          ((hn)localObject1).esb = i5;
          ((hn)localObject1).esc = i7;
          ((hn)localObject1).esd = i6;
          ((hn)localObject1).dTt = i15;
          ((hn)localObject1).ese = (i2 / 1000);
          ((hn)localObject1).efW = j;
          ((hn)localObject1).efX = i3;
          ((hn)localObject1).esf = m;
          ((hn)localObject1).efZ = i;
          ((hn)localObject1).esg = 0L;
          ((hn)localObject1).egu = n;
          ((hn)localObject1).esh = i1;
          localObject1 = ((hn)localObject1).qe("");
          ((hn)localObject1).dTu = (i16 * 1000);
          localObject1 = ((hn)localObject1).qf(paramh.field_requestVideoFormat);
          ((hn)localObject1).dQA = paramd.field_fileLength;
          ((hn)localObject1).esk = paramd.field_recvedBytes;
          ((hn)localObject1).egc = paramd.field_startTime;
          ((hn)localObject1).egd = paramd.field_endTime;
          ((hn)localObject1).esl = paramd.field_retCode;
          ((hn)localObject1).esm = paramd.field_enQueueTime;
          ((hn)localObject1).esn = paramd.field_moovRequestTimes;
          ((hn)localObject1).eso = paramd.field_moovCost;
          ((hn)localObject1).egr = paramd.field_moovSize;
          if (paramd.field_moovCompleted)
          {
            l2 = 1L;
            ((hn)localObject1).esp = l2;
            ((hn)localObject1).esq = paramd.field_moovFailReason;
            ((hn)localObject1).esr = paramd.field_firstConnectCost;
            ((hn)localObject1).ess = paramd.field_firstRequestCost;
            ((hn)localObject1).est = paramd.field_firstRequestSize;
            ((hn)localObject1).esu = paramd.field_firstRequestDownloadSize;
            if (!paramd.field_firstRequestCompleted) {
              break label2655;
            }
            l2 = 1L;
            label2287:
            ((hn)localObject1).esv = l2;
            ((hn)localObject1).esw = paramd.field_averageSpeed;
            ((hn)localObject1).esx = paramd.field_averageConnectCost;
            ((hn)localObject1).ego = paramd.field_netConnectTimes;
            localObject1 = ((hn)localObject1).qg(paramd.XP()).qh(paramd.field_clientIP);
            if (!paramd.field_isCrossNet) {
              break label2661;
            }
          }
          label2655:
          label2661:
          for (l2 = 1L;; l2 = 0L)
          {
            ((hn)localObject1).esz = l2;
            ((hn)localObject1).egC = paramh.fJL;
            ((hn)localObject1).esA = i4;
            ((hn)localObject1).dQy = i17;
            ((hn)localObject1).esB = l1;
            ((hn)localObject1).dTB = k;
            ((hn)localObject1).esC = i8;
            ((hn)localObject1).egD = paramd.transportProtocol;
            ((hn)localObject1).egE = paramd.transportProtocolError;
            ad.d("MicroMsg.OnlineVideoService", "time distance %d", new Object[] { Long.valueOf(System.currentTimeMillis() - paramArrayOfObject.esB) });
            if (System.currentTimeMillis() - paramArrayOfObject.esB > 500L) {
              paramArrayOfObject.aLk();
            }
            if (!bool2) {
              break;
            }
            paramArrayOfObject = new fr();
            localObject1 = com.tencent.mm.plugin.sight.base.e.axx(paramh.field_fullpath);
            if (localObject1 != null)
            {
              paramArrayOfObject.dTt = ((com.tencent.mm.plugin.sight.base.a)localObject1).videoDuration;
              paramArrayOfObject.dTu = ((com.tencent.mm.plugin.sight.base.a)localObject1).videoBitrate;
              paramArrayOfObject.dTv = ((com.tencent.mm.plugin.sight.base.a)localObject1).audioBitrate;
              paramArrayOfObject.dTw = ((com.tencent.mm.plugin.sight.base.a)localObject1).frameRate;
              paramArrayOfObject.dTx = ((com.tencent.mm.plugin.sight.base.a)localObject1).width;
              paramArrayOfObject.dTy = ((com.tencent.mm.plugin.sight.base.a)localObject1).height;
              paramArrayOfObject.dTA = ((com.tencent.mm.plugin.sight.base.a)localObject1).audioChannel;
            }
            paramArrayOfObject.dTs = paramd.field_fileLength;
            paramArrayOfObject = paramArrayOfObject.oG(paramh.url);
            f.aGJ();
            paramArrayOfObject = paramArrayOfObject.oH(a.EL(paramh.field_fullpath));
            paramArrayOfObject.dTq = paramd.field_startTime;
            paramArrayOfObject.dTr = paramd.field_endTime;
            paramArrayOfObject = paramArrayOfObject.oI(str1);
            paramArrayOfObject.dTB = k;
            paramArrayOfObject.dTC = localPInt2.value;
            paramArrayOfObject.aLk();
            break;
            l2 = 0L;
            break label2220;
            l2 = 0L;
            break label2287;
          }
        }
        label2220:
        paramArrayOfObject = new fd((String)localObject2);
        paramArrayOfObject.eks = i5;
        paramArrayOfObject.om((String)localObject1);
        paramArrayOfObject.ekq = i6;
        paramArrayOfObject.aLk();
        break label1356;
        label2704:
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 133L, 1L, false);
      }
      label2721:
      localObject1 = "";
      continue;
      label2729:
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
  
  private static boolean a(com.tencent.mm.storage.bj parambj, String paramString1, long paramLong, String paramString2)
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
      if (parambj == null)
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
      i = parambj.hbR;
      if (i == 0)
      {
        AppMethodBeat.o(126739);
        return false;
      }
      long l = com.tencent.mm.sdk.platformtools.bt.rM(parambj.hbR);
      if (l > paramLong)
      {
        AppMethodBeat.o(126739);
        return true;
      }
      AppMethodBeat.o(126739);
      return false;
    }
    catch (Exception parambj)
    {
      ad.e("MicroMsg.OnlineVideoService", "error for check dcip %s", new Object[] { parambj.getMessage() });
      AppMethodBeat.o(126739);
    }
    return false;
  }
  
  private static boolean i(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(126736);
    if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(126736);
      return false;
    }
    o.aMJ();
    paramString2 = t.Hh(paramString2);
    if ((com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramString1)) || (paramInt <= 0) || (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramString2)))
    {
      ad.w("MicroMsg.OnlineVideoService", "insert media duplication but args is error.[%d, %s, %s]", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
      AppMethodBeat.o(126736);
      return false;
    }
    boolean bool = ((com.tencent.mm.plugin.n.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.n.a.a.class)).azx().E(paramString1, paramInt, paramString2);
    AppMethodBeat.o(126736);
    return bool;
  }
  
  public static void q(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(126740);
    if (paramArrayOfInt == null)
    {
      AppMethodBeat.o(126740);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yhR.f(17891, new Object[] { Integer.valueOf(paramArrayOfInt[6]), Integer.valueOf(paramArrayOfInt[8]), Integer.valueOf(paramArrayOfInt[9]), Integer.valueOf(paramArrayOfInt[7]), Integer.valueOf(paramArrayOfInt[10]), Integer.valueOf(paramArrayOfInt[11]), Integer.valueOf(paramArrayOfInt[12]), Integer.valueOf(paramArrayOfInt[13]), Integer.valueOf(paramArrayOfInt[14]), Integer.valueOf(paramArrayOfInt[15]), Integer.valueOf(paramArrayOfInt[0]), Integer.valueOf(paramArrayOfInt[1]), Integer.valueOf(paramArrayOfInt[2]), Integer.valueOf(paramArrayOfInt[3]), Integer.valueOf(paramArrayOfInt[4]), Integer.valueOf(paramArrayOfInt[5]), Integer.valueOf(paramArrayOfInt[16]), Integer.valueOf(paramArrayOfInt[17]), Integer.valueOf(paramArrayOfInt[18]), Integer.valueOf(paramArrayOfInt[19]), Integer.valueOf(paramArrayOfInt[20]), Integer.valueOf(paramArrayOfInt[21]), Integer.valueOf(paramArrayOfInt[22]), Integer.valueOf(paramArrayOfInt[23]), Integer.valueOf(paramArrayOfInt[24]), Integer.valueOf(paramArrayOfInt[25]), Integer.valueOf(paramArrayOfInt[26]), Integer.valueOf(paramArrayOfInt[27]), Integer.valueOf(paramArrayOfInt[28]) });
    AppMethodBeat.o(126740);
  }
  
  public static int r(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126729);
    f.aGJ();
    int i = a.requestVideoData(paramString, paramInt1, paramInt2, 0);
    ad.i("MicroMsg.OnlineVideoService", "request video video[%s], offset[%d], length[%d] duration[%d] ret[%d]", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0), Integer.valueOf(i) });
    AppMethodBeat.o(126729);
    return i;
  }
  
  public final int a(final String paramString, final com.tencent.mm.i.c paramc, final com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(126734);
    if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.OnlineVideoService", "cdn callback mediaid is null.");
      AppMethodBeat.o(126734);
      return -1;
    }
    if ((paramc == null) && (paramd == null))
    {
      ad.e("MicroMsg.OnlineVideoService", "cdn callback info all null.");
      AppMethodBeat.o(126734);
      return -2;
    }
    com.tencent.mm.kernel.g.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(169094);
        Object localObject = (h)e.this.hTK.get(paramString);
        if (localObject == null)
        {
          AppMethodBeat.o(169094);
          return;
        }
        if (((h)localObject).fJN != null)
        {
          ad.i("MicroMsg.OnlineVideoService", "cdn callback %s route to videoCallback", new Object[] { paramString });
          if (paramc != null)
          {
            ((h)localObject).fJN.i(paramString, paramc.field_finishedLength, paramc.field_toltalLength);
            AppMethodBeat.o(169094);
            return;
          }
          if (paramd != null)
          {
            ad.i("MicroMsg.OnlineVideoService", "cdn callback %s route to videoCallback, sceneResult.retCode:%s", new Object[] { paramString, Integer.valueOf(paramd.field_retCode) });
            ((h)localObject).fJN.a(paramString, paramd.field_retCode, paramd);
            e.this.hTK.remove(paramString);
            if (paramd.field_retCode == 0)
            {
              e.this.hUv.put(((h)localObject).field_mediaId, localObject);
              e.this.hUw.put(((h)localObject).field_mediaId, paramd);
            }
            AppMethodBeat.o(169094);
            return;
          }
          AppMethodBeat.o(169094);
          return;
        }
        s locals = u.Hy(((h)localObject).filename);
        if (locals == null)
        {
          ad.w("MicroMsg.OnlineVideoService", "stream download video callback, but video info is null.[%s]", new Object[] { ((h)localObject).filename });
          AppMethodBeat.o(169094);
          return;
        }
        if (((h)localObject).fJj != null)
        {
          ((h)localObject).fJj.a(paramString, 0, paramc, paramd, ((h)localObject).field_onlycheckexist);
          if (paramd != null) {
            e.this.hTK.remove(paramString);
          }
          AppMethodBeat.o(169094);
          return;
        }
        if (paramc != null)
        {
          if (paramc.field_finishedLength == locals.hMP)
          {
            ad.i("MicroMsg.OnlineVideoService", "stream download finish.");
            AppMethodBeat.o(169094);
            return;
          }
          if ((locals.status != 130) && (locals.iua > paramc.field_finishedLength))
          {
            ad.w("MicroMsg.OnlineVideoService", "set video error. db now size %d, cdn callback %d.", new Object[] { Integer.valueOf(locals.iua), Long.valueOf(paramc.field_finishedLength) });
            AppMethodBeat.o(169094);
            return;
          }
          ad.i("MicroMsg.OnlineVideoService", "callback progress info " + paramc.field_finishedLength);
          locals.iud = com.tencent.mm.sdk.platformtools.bt.aQJ();
          locals.iua = ((int)paramc.field_finishedLength);
          locals.dDp = 1040;
          u.f(locals);
          localObject = new nx();
          ((nx)localObject).dBK.dsi = 5;
          ((nx)localObject).dBK.mediaId = paramString;
          ((nx)localObject).dBK.offset = ((int)paramc.field_finishedLength);
          ((nx)localObject).dBK.length = ((int)paramc.field_toltalLength);
          com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
          AppMethodBeat.o(169094);
          return;
        }
        int i;
        int j;
        if (paramd != null)
        {
          ad.i("MicroMsg.OnlineVideoService", "callback result info " + paramd.field_retCode + ", filesize:" + paramd.field_fileLength + ",recved:" + paramd.field_recvedBytes);
          if (paramd.field_retCode == 0) {
            break label1130;
          }
          if (paramd.field_retCode != -10012) {
            u.Hp(locals.getFileName());
          }
          boolean bool = ((h)localObject).XT();
          i = paramd.field_retCode;
          j = ((h)localObject).fJF;
          if (!bool) {
            break label1039;
          }
          if (j != 1) {
            break label950;
          }
          if (i != -5103059) {
            break label885;
          }
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 111L, 1L, false);
          com.tencent.mm.plugin.report.service.g.yhR.f(13836, new Object[] { Integer.valueOf(101), Long.valueOf(com.tencent.mm.sdk.platformtools.bt.aQJ()), Integer.valueOf(i) });
        }
        for (;;)
        {
          localObject = new nx();
          ((nx)localObject).dBK.dsi = 4;
          ((nx)localObject).dBK.mediaId = paramString;
          ((nx)localObject).dBK.offset = 0;
          ((nx)localObject).dBK.retCode = paramd.field_retCode;
          ((nx)localObject).dBK.length = ((int)paramd.field_fileLength);
          com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
          e.this.hTK.remove(paramString);
          AppMethodBeat.o(169094);
          return;
          label885:
          if (i == -5103087)
          {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 112L, 1L, false);
            break;
          }
          if (i == -10012)
          {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 113L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 114L, 1L, false);
          break;
          label950:
          if (i == -5103059)
          {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 116L, 1L, false);
            break;
          }
          if (i == -5103087)
          {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 117L, 1L, false);
            break;
          }
          if (i == -10012)
          {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 118L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 119L, 1L, false);
          break;
          label1039:
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 213L, 1L, false);
          if (j == 1) {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 214L, 1L, false);
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.g.yhR.f(13836, new Object[] { Integer.valueOf(201), Long.valueOf(com.tencent.mm.sdk.platformtools.bt.aQJ()), Integer.valueOf(i) });
            break;
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 215L, 1L, false);
          }
          label1130:
          e.a(locals, (int)paramd.field_fileLength, ((h)localObject).fJD);
          e.this.hUv.put(((h)localObject).field_mediaId, localObject);
          e.this.hUw.put(((h)localObject).field_mediaId, paramd);
        }
      }
    });
    if (this.hTK.get(paramString) != null)
    {
      AppMethodBeat.o(126734);
      return 1;
    }
    AppMethodBeat.o(126734);
    return 0;
  }
  
  public final boolean a(final h paramh)
  {
    AppMethodBeat.i(126725);
    if (paramh == null)
    {
      ad.e("MicroMsg.OnlineVideoService", "add download task, but task is null.");
      AppMethodBeat.o(126725);
      return false;
    }
    if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramh.field_mediaId))
    {
      ad.e("MicroMsg.OnlineVideoService", "add download task, but task mediaId is null.");
      AppMethodBeat.o(126725);
      return false;
    }
    ad.i("MicroMsg.OnlineVideoService", "add download task : " + paramh.field_mediaId);
    if (paramh.field_fileId == null) {
      paramh.field_fileId = "";
    }
    if (paramh.field_aesKey == null) {
      paramh.field_aesKey = "";
    }
    paramh.dNR = false;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126715);
          e.this.gIf.removeCallbacksAndMessages(paramh.field_mediaId);
          e.this.hTI.add(paramh.field_mediaId);
          e.this.hTJ.put(paramh.field_mediaId, paramh);
          e.this.eL(false);
          AppMethodBeat.o(126715);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(126725);
      return true;
      this.gIf.removeCallbacksAndMessages(paramh.field_mediaId);
      this.hTI.add(paramh.field_mediaId);
      this.hTJ.put(paramh.field_mediaId, paramh);
      eL(false);
    }
  }
  
  public final boolean a(final h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(126724);
    if (paramh == null)
    {
      ad.e("MicroMsg.OnlineVideoService", "add download task, but task is null.");
      AppMethodBeat.o(126724);
      return false;
    }
    if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramh.field_mediaId))
    {
      ad.e("MicroMsg.OnlineVideoService", "add download task, but task mediaId is null.");
      AppMethodBeat.o(126724);
      return false;
    }
    ad.i("MicroMsg.OnlineVideoService", "add download task : " + paramh.field_mediaId + " delay : " + paramBoolean);
    if (paramh.field_fileId == null) {
      paramh.field_fileId = "";
    }
    if (paramh.field_aesKey == null) {
      paramh.field_aesKey = "";
    }
    paramh.dNR = false;
    if ((m(paramh.field_mediaId, null)) || (paramBoolean)) {
      com.tencent.mm.kernel.g.ajF().ay(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126713);
          e.this.hTI.add(paramh.field_mediaId);
          e.this.hTJ.put(paramh.field_mediaId, paramh);
          e.this.eL(false);
          AppMethodBeat.o(126713);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(126724);
      return true;
      com.tencent.mm.kernel.g.ajF().ay(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126714);
          e.this.hTI.add(paramh.field_mediaId);
          e.this.hTJ.put(paramh.field_mediaId, paramh);
          e.this.eL(false);
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
    if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramString)) {
      if (!this.hTK.containsKey(paramString)) {
        break label90;
      }
    }
    for (bool1 = true;; bool1 = bool2)
    {
      com.tencent.mm.kernel.g.ajF().ay(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126718);
          Object localObject1 = (h)e.this.hTK.remove(paramString);
          Object localObject2;
          int i;
          if (localObject1 != null)
          {
            localObject2 = new com.tencent.mm.i.d();
            f.aGJ();
            i = a.c(((h)localObject1).field_mediaId, (com.tencent.mm.i.d)localObject2);
            if (i == 0) {
              e.a(this.hUC, (com.tencent.mm.i.d)localObject2, (h)localObject1, false);
            }
          }
          for (;;)
          {
            e.this.hTJ.remove(paramString);
            if (parama != null) {
              parama.a((h)localObject1, (com.tencent.mm.i.d)localObject2);
            }
            AppMethodBeat.o(126718);
            return;
            ad.w("MicroMsg.OnlineVideoService", "stop video stream download error. ret %d, mediaId %s", new Object[] { Integer.valueOf(i), ((h)localObject1).field_mediaId });
            continue;
            h localh = (h)e.this.hUv.remove(paramString);
            com.tencent.mm.i.d locald = (com.tencent.mm.i.d)e.this.hUw.remove(paramString);
            localObject1 = localh;
            localObject2 = locald;
            if (localh != null)
            {
              localObject1 = localh;
              localObject2 = locald;
              if (locald != null)
              {
                e.a(this.hUC, locald, localh, true);
                localObject1 = localh;
                localObject2 = locald;
              }
            }
          }
        }
      });
      ad.i("MicroMsg.OnlineVideoService", "cancelDownloadTaskWithCallback mediaId : " + paramString + " remove : " + bool1);
      AppMethodBeat.o(169096);
      return bool1;
      label90:
      f.aGI().EQ(paramString);
    }
  }
  
  public final int d(final String paramString1, final int paramInt1, final int paramInt2, final String paramString2)
  {
    AppMethodBeat.i(218835);
    this.hUx.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126719);
        ad.i("MicroMsg.OnlineVideoService", "onMoovReady mediaId[%s]", new Object[] { paramString1 });
        if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramString1))
        {
          AppMethodBeat.o(126719);
          return;
        }
        com.tencent.mm.kernel.g.ajF().ay(new Runnable()
        {
          public final void run()
          {
            boolean bool2 = true;
            AppMethodBeat.i(169095);
            h localh = (h)e.this.hTK.get(e.10.this.LO);
            Object localObject = new StringBuilder("info=").append(localh).append(" mediaId=").append(e.10.this.LO).append(" info.videoCallback=");
            if ((localh != null) && (localh.fJN == null)) {}
            for (boolean bool1 = true;; bool1 = false)
            {
              ad.w("MicroMsg.OnlineVideoService", bool1);
              if (localh == null) {
                break label507;
              }
              localh.fJL = e.10.this.hUz;
              if (localh.fJN == null) {
                break;
              }
              localh.fJN.a(e.10.this.LO, e.10.this.hUz, e.10.this.hUA, e.10.this.hUE);
              AppMethodBeat.o(169095);
              return;
            }
            if (r.GW(localh.field_fullpath))
            {
              ad.w("MicroMsg.OnlineVideoService", "it is qt video, need finish all file. isPlayMode" + localh.fJF);
              if (localh.fJF == 1)
              {
                e.r(localh.field_mediaId, 0, localh.field_totalLen);
                com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 19L, 1L, false);
              }
              AppMethodBeat.o(169095);
              return;
            }
            localObject = new nx();
            ((nx)localObject).dBK.dsi = 1;
            ((nx)localObject).dBK.retCode = 0;
            ((nx)localObject).dBK.mediaId = e.10.this.LO;
            ((nx)localObject).dBK.offset = e.10.this.hUz;
            ((nx)localObject).dBK.length = e.10.this.hUA;
            ((nx)localObject).dBK.dBL = localh.fJC;
            nx.a locala = ((nx)localObject).dBK;
            if (localh.fJk > 0) {}
            for (bool1 = bool2;; bool1 = false)
            {
              locala.dBM = bool1;
              com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
              localObject = u.Hy(localh.filename);
              if (localObject == null) {
                break label507;
              }
              ad.i("MicroMsg.OnlineVideoService", "on moov ready info: " + ((s)localObject).getFileName() + " status : " + ((s)localObject).status);
              if (((s)localObject).status != 130) {
                break;
              }
              AppMethodBeat.o(169095);
              return;
            }
            if (((s)localObject).status != 122)
            {
              localObject = u.Hy(localh.filename);
              if (localObject != null)
              {
                ((s)localObject).status = 121;
                ((s)localObject).dDp = 256;
                o.aMJ().c((s)localObject);
              }
              if (localh.fJF == 0)
              {
                ad.i("MicroMsg.OnlineVideoService", "stop download video");
                o.aMO().aNf();
                o.aMO().run();
              }
            }
            label507:
            AppMethodBeat.o(169095);
          }
        });
        AppMethodBeat.o(126719);
      }
    });
    if (this.hTK.containsKey(paramString1))
    {
      AppMethodBeat.o(218835);
      return 1;
    }
    AppMethodBeat.o(218835);
    return 0;
  }
  
  public final void eL(boolean paramBoolean)
  {
    AppMethodBeat.i(126730);
    if (!com.tencent.mm.kernel.g.ajx())
    {
      AppMethodBeat.o(126730);
      return;
    }
    if ((!paramBoolean) && (f.aGJ().aGA()))
    {
      com.tencent.mm.kernel.g.ajA();
      if (com.tencent.mm.kernel.a.aiJ())
      {
        ad.w("MicroMsg.OnlineVideoService", "cdn engine not init cdn dnsinfo , will retry after set info");
        f.aGI().eL(paramBoolean);
        AppMethodBeat.o(126730);
        return;
      }
    }
    f.aGI().aGB();
    while (!this.hTI.isEmpty())
    {
      Object localObject1 = (String)this.hTI.poll();
      Object localObject2 = (h)this.hTJ.remove(localObject1);
      if (localObject2 != null)
      {
        ((h)localObject2).field_startTime = com.tencent.mm.sdk.platformtools.bt.flT();
        if (!((h)localObject2).dNR)
        {
          if (((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Iwe, Integer.valueOf(-1))).intValue() == 2) {
            ad.i("MicroMsg.OnlineVideoService", "command set do not check media duplication.");
          }
          label167:
          int j;
          for (int i = 0;; i = 1)
          {
            if (i == 0) {
              break label410;
            }
            localObject2 = new nx();
            ((nx)localObject2).dBK.dsi = 6;
            ((nx)localObject2).dBK.mediaId = ((String)localObject1);
            com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject2);
            break;
            if (((h)localObject2).XU()) {
              break label167;
            }
            Object localObject3 = ((h)localObject2).fJD;
            i = ((h)localObject2).fJE;
            Object localObject4 = ((com.tencent.mm.plugin.n.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.n.a.a.class)).azx().gq((String)localObject3, i);
            j = i - (int)com.tencent.mm.vfs.i.aYo((String)localObject4);
            if ((com.tencent.mm.sdk.platformtools.bt.isNullOrNil((String)localObject4)) || (j < 0) || (j > 16)) {
              break label167;
            }
            ad.i("MicroMsg.OnlineVideoService", "it had download this video[%d, %s, %s].", new Object[] { Integer.valueOf(i), localObject3, localObject4 });
            com.tencent.mm.vfs.i.mz((String)localObject4, ((h)localObject2).field_fullpath);
            localObject4 = u.Hy(((h)localObject2).filename);
            a((s)localObject4, i, (String)localObject3);
            localObject3 = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().xY(((s)localObject4).iuf);
            ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().a(new i.c(((ei)localObject3).field_talker, "update", (bu)localObject3));
          }
          label410:
          if (((h)localObject2).XT())
          {
            i = f.aGJ().a((com.tencent.mm.i.g)localObject2, ((h)localObject2).fJF);
            label432:
            ad.i("MicroMsg.OnlineVideoService", "start task %s streaming download. ret %d ", new Object[] { localObject2, Integer.valueOf(i) });
            if (i == 0) {
              break label1161;
            }
            ad.w("MicroMsg.OnlineVideoService", "start stream video error. ret : " + i + " media id: " + ((h)localObject2).field_mediaId);
            paramBoolean = ((h)localObject2).XT();
            j = ((h)localObject2).fJF;
            if (!paramBoolean) {
              break label1071;
            }
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 3L, 1L, false);
            if (j != 1) {
              break label1006;
            }
            if (i != -21006) {
              break label965;
            }
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 100L, 1L, false);
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.g.yhR.f(13836, new Object[] { Integer.valueOf(100), Long.valueOf(com.tencent.mm.sdk.platformtools.bt.aQJ()), "" });
            break;
            if (((h)localObject2).XR())
            {
              i = f.aGJ().a(((h)localObject2).field_mediaId, ((h)localObject2).url, ((h)localObject2).referer, ((h)localObject2).field_fullpath, ((h)localObject2).fJF, ((h)localObject2).fJa, ((h)localObject2).isColdSnsData, ((h)localObject2).signalQuality, ((h)localObject2).snsScene, ((h)localObject2).field_preloadRatio, ((h)localObject2).preloadMinSize, ((h)localObject2).field_requestVideoFormat, 4, ((h)localObject2).concurrentCount);
              break label432;
            }
            if (((h)localObject2).XV())
            {
              i = f.aGJ().a(((h)localObject2).field_mediaId, ((h)localObject2).url, ((h)localObject2).referer, ((h)localObject2).field_fullpath, ((h)localObject2).fJF, ((h)localObject2).fJa, ((h)localObject2).isColdSnsData, ((h)localObject2).signalQuality, ((h)localObject2).snsScene, ((h)localObject2).field_preloadRatio, ((h)localObject2).preloadMinSize, ((h)localObject2).field_requestVideoFormat, 4);
              break label432;
            }
            if (((h)localObject2).XW())
            {
              i = f.aGJ().a(((h)localObject2).field_mediaId, ((h)localObject2).url, ((h)localObject2).referer, ((h)localObject2).field_fullpath, ((h)localObject2).fJF, ((h)localObject2).fJa, ((h)localObject2).isColdSnsData, ((h)localObject2).signalQuality, ((h)localObject2).snsScene, ((h)localObject2).field_preloadRatio, ((h)localObject2).preloadMinSize, ((h)localObject2).field_requestVideoFormat, ((h)localObject2).connectionCount, ((h)localObject2).fJM, ((h)localObject2).videoFlag, ((h)localObject2).snsCipherKey, ((h)localObject2).concurrentCount);
              break label432;
            }
            if (((h)localObject2).XS())
            {
              i = f.aGJ().a(((h)localObject2).field_mediaId, ((h)localObject2).url, ((h)localObject2).referer, ((h)localObject2).field_fullpath, ((h)localObject2).fJF, ((h)localObject2).field_preloadRatio, ((h)localObject2).preloadMinSize, ((h)localObject2).concurrentCount);
              break label432;
            }
            i = f.aGJ().a(((h)localObject2).field_mediaId, ((h)localObject2).url, ((h)localObject2).referer, ((h)localObject2).field_fullpath, ((h)localObject2).fJF, ((h)localObject2).fJa, ((h)localObject2).field_preloadRatio, ((h)localObject2).preloadMinSize);
            break label432;
            label965:
            if (i == -20003)
            {
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 101L, 1L, false);
            }
            else
            {
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 102L, 1L, false);
              continue;
              label1006:
              if (i == -21006) {
                com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 106L, 1L, false);
              } else if (i == -20003) {
                com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 107L, 1L, false);
              } else {
                com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 108L, 1L, false);
              }
            }
          }
          label1071:
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 210L, 1L, false);
          if (j == 1) {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 211L, 1L, false);
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.g.yhR.f(13836, new Object[] { Integer.valueOf(200), Long.valueOf(com.tencent.mm.sdk.platformtools.bt.aQJ()), "" });
            break;
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 212L, 1L, false);
          }
          label1161:
          ((h)localObject2).fJC = com.tencent.mm.sdk.platformtools.bt.flT();
          if (((h)localObject2).XT())
          {
            localObject1 = u.Hy(((h)localObject2).filename);
            if (localObject1 != null)
            {
              i = ((s)localObject1).status;
              if ((i != 120) && (i != 122) && (i != 121))
              {
                ((s)localObject1).status = 120;
                ((s)localObject1).dDp = 256;
                o.aMJ().c((s)localObject1);
              }
            }
          }
          this.hTK.put(((h)localObject2).field_mediaId, localObject2);
        }
      }
    }
    AppMethodBeat.o(126730);
  }
  
  public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126728);
    if ((h)this.hTK.get(paramString) == null)
    {
      ad.i("MicroMsg.OnlineVideoService", "this media[%s] don't download now.", new Object[] { paramString });
      AppMethodBeat.o(126728);
      return false;
    }
    f.aGJ();
    boolean bool = a.isVideoDataAvailable(paramString, paramInt1, paramInt2);
    ad.i("MicroMsg.OnlineVideoService", "is video[%s] data[%d, %d] available[%b]", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
    AppMethodBeat.o(126728);
    return bool;
  }
  
  public final boolean l(final String paramString, final Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(126726);
    boolean bool;
    if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramString)) {
      if (this.hTK.containsKey(paramString))
      {
        bool = true;
        if ((!bool) || (Looper.myLooper() == Looper.getMainLooper())) {
          break label121;
        }
        this.gIf.postAtTime(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(126716);
            h localh = (h)e.this.hTK.remove(paramString);
            com.tencent.mm.i.d locald;
            int i;
            if (localh != null)
            {
              locald = new com.tencent.mm.i.d();
              f.aGJ();
              i = a.c(localh.field_mediaId, locald);
              if (i == 0) {
                e.a(paramArrayOfObject, locald, localh, false);
              }
            }
            for (;;)
            {
              e.this.hTJ.remove(paramString);
              AppMethodBeat.o(126716);
              return;
              ad.w("MicroMsg.OnlineVideoService", "stop video stream download error. ret %d, mediaId %s", new Object[] { Integer.valueOf(i), localh.field_mediaId });
              continue;
              localh = (h)e.this.hUv.remove(paramString);
              locald = (com.tencent.mm.i.d)e.this.hUw.remove(paramString);
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
      ad.i("MicroMsg.OnlineVideoService", "cancelDownloadTaskInMainThread mediaId : " + paramString + " remove : " + bool);
      AppMethodBeat.o(126726);
      return bool;
      f.aGI().EQ(paramString);
      bool = false;
      break;
      label121:
      this.gIf.removeCallbacksAndMessages(paramString);
      h localh = (h)this.hTK.remove(paramString);
      com.tencent.mm.i.d locald;
      int i;
      if (localh != null)
      {
        locald = new com.tencent.mm.i.d();
        f.aGJ();
        i = a.c(localh.field_mediaId, locald);
        if (i == 0) {
          a(paramArrayOfObject, locald, localh, false);
        }
      }
      for (;;)
      {
        this.hTJ.remove(paramString);
        break;
        ad.w("MicroMsg.OnlineVideoService", "stop video stream download error. ret %d, mediaId %s", new Object[] { Integer.valueOf(i), localh.field_mediaId });
        continue;
        localh = (h)this.hUv.remove(paramString);
        locald = (com.tencent.mm.i.d)this.hUw.remove(paramString);
        if ((localh != null) && (locald != null)) {
          a(paramArrayOfObject, locald, localh, true);
        }
      }
      bool = false;
    }
  }
  
  public final boolean m(final String paramString, final Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(126727);
    boolean bool1 = false;
    boolean bool2 = false;
    if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramString)) {
      if (!this.hTK.containsKey(paramString)) {
        break label90;
      }
    }
    for (bool1 = true;; bool1 = bool2)
    {
      com.tencent.mm.kernel.g.ajF().ay(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126717);
          h localh = (h)e.this.hTK.remove(paramString);
          com.tencent.mm.i.d locald;
          int i;
          if (localh != null)
          {
            locald = new com.tencent.mm.i.d();
            f.aGJ();
            i = a.c(localh.field_mediaId, locald);
            if (i == 0) {
              e.a(paramArrayOfObject, locald, localh, false);
            }
          }
          for (;;)
          {
            e.this.hTJ.remove(paramString);
            AppMethodBeat.o(126717);
            return;
            ad.w("MicroMsg.OnlineVideoService", "stop video stream download error. ret %d, mediaId %s", new Object[] { Integer.valueOf(i), localh.field_mediaId });
            continue;
            localh = (h)e.this.hUv.remove(paramString);
            locald = (com.tencent.mm.i.d)e.this.hUw.remove(paramString);
            if ((localh != null) && (locald != null)) {
              e.a(paramArrayOfObject, locald, localh, true);
            }
          }
        }
      });
      ad.i("MicroMsg.OnlineVideoService", "cancelDownloadTask mediaId : " + paramString + " remove : " + bool1);
      AppMethodBeat.o(126727);
      return bool1;
      label90:
      f.aGI().EQ(paramString);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(126723);
    if (paramn.getType() != 379)
    {
      AppMethodBeat.o(126723);
      return;
    }
    ad.i("MicroMsg.OnlineVideoService", "it get cdn dns success[%d, %d], try to start.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (com.tencent.mm.kernel.g.ajA().aiK()) {
      com.tencent.mm.kernel.g.ajF().ay(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126711);
          e.this.eL(true);
          AppMethodBeat.o(126711);
        }
      });
    }
    AppMethodBeat.o(126723);
  }
  
  public final int p(final String paramString, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(218836);
    ad.i("MicroMsg.OnlineVideoService", "onDataAvailable. offset %d, length %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(218836);
      return 0;
    }
    com.tencent.mm.kernel.g.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126720);
        Object localObject = (h)e.this.hTK.get(paramString);
        if (localObject != null)
        {
          if (((h)localObject).fJN != null) {
            ((h)localObject).fJN.onDataAvailable(paramString, paramInt1, paramInt2);
          }
          localObject = new nx();
          ((nx)localObject).dBK.dsi = 2;
          ((nx)localObject).dBK.retCode = 0;
          ((nx)localObject).dBK.mediaId = paramString;
          ((nx)localObject).dBK.offset = paramInt1;
          ((nx)localObject).dBK.length = paramInt2;
          com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
        }
        AppMethodBeat.o(126720);
      }
    });
    if (this.hTK.containsKey(paramString))
    {
      AppMethodBeat.o(218836);
      return 1;
    }
    AppMethodBeat.o(218836);
    return 0;
  }
  
  public final int q(final String paramString, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(218837);
    ad.i("MicroMsg.OnlineVideoService", "onDownloadToEnd. offset %d, length %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(218837);
      return 0;
    }
    com.tencent.mm.kernel.g.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126712);
        h localh = (h)e.this.hTK.get(paramString);
        if (localh != null)
        {
          nx localnx = new nx();
          localnx.dBK.dsi = 3;
          localnx.dBK.retCode = 0;
          localnx.dBK.mediaId = paramString;
          localnx.dBK.offset = paramInt1;
          localnx.dBK.length = paramInt2;
          com.tencent.mm.sdk.b.a.IbL.l(localnx);
          if ((paramInt1 == 0) && (paramInt2 >= localh.fJE)) {
            e.a(u.Hy(localh.filename), localh.fJE, localh.fJD);
          }
        }
        AppMethodBeat.o(126712);
      }
    });
    if (this.hTK.containsKey(paramString))
    {
      AppMethodBeat.o(218837);
      return 1;
    }
    AppMethodBeat.o(218837);
    return 0;
  }
  
  public final void release()
  {
    AppMethodBeat.i(126722);
    com.tencent.mm.kernel.g.aiU().b(379, this);
    AppMethodBeat.o(126722);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ao.e
 * JD-Core Version:    0.7.0.1
 */