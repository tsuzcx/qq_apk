package com.tencent.mm.an;

import android.os.Looper;
import com.tencent.e.i;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.Config;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.app.o.a;
import com.tencent.mm.g.a.ll;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.g.b;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class b
  implements com.tencent.mm.ak.f, com.tencent.mm.i.b, com.tencent.mm.i.b.a, n.b
{
  private static final long[] hWH = { 0L, 2L, 5L, 7L, 10L, 15L, 20L, 30L, 50L, 70L, 100L, 200L, 400L, 600L, 800L, 1000L, 3000L, 5000L, 10000L, 20000L, 30000L, 40000L, 50000L, 60000L, 120000L };
  private static final int[] hWI = { 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34 };
  private static int hWJ = -1;
  private static long hWK = -1L;
  public o.a appForegroundListener;
  private Queue<String> hWA;
  public Map<String, com.tencent.mm.i.g> hWB;
  public Map<String, com.tencent.mm.i.g> hWC;
  public Map<String, Integer> hWD;
  private String hWE;
  private long hWF;
  public HashSet<String> hWG;
  private int hWs;
  aq hWt;
  com.tencent.mm.sdk.b.c<ll> hWu;
  com.tencent.mm.network.n hWv;
  private ConcurrentHashMap<String, a> hWw;
  final aw hWx;
  ConcurrentHashMap<String, String> hWy;
  private boolean hWz;
  
  public b()
  {
    AppMethodBeat.i(150406);
    this.hWs = -1;
    this.hWt = new b.1(this, Looper.getMainLooper());
    this.hWu = new b.3(this);
    this.hWv = new b.4(this);
    this.hWw = new ConcurrentHashMap();
    this.hWx = new aw(Looper.getMainLooper(), new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(218666);
        ae.i("MicroMsg.CdnTransportService", "cdnCallbackExecuteTimeReport onTimerExpired");
        b.b(b.this);
        AppMethodBeat.o(218666);
        return true;
      }
    }, true);
    this.appForegroundListener = new o.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(218669);
        ae.i("MicroMsg.CdnTransportService", "onAppBackground %s", new Object[] { paramAnonymousString });
        if (!b.aGS())
        {
          AppMethodBeat.o(218669);
          return;
        }
        b.a(b.this, false);
        b.d(b.this).stopTimer();
        com.tencent.e.h.MqF.aO(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(218667);
            ae.i("MicroMsg.CdnTransportService", "appForegroundListener onAppBackground");
            b.b(b.this);
            Iterator localIterator = b.c(b.this).entrySet().iterator();
            if (localIterator.hasNext())
            {
              Object localObject = (Map.Entry)localIterator.next();
              localObject = (b.a)b.c(b.this).remove(((Map.Entry)localObject).getKey());
              if (localObject != null) {}
              for (localObject = ((b.a)localObject).toString();; localObject = "null")
              {
                ae.i("MicroMsg.CdnTransportService", "remove %s", new Object[] { localObject });
                break;
              }
            }
            AppMethodBeat.o(218667);
          }
        });
        AppMethodBeat.o(218669);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(218668);
        ae.i("MicroMsg.CdnTransportService", "onAppForeground %s", new Object[] { paramAnonymousString });
        if (!b.aGS())
        {
          AppMethodBeat.o(218668);
          return;
        }
        b.a(b.this, true);
        b.c(b.this).clear();
        b.d(b.this).ay(60000L, 60000L);
        AppMethodBeat.o(218668);
      }
    };
    this.hWy = new ConcurrentHashMap();
    this.hWz = com.tencent.mm.ap.a.isActive();
    this.hWA = new LinkedList();
    this.hWB = new HashMap();
    this.hWC = new ConcurrentHashMap();
    this.hWD = new HashMap();
    this.hWE = "";
    this.hWF = 0L;
    this.hWG = new HashSet();
    com.tencent.mm.kernel.g.ajQ().a(this.hWv);
    if (com.tencent.mm.kernel.g.ajP().aiZ()) {
      com.tencent.mm.kernel.g.ajR().ajA().a(this);
    }
    com.tencent.mm.kernel.g.ajj().a(379, this);
    com.tencent.mm.sdk.b.a.IvT.c(this.hWu);
    if (aGS())
    {
      this.appForegroundListener.alive();
      this.hWx.ay(60000L, 60000L);
    }
    ae.i("MicroMsg.CdnTransportService", "summersafecdn CdnTransportService init[%s] stack[%s]", new Object[] { Integer.valueOf(hashCode()), bu.fpN() });
    AppMethodBeat.o(150406);
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(218678);
    if (parama == null)
    {
      AppMethodBeat.o(218678);
      return;
    }
    long l = parama.endTime - parama.startTime;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(x(5, l));
    int k = 10;
    int i = hWH.length - 1;
    for (;;)
    {
      int j = k;
      if (i >= 0)
      {
        if (l >= hWH[i]) {
          j = hWI[i];
        }
      }
      else
      {
        localArrayList.add(x(j, 1L));
        localArrayList.add(x(0, 1L));
        com.tencent.mm.plugin.report.e.ywz.b(localArrayList, false);
        ae.i("MicroMsg.CdnTransportService", "reportCDNCallbackTime(%s) taskName:%s cdnCallbackReportId:%s mediaId:%s duration:%s(%s-%s)", new Object[] { Long.valueOf(parama.threadId), parama.fLl, bu.bI(parama.hWR, ""), bu.bI(parama.field_mediaId, ""), Long.valueOf(l), Long.valueOf(parama.startTime), Long.valueOf(parama.endTime) });
        AppMethodBeat.o(218678);
        return;
      }
      i -= 1;
    }
  }
  
  public static boolean aGS()
  {
    AppMethodBeat.i(218680);
    String str = com.tencent.mm.plugin.expt.h.d.ctr().b("clicfg_cdn_callback_consume_time_statistics_switch", "1", false, true);
    ae.d("MicroMsg.CdnTransportService", "canCDNCallbackStatistics() sw:%s", new Object[] { str });
    boolean bool = bu.lX(str, "1");
    AppMethodBeat.o(218680);
    return bool;
  }
  
  private static int aGT()
  {
    AppMethodBeat.i(218681);
    if (hWJ == -1)
    {
      String str = com.tencent.mm.plugin.expt.h.d.ctr().b("clicfg_cdn_callback_tag_max_num", "1", false, true);
      ae.d("MicroMsg.CdnTransportService", "getTagMaxNum() maxNum:%s", new Object[] { str });
      hWJ = bu.getInt(str, 1);
    }
    int i = hWJ;
    AppMethodBeat.o(218681);
    return i;
  }
  
  private String g(com.tencent.mm.i.g paramg)
  {
    AppMethodBeat.i(218677);
    if ((paramg == null) || (bu.isNullOrNil(paramg.fLl)))
    {
      AppMethodBeat.o(218677);
      return "MicroMsg.CdnTransportService";
    }
    if (this.hWy.containsKey(paramg.fLl))
    {
      paramg = (String)this.hWy.get(paramg.fLl);
      AppMethodBeat.o(218677);
      return paramg;
    }
    String str = "MicroMsg.CdnTransportService_" + (this.hWy.size() + 1) % aGT();
    this.hWy.put(paramg.fLl, str);
    ae.i("MicroMsg.CdnTransportService", "taskName:%s tag:%s", new Object[] { bu.bI(paramg.fLl, ""), bu.bI(str, "") });
    AppMethodBeat.o(218677);
    return str;
  }
  
  public static boolean pd(int paramInt)
  {
    AppMethodBeat.i(150405);
    com.tencent.mm.kernel.g.ajP();
    if (com.tencent.mm.kernel.a.aiY())
    {
      int k = bu.a((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(144385, null), 0);
      int i = com.tencent.mm.n.g.acL().getInt("CDNGrayscaleBitMask", 0);
      int j = com.tencent.mm.n.g.acL().getInt("CDNGrayscaleBitVal", 0);
      k = k & (i ^ 0xFFFFFFFF) | j & i;
      ae.d("MicroMsg.CdnTransportService", "summersafecdn cdntra cdnBitSet:%d grayScaleFlag:%d res:%d Test.forceCDNTrans:%b, CDNGrayscaleBitMask:%d, CDNGrayscaleBitVal:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt), Integer.valueOf(k & paramInt), Boolean.valueOf(ac.iRB), Integer.valueOf(i), Integer.valueOf(j) });
      if (ac.iRB)
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
  
  private static IDKey x(int paramInt, long paramLong)
  {
    AppMethodBeat.i(218679);
    IDKey localIDKey = new IDKey();
    localIDKey.SetID(1452);
    localIDKey.SetKey(paramInt);
    localIDKey.SetValue(paramLong);
    AppMethodBeat.o(218679);
    return localIDKey;
  }
  
  public final boolean Fr(String paramString)
  {
    AppMethodBeat.i(150410);
    com.tencent.mm.i.g localg = (com.tencent.mm.i.g)this.hWC.remove(paramString);
    if (localg != null)
    {
      f.aHa();
      a.Fj(paramString);
      com.tencent.mm.plugin.report.service.g.yxI.f(10769, new Object[] { Integer.valueOf(c.hXe), Integer.valueOf(localg.field_fileType), Long.valueOf(bu.fpO() - localg.field_startTime) });
    }
    this.hWB.remove(paramString);
    ae.i("MicroMsg.CdnTransportService", "summersafecdn cdntra cancelSendTask mediaid:%s mapremove:%s engine ret:%d", new Object[] { paramString, localg, Integer.valueOf(0) });
    AppMethodBeat.o(150410);
    return true;
  }
  
  public final boolean Fs(String paramString)
  {
    AppMethodBeat.i(150411);
    com.tencent.mm.i.g localg = (com.tencent.mm.i.g)this.hWC.remove(paramString);
    if (localg != null)
    {
      if ((localg.field_fileType != com.tencent.mm.i.a.fKO) && (localg.field_fileType != com.tencent.mm.i.a.fKQ)) {
        break label157;
      }
      f.aHa();
      a.Fo(paramString);
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(10769, new Object[] { Integer.valueOf(c.hXd), Integer.valueOf(localg.field_fileType), Long.valueOf(bu.fpO() - localg.field_startTime) });
      this.hWB.remove(paramString);
      this.hWD.remove(paramString);
      ae.i("MicroMsg.CdnTransportService", "summersafecdn cdntra cancelRecvTask mediaid:%s mapremove:%s engine ret:%d", new Object[] { paramString, localg, Integer.valueOf(0) });
      AppMethodBeat.o(150411);
      return true;
      label157:
      if (localg.fLv)
      {
        f.aHa();
        a.Fp(paramString);
      }
      else
      {
        f.aHa();
        a.Fk(paramString);
      }
    }
  }
  
  public final int a(final String paramString, final com.tencent.mm.i.c paramc, final com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(150414);
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.CdnTransportService", "cdn callback mediaid is null");
      AppMethodBeat.o(150414);
      return -1;
    }
    if ((paramc == null) && (paramd == null))
    {
      ae.e("MicroMsg.CdnTransportService", "cdn callback info all null");
      AppMethodBeat.o(150414);
      return -2;
    }
    if (paramc != null) {
      ae.d("MicroMsg.CdnTransportService", "CDN progress. total:%d, cur:%d, canshow:%b", new Object[] { Long.valueOf(paramc.field_toltalLength), Long.valueOf(paramc.field_finishedLength), Boolean.valueOf(paramc.field_mtlnotify) });
    }
    this.hWF = bu.fpO();
    this.hWE = paramString;
    com.tencent.e.h.MqF.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(218671);
        Object localObject = (com.tencent.mm.i.g)b.h(b.this).get(paramString);
        if (localObject == null)
        {
          ae.d("MicroMsg.CdnTransportService", " task in jni get info failed mediaid[%s] hash[%s]", new Object[] { paramString, Integer.valueOf(b.this.hashCode()) });
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(594L, 7L, 1L, true);
          AppMethodBeat.o(218671);
          return;
        }
        b.a locala = b.a(b.this, (com.tencent.mm.i.g)localObject);
        if (paramc != null)
        {
          paramc.mediaId = paramString;
          ae.i("MicroMsg.CdnTransportService", "MTL: total:%d, cur:%d, mtl:%b", new Object[] { Long.valueOf(paramc.field_toltalLength), Long.valueOf(paramc.field_finishedLength), Boolean.valueOf(paramc.field_mtlnotify) });
        }
        if (paramd != null) {
          paramd.mediaId = paramString;
        }
        if (((com.tencent.mm.i.g)localObject).fLm != null)
        {
          long l = bu.fpO();
          if ((paramd == null) && (paramc != null) && (!paramc.field_mtlnotify) && (az.getNetWorkType(ak.getContext()) == -1))
          {
            b.a(b.this, locala);
            AppMethodBeat.o(218671);
            return;
          }
          ((com.tencent.mm.i.g)localObject).field_lastProgressCallbackTime = l;
          ((com.tencent.mm.i.g)localObject).fLm.a(paramString, 0, paramc, paramd, ((com.tencent.mm.i.g)localObject).field_onlycheckexist);
        }
        if ((localObject instanceof com.tencent.mm.i.f)) {}
        for (localObject = (com.tencent.mm.i.f)localObject;; localObject = null)
        {
          if ((b.a(paramc)) && ((localObject == null) || (((com.tencent.mm.i.f)localObject).Ya()))) {
            b.e(b.this).remove(paramString);
          }
          if (paramd != null)
          {
            if ((localObject == null) || (((com.tencent.mm.i.f)localObject).Ya())) {
              b.h(b.this).remove(paramString);
            }
            if (paramd.field_retCode == -5103011)
            {
              ae.i("MicroMsg.CdnTransportService", "summersafecdn ERR_VALIDATE_AUTHKEY");
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(546L, 4L, 1L, true);
              f.aHa().keep_OnRequestDoGetCdnDnsInfo(999);
            }
          }
          b.b(b.this, locala);
          AppMethodBeat.o(218671);
          return;
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(218672);
        String str = super.toString() + "|callback";
        AppMethodBeat.o(218672);
        return str;
      }
    }, g((com.tencent.mm.i.g)this.hWC.get(paramString)));
    AppMethodBeat.o(150414);
    return 0;
  }
  
  public final int a(final String paramString, final com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(218676);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(218676);
      return 0;
    }
    com.tencent.e.h.MqF.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(218665);
        com.tencent.mm.i.g localg = (com.tencent.mm.i.g)b.h(b.this).get(paramString);
        if (localg == null)
        {
          ae.d("MicroMsg.CdnTransportService", " task in jni get info failed mediaid:%s", new Object[] { paramString });
          AppMethodBeat.o(218665);
          return;
        }
        if (localg.fLE != null) {
          localg.fLE.b(paramString, paramd);
        }
        AppMethodBeat.o(218665);
      }
    }, g((com.tencent.mm.i.g)this.hWC.get(paramString)));
    AppMethodBeat.o(218676);
    return 0;
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(150403);
    if (!com.tencent.mm.kernel.g.ajP().aiZ())
    {
      AppMethodBeat.o(150403);
      return;
    }
    int i = bu.m(paramObject, 0);
    ae.d("MicroMsg.CdnTransportService", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    if ((paramn != com.tencent.mm.kernel.g.ajR().ajA()) || (i <= 0))
    {
      ae.e("MicroMsg.CdnTransportService", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramn });
      AppMethodBeat.o(150403);
      return;
    }
    if (i != 144385)
    {
      AppMethodBeat.o(150403);
      return;
    }
    f.aGW().pf(10);
    AppMethodBeat.o(150403);
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    AppMethodBeat.i(150415);
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.CdnTransportService", "cdn callback getauthbuf mediaid is null");
      AppMethodBeat.o(150415);
      return;
    }
    com.tencent.mm.i.g localg = (com.tencent.mm.i.g)this.hWC.get(paramString);
    if (localg == null)
    {
      ae.e("MicroMsg.CdnTransportService", " getauthbuf task in jni get info failed mediaid:%s", new Object[] { paramString });
      AppMethodBeat.o(150415);
      return;
    }
    if (localg.fLm != null)
    {
      localg.fLm.a(paramString, paramByteArrayOutputStream);
      AppMethodBeat.o(150415);
      return;
    }
    ae.e("MicroMsg.CdnTransportService", "getCdnAuthInfo fail, null taskcallback.");
    AppMethodBeat.o(150415);
  }
  
  public final void aGR()
  {
    AppMethodBeat.i(150413);
    com.tencent.mm.kernel.g.ajP();
    CdnLogic.Config localConfig;
    Object localObject;
    String str1;
    String str2;
    String str3;
    String str4;
    String str5;
    String str6;
    String str7;
    String str8;
    if (com.tencent.mm.kernel.a.aiY())
    {
      localConfig = new CdnLogic.Config();
      localObject = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getValue("EnableCDNUploadImg");
      str1 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getValue("EnableCDNVerifyConnect");
      str2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getValue("EnableCDNVideoRedirectOC");
      str3 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getValue("EnableStreamUploadVideo");
      str4 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getValue("C2COverloadDelaySeconds");
      str5 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getValue("SNSOverloadDelaySeconds");
      str6 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getValue("EnableSnsStreamDownload");
      str7 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getValue("EnableSnsImageDownload");
      str8 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getValue("ApprovedVideoPrivateProtocolHosts");
    }
    for (;;)
    {
      try
      {
        if (!bu.isNullOrNil((String)localObject)) {
          localConfig.UseStreamCDN = Integer.valueOf((String)localObject).intValue();
        }
        if (!bu.isNullOrNil(str1)) {
          localConfig.EnableCDNVerifyConnect = Integer.valueOf(str1).intValue();
        }
        if (!bu.isNullOrNil(str2)) {
          localConfig.EnableCDNVideoRedirectOC = Integer.valueOf(str2).intValue();
        }
        if (!bu.isNullOrNil(str3)) {
          localConfig.EnableStreamUploadVideo = Integer.valueOf(str3).intValue();
        }
        if (!bu.isNullOrNil(str4)) {
          localConfig.C2COverloadDelaySeconds = Integer.valueOf(str4).intValue();
        }
        if (!bu.isNullOrNil(str5)) {
          localConfig.SNSOverloadDelaySeconds = Integer.valueOf(str5).intValue();
        }
        if (!bu.isNullOrNil(str6)) {
          localConfig.EnableSnsStreamDownload = Integer.valueOf(str6).intValue();
        }
        if (!bu.isNullOrNil(str7)) {
          localConfig.EnableSnsImageDownload = Integer.valueOf(str7).intValue();
        }
        if (!bu.isNullOrNil(str8)) {
          localConfig.ApprovedVideoHosts = str8;
        }
        f.aGZ();
        if (!pd(256)) {
          continue;
        }
        i = 1;
        localConfig.EnableSafeCDN = i;
        localConfig.EnableSnsVideoRedirect = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qJC, 0);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("clicfg_android_channelvideo_quic=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qJD, "0")).append(";");
        ((StringBuilder)localObject).append("clicfg_android_statusvideo_quic=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qJE, "0")).append(";");
        ((StringBuilder)localObject).append("clicfg_android_snsvideo_quic=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qJF, "0")).append(";");
        ((StringBuilder)localObject).append("clicfg_android_snsimage_quic=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qJG, "0")).append(";");
        ((StringBuilder)localObject).append("clicfg_android_c2cvideo_quic=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qJH, "0")).append(";");
        ((StringBuilder)localObject).append("clicfg_android_quic_bigfile=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qJI, "0")).append(";");
        ((StringBuilder)localObject).append("clicfg_android_quic_fullimage=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qJJ, "0")).append(";");
        ((StringBuilder)localObject).append("clicfg_android_c2cimage2_quic=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qJK, "0")).append(";");
        ((StringBuilder)localObject).append("clicfg_android_c2cfile_quic=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qJL, "0")).append(";");
        ((StringBuilder)localObject).append("clicfg_android_quic_backup=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qJM, "0")).append(";");
        ((StringBuilder)localObject).append("clicfg_android_quic_favorite=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qJN, "0")).append(";");
        localConfig.QuicExptValues = ((StringBuilder)localObject).toString();
        ae.i("MicroMsg.CdnTransportService", "[quic.config] expt %s", new Object[] { localConfig.QuicExptValues });
        if (localConfig.UseStreamCDN != 0)
        {
          localObject = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getValue("ProgJPEGUploadSizeLimitWifi");
          str1 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getValue("ProgJPEGUploadSizeLimit3G");
          str2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getValue("ProgJPEGDownloadSizeLimit");
          str3 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getValue("EnableJPEGDyncmicETL");
          if (!bu.isNullOrNil((String)localObject)) {
            localConfig.WifiEtl = Integer.valueOf((String)localObject).intValue();
          }
          if (!bu.isNullOrNil(str1)) {
            localConfig.MobileEtl = Integer.valueOf(str1).intValue();
          }
          if (!bu.isNullOrNil(str2)) {
            localConfig.Ptl = Integer.valueOf(str2).intValue();
          }
          if (!bu.isNullOrNil(str3)) {
            localConfig.UseDynamicETL = Integer.valueOf(str3).intValue();
          }
        }
        if (this.hWs != -1)
        {
          ae.w("MicroMsg.CdnTransportService", "cmd set snsimage flag: %d", new Object[] { Integer.valueOf(this.hWs) });
          localConfig.EnableSnsImageDownload = this.hWs;
        }
        ae.i("MicroMsg.CdnTransportService", "summersafecdn streamcdn config[SVR]:%s", new Object[] { localConfig });
        CdnLogic.setConfig(localConfig);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        int i;
        ae.e("MicroMsg.CdnTransportService", localNumberFormatException.toString());
        continue;
      }
      if (ac.iSa)
      {
        ae.w("MicroMsg.CdnTransportService", "use cdn debug configure.");
        localConfig.UseStreamCDN = 1;
        localConfig.EnableSnsVideoRedirect = ac.iSg;
        ae.i("MicroMsg.CdnTransportService", "streamcdn config[DEBUG]:%s", new Object[] { localConfig });
        CdnLogic.setConfig(localConfig);
      }
      AppMethodBeat.o(150413);
      return;
      i = 0;
    }
  }
  
  public final boolean b(final com.tencent.mm.i.g paramg, final int paramInt)
  {
    AppMethodBeat.i(150407);
    if (paramg == null)
    {
      ae.e("MicroMsg.CdnTransportService", "addRecvTask task info is null");
      AppMethodBeat.o(150407);
      return false;
    }
    if (bu.isNullOrNil(paramg.field_mediaId))
    {
      ae.e("MicroMsg.CdnTransportService", "addRecvTask mediaId is null");
      AppMethodBeat.o(150407);
      return false;
    }
    if (paramg.field_fileId == null) {
      paramg.field_fileId = "";
    }
    if (paramg.field_aesKey == null) {
      paramg.field_aesKey = "";
    }
    paramg.dPh = false;
    com.tencent.e.h.MqF.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150400);
        if (paramInt != -1) {
          b.e(b.this).put(paramg.field_mediaId, Integer.valueOf(paramInt));
        }
        ae.i("MicroMsg.CdnTransportService", "CdnTransportService cdn thread run %s", new Object[] { paramg.field_mediaId });
        b.f(b.this).add(paramg.field_mediaId);
        b.g(b.this).put(paramg.field_mediaId, paramg);
        b.this.eN(false);
        AppMethodBeat.o(150400);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(150401);
        String str = super.toString() + "|addRecvTask";
        AppMethodBeat.o(150401);
        return str;
      }
    }, "MicroMsg.Cdn.ThreadName");
    AppMethodBeat.o(150407);
    return true;
  }
  
  public final boolean d(com.tencent.mm.i.g paramg)
  {
    AppMethodBeat.i(218675);
    if (paramg == null)
    {
      ae.e("MicroMsg.CdnTransportService", "addRecvTask task info is null");
      AppMethodBeat.o(218675);
      return false;
    }
    if (bu.isNullOrNil(paramg.field_mediaId))
    {
      ae.e("MicroMsg.CdnTransportService", "addRecvTask mediaId is null");
      AppMethodBeat.o(218675);
      return false;
    }
    if (paramg.field_fileId == null) {
      paramg.field_fileId = "";
    }
    if (paramg.field_aesKey == null) {
      paramg.field_aesKey = "";
    }
    paramg.dPh = false;
    ae.i("MicroMsg.CdnTransportService", "CdnTransportService cdn thread run %s", new Object[] { paramg.field_mediaId });
    this.hWA.add(paramg.field_mediaId);
    this.hWB.put(paramg.field_mediaId, paramg);
    eN(false);
    AppMethodBeat.o(218675);
    return true;
  }
  
  public final boolean e(com.tencent.mm.i.g paramg)
  {
    AppMethodBeat.i(150408);
    boolean bool = b(paramg, -1);
    AppMethodBeat.o(150408);
    return bool;
  }
  
  public final void eN(boolean paramBoolean)
  {
    AppMethodBeat.i(150412);
    if ((!paramBoolean) && (f.aHa().aGQ()))
    {
      com.tencent.mm.kernel.g.ajP();
      if (com.tencent.mm.kernel.a.aiY())
      {
        ae.w("MicroMsg.CdnTransportService", "summersafecdn cdntra Not init cdn dnsinfo , will retry after set info");
        f.aGW().pf(4);
        AppMethodBeat.o(150412);
        return;
      }
    }
    aGR();
    ae.i("MicroMsg.CdnTransportService", "summersafecdn tryStart queue:%d", new Object[] { Integer.valueOf(this.hWA.size()) });
    Object localObject1;
    Object localObject3;
    label216:
    int j;
    label226:
    Object localObject2;
    if (!this.hWA.isEmpty())
    {
      localObject1 = (String)this.hWA.poll();
      localObject3 = (com.tencent.mm.i.g)this.hWB.remove(localObject1);
      if (localObject3 == null)
      {
        ae.e("MicroMsg.CdnTransportService", "summersafecdn task queue is empty , maybe bug here");
        AppMethodBeat.o(150412);
        return;
      }
      ae.i("MicroMsg.CdnTransportService", "summersafecdn id:%s cdnautostart :%s chatroom:%s", new Object[] { ((com.tencent.mm.i.g)localObject3).field_mediaId, Boolean.valueOf(((com.tencent.mm.i.g)localObject3).field_autostart), Integer.valueOf(((com.tencent.mm.i.g)localObject3).field_chattype) });
      ((com.tencent.mm.i.g)localObject3).field_startTime = bu.fpO();
      if (((com.tencent.mm.i.g)localObject3).dPh)
      {
        String str;
        if (((com.tencent.mm.i.g)localObject3).field_fullpath == null)
        {
          i = -1;
          if (((com.tencent.mm.i.g)localObject3).field_thumbpath != null) {
            break label623;
          }
          j = -1;
          ae.i("MicroMsg.CdnTransportService", "summersafecdn tryStart send file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b] largesvideo[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), bu.aSM(((com.tencent.mm.i.g)localObject3).field_svr_signature), bu.aSM(((com.tencent.mm.i.g)localObject3).field_aesKey), Integer.valueOf(((com.tencent.mm.i.g)localObject3).field_fileType), ((com.tencent.mm.i.g)localObject3).field_mediaId, Boolean.valueOf(((com.tencent.mm.i.g)localObject3).field_onlycheckexist), Integer.valueOf(((com.tencent.mm.i.g)localObject3).field_largesvideo) });
          if (((com.tencent.mm.i.g)localObject3).field_fullpath == null) {
            ((com.tencent.mm.i.g)localObject3).field_fullpath = "";
          }
          if (((com.tencent.mm.i.g)localObject3).field_thumbpath == null) {
            ((com.tencent.mm.i.g)localObject3).field_thumbpath = "";
          }
          localObject1 = (com.tencent.mm.i.g)this.hWC.put(((com.tencent.mm.i.g)localObject3).field_mediaId, localObject3);
          localObject2 = (com.tencent.mm.i.g)this.hWC.get(((com.tencent.mm.i.g)localObject3).field_mediaId);
          if (localObject2 == null) {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(594L, 5L, 1L, true);
          }
          i = f.aHa().b((com.tencent.mm.i.g)localObject3);
          str = ((com.tencent.mm.i.g)localObject3).field_mediaId;
          if (localObject1 != null) {
            break label635;
          }
          localObject1 = null;
          label432:
          if (localObject2 != null) {
            break label645;
          }
        }
        label645:
        for (localObject2 = null;; localObject2 = ((com.tencent.mm.i.g)localObject2).field_mediaId)
        {
          ae.i("MicroMsg.CdnTransportService", "summersafecdn startupUploadMedia ok, field_mediaId[%s] ret[%s, %s, %s] hash[%s]", new Object[] { str, Integer.valueOf(i), localObject1, localObject2, Integer.valueOf(hashCode()) });
          if (i == 0) {
            break;
          }
          ae.e("MicroMsg.CdnTransportService", "summersafecdn startupUploadMedia error:%d clientid:%s", new Object[] { Integer.valueOf(i), ((com.tencent.mm.i.g)localObject3).field_mediaId });
          if (-21005 != i)
          {
            localObject1 = (com.tencent.mm.i.g)this.hWC.remove(((com.tencent.mm.i.g)localObject3).field_mediaId);
            ae.e("MicroMsg.CdnTransportService", "summersafecdn startupUploadMedia error:%d clientid:%s remove[%s]", new Object[] { Integer.valueOf(i), ((com.tencent.mm.i.g)localObject3).field_mediaId, localObject1 });
          }
          if (((com.tencent.mm.i.g)localObject3).fLm == null) {
            break;
          }
          ((com.tencent.mm.i.g)localObject3).fLm.a(((com.tencent.mm.i.g)localObject3).field_mediaId, i, null, null, ((com.tencent.mm.i.g)localObject3).field_onlycheckexist);
          break;
          i = ((com.tencent.mm.i.g)localObject3).field_fullpath.length();
          break label216;
          label623:
          j = ((com.tencent.mm.i.g)localObject3).field_thumbpath.length();
          break label226;
          label635:
          localObject1 = ((com.tencent.mm.i.g)localObject1).field_mediaId;
          break label432;
        }
      }
      j = -1;
      if (((com.tencent.mm.i.g)localObject3).field_fileType == 40001) {
        i = f.aHa().a(((com.tencent.mm.i.g)localObject3).field_mediaId, ((com.tencent.mm.i.g)localObject3).fLp, ((com.tencent.mm.i.g)localObject3).field_fullpath, ((com.tencent.mm.i.g)localObject3).field_fileType, ((com.tencent.mm.i.g)localObject3).field_aesKey, ((com.tencent.mm.i.g)localObject3).field_authKey);
      }
      for (;;)
      {
        label705:
        if (i != 0)
        {
          ae.e("MicroMsg.CdnTransportService", "summersafecdn startupDownloadMedia error:%d clientid:%s", new Object[] { Integer.valueOf(i), ((com.tencent.mm.i.g)localObject3).field_mediaId });
          if (((com.tencent.mm.i.g)localObject3).fLm == null) {
            break;
          }
          ((com.tencent.mm.i.g)localObject3).fLm.a(((com.tencent.mm.i.g)localObject3).field_mediaId, i, null, null, ((com.tencent.mm.i.g)localObject3).field_onlycheckexist);
          break;
          if (((com.tencent.mm.i.g)localObject3).field_fileType == 19) {
            i = f.aHa().a(((com.tencent.mm.i.g)localObject3).field_mediaId, ((com.tencent.mm.i.g)localObject3).fLp, ((com.tencent.mm.i.g)localObject3).field_fullpath, ((com.tencent.mm.i.g)localObject3).field_fileType, ((com.tencent.mm.i.g)localObject3).field_aesKey, ((com.tencent.mm.i.g)localObject3).field_authKey);
          } else if ((((com.tencent.mm.i.g)localObject3).field_fileType == com.tencent.mm.i.a.fKO) || (((com.tencent.mm.i.g)localObject3).field_fileType == com.tencent.mm.i.a.fKQ)) {
            if ((((com.tencent.mm.i.g)localObject3).field_fullpath == null) || (((com.tencent.mm.i.g)localObject3).field_fullpath.isEmpty())) {
              break label2014;
            }
          }
        }
      }
    }
    label1299:
    label1443:
    label1456:
    label1840:
    label1992:
    label2009:
    label2014:
    for (int i = f.aHa().a(((com.tencent.mm.i.g)localObject3).field_mediaId, ((com.tencent.mm.i.g)localObject3).fLp, ((com.tencent.mm.i.g)localObject3).field_fullpath, ((com.tencent.mm.i.g)localObject3).field_fileType, ((com.tencent.mm.i.g)localObject3).fLq, ((com.tencent.mm.i.g)localObject3).fLr, ((com.tencent.mm.i.g)localObject3).fLs, ((com.tencent.mm.i.g)localObject3).fLt, ((com.tencent.mm.i.g)localObject3).fLA, ((com.tencent.mm.i.g)localObject3).fLB);; i = -1)
    {
      if (((com.tencent.mm.i.g)localObject3).field_fullpath == null) {}
      for (j = -1;; j = ((com.tencent.mm.i.g)localObject3).field_fullpath.length())
      {
        ae.i("MicroMsg.CdnTransportService", "url download tryStart recv file:%d field_mediaId[%s], download_url[%s], filetype:[%d]", new Object[] { Integer.valueOf(j), ((com.tencent.mm.i.g)localObject3).field_mediaId, ((com.tencent.mm.i.g)localObject3).fLp, Integer.valueOf(((com.tencent.mm.i.g)localObject3).field_fileType) });
        break;
      }
      if (((com.tencent.mm.i.g)localObject3).fLv)
      {
        i = j;
        if (((com.tencent.mm.i.g)localObject3).field_fullpath != null)
        {
          i = j;
          if (!((com.tencent.mm.i.g)localObject3).field_fullpath.isEmpty()) {
            i = f.aHa().a(((com.tencent.mm.i.g)localObject3).field_mediaId, ((com.tencent.mm.i.g)localObject3).field_fullpath, ((com.tencent.mm.i.g)localObject3).fLp, ((com.tencent.mm.i.g)localObject3).fLw, ((com.tencent.mm.i.g)localObject3).fLx, ((com.tencent.mm.i.g)localObject3).allow_mobile_net_download, ((com.tencent.mm.i.g)localObject3).fLq, ((com.tencent.mm.i.g)localObject3).fLr, ((com.tencent.mm.i.g)localObject3).is_resume_task, ((com.tencent.mm.i.g)localObject3).fLu, ((com.tencent.mm.i.g)localObject3).fLs);
          }
        }
        if (((com.tencent.mm.i.g)localObject3).field_fullpath == null) {}
        for (j = -1;; j = ((com.tencent.mm.i.g)localObject3).field_fullpath.length())
        {
          ae.i("MicroMsg.CdnTransportService", "game package download tryStart recv file:%d field_mediaId[%s], download_url[%s] https url[%s]", new Object[] { Integer.valueOf(j), ((com.tencent.mm.i.g)localObject3).field_mediaId, ((com.tencent.mm.i.g)localObject3).fLp, ((com.tencent.mm.i.g)localObject3).fLw });
          break;
        }
      }
      if (((com.tencent.mm.i.g)localObject3).fLy)
      {
        if ((localObject3 instanceof com.tencent.mm.i.f))
        {
          localObject1 = (com.tencent.mm.i.f)localObject3;
          i = f.aHa().a((com.tencent.mm.i.f)localObject1);
          break label705;
        }
        if (!(localObject3 instanceof com.tencent.mm.i.e)) {
          break label2009;
        }
        localObject1 = (com.tencent.mm.i.e)localObject3;
        i = f.aHa().a(((com.tencent.mm.i.e)localObject1).field_mediaId, ((com.tencent.mm.i.e)localObject1).url, ((com.tencent.mm.i.e)localObject1).referer, ((com.tencent.mm.i.e)localObject1).fLd, ((com.tencent.mm.i.e)localObject1).fLe, ((com.tencent.mm.i.e)localObject1).fLf, ((com.tencent.mm.i.e)localObject1).fLg, ((com.tencent.mm.i.e)localObject1).fLh, ((com.tencent.mm.i.e)localObject1).isColdSnsData, ((com.tencent.mm.i.e)localObject1).signalQuality, ((com.tencent.mm.i.e)localObject1).snsScene, ((com.tencent.mm.i.e)localObject1).snsCipherKey, ((com.tencent.mm.i.e)localObject1).eRn, ((com.tencent.mm.i.e)localObject1).appType, ((com.tencent.mm.i.e)localObject1).fileType);
        break label705;
      }
      if (((com.tencent.mm.i.g)localObject3).field_fullpath == null)
      {
        i = -1;
        if (((com.tencent.mm.i.g)localObject3).field_thumbpath != null) {
          break label1443;
        }
      }
      for (int k = -1;; k = ((com.tencent.mm.i.g)localObject3).field_thumbpath.length())
      {
        ae.i("MicroMsg.CdnTransportService", "summersafecdn tryStart recv file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b]", new Object[] { Integer.valueOf(i), Integer.valueOf(k), ((com.tencent.mm.i.g)localObject3).field_svr_signature, ((com.tencent.mm.i.g)localObject3).field_aesKey, Integer.valueOf(((com.tencent.mm.i.g)localObject3).field_fileType), ((com.tencent.mm.i.g)localObject3).field_mediaId, Boolean.valueOf(((com.tencent.mm.i.g)localObject3).field_onlycheckexist) });
        if (((com.tencent.mm.i.g)localObject3).fLC != 2) {
          break label1840;
        }
        if (!(localObject3 instanceof com.tencent.mm.i.h)) {
          break label2009;
        }
        localObject1 = (com.tencent.mm.i.h)localObject3;
        if (!((com.tencent.mm.i.h)localObject1).Yd()) {
          break label1456;
        }
        i = f.aHa().a((com.tencent.mm.i.g)localObject3, 2);
        break;
        i = ((com.tencent.mm.i.g)localObject3).field_fullpath.length();
        break label1299;
      }
      if (((com.tencent.mm.i.h)localObject1).Yb())
      {
        i = f.aHa().a(((com.tencent.mm.i.h)localObject1).field_mediaId, ((com.tencent.mm.i.h)localObject1).url, ((com.tencent.mm.i.h)localObject1).referer, ((com.tencent.mm.i.h)localObject1).field_fullpath, ((com.tencent.mm.i.h)localObject1).fLI, ((com.tencent.mm.i.h)localObject1).fLe, ((com.tencent.mm.i.h)localObject1).isColdSnsData, ((com.tencent.mm.i.h)localObject1).signalQuality, ((com.tencent.mm.i.h)localObject1).snsScene, ((com.tencent.mm.i.h)localObject1).field_preloadRatio, ((com.tencent.mm.i.h)localObject1).preloadMinSize, ((com.tencent.mm.i.h)localObject1).field_requestVideoFormat, 1, 1);
        break label705;
      }
      if (((com.tencent.mm.i.h)localObject1).Yc())
      {
        i = f.aHa().a(((com.tencent.mm.i.h)localObject1).field_mediaId, ((com.tencent.mm.i.h)localObject1).url, ((com.tencent.mm.i.h)localObject1).referer, ((com.tencent.mm.i.h)localObject1).field_fullpath, ((com.tencent.mm.i.h)localObject1).fLI, ((com.tencent.mm.i.h)localObject1).field_preloadRatio, ((com.tencent.mm.i.h)localObject1).preloadMinSize, ((com.tencent.mm.i.h)localObject1).concurrentCount);
        break label705;
      }
      if (((com.tencent.mm.i.h)localObject1).Yf())
      {
        i = f.aHa().a(((com.tencent.mm.i.h)localObject1).field_mediaId, ((com.tencent.mm.i.h)localObject1).url, ((com.tencent.mm.i.h)localObject1).referer, ((com.tencent.mm.i.h)localObject1).field_fullpath, ((com.tencent.mm.i.h)localObject1).fLI, ((com.tencent.mm.i.h)localObject1).fLe, ((com.tencent.mm.i.h)localObject1).isColdSnsData, ((com.tencent.mm.i.h)localObject1).signalQuality, ((com.tencent.mm.i.h)localObject1).snsScene, ((com.tencent.mm.i.h)localObject1).field_preloadRatio, ((com.tencent.mm.i.h)localObject1).preloadMinSize, ((com.tencent.mm.i.h)localObject1).field_requestVideoFormat, ((com.tencent.mm.i.h)localObject1).connectionCount);
        break label705;
      }
      if (((com.tencent.mm.i.h)localObject1).Yh())
      {
        i = f.aHa().a(((com.tencent.mm.i.h)localObject1).field_mediaId, ((com.tencent.mm.i.h)localObject1).url, ((com.tencent.mm.i.h)localObject1).referer, ((com.tencent.mm.i.h)localObject1).field_fullpath, ((com.tencent.mm.i.h)localObject1).fLI, ((com.tencent.mm.i.h)localObject1).field_preloadRatio, ((com.tencent.mm.i.h)localObject1).preloadMinSize, ((com.tencent.mm.i.h)localObject1).concurrentCount);
        break label705;
      }
      i = j;
      if (((com.tencent.mm.i.h)localObject1).Yg()) {
        i = f.aHa().a(((com.tencent.mm.i.h)localObject1).field_mediaId, ((com.tencent.mm.i.h)localObject1).url, ((com.tencent.mm.i.h)localObject1).referer, ((com.tencent.mm.i.h)localObject1).field_fullpath, ((com.tencent.mm.i.h)localObject1).fLI, ((com.tencent.mm.i.h)localObject1).fLe, ((com.tencent.mm.i.h)localObject1).isColdSnsData, ((com.tencent.mm.i.h)localObject1).signalQuality, ((com.tencent.mm.i.h)localObject1).snsScene, ((com.tencent.mm.i.h)localObject1).field_preloadRatio, ((com.tencent.mm.i.h)localObject1).preloadMinSize, ((com.tencent.mm.i.h)localObject1).field_requestVideoFormat, ((com.tencent.mm.i.h)localObject1).connectionCount, ((com.tencent.mm.i.h)localObject1).fLP, ((com.tencent.mm.i.h)localObject1).videoFlag, ((com.tencent.mm.i.h)localObject1).snsCipherKey, ((com.tencent.mm.i.h)localObject1).concurrentCount);
      }
      break label705;
      i = f.aHa().c((com.tencent.mm.i.g)localObject3);
      break label705;
      localObject1 = (com.tencent.mm.i.g)this.hWC.put(((com.tencent.mm.i.g)localObject3).field_mediaId, localObject3);
      localObject2 = (com.tencent.mm.i.g)this.hWC.get(((com.tencent.mm.i.g)localObject3).field_mediaId);
      if (localObject2 == null) {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(594L, 6L, 1L, true);
      }
      localObject3 = ((com.tencent.mm.i.g)localObject3).field_mediaId;
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject2 != null) {
          break label1992;
        }
      }
      for (localObject2 = null;; localObject2 = ((com.tencent.mm.i.g)localObject2).field_mediaId)
      {
        ae.i("MicroMsg.CdnTransportService", "summersafecdn startupDownloadMedia ok, field_mediaId[%s] ret[%s, %s, %s] hash[%s]", new Object[] { localObject3, Integer.valueOf(i), localObject1, localObject2, Integer.valueOf(hashCode()) });
        break;
        localObject1 = ((com.tencent.mm.i.g)localObject1).field_mediaId;
        break label1926;
      }
      AppMethodBeat.o(150412);
      return;
      i = -1;
      break label705;
    }
  }
  
  public final boolean f(final com.tencent.mm.i.g paramg)
  {
    AppMethodBeat.i(150409);
    if (paramg == null)
    {
      ae.e("MicroMsg.CdnTransportService", "summersafecdn addSendTask task info is null");
      AppMethodBeat.o(150409);
      return false;
    }
    if (bu.isNullOrNil(paramg.field_mediaId))
    {
      ae.e("MicroMsg.CdnTransportService", "summersafecdn addSendTask mediaId is null");
      AppMethodBeat.o(150409);
      return false;
    }
    if (paramg.field_fileId == null) {
      paramg.field_fileId = "";
    }
    if (paramg.field_aesKey == null) {
      paramg.field_aesKey = "";
    }
    paramg.dPh = true;
    com.tencent.e.h.MqF.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150402);
        b.f(b.this).add(paramg.field_mediaId);
        b.g(b.this).put(paramg.field_mediaId, paramg);
        b.this.eN(false);
        AppMethodBeat.o(150402);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(218670);
        String str = super.toString() + "|addSendTask";
        AppMethodBeat.o(218670);
        return str;
      }
    }, "MicroMsg.Cdn.ThreadName");
    AppMethodBeat.o(150409);
    return true;
  }
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150416);
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.CdnTransportService", "cdn callback decodePrepareResponse mediaid is null");
      AppMethodBeat.o(150416);
      return null;
    }
    com.tencent.mm.i.g localg = (com.tencent.mm.i.g)this.hWC.get(paramString);
    if (localg == null)
    {
      ae.e("MicroMsg.CdnTransportService", " decodePrepareResponse task in jni get info failed mediaid:%s", new Object[] { paramString });
      AppMethodBeat.o(150416);
      return null;
    }
    if (localg.fLm != null)
    {
      paramString = localg.fLm.f(paramString, paramArrayOfByte);
      AppMethodBeat.o(150416);
      return paramString;
    }
    ae.e("MicroMsg.CdnTransportService", "decodePrepareResponse fail, null taskcallback.");
    AppMethodBeat.o(150416);
    return null;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(150404);
    if (paramn.getType() != 379)
    {
      AppMethodBeat.o(150404);
      return;
    }
    ae.d("MicroMsg.CdnTransportService", "cdntra onSceneEnd it will tryStart sceneType:%d [%d,%d]", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (com.tencent.mm.kernel.g.ajP().aiZ()) {
      com.tencent.e.h.MqF.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(150398);
          b.this.eN(true);
          AppMethodBeat.o(150398);
        }
        
        public final String toString()
        {
          AppMethodBeat.i(150399);
          String str = super.toString() + "|onSceneEnd";
          AppMethodBeat.o(150399);
          return str;
        }
      }, "MicroMsg.Cdn.ThreadName");
    }
    AppMethodBeat.o(150404);
  }
  
  public final void pe(int paramInt)
  {
    this.hWs = paramInt;
  }
  
  static final class a
  {
    public boolean dPh;
    public int dQH;
    public int dQI;
    public int dQJ;
    public int dQK;
    public int dQL;
    public int dQM;
    public int dQN;
    public int dQO;
    public String dQP;
    public int dQQ;
    public int dQR;
    public long endTime;
    public String fLl;
    public String field_mediaId;
    public int field_totalLen;
    public String hWR;
    public long hWS;
    public long startTime;
    public long threadId;
    
    public a(String paramString1, String paramString2, String paramString3, long paramLong, com.tencent.mm.i.g paramg)
    {
      AppMethodBeat.i(218673);
      this.hWR = "";
      this.fLl = "task_default";
      this.field_mediaId = "";
      this.field_totalLen = 0;
      this.startTime = 0L;
      this.endTime = -1L;
      this.threadId = 0L;
      this.dQH = 0;
      this.dQI = 0;
      this.dQJ = 0;
      this.dQK = 0;
      this.dQL = 0;
      this.dQM = 0;
      this.dQN = 0;
      this.dQO = 0;
      this.dQP = "";
      this.dQQ = 0;
      this.dQR = 0;
      this.hWS = 0L;
      this.hWR = paramString1;
      this.fLl = paramString2;
      this.field_mediaId = paramString3;
      this.dPh = paramg.dPh;
      this.field_totalLen = paramg.field_totalLen;
      this.startTime = paramLong;
      this.threadId = Thread.currentThread().getId();
      this.dQH = paramg.field_fileType;
      this.dQI = paramg.field_appType;
      this.dQJ = paramg.field_bzScene;
      this.dQK = paramg.eRn;
      this.dQL = paramg.field_chattype;
      this.dQM = paramg.field_advideoflag;
      this.dQN = paramg.field_largesvideo;
      this.dQO = paramg.field_requestVideoFormat;
      this.dQP = bu.bI(paramg.field_snsScene, "");
      if (paramg.fLy) {
        i = 1;
      }
      this.dQQ = i;
      this.dQR = paramg.fLD;
      this.hWS = System.currentTimeMillis();
      AppMethodBeat.o(218673);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(218674);
      String str = "CdnTaskReportInfo{cdnCallbackReportId='" + this.hWR + '\'' + ", taskName='" + this.fLl + '\'' + ", field_mediaId='" + this.field_mediaId + '\'' + ", isSend=" + this.dPh + ", field_totalLen=" + this.field_totalLen + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", threadId=" + this.threadId + ", _FileType=" + this.dQH + ", _AppType=" + this.dQI + ", _BzScene=" + this.dQJ + ", _BizType=" + this.dQK + ", _Chattype=" + this.dQL + ", _Advideoflag=" + this.dQM + ", _Largesvideo=" + this.dQN + ", _RequestVideoFormat=" + this.dQO + ", _SnsScene='" + this.dQP + '\'' + ", _SnsImageDownload=" + this.dQQ + ", _VideoTaskType=" + this.dQR + ", localTime=" + this.hWS + '}';
      AppMethodBeat.o(218674);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.an.b
 * JD-Core Version:    0.7.0.1
 */