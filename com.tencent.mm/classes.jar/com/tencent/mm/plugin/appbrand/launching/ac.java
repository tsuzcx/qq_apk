package com.tencent.mm.plugin.appbrand.launching;

import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.autogen.mmdata.rpt.sj;
import com.tencent.mm.autogen.mmdata.rpt.tc;
import com.tencent.mm.autogen.mmdata.rpt.tj;
import com.tencent.mm.autogen.mmdata.rpt.tj.a;
import com.tencent.mm.cp.f;
import com.tencent.mm.cp.g;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.IPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.af;
import com.tencent.mm.plugin.appbrand.appcache.am;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.appcache.k.a;
import com.tencent.mm.plugin.appbrand.appcache.predownload.d.a.b;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaWidgetInfo;
import com.tencent.mm.plugin.appbrand.jsapi.ag.c;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.report.w;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.aeo;
import com.tencent.mm.protocal.protobuf.ciq;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils;", "", "()V", "TAG", "", "WAGAME_TYPE", "", "getWAGAME_TYPE", "()I", "applyLaunchAheadParallelCgiResponse", "", "instanceId", "canUseSeparatedPlugins", "", "appId", "versionType", "appVersion", "isGame", "acceptedLibReader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "createBatchReporter", "Lcom/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor$IReporter;", "reportQualitySession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "isLaunch", "isForPreRender", "onPkgMissed", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "singleMapOf", "", "K", "V", "key", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;", "pickAppropriateWidgetInfoList", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaWidgetInfo;", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;", "BaseBatchGetCodeReporter", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ac
{
  public static final ac tas;
  private static final int tat;
  
  static
  {
    AppMethodBeat.i(180606);
    tas = new ac();
    tat = 1004;
    AppMethodBeat.o(180606);
  }
  
  private static <K, V> Map<K, V> N(K paramK, V paramV)
  {
    AppMethodBeat.i(180605);
    ArrayMap localArrayMap = new ArrayMap();
    localArrayMap.put(paramK, paramV);
    paramK = (Map)localArrayMap;
    AppMethodBeat.o(180605);
    return paramK;
  }
  
  public static boolean W(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(320703);
    s.u(paramString, "appId");
    if (k.a.vK(paramInt1))
    {
      AppMethodBeat.o(320703);
      return true;
    }
    paramString = ((com.tencent.mm.plugin.appbrand.appcache.b)n.ag(com.tencent.mm.plugin.appbrand.appcache.b.class)).bv(paramString, paramInt2);
    switch (ac.b.$EnumSwitchMapping$0[paramString.ordinal()])
    {
    default: 
      AppMethodBeat.o(320703);
      return false;
    }
    AppMethodBeat.o(320703);
    return true;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils$BaseBatchGetCodeReporter;", "Lcom/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor$IReporter;", "()V", "callOnPkgCachedDefaultReportHandler", "", "reportQualitySession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "request", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "response", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "assignFromQualitySession", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualitySplitCodeLibStatisStruct;", "session", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  static abstract class a
    implements l.a
  {
    public static void a(tj paramtj, QualitySession paramQualitySession)
    {
      s.u(paramtj, "<this>");
      s.u(paramQualitySession, "session");
      paramtj.imT = paramtj.F("AppId", paramQualitySession.appId, true);
      paramtj.ind = paramQualitySession.tSh;
      paramtj.jCM = tj.a.oZ(paramQualitySession.tQx);
      paramtj.jax = paramQualitySession.apptype;
      paramtj.ilM = paramtj.F("InstanceId", paramQualitySession.eup, true);
      paramtj.iqr = paramQualitySession.scene;
    }
    
    public static void a(QualitySession paramQualitySession, y.d paramd, y.e parame)
    {
      s.u(paramQualitySession, "reportQualitySession");
      s.u(paramd, "request");
      s.u(parame, "response");
      if (((parame.taa instanceof y.f.a)) && (((y.f.a)parame.taa).reason != 0))
      {
        localtc = new tc();
        localtc.ilM = localtc.F("InstanceId", paramQualitySession.eup, true);
        localtc.imT = localtc.F("AppId", paramQualitySession.appId, true);
        localtc.ind = paramQualitySession.tSh;
        localtc.ine = paramQualitySession.tQx;
        localtc.iqr = paramQualitySession.scene;
        localtc.iqw = localtc.F("md5", parame.sZZ.checksumMd5(), true);
        localtc.iSn = localtc.F("moduleName", paramd.esT, true);
        localtc.jAV = paramd.hDq;
        switch (((y.f.a)parame.taa).reason)
        {
        default: 
          localtc.bMH();
        }
      }
      label222:
      label248:
      while ((!(parame.taa instanceof y.f.a)) || (((y.f.a)parame.taa).reason != 0))
      {
        tc localtc;
        for (;;)
        {
          return;
          localtc.jAW = 1L;
        }
        localtc.jAW = 2L;
        paramQualitySession = paramd.sZU;
        if ((paramQualitySession instanceof y.g.c))
        {
          paramQualitySession = (y.g.c)paramQualitySession;
          if (paramQualitySession != null) {
            break label248;
          }
        }
        for (paramQualitySession = null;; paramQualitySession = Long.valueOf(paramQualitySession.rcA).toString())
        {
          localtc.jAX = localtc.F("resue_reason", paramQualitySession, true);
          break;
          paramQualitySession = null;
          break label222;
        }
      }
      d.d("MicroMsg.AppBrand.PredownloadGetCodeStatStorage__report", (kotlin.g.a.a)new a.b((com.tencent.mm.plugin.appbrand.appcache.predownload.d.a)n.ag(com.tencent.mm.plugin.appbrand.appcache.predownload.d.a.class), paramQualitySession.eup, paramd.appId, parame.sZZ.pkgVersion(), paramd.hDq, paramd.esT));
    }
    
    public void a(y.d paramd)
    {
      s.u(this, "this");
      s.u(paramd, "request");
    }
    
    public void a(y.d paramd, y.e parame)
    {
      l.a locala = (l.a)this;
      s.u(locala, "this");
      s.u(paramd, "request");
      s.u(parame, "response");
      s.u((y.c)locala, "this");
      s.u(paramd, "request");
      s.u(parame, "response");
    }
    
    public void b(y.d paramd)
    {
      l.a locala = (l.a)this;
      s.u(locala, "this");
      s.u(paramd, "request");
      y.c.a.a((y.c)locala, paramd);
    }
    
    public void b(y.d paramd, y.e parame)
    {
      l.a locala = (l.a)this;
      s.u(locala, "this");
      s.u(paramd, "request");
      s.u(parame, "response");
      s.u((y.c)locala, "this");
      s.u(paramd, "request");
      s.u(parame, "response");
    }
    
    public void czU()
    {
      s.u(this, "this");
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(HashMap<z.a, ciq[]> paramHashMap)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils$createBatchReporter$2", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils$BaseBatchGetCodeReporter;", "TAG", "", "mIsColdStartUp", "", "mStageList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "com/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils$createBatchReporter$2.PluginInfo", "addPluginStage", "", "stage", "", "provider", "version", "markColdStartUp", "onAllPkgDownloaded", "onPkgCached", "request", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "response", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "onPkgDownloadError", "onPkgDownloadSuccess", "packageType", "onPkgMissed", "onPkgUpdated", "reportPkgDownloadStatus", "key", "reportPluginHitRate", "PluginInfo", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends ac.a
  {
    final String TAG;
    private CopyOnWriteArrayList<a> taw;
    private volatile boolean tax;
    
    e(boolean paramBoolean, QualitySession paramQualitySession, aeo paramaeo, kotlin.g.a.b<? super y.d, ah> paramb)
    {
      AppMethodBeat.i(320947);
      this.TAG = "MicroMsg.AppBrand.LaunchCheckPkgBatchGetCodeUtils.gameBatchReporter";
      this.taw = new CopyOnWriteArrayList();
      AppMethodBeat.o(320947);
    }
    
    private static void BY(int paramInt)
    {
      AppMethodBeat.i(320962);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(320962);
        return;
        BZ(0);
        AppMethodBeat.o(320962);
        return;
        BZ(9);
        AppMethodBeat.o(320962);
        return;
        BZ(4);
        AppMethodBeat.o(320962);
        return;
        BZ(2);
        AppMethodBeat.o(320962);
        return;
        BZ(7);
        AppMethodBeat.o(320962);
        return;
        BZ(11);
        AppMethodBeat.o(320962);
        return;
        BZ(13);
      }
    }
    
    private static void BZ(int paramInt)
    {
      AppMethodBeat.i(320967);
      h.OAn.idkeyStat(1027L, paramInt, 1L, false);
      AppMethodBeat.o(320967);
    }
    
    private static final Void a(y.d paramd, y.e parame, Void paramVoid)
    {
      AppMethodBeat.i(320972);
      s.u(paramd, "$request");
      s.u(parame, "$response");
      am.bA(new af(paramd.appId, "__PLUGINCODE__").toString(), parame.sZZ.pkgVersion());
      AppMethodBeat.o(320972);
      return null;
    }
    
    private final void cAh()
    {
      AppMethodBeat.i(320953);
      if (this.tax)
      {
        AppMethodBeat.o(320953);
        return;
      }
      this.tax = true;
      m(1, "", 0);
      AppMethodBeat.o(320953);
    }
    
    private final void m(int paramInt1, String paramString, int paramInt2)
    {
      AppMethodBeat.i(320956);
      Log.i(this.TAG, "addPluginStage stage:%d,provider:%s,version:%d", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2) });
      a locala = new a();
      locala.adb(paramString);
      locala.hSE = paramInt1;
      locala.version = paramInt2;
      this.taw.add(locala);
      AppMethodBeat.o(320956);
    }
    
    public final void a(y.d paramd)
    {
      AppMethodBeat.i(320985);
      s.u(paramd, "request");
      switch (paramd.hDq)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(320985);
        return;
        BZ(1);
        AppMethodBeat.o(320985);
        return;
        BZ(10);
        AppMethodBeat.o(320985);
        return;
        BZ(5);
        AppMethodBeat.o(320985);
        return;
        BZ(3);
        AppMethodBeat.o(320985);
        return;
        BZ(8);
        AppMethodBeat.o(320985);
        return;
        BZ(12);
        AppMethodBeat.o(320985);
        return;
        BZ(14);
      }
    }
    
    public final void a(y.d paramd, final y.e parame)
    {
      AppMethodBeat.i(320992);
      s.u(paramd, "request");
      s.u(parame, "response");
      if (((paramd.sZU instanceof y.g.b)) && (!((y.g.b)paramd.sZU).tae))
      {
        arrayOfInt = com.tencent.mm.cq.a.agWM;
        s.s(arrayOfInt, "PLUGINCODE_PACKAGE_TYPES");
        if (k.contains(arrayOfInt, paramd.hDq))
        {
          Log.i(this.TAG, "onPkgCached, will update plugin(" + paramd.appId + ") to latest in background...");
          d.B((kotlin.g.a.a)new b(paramd, this.taz, this.sYY, this, parame));
        }
      }
      int[] arrayOfInt = com.tencent.mm.cq.a.agWM;
      s.s(arrayOfInt, "PLUGINCODE_PACKAGE_TYPES");
      if (k.contains(arrayOfInt, paramd.hDq))
      {
        m(3, paramd.appId, parame.sZZ.pkgVersion());
        g.jPX().i(new ac.e..ExternalSyntheticLambda0(paramd, parame)).jJM();
      }
      a(this.sYY, paramd, parame);
      AppMethodBeat.o(320992);
    }
    
    public final void b(y.d paramd)
    {
      AppMethodBeat.i(320999);
      s.u(paramd, "request");
      this.taA.invoke(paramd);
      int[] arrayOfInt = com.tencent.mm.cq.a.agWM;
      s.s(arrayOfInt, "PLUGINCODE_PACKAGE_TYPES");
      if (k.contains(arrayOfInt, paramd.hDq))
      {
        if ((paramd.sZU instanceof y.g.c))
        {
          int k = paramd.sZU.cAf();
          arrayOfInt = n.cfm().Vz(paramd.cAe().toString());
          if (arrayOfInt == null)
          {
            cAh();
            m(2, paramd.appId, k);
            BY(paramd.hDq);
            AppMethodBeat.o(320999);
            return;
          }
          Collection localCollection = (Collection)new ArrayList();
          int m = arrayOfInt.length;
          int i = 0;
          if (i < m)
          {
            int n = arrayOfInt[i];
            if (n == paramd.sZU.cAf()) {}
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
              cAh();
              m(4, paramd.appId, k);
              BY(paramd.hDq);
            }
            AppMethodBeat.o(320999);
            return;
          }
        }
        cAh();
        m(2, paramd.appId, 0);
        BY(paramd.hDq);
        AppMethodBeat.o(320999);
        return;
      }
      arrayOfInt = com.tencent.mm.cq.a.agWK;
      s.s(arrayOfInt, "LOCAL_SUPPORT_PACKAGE_TYPES_IN_WIDGET_INFO");
      if (k.contains(arrayOfInt, paramd.hDq))
      {
        cAh();
        BY(paramd.hDq);
      }
      AppMethodBeat.o(320999);
    }
    
    public final void b(y.d paramd, y.e parame)
    {
      AppMethodBeat.i(321000);
      s.u(paramd, "request");
      s.u(parame, "response");
      int[] arrayOfInt = com.tencent.mm.cq.a.agWM;
      s.s(arrayOfInt, "PLUGINCODE_PACKAGE_TYPES");
      if (k.contains(arrayOfInt, paramd.hDq)) {
        am.bA(paramd.appId, parame.sZZ.pkgVersion());
      }
      AppMethodBeat.o(321000);
    }
    
    public final void czU()
    {
      AppMethodBeat.i(320980);
      Log.i(this.TAG, "onAllPkgDownloaded isLaunch:%b", new Object[] { Boolean.valueOf(this.tay) });
      if ((this.tax) && (this.tay) && (this.taw != null) && (this.taw.size() > 0))
      {
        Log.i(this.TAG, "mStageList size:%d", new Object[] { Integer.valueOf(this.taw.size()) });
        Iterator localIterator = this.taw.iterator();
        while (localIterator.hasNext())
        {
          a locala = (a)localIterator.next();
          tj localtj = new tj();
          a(localtj, this.sYY);
          localtj.zN(w.cID());
          localtj.zM(locala.provider);
          localtj.iuf = locala.version;
          localtj.jCO = locala.hSE;
          localtj.bMH();
        }
      }
      AppMethodBeat.o(320980);
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils$createBatchReporter$2.PluginInfo", "", "(Lcom/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils$createBatchReporter$2;)V", "provider", "", "getProvider", "()Ljava/lang/String;", "setProvider", "(Ljava/lang/String;)V", "stage", "", "getStage", "()I", "setStage", "(I)V", "version", "getVersion", "setVersion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
    public final class a
    {
      int hSE;
      String provider;
      int version;
      
      public a()
      {
        AppMethodBeat.i(320831);
        this.provider = "";
        AppMethodBeat.o(320831);
      }
      
      public final void adb(String paramString)
      {
        AppMethodBeat.i(320836);
        s.u(paramString, "<set-?>");
        this.provider = paramString;
        AppMethodBeat.o(320836);
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.a<ah>
    {
      b(y.d paramd, aeo paramaeo, QualitySession paramQualitySession, ac.e parame, y.e parame1)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils$createBatchReporter$3", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils$BaseBatchGetCodeReporter;", "TAG", "", "onPkgCached", "", "request", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "response", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "onPkgMissed", "onPkgUpdated", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends ac.a
  {
    final String TAG = "MicroMsg.AppBrand.LaunchCheckPkgBatchGetCodeUtils.defaultBatchReporter";
    
    f(QualitySession paramQualitySession, aeo paramaeo, kotlin.g.a.b<? super y.d, ah> paramb) {}
    
    public final void a(y.d paramd, final y.e parame)
    {
      AppMethodBeat.i(320945);
      s.u(paramd, "request");
      s.u(parame, "response");
      if (((paramd.sZU instanceof y.g.b)) && (!((y.g.b)paramd.sZU).tae))
      {
        localObject = com.tencent.mm.cq.a.agWM;
        s.s(localObject, "PLUGINCODE_PACKAGE_TYPES");
        if (k.contains((int[])localObject, paramd.hDq))
        {
          Log.i(this.TAG, "onPkgCached, will update plugin(" + paramd.appId + ") to latest in background...");
          localObject = this.sYY.eup;
          d.B((kotlin.g.a.a)new a(paramd, this.taz, this.sYY, (String)localObject, this, parame));
        }
      }
      Object localObject = com.tencent.mm.cq.a.agWM;
      s.s(localObject, "PLUGINCODE_PACKAGE_TYPES");
      if (k.contains((int[])localObject, paramd.hDq))
      {
        localObject = new tj();
        a((tj)localObject, this.sYY);
        ((tj)localObject).zN(w.cID());
        ((tj)localObject).zM(paramd.appId);
        ((tj)localObject).iuf = parame.sZZ.pkgVersion();
        ((tj)localObject).jCO = 3L;
        ((tj)localObject).bMH();
        am.bA(paramd.appId, parame.sZZ.pkgVersion());
      }
      a(this.sYY, paramd, parame);
      AppMethodBeat.o(320945);
    }
    
    public final void b(y.d paramd)
    {
      AppMethodBeat.i(320959);
      s.u(paramd, "request");
      this.taA.invoke(paramd);
      Object localObject = com.tencent.mm.cq.a.agWM;
      s.s(localObject, "PLUGINCODE_PACKAGE_TYPES");
      int[] arrayOfInt;
      if (k.contains((int[])localObject, paramd.hDq))
      {
        localObject = new tj();
        a((tj)localObject, this.sYY);
        ((tj)localObject).zN(w.cID());
        ((tj)localObject).zM(paramd.appId);
        if (!(paramd.sZU instanceof y.g.c)) {
          break label261;
        }
        ((tj)localObject).iuf = ((y.g.c)paramd.sZU).version;
        arrayOfInt = n.cfm().Vz(paramd.cAe().toString());
        if (arrayOfInt != null) {
          break label149;
        }
        ((tj)localObject).jCO = 2L;
      }
      for (;;)
      {
        ((tj)localObject).bMH();
        AppMethodBeat.o(320959);
        return;
        label149:
        Collection localCollection = (Collection)new ArrayList();
        int k = arrayOfInt.length;
        int i = 0;
        if (i < k)
        {
          int m = arrayOfInt[i];
          if (m == paramd.sZU.cAf()) {}
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
            break label259;
          }
          ((tj)localObject).jCO = 4L;
          break;
        }
        label259:
        continue;
        label261:
        ((tj)localObject).iuf = 0L;
        ((tj)localObject).jCO = 2L;
      }
    }
    
    public final void b(y.d paramd, y.e parame)
    {
      AppMethodBeat.i(320951);
      s.u(paramd, "request");
      s.u(parame, "response");
      int[] arrayOfInt = com.tencent.mm.cq.a.agWM;
      s.s(arrayOfInt, "PLUGINCODE_PACKAGE_TYPES");
      if (k.contains(arrayOfInt, paramd.hDq)) {
        am.bA(paramd.appId, parame.sZZ.pkgVersion());
      }
      AppMethodBeat.o(320951);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(y.d paramd, aeo paramaeo, QualitySession paramQualitySession, String paramString, ac.f paramf, y.e parame)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k=3, mv={1, 5, 1})
  public static final class g<T>
    implements Comparator
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(180599);
      int i = kotlin.b.a.b((Comparable)Integer.valueOf(((WxaAttributes.WxaWidgetInfo)paramT2).hDq), (Comparable)Integer.valueOf(((WxaAttributes.WxaWidgetInfo)paramT1).hDq));
      AppMethodBeat.o(180599);
      return i;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k=3, mv={1, 5, 1})
  public static final class h<T>
    implements Comparator
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(320940);
      int i = kotlin.b.a.b((Comparable)Integer.valueOf(((WxaAttributes.WxaWidgetInfo)paramT2).hDq), (Comparable)Integer.valueOf(((WxaAttributes.WxaWidgetInfo)paramT1).hDq));
      AppMethodBeat.o(320940);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ac
 * JD-Core Version:    0.7.0.1
 */