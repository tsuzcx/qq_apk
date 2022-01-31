package com.tencent.mm.al;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.jy;
import com.tencent.mm.g.a.lu;
import com.tencent.mm.g.b.a.ap;
import com.tencent.mm.g.b.a.au;
import com.tencent.mm.g.b.a.bw;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bf.b;
import com.tencent.mm.model.n;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class e
  implements com.tencent.mm.ai.f, a.a
{
  Queue<String> fyK;
  Map<String, com.tencent.mm.i.h> fyL;
  Map<String, com.tencent.mm.i.h> fyM;
  Map<String, com.tencent.mm.i.h> fzq;
  Map<String, com.tencent.mm.i.d> fzr;
  
  public e()
  {
    AppMethodBeat.i(50568);
    this.fyK = new LinkedList();
    this.fyL = new HashMap();
    this.fyM = new HashMap();
    this.fzq = new HashMap();
    this.fzr = new HashMap();
    com.tencent.mm.kernel.g.Rc().a(379, this);
    AppMethodBeat.o(50568);
  }
  
  public static com.tencent.mm.i.h a(az paramaz, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(50585);
    if (paramaz == null)
    {
      ab.w("MicroMsg.OnlineVideoService", "check can sns online video, scene is null.");
      AppMethodBeat.o(50585);
      return null;
    }
    if (bo.isNullOrNil(paramString1))
    {
      ab.w("MicroMsg.OnlineVideoService", "check can sns online video, url is null.");
      AppMethodBeat.o(50585);
      return null;
    }
    Object localObject = com.tencent.mm.modelvideo.u.vr(paramString3);
    if (localObject == null)
    {
      ab.w("MicroMsg.OnlineVideoService", "check can sns online video, video info is null. %s", new Object[] { paramString3 });
      AppMethodBeat.o(50585);
      return null;
    }
    String str = c.a("snsvideo", paramaz.oLs, "sns", paramString1);
    if (bo.isNullOrNil(str))
    {
      ab.w("MicroMsg.OnlineVideoService", "check can http online video, can not create media id. url %s ", new Object[] { paramString1 });
      AppMethodBeat.o(50585);
      return null;
    }
    com.tencent.mm.i.h localh = new com.tencent.mm.i.h();
    localh.filename = paramString3;
    localh.field_fullpath = paramString2;
    localh.field_mediaId = str;
    localh.edE = 2;
    localh.edJ = paramInt;
    localh.edL = ((s)localObject).edL;
    if (paramaz == null) {
      paramString3 = "";
    }
    for (;;)
    {
      int i = com.tencent.mm.protocal.d.whH;
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RJ();
      str = com.tencent.mm.a.p.getString(com.tencent.mm.kernel.a.getUin());
      int j = at.getNetTypeForStat(ah.getContext());
      int k = at.getStrength(ah.getContext());
      label235:
      long l1;
      if (!bo.isNullOrNil(paramString3))
      {
        localObject = "&scene=".concat(String.valueOf(paramString3));
        localh.referer = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d%s", new Object[] { Integer.valueOf(i), str, Integer.valueOf(j), Integer.valueOf(k), localObject });
        localh.url = paramString1;
        paramString1 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue("SnsSightDomainList");
        long l2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getInt("SnsSightMainStandbyIpSwitchTime", 0);
        ab.i("MicroMsg.OnlineVideoService", "hostvalue %s dcipTime %s scene.time[%d]", new Object[] { paramString1, Long.valueOf(l2), Integer.valueOf(paramaz.oLs) });
        l1 = l2;
        if (l2 <= 0L) {
          l1 = 259200L;
        }
      }
      for (boolean bool = a(paramaz, localh.url, l1, paramString1);; bool = false)
      {
        try
        {
          localh.host = new URL(localh.url).getHost();
          paramString1 = new ArrayList();
          com.tencent.mm.network.b.a(bool, paramString1, localh.host);
          localh.edh = new String[paramString1.size()];
          paramString1.toArray(localh.edh);
          if (bo.gz(paramaz.oLs) <= l1) {
            continue;
          }
          bool = true;
          localh.isColdSnsData = bool;
          localh.signalQuality = at.getStrength(ah.getContext());
          localh.snsScene = paramString3;
          localh.concurrentCount = 5;
          if (((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.lRD, false)) {
            localh.field_requestVideoFormat = com.tencent.mm.modelcontrol.d.x(paramInt, paramString2);
          }
          AppMethodBeat.o(50585);
          return localh;
        }
        catch (Exception paramaz)
        {
          ab.printErrStackTrace("MicroMsg.OnlineVideoService", paramaz, "check can sns online video error taskInfo %s", new Object[] { localh });
          AppMethodBeat.o(50585);
          return null;
        }
        if (paramaz.equals(az.yNN))
        {
          paramString3 = "album_friend";
          break;
        }
        if (paramaz.equals(az.yNO))
        {
          paramString3 = "album_self";
          break;
        }
        if (paramaz.equals(az.yNP))
        {
          paramString3 = "album_stranger";
          break;
        }
        if (paramaz.equals(az.yNQ))
        {
          paramString3 = "profile_friend";
          break;
        }
        if (paramaz.equals(az.yNR))
        {
          paramString3 = "profile_stranger";
          break;
        }
        if (paramaz.equals(az.yNS))
        {
          paramString3 = "comment";
          break;
        }
        if (paramaz.equals(az.yNM))
        {
          paramString3 = "timeline";
          break;
        }
        if (paramaz.equals(az.yNV))
        {
          paramString3 = "snssight";
          break;
        }
        if (!paramaz.equals(az.yNX)) {
          break label751;
        }
        paramString3 = "storysight";
        break;
        localObject = "";
        break label235;
      }
      label751:
      paramString3 = "";
    }
  }
  
  private static void a(com.tencent.mm.i.h paramh, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(139636);
    if (paramArrayOfObject != null) {}
    for (int i = ((Integer)paramArrayOfObject[6]).intValue();; i = 0)
    {
      boolean bool1 = paramh.Jr();
      boolean bool2 = paramh.Jp();
      boolean bool3 = paramh.Jt();
      ab.i("MicroMsg.OnlineVideoService", "CodecID: Path : [%s] ", new Object[] { paramh.field_fullpath });
      paramArrayOfObject = SightVideoJNI.getCodecID(paramh.field_fullpath);
      ab.i("MicroMsg.OnlineVideoService", "CodecID: [%d], VideoFormat: [%d]", new Object[] { Integer.valueOf(paramArrayOfObject[0]), Integer.valueOf(paramArrayOfObject[1]) });
      if (bool1)
      {
        com.tencent.mm.plugin.report.service.h.qsU.e(17319, new Object[] { paramh.field_fileId, Integer.valueOf(1), Integer.valueOf(paramArrayOfObject[0]), Integer.valueOf(i), Integer.valueOf(paramArrayOfObject[1]) });
        AppMethodBeat.o(139636);
        return;
      }
      if (bool2)
      {
        com.tencent.mm.plugin.report.service.h.qsU.e(17319, new Object[] { paramh.url, Integer.valueOf(0), Integer.valueOf(paramArrayOfObject[0]), Integer.valueOf(i), Integer.valueOf(paramArrayOfObject[1]) });
        AppMethodBeat.o(139636);
        return;
      }
      if (bool3) {
        com.tencent.mm.plugin.report.service.h.qsU.e(17319, new Object[] { paramh.url, Integer.valueOf(2), Integer.valueOf(paramArrayOfObject[0]), Integer.valueOf(i), Integer.valueOf(paramArrayOfObject[1]) });
      }
      AppMethodBeat.o(139636);
      return;
    }
  }
  
  static void a(s params, int paramInt, String paramString)
  {
    AppMethodBeat.i(50582);
    ab.i("MicroMsg.OnlineVideoService", "download finish. totalLen %d ", new Object[] { Integer.valueOf(paramInt) });
    if (params != null)
    {
      com.tencent.mm.modelvideo.u.ae(params.getFileName(), paramInt);
      i(paramInt, paramString, params.getFileName());
    }
    AppMethodBeat.o(50582);
  }
  
  private static void a(PInt paramPInt1, PInt paramPInt2, String paramString, int paramInt)
  {
    AppMethodBeat.i(50588);
    int j = 0;
    paramString = com.tencent.mm.modelvideo.u.vr(paramString);
    if (paramString != null) {
      j = paramString.czu;
    }
    for (int k = paramString.fsd;; k = 0)
    {
      if (paramInt <= 0)
      {
        i = 1;
        paramPInt1.value = j;
        paramPInt2.value = i;
        ab.d("MicroMsg.OnlineVideoService", "getPreloadVideoInfo pHadPreloadSize[%d] pHadPreloadCompletion[%d]", new Object[] { Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value) });
        AppMethodBeat.o(50588);
        return;
      }
      int m = (int)(paramInt / 100.0F * k);
      if (j < m) {}
      for (int i = 2;; i = 3)
      {
        ab.d("MicroMsg.OnlineVideoService", "getPreloadVideoInfo %d * %d = configSize[%d] preloadSize[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j) });
        break;
      }
    }
  }
  
  private static void a(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, long paramLong1, long paramLong2, String paramString4, String[] paramArrayOfString, String paramString5, int paramInt3, int paramInt4, String paramString6)
  {
    AppMethodBeat.i(50589);
    jy localjy = new jy();
    localjy.czo.czp = paramString1;
    localjy.czo.czq = paramString2;
    localjy.czo.czr = paramInt1;
    localjy.czo.fileId = paramString3;
    localjy.czo.netType = paramInt2;
    localjy.czo.startTime = paramLong1;
    localjy.czo.endTime = paramLong2;
    localjy.czo.path = paramString4;
    localjy.czo.czs = paramArrayOfString;
    localjy.czo.czt = paramString5;
    localjy.czo.czu = paramInt3;
    localjy.czo.czv = paramInt4;
    localjy.czo.czw = paramString6;
    com.tencent.mm.sdk.b.a.ymk.l(localjy);
    AppMethodBeat.o(50589);
  }
  
  public static void a(Object[] paramArrayOfObject, com.tencent.mm.i.d paramd, com.tencent.mm.i.h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(50587);
    if ((paramh == null) || (paramd == null))
    {
      ab.w("MicroMsg.OnlineVideoService", "video task info is null or download result is null.");
      AppMethodBeat.o(50587);
      return;
    }
    if ((!paramh.Jp()) && (!paramh.Jr()) && (!paramh.Jt()))
    {
      AppMethodBeat.o(50587);
      return;
    }
    a(paramh, paramArrayOfObject);
    String str2 = paramd.field_clientIP;
    int i4;
    label151:
    label172:
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
      ab.i("MicroMsg.OnlineVideoService", "rpt online video format[%d] clientIp[%s] isCrossNet[%d]", new Object[] { Integer.valueOf(paramd.field_videoFormat), str2, Integer.valueOf(i4) });
      if (paramd.field_videoFormat == 2) {
        com.tencent.mm.modelvideo.u.vv(paramh.filename);
      }
      if (!bo.isNullOrNil(str2)) {
        break label1482;
      }
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(354L, 45L, 1L, false);
      if (!paramd.field_isCrossNet) {
        break label1499;
      }
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(354L, 47L, 1L, false);
      bool1 = paramh.Jr();
      bool2 = paramh.Jt();
      localObject1 = new PInt();
      localObject2 = new PInt();
      ((PInt)localObject2).value = 0;
      ((PInt)localObject1).value = 0;
      com.tencent.mm.modelvideo.u.a(paramh.field_fullpath, (PInt)localObject1, (PInt)localObject2);
      i15 = ((PInt)localObject1).value * 1000;
      i16 = ((PInt)localObject2).value;
      i6 = 0;
      i5 = 0;
      if (paramArrayOfObject == null) {
        break label2662;
      }
      i2 = ((Integer)paramArrayOfObject[0]).intValue() * 1000;
      j = ((Integer)paramArrayOfObject[1]).intValue();
      i3 = ((Integer)paramArrayOfObject[2]).intValue();
      m = ((Integer)paramArrayOfObject[3]).intValue();
      i = ((Integer)paramArrayOfObject[4]).intValue();
      n = ((Integer)paramArrayOfObject[5]).intValue();
      i1 = ((Integer)paramArrayOfObject[6]).intValue();
      if (paramArrayOfObject.length <= 10) {
        break label2655;
      }
      i6 = ((Integer)paramArrayOfObject[7]).intValue();
      localObject1 = (String)paramArrayOfObject[8];
      i5 = ((Long)paramArrayOfObject[9]).intValue();
    }
    for (;;)
    {
      int i7 = paramh.edL;
      int k = i7;
      label400:
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
        i17 = at.gV(ah.getContext());
        str1 = paramd.Jn();
        PInt localPInt1 = new PInt();
        localPInt2 = new PInt();
        a(localPInt1, localPInt2, paramh.filename, paramh.edO);
        localStringBuffer = new StringBuffer();
        if (!bool1) {
          break label1523;
        }
        localStringBuffer.append(paramh.field_fileId).append(",").append(paramh.field_aesKey).append(",");
        label490:
        localStringBuffer.append(paramd.field_fileLength).append(",").append(i15).append(",");
        localStringBuffer.append(paramd.field_recvedBytes).append(",");
        localStringBuffer.append(i2 + ",").append(j + ",").append(i3 + ",");
        localStringBuffer.append(m + ",").append(i + ",");
        localStringBuffer.append(i17).append(",");
        localStringBuffer.append(k).append(",");
        localStringBuffer.append(paramd.field_startTime).append(",");
        localStringBuffer.append(paramd.field_endTime).append(",");
        if (!bool1) {
          break label1570;
        }
        if (paramh.edK == null) {
          break label1555;
        }
        localObject2 = com.tencent.mm.a.g.w(paramh.edK.getBytes());
        label743:
        localStringBuffer.append(localObject2).append(",");
        if (!com.tencent.mm.model.t.lA(paramh.edK)) {
          break label1564;
        }
        k = 1;
        label770:
        localStringBuffer.append(k).append(",");
        label784:
        localStringBuffer.append(paramd.field_retCode).append(",");
        localStringBuffer.append(paramd.field_enQueueTime).append(",");
        localStringBuffer.append(paramd.field_firstRequestCost).append(",");
        localStringBuffer.append(paramd.field_firstRequestSize).append(",");
        localStringBuffer.append(paramd.field_firstRequestDownloadSize).append(",");
        if (!paramd.field_firstRequestCompleted) {
          break label1602;
        }
        k = 1;
        label874:
        localStringBuffer.append(k).append(",");
        localStringBuffer.append(paramd.field_averageSpeed).append(",");
        localStringBuffer.append(paramd.field_averageConnectCost).append(",");
        localStringBuffer.append(paramd.field_firstConnectCost).append(",");
        localStringBuffer.append(paramd.field_netConnectTimes).append(",");
        localStringBuffer.append(paramd.field_moovRequestTimes).append(",");
        localStringBuffer.append(paramd.field_moovCost).append(",");
        localStringBuffer.append(paramd.field_moovSize).append(",");
        if (!paramd.field_moovCompleted) {
          break label1608;
        }
        k = 1;
        label1010:
        localStringBuffer.append(k).append(",");
        localStringBuffer.append(paramd.field_moovFailReason).append(",");
        localStringBuffer.append(n).append(",");
        localStringBuffer.append(i1).append(",");
        if (!bool1) {
          break label1614;
        }
        localStringBuffer.append(i16).append(",");
        localStringBuffer.append(str1).append(",");
        if (!bool1) {
          break label1673;
        }
        localStringBuffer.append(paramh.edN).append(",");
        localStringBuffer.append(paramh.cFn).append(",");
        localStringBuffer.append(paramh.edq).append(",");
        localStringBuffer.append(paramd.field_videoFormat).append(",");
        label1170:
        localStringBuffer.append(str2).append(",");
        localStringBuffer.append(i4).append(",");
        localStringBuffer.append(paramh.edP).append(",");
        localStringBuffer.append(localPInt1.value).append(",");
        localStringBuffer.append(localPInt2.value);
        if (!bool1) {
          break label1695;
        }
        k = 13570;
        label1252:
        if (bool2) {
          k = 13570;
        }
        localObject2 = localStringBuffer.toString();
        ab.i("MicroMsg.OnlineVideoService", "report online video %d:%s", new Object[] { Integer.valueOf(k), localObject2 });
        if (!bool1) {
          break label1703;
        }
        new com.tencent.mm.g.b.a.u((String)localObject2).ake();
        label1312:
        if (paramBoolean) {
          a(paramh.czp, paramh.edK, paramh.czr, paramd.field_fileId, i17, paramd.field_startTime, paramd.field_endTime, paramh.field_fullpath, paramd.field_usedSvrIps, paramh.url, localPInt1.value, localPInt2.value, paramh.czw);
        }
        if (bool1)
        {
          if (paramd.field_videoFormat != 2) {
            break label2638;
          }
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(354L, 132L, 1L, false);
        }
      }
      for (;;)
      {
        paramArrayOfObject = com.tencent.mm.modelvideo.u.vr(paramh.filename);
        if (paramArrayOfObject != null)
        {
          paramArrayOfObject = ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().kB(paramArrayOfObject.fXy);
          ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().a(new h.c(paramArrayOfObject.field_talker, "update", paramArrayOfObject));
        }
        AppMethodBeat.o(50587);
        return;
        i4 = 0;
        break;
        label1482:
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(354L, 46L, 1L, false);
        break label151;
        label1499:
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(354L, 48L, 1L, false);
        break label172;
        k = 31;
        break label400;
        label1523:
        localStringBuffer.append(paramh.url).append(",").append(paramh.edM).append(",");
        break label490;
        label1555:
        localObject2 = Integer.valueOf(0);
        break label743;
        label1564:
        k = 0;
        break label770;
        label1570:
        localStringBuffer.append(0).append(",");
        localStringBuffer.append(paramd.field_httpStatusCode).append(",");
        break label784;
        label1602:
        k = 0;
        break label874;
        label1608:
        k = 0;
        break label1010;
        label1614:
        localStringBuffer.append(i16).append(",");
        if (paramh.edK != null) {}
        for (localObject2 = com.tencent.mm.a.g.w(paramh.edK.getBytes());; localObject2 = Integer.valueOf(0))
        {
          localStringBuffer.append(localObject2).append(",");
          break;
        }
        label1673:
        localStringBuffer.append(com.tencent.mm.plugin.video.c.aeA(paramh.czw)).append(",");
        break label1170;
        label1695:
        k = 13790;
        break label1252;
        label1703:
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
              k = bo.getInt(paramArrayOfObject[7].toString(), 0);
              bo.getInt(paramArrayOfObject[8].toString(), 0);
              i4 = bo.getInt(paramArrayOfObject[9].toString(), 0);
              localObject1 = paramArrayOfObject[11].toString();
              i5 = bo.getInt(paramArrayOfObject[12].toString(), 0);
              l1 = bo.getLong(paramArrayOfObject[13].toString(), 0L);
              i6 = bo.getInt(paramArrayOfObject[14].toString(), 0);
              i7 = bo.getInt(paramArrayOfObject[15].toString(), 0);
              i8 = bo.getInt(paramArrayOfObject[16].toString(), 0);
            }
          }
          paramArrayOfObject = new bw();
          localObject1 = paramArrayOfObject.gS((String)localObject1);
          ((bw)localObject1).cYY = i5;
          ((bw)localObject1).cYZ = i7;
          ((bw)localObject1).cZa = i6;
          ((bw)localObject1).cQH = i15;
          ((bw)localObject1).cZb = (i2 / 1000);
          ((bw)localObject1).cSX = j;
          ((bw)localObject1).cSY = i3;
          ((bw)localObject1).cZc = m;
          ((bw)localObject1).cTa = i;
          ((bw)localObject1).cZd = 0L;
          ((bw)localObject1).cTu = n;
          ((bw)localObject1).cZe = i1;
          localObject1 = ((bw)localObject1).gT("");
          ((bw)localObject1).cQI = (i16 * 1000);
          localObject1 = ((bw)localObject1).gU(paramh.field_requestVideoFormat);
          ((bw)localObject1).cOC = paramd.field_fileLength;
          ((bw)localObject1).cZh = paramd.field_recvedBytes;
          ((bw)localObject1).cTd = paramd.field_startTime;
          ((bw)localObject1).cTe = paramd.field_endTime;
          ((bw)localObject1).cZi = paramd.field_retCode;
          ((bw)localObject1).cZj = paramd.field_enQueueTime;
          ((bw)localObject1).cZk = paramd.field_moovRequestTimes;
          ((bw)localObject1).cZl = paramd.field_moovCost;
          ((bw)localObject1).cTr = paramd.field_moovSize;
          if (paramd.field_moovCompleted)
          {
            l2 = 1L;
            ((bw)localObject1).cZm = l2;
            ((bw)localObject1).cZn = paramd.field_moovFailReason;
            ((bw)localObject1).cZo = paramd.field_firstConnectCost;
            ((bw)localObject1).cZp = paramd.field_firstRequestCost;
            ((bw)localObject1).cZq = paramd.field_firstRequestSize;
            ((bw)localObject1).cZr = paramd.field_firstRequestDownloadSize;
            if (!paramd.field_firstRequestCompleted) {
              break label2589;
            }
            l2 = 1L;
            label2243:
            ((bw)localObject1).cZs = l2;
            ((bw)localObject1).cZt = paramd.field_averageSpeed;
            ((bw)localObject1).cZu = paramd.field_averageConnectCost;
            ((bw)localObject1).cTo = paramd.field_netConnectTimes;
            localObject1 = ((bw)localObject1).gV(paramd.Jn()).gW(paramd.field_clientIP);
            if (!paramd.field_isCrossNet) {
              break label2595;
            }
          }
          for (l2 = 1L;; l2 = 0L)
          {
            ((bw)localObject1).cZw = l2;
            ((bw)localObject1).cTC = paramh.edP;
            ((bw)localObject1).cZx = i4;
            ((bw)localObject1).cOA = i17;
            ((bw)localObject1).cZy = l1;
            ((bw)localObject1).cQP = k;
            ((bw)localObject1).cZz = i8;
            ab.d("MicroMsg.OnlineVideoService", "time distance %d", new Object[] { Long.valueOf(System.currentTimeMillis() - paramArrayOfObject.cZy) });
            if (System.currentTimeMillis() - paramArrayOfObject.cZy > 500L) {
              paramArrayOfObject.ake();
            }
            paramArrayOfObject = new au();
            localObject1 = com.tencent.mm.plugin.sight.base.d.Zo(paramh.field_fullpath);
            if (localObject1 != null)
            {
              paramArrayOfObject.cQH = ((com.tencent.mm.plugin.sight.base.a)localObject1).eVA;
              paramArrayOfObject.cQI = ((com.tencent.mm.plugin.sight.base.a)localObject1).videoBitrate;
              paramArrayOfObject.cQJ = ((com.tencent.mm.plugin.sight.base.a)localObject1).fzT;
              paramArrayOfObject.cQK = ((com.tencent.mm.plugin.sight.base.a)localObject1).eRw;
              paramArrayOfObject.cQL = ((com.tencent.mm.plugin.sight.base.a)localObject1).width;
              paramArrayOfObject.cQM = ((com.tencent.mm.plugin.sight.base.a)localObject1).height;
              paramArrayOfObject.cQO = ((com.tencent.mm.plugin.sight.base.a)localObject1).qSh;
            }
            paramArrayOfObject.cQG = paramd.field_fileLength;
            paramArrayOfObject = paramArrayOfObject.gg(paramh.url);
            f.afP();
            paramArrayOfObject = paramArrayOfObject.gh(a.sE(paramh.field_fullpath));
            paramArrayOfObject.cQE = paramd.field_startTime;
            paramArrayOfObject.cQF = paramd.field_endTime;
            paramArrayOfObject = paramArrayOfObject.gi(str1);
            paramArrayOfObject.cQP = k;
            paramArrayOfObject.cQQ = localPInt2.value;
            paramArrayOfObject.ake();
            break;
            l2 = 0L;
            break label2176;
            l2 = 0L;
            break label2243;
          }
        }
        label2176:
        label2589:
        label2595:
        paramArrayOfObject = new ap((String)localObject2);
        paramArrayOfObject.cUY = i5;
        paramArrayOfObject.fW((String)localObject1);
        paramArrayOfObject.cUW = i6;
        paramArrayOfObject.ake();
        break label1312;
        label2638:
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(354L, 133L, 1L, false);
      }
      label2655:
      localObject1 = "";
      continue;
      label2662:
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
  
  private static boolean a(az paramaz, String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(50586);
    if (paramString1 == null)
    {
      AppMethodBeat.o(50586);
      return false;
    }
    try
    {
      paramString1 = new URL(paramString1);
      if (paramaz == null)
      {
        AppMethodBeat.o(50586);
        return false;
      }
      if (paramString2 == null)
      {
        AppMethodBeat.o(50586);
        return false;
      }
      int i = paramString2.indexOf(paramString1.getHost());
      if (i == -1)
      {
        AppMethodBeat.o(50586);
        return false;
      }
      i = paramaz.oLs;
      if (i == 0)
      {
        AppMethodBeat.o(50586);
        return false;
      }
      long l = bo.gz(paramaz.oLs);
      if (l > paramLong)
      {
        AppMethodBeat.o(50586);
        return true;
      }
      AppMethodBeat.o(50586);
      return false;
    }
    catch (Exception paramaz)
    {
      ab.e("MicroMsg.OnlineVideoService", "error for check dcip %s", new Object[] { paramaz.getMessage() });
      AppMethodBeat.o(50586);
    }
    return false;
  }
  
  private static boolean i(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(50583);
    if (bo.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(50583);
      return false;
    }
    o.alE();
    paramString2 = com.tencent.mm.modelvideo.t.vf(paramString2);
    if ((bo.isNullOrNil(paramString1)) || (paramInt <= 0) || (bo.isNullOrNil(paramString2)))
    {
      ab.w("MicroMsg.OnlineVideoService", "insert media duplication but args is error.[%d, %s, %s]", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
      AppMethodBeat.o(50583);
      return false;
    }
    boolean bool = ((com.tencent.mm.plugin.m.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.m.a.a.class)).YH().y(paramString1, paramInt, paramString2);
    AppMethodBeat.o(50583);
    return bool;
  }
  
  public static int r(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(50576);
    f.afP();
    int i = a.r(paramString, paramInt1, paramInt2);
    ab.i("MicroMsg.OnlineVideoService", "request video video[%s], offset[%d], length[%d] duration[%d] ret[%d]", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0), Integer.valueOf(i) });
    AppMethodBeat.o(50576);
    return i;
  }
  
  public static com.tencent.mm.i.h sL(String paramString)
  {
    AppMethodBeat.i(50584);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(50584);
      return null;
    }
    s locals = com.tencent.mm.modelvideo.u.vr(paramString);
    if (locals == null)
    {
      AppMethodBeat.o(50584);
      return null;
    }
    Object localObject1 = br.F(locals.alP(), "msg");
    if (localObject1 == null)
    {
      ab.w("MicroMsg.OnlineVideoService", "cdntra parse video recv xml failed");
      AppMethodBeat.o(50584);
      return null;
    }
    Object localObject2 = (String)((Map)localObject1).get(".msg.videomsg.$cdnvideourl");
    if (bo.isNullOrNil((String)localObject2))
    {
      ab.w("MicroMsg.OnlineVideoService", "cdntra parse video recv xml failed");
      AppMethodBeat.o(50584);
      return null;
    }
    int j = Integer.valueOf((String)((Map)localObject1).get(".msg.videomsg.$length")).intValue();
    String str1 = (String)((Map)localObject1).get(".msg.videomsg.$md5");
    String str2 = (String)((Map)localObject1).get(".msg.videomsg.$aeskey");
    String str3 = (String)((Map)localObject1).get(".msg.videomsg.$fileparam");
    String str4 = c.a("downvideo", locals.createTime, locals.getUser(), locals.getFileName());
    if (bo.isNullOrNil(str4))
    {
      ab.w("MicroMsg.OnlineVideoService", "cdntra genClientId failed not use cdn file:%s", new Object[] { locals.getFileName() });
      AppMethodBeat.o(50584);
      return null;
    }
    o.alE();
    String str5 = com.tencent.mm.modelvideo.t.vf(paramString);
    localObject1 = new com.tencent.mm.i.h();
    ((com.tencent.mm.i.h)localObject1).filename = paramString;
    ((com.tencent.mm.i.h)localObject1).edH = str1;
    ((com.tencent.mm.i.h)localObject1).edI = j;
    ((com.tencent.mm.i.h)localObject1).edJ = 1;
    ((com.tencent.mm.i.h)localObject1).czp = locals.alM();
    ((com.tencent.mm.i.h)localObject1).edK = locals.getUser();
    if (com.tencent.mm.model.t.lA(locals.getUser()))
    {
      i = n.nv(locals.getUser());
      ((com.tencent.mm.i.h)localObject1).czr = i;
      ((com.tencent.mm.i.h)localObject1).field_mediaId = str4;
      ((com.tencent.mm.i.h)localObject1).field_fullpath = str5;
      ((com.tencent.mm.i.h)localObject1).field_fileType = com.tencent.mm.i.a.MediaType_VIDEO;
      ((com.tencent.mm.i.h)localObject1).field_totalLen = j;
      ((com.tencent.mm.i.h)localObject1).field_aesKey = str2;
      ((com.tencent.mm.i.h)localObject1).field_fileId = ((String)localObject2);
      ((com.tencent.mm.i.h)localObject1).field_priority = com.tencent.mm.i.a.ecF;
      ((com.tencent.mm.i.h)localObject1).field_wxmsgparam = str3;
      if (!com.tencent.mm.model.t.lA(locals.getUser())) {
        break label536;
      }
      i = 1;
      label385:
      ((com.tencent.mm.i.h)localObject1).field_chattype = i;
      ((com.tencent.mm.i.h)localObject1).edL = locals.edL;
      paramString = ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().ag(locals.getUser(), locals.cFn);
      localObject2 = bf.pA(paramString.dns);
      ((com.tencent.mm.i.h)localObject1).edq = 0;
      ((com.tencent.mm.i.h)localObject1).edr = 0;
      ((com.tencent.mm.i.h)localObject1).edN = paramString.field_createTime;
      ((com.tencent.mm.i.h)localObject1).cFn = paramString.field_msgSvrId;
      if (localObject2 == null) {
        break label541;
      }
    }
    label536:
    label541:
    for (int i = ((bf.b)localObject2).fmU;; i = 0)
    {
      ((com.tencent.mm.i.h)localObject1).edO = i;
      if (((com.tencent.mm.i.h)localObject1).edq > 0) {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(354L, 36L, 1L, false);
      }
      ((com.tencent.mm.i.h)localObject1).field_autostart = false;
      ((com.tencent.mm.i.h)localObject1).field_requestVideoFormat = com.tencent.mm.modelcontrol.d.a(1, locals);
      AppMethodBeat.o(50584);
      return localObject1;
      i = 0;
      break;
      i = 0;
      break label385;
    }
  }
  
  public final int a(String paramString, com.tencent.mm.i.c paramc, com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(50581);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.OnlineVideoService", "cdn callback mediaid is null.");
      AppMethodBeat.o(50581);
      return -1;
    }
    if ((paramc == null) && (paramd == null))
    {
      ab.e("MicroMsg.OnlineVideoService", "cdn callback info all null.");
      AppMethodBeat.o(50581);
      return -2;
    }
    com.tencent.mm.kernel.g.RO().ac(new e.2(this, paramString, paramc, paramd));
    if (this.fyM.get(paramString) != null)
    {
      AppMethodBeat.o(50581);
      return 1;
    }
    AppMethodBeat.o(50581);
    return 0;
  }
  
  public final boolean a(final com.tencent.mm.i.h paramh)
  {
    AppMethodBeat.i(50572);
    if (bo.isNullOrNil(paramh.field_mediaId))
    {
      ab.e("MicroMsg.OnlineVideoService", "add download task, but task mediaId is null.");
      AppMethodBeat.o(50572);
      return false;
    }
    ab.i("MicroMsg.OnlineVideoService", "add download task : " + paramh.field_mediaId);
    if (paramh.field_fileId == null) {
      paramh.field_fileId = "";
    }
    if (paramh.field_aesKey == null) {
      paramh.field_aesKey = "";
    }
    paramh.cMU = false;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      al.d(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(50562);
          e.this.fyK.add(paramh.field_mediaId);
          e.this.fyL.put(paramh.field_mediaId, paramh);
          e.this.cV(false);
          AppMethodBeat.o(50562);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(50572);
      return true;
      this.fyK.add(paramh.field_mediaId);
      this.fyL.put(paramh.field_mediaId, paramh);
      cV(false);
    }
  }
  
  public final boolean a(com.tencent.mm.i.h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(50571);
    if (paramh == null)
    {
      ab.e("MicroMsg.OnlineVideoService", "add download task, but task is null.");
      AppMethodBeat.o(50571);
      return false;
    }
    if (bo.isNullOrNil(paramh.field_mediaId))
    {
      ab.e("MicroMsg.OnlineVideoService", "add download task, but task mediaId is null.");
      AppMethodBeat.o(50571);
      return false;
    }
    ab.i("MicroMsg.OnlineVideoService", "add download task : " + paramh.field_mediaId + " delay : " + paramBoolean);
    if (paramh.field_fileId == null) {
      paramh.field_fileId = "";
    }
    if (paramh.field_aesKey == null) {
      paramh.field_aesKey = "";
    }
    paramh.cMU = false;
    if ((j(paramh.field_mediaId, null)) || (paramBoolean)) {
      com.tencent.mm.kernel.g.RO().ac(new e.3(this, paramh));
    }
    for (;;)
    {
      AppMethodBeat.o(50571);
      return true;
      com.tencent.mm.kernel.g.RO().ac(new e.4(this, paramh));
    }
  }
  
  public final void cV(boolean paramBoolean)
  {
    AppMethodBeat.i(50577);
    if (!com.tencent.mm.kernel.g.RG())
    {
      AppMethodBeat.o(50577);
      return;
    }
    if ((!paramBoolean) && (f.afP().afH()))
    {
      com.tencent.mm.kernel.g.RJ();
      if (com.tencent.mm.kernel.a.QT())
      {
        ab.w("MicroMsg.OnlineVideoService", "cdn engine not init cdn dnsinfo , will retry after set info");
        f.afO().cV(paramBoolean);
        AppMethodBeat.o(50577);
        return;
      }
    }
    f.afO().afJ();
    while (!this.fyK.isEmpty())
    {
      Object localObject1 = (String)this.fyK.poll();
      Object localObject2 = (com.tencent.mm.i.h)this.fyL.remove(localObject1);
      if (localObject2 != null)
      {
        ((com.tencent.mm.i.h)localObject2).field_startTime = bo.aoy();
        if (!((com.tencent.mm.i.h)localObject2).cMU)
        {
          if (((Integer)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yDz, Integer.valueOf(-1))).intValue() == 2) {
            ab.i("MicroMsg.OnlineVideoService", "command set do not check media duplication.");
          }
          label167:
          int j;
          for (int i = 0;; i = 1)
          {
            if (i == 0) {
              break label410;
            }
            localObject2 = new lu();
            ((lu)localObject2).cBN.cut = 6;
            ((lu)localObject2).cBN.cBO = ((String)localObject1);
            com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject2);
            break;
            if (((com.tencent.mm.i.h)localObject2).Js()) {
              break label167;
            }
            Object localObject3 = ((com.tencent.mm.i.h)localObject2).edH;
            i = ((com.tencent.mm.i.h)localObject2).edI;
            Object localObject4 = ((com.tencent.mm.plugin.m.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.m.a.a.class)).YH().eG((String)localObject3, i);
            j = i - (int)com.tencent.mm.vfs.e.avI((String)localObject4);
            if ((bo.isNullOrNil((String)localObject4)) || (j < 0) || (j > 16)) {
              break label167;
            }
            ab.i("MicroMsg.OnlineVideoService", "it had download this video[%d, %s, %s].", new Object[] { Integer.valueOf(i), localObject3, localObject4 });
            com.tencent.mm.vfs.e.C((String)localObject4, ((com.tencent.mm.i.h)localObject2).field_fullpath);
            localObject4 = com.tencent.mm.modelvideo.u.vr(((com.tencent.mm.i.h)localObject2).filename);
            a((s)localObject4, i, (String)localObject3);
            localObject3 = ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().kB(((s)localObject4).fXy);
            ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().a(new h.c(((dd)localObject3).field_talker, "update", (bi)localObject3));
          }
          label410:
          if (((com.tencent.mm.i.h)localObject2).Jr())
          {
            i = f.afP().a((com.tencent.mm.i.g)localObject2, ((com.tencent.mm.i.h)localObject2).edJ);
            label432:
            ab.i("MicroMsg.OnlineVideoService", "start task %s streaming download. ret %d ", new Object[] { localObject2, Integer.valueOf(i) });
            if (i == 0) {
              break label1036;
            }
            ab.w("MicroMsg.OnlineVideoService", "start stream video error. ret : " + i + " media id: " + ((com.tencent.mm.i.h)localObject2).field_mediaId);
            paramBoolean = ((com.tencent.mm.i.h)localObject2).Jr();
            j = ((com.tencent.mm.i.h)localObject2).edJ;
            if (!paramBoolean) {
              break label947;
            }
            com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(354L, 3L, 1L, false);
            if (j != 1) {
              break label882;
            }
            if (i != -21006) {
              break label841;
            }
            com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(354L, 100L, 1L, false);
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.qsU.e(13836, new Object[] { Integer.valueOf(100), Long.valueOf(bo.aox()), "" });
            break;
            if (((com.tencent.mm.i.h)localObject2).Jp())
            {
              i = f.afP().a(((com.tencent.mm.i.h)localObject2).field_mediaId, ((com.tencent.mm.i.h)localObject2).url, ((com.tencent.mm.i.h)localObject2).referer, ((com.tencent.mm.i.h)localObject2).field_fullpath, ((com.tencent.mm.i.h)localObject2).edJ, ((com.tencent.mm.i.h)localObject2).edh, ((com.tencent.mm.i.h)localObject2).isColdSnsData, ((com.tencent.mm.i.h)localObject2).signalQuality, ((com.tencent.mm.i.h)localObject2).snsScene, ((com.tencent.mm.i.h)localObject2).field_preloadRatio, ((com.tencent.mm.i.h)localObject2).field_requestVideoFormat, 4, ((com.tencent.mm.i.h)localObject2).concurrentCount);
              break label432;
            }
            if (((com.tencent.mm.i.h)localObject2).Jt())
            {
              i = f.afP().a(((com.tencent.mm.i.h)localObject2).field_mediaId, ((com.tencent.mm.i.h)localObject2).url, ((com.tencent.mm.i.h)localObject2).referer, ((com.tencent.mm.i.h)localObject2).field_fullpath, ((com.tencent.mm.i.h)localObject2).edJ, ((com.tencent.mm.i.h)localObject2).edh, ((com.tencent.mm.i.h)localObject2).isColdSnsData, ((com.tencent.mm.i.h)localObject2).signalQuality, ((com.tencent.mm.i.h)localObject2).snsScene, ((com.tencent.mm.i.h)localObject2).field_preloadRatio, ((com.tencent.mm.i.h)localObject2).field_requestVideoFormat, 4);
              break label432;
            }
            if (((com.tencent.mm.i.h)localObject2).Jq())
            {
              i = f.afP().a(((com.tencent.mm.i.h)localObject2).field_mediaId, ((com.tencent.mm.i.h)localObject2).url, ((com.tencent.mm.i.h)localObject2).referer, ((com.tencent.mm.i.h)localObject2).field_fullpath, ((com.tencent.mm.i.h)localObject2).edJ, ((com.tencent.mm.i.h)localObject2).field_preloadRatio, ((com.tencent.mm.i.h)localObject2).concurrentCount);
              break label432;
            }
            i = f.afP().a(((com.tencent.mm.i.h)localObject2).field_mediaId, ((com.tencent.mm.i.h)localObject2).url, ((com.tencent.mm.i.h)localObject2).referer, ((com.tencent.mm.i.h)localObject2).field_fullpath, ((com.tencent.mm.i.h)localObject2).edJ, ((com.tencent.mm.i.h)localObject2).edh, ((com.tencent.mm.i.h)localObject2).field_preloadRatio);
            break label432;
            label841:
            if (i == -20003)
            {
              com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(354L, 101L, 1L, false);
            }
            else
            {
              com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(354L, 102L, 1L, false);
              continue;
              label882:
              if (i == -21006) {
                com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(354L, 106L, 1L, false);
              } else if (i == -20003) {
                com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(354L, 107L, 1L, false);
              } else {
                com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(354L, 108L, 1L, false);
              }
            }
          }
          label947:
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(354L, 210L, 1L, false);
          if (j == 1) {
            com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(354L, 211L, 1L, false);
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.qsU.e(13836, new Object[] { Integer.valueOf(200), Long.valueOf(bo.aox()), "" });
            break;
            com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(354L, 212L, 1L, false);
          }
          label1036:
          ((com.tencent.mm.i.h)localObject2).edG = bo.aoy();
          if (((com.tencent.mm.i.h)localObject2).Jr())
          {
            localObject1 = com.tencent.mm.modelvideo.u.vr(((com.tencent.mm.i.h)localObject2).filename);
            if (localObject1 != null)
            {
              i = ((s)localObject1).status;
              if ((i != 120) && (i != 122) && (i != 121))
              {
                ((s)localObject1).status = 120;
                ((s)localObject1).bsY = 256;
                o.alE().c((s)localObject1);
              }
            }
          }
          this.fyM.put(((com.tencent.mm.i.h)localObject2).field_mediaId, localObject2);
        }
      }
    }
    AppMethodBeat.o(50577);
  }
  
  public final boolean h(String paramString, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(50573);
    boolean bool;
    if (!bo.isNullOrNil(paramString)) {
      if (this.fyM.containsKey(paramString))
      {
        bool = true;
        if (Looper.myLooper() == Looper.getMainLooper()) {
          break label107;
        }
        al.d(new e.6(this, paramString, paramArrayOfObject));
      }
    }
    for (;;)
    {
      ab.i("MicroMsg.OnlineVideoService", "cancelDownloadTaskInMainThread mediaId : " + paramString + " remove : " + bool);
      AppMethodBeat.o(50573);
      return bool;
      f.afO().sJ(paramString);
      bool = false;
      break;
      label107:
      com.tencent.mm.i.h localh = (com.tencent.mm.i.h)this.fyM.remove(paramString);
      com.tencent.mm.i.d locald;
      int i;
      if (localh != null)
      {
        locald = new com.tencent.mm.i.d();
        f.afP();
        i = a.b(localh.field_mediaId, locald);
        if (i == 0) {
          a(paramArrayOfObject, locald, localh, false);
        }
      }
      for (;;)
      {
        this.fyL.remove(paramString);
        break;
        ab.w("MicroMsg.OnlineVideoService", "stop video stream download error. ret %d, mediaId %s", new Object[] { Integer.valueOf(i), localh.field_mediaId });
        continue;
        localh = (com.tencent.mm.i.h)this.fzq.remove(paramString);
        locald = (com.tencent.mm.i.d)this.fzr.remove(paramString);
        if ((localh != null) && (locald != null)) {
          a(paramArrayOfObject, locald, localh, true);
        }
      }
      bool = false;
    }
  }
  
  public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(50575);
    if ((com.tencent.mm.i.h)this.fyM.get(paramString) == null)
    {
      ab.i("MicroMsg.OnlineVideoService", "this media[%s] don't download now.", new Object[] { paramString });
      AppMethodBeat.o(50575);
      return false;
    }
    f.afP();
    boolean bool = a.isVideoDataAvailable(paramString, paramInt1, paramInt2);
    ab.i("MicroMsg.OnlineVideoService", "is video[%s] data[%d, %d] available[%b]", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
    AppMethodBeat.o(50575);
    return bool;
  }
  
  public final boolean j(final String paramString, final Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(50574);
    boolean bool1 = false;
    boolean bool2 = false;
    if (!bo.isNullOrNil(paramString)) {
      if (!this.fyM.containsKey(paramString)) {
        break label90;
      }
    }
    for (bool1 = true;; bool1 = bool2)
    {
      com.tencent.mm.kernel.g.RO().ac(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(50564);
          com.tencent.mm.i.h localh = (com.tencent.mm.i.h)e.this.fyM.remove(paramString);
          com.tencent.mm.i.d locald;
          int i;
          if (localh != null)
          {
            locald = new com.tencent.mm.i.d();
            f.afP();
            i = a.b(localh.field_mediaId, locald);
            if (i == 0) {
              e.a(paramArrayOfObject, locald, localh, false);
            }
          }
          for (;;)
          {
            e.this.fyL.remove(paramString);
            AppMethodBeat.o(50564);
            return;
            ab.w("MicroMsg.OnlineVideoService", "stop video stream download error. ret %d, mediaId %s", new Object[] { Integer.valueOf(i), localh.field_mediaId });
            continue;
            localh = (com.tencent.mm.i.h)e.this.fzq.remove(paramString);
            locald = (com.tencent.mm.i.d)e.this.fzr.remove(paramString);
            if ((localh != null) && (locald != null)) {
              e.a(paramArrayOfObject, locald, localh, true);
            }
          }
        }
      });
      ab.i("MicroMsg.OnlineVideoService", "cancelDownloadTask mediaId : " + paramString + " remove : " + bool1);
      AppMethodBeat.o(50574);
      return bool1;
      label90:
      f.afO().sJ(paramString);
    }
  }
  
  public final void l(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(50578);
    ab.i("MicroMsg.OnlineVideoService", "onMoovReady mediaId[%s]", new Object[] { paramString });
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(50578);
      return;
    }
    com.tencent.mm.kernel.g.RO().ac(new e.8(this, paramString, paramInt1, paramInt2));
    AppMethodBeat.o(50578);
  }
  
  public final void m(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(50579);
    ab.i("MicroMsg.OnlineVideoService", "onDataAvailable. offset %d, length %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(50579);
      return;
    }
    com.tencent.mm.kernel.g.RO().ac(new e.9(this, paramString, paramInt1, paramInt2));
    AppMethodBeat.o(50579);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(50570);
    if (paramm.getType() != 379)
    {
      AppMethodBeat.o(50570);
      return;
    }
    ab.i("MicroMsg.OnlineVideoService", "it get cdn dns success[%d, %d], try to start.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (com.tencent.mm.kernel.g.RJ().QU()) {
      com.tencent.mm.kernel.g.RO().ac(new e.1(this));
    }
    AppMethodBeat.o(50570);
  }
  
  public final void release()
  {
    AppMethodBeat.i(50569);
    com.tencent.mm.kernel.g.Rc().b(379, this);
    AppMethodBeat.o(50569);
  }
  
  public final void s(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(50580);
    ab.i("MicroMsg.OnlineVideoService", "onDownloadToEnd. offset %d, length %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(50580);
      return;
    }
    com.tencent.mm.kernel.g.RO().ac(new e.10(this, paramString, paramInt1, paramInt2));
    AppMethodBeat.o(50580);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.al.e
 * JD-Core Version:    0.7.0.1
 */