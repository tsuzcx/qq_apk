package com.tencent.mm.an;

import android.os.Looper;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.Config;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.app.o.a;
import com.tencent.mm.g.a.mb;
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
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

public final class b
  implements com.tencent.mm.ak.i, com.tencent.mm.i.b, com.tencent.mm.i.b.a, MStorageEx.IOnStorageChange
{
  private static final long[] iRF = { 0L, 2L, 5L, 7L, 10L, 15L, 20L, 30L, 50L, 70L, 100L, 200L, 400L, 600L, 800L, 1000L, 3000L, 5000L, 10000L, 20000L, 30000L, 40000L, 50000L, 60000L, 120000L };
  private static final int[] iRG = { 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34 };
  private static int iRH = -1;
  private static long iRI = -1L;
  public o.a appForegroundListener;
  public Map<String, com.tencent.mm.i.g> iRA;
  public Map<String, Integer> iRB;
  private String iRC;
  private long iRD;
  public HashSet<String> iRE;
  private int iRq;
  MMHandler iRr;
  IListener<mb> iRs;
  p iRt;
  private ConcurrentHashMap<String, a> iRu;
  final MTimerHandler iRv;
  ConcurrentHashMap<String, String> iRw;
  private boolean iRx;
  private Queue<String> iRy;
  public Map<String, com.tencent.mm.i.g> iRz;
  
  public b()
  {
    AppMethodBeat.i(150406);
    this.iRq = -1;
    this.iRr = new b.1(this, Looper.getMainLooper());
    this.iRs = new b.3(this);
    this.iRt = new b.4(this);
    this.iRu = new ConcurrentHashMap();
    this.iRv = new MTimerHandler(Looper.getMainLooper(), new b.5(this), true);
    this.appForegroundListener = new b.6(this);
    this.iRw = new ConcurrentHashMap();
    this.iRx = com.tencent.mm.ap.a.isActive();
    this.iRy = new LinkedList();
    this.iRz = new HashMap();
    this.iRA = new ConcurrentHashMap();
    this.iRB = new HashMap();
    this.iRC = "";
    this.iRD = 0L;
    this.iRE = new HashSet();
    com.tencent.mm.kernel.g.aAg().a(this.iRt);
    if (com.tencent.mm.kernel.g.aAf().azp()) {
      com.tencent.mm.kernel.g.aAh().azQ().add(this);
    }
    com.tencent.mm.kernel.g.azz().a(379, this);
    EventCenter.instance.addListener(this.iRs);
    if (baJ())
    {
      this.appForegroundListener.alive();
      this.iRv.startTimer(60000L);
    }
    Log.i("MicroMsg.CdnTransportService", "summersafecdn CdnTransportService init[%s] stack[%s]", new Object[] { Integer.valueOf(hashCode()), Util.getStack() });
    AppMethodBeat.o(150406);
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(223559);
    if (parama == null)
    {
      AppMethodBeat.o(223559);
      return;
    }
    long l = parama.endTime - parama.startTime;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(z(5, l));
    int k = 10;
    int i = iRF.length - 1;
    for (;;)
    {
      int j = k;
      if (i >= 0)
      {
        if (l >= iRF[i]) {
          j = iRG[i];
        }
      }
      else
      {
        localArrayList.add(z(j, 1L));
        localArrayList.add(z(0, 1L));
        com.tencent.mm.plugin.report.e.Cxv.b(localArrayList, false);
        Log.i("MicroMsg.CdnTransportService", "reportCDNCallbackTime(%s) taskName:%s cdnCallbackReportId:%s mediaId:%s duration:%s(%s-%s)", new Object[] { Long.valueOf(parama.threadId), parama.taskName, Util.nullAs(parama.iRP, ""), Util.nullAs(parama.field_mediaId, ""), Long.valueOf(l), Long.valueOf(parama.startTime), Long.valueOf(parama.endTime) });
        AppMethodBeat.o(223559);
        return;
      }
      i -= 1;
    }
  }
  
  public static boolean baJ()
  {
    AppMethodBeat.i(223561);
    String str = com.tencent.mm.plugin.expt.h.d.cRY().b("clicfg_cdn_callback_consume_time_statistics_switch", "1", false, true);
    Log.d("MicroMsg.CdnTransportService", "canCDNCallbackStatistics() sw:%s", new Object[] { str });
    boolean bool = Util.isEqual(str, "1");
    AppMethodBeat.o(223561);
    return bool;
  }
  
  private static int baK()
  {
    AppMethodBeat.i(223562);
    if (iRH == -1)
    {
      String str = com.tencent.mm.plugin.expt.h.d.cRY().b("clicfg_cdn_callback_tag_max_num", "1", false, true);
      Log.d("MicroMsg.CdnTransportService", "getTagMaxNum() maxNum:%s", new Object[] { str });
      iRH = Util.getInt(str, 1);
    }
    int i = iRH;
    AppMethodBeat.o(223562);
    return i;
  }
  
  private String g(com.tencent.mm.i.g paramg)
  {
    AppMethodBeat.i(223558);
    if ((paramg == null) || (Util.isNullOrNil(paramg.taskName)))
    {
      AppMethodBeat.o(223558);
      return "MicroMsg.CdnTransportService";
    }
    if (this.iRw.containsKey(paramg.taskName))
    {
      paramg = (String)this.iRw.get(paramg.taskName);
      AppMethodBeat.o(223558);
      return paramg;
    }
    String str = "MicroMsg.CdnTransportService_" + (this.iRw.size() + 1) % baK();
    this.iRw.put(paramg.taskName, str);
    Log.i("MicroMsg.CdnTransportService", "taskName:%s tag:%s", new Object[] { Util.nullAs(paramg.taskName, ""), Util.nullAs(str, "") });
    AppMethodBeat.o(223558);
    return str;
  }
  
  public static boolean sS(int paramInt)
  {
    AppMethodBeat.i(150405);
    com.tencent.mm.kernel.g.aAf();
    if (com.tencent.mm.kernel.a.azo())
    {
      int k = Util.nullAs((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(144385, null), 0);
      int i = com.tencent.mm.n.h.aqJ().getInt("CDNGrayscaleBitMask", 0);
      int j = com.tencent.mm.n.h.aqJ().getInt("CDNGrayscaleBitVal", 0);
      k = k & (i ^ 0xFFFFFFFF) | j & i;
      Log.d("MicroMsg.CdnTransportService", "summersafecdn cdntra cdnBitSet:%d grayScaleFlag:%d res:%d Test.forceCDNTrans:%b, CDNGrayscaleBitMask:%d, CDNGrayscaleBitVal:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt), Integer.valueOf(k & paramInt), Boolean.valueOf(ac.jOw), Integer.valueOf(i), Integer.valueOf(j) });
      if (ac.jOw)
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
    AppMethodBeat.i(223560);
    IDKey localIDKey = new IDKey();
    localIDKey.SetID(1452);
    localIDKey.SetKey(paramInt);
    localIDKey.SetValue(paramLong);
    AppMethodBeat.o(223560);
    return localIDKey;
  }
  
  public final boolean Ob(String paramString)
  {
    AppMethodBeat.i(150410);
    com.tencent.mm.i.g localg = (com.tencent.mm.i.g)this.iRA.remove(paramString);
    if (localg != null)
    {
      f.baR();
      a.NT(paramString);
      com.tencent.mm.plugin.report.service.h.CyF.a(10769, new Object[] { Integer.valueOf(c.iSc), Integer.valueOf(localg.field_fileType), Long.valueOf(Util.nowMilliSecond() - localg.field_startTime) });
    }
    this.iRz.remove(paramString);
    Log.i("MicroMsg.CdnTransportService", "summersafecdn cdntra cancelSendTask mediaid:%s mapremove:%s engine ret:%d", new Object[] { paramString, localg, Integer.valueOf(0) });
    AppMethodBeat.o(150410);
    return true;
  }
  
  public final boolean Oc(String paramString)
  {
    AppMethodBeat.i(150411);
    com.tencent.mm.i.g localg = (com.tencent.mm.i.g)this.iRA.remove(paramString);
    if (localg != null)
    {
      if ((localg.field_fileType != com.tencent.mm.i.a.gqa) && (localg.field_fileType != com.tencent.mm.i.a.gqc) && (localg.field_fileType != com.tencent.mm.i.a.gqg)) {
        break label167;
      }
      f.baR();
      a.NY(paramString);
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.CyF.a(10769, new Object[] { Integer.valueOf(c.iSb), Integer.valueOf(localg.field_fileType), Long.valueOf(Util.nowMilliSecond() - localg.field_startTime) });
      this.iRz.remove(paramString);
      this.iRB.remove(paramString);
      Log.i("MicroMsg.CdnTransportService", "summersafecdn cdntra cancelRecvTask mediaid:%s mapremove:%s engine ret:%d", new Object[] { paramString, localg, Integer.valueOf(0) });
      AppMethodBeat.o(150411);
      return true;
      label167:
      if (localg.gqH)
      {
        f.baR();
        a.NZ(paramString);
      }
      else
      {
        f.baR();
        a.NU(paramString);
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
    this.iRD = Util.nowMilliSecond();
    this.iRC = paramString;
    com.tencent.f.h.RTc.b(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(223552);
        Object localObject = (com.tencent.mm.i.g)b.h(b.this).get(paramString);
        if (localObject == null)
        {
          Log.d("MicroMsg.CdnTransportService", " task in jni get info failed mediaid[%s] hash[%s]", new Object[] { paramString, Integer.valueOf(b.this.hashCode()) });
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(594L, 7L, 1L, true);
          AppMethodBeat.o(223552);
          return;
        }
        b.a locala = b.a(b.this, (com.tencent.mm.i.g)localObject);
        if (paramc != null)
        {
          paramc.mediaId = paramString;
          Log.i("MicroMsg.CdnTransportService", "MTL: total:%d, cur:%d, mtl:%b", new Object[] { Long.valueOf(paramc.field_toltalLength), Long.valueOf(paramc.field_finishedLength), Boolean.valueOf(paramc.field_mtlnotify) });
        }
        if (paramd != null) {
          paramd.mediaId = paramString;
        }
        if (((com.tencent.mm.i.g)localObject).gqy != null)
        {
          long l = Util.nowMilliSecond();
          if ((paramd == null) && (paramc != null) && (!paramc.field_mtlnotify) && (NetStatusUtil.getNetWorkType(MMApplicationContext.getContext()) == -1))
          {
            b.a(b.this, locala);
            AppMethodBeat.o(223552);
            return;
          }
          ((com.tencent.mm.i.g)localObject).field_lastProgressCallbackTime = l;
          ((com.tencent.mm.i.g)localObject).gqy.a(paramString, 0, paramc, paramd, ((com.tencent.mm.i.g)localObject).field_onlycheckexist);
        }
        if ((localObject instanceof com.tencent.mm.i.f)) {}
        for (localObject = (com.tencent.mm.i.f)localObject;; localObject = null)
        {
          if ((b.a(paramc)) && ((localObject == null) || (((com.tencent.mm.i.f)localObject).alN()))) {
            b.e(b.this).remove(paramString);
          }
          if (paramd != null)
          {
            if ((localObject == null) || (((com.tencent.mm.i.f)localObject).alN())) {
              b.h(b.this).remove(paramString);
            }
            if (paramd.field_retCode == -5103011)
            {
              Log.i("MicroMsg.CdnTransportService", "summersafecdn ERR_VALIDATE_AUTHKEY");
              com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(546L, 4L, 1L, true);
              f.baR().keep_OnRequestDoGetCdnDnsInfo(999);
            }
          }
          b.b(b.this, locala);
          AppMethodBeat.o(223552);
          return;
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(223553);
        String str = super.toString() + "|callback";
        AppMethodBeat.o(223553);
        return str;
      }
    }, g((com.tencent.mm.i.g)this.iRA.get(paramString)));
    AppMethodBeat.o(150414);
    return 0;
  }
  
  public final int a(final String paramString, final com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(223557);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(223557);
      return 0;
    }
    com.tencent.f.h.RTc.b(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(223546);
        com.tencent.mm.i.g localg = (com.tencent.mm.i.g)b.h(b.this).get(paramString);
        if (localg == null)
        {
          Log.d("MicroMsg.CdnTransportService", " task in jni get info failed mediaid:%s", new Object[] { paramString });
          AppMethodBeat.o(223546);
          return;
        }
        if (localg.gqQ != null) {
          localg.gqQ.b(paramString, paramd);
        }
        AppMethodBeat.o(223546);
      }
    }, g((com.tencent.mm.i.g)this.iRA.get(paramString)));
    AppMethodBeat.o(223557);
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
    com.tencent.mm.i.g localg = (com.tencent.mm.i.g)this.iRA.get(paramString);
    if (localg == null)
    {
      Log.e("MicroMsg.CdnTransportService", " getauthbuf task in jni get info failed mediaid:%s", new Object[] { paramString });
      AppMethodBeat.o(150415);
      return;
    }
    if (localg.gqy != null)
    {
      localg.gqy.a(paramString, paramByteArrayOutputStream);
      AppMethodBeat.o(150415);
      return;
    }
    Log.e("MicroMsg.CdnTransportService", "getCdnAuthInfo fail, null taskcallback.");
    AppMethodBeat.o(150415);
  }
  
  public final boolean b(com.tencent.mm.i.g paramg, int paramInt)
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
    paramg.ehd = false;
    com.tencent.f.h.RTc.b(new b.8(this, paramInt, paramg), "MicroMsg.Cdn.ThreadName");
    AppMethodBeat.o(150407);
    return true;
  }
  
  public final void baI()
  {
    AppMethodBeat.i(150413);
    com.tencent.mm.kernel.g.aAf();
    CdnLogic.Config localConfig;
    Object localObject;
    String str1;
    String str2;
    String str3;
    String str4;
    String str5;
    String str6;
    String str7;
    if (com.tencent.mm.kernel.a.azo())
    {
      localConfig = new CdnLogic.Config();
      localObject = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("EnableCDNUploadImg");
      str1 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("EnableCDNVerifyConnect");
      str2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("EnableCDNVideoRedirectOC");
      str3 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("EnableStreamUploadVideo");
      str4 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("C2COverloadDelaySeconds");
      str5 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("SNSOverloadDelaySeconds");
      str6 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("EnableSnsStreamDownload");
      str7 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("EnableSnsImageDownload");
    }
    for (;;)
    {
      try
      {
        if (!Util.isNullOrNil((String)localObject)) {
          localConfig.UseStreamCDN = Integer.valueOf((String)localObject).intValue();
        }
        if (!Util.isNullOrNil(str1)) {
          localConfig.EnableCDNVerifyConnect = Integer.valueOf(str1).intValue();
        }
        if (!Util.isNullOrNil(str2)) {
          localConfig.EnableCDNVideoRedirectOC = Integer.valueOf(str2).intValue();
        }
        if (!Util.isNullOrNil(str3)) {
          localConfig.EnableStreamUploadVideo = Integer.valueOf(str3).intValue();
        }
        if (!Util.isNullOrNil(str4)) {
          localConfig.C2COverloadDelaySeconds = Integer.valueOf(str4).intValue();
        }
        if (!Util.isNullOrNil(str5)) {
          localConfig.SNSOverloadDelaySeconds = Integer.valueOf(str5).intValue();
        }
        if (!Util.isNullOrNil(str6)) {
          localConfig.EnableSnsStreamDownload = Integer.valueOf(str6).intValue();
        }
        if (!Util.isNullOrNil(str7)) {
          localConfig.EnableSnsImageDownload = Integer.valueOf(str7).intValue();
        }
        f.baQ();
        if (!sS(256)) {
          continue;
        }
        i = 1;
        localConfig.EnableSafeCDN = i;
        localConfig.EnableSnsVideoRedirect = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.sfh, 0);
        localConfig.ApprovedVideoHosts = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.sft, "vweixinf.tc.qq.com,szwbwxsns.video.qq.com,szxzwxsns.video.qq.com,szzjwxsns.video.qq.com,shwbwxsns.video.qq.com,shxzwxsns.video.qq.com,shzjwxsns.video.qq.com,wxsnsdy.wxs.qq.com,vweixinthumb.tc.qq.com,wxsnsdythumb.wxs.qq.com,wxappthumb.tc.qq.com,wxapp.tc.qq.com,wxsnsdysvp.wxs.qq.com");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("clicfg_android_channelvideo_quic=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.sfi, "0")).append(";");
        ((StringBuilder)localObject).append("clicfg_android_statusvideo_quic=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.sfj, "0")).append(";");
        ((StringBuilder)localObject).append("clicfg_android_snsvideo_quic=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.sfk, "0")).append(";");
        ((StringBuilder)localObject).append("clicfg_android_snsimage_quic=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.sfl, "0")).append(";");
        ((StringBuilder)localObject).append("clicfg_android_c2cvideo_quic=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.sfm, "0")).append(";");
        ((StringBuilder)localObject).append("clicfg_android_quic_bigfile=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.sfn, "0")).append(";");
        ((StringBuilder)localObject).append("clicfg_android_quic_fullimage=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.sfo, "0")).append(";");
        ((StringBuilder)localObject).append("clicfg_android_c2cimage2_quic=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.sfp, "0")).append(";");
        ((StringBuilder)localObject).append("clicfg_android_c2cfile_quic=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.sfq, "0")).append(";");
        ((StringBuilder)localObject).append("clicfg_android_quic_backup=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.sfr, "0")).append(";");
        ((StringBuilder)localObject).append("clicfg_android_quic_favorite=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.sfs, "0")).append(";");
        localConfig.QuicExptValues = ((StringBuilder)localObject).toString();
        Log.i("MicroMsg.CdnTransportService", "[quic.config] expt %s", new Object[] { localConfig.QuicExptValues });
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("clicfg_favriate_maxsize_mb=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.sfu, "1124")).append(";");
        ((StringBuilder)localObject).append("clicfg_snsvideo_maxsize_mb=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.sfv, "1124")).append(";");
        ((StringBuilder)localObject).append("clicfg_c2cvideo_maxsize_mb=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.sfw, "300")).append(";");
        ((StringBuilder)localObject).append("clicfg_bigfile_maxsize_mb=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.sfx, "1124")).append(";");
        ((StringBuilder)localObject).append("clicfg_channelvideo_maxsize_mb=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.sfy, "1124")).append(";");
        ((StringBuilder)localObject).append("clicfg_image_maxsize_mb=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.sfz, "56")).append(";");
        ((StringBuilder)localObject).append("clicfg_c2cfile_maxsize_mb=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.sfA, "56")).append(";");
        ((StringBuilder)localObject).append("clicfg_adimage_maxsize_mb=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.sfB, "100")).append(";");
        ((StringBuilder)localObject).append("clicfg_default_maxsize_mb=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.sfC, "4096")).append(";");
        ((StringBuilder)localObject).append("clicfg_wecom_maxsize_mb=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.sfD, "4096")).append(";");
        ((StringBuilder)localObject).append("clicfg_3rdhttp_maxsize_mb=").append(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.sfE, "4096")).append(";");
        localConfig.MiscellaneousExptValues = ((StringBuilder)localObject).toString();
        if (localConfig.UseStreamCDN != 0)
        {
          localObject = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("ProgJPEGUploadSizeLimitWifi");
          str1 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("ProgJPEGUploadSizeLimit3G");
          str2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("ProgJPEGDownloadSizeLimit");
          str3 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("EnableJPEGDyncmicETL");
          if (!Util.isNullOrNil((String)localObject)) {
            localConfig.WifiEtl = Integer.valueOf((String)localObject).intValue();
          }
          if (!Util.isNullOrNil(str1)) {
            localConfig.MobileEtl = Integer.valueOf(str1).intValue();
          }
          if (!Util.isNullOrNil(str2)) {
            localConfig.Ptl = Integer.valueOf(str2).intValue();
          }
          if (!Util.isNullOrNil(str3)) {
            localConfig.UseDynamicETL = Integer.valueOf(str3).intValue();
          }
        }
        if (this.iRq != -1)
        {
          Log.w("MicroMsg.CdnTransportService", "cmd set snsimage flag: %d", new Object[] { Integer.valueOf(this.iRq) });
          localConfig.EnableSnsImageDownload = this.iRq;
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
      if (ac.jOV)
      {
        Log.w("MicroMsg.CdnTransportService", "use cdn debug configure.");
        localConfig.UseStreamCDN = 1;
        localConfig.EnableSnsVideoRedirect = ac.jPb;
        Log.i("MicroMsg.CdnTransportService", "streamcdn config[DEBUG]:%s", new Object[] { localConfig });
        CdnLogic.setConfig(localConfig);
      }
      AppMethodBeat.o(150413);
      return;
      i = 0;
    }
  }
  
  public final boolean d(com.tencent.mm.i.g paramg)
  {
    AppMethodBeat.i(223556);
    if (paramg == null)
    {
      Log.e("MicroMsg.CdnTransportService", "addRecvTask task info is null");
      AppMethodBeat.o(223556);
      return false;
    }
    if (Util.isNullOrNil(paramg.field_mediaId))
    {
      Log.e("MicroMsg.CdnTransportService", "addRecvTask mediaId is null");
      AppMethodBeat.o(223556);
      return false;
    }
    if (paramg.field_fileId == null) {
      paramg.field_fileId = "";
    }
    if (paramg.field_aesKey == null) {
      paramg.field_aesKey = "";
    }
    paramg.ehd = false;
    Log.i("MicroMsg.CdnTransportService", "CdnTransportService cdn thread run %s", new Object[] { paramg.field_mediaId });
    this.iRy.add(paramg.field_mediaId);
    this.iRz.put(paramg.field_mediaId, paramg);
    fD(false);
    AppMethodBeat.o(223556);
    return true;
  }
  
  public final boolean e(com.tencent.mm.i.g paramg)
  {
    AppMethodBeat.i(150408);
    boolean bool = b(paramg, -1);
    AppMethodBeat.o(150408);
    return bool;
  }
  
  public final boolean f(com.tencent.mm.i.g paramg)
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
    paramg.ehd = true;
    com.tencent.f.h.RTc.b(new b.9(this, paramg), "MicroMsg.Cdn.ThreadName");
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
    com.tencent.mm.i.g localg = (com.tencent.mm.i.g)this.iRA.get(paramString);
    if (localg == null)
    {
      Log.e("MicroMsg.CdnTransportService", " decodePrepareResponse task in jni get info failed mediaid:%s", new Object[] { paramString });
      AppMethodBeat.o(150416);
      return null;
    }
    if (localg.gqy != null)
    {
      paramString = localg.gqy.f(paramString, paramArrayOfByte);
      AppMethodBeat.o(150416);
      return paramString;
    }
    Log.e("MicroMsg.CdnTransportService", "decodePrepareResponse fail, null taskcallback.");
    AppMethodBeat.o(150416);
    return null;
  }
  
  public final void fD(boolean paramBoolean)
  {
    AppMethodBeat.i(150412);
    if ((!paramBoolean) && (f.baR().baH()))
    {
      com.tencent.mm.kernel.g.aAf();
      if (com.tencent.mm.kernel.a.azo())
      {
        Log.w("MicroMsg.CdnTransportService", "summersafecdn cdntra Not init cdn dnsinfo , will retry after set info");
        f.baN().sU(4);
        AppMethodBeat.o(150412);
        return;
      }
    }
    baI();
    Log.i("MicroMsg.CdnTransportService", "summersafecdn tryStart queue:%d", new Object[] { Integer.valueOf(this.iRy.size()) });
    Object localObject1;
    Object localObject3;
    label216:
    int j;
    label226:
    Object localObject2;
    if (!this.iRy.isEmpty())
    {
      localObject1 = (String)this.iRy.poll();
      localObject3 = (com.tencent.mm.i.g)this.iRz.remove(localObject1);
      if (localObject3 == null)
      {
        Log.e("MicroMsg.CdnTransportService", "summersafecdn task queue is empty , maybe bug here");
        AppMethodBeat.o(150412);
        return;
      }
      Log.i("MicroMsg.CdnTransportService", "summersafecdn id:%s cdnautostart :%s chatroom:%s", new Object[] { ((com.tencent.mm.i.g)localObject3).field_mediaId, Boolean.valueOf(((com.tencent.mm.i.g)localObject3).field_autostart), Integer.valueOf(((com.tencent.mm.i.g)localObject3).field_chattype) });
      ((com.tencent.mm.i.g)localObject3).field_startTime = Util.nowMilliSecond();
      if (((com.tencent.mm.i.g)localObject3).ehd)
      {
        String str;
        if (((com.tencent.mm.i.g)localObject3).field_fullpath == null)
        {
          i = -1;
          if (((com.tencent.mm.i.g)localObject3).field_thumbpath != null) {
            break label623;
          }
          j = -1;
          Log.i("MicroMsg.CdnTransportService", "summersafecdn tryStart send file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b] largesvideo[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Util.secPrint(((com.tencent.mm.i.g)localObject3).field_svr_signature), Util.secPrint(((com.tencent.mm.i.g)localObject3).field_aesKey), Integer.valueOf(((com.tencent.mm.i.g)localObject3).field_fileType), ((com.tencent.mm.i.g)localObject3).field_mediaId, Boolean.valueOf(((com.tencent.mm.i.g)localObject3).field_onlycheckexist), Integer.valueOf(((com.tencent.mm.i.g)localObject3).field_largesvideo) });
          if (((com.tencent.mm.i.g)localObject3).field_fullpath == null) {
            ((com.tencent.mm.i.g)localObject3).field_fullpath = "";
          }
          if (((com.tencent.mm.i.g)localObject3).field_thumbpath == null) {
            ((com.tencent.mm.i.g)localObject3).field_thumbpath = "";
          }
          localObject1 = (com.tencent.mm.i.g)this.iRA.put(((com.tencent.mm.i.g)localObject3).field_mediaId, localObject3);
          localObject2 = (com.tencent.mm.i.g)this.iRA.get(((com.tencent.mm.i.g)localObject3).field_mediaId);
          if (localObject2 == null) {
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(594L, 5L, 1L, true);
          }
          i = f.baR().b((com.tencent.mm.i.g)localObject3);
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
          Log.i("MicroMsg.CdnTransportService", "summersafecdn startupUploadMedia ok, field_mediaId[%s] ret[%s, %s, %s] hash[%s]", new Object[] { str, Integer.valueOf(i), localObject1, localObject2, Integer.valueOf(hashCode()) });
          if (i == 0) {
            break;
          }
          Log.e("MicroMsg.CdnTransportService", "summersafecdn startupUploadMedia error:%d clientid:%s", new Object[] { Integer.valueOf(i), ((com.tencent.mm.i.g)localObject3).field_mediaId });
          if (-21005 != i)
          {
            localObject1 = (com.tencent.mm.i.g)this.iRA.remove(((com.tencent.mm.i.g)localObject3).field_mediaId);
            Log.e("MicroMsg.CdnTransportService", "summersafecdn startupUploadMedia error:%d clientid:%s remove[%s]", new Object[] { Integer.valueOf(i), ((com.tencent.mm.i.g)localObject3).field_mediaId, localObject1 });
          }
          if (((com.tencent.mm.i.g)localObject3).gqy == null) {
            break;
          }
          ((com.tencent.mm.i.g)localObject3).gqy.a(((com.tencent.mm.i.g)localObject3).field_mediaId, i, null, null, ((com.tencent.mm.i.g)localObject3).field_onlycheckexist);
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
        i = f.baR().a(((com.tencent.mm.i.g)localObject3).field_mediaId, ((com.tencent.mm.i.g)localObject3).gqB, ((com.tencent.mm.i.g)localObject3).field_fullpath, ((com.tencent.mm.i.g)localObject3).field_fileType, ((com.tencent.mm.i.g)localObject3).field_aesKey, ((com.tencent.mm.i.g)localObject3).field_authKey);
      }
      for (;;)
      {
        label705:
        if (i != 0)
        {
          Log.e("MicroMsg.CdnTransportService", "summersafecdn startupDownloadMedia error:%d clientid:%s", new Object[] { Integer.valueOf(i), ((com.tencent.mm.i.g)localObject3).field_mediaId });
          if (((com.tencent.mm.i.g)localObject3).gqy == null) {
            break;
          }
          ((com.tencent.mm.i.g)localObject3).gqy.a(((com.tencent.mm.i.g)localObject3).field_mediaId, i, null, null, ((com.tencent.mm.i.g)localObject3).field_onlycheckexist);
          break;
          if (((com.tencent.mm.i.g)localObject3).field_fileType == 19) {
            i = f.baR().a(((com.tencent.mm.i.g)localObject3).field_mediaId, ((com.tencent.mm.i.g)localObject3).gqB, ((com.tencent.mm.i.g)localObject3).field_fullpath, ((com.tencent.mm.i.g)localObject3).field_fileType, ((com.tencent.mm.i.g)localObject3).field_aesKey, ((com.tencent.mm.i.g)localObject3).field_authKey);
          } else if ((((com.tencent.mm.i.g)localObject3).field_fileType == com.tencent.mm.i.a.gqa) || (((com.tencent.mm.i.g)localObject3).field_fileType == com.tencent.mm.i.a.gqc) || (((com.tencent.mm.i.g)localObject3).field_fileType == com.tencent.mm.i.a.gqg)) {
            if ((((com.tencent.mm.i.g)localObject3).field_fullpath == null) || (((com.tencent.mm.i.g)localObject3).field_fullpath.isEmpty())) {
              break label1682;
            }
          }
        }
      }
    }
    label1677:
    label1682:
    for (int i = f.baR().a(((com.tencent.mm.i.g)localObject3).field_mediaId, ((com.tencent.mm.i.g)localObject3).gqB, ((com.tencent.mm.i.g)localObject3).field_fullpath, ((com.tencent.mm.i.g)localObject3).field_fileType, ((com.tencent.mm.i.g)localObject3).gqC, ((com.tencent.mm.i.g)localObject3).gqD, ((com.tencent.mm.i.g)localObject3).gqE, ((com.tencent.mm.i.g)localObject3).gqF, ((com.tencent.mm.i.g)localObject3).gqM, ((com.tencent.mm.i.g)localObject3).gqN);; i = -1)
    {
      if (((com.tencent.mm.i.g)localObject3).field_fullpath == null) {}
      for (j = -1;; j = ((com.tencent.mm.i.g)localObject3).field_fullpath.length())
      {
        Log.i("MicroMsg.CdnTransportService", "url download tryStart recv file:%d field_mediaId[%s], download_url[%s], filetype:[%d]", new Object[] { Integer.valueOf(j), ((com.tencent.mm.i.g)localObject3).field_mediaId, ((com.tencent.mm.i.g)localObject3).gqB, Integer.valueOf(((com.tencent.mm.i.g)localObject3).field_fileType) });
        break;
      }
      if (((com.tencent.mm.i.g)localObject3).gqH)
      {
        i = j;
        if (((com.tencent.mm.i.g)localObject3).field_fullpath != null)
        {
          i = j;
          if (!((com.tencent.mm.i.g)localObject3).field_fullpath.isEmpty()) {
            i = f.baR().a(((com.tencent.mm.i.g)localObject3).field_mediaId, ((com.tencent.mm.i.g)localObject3).field_fullpath, ((com.tencent.mm.i.g)localObject3).gqB, ((com.tencent.mm.i.g)localObject3).gqI, ((com.tencent.mm.i.g)localObject3).gqJ, ((com.tencent.mm.i.g)localObject3).allow_mobile_net_download, ((com.tencent.mm.i.g)localObject3).gqC, ((com.tencent.mm.i.g)localObject3).gqD, ((com.tencent.mm.i.g)localObject3).is_resume_task, ((com.tencent.mm.i.g)localObject3).gqG, ((com.tencent.mm.i.g)localObject3).gqE);
          }
        }
        if (((com.tencent.mm.i.g)localObject3).field_fullpath == null) {}
        for (j = -1;; j = ((com.tencent.mm.i.g)localObject3).field_fullpath.length())
        {
          Log.i("MicroMsg.CdnTransportService", "game package download tryStart recv file:%d field_mediaId[%s], download_url[%s] https url[%s]", new Object[] { Integer.valueOf(j), ((com.tencent.mm.i.g)localObject3).field_mediaId, ((com.tencent.mm.i.g)localObject3).gqB, ((com.tencent.mm.i.g)localObject3).gqI });
          break;
        }
      }
      if (((com.tencent.mm.i.g)localObject3).gqK)
      {
        if ((localObject3 instanceof com.tencent.mm.i.f))
        {
          localObject1 = (com.tencent.mm.i.f)localObject3;
          i = f.baR().a((com.tencent.mm.i.f)localObject1);
          break label705;
        }
        if (!(localObject3 instanceof com.tencent.mm.i.e)) {
          break label1677;
        }
        localObject1 = (com.tencent.mm.i.e)localObject3;
        i = f.baR().a((com.tencent.mm.i.e)localObject1);
        break label705;
      }
      if (((com.tencent.mm.i.g)localObject3).field_fullpath == null)
      {
        i = -1;
        label1237:
        if (((com.tencent.mm.i.g)localObject3).field_thumbpath != null) {
          break label1381;
        }
      }
      label1381:
      for (int k = -1;; k = ((com.tencent.mm.i.g)localObject3).field_thumbpath.length())
      {
        Log.i("MicroMsg.CdnTransportService", "summersafecdn tryStart recv file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b]", new Object[] { Integer.valueOf(i), Integer.valueOf(k), ((com.tencent.mm.i.g)localObject3).field_svr_signature, ((com.tencent.mm.i.g)localObject3).field_aesKey, Integer.valueOf(((com.tencent.mm.i.g)localObject3).field_fileType), ((com.tencent.mm.i.g)localObject3).field_mediaId, Boolean.valueOf(((com.tencent.mm.i.g)localObject3).field_onlycheckexist) });
        if (((com.tencent.mm.i.g)localObject3).gqO != 2) {
          break label1508;
        }
        if (!(localObject3 instanceof com.tencent.mm.i.h)) {
          break label1677;
        }
        localObject1 = (com.tencent.mm.i.h)localObject3;
        if (!((com.tencent.mm.i.h)localObject1).alQ()) {
          break label1394;
        }
        i = f.baR().a((com.tencent.mm.i.g)localObject3, 2);
        break;
        i = ((com.tencent.mm.i.g)localObject3).field_fullpath.length();
        break label1237;
      }
      label1394:
      if (((com.tencent.mm.i.h)localObject1).alO())
      {
        ((com.tencent.mm.i.h)localObject1).connectionCount = 1;
        ((com.tencent.mm.i.h)localObject1).concurrentCount = 1;
        i = f.baR().a((com.tencent.mm.i.h)localObject1);
        break label705;
      }
      if (((com.tencent.mm.i.h)localObject1).alP())
      {
        i = f.baR().d((com.tencent.mm.i.h)localObject1);
        break label705;
      }
      if (((com.tencent.mm.i.h)localObject1).alS())
      {
        i = f.baR().b((com.tencent.mm.i.h)localObject1);
        break label705;
      }
      if (((com.tencent.mm.i.h)localObject1).alU())
      {
        i = f.baR().d((com.tencent.mm.i.h)localObject1);
        break label705;
      }
      i = j;
      if (((com.tencent.mm.i.h)localObject1).alT()) {
        i = f.baR().c((com.tencent.mm.i.h)localObject1);
      }
      break label705;
      label1508:
      i = f.baR().c((com.tencent.mm.i.g)localObject3);
      break label705;
      localObject1 = (com.tencent.mm.i.g)this.iRA.put(((com.tencent.mm.i.g)localObject3).field_mediaId, localObject3);
      localObject2 = (com.tencent.mm.i.g)this.iRA.get(((com.tencent.mm.i.g)localObject3).field_mediaId);
      if (localObject2 == null) {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(594L, 6L, 1L, true);
      }
      localObject3 = ((com.tencent.mm.i.g)localObject3).field_mediaId;
      if (localObject1 == null)
      {
        localObject1 = null;
        label1594:
        if (localObject2 != null) {
          break label1660;
        }
      }
      label1660:
      for (localObject2 = null;; localObject2 = ((com.tencent.mm.i.g)localObject2).field_mediaId)
      {
        Log.i("MicroMsg.CdnTransportService", "summersafecdn startupDownloadMedia ok, field_mediaId[%s] ret[%s, %s, %s] hash[%s]", new Object[] { localObject3, Integer.valueOf(i), localObject1, localObject2, Integer.valueOf(hashCode()) });
        break;
        localObject1 = ((com.tencent.mm.i.g)localObject1).field_mediaId;
        break label1594;
      }
      AppMethodBeat.o(150412);
      return;
      i = -1;
      break label705;
    }
  }
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(150403);
    if (!com.tencent.mm.kernel.g.aAf().azp())
    {
      AppMethodBeat.o(150403);
      return;
    }
    int i = Util.nullAsInt(paramObject, 0);
    Log.d("MicroMsg.CdnTransportService", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramMStorageEx });
    if ((paramMStorageEx != com.tencent.mm.kernel.g.aAh().azQ()) || (i <= 0))
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
    f.baN().sU(10);
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
    if (com.tencent.mm.kernel.g.aAf().azp()) {
      com.tencent.f.h.RTc.b(new b.7(this), "MicroMsg.Cdn.ThreadName");
    }
    AppMethodBeat.o(150404);
  }
  
  public final void sT(int paramInt)
  {
    this.iRq = paramInt;
  }
  
  static final class a
  {
    public boolean ehd;
    public int ejG;
    public int ejH;
    public int ejI;
    public int ejJ;
    public int ejK;
    public int ejL;
    public int ejM;
    public int ejN;
    public String ejO;
    public int ejP;
    public int ejQ;
    public long endTime;
    public String field_mediaId;
    public int field_totalLen;
    public String iRP;
    public long iRQ;
    public long startTime;
    public String taskName;
    public long threadId;
    
    public a(String paramString1, String paramString2, String paramString3, long paramLong, com.tencent.mm.i.g paramg)
    {
      AppMethodBeat.i(223554);
      this.iRP = "";
      this.taskName = "task_default";
      this.field_mediaId = "";
      this.field_totalLen = 0;
      this.startTime = 0L;
      this.endTime = -1L;
      this.threadId = 0L;
      this.ejG = 0;
      this.ejH = 0;
      this.ejI = 0;
      this.ejJ = 0;
      this.ejK = 0;
      this.ejL = 0;
      this.ejM = 0;
      this.ejN = 0;
      this.ejO = "";
      this.ejP = 0;
      this.ejQ = 0;
      this.iRQ = 0L;
      this.iRP = paramString1;
      this.taskName = paramString2;
      this.field_mediaId = paramString3;
      this.ehd = paramg.ehd;
      this.field_totalLen = paramg.field_totalLen;
      this.startTime = paramLong;
      this.threadId = Thread.currentThread().getId();
      this.ejG = paramg.field_fileType;
      this.ejH = paramg.field_appType;
      this.ejI = paramg.field_bzScene;
      this.ejJ = paramg.fuQ;
      this.ejK = paramg.field_chattype;
      this.ejL = paramg.field_advideoflag;
      this.ejM = paramg.field_largesvideo;
      this.ejN = paramg.field_requestVideoFormat;
      this.ejO = Util.nullAs(paramg.field_snsScene, "");
      if (paramg.gqK) {
        i = 1;
      }
      this.ejP = i;
      this.ejQ = paramg.gqP;
      this.iRQ = System.currentTimeMillis();
      AppMethodBeat.o(223554);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(223555);
      String str = "CdnTaskReportInfo{cdnCallbackReportId='" + this.iRP + '\'' + ", taskName='" + this.taskName + '\'' + ", field_mediaId='" + this.field_mediaId + '\'' + ", isSend=" + this.ehd + ", field_totalLen=" + this.field_totalLen + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", threadId=" + this.threadId + ", _FileType=" + this.ejG + ", _AppType=" + this.ejH + ", _BzScene=" + this.ejI + ", _BizType=" + this.ejJ + ", _Chattype=" + this.ejK + ", _Advideoflag=" + this.ejL + ", _Largesvideo=" + this.ejM + ", _RequestVideoFormat=" + this.ejN + ", _SnsScene='" + this.ejO + '\'' + ", _SnsImageDownload=" + this.ejP + ", _VideoTaskType=" + this.ejQ + ", localTime=" + this.iRQ + '}';
      AppMethodBeat.o(223555);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.an.b
 * JD-Core Version:    0.7.0.1
 */