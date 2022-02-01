package com.tencent.mm.an;

import android.os.Looper;
import com.tencent.e.i;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.Config;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.lb;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.g.b;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

public final class b
  implements com.tencent.mm.ak.g, com.tencent.mm.i.b, com.tencent.mm.i.b.a, n.b
{
  private int hBf;
  ao hBg;
  com.tencent.mm.sdk.b.c<lb> hBh;
  com.tencent.mm.network.n hBi;
  Queue<String> hBj;
  public Map<String, com.tencent.mm.i.g> hBk;
  public Map<String, com.tencent.mm.i.g> hBl;
  public Map<String, Integer> hBm;
  private String hBn;
  private long hBo;
  public HashSet<String> hBp;
  
  public b()
  {
    AppMethodBeat.i(150406);
    this.hBf = -1;
    this.hBg = new b.1(this, Looper.getMainLooper());
    this.hBh = new b.2(this);
    this.hBi = new b.3(this);
    this.hBj = new LinkedList();
    this.hBk = new HashMap();
    this.hBl = new ConcurrentHashMap();
    this.hBm = new HashMap();
    this.hBn = "";
    this.hBo = 0L;
    this.hBp = new HashSet();
    com.tencent.mm.kernel.g.agQ().a(this.hBi);
    if (com.tencent.mm.kernel.g.agP().afY()) {
      com.tencent.mm.kernel.g.agR().agA().a(this);
    }
    com.tencent.mm.kernel.g.agi().a(379, this);
    com.tencent.mm.sdk.b.a.GpY.c(this.hBh);
    ac.i("MicroMsg.CdnTransportService", "summersafecdn CdnTransportService init[%s] stack[%s]", new Object[] { Integer.valueOf(hashCode()), bs.eWi() });
    AppMethodBeat.o(150406);
  }
  
  public static boolean oz(int paramInt)
  {
    AppMethodBeat.i(150405);
    com.tencent.mm.kernel.g.agP();
    if (com.tencent.mm.kernel.a.afX())
    {
      int k = bs.a((Integer)com.tencent.mm.kernel.g.agR().agA().get(144385, null), 0);
      int i = com.tencent.mm.m.g.ZY().getInt("CDNGrayscaleBitMask", 0);
      int j = com.tencent.mm.m.g.ZY().getInt("CDNGrayscaleBitVal", 0);
      k = k & (i ^ 0xFFFFFFFF) | j & i;
      ac.d("MicroMsg.CdnTransportService", "summersafecdn cdntra cdnBitSet:%d grayScaleFlag:%d res:%d Test.forceCDNTrans:%b, CDNGrayscaleBitMask:%d, CDNGrayscaleBitVal:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt), Integer.valueOf(k & paramInt), Boolean.valueOf(ab.ivA), Integer.valueOf(i), Integer.valueOf(j) });
      if (ab.ivA)
      {
        AppMethodBeat.o(150405);
        return true;
      }
      if ((k & paramInt) > 0)
      {
        AppMethodBeat.o(150405);
        return true;
      }
      AppMethodBeat.o(150405);
      return false;
    }
    AppMethodBeat.o(150405);
    return true;
  }
  
  public final boolean BQ(String paramString)
  {
    AppMethodBeat.i(150410);
    com.tencent.mm.i.g localg = (com.tencent.mm.i.g)this.hBl.remove(paramString);
    if (localg != null)
    {
      f.aDE();
      a.BI(paramString);
      com.tencent.mm.plugin.report.service.h.wUl.f(10769, new Object[] { Integer.valueOf(c.hBG), Integer.valueOf(localg.field_fileType), Long.valueOf(bs.eWj() - localg.field_startTime) });
    }
    this.hBk.remove(paramString);
    ac.i("MicroMsg.CdnTransportService", "summersafecdn cdntra cancelSendTask mediaid:%s mapremove:%s engine ret:%d", new Object[] { paramString, localg, Integer.valueOf(0) });
    AppMethodBeat.o(150410);
    return true;
  }
  
  public final boolean BR(String paramString)
  {
    AppMethodBeat.i(150411);
    com.tencent.mm.i.g localg = (com.tencent.mm.i.g)this.hBl.remove(paramString);
    if (localg != null)
    {
      if ((localg.field_fileType != com.tencent.mm.i.a.fqD) && (localg.field_fileType != com.tencent.mm.i.a.fqF)) {
        break label156;
      }
      f.aDE();
      a.BN(paramString);
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.wUl.f(10769, new Object[] { Integer.valueOf(c.hBF), Integer.valueOf(localg.field_fileType), Long.valueOf(bs.eWj() - localg.field_startTime) });
      this.hBk.remove(paramString);
      this.hBm.remove(paramString);
      ac.i("MicroMsg.CdnTransportService", "summersafecdn cdntra cancelRecvTask mediaid:%s mapremove:%s engine ret:%d", new Object[] { paramString, localg, Integer.valueOf(0) });
      AppMethodBeat.o(150411);
      return true;
      label156:
      if (localg.frk)
      {
        f.aDE();
        a.BO(paramString);
      }
      else
      {
        f.aDE();
        a.BJ(paramString);
      }
    }
  }
  
  public final int a(final String paramString, final com.tencent.mm.i.c paramc, final d paramd)
  {
    AppMethodBeat.i(150414);
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.CdnTransportService", "cdn callback mediaid is null");
      AppMethodBeat.o(150414);
      return -1;
    }
    if ((paramc == null) && (paramd == null))
    {
      ac.e("MicroMsg.CdnTransportService", "cdn callback info all null");
      AppMethodBeat.o(150414);
      return -2;
    }
    if (paramc != null) {
      ac.d("MicroMsg.CdnTransportService", "CDN progress. total:%d, cur:%d, canshow:%b", new Object[] { Long.valueOf(paramc.field_toltalLength), Long.valueOf(paramc.field_finishedLength), Boolean.valueOf(paramc.field_mtlnotify) });
    }
    this.hBo = bs.eWj();
    this.hBn = paramString;
    com.tencent.e.h.JZN.f(new Runnable()
    {
      public final void run()
      {
        int i = 0;
        AppMethodBeat.i(150400);
        Object localObject = (com.tencent.mm.i.g)b.this.hBl.get(paramString);
        if (localObject == null)
        {
          ac.d("MicroMsg.CdnTransportService", " task in jni get info failed mediaid[%s] hash[%s]", new Object[] { paramString, Integer.valueOf(b.this.hashCode()) });
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(594L, 7L, 1L, true);
          AppMethodBeat.o(150400);
          return;
        }
        if (paramc != null)
        {
          paramc.mediaId = paramString;
          ac.i("MicroMsg.CdnTransportService", "MTL: total:%d, cur:%d, mtl:%b", new Object[] { Long.valueOf(paramc.field_toltalLength), Long.valueOf(paramc.field_finishedLength), Boolean.valueOf(paramc.field_mtlnotify) });
        }
        if (paramd != null) {
          paramd.mediaId = paramString;
        }
        if (((com.tencent.mm.i.g)localObject).frb != null)
        {
          long l = bs.eWj();
          if ((paramd == null) && (paramc != null) && (!paramc.field_mtlnotify) && (ax.getNetWorkType(ai.getContext()) == -1))
          {
            AppMethodBeat.o(150400);
            return;
          }
          ((com.tencent.mm.i.g)localObject).field_lastProgressCallbackTime = l;
          ((com.tencent.mm.i.g)localObject).frb.a(paramString, 0, paramc, paramd, ((com.tencent.mm.i.g)localObject).field_onlycheckexist);
        }
        if ((localObject instanceof com.tencent.mm.i.f)) {}
        for (localObject = (com.tencent.mm.i.f)localObject;; localObject = null)
        {
          com.tencent.mm.i.c localc = paramc;
          if ((localc != null) && (localc.field_finishedLength != localc.field_toltalLength)) {}
          for (;;)
          {
            if ((i != 0) && ((localObject == null) || (((com.tencent.mm.i.f)localObject).Vz()))) {
              b.this.hBm.remove(paramString);
            }
            if (paramd != null)
            {
              if ((localObject == null) || (((com.tencent.mm.i.f)localObject).Vz())) {
                b.this.hBl.remove(paramString);
              }
              if (paramd.field_retCode == -5103011)
              {
                ac.i("MicroMsg.CdnTransportService", "summersafecdn ERR_VALIDATE_AUTHKEY");
                com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(546L, 4L, 1L, true);
                f.aDE().keep_OnRequestDoGetCdnDnsInfo(999);
              }
            }
            AppMethodBeat.o(150400);
            return;
            i = 1;
          }
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(150401);
        String str = super.toString() + "|callback";
        AppMethodBeat.o(150401);
        return str;
      }
    }, "MicroMsg.CdnTransportService");
    AppMethodBeat.o(150414);
    return 0;
  }
  
  public final int a(final String paramString, final d paramd)
  {
    AppMethodBeat.i(192609);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(192609);
      return 0;
    }
    com.tencent.e.h.JZN.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150402);
        com.tencent.mm.i.g localg = (com.tencent.mm.i.g)b.this.hBl.get(paramString);
        if (localg == null)
        {
          ac.d("MicroMsg.CdnTransportService", " task in jni get info failed mediaid:%s", new Object[] { paramString });
          AppMethodBeat.o(150402);
          return;
        }
        if (localg.frs != null) {
          localg.frs.b(paramString, paramd);
        }
        AppMethodBeat.o(150402);
      }
    }, "MicroMsg.CdnTransportService");
    AppMethodBeat.o(192609);
    return 0;
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(150403);
    if (!com.tencent.mm.kernel.g.agP().afY())
    {
      AppMethodBeat.o(150403);
      return;
    }
    int i = bs.l(paramObject, 0);
    ac.d("MicroMsg.CdnTransportService", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    if ((paramn != com.tencent.mm.kernel.g.agR().agA()) || (i <= 0))
    {
      ac.e("MicroMsg.CdnTransportService", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramn });
      AppMethodBeat.o(150403);
      return;
    }
    if (i != 144385)
    {
      AppMethodBeat.o(150403);
      return;
    }
    f.aDA().oB(10);
    AppMethodBeat.o(150403);
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    AppMethodBeat.i(150415);
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.CdnTransportService", "cdn callback getauthbuf mediaid is null");
      AppMethodBeat.o(150415);
      return;
    }
    com.tencent.mm.i.g localg = (com.tencent.mm.i.g)this.hBl.get(paramString);
    if (localg == null)
    {
      ac.e("MicroMsg.CdnTransportService", " getauthbuf task in jni get info failed mediaid:%s", new Object[] { paramString });
      AppMethodBeat.o(150415);
      return;
    }
    if (localg.frb != null)
    {
      localg.frb.a(paramString, paramByteArrayOutputStream);
      AppMethodBeat.o(150415);
      return;
    }
    ac.e("MicroMsg.CdnTransportService", "getCdnAuthInfo fail, null taskcallback.");
    AppMethodBeat.o(150415);
  }
  
  public final void aDy()
  {
    AppMethodBeat.i(150413);
    com.tencent.mm.kernel.g.agP();
    CdnLogic.Config localConfig;
    String str1;
    String str2;
    String str3;
    String str4;
    String str5;
    String str6;
    String str7;
    String str8;
    String str9;
    if (com.tencent.mm.kernel.a.afX())
    {
      localConfig = new CdnLogic.Config();
      str1 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getValue("EnableCDNUploadImg");
      str2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getValue("EnableCDNVerifyConnect");
      str3 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getValue("EnableCDNVideoRedirectOC");
      str4 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getValue("EnableStreamUploadVideo");
      str5 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getValue("C2COverloadDelaySeconds");
      str6 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getValue("SNSOverloadDelaySeconds");
      str7 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getValue("EnableSnsStreamDownload");
      str8 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getValue("EnableSnsImageDownload");
      str9 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getValue("ApprovedVideoPrivateProtocolHosts");
    }
    for (;;)
    {
      try
      {
        if (!bs.isNullOrNil(str1)) {
          localConfig.UseStreamCDN = Integer.valueOf(str1).intValue();
        }
        if (!bs.isNullOrNil(str2)) {
          localConfig.EnableCDNVerifyConnect = Integer.valueOf(str2).intValue();
        }
        if (!bs.isNullOrNil(str3)) {
          localConfig.EnableCDNVideoRedirectOC = Integer.valueOf(str3).intValue();
        }
        if (!bs.isNullOrNil(str4)) {
          localConfig.EnableStreamUploadVideo = Integer.valueOf(str4).intValue();
        }
        if (!bs.isNullOrNil(str5)) {
          localConfig.C2COverloadDelaySeconds = Integer.valueOf(str5).intValue();
        }
        if (!bs.isNullOrNil(str6)) {
          localConfig.SNSOverloadDelaySeconds = Integer.valueOf(str6).intValue();
        }
        if (!bs.isNullOrNil(str7)) {
          localConfig.EnableSnsStreamDownload = Integer.valueOf(str7).intValue();
        }
        if (!bs.isNullOrNil(str8)) {
          localConfig.EnableSnsImageDownload = Integer.valueOf(str8).intValue();
        }
        if (!bs.isNullOrNil(str9)) {
          localConfig.ApprovedVideoHosts = str9;
        }
        f.aDD();
        if (!oz(256)) {
          continue;
        }
        i = 1;
        localConfig.EnableSafeCDN = i;
        localConfig.SupportQuicVersionMax = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.sKc, 1);
        localConfig.EnableC2CVideoQUIC = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pXd, 0);
        localConfig.EnableUserVideoQUIC = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pXe, 0);
        localConfig.EnableBandVideoQUIC = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pXf, 0);
        localConfig.EnableStatusVideoQUIC = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pXg, 0);
        localConfig.EnableSnsVideoRedirect = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pXh, 0);
        ac.i("MicroMsg.CdnTransportService", "[quic.config] ver %d c2c %d user %d band %d status %d", new Object[] { Integer.valueOf(localConfig.SupportQuicVersionMax), Integer.valueOf(localConfig.EnableC2CVideoQUIC), Integer.valueOf(localConfig.EnableUserVideoQUIC), Integer.valueOf(localConfig.EnableBandVideoQUIC), Integer.valueOf(localConfig.EnableStatusVideoQUIC) });
        if (localConfig.UseStreamCDN != 0)
        {
          str1 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getValue("ProgJPEGUploadSizeLimitWifi");
          str2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getValue("ProgJPEGUploadSizeLimit3G");
          str3 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getValue("ProgJPEGDownloadSizeLimit");
          str4 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getValue("ProgJPEGOnlyRecvPTL");
          str5 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getValue("EnableJPEGDyncmicETL");
          if (!bs.isNullOrNil(str1)) {
            localConfig.WifiEtl = Integer.valueOf(str1).intValue();
          }
          if (!bs.isNullOrNil(str2)) {
            localConfig.MobileEtl = Integer.valueOf(str2).intValue();
          }
          if (!bs.isNullOrNil(str3)) {
            localConfig.Ptl = Integer.valueOf(str3).intValue();
          }
          if (!bs.isNullOrNil(str4))
          {
            if (Integer.valueOf(str4).intValue() == 0) {
              continue;
            }
            bool = true;
            localConfig.onlyrecvPtl = bool;
          }
          if (!bs.isNullOrNil(str5)) {
            localConfig.UseDynamicETL = Integer.valueOf(str5).intValue();
          }
        }
        if (this.hBf != -1)
        {
          ac.w("MicroMsg.CdnTransportService", "cmd set snsimage flag: %d", new Object[] { Integer.valueOf(this.hBf) });
          localConfig.EnableSnsImageDownload = this.hBf;
        }
        ac.i("MicroMsg.CdnTransportService", "summersafecdn streamcdn config[SVR]:%s", new Object[] { localConfig });
        CdnLogic.setConfig(localConfig);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        int i;
        boolean bool;
        ac.e("MicroMsg.CdnTransportService", localNumberFormatException.toString());
        continue;
      }
      if (ab.ivZ)
      {
        ac.w("MicroMsg.CdnTransportService", "use cdn debug configure.");
        localConfig.UseStreamCDN = 1;
        localConfig.EnableSnsVideoRedirect = ab.iwf;
        ac.i("MicroMsg.CdnTransportService", "streamcdn config[DEBUG]:%s", new Object[] { localConfig });
        CdnLogic.setConfig(localConfig);
      }
      AppMethodBeat.o(150413);
      return;
      i = 0;
      continue;
      bool = false;
    }
  }
  
  public final boolean b(final com.tencent.mm.i.g paramg, final int paramInt)
  {
    AppMethodBeat.i(150407);
    if (paramg == null)
    {
      ac.e("MicroMsg.CdnTransportService", "addRecvTask task info is null");
      AppMethodBeat.o(150407);
      return false;
    }
    if (bs.isNullOrNil(paramg.field_mediaId))
    {
      ac.e("MicroMsg.CdnTransportService", "addRecvTask mediaId is null");
      AppMethodBeat.o(150407);
      return false;
    }
    if (paramg.field_fileId == null) {
      paramg.field_fileId = "";
    }
    if (paramg.field_aesKey == null) {
      paramg.field_aesKey = "";
    }
    paramg.dBE = false;
    com.tencent.e.h.JZN.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150396);
        if (paramInt != -1) {
          b.this.hBm.put(paramg.field_mediaId, Integer.valueOf(paramInt));
        }
        ac.i("MicroMsg.CdnTransportService", "CdnTransportService cdn thread run %s", new Object[] { paramg.field_mediaId });
        b.this.hBj.add(paramg.field_mediaId);
        b.this.hBk.put(paramg.field_mediaId, paramg);
        b.this.eJ(false);
        AppMethodBeat.o(150396);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(150397);
        String str = super.toString() + "|addRecvTask";
        AppMethodBeat.o(150397);
        return str;
      }
    }, "MicroMsg.Cdn.ThreadName");
    AppMethodBeat.o(150407);
    return true;
  }
  
  public final boolean d(com.tencent.mm.i.g paramg)
  {
    AppMethodBeat.i(192608);
    if (paramg == null)
    {
      ac.e("MicroMsg.CdnTransportService", "addRecvTask task info is null");
      AppMethodBeat.o(192608);
      return false;
    }
    if (bs.isNullOrNil(paramg.field_mediaId))
    {
      ac.e("MicroMsg.CdnTransportService", "addRecvTask mediaId is null");
      AppMethodBeat.o(192608);
      return false;
    }
    if (paramg.field_fileId == null) {
      paramg.field_fileId = "";
    }
    if (paramg.field_aesKey == null) {
      paramg.field_aesKey = "";
    }
    paramg.dBE = false;
    ac.i("MicroMsg.CdnTransportService", "CdnTransportService cdn thread run %s", new Object[] { paramg.field_mediaId });
    this.hBj.add(paramg.field_mediaId);
    this.hBk.put(paramg.field_mediaId, paramg);
    eJ(false);
    AppMethodBeat.o(192608);
    return true;
  }
  
  public final boolean e(com.tencent.mm.i.g paramg)
  {
    AppMethodBeat.i(150408);
    boolean bool = b(paramg, -1);
    AppMethodBeat.o(150408);
    return bool;
  }
  
  public final void eJ(boolean paramBoolean)
  {
    AppMethodBeat.i(150412);
    if ((!paramBoolean) && (f.aDE().aDx()))
    {
      com.tencent.mm.kernel.g.agP();
      if (com.tencent.mm.kernel.a.afX())
      {
        ac.w("MicroMsg.CdnTransportService", "summersafecdn cdntra Not init cdn dnsinfo , will retry after set info");
        f.aDA().oB(4);
        AppMethodBeat.o(150412);
        return;
      }
    }
    aDy();
    ac.i("MicroMsg.CdnTransportService", "summersafecdn tryStart queue:%d", new Object[] { Integer.valueOf(this.hBj.size()) });
    Object localObject1;
    Object localObject3;
    label212:
    int j;
    label222:
    Object localObject2;
    if (!this.hBj.isEmpty())
    {
      localObject1 = (String)this.hBj.poll();
      localObject3 = (com.tencent.mm.i.g)this.hBk.remove(localObject1);
      if (localObject3 == null)
      {
        ac.e("MicroMsg.CdnTransportService", "summersafecdn task queue is empty , maybe bug here");
        AppMethodBeat.o(150412);
        return;
      }
      ac.i("MicroMsg.CdnTransportService", "summersafecdn id:%s cdnautostart :%s chatroom:%s", new Object[] { ((com.tencent.mm.i.g)localObject3).field_mediaId, Boolean.valueOf(((com.tencent.mm.i.g)localObject3).field_autostart), Integer.valueOf(((com.tencent.mm.i.g)localObject3).field_chattype) });
      ((com.tencent.mm.i.g)localObject3).field_startTime = bs.eWj();
      if (((com.tencent.mm.i.g)localObject3).dBE)
      {
        String str;
        if (((com.tencent.mm.i.g)localObject3).field_fullpath == null)
        {
          i = -1;
          if (((com.tencent.mm.i.g)localObject3).field_thumbpath != null) {
            break label581;
          }
          j = -1;
          ac.i("MicroMsg.CdnTransportService", "summersafecdn tryStart send file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b] largesvideo[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), bs.aLJ(((com.tencent.mm.i.g)localObject3).field_svr_signature), bs.aLJ(((com.tencent.mm.i.g)localObject3).field_aesKey), Integer.valueOf(((com.tencent.mm.i.g)localObject3).field_fileType), ((com.tencent.mm.i.g)localObject3).field_mediaId, Boolean.valueOf(((com.tencent.mm.i.g)localObject3).field_onlycheckexist), Integer.valueOf(((com.tencent.mm.i.g)localObject3).field_largesvideo) });
          if (((com.tencent.mm.i.g)localObject3).field_fullpath == null) {
            ((com.tencent.mm.i.g)localObject3).field_fullpath = "";
          }
          if (((com.tencent.mm.i.g)localObject3).field_thumbpath == null) {
            ((com.tencent.mm.i.g)localObject3).field_thumbpath = "";
          }
          localObject1 = (com.tencent.mm.i.g)this.hBl.put(((com.tencent.mm.i.g)localObject3).field_mediaId, localObject3);
          localObject2 = (com.tencent.mm.i.g)this.hBl.get(((com.tencent.mm.i.g)localObject3).field_mediaId);
          if (localObject2 == null) {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(594L, 5L, 1L, true);
          }
          i = f.aDE().b((com.tencent.mm.i.g)localObject3);
          str = ((com.tencent.mm.i.g)localObject3).field_mediaId;
          if (localObject1 != null) {
            break label593;
          }
          localObject1 = null;
          label427:
          if (localObject2 != null) {
            break label603;
          }
        }
        label581:
        label593:
        label603:
        for (localObject2 = null;; localObject2 = ((com.tencent.mm.i.g)localObject2).field_mediaId)
        {
          ac.i("MicroMsg.CdnTransportService", "summersafecdn startupUploadMedia ok, field_mediaId[%s] ret[%s, %s, %s] hash[%s]", new Object[] { str, Integer.valueOf(i), localObject1, localObject2, Integer.valueOf(hashCode()) });
          if (i == 0) {
            break;
          }
          localObject1 = (com.tencent.mm.i.g)this.hBl.remove(((com.tencent.mm.i.g)localObject3).field_mediaId);
          ac.e("MicroMsg.CdnTransportService", "summersafecdn startupUploadMedia error:%d clientid:%s remove[%s]", new Object[] { Integer.valueOf(i), ((com.tencent.mm.i.g)localObject3).field_mediaId, localObject1 });
          if (((com.tencent.mm.i.g)localObject3).frb == null) {
            break;
          }
          ((com.tencent.mm.i.g)localObject3).frb.a(((com.tencent.mm.i.g)localObject3).field_mediaId, i, null, null, ((com.tencent.mm.i.g)localObject3).field_onlycheckexist);
          break;
          i = ((com.tencent.mm.i.g)localObject3).field_fullpath.length();
          break label212;
          j = ((com.tencent.mm.i.g)localObject3).field_thumbpath.length();
          break label222;
          localObject1 = ((com.tencent.mm.i.g)localObject1).field_mediaId;
          break label427;
        }
      }
      j = -1;
      if (((com.tencent.mm.i.g)localObject3).field_fileType == 40001) {
        i = f.aDE().a(((com.tencent.mm.i.g)localObject3).field_mediaId, ((com.tencent.mm.i.g)localObject3).fre, ((com.tencent.mm.i.g)localObject3).field_fullpath, ((com.tencent.mm.i.g)localObject3).field_fileType, ((com.tencent.mm.i.g)localObject3).field_aesKey, ((com.tencent.mm.i.g)localObject3).field_authKey);
      }
      for (;;)
      {
        label663:
        if (i != 0)
        {
          ac.e("MicroMsg.CdnTransportService", "summersafecdn startupDownloadMedia error:%d clientid:%s", new Object[] { Integer.valueOf(i), ((com.tencent.mm.i.g)localObject3).field_mediaId });
          if (((com.tencent.mm.i.g)localObject3).frb == null) {
            break;
          }
          ((com.tencent.mm.i.g)localObject3).frb.a(((com.tencent.mm.i.g)localObject3).field_mediaId, i, null, null, ((com.tencent.mm.i.g)localObject3).field_onlycheckexist);
          break;
          if (((com.tencent.mm.i.g)localObject3).field_fileType == 19) {
            i = f.aDE().a(((com.tencent.mm.i.g)localObject3).field_mediaId, ((com.tencent.mm.i.g)localObject3).fre, ((com.tencent.mm.i.g)localObject3).field_fullpath, ((com.tencent.mm.i.g)localObject3).field_fileType, ((com.tencent.mm.i.g)localObject3).field_aesKey, ((com.tencent.mm.i.g)localObject3).field_authKey);
          } else if ((((com.tencent.mm.i.g)localObject3).field_fileType == com.tencent.mm.i.a.fqD) || (((com.tencent.mm.i.g)localObject3).field_fileType == com.tencent.mm.i.a.fqF)) {
            if ((((com.tencent.mm.i.g)localObject3).field_fullpath == null) || (((com.tencent.mm.i.g)localObject3).field_fullpath.isEmpty())) {
              break label1957;
            }
          }
        }
      }
    }
    label1935:
    label1952:
    label1957:
    for (int i = f.aDE().a(((com.tencent.mm.i.g)localObject3).field_mediaId, ((com.tencent.mm.i.g)localObject3).fre, ((com.tencent.mm.i.g)localObject3).field_fullpath, ((com.tencent.mm.i.g)localObject3).field_fileType, ((com.tencent.mm.i.g)localObject3).frf, ((com.tencent.mm.i.g)localObject3).frg, ((com.tencent.mm.i.g)localObject3).frh, ((com.tencent.mm.i.g)localObject3).fri, ((com.tencent.mm.i.g)localObject3).frp);; i = -1)
    {
      if (((com.tencent.mm.i.g)localObject3).field_fullpath == null) {}
      for (j = -1;; j = ((com.tencent.mm.i.g)localObject3).field_fullpath.length())
      {
        ac.i("MicroMsg.CdnTransportService", "url download tryStart recv file:%d field_mediaId[%s], download_url[%s], filetype:[%d]", new Object[] { Integer.valueOf(j), ((com.tencent.mm.i.g)localObject3).field_mediaId, ((com.tencent.mm.i.g)localObject3).fre, Integer.valueOf(((com.tencent.mm.i.g)localObject3).field_fileType) });
        break;
      }
      if (((com.tencent.mm.i.g)localObject3).frk)
      {
        i = j;
        if (((com.tencent.mm.i.g)localObject3).field_fullpath != null)
        {
          i = j;
          if (!((com.tencent.mm.i.g)localObject3).field_fullpath.isEmpty()) {
            i = f.aDE().a(((com.tencent.mm.i.g)localObject3).field_mediaId, ((com.tencent.mm.i.g)localObject3).field_fullpath, ((com.tencent.mm.i.g)localObject3).fre, ((com.tencent.mm.i.g)localObject3).frl, ((com.tencent.mm.i.g)localObject3).frm, ((com.tencent.mm.i.g)localObject3).allow_mobile_net_download, ((com.tencent.mm.i.g)localObject3).frf, ((com.tencent.mm.i.g)localObject3).frg, ((com.tencent.mm.i.g)localObject3).is_resume_task, ((com.tencent.mm.i.g)localObject3).frj, ((com.tencent.mm.i.g)localObject3).frh);
          }
        }
        if (((com.tencent.mm.i.g)localObject3).field_fullpath == null) {}
        for (j = -1;; j = ((com.tencent.mm.i.g)localObject3).field_fullpath.length())
        {
          ac.i("MicroMsg.CdnTransportService", "game package download tryStart recv file:%d field_mediaId[%s], download_url[%s] https url[%s]", new Object[] { Integer.valueOf(j), ((com.tencent.mm.i.g)localObject3).field_mediaId, ((com.tencent.mm.i.g)localObject3).fre, ((com.tencent.mm.i.g)localObject3).frl });
          break;
        }
      }
      if (((com.tencent.mm.i.g)localObject3).frn)
      {
        if ((localObject3 instanceof com.tencent.mm.i.f))
        {
          localObject1 = (com.tencent.mm.i.f)localObject3;
          i = f.aDE().a((com.tencent.mm.i.f)localObject1);
          break label663;
        }
        if (!(localObject3 instanceof com.tencent.mm.i.e)) {
          break label1952;
        }
        localObject1 = (com.tencent.mm.i.e)localObject3;
        i = f.aDE().a(((com.tencent.mm.i.e)localObject1).field_mediaId, ((com.tencent.mm.i.e)localObject1).url, ((com.tencent.mm.i.e)localObject1).referer, ((com.tencent.mm.i.e)localObject1).fqS, ((com.tencent.mm.i.e)localObject1).fqT, ((com.tencent.mm.i.e)localObject1).fqU, ((com.tencent.mm.i.e)localObject1).fqV, ((com.tencent.mm.i.e)localObject1).fqW, ((com.tencent.mm.i.e)localObject1).isColdSnsData, ((com.tencent.mm.i.e)localObject1).signalQuality, ((com.tencent.mm.i.e)localObject1).snsScene, ((com.tencent.mm.i.e)localObject1).snsCipherKey, ((com.tencent.mm.i.e)localObject1).eyd, ((com.tencent.mm.i.e)localObject1).appType, ((com.tencent.mm.i.e)localObject1).fileType);
        break label663;
      }
      if (((com.tencent.mm.i.g)localObject3).field_fullpath == null)
      {
        i = -1;
        label1249:
        if (((com.tencent.mm.i.g)localObject3).field_thumbpath != null) {
          break label1392;
        }
      }
      label1392:
      for (int k = -1;; k = ((com.tencent.mm.i.g)localObject3).field_thumbpath.length())
      {
        ac.i("MicroMsg.CdnTransportService", "summersafecdn tryStart recv file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b]", new Object[] { Integer.valueOf(i), Integer.valueOf(k), ((com.tencent.mm.i.g)localObject3).field_svr_signature, ((com.tencent.mm.i.g)localObject3).field_aesKey, Integer.valueOf(((com.tencent.mm.i.g)localObject3).field_fileType), ((com.tencent.mm.i.g)localObject3).field_mediaId, Boolean.valueOf(((com.tencent.mm.i.g)localObject3).field_onlycheckexist) });
        if (((com.tencent.mm.i.g)localObject3).frq != 2) {
          break label1784;
        }
        if (!(localObject3 instanceof com.tencent.mm.i.h)) {
          break label1952;
        }
        localObject1 = (com.tencent.mm.i.h)localObject3;
        if (!((com.tencent.mm.i.h)localObject1).VC()) {
          break label1405;
        }
        i = f.aDE().a((com.tencent.mm.i.g)localObject3, 2);
        break;
        i = ((com.tencent.mm.i.g)localObject3).field_fullpath.length();
        break label1249;
      }
      label1405:
      if (((com.tencent.mm.i.h)localObject1).VA())
      {
        i = f.aDE().a(((com.tencent.mm.i.h)localObject1).field_mediaId, ((com.tencent.mm.i.h)localObject1).url, ((com.tencent.mm.i.h)localObject1).referer, ((com.tencent.mm.i.h)localObject1).field_fullpath, ((com.tencent.mm.i.h)localObject1).frw, ((com.tencent.mm.i.h)localObject1).fqT, ((com.tencent.mm.i.h)localObject1).isColdSnsData, ((com.tencent.mm.i.h)localObject1).signalQuality, ((com.tencent.mm.i.h)localObject1).snsScene, ((com.tencent.mm.i.h)localObject1).field_preloadRatio, ((com.tencent.mm.i.h)localObject1).preloadMinSize, ((com.tencent.mm.i.h)localObject1).field_requestVideoFormat, 1, 1);
        break label663;
      }
      if (((com.tencent.mm.i.h)localObject1).VB())
      {
        i = f.aDE().a(((com.tencent.mm.i.h)localObject1).field_mediaId, ((com.tencent.mm.i.h)localObject1).url, ((com.tencent.mm.i.h)localObject1).referer, ((com.tencent.mm.i.h)localObject1).field_fullpath, ((com.tencent.mm.i.h)localObject1).frw, ((com.tencent.mm.i.h)localObject1).field_preloadRatio, ((com.tencent.mm.i.h)localObject1).preloadMinSize, ((com.tencent.mm.i.h)localObject1).concurrentCount);
        break label663;
      }
      if (((com.tencent.mm.i.h)localObject1).VE())
      {
        i = f.aDE().a(((com.tencent.mm.i.h)localObject1).field_mediaId, ((com.tencent.mm.i.h)localObject1).url, ((com.tencent.mm.i.h)localObject1).referer, ((com.tencent.mm.i.h)localObject1).field_fullpath, ((com.tencent.mm.i.h)localObject1).frw, ((com.tencent.mm.i.h)localObject1).fqT, ((com.tencent.mm.i.h)localObject1).isColdSnsData, ((com.tencent.mm.i.h)localObject1).signalQuality, ((com.tencent.mm.i.h)localObject1).snsScene, ((com.tencent.mm.i.h)localObject1).field_preloadRatio, ((com.tencent.mm.i.h)localObject1).preloadMinSize, ((com.tencent.mm.i.h)localObject1).field_requestVideoFormat, ((com.tencent.mm.i.h)localObject1).connectionCount);
        break label663;
      }
      if (((com.tencent.mm.i.h)localObject1).VG())
      {
        i = f.aDE().a(((com.tencent.mm.i.h)localObject1).field_mediaId, ((com.tencent.mm.i.h)localObject1).url, ((com.tencent.mm.i.h)localObject1).referer, ((com.tencent.mm.i.h)localObject1).field_fullpath, ((com.tencent.mm.i.h)localObject1).frw, ((com.tencent.mm.i.h)localObject1).field_preloadRatio, ((com.tencent.mm.i.h)localObject1).preloadMinSize, ((com.tencent.mm.i.h)localObject1).concurrentCount);
        break label663;
      }
      i = j;
      if (((com.tencent.mm.i.h)localObject1).VF()) {
        i = f.aDE().a(((com.tencent.mm.i.h)localObject1).field_mediaId, ((com.tencent.mm.i.h)localObject1).url, ((com.tencent.mm.i.h)localObject1).referer, ((com.tencent.mm.i.h)localObject1).field_fullpath, ((com.tencent.mm.i.h)localObject1).frw, ((com.tencent.mm.i.h)localObject1).fqT, ((com.tencent.mm.i.h)localObject1).isColdSnsData, ((com.tencent.mm.i.h)localObject1).signalQuality, ((com.tencent.mm.i.h)localObject1).snsScene, ((com.tencent.mm.i.h)localObject1).field_preloadRatio, ((com.tencent.mm.i.h)localObject1).preloadMinSize, ((com.tencent.mm.i.h)localObject1).field_requestVideoFormat, ((com.tencent.mm.i.h)localObject1).connectionCount, ((com.tencent.mm.i.h)localObject1).frD, ((com.tencent.mm.i.h)localObject1).videoFlag, ((com.tencent.mm.i.h)localObject1).snsCipherKey);
      }
      break label663;
      label1784:
      i = f.aDE().c((com.tencent.mm.i.g)localObject3);
      break label663;
      localObject1 = (com.tencent.mm.i.g)this.hBl.put(((com.tencent.mm.i.g)localObject3).field_mediaId, localObject3);
      localObject2 = (com.tencent.mm.i.g)this.hBl.get(((com.tencent.mm.i.g)localObject3).field_mediaId);
      if (localObject2 == null) {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(594L, 6L, 1L, true);
      }
      localObject3 = ((com.tencent.mm.i.g)localObject3).field_mediaId;
      if (localObject1 == null)
      {
        localObject1 = null;
        label1870:
        if (localObject2 != null) {
          break label1935;
        }
      }
      for (localObject2 = null;; localObject2 = ((com.tencent.mm.i.g)localObject2).field_mediaId)
      {
        ac.i("MicroMsg.CdnTransportService", "summersafecdn startupDownloadMedia ok, field_mediaId[%s] ret[%s, %s, %s] hash[%s]", new Object[] { localObject3, Integer.valueOf(i), localObject1, localObject2, Integer.valueOf(hashCode()) });
        break;
        localObject1 = ((com.tencent.mm.i.g)localObject1).field_mediaId;
        break label1870;
      }
      AppMethodBeat.o(150412);
      return;
      i = -1;
      break label663;
    }
  }
  
  public final boolean f(final com.tencent.mm.i.g paramg)
  {
    AppMethodBeat.i(150409);
    if (paramg == null)
    {
      ac.e("MicroMsg.CdnTransportService", "summersafecdn addSendTask task info is null");
      AppMethodBeat.o(150409);
      return false;
    }
    if (bs.isNullOrNil(paramg.field_mediaId))
    {
      ac.e("MicroMsg.CdnTransportService", "summersafecdn addSendTask mediaId is null");
      AppMethodBeat.o(150409);
      return false;
    }
    if (paramg.field_fileId == null) {
      paramg.field_fileId = "";
    }
    if (paramg.field_aesKey == null) {
      paramg.field_aesKey = "";
    }
    paramg.dBE = true;
    com.tencent.e.h.JZN.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150398);
        b.this.hBj.add(paramg.field_mediaId);
        b.this.hBk.put(paramg.field_mediaId, paramg);
        b.this.eJ(false);
        AppMethodBeat.o(150398);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(150399);
        String str = super.toString() + "|addSendTask";
        AppMethodBeat.o(150399);
        return str;
      }
    }, "MicroMsg.Cdn.ThreadName");
    AppMethodBeat.o(150409);
    return true;
  }
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150416);
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.CdnTransportService", "cdn callback decodePrepareResponse mediaid is null");
      AppMethodBeat.o(150416);
      return null;
    }
    com.tencent.mm.i.g localg = (com.tencent.mm.i.g)this.hBl.get(paramString);
    if (localg == null)
    {
      ac.e("MicroMsg.CdnTransportService", " decodePrepareResponse task in jni get info failed mediaid:%s", new Object[] { paramString });
      AppMethodBeat.o(150416);
      return null;
    }
    if (localg.frb != null)
    {
      paramString = localg.frb.f(paramString, paramArrayOfByte);
      AppMethodBeat.o(150416);
      return paramString;
    }
    ac.e("MicroMsg.CdnTransportService", "decodePrepareResponse fail, null taskcallback.");
    AppMethodBeat.o(150416);
    return null;
  }
  
  public final void oA(int paramInt)
  {
    this.hBf = paramInt;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(150404);
    if (paramn.getType() != 379)
    {
      AppMethodBeat.o(150404);
      return;
    }
    ac.d("MicroMsg.CdnTransportService", "cdntra onSceneEnd it will tryStart sceneType:%d [%d,%d]", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (com.tencent.mm.kernel.g.agP().afY()) {
      com.tencent.e.h.JZN.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(150394);
          b.this.eJ(true);
          AppMethodBeat.o(150394);
        }
        
        public final String toString()
        {
          AppMethodBeat.i(150395);
          String str = super.toString() + "|onSceneEnd";
          AppMethodBeat.o(150395);
          return str;
        }
      }, "MicroMsg.Cdn.ThreadName");
    }
    AppMethodBeat.o(150404);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.an.b
 * JD-Core Version:    0.7.0.1
 */