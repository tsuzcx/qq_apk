package com.tencent.mm.ao;

import android.os.Looper;
import com.tencent.e.i;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.Config;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.app.n.a;
import com.tencent.mm.g.a.lk;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.g.b;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
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
  implements com.tencent.mm.al.f, com.tencent.mm.i.b, com.tencent.mm.i.b.a, n.b
{
  private static final long[] hTP = { 0L, 2L, 5L, 7L, 10L, 15L, 20L, 30L, 50L, 70L, 100L, 200L, 400L, 600L, 800L, 1000L, 3000L, 5000L, 10000L, 20000L, 30000L, 40000L, 50000L, 60000L, 120000L };
  private static final int[] hTQ = { 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34 };
  private static int hTR = -1;
  private static long hTS = -1L;
  public n.a appForegroundListener;
  private int hTA;
  ap hTB;
  com.tencent.mm.sdk.b.c<lk> hTC;
  com.tencent.mm.network.n hTD;
  private ConcurrentHashMap<String, a> hTE;
  final av hTF;
  ConcurrentHashMap<String, String> hTG;
  private boolean hTH;
  private Queue<String> hTI;
  public Map<String, com.tencent.mm.i.g> hTJ;
  public Map<String, com.tencent.mm.i.g> hTK;
  public Map<String, Integer> hTL;
  private String hTM;
  private long hTN;
  public HashSet<String> hTO;
  
  public b()
  {
    AppMethodBeat.i(150406);
    this.hTA = -1;
    this.hTB = new b.1(this, Looper.getMainLooper());
    this.hTC = new b.3(this);
    this.hTD = new b.4(this);
    this.hTE = new ConcurrentHashMap();
    this.hTF = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(195216);
        ad.i("MicroMsg.CdnTransportService", "cdnCallbackExecuteTimeReport onTimerExpired");
        b.b(b.this);
        AppMethodBeat.o(195216);
        return true;
      }
    }, true);
    this.appForegroundListener = new n.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(195219);
        ad.i("MicroMsg.CdnTransportService", "onAppBackground %s", new Object[] { paramAnonymousString });
        if (!b.aGC())
        {
          AppMethodBeat.o(195219);
          return;
        }
        b.a(b.this, false);
        b.d(b.this).stopTimer();
        com.tencent.e.h.LTJ.aR(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(195217);
            ad.i("MicroMsg.CdnTransportService", "appForegroundListener onAppBackground");
            b.b(b.this);
            Iterator localIterator = b.c(b.this).entrySet().iterator();
            if (localIterator.hasNext())
            {
              Object localObject = (Map.Entry)localIterator.next();
              localObject = (b.a)b.c(b.this).remove(((Map.Entry)localObject).getKey());
              if (localObject != null) {}
              for (localObject = ((b.a)localObject).toString();; localObject = "null")
              {
                ad.i("MicroMsg.CdnTransportService", "remove %s", new Object[] { localObject });
                break;
              }
            }
            AppMethodBeat.o(195217);
          }
        });
        AppMethodBeat.o(195219);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(195218);
        ad.i("MicroMsg.CdnTransportService", "onAppForeground %s", new Object[] { paramAnonymousString });
        if (!b.aGC())
        {
          AppMethodBeat.o(195218);
          return;
        }
        b.a(b.this, true);
        b.c(b.this).clear();
        b.d(b.this).az(60000L, 60000L);
        AppMethodBeat.o(195218);
      }
    };
    this.hTG = new ConcurrentHashMap();
    this.hTH = com.tencent.mm.aq.a.isActive();
    this.hTI = new LinkedList();
    this.hTJ = new HashMap();
    this.hTK = new ConcurrentHashMap();
    this.hTL = new HashMap();
    this.hTM = "";
    this.hTN = 0L;
    this.hTO = new HashSet();
    com.tencent.mm.kernel.g.ajB().a(this.hTD);
    if (com.tencent.mm.kernel.g.ajA().aiK()) {
      com.tencent.mm.kernel.g.ajC().ajl().a(this);
    }
    com.tencent.mm.kernel.g.aiU().a(379, this);
    com.tencent.mm.sdk.b.a.IbL.c(this.hTC);
    if (aGC())
    {
      this.appForegroundListener.alive();
      this.hTF.az(60000L, 60000L);
    }
    ad.i("MicroMsg.CdnTransportService", "summersafecdn CdnTransportService init[%s] stack[%s]", new Object[] { Integer.valueOf(hashCode()), bt.flS() });
    AppMethodBeat.o(150406);
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(195228);
    if (parama == null)
    {
      AppMethodBeat.o(195228);
      return;
    }
    long l = parama.endTime - parama.startTime;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(x(5, l));
    int k = 10;
    int i = hTP.length - 1;
    for (;;)
    {
      int j = k;
      if (i >= 0)
      {
        if (l >= hTP[i]) {
          j = hTQ[i];
        }
      }
      else
      {
        localArrayList.add(x(j, 1L));
        localArrayList.add(x(0, 1L));
        com.tencent.mm.plugin.report.e.ygI.b(localArrayList, false);
        ad.i("MicroMsg.CdnTransportService", "reportCDNCallbackTime(%s) taskName:%s cdnCallbackReportId:%s mediaId:%s duration:%s(%s-%s)", new Object[] { Long.valueOf(parama.threadId), parama.fJi, bt.bI(parama.hTZ, ""), bt.bI(parama.field_mediaId, ""), Long.valueOf(l), Long.valueOf(parama.startTime), Long.valueOf(parama.endTime) });
        AppMethodBeat.o(195228);
        return;
      }
      i -= 1;
    }
  }
  
  public static boolean aGC()
  {
    AppMethodBeat.i(195230);
    String str = com.tencent.mm.plugin.expt.h.d.crP().b("clicfg_cdn_callback_consume_time_statistics_switch", "1", false, true);
    ad.d("MicroMsg.CdnTransportService", "canCDNCallbackStatistics() sw:%s", new Object[] { str });
    boolean bool = bt.lQ(str, "1");
    AppMethodBeat.o(195230);
    return bool;
  }
  
  private static int aGD()
  {
    AppMethodBeat.i(195231);
    if (hTR == -1)
    {
      String str = com.tencent.mm.plugin.expt.h.d.crP().b("clicfg_cdn_callback_tag_max_num", "1", false, true);
      ad.d("MicroMsg.CdnTransportService", "getTagMaxNum() maxNum:%s", new Object[] { str });
      hTR = bt.getInt(str, 1);
    }
    int i = hTR;
    AppMethodBeat.o(195231);
    return i;
  }
  
  private String g(com.tencent.mm.i.g paramg)
  {
    AppMethodBeat.i(195227);
    if ((paramg == null) || (bt.isNullOrNil(paramg.fJi)))
    {
      AppMethodBeat.o(195227);
      return "MicroMsg.CdnTransportService";
    }
    if (this.hTG.containsKey(paramg.fJi))
    {
      paramg = (String)this.hTG.get(paramg.fJi);
      AppMethodBeat.o(195227);
      return paramg;
    }
    String str = "MicroMsg.CdnTransportService_" + (this.hTG.size() + 1) % aGD();
    this.hTG.put(paramg.fJi, str);
    ad.i("MicroMsg.CdnTransportService", "taskName:%s tag:%s", new Object[] { bt.bI(paramg.fJi, ""), bt.bI(str, "") });
    AppMethodBeat.o(195227);
    return str;
  }
  
  public static boolean pa(int paramInt)
  {
    AppMethodBeat.i(150405);
    com.tencent.mm.kernel.g.ajA();
    if (com.tencent.mm.kernel.a.aiJ())
    {
      int k = bt.a((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(144385, null), 0);
      int i = com.tencent.mm.n.g.acA().getInt("CDNGrayscaleBitMask", 0);
      int j = com.tencent.mm.n.g.acA().getInt("CDNGrayscaleBitVal", 0);
      k = k & (i ^ 0xFFFFFFFF) | j & i;
      ad.d("MicroMsg.CdnTransportService", "summersafecdn cdntra cdnBitSet:%d grayScaleFlag:%d res:%d Test.forceCDNTrans:%b, CDNGrayscaleBitMask:%d, CDNGrayscaleBitVal:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt), Integer.valueOf(k & paramInt), Boolean.valueOf(ac.iOH), Integer.valueOf(i), Integer.valueOf(j) });
      if (ac.iOH)
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
    AppMethodBeat.i(195229);
    IDKey localIDKey = new IDKey();
    localIDKey.SetID(1452);
    localIDKey.SetKey(paramInt);
    localIDKey.SetValue(paramLong);
    AppMethodBeat.o(195229);
    return localIDKey;
  }
  
  public final boolean EP(String paramString)
  {
    AppMethodBeat.i(150410);
    com.tencent.mm.i.g localg = (com.tencent.mm.i.g)this.hTK.remove(paramString);
    if (localg != null)
    {
      f.aGJ();
      a.EH(paramString);
      com.tencent.mm.plugin.report.service.g.yhR.f(10769, new Object[] { Integer.valueOf(c.hUm), Integer.valueOf(localg.field_fileType), Long.valueOf(bt.flT() - localg.field_startTime) });
    }
    this.hTJ.remove(paramString);
    ad.i("MicroMsg.CdnTransportService", "summersafecdn cdntra cancelSendTask mediaid:%s mapremove:%s engine ret:%d", new Object[] { paramString, localg, Integer.valueOf(0) });
    AppMethodBeat.o(150410);
    return true;
  }
  
  public final boolean EQ(String paramString)
  {
    AppMethodBeat.i(150411);
    com.tencent.mm.i.g localg = (com.tencent.mm.i.g)this.hTK.remove(paramString);
    if (localg != null)
    {
      if ((localg.field_fileType != com.tencent.mm.i.a.fIK) && (localg.field_fileType != com.tencent.mm.i.a.fIM)) {
        break label157;
      }
      f.aGJ();
      a.EM(paramString);
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.g.yhR.f(10769, new Object[] { Integer.valueOf(c.hUl), Integer.valueOf(localg.field_fileType), Long.valueOf(bt.flT() - localg.field_startTime) });
      this.hTJ.remove(paramString);
      this.hTL.remove(paramString);
      ad.i("MicroMsg.CdnTransportService", "summersafecdn cdntra cancelRecvTask mediaid:%s mapremove:%s engine ret:%d", new Object[] { paramString, localg, Integer.valueOf(0) });
      AppMethodBeat.o(150411);
      return true;
      label157:
      if (localg.fJs)
      {
        f.aGJ();
        a.EN(paramString);
      }
      else
      {
        f.aGJ();
        a.EI(paramString);
      }
    }
  }
  
  public final int a(final String paramString, final com.tencent.mm.i.c paramc, final com.tencent.mm.i.d paramd)
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
    this.hTN = bt.flT();
    this.hTM = paramString;
    com.tencent.e.h.LTJ.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(195221);
        Object localObject = (com.tencent.mm.i.g)b.h(b.this).get(paramString);
        if (localObject == null)
        {
          ad.d("MicroMsg.CdnTransportService", " task in jni get info failed mediaid[%s] hash[%s]", new Object[] { paramString, Integer.valueOf(b.this.hashCode()) });
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(594L, 7L, 1L, true);
          AppMethodBeat.o(195221);
          return;
        }
        b.a locala = b.a(b.this, (com.tencent.mm.i.g)localObject);
        if (paramc != null)
        {
          paramc.mediaId = paramString;
          ad.i("MicroMsg.CdnTransportService", "MTL: total:%d, cur:%d, mtl:%b", new Object[] { Long.valueOf(paramc.field_toltalLength), Long.valueOf(paramc.field_finishedLength), Boolean.valueOf(paramc.field_mtlnotify) });
        }
        if (paramd != null) {
          paramd.mediaId = paramString;
        }
        if (((com.tencent.mm.i.g)localObject).fJj != null)
        {
          long l = bt.flT();
          if ((paramd == null) && (paramc != null) && (!paramc.field_mtlnotify) && (ay.getNetWorkType(aj.getContext()) == -1))
          {
            b.a(b.this, locala);
            AppMethodBeat.o(195221);
            return;
          }
          ((com.tencent.mm.i.g)localObject).field_lastProgressCallbackTime = l;
          ((com.tencent.mm.i.g)localObject).fJj.a(paramString, 0, paramc, paramd, ((com.tencent.mm.i.g)localObject).field_onlycheckexist);
        }
        if ((localObject instanceof com.tencent.mm.i.f)) {}
        for (localObject = (com.tencent.mm.i.f)localObject;; localObject = null)
        {
          if ((b.a(paramc)) && ((localObject == null) || (((com.tencent.mm.i.f)localObject).XQ()))) {
            b.e(b.this).remove(paramString);
          }
          if (paramd != null)
          {
            if ((localObject == null) || (((com.tencent.mm.i.f)localObject).XQ())) {
              b.h(b.this).remove(paramString);
            }
            if (paramd.field_retCode == -5103011)
            {
              ad.i("MicroMsg.CdnTransportService", "summersafecdn ERR_VALIDATE_AUTHKEY");
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(546L, 4L, 1L, true);
              f.aGJ().keep_OnRequestDoGetCdnDnsInfo(999);
            }
          }
          b.b(b.this, locala);
          AppMethodBeat.o(195221);
          return;
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(195222);
        String str = super.toString() + "|callback";
        AppMethodBeat.o(195222);
        return str;
      }
    }, g((com.tencent.mm.i.g)this.hTK.get(paramString)));
    AppMethodBeat.o(150414);
    return 0;
  }
  
  public final int a(final String paramString, final com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(195226);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(195226);
      return 0;
    }
    com.tencent.e.h.LTJ.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(195215);
        com.tencent.mm.i.g localg = (com.tencent.mm.i.g)b.h(b.this).get(paramString);
        if (localg == null)
        {
          ad.d("MicroMsg.CdnTransportService", " task in jni get info failed mediaid:%s", new Object[] { paramString });
          AppMethodBeat.o(195215);
          return;
        }
        if (localg.fJB != null) {
          localg.fJB.b(paramString, paramd);
        }
        AppMethodBeat.o(195215);
      }
    }, g((com.tencent.mm.i.g)this.hTK.get(paramString)));
    AppMethodBeat.o(195226);
    return 0;
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(150403);
    if (!com.tencent.mm.kernel.g.ajA().aiK())
    {
      AppMethodBeat.o(150403);
      return;
    }
    int i = bt.m(paramObject, 0);
    ad.d("MicroMsg.CdnTransportService", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    if ((paramn != com.tencent.mm.kernel.g.ajC().ajl()) || (i <= 0))
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
    f.aGF().pc(10);
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
    com.tencent.mm.i.g localg = (com.tencent.mm.i.g)this.hTK.get(paramString);
    if (localg == null)
    {
      ad.e("MicroMsg.CdnTransportService", " getauthbuf task in jni get info failed mediaid:%s", new Object[] { paramString });
      AppMethodBeat.o(150415);
      return;
    }
    if (localg.fJj != null)
    {
      localg.fJj.a(paramString, paramByteArrayOutputStream);
      AppMethodBeat.o(150415);
      return;
    }
    ad.e("MicroMsg.CdnTransportService", "getCdnAuthInfo fail, null taskcallback.");
    AppMethodBeat.o(150415);
  }
  
  public final void aGB()
  {
    AppMethodBeat.i(150413);
    com.tencent.mm.kernel.g.ajA();
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
    if (com.tencent.mm.kernel.a.aiJ())
    {
      localConfig = new CdnLogic.Config();
      str1 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getValue("EnableCDNUploadImg");
      str2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getValue("EnableCDNVerifyConnect");
      str3 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getValue("EnableCDNVideoRedirectOC");
      str4 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getValue("EnableStreamUploadVideo");
      str5 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getValue("C2COverloadDelaySeconds");
      str6 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getValue("SNSOverloadDelaySeconds");
      str7 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getValue("EnableSnsStreamDownload");
      str8 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getValue("EnableSnsImageDownload");
      str9 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getValue("ApprovedVideoPrivateProtocolHosts");
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
        f.aGI();
        if (!pa(256)) {
          continue;
        }
        i = 1;
        localConfig.EnableSafeCDN = i;
        localConfig.SupportQuicVersionMax = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qCg, 1);
        localConfig.EnableC2CVideoQUIC = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qCh, 0);
        localConfig.EnableUserVideoQUIC = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qCi, 0);
        localConfig.EnableBandVideoQUIC = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qCj, 0);
        localConfig.EnableStatusVideoQUIC = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qCk, 0);
        localConfig.EnableSnsVideoRedirect = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qCl, 0);
        ad.i("MicroMsg.CdnTransportService", "[quic.config] ver %d c2c %d user %d band %d status %d", new Object[] { Integer.valueOf(localConfig.SupportQuicVersionMax), Integer.valueOf(localConfig.EnableC2CVideoQUIC), Integer.valueOf(localConfig.EnableUserVideoQUIC), Integer.valueOf(localConfig.EnableBandVideoQUIC), Integer.valueOf(localConfig.EnableStatusVideoQUIC) });
        if (localConfig.UseStreamCDN != 0)
        {
          str1 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getValue("ProgJPEGUploadSizeLimitWifi");
          str2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getValue("ProgJPEGUploadSizeLimit3G");
          str3 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getValue("ProgJPEGDownloadSizeLimit");
          str4 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getValue("ProgJPEGOnlyRecvPTL");
          str5 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getValue("EnableJPEGDyncmicETL");
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
        if (this.hTA != -1)
        {
          ad.w("MicroMsg.CdnTransportService", "cmd set snsimage flag: %d", new Object[] { Integer.valueOf(this.hTA) });
          localConfig.EnableSnsImageDownload = this.hTA;
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
      if (ac.iPg)
      {
        ad.w("MicroMsg.CdnTransportService", "use cdn debug configure.");
        localConfig.UseStreamCDN = 1;
        localConfig.EnableSnsVideoRedirect = ac.iPm;
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
    paramg.dNR = false;
    com.tencent.e.h.LTJ.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150400);
        if (paramInt != -1) {
          b.e(b.this).put(paramg.field_mediaId, Integer.valueOf(paramInt));
        }
        ad.i("MicroMsg.CdnTransportService", "CdnTransportService cdn thread run %s", new Object[] { paramg.field_mediaId });
        b.f(b.this).add(paramg.field_mediaId);
        b.g(b.this).put(paramg.field_mediaId, paramg);
        b.this.eL(false);
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
    AppMethodBeat.i(195225);
    if (paramg == null)
    {
      ad.e("MicroMsg.CdnTransportService", "addRecvTask task info is null");
      AppMethodBeat.o(195225);
      return false;
    }
    if (bt.isNullOrNil(paramg.field_mediaId))
    {
      ad.e("MicroMsg.CdnTransportService", "addRecvTask mediaId is null");
      AppMethodBeat.o(195225);
      return false;
    }
    if (paramg.field_fileId == null) {
      paramg.field_fileId = "";
    }
    if (paramg.field_aesKey == null) {
      paramg.field_aesKey = "";
    }
    paramg.dNR = false;
    ad.i("MicroMsg.CdnTransportService", "CdnTransportService cdn thread run %s", new Object[] { paramg.field_mediaId });
    this.hTI.add(paramg.field_mediaId);
    this.hTJ.put(paramg.field_mediaId, paramg);
    eL(false);
    AppMethodBeat.o(195225);
    return true;
  }
  
  public final boolean e(com.tencent.mm.i.g paramg)
  {
    AppMethodBeat.i(150408);
    boolean bool = b(paramg, -1);
    AppMethodBeat.o(150408);
    return bool;
  }
  
  public final void eL(boolean paramBoolean)
  {
    AppMethodBeat.i(150412);
    if ((!paramBoolean) && (f.aGJ().aGA()))
    {
      com.tencent.mm.kernel.g.ajA();
      if (com.tencent.mm.kernel.a.aiJ())
      {
        ad.w("MicroMsg.CdnTransportService", "summersafecdn cdntra Not init cdn dnsinfo , will retry after set info");
        f.aGF().pc(4);
        AppMethodBeat.o(150412);
        return;
      }
    }
    aGB();
    ad.i("MicroMsg.CdnTransportService", "summersafecdn tryStart queue:%d", new Object[] { Integer.valueOf(this.hTI.size()) });
    Object localObject1;
    Object localObject3;
    label216:
    int j;
    label226:
    Object localObject2;
    if (!this.hTI.isEmpty())
    {
      localObject1 = (String)this.hTI.poll();
      localObject3 = (com.tencent.mm.i.g)this.hTJ.remove(localObject1);
      if (localObject3 == null)
      {
        ad.e("MicroMsg.CdnTransportService", "summersafecdn task queue is empty , maybe bug here");
        AppMethodBeat.o(150412);
        return;
      }
      ad.i("MicroMsg.CdnTransportService", "summersafecdn id:%s cdnautostart :%s chatroom:%s", new Object[] { ((com.tencent.mm.i.g)localObject3).field_mediaId, Boolean.valueOf(((com.tencent.mm.i.g)localObject3).field_autostart), Integer.valueOf(((com.tencent.mm.i.g)localObject3).field_chattype) });
      ((com.tencent.mm.i.g)localObject3).field_startTime = bt.flT();
      if (((com.tencent.mm.i.g)localObject3).dNR)
      {
        String str;
        if (((com.tencent.mm.i.g)localObject3).field_fullpath == null)
        {
          i = -1;
          if (((com.tencent.mm.i.g)localObject3).field_thumbpath != null) {
            break label623;
          }
          j = -1;
          ad.i("MicroMsg.CdnTransportService", "summersafecdn tryStart send file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b] largesvideo[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), bt.aRp(((com.tencent.mm.i.g)localObject3).field_svr_signature), bt.aRp(((com.tencent.mm.i.g)localObject3).field_aesKey), Integer.valueOf(((com.tencent.mm.i.g)localObject3).field_fileType), ((com.tencent.mm.i.g)localObject3).field_mediaId, Boolean.valueOf(((com.tencent.mm.i.g)localObject3).field_onlycheckexist), Integer.valueOf(((com.tencent.mm.i.g)localObject3).field_largesvideo) });
          if (((com.tencent.mm.i.g)localObject3).field_fullpath == null) {
            ((com.tencent.mm.i.g)localObject3).field_fullpath = "";
          }
          if (((com.tencent.mm.i.g)localObject3).field_thumbpath == null) {
            ((com.tencent.mm.i.g)localObject3).field_thumbpath = "";
          }
          localObject1 = (com.tencent.mm.i.g)this.hTK.put(((com.tencent.mm.i.g)localObject3).field_mediaId, localObject3);
          localObject2 = (com.tencent.mm.i.g)this.hTK.get(((com.tencent.mm.i.g)localObject3).field_mediaId);
          if (localObject2 == null) {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(594L, 5L, 1L, true);
          }
          i = f.aGJ().b((com.tencent.mm.i.g)localObject3);
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
          ad.i("MicroMsg.CdnTransportService", "summersafecdn startupUploadMedia ok, field_mediaId[%s] ret[%s, %s, %s] hash[%s]", new Object[] { str, Integer.valueOf(i), localObject1, localObject2, Integer.valueOf(hashCode()) });
          if (i == 0) {
            break;
          }
          ad.e("MicroMsg.CdnTransportService", "summersafecdn startupUploadMedia error:%d clientid:%s", new Object[] { Integer.valueOf(i), ((com.tencent.mm.i.g)localObject3).field_mediaId });
          if (-21005 != i)
          {
            localObject1 = (com.tencent.mm.i.g)this.hTK.remove(((com.tencent.mm.i.g)localObject3).field_mediaId);
            ad.e("MicroMsg.CdnTransportService", "summersafecdn startupUploadMedia error:%d clientid:%s remove[%s]", new Object[] { Integer.valueOf(i), ((com.tencent.mm.i.g)localObject3).field_mediaId, localObject1 });
          }
          if (((com.tencent.mm.i.g)localObject3).fJj == null) {
            break;
          }
          ((com.tencent.mm.i.g)localObject3).fJj.a(((com.tencent.mm.i.g)localObject3).field_mediaId, i, null, null, ((com.tencent.mm.i.g)localObject3).field_onlycheckexist);
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
        i = f.aGJ().a(((com.tencent.mm.i.g)localObject3).field_mediaId, ((com.tencent.mm.i.g)localObject3).fJm, ((com.tencent.mm.i.g)localObject3).field_fullpath, ((com.tencent.mm.i.g)localObject3).field_fileType, ((com.tencent.mm.i.g)localObject3).field_aesKey, ((com.tencent.mm.i.g)localObject3).field_authKey);
      }
      for (;;)
      {
        label705:
        if (i != 0)
        {
          ad.e("MicroMsg.CdnTransportService", "summersafecdn startupDownloadMedia error:%d clientid:%s", new Object[] { Integer.valueOf(i), ((com.tencent.mm.i.g)localObject3).field_mediaId });
          if (((com.tencent.mm.i.g)localObject3).fJj == null) {
            break;
          }
          ((com.tencent.mm.i.g)localObject3).fJj.a(((com.tencent.mm.i.g)localObject3).field_mediaId, i, null, null, ((com.tencent.mm.i.g)localObject3).field_onlycheckexist);
          break;
          if (((com.tencent.mm.i.g)localObject3).field_fileType == 19) {
            i = f.aGJ().a(((com.tencent.mm.i.g)localObject3).field_mediaId, ((com.tencent.mm.i.g)localObject3).fJm, ((com.tencent.mm.i.g)localObject3).field_fullpath, ((com.tencent.mm.i.g)localObject3).field_fileType, ((com.tencent.mm.i.g)localObject3).field_aesKey, ((com.tencent.mm.i.g)localObject3).field_authKey);
          } else if ((((com.tencent.mm.i.g)localObject3).field_fileType == com.tencent.mm.i.a.fIK) || (((com.tencent.mm.i.g)localObject3).field_fileType == com.tencent.mm.i.a.fIM)) {
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
    for (int i = f.aGJ().a(((com.tencent.mm.i.g)localObject3).field_mediaId, ((com.tencent.mm.i.g)localObject3).fJm, ((com.tencent.mm.i.g)localObject3).field_fullpath, ((com.tencent.mm.i.g)localObject3).field_fileType, ((com.tencent.mm.i.g)localObject3).fJn, ((com.tencent.mm.i.g)localObject3).fJo, ((com.tencent.mm.i.g)localObject3).fJp, ((com.tencent.mm.i.g)localObject3).fJq, ((com.tencent.mm.i.g)localObject3).fJx, ((com.tencent.mm.i.g)localObject3).fJy);; i = -1)
    {
      if (((com.tencent.mm.i.g)localObject3).field_fullpath == null) {}
      for (j = -1;; j = ((com.tencent.mm.i.g)localObject3).field_fullpath.length())
      {
        ad.i("MicroMsg.CdnTransportService", "url download tryStart recv file:%d field_mediaId[%s], download_url[%s], filetype:[%d]", new Object[] { Integer.valueOf(j), ((com.tencent.mm.i.g)localObject3).field_mediaId, ((com.tencent.mm.i.g)localObject3).fJm, Integer.valueOf(((com.tencent.mm.i.g)localObject3).field_fileType) });
        break;
      }
      if (((com.tencent.mm.i.g)localObject3).fJs)
      {
        i = j;
        if (((com.tencent.mm.i.g)localObject3).field_fullpath != null)
        {
          i = j;
          if (!((com.tencent.mm.i.g)localObject3).field_fullpath.isEmpty()) {
            i = f.aGJ().a(((com.tencent.mm.i.g)localObject3).field_mediaId, ((com.tencent.mm.i.g)localObject3).field_fullpath, ((com.tencent.mm.i.g)localObject3).fJm, ((com.tencent.mm.i.g)localObject3).fJt, ((com.tencent.mm.i.g)localObject3).fJu, ((com.tencent.mm.i.g)localObject3).allow_mobile_net_download, ((com.tencent.mm.i.g)localObject3).fJn, ((com.tencent.mm.i.g)localObject3).fJo, ((com.tencent.mm.i.g)localObject3).is_resume_task, ((com.tencent.mm.i.g)localObject3).fJr, ((com.tencent.mm.i.g)localObject3).fJp);
          }
        }
        if (((com.tencent.mm.i.g)localObject3).field_fullpath == null) {}
        for (j = -1;; j = ((com.tencent.mm.i.g)localObject3).field_fullpath.length())
        {
          ad.i("MicroMsg.CdnTransportService", "game package download tryStart recv file:%d field_mediaId[%s], download_url[%s] https url[%s]", new Object[] { Integer.valueOf(j), ((com.tencent.mm.i.g)localObject3).field_mediaId, ((com.tencent.mm.i.g)localObject3).fJm, ((com.tencent.mm.i.g)localObject3).fJt });
          break;
        }
      }
      if (((com.tencent.mm.i.g)localObject3).fJv)
      {
        if ((localObject3 instanceof com.tencent.mm.i.f))
        {
          localObject1 = (com.tencent.mm.i.f)localObject3;
          i = f.aGJ().a((com.tencent.mm.i.f)localObject1);
          break label705;
        }
        if (!(localObject3 instanceof com.tencent.mm.i.e)) {
          break label2009;
        }
        localObject1 = (com.tencent.mm.i.e)localObject3;
        i = f.aGJ().a(((com.tencent.mm.i.e)localObject1).field_mediaId, ((com.tencent.mm.i.e)localObject1).url, ((com.tencent.mm.i.e)localObject1).referer, ((com.tencent.mm.i.e)localObject1).fIZ, ((com.tencent.mm.i.e)localObject1).fJa, ((com.tencent.mm.i.e)localObject1).fJb, ((com.tencent.mm.i.e)localObject1).fJc, ((com.tencent.mm.i.e)localObject1).fJd, ((com.tencent.mm.i.e)localObject1).isColdSnsData, ((com.tencent.mm.i.e)localObject1).signalQuality, ((com.tencent.mm.i.e)localObject1).snsScene, ((com.tencent.mm.i.e)localObject1).snsCipherKey, ((com.tencent.mm.i.e)localObject1).ePC, ((com.tencent.mm.i.e)localObject1).appType, ((com.tencent.mm.i.e)localObject1).fileType);
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
        ad.i("MicroMsg.CdnTransportService", "summersafecdn tryStart recv file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b]", new Object[] { Integer.valueOf(i), Integer.valueOf(k), ((com.tencent.mm.i.g)localObject3).field_svr_signature, ((com.tencent.mm.i.g)localObject3).field_aesKey, Integer.valueOf(((com.tencent.mm.i.g)localObject3).field_fileType), ((com.tencent.mm.i.g)localObject3).field_mediaId, Boolean.valueOf(((com.tencent.mm.i.g)localObject3).field_onlycheckexist) });
        if (((com.tencent.mm.i.g)localObject3).fJz != 2) {
          break label1840;
        }
        if (!(localObject3 instanceof com.tencent.mm.i.h)) {
          break label2009;
        }
        localObject1 = (com.tencent.mm.i.h)localObject3;
        if (!((com.tencent.mm.i.h)localObject1).XT()) {
          break label1456;
        }
        i = f.aGJ().a((com.tencent.mm.i.g)localObject3, 2);
        break;
        i = ((com.tencent.mm.i.g)localObject3).field_fullpath.length();
        break label1299;
      }
      if (((com.tencent.mm.i.h)localObject1).XR())
      {
        i = f.aGJ().a(((com.tencent.mm.i.h)localObject1).field_mediaId, ((com.tencent.mm.i.h)localObject1).url, ((com.tencent.mm.i.h)localObject1).referer, ((com.tencent.mm.i.h)localObject1).field_fullpath, ((com.tencent.mm.i.h)localObject1).fJF, ((com.tencent.mm.i.h)localObject1).fJa, ((com.tencent.mm.i.h)localObject1).isColdSnsData, ((com.tencent.mm.i.h)localObject1).signalQuality, ((com.tencent.mm.i.h)localObject1).snsScene, ((com.tencent.mm.i.h)localObject1).field_preloadRatio, ((com.tencent.mm.i.h)localObject1).preloadMinSize, ((com.tencent.mm.i.h)localObject1).field_requestVideoFormat, 1, 1);
        break label705;
      }
      if (((com.tencent.mm.i.h)localObject1).XS())
      {
        i = f.aGJ().a(((com.tencent.mm.i.h)localObject1).field_mediaId, ((com.tencent.mm.i.h)localObject1).url, ((com.tencent.mm.i.h)localObject1).referer, ((com.tencent.mm.i.h)localObject1).field_fullpath, ((com.tencent.mm.i.h)localObject1).fJF, ((com.tencent.mm.i.h)localObject1).field_preloadRatio, ((com.tencent.mm.i.h)localObject1).preloadMinSize, ((com.tencent.mm.i.h)localObject1).concurrentCount);
        break label705;
      }
      if (((com.tencent.mm.i.h)localObject1).XV())
      {
        i = f.aGJ().a(((com.tencent.mm.i.h)localObject1).field_mediaId, ((com.tencent.mm.i.h)localObject1).url, ((com.tencent.mm.i.h)localObject1).referer, ((com.tencent.mm.i.h)localObject1).field_fullpath, ((com.tencent.mm.i.h)localObject1).fJF, ((com.tencent.mm.i.h)localObject1).fJa, ((com.tencent.mm.i.h)localObject1).isColdSnsData, ((com.tencent.mm.i.h)localObject1).signalQuality, ((com.tencent.mm.i.h)localObject1).snsScene, ((com.tencent.mm.i.h)localObject1).field_preloadRatio, ((com.tencent.mm.i.h)localObject1).preloadMinSize, ((com.tencent.mm.i.h)localObject1).field_requestVideoFormat, ((com.tencent.mm.i.h)localObject1).connectionCount);
        break label705;
      }
      if (((com.tencent.mm.i.h)localObject1).XX())
      {
        i = f.aGJ().a(((com.tencent.mm.i.h)localObject1).field_mediaId, ((com.tencent.mm.i.h)localObject1).url, ((com.tencent.mm.i.h)localObject1).referer, ((com.tencent.mm.i.h)localObject1).field_fullpath, ((com.tencent.mm.i.h)localObject1).fJF, ((com.tencent.mm.i.h)localObject1).field_preloadRatio, ((com.tencent.mm.i.h)localObject1).preloadMinSize, ((com.tencent.mm.i.h)localObject1).concurrentCount);
        break label705;
      }
      i = j;
      if (((com.tencent.mm.i.h)localObject1).XW()) {
        i = f.aGJ().a(((com.tencent.mm.i.h)localObject1).field_mediaId, ((com.tencent.mm.i.h)localObject1).url, ((com.tencent.mm.i.h)localObject1).referer, ((com.tencent.mm.i.h)localObject1).field_fullpath, ((com.tencent.mm.i.h)localObject1).fJF, ((com.tencent.mm.i.h)localObject1).fJa, ((com.tencent.mm.i.h)localObject1).isColdSnsData, ((com.tencent.mm.i.h)localObject1).signalQuality, ((com.tencent.mm.i.h)localObject1).snsScene, ((com.tencent.mm.i.h)localObject1).field_preloadRatio, ((com.tencent.mm.i.h)localObject1).preloadMinSize, ((com.tencent.mm.i.h)localObject1).field_requestVideoFormat, ((com.tencent.mm.i.h)localObject1).connectionCount, ((com.tencent.mm.i.h)localObject1).fJM, ((com.tencent.mm.i.h)localObject1).videoFlag, ((com.tencent.mm.i.h)localObject1).snsCipherKey, ((com.tencent.mm.i.h)localObject1).concurrentCount);
      }
      break label705;
      i = f.aGJ().c((com.tencent.mm.i.g)localObject3);
      break label705;
      localObject1 = (com.tencent.mm.i.g)this.hTK.put(((com.tencent.mm.i.g)localObject3).field_mediaId, localObject3);
      localObject2 = (com.tencent.mm.i.g)this.hTK.get(((com.tencent.mm.i.g)localObject3).field_mediaId);
      if (localObject2 == null) {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(594L, 6L, 1L, true);
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
        ad.i("MicroMsg.CdnTransportService", "summersafecdn startupDownloadMedia ok, field_mediaId[%s] ret[%s, %s, %s] hash[%s]", new Object[] { localObject3, Integer.valueOf(i), localObject1, localObject2, Integer.valueOf(hashCode()) });
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
    paramg.dNR = true;
    com.tencent.e.h.LTJ.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150402);
        b.f(b.this).add(paramg.field_mediaId);
        b.g(b.this).put(paramg.field_mediaId, paramg);
        b.this.eL(false);
        AppMethodBeat.o(150402);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(195220);
        String str = super.toString() + "|addSendTask";
        AppMethodBeat.o(195220);
        return str;
      }
    }, "MicroMsg.Cdn.ThreadName");
    AppMethodBeat.o(150409);
    return true;
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
    com.tencent.mm.i.g localg = (com.tencent.mm.i.g)this.hTK.get(paramString);
    if (localg == null)
    {
      ad.e("MicroMsg.CdnTransportService", " decodePrepareResponse task in jni get info failed mediaid:%s", new Object[] { paramString });
      AppMethodBeat.o(150416);
      return null;
    }
    if (localg.fJj != null)
    {
      paramString = localg.fJj.f(paramString, paramArrayOfByte);
      AppMethodBeat.o(150416);
      return paramString;
    }
    ad.e("MicroMsg.CdnTransportService", "decodePrepareResponse fail, null taskcallback.");
    AppMethodBeat.o(150416);
    return null;
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
    if (com.tencent.mm.kernel.g.ajA().aiK()) {
      com.tencent.e.h.LTJ.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(150398);
          b.this.eL(true);
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
  
  public final void pb(int paramInt)
  {
    this.hTA = paramInt;
  }
  
  static final class a
  {
    public boolean dNR;
    public int dPA;
    public int dPB;
    public int dPr;
    public int dPs;
    public int dPt;
    public int dPu;
    public int dPv;
    public int dPw;
    public int dPx;
    public int dPy;
    public String dPz;
    public long endTime;
    public String fJi;
    public String field_mediaId;
    public int field_totalLen;
    public String hTZ;
    public long hUa;
    public long startTime;
    public long threadId;
    
    public a(String paramString1, String paramString2, String paramString3, long paramLong, com.tencent.mm.i.g paramg)
    {
      AppMethodBeat.i(195223);
      this.hTZ = "";
      this.fJi = "task_default";
      this.field_mediaId = "";
      this.field_totalLen = 0;
      this.startTime = 0L;
      this.endTime = -1L;
      this.threadId = 0L;
      this.dPr = 0;
      this.dPs = 0;
      this.dPt = 0;
      this.dPu = 0;
      this.dPv = 0;
      this.dPw = 0;
      this.dPx = 0;
      this.dPy = 0;
      this.dPz = "";
      this.dPA = 0;
      this.dPB = 0;
      this.hUa = 0L;
      this.hTZ = paramString1;
      this.fJi = paramString2;
      this.field_mediaId = paramString3;
      this.dNR = paramg.dNR;
      this.field_totalLen = paramg.field_totalLen;
      this.startTime = paramLong;
      this.threadId = Thread.currentThread().getId();
      this.dPr = paramg.field_fileType;
      this.dPs = paramg.field_appType;
      this.dPt = paramg.field_bzScene;
      this.dPu = paramg.ePC;
      this.dPv = paramg.field_chattype;
      this.dPw = paramg.field_advideoflag;
      this.dPx = paramg.field_largesvideo;
      this.dPy = paramg.field_requestVideoFormat;
      this.dPz = bt.bI(paramg.field_snsScene, "");
      if (paramg.fJv) {
        i = 1;
      }
      this.dPA = i;
      this.dPB = paramg.fJA;
      this.hUa = System.currentTimeMillis();
      AppMethodBeat.o(195223);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(195224);
      String str = "CdnTaskReportInfo{cdnCallbackReportId='" + this.hTZ + '\'' + ", taskName='" + this.fJi + '\'' + ", field_mediaId='" + this.field_mediaId + '\'' + ", isSend=" + this.dNR + ", field_totalLen=" + this.field_totalLen + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", threadId=" + this.threadId + ", _FileType=" + this.dPr + ", _AppType=" + this.dPs + ", _BzScene=" + this.dPt + ", _BizType=" + this.dPu + ", _Chattype=" + this.dPv + ", _Advideoflag=" + this.dPw + ", _Largesvideo=" + this.dPx + ", _RequestVideoFormat=" + this.dPy + ", _SnsScene='" + this.dPz + '\'' + ", _SnsImageDownload=" + this.dPA + ", _VideoTaskType=" + this.dPB + ", localTime=" + this.hUa + '}';
      AppMethodBeat.o(195224);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ao.b
 * JD-Core Version:    0.7.0.1
 */