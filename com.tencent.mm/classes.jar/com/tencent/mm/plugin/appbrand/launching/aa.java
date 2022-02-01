package com.tencent.mm.plugin.appbrand.launching;

import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.cw.f;
import com.tencent.mm.cw.g;
import com.tencent.mm.f.b.a.oq;
import com.tencent.mm.f.b.a.pj;
import com.tencent.mm.f.b.a.pq;
import com.tencent.mm.f.b.a.pq.a;
import com.tencent.mm.plugin.appbrand.appcache.IPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.ae;
import com.tencent.mm.plugin.appbrand.appcache.al;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appcache.predownload.d.a.b;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaWidgetInfo;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.report.u;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ack;
import com.tencent.mm.protocal.protobuf.btv;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.a.e;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils;", "", "()V", "TAG", "", "WAGAME_TYPE", "", "getWAGAME_TYPE", "()I", "applyLaunchAheadParallelCgiResponse", "", "instanceId", "canUseSeparatedPlugins", "", "appId", "versionType", "appVersion", "isGame", "acceptedLibReader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "createBatchReporter", "Lcom/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor$IReporter;", "reportQualitySession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "isLaunch", "isForPreRender", "onPkgMissed", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "singleMapOf", "", "K", "V", "key", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;", "pickAppropriateWidgetInfoList", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaWidgetInfo;", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;", "BaseBatchGetCodeReporter", "plugin-appbrand-integration_release"})
public final class aa
{
  private static final int pVE = 1004;
  public static final aa pVF;
  
  static
  {
    AppMethodBeat.i(180606);
    pVF = new aa();
    pVE = 1004;
    AppMethodBeat.o(180606);
  }
  
  private static <K, V> Map<K, V> C(K paramK, V paramV)
  {
    AppMethodBeat.i(180605);
    ArrayMap localArrayMap = new ArrayMap();
    localArrayMap.put(paramK, paramV);
    paramK = (Map)localArrayMap;
    AppMethodBeat.o(180605);
    return paramK;
  }
  
  public static boolean S(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(254725);
    p.k(paramString, "appId");
    if (j.a.vB(paramInt1))
    {
      AppMethodBeat.o(254725);
      return true;
    }
    paramString = ((com.tencent.mm.plugin.appbrand.appcache.b)com.tencent.mm.plugin.appbrand.app.m.W(com.tencent.mm.plugin.appbrand.appcache.b.class)).be(paramString, paramInt2);
    switch (ab.$EnumSwitchMapping$0[paramString.ordinal()])
    {
    default: 
      AppMethodBeat.o(254725);
      return false;
    }
    AppMethodBeat.o(254725);
    return true;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "invoke", "()[Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "com/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils$applyLaunchAheadParallelCgiResponse$1$1$interceptResp$1"})
  static final class a
    extends q
    implements kotlin.g.a.a<btv[]>
  {
    a(x.a parama, HashMap paramHashMap)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
  public static final class b<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(180589);
      int i = kotlin.b.a.a((Comparable)Integer.valueOf(((WxaAttributes.WxaWidgetInfo)paramT2).fyH), (Comparable)Integer.valueOf(((WxaAttributes.WxaWidgetInfo)paramT1).fyH));
      AppMethodBeat.o(180589);
      return i;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils$BaseBatchGetCodeReporter;", "Lcom/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor$IReporter;", "()V", "callOnPkgCachedDefaultReportHandler", "", "reportQualitySession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "request", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "response", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "assignFromQualitySession", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualitySplitCodeLibStatisStruct;", "session", "plugin-appbrand-integration_release"})
  static abstract class c
    implements k.a
  {
    public static void a(pq parampq, QualitySession paramQualitySession)
    {
      p.k(parampq, "$this$assignFromQualitySession");
      p.k(paramQualitySession, "session");
      parampq.GD(paramQualitySession.appId);
      parampq.CC(paramQualitySession.qNx);
      parampq.a(pq.a.oN(paramQualitySession.qLQ));
      parampq.CD(paramQualitySession.apptype);
      parampq.GG(paramQualitySession.cBH);
      parampq.CG(paramQualitySession.scene);
    }
    
    public static void a(QualitySession paramQualitySession, w.d paramd, w.e parame)
    {
      Object localObject = null;
      p.k(paramQualitySession, "reportQualitySession");
      p.k(paramd, "request");
      p.k(parame, "response");
      if (((parame.pVo instanceof w.f.a)) && (((w.f.a)parame.pVo).bnA != 0))
      {
        localpj = new pj();
        localpj.Gq(paramQualitySession.cBH);
        localpj.Gr(paramQualitySession.appId);
        localpj.Ci(paramQualitySession.qNx);
        localpj.Cj(paramQualitySession.qLQ);
        localpj.Ck(paramQualitySession.scene);
        localpj.Gs(parame.pVn.checksumMd5());
        localpj.Gt(paramd.cAy);
        localpj.Cl(paramd.fyH);
        switch (((w.f.a)parame.pVo).bnA)
        {
        default: 
          localpj.bpa();
        }
      }
      while ((!(parame.pVo instanceof w.f.a)) || (((w.f.a)parame.pVo).bnA != 0)) {
        for (;;)
        {
          pj localpj;
          return;
          localpj.Cm(1L);
          continue;
          localpj.Cm(2L);
          paramd = paramd.pVk;
          paramQualitySession = paramd;
          if (!(paramd instanceof w.g.c)) {
            paramQualitySession = null;
          }
          paramd = (w.g.c)paramQualitySession;
          paramQualitySession = localObject;
          if (paramd != null) {
            paramQualitySession = String.valueOf(paramd.obN);
          }
          localpj.Gu(paramQualitySession);
        }
      }
      d.b("MicroMsg.AppBrand.PredownloadGetCodeStatStorage__report", (kotlin.g.a.a)new a.b((com.tencent.mm.plugin.appbrand.appcache.predownload.d.a)com.tencent.mm.plugin.appbrand.app.m.W(com.tencent.mm.plugin.appbrand.appcache.predownload.d.a.class), paramQualitySession.cBH, paramd.appId, parame.pVn.pkgVersion(), paramd.fyH, paramd.cAy));
    }
    
    public void a(w.d paramd)
    {
      p.k(paramd, "request");
      p.k(paramd, "request");
    }
    
    public void a(w.d paramd, w.e parame)
    {
      p.k(paramd, "request");
      p.k(parame, "response");
      p.k(paramd, "request");
      p.k(parame, "response");
      p.k(paramd, "request");
      p.k(parame, "response");
    }
    
    public void b(w.d paramd)
    {
      p.k(paramd, "request");
      p.k(paramd, "request");
      p.k(paramd, "request");
    }
    
    public void b(w.d paramd, w.e parame)
    {
      p.k(paramd, "request");
      p.k(parame, "response");
      p.k(paramd, "request");
      p.k(parame, "response");
      p.k(paramd, "request");
      p.k(parame, "response");
    }
    
    public void bZJ() {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(HashMap paramHashMap)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.b<w.d, x>
  {
    public static final e pVJ;
    
    static
    {
      AppMethodBeat.i(249558);
      pVJ = new e();
      AppMethodBeat.o(249558);
    }
    
    e()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils$createBatchReporter$2", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils$BaseBatchGetCodeReporter;", "TAG", "", "mIsColdStartUp", "", "mStageList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "com/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils$createBatchReporter$2.PluginInfo", "addPluginStage", "", "stage", "", "provider", "version", "markColdStartUp", "onAllPkgDownloaded", "onPkgCached", "request", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "response", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "onPkgDownloadError", "onPkgDownloadSuccess", "packageType", "onPkgMissed", "onPkgUpdated", "reportPkgDownloadStatus", "key", "reportPluginHitRate", "PluginInfo", "plugin-appbrand-integration_release"})
  public static final class f
    extends aa.c
  {
    final String TAG;
    private CopyOnWriteArrayList<a> pVK;
    private volatile boolean pVL;
    
    f(boolean paramBoolean, QualitySession paramQualitySession, ack paramack, kotlin.g.a.b paramb)
    {
      AppMethodBeat.i(266500);
      this.TAG = "MicroMsg.AppBrand.LaunchCheckPkgBatchGetCodeUtils.gameBatchReporter";
      this.pVK = new CopyOnWriteArrayList();
      AppMethodBeat.o(266500);
    }
    
    private static void BJ(int paramInt)
    {
      AppMethodBeat.i(266493);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(266493);
        return;
        BK(0);
        AppMethodBeat.o(266493);
        return;
        BK(9);
        AppMethodBeat.o(266493);
        return;
        BK(4);
        AppMethodBeat.o(266493);
        return;
        BK(2);
        AppMethodBeat.o(266493);
        return;
        BK(7);
        AppMethodBeat.o(266493);
        return;
        BK(11);
        AppMethodBeat.o(266493);
        return;
        BK(13);
      }
    }
    
    private static void BK(int paramInt)
    {
      AppMethodBeat.i(266494);
      h.IzE.idkeyStat(1027L, paramInt, 1L, false);
      AppMethodBeat.o(266494);
    }
    
    private final void bZV()
    {
      AppMethodBeat.i(266490);
      if (this.pVL)
      {
        AppMethodBeat.o(266490);
        return;
      }
      this.pVL = true;
      k(1, "", 0);
      AppMethodBeat.o(266490);
    }
    
    private final void k(int paramInt1, String paramString, int paramInt2)
    {
      AppMethodBeat.i(266492);
      Log.i(this.TAG, "addPluginStage stage:%d,provider:%s,version:%d", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2) });
      a locala = new a();
      locala.ajX(paramString);
      locala.fMU = paramInt1;
      locala.version = paramInt2;
      this.pVK.add(locala);
      AppMethodBeat.o(266492);
    }
    
    public final void a(w.d paramd)
    {
      AppMethodBeat.i(266496);
      p.k(paramd, "request");
      switch (paramd.fyH)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(266496);
        return;
        BK(1);
        AppMethodBeat.o(266496);
        return;
        BK(10);
        AppMethodBeat.o(266496);
        return;
        BK(5);
        AppMethodBeat.o(266496);
        return;
        BK(3);
        AppMethodBeat.o(266496);
        return;
        BK(8);
        AppMethodBeat.o(266496);
        return;
        BK(12);
        AppMethodBeat.o(266496);
        return;
        BK(14);
      }
    }
    
    public final void a(final w.d paramd, final w.e parame)
    {
      AppMethodBeat.i(266497);
      p.k(paramd, "request");
      p.k(parame, "response");
      if (((paramd.pVk instanceof w.g.b)) && (!((w.g.b)paramd.pVk).pVr))
      {
        arrayOfInt = com.tencent.mm.cx.a.YYB;
        p.j(arrayOfInt, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
        if (e.contains(arrayOfInt, paramd.fyH))
        {
          Log.i(this.TAG, "onPkgCached, will update plugin(" + paramd.appId + ") to latest in background...");
          d.h((kotlin.g.a.a)new b(this, paramd, parame));
        }
      }
      int[] arrayOfInt = com.tencent.mm.cx.a.YYB;
      p.j(arrayOfInt, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
      if (e.contains(arrayOfInt, paramd.fyH))
      {
        k(3, paramd.appId, parame.pVn.pkgVersion());
        g.ijP().i((com.tencent.mm.vending.c.a)new c(paramd, parame)).ieF();
      }
      a(this.pTU, paramd, parame);
      AppMethodBeat.o(266497);
    }
    
    public final void b(w.d paramd)
    {
      AppMethodBeat.i(266498);
      p.k(paramd, "request");
      this.pVN.invoke(paramd);
      int[] arrayOfInt = com.tencent.mm.cx.a.YYB;
      p.j(arrayOfInt, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
      if (e.contains(arrayOfInt, paramd.fyH))
      {
        if ((paramd.pVk instanceof w.g.c))
        {
          int k = paramd.pVk.bZT();
          arrayOfInt = com.tencent.mm.plugin.appbrand.app.m.bFP().adb(paramd.bZS().toString());
          if (arrayOfInt == null)
          {
            bZV();
            k(2, paramd.appId, k);
            BJ(paramd.fyH);
            AppMethodBeat.o(266498);
            return;
          }
          Collection localCollection = (Collection)new ArrayList();
          int m = arrayOfInt.length;
          int i = 0;
          if (i < m)
          {
            int n = arrayOfInt[i];
            if (n == paramd.pVk.bZT()) {}
            for (int j = 1;; j = 0)
            {
              if (j == 0) {
                localCollection.add(Integer.valueOf(n));
              }
              i += 1;
              break;
            }
          }
          if (!((Collection)localCollection).isEmpty()) {}
          for (i = 1;; i = 0)
          {
            if (i != 0)
            {
              bZV();
              k(4, paramd.appId, k);
              BJ(paramd.fyH);
            }
            AppMethodBeat.o(266498);
            return;
          }
        }
        bZV();
        k(2, paramd.appId, 0);
        BJ(paramd.fyH);
        AppMethodBeat.o(266498);
        return;
      }
      arrayOfInt = com.tencent.mm.cx.a.YYz;
      p.j(arrayOfInt, "ConstantsWxaPackageProto…KAGE_TYPES_IN_WIDGET_INFO");
      if (e.contains(arrayOfInt, paramd.fyH))
      {
        bZV();
        BJ(paramd.fyH);
      }
      AppMethodBeat.o(266498);
    }
    
    public final void b(w.d paramd, w.e parame)
    {
      AppMethodBeat.i(266499);
      p.k(paramd, "request");
      p.k(parame, "response");
      int[] arrayOfInt = com.tencent.mm.cx.a.YYB;
      p.j(arrayOfInt, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
      if (e.contains(arrayOfInt, paramd.fyH)) {
        al.bj(paramd.appId, parame.pVn.pkgVersion());
      }
      AppMethodBeat.o(266499);
    }
    
    public final void bZJ()
    {
      AppMethodBeat.i(266495);
      Log.i(this.TAG, "onAllPkgDownloaded isLaunch:%b", new Object[] { Boolean.valueOf(this.pVM) });
      if ((this.pVL) && (this.pVM) && (this.pVK != null) && (this.pVK.size() > 0))
      {
        Log.i(this.TAG, "mStageList size:%d", new Object[] { Integer.valueOf(this.pVK.size()) });
        Iterator localIterator = this.pVK.iterator();
        while (localIterator.hasNext())
        {
          a locala = (a)localIterator.next();
          pq localpq = new pq();
          a(localpq, this.pTU);
          localpq.GF(u.chI());
          localpq.GE(locala.provider);
          localpq.CE(locala.version);
          localpq.CF(locala.fMU);
          localpq.bpa();
        }
      }
      AppMethodBeat.o(266495);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils$createBatchReporter$2.PluginInfo", "", "(Lcom/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils$createBatchReporter$2;)V", "provider", "", "getProvider", "()Ljava/lang/String;", "setProvider", "(Ljava/lang/String;)V", "stage", "", "getStage", "()I", "setStage", "(I)V", "version", "getVersion", "setVersion", "plugin-appbrand-integration_release"})
    public final class a
    {
      int fMU;
      String provider = "";
      int version;
      
      public final void ajX(String paramString)
      {
        AppMethodBeat.i(277008);
        p.k(paramString, "<set-?>");
        this.provider = paramString;
        AppMethodBeat.o(277008);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class b
      extends q
      implements kotlin.g.a.a<x>
    {
      b(aa.f paramf, w.d paramd, w.e parame)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
    static final class c<_Ret, _Var>
      implements com.tencent.mm.vending.c.a<_Ret, _Var>
    {
      c(w.d paramd, w.e parame) {}
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils$createBatchReporter$3", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils$BaseBatchGetCodeReporter;", "TAG", "", "onPkgCached", "", "request", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "response", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "onPkgMissed", "onPkgUpdated", "plugin-appbrand-integration_release"})
  public static final class g
    extends aa.c
  {
    final String TAG = "MicroMsg.AppBrand.LaunchCheckPkgBatchGetCodeUtils.defaultBatchReporter";
    
    g(QualitySession paramQualitySession, ack paramack, kotlin.g.a.b paramb) {}
    
    public final void a(final w.d paramd, final w.e parame)
    {
      AppMethodBeat.i(278374);
      p.k(paramd, "request");
      p.k(parame, "response");
      if (((paramd.pVk instanceof w.g.b)) && (!((w.g.b)paramd.pVk).pVr))
      {
        localObject = com.tencent.mm.cx.a.YYB;
        p.j(localObject, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
        if (e.contains((int[])localObject, paramd.fyH))
        {
          Log.i(this.TAG, "onPkgCached, will update plugin(" + paramd.appId + ") to latest in background...");
          d.h((kotlin.g.a.a)new a(this, paramd, parame));
        }
      }
      Object localObject = com.tencent.mm.cx.a.YYB;
      p.j(localObject, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
      if (e.contains((int[])localObject, paramd.fyH))
      {
        localObject = new pq();
        a((pq)localObject, this.pTU);
        ((pq)localObject).GF(u.chI());
        ((pq)localObject).GE(paramd.appId);
        ((pq)localObject).CE(parame.pVn.pkgVersion());
        ((pq)localObject).CF(3L);
        ((pq)localObject).bpa();
        al.bj(paramd.appId, parame.pVn.pkgVersion());
      }
      a(this.pTU, paramd, parame);
      AppMethodBeat.o(278374);
    }
    
    public final void b(w.d paramd)
    {
      AppMethodBeat.i(278376);
      p.k(paramd, "request");
      this.pVN.invoke(paramd);
      Object localObject = com.tencent.mm.cx.a.YYB;
      p.j(localObject, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
      int[] arrayOfInt;
      if (e.contains((int[])localObject, paramd.fyH))
      {
        localObject = new pq();
        a((pq)localObject, this.pTU);
        ((pq)localObject).GF(u.chI());
        ((pq)localObject).GE(paramd.appId);
        if (!(paramd.pVk instanceof w.g.c)) {
          break label264;
        }
        ((pq)localObject).CE(((w.g.c)paramd.pVk).version);
        arrayOfInt = com.tencent.mm.plugin.appbrand.app.m.bFP().adb(paramd.bZS().toString());
        if (arrayOfInt != null) {
          break label151;
        }
        ((pq)localObject).CF(2L);
      }
      for (;;)
      {
        ((pq)localObject).bpa();
        AppMethodBeat.o(278376);
        return;
        label151:
        Collection localCollection = (Collection)new ArrayList();
        int k = arrayOfInt.length;
        int i = 0;
        if (i < k)
        {
          int m = arrayOfInt[i];
          if (m == paramd.pVk.bZT()) {}
          for (int j = 1;; j = 0)
          {
            if (j == 0) {
              localCollection.add(Integer.valueOf(m));
            }
            i += 1;
            break;
          }
        }
        if (!((Collection)localCollection).isEmpty()) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label262;
          }
          ((pq)localObject).CF(4L);
          break;
        }
        label262:
        continue;
        label264:
        ((pq)localObject).CE(0L);
        ((pq)localObject).CF(2L);
      }
    }
    
    public final void b(w.d paramd, w.e parame)
    {
      AppMethodBeat.i(278375);
      p.k(paramd, "request");
      p.k(parame, "response");
      int[] arrayOfInt = com.tencent.mm.cx.a.YYB;
      p.j(arrayOfInt, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
      if (e.contains(arrayOfInt, paramd.fyH)) {
        al.bj(paramd.appId, parame.pVn.pkgVersion());
      }
      AppMethodBeat.o(278375);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(aa.g paramg, w.d paramd, w.e parame)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
  public static final class h<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(180599);
      int i = kotlin.b.a.a((Comparable)Integer.valueOf(((WxaAttributes.WxaWidgetInfo)paramT2).fyH), (Comparable)Integer.valueOf(((WxaAttributes.WxaWidgetInfo)paramT1).fyH));
      AppMethodBeat.o(180599);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.aa
 * JD-Core Version:    0.7.0.1
 */