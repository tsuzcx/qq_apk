package com.tencent.mm.plugin.appbrand.launching;

import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.co.f;
import com.tencent.mm.co.g;
import com.tencent.mm.g.b.a.fx;
import com.tencent.mm.g.b.a.fx.a;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.IPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.ab;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaWidgetInfo;
import com.tencent.mm.plugin.appbrand.report.q;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.atf;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.e;
import d.g.b.k;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils;", "", "()V", "TAG", "", "WAGAME_TYPE", "", "getWAGAME_TYPE", "()I", "applyLaunchAheadParallelCgiResponse", "", "instanceId", "canUseSeparatedPlugins", "", "appId", "versionType", "appVersion", "isGame", "acceptedLibReader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "createBatchReporter", "Lcom/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor$IReporter;", "reportQualitySession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "isLaunch", "onPkgMissed", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "singleMapOf", "", "K", "V", "key", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;", "pickAppropriateWidgetInfoList", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaWidgetInfo;", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;", "plugin-appbrand-integration_release"})
public final class ae
{
  private static final int kKg = 1004;
  public static final ae kKh;
  
  static
  {
    AppMethodBeat.i(180606);
    kKh = new ae();
    kKg = 1004;
    AppMethodBeat.o(180606);
  }
  
  private static <K, V> Map<K, V> A(K paramK, V paramV)
  {
    AppMethodBeat.i(180605);
    ArrayMap localArrayMap = new ArrayMap();
    localArrayMap.put(paramK, paramV);
    paramK = (Map)localArrayMap;
    AppMethodBeat.o(180605);
    return paramK;
  }
  
  private static boolean a(ICommLibReader paramICommLibReader, boolean paramBoolean)
  {
    AppMethodBeat.i(180602);
    if (paramBoolean)
    {
      AppMethodBeat.o(180602);
      return true;
    }
    paramICommLibReader = paramICommLibReader.DI("injectAppSeparatedPlugin");
    if ((paramICommLibReader != null) && (Boolean.parseBoolean(paramICommLibReader) == true))
    {
      AppMethodBeat.o(180602);
      return true;
    }
    AppMethodBeat.o(180602);
    return false;
  }
  
