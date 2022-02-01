package com.tencent.mm.aq;

import android.os.Looper;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.Config;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.app.o.a;
import com.tencent.mm.f.a.ms;
import com.tencent.mm.i.e;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.g.b;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ao;
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
  implements com.tencent.mm.an.i, com.tencent.mm.i.b, com.tencent.mm.i.b.a, MStorageEx.IOnStorageChange
{
  private static final long[] lHX = { 0L, 2L, 5L, 7L, 10L, 15L, 20L, 30L, 50L, 70L, 100L, 200L, 400L, 600L, 800L, 1000L, 3000L, 5000L, 10000L, 20000L, 30000L, 40000L, 50000L, 60000L, 120000L };
  private static final int[] lHY = { 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34 };
  private static int lHZ = -1;
  private static long lIa = -1L;
  public o.a appForegroundListener;
  private int lHI;
  MMHandler lHJ;
  IListener<ms> lHK;
  p lHL;
  private ConcurrentHashMap<String, a> lHM;
  final MTimerHandler lHN;
  ConcurrentHashMap<String, String> lHO;
  private boolean lHP;
  private Queue<String> lHQ;
  public Map<String, g> lHR;
  public Map<String, g> lHS;
  public Map<String, Integer> lHT;
  private String lHU;
  private long lHV;
  public HashSet<String> lHW;
  
  public b()
  {
    AppMethodBeat.i(150406);
    this.lHI = -1;
    this.lHJ = new b.1(this, Looper.getMainLooper());
    this.lHK = new b.3(this);
    this.lHL = new b.4(this);
    this.lHM = new ConcurrentHashMap();
    this.lHN = new MTimerHandler(Looper.getMainLooper(), new b.5(this), true);
    this.appForegroundListener = new o.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(213166);
        Log.i("MicroMsg.CdnTransportService", "onAppBackground %s", new Object[] { paramAnonymousString });
        if (!b.bjY())
        {
          AppMethodBeat.o(213166);
          return;
        }
        b.a(b.this, false);
        b.d(b.this).stopTimer();
        com.tencent.e.h.ZvG.be(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(243471);
            Log.i("MicroMsg.CdnTransportService", "appForegroundListener onAppBackground");
            b.b(b.this);
            Iterator localIterator = b.c(b.this).entrySet().iterator();
            if (localIterator.hasNext())
            {
              Object localObject = (Map.Entry)localIterator.next();
              localObject = (b.a)b.c(b.this).remove(((Map.Entry)localObject).getKey());
              if (localObject != null) {}
              for (localObject = ((b.a)localObject).toString();; localObject = "null")
              {
                Log.i("MicroMsg.CdnTransportService", "remove %s", new Object[] { localObject });
                break;
              }
            }
            AppMethodBeat.o(243471);
          }
        });
        AppMethodBeat.o(213166);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(213165);
        Log.i("MicroMsg.CdnTransportService", "onAppForeground %s", new Object[] { paramAnonymousString });
        if (!b.bjY())
        {
          AppMethodBeat.o(213165);
          return;
        }
        b.a(b.this, true);
        b.c(b.this).clear();
        b.d(b.this).startTimer(60000L);
        AppMethodBeat.o(213165);
      }
    };
    this.lHO = new ConcurrentHashMap();
    this.lHP = com.tencent.mm.as.a.isActive();
    this.lHQ = new LinkedList();
    this.lHR = new HashMap();
    this.lHS = new ConcurrentHashMap();
    this.lHT = new HashMap();
    this.lHU = "";
    this.lHV = 0L;
    this.lHW = new HashSet();
    com.tencent.mm.kernel.h.aHF().a(this.lHL);
    if (com.tencent.mm.kernel.h.aHE().aGM()) {
      com.tencent.mm.kernel.h.aHG().aHp().add(this);
    }
    com.tencent.mm.kernel.h.aGY().a(379, this);
    EventCenter.instance.addListener(this.lHK);
    if (bjY())
    {
      this.appForegroundListener.alive();
      this.lHN.startTimer(60000L);
    }
    Log.i("MicroMsg.CdnTransportService", "summersafecdn CdnTransportService init[%s] stack[%s]", new Object[] { Integer.valueOf(hashCode()), Util.getStack() });
    AppMethodBeat.o(150406);
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(202121);
    if (parama == null)
    {
      AppMethodBeat.o(202121);
      return;
    }
    long l = parama.endTime - parama.startTime;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(z(5, l));
    int k = 10;
    int i = lHX.length - 1;
    for (;;)
    {
      int j = k;
      if (i >= 0)
      {
        if (l >= lHX[i]) {
          j = lHY[i];
        }
      }
      else
      {
        localArrayList.add(z(j, 1L));
        localArrayList.add(z(0, 1L));
        com.tencent.mm.plugin.report.f.Iyx.b(localArrayList, false);
        Log.i("MicroMsg.CdnTransportService", "reportCDNCallbackTime(%s) taskName:%s cdnCallbackReportId:%s mediaId:%s duration:%s(%s-%s)", new Object[] { Long.valueOf(parama.threadId), parama.taskName, Util.nullAs(parama.lIh, ""), Util.nullAs(parama.field_mediaId, ""), Long.valueOf(l), Long.valueOf(parama.startTime), Long.valueOf(parama.endTime) });
        AppMethodBeat.o(202121);
        return;
      }
      i -= 1;
    }
  }
  
  public static boolean bjY()
  {
    AppMethodBeat.i(202129);
    String str = com.tencent.mm.plugin.expt.h.d.dgX().a("clicfg_cdn_callback_consume_time_statistics_switch", "1", false, true);
    Log.d("MicroMsg.CdnTransportService", "canCDNCallbackStatistics() sw:%s", new Object[] { str });
    boolean bool = Util.isEqual(str, "1");
    AppMethodBeat.o(202129);
    return bool;
  }
  
  private static int bjZ()
  {
    AppMethodBeat.i(202131);
    if (lHZ == -1)
    {
      String str = com.tencent.mm.plugin.expt.h.d.dgX().a("clicfg_cdn_callback_tag_max_num", "1", false, true);
      Log.d("MicroMsg.CdnTransportService", "getTagMaxNum() maxNum:%s", new Object[] { str });
      lHZ = Util.getInt(str, 1);
    }
    int i = lHZ;
    AppMethodBeat.o(202131);
    return i;
  }
  
  private String g(g paramg)
  {
    AppMethodBeat.i(202112);
    if ((paramg == null) || (Util.isNullOrNil(paramg.taskName)))
    {
      AppMethodBeat.o(202112);
      return "MicroMsg.CdnTransportService";
    }
    if (this.lHO.containsKey(paramg.taskName))
    {
      paramg = (String)this.lHO.get(paramg.taskName);
      AppMethodBeat.o(202112);
      return paramg;
    }
    String str = "MicroMsg.CdnTransportService_" + (this.lHO.size() + 1) % bjZ();
    this.lHO.put(paramg.taskName, str);
    Log.i("MicroMsg.CdnTransportService", "taskName:%s tag:%s", new Object[] { Util.nullAs(paramg.taskName, ""), Util.nullAs(str, "") });
    AppMethodBeat.o(202112);
    return str;
  }
  
  public static boolean vQ(int paramInt)
  {
    AppMethodBeat.i(150405);
    com.tencent.mm.kernel.h.aHE();
    if (com.tencent.mm.kernel.b.aGL())
    {
      int k = Util.nullAs((Integer)com.tencent.mm.kernel.h.aHG().aHp().b(144385, null), 0);
      int i = com.tencent.mm.n.h.axc().getInt("CDNGrayscaleBitMask", 0);
      int j = com.tencent.mm.n.h.axc().getInt("CDNGrayscaleBitVal", 0);
      k = k & (i ^ 0xFFFFFFFF) | j & i;
      Log.d("MicroMsg.CdnTransportService", "summersafecdn cdntra cdnBitSet:%d grayScaleFlag:%d res:%d Test.forceCDNTrans:%b, CDNGrayscaleBitMask:%d, CDNGrayscaleBitVal:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt), Integer.valueOf(k & paramInt), Boolean.valueOf(ac.mFG), Integer.valueOf(i), Integer.valueOf(j) });
      if (ac.mFG)
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
  
  private static IDKey z(int paramInt, long paramLong)
  {
    AppMethodBeat.i(202125);
    IDKey localIDKey = new IDKey();
    localIDKey.SetID(1452);
    localIDKey.SetKey(paramInt);
    localIDKey.SetValue(paramLong);
    AppMethodBeat.o(202125);
    return localIDKey;
  }
  
  public final boolean Vy(String paramString)
  {
    AppMethodBeat.i(150410);
    g localg = (g)this.lHS.remove(paramString);
    if (localg != null)
    {
      f.bkh();
      a.Vq(paramString);
      com.tencent.mm.plugin.report.service.h.IzE.a(10769, new Object[] { Integer.valueOf(c.lIu), Integer.valueOf(localg.field_fileType), Long.valueOf(Util.nowMilliSecond() - localg.field_startTime) });
    }
    this.lHR.remove(paramString);
    Log.i("MicroMsg.CdnTransportService", "summersafecdn cdntra cancelSendTask mediaid:%s mapremove:%s engine ret:%d", new Object[] { paramString, localg, Integer.valueOf(0) });
    AppMethodBeat.o(150410);
    return true;
  }
  
  public final boolean Vz(String paramString)
  {
    AppMethodBeat.i(150411);
    g localg = (g)this.lHS.remove(paramString);
    if (localg != null)
    {
      if ((localg.field_fileType != com.tencent.mm.i.a.iUi) && (localg.field_fileType != com.tencent.mm.i.a.iUk) && (localg.field_fileType != com.tencent.mm.i.a.iUo)) {
        break label167;
      }
      f.bkh();
      a.Vv(paramString);
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(10769, new Object[] { Integer.valueOf(c.lIt), Integer.valueOf(localg.field_fileType), Long.valueOf(Util.nowMilliSecond() - localg.field_startTime) });
      this.lHR.remove(paramString);
      this.lHT.remove(paramString);
      Log.i("MicroMsg.CdnTransportService", "summersafecdn cdntra cancelRecvTask mediaid:%s mapremove:%s engine ret:%d", new Object[] { paramString, localg, Integer.valueOf(0) });
      AppMethodBeat.o(150411);
      return true;
      label167:
      if (localg.iUP)
      {
        f.bkh();
        a.Vw(paramString);
      }
      else
      {
        f.bkh();
        a.Vr(paramString);
      }
    }
  }
  
  public final int a(final String paramString, final com.tencent.mm.i.c paramc, final com.tencent.mm.i.d paramd)
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
    this.lHV = Util.nowMilliSecond();
    this.lHU = paramString;
    com.tencent.e.h.ZvG.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(187838);
        Object localObject = (g)b.h(b.this).get(paramString);
        if (localObject == null)
        {
          Log.d("MicroMsg.CdnTransportService", " task in jni get info failed mediaid[%s] hash[%s]", new Object[] { paramString, Integer.valueOf(b.this.hashCode()) });
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(594L, 7L, 1L, true);
          AppMethodBeat.o(187838);
          return;
        }
        b.a locala = b.a(b.this, (g)localObject);
        if (paramc != null)
        {
          paramc.mediaId = paramString;
          Log.i("MicroMsg.CdnTransportService", "MTL: total:%d, cur:%d, mtl:%b", new Object[] { Long.valueOf(paramc.field_toltalLength), Long.valueOf(paramc.field_finishedLength), Boolean.valueOf(paramc.field_mtlnotify) });
        }
        if (paramd != null) {
          paramd.mediaId = paramString;
        }
        if (((g)localObject).iUG != null)
        {
          long l = Util.nowMilliSecond();
          if ((paramd == null) && (paramc != null) && (!paramc.field_mtlnotify) && (NetStatusUtil.getNetWorkType(MMApplicationContext.getContext()) == -1))
          {
            b.a(b.this, locala);
            AppMethodBeat.o(187838);
            return;
          }
          ((g)localObject).field_lastProgressCallbackTime = l;
          ((g)localObject).iUG.a(paramString, 0, paramc, paramd, ((g)localObject).field_onlycheckexist);
        }
        if ((localObject instanceof com.tencent.mm.i.f)) {}
        for (localObject = (com.tencent.mm.i.f)localObject;; localObject = null)
        {
          if ((b.a(paramc)) && ((localObject == null) || (((com.tencent.mm.i.f)localObject).arM()))) {
            b.e(b.this).remove(paramString);
          }
          if (paramd != null)
          {
            if ((localObject == null) || (((com.tencent.mm.i.f)localObject).arM())) {
              b.h(b.this).remove(paramString);
            }
            if (paramd.field_retCode == -5103011)
            {
              Log.i("MicroMsg.CdnTransportService", "summersafecdn ERR_VALIDATE_AUTHKEY");
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(546L, 4L, 1L, true);
              f.bkh().keep_OnRequestDoGetCdnDnsInfo(999);
            }
          }
          b.b(b.this, locala);
          AppMethodBeat.o(187838);
          return;
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(187839);
        String str = super.toString() + "|callback";
        AppMethodBeat.o(187839);
        return str;
      }
    }, g((g)this.lHS.get(paramString)));
    AppMethodBeat.o(150414);
    return 0;
  }
  
  public final int a(final String paramString, final com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(202106);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(202106);
      return 0;
    }
    com.tencent.e.h.ZvG.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(190064);
        g localg = (g)b.h(b.this).get(paramString);
        if (localg == null)
        {
          Log.d("MicroMsg.CdnTransportService", " task in jni get info failed mediaid:%s", new Object[] { paramString });
          AppMethodBeat.o(190064);
          return;
        }
        if (localg.iUY != null) {
          localg.iUY.b(paramString, paramd);
        }
        AppMethodBeat.o(190064);
      }
    }, g((g)this.lHS.get(paramString)));
    AppMethodBeat.o(202106);
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
    g localg = (g)this.lHS.get(paramString);
    if (localg == null)
    {
      Log.e("MicroMsg.CdnTransportService", " getauthbuf task in jni get info failed mediaid:%s", new Object[] { paramString });
      AppMethodBeat.o(150415);
      return;
    }
    if (localg.iUG != null)
    {
      localg.iUG.a(paramString, paramByteArrayOutputStream);
      AppMethodBeat.o(150415);
      return;
    }
    Log.e("MicroMsg.CdnTransportService", "getCdnAuthInfo fail, null taskcallback.");
    AppMethodBeat.o(150415);
  }
  
  public final boolean b(g paramg, int paramInt)
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
    paramg.gbt = false;
    com.tencent.e.h.ZvG.d(new b.8(this, paramInt, paramg), "MicroMsg.Cdn.ThreadName");
    AppMethodBeat.o(150407);
    return true;
  }
  
  public final void bjX()
  {
    AppMethodBeat.i(150413);
    com.tencent.mm.kernel.h.aHE();
    CdnLogic.Config localConfig;
    if (com.tencent.mm.kernel.b.aGL())
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
        Object localObject = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getValue("C2COverloadDelaySeconds");
        String str1 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getValue("SNSOverloadDelaySeconds");
        String str2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getValue("EnableSnsStreamDownload");
        String str3 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getValue("EnableSnsImageDownload");
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
        f.bkg();
        if (!vQ(256)) {
          continue;
        }
        i = 1;
        localConfig.EnableSafeCDN = i;
        localConfig.ApprovedVideoHosts = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vPd, "vweixinf.tc.qq.com,szwbwxsns.video.qq.com,szxzwxsns.video.qq.com,szzjwxsns.video.qq.com,shwbwxsns.video.qq.com,shxzwxsns.video.qq.com,shzjwxsns.video.qq.com,wxsnsdy.wxs.qq.com,vweixinthumb.tc.qq.com,wxsnsdythumb.wxs.qq.com,wxappthumb.tc.qq.com,wxapp.tc.qq.com,wxsnsdysvp.wxs.qq.com");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("clicfg_android_channelvideo_quic=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vOS, "224")).append(";");
        ((StringBuilder)localObject).append("clicfg_android_statusvideo_quic=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vOT, "224")).append(";");
        ((StringBuilder)localObject).append("clicfg_android_snsvideo_quic=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vOU, "0")).append(";");
        ((StringBuilder)localObject).append("clicfg_android_snsimage_quic=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vOV, "111")).append(";");
        ((StringBuilder)localObject).append("clicfg_android_c2cvideo_quic=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vOW, "111")).append(";");
        ((StringBuilder)localObject).append("clicfg_android_quic_bigfile=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vOX, "114")).append(";");
        ((StringBuilder)localObject).append("clicfg_android_quic_fullimage=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vOY, "111")).append(";");
        ((StringBuilder)localObject).append("clicfg_android_c2cimage2_quic=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vOZ, "111")).append(";");
        ((StringBuilder)localObject).append("clicfg_android_c2cfile_quic=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vPa, "111")).append(";");
        ((StringBuilder)localObject).append("clicfg_android_quic_backup=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vPb, "314")).append(";");
        ((StringBuilder)localObject).append("clicfg_android_quic_favorite=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vPc, "311")).append(";");
        localConfig.QuicExptValues = ((StringBuilder)localObject).toString();
        Log.i("MicroMsg.CdnTransportService", "[quic.config] expt %s", new Object[] { localConfig.QuicExptValues });
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("clicfg_favriate_maxsize_mb=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vPe, "1124")).append(";");
        ((StringBuilder)localObject).append("clicfg_snsvideo_maxsize_mb=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vPf, "1124")).append(";");
        ((StringBuilder)localObject).append("clicfg_c2cvideo_maxsize_mb=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vPg, "300")).append(";");
        ((StringBuilder)localObject).append("clicfg_bigfile_maxsize_mb=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vPh, "1124")).append(";");
        ((StringBuilder)localObject).append("clicfg_channelvideo_maxsize_mb=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vPi, "1124")).append(";");
        ((StringBuilder)localObject).append("clicfg_image_maxsize_mb=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vPj, "56")).append(";");
        ((StringBuilder)localObject).append("clicfg_c2cfile_maxsize_mb=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vPk, "56")).append(";");
        ((StringBuilder)localObject).append("clicfg_adimage_maxsize_mb=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vPl, "100")).append(";");
        ((StringBuilder)localObject).append("clicfg_default_maxsize_mb=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vPm, "4096")).append(";");
        ((StringBuilder)localObject).append("clicfg_wecom_maxsize_mb=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vPn, "4096")).append(";");
        ((StringBuilder)localObject).append("clicfg_3rdhttp_maxsize_mb=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vPo, "4096")).append(";");
        localConfig.MiscellaneousExptValues = ((StringBuilder)localObject).toString();
        if (this.lHI != -1)
        {
          Log.w("MicroMsg.CdnTransportService", "cmd set snsimage flag: %d", new Object[] { Integer.valueOf(this.lHI) });
          localConfig.EnableSnsImageDownload = this.lHI;
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
      if (ac.mGf)
      {
        Log.w("MicroMsg.CdnTransportService", "use cdn debug configure.");
        localConfig.UseStreamCDN = 1;
        localConfig.EnableSnsVideoRedirect = ac.mGl;
        Log.i("MicroMsg.CdnTransportService", "streamcdn config[DEBUG]:%s", new Object[] { localConfig });
        CdnLogic.setConfig(localConfig);
      }
      AppMethodBeat.o(150413);
      return;
      i = 0;
    }
  }
  
  public final boolean d(g paramg)
  {
    AppMethodBeat.i(202014);
    if (paramg == null)
    {
      Log.e("MicroMsg.CdnTransportService", "addRecvTask task info is null");
      AppMethodBeat.o(202014);
      return false;
    }
    if (Util.isNullOrNil(paramg.field_mediaId))
    {
      Log.e("MicroMsg.CdnTransportService", "addRecvTask mediaId is null");
      AppMethodBeat.o(202014);
      return false;
    }
    if (paramg.field_fileId == null) {
      paramg.field_fileId = "";
    }
    if (paramg.field_aesKey == null) {
      paramg.field_aesKey = "";
    }
    paramg.gbt = false;
    Log.i("MicroMsg.CdnTransportService", "CdnTransportService cdn thread run %s", new Object[] { paramg.field_mediaId });
    this.lHQ.add(paramg.field_mediaId);
    this.lHR.put(paramg.field_mediaId, paramg);
    go(false);
    AppMethodBeat.o(202014);
    return true;
  }
  
  public final boolean e(g paramg)
  {
    AppMethodBeat.i(150408);
    boolean bool = b(paramg, -1);
    AppMethodBeat.o(150408);
    return bool;
  }
  
  public final boolean f(g paramg)
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
    paramg.gbt = true;
    com.tencent.e.h.ZvG.d(new b.9(this, paramg), "MicroMsg.Cdn.ThreadName");
    AppMethodBeat.o(150409);
    return true;
  }
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150416);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.CdnTransportService", "cdn callback decodePrepareResponse mediaid is null");
      AppMethodBeat.o(150416);
      return null;
    }
    g localg = (g)this.lHS.get(paramString);
    if (localg == null)
    {
      Log.e("MicroMsg.CdnTransportService", " decodePrepareResponse task in jni get info failed mediaid:%s", new Object[] { paramString });
      AppMethodBeat.o(150416);
      return null;
    }
    if (localg.iUG != null)
    {
      paramString = localg.iUG.f(paramString, paramArrayOfByte);
      AppMethodBeat.o(150416);
      return paramString;
    }
    Log.e("MicroMsg.CdnTransportService", "decodePrepareResponse fail, null taskcallback.");
    AppMethodBeat.o(150416);
    return null;
  }
  
  public final void go(boolean paramBoolean)
  {
    AppMethodBeat.i(150412);
    if ((!paramBoolean) && (f.bkh().bjW()))
    {
      com.tencent.mm.kernel.h.aHE();
      if (com.tencent.mm.kernel.b.aGL())
      {
        Log.w("MicroMsg.CdnTransportService", "summersafecdn cdntra Not init cdn dnsinfo , will retry after set info");
        f.bkd().vS(4);
        AppMethodBeat.o(150412);
        return;
      }
    }
    bjX();
    Log.i("MicroMsg.CdnTransportService", "summersafecdn tryStart queue:%d", new Object[] { Integer.valueOf(this.lHQ.size()) });
    Object localObject1;
    Object localObject3;
    label216:
    int j;
    label226:
    Object localObject2;
    if (!this.lHQ.isEmpty())
    {
      localObject1 = (String)this.lHQ.poll();
      localObject3 = (g)this.lHR.remove(localObject1);
      if (localObject3 == null)
      {
        Log.e("MicroMsg.CdnTransportService", "summersafecdn task queue is empty , maybe bug here");
        AppMethodBeat.o(150412);
        return;
      }
      Log.i("MicroMsg.CdnTransportService", "summersafecdn id:%s cdnautostart :%s chatroom:%s", new Object[] { ((g)localObject3).field_mediaId, Boolean.valueOf(((g)localObject3).field_autostart), Integer.valueOf(((g)localObject3).field_chattype) });
      ((g)localObject3).field_startTime = Util.nowMilliSecond();
      if (((g)localObject3).gbt)
      {
        String str;
        if (((g)localObject3).field_fullpath == null)
        {
          i = -1;
          if (((g)localObject3).field_thumbpath != null) {
            break label623;
          }
          j = -1;
          Log.i("MicroMsg.CdnTransportService", "summersafecdn tryStart send file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b] largesvideo[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Util.secPrint(((g)localObject3).field_svr_signature), Util.secPrint(((g)localObject3).field_aesKey), Integer.valueOf(((g)localObject3).field_fileType), ((g)localObject3).field_mediaId, Boolean.valueOf(((g)localObject3).field_onlycheckexist), Integer.valueOf(((g)localObject3).field_largesvideo) });
          if (((g)localObject3).field_fullpath == null) {
            ((g)localObject3).field_fullpath = "";
          }
          if (((g)localObject3).field_thumbpath == null) {
            ((g)localObject3).field_thumbpath = "";
          }
          localObject1 = (g)this.lHS.put(((g)localObject3).field_mediaId, localObject3);
          localObject2 = (g)this.lHS.get(((g)localObject3).field_mediaId);
          if (localObject2 == null) {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(594L, 5L, 1L, true);
          }
          i = f.bkh().b((g)localObject3);
          str = ((g)localObject3).field_mediaId;
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
        for (localObject2 = null;; localObject2 = ((g)localObject2).field_mediaId)
        {
          Log.i("MicroMsg.CdnTransportService", "summersafecdn startupUploadMedia ok, field_mediaId[%s] ret[%s, %s, %s] hash[%s]", new Object[] { str, Integer.valueOf(i), localObject1, localObject2, Integer.valueOf(hashCode()) });
          if (i == 0) {
            break;
          }
          Log.e("MicroMsg.CdnTransportService", "summersafecdn startupUploadMedia error:%d clientid:%s", new Object[] { Integer.valueOf(i), ((g)localObject3).field_mediaId });
          if (-21005 != i)
          {
            localObject1 = (g)this.lHS.remove(((g)localObject3).field_mediaId);
            Log.e("MicroMsg.CdnTransportService", "summersafecdn startupUploadMedia error:%d clientid:%s remove[%s]", new Object[] { Integer.valueOf(i), ((g)localObject3).field_mediaId, localObject1 });
          }
          if (((g)localObject3).iUG == null) {
            break;
          }
          ((g)localObject3).iUG.a(((g)localObject3).field_mediaId, i, null, null, ((g)localObject3).field_onlycheckexist);
          break;
          i = ((g)localObject3).field_fullpath.length();
          break label216;
          label623:
          j = ((g)localObject3).field_thumbpath.length();
          break label226;
          label635:
          localObject1 = ((g)localObject1).field_mediaId;
          break label432;
        }
      }
      j = -1;
      if (((g)localObject3).field_fileType == 40001) {
        i = f.bkh().a(((g)localObject3).field_mediaId, ((g)localObject3).iUJ, ((g)localObject3).field_fullpath, ((g)localObject3).field_fileType, ((g)localObject3).field_aesKey, ((g)localObject3).field_authKey, ((g)localObject3).field_totalLen, false);
      }
      for (;;)
      {
        label711:
        if (i != 0)
        {
          Log.e("MicroMsg.CdnTransportService", "summersafecdn startupDownloadMedia error:%d clientid:%s", new Object[] { Integer.valueOf(i), ((g)localObject3).field_mediaId });
          if (((g)localObject3).iUG == null) {
            break;
          }
          ((g)localObject3).iUG.a(((g)localObject3).field_mediaId, i, null, null, ((g)localObject3).field_onlycheckexist);
          break;
          if (((g)localObject3).field_fileType == 19)
          {
            paramBoolean = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vXm, false);
            i = f.bkh().a(((g)localObject3).field_mediaId, ((g)localObject3).iUJ, ((g)localObject3).field_fullpath, ((g)localObject3).field_fileType, ((g)localObject3).field_aesKey, ((g)localObject3).field_authKey, ((g)localObject3).field_totalLen, paramBoolean);
          }
          else if ((((g)localObject3).field_fileType == com.tencent.mm.i.a.iUi) || (((g)localObject3).field_fileType == com.tencent.mm.i.a.iUk) || (((g)localObject3).field_fileType == com.tencent.mm.i.a.iUo))
          {
            if ((((g)localObject3).field_fullpath == null) || (((g)localObject3).field_fullpath.isEmpty())) {
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
    for (int i = f.bkh().a(((g)localObject3).field_mediaId, ((g)localObject3).iUJ, ((g)localObject3).field_fullpath, ((g)localObject3).field_fileType, ((g)localObject3).iUK, ((g)localObject3).iUL, ((g)localObject3).iUM, ((g)localObject3).iUN, ((g)localObject3).iUU, ((g)localObject3).iUV);; i = -1)
    {
      if (((g)localObject3).field_fullpath == null) {}
      for (j = -1;; j = ((g)localObject3).field_fullpath.length())
      {
        Log.i("MicroMsg.CdnTransportService", "url download tryStart recv file:%d field_mediaId[%s], download_url[%s], filetype:[%d]", new Object[] { Integer.valueOf(j), ((g)localObject3).field_mediaId, ((g)localObject3).iUJ, Integer.valueOf(((g)localObject3).field_fileType) });
        break;
      }
      if (((g)localObject3).iUP)
      {
        i = j;
        if (((g)localObject3).field_fullpath != null)
        {
          i = j;
          if (!((g)localObject3).field_fullpath.isEmpty()) {
            i = f.bkh().a(((g)localObject3).field_mediaId, ((g)localObject3).field_fullpath, ((g)localObject3).iUJ, ((g)localObject3).iUQ, ((g)localObject3).iUR, ((g)localObject3).allow_mobile_net_download, ((g)localObject3).iUK, ((g)localObject3).iUL, ((g)localObject3).is_resume_task, ((g)localObject3).iUO, ((g)localObject3).iUM);
          }
        }
        if (((g)localObject3).field_fullpath == null) {}
        for (j = -1;; j = ((g)localObject3).field_fullpath.length())
        {
          Log.i("MicroMsg.CdnTransportService", "game package download tryStart recv file:%d field_mediaId[%s], download_url[%s] https url[%s]", new Object[] { Integer.valueOf(j), ((g)localObject3).field_mediaId, ((g)localObject3).iUJ, ((g)localObject3).iUQ });
          break;
        }
      }
      if (((g)localObject3).iUS)
      {
        if ((localObject3 instanceof com.tencent.mm.i.f))
        {
          localObject1 = (com.tencent.mm.i.f)localObject3;
          i = f.bkh().a((com.tencent.mm.i.f)localObject1);
          break label711;
        }
        if (!(localObject3 instanceof e)) {
          break label1708;
        }
        localObject1 = (e)localObject3;
        i = f.bkh().a((e)localObject1);
        break label711;
      }
      if (((g)localObject3).field_fullpath == null)
      {
        i = -1;
        label1268:
        if (((g)localObject3).field_thumbpath != null) {
          break label1412;
        }
      }
      for (int k = -1;; k = ((g)localObject3).field_thumbpath.length())
      {
        Log.i("MicroMsg.CdnTransportService", "summersafecdn tryStart recv file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b]", new Object[] { Integer.valueOf(i), Integer.valueOf(k), ((g)localObject3).field_svr_signature, ((g)localObject3).field_aesKey, Integer.valueOf(((g)localObject3).field_fileType), ((g)localObject3).field_mediaId, Boolean.valueOf(((g)localObject3).field_onlycheckexist) });
        if (((g)localObject3).iUW != 2) {
          break label1539;
        }
        if (!(localObject3 instanceof com.tencent.mm.i.h)) {
          break label1708;
        }
        localObject1 = (com.tencent.mm.i.h)localObject3;
        if (!((com.tencent.mm.i.h)localObject1).arP()) {
          break label1425;
        }
        i = f.bkh().a((g)localObject3, 2);
        break;
        i = ((g)localObject3).field_fullpath.length();
        break label1268;
      }
      if (((com.tencent.mm.i.h)localObject1).arN())
      {
        ((com.tencent.mm.i.h)localObject1).connectionCount = 1;
        ((com.tencent.mm.i.h)localObject1).concurrentCount = 1;
        i = f.bkh().a((com.tencent.mm.i.h)localObject1);
        break label711;
      }
      if (((com.tencent.mm.i.h)localObject1).arO())
      {
        i = f.bkh().d((com.tencent.mm.i.h)localObject1);
        break label711;
      }
      if (((com.tencent.mm.i.h)localObject1).arS())
      {
        i = f.bkh().b((com.tencent.mm.i.h)localObject1);
        break label711;
      }
      if (((com.tencent.mm.i.h)localObject1).arU())
      {
        i = f.bkh().d((com.tencent.mm.i.h)localObject1);
        break label711;
      }
      i = j;
      if (((com.tencent.mm.i.h)localObject1).arT()) {
        i = f.bkh().c((com.tencent.mm.i.h)localObject1);
      }
      break label711;
      i = f.bkh().c((g)localObject3);
      break label711;
      localObject1 = (g)this.lHS.put(((g)localObject3).field_mediaId, localObject3);
      localObject2 = (g)this.lHS.get(((g)localObject3).field_mediaId);
      if (localObject2 == null) {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(594L, 6L, 1L, true);
      }
      localObject3 = ((g)localObject3).field_mediaId;
      if (localObject1 == null)
      {
        localObject1 = null;
        label1625:
        if (localObject2 != null) {
          break label1691;
        }
      }
      for (localObject2 = null;; localObject2 = ((g)localObject2).field_mediaId)
      {
        Log.i("MicroMsg.CdnTransportService", "summersafecdn startupDownloadMedia ok, field_mediaId[%s] ret[%s, %s, %s] hash[%s]", new Object[] { localObject3, Integer.valueOf(i), localObject1, localObject2, Integer.valueOf(hashCode()) });
        break;
        localObject1 = ((g)localObject1).field_mediaId;
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
    if (!com.tencent.mm.kernel.h.aHE().aGM())
    {
      AppMethodBeat.o(150403);
      return;
    }
    int i = Util.nullAsInt(paramObject, 0);
    Log.d("MicroMsg.CdnTransportService", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramMStorageEx });
    if ((paramMStorageEx != com.tencent.mm.kernel.h.aHG().aHp()) || (i <= 0))
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
    f.bkd().vS(10);
    AppMethodBeat.o(150403);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(150404);
    if (paramq.getType() != 379)
    {
      AppMethodBeat.o(150404);
      return;
    }
    Log.d("MicroMsg.CdnTransportService", "cdntra onSceneEnd it will tryStart sceneType:%d [%d,%d]", new Object[] { Integer.valueOf(paramq.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (com.tencent.mm.kernel.h.aHE().aGM()) {
      com.tencent.e.h.ZvG.d(new b.7(this), "MicroMsg.Cdn.ThreadName");
    }
    AppMethodBeat.o(150404);
  }
  
  public final void vR(int paramInt)
  {
    this.lHI = paramInt;
  }
  
  static final class a
  {
    public long endTime;
    public String field_mediaId;
    public int field_totalLen;
    public boolean gbt;
    public int gel;
    public int gem;
    public int gen;
    public int geo;
    public int gep;
    public int geq;
    public int ger;
    public int ges;
    public String get;
    public int geu;
    public int gev;
    public String lIh;
    public long lIi;
    public long startTime;
    public String taskName;
    public long threadId;
    
    public a(String paramString1, String paramString2, String paramString3, long paramLong, g paramg)
    {
      AppMethodBeat.i(220214);
      this.lIh = "";
      this.taskName = "task_default";
      this.field_mediaId = "";
      this.field_totalLen = 0;
      this.startTime = 0L;
      this.endTime = -1L;
      this.threadId = 0L;
      this.gel = 0;
      this.gem = 0;
      this.gen = 0;
      this.geo = 0;
      this.gep = 0;
      this.geq = 0;
      this.ger = 0;
      this.ges = 0;
      this.get = "";
      this.geu = 0;
      this.gev = 0;
      this.lIi = 0L;
      this.lIh = paramString1;
      this.taskName = paramString2;
      this.field_mediaId = paramString3;
      this.gbt = paramg.gbt;
      this.field_totalLen = paramg.field_totalLen;
      this.startTime = paramLong;
      this.threadId = Thread.currentThread().getId();
      this.gel = paramg.field_fileType;
      this.gem = paramg.field_appType;
      this.gen = paramg.field_bzScene;
      this.geo = paramg.hDp;
      this.gep = paramg.field_chattype;
      this.geq = paramg.field_advideoflag;
      this.ger = paramg.field_largesvideo;
      this.ges = paramg.field_requestVideoFormat;
      this.get = Util.nullAs(paramg.field_snsScene, "");
      if (paramg.iUS) {
        i = 1;
      }
      this.geu = i;
      this.gev = paramg.iUX;
      this.lIi = System.currentTimeMillis();
      AppMethodBeat.o(220214);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(220216);
      String str = "CdnTaskReportInfo{cdnCallbackReportId='" + this.lIh + '\'' + ", taskName='" + this.taskName + '\'' + ", field_mediaId='" + this.field_mediaId + '\'' + ", isSend=" + this.gbt + ", field_totalLen=" + this.field_totalLen + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", threadId=" + this.threadId + ", _FileType=" + this.gel + ", _AppType=" + this.gem + ", _BzScene=" + this.gen + ", _BizType=" + this.geo + ", _Chattype=" + this.gep + ", _Advideoflag=" + this.geq + ", _Largesvideo=" + this.ger + ", _RequestVideoFormat=" + this.ges + ", _SnsScene='" + this.get + '\'' + ", _SnsImageDownload=" + this.geu + ", _VideoTaskType=" + this.gev + ", localTime=" + this.lIi + '}';
      AppMethodBeat.o(220216);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.aq.b
 * JD-Core Version:    0.7.0.1
 */