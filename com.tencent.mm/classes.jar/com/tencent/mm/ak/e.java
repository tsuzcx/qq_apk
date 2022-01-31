package com.tencent.mm.ak;

import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.jp;
import com.tencent.mm.h.a.lf;
import com.tencent.mm.h.b.a.l;
import com.tencent.mm.h.b.a.w;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.g.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
  implements com.tencent.mm.ah.f, a.a
{
  Queue<String> eiG = new LinkedList();
  Map<String, com.tencent.mm.j.g> eiH = new HashMap();
  Map<String, com.tencent.mm.j.g> eiI = new HashMap();
  Map<String, com.tencent.mm.j.g> ejm = new HashMap();
  Map<String, com.tencent.mm.j.d> ejn = new HashMap();
  
  public e()
  {
    com.tencent.mm.kernel.g.Dk().a(379, this);
  }
  
  public static com.tencent.mm.j.g a(az paramaz, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (paramaz == null)
    {
      y.w("MicroMsg.OnlineVideoService", "check can sns online video, scene is null.");
      return null;
    }
    if (bk.bl(paramString1))
    {
      y.w("MicroMsg.OnlineVideoService", "check can sns online video, url is null.");
      return null;
    }
    Object localObject = u.oe(paramString3);
    if (localObject == null)
    {
      y.w("MicroMsg.OnlineVideoService", "check can sns online video, video info is null. %s", new Object[] { paramString3 });
      return null;
    }
    String str = c.a("snsvideo", paramaz.time, "sns", paramString1);
    if (bk.bl(str))
    {
      y.w("MicroMsg.OnlineVideoService", "check can http online video, can not create media id. url %s ", new Object[] { paramString1 });
      return null;
    }
    com.tencent.mm.j.g localg = new com.tencent.mm.j.g();
    localg.filename = paramString3;
    localg.field_fullpath = paramString2;
    localg.field_mediaId = str;
    localg.dmb = 2;
    localg.dmg = paramInt;
    localg.dmi = ((com.tencent.mm.modelvideo.s)localObject).dmi;
    if (paramaz == null) {
      paramString3 = "";
    }
    for (;;)
    {
      int i = com.tencent.mm.protocal.d.spa;
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DN();
      str = com.tencent.mm.a.o.getString(com.tencent.mm.kernel.a.CK());
      int j = aq.getNetTypeForStat(ae.getContext());
      int k = aq.getStrength(ae.getContext());
      label217:
      long l1;
      if (!bk.bl(paramString3))
      {
        localObject = "&scene=" + paramString3;
        localg.referer = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d%s", new Object[] { Integer.valueOf(i), str, Integer.valueOf(j), Integer.valueOf(k), localObject });
        localg.url = paramString1;
        paramString1 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getValue("SnsSightDomainList");
        long l2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getInt("SnsSightMainStandbyIpSwitchTime", 0);
        y.i("MicroMsg.OnlineVideoService", "hostvalue %s dcipTime %s scene.time[%d]", new Object[] { paramString1, Long.valueOf(l2), Integer.valueOf(paramaz.time) });
        l1 = l2;
        if (l2 <= 0L) {
          l1 = 259200L;
        }
      }
      for (boolean bool = a(paramaz, localg.url, l1, paramString1);; bool = false)
      {
        try
        {
          localg.host = new URL(localg.url).getHost();
          paramString1 = new ArrayList();
          com.tencent.mm.network.b.a(bool, paramString1, localg.host);
          localg.dlK = new String[paramString1.size()];
          paramString1.toArray(localg.dlK);
          if (bk.cn(paramaz.time) <= l1) {
            continue;
          }
          bool = true;
          localg.isColdSnsData = bool;
          localg.signalQuality = aq.getStrength(ae.getContext());
          localg.snsScene = paramString3;
          if (((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.jIf, false)) {
            localg.field_requestVideoFormat = com.tencent.mm.modelcontrol.d.q(paramInt, paramString2);
          }
          return localg;
        }
        catch (Exception paramaz)
        {
          y.printErrStackTrace("MicroMsg.OnlineVideoService", paramaz, "check can sns online video error taskInfo %s", new Object[] { localg });
          return null;
        }
        if (paramaz.equals(az.uBD))
        {
          paramString3 = "album_friend";
          break;
        }
        if (paramaz.equals(az.uBE))
        {
          paramString3 = "album_self";
          break;
        }
        if (paramaz.equals(az.uBF))
        {
          paramString3 = "album_stranger";
          break;
        }
        if (paramaz.equals(az.uBG))
        {
          paramString3 = "profile_friend";
          break;
        }
        if (paramaz.equals(az.uBH))
        {
          paramString3 = "profile_stranger";
          break;
        }
        if (paramaz.equals(az.uBI))
        {
          paramString3 = "comment";
          break;
        }
        if (paramaz.equals(az.uBC))
        {
          paramString3 = "timeline";
          break;
        }
        if (!paramaz.equals(az.uBL)) {
          break label700;
        }
        paramString3 = "snssight";
        break;
        localObject = "";
        break label217;
      }
      label700:
      paramString3 = "";
    }
  }
  
  static void a(com.tencent.mm.modelvideo.s params, int paramInt, String paramString)
  {
    y.i("MicroMsg.OnlineVideoService", "download finish. totalLen %d ", new Object[] { Integer.valueOf(paramInt) });
    if (params != null)
    {
      u.W(params.getFileName(), paramInt);
      params = params.getFileName();
      if (!bk.bl(paramString))
      {
        com.tencent.mm.modelvideo.o.Sr();
        params = t.nS(params);
        if ((!bk.bl(paramString)) && (paramInt > 0) && (!bk.bl(params))) {
          break label99;
        }
        y.w("MicroMsg.OnlineVideoService", "insert media duplication but args is error.[%d, %s, %s]", new Object[] { Integer.valueOf(paramInt), paramString, params });
      }
    }
    return;
    label99:
    ((com.tencent.mm.plugin.r.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.r.a.a.class)).FD().A(paramString, paramInt, params);
  }
  
  public static void a(Object[] paramArrayOfObject, com.tencent.mm.j.d paramd, com.tencent.mm.j.g paramg, boolean paramBoolean)
  {
    if ((paramg == null) || (paramd == null))
    {
      y.w("MicroMsg.OnlineVideoService", "video task info is null or download result is null.");
      break label16;
    }
    label16:
    while ((!paramg.wX()) && (!paramg.wZ())) {
      return;
    }
    String str1 = paramd.field_clientIP;
    int k;
    label47:
    Object localObject1;
    Object localObject2;
    label181:
    label202:
    boolean bool;
    int i9;
    int i8;
    int i5;
    int i4;
    int i3;
    int i2;
    int i1;
    int n;
    int m;
    if (paramd.field_isCrossNet)
    {
      k = 1;
      y.i("MicroMsg.OnlineVideoService", "rpt online video format[%d] clientIp[%s] isCrossNet[%d]", new Object[] { Integer.valueOf(paramd.field_videoFormat), str1, Integer.valueOf(k) });
      if (paramd.field_videoFormat == 2)
      {
        localObject1 = paramg.filename;
        localObject2 = u.oe((String)localObject1);
        if (localObject2 != null)
        {
          ((com.tencent.mm.modelvideo.s)localObject2).videoFormat = 2;
          ((com.tencent.mm.modelvideo.s)localObject2).bcw = 2;
          y.i("MicroMsg.VideoLogic", "set VideoFormat ret[%b] filename[%s] format[%d]", new Object[] { Boolean.valueOf(com.tencent.mm.modelvideo.o.Sr().c((com.tencent.mm.modelvideo.s)localObject2)), localObject1, Integer.valueOf(2) });
        }
      }
      if (!bk.bl(str1)) {
        break label1680;
      }
      h.nFQ.a(354L, 45L, 1L, false);
      if (!paramd.field_isCrossNet) {
        break label1697;
      }
      h.nFQ.a(354L, 47L, 1L, false);
      bool = paramg.wZ();
      localObject1 = new PInt();
      localObject2 = new PInt();
      ((PInt)localObject2).value = 0;
      ((PInt)localObject1).value = 0;
      u.a(paramg.field_fullpath, (PInt)localObject1, (PInt)localObject2);
      i9 = ((PInt)localObject1).value;
      i8 = ((PInt)localObject2).value;
      if (paramArrayOfObject == null) {
        break label2012;
      }
      i5 = ((Integer)paramArrayOfObject[0]).intValue() * 1000;
      i4 = ((Integer)paramArrayOfObject[1]).intValue();
      i3 = ((Integer)paramArrayOfObject[2]).intValue();
      i2 = ((Integer)paramArrayOfObject[3]).intValue();
      i1 = ((Integer)paramArrayOfObject[4]).intValue();
      n = ((Integer)paramArrayOfObject[5]).intValue();
      m = ((Integer)paramArrayOfObject[6]).intValue();
    }
    for (;;)
    {
      int j = paramg.dmi;
      int i = j;
      label374:
      int i10;
      String str2;
      int i11;
      int i6;
      if (j <= 0)
      {
        if (bool) {
          i = 10;
        }
      }
      else
      {
        i10 = aq.fI(ae.getContext());
        str2 = paramd.wW();
        localObject1 = new PInt();
        localObject2 = new PInt();
        paramArrayOfObject = paramg.filename;
        i11 = paramg.dml;
        i6 = 0;
        paramArrayOfObject = u.oe(paramArrayOfObject);
        if (paramArrayOfObject == null) {
          break label2006;
        }
        i6 = paramArrayOfObject.bRT;
      }
      label540:
      label822:
      label836:
      label1222:
      label1351:
      label1876:
      label2006:
      for (int i7 = paramArrayOfObject.ebK;; i7 = 0)
      {
        Object localObject3;
        if (i11 <= 0)
        {
          j = 1;
          ((PInt)localObject1).value = i6;
          ((PInt)localObject2).value = j;
          y.d("MicroMsg.OnlineVideoService", "getPreloadVideoInfo pHadPreloadSize[%d] pHadPreloadCompletion[%d]", new Object[] { Integer.valueOf(((PInt)localObject1).value), Integer.valueOf(((PInt)localObject2).value) });
          localObject3 = new StringBuffer();
          if (!bool) {
            break label1798;
          }
          ((StringBuffer)localObject3).append(paramg.field_fileId).append(",").append(paramg.field_aesKey).append(",");
          ((StringBuffer)localObject3).append(paramd.field_fileLength).append(",").append(i9 * 1000).append(",");
          ((StringBuffer)localObject3).append(paramd.field_recvedBytes).append(",");
          ((StringBuffer)localObject3).append(i5 + ",").append(i4 + ",").append(i3 + ",");
          ((StringBuffer)localObject3).append(i2 + ",").append(i1 + ",");
          ((StringBuffer)localObject3).append(i10).append(",");
          ((StringBuffer)localObject3).append(i).append(",");
          ((StringBuffer)localObject3).append(paramd.field_startTime).append(",");
          ((StringBuffer)localObject3).append(paramd.field_endTime).append(",");
          if (!bool) {
            break label1844;
          }
          if (paramg.dmh == null) {
            break label1830;
          }
          paramArrayOfObject = com.tencent.mm.a.g.o(paramg.dmh.getBytes());
          ((StringBuffer)localObject3).append(paramArrayOfObject).append(",");
          if (!com.tencent.mm.model.s.fn(paramg.dmh)) {
            break label1838;
          }
          i = 1;
          ((StringBuffer)localObject3).append(i).append(",");
          ((StringBuffer)localObject3).append(paramd.field_retCode).append(",");
          ((StringBuffer)localObject3).append(paramd.field_enQueueTime).append(",");
          ((StringBuffer)localObject3).append(paramd.field_firstRequestCost).append(",");
          ((StringBuffer)localObject3).append(paramd.field_firstRequestSize).append(",");
          ((StringBuffer)localObject3).append(paramd.field_firstRequestDownloadSize).append(",");
          if (!paramd.field_firstRequestCompleted) {
            break label1876;
          }
          i = 1;
          ((StringBuffer)localObject3).append(i).append(",");
          ((StringBuffer)localObject3).append(paramd.field_averageSpeed).append(",");
          ((StringBuffer)localObject3).append(paramd.field_averageConnectCost).append(",");
          ((StringBuffer)localObject3).append(paramd.field_firstConnectCost).append(",");
          ((StringBuffer)localObject3).append(paramd.field_netConnectTimes).append(",");
          ((StringBuffer)localObject3).append(paramd.field_moovRequestTimes).append(",");
          ((StringBuffer)localObject3).append(paramd.field_moovCost).append(",");
          ((StringBuffer)localObject3).append(paramd.field_moovSize).append(",");
          if (!paramd.field_moovCompleted) {
            break label1882;
          }
          i = 1;
          ((StringBuffer)localObject3).append(i).append(",");
          ((StringBuffer)localObject3).append(paramd.field_moovFailReason).append(",");
          ((StringBuffer)localObject3).append(n).append(",");
          ((StringBuffer)localObject3).append(m).append(",");
          if (!bool) {
            break label1888;
          }
          ((StringBuffer)localObject3).append(i8).append(",");
          ((StringBuffer)localObject3).append(str2).append(",");
          if (!bool) {
            break label1944;
          }
          ((StringBuffer)localObject3).append(paramg.dmk).append(",");
          ((StringBuffer)localObject3).append(paramg.bXr).append(",");
          ((StringBuffer)localObject3).append(paramg.initialDownloadLength).append(",");
          ((StringBuffer)localObject3).append(paramd.field_videoFormat).append(",");
          ((StringBuffer)localObject3).append(str1).append(",");
          ((StringBuffer)localObject3).append(k).append(",");
          ((StringBuffer)localObject3).append(paramg.dmm).append(",");
          ((StringBuffer)localObject3).append(((PInt)localObject1).value).append(",");
          ((StringBuffer)localObject3).append(((PInt)localObject2).value);
          if (!bool) {
            break label1966;
          }
          i = 13570;
          paramArrayOfObject = ((StringBuffer)localObject3).toString();
          y.i("MicroMsg.OnlineVideoService", "report online video %d:%s", new Object[] { Integer.valueOf(i), paramArrayOfObject });
          if (!bool) {
            break label1974;
          }
          new l(paramArrayOfObject).QX();
          if (paramBoolean)
          {
            paramArrayOfObject = paramg.bRO;
            str1 = paramg.dmh;
            i = paramg.bRQ;
            str2 = paramd.field_fileId;
            long l1 = paramd.field_startTime;
            long l2 = paramd.field_endTime;
            localObject3 = paramg.field_fullpath;
            String[] arrayOfString = paramd.field_usedSvrIps;
            String str3 = paramg.url;
            j = ((PInt)localObject1).value;
            k = ((PInt)localObject2).value;
            localObject1 = paramg.bRV;
            localObject2 = new jp();
            ((jp)localObject2).bRN.bRO = paramArrayOfObject;
            ((jp)localObject2).bRN.bRP = str1;
            ((jp)localObject2).bRN.bRQ = i;
            ((jp)localObject2).bRN.fileId = str2;
            ((jp)localObject2).bRN.netType = i10;
            ((jp)localObject2).bRN.startTime = l1;
            ((jp)localObject2).bRN.endTime = l2;
            ((jp)localObject2).bRN.path = ((String)localObject3);
            ((jp)localObject2).bRN.bRR = arrayOfString;
            ((jp)localObject2).bRN.bRS = str3;
            ((jp)localObject2).bRN.bRT = j;
            ((jp)localObject2).bRN.bRU = k;
            ((jp)localObject2).bRN.bRV = ((String)localObject1);
            com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject2);
          }
          if (!bool) {
            break;
          }
          if (paramd.field_videoFormat != 2) {
            break label1989;
          }
          h.nFQ.a(354L, 132L, 1L, false);
        }
        for (;;)
        {
          paramArrayOfObject = u.oe(paramg.filename);
          if (paramArrayOfObject == null) {
            break;
          }
          paramArrayOfObject = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(paramArrayOfObject.eHI);
          ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().a(new g.c(paramArrayOfObject.field_talker, "update", paramArrayOfObject));
          return;
          k = 0;
          break label47;
          h.nFQ.a(354L, 46L, 1L, false);
          break label181;
          h.nFQ.a(354L, 48L, 1L, false);
          break label202;
          i = 31;
          break label374;
          int i12 = (int)(i11 / 100.0F * i7);
          if (i6 < i12) {}
          for (j = 2;; j = 3)
          {
            y.d("MicroMsg.OnlineVideoService", "getPreloadVideoInfo %d * %d = configSize[%d] preloadSize[%d]", new Object[] { Integer.valueOf(i11), Integer.valueOf(i7), Integer.valueOf(i12), Integer.valueOf(i6) });
            break;
          }
          ((StringBuffer)localObject3).append(paramg.url).append(",").append(paramg.dmj).append(",");
          break label540;
          paramArrayOfObject = Integer.valueOf(0);
          break label796;
          i = 0;
          break label822;
          ((StringBuffer)localObject3).append(0).append(",");
          ((StringBuffer)localObject3).append(paramd.field_httpStatusCode).append(",");
          break label836;
          i = 0;
          break label926;
          label1882:
          i = 0;
          break label1062;
          label1888:
          ((StringBuffer)localObject3).append(i8).append(",");
          if (paramg.dmh != null) {}
          for (paramArrayOfObject = com.tencent.mm.a.g.o(paramg.dmh.getBytes());; paramArrayOfObject = Integer.valueOf(0))
          {
            ((StringBuffer)localObject3).append(paramArrayOfObject).append(",");
            break;
          }
          ((StringBuffer)localObject3).append(com.tencent.mm.plugin.video.c.PU(paramg.bRV)).append(",");
          break label1222;
          i = 13790;
          break label1304;
          new w(paramArrayOfObject).QX();
          break label1351;
          h.nFQ.a(354L, 133L, 1L, false);
        }
      }
      label796:
      label926:
      label1062:
      label1838:
      label1844:
      label1974:
      label1989:
      label2012:
      m = 0;
      label1304:
      label1697:
      label1830:
      label1966:
      n = 0;
      label1680:
      label1944:
      i1 = 0;
      label1798:
      i2 = 0;
      i3 = 0;
      i4 = 0;
      i5 = 0;
    }
  }
  
  private static boolean a(az paramaz, String paramString1, long paramLong, String paramString2)
  {
    if (paramString1 == null) {}
    for (;;)
    {
      return false;
      try
      {
        paramString1 = new URL(paramString1);
        if ((paramaz != null) && (paramString2 != null) && (paramString2.indexOf(paramString1.getHost()) != -1) && (paramaz.time != 0))
        {
          long l = bk.cn(paramaz.time);
          if (l > paramLong) {
            return true;
          }
        }
      }
      catch (Exception paramaz)
      {
        y.e("MicroMsg.OnlineVideoService", "error for check dcip %s", new Object[] { paramaz.getMessage() });
      }
    }
    return false;
  }
  
  public static int h(String paramString, int paramInt1, int paramInt2)
  {
    f.Ne();
    int i = a.h(paramString, paramInt1, paramInt2);
    y.i("MicroMsg.OnlineVideoService", "request video video[%s], offset[%d], length[%d] duration[%d] ret[%d]", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0), Integer.valueOf(i) });
    return i;
  }
  
  public final int a(String paramString, com.tencent.mm.j.c paramc, com.tencent.mm.j.d paramd)
  {
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.OnlineVideoService", "cdn callback mediaid is null.");
      return -1;
    }
    if ((paramc == null) && (paramd == null))
    {
      y.e("MicroMsg.OnlineVideoService", "cdn callback info all null.");
      return -2;
    }
    com.tencent.mm.kernel.g.DS().O(new e.8(this, paramString, paramc, paramd));
    if (this.eiI.get(paramString) != null) {
      return 1;
    }
    return 0;
  }
  
  public final boolean a(final com.tencent.mm.j.g paramg, boolean paramBoolean)
  {
    if (paramg == null)
    {
      y.e("MicroMsg.OnlineVideoService", "add download task, but task is null.");
      return false;
    }
    if (bk.bl(paramg.field_mediaId))
    {
      y.e("MicroMsg.OnlineVideoService", "add download task, but task mediaId is null.");
      return false;
    }
    y.i("MicroMsg.OnlineVideoService", "add download task : " + paramg.field_mediaId + " delay : " + paramBoolean);
    if (paramg.field_fileId == null) {
      paramg.field_fileId = "";
    }
    if (paramg.field_aesKey == null) {
      paramg.field_aesKey = "";
    }
    paramg.ceg = false;
    if ((k(paramg.field_mediaId, null)) || (paramBoolean)) {
      com.tencent.mm.kernel.g.DS().O(new Runnable()
      {
        public final void run()
        {
          e.this.eiG.add(paramg.field_mediaId);
          e.this.eiH.put(paramg.field_mediaId, paramg);
          e.this.bT(false);
        }
      });
    }
    for (;;)
    {
      return true;
      com.tencent.mm.kernel.g.DS().O(new e.3(this, paramg));
    }
  }
  
  public final void bT(boolean paramBoolean)
  {
    if (!com.tencent.mm.kernel.g.DK()) {}
    for (;;)
    {
      return;
      if ((!paramBoolean) && (f.Ne().MX()))
      {
        com.tencent.mm.kernel.g.DN();
        if (com.tencent.mm.kernel.a.Db())
        {
          y.w("MicroMsg.OnlineVideoService", "cdn engine not init cdn dnsinfo , will retry after set info");
          f.Nd().bT(paramBoolean);
          return;
        }
      }
      f.Nd().MY();
      while (!this.eiG.isEmpty())
      {
        Object localObject1 = (String)this.eiG.poll();
        Object localObject2 = (com.tencent.mm.j.g)this.eiH.remove(localObject1);
        if (localObject2 != null)
        {
          ((com.tencent.mm.j.g)localObject2).field_startTime = bk.UY();
          if (!((com.tencent.mm.j.g)localObject2).ceg)
          {
            if (((Integer)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.utw, Integer.valueOf(-1))).intValue() == 2) {
              y.i("MicroMsg.OnlineVideoService", "command set do not check media duplication.");
            }
            label149:
            int j;
            for (int i = 0;; i = 1)
            {
              if (i == 0) {
                break label392;
              }
              localObject2 = new lf();
              ((lf)localObject2).bUh.bNb = 6;
              ((lf)localObject2).bUh.bUi = ((String)localObject1);
              com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject2);
              break;
              if (((com.tencent.mm.j.g)localObject2).xa()) {
                break label149;
              }
              Object localObject3 = ((com.tencent.mm.j.g)localObject2).dme;
              i = ((com.tencent.mm.j.g)localObject2).dmf;
              Object localObject4 = ((com.tencent.mm.plugin.r.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.r.a.a.class)).FD().dx((String)localObject3, i);
              j = i - (int)com.tencent.mm.vfs.e.aeQ((String)localObject4);
              if ((bk.bl((String)localObject4)) || (j < 0) || (j > 16)) {
                break label149;
              }
              y.i("MicroMsg.OnlineVideoService", "it had download this video[%d, %s, %s].", new Object[] { Integer.valueOf(i), localObject3, localObject4 });
              com.tencent.mm.vfs.e.r((String)localObject4, ((com.tencent.mm.j.g)localObject2).field_fullpath);
              localObject4 = u.oe(((com.tencent.mm.j.g)localObject2).filename);
              a((com.tencent.mm.modelvideo.s)localObject4, i, (String)localObject3);
              localObject3 = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(((com.tencent.mm.modelvideo.s)localObject4).eHI);
              ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().a(new g.c(((cs)localObject3).field_talker, "update", (bi)localObject3));
            }
            label392:
            if (((com.tencent.mm.j.g)localObject2).wZ())
            {
              f.Ne();
              i = a.a((com.tencent.mm.j.f)localObject2, ((com.tencent.mm.j.g)localObject2).dmg);
              label415:
              y.i("MicroMsg.OnlineVideoService", "start task %s streaming download. ret %d ", new Object[] { localObject2, Integer.valueOf(i) });
              if (i == 0) {
                break label962;
              }
              y.w("MicroMsg.OnlineVideoService", "start stream video error. ret : " + i + " media id: " + ((com.tencent.mm.j.g)localObject2).field_mediaId);
              paramBoolean = ((com.tencent.mm.j.g)localObject2).wZ();
              j = ((com.tencent.mm.j.g)localObject2).dmg;
              if (!paramBoolean) {
                break label873;
              }
              h.nFQ.a(354L, 3L, 1L, false);
              if (j != 1) {
                break label808;
              }
              if (i != -21006) {
                break label767;
              }
              h.nFQ.a(354L, 100L, 1L, false);
            }
            label808:
            for (;;)
            {
              h.nFQ.f(13836, new Object[] { Integer.valueOf(100), Long.valueOf(bk.UX()), "" });
              break;
              if (((com.tencent.mm.j.g)localObject2).wX())
              {
                f.Ne();
                i = a.a(((com.tencent.mm.j.g)localObject2).field_mediaId, ((com.tencent.mm.j.g)localObject2).url, ((com.tencent.mm.j.g)localObject2).referer, ((com.tencent.mm.j.g)localObject2).field_fullpath, ((com.tencent.mm.j.g)localObject2).dmg, ((com.tencent.mm.j.g)localObject2).dlK, ((com.tencent.mm.j.g)localObject2).initialDownloadOffset, ((com.tencent.mm.j.g)localObject2).initialDownloadLength, ((com.tencent.mm.j.g)localObject2).isColdSnsData, ((com.tencent.mm.j.g)localObject2).signalQuality, ((com.tencent.mm.j.g)localObject2).snsScene, ((com.tencent.mm.j.g)localObject2).field_preloadRatio, ((com.tencent.mm.j.g)localObject2).field_requestVideoFormat);
                break label415;
              }
              if (((com.tencent.mm.j.g)localObject2).wY())
              {
                f.Ne();
                i = a.a(((com.tencent.mm.j.g)localObject2).field_mediaId, ((com.tencent.mm.j.g)localObject2).url, ((com.tencent.mm.j.g)localObject2).referer, ((com.tencent.mm.j.g)localObject2).field_fullpath, ((com.tencent.mm.j.g)localObject2).dmg, ((com.tencent.mm.j.g)localObject2).field_preloadRatio, ((com.tencent.mm.j.g)localObject2).concurrentCount);
                break label415;
              }
              f.Ne();
              i = a.a(((com.tencent.mm.j.g)localObject2).field_mediaId, ((com.tencent.mm.j.g)localObject2).url, ((com.tencent.mm.j.g)localObject2).referer, ((com.tencent.mm.j.g)localObject2).field_fullpath, ((com.tencent.mm.j.g)localObject2).dmg, ((com.tencent.mm.j.g)localObject2).dlK, ((com.tencent.mm.j.g)localObject2).initialDownloadOffset, ((com.tencent.mm.j.g)localObject2).initialDownloadLength, ((com.tencent.mm.j.g)localObject2).field_preloadRatio);
              break label415;
              label767:
              if (i == -20003)
              {
                h.nFQ.a(354L, 101L, 1L, false);
              }
              else
              {
                h.nFQ.a(354L, 102L, 1L, false);
                continue;
                if (i == -21006) {
                  h.nFQ.a(354L, 106L, 1L, false);
                } else if (i == -20003) {
                  h.nFQ.a(354L, 107L, 1L, false);
                } else {
                  h.nFQ.a(354L, 108L, 1L, false);
                }
              }
            }
            label873:
            h.nFQ.a(354L, 210L, 1L, false);
            if (j == 1) {
              h.nFQ.a(354L, 211L, 1L, false);
            }
            for (;;)
            {
              h.nFQ.f(13836, new Object[] { Integer.valueOf(200), Long.valueOf(bk.UX()), "" });
              break;
              h.nFQ.a(354L, 212L, 1L, false);
            }
            label962:
            ((com.tencent.mm.j.g)localObject2).dmd = bk.UY();
            if (((com.tencent.mm.j.g)localObject2).wZ())
            {
              localObject1 = u.oe(((com.tencent.mm.j.g)localObject2).filename);
              if (localObject1 != null)
              {
                i = ((com.tencent.mm.modelvideo.s)localObject1).status;
                if ((i != 120) && (i != 122) && (i != 121))
                {
                  ((com.tencent.mm.modelvideo.s)localObject1).status = 120;
                  ((com.tencent.mm.modelvideo.s)localObject1).bcw = 256;
                  com.tencent.mm.modelvideo.o.Sr().c((com.tencent.mm.modelvideo.s)localObject1);
                }
              }
            }
            this.eiI.put(((com.tencent.mm.j.g)localObject2).field_mediaId, localObject2);
          }
        }
      }
    }
  }
  
  public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
  {
    if ((com.tencent.mm.j.g)this.eiI.get(paramString) == null)
    {
      y.i("MicroMsg.OnlineVideoService", "this media[%s] don't download now.", new Object[] { paramString });
      return false;
    }
    f.Ne();
    boolean bool = a.isVideoDataAvailable(paramString, paramInt1, paramInt2);
    y.i("MicroMsg.OnlineVideoService", "is video[%s] data[%d, %d] available[%b]", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
    return bool;
  }
  
  public final boolean k(String paramString, Object[] paramArrayOfObject)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (!bk.bl(paramString)) {
      if (!this.eiI.containsKey(paramString)) {
        break label78;
      }
    }
    for (bool1 = true;; bool1 = bool2)
    {
      com.tencent.mm.kernel.g.DS().O(new e.4(this, paramString, paramArrayOfObject));
      y.i("MicroMsg.OnlineVideoService", "cancelDownloadTask mediaId : " + paramString + " remove : " + bool1);
      return bool1;
      label78:
      f.Nd().lM(paramString);
    }
  }
  
  public final void onDataAvailable(String paramString, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.OnlineVideoService", "onDataAvailable. offset %d, length %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (bk.bl(paramString)) {
      return;
    }
    com.tencent.mm.kernel.g.DS().O(new e.6(this, paramString, paramInt1, paramInt2));
  }
  
  public final void onDownloadToEnd(String paramString, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.OnlineVideoService", "onDownloadToEnd. offset %d, length %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (bk.bl(paramString)) {
      return;
    }
    com.tencent.mm.kernel.g.DS().O(new e.7(this, paramString, paramInt1, paramInt2));
  }
  
  public final void onMoovReady(String paramString, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.OnlineVideoService", "onMoovReady mediaId[%s]", new Object[] { paramString });
    if (bk.bl(paramString)) {
      return;
    }
    com.tencent.mm.kernel.g.DS().O(new e.5(this, paramString, paramInt1, paramInt2));
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (paramm.getType() != 379) {}
    do
    {
      return;
      y.i("MicroMsg.OnlineVideoService", "it get cdn dns success[%d, %d], try to start.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    } while (!com.tencent.mm.kernel.g.DN().Dc());
    com.tencent.mm.kernel.g.DS().O(new e.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ak.e
 * JD-Core Version:    0.7.0.1
 */