  public static boolean a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, ICommLibReader paramICommLibReader)
  {
    AppMethodBeat.i(180603);
    k.h(paramString, "appId");
    if (j.a.nz(paramInt1))
    {
      if ((paramICommLibReader != null) && (a(paramICommLibReader, paramBoolean) == true))
      {
        AppMethodBeat.o(180603);
        return true;
      }
      AppMethodBeat.o(180603);
      return false;
    }
    paramString = ((com.tencent.mm.plugin.appbrand.appcache.b)j.T(com.tencent.mm.plugin.appbrand.appcache.b.class)).aA(paramString, paramInt2);
    switch (af.ciE[paramString.ordinal()])
    {
    default: 
      AppMethodBeat.o(180603);
      return false;
    }
    if ((paramICommLibReader != null) && (a(paramICommLibReader, paramBoolean) == true))
    {
      AppMethodBeat.o(180603);
      return true;
    }
    AppMethodBeat.o(180603);
    return false;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "invoke", "()[Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "com/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils$applyLaunchAheadParallelCgiResponse$1$1$interceptResp$1"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<atf[]>
  {
    a(z.b paramb, HashMap paramHashMap)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
  public static final class b<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(180589);
      int i = d.b.a.a((Comparable)Integer.valueOf(((WxaAttributes.WxaWidgetInfo)paramT2).deP), (Comparable)Integer.valueOf(((WxaAttributes.WxaWidgetInfo)paramT1).deP));
      AppMethodBeat.o(180589);
      return i;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    c(HashMap paramHashMap)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.b<y.d, y>
  {
    public static final d kKl;
    
    static
    {
      AppMethodBeat.i(196364);
      kKl = new d();
      AppMethodBeat.o(196364);
    }
    
    d()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils$createBatchReporter$2", "Lcom/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor$IReporter;", "TAG", "", "mIsColdStartUp", "", "mStageList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "com/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils$createBatchReporter$2.PluginInfo", "addPluginStage", "", "stage", "", "provider", "version", "markColdStartUp", "onAllPkgDownloaded", "onPkgCached", "request", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "response", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "onPkgDownloadError", "onPkgDownloadSuccess", "packageType", "onPkgMissed", "reportPkgDownloadStatus", "key", "reportPluginHitRate", "assignFromQualitySession", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualitySplitCodeLibStatisStruct;", "session", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "PluginInfo", "plugin-appbrand-integration_release"})
  public static final class e
    implements l.a
  {
    final String TAG;
    private CopyOnWriteArrayList<a> kKm;
    private volatile boolean kKn;
    
    e(boolean paramBoolean, QualitySession paramQualitySession, d.g.a.b paramb)
    {
      AppMethodBeat.i(196379);
      this.TAG = "MicroMsg.AppBrand.LaunchCheckPkgBatchGetCodeUtils.gameBatchReporter";
      this.kKm = new CopyOnWriteArrayList();
      AppMethodBeat.o(196379);
    }
    
    private final void bgH()
    {
      AppMethodBeat.i(196371);
      if (this.kKn)
      {
        AppMethodBeat.o(196371);
        return;
      }
      this.kKn = true;
      j(1, "", 0);
      AppMethodBeat.o(196371);
    }
    
    private final void j(int paramInt1, String paramString, int paramInt2)
    {
      AppMethodBeat.i(196372);
      ad.i(this.TAG, "addPluginStage stage:%d,provider:%s,version:%d", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2) });
      a locala = new a();
      locala.setProvider(paramString);
      locala.drg = paramInt1;
      locala.version = paramInt2;
      this.kKm.add(locala);
      AppMethodBeat.o(196372);
    }
    
    private static void sL(int paramInt)
    {
      AppMethodBeat.i(196373);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(196373);
        return;
        sM(0);
        AppMethodBeat.o(196373);
        return;
        sM(9);
        AppMethodBeat.o(196373);
        return;
        sM(4);
        AppMethodBeat.o(196373);
        return;
        sM(2);
        AppMethodBeat.o(196373);
        return;
        sM(7);
        AppMethodBeat.o(196373);
        return;
        sM(11);
        AppMethodBeat.o(196373);
        return;
        sM(13);
      }
    }
    
    private static void sM(int paramInt)
    {
      AppMethodBeat.i(196374);
      h.vKh.idkeyStat(1027L, paramInt, 1L, false);
      AppMethodBeat.o(196374);
    }
    
    public final void a(y.d paramd)
    {
      AppMethodBeat.i(196376);
      k.h(paramd, "request");
      switch (paramd.deP)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(196376);
        return;
        sM(1);
        AppMethodBeat.o(196376);
        return;
        sM(10);
        AppMethodBeat.o(196376);
        return;
        sM(5);
        AppMethodBeat.o(196376);
        return;
        sM(3);
        AppMethodBeat.o(196376);
        return;
        sM(8);
        AppMethodBeat.o(196376);
        return;
        sM(12);
        AppMethodBeat.o(196376);
        return;
        sM(14);
      }
    }
    
    public final void b(y.d paramd)
    {
      AppMethodBeat.i(196378);
      k.h(paramd, "request");
      this.kKp.aA(paramd);
      int[] arrayOfInt = com.tencent.mm.cp.a.Igu;
      k.g(arrayOfInt, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
      if (e.contains(arrayOfInt, paramd.deP))
      {
        if ((paramd.kJx instanceof y.g.b))
        {
          final int k = ((y.g.b)paramd.kJx).version;
          arrayOfInt = j.aOK().El(paramd.bgB().toString());
          if (arrayOfInt == null)
          {
            bgH();
            j(2, paramd.appId, k);
            sL(paramd.deP);
          }
          label266:
          for (;;)
          {
            g.fkM().i((com.tencent.mm.vending.c.a)new d(paramd, k)).fhm();
            AppMethodBeat.o(196378);
            return;
            Collection localCollection = (Collection)new ArrayList();
            int m = arrayOfInt.length;
            int i = 0;
            if (i < m)
            {
              int n = arrayOfInt[i];
              if (n == ((y.g.b)paramd.kJx).version) {}
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
              if (i == 0) {
                break label266;
              }
              bgH();
              j(4, paramd.appId, k);
              sL(paramd.deP);
              break;
            }
          }
        }
        bgH();
        j(2, paramd.appId, 0);
        sL(paramd.deP);
        AppMethodBeat.o(196378);
        return;
      }
      arrayOfInt = com.tencent.mm.cp.a.Igs;
      k.g(arrayOfInt, "ConstantsWxaPackageProto…KAGE_TYPES_IN_WIDGET_INFO");
      if (e.contains(arrayOfInt, paramd.deP))
      {
        bgH();
        sL(paramd.deP);
      }
      AppMethodBeat.o(196378);
    }
    
    public final void b(y.d paramd, final y.e parame)
    {
      AppMethodBeat.i(196377);
      k.h(paramd, "request");
      k.h(parame, "response");
      if (((paramd.kJx instanceof y.g.a)) && (!((y.g.a)paramd.kJx).kJF))
      {
        arrayOfInt = com.tencent.mm.cp.a.Igu;
        k.g(arrayOfInt, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
        if (e.contains(arrayOfInt, paramd.deP))
        {
          ad.i(this.TAG, "onPkgCached, will update plugin(" + paramd.appId + ") to latest in background...");
          c.b(null, (d.g.a.a)new ae.e.b(this, paramd, parame));
        }
      }
      int[] arrayOfInt = com.tencent.mm.cp.a.Igu;
      k.g(arrayOfInt, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
      if (e.contains(arrayOfInt, paramd.deP))
      {
        j(3, paramd.appId, parame.kJA.pkgVersion());
        g.fkM().i((com.tencent.mm.vending.c.a)new c(paramd, parame)).fhm();
      }
      AppMethodBeat.o(196377);
    }
    
    public final void bgs()
    {
      AppMethodBeat.i(196375);
      ad.i(this.TAG, "onAllPkgDownloaded isLaunch:%b", new Object[] { Boolean.valueOf(this.kKo) });
      if ((this.kKn) && (this.kKo) && (this.kKm != null) && (this.kKm.size() > 0))
      {
        ad.i(this.TAG, "mStageList size:%d", new Object[] { Integer.valueOf(this.kKm.size()) });
        Iterator localIterator = this.kKm.iterator();
        while (localIterator.hasNext())
        {
          a locala = (a)localIterator.next();
          fx localfx = new fx();
          QualitySession localQualitySession = this.kIe;
          localfx.lD(localQualitySession.appId);
          localfx.je(localQualitySession.lty);
          localfx.a(fx.a.jd(localQualitySession.lrW));
          localfx.jf(localQualitySession.apptype);
          localfx.lG(localQualitySession.kGa);
          localfx.ji(localQualitySession.scene);
          localfx.lF(q.bmn());
          localfx.lE(locala.provider);
          localfx.jg(locala.version);
          localfx.jh(locala.drg);
          localfx.aBj();
        }
      }
      AppMethodBeat.o(196375);
    }
    
    public final void c(y.d paramd, y.e parame)
    {
      AppMethodBeat.i(196380);
      k.h(paramd, "request");
      k.h(parame, "response");
      l.a.a.a(paramd, parame);
      AppMethodBeat.o(196380);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils$createBatchReporter$2.PluginInfo", "", "(Lcom/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils$createBatchReporter$2;)V", "provider", "", "getProvider", "()Ljava/lang/String;", "setProvider", "(Ljava/lang/String;)V", "stage", "", "getStage", "()I", "setStage", "(I)V", "version", "getVersion", "setVersion", "plugin-appbrand-integration_release"})
    public final class a
    {
      int drg;
      String provider = "";
      int version;
      
      public final void setProvider(String paramString)
      {
        AppMethodBeat.i(196365);
        k.h(paramString, "<set-?>");
        this.provider = paramString;
        AppMethodBeat.o(196365);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
    static final class c<_Ret, _Var>
      implements com.tencent.mm.vending.c.a<_Ret, _Var>
    {
      c(y.d paramd, y.e parame) {}
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
    static final class d<_Ret, _Var>
      implements com.tencent.mm.vending.c.a<_Ret, _Var>
    {
      d(y.d paramd, int paramInt) {}
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils$createBatchReporter$3", "Lcom/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor$IReporter;", "TAG", "", "onPkgCached", "", "request", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "response", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "onPkgMissed", "assignFromQualitySession", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualitySplitCodeLibStatisStruct;", "session", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "plugin-appbrand-integration_release"})
  public static final class f
    implements l.a
  {
    final String TAG = "MicroMsg.AppBrand.LaunchCheckPkgBatchGetCodeUtils.defaultBatchReporter";
    
    f(QualitySession paramQualitySession, d.g.a.b paramb) {}
    
    private static void a(fx paramfx, QualitySession paramQualitySession)
    {
      AppMethodBeat.i(196386);
      paramfx.lD(paramQualitySession.appId);
      paramfx.je(paramQualitySession.lty);
      paramfx.a(fx.a.jd(paramQualitySession.lrW));
      paramfx.jf(paramQualitySession.apptype);
      paramfx.lG(paramQualitySession.kGa);
      paramfx.ji(paramQualitySession.scene);
      AppMethodBeat.o(196386);
    }
    
    public final void a(y.d paramd)
    {
      AppMethodBeat.i(196387);
      k.h(paramd, "request");
      k.h(paramd, "request");
      AppMethodBeat.o(196387);
    }
    
    public final void b(y.d paramd)
    {
      AppMethodBeat.i(196385);
      k.h(paramd, "request");
      this.kKp.aA(paramd);
      Object localObject = com.tencent.mm.cp.a.Igu;
      k.g(localObject, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
      int[] arrayOfInt;
      if (e.contains((int[])localObject, paramd.deP))
      {
        localObject = new fx();
        a((fx)localObject, this.kIe);
        ((fx)localObject).lF(q.bmn());
        ((fx)localObject).lE(paramd.appId);
        if (!(paramd.kJx instanceof y.g.b)) {
          break label267;
        }
        ((fx)localObject).jg(((y.g.b)paramd.kJx).version);
        arrayOfInt = j.aOK().El(paramd.bgB().toString());
        if (arrayOfInt != null) {
          break label151;
        }
        ((fx)localObject).jh(2L);
      }
      for (;;)
      {
        ((fx)localObject).aBj();
        AppMethodBeat.o(196385);
        return;
        label151:
        Collection localCollection = (Collection)new ArrayList();
        int k = arrayOfInt.length;
        int i = 0;
        if (i < k)
        {
          int m = arrayOfInt[i];
          if (m == ((y.g.b)paramd.kJx).version) {}
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
            break label265;
          }
          ((fx)localObject).jh(4L);
          break;
        }
        label265:
        continue;
        label267:
        ((fx)localObject).jg(0L);
        ((fx)localObject).jh(2L);
      }
    }
    
    public final void b(y.d paramd, y.e parame)
    {
      AppMethodBeat.i(196384);
      k.h(paramd, "request");
      k.h(parame, "response");
      if (((paramd.kJx instanceof y.g.a)) && (!((y.g.a)paramd.kJx).kJF))
      {
        localObject = com.tencent.mm.cp.a.Igu;
        k.g(localObject, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
        if (e.contains((int[])localObject, paramd.deP))
        {
          ad.i(this.TAG, "onPkgCached, will update plugin(" + paramd.appId + ") to latest in background...");
          c.b(null, (d.g.a.a)new ae.f.a(this, paramd, parame));
        }
      }
      Object localObject = com.tencent.mm.cp.a.Igu;
      k.g(localObject, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
      if (e.contains((int[])localObject, paramd.deP))
      {
        localObject = new fx();
        a((fx)localObject, this.kIe);
        ((fx)localObject).lF(q.bmn());
        ((fx)localObject).lE(paramd.appId);
        ((fx)localObject).jg(parame.kJA.pkgVersion());
        ((fx)localObject).jh(3L);
        ((fx)localObject).aBj();
      }
      AppMethodBeat.o(196384);
    }
    
    public final void bgs() {}
    
    public final void c(y.d paramd, y.e parame)
    {
      AppMethodBeat.i(196388);
      k.h(paramd, "request");
      k.h(parame, "response");
      l.a.a.a(paramd, parame);
      AppMethodBeat.o(196388);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
  public static final class g<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(180599);
      int i = d.b.a.a((Comparable)Integer.valueOf(((WxaAttributes.WxaWidgetInfo)paramT2).deP), (Comparable)Integer.valueOf(((WxaAttributes.WxaWidgetInfo)paramT1).deP));
      AppMethodBeat.o(180599);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ae
 * JD-Core Version:    0.7.0.1
 */