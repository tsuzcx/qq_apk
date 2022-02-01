package com.tencent.mm.ao;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.b.p;
import com.tencent.mm.g.a.lb;
import com.tencent.mm.g.a.ng;
import com.tencent.mm.g.a.ng.a;
import com.tencent.mm.g.b.a.bf;
import com.tencent.mm.g.b.a.cq;
import com.tencent.mm.g.b.a.de;
import com.tencent.mm.g.b.a.eu;
import com.tencent.mm.g.c.du;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bl;
import com.tencent.mm.vfs.i;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class e
  implements com.tencent.mm.al.g, a.a
{
  Queue<String> haI;
  Map<String, com.tencent.mm.i.h> haJ;
  Map<String, com.tencent.mm.i.h> haK;
  Map<String, com.tencent.mm.i.h> hbo;
  Map<String, com.tencent.mm.i.d> hbp;
  private final ap hbq;
  
  public e()
  {
    AppMethodBeat.i(126721);
    this.haI = new LinkedList();
    this.haJ = new HashMap();
    this.haK = new HashMap();
    this.hbo = new HashMap();
    this.hbp = new HashMap();
    this.hbq = new ap(Looper.getMainLooper());
    com.tencent.mm.kernel.g.aeS().a(379, this);
    AppMethodBeat.o(126721);
  }
  
  public static com.tencent.mm.i.h a(bc parambc, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(126738);
    if (parambc == null)
    {
      ad.w("MicroMsg.OnlineVideoService", "check can sns online video, scene is null.");
      AppMethodBeat.o(126738);
      return null;
    }
    if (bt.isNullOrNil(paramString1))
    {
      ad.w("MicroMsg.OnlineVideoService", "check can sns online video, url is null.");
      AppMethodBeat.o(126738);
      return null;
    }
    Object localObject = u.Ae(paramString3);
    if (localObject == null)
    {
      ad.w("MicroMsg.OnlineVideoService", "check can sns online video, video info is null. %s", new Object[] { paramString3 });
      AppMethodBeat.o(126738);
      return null;
    }
    String str = c.a("snsvideo", parambc.tGD, "sns", paramString1);
    if (bt.isNullOrNil(str))
    {
      ad.w("MicroMsg.OnlineVideoService", "check can http online video, can not create media id. url %s ", new Object[] { paramString1 });
      AppMethodBeat.o(126738);
      return null;
    }
    com.tencent.mm.i.h localh = new com.tencent.mm.i.h();
    localh.filename = paramString3;
    localh.field_fullpath = paramString2;
    localh.field_mediaId = str;
    localh.fnX = 2;
    localh.foc = paramInt;
    localh.foe = ((s)localObject).foe;
    if (parambc == null) {
      paramString3 = "";
    }
    for (;;)
    {
      int i = com.tencent.mm.protocal.d.CpK;
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afz();
      str = p.getString(com.tencent.mm.kernel.a.getUin());
      int j = ay.getNetTypeForStat(aj.getContext());
      int k = ay.getStrength(aj.getContext());
      label235:
      long l1;
      if (!bt.isNullOrNil(paramString3))
      {
        localObject = "&scene=".concat(String.valueOf(paramString3));
        localh.referer = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d%s", new Object[] { Integer.valueOf(i), str, Integer.valueOf(j), Integer.valueOf(k), localObject });
        localh.url = paramString1;
        paramString1 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getValue("SnsSightDomainList");
        long l2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getInt("SnsSightMainStandbyIpSwitchTime", 0);
        ad.i("MicroMsg.OnlineVideoService", "hostvalue %s dcipTime %s scene.time[%d]", new Object[] { paramString1, Long.valueOf(l2), Integer.valueOf(parambc.tGD) });
        l1 = l2;
        if (l2 <= 0L) {
          l1 = 259200L;
        }
      }
      for (boolean bool = a(parambc, localh.url, l1, paramString1);; bool = false)
      {
        try
        {
          localh.host = new URL(localh.url).getHost();
          paramString1 = new ArrayList();
          com.tencent.mm.network.b.b(bool, paramString1, localh.host);
          localh.fnz = new String[paramString1.size()];
          paramString1.toArray(localh.fnz);
          if (bt.lZ(parambc.tGD) <= l1) {
            continue;
          }
          bool = true;
          localh.isColdSnsData = bool;
          localh.signalQuality = ay.getStrength(aj.getContext());
          localh.snsScene = paramString3;
          localh.concurrentCount = 5;
          if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.piQ, false)) {
            localh.field_requestVideoFormat = com.tencent.mm.modelcontrol.d.G(paramInt, paramString2);
          }
          AppMethodBeat.o(126738);
          return localh;
        }
        catch (Exception parambc)
        {
          ad.printErrStackTrace("MicroMsg.OnlineVideoService", parambc, "check can sns online video error taskInfo %s", new Object[] { localh });
          AppMethodBeat.o(126738);
          return null;
        }
        if (parambc.equals(bc.Fzy))
        {
          paramString3 = "album_friend";
          break;
        }
        if (parambc.equals(bc.Fzz))
        {
          paramString3 = "album_self";
          break;
        }
        if (parambc.equals(bc.FzA))
        {
          paramString3 = "album_stranger";
          break;
        }
        if (parambc.equals(bc.FzB))
        {
          paramString3 = "profile_friend";
          break;
        }
        if (parambc.equals(bc.FzC))
        {
          paramString3 = "profile_stranger";
          break;
        }
        if (parambc.equals(bc.FzD))
        {
          paramString3 = "comment";
          break;
        }
        if (parambc.equals(bc.Fzx))
        {
          paramString3 = "timeline";
          break;
        }
        if (parambc.equals(bc.FzG))
        {
          paramString3 = "snssight";
          break;
        }
        if (!parambc.equals(bc.FzI)) {
          break label754;
        }
        paramString3 = "storysight";
        break;
        localObject = "";
        break label235;
      }
      label754:
      paramString3 = "";
    }
  }
  
  static void a(s params, int paramInt, String paramString)
  {
    AppMethodBeat.i(126735);
    ad.i("MicroMsg.OnlineVideoService", "download finish. totalLen %d ", new Object[] { Integer.valueOf(paramInt) });
    if (params != null)
    {
      u.an(params.getFileName(), paramInt);
      j(paramInt, paramString, params.getFileName());
    }
    AppMethodBeat.o(126735);
  }
  
  private static void a(PInt paramPInt1, PInt paramPInt2, String paramString, int paramInt)
  {
    AppMethodBeat.i(126743);
    int j = 0;
    paramString = u.Ae(paramString);
    if (paramString != null) {
      j = paramString.dpA;
    }
    for (int k = paramString.gTY;; k = 0)
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
    lb locallb = new lb();
    locallb.dpu.dpv = paramString1;
    locallb.dpu.dpw = paramString2;
    locallb.dpu.dpx = paramInt1;
    locallb.dpu.fileId = paramString3;
    locallb.dpu.netType = paramInt2;
    locallb.dpu.startTime = paramLong1;
    locallb.dpu.endTime = paramLong2;
    locallb.dpu.path = paramString4;
    locallb.dpu.dpy = paramArrayOfString;
    locallb.dpu.dpz = paramString5;
    locallb.dpu.dpA = paramInt3;
    locallb.dpu.dpB = paramInt4;
    locallb.dpu.dpC = paramString6;
    com.tencent.mm.sdk.b.a.ESL.l(locallb);
    AppMethodBeat.o(126744);
  }
  
  public static void a(Object[] paramArrayOfObject, com.tencent.mm.i.d paramd, com.tencent.mm.i.h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(126742);
    if ((paramh == null) || (paramd == null))
    {
      ad.w("MicroMsg.OnlineVideoService", "video task info is null or download result is null.");
      AppMethodBeat.o(126742);
      return;
    }
    if ((!paramh.UF()) && (!paramh.UH()) && (!paramh.UJ()))
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
        u.Ai(paramh.filename);
      }
      if (!bt.isNullOrNil(str2)) {
        break label1526;
      }
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 45L, 1L, false);
      if (!paramd.field_isCrossNet) {
        break label1543;
      }
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 47L, 1L, false);
      bool1 = paramh.UH();
      bool2 = paramh.UJ();
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
        break label2726;
      }
      i2 = ((Integer)paramArrayOfObject[0]).intValue() * 1000;
      j = ((Integer)paramArrayOfObject[1]).intValue();
      i3 = ((Integer)paramArrayOfObject[2]).intValue();
      m = ((Integer)paramArrayOfObject[3]).intValue();
      i = ((Integer)paramArrayOfObject[4]).intValue();
      n = ((Integer)paramArrayOfObject[5]).intValue();
      i1 = ((Integer)paramArrayOfObject[6]).intValue();
      if ((bool2) || (bool1) || (paramArrayOfObject.length <= 10)) {
        break label2719;
      }
      i6 = ((Integer)paramArrayOfObject[7]).intValue();
      localObject1 = (String)paramArrayOfObject[8];
      i5 = ((Long)paramArrayOfObject[9]).intValue();
    }
    for (;;)
    {
      int i7 = paramh.foe;
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
        i17 = ay.ix(aj.getContext());
        str1 = paramd.UD();
        PInt localPInt1 = new PInt();
        localPInt2 = new PInt();
        a(localPInt1, localPInt2, paramh.filename, paramh.foh);
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
        if (paramh.fod == null) {
          break label1599;
        }
        localObject2 = com.tencent.mm.b.g.getMessageDigest(paramh.fod.getBytes());
        label755:
        localStringBuffer.append(localObject2).append(",");
        if (!w.pF(paramh.fod)) {
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
        localStringBuffer.append(paramh.fog).append(",");
        localStringBuffer.append(paramh.drA).append(",");
        localStringBuffer.append(paramh.fnI).append(",");
        localStringBuffer.append(paramd.field_videoFormat).append(",");
        label1182:
        localStringBuffer.append(str2).append(",");
        localStringBuffer.append(i4).append(",");
        localStringBuffer.append(paramh.foi).append(",");
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
        new bf((String)localObject2).aBj();
        label1356:
        if (paramBoolean) {
          a(paramh.dpv, paramh.fod, paramh.dpx, paramd.field_fileId, i17, paramd.field_startTime, paramd.field_endTime, paramh.field_fullpath, paramd.field_usedSvrIps, paramh.url, localPInt1.value, localPInt2.value, paramh.dpC);
        }
        if (bool1)
        {
          if (paramd.field_videoFormat != 2) {
            break label2702;
          }
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 132L, 1L, false);
        }
      }
      for (;;)
      {
        paramArrayOfObject = u.Ae(paramh.filename);
        if (paramArrayOfObject != null)
        {
          paramArrayOfObject = ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().rm(paramArrayOfObject.hAi);
          ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().a(new h.c(paramArrayOfObject.field_talker, "update", paramArrayOfObject));
        }
        AppMethodBeat.o(126742);
        return;
        i4 = 0;
        break;
        label1526:
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 46L, 1L, false);
        break label146;
        label1543:
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 48L, 1L, false);
        break label167;
        k = 31;
        break label412;
        label1567:
        localStringBuffer.append(paramh.url).append(",").append(paramh.fof).append(",");
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
        if (paramh.fod != null) {}
        for (localObject2 = com.tencent.mm.b.g.getMessageDigest(paramh.fod.getBytes());; localObject2 = Integer.valueOf(0))
        {
          localStringBuffer.append(localObject2).append(",");
          break;
        }
        label1717:
        localStringBuffer.append(com.tencent.mm.plugin.video.c.asU(paramh.dpC)).append(",");
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
              k = bt.getInt(paramArrayOfObject[7].toString(), 0);
              bt.getInt(paramArrayOfObject[8].toString(), 0);
              i4 = bt.getInt(paramArrayOfObject[9].toString(), 0);
              localObject1 = paramArrayOfObject[11].toString();
              i5 = bt.getInt(paramArrayOfObject[12].toString(), 0);
              l1 = bt.getLong(paramArrayOfObject[13].toString(), 0L);
              i6 = bt.getInt(paramArrayOfObject[14].toString(), 0);
              i7 = bt.getInt(paramArrayOfObject[15].toString(), 0);
              i8 = bt.getInt(paramArrayOfObject[16].toString(), 0);
            }
          }
          paramArrayOfObject = new eu();
          localObject1 = paramArrayOfObject.kM((String)localObject1);
          ((eu)localObject1).dZE = i5;
          ((eu)localObject1).dZF = i7;
          ((eu)localObject1).dZG = i6;
          ((eu)localObject1).dIm = i15;
          ((eu)localObject1).dZH = (i2 / 1000);
          ((eu)localObject1).dOJ = j;
          ((eu)localObject1).dOK = i3;
          ((eu)localObject1).dZI = m;
          ((eu)localObject1).dOM = i;
          ((eu)localObject1).dZJ = 0L;
          ((eu)localObject1).dPg = n;
          ((eu)localObject1).dZK = i1;
          localObject1 = ((eu)localObject1).kN("");
          ((eu)localObject1).dIn = (i16 * 1000);
          localObject1 = ((eu)localObject1).kO(paramh.field_requestVideoFormat);
          ((eu)localObject1).dFQ = paramd.field_fileLength;
          ((eu)localObject1).dZN = paramd.field_recvedBytes;
          ((eu)localObject1).dOP = paramd.field_startTime;
          ((eu)localObject1).dOQ = paramd.field_endTime;
          ((eu)localObject1).dZO = paramd.field_retCode;
          ((eu)localObject1).dZP = paramd.field_enQueueTime;
          ((eu)localObject1).dZQ = paramd.field_moovRequestTimes;
          ((eu)localObject1).dZR = paramd.field_moovCost;
          ((eu)localObject1).dPd = paramd.field_moovSize;
          if (paramd.field_moovCompleted)
          {
            l2 = 1L;
            ((eu)localObject1).dZS = l2;
            ((eu)localObject1).dZT = paramd.field_moovFailReason;
            ((eu)localObject1).dZU = paramd.field_firstConnectCost;
            ((eu)localObject1).dZV = paramd.field_firstRequestCost;
            ((eu)localObject1).dZW = paramd.field_firstRequestSize;
            ((eu)localObject1).dZX = paramd.field_firstRequestDownloadSize;
            if (!paramd.field_firstRequestCompleted) {
              break label2653;
            }
            l2 = 1L;
            label2285:
            ((eu)localObject1).dZY = l2;
            ((eu)localObject1).dZZ = paramd.field_averageSpeed;
            ((eu)localObject1).eaa = paramd.field_averageConnectCost;
            ((eu)localObject1).dPa = paramd.field_netConnectTimes;
            localObject1 = ((eu)localObject1).kP(paramd.UD()).kQ(paramd.field_clientIP);
            if (!paramd.field_isCrossNet) {
              break label2659;
            }
          }
          label2653:
          label2659:
          for (l2 = 1L;; l2 = 0L)
          {
            ((eu)localObject1).eac = l2;
            ((eu)localObject1).dPo = paramh.foi;
            ((eu)localObject1).ead = i4;
            ((eu)localObject1).dFO = i17;
            ((eu)localObject1).eae = l1;
            ((eu)localObject1).dIu = k;
            ((eu)localObject1).eaf = i8;
            ((eu)localObject1).dPp = paramd.transportProtocol;
            ((eu)localObject1).dPq = paramd.transportProtocolError;
            ad.d("MicroMsg.OnlineVideoService", "time distance %d", new Object[] { Long.valueOf(System.currentTimeMillis() - paramArrayOfObject.eae) });
            if (System.currentTimeMillis() - paramArrayOfObject.eae > 500L) {
              paramArrayOfObject.aBj();
            }
            if (!bool2) {
              break;
            }
            paramArrayOfObject = new de();
            localObject1 = com.tencent.mm.plugin.sight.base.e.ano(paramh.field_fullpath);
            if (localObject1 != null)
            {
              paramArrayOfObject.dIm = ((com.tencent.mm.plugin.sight.base.a)localObject1).videoDuration;
              paramArrayOfObject.dIn = ((com.tencent.mm.plugin.sight.base.a)localObject1).videoBitrate;
              paramArrayOfObject.dIo = ((com.tencent.mm.plugin.sight.base.a)localObject1).audioBitrate;
              paramArrayOfObject.dIp = ((com.tencent.mm.plugin.sight.base.a)localObject1).frameRate;
              paramArrayOfObject.dIq = ((com.tencent.mm.plugin.sight.base.a)localObject1).width;
              paramArrayOfObject.dIr = ((com.tencent.mm.plugin.sight.base.a)localObject1).height;
              paramArrayOfObject.dIt = ((com.tencent.mm.plugin.sight.base.a)localObject1).audioChannel;
            }
            paramArrayOfObject.dIl = paramd.field_fileLength;
            paramArrayOfObject = paramArrayOfObject.jD(paramh.url);
            f.awM();
            paramArrayOfObject = paramArrayOfObject.jE(a.xG(paramh.field_fullpath));
            paramArrayOfObject.dIj = paramd.field_startTime;
            paramArrayOfObject.dIk = paramd.field_endTime;
            paramArrayOfObject = paramArrayOfObject.jF(str1);
            paramArrayOfObject.dIu = k;
            paramArrayOfObject.dIv = localPInt2.value;
            paramArrayOfObject.aBj();
            break;
            l2 = 0L;
            break label2218;
            l2 = 0L;
            break label2285;
          }
        }
        label2218:
        paramArrayOfObject = new cq((String)localObject2);
        paramArrayOfObject.dSm = i5;
        paramArrayOfObject.jj((String)localObject1);
        paramArrayOfObject.dSk = i6;
        paramArrayOfObject.aBj();
        break label1356;
        label2702:
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 133L, 1L, false);
      }
      label2719:
      localObject1 = "";
      continue;
      label2726:
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
  
  private static boolean a(bc parambc, String paramString1, long paramLong, String paramString2)
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
      if (parambc == null)
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
      i = parambc.tGD;
      if (i == 0)
      {
        AppMethodBeat.o(126739);
        return false;
      }
      long l = bt.lZ(parambc.tGD);
      if (l > paramLong)
      {
        AppMethodBeat.o(126739);
        return true;
      }
      AppMethodBeat.o(126739);
      return false;
    }
    catch (Exception parambc)
    {
      ad.e("MicroMsg.OnlineVideoService", "error for check dcip %s", new Object[] { parambc.getMessage() });
      AppMethodBeat.o(126739);
    }
    return false;
  }
  
  private static boolean j(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(126736);
    if (bt.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(126736);
      return false;
    }
    o.aCI();
    paramString2 = t.zQ(paramString2);
    if ((bt.isNullOrNil(paramString1)) || (paramInt <= 0) || (bt.isNullOrNil(paramString2)))
    {
      ad.w("MicroMsg.OnlineVideoService", "insert media duplication but args is error.[%d, %s, %s]", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
      AppMethodBeat.o(126736);
      return false;
    }
    boolean bool = ((com.tencent.mm.plugin.n.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.n.a.a.class)).apT().E(paramString1, paramInt, paramString2);
    AppMethodBeat.o(126736);
    return bool;
  }
  
  public static void p(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(126740);
    if (paramArrayOfInt == null)
    {
      AppMethodBeat.o(126740);
      return;
    }
    com.tencent.mm.plugin.report.service.h.vKh.f(17891, new Object[] { Integer.valueOf(paramArrayOfInt[6]), Integer.valueOf(paramArrayOfInt[8]), Integer.valueOf(paramArrayOfInt[9]), Integer.valueOf(paramArrayOfInt[7]), Integer.valueOf(paramArrayOfInt[10]), Integer.valueOf(paramArrayOfInt[11]), Integer.valueOf(paramArrayOfInt[12]), Integer.valueOf(paramArrayOfInt[13]), Integer.valueOf(paramArrayOfInt[14]), Integer.valueOf(paramArrayOfInt[15]), Integer.valueOf(paramArrayOfInt[0]), Integer.valueOf(paramArrayOfInt[1]), Integer.valueOf(paramArrayOfInt[2]), Integer.valueOf(paramArrayOfInt[3]), Integer.valueOf(paramArrayOfInt[4]), Integer.valueOf(paramArrayOfInt[5]), Integer.valueOf(paramArrayOfInt[16]), Integer.valueOf(paramArrayOfInt[17]), Integer.valueOf(paramArrayOfInt[18]), Integer.valueOf(paramArrayOfInt[19]), Integer.valueOf(paramArrayOfInt[20]), Integer.valueOf(paramArrayOfInt[21]) });
    AppMethodBeat.o(126740);
  }
  
  public static int q(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126729);
    f.awM();
    int i = a.o(paramString, paramInt1, paramInt2);
    ad.i("MicroMsg.OnlineVideoService", "request video video[%s], offset[%d], length[%d] duration[%d] ret[%d]", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0), Integer.valueOf(i) });
    AppMethodBeat.o(126729);
    return i;
  }
  
  public static com.tencent.mm.i.h xN(String paramString)
  {
    AppMethodBeat.i(126737);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(126737);
      return null;
    }
    s locals = u.Ae(paramString);
    if (locals == null)
    {
      AppMethodBeat.o(126737);
      return null;
    }
    Object localObject1 = bw.K(locals.aCT(), "msg");
    if (localObject1 == null)
    {
      ad.w("MicroMsg.OnlineVideoService", "cdntra parse video recv xml failed");
      AppMethodBeat.o(126737);
      return null;
    }
    Object localObject2 = (String)((Map)localObject1).get(".msg.videomsg.$cdnvideourl");
    if (bt.isNullOrNil((String)localObject2))
    {
      ad.w("MicroMsg.OnlineVideoService", "cdntra parse video recv xml failed");
      AppMethodBeat.o(126737);
      return null;
    }
    int j = bt.getInt((String)((Map)localObject1).get(".msg.videomsg.$length"), 0);
    String str1 = (String)((Map)localObject1).get(".msg.videomsg.$md5");
    String str2 = (String)((Map)localObject1).get(".msg.videomsg.$aeskey");
    String str3 = (String)((Map)localObject1).get(".msg.videomsg.$fileparam");
    String str4 = c.a("downvideo", locals.createTime, locals.getUser(), locals.getFileName());
    if (bt.isNullOrNil(str4))
    {
      ad.w("MicroMsg.OnlineVideoService", "cdntra genClientId failed not use cdn file:%s", new Object[] { locals.getFileName() });
      AppMethodBeat.o(126737);
      return null;
    }
    o.aCI();
    String str5 = t.zQ(paramString);
    localObject1 = new com.tencent.mm.i.h();
    ((com.tencent.mm.i.h)localObject1).filename = paramString;
    ((com.tencent.mm.i.h)localObject1).foa = str1;
    ((com.tencent.mm.i.h)localObject1).fob = j;
    ((com.tencent.mm.i.h)localObject1).foc = 1;
    ((com.tencent.mm.i.h)localObject1).dpv = locals.aCQ();
    ((com.tencent.mm.i.h)localObject1).fod = locals.getUser();
    if (w.pF(locals.getUser()))
    {
      i = com.tencent.mm.model.q.rY(locals.getUser());
      ((com.tencent.mm.i.h)localObject1).dpx = i;
      ((com.tencent.mm.i.h)localObject1).field_mediaId = str4;
      ((com.tencent.mm.i.h)localObject1).field_fullpath = str5;
      ((com.tencent.mm.i.h)localObject1).field_fileType = com.tencent.mm.i.a.MediaType_VIDEO;
      ((com.tencent.mm.i.h)localObject1).field_totalLen = j;
      ((com.tencent.mm.i.h)localObject1).field_aesKey = str2;
      ((com.tencent.mm.i.h)localObject1).field_fileId = ((String)localObject2);
      ((com.tencent.mm.i.h)localObject1).field_priority = com.tencent.mm.i.a.fmV;
      ((com.tencent.mm.i.h)localObject1).field_wxmsgparam = str3;
      if (!w.pF(locals.getUser())) {
        break label534;
      }
      i = 1;
      label383:
      ((com.tencent.mm.i.h)localObject1).field_chattype = i;
      ((com.tencent.mm.i.h)localObject1).foe = locals.foe;
      paramString = ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().aD(locals.getUser(), locals.drA);
      localObject2 = bi.ul(paramString.esh);
      ((com.tencent.mm.i.h)localObject1).fnI = 0;
      ((com.tencent.mm.i.h)localObject1).fnJ = 0;
      ((com.tencent.mm.i.h)localObject1).fog = paramString.field_createTime;
      ((com.tencent.mm.i.h)localObject1).drA = paramString.field_msgSvrId;
      if (localObject2 == null) {
        break label539;
      }
    }
    label534:
    label539:
    for (int i = ((bi.b)localObject2).gOm;; i = 0)
    {
      ((com.tencent.mm.i.h)localObject1).foh = i;
      if (((com.tencent.mm.i.h)localObject1).fnI > 0) {
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 36L, 1L, false);
      }
      ((com.tencent.mm.i.h)localObject1).field_autostart = false;
      ((com.tencent.mm.i.h)localObject1).field_requestVideoFormat = com.tencent.mm.modelcontrol.d.a(1, locals);
      AppMethodBeat.o(126737);
      return localObject1;
      i = 0;
      break;
      i = 0;
      break label383;
    }
  }
  
  public final int a(final String paramString, final com.tencent.mm.i.c paramc, final com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(126734);
    if (bt.isNullOrNil(paramString))
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
    com.tencent.mm.kernel.g.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(169094);
        Object localObject = (com.tencent.mm.i.h)e.this.haK.get(paramString);
        if (localObject == null)
        {
          AppMethodBeat.o(169094);
          return;
        }
        if (((com.tencent.mm.i.h)localObject).foj != null)
        {
          ad.i("MicroMsg.OnlineVideoService", "cdn callback %s route to videoCallback", new Object[] { paramString });
          if (paramc != null)
          {
            ((com.tencent.mm.i.h)localObject).foj.k(paramString, paramc.field_finishedLength, paramc.field_toltalLength);
            AppMethodBeat.o(169094);
            return;
          }
          if (paramd != null)
          {
            ad.i("MicroMsg.OnlineVideoService", "cdn callback %s route to videoCallback, sceneResult.retCode:%s", new Object[] { paramString, Integer.valueOf(paramd.field_retCode) });
            ((com.tencent.mm.i.h)localObject).foj.a(paramString, paramd.field_retCode, paramd);
            e.this.haK.remove(paramString);
            if (paramd.field_retCode == 0)
            {
              e.this.hbo.put(((com.tencent.mm.i.h)localObject).field_mediaId, localObject);
              e.this.hbp.put(((com.tencent.mm.i.h)localObject).field_mediaId, paramd);
            }
            AppMethodBeat.o(169094);
            return;
          }
          AppMethodBeat.o(169094);
          return;
        }
        s locals = u.Ae(((com.tencent.mm.i.h)localObject).filename);
        if (locals == null)
        {
          ad.w("MicroMsg.OnlineVideoService", "stream download video callback, but video info is null.[%s]", new Object[] { ((com.tencent.mm.i.h)localObject).filename });
          AppMethodBeat.o(169094);
          return;
        }
        if (((com.tencent.mm.i.h)localObject).fnH != null)
        {
          ((com.tencent.mm.i.h)localObject).fnH.a(paramString, 0, paramc, paramd, ((com.tencent.mm.i.h)localObject).field_onlycheckexist);
          if (paramd != null) {
            e.this.haK.remove(paramString);
          }
          AppMethodBeat.o(169094);
          return;
        }
        if (paramc != null)
        {
          if (paramc.field_finishedLength == locals.gTY)
          {
            ad.i("MicroMsg.OnlineVideoService", "stream download finish.");
            AppMethodBeat.o(169094);
            return;
          }
          if ((locals.status != 130) && (locals.hAd > paramc.field_finishedLength))
          {
            ad.w("MicroMsg.OnlineVideoService", "set video error. db now size %d, cdn callback %d.", new Object[] { Integer.valueOf(locals.hAd), Long.valueOf(paramc.field_finishedLength) });
            AppMethodBeat.o(169094);
            return;
          }
          ad.i("MicroMsg.OnlineVideoService", "callback progress info " + paramc.field_finishedLength);
          locals.hAg = bt.aGK();
          locals.hAd = ((int)paramc.field_finishedLength);
          locals.dtM = 1040;
          u.f(locals);
          localObject = new ng();
          ((ng)localObject).dsm.djq = 5;
          ((ng)localObject).dsm.mediaId = paramString;
          ((ng)localObject).dsm.offset = ((int)paramc.field_finishedLength);
          ((ng)localObject).dsm.length = ((int)paramc.field_toltalLength);
          com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
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
            u.zV(locals.getFileName());
          }
          boolean bool = ((com.tencent.mm.i.h)localObject).UH();
          i = paramd.field_retCode;
          j = ((com.tencent.mm.i.h)localObject).foc;
          if (!bool) {
            break label1039;
          }
          if (j != 1) {
            break label950;
          }
          if (i != -5103059) {
            break label885;
          }
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 111L, 1L, false);
          com.tencent.mm.plugin.report.service.h.vKh.f(13836, new Object[] { Integer.valueOf(101), Long.valueOf(bt.aGK()), Integer.valueOf(i) });
        }
        for (;;)
        {
          localObject = new ng();
          ((ng)localObject).dsm.djq = 4;
          ((ng)localObject).dsm.mediaId = paramString;
          ((ng)localObject).dsm.offset = 0;
          ((ng)localObject).dsm.retCode = paramd.field_retCode;
          ((ng)localObject).dsm.length = ((int)paramd.field_fileLength);
          com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
          e.this.haK.remove(paramString);
          AppMethodBeat.o(169094);
          return;
          label885:
          if (i == -5103087)
          {
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 112L, 1L, false);
            break;
          }
          if (i == -10012)
          {
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 113L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 114L, 1L, false);
          break;
          label950:
          if (i == -5103059)
          {
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 116L, 1L, false);
            break;
          }
          if (i == -5103087)
          {
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 117L, 1L, false);
            break;
          }
          if (i == -10012)
          {
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 118L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 119L, 1L, false);
          break;
          label1039:
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 213L, 1L, false);
          if (j == 1) {
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 214L, 1L, false);
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.vKh.f(13836, new Object[] { Integer.valueOf(201), Long.valueOf(bt.aGK()), Integer.valueOf(i) });
            break;
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 215L, 1L, false);
          }
          label1130:
          e.a(locals, (int)paramd.field_fileLength, ((com.tencent.mm.i.h)localObject).foa);
          e.this.hbo.put(((com.tencent.mm.i.h)localObject).field_mediaId, localObject);
          e.this.hbp.put(((com.tencent.mm.i.h)localObject).field_mediaId, paramd);
        }
      }
    });
    if (this.haK.get(paramString) != null)
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
    if (bt.isNullOrNil(paramh.field_mediaId))
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
    paramh.dDS = false;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126715);
          e.this.haI.add(paramh.field_mediaId);
          e.this.haJ.put(paramh.field_mediaId, paramh);
          e.this.eo(false);
          AppMethodBeat.o(126715);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(126725);
      return true;
      this.haI.add(paramh.field_mediaId);
      this.haJ.put(paramh.field_mediaId, paramh);
      eo(false);
    }
  }
  
  public final boolean a(final com.tencent.mm.i.h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(126724);
    if (paramh == null)
    {
      ad.e("MicroMsg.OnlineVideoService", "add download task, but task is null.");
      AppMethodBeat.o(126724);
      return false;
    }
    if (bt.isNullOrNil(paramh.field_mediaId))
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
    paramh.dDS = false;
    if ((k(paramh.field_mediaId, null)) || (paramBoolean)) {
      com.tencent.mm.kernel.g.afE().ax(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126713);
          e.this.haI.add(paramh.field_mediaId);
          e.this.haJ.put(paramh.field_mediaId, paramh);
          e.this.eo(false);
          AppMethodBeat.o(126713);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(126724);
      return true;
      com.tencent.mm.kernel.g.afE().ax(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126714);
          e.this.haI.add(paramh.field_mediaId);
          e.this.haJ.put(paramh.field_mediaId, paramh);
          e.this.eo(false);
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
    if (!bt.isNullOrNil(paramString)) {
      if (!this.haK.containsKey(paramString)) {
        break label90;
      }
    }
    for (bool1 = true;; bool1 = bool2)
    {
      com.tencent.mm.kernel.g.afE().ax(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126718);
          Object localObject1 = (com.tencent.mm.i.h)e.this.haK.remove(paramString);
          Object localObject2;
          int i;
          if (localObject1 != null)
          {
            localObject2 = new com.tencent.mm.i.d();
            f.awM();
            i = a.b(((com.tencent.mm.i.h)localObject1).field_mediaId, (com.tencent.mm.i.d)localObject2);
            if (i == 0) {
              e.a(this.hbv, (com.tencent.mm.i.d)localObject2, (com.tencent.mm.i.h)localObject1, false);
            }
          }
          for (;;)
          {
            e.this.haJ.remove(paramString);
            if (parama != null) {
              parama.a((com.tencent.mm.i.h)localObject1, (com.tencent.mm.i.d)localObject2);
            }
            AppMethodBeat.o(126718);
            return;
            ad.w("MicroMsg.OnlineVideoService", "stop video stream download error. ret %d, mediaId %s", new Object[] { Integer.valueOf(i), ((com.tencent.mm.i.h)localObject1).field_mediaId });
            continue;
            com.tencent.mm.i.h localh = (com.tencent.mm.i.h)e.this.hbo.remove(paramString);
            com.tencent.mm.i.d locald = (com.tencent.mm.i.d)e.this.hbp.remove(paramString);
            localObject1 = localh;
            localObject2 = locald;
            if (localh != null)
            {
              localObject1 = localh;
              localObject2 = locald;
              if (locald != null)
              {
                e.a(this.hbv, locald, localh, true);
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
      f.awL().xL(paramString);
    }
  }
  
  public final void eo(boolean paramBoolean)
  {
    AppMethodBeat.i(126730);
    if (!com.tencent.mm.kernel.g.afw())
    {
      AppMethodBeat.o(126730);
      return;
    }
    if ((!paramBoolean) && (f.awM().awF()))
    {
      com.tencent.mm.kernel.g.afz();
      if (com.tencent.mm.kernel.a.aeH())
      {
        ad.w("MicroMsg.OnlineVideoService", "cdn engine not init cdn dnsinfo , will retry after set info");
        f.awL().eo(paramBoolean);
        AppMethodBeat.o(126730);
        return;
      }
    }
    f.awL().awG();
    while (!this.haI.isEmpty())
    {
      Object localObject1 = (String)this.haI.poll();
      Object localObject2 = (com.tencent.mm.i.h)this.haJ.remove(localObject1);
      if (localObject2 != null)
      {
        ((com.tencent.mm.i.h)localObject2).field_startTime = bt.eGO();
        if (!((com.tencent.mm.i.h)localObject2).dDS)
        {
          if (((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FlX, Integer.valueOf(-1))).intValue() == 2) {
            ad.i("MicroMsg.OnlineVideoService", "command set do not check media duplication.");
          }
          label167:
          int j;
          for (int i = 0;; i = 1)
          {
            if (i == 0) {
              break label410;
            }
            localObject2 = new ng();
            ((ng)localObject2).dsm.djq = 6;
            ((ng)localObject2).dsm.mediaId = ((String)localObject1);
            com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject2);
            break;
            if (((com.tencent.mm.i.h)localObject2).UI()) {
              break label167;
            }
            Object localObject3 = ((com.tencent.mm.i.h)localObject2).foa;
            i = ((com.tencent.mm.i.h)localObject2).fob;
            Object localObject4 = ((com.tencent.mm.plugin.n.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.n.a.a.class)).apT().fP((String)localObject3, i);
            j = i - (int)i.aMN((String)localObject4);
            if ((bt.isNullOrNil((String)localObject4)) || (j < 0) || (j > 16)) {
              break label167;
            }
            ad.i("MicroMsg.OnlineVideoService", "it had download this video[%d, %s, %s].", new Object[] { Integer.valueOf(i), localObject3, localObject4 });
            i.lC((String)localObject4, ((com.tencent.mm.i.h)localObject2).field_fullpath);
            localObject4 = u.Ae(((com.tencent.mm.i.h)localObject2).filename);
            a((s)localObject4, i, (String)localObject3);
            localObject3 = ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().rm(((s)localObject4).hAi);
            ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().a(new h.c(((du)localObject3).field_talker, "update", (bl)localObject3));
          }
          label410:
          if (((com.tencent.mm.i.h)localObject2).UH())
          {
            i = f.awM().a((com.tencent.mm.i.g)localObject2, ((com.tencent.mm.i.h)localObject2).foc);
            label432:
            ad.i("MicroMsg.OnlineVideoService", "start task %s streaming download. ret %d ", new Object[] { localObject2, Integer.valueOf(i) });
            if (i == 0) {
              break label1154;
            }
            ad.w("MicroMsg.OnlineVideoService", "start stream video error. ret : " + i + " media id: " + ((com.tencent.mm.i.h)localObject2).field_mediaId);
            paramBoolean = ((com.tencent.mm.i.h)localObject2).UH();
            j = ((com.tencent.mm.i.h)localObject2).foc;
            if (!paramBoolean) {
              break label1065;
            }
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 3L, 1L, false);
            if (j != 1) {
              break label1000;
            }
            if (i != -21006) {
              break label959;
            }
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 100L, 1L, false);
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.vKh.f(13836, new Object[] { Integer.valueOf(100), Long.valueOf(bt.aGK()), "" });
            break;
            if (((com.tencent.mm.i.h)localObject2).UF())
            {
              i = f.awM().a(((com.tencent.mm.i.h)localObject2).field_mediaId, ((com.tencent.mm.i.h)localObject2).url, ((com.tencent.mm.i.h)localObject2).referer, ((com.tencent.mm.i.h)localObject2).field_fullpath, ((com.tencent.mm.i.h)localObject2).foc, ((com.tencent.mm.i.h)localObject2).fnz, ((com.tencent.mm.i.h)localObject2).isColdSnsData, ((com.tencent.mm.i.h)localObject2).signalQuality, ((com.tencent.mm.i.h)localObject2).snsScene, ((com.tencent.mm.i.h)localObject2).field_preloadRatio, ((com.tencent.mm.i.h)localObject2).preloadMinSize, ((com.tencent.mm.i.h)localObject2).field_requestVideoFormat, 4, ((com.tencent.mm.i.h)localObject2).concurrentCount);
              break label432;
            }
            if (((com.tencent.mm.i.h)localObject2).UJ())
            {
              i = f.awM().a(((com.tencent.mm.i.h)localObject2).field_mediaId, ((com.tencent.mm.i.h)localObject2).url, ((com.tencent.mm.i.h)localObject2).referer, ((com.tencent.mm.i.h)localObject2).field_fullpath, ((com.tencent.mm.i.h)localObject2).foc, ((com.tencent.mm.i.h)localObject2).fnz, ((com.tencent.mm.i.h)localObject2).isColdSnsData, ((com.tencent.mm.i.h)localObject2).signalQuality, ((com.tencent.mm.i.h)localObject2).snsScene, ((com.tencent.mm.i.h)localObject2).field_preloadRatio, ((com.tencent.mm.i.h)localObject2).preloadMinSize, ((com.tencent.mm.i.h)localObject2).field_requestVideoFormat, 4);
              break label432;
            }
            if (((com.tencent.mm.i.h)localObject2).UK())
            {
              i = f.awM().a(((com.tencent.mm.i.h)localObject2).field_mediaId, ((com.tencent.mm.i.h)localObject2).url, ((com.tencent.mm.i.h)localObject2).referer, ((com.tencent.mm.i.h)localObject2).field_fullpath, ((com.tencent.mm.i.h)localObject2).foc, ((com.tencent.mm.i.h)localObject2).fnz, ((com.tencent.mm.i.h)localObject2).isColdSnsData, ((com.tencent.mm.i.h)localObject2).signalQuality, ((com.tencent.mm.i.h)localObject2).snsScene, ((com.tencent.mm.i.h)localObject2).field_preloadRatio, ((com.tencent.mm.i.h)localObject2).preloadMinSize, ((com.tencent.mm.i.h)localObject2).field_requestVideoFormat, ((com.tencent.mm.i.h)localObject2).connectionCount, ((com.tencent.mm.i.h)localObject2).qpa, ((com.tencent.mm.i.h)localObject2).videoFlag, ((com.tencent.mm.i.h)localObject2).snsCipherKey);
              break label432;
            }
            if (((com.tencent.mm.i.h)localObject2).UG())
            {
              i = f.awM().a(((com.tencent.mm.i.h)localObject2).field_mediaId, ((com.tencent.mm.i.h)localObject2).url, ((com.tencent.mm.i.h)localObject2).referer, ((com.tencent.mm.i.h)localObject2).field_fullpath, ((com.tencent.mm.i.h)localObject2).foc, ((com.tencent.mm.i.h)localObject2).field_preloadRatio, ((com.tencent.mm.i.h)localObject2).preloadMinSize, ((com.tencent.mm.i.h)localObject2).concurrentCount);
              break label432;
            }
            i = f.awM().a(((com.tencent.mm.i.h)localObject2).field_mediaId, ((com.tencent.mm.i.h)localObject2).url, ((com.tencent.mm.i.h)localObject2).referer, ((com.tencent.mm.i.h)localObject2).field_fullpath, ((com.tencent.mm.i.h)localObject2).foc, ((com.tencent.mm.i.h)localObject2).fnz, ((com.tencent.mm.i.h)localObject2).field_preloadRatio, ((com.tencent.mm.i.h)localObject2).preloadMinSize);
            break label432;
            label959:
            if (i == -20003)
            {
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 101L, 1L, false);
            }
            else
            {
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 102L, 1L, false);
              continue;
              label1000:
              if (i == -21006) {
                com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 106L, 1L, false);
              } else if (i == -20003) {
                com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 107L, 1L, false);
              } else {
                com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 108L, 1L, false);
              }
            }
          }
          label1065:
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 210L, 1L, false);
          if (j == 1) {
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 211L, 1L, false);
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.vKh.f(13836, new Object[] { Integer.valueOf(200), Long.valueOf(bt.aGK()), "" });
            break;
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 212L, 1L, false);
          }
          label1154:
          ((com.tencent.mm.i.h)localObject2).fnZ = bt.eGO();
          if (((com.tencent.mm.i.h)localObject2).UH())
          {
            localObject1 = u.Ae(((com.tencent.mm.i.h)localObject2).filename);
            if (localObject1 != null)
            {
              i = ((s)localObject1).status;
              if ((i != 120) && (i != 122) && (i != 121))
              {
                ((s)localObject1).status = 120;
                ((s)localObject1).dtM = 256;
                o.aCI().c((s)localObject1);
              }
            }
          }
          this.haK.put(((com.tencent.mm.i.h)localObject2).field_mediaId, localObject2);
        }
      }
    }
    AppMethodBeat.o(126730);
  }
  
  public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126728);
    if ((com.tencent.mm.i.h)this.haK.get(paramString) == null)
    {
      ad.i("MicroMsg.OnlineVideoService", "this media[%s] don't download now.", new Object[] { paramString });
      AppMethodBeat.o(126728);
      return false;
    }
    f.awM();
    boolean bool = a.isVideoDataAvailable(paramString, paramInt1, paramInt2);
    ad.i("MicroMsg.OnlineVideoService", "is video[%s] data[%d, %d] available[%b]", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
    AppMethodBeat.o(126728);
    return bool;
  }
  
  public final boolean j(final String paramString, final Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(126726);
    boolean bool;
    if (!bt.isNullOrNil(paramString)) {
      if (this.haK.containsKey(paramString))
      {
        bool = true;
        if (Looper.myLooper() == Looper.getMainLooper()) {
          break label107;
        }
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(126716);
            com.tencent.mm.i.h localh = (com.tencent.mm.i.h)e.this.haK.remove(paramString);
            com.tencent.mm.i.d locald;
            int i;
            if (localh != null)
            {
              locald = new com.tencent.mm.i.d();
              f.awM();
              i = a.b(localh.field_mediaId, locald);
              if (i == 0) {
                e.a(paramArrayOfObject, locald, localh, false);
              }
            }
            for (;;)
            {
              e.this.haJ.remove(paramString);
              AppMethodBeat.o(126716);
              return;
              ad.w("MicroMsg.OnlineVideoService", "stop video stream download error. ret %d, mediaId %s", new Object[] { Integer.valueOf(i), localh.field_mediaId });
              continue;
              localh = (com.tencent.mm.i.h)e.this.hbo.remove(paramString);
              locald = (com.tencent.mm.i.d)e.this.hbp.remove(paramString);
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
      ad.i("MicroMsg.OnlineVideoService", "cancelDownloadTaskInMainThread mediaId : " + paramString + " remove : " + bool);
      AppMethodBeat.o(126726);
      return bool;
      f.awL().xL(paramString);
      bool = false;
      break;
      label107:
      com.tencent.mm.i.h localh = (com.tencent.mm.i.h)this.haK.remove(paramString);
      com.tencent.mm.i.d locald;
      int i;
      if (localh != null)
      {
        locald = new com.tencent.mm.i.d();
        f.awM();
        i = a.b(localh.field_mediaId, locald);
        if (i == 0) {
          a(paramArrayOfObject, locald, localh, false);
        }
      }
      for (;;)
      {
        this.haJ.remove(paramString);
        break;
        ad.w("MicroMsg.OnlineVideoService", "stop video stream download error. ret %d, mediaId %s", new Object[] { Integer.valueOf(i), localh.field_mediaId });
        continue;
        localh = (com.tencent.mm.i.h)this.hbo.remove(paramString);
        locald = (com.tencent.mm.i.d)this.hbp.remove(paramString);
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
    if (!bt.isNullOrNil(paramString)) {
      if (!this.haK.containsKey(paramString)) {
        break label90;
      }
    }
    for (bool1 = true;; bool1 = bool2)
    {
      com.tencent.mm.kernel.g.afE().ax(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126717);
          com.tencent.mm.i.h localh = (com.tencent.mm.i.h)e.this.haK.remove(paramString);
          com.tencent.mm.i.d locald;
          int i;
          if (localh != null)
          {
            locald = new com.tencent.mm.i.d();
            f.awM();
            i = a.b(localh.field_mediaId, locald);
            if (i == 0) {
              e.a(paramArrayOfObject, locald, localh, false);
            }
          }
          for (;;)
          {
            e.this.haJ.remove(paramString);
            AppMethodBeat.o(126717);
            return;
            ad.w("MicroMsg.OnlineVideoService", "stop video stream download error. ret %d, mediaId %s", new Object[] { Integer.valueOf(i), localh.field_mediaId });
            continue;
            localh = (com.tencent.mm.i.h)e.this.hbo.remove(paramString);
            locald = (com.tencent.mm.i.d)e.this.hbp.remove(paramString);
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
      f.awL().xL(paramString);
    }
  }
  
  public final int l(final String paramString1, final int paramInt1, final int paramInt2, final String paramString2)
  {
    AppMethodBeat.i(202416);
    this.hbq.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126719);
        ad.i("MicroMsg.OnlineVideoService", "onMoovReady mediaId[%s]", new Object[] { paramString1 });
        if (bt.isNullOrNil(paramString1))
        {
          AppMethodBeat.o(126719);
          return;
        }
        com.tencent.mm.kernel.g.afE().ax(new Runnable()
        {
          public final void run()
          {
            boolean bool2 = true;
            AppMethodBeat.i(169095);
            com.tencent.mm.i.h localh = (com.tencent.mm.i.h)e.this.haK.get(e.10.this.Jd);
            Object localObject = new StringBuilder("info=").append(localh).append(" mediaId=").append(e.10.this.Jd).append(" info.videoCallback=");
            if ((localh != null) && (localh.foj == null)) {}
            for (boolean bool1 = true;; bool1 = false)
            {
              ad.w("MicroMsg.OnlineVideoService", bool1);
              if (localh == null) {
                break label507;
              }
              localh.foi = e.10.this.hbs;
              if (localh.foj == null) {
                break;
              }
              localh.foj.a(e.10.this.Jd, e.10.this.hbs, e.10.this.hbt, e.10.this.KCc);
              AppMethodBeat.o(169095);
              return;
            }
            if (r.zK(localh.field_fullpath))
            {
              ad.w("MicroMsg.OnlineVideoService", "it is qt video, need finish all file. isPlayMode" + localh.foc);
              if (localh.foc == 1)
              {
                e.q(localh.field_mediaId, 0, localh.field_totalLen);
                com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 19L, 1L, false);
              }
              AppMethodBeat.o(169095);
              return;
            }
            localObject = new ng();
            ((ng)localObject).dsm.djq = 1;
            ((ng)localObject).dsm.retCode = 0;
            ((ng)localObject).dsm.mediaId = e.10.this.Jd;
            ((ng)localObject).dsm.offset = e.10.this.hbs;
            ((ng)localObject).dsm.length = e.10.this.hbt;
            ((ng)localObject).dsm.dsn = localh.fnZ;
            ng.a locala = ((ng)localObject).dsm;
            if (localh.fnI > 0) {}
            for (bool1 = bool2;; bool1 = false)
            {
              locala.dso = bool1;
              com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
              localObject = u.Ae(localh.filename);
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
              localObject = u.Ae(localh.filename);
              if (localObject != null)
              {
                ((s)localObject).status = 121;
                ((s)localObject).dtM = 256;
                o.aCI().c((s)localObject);
              }
              if (localh.foc == 0)
              {
                ad.i("MicroMsg.OnlineVideoService", "stop download video");
                o.aCN().aDe();
                o.aCN().run();
              }
            }
            label507:
            AppMethodBeat.o(169095);
          }
        });
        AppMethodBeat.o(126719);
      }
    });
    if (this.haK.containsKey(paramString1))
    {
      AppMethodBeat.o(202416);
      return 1;
    }
    AppMethodBeat.o(202416);
    return 0;
  }
  
  public final int n(final String paramString, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(202417);
    ad.i("MicroMsg.OnlineVideoService", "onDataAvailable. offset %d, length %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(202417);
      return 0;
    }
    com.tencent.mm.kernel.g.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126720);
        Object localObject = (com.tencent.mm.i.h)e.this.haK.get(paramString);
        if (localObject != null)
        {
          if (((com.tencent.mm.i.h)localObject).foj != null) {
            ((com.tencent.mm.i.h)localObject).foj.onDataAvailable(paramString, paramInt1, paramInt2);
          }
          localObject = new ng();
          ((ng)localObject).dsm.djq = 2;
          ((ng)localObject).dsm.retCode = 0;
          ((ng)localObject).dsm.mediaId = paramString;
          ((ng)localObject).dsm.offset = paramInt1;
          ((ng)localObject).dsm.length = paramInt2;
          com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
        }
        AppMethodBeat.o(126720);
      }
    });
    if (this.haK.containsKey(paramString))
    {
      AppMethodBeat.o(202417);
      return 1;
    }
    AppMethodBeat.o(202417);
    return 0;
  }
  
  public final int o(final String paramString, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(202418);
    ad.i("MicroMsg.OnlineVideoService", "onDownloadToEnd. offset %d, length %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(202418);
      return 0;
    }
    com.tencent.mm.kernel.g.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126712);
        com.tencent.mm.i.h localh = (com.tencent.mm.i.h)e.this.haK.get(paramString);
        if (localh != null)
        {
          ng localng = new ng();
          localng.dsm.djq = 3;
          localng.dsm.retCode = 0;
          localng.dsm.mediaId = paramString;
          localng.dsm.offset = paramInt1;
          localng.dsm.length = paramInt2;
          com.tencent.mm.sdk.b.a.ESL.l(localng);
          if ((paramInt1 == 0) && (paramInt2 >= localh.fob)) {
            e.a(u.Ae(localh.filename), localh.fob, localh.foa);
          }
        }
        AppMethodBeat.o(126712);
      }
    });
    if (this.haK.containsKey(paramString))
    {
      AppMethodBeat.o(202418);
      return 1;
    }
    AppMethodBeat.o(202418);
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
    ad.i("MicroMsg.OnlineVideoService", "it get cdn dns success[%d, %d], try to start.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (com.tencent.mm.kernel.g.afz().aeI()) {
      com.tencent.mm.kernel.g.afE().ax(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126711);
          e.this.eo(true);
          AppMethodBeat.o(126711);
        }
      });
    }
    AppMethodBeat.o(126723);
  }
  
  public final void release()
  {
    AppMethodBeat.i(126722);
    com.tencent.mm.kernel.g.aeS().b(379, this);
    AppMethodBeat.o(126722);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ao.e
 * JD-Core Version:    0.7.0.1
 */