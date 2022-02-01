package com.tencent.mm.modelcdntran;

import android.os.Looper;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.Config;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.app.q.a;
import com.tencent.mm.autogen.a.nz;
import com.tencent.mm.g.e;
import com.tencent.mm.g.g.b;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.aq;
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

public final class g
  implements com.tencent.mm.am.h, com.tencent.mm.g.b, com.tencent.mm.g.b.a, MStorageEx.IOnStorageChange
{
  private static final long[] oAw = { 0L, 2L, 5L, 7L, 10L, 15L, 20L, 30L, 50L, 70L, 100L, 200L, 400L, 600L, 800L, 1000L, 3000L, 5000L, 10000L, 20000L, 30000L, 40000L, 50000L, 60000L, 120000L };
  private static final int[] oAx = { 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34 };
  private static int oAy = -1;
  private static long oAz = -1L;
  public q.a appForegroundListener;
  private int oAh;
  MMHandler oAi;
  IListener<nz> oAj;
  com.tencent.mm.network.p oAk;
  private ConcurrentHashMap<String, a> oAl;
  final MTimerHandler oAm;
  ConcurrentHashMap<String, String> oAn;
  private boolean oAo;
  private Queue<String> oAp;
  public Map<String, com.tencent.mm.g.g> oAq;
  public Map<String, com.tencent.mm.g.g> oAr;
  public Map<String, Integer> oAs;
  private String oAt;
  private long oAu;
  public HashSet<String> oAv;
  
  public g()
  {
    AppMethodBeat.i(150406);
    this.oAh = -1;
    this.oAi = new g.1(this, Looper.getMainLooper());
    this.oAj = new CdnTransportService.2(this, com.tencent.mm.app.f.hfK);
    this.oAk = new g.3(this);
    this.oAl = new ConcurrentHashMap();
    this.oAm = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(237900);
        Log.i("MicroMsg.CdnTransportService", "cdnCallbackExecuteTimeReport onTimerExpired");
        g.b(g.this);
        AppMethodBeat.o(237900);
        return true;
      }
    }, true);
    this.appForegroundListener = new q.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(237904);
        Log.i("MicroMsg.CdnTransportService", "onAppBackground %s", new Object[] { paramAnonymousString });
        if (!g.bHN())
        {
          AppMethodBeat.o(237904);
          return;
        }
        g.a(g.this, false);
        g.d(g.this).stopTimer();
        com.tencent.threadpool.h.ahAA.bm(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(237815);
            Log.i("MicroMsg.CdnTransportService", "appForegroundListener onAppBackground");
            g.b(g.this);
            Iterator localIterator = g.c(g.this).entrySet().iterator();
            if (localIterator.hasNext())
            {
              Object localObject = (Map.Entry)localIterator.next();
              localObject = (g.a)g.c(g.this).remove(((Map.Entry)localObject).getKey());
              if (localObject != null) {}
              for (localObject = ((g.a)localObject).toString();; localObject = "null")
              {
                Log.i("MicroMsg.CdnTransportService", "remove %s", new Object[] { localObject });
                break;
              }
            }
            AppMethodBeat.o(237815);
          }
        });
        AppMethodBeat.o(237904);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(237899);
        Log.i("MicroMsg.CdnTransportService", "onAppForeground %s", new Object[] { paramAnonymousString });
        if (!g.bHN())
        {
          AppMethodBeat.o(237899);
          return;
        }
        g.a(g.this, true);
        g.c(g.this).clear();
        g.d(g.this).startTimer(60000L);
        AppMethodBeat.o(237899);
      }
    };
    this.oAn = new ConcurrentHashMap();
    this.oAo = com.tencent.mm.aq.a.isActive();
    this.oAp = new LinkedList();
    this.oAq = new HashMap();
    this.oAr = new ConcurrentHashMap();
    this.oAs = new HashMap();
    this.oAt = "";
    this.oAu = 0L;
    this.oAv = new HashSet();
    com.tencent.mm.kernel.h.baD().a(this.oAk);
    if (com.tencent.mm.kernel.h.baC().aZN()) {
      com.tencent.mm.kernel.h.baE().ban().add(this);
    }
    com.tencent.mm.kernel.h.aZW().a(379, this);
    this.oAj.alive();
    if (bHN())
    {
      this.appForegroundListener.alive();
      this.oAm.startTimer(60000L);
    }
    Log.i("MicroMsg.CdnTransportService", "summersafecdn CdnTransportService init[%s] stack[%s]", new Object[] { Integer.valueOf(hashCode()), Util.getStack() });
    AppMethodBeat.o(150406);
  }
  
  private static IDKey C(int paramInt, long paramLong)
  {
    AppMethodBeat.i(237880);
    IDKey localIDKey = new IDKey();
    localIDKey.SetID(1452);
    localIDKey.SetKey(paramInt);
    localIDKey.SetValue(paramLong);
    AppMethodBeat.o(237880);
    return localIDKey;
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(237875);
    if (parama == null)
    {
      AppMethodBeat.o(237875);
      return;
    }
    long l = parama.endTime - parama.startTime;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(C(5, l));
    int k = 10;
    int i = oAw.length - 1;
    for (;;)
    {
      int j = k;
      if (i >= 0)
      {
        if (l >= oAw[i]) {
          j = oAx[i];
        }
      }
      else
      {
        localArrayList.add(C(j, 1L));
        localArrayList.add(C(0, 1L));
        com.tencent.mm.plugin.report.f.Ozc.b(localArrayList, false);
        Log.i("MicroMsg.CdnTransportService", "reportCDNCallbackTime(%s) taskName:%s cdnCallbackReportId:%s mediaId:%s duration:%s(%s-%s)", new Object[] { Long.valueOf(parama.threadId), parama.taskName, Util.nullAs(parama.oAG, ""), Util.nullAs(parama.field_mediaId, ""), Long.valueOf(l), Long.valueOf(parama.startTime), Long.valueOf(parama.endTime) });
        AppMethodBeat.o(237875);
        return;
      }
      i -= 1;
    }
  }
  
  public static boolean bHN()
  {
    AppMethodBeat.i(237885);
    String str = com.tencent.mm.plugin.expt.e.d.dNI().a("clicfg_cdn_callback_consume_time_statistics_switch", "1", false, true);
    Log.d("MicroMsg.CdnTransportService", "canCDNCallbackStatistics() sw:%s", new Object[] { str });
    boolean bool = Util.isEqual(str, "1");
    AppMethodBeat.o(237885);
    return bool;
  }
  
  private static int bHO()
  {
    AppMethodBeat.i(237893);
    if (oAy == -1)
    {
      String str = com.tencent.mm.plugin.expt.e.d.dNI().a("clicfg_cdn_callback_tag_max_num", "1", false, true);
      Log.d("MicroMsg.CdnTransportService", "getTagMaxNum() maxNum:%s", new Object[] { str });
      oAy = Util.getInt(str, 1);
    }
    int i = oAy;
    AppMethodBeat.o(237893);
    return i;
  }
  
  private String h(com.tencent.mm.g.g paramg)
  {
    AppMethodBeat.i(237872);
    if ((paramg == null) || (Util.isNullOrNil(paramg.taskName)))
    {
      AppMethodBeat.o(237872);
      return "MicroMsg.CdnTransportService";
    }
    if (this.oAn.containsKey(paramg.taskName))
    {
      paramg = (String)this.oAn.get(paramg.taskName);
      AppMethodBeat.o(237872);
      return paramg;
    }
    String str = "MicroMsg.CdnTransportService_" + (this.oAn.size() + 1) % bHO();
    this.oAn.put(paramg.taskName, str);
    Log.i("MicroMsg.CdnTransportService", "taskName:%s tag:%s", new Object[] { Util.nullAs(paramg.taskName, ""), Util.nullAs(str, "") });
    AppMethodBeat.o(237872);
    return str;
  }
  
  public static boolean vV(int paramInt)
  {
    AppMethodBeat.i(150405);
    com.tencent.mm.kernel.h.baC();
    if (com.tencent.mm.kernel.b.aZM())
    {
      int k = Util.nullAs((Integer)com.tencent.mm.kernel.h.baE().ban().d(144385, null), 0);
      int i = com.tencent.mm.k.i.aRC().getInt("CDNGrayscaleBitMask", 0);
      int j = com.tencent.mm.k.i.aRC().getInt("CDNGrayscaleBitVal", 0);
      k = k & (i ^ 0xFFFFFFFF) | j & i;
      Log.d("MicroMsg.CdnTransportService", "summersafecdn cdntra cdnBitSet:%d grayScaleFlag:%d res:%d Test.forceCDNTrans:%b, CDNGrayscaleBitMask:%d, CDNGrayscaleBitVal:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt), Integer.valueOf(k & paramInt), Boolean.valueOf(z.pCg), Integer.valueOf(i), Integer.valueOf(j) });
      com.tencent.mm.util.i locali = com.tencent.mm.util.i.agtt;
      if ((com.tencent.mm.util.i.a(com.tencent.mm.util.b.a.agqB, 0) == 1) && (paramInt == 256))
      {
        AppMethodBeat.o(150405);
        return false;
      }
      if (z.pCg)
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
  
  public final boolean Ny(String paramString)
  {
    AppMethodBeat.i(150410);
    com.tencent.mm.g.g localg = (com.tencent.mm.g.g)this.oAr.remove(paramString);
    int i;
    if (localg != null)
    {
      k.bHX();
      i = d.Nq(paramString);
      com.tencent.mm.plugin.report.service.h.OAn.b(10769, new Object[] { Integer.valueOf(h.oAT), Integer.valueOf(localg.field_fileType), Long.valueOf(Util.nowMilliSecond() - localg.field_startTime) });
    }
    for (;;)
    {
      this.oAq.remove(paramString);
      Log.i("MicroMsg.CdnTransportService", "summersafecdn cdntra cancelSendTask mediaid:%s mapremove:%s engine ret:%d", new Object[] { paramString, localg, Integer.valueOf(i) });
      AppMethodBeat.o(150410);
      return true;
      i = 0;
    }
  }
  
  public final boolean Nz(String paramString)
  {
    AppMethodBeat.i(150411);
    com.tencent.mm.g.g localg = (com.tencent.mm.g.g)this.oAr.remove(paramString);
    int i;
    if (localg != null) {
      if ((localg.field_fileType == com.tencent.mm.g.a.lwn) || (localg.field_fileType == com.tencent.mm.g.a.lwp) || (localg.field_fileType == com.tencent.mm.g.a.lwt))
      {
        k.bHX();
        i = d.Nv(paramString);
        com.tencent.mm.plugin.report.service.h.OAn.b(10769, new Object[] { Integer.valueOf(h.oAS), Integer.valueOf(localg.field_fileType), Long.valueOf(Util.nowMilliSecond() - localg.field_startTime) });
      }
    }
    for (;;)
    {
      this.oAq.remove(paramString);
      this.oAs.remove(paramString);
      Log.i("MicroMsg.CdnTransportService", "summersafecdn cdntra cancelRecvTask mediaid:%s mapremove:%s engine ret:%d", new Object[] { paramString, localg, Integer.valueOf(i) });
      AppMethodBeat.o(150411);
      return true;
      if (localg.lwU)
      {
        k.bHX();
        i = d.Nw(paramString);
        break;
      }
      k.bHX();
      i = d.Nr(paramString);
      break;
      i = 0;
    }
  }
  
  public final int a(final String paramString, final com.tencent.mm.g.c paramc, final com.tencent.mm.g.d paramd)
  {
    AppMethodBeat.i(150414);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.CdnTransportService", "cdn callback mediaid is null");
      AppMethodBeat.o(150414);
      return -1;
    }
    if ((paramc == null) && (paramd == null))
    {
      Log.e("MicroMsg.CdnTransportService", "cdn callback info all null");
      AppMethodBeat.o(150414);
      return -2;
    }
    if (paramc != null) {
      Log.d("MicroMsg.CdnTransportService", "CDN progress. total:%d, cur:%d, canshow:%b", new Object[] { Long.valueOf(paramc.field_toltalLength), Long.valueOf(paramc.field_finishedLength), Boolean.valueOf(paramc.field_mtlnotify) });
    }
    this.oAu = Util.nowMilliSecond();
    this.oAt = paramString;
    com.tencent.threadpool.h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(237889);
        Object localObject = (com.tencent.mm.g.g)g.h(g.this).get(paramString);
        if (localObject == null)
        {
          Log.d("MicroMsg.CdnTransportService", " task in jni get info failed mediaid[%s] hash[%s]", new Object[] { paramString, Integer.valueOf(g.this.hashCode()) });
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(594L, 7L, 1L, true);
          AppMethodBeat.o(237889);
          return;
        }
        g.a locala = g.a(g.this, (com.tencent.mm.g.g)localObject);
        if (paramc != null)
        {
          paramc.mediaId = paramString;
          Log.i("MicroMsg.CdnTransportService", "MTL: total:%d, cur:%d, mtl:%b", new Object[] { Long.valueOf(paramc.field_toltalLength), Long.valueOf(paramc.field_finishedLength), Boolean.valueOf(paramc.field_mtlnotify) });
        }
        if (paramd != null) {
          paramd.mediaId = paramString;
        }
        if (((com.tencent.mm.g.g)localObject).lwL != null)
        {
          long l = Util.nowMilliSecond();
          if ((paramd == null) && (paramc != null) && (!paramc.field_mtlnotify) && (NetStatusUtil.getNetWorkType(MMApplicationContext.getContext()) == -1))
          {
            g.a(g.this, locala);
            AppMethodBeat.o(237889);
            return;
          }
          ((com.tencent.mm.g.g)localObject).field_lastProgressCallbackTime = l;
          ((com.tencent.mm.g.g)localObject).lwL.a(paramString, 0, paramc, paramd, ((com.tencent.mm.g.g)localObject).field_onlycheckexist);
        }
        if ((localObject instanceof com.tencent.mm.g.f)) {}
        for (localObject = (com.tencent.mm.g.f)localObject;; localObject = null)
        {
          if ((g.a(paramc)) && ((localObject == null) || (((com.tencent.mm.g.f)localObject).aLI()))) {
            g.e(g.this).remove(paramString);
          }
          if (paramd != null)
          {
            if ((localObject == null) || (((com.tencent.mm.g.f)localObject).aLI())) {
              g.h(g.this).remove(paramString);
            }
            if (paramd.field_retCode == -5103011)
            {
              Log.i("MicroMsg.CdnTransportService", "summersafecdn ERR_VALIDATE_AUTHKEY");
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(546L, 4L, 1L, true);
              k.bHX().keep_OnRequestDoGetCdnDnsInfo(999);
            }
          }
          g.b(g.this, locala);
          AppMethodBeat.o(237889);
          return;
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(237895);
        String str = super.toString() + "|callback";
        AppMethodBeat.o(237895);
        return str;
      }
    }, h((com.tencent.mm.g.g)this.oAr.get(paramString)));
    AppMethodBeat.o(150414);
    return 0;
  }
  
  public final int a(final String paramString, final com.tencent.mm.g.d paramd)
  {
    AppMethodBeat.i(238096);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(238096);
      return 0;
    }
    com.tencent.threadpool.h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(237908);
        com.tencent.mm.g.g localg = (com.tencent.mm.g.g)g.h(g.this).get(paramString);
        if (localg == null)
        {
          Log.d("MicroMsg.CdnTransportService", " task in jni get info failed mediaid:%s", new Object[] { paramString });
          AppMethodBeat.o(237908);
          return;
        }
        if (localg.lxd != null) {
          localg.lxd.b(paramString, paramd);
        }
        AppMethodBeat.o(237908);
      }
    }, h((com.tencent.mm.g.g)this.oAr.get(paramString)));
    AppMethodBeat.o(238096);
    return 0;
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    AppMethodBeat.i(150415);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.CdnTransportService", "cdn callback getauthbuf mediaid is null");
      AppMethodBeat.o(150415);
      return;
    }
    com.tencent.mm.g.g localg = (com.tencent.mm.g.g)this.oAr.get(paramString);
    if (localg == null)
    {
      Log.e("MicroMsg.CdnTransportService", " getauthbuf task in jni get info failed mediaid:%s", new Object[] { paramString });
      AppMethodBeat.o(150415);
      return;
    }
    if (localg.lwL != null)
    {
      localg.lwL.a(paramString, paramByteArrayOutputStream);
      AppMethodBeat.o(150415);
      return;
    }
    Log.e("MicroMsg.CdnTransportService", "getCdnAuthInfo fail, null taskcallback.");
    AppMethodBeat.o(150415);
  }
  
  @Deprecated
  public final boolean b(final com.tencent.mm.g.g paramg, final int paramInt)
  {
    AppMethodBeat.i(150407);
    if (paramg == null)
    {
      Log.e("MicroMsg.CdnTransportService", "addRecvTask task info is null");
      AppMethodBeat.o(150407);
      return false;
    }
    if (Util.isNullOrNil(paramg.field_mediaId))
    {
      Log.e("MicroMsg.CdnTransportService", "addRecvTask mediaId is null");
      AppMethodBeat.o(150407);
      return false;
    }
    if (paramg.field_fileId == null) {
      paramg.field_fileId = "";
    }
    if (paramg.field_aesKey == null) {
      paramg.field_aesKey = "";
    }
    paramg.ihD = false;
    com.tencent.threadpool.h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150400);
        if (paramInt != -1) {
          g.e(g.this).put(paramg.field_mediaId, Integer.valueOf(paramInt));
        }
        Log.i("MicroMsg.CdnTransportService", "CdnTransportService cdn thread run %s", new Object[] { paramg.field_mediaId });
        g.f(g.this).add(paramg.field_mediaId);
        g.g(g.this).put(paramg.field_mediaId, paramg);
        g.this.hf(false);
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
  
  public final void bHM()
  {
    AppMethodBeat.i(150413);
    com.tencent.mm.kernel.h.baC();
    CdnLogic.Config localConfig;
    if (com.tencent.mm.kernel.b.aZM())
    {
      localConfig = new CdnLogic.Config();
      localConfig.UseStreamCDN = 1;
      localConfig.WifiEtl = 100;
      localConfig.MobileEtl = 100;
      localConfig.Ptl = 100;
      localConfig.UseDynamicETL = 0;
      localConfig.EnableCDNVerifyConnect = 1;
      localConfig.EnableCDNVideoRedirectOC = 1;
      localConfig.EnableStreamUploadVideo = 1;
      localConfig.EnableSnsVideoRedirect = 1;
      localConfig.EnableConnectionReuse = 1;
    }
    for (;;)
    {
      try
      {
        Object localObject = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getValue("C2COverloadDelaySeconds");
        String str1 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getValue("SNSOverloadDelaySeconds");
        String str2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getValue("EnableSnsStreamDownload");
        String str3 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getValue("EnableSnsImageDownload");
        if (!Util.isNullOrNil((String)localObject)) {
          localConfig.C2COverloadDelaySeconds = Integer.valueOf((String)localObject).intValue();
        }
        if (!Util.isNullOrNil(str1)) {
          localConfig.SNSOverloadDelaySeconds = Integer.valueOf(str1).intValue();
        }
        if (!Util.isNullOrNil(str2)) {
          localConfig.EnableSnsStreamDownload = Integer.valueOf(str2).intValue();
        }
        if (!Util.isNullOrNil(str3)) {
          localConfig.EnableSnsImageDownload = Integer.valueOf(str3).intValue();
        }
        k.bHW();
        if (!vV(256)) {
          continue;
        }
        i = 1;
        localConfig.EnableSafeCDN = i;
        localConfig.ApprovedVideoHosts = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zhF, "vweixinf.tc.qq.com,szwbwxsns.video.qq.com,szxzwxsns.video.qq.com,szzjwxsns.video.qq.com,shwbwxsns.video.qq.com,shxzwxsns.video.qq.com,shzjwxsns.video.qq.com,wxsnsdy.wxs.qq.com,vweixinthumb.tc.qq.com,wxsnsdythumb.wxs.qq.com,wxappthumb.tc.qq.com,wxapp.tc.qq.com,wxsnsdysvp.wxs.qq.com");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("clicfg_android_channelvideo_quic=").append(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zhu, "224")).append(";");
        ((StringBuilder)localObject).append("clicfg_android_statusvideo_quic=").append(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zhv, "224")).append(";");
        ((StringBuilder)localObject).append("clicfg_android_snsvideo_quic=").append(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zhw, "0")).append(";");
        ((StringBuilder)localObject).append("clicfg_android_snsimage_quic=").append(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zhx, "111")).append(";");
        ((StringBuilder)localObject).append("clicfg_android_c2cvideo_quic=").append(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zhy, "111")).append(";");
        ((StringBuilder)localObject).append("clicfg_android_quic_bigfile=").append(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zhz, "114")).append(";");
        ((StringBuilder)localObject).append("clicfg_android_quic_fullimage=").append(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zhA, "111")).append(";");
        ((StringBuilder)localObject).append("clicfg_android_c2cimage2_quic=").append(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zhB, "111")).append(";");
        ((StringBuilder)localObject).append("clicfg_android_c2cfile_quic=").append(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zhC, "111")).append(";");
        ((StringBuilder)localObject).append("clicfg_android_quic_backup=").append(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zhD, "314")).append(";");
        ((StringBuilder)localObject).append("clicfg_android_quic_favorite=").append(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zhE, "311")).append(";");
        if (!Util.isOverseasUser(MMApplicationContext.getContext()))
        {
          ((StringBuilder)localObject).append("clicfg_android_channelvideo_quic=").append(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zhu, "224")).append(";");
          ((StringBuilder)localObject).append("clicfg_android_statusvideo_quic=").append(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zhv, "224")).append(";");
          ((StringBuilder)localObject).append("clicfg_android_snsvideo_quic=").append(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zhw, "112")).append(";");
          ((StringBuilder)localObject).append("clicfg_android_snsimage_quic=").append(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zhx, "111")).append(";");
          ((StringBuilder)localObject).append("clicfg_android_c2cvideo_quic=").append(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zhy, "112")).append(";");
          ((StringBuilder)localObject).append("clicfg_android_quic_bigfile=").append(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zhz, "114")).append(";");
          ((StringBuilder)localObject).append("clicfg_android_quic_fullimage=").append(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zhA, "311")).append(";");
          ((StringBuilder)localObject).append("clicfg_android_c2cimage2_quic=").append(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zhB, "311")).append(";");
          ((StringBuilder)localObject).append("clicfg_android_c2cfile_quic=").append(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zhC, "311")).append(";");
          ((StringBuilder)localObject).append("clicfg_android_quic_backup=").append(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zhD, "314")).append(";");
          ((StringBuilder)localObject).append("clicfg_android_quic_favorite=").append(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zhE, "311")).append(";");
        }
        localConfig.QuicExptValues = ((StringBuilder)localObject).toString();
        Log.i("MicroMsg.CdnTransportService", "[quic.config] expt %s", new Object[] { localConfig.QuicExptValues });
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("clicfg_favriate_maxsize_mb=").append(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zhG, "4200")).append(";");
        ((StringBuilder)localObject).append("clicfg_snsvideo_maxsize_mb=").append(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zhH, "1124")).append(";");
        ((StringBuilder)localObject).append("clicfg_c2cvideo_maxsize_mb=").append(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zhI, "4200")).append(";");
        ((StringBuilder)localObject).append("clicfg_bigfile_maxsize_mb=").append(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zhJ, "4200")).append(";");
        ((StringBuilder)localObject).append("clicfg_channelvideo_maxsize_mb=").append(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zhK, "4200")).append(";");
        ((StringBuilder)localObject).append("clicfg_image_maxsize_mb=").append(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zhL, "56")).append(";");
        ((StringBuilder)localObject).append("clicfg_c2cfile_maxsize_mb=").append(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zhM, "56")).append(";");
        ((StringBuilder)localObject).append("clicfg_adimage_maxsize_mb=").append(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zhN, "100")).append(";");
        ((StringBuilder)localObject).append("clicfg_default_maxsize_mb=").append(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zhO, "4096")).append(";");
        ((StringBuilder)localObject).append("clicfg_wecom_maxsize_mb=").append(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zhP, "4096")).append(";");
        ((StringBuilder)localObject).append("clicfg_3rdhttp_maxsize_mb=").append(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zhQ, "4096")).append(";");
        localConfig.MiscellaneousExptValues = ((StringBuilder)localObject).toString();
        if (this.oAh != -1)
        {
          Log.w("MicroMsg.CdnTransportService", "cmd set snsimage flag: %d", new Object[] { Integer.valueOf(this.oAh) });
          localConfig.EnableSnsImageDownload = this.oAh;
        }
        Log.i("MicroMsg.CdnTransportService", "summersafecdn streamcdn config[SVR]:%s", new Object[] { localConfig });
        CdnLogic.setConfig(localConfig);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        int i;
        Log.e("MicroMsg.CdnTransportService", localNumberFormatException.toString());
        continue;
      }
      if (z.pCF)
      {
        Log.w("MicroMsg.CdnTransportService", "use cdn debug configure.");
        localConfig.UseStreamCDN = 1;
        localConfig.EnableSnsVideoRedirect = z.pCL;
        Log.i("MicroMsg.CdnTransportService", "streamcdn config[DEBUG]:%s", new Object[] { localConfig });
        CdnLogic.setConfig(localConfig);
      }
      AppMethodBeat.o(150413);
      return;
      i = 0;
    }
  }
  
  @Deprecated
  public final boolean f(com.tencent.mm.g.g paramg)
  {
    AppMethodBeat.i(238009);
    if (paramg == null)
    {
      Log.e("MicroMsg.CdnTransportService", "addRecvTask task info is null");
      AppMethodBeat.o(238009);
      return false;
    }
    if (Util.isNullOrNil(paramg.field_mediaId))
    {
      Log.e("MicroMsg.CdnTransportService", "addRecvTask mediaId is null");
      AppMethodBeat.o(238009);
      return false;
    }
    if (paramg.field_fileId == null) {
      paramg.field_fileId = "";
    }
    if (paramg.field_aesKey == null) {
      paramg.field_aesKey = "";
    }
    paramg.ihD = false;
    Log.i("MicroMsg.CdnTransportService", "CdnTransportService cdn thread run %s", new Object[] { paramg.field_mediaId });
    this.oAp.add(paramg.field_mediaId);
    this.oAq.put(paramg.field_mediaId, paramg);
    hf(false);
    AppMethodBeat.o(238009);
    return true;
  }
  
  @Deprecated
  public final boolean g(final com.tencent.mm.g.g paramg)
  {
    AppMethodBeat.i(150409);
    if (paramg == null)
    {
      Log.e("MicroMsg.CdnTransportService", "summersafecdn addSendTask task info is null");
      AppMethodBeat.o(150409);
      return false;
    }
    if (Util.isNullOrNil(paramg.field_mediaId))
    {
      Log.e("MicroMsg.CdnTransportService", "summersafecdn addSendTask mediaId is null");
      AppMethodBeat.o(150409);
      return false;
    }
    if (paramg.field_fileId == null) {
      paramg.field_fileId = "";
    }
    if (paramg.field_aesKey == null) {
      paramg.field_aesKey = "";
    }
    paramg.ihD = true;
    com.tencent.threadpool.h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150402);
        g.f(g.this).add(paramg.field_mediaId);
        g.g(g.this).put(paramg.field_mediaId, paramg);
        g.this.hf(false);
        AppMethodBeat.o(150402);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(237890);
        String str = super.toString() + "|addSendTask";
        AppMethodBeat.o(237890);
        return str;
      }
    }, "MicroMsg.Cdn.ThreadName");
    AppMethodBeat.o(150409);
    return true;
  }
  
  public final byte[] h(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150416);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.CdnTransportService", "cdn callback decodePrepareResponse mediaid is null");
      AppMethodBeat.o(150416);
      return null;
    }
    com.tencent.mm.g.g localg = (com.tencent.mm.g.g)this.oAr.get(paramString);
    if (localg == null)
    {
      Log.e("MicroMsg.CdnTransportService", " decodePrepareResponse task in jni get info failed mediaid:%s", new Object[] { paramString });
      AppMethodBeat.o(150416);
      return null;
    }
    if (localg.lwL != null)
    {
      paramString = localg.lwL.h(paramString, paramArrayOfByte);
      AppMethodBeat.o(150416);
      return paramString;
    }
    Log.e("MicroMsg.CdnTransportService", "decodePrepareResponse fail, null taskcallback.");
    AppMethodBeat.o(150416);
    return null;
  }
  
  public final void hf(boolean paramBoolean)
  {
    AppMethodBeat.i(150412);
    if ((!paramBoolean) && (k.bHX().bHJ()))
    {
      com.tencent.mm.kernel.h.baC();
      if (com.tencent.mm.kernel.b.aZM())
      {
        Log.w("MicroMsg.CdnTransportService", "summersafecdn cdntra Not init cdn dnsinfo , will retry after set info");
        k.bHT().vX(4);
        AppMethodBeat.o(150412);
        return;
      }
    }
    bHM();
    Log.i("MicroMsg.CdnTransportService", "summersafecdn tryStart queue:%d", new Object[] { Integer.valueOf(this.oAp.size()) });
    Object localObject1;
    Object localObject3;
    label216:
    int j;
    label226:
    Object localObject2;
    if (!this.oAp.isEmpty())
    {
      localObject1 = (String)this.oAp.poll();
      localObject3 = (com.tencent.mm.g.g)this.oAq.remove(localObject1);
      if (localObject3 == null)
      {
        Log.e("MicroMsg.CdnTransportService", "summersafecdn task queue is empty , maybe bug here");
        AppMethodBeat.o(150412);
        return;
      }
      Log.i("MicroMsg.CdnTransportService", "summersafecdn id:%s cdnautostart :%s chatroom:%s", new Object[] { ((com.tencent.mm.g.g)localObject3).field_mediaId, Boolean.valueOf(((com.tencent.mm.g.g)localObject3).field_autostart), Integer.valueOf(((com.tencent.mm.g.g)localObject3).field_chattype) });
      ((com.tencent.mm.g.g)localObject3).field_startTime = Util.nowMilliSecond();
      if (((com.tencent.mm.g.g)localObject3).ihD)
      {
        String str;
        if (((com.tencent.mm.g.g)localObject3).field_fullpath == null)
        {
          i = -1;
          if (((com.tencent.mm.g.g)localObject3).field_thumbpath != null) {
            break label623;
          }
          j = -1;
          Log.i("MicroMsg.CdnTransportService", "summersafecdn tryStart send file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b] largesvideo[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Util.secPrint(((com.tencent.mm.g.g)localObject3).field_svr_signature), Util.secPrint(((com.tencent.mm.g.g)localObject3).field_aesKey), Integer.valueOf(((com.tencent.mm.g.g)localObject3).field_fileType), ((com.tencent.mm.g.g)localObject3).field_mediaId, Boolean.valueOf(((com.tencent.mm.g.g)localObject3).field_onlycheckexist), Integer.valueOf(((com.tencent.mm.g.g)localObject3).field_largesvideo) });
          if (((com.tencent.mm.g.g)localObject3).field_fullpath == null) {
            ((com.tencent.mm.g.g)localObject3).field_fullpath = "";
          }
          if (((com.tencent.mm.g.g)localObject3).field_thumbpath == null) {
            ((com.tencent.mm.g.g)localObject3).field_thumbpath = "";
          }
          localObject1 = (com.tencent.mm.g.g)this.oAr.put(((com.tencent.mm.g.g)localObject3).field_mediaId, localObject3);
          localObject2 = (com.tencent.mm.g.g)this.oAr.get(((com.tencent.mm.g.g)localObject3).field_mediaId);
          if (localObject2 == null) {
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(594L, 5L, 1L, true);
          }
          i = k.bHX().d((com.tencent.mm.g.g)localObject3);
          str = ((com.tencent.mm.g.g)localObject3).field_mediaId;
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
        for (localObject2 = null;; localObject2 = ((com.tencent.mm.g.g)localObject2).field_mediaId)
        {
          Log.i("MicroMsg.CdnTransportService", "summersafecdn startupUploadMedia ok, field_mediaId[%s] ret[%s, %s, %s] hash[%s]", new Object[] { str, Integer.valueOf(i), localObject1, localObject2, Integer.valueOf(hashCode()) });
          if (i == 0) {
            break;
          }
          Log.e("MicroMsg.CdnTransportService", "summersafecdn startupUploadMedia error:%d clientid:%s", new Object[] { Integer.valueOf(i), ((com.tencent.mm.g.g)localObject3).field_mediaId });
          if (-21005 != i)
          {
            localObject1 = (com.tencent.mm.g.g)this.oAr.remove(((com.tencent.mm.g.g)localObject3).field_mediaId);
            Log.e("MicroMsg.CdnTransportService", "summersafecdn startupUploadMedia error:%d clientid:%s remove[%s]", new Object[] { Integer.valueOf(i), ((com.tencent.mm.g.g)localObject3).field_mediaId, localObject1 });
          }
          if (((com.tencent.mm.g.g)localObject3).lwL == null) {
            break;
          }
          ((com.tencent.mm.g.g)localObject3).lwL.a(((com.tencent.mm.g.g)localObject3).field_mediaId, i, null, null, ((com.tencent.mm.g.g)localObject3).field_onlycheckexist);
          break;
          i = ((com.tencent.mm.g.g)localObject3).field_fullpath.length();
          break label216;
          label623:
          j = ((com.tencent.mm.g.g)localObject3).field_thumbpath.length();
          break label226;
          label635:
          localObject1 = ((com.tencent.mm.g.g)localObject1).field_mediaId;
          break label432;
        }
      }
      j = -1;
      if (((com.tencent.mm.g.g)localObject3).field_fileType == 40001) {
        i = k.bHX().a(((com.tencent.mm.g.g)localObject3).field_mediaId, ((com.tencent.mm.g.g)localObject3).lwO, ((com.tencent.mm.g.g)localObject3).field_fullpath, ((com.tencent.mm.g.g)localObject3).field_fileType, ((com.tencent.mm.g.g)localObject3).field_aesKey, ((com.tencent.mm.g.g)localObject3).field_authKey, ((com.tencent.mm.g.g)localObject3).field_totalLen, false);
      }
      for (;;)
      {
        label711:
        if (i != 0)
        {
          Log.e("MicroMsg.CdnTransportService", "summersafecdn startupDownloadMedia error:%d clientid:%s", new Object[] { Integer.valueOf(i), ((com.tencent.mm.g.g)localObject3).field_mediaId });
          if (((com.tencent.mm.g.g)localObject3).lwL == null) {
            break;
          }
          ((com.tencent.mm.g.g)localObject3).lwL.a(((com.tencent.mm.g.g)localObject3).field_mediaId, i, null, null, ((com.tencent.mm.g.g)localObject3).field_onlycheckexist);
          break;
          if (((com.tencent.mm.g.g)localObject3).field_fileType == 19)
          {
            paramBoolean = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zpR, false);
            i = k.bHX().a(((com.tencent.mm.g.g)localObject3).field_mediaId, ((com.tencent.mm.g.g)localObject3).lwO, ((com.tencent.mm.g.g)localObject3).field_fullpath, ((com.tencent.mm.g.g)localObject3).field_fileType, ((com.tencent.mm.g.g)localObject3).field_aesKey, ((com.tencent.mm.g.g)localObject3).field_authKey, ((com.tencent.mm.g.g)localObject3).field_totalLen, paramBoolean);
          }
          else if ((((com.tencent.mm.g.g)localObject3).field_fileType == com.tencent.mm.g.a.lwn) || (((com.tencent.mm.g.g)localObject3).field_fileType == com.tencent.mm.g.a.lwp) || (((com.tencent.mm.g.g)localObject3).field_fileType == com.tencent.mm.g.a.lwt))
          {
            if ((((com.tencent.mm.g.g)localObject3).field_fullpath == null) || (((com.tencent.mm.g.g)localObject3).field_fullpath.isEmpty())) {
              break label1713;
            }
          }
        }
      }
    }
    label1412:
    label1425:
    label1691:
    label1708:
    label1713:
    for (int i = k.bHX().a(((com.tencent.mm.g.g)localObject3).field_mediaId, ((com.tencent.mm.g.g)localObject3).lwO, ((com.tencent.mm.g.g)localObject3).field_fullpath, ((com.tencent.mm.g.g)localObject3).field_fileType, ((com.tencent.mm.g.g)localObject3).lwP, ((com.tencent.mm.g.g)localObject3).lwQ, ((com.tencent.mm.g.g)localObject3).lwR, ((com.tencent.mm.g.g)localObject3).lwS, ((com.tencent.mm.g.g)localObject3).lwZ, ((com.tencent.mm.g.g)localObject3).lxa);; i = -1)
    {
      if (((com.tencent.mm.g.g)localObject3).field_fullpath == null) {}
      for (j = -1;; j = ((com.tencent.mm.g.g)localObject3).field_fullpath.length())
      {
        Log.i("MicroMsg.CdnTransportService", "url download tryStart recv file:%d field_mediaId[%s], download_url[%s], filetype:[%d]", new Object[] { Integer.valueOf(j), ((com.tencent.mm.g.g)localObject3).field_mediaId, ((com.tencent.mm.g.g)localObject3).lwO, Integer.valueOf(((com.tencent.mm.g.g)localObject3).field_fileType) });
        break;
      }
      if (((com.tencent.mm.g.g)localObject3).lwU)
      {
        i = j;
        if (((com.tencent.mm.g.g)localObject3).field_fullpath != null)
        {
          i = j;
          if (!((com.tencent.mm.g.g)localObject3).field_fullpath.isEmpty()) {
            i = k.bHX().a(((com.tencent.mm.g.g)localObject3).field_mediaId, ((com.tencent.mm.g.g)localObject3).field_fullpath, ((com.tencent.mm.g.g)localObject3).lwO, ((com.tencent.mm.g.g)localObject3).lwV, ((com.tencent.mm.g.g)localObject3).lwW, ((com.tencent.mm.g.g)localObject3).allow_mobile_net_download, ((com.tencent.mm.g.g)localObject3).lwP, ((com.tencent.mm.g.g)localObject3).lwQ, ((com.tencent.mm.g.g)localObject3).is_resume_task, ((com.tencent.mm.g.g)localObject3).lwT, ((com.tencent.mm.g.g)localObject3).lwR);
          }
        }
        if (((com.tencent.mm.g.g)localObject3).field_fullpath == null) {}
        for (j = -1;; j = ((com.tencent.mm.g.g)localObject3).field_fullpath.length())
        {
          Log.i("MicroMsg.CdnTransportService", "game package download tryStart recv file:%d field_mediaId[%s], download_url[%s] https url[%s]", new Object[] { Integer.valueOf(j), ((com.tencent.mm.g.g)localObject3).field_mediaId, ((com.tencent.mm.g.g)localObject3).lwO, ((com.tencent.mm.g.g)localObject3).lwV });
          break;
        }
      }
      if (((com.tencent.mm.g.g)localObject3).lwX)
      {
        if ((localObject3 instanceof com.tencent.mm.g.f))
        {
          localObject1 = (com.tencent.mm.g.f)localObject3;
          i = k.bHX().a((com.tencent.mm.g.f)localObject1);
          break label711;
        }
        if (!(localObject3 instanceof e)) {
          break label1708;
        }
        localObject1 = (e)localObject3;
        i = k.bHX().a((e)localObject1);
        break label711;
      }
      if (((com.tencent.mm.g.g)localObject3).field_fullpath == null)
      {
        i = -1;
        label1268:
        if (((com.tencent.mm.g.g)localObject3).field_thumbpath != null) {
          break label1412;
        }
      }
      for (int k = -1;; k = ((com.tencent.mm.g.g)localObject3).field_thumbpath.length())
      {
        Log.i("MicroMsg.CdnTransportService", "summersafecdn tryStart recv file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b]", new Object[] { Integer.valueOf(i), Integer.valueOf(k), ((com.tencent.mm.g.g)localObject3).field_svr_signature, ((com.tencent.mm.g.g)localObject3).field_aesKey, Integer.valueOf(((com.tencent.mm.g.g)localObject3).field_fileType), ((com.tencent.mm.g.g)localObject3).field_mediaId, Boolean.valueOf(((com.tencent.mm.g.g)localObject3).field_onlycheckexist) });
        if (((com.tencent.mm.g.g)localObject3).lxb != 2) {
          break label1539;
        }
        if (!(localObject3 instanceof com.tencent.mm.g.h)) {
          break label1708;
        }
        localObject1 = (com.tencent.mm.g.h)localObject3;
        if (!((com.tencent.mm.g.h)localObject1).aLL()) {
          break label1425;
        }
        i = k.bHX().a((com.tencent.mm.g.g)localObject3, 2);
        break;
        i = ((com.tencent.mm.g.g)localObject3).field_fullpath.length();
        break label1268;
      }
      if (((com.tencent.mm.g.h)localObject1).aLJ())
      {
        ((com.tencent.mm.g.h)localObject1).connectionCount = 1;
        ((com.tencent.mm.g.h)localObject1).concurrentCount = 1;
        i = k.bHX().a((com.tencent.mm.g.h)localObject1);
        break label711;
      }
      if (((com.tencent.mm.g.h)localObject1).aLK())
      {
        i = k.bHX().d((com.tencent.mm.g.h)localObject1);
        break label711;
      }
      if (((com.tencent.mm.g.h)localObject1).aLO())
      {
        i = k.bHX().b((com.tencent.mm.g.h)localObject1);
        break label711;
      }
      if (((com.tencent.mm.g.h)localObject1).aLQ())
      {
        i = k.bHX().d((com.tencent.mm.g.h)localObject1);
        break label711;
      }
      i = j;
      if (((com.tencent.mm.g.h)localObject1).aLP()) {
        i = k.bHX().c((com.tencent.mm.g.h)localObject1);
      }
      break label711;
      i = k.bHX().e((com.tencent.mm.g.g)localObject3);
      break label711;
      localObject1 = (com.tencent.mm.g.g)this.oAr.put(((com.tencent.mm.g.g)localObject3).field_mediaId, localObject3);
      localObject2 = (com.tencent.mm.g.g)this.oAr.get(((com.tencent.mm.g.g)localObject3).field_mediaId);
      if (localObject2 == null) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(594L, 6L, 1L, true);
      }
      localObject3 = ((com.tencent.mm.g.g)localObject3).field_mediaId;
      if (localObject1 == null)
      {
        localObject1 = null;
        label1625:
        if (localObject2 != null) {
          break label1691;
        }
      }
      for (localObject2 = null;; localObject2 = ((com.tencent.mm.g.g)localObject2).field_mediaId)
      {
        Log.i("MicroMsg.CdnTransportService", "summersafecdn startupDownloadMedia ok, field_mediaId[%s] ret[%s, %s, %s] hash[%s]", new Object[] { localObject3, Integer.valueOf(i), localObject1, localObject2, Integer.valueOf(hashCode()) });
        break;
        localObject1 = ((com.tencent.mm.g.g)localObject1).field_mediaId;
        break label1625;
      }
      AppMethodBeat.o(150412);
      return;
      i = -1;
      break label711;
    }
  }
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(150403);
    if (!com.tencent.mm.kernel.h.baC().aZN())
    {
      AppMethodBeat.o(150403);
      return;
    }
    int i = Util.nullAsInt(paramObject, 0);
    Log.d("MicroMsg.CdnTransportService", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramMStorageEx });
    if ((paramMStorageEx != com.tencent.mm.kernel.h.baE().ban()) || (i <= 0))
    {
      Log.e("MicroMsg.CdnTransportService", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramMStorageEx });
      AppMethodBeat.o(150403);
      return;
    }
    if (i != 144385)
    {
      AppMethodBeat.o(150403);
      return;
    }
    k.bHT().vX(10);
    AppMethodBeat.o(150403);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(150404);
    if (paramp.getType() != 379)
    {
      AppMethodBeat.o(150404);
      return;
    }
    Log.d("MicroMsg.CdnTransportService", "cdntra onSceneEnd it will tryStart sceneType:%d [%d,%d]", new Object[] { Integer.valueOf(paramp.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (com.tencent.mm.kernel.h.baC().aZN()) {
      com.tencent.threadpool.h.ahAA.g(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(150398);
          g.this.hf(true);
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
  
  public final void vW(int paramInt)
  {
    this.oAh = paramInt;
  }
  
  static final class a
  {
    public long endTime;
    public String field_mediaId;
    public int field_totalLen;
    public boolean ihD;
    public int ikK;
    public int ikL;
    public int ikM;
    public int ikN;
    public int ikO;
    public int ikP;
    public int ikQ;
    public int ikR;
    public String ikS;
    public int ikT;
    public int ikU;
    public String oAG;
    public long oAH;
    public long startTime;
    public String taskName;
    public long threadId;
    
    public a(String paramString1, String paramString2, String paramString3, long paramLong, com.tencent.mm.g.g paramg)
    {
      AppMethodBeat.i(237831);
      this.oAG = "";
      this.taskName = "task_default";
      this.field_mediaId = "";
      this.field_totalLen = 0;
      this.startTime = 0L;
      this.endTime = -1L;
      this.threadId = 0L;
      this.ikK = 0;
      this.ikL = 0;
      this.ikM = 0;
      this.ikN = 0;
      this.ikO = 0;
      this.ikP = 0;
      this.ikQ = 0;
      this.ikR = 0;
      this.ikS = "";
      this.ikT = 0;
      this.ikU = 0;
      this.oAH = 0L;
      this.oAG = paramString1;
      this.taskName = paramString2;
      this.field_mediaId = paramString3;
      this.ihD = paramg.ihD;
      this.field_totalLen = paramg.field_totalLen;
      this.startTime = paramLong;
      this.threadId = Thread.currentThread().getId();
      this.ikK = paramg.field_fileType;
      this.ikL = paramg.field_appType;
      this.ikM = paramg.field_bzScene;
      this.ikN = paramg.hyY;
      this.ikO = paramg.field_chattype;
      this.ikP = paramg.field_advideoflag;
      this.ikQ = paramg.field_largesvideo;
      this.ikR = paramg.field_requestVideoFormat;
      this.ikS = Util.nullAs(paramg.field_snsScene, "");
      if (paramg.lwX) {
        i = 1;
      }
      this.ikT = i;
      this.ikU = paramg.lxc;
      this.oAH = System.currentTimeMillis();
      AppMethodBeat.o(237831);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(237843);
      String str = "CdnTaskReportInfo{cdnCallbackReportId='" + this.oAG + '\'' + ", taskName='" + this.taskName + '\'' + ", field_mediaId='" + this.field_mediaId + '\'' + ", isSend=" + this.ihD + ", field_totalLen=" + this.field_totalLen + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", threadId=" + this.threadId + ", _FileType=" + this.ikK + ", _AppType=" + this.ikL + ", _BzScene=" + this.ikM + ", _BizType=" + this.ikN + ", _Chattype=" + this.ikO + ", _Advideoflag=" + this.ikP + ", _Largesvideo=" + this.ikQ + ", _RequestVideoFormat=" + this.ikR + ", _SnsScene='" + this.ikS + '\'' + ", _SnsImageDownload=" + this.ikT + ", _VideoTaskType=" + this.ikU + ", localTime=" + this.oAH + '}';
      AppMethodBeat.o(237843);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelcdntran.g
 * JD-Core Version:    0.7.0.1
 */