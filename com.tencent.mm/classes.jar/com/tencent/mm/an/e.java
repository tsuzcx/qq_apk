package com.tencent.mm.an;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.b.p;
import com.tencent.mm.g.a.lk;
import com.tencent.mm.g.a.np;
import com.tencent.mm.g.a.np.a;
import com.tencent.mm.g.b.a.cs;
import com.tencent.mm.g.b.a.ee;
import com.tencent.mm.g.b.a.es;
import com.tencent.mm.g.b.a.gk;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.h.a;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bi.b;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.modelvideo.y.a;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.bo;
import com.tencent.mm.vfs.i;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class e
  implements com.tencent.mm.ak.g, a.a
{
  Map<String, com.tencent.mm.i.h> hBP;
  Map<String, com.tencent.mm.i.d> hBQ;
  private final ao hBR;
  Queue<String> hBj;
  Map<String, com.tencent.mm.i.h> hBk;
  Map<String, com.tencent.mm.i.h> hBl;
  
  public e()
  {
    AppMethodBeat.i(126721);
    this.hBj = new LinkedList();
    this.hBk = new HashMap();
    this.hBl = new HashMap();
    this.hBP = new HashMap();
    this.hBQ = new HashMap();
    this.hBR = new ao(Looper.getMainLooper());
    com.tencent.mm.kernel.g.agi().a(379, this);
    AppMethodBeat.o(126721);
  }
  
  public static com.tencent.mm.i.h BT(String paramString)
  {
    AppMethodBeat.i(126737);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(126737);
      return null;
    }
    s locals = u.Ej(paramString);
    if (locals == null)
    {
      AppMethodBeat.o(126737);
      return null;
    }
    Object localObject1 = bv.L(locals.aJK(), "msg");
    if (localObject1 == null)
    {
      ac.w("MicroMsg.OnlineVideoService", "cdntra parse video recv xml failed");
      AppMethodBeat.o(126737);
      return null;
    }
    Object localObject2 = (String)((Map)localObject1).get(".msg.videomsg.$cdnvideourl");
    if (bs.isNullOrNil((String)localObject2))
    {
      ac.w("MicroMsg.OnlineVideoService", "cdntra parse video recv xml failed");
      AppMethodBeat.o(126737);
      return null;
    }
    int j = bs.getInt((String)((Map)localObject1).get(".msg.videomsg.$length"), 0);
    String str1 = (String)((Map)localObject1).get(".msg.videomsg.$md5");
    String str2 = (String)((Map)localObject1).get(".msg.videomsg.$aeskey");
    String str3 = (String)((Map)localObject1).get(".msg.videomsg.$fileparam");
    String str4 = c.a("downvideo", locals.createTime, locals.getUser(), locals.getFileName());
    if (bs.isNullOrNil(str4))
    {
      ac.w("MicroMsg.OnlineVideoService", "cdntra genClientId failed not use cdn file:%s", new Object[] { locals.getFileName() });
      AppMethodBeat.o(126737);
      return null;
    }
    o.aJy();
    String str5 = t.DV(paramString);
    localObject1 = new com.tencent.mm.i.h();
    ((com.tencent.mm.i.h)localObject1).filename = paramString;
    ((com.tencent.mm.i.h)localObject1).fru = str1;
    ((com.tencent.mm.i.h)localObject1).frv = j;
    ((com.tencent.mm.i.h)localObject1).frw = 1;
    ((com.tencent.mm.i.h)localObject1).dng = locals.aJH();
    ((com.tencent.mm.i.h)localObject1).frx = locals.getUser();
    if (w.sQ(locals.getUser()))
    {
      i = com.tencent.mm.model.q.wb(locals.getUser());
      ((com.tencent.mm.i.h)localObject1).dni = i;
      ((com.tencent.mm.i.h)localObject1).field_mediaId = str4;
      ((com.tencent.mm.i.h)localObject1).field_fullpath = str5;
      ((com.tencent.mm.i.h)localObject1).field_fileType = com.tencent.mm.i.a.MediaType_VIDEO;
      ((com.tencent.mm.i.h)localObject1).field_totalLen = j;
      ((com.tencent.mm.i.h)localObject1).field_aesKey = str2;
      ((com.tencent.mm.i.h)localObject1).field_fileId = ((String)localObject2);
      ((com.tencent.mm.i.h)localObject1).field_priority = com.tencent.mm.i.a.fqp;
      ((com.tencent.mm.i.h)localObject1).field_wxmsgparam = str3;
      if (!w.sQ(locals.getUser())) {
        break label517;
      }
      i = 1;
      label367:
      ((com.tencent.mm.i.h)localObject1).field_chattype = i;
      ((com.tencent.mm.i.h)localObject1).fry = locals.fry;
      paramString = ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().aF(locals.getUser(), locals.dpl);
      localObject2 = bi.yr(paramString.eul);
      ((com.tencent.mm.i.h)localObject1).frc = 0;
      ((com.tencent.mm.i.h)localObject1).frd = 0;
      ((com.tencent.mm.i.h)localObject1).frA = paramString.field_createTime;
      ((com.tencent.mm.i.h)localObject1).dpl = paramString.field_msgSvrId;
      if (localObject2 == null) {
        break label522;
      }
    }
    label517:
    label522:
    for (int i = ((bi.b)localObject2).hoM;; i = 0)
    {
      ((com.tencent.mm.i.h)localObject1).frB = i;
      if (((com.tencent.mm.i.h)localObject1).frc > 0) {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 36L, 1L, false);
      }
      ((com.tencent.mm.i.h)localObject1).field_autostart = false;
      ((com.tencent.mm.i.h)localObject1).field_requestVideoFormat = com.tencent.mm.modelcontrol.d.a(1, locals);
      AppMethodBeat.o(126737);
      return localObject1;
      i = 0;
      break;
      i = 0;
      break label367;
    }
  }
  
  public static com.tencent.mm.i.h a(bf parambf, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(126738);
    if (parambf == null)
    {
      ac.w("MicroMsg.OnlineVideoService", "check can sns online video, scene is null.");
      AppMethodBeat.o(126738);
      return null;
    }
    if (bs.isNullOrNil(paramString1))
    {
      ac.w("MicroMsg.OnlineVideoService", "check can sns online video, url is null.");
      AppMethodBeat.o(126738);
      return null;
    }
    Object localObject = u.Ej(paramString3);
    if (localObject == null)
    {
      ac.w("MicroMsg.OnlineVideoService", "check can sns online video, video info is null. %s", new Object[] { paramString3 });
      AppMethodBeat.o(126738);
      return null;
    }
    String str = c.a("snsvideo", parambf.gIh, "sns", paramString1);
    if (bs.isNullOrNil(str))
    {
      ac.w("MicroMsg.OnlineVideoService", "check can http online video, can not create media id. url %s ", new Object[] { paramString1 });
      AppMethodBeat.o(126738);
      return null;
    }
    com.tencent.mm.i.h localh = new com.tencent.mm.i.h();
    localh.filename = paramString3;
    localh.field_fullpath = paramString2;
    localh.field_mediaId = str;
    localh.frr = 2;
    localh.frw = paramInt;
    localh.fry = ((s)localObject).fry;
    if (parambf == null) {
      paramString3 = "";
    }
    for (;;)
    {
      int i = com.tencent.mm.protocal.d.DIc;
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agP();
      str = p.getString(com.tencent.mm.kernel.a.getUin());
      int j = ax.getNetTypeForStat(ai.getContext());
      int k = ax.getStrength(ai.getContext());
      label248:
      long l1;
      if (!bs.isNullOrNil(paramString3))
      {
        localObject = "&scene=".concat(String.valueOf(paramString3));
        localh.referer = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d%s", new Object[] { Integer.valueOf(i), str, Integer.valueOf(j), Integer.valueOf(k), localObject });
        localh.url = paramString1;
        paramString1 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getValue("SnsSightDomainList");
        long l2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getInt("SnsSightMainStandbyIpSwitchTime", 0);
        ac.i("MicroMsg.OnlineVideoService", "hostvalue %s dcipTime %s scene.time[%d]", new Object[] { paramString1, Long.valueOf(l2), Integer.valueOf(parambf.gIh) });
        l1 = l2;
        if (l2 <= 0L) {
          l1 = 259200L;
        }
      }
      for (boolean bool = a(parambf, localh.url, l1, paramString1);; bool = false)
      {
        try
        {
          localh.host = new URL(localh.url).getHost();
          paramString1 = new ArrayList();
          com.tencent.mm.network.b.b(bool, paramString1, localh.host);
          localh.fqT = new String[paramString1.size()];
          paramString1.toArray(localh.fqT);
          if (bs.pN(parambf.gIh) <= l1) {
            continue;
          }
          bool = true;
          localh.isColdSnsData = bool;
          localh.signalQuality = ax.getStrength(ai.getContext());
          localh.snsScene = paramString3;
          localh.concurrentCount = 5;
          if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pMd, false)) {
            localh.field_requestVideoFormat = com.tencent.mm.modelcontrol.d.H(paramInt, paramString2);
          }
          AppMethodBeat.o(126738);
          return localh;
        }
        catch (Exception parambf)
        {
          ac.printErrStackTrace("MicroMsg.OnlineVideoService", parambf, "check can sns online video error taskInfo %s", new Object[] { localh });
          AppMethodBeat.o(126738);
          return null;
        }
        if (parambf.equals(bf.GYA))
        {
          paramString3 = "album_friend";
          break;
        }
        if (parambf.equals(bf.GYB))
        {
          paramString3 = "album_self";
          break;
        }
        if (parambf.equals(bf.GYC))
        {
          paramString3 = "album_stranger";
          break;
        }
        if (parambf.equals(bf.GYD))
        {
          paramString3 = "profile_friend";
          break;
        }
        if (parambf.equals(bf.GYE))
        {
          paramString3 = "profile_stranger";
          break;
        }
        if (parambf.equals(bf.GYF))
        {
          paramString3 = "comment";
          break;
        }
        if (parambf.equals(bf.GYz))
        {
          paramString3 = "timeline";
          break;
        }
        if (parambf.equals(bf.GYI))
        {
          paramString3 = "snssight";
          break;
        }
        if (!parambf.equals(bf.GYK)) {
          break label773;
        }
        paramString3 = "storysight";
        break;
        localObject = "";
        break label248;
      }
      label773:
      paramString3 = "";
    }
  }
  
  static void a(s params, int paramInt, String paramString)
  {
    AppMethodBeat.i(126735);
    ac.i("MicroMsg.OnlineVideoService", "download finish. totalLen %d ", new Object[] { Integer.valueOf(paramInt) });
    if (params != null)
    {
      u.ar(params.getFileName(), paramInt);
      i(paramInt, paramString, params.getFileName());
    }
    AppMethodBeat.o(126735);
  }
  
  private static void a(PInt paramPInt1, PInt paramPInt2, String paramString, int paramInt)
  {
    AppMethodBeat.i(126743);
    int j = 0;
    paramString = u.Ej(paramString);
    if (paramString != null) {
      j = paramString.dnl;
    }
    for (int k = paramString.hux;; k = 0)
    {
      if (paramInt <= 0)
      {
        i = 1;
        paramPInt1.value = j;
        paramPInt2.value = i;
        ac.d("MicroMsg.OnlineVideoService", "getPreloadVideoInfo pHadPreloadSize[%d] pHadPreloadCompletion[%d]", new Object[] { Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value) });
        AppMethodBeat.o(126743);
        return;
      }
      int m = (int)(paramInt / 100.0F * k);
      if (j < m) {}
      for (int i = 2;; i = 3)
      {
        ac.d("MicroMsg.OnlineVideoService", "getPreloadVideoInfo %d * %d = configSize[%d] preloadSize[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j) });
        break;
      }
    }
  }
  
  private static void a(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, long paramLong1, long paramLong2, String paramString4, String[] paramArrayOfString, String paramString5, int paramInt3, int paramInt4, String paramString6)
  {
    AppMethodBeat.i(126744);
    lk locallk = new lk();
    locallk.dnf.dng = paramString1;
    locallk.dnf.dnh = paramString2;
    locallk.dnf.dni = paramInt1;
    locallk.dnf.fileId = paramString3;
    locallk.dnf.netType = paramInt2;
    locallk.dnf.startTime = paramLong1;
    locallk.dnf.endTime = paramLong2;
    locallk.dnf.path = paramString4;
    locallk.dnf.dnj = paramArrayOfString;
    locallk.dnf.dnk = paramString5;
    locallk.dnf.dnl = paramInt3;
    locallk.dnf.dnm = paramInt4;
    locallk.dnf.dnn = paramString6;
    com.tencent.mm.sdk.b.a.GpY.l(locallk);
    AppMethodBeat.o(126744);
  }
  
  public static void a(Object[] paramArrayOfObject, com.tencent.mm.i.d paramd, com.tencent.mm.i.h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(126742);
    if ((paramh == null) || (paramd == null))
    {
      ac.w("MicroMsg.OnlineVideoService", "video task info is null or download result is null.");
      AppMethodBeat.o(126742);
      return;
    }
    if ((!paramh.VA()) && (!paramh.VC()) && (!paramh.VE()))
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
      ac.i("MicroMsg.OnlineVideoService", "rpt online video format[%d] clientIp[%s] isCrossNet[%d]", new Object[] { Integer.valueOf(paramd.field_videoFormat), str2, Integer.valueOf(i4) });
      if (paramd.field_videoFormat == 2) {
        u.En(paramh.filename);
      }
      if (!bs.isNullOrNil(str2)) {
        break label1526;
      }
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 45L, 1L, false);
      if (!paramd.field_isCrossNet) {
        break label1543;
      }
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 47L, 1L, false);
      bool1 = paramh.VC();
      bool2 = paramh.VE();
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
      int i7 = paramh.fry;
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
        i17 = ax.iI(ai.getContext());
        str1 = paramd.Vy();
        PInt localPInt1 = new PInt();
        localPInt2 = new PInt();
        a(localPInt1, localPInt2, paramh.filename, paramh.frB);
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
        if (paramh.frx == null) {
          break label1599;
        }
        localObject2 = com.tencent.mm.b.g.getMessageDigest(paramh.frx.getBytes());
        label755:
        localStringBuffer.append(localObject2).append(",");
        if (!w.sQ(paramh.frx)) {
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
        localStringBuffer.append(paramh.frA).append(",");
        localStringBuffer.append(paramh.dpl).append(",");
        localStringBuffer.append(paramh.frc).append(",");
        localStringBuffer.append(paramd.field_videoFormat).append(",");
        label1182:
        localStringBuffer.append(str2).append(",");
        localStringBuffer.append(i4).append(",");
        localStringBuffer.append(paramh.frC).append(",");
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
        ac.i("MicroMsg.OnlineVideoService", "report online video %d:%s", new Object[] { Integer.valueOf(k), localObject2 });
        if (!bool1) {
          break label1747;
        }
        new cs((String)localObject2).aHZ();
        label1356:
        if (paramBoolean) {
          a(paramh.dng, paramh.frx, paramh.dni, paramd.field_fileId, i17, paramd.field_startTime, paramd.field_endTime, paramh.field_fullpath, paramd.field_usedSvrIps, paramh.url, localPInt1.value, localPInt2.value, paramh.dnn);
        }
        if (bool1)
        {
          if (paramd.field_videoFormat != 2) {
            break label2704;
          }
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 132L, 1L, false);
        }
      }
      for (;;)
      {
        paramArrayOfObject = u.Ej(paramh.filename);
        if (paramArrayOfObject != null)
        {
          paramArrayOfObject = ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().vP(paramArrayOfObject.iaJ);
          ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().a(new h.c(paramArrayOfObject.field_talker, "update", paramArrayOfObject));
        }
        AppMethodBeat.o(126742);
        return;
        i4 = 0;
        break;
        label1526:
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 46L, 1L, false);
        break label146;
        label1543:
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 48L, 1L, false);
        break label167;
        k = 31;
        break label412;
        label1567:
        localStringBuffer.append(paramh.url).append(",").append(paramh.frz).append(",");
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
        if (paramh.frx != null) {}
        for (localObject2 = com.tencent.mm.b.g.getMessageDigest(paramh.frx.getBytes());; localObject2 = Integer.valueOf(0))
        {
          localStringBuffer.append(localObject2).append(",");
          break;
        }
        label1717:
        localStringBuffer.append(com.tencent.mm.plugin.video.c.ayd(paramh.dnn)).append(",");
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
              k = bs.getInt(paramArrayOfObject[7].toString(), 0);
              bs.getInt(paramArrayOfObject[8].toString(), 0);
              i4 = bs.getInt(paramArrayOfObject[9].toString(), 0);
              localObject1 = paramArrayOfObject[11].toString();
              i5 = bs.getInt(paramArrayOfObject[12].toString(), 0);
              l1 = bs.getLong(paramArrayOfObject[13].toString(), 0L);
              i6 = bs.getInt(paramArrayOfObject[14].toString(), 0);
              i7 = bs.getInt(paramArrayOfObject[15].toString(), 0);
              i8 = bs.getInt(paramArrayOfObject[16].toString(), 0);
            }
          }
          paramArrayOfObject = new gk();
          localObject1 = paramArrayOfObject.nE((String)localObject1);
          ((gk)localObject1).ebw = i5;
          ((gk)localObject1).ebx = i7;
          ((gk)localObject1).eby = i6;
          ((gk)localObject1).dGo = i15;
          ((gk)localObject1).ebz = (i2 / 1000);
          ((gk)localObject1).dQA = j;
          ((gk)localObject1).dQB = i3;
          ((gk)localObject1).ebA = m;
          ((gk)localObject1).dQD = i;
          ((gk)localObject1).ebB = 0L;
          ((gk)localObject1).dQX = n;
          ((gk)localObject1).ebC = i1;
          localObject1 = ((gk)localObject1).nF("");
          ((gk)localObject1).dGp = (i16 * 1000);
          localObject1 = ((gk)localObject1).nG(paramh.field_requestVideoFormat);
          ((gk)localObject1).dDD = paramd.field_fileLength;
          ((gk)localObject1).ebF = paramd.field_recvedBytes;
          ((gk)localObject1).dQG = paramd.field_startTime;
          ((gk)localObject1).dQH = paramd.field_endTime;
          ((gk)localObject1).ebG = paramd.field_retCode;
          ((gk)localObject1).ebH = paramd.field_enQueueTime;
          ((gk)localObject1).ebI = paramd.field_moovRequestTimes;
          ((gk)localObject1).ebJ = paramd.field_moovCost;
          ((gk)localObject1).dQU = paramd.field_moovSize;
          if (paramd.field_moovCompleted)
          {
            l2 = 1L;
            ((gk)localObject1).ebK = l2;
            ((gk)localObject1).ebL = paramd.field_moovFailReason;
            ((gk)localObject1).ebM = paramd.field_firstConnectCost;
            ((gk)localObject1).ebN = paramd.field_firstRequestCost;
            ((gk)localObject1).ebO = paramd.field_firstRequestSize;
            ((gk)localObject1).ebP = paramd.field_firstRequestDownloadSize;
            if (!paramd.field_firstRequestCompleted) {
              break label2655;
            }
            l2 = 1L;
            label2287:
            ((gk)localObject1).ebQ = l2;
            ((gk)localObject1).ebR = paramd.field_averageSpeed;
            ((gk)localObject1).ebS = paramd.field_averageConnectCost;
            ((gk)localObject1).dQR = paramd.field_netConnectTimes;
            localObject1 = ((gk)localObject1).nH(paramd.Vy()).nI(paramd.field_clientIP);
            if (!paramd.field_isCrossNet) {
              break label2661;
            }
          }
          label2655:
          label2661:
          for (l2 = 1L;; l2 = 0L)
          {
            ((gk)localObject1).ebU = l2;
            ((gk)localObject1).dRf = paramh.frC;
            ((gk)localObject1).ebV = i4;
            ((gk)localObject1).dDB = i17;
            ((gk)localObject1).ebW = l1;
            ((gk)localObject1).dGw = k;
            ((gk)localObject1).ebX = i8;
            ((gk)localObject1).dRg = paramd.transportProtocol;
            ((gk)localObject1).dRh = paramd.transportProtocolError;
            ac.d("MicroMsg.OnlineVideoService", "time distance %d", new Object[] { Long.valueOf(System.currentTimeMillis() - paramArrayOfObject.ebW) });
            if (System.currentTimeMillis() - paramArrayOfObject.ebW > 500L) {
              paramArrayOfObject.aHZ();
            }
            if (!bool2) {
              break;
            }
            paramArrayOfObject = new es();
            localObject1 = com.tencent.mm.plugin.sight.base.e.asx(paramh.field_fullpath);
            if (localObject1 != null)
            {
              paramArrayOfObject.dGo = ((com.tencent.mm.plugin.sight.base.a)localObject1).videoDuration;
              paramArrayOfObject.dGp = ((com.tencent.mm.plugin.sight.base.a)localObject1).videoBitrate;
              paramArrayOfObject.dGq = ((com.tencent.mm.plugin.sight.base.a)localObject1).audioBitrate;
              paramArrayOfObject.dGr = ((com.tencent.mm.plugin.sight.base.a)localObject1).frameRate;
              paramArrayOfObject.dGs = ((com.tencent.mm.plugin.sight.base.a)localObject1).width;
              paramArrayOfObject.dGt = ((com.tencent.mm.plugin.sight.base.a)localObject1).height;
              paramArrayOfObject.dGv = ((com.tencent.mm.plugin.sight.base.a)localObject1).audioChannel;
            }
            paramArrayOfObject.dGn = paramd.field_fileLength;
            paramArrayOfObject = paramArrayOfObject.mt(paramh.url);
            f.aDE();
            paramArrayOfObject = paramArrayOfObject.mu(a.BM(paramh.field_fullpath));
            paramArrayOfObject.dGl = paramd.field_startTime;
            paramArrayOfObject.dGm = paramd.field_endTime;
            paramArrayOfObject = paramArrayOfObject.mv(str1);
            paramArrayOfObject.dGw = k;
            paramArrayOfObject.dGx = localPInt2.value;
            paramArrayOfObject.aHZ();
            break;
            l2 = 0L;
            break label2220;
            l2 = 0L;
            break label2287;
          }
        }
        label2220:
        paramArrayOfObject = new ee((String)localObject2);
        paramArrayOfObject.dUa = i5;
        paramArrayOfObject.lZ((String)localObject1);
        paramArrayOfObject.dTY = i6;
        paramArrayOfObject.aHZ();
        break label1356;
        label2704:
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 133L, 1L, false);
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
  
  private static boolean a(bf parambf, String paramString1, long paramLong, String paramString2)
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
      if (parambf == null)
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
      i = parambf.gIh;
      if (i == 0)
      {
        AppMethodBeat.o(126739);
        return false;
      }
      long l = bs.pN(parambf.gIh);
      if (l > paramLong)
      {
        AppMethodBeat.o(126739);
        return true;
      }
      AppMethodBeat.o(126739);
      return false;
    }
    catch (Exception parambf)
    {
      ac.e("MicroMsg.OnlineVideoService", "error for check dcip %s", new Object[] { parambf.getMessage() });
      AppMethodBeat.o(126739);
    }
    return false;
  }
  
  private static boolean i(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(126736);
    if (bs.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(126736);
      return false;
    }
    o.aJy();
    paramString2 = t.DV(paramString2);
    if ((bs.isNullOrNil(paramString1)) || (paramInt <= 0) || (bs.isNullOrNil(paramString2)))
    {
      ac.w("MicroMsg.OnlineVideoService", "insert media duplication but args is error.[%d, %s, %s]", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
      AppMethodBeat.o(126736);
      return false;
    }
    boolean bool = ((com.tencent.mm.plugin.n.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.n.a.a.class)).awI().D(paramString1, paramInt, paramString2);
    AppMethodBeat.o(126736);
    return bool;
  }
  
  public static int p(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126729);
    f.aDE();
    int i = a.requestVideoData(paramString, paramInt1, paramInt2, 0);
    ac.i("MicroMsg.OnlineVideoService", "request video video[%s], offset[%d], length[%d] duration[%d] ret[%d]", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0), Integer.valueOf(i) });
    AppMethodBeat.o(126729);
    return i;
  }
  
  public static void q(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(126740);
    if (paramArrayOfInt == null)
    {
      AppMethodBeat.o(126740);
      return;
    }
    com.tencent.mm.plugin.report.service.h.wUl.f(17891, new Object[] { Integer.valueOf(paramArrayOfInt[6]), Integer.valueOf(paramArrayOfInt[8]), Integer.valueOf(paramArrayOfInt[9]), Integer.valueOf(paramArrayOfInt[7]), Integer.valueOf(paramArrayOfInt[10]), Integer.valueOf(paramArrayOfInt[11]), Integer.valueOf(paramArrayOfInt[12]), Integer.valueOf(paramArrayOfInt[13]), Integer.valueOf(paramArrayOfInt[14]), Integer.valueOf(paramArrayOfInt[15]), Integer.valueOf(paramArrayOfInt[0]), Integer.valueOf(paramArrayOfInt[1]), Integer.valueOf(paramArrayOfInt[2]), Integer.valueOf(paramArrayOfInt[3]), Integer.valueOf(paramArrayOfInt[4]), Integer.valueOf(paramArrayOfInt[5]), Integer.valueOf(paramArrayOfInt[16]), Integer.valueOf(paramArrayOfInt[17]), Integer.valueOf(paramArrayOfInt[18]), Integer.valueOf(paramArrayOfInt[19]), Integer.valueOf(paramArrayOfInt[20]), Integer.valueOf(paramArrayOfInt[21]) });
    AppMethodBeat.o(126740);
  }
  
  public final int a(final String paramString, final com.tencent.mm.i.c paramc, final com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(126734);
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.OnlineVideoService", "cdn callback mediaid is null.");
      AppMethodBeat.o(126734);
      return -1;
    }
    if ((paramc == null) && (paramd == null))
    {
      ac.e("MicroMsg.OnlineVideoService", "cdn callback info all null.");
      AppMethodBeat.o(126734);
      return -2;
    }
    com.tencent.mm.kernel.g.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(169094);
        Object localObject = (com.tencent.mm.i.h)e.this.hBl.get(paramString);
        if (localObject == null)
        {
          AppMethodBeat.o(169094);
          return;
        }
        if (((com.tencent.mm.i.h)localObject).frE != null)
        {
          ac.i("MicroMsg.OnlineVideoService", "cdn callback %s route to videoCallback", new Object[] { paramString });
          if (paramc != null)
          {
            ((com.tencent.mm.i.h)localObject).frE.i(paramString, paramc.field_finishedLength, paramc.field_toltalLength);
            AppMethodBeat.o(169094);
            return;
          }
          if (paramd != null)
          {
            ac.i("MicroMsg.OnlineVideoService", "cdn callback %s route to videoCallback, sceneResult.retCode:%s", new Object[] { paramString, Integer.valueOf(paramd.field_retCode) });
            ((com.tencent.mm.i.h)localObject).frE.a(paramString, paramd.field_retCode, paramd);
            e.this.hBl.remove(paramString);
            if (paramd.field_retCode == 0)
            {
              e.this.hBP.put(((com.tencent.mm.i.h)localObject).field_mediaId, localObject);
              e.this.hBQ.put(((com.tencent.mm.i.h)localObject).field_mediaId, paramd);
            }
            AppMethodBeat.o(169094);
            return;
          }
          AppMethodBeat.o(169094);
          return;
        }
        s locals = u.Ej(((com.tencent.mm.i.h)localObject).filename);
        if (locals == null)
        {
          ac.w("MicroMsg.OnlineVideoService", "stream download video callback, but video info is null.[%s]", new Object[] { ((com.tencent.mm.i.h)localObject).filename });
          AppMethodBeat.o(169094);
          return;
        }
        if (((com.tencent.mm.i.h)localObject).frb != null)
        {
          ((com.tencent.mm.i.h)localObject).frb.a(paramString, 0, paramc, paramd, ((com.tencent.mm.i.h)localObject).field_onlycheckexist);
          if (paramd != null) {
            e.this.hBl.remove(paramString);
          }
          AppMethodBeat.o(169094);
          return;
        }
        if (paramc != null)
        {
          if (paramc.field_finishedLength == locals.hux)
          {
            ac.i("MicroMsg.OnlineVideoService", "stream download finish.");
            AppMethodBeat.o(169094);
            return;
          }
          if ((locals.status != 130) && (locals.iaE > paramc.field_finishedLength))
          {
            ac.w("MicroMsg.OnlineVideoService", "set video error. db now size %d, cdn callback %d.", new Object[] { Integer.valueOf(locals.iaE), Long.valueOf(paramc.field_finishedLength) });
            AppMethodBeat.o(169094);
            return;
          }
          ac.i("MicroMsg.OnlineVideoService", "callback progress info " + paramc.field_finishedLength);
          locals.iaH = bs.aNx();
          locals.iaE = ((int)paramc.field_finishedLength);
          locals.drx = 1040;
          u.f(locals);
          localObject = new np();
          ((np)localObject).dpX.dgL = 5;
          ((np)localObject).dpX.mediaId = paramString;
          ((np)localObject).dpX.offset = ((int)paramc.field_finishedLength);
          ((np)localObject).dpX.length = ((int)paramc.field_toltalLength);
          com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
          AppMethodBeat.o(169094);
          return;
        }
        int i;
        int j;
        if (paramd != null)
        {
          ac.i("MicroMsg.OnlineVideoService", "callback result info " + paramd.field_retCode + ", filesize:" + paramd.field_fileLength + ",recved:" + paramd.field_recvedBytes);
          if (paramd.field_retCode == 0) {
            break label1130;
          }
          if (paramd.field_retCode != -10012) {
            u.Ea(locals.getFileName());
          }
          boolean bool = ((com.tencent.mm.i.h)localObject).VC();
          i = paramd.field_retCode;
          j = ((com.tencent.mm.i.h)localObject).frw;
          if (!bool) {
            break label1039;
          }
          if (j != 1) {
            break label950;
          }
          if (i != -5103059) {
            break label885;
          }
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 111L, 1L, false);
          com.tencent.mm.plugin.report.service.h.wUl.f(13836, new Object[] { Integer.valueOf(101), Long.valueOf(bs.aNx()), Integer.valueOf(i) });
        }
        for (;;)
        {
          localObject = new np();
          ((np)localObject).dpX.dgL = 4;
          ((np)localObject).dpX.mediaId = paramString;
          ((np)localObject).dpX.offset = 0;
          ((np)localObject).dpX.retCode = paramd.field_retCode;
          ((np)localObject).dpX.length = ((int)paramd.field_fileLength);
          com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
          e.this.hBl.remove(paramString);
          AppMethodBeat.o(169094);
          return;
          label885:
          if (i == -5103087)
          {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 112L, 1L, false);
            break;
          }
          if (i == -10012)
          {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 113L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 114L, 1L, false);
          break;
          label950:
          if (i == -5103059)
          {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 116L, 1L, false);
            break;
          }
          if (i == -5103087)
          {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 117L, 1L, false);
            break;
          }
          if (i == -10012)
          {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 118L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 119L, 1L, false);
          break;
          label1039:
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 213L, 1L, false);
          if (j == 1) {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 214L, 1L, false);
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.wUl.f(13836, new Object[] { Integer.valueOf(201), Long.valueOf(bs.aNx()), Integer.valueOf(i) });
            break;
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 215L, 1L, false);
          }
          label1130:
          e.a(locals, (int)paramd.field_fileLength, ((com.tencent.mm.i.h)localObject).fru);
          e.this.hBP.put(((com.tencent.mm.i.h)localObject).field_mediaId, localObject);
          e.this.hBQ.put(((com.tencent.mm.i.h)localObject).field_mediaId, paramd);
        }
      }
    });
    if (this.hBl.get(paramString) != null)
    {
      AppMethodBeat.o(126734);
      return 1;
    }
    AppMethodBeat.o(126734);
    return 0;
  }
  
  public final boolean a(final com.tencent.mm.i.h paramh)
  {
    AppMethodBeat.i(126725);
    if (paramh == null)
    {
      ac.e("MicroMsg.OnlineVideoService", "add download task, but task is null.");
      AppMethodBeat.o(126725);
      return false;
    }
    if (bs.isNullOrNil(paramh.field_mediaId))
    {
      ac.e("MicroMsg.OnlineVideoService", "add download task, but task mediaId is null.");
      AppMethodBeat.o(126725);
      return false;
    }
    ac.i("MicroMsg.OnlineVideoService", "add download task : " + paramh.field_mediaId);
    if (paramh.field_fileId == null) {
      paramh.field_fileId = "";
    }
    if (paramh.field_aesKey == null) {
      paramh.field_aesKey = "";
    }
    paramh.dBE = false;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126715);
          e.this.hBj.add(paramh.field_mediaId);
          e.this.hBk.put(paramh.field_mediaId, paramh);
          e.this.eJ(false);
          AppMethodBeat.o(126715);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(126725);
      return true;
      this.hBj.add(paramh.field_mediaId);
      this.hBk.put(paramh.field_mediaId, paramh);
      eJ(false);
    }
  }
  
  public final boolean a(final com.tencent.mm.i.h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(126724);
    if (paramh == null)
    {
      ac.e("MicroMsg.OnlineVideoService", "add download task, but task is null.");
      AppMethodBeat.o(126724);
      return false;
    }
    if (bs.isNullOrNil(paramh.field_mediaId))
    {
      ac.e("MicroMsg.OnlineVideoService", "add download task, but task mediaId is null.");
      AppMethodBeat.o(126724);
      return false;
    }
    ac.i("MicroMsg.OnlineVideoService", "add download task : " + paramh.field_mediaId + " delay : " + paramBoolean);
    if (paramh.field_fileId == null) {
      paramh.field_fileId = "";
    }
    if (paramh.field_aesKey == null) {
      paramh.field_aesKey = "";
    }
    paramh.dBE = false;
    if ((k(paramh.field_mediaId, null)) || (paramBoolean)) {
      com.tencent.mm.kernel.g.agU().az(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126713);
          e.this.hBj.add(paramh.field_mediaId);
          e.this.hBk.put(paramh.field_mediaId, paramh);
          e.this.eJ(false);
          AppMethodBeat.o(126713);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(126724);
      return true;
      com.tencent.mm.kernel.g.agU().az(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126714);
          e.this.hBj.add(paramh.field_mediaId);
          e.this.hBk.put(paramh.field_mediaId, paramh);
          e.this.eJ(false);
          AppMethodBeat.o(126714);
        }
      });
    }
  }
  
  public final boolean a(final String paramString, final a parama)
  {
    AppMethodBeat.i(169096);
    boolean bool1 = false;
    boolean bool2 = false;
    if (!bs.isNullOrNil(paramString)) {
      if (!this.hBl.containsKey(paramString)) {
        break label90;
      }
    }
    for (bool1 = true;; bool1 = bool2)
    {
      com.tencent.mm.kernel.g.agU().az(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126718);
          Object localObject1 = (com.tencent.mm.i.h)e.this.hBl.remove(paramString);
          Object localObject2;
          int i;
          if (localObject1 != null)
          {
            localObject2 = new com.tencent.mm.i.d();
            f.aDE();
            i = a.c(((com.tencent.mm.i.h)localObject1).field_mediaId, (com.tencent.mm.i.d)localObject2);
            if (i == 0) {
              e.a(this.hBW, (com.tencent.mm.i.d)localObject2, (com.tencent.mm.i.h)localObject1, false);
            }
          }
          for (;;)
          {
            e.this.hBk.remove(paramString);
            if (parama != null) {
              parama.a((com.tencent.mm.i.h)localObject1, (com.tencent.mm.i.d)localObject2);
            }
            AppMethodBeat.o(126718);
            return;
            ac.w("MicroMsg.OnlineVideoService", "stop video stream download error. ret %d, mediaId %s", new Object[] { Integer.valueOf(i), ((com.tencent.mm.i.h)localObject1).field_mediaId });
            continue;
            com.tencent.mm.i.h localh = (com.tencent.mm.i.h)e.this.hBP.remove(paramString);
            com.tencent.mm.i.d locald = (com.tencent.mm.i.d)e.this.hBQ.remove(paramString);
            localObject1 = localh;
            localObject2 = locald;
            if (localh != null)
            {
              localObject1 = localh;
              localObject2 = locald;
              if (locald != null)
              {
                e.a(this.hBW, locald, localh, true);
                localObject1 = localh;
                localObject2 = locald;
              }
            }
          }
        }
      });
      ac.i("MicroMsg.OnlineVideoService", "cancelDownloadTaskWithCallback mediaId : " + paramString + " remove : " + bool1);
      AppMethodBeat.o(169096);
      return bool1;
      label90:
      f.aDD().BR(paramString);
    }
  }
  
  public final int d(final String paramString1, final int paramInt1, final int paramInt2, final String paramString2)
  {
    AppMethodBeat.i(209959);
    this.hBR.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126719);
        ac.i("MicroMsg.OnlineVideoService", "onMoovReady mediaId[%s]", new Object[] { paramString1 });
        if (bs.isNullOrNil(paramString1))
        {
          AppMethodBeat.o(126719);
          return;
        }
        com.tencent.mm.kernel.g.agU().az(new Runnable()
        {
          public final void run()
          {
            boolean bool2 = true;
            AppMethodBeat.i(169095);
            com.tencent.mm.i.h localh = (com.tencent.mm.i.h)e.this.hBl.get(e.10.this.JY);
            Object localObject = new StringBuilder("info=").append(localh).append(" mediaId=").append(e.10.this.JY).append(" info.videoCallback=");
            if ((localh != null) && (localh.frE == null)) {}
            for (boolean bool1 = true;; bool1 = false)
            {
              ac.w("MicroMsg.OnlineVideoService", bool1);
              if (localh == null) {
                break label507;
              }
              localh.frC = e.10.this.hBT;
              if (localh.frE == null) {
                break;
              }
              localh.frE.a(e.10.this.JY, e.10.this.hBT, e.10.this.hBU, e.10.this.hBY);
              AppMethodBeat.o(169095);
              return;
            }
            if (r.DP(localh.field_fullpath))
            {
              ac.w("MicroMsg.OnlineVideoService", "it is qt video, need finish all file. isPlayMode" + localh.frw);
              if (localh.frw == 1)
              {
                e.p(localh.field_mediaId, 0, localh.field_totalLen);
                com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 19L, 1L, false);
              }
              AppMethodBeat.o(169095);
              return;
            }
            localObject = new np();
            ((np)localObject).dpX.dgL = 1;
            ((np)localObject).dpX.retCode = 0;
            ((np)localObject).dpX.mediaId = e.10.this.JY;
            ((np)localObject).dpX.offset = e.10.this.hBT;
            ((np)localObject).dpX.length = e.10.this.hBU;
            ((np)localObject).dpX.dpY = localh.frt;
            np.a locala = ((np)localObject).dpX;
            if (localh.frc > 0) {}
            for (bool1 = bool2;; bool1 = false)
            {
              locala.dpZ = bool1;
              com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
              localObject = u.Ej(localh.filename);
              if (localObject == null) {
                break label507;
              }
              ac.i("MicroMsg.OnlineVideoService", "on moov ready info: " + ((s)localObject).getFileName() + " status : " + ((s)localObject).status);
              if (((s)localObject).status != 130) {
                break;
              }
              AppMethodBeat.o(169095);
              return;
            }
            if (((s)localObject).status != 122)
            {
              localObject = u.Ej(localh.filename);
              if (localObject != null)
              {
                ((s)localObject).status = 121;
                ((s)localObject).drx = 256;
                o.aJy().c((s)localObject);
              }
              if (localh.frw == 0)
              {
                ac.i("MicroMsg.OnlineVideoService", "stop download video");
                o.aJD().aJV();
                o.aJD().run();
              }
            }
            label507:
            AppMethodBeat.o(169095);
          }
        });
        AppMethodBeat.o(126719);
      }
    });
    if (this.hBl.containsKey(paramString1))
    {
      AppMethodBeat.o(209959);
      return 1;
    }
    AppMethodBeat.o(209959);
    return 0;
  }
  
  public final void eJ(boolean paramBoolean)
  {
    AppMethodBeat.i(126730);
    if (!com.tencent.mm.kernel.g.agM())
    {
      AppMethodBeat.o(126730);
      return;
    }
    if ((!paramBoolean) && (f.aDE().aDx()))
    {
      com.tencent.mm.kernel.g.agP();
      if (com.tencent.mm.kernel.a.afX())
      {
        ac.w("MicroMsg.OnlineVideoService", "cdn engine not init cdn dnsinfo , will retry after set info");
        f.aDD().eJ(paramBoolean);
        AppMethodBeat.o(126730);
        return;
      }
    }
    f.aDD().aDy();
    while (!this.hBj.isEmpty())
    {
      Object localObject1 = (String)this.hBj.poll();
      Object localObject2 = (com.tencent.mm.i.h)this.hBk.remove(localObject1);
      if (localObject2 != null)
      {
        ((com.tencent.mm.i.h)localObject2).field_startTime = bs.eWj();
        if (!((com.tencent.mm.i.h)localObject2).dBE)
        {
          if (((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GJM, Integer.valueOf(-1))).intValue() == 2) {
            ac.i("MicroMsg.OnlineVideoService", "command set do not check media duplication.");
          }
          label167:
          int j;
          for (int i = 0;; i = 1)
          {
            if (i == 0) {
              break label410;
            }
            localObject2 = new np();
            ((np)localObject2).dpX.dgL = 6;
            ((np)localObject2).dpX.mediaId = ((String)localObject1);
            com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject2);
            break;
            if (((com.tencent.mm.i.h)localObject2).VD()) {
              break label167;
            }
            Object localObject3 = ((com.tencent.mm.i.h)localObject2).fru;
            i = ((com.tencent.mm.i.h)localObject2).frv;
            Object localObject4 = ((com.tencent.mm.plugin.n.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.n.a.a.class)).awI().fT((String)localObject3, i);
            j = i - (int)i.aSp((String)localObject4);
            if ((bs.isNullOrNil((String)localObject4)) || (j < 0) || (j > 16)) {
              break label167;
            }
            ac.i("MicroMsg.OnlineVideoService", "it had download this video[%d, %s, %s].", new Object[] { Integer.valueOf(i), localObject3, localObject4 });
            i.lZ((String)localObject4, ((com.tencent.mm.i.h)localObject2).field_fullpath);
            localObject4 = u.Ej(((com.tencent.mm.i.h)localObject2).filename);
            a((s)localObject4, i, (String)localObject3);
            localObject3 = ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().vP(((s)localObject4).iaJ);
            ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().a(new h.c(((dy)localObject3).field_talker, "update", (bo)localObject3));
          }
          label410:
          if (((com.tencent.mm.i.h)localObject2).VC())
          {
            i = f.aDE().a((com.tencent.mm.i.g)localObject2, ((com.tencent.mm.i.h)localObject2).frw);
            label432:
            ac.i("MicroMsg.OnlineVideoService", "start task %s streaming download. ret %d ", new Object[] { localObject2, Integer.valueOf(i) });
            if (i == 0) {
              break label1156;
            }
            ac.w("MicroMsg.OnlineVideoService", "start stream video error. ret : " + i + " media id: " + ((com.tencent.mm.i.h)localObject2).field_mediaId);
            paramBoolean = ((com.tencent.mm.i.h)localObject2).VC();
            j = ((com.tencent.mm.i.h)localObject2).frw;
            if (!paramBoolean) {
              break label1066;
            }
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 3L, 1L, false);
            if (j != 1) {
              break label1001;
            }
            if (i != -21006) {
              break label960;
            }
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 100L, 1L, false);
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.wUl.f(13836, new Object[] { Integer.valueOf(100), Long.valueOf(bs.aNx()), "" });
            break;
            if (((com.tencent.mm.i.h)localObject2).VA())
            {
              i = f.aDE().a(((com.tencent.mm.i.h)localObject2).field_mediaId, ((com.tencent.mm.i.h)localObject2).url, ((com.tencent.mm.i.h)localObject2).referer, ((com.tencent.mm.i.h)localObject2).field_fullpath, ((com.tencent.mm.i.h)localObject2).frw, ((com.tencent.mm.i.h)localObject2).fqT, ((com.tencent.mm.i.h)localObject2).isColdSnsData, ((com.tencent.mm.i.h)localObject2).signalQuality, ((com.tencent.mm.i.h)localObject2).snsScene, ((com.tencent.mm.i.h)localObject2).field_preloadRatio, ((com.tencent.mm.i.h)localObject2).preloadMinSize, ((com.tencent.mm.i.h)localObject2).field_requestVideoFormat, 4, ((com.tencent.mm.i.h)localObject2).concurrentCount);
              break label432;
            }
            if (((com.tencent.mm.i.h)localObject2).VE())
            {
              i = f.aDE().a(((com.tencent.mm.i.h)localObject2).field_mediaId, ((com.tencent.mm.i.h)localObject2).url, ((com.tencent.mm.i.h)localObject2).referer, ((com.tencent.mm.i.h)localObject2).field_fullpath, ((com.tencent.mm.i.h)localObject2).frw, ((com.tencent.mm.i.h)localObject2).fqT, ((com.tencent.mm.i.h)localObject2).isColdSnsData, ((com.tencent.mm.i.h)localObject2).signalQuality, ((com.tencent.mm.i.h)localObject2).snsScene, ((com.tencent.mm.i.h)localObject2).field_preloadRatio, ((com.tencent.mm.i.h)localObject2).preloadMinSize, ((com.tencent.mm.i.h)localObject2).field_requestVideoFormat, 4);
              break label432;
            }
            if (((com.tencent.mm.i.h)localObject2).VF())
            {
              i = f.aDE().a(((com.tencent.mm.i.h)localObject2).field_mediaId, ((com.tencent.mm.i.h)localObject2).url, ((com.tencent.mm.i.h)localObject2).referer, ((com.tencent.mm.i.h)localObject2).field_fullpath, ((com.tencent.mm.i.h)localObject2).frw, ((com.tencent.mm.i.h)localObject2).fqT, ((com.tencent.mm.i.h)localObject2).isColdSnsData, ((com.tencent.mm.i.h)localObject2).signalQuality, ((com.tencent.mm.i.h)localObject2).snsScene, ((com.tencent.mm.i.h)localObject2).field_preloadRatio, ((com.tencent.mm.i.h)localObject2).preloadMinSize, ((com.tencent.mm.i.h)localObject2).field_requestVideoFormat, ((com.tencent.mm.i.h)localObject2).connectionCount, ((com.tencent.mm.i.h)localObject2).frD, ((com.tencent.mm.i.h)localObject2).videoFlag, ((com.tencent.mm.i.h)localObject2).snsCipherKey);
              break label432;
            }
            if (((com.tencent.mm.i.h)localObject2).VB())
            {
              i = f.aDE().a(((com.tencent.mm.i.h)localObject2).field_mediaId, ((com.tencent.mm.i.h)localObject2).url, ((com.tencent.mm.i.h)localObject2).referer, ((com.tencent.mm.i.h)localObject2).field_fullpath, ((com.tencent.mm.i.h)localObject2).frw, ((com.tencent.mm.i.h)localObject2).field_preloadRatio, ((com.tencent.mm.i.h)localObject2).preloadMinSize, ((com.tencent.mm.i.h)localObject2).concurrentCount);
              break label432;
            }
            i = f.aDE().a(((com.tencent.mm.i.h)localObject2).field_mediaId, ((com.tencent.mm.i.h)localObject2).url, ((com.tencent.mm.i.h)localObject2).referer, ((com.tencent.mm.i.h)localObject2).field_fullpath, ((com.tencent.mm.i.h)localObject2).frw, ((com.tencent.mm.i.h)localObject2).fqT, ((com.tencent.mm.i.h)localObject2).field_preloadRatio, ((com.tencent.mm.i.h)localObject2).preloadMinSize);
            break label432;
            label960:
            if (i == -20003)
            {
              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 101L, 1L, false);
            }
            else
            {
              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 102L, 1L, false);
              continue;
              label1001:
              if (i == -21006) {
                com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 106L, 1L, false);
              } else if (i == -20003) {
                com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 107L, 1L, false);
              } else {
                com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 108L, 1L, false);
              }
            }
          }
          label1066:
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 210L, 1L, false);
          if (j == 1) {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 211L, 1L, false);
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.wUl.f(13836, new Object[] { Integer.valueOf(200), Long.valueOf(bs.aNx()), "" });
            break;
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 212L, 1L, false);
          }
          label1156:
          ((com.tencent.mm.i.h)localObject2).frt = bs.eWj();
          if (((com.tencent.mm.i.h)localObject2).VC())
          {
            localObject1 = u.Ej(((com.tencent.mm.i.h)localObject2).filename);
            if (localObject1 != null)
            {
              i = ((s)localObject1).status;
              if ((i != 120) && (i != 122) && (i != 121))
              {
                ((s)localObject1).status = 120;
                ((s)localObject1).drx = 256;
                o.aJy().c((s)localObject1);
              }
            }
          }
          this.hBl.put(((com.tencent.mm.i.h)localObject2).field_mediaId, localObject2);
        }
      }
    }
    AppMethodBeat.o(126730);
  }
  
  public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126728);
    if ((com.tencent.mm.i.h)this.hBl.get(paramString) == null)
    {
      ac.i("MicroMsg.OnlineVideoService", "this media[%s] don't download now.", new Object[] { paramString });
      AppMethodBeat.o(126728);
      return false;
    }
    f.aDE();
    boolean bool = a.isVideoDataAvailable(paramString, paramInt1, paramInt2);
    ac.i("MicroMsg.OnlineVideoService", "is video[%s] data[%d, %d] available[%b]", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
    AppMethodBeat.o(126728);
    return bool;
  }
  
  public final boolean j(final String paramString, final Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(126726);
    boolean bool;
    if (!bs.isNullOrNil(paramString)) {
      if (this.hBl.containsKey(paramString))
      {
        bool = true;
        if (Looper.myLooper() == Looper.getMainLooper()) {
          break label107;
        }
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(126716);
            com.tencent.mm.i.h localh = (com.tencent.mm.i.h)e.this.hBl.remove(paramString);
            com.tencent.mm.i.d locald;
            int i;
            if (localh != null)
            {
              locald = new com.tencent.mm.i.d();
              f.aDE();
              i = a.c(localh.field_mediaId, locald);
              if (i == 0) {
                e.a(paramArrayOfObject, locald, localh, false);
              }
            }
            for (;;)
            {
              e.this.hBk.remove(paramString);
              AppMethodBeat.o(126716);
              return;
              ac.w("MicroMsg.OnlineVideoService", "stop video stream download error. ret %d, mediaId %s", new Object[] { Integer.valueOf(i), localh.field_mediaId });
              continue;
              localh = (com.tencent.mm.i.h)e.this.hBP.remove(paramString);
              locald = (com.tencent.mm.i.d)e.this.hBQ.remove(paramString);
              if ((localh != null) && (locald != null)) {
                e.a(paramArrayOfObject, locald, localh, true);
              }
            }
          }
        });
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.OnlineVideoService", "cancelDownloadTaskInMainThread mediaId : " + paramString + " remove : " + bool);
      AppMethodBeat.o(126726);
      return bool;
      f.aDD().BR(paramString);
      bool = false;
      break;
      label107:
      com.tencent.mm.i.h localh = (com.tencent.mm.i.h)this.hBl.remove(paramString);
      com.tencent.mm.i.d locald;
      int i;
      if (localh != null)
      {
        locald = new com.tencent.mm.i.d();
        f.aDE();
        i = a.c(localh.field_mediaId, locald);
        if (i == 0) {
          a(paramArrayOfObject, locald, localh, false);
        }
      }
      for (;;)
      {
        this.hBk.remove(paramString);
        break;
        ac.w("MicroMsg.OnlineVideoService", "stop video stream download error. ret %d, mediaId %s", new Object[] { Integer.valueOf(i), localh.field_mediaId });
        continue;
        localh = (com.tencent.mm.i.h)this.hBP.remove(paramString);
        locald = (com.tencent.mm.i.d)this.hBQ.remove(paramString);
        if ((localh != null) && (locald != null)) {
          a(paramArrayOfObject, locald, localh, true);
        }
      }
      bool = false;
    }
  }
  
  public final boolean k(final String paramString, final Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(126727);
    boolean bool1 = false;
    boolean bool2 = false;
    if (!bs.isNullOrNil(paramString)) {
      if (!this.hBl.containsKey(paramString)) {
        break label90;
      }
    }
    for (bool1 = true;; bool1 = bool2)
    {
      com.tencent.mm.kernel.g.agU().az(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126717);
          com.tencent.mm.i.h localh = (com.tencent.mm.i.h)e.this.hBl.remove(paramString);
          com.tencent.mm.i.d locald;
          int i;
          if (localh != null)
          {
            locald = new com.tencent.mm.i.d();
            f.aDE();
            i = a.c(localh.field_mediaId, locald);
            if (i == 0) {
              e.a(paramArrayOfObject, locald, localh, false);
            }
          }
          for (;;)
          {
            e.this.hBk.remove(paramString);
            AppMethodBeat.o(126717);
            return;
            ac.w("MicroMsg.OnlineVideoService", "stop video stream download error. ret %d, mediaId %s", new Object[] { Integer.valueOf(i), localh.field_mediaId });
            continue;
            localh = (com.tencent.mm.i.h)e.this.hBP.remove(paramString);
            locald = (com.tencent.mm.i.d)e.this.hBQ.remove(paramString);
            if ((localh != null) && (locald != null)) {
              e.a(paramArrayOfObject, locald, localh, true);
            }
          }
        }
      });
      ac.i("MicroMsg.OnlineVideoService", "cancelDownloadTask mediaId : " + paramString + " remove : " + bool1);
      AppMethodBeat.o(126727);
      return bool1;
      label90:
      f.aDD().BR(paramString);
    }
  }
  
  public final int n(final String paramString, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(209960);
    ac.i("MicroMsg.OnlineVideoService", "onDataAvailable. offset %d, length %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(209960);
      return 0;
    }
    com.tencent.mm.kernel.g.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126720);
        Object localObject = (com.tencent.mm.i.h)e.this.hBl.get(paramString);
        if (localObject != null)
        {
          if (((com.tencent.mm.i.h)localObject).frE != null) {
            ((com.tencent.mm.i.h)localObject).frE.onDataAvailable(paramString, paramInt1, paramInt2);
          }
          localObject = new np();
          ((np)localObject).dpX.dgL = 2;
          ((np)localObject).dpX.retCode = 0;
          ((np)localObject).dpX.mediaId = paramString;
          ((np)localObject).dpX.offset = paramInt1;
          ((np)localObject).dpX.length = paramInt2;
          com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
        }
        AppMethodBeat.o(126720);
      }
    });
    if (this.hBl.containsKey(paramString))
    {
      AppMethodBeat.o(209960);
      return 1;
    }
    AppMethodBeat.o(209960);
    return 0;
  }
  
  public final int o(final String paramString, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(209961);
    ac.i("MicroMsg.OnlineVideoService", "onDownloadToEnd. offset %d, length %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(209961);
      return 0;
    }
    com.tencent.mm.kernel.g.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126712);
        com.tencent.mm.i.h localh = (com.tencent.mm.i.h)e.this.hBl.get(paramString);
        if (localh != null)
        {
          np localnp = new np();
          localnp.dpX.dgL = 3;
          localnp.dpX.retCode = 0;
          localnp.dpX.mediaId = paramString;
          localnp.dpX.offset = paramInt1;
          localnp.dpX.length = paramInt2;
          com.tencent.mm.sdk.b.a.GpY.l(localnp);
          if ((paramInt1 == 0) && (paramInt2 >= localh.frv)) {
            e.a(u.Ej(localh.filename), localh.frv, localh.fru);
          }
        }
        AppMethodBeat.o(126712);
      }
    });
    if (this.hBl.containsKey(paramString))
    {
      AppMethodBeat.o(209961);
      return 1;
    }
    AppMethodBeat.o(209961);
    return 0;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(126723);
    if (paramn.getType() != 379)
    {
      AppMethodBeat.o(126723);
      return;
    }
    ac.i("MicroMsg.OnlineVideoService", "it get cdn dns success[%d, %d], try to start.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (com.tencent.mm.kernel.g.agP().afY()) {
      com.tencent.mm.kernel.g.agU().az(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126711);
          e.this.eJ(true);
          AppMethodBeat.o(126711);
        }
      });
    }
    AppMethodBeat.o(126723);
  }
  
  public final void release()
  {
    AppMethodBeat.i(126722);
    com.tencent.mm.kernel.g.agi().b(379, this);
    AppMethodBeat.o(126722);
  }
  
  public static abstract interface a
  {
    public abstract void a(com.tencent.mm.i.h paramh, com.tencent.mm.i.d paramd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.an.e
 * JD-Core Version:    0.7.0.1
 */