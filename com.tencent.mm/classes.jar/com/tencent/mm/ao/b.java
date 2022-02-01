package com.tencent.mm.ao;

import android.os.Looper;
import com.tencent.e.i;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.Config;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.ks;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.g.b;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

public final class b
  implements com.tencent.mm.al.g, com.tencent.mm.i.b, com.tencent.mm.i.b.a, n.b
{
  private int haE;
  ap haF;
  com.tencent.mm.sdk.b.c<ks> haG;
  com.tencent.mm.network.n haH;
  Queue<String> haI;
  public Map<String, com.tencent.mm.i.g> haJ;
  public Map<String, com.tencent.mm.i.g> haK;
  public Map<String, Integer> haL;
  private String haM;
  private long haN;
  public HashSet<String> haO;
  
  public b()
  {
    AppMethodBeat.i(150406);
    this.haE = -1;
    this.haF = new b.1(this, Looper.getMainLooper());
    this.haG = new b.2(this);
    this.haH = new b.3(this);
    this.haI = new LinkedList();
    this.haJ = new HashMap();
    this.haK = new ConcurrentHashMap();
    this.haL = new HashMap();
    this.haM = "";
    this.haN = 0L;
    this.haO = new HashSet();
    com.tencent.mm.kernel.g.afA().a(this.haH);
    if (com.tencent.mm.kernel.g.afz().aeI()) {
      com.tencent.mm.kernel.g.afB().afk().a(this);
    }
    com.tencent.mm.kernel.g.aeS().a(379, this);
    com.tencent.mm.sdk.b.a.ESL.c(this.haG);
    ad.i("MicroMsg.CdnTransportService", "summersafecdn CdnTransportService init[%s] stack[%s]", new Object[] { Integer.valueOf(hashCode()), bt.eGN() });
    AppMethodBeat.o(150406);
  }
  
  public static boolean nL(int paramInt)
  {
    AppMethodBeat.i(150405);
    com.tencent.mm.kernel.g.afz();
    if (com.tencent.mm.kernel.a.aeH())
    {
      int i = bt.a((Integer)com.tencent.mm.kernel.g.afB().afk().get(144385, null), 0);
      ad.d("MicroMsg.CdnTransportService", "summersafecdn cdntra cdnBitSet:%d grayScaleFlag:%d res:%d Test.forceCDNTrans:%b", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(i & paramInt), Boolean.valueOf(com.tencent.mm.platformtools.ab.hVw) });
      if (com.tencent.mm.platformtools.ab.hVw)
      {
        AppMethodBeat.o(150405);
        return true;
      }
      if ((i & paramInt) > 0)
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
  
  public final int a(final String paramString, final com.tencent.mm.i.c paramc, final d paramd)
  {
    AppMethodBeat.i(150414);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.CdnTransportService", "cdn callback mediaid is null");
      AppMethodBeat.o(150414);
      return -1;
    }
    if ((paramc == null) && (paramd == null))
    {
      ad.e("MicroMsg.CdnTransportService", "cdn callback info all null");
      AppMethodBeat.o(150414);
      return -2;
    }
    if (paramc != null) {
      ad.d("MicroMsg.CdnTransportService", "CDN progress. total:%d, cur:%d, canshow:%b", new Object[] { Long.valueOf(paramc.field_toltalLength), Long.valueOf(paramc.field_finishedLength), Boolean.valueOf(paramc.field_mtlnotify) });
    }
    this.haN = bt.eGO();
    this.haM = paramString;
    com.tencent.e.h.Iye.f(new Runnable()
    {
      public final void run()
      {
        int i = 0;
        AppMethodBeat.i(150400);
        Object localObject = (com.tencent.mm.i.g)b.this.haK.get(paramString);
        if (localObject == null)
        {
          ad.d("MicroMsg.CdnTransportService", " task in jni get info failed mediaid[%s] hash[%s]", new Object[] { paramString, Integer.valueOf(b.this.hashCode()) });
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(594L, 7L, 1L, true);
          AppMethodBeat.o(150400);
          return;
        }
        if (paramc != null)
        {
          paramc.mediaId = paramString;
          ad.i("MicroMsg.CdnTransportService", "MTL: total:%d, cur:%d, mtl:%b", new Object[] { Long.valueOf(paramc.field_toltalLength), Long.valueOf(paramc.field_finishedLength), Boolean.valueOf(paramc.field_mtlnotify) });
        }
        if (paramd != null) {
          paramd.mediaId = paramString;
        }
        if (((com.tencent.mm.i.g)localObject).fnH != null)
        {
          long l = bt.eGO();
          if ((paramd == null) && (paramc != null) && (!paramc.field_mtlnotify) && (ay.getNetWorkType(aj.getContext()) == -1))
          {
            AppMethodBeat.o(150400);
            return;
          }
          ((com.tencent.mm.i.g)localObject).field_lastProgressCallbackTime = l;
          ((com.tencent.mm.i.g)localObject).fnH.a(paramString, 0, paramc, paramd, ((com.tencent.mm.i.g)localObject).field_onlycheckexist);
        }
        if ((localObject instanceof com.tencent.mm.i.f)) {}
        for (localObject = (com.tencent.mm.i.f)localObject;; localObject = null)
        {
          com.tencent.mm.i.c localc = paramc;
          if ((localc != null) && (localc.field_finishedLength != localc.field_toltalLength)) {}
          for (;;)
          {
            if ((i != 0) && ((localObject == null) || (((com.tencent.mm.i.f)localObject).UE()))) {
              b.this.haL.remove(paramString);
            }
            if (paramd != null)
            {
              if ((localObject == null) || (((com.tencent.mm.i.f)localObject).UE())) {
                b.this.haK.remove(paramString);
              }
              if (paramd.field_retCode == -5103011)
              {
                ad.i("MicroMsg.CdnTransportService", "summersafecdn ERR_VALIDATE_AUTHKEY");
                com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(546L, 4L, 1L, true);
                f.awM().keep_OnRequestDoGetCdnDnsInfo(999);
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
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(150403);
    if (!com.tencent.mm.kernel.g.afz().aeI())
    {
      AppMethodBeat.o(150403);
      return;
    }
    int i = bt.i(paramObject, 0);
    ad.d("MicroMsg.CdnTransportService", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    if ((paramn != com.tencent.mm.kernel.g.afB().afk()) || (i <= 0))
    {
      ad.e("MicroMsg.CdnTransportService", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramn });
      AppMethodBeat.o(150403);
      return;
    }
    if (i != 144385)
    {
      AppMethodBeat.o(150403);
      return;
    }
    f.awI().nN(10);
    AppMethodBeat.o(150403);
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    AppMethodBeat.i(150415);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.CdnTransportService", "cdn callback getauthbuf mediaid is null");
      AppMethodBeat.o(150415);
      return;
    }
    com.tencent.mm.i.g localg = (com.tencent.mm.i.g)this.haK.get(paramString);
    if (localg == null)
    {
      ad.e("MicroMsg.CdnTransportService", " getauthbuf task in jni get info failed mediaid:%s", new Object[] { paramString });
      AppMethodBeat.o(150415);
      return;
    }
    if (localg.fnH != null)
    {
      localg.fnH.a(paramString, paramByteArrayOutputStream);
      AppMethodBeat.o(150415);
      return;
    }
    ad.e("MicroMsg.CdnTransportService", "getCdnAuthInfo fail, null taskcallback.");
    AppMethodBeat.o(150415);
  }
  
  public final void awG()
  {
    AppMethodBeat.i(150413);
    com.tencent.mm.kernel.g.afz();
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
    if (com.tencent.mm.kernel.a.aeH())
    {
      localConfig = new CdnLogic.Config();
      str1 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getValue("EnableCDNUploadImg");
      str2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getValue("EnableCDNVerifyConnect");
      str3 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getValue("EnableCDNVideoRedirectOC");
      str4 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getValue("EnableStreamUploadVideo");
      str5 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getValue("C2COverloadDelaySeconds");
      str6 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getValue("SNSOverloadDelaySeconds");
      str7 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getValue("EnableSnsStreamDownload");
      str8 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getValue("EnableSnsImageDownload");
      str9 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getValue("ApprovedVideoPrivateProtocolHosts");
    }
    for (;;)
    {
      try
      {
        if (!bt.isNullOrNil(str1)) {
          localConfig.UseStreamCDN = Integer.valueOf(str1).intValue();
        }
        if (!bt.isNullOrNil(str2)) {
          localConfig.EnableCDNVerifyConnect = Integer.valueOf(str2).intValue();
        }
        if (!bt.isNullOrNil(str3)) {
          localConfig.EnableCDNVideoRedirectOC = Integer.valueOf(str3).intValue();
        }
        if (!bt.isNullOrNil(str4)) {
          localConfig.EnableStreamUploadVideo = Integer.valueOf(str4).intValue();
        }
        if (!bt.isNullOrNil(str5)) {
          localConfig.C2COverloadDelaySeconds = Integer.valueOf(str5).intValue();
        }
        if (!bt.isNullOrNil(str6)) {
          localConfig.SNSOverloadDelaySeconds = Integer.valueOf(str6).intValue();
        }
        if (!bt.isNullOrNil(str7)) {
          localConfig.EnableSnsStreamDownload = Integer.valueOf(str7).intValue();
        }
        if (!bt.isNullOrNil(str8)) {
          localConfig.EnableSnsImageDownload = Integer.valueOf(str8).intValue();
        }
        if (!bt.isNullOrNil(str9)) {
          localConfig.ApprovedVideoHosts = str9;
        }
        f.awL();
        if (!nL(256)) {
          continue;
        }
        i = 1;
        localConfig.EnableSafeCDN = i;
        localConfig.EnableC2CVideoQUIC = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.psS, 0);
        localConfig.EnableUserVideoQUIC = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.psT, 0);
        localConfig.EnableBandVideoQUIC = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.psU, 0);
        localConfig.EnableStatusVideoQUIC = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.psV, 0);
        localConfig.EnableSnsVideoRedirect = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.psW, 0);
        ad.i("MicroMsg.CdnTransportService", "[quic.config] c2c %d user %d band %d status %d", new Object[] { Integer.valueOf(localConfig.EnableC2CVideoQUIC), Integer.valueOf(localConfig.EnableUserVideoQUIC), Integer.valueOf(localConfig.EnableBandVideoQUIC), Integer.valueOf(localConfig.EnableStatusVideoQUIC) });
        if (localConfig.UseStreamCDN != 0)
        {
          str1 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getValue("ProgJPEGUploadSizeLimitWifi");
          str2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getValue("ProgJPEGUploadSizeLimit3G");
          str3 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getValue("ProgJPEGDownloadSizeLimit");
          str4 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getValue("ProgJPEGOnlyRecvPTL");
          str5 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getValue("EnableJPEGDyncmicETL");
          if (!bt.isNullOrNil(str1)) {
            localConfig.WifiEtl = Integer.valueOf(str1).intValue();
          }
          if (!bt.isNullOrNil(str2)) {
            localConfig.MobileEtl = Integer.valueOf(str2).intValue();
          }
          if (!bt.isNullOrNil(str3)) {
            localConfig.Ptl = Integer.valueOf(str3).intValue();
          }
          if (!bt.isNullOrNil(str4))
          {
            if (Integer.valueOf(str4).intValue() == 0) {
              continue;
            }
            bool = true;
            localConfig.onlyrecvPtl = bool;
          }
          if (!bt.isNullOrNil(str5)) {
            localConfig.UseDynamicETL = Integer.valueOf(str5).intValue();
          }
        }
        if (this.haE != -1)
        {
          ad.w("MicroMsg.CdnTransportService", "cmd set snsimage flag: %d", new Object[] { Integer.valueOf(this.haE) });
          localConfig.EnableSnsImageDownload = this.haE;
        }
        ad.i("MicroMsg.CdnTransportService", "summersafecdn streamcdn config[SVR]:%s", new Object[] { localConfig });
        CdnLogic.setConfig(localConfig);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        int i;
        boolean bool;
        ad.e("MicroMsg.CdnTransportService", localNumberFormatException.toString());
        continue;
      }
      if (com.tencent.mm.platformtools.ab.hVV)
      {
        ad.w("MicroMsg.CdnTransportService", "use cdn debug configure.");
        localConfig.UseStreamCDN = 1;
        localConfig.EnableSnsVideoRedirect = com.tencent.mm.platformtools.ab.hWb;
        ad.i("MicroMsg.CdnTransportService", "streamcdn config[DEBUG]:%s", new Object[] { localConfig });
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
      ad.e("MicroMsg.CdnTransportService", "addRecvTask task info is null");
      AppMethodBeat.o(150407);
      return false;
    }
    if (bt.isNullOrNil(paramg.field_mediaId))
    {
      ad.e("MicroMsg.CdnTransportService", "addRecvTask mediaId is null");
      AppMethodBeat.o(150407);
      return false;
    }
    if (paramg.field_fileId == null) {
      paramg.field_fileId = "";
    }
    if (paramg.field_aesKey == null) {
      paramg.field_aesKey = "";
    }
    paramg.dDS = false;
    com.tencent.e.h.Iye.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150396);
        if (paramInt != -1) {
          b.this.haL.put(paramg.field_mediaId, Integer.valueOf(paramInt));
        }
        ad.i("MicroMsg.CdnTransportService", "CdnTransportService cdn thread run %s", new Object[] { paramg.field_mediaId });
        b.this.haI.add(paramg.field_mediaId);
        b.this.haJ.put(paramg.field_mediaId, paramg);
        b.this.eo(false);
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
  
  public final int c(final String paramString, final d paramd)
  {
    AppMethodBeat.i(203567);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(203567);
      return 0;
    }
    com.tencent.e.h.Iye.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150402);
        com.tencent.mm.i.g localg = (com.tencent.mm.i.g)b.this.haK.get(paramString);
        if (localg == null)
        {
          ad.d("MicroMsg.CdnTransportService", " task in jni get info failed mediaid:%s", new Object[] { paramString });
          AppMethodBeat.o(150402);
          return;
        }
        if (localg.fnY != null) {
          localg.fnY.a(paramString, paramd);
        }
        AppMethodBeat.o(150402);
      }
    }, "MicroMsg.CdnTransportService");
    AppMethodBeat.o(203567);
    return 0;
  }
  
  public final boolean d(com.tencent.mm.i.g paramg)
  {
    AppMethodBeat.i(150408);
    boolean bool = b(paramg, -1);
    AppMethodBeat.o(150408);
    return bool;
  }
  
  public final boolean e(final com.tencent.mm.i.g paramg)
  {
    AppMethodBeat.i(150409);
    if (paramg == null)
    {
      ad.e("MicroMsg.CdnTransportService", "summersafecdn addSendTask task info is null");
      AppMethodBeat.o(150409);
      return false;
    }
    if (bt.isNullOrNil(paramg.field_mediaId))
    {
      ad.e("MicroMsg.CdnTransportService", "summersafecdn addSendTask mediaId is null");
      AppMethodBeat.o(150409);
      return false;
    }
    if (paramg.field_fileId == null) {
      paramg.field_fileId = "";
    }
    if (paramg.field_aesKey == null) {
      paramg.field_aesKey = "";
    }
    paramg.dDS = true;
    com.tencent.e.h.Iye.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150398);
        b.this.haI.add(paramg.field_mediaId);
        b.this.haJ.put(paramg.field_mediaId, paramg);
        b.this.eo(false);
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
  
  public final void eo(boolean paramBoolean)
  {
    AppMethodBeat.i(150412);
    if ((!paramBoolean) && (f.awM().awF()))
    {
      com.tencent.mm.kernel.g.afz();
      if (com.tencent.mm.kernel.a.aeH())
      {
        ad.w("MicroMsg.CdnTransportService", "summersafecdn cdntra Not init cdn dnsinfo , will retry after set info");
        f.awI().nN(4);
        AppMethodBeat.o(150412);
        return;
      }
    }
    awG();
    ad.i("MicroMsg.CdnTransportService", "summersafecdn tryStart queue:%d", new Object[] { Integer.valueOf(this.haI.size()) });
    Object localObject1;
    Object localObject3;
    label212:
    int j;
    label222:
    Object localObject2;
    if (!this.haI.isEmpty())
    {
      localObject1 = (String)this.haI.poll();
      localObject3 = (com.tencent.mm.i.g)this.haJ.remove(localObject1);
      if (localObject3 == null)
      {
        ad.e("MicroMsg.CdnTransportService", "summersafecdn task queue is empty , maybe bug here");
        AppMethodBeat.o(150412);
        return;
      }
      ad.i("MicroMsg.CdnTransportService", "summersafecdn id:%s cdnautostart :%s chatroom:%s", new Object[] { ((com.tencent.mm.i.g)localObject3).field_mediaId, Boolean.valueOf(((com.tencent.mm.i.g)localObject3).field_autostart), Integer.valueOf(((com.tencent.mm.i.g)localObject3).field_chattype) });
      ((com.tencent.mm.i.g)localObject3).field_startTime = bt.eGO();
      if (((com.tencent.mm.i.g)localObject3).dDS)
      {
        String str;
        if (((com.tencent.mm.i.g)localObject3).field_fullpath == null)
        {
          i = -1;
          if (((com.tencent.mm.i.g)localObject3).field_thumbpath != null) {
            break label581;
          }
          j = -1;
          ad.i("MicroMsg.CdnTransportService", "summersafecdn tryStart send file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b] largesvideo[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), bt.aGs(((com.tencent.mm.i.g)localObject3).field_svr_signature), bt.aGs(((com.tencent.mm.i.g)localObject3).field_aesKey), Integer.valueOf(((com.tencent.mm.i.g)localObject3).field_fileType), ((com.tencent.mm.i.g)localObject3).field_mediaId, Boolean.valueOf(((com.tencent.mm.i.g)localObject3).field_onlycheckexist), Integer.valueOf(((com.tencent.mm.i.g)localObject3).field_largesvideo) });
          if (((com.tencent.mm.i.g)localObject3).field_fullpath == null) {
            ((com.tencent.mm.i.g)localObject3).field_fullpath = "";
          }
          if (((com.tencent.mm.i.g)localObject3).field_thumbpath == null) {
            ((com.tencent.mm.i.g)localObject3).field_thumbpath = "";
          }
          localObject1 = (com.tencent.mm.i.g)this.haK.put(((com.tencent.mm.i.g)localObject3).field_mediaId, localObject3);
          localObject2 = (com.tencent.mm.i.g)this.haK.get(((com.tencent.mm.i.g)localObject3).field_mediaId);
          if (localObject2 == null) {
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(594L, 5L, 1L, true);
          }
          i = f.awM().b((com.tencent.mm.i.g)localObject3);
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
          ad.i("MicroMsg.CdnTransportService", "summersafecdn startupUploadMedia ok, field_mediaId[%s] ret[%s, %s, %s] hash[%s]", new Object[] { str, Integer.valueOf(i), localObject1, localObject2, Integer.valueOf(hashCode()) });
          if (i == 0) {
            break;
          }
          localObject1 = (com.tencent.mm.i.g)this.haK.remove(((com.tencent.mm.i.g)localObject3).field_mediaId);
          ad.e("MicroMsg.CdnTransportService", "summersafecdn startupUploadMedia error:%d clientid:%s remove[%s]", new Object[] { Integer.valueOf(i), ((com.tencent.mm.i.g)localObject3).field_mediaId, localObject1 });
          if (((com.tencent.mm.i.g)localObject3).fnH == null) {
            break;
          }
          ((com.tencent.mm.i.g)localObject3).fnH.a(((com.tencent.mm.i.g)localObject3).field_mediaId, i, null, null, ((com.tencent.mm.i.g)localObject3).field_onlycheckexist);
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
        i = f.awM().a(((com.tencent.mm.i.g)localObject3).field_mediaId, ((com.tencent.mm.i.g)localObject3).fnK, ((com.tencent.mm.i.g)localObject3).field_fullpath, ((com.tencent.mm.i.g)localObject3).field_fileType, ((com.tencent.mm.i.g)localObject3).field_aesKey, ((com.tencent.mm.i.g)localObject3).field_authKey);
      }
      for (;;)
      {
        label663:
        if (i != 0)
        {
          ad.e("MicroMsg.CdnTransportService", "summersafecdn startupDownloadMedia error:%d clientid:%s", new Object[] { Integer.valueOf(i), ((com.tencent.mm.i.g)localObject3).field_mediaId });
          if (((com.tencent.mm.i.g)localObject3).fnH == null) {
            break;
          }
          ((com.tencent.mm.i.g)localObject3).fnH.a(((com.tencent.mm.i.g)localObject3).field_mediaId, i, null, null, ((com.tencent.mm.i.g)localObject3).field_onlycheckexist);
          break;
          if (((com.tencent.mm.i.g)localObject3).field_fileType == 19) {
            i = f.awM().a(((com.tencent.mm.i.g)localObject3).field_mediaId, ((com.tencent.mm.i.g)localObject3).fnK, ((com.tencent.mm.i.g)localObject3).field_fullpath, ((com.tencent.mm.i.g)localObject3).field_fileType, ((com.tencent.mm.i.g)localObject3).field_aesKey, ((com.tencent.mm.i.g)localObject3).field_authKey);
          } else if ((((com.tencent.mm.i.g)localObject3).field_fileType == com.tencent.mm.i.a.fnj) || (((com.tencent.mm.i.g)localObject3).field_fileType == com.tencent.mm.i.a.fnl)) {
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
    for (int i = f.awM().a(((com.tencent.mm.i.g)localObject3).field_mediaId, ((com.tencent.mm.i.g)localObject3).fnK, ((com.tencent.mm.i.g)localObject3).field_fullpath, ((com.tencent.mm.i.g)localObject3).field_fileType, ((com.tencent.mm.i.g)localObject3).fnL, ((com.tencent.mm.i.g)localObject3).fnM, ((com.tencent.mm.i.g)localObject3).fnN, ((com.tencent.mm.i.g)localObject3).fnO, ((com.tencent.mm.i.g)localObject3).fnV);; i = -1)
    {
      if (((com.tencent.mm.i.g)localObject3).field_fullpath == null) {}
      for (j = -1;; j = ((com.tencent.mm.i.g)localObject3).field_fullpath.length())
      {
        ad.i("MicroMsg.CdnTransportService", "url download tryStart recv file:%d field_mediaId[%s], download_url[%s], filetype:[%d]", new Object[] { Integer.valueOf(j), ((com.tencent.mm.i.g)localObject3).field_mediaId, ((com.tencent.mm.i.g)localObject3).fnK, Integer.valueOf(((com.tencent.mm.i.g)localObject3).field_fileType) });
        break;
      }
      if (((com.tencent.mm.i.g)localObject3).fnQ)
      {
        i = j;
        if (((com.tencent.mm.i.g)localObject3).field_fullpath != null)
        {
          i = j;
          if (!((com.tencent.mm.i.g)localObject3).field_fullpath.isEmpty()) {
            i = f.awM().a(((com.tencent.mm.i.g)localObject3).field_mediaId, ((com.tencent.mm.i.g)localObject3).field_fullpath, ((com.tencent.mm.i.g)localObject3).fnK, ((com.tencent.mm.i.g)localObject3).fnR, ((com.tencent.mm.i.g)localObject3).fnS, ((com.tencent.mm.i.g)localObject3).allow_mobile_net_download, ((com.tencent.mm.i.g)localObject3).fnL, ((com.tencent.mm.i.g)localObject3).fnM, ((com.tencent.mm.i.g)localObject3).is_resume_task, ((com.tencent.mm.i.g)localObject3).fnP, ((com.tencent.mm.i.g)localObject3).fnN);
          }
        }
        if (((com.tencent.mm.i.g)localObject3).field_fullpath == null) {}
        for (j = -1;; j = ((com.tencent.mm.i.g)localObject3).field_fullpath.length())
        {
          ad.i("MicroMsg.CdnTransportService", "game package download tryStart recv file:%d field_mediaId[%s], download_url[%s] https url[%s]", new Object[] { Integer.valueOf(j), ((com.tencent.mm.i.g)localObject3).field_mediaId, ((com.tencent.mm.i.g)localObject3).fnK, ((com.tencent.mm.i.g)localObject3).fnR });
          break;
        }
      }
      if (((com.tencent.mm.i.g)localObject3).fnT)
      {
        if ((localObject3 instanceof com.tencent.mm.i.f))
        {
          localObject1 = (com.tencent.mm.i.f)localObject3;
          i = f.awM().a((com.tencent.mm.i.f)localObject1);
          break label663;
        }
        if (!(localObject3 instanceof com.tencent.mm.i.e)) {
          break label1952;
        }
        localObject1 = (com.tencent.mm.i.e)localObject3;
        i = f.awM().a(((com.tencent.mm.i.e)localObject1).field_mediaId, ((com.tencent.mm.i.e)localObject1).url, ((com.tencent.mm.i.e)localObject1).referer, ((com.tencent.mm.i.e)localObject1).fny, ((com.tencent.mm.i.e)localObject1).fnz, ((com.tencent.mm.i.e)localObject1).fnA, ((com.tencent.mm.i.e)localObject1).fnB, ((com.tencent.mm.i.e)localObject1).fnC, ((com.tencent.mm.i.e)localObject1).isColdSnsData, ((com.tencent.mm.i.e)localObject1).signalQuality, ((com.tencent.mm.i.e)localObject1).snsScene, ((com.tencent.mm.i.e)localObject1).snsCipherKey, ((com.tencent.mm.i.e)localObject1).evH, ((com.tencent.mm.i.e)localObject1).appType, ((com.tencent.mm.i.e)localObject1).fileType);
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
        ad.i("MicroMsg.CdnTransportService", "summersafecdn tryStart recv file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b]", new Object[] { Integer.valueOf(i), Integer.valueOf(k), ((com.tencent.mm.i.g)localObject3).field_svr_signature, ((com.tencent.mm.i.g)localObject3).field_aesKey, Integer.valueOf(((com.tencent.mm.i.g)localObject3).field_fileType), ((com.tencent.mm.i.g)localObject3).field_mediaId, Boolean.valueOf(((com.tencent.mm.i.g)localObject3).field_onlycheckexist) });
        if (((com.tencent.mm.i.g)localObject3).fnW != 2) {
          break label1784;
        }
        if (!(localObject3 instanceof com.tencent.mm.i.h)) {
          break label1952;
        }
        localObject1 = (com.tencent.mm.i.h)localObject3;
        if (!((com.tencent.mm.i.h)localObject1).UH()) {
          break label1405;
        }
        i = f.awM().a((com.tencent.mm.i.g)localObject3, 2);
        break;
        i = ((com.tencent.mm.i.g)localObject3).field_fullpath.length();
        break label1249;
      }
      label1405:
      if (((com.tencent.mm.i.h)localObject1).UF())
      {
        i = f.awM().a(((com.tencent.mm.i.h)localObject1).field_mediaId, ((com.tencent.mm.i.h)localObject1).url, ((com.tencent.mm.i.h)localObject1).referer, ((com.tencent.mm.i.h)localObject1).field_fullpath, ((com.tencent.mm.i.h)localObject1).foc, ((com.tencent.mm.i.h)localObject1).fnz, ((com.tencent.mm.i.h)localObject1).isColdSnsData, ((com.tencent.mm.i.h)localObject1).signalQuality, ((com.tencent.mm.i.h)localObject1).snsScene, ((com.tencent.mm.i.h)localObject1).field_preloadRatio, ((com.tencent.mm.i.h)localObject1).preloadMinSize, ((com.tencent.mm.i.h)localObject1).field_requestVideoFormat, 1, 1);
        break label663;
      }
      if (((com.tencent.mm.i.h)localObject1).UG())
      {
        i = f.awM().a(((com.tencent.mm.i.h)localObject1).field_mediaId, ((com.tencent.mm.i.h)localObject1).url, ((com.tencent.mm.i.h)localObject1).referer, ((com.tencent.mm.i.h)localObject1).field_fullpath, ((com.tencent.mm.i.h)localObject1).foc, ((com.tencent.mm.i.h)localObject1).field_preloadRatio, ((com.tencent.mm.i.h)localObject1).preloadMinSize, ((com.tencent.mm.i.h)localObject1).concurrentCount);
        break label663;
      }
      if (((com.tencent.mm.i.h)localObject1).UJ())
      {
        i = f.awM().a(((com.tencent.mm.i.h)localObject1).field_mediaId, ((com.tencent.mm.i.h)localObject1).url, ((com.tencent.mm.i.h)localObject1).referer, ((com.tencent.mm.i.h)localObject1).field_fullpath, ((com.tencent.mm.i.h)localObject1).foc, ((com.tencent.mm.i.h)localObject1).fnz, ((com.tencent.mm.i.h)localObject1).isColdSnsData, ((com.tencent.mm.i.h)localObject1).signalQuality, ((com.tencent.mm.i.h)localObject1).snsScene, ((com.tencent.mm.i.h)localObject1).field_preloadRatio, ((com.tencent.mm.i.h)localObject1).preloadMinSize, ((com.tencent.mm.i.h)localObject1).field_requestVideoFormat, ((com.tencent.mm.i.h)localObject1).connectionCount);
        break label663;
      }
      if (((com.tencent.mm.i.h)localObject1).ccl())
      {
        i = f.awM().a(((com.tencent.mm.i.h)localObject1).field_mediaId, ((com.tencent.mm.i.h)localObject1).url, ((com.tencent.mm.i.h)localObject1).referer, ((com.tencent.mm.i.h)localObject1).field_fullpath, ((com.tencent.mm.i.h)localObject1).foc, ((com.tencent.mm.i.h)localObject1).field_preloadRatio, ((com.tencent.mm.i.h)localObject1).preloadMinSize, ((com.tencent.mm.i.h)localObject1).concurrentCount);
        break label663;
      }
      i = j;
      if (((com.tencent.mm.i.h)localObject1).UK()) {
        i = f.awM().a(((com.tencent.mm.i.h)localObject1).field_mediaId, ((com.tencent.mm.i.h)localObject1).url, ((com.tencent.mm.i.h)localObject1).referer, ((com.tencent.mm.i.h)localObject1).field_fullpath, ((com.tencent.mm.i.h)localObject1).foc, ((com.tencent.mm.i.h)localObject1).fnz, ((com.tencent.mm.i.h)localObject1).isColdSnsData, ((com.tencent.mm.i.h)localObject1).signalQuality, ((com.tencent.mm.i.h)localObject1).snsScene, ((com.tencent.mm.i.h)localObject1).field_preloadRatio, ((com.tencent.mm.i.h)localObject1).preloadMinSize, ((com.tencent.mm.i.h)localObject1).field_requestVideoFormat, ((com.tencent.mm.i.h)localObject1).connectionCount, ((com.tencent.mm.i.h)localObject1).qpa, ((com.tencent.mm.i.h)localObject1).videoFlag, ((com.tencent.mm.i.h)localObject1).snsCipherKey);
      }
      break label663;
      label1784:
      i = f.awM().c((com.tencent.mm.i.g)localObject3);
      break label663;
      localObject1 = (com.tencent.mm.i.g)this.haK.put(((com.tencent.mm.i.g)localObject3).field_mediaId, localObject3);
      localObject2 = (com.tencent.mm.i.g)this.haK.get(((com.tencent.mm.i.g)localObject3).field_mediaId);
      if (localObject2 == null) {
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(594L, 6L, 1L, true);
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
        ad.i("MicroMsg.CdnTransportService", "summersafecdn startupDownloadMedia ok, field_mediaId[%s] ret[%s, %s, %s] hash[%s]", new Object[] { localObject3, Integer.valueOf(i), localObject1, localObject2, Integer.valueOf(hashCode()) });
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
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150416);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.CdnTransportService", "cdn callback decodePrepareResponse mediaid is null");
      AppMethodBeat.o(150416);
      return null;
    }
    com.tencent.mm.i.g localg = (com.tencent.mm.i.g)this.haK.get(paramString);
    if (localg == null)
    {
      ad.e("MicroMsg.CdnTransportService", " decodePrepareResponse task in jni get info failed mediaid:%s", new Object[] { paramString });
      AppMethodBeat.o(150416);
      return null;
    }
    if (localg.fnH != null)
    {
      paramString = localg.fnH.f(paramString, paramArrayOfByte);
      AppMethodBeat.o(150416);
      return paramString;
    }
    ad.e("MicroMsg.CdnTransportService", "decodePrepareResponse fail, null taskcallback.");
    AppMethodBeat.o(150416);
    return null;
  }
  
  public final boolean h(com.tencent.mm.i.g paramg)
  {
    AppMethodBeat.i(203566);
    if (paramg == null)
    {
      ad.e("MicroMsg.CdnTransportService", "addRecvTask task info is null");
      AppMethodBeat.o(203566);
      return false;
    }
    if (bt.isNullOrNil(paramg.field_mediaId))
    {
      ad.e("MicroMsg.CdnTransportService", "addRecvTask mediaId is null");
      AppMethodBeat.o(203566);
      return false;
    }
    if (paramg.field_fileId == null) {
      paramg.field_fileId = "";
    }
    if (paramg.field_aesKey == null) {
      paramg.field_aesKey = "";
    }
    paramg.dDS = false;
    ad.i("MicroMsg.CdnTransportService", "CdnTransportService cdn thread run %s", new Object[] { paramg.field_mediaId });
    this.haI.add(paramg.field_mediaId);
    this.haJ.put(paramg.field_mediaId, paramg);
    eo(false);
    AppMethodBeat.o(203566);
    return true;
  }
  
  public final void nM(int paramInt)
  {
    this.haE = paramInt;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(150404);
    if (paramn.getType() != 379)
    {
      AppMethodBeat.o(150404);
      return;
    }
    ad.d("MicroMsg.CdnTransportService", "cdntra onSceneEnd it will tryStart sceneType:%d [%d,%d]", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (com.tencent.mm.kernel.g.afz().aeI()) {
      com.tencent.e.h.Iye.f(new b.4(this), "MicroMsg.Cdn.ThreadName");
    }
    AppMethodBeat.o(150404);
  }
  
  public final boolean xK(String paramString)
  {
    AppMethodBeat.i(150410);
    com.tencent.mm.i.g localg = (com.tencent.mm.i.g)this.haK.remove(paramString);
    if (localg != null)
    {
      f.awM();
      a.xC(paramString);
      com.tencent.mm.plugin.report.service.h.vKh.f(10769, new Object[] { Integer.valueOf(c.hbf), Integer.valueOf(localg.field_fileType), Long.valueOf(bt.eGO() - localg.field_startTime) });
    }
    this.haJ.remove(paramString);
    ad.i("MicroMsg.CdnTransportService", "summersafecdn cdntra cancelSendTask mediaid:%s mapremove:%s engine ret:%d", new Object[] { paramString, localg, Integer.valueOf(0) });
    AppMethodBeat.o(150410);
    return true;
  }
  
  public final boolean xL(String paramString)
  {
    AppMethodBeat.i(150411);
    com.tencent.mm.i.g localg = (com.tencent.mm.i.g)this.haK.remove(paramString);
    if (localg != null)
    {
      if ((localg.field_fileType != com.tencent.mm.i.a.fnj) && (localg.field_fileType != com.tencent.mm.i.a.fnl)) {
        break label156;
      }
      f.awM();
      a.xH(paramString);
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.vKh.f(10769, new Object[] { Integer.valueOf(c.hbe), Integer.valueOf(localg.field_fileType), Long.valueOf(bt.eGO() - localg.field_startTime) });
      this.haJ.remove(paramString);
      this.haL.remove(paramString);
      ad.i("MicroMsg.CdnTransportService", "summersafecdn cdntra cancelRecvTask mediaid:%s mapremove:%s engine ret:%d", new Object[] { paramString, localg, Integer.valueOf(0) });
      AppMethodBeat.o(150411);
      return true;
      label156:
      if (localg.fnQ)
      {
        f.awM();
        a.xI(paramString);
      }
      else
      {
        f.awM();
        a.xD(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ao.b
 * JD-Core Version:    0.7.0.1
 */