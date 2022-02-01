package com.tencent.mm.an;

import android.os.Looper;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.p;
import com.tencent.mm.g.a.lu;
import com.tencent.mm.g.a.ny;
import com.tencent.mm.g.a.ny.a;
import com.tencent.mm.g.b.a.dn;
import com.tencent.mm.g.b.a.ff;
import com.tencent.mm.g.b.a.ft;
import com.tencent.mm.g.b.a.hp;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.h;
import com.tencent.mm.i.h.a;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bl.b;
import com.tencent.mm.model.x;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.modelvideo.y.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bv;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class e
  implements com.tencent.mm.ak.f, a.a
{
  aq gKO;
  Queue<String> hWA;
  Map<String, h> hWB;
  Map<String, h> hWC;
  Map<String, h> hXn;
  Map<String, com.tencent.mm.i.d> hXo;
  private final aq hXp;
  
  public e()
  {
    AppMethodBeat.i(126721);
    this.hWA = new LinkedList();
    this.hWB = new HashMap();
    this.hWC = new HashMap();
    this.hXn = new HashMap();
    this.hXo = new HashMap();
    this.hXp = new aq(Looper.getMainLooper());
    this.gKO = new aq(Looper.getMainLooper());
    com.tencent.mm.kernel.g.ajj().a(379, this);
    AppMethodBeat.o(126721);
  }
  
  public static h Fu(String paramString)
  {
    AppMethodBeat.i(126737);
    if (com.tencent.mm.sdk.platformtools.bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(126737);
      return null;
    }
    s locals = u.Ia(paramString);
    if (locals == null)
    {
      AppMethodBeat.o(126737);
      return null;
    }
    Object localObject1 = bx.M(locals.aNt(), "msg");
    if (localObject1 == null)
    {
      ae.w("MicroMsg.OnlineVideoService", "cdntra parse video recv xml failed");
      AppMethodBeat.o(126737);
      return null;
    }
    Object localObject2 = (String)((Map)localObject1).get(".msg.videomsg.$cdnvideourl");
    if (com.tencent.mm.sdk.platformtools.bu.isNullOrNil((String)localObject2))
    {
      ae.w("MicroMsg.OnlineVideoService", "cdntra parse video recv xml failed");
      AppMethodBeat.o(126737);
      return null;
    }
    int j = com.tencent.mm.sdk.platformtools.bu.getInt((String)((Map)localObject1).get(".msg.videomsg.$length"), 0);
    String str1 = (String)((Map)localObject1).get(".msg.videomsg.$md5");
    String str2 = (String)((Map)localObject1).get(".msg.videomsg.$aeskey");
    String str3 = (String)((Map)localObject1).get(".msg.videomsg.$fileparam");
    String str4 = c.a("downvideo", locals.createTime, locals.getUser(), locals.getFileName());
    if (com.tencent.mm.sdk.platformtools.bu.isNullOrNil(str4))
    {
      ae.w("MicroMsg.OnlineVideoService", "cdntra genClientId failed not use cdn file:%s", new Object[] { locals.getFileName() });
      AppMethodBeat.o(126737);
      return null;
    }
    com.tencent.mm.modelvideo.o.aNh();
    String str5 = t.HJ(paramString);
    localObject1 = new h();
    ((h)localObject1).fLl = "task_OnlineVideoService_1";
    ((h)localObject1).filename = paramString;
    ((h)localObject1).fLG = str1;
    ((h)localObject1).fLH = j;
    ((h)localObject1).fLI = 1;
    ((h)localObject1).dzZ = locals.aNq();
    ((h)localObject1).fLJ = locals.getUser();
    if (x.wb(locals.getUser()))
    {
      i = com.tencent.mm.model.r.zC(locals.getUser());
      ((h)localObject1).dAb = i;
      ((h)localObject1).field_mediaId = str4;
      ((h)localObject1).field_fullpath = str5;
      ((h)localObject1).field_fileType = com.tencent.mm.i.a.MediaType_VIDEO;
      ((h)localObject1).field_totalLen = j;
      ((h)localObject1).field_aesKey = str2;
      ((h)localObject1).field_fileId = ((String)localObject2);
      ((h)localObject1).field_priority = com.tencent.mm.i.a.fKA;
      ((h)localObject1).field_wxmsgparam = str3;
      if (!x.wb(locals.getUser())) {
        break label524;
      }
      i = 1;
      label374:
      ((h)localObject1).field_chattype = i;
      ((h)localObject1).fLK = locals.fLK;
      paramString = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().aJ(locals.getUser(), locals.dCd);
      localObject2 = bl.BS(paramString.eNd);
      ((h)localObject1).fLn = 0;
      ((h)localObject1).fLo = 0;
      ((h)localObject1).fLM = paramString.field_createTime;
      ((h)localObject1).dCd = paramString.field_msgSvrId;
      if (localObject2 == null) {
        break label529;
      }
    }
    label524:
    label529:
    for (int i = ((bl.b)localObject2).hJW;; i = 0)
    {
      ((h)localObject1).fLN = i;
      if (((h)localObject1).fLn > 0) {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 36L, 1L, false);
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
  
  public static h a(bk parambk, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(126738);
    if (parambk == null)
    {
      ae.w("MicroMsg.OnlineVideoService", "check can sns online video, scene is null.");
      AppMethodBeat.o(126738);
      return null;
    }
    if (com.tencent.mm.sdk.platformtools.bu.isNullOrNil(paramString1))
    {
      ae.w("MicroMsg.OnlineVideoService", "check can sns online video, url is null.");
      AppMethodBeat.o(126738);
      return null;
    }
    Object localObject = u.Ia(paramString3);
    if (localObject == null)
    {
      ae.w("MicroMsg.OnlineVideoService", "check can sns online video, video info is null. %s", new Object[] { paramString3 });
      AppMethodBeat.o(126738);
      return null;
    }
    String str = c.a("snsvideo", parambk.heF, "sns", paramString1);
    if (com.tencent.mm.sdk.platformtools.bu.isNullOrNil(str))
    {
      ae.w("MicroMsg.OnlineVideoService", "check can http online video, can not create media id. url %s ", new Object[] { paramString1 });
      AppMethodBeat.o(126738);
      return null;
    }
    h localh = new h();
    localh.fLl = "task_OnlineVideoService_2";
    localh.filename = paramString3;
    localh.field_fullpath = paramString2;
    localh.field_mediaId = str;
    localh.fLD = 2;
    localh.fLI = paramInt;
    localh.fLK = ((s)localObject).fLK;
    if (parambk == null) {
      paramString3 = "";
    }
    for (;;)
    {
      int i = com.tencent.mm.protocal.d.FFH;
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajP();
      str = p.getString(com.tencent.mm.kernel.a.getUin());
      int j = az.getNetTypeForStat(ak.getContext());
      int k = az.getStrength(ak.getContext());
      label256:
      long l1;
      if (!com.tencent.mm.sdk.platformtools.bu.isNullOrNil(paramString3))
      {
        localObject = "&scene=".concat(String.valueOf(paramString3));
        localh.referer = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d%s", new Object[] { Integer.valueOf(i), str, Integer.valueOf(j), Integer.valueOf(k), localObject });
        localh.url = paramString1;
        paramString1 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getValue("SnsSightDomainList");
        long l2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getInt("SnsSightMainStandbyIpSwitchTime", 0);
        ae.i("MicroMsg.OnlineVideoService", "hostvalue %s dcipTime %s scene.time[%d]", new Object[] { paramString1, Long.valueOf(l2), Integer.valueOf(parambk.heF) });
        l1 = l2;
        if (l2 <= 0L) {
          l1 = 259200L;
        }
      }
      for (boolean bool = a(parambk, localh.url, l1, paramString1);; bool = false)
      {
        try
        {
          localh.host = new URL(localh.url).getHost();
          paramString1 = new ArrayList();
          com.tencent.mm.network.b.b(bool, paramString1, localh.host);
          localh.fLe = new String[paramString1.size()];
          paramString1.toArray(localh.fLe);
          if (com.tencent.mm.sdk.platformtools.bu.rZ(parambk.heF) <= l1) {
            continue;
          }
          bool = true;
          localh.isColdSnsData = bool;
          localh.signalQuality = az.getStrength(ak.getContext());
          localh.snsScene = paramString3;
          localh.concurrentCount = 5;
          if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qwy, false)) {
            localh.field_requestVideoFormat = com.tencent.mm.modelcontrol.d.H(paramInt, paramString2);
          }
          AppMethodBeat.o(126738);
          return localh;
        }
        catch (Exception parambk)
        {
          ae.printErrStackTrace("MicroMsg.OnlineVideoService", parambk, "check can sns online video error taskInfo %s", new Object[] { localh });
          AppMethodBeat.o(126738);
          return null;
        }
        if (parambk.equals(bk.Jgv))
        {
          paramString3 = "album_friend";
          break;
        }
        if (parambk.equals(bk.Jgw))
        {
          paramString3 = "album_self";
          break;
        }
        if (parambk.equals(bk.Jgx))
        {
          paramString3 = "album_stranger";
          break;
        }
        if (parambk.equals(bk.Jgy))
        {
          paramString3 = "profile_friend";
          break;
        }
        if (parambk.equals(bk.Jgz))
        {
          paramString3 = "profile_stranger";
          break;
        }
        if (parambk.equals(bk.JgA))
        {
          paramString3 = "comment";
          break;
        }
        if (parambk.equals(bk.Jgu))
        {
          paramString3 = "timeline";
          break;
        }
        if (parambk.equals(bk.JgD))
        {
          paramString3 = "snssight";
          break;
        }
        if (!parambk.equals(bk.JgF)) {
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
    ae.i("MicroMsg.OnlineVideoService", "download finish. totalLen %d ", new Object[] { Integer.valueOf(paramInt) });
    if (params != null)
    {
      u.au(params.getFileName(), paramInt);
      i(paramInt, paramString, params.getFileName());
    }
    AppMethodBeat.o(126735);
  }
  
  private static void a(PInt paramPInt1, PInt paramPInt2, String paramString, int paramInt)
  {
    AppMethodBeat.i(126743);
    int j = 0;
    paramString = u.Ia(paramString);
    if (paramString != null) {
      j = paramString.dAe;
    }
    for (int k = paramString.hPI;; k = 0)
    {
      if (paramInt <= 0)
      {
        i = 1;
        paramPInt1.value = j;
        paramPInt2.value = i;
        ae.d("MicroMsg.OnlineVideoService", "getPreloadVideoInfo pHadPreloadSize[%d] pHadPreloadCompletion[%d]", new Object[] { Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value) });
        AppMethodBeat.o(126743);
        return;
      }
      int m = (int)(paramInt / 100.0F * k);
      if (j < m) {}
      for (int i = 2;; i = 3)
      {
        ae.d("MicroMsg.OnlineVideoService", "getPreloadVideoInfo %d * %d = configSize[%d] preloadSize[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j) });
        break;
      }
    }
  }
  
  private static void a(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, long paramLong1, long paramLong2, String paramString4, String[] paramArrayOfString, String paramString5, int paramInt3, int paramInt4, String paramString6)
  {
    AppMethodBeat.i(126744);
    lu locallu = new lu();
    locallu.dzY.dzZ = paramString1;
    locallu.dzY.dAa = paramString2;
    locallu.dzY.dAb = paramInt1;
    locallu.dzY.fileId = paramString3;
    locallu.dzY.netType = paramInt2;
    locallu.dzY.startTime = paramLong1;
    locallu.dzY.endTime = paramLong2;
    locallu.dzY.path = paramString4;
    locallu.dzY.dAc = paramArrayOfString;
    locallu.dzY.dAd = paramString5;
    locallu.dzY.dAe = paramInt3;
    locallu.dzY.dAf = paramInt4;
    locallu.dzY.dAg = paramString6;
    com.tencent.mm.sdk.b.a.IvT.l(locallu);
    AppMethodBeat.o(126744);
  }
  
  public static void a(Object[] paramArrayOfObject, com.tencent.mm.i.d paramd, h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(126742);
    if ((paramh == null) || (paramd == null))
    {
      ae.w("MicroMsg.OnlineVideoService", "video task info is null or download result is null.");
      AppMethodBeat.o(126742);
      return;
    }
    if ((!paramh.Yb()) && (!paramh.Yd()) && (!paramh.Yf()))
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
      ae.i("MicroMsg.OnlineVideoService", "rpt online video format[%d] clientIp[%s] isCrossNet[%d]", new Object[] { Integer.valueOf(paramd.field_videoFormat), str2, Integer.valueOf(i4) });
      if (paramd.field_videoFormat == 2) {
        u.Ie(paramh.filename);
      }
      if (!com.tencent.mm.sdk.platformtools.bu.isNullOrNil(str2)) {
        break label1526;
      }
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 45L, 1L, false);
      if (!paramd.field_isCrossNet) {
        break label1543;
      }
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 47L, 1L, false);
      bool1 = paramh.Yd();
      bool2 = paramh.Yf();
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
      int i7 = paramh.fLK;
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
        i17 = az.iX(ak.getContext());
        str1 = paramd.XZ();
        PInt localPInt1 = new PInt();
        localPInt2 = new PInt();
        a(localPInt1, localPInt2, paramh.filename, paramh.fLN);
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
        if (paramh.fLJ == null) {
          break label1599;
        }
        localObject2 = com.tencent.mm.b.g.getMessageDigest(paramh.fLJ.getBytes());
        label755:
        localStringBuffer.append(localObject2).append(",");
        if (!x.wb(paramh.fLJ)) {
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
        localStringBuffer.append(paramh.fLM).append(",");
        localStringBuffer.append(paramh.dCd).append(",");
        localStringBuffer.append(paramh.fLn).append(",");
        localStringBuffer.append(paramd.field_videoFormat).append(",");
        label1182:
        localStringBuffer.append(str2).append(",");
        localStringBuffer.append(i4).append(",");
        localStringBuffer.append(paramh.fLO).append(",");
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
        ae.i("MicroMsg.OnlineVideoService", "report online video %d:%s", new Object[] { Integer.valueOf(k), localObject2 });
        if (!bool1) {
          break label1747;
        }
        new dn((String)localObject2).aLH();
        label1356:
        if (paramBoolean) {
          a(paramh.dzZ, paramh.fLJ, paramh.dAb, paramd.field_fileId, i17, paramd.field_startTime, paramd.field_endTime, paramh.field_fullpath, paramd.field_usedSvrIps, paramh.url, localPInt1.value, localPInt2.value, paramh.dAg);
        }
        if (bool1)
        {
          if (paramd.field_videoFormat != 2) {
            break label2704;
          }
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 132L, 1L, false);
        }
      }
      for (;;)
      {
        paramArrayOfObject = u.Ia(paramh.filename);
        if (paramArrayOfObject != null)
        {
          paramArrayOfObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ys(paramArrayOfObject.iwZ);
          ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().a(new i.c(paramArrayOfObject.field_talker, "update", paramArrayOfObject));
        }
        AppMethodBeat.o(126742);
        return;
        i4 = 0;
        break;
        label1526:
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 46L, 1L, false);
        break label146;
        label1543:
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 48L, 1L, false);
        break label167;
        k = 31;
        break label412;
        label1567:
        localStringBuffer.append(paramh.url).append(",").append(paramh.fLL).append(",");
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
        if (paramh.fLJ != null) {}
        for (localObject2 = com.tencent.mm.b.g.getMessageDigest(paramh.fLJ.getBytes());; localObject2 = Integer.valueOf(0))
        {
          localStringBuffer.append(localObject2).append(",");
          break;
        }
        label1717:
        localStringBuffer.append(com.tencent.mm.plugin.video.c.aEB(paramh.dAg)).append(",");
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
              k = com.tencent.mm.sdk.platformtools.bu.getInt(paramArrayOfObject[7].toString(), 0);
              com.tencent.mm.sdk.platformtools.bu.getInt(paramArrayOfObject[8].toString(), 0);
              i4 = com.tencent.mm.sdk.platformtools.bu.getInt(paramArrayOfObject[9].toString(), 0);
              localObject1 = paramArrayOfObject[11].toString();
              i5 = com.tencent.mm.sdk.platformtools.bu.getInt(paramArrayOfObject[12].toString(), 0);
              l1 = com.tencent.mm.sdk.platformtools.bu.getLong(paramArrayOfObject[13].toString(), 0L);
              i6 = com.tencent.mm.sdk.platformtools.bu.getInt(paramArrayOfObject[14].toString(), 0);
              i7 = com.tencent.mm.sdk.platformtools.bu.getInt(paramArrayOfObject[15].toString(), 0);
              i8 = com.tencent.mm.sdk.platformtools.bu.getInt(paramArrayOfObject[16].toString(), 0);
            }
          }
          paramArrayOfObject = new hp();
          localObject1 = paramArrayOfObject.qy((String)localObject1);
          ((hp)localObject1).etI = i5;
          ((hp)localObject1).etJ = i7;
          ((hp)localObject1).etK = i6;
          ((hp)localObject1).dUJ = i15;
          ((hp)localObject1).etL = (i2 / 1000);
          ((hp)localObject1).ehH = j;
          ((hp)localObject1).ehI = i3;
          ((hp)localObject1).etM = m;
          ((hp)localObject1).ehK = i;
          ((hp)localObject1).etN = 0L;
          ((hp)localObject1).eie = n;
          ((hp)localObject1).etO = i1;
          localObject1 = ((hp)localObject1).qz("");
          ((hp)localObject1).dUK = (i16 * 1000);
          localObject1 = ((hp)localObject1).qA(paramh.field_requestVideoFormat);
          ((hp)localObject1).dRQ = paramd.field_fileLength;
          ((hp)localObject1).etR = paramd.field_recvedBytes;
          ((hp)localObject1).ehN = paramd.field_startTime;
          ((hp)localObject1).ehO = paramd.field_endTime;
          ((hp)localObject1).etS = paramd.field_retCode;
          ((hp)localObject1).etT = paramd.field_enQueueTime;
          ((hp)localObject1).etU = paramd.field_moovRequestTimes;
          ((hp)localObject1).etV = paramd.field_moovCost;
          ((hp)localObject1).eib = paramd.field_moovSize;
          if (paramd.field_moovCompleted)
          {
            l2 = 1L;
            ((hp)localObject1).etW = l2;
            ((hp)localObject1).etX = paramd.field_moovFailReason;
            ((hp)localObject1).etY = paramd.field_firstConnectCost;
            ((hp)localObject1).etZ = paramd.field_firstRequestCost;
            ((hp)localObject1).eua = paramd.field_firstRequestSize;
            ((hp)localObject1).eub = paramd.field_firstRequestDownloadSize;
            if (!paramd.field_firstRequestCompleted) {
              break label2655;
            }
            l2 = 1L;
            label2287:
            ((hp)localObject1).euc = l2;
            ((hp)localObject1).eud = paramd.field_averageSpeed;
            ((hp)localObject1).eue = paramd.field_averageConnectCost;
            ((hp)localObject1).ehY = paramd.field_netConnectTimes;
            localObject1 = ((hp)localObject1).qB(paramd.XZ()).qC(paramd.field_clientIP);
            if (!paramd.field_isCrossNet) {
              break label2661;
            }
          }
          label2655:
          label2661:
          for (l2 = 1L;; l2 = 0L)
          {
            ((hp)localObject1).eug = l2;
            ((hp)localObject1).eim = paramh.fLO;
            ((hp)localObject1).euh = i4;
            ((hp)localObject1).dRO = i17;
            ((hp)localObject1).eui = l1;
            ((hp)localObject1).dUR = k;
            ((hp)localObject1).euj = i8;
            ((hp)localObject1).ein = paramd.transportProtocol;
            ((hp)localObject1).eio = paramd.transportProtocolError;
            ae.d("MicroMsg.OnlineVideoService", "time distance %d", new Object[] { Long.valueOf(System.currentTimeMillis() - paramArrayOfObject.eui) });
            if (System.currentTimeMillis() - paramArrayOfObject.eui > 500L) {
              paramArrayOfObject.aLH();
            }
            if (!bool2) {
              break;
            }
            paramArrayOfObject = new ft();
            localObject1 = com.tencent.mm.plugin.sight.base.e.ayN(paramh.field_fullpath);
            if (localObject1 != null)
            {
              paramArrayOfObject.dUJ = ((com.tencent.mm.plugin.sight.base.a)localObject1).videoDuration;
              paramArrayOfObject.dUK = ((com.tencent.mm.plugin.sight.base.a)localObject1).videoBitrate;
              paramArrayOfObject.dUL = ((com.tencent.mm.plugin.sight.base.a)localObject1).audioBitrate;
              paramArrayOfObject.dUM = ((com.tencent.mm.plugin.sight.base.a)localObject1).frameRate;
              paramArrayOfObject.dUN = ((com.tencent.mm.plugin.sight.base.a)localObject1).width;
              paramArrayOfObject.dUO = ((com.tencent.mm.plugin.sight.base.a)localObject1).height;
              paramArrayOfObject.dUQ = ((com.tencent.mm.plugin.sight.base.a)localObject1).audioChannel;
            }
            paramArrayOfObject.dUI = paramd.field_fileLength;
            paramArrayOfObject = paramArrayOfObject.pb(paramh.url);
            f.aHa();
            paramArrayOfObject = paramArrayOfObject.pc(a.Fn(paramh.field_fullpath));
            paramArrayOfObject.dUG = paramd.field_startTime;
            paramArrayOfObject.dUH = paramd.field_endTime;
            paramArrayOfObject = paramArrayOfObject.pd(str1);
            paramArrayOfObject.dUR = k;
            paramArrayOfObject.dUS = localPInt2.value;
            paramArrayOfObject.aLH();
            break;
            l2 = 0L;
            break label2220;
            l2 = 0L;
            break label2287;
          }
        }
        label2220:
        paramArrayOfObject = new ff((String)localObject2);
        paramArrayOfObject.elZ = i5;
        paramArrayOfObject.oH((String)localObject1);
        paramArrayOfObject.elX = i6;
        paramArrayOfObject.aLH();
        break label1356;
        label2704:
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 133L, 1L, false);
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
  
  private static boolean a(bk parambk, String paramString1, long paramLong, String paramString2)
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
      if (parambk == null)
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
      i = parambk.heF;
      if (i == 0)
      {
        AppMethodBeat.o(126739);
        return false;
      }
      long l = com.tencent.mm.sdk.platformtools.bu.rZ(parambk.heF);
      if (l > paramLong)
      {
        AppMethodBeat.o(126739);
        return true;
      }
      AppMethodBeat.o(126739);
      return false;
    }
    catch (Exception parambk)
    {
      ae.e("MicroMsg.OnlineVideoService", "error for check dcip %s", new Object[] { parambk.getMessage() });
      AppMethodBeat.o(126739);
    }
    return false;
  }
  
  private static boolean i(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(126736);
    if (com.tencent.mm.sdk.platformtools.bu.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(126736);
      return false;
    }
    com.tencent.mm.modelvideo.o.aNh();
    paramString2 = t.HJ(paramString2);
    if ((com.tencent.mm.sdk.platformtools.bu.isNullOrNil(paramString1)) || (paramInt <= 0) || (com.tencent.mm.sdk.platformtools.bu.isNullOrNil(paramString2)))
    {
      ae.w("MicroMsg.OnlineVideoService", "insert media duplication but args is error.[%d, %s, %s]", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
      AppMethodBeat.o(126736);
      return false;
    }
    boolean bool = ((com.tencent.mm.plugin.n.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.n.a.a.class)).azN().G(paramString1, paramInt, paramString2);
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
    com.tencent.mm.plugin.report.service.g.yxI.f(17891, new Object[] { Integer.valueOf(paramArrayOfInt[6]), Integer.valueOf(paramArrayOfInt[8]), Integer.valueOf(paramArrayOfInt[9]), Integer.valueOf(paramArrayOfInt[7]), Integer.valueOf(paramArrayOfInt[10]), Integer.valueOf(paramArrayOfInt[11]), Integer.valueOf(paramArrayOfInt[12]), Integer.valueOf(paramArrayOfInt[13]), Integer.valueOf(paramArrayOfInt[14]), Integer.valueOf(paramArrayOfInt[15]), Integer.valueOf(paramArrayOfInt[0]), Integer.valueOf(paramArrayOfInt[1]), Integer.valueOf(paramArrayOfInt[2]), Integer.valueOf(paramArrayOfInt[3]), Integer.valueOf(paramArrayOfInt[4]), Integer.valueOf(paramArrayOfInt[5]), Integer.valueOf(paramArrayOfInt[16]), Integer.valueOf(paramArrayOfInt[17]), Integer.valueOf(paramArrayOfInt[18]), Integer.valueOf(paramArrayOfInt[19]), Integer.valueOf(paramArrayOfInt[20]), Integer.valueOf(paramArrayOfInt[21]), Integer.valueOf(paramArrayOfInt[22]), Integer.valueOf(paramArrayOfInt[23]), Integer.valueOf(paramArrayOfInt[24]), Integer.valueOf(paramArrayOfInt[25]), Integer.valueOf(paramArrayOfInt[26]), Integer.valueOf(paramArrayOfInt[27]), Integer.valueOf(paramArrayOfInt[28]), Integer.valueOf(paramArrayOfInt[29]), Integer.valueOf(paramArrayOfInt[30]), Integer.valueOf(paramArrayOfInt[31]), Integer.valueOf(paramArrayOfInt[32]), Integer.valueOf(paramArrayOfInt[33]) });
    AppMethodBeat.o(126740);
  }
  
  public static int r(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126729);
    f.aHa();
    int i = a.requestVideoData(paramString, paramInt1, paramInt2, 0);
    ae.i("MicroMsg.OnlineVideoService", "request video video[%s], offset[%d], length[%d] duration[%d] ret[%d]", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0), Integer.valueOf(i) });
    AppMethodBeat.o(126729);
    return i;
  }
  
  public final int a(final String paramString, final com.tencent.mm.i.c paramc, final com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(126734);
    if (com.tencent.mm.sdk.platformtools.bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.OnlineVideoService", "cdn callback mediaid is null.");
      AppMethodBeat.o(126734);
      return -1;
    }
    if ((paramc == null) && (paramd == null))
    {
      ae.e("MicroMsg.OnlineVideoService", "cdn callback info all null.");
      AppMethodBeat.o(126734);
      return -2;
    }
    com.tencent.mm.kernel.g.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(169094);
        Object localObject = (h)e.this.hWC.get(paramString);
        if (localObject == null)
        {
          AppMethodBeat.o(169094);
          return;
        }
        if (((h)localObject).fLQ != null)
        {
          ae.i("MicroMsg.OnlineVideoService", "cdn callback %s route to videoCallback", new Object[] { paramString });
          if (paramc != null)
          {
            ((h)localObject).fLQ.i(paramString, paramc.field_finishedLength, paramc.field_toltalLength);
            AppMethodBeat.o(169094);
            return;
          }
          if (paramd != null)
          {
            ae.i("MicroMsg.OnlineVideoService", "cdn callback %s route to videoCallback, sceneResult.retCode:%s", new Object[] { paramString, Integer.valueOf(paramd.field_retCode) });
            ((h)localObject).fLQ.a(paramString, paramd.field_retCode, paramd);
            e.this.hWC.remove(paramString);
            if (paramd.field_retCode == 0)
            {
              e.this.hXn.put(((h)localObject).field_mediaId, localObject);
              e.this.hXo.put(((h)localObject).field_mediaId, paramd);
            }
            AppMethodBeat.o(169094);
            return;
          }
          AppMethodBeat.o(169094);
          return;
        }
        s locals = u.Ia(((h)localObject).filename);
        if (locals == null)
        {
          ae.w("MicroMsg.OnlineVideoService", "stream download video callback, but video info is null.[%s]", new Object[] { ((h)localObject).filename });
          AppMethodBeat.o(169094);
          return;
        }
        if (((h)localObject).fLm != null)
        {
          ((h)localObject).fLm.a(paramString, 0, paramc, paramd, ((h)localObject).field_onlycheckexist);
          if (paramd != null) {
            e.this.hWC.remove(paramString);
          }
          AppMethodBeat.o(169094);
          return;
        }
        if (paramc != null)
        {
          if (paramc.field_finishedLength == locals.hPI)
          {
            ae.i("MicroMsg.OnlineVideoService", "stream download finish.");
            AppMethodBeat.o(169094);
            return;
          }
          if ((locals.status != 130) && (locals.iwU > paramc.field_finishedLength))
          {
            ae.w("MicroMsg.OnlineVideoService", "set video error. db now size %d, cdn callback %d.", new Object[] { Integer.valueOf(locals.iwU), Long.valueOf(paramc.field_finishedLength) });
            AppMethodBeat.o(169094);
            return;
          }
          ae.i("MicroMsg.OnlineVideoService", "callback progress info " + paramc.field_finishedLength);
          locals.iwX = com.tencent.mm.sdk.platformtools.bu.aRi();
          locals.iwU = ((int)paramc.field_finishedLength);
          locals.dEu = 1040;
          u.f(locals);
          localObject = new ny();
          ((ny)localObject).dCP.dto = 5;
          ((ny)localObject).dCP.mediaId = paramString;
          ((ny)localObject).dCP.offset = ((int)paramc.field_finishedLength);
          ((ny)localObject).dCP.length = ((int)paramc.field_toltalLength);
          com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
          AppMethodBeat.o(169094);
          return;
        }
        int i;
        int j;
        if (paramd != null)
        {
          ae.i("MicroMsg.OnlineVideoService", "callback result info " + paramd.field_retCode + ", filesize:" + paramd.field_fileLength + ",recved:" + paramd.field_recvedBytes);
          if (paramd.field_retCode == 0) {
            break label1130;
          }
          if (paramd.field_retCode != -10012) {
            u.HR(locals.getFileName());
          }
          boolean bool = ((h)localObject).Yd();
          i = paramd.field_retCode;
          j = ((h)localObject).fLI;
          if (!bool) {
            break label1039;
          }
          if (j != 1) {
            break label950;
          }
          if (i != -5103059) {
            break label885;
          }
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 111L, 1L, false);
          com.tencent.mm.plugin.report.service.g.yxI.f(13836, new Object[] { Integer.valueOf(101), Long.valueOf(com.tencent.mm.sdk.platformtools.bu.aRi()), Integer.valueOf(i) });
        }
        for (;;)
        {
          localObject = new ny();
          ((ny)localObject).dCP.dto = 4;
          ((ny)localObject).dCP.mediaId = paramString;
          ((ny)localObject).dCP.offset = 0;
          ((ny)localObject).dCP.retCode = paramd.field_retCode;
          ((ny)localObject).dCP.length = ((int)paramd.field_fileLength);
          com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
          e.this.hWC.remove(paramString);
          AppMethodBeat.o(169094);
          return;
          label885:
          if (i == -5103087)
          {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 112L, 1L, false);
            break;
          }
          if (i == -10012)
          {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 113L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 114L, 1L, false);
          break;
          label950:
          if (i == -5103059)
          {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 116L, 1L, false);
            break;
          }
          if (i == -5103087)
          {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 117L, 1L, false);
            break;
          }
          if (i == -10012)
          {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 118L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 119L, 1L, false);
          break;
          label1039:
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 213L, 1L, false);
          if (j == 1) {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 214L, 1L, false);
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.g.yxI.f(13836, new Object[] { Integer.valueOf(201), Long.valueOf(com.tencent.mm.sdk.platformtools.bu.aRi()), Integer.valueOf(i) });
            break;
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 215L, 1L, false);
          }
          label1130:
          e.a(locals, (int)paramd.field_fileLength, ((h)localObject).fLG);
          e.this.hXn.put(((h)localObject).field_mediaId, localObject);
          e.this.hXo.put(((h)localObject).field_mediaId, paramd);
        }
      }
    });
    if (this.hWC.get(paramString) != null)
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
      ae.e("MicroMsg.OnlineVideoService", "add download task, but task is null.");
      AppMethodBeat.o(126725);
      return false;
    }
    if (com.tencent.mm.sdk.platformtools.bu.isNullOrNil(paramh.field_mediaId))
    {
      ae.e("MicroMsg.OnlineVideoService", "add download task, but task mediaId is null.");
      AppMethodBeat.o(126725);
      return false;
    }
    ae.i("MicroMsg.OnlineVideoService", "add download task : " + paramh.field_mediaId);
    if (paramh.field_fileId == null) {
      paramh.field_fileId = "";
    }
    if (paramh.field_aesKey == null) {
      paramh.field_aesKey = "";
    }
    paramh.dPh = false;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126715);
          e.this.gKO.removeCallbacksAndMessages(paramh.field_mediaId);
          e.this.hWA.add(paramh.field_mediaId);
          e.this.hWB.put(paramh.field_mediaId, paramh);
          e.this.eN(false);
          AppMethodBeat.o(126715);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(126725);
      return true;
      this.gKO.removeCallbacksAndMessages(paramh.field_mediaId);
      this.hWA.add(paramh.field_mediaId);
      this.hWB.put(paramh.field_mediaId, paramh);
      eN(false);
    }
  }
  
  public final boolean a(final h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(126724);
    if (paramh == null)
    {
      ae.e("MicroMsg.OnlineVideoService", "add download task, but task is null.");
      AppMethodBeat.o(126724);
      return false;
    }
    if (com.tencent.mm.sdk.platformtools.bu.isNullOrNil(paramh.field_mediaId))
    {
      ae.e("MicroMsg.OnlineVideoService", "add download task, but task mediaId is null.");
      AppMethodBeat.o(126724);
      return false;
    }
    ae.i("MicroMsg.OnlineVideoService", "add download task : " + paramh.field_mediaId + " delay : " + paramBoolean);
    if (paramh.field_fileId == null) {
      paramh.field_fileId = "";
    }
    if (paramh.field_aesKey == null) {
      paramh.field_aesKey = "";
    }
    paramh.dPh = false;
    if ((m(paramh.field_mediaId, null)) || (paramBoolean)) {
      com.tencent.mm.kernel.g.ajU().aw(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126713);
          e.this.hWA.add(paramh.field_mediaId);
          e.this.hWB.put(paramh.field_mediaId, paramh);
          e.this.eN(false);
          AppMethodBeat.o(126713);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(126724);
      return true;
      com.tencent.mm.kernel.g.ajU().aw(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126714);
          e.this.hWA.add(paramh.field_mediaId);
          e.this.hWB.put(paramh.field_mediaId, paramh);
          e.this.eN(false);
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
    if (!com.tencent.mm.sdk.platformtools.bu.isNullOrNil(paramString)) {
      if (!this.hWC.containsKey(paramString)) {
        break label90;
      }
    }
    for (bool1 = true;; bool1 = bool2)
    {
      com.tencent.mm.kernel.g.ajU().aw(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126718);
          Object localObject1 = (h)e.this.hWC.remove(paramString);
          Object localObject2;
          int i;
          if (localObject1 != null)
          {
            localObject2 = new com.tencent.mm.i.d();
            f.aHa();
            i = a.c(((h)localObject1).field_mediaId, (com.tencent.mm.i.d)localObject2);
            if (i == 0) {
              e.a(this.hXu, (com.tencent.mm.i.d)localObject2, (h)localObject1, false);
            }
          }
          for (;;)
          {
            e.this.hWB.remove(paramString);
            if (parama != null) {
              parama.a((h)localObject1, (com.tencent.mm.i.d)localObject2);
            }
            AppMethodBeat.o(126718);
            return;
            ae.w("MicroMsg.OnlineVideoService", "stop video stream download error. ret %d, mediaId %s", new Object[] { Integer.valueOf(i), ((h)localObject1).field_mediaId });
            continue;
            h localh = (h)e.this.hXn.remove(paramString);
            com.tencent.mm.i.d locald = (com.tencent.mm.i.d)e.this.hXo.remove(paramString);
            localObject1 = localh;
            localObject2 = locald;
            if (localh != null)
            {
              localObject1 = localh;
              localObject2 = locald;
              if (locald != null)
              {
                e.a(this.hXu, locald, localh, true);
                localObject1 = localh;
                localObject2 = locald;
              }
            }
          }
        }
      });
      ae.i("MicroMsg.OnlineVideoService", "cancelDownloadTaskWithCallback mediaId : " + paramString + " remove : " + bool1);
      AppMethodBeat.o(169096);
      return bool1;
      label90:
      f.aGZ().Fs(paramString);
    }
  }
  
  public final int d(final String paramString1, final int paramInt1, final int paramInt2, final String paramString2)
  {
    AppMethodBeat.i(217452);
    this.hXp.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126719);
        ae.i("MicroMsg.OnlineVideoService", "onMoovReady mediaId[%s]", new Object[] { paramString1 });
        if (com.tencent.mm.sdk.platformtools.bu.isNullOrNil(paramString1))
        {
          AppMethodBeat.o(126719);
          return;
        }
        com.tencent.mm.kernel.g.ajU().aw(new Runnable()
        {
          public final void run()
          {
            boolean bool2 = true;
            AppMethodBeat.i(169095);
            h localh = (h)e.this.hWC.get(e.10.this.LO);
            Object localObject = new StringBuilder("info=").append(localh).append(" mediaId=").append(e.10.this.LO).append(" info.videoCallback=");
            if ((localh != null) && (localh.fLQ == null)) {}
            for (boolean bool1 = true;; bool1 = false)
            {
              ae.w("MicroMsg.OnlineVideoService", bool1);
              if (localh == null) {
                break label507;
              }
              localh.fLO = e.10.this.hXr;
              if (localh.fLQ == null) {
                break;
              }
              localh.fLQ.a(e.10.this.LO, e.10.this.hXr, e.10.this.hXs, e.10.this.hXw);
              AppMethodBeat.o(169095);
              return;
            }
            if (com.tencent.mm.modelvideo.r.Hy(localh.field_fullpath))
            {
              ae.w("MicroMsg.OnlineVideoService", "it is qt video, need finish all file. isPlayMode" + localh.fLI);
              if (localh.fLI == 1)
              {
                e.r(localh.field_mediaId, 0, localh.field_totalLen);
                com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 19L, 1L, false);
              }
              AppMethodBeat.o(169095);
              return;
            }
            localObject = new ny();
            ((ny)localObject).dCP.dto = 1;
            ((ny)localObject).dCP.retCode = 0;
            ((ny)localObject).dCP.mediaId = e.10.this.LO;
            ((ny)localObject).dCP.offset = e.10.this.hXr;
            ((ny)localObject).dCP.length = e.10.this.hXs;
            ((ny)localObject).dCP.dCQ = localh.fLF;
            ny.a locala = ((ny)localObject).dCP;
            if (localh.fLn > 0) {}
            for (bool1 = bool2;; bool1 = false)
            {
              locala.dCR = bool1;
              com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
              localObject = u.Ia(localh.filename);
              if (localObject == null) {
                break label507;
              }
              ae.i("MicroMsg.OnlineVideoService", "on moov ready info: " + ((s)localObject).getFileName() + " status : " + ((s)localObject).status);
              if (((s)localObject).status != 130) {
                break;
              }
              AppMethodBeat.o(169095);
              return;
            }
            if (((s)localObject).status != 122)
            {
              localObject = u.Ia(localh.filename);
              if (localObject != null)
              {
                ((s)localObject).status = 121;
                ((s)localObject).dEu = 256;
                com.tencent.mm.modelvideo.o.aNh().c((s)localObject);
              }
              if (localh.fLI == 0)
              {
                ae.i("MicroMsg.OnlineVideoService", "stop download video");
                com.tencent.mm.modelvideo.o.aNm().aND();
                com.tencent.mm.modelvideo.o.aNm().run();
              }
            }
            label507:
            AppMethodBeat.o(169095);
          }
        });
        AppMethodBeat.o(126719);
      }
    });
    if (this.hWC.containsKey(paramString1))
    {
      AppMethodBeat.o(217452);
      return 1;
    }
    AppMethodBeat.o(217452);
    return 0;
  }
  
  public final void eN(boolean paramBoolean)
  {
    AppMethodBeat.i(126730);
    if (!com.tencent.mm.kernel.g.ajM())
    {
      AppMethodBeat.o(126730);
      return;
    }
    if ((!paramBoolean) && (f.aHa().aGQ()))
    {
      com.tencent.mm.kernel.g.ajP();
      if (com.tencent.mm.kernel.a.aiY())
      {
        ae.w("MicroMsg.OnlineVideoService", "cdn engine not init cdn dnsinfo , will retry after set info");
        f.aGZ().eN(paramBoolean);
        AppMethodBeat.o(126730);
        return;
      }
    }
    f.aGZ().aGR();
    while (!this.hWA.isEmpty())
    {
      Object localObject1 = (String)this.hWA.poll();
      Object localObject2 = (h)this.hWB.remove(localObject1);
      if (localObject2 != null)
      {
        ((h)localObject2).field_startTime = com.tencent.mm.sdk.platformtools.bu.fpO();
        if (!((h)localObject2).dPh)
        {
          if (((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IQC, Integer.valueOf(-1))).intValue() == 2) {
            ae.i("MicroMsg.OnlineVideoService", "command set do not check media duplication.");
          }
          label167:
          int j;
          for (int i = 0;; i = 1)
          {
            if (i == 0) {
              break label410;
            }
            localObject2 = new ny();
            ((ny)localObject2).dCP.dto = 6;
            ((ny)localObject2).dCP.mediaId = ((String)localObject1);
            com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
            break;
            if (((h)localObject2).Ye()) {
              break label167;
            }
            Object localObject3 = ((h)localObject2).fLG;
            i = ((h)localObject2).fLH;
            Object localObject4 = ((com.tencent.mm.plugin.n.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.n.a.a.class)).azN().gz((String)localObject3, i);
            j = i - (int)com.tencent.mm.vfs.o.aZR((String)localObject4);
            if ((com.tencent.mm.sdk.platformtools.bu.isNullOrNil((String)localObject4)) || (j < 0) || (j > 16)) {
              break label167;
            }
            ae.i("MicroMsg.OnlineVideoService", "it had download this video[%d, %s, %s].", new Object[] { Integer.valueOf(i), localObject3, localObject4 });
            com.tencent.mm.vfs.o.mF((String)localObject4, ((h)localObject2).field_fullpath);
            localObject4 = u.Ia(((h)localObject2).filename);
            a((s)localObject4, i, (String)localObject3);
            localObject3 = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ys(((s)localObject4).iwZ);
            ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().a(new i.c(((ei)localObject3).field_talker, "update", (bv)localObject3));
          }
          label410:
          if (((h)localObject2).Yd())
          {
            i = f.aHa().a((com.tencent.mm.i.g)localObject2, ((h)localObject2).fLI);
            label432:
            ae.i("MicroMsg.OnlineVideoService", "start task %s streaming download. ret %d ", new Object[] { localObject2, Integer.valueOf(i) });
            if (i == 0) {
              break label1161;
            }
            ae.w("MicroMsg.OnlineVideoService", "start stream video error. ret : " + i + " media id: " + ((h)localObject2).field_mediaId);
            paramBoolean = ((h)localObject2).Yd();
            j = ((h)localObject2).fLI;
            if (!paramBoolean) {
              break label1071;
            }
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 3L, 1L, false);
            if (j != 1) {
              break label1006;
            }
            if (i != -21006) {
              break label965;
            }
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 100L, 1L, false);
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.g.yxI.f(13836, new Object[] { Integer.valueOf(100), Long.valueOf(com.tencent.mm.sdk.platformtools.bu.aRi()), "" });
            break;
            if (((h)localObject2).Yb())
            {
              i = f.aHa().a(((h)localObject2).field_mediaId, ((h)localObject2).url, ((h)localObject2).referer, ((h)localObject2).field_fullpath, ((h)localObject2).fLI, ((h)localObject2).fLe, ((h)localObject2).isColdSnsData, ((h)localObject2).signalQuality, ((h)localObject2).snsScene, ((h)localObject2).field_preloadRatio, ((h)localObject2).preloadMinSize, ((h)localObject2).field_requestVideoFormat, 4, ((h)localObject2).concurrentCount);
              break label432;
            }
            if (((h)localObject2).Yf())
            {
              i = f.aHa().a(((h)localObject2).field_mediaId, ((h)localObject2).url, ((h)localObject2).referer, ((h)localObject2).field_fullpath, ((h)localObject2).fLI, ((h)localObject2).fLe, ((h)localObject2).isColdSnsData, ((h)localObject2).signalQuality, ((h)localObject2).snsScene, ((h)localObject2).field_preloadRatio, ((h)localObject2).preloadMinSize, ((h)localObject2).field_requestVideoFormat, 4);
              break label432;
            }
            if (((h)localObject2).Yg())
            {
              i = f.aHa().a(((h)localObject2).field_mediaId, ((h)localObject2).url, ((h)localObject2).referer, ((h)localObject2).field_fullpath, ((h)localObject2).fLI, ((h)localObject2).fLe, ((h)localObject2).isColdSnsData, ((h)localObject2).signalQuality, ((h)localObject2).snsScene, ((h)localObject2).field_preloadRatio, ((h)localObject2).preloadMinSize, ((h)localObject2).field_requestVideoFormat, ((h)localObject2).connectionCount, ((h)localObject2).fLP, ((h)localObject2).videoFlag, ((h)localObject2).snsCipherKey, ((h)localObject2).concurrentCount);
              break label432;
            }
            if (((h)localObject2).Yc())
            {
              i = f.aHa().a(((h)localObject2).field_mediaId, ((h)localObject2).url, ((h)localObject2).referer, ((h)localObject2).field_fullpath, ((h)localObject2).fLI, ((h)localObject2).field_preloadRatio, ((h)localObject2).preloadMinSize, ((h)localObject2).concurrentCount);
              break label432;
            }
            i = f.aHa().a(((h)localObject2).field_mediaId, ((h)localObject2).url, ((h)localObject2).referer, ((h)localObject2).field_fullpath, ((h)localObject2).fLI, ((h)localObject2).fLe, ((h)localObject2).field_preloadRatio, ((h)localObject2).preloadMinSize);
            break label432;
            label965:
            if (i == -20003)
            {
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 101L, 1L, false);
            }
            else
            {
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 102L, 1L, false);
              continue;
              label1006:
              if (i == -21006) {
                com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 106L, 1L, false);
              } else if (i == -20003) {
                com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 107L, 1L, false);
              } else {
                com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 108L, 1L, false);
              }
            }
          }
          label1071:
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 210L, 1L, false);
          if (j == 1) {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 211L, 1L, false);
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.g.yxI.f(13836, new Object[] { Integer.valueOf(200), Long.valueOf(com.tencent.mm.sdk.platformtools.bu.aRi()), "" });
            break;
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 212L, 1L, false);
          }
          label1161:
          ((h)localObject2).fLF = com.tencent.mm.sdk.platformtools.bu.fpO();
          if (((h)localObject2).Yd())
          {
            localObject1 = u.Ia(((h)localObject2).filename);
            if (localObject1 != null)
            {
              i = ((s)localObject1).status;
              if ((i != 120) && (i != 122) && (i != 121))
              {
                ((s)localObject1).status = 120;
                ((s)localObject1).dEu = 256;
                com.tencent.mm.modelvideo.o.aNh().c((s)localObject1);
              }
            }
          }
          this.hWC.put(((h)localObject2).field_mediaId, localObject2);
        }
      }
    }
    AppMethodBeat.o(126730);
  }
  
  public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126728);
    if ((h)this.hWC.get(paramString) == null)
    {
      ae.i("MicroMsg.OnlineVideoService", "this media[%s] don't download now.", new Object[] { paramString });
      AppMethodBeat.o(126728);
      return false;
    }
    f.aHa();
    boolean bool = a.isVideoDataAvailable(paramString, paramInt1, paramInt2);
    ae.i("MicroMsg.OnlineVideoService", "is video[%s] data[%d, %d] available[%b]", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
    AppMethodBeat.o(126728);
    return bool;
  }
  
  public final boolean l(final String paramString, final Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(126726);
    boolean bool;
    if (!com.tencent.mm.sdk.platformtools.bu.isNullOrNil(paramString)) {
      if (this.hWC.containsKey(paramString))
      {
        bool = true;
        if ((!bool) || (Looper.myLooper() == Looper.getMainLooper())) {
          break label121;
        }
        this.gKO.postAtTime(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(126716);
            h localh = (h)e.this.hWC.remove(paramString);
            com.tencent.mm.i.d locald;
            int i;
            if (localh != null)
            {
              locald = new com.tencent.mm.i.d();
              f.aHa();
              i = a.c(localh.field_mediaId, locald);
              if (i == 0) {
                e.a(paramArrayOfObject, locald, localh, false);
              }
            }
            for (;;)
            {
              e.this.hWB.remove(paramString);
              AppMethodBeat.o(126716);
              return;
              ae.w("MicroMsg.OnlineVideoService", "stop video stream download error. ret %d, mediaId %s", new Object[] { Integer.valueOf(i), localh.field_mediaId });
              continue;
              localh = (h)e.this.hXn.remove(paramString);
              locald = (com.tencent.mm.i.d)e.this.hXo.remove(paramString);
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
      ae.i("MicroMsg.OnlineVideoService", "cancelDownloadTaskInMainThread mediaId : " + paramString + " remove : " + bool);
      AppMethodBeat.o(126726);
      return bool;
      f.aGZ().Fs(paramString);
      bool = false;
      break;
      label121:
      this.gKO.removeCallbacksAndMessages(paramString);
      h localh = (h)this.hWC.remove(paramString);
      com.tencent.mm.i.d locald;
      int i;
      if (localh != null)
      {
        locald = new com.tencent.mm.i.d();
        f.aHa();
        i = a.c(localh.field_mediaId, locald);
        if (i == 0) {
          a(paramArrayOfObject, locald, localh, false);
        }
      }
      for (;;)
      {
        this.hWB.remove(paramString);
        break;
        ae.w("MicroMsg.OnlineVideoService", "stop video stream download error. ret %d, mediaId %s", new Object[] { Integer.valueOf(i), localh.field_mediaId });
        continue;
        localh = (h)this.hXn.remove(paramString);
        locald = (com.tencent.mm.i.d)this.hXo.remove(paramString);
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
    if (!com.tencent.mm.sdk.platformtools.bu.isNullOrNil(paramString)) {
      if (!this.hWC.containsKey(paramString)) {
        break label90;
      }
    }
    for (bool1 = true;; bool1 = bool2)
    {
      com.tencent.mm.kernel.g.ajU().aw(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126717);
          h localh = (h)e.this.hWC.remove(paramString);
          com.tencent.mm.i.d locald;
          int i;
          if (localh != null)
          {
            locald = new com.tencent.mm.i.d();
            f.aHa();
            i = a.c(localh.field_mediaId, locald);
            if (i == 0) {
              e.a(paramArrayOfObject, locald, localh, false);
            }
          }
          for (;;)
          {
            e.this.hWB.remove(paramString);
            AppMethodBeat.o(126717);
            return;
            ae.w("MicroMsg.OnlineVideoService", "stop video stream download error. ret %d, mediaId %s", new Object[] { Integer.valueOf(i), localh.field_mediaId });
            continue;
            localh = (h)e.this.hXn.remove(paramString);
            locald = (com.tencent.mm.i.d)e.this.hXo.remove(paramString);
            if ((localh != null) && (locald != null)) {
              e.a(paramArrayOfObject, locald, localh, true);
            }
          }
        }
      });
      ae.i("MicroMsg.OnlineVideoService", "cancelDownloadTask mediaId : " + paramString + " remove : " + bool1);
      AppMethodBeat.o(126727);
      return bool1;
      label90:
      f.aGZ().Fs(paramString);
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
    ae.i("MicroMsg.OnlineVideoService", "it get cdn dns success[%d, %d], try to start.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (com.tencent.mm.kernel.g.ajP().aiZ()) {
      com.tencent.mm.kernel.g.ajU().aw(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126711);
          e.this.eN(true);
          AppMethodBeat.o(126711);
        }
      });
    }
    AppMethodBeat.o(126723);
  }
  
  public final int p(final String paramString, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(217453);
    ae.i("MicroMsg.OnlineVideoService", "onDataAvailable. offset %d, length %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (com.tencent.mm.sdk.platformtools.bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(217453);
      return 0;
    }
    com.tencent.mm.kernel.g.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126720);
        Object localObject = (h)e.this.hWC.get(paramString);
        if (localObject != null)
        {
          if (((h)localObject).fLQ != null) {
            ((h)localObject).fLQ.onDataAvailable(paramString, paramInt1, paramInt2);
          }
          localObject = new ny();
          ((ny)localObject).dCP.dto = 2;
          ((ny)localObject).dCP.retCode = 0;
          ((ny)localObject).dCP.mediaId = paramString;
          ((ny)localObject).dCP.offset = paramInt1;
          ((ny)localObject).dCP.length = paramInt2;
          com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
        }
        AppMethodBeat.o(126720);
      }
    });
    if (this.hWC.containsKey(paramString))
    {
      AppMethodBeat.o(217453);
      return 1;
    }
    AppMethodBeat.o(217453);
    return 0;
  }
  
  public final int q(final String paramString, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(217454);
    ae.i("MicroMsg.OnlineVideoService", "onDownloadToEnd. offset %d, length %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (com.tencent.mm.sdk.platformtools.bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(217454);
      return 0;
    }
    com.tencent.mm.kernel.g.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126712);
        h localh = (h)e.this.hWC.get(paramString);
        if (localh != null)
        {
          ny localny = new ny();
          localny.dCP.dto = 3;
          localny.dCP.retCode = 0;
          localny.dCP.mediaId = paramString;
          localny.dCP.offset = paramInt1;
          localny.dCP.length = paramInt2;
          com.tencent.mm.sdk.b.a.IvT.l(localny);
          if ((paramInt1 == 0) && (paramInt2 >= localh.fLH)) {
            e.a(u.Ia(localh.filename), localh.fLH, localh.fLG);
          }
        }
        AppMethodBeat.o(126712);
      }
    });
    if (this.hWC.containsKey(paramString))
    {
      AppMethodBeat.o(217454);
      return 1;
    }
    AppMethodBeat.o(217454);
    return 0;
  }
  
  public final void release()
  {
    AppMethodBeat.i(126722);
    com.tencent.mm.kernel.g.ajj().b(379, this);
    AppMethodBeat.o(126722);
  }
  
  public static abstract interface a
  {
    public abstract void a(h paramh, com.tencent.mm.i.d paramd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.an.e
 * JD-Core Version:    0.7.0.1
 */