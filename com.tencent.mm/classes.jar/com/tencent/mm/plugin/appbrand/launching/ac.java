package com.tencent.mm.plugin.appbrand.launching;

import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.co.f;
import com.tencent.mm.co.g;
import com.tencent.mm.g.b.a.ls;
import com.tencent.mm.g.b.a.mr;
import com.tencent.mm.g.b.a.mr.a;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.IPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaWidgetInfo;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.report.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.protocal.protobuf.bmm;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.a.e;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils;", "", "()V", "TAG", "", "WAGAME_TYPE", "", "getWAGAME_TYPE", "()I", "applyLaunchAheadParallelCgiResponse", "", "instanceId", "canUseSeparatedPlugins", "", "appId", "versionType", "appVersion", "isGame", "acceptedLibReader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "createBatchReporter", "Lcom/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor$IReporter;", "reportQualitySession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "isLaunch", "isForPreRender", "onPkgMissed", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "singleMapOf", "", "K", "V", "key", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;", "pickAppropriateWidgetInfoList", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaWidgetInfo;", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;", "plugin-appbrand-integration_release"})
public final class ac
{
  private static final int mUG = 1004;
  public static final ac mUH;
  
  static
  {
    AppMethodBeat.i(180606);
    mUH = new ac();
    mUG = 1004;
    AppMethodBeat.o(180606);
  }
  
  private static <K, V> Map<K, V> I(K paramK, V paramV)
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
    paramICommLibReader = paramICommLibReader.UN("injectAppSeparatedPlugin");
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
    p.h(paramString, "appId");
    if (j.a.sE(paramInt1))
    {
      if ((paramICommLibReader != null) && (a(paramICommLibReader, paramBoolean) == true))
      {
        AppMethodBeat.o(180603);
        return true;
      }
      AppMethodBeat.o(180603);
      return false;
    }
    paramString = ((com.tencent.mm.plugin.appbrand.appcache.b)n.W(com.tencent.mm.plugin.appbrand.appcache.b.class)).aM(paramString, paramInt2);
    switch (ad.$EnumSwitchMapping$0[paramString.ordinal()])
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "invoke", "()[Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "com/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils$applyLaunchAheadParallelCgiResponse$1$1$interceptResp$1"})
  static final class a
    extends q
    implements kotlin.g.a.a<bmm[]>
  {
    a(y.b paramb, HashMap paramHashMap)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
  public static final class b<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(180589);
      int i = kotlin.b.a.a((Comparable)Integer.valueOf(((WxaAttributes.WxaWidgetInfo)paramT2).packageType), (Comparable)Integer.valueOf(((WxaAttributes.WxaWidgetInfo)paramT1).packageType));
      AppMethodBeat.o(180589);
      return i;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(HashMap paramHashMap)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<x.d, x>
  {
    public static final d mUL;
    
    static
    {
      AppMethodBeat.i(228663);
      mUL = new d();
      AppMethodBeat.o(228663);
    }
    
    d()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils$createBatchReporter$2", "Lcom/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor$IReporter;", "TAG", "", "mIsColdStartUp", "", "mStageList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "com/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils$createBatchReporter$2.PluginInfo", "addPluginStage", "", "stage", "", "provider", "version", "markColdStartUp", "onAllPkgDownloaded", "onPkgCached", "request", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "response", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "onPkgDownloadError", "onPkgDownloadSuccess", "packageType", "onPkgMissed", "reportPkgDownloadStatus", "key", "reportPluginHitRate", "assignFromQualitySession", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualitySplitCodeLibStatisStruct;", "session", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "PluginInfo", "plugin-appbrand-integration_release"})
  public static final class e
    implements l.a
  {
    final String TAG;
    private CopyOnWriteArrayList<a> mUM;
    private volatile boolean mUN;
    
    e(boolean paramBoolean, QualitySession paramQualitySession, acc paramacc, kotlin.g.a.b paramb)
    {
      AppMethodBeat.i(228678);
      this.TAG = "MicroMsg.AppBrand.LaunchCheckPkgBatchGetCodeUtils.gameBatchReporter";
      this.mUM = new CopyOnWriteArrayList();
      AppMethodBeat.o(228678);
    }
    
    private final void bNB()
    {
      AppMethodBeat.i(228670);
      if (this.mUN)
      {
        AppMethodBeat.o(228670);
        return;
      }
      this.mUN = true;
      k(1, "", 0);
      AppMethodBeat.o(228670);
    }
    
    private final void k(int paramInt1, String paramString, int paramInt2)
    {
      AppMethodBeat.i(228671);
      Log.i(this.TAG, "addPluginStage stage:%d,provider:%s,version:%d", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2) });
      a locala = new a();
      locala.setProvider(paramString);
      locala.dTz = paramInt1;
      locala.version = paramInt2;
      this.mUM.add(locala);
      AppMethodBeat.o(228671);
    }
    
    private static void yj(int paramInt)
    {
      AppMethodBeat.i(228672);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(228672);
        return;
        yk(0);
        AppMethodBeat.o(228672);
        return;
        yk(9);
        AppMethodBeat.o(228672);
        return;
        yk(4);
        AppMethodBeat.o(228672);
        return;
        yk(2);
        AppMethodBeat.o(228672);
        return;
        yk(7);
        AppMethodBeat.o(228672);
        return;
        yk(11);
        AppMethodBeat.o(228672);
        return;
        yk(13);
      }
    }
    
    private static void yk(int paramInt)
    {
      AppMethodBeat.i(228673);
      h.CyF.idkeyStat(1027L, paramInt, 1L, false);
      AppMethodBeat.o(228673);
    }
    
    public final void a(x.d paramd)
    {
      AppMethodBeat.i(228675);
      p.h(paramd, "request");
      switch (paramd.packageType)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(228675);
        return;
        yk(1);
        AppMethodBeat.o(228675);
        return;
        yk(10);
        AppMethodBeat.o(228675);
        return;
        yk(5);
        AppMethodBeat.o(228675);
        return;
        yk(3);
        AppMethodBeat.o(228675);
        return;
        yk(8);
        AppMethodBeat.o(228675);
        return;
        yk(12);
        AppMethodBeat.o(228675);
        return;
        yk(14);
      }
    }
    
    public final void b(x.d paramd)
    {
      AppMethodBeat.i(228677);
      p.h(paramd, "request");
      this.mUP.invoke(paramd);
      int[] arrayOfInt = com.tencent.mm.cp.a.Rxa;
      p.g(arrayOfInt, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
      if (e.contains(arrayOfInt, paramd.packageType))
      {
        if ((paramd.mUl instanceof x.g.b))
        {
          final int k = ((x.g.b)paramd.mUl).version;
          arrayOfInt = n.buL().Vs(paramd.bNz().toString());
          if (arrayOfInt == null)
          {
            bNB();
            k(2, paramd.appId, k);
            yj(paramd.packageType);
          }
          label266:
          for (;;)
          {
            g.hio().i((com.tencent.mm.vending.c.a)new d(paramd, k)).hdy();
            AppMethodBeat.o(228677);
            return;
            Collection localCollection = (Collection)new ArrayList();
            int m = arrayOfInt.length;
            int i = 0;
            if (i < m)
            {
              int n = arrayOfInt[i];
              if (n == ((x.g.b)paramd.mUl).version) {}
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
              bNB();
              k(4, paramd.appId, k);
              yj(paramd.packageType);
              break;
            }
          }
        }
        bNB();
        k(2, paramd.appId, 0);
        yj(paramd.packageType);
        AppMethodBeat.o(228677);
        return;
      }
      arrayOfInt = com.tencent.mm.cp.a.RwY;
      p.g(arrayOfInt, "ConstantsWxaPackageProto…KAGE_TYPES_IN_WIDGET_INFO");
      if (e.contains(arrayOfInt, paramd.packageType))
      {
        bNB();
        yj(paramd.packageType);
      }
      AppMethodBeat.o(228677);
    }
    
    public final void b(final x.d paramd, final x.e parame)
    {
      AppMethodBeat.i(228676);
      p.h(paramd, "request");
      p.h(parame, "response");
      if (((paramd.mUl instanceof x.g.a)) && (!((x.g.a)paramd.mUl).mUt))
      {
        arrayOfInt = com.tencent.mm.cp.a.Rxa;
        p.g(arrayOfInt, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
        if (e.contains(arrayOfInt, paramd.packageType))
        {
          Log.i(this.TAG, "onPkgCached, will update plugin(" + paramd.appId + ") to latest in background...");
          d.i((kotlin.g.a.a)new b(this, paramd, parame));
        }
      }
      int[] arrayOfInt = com.tencent.mm.cp.a.Rxa;
      p.g(arrayOfInt, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
      if (e.contains(arrayOfInt, paramd.packageType))
      {
        k(3, paramd.appId, parame.mUo.pkgVersion());
        g.hio().i((com.tencent.mm.vending.c.a)new c(paramd, parame)).hdy();
      }
      AppMethodBeat.o(228676);
    }
    
    public final void bNs()
    {
      AppMethodBeat.i(228674);
      Log.i(this.TAG, "onAllPkgDownloaded isLaunch:%b", new Object[] { Boolean.valueOf(this.mUO) });
      if ((this.mUN) && (this.mUO) && (this.mUM != null) && (this.mUM.size() > 0))
      {
        Log.i(this.TAG, "mStageList size:%d", new Object[] { Integer.valueOf(this.mUM.size()) });
        Iterator localIterator = this.mUM.iterator();
        while (localIterator.hasNext())
        {
          a locala = (a)localIterator.next();
          mr localmr = new mr();
          QualitySession localQualitySession = this.mSX;
          localmr.zS(localQualitySession.appId);
          localmr.wC(localQualitySession.nLk);
          localmr.a(mr.a.mC(localQualitySession.nJE));
          localmr.wD(localQualitySession.apptype);
          localmr.zV(localQualitySession.kEY);
          localmr.wG(localQualitySession.scene);
          localmr.zU(t.bUy());
          localmr.zT(locala.provider);
          localmr.wE(locala.version);
          localmr.wF(locala.dTz);
          localmr.bfK();
        }
      }
      AppMethodBeat.o(228674);
    }
    
    public final void c(x.d paramd, x.e parame)
    {
      AppMethodBeat.i(228679);
      p.h(paramd, "request");
      p.h(parame, "response");
      l.a.a.a(paramd, parame);
      AppMethodBeat.o(228679);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils$createBatchReporter$2.PluginInfo", "", "(Lcom/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils$createBatchReporter$2;)V", "provider", "", "getProvider", "()Ljava/lang/String;", "setProvider", "(Ljava/lang/String;)V", "stage", "", "getStage", "()I", "setStage", "(I)V", "version", "getVersion", "setVersion", "plugin-appbrand-integration_release"})
    public final class a
    {
      int dTz;
      String provider = "";
      int version;
      
      public final void setProvider(String paramString)
      {
        AppMethodBeat.i(228664);
        p.h(paramString, "<set-?>");
        this.provider = paramString;
        AppMethodBeat.o(228664);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class b
      extends q
      implements kotlin.g.a.a<x>
    {
      b(ac.e parame, x.d paramd, x.e parame1)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
    static final class c<_Ret, _Var>
      implements com.tencent.mm.vending.c.a<_Ret, _Var>
    {
      c(x.d paramd, x.e parame) {}
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
    static final class d<_Ret, _Var>
      implements com.tencent.mm.vending.c.a<_Ret, _Var>
    {
      d(x.d paramd, int paramInt) {}
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils$createBatchReporter$3", "Lcom/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor$IReporter;", "TAG", "", "onPkgCached", "", "request", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "response", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "onPkgMissed", "assignFromQualitySession", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualitySplitCodeLibStatisStruct;", "session", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "plugin-appbrand-integration_release"})
  public static final class f
    implements l.a
  {
    final String TAG = "MicroMsg.AppBrand.LaunchCheckPkgBatchGetCodeUtils.defaultBatchReporter";
    
    f(QualitySession paramQualitySession, acc paramacc, kotlin.g.a.b paramb) {}
    
    private static void a(mr parammr, QualitySession paramQualitySession)
    {
      AppMethodBeat.i(228685);
      parammr.zS(paramQualitySession.appId);
      parammr.wC(paramQualitySession.nLk);
      parammr.a(mr.a.mC(paramQualitySession.nJE));
      parammr.wD(paramQualitySession.apptype);
      parammr.zV(paramQualitySession.kEY);
      parammr.wG(paramQualitySession.scene);
      AppMethodBeat.o(228685);
    }
    
    public final void a(x.d paramd)
    {
      AppMethodBeat.i(228686);
      p.h(paramd, "request");
      p.h(paramd, "request");
      AppMethodBeat.o(228686);
    }
    
    public final void b(x.d paramd)
    {
      AppMethodBeat.i(228684);
      p.h(paramd, "request");
      this.mUP.invoke(paramd);
      Object localObject = com.tencent.mm.cp.a.Rxa;
      p.g(localObject, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
      int[] arrayOfInt;
      if (e.contains((int[])localObject, paramd.packageType))
      {
        localObject = new mr();
        a((mr)localObject, this.mSX);
        ((mr)localObject).zU(t.bUy());
        ((mr)localObject).zT(paramd.appId);
        if (!(paramd.mUl instanceof x.g.b)) {
          break label267;
        }
        ((mr)localObject).wE(((x.g.b)paramd.mUl).version);
        arrayOfInt = n.buL().Vs(paramd.bNz().toString());
        if (arrayOfInt != null) {
          break label151;
        }
        ((mr)localObject).wF(2L);
      }
      for (;;)
      {
        ((mr)localObject).bfK();
        AppMethodBeat.o(228684);
        return;
        label151:
        Collection localCollection = (Collection)new ArrayList();
        int k = arrayOfInt.length;
        int i = 0;
        if (i < k)
        {
          int m = arrayOfInt[i];
          if (m == ((x.g.b)paramd.mUl).version) {}
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
          ((mr)localObject).wF(4L);
          break;
        }
        label265:
        continue;
        label267:
        ((mr)localObject).wE(0L);
        ((mr)localObject).wF(2L);
      }
    }
    
    public final void b(final x.d paramd, final x.e parame)
    {
      AppMethodBeat.i(228683);
      p.h(paramd, "request");
      p.h(parame, "response");
      if (((paramd.mUl instanceof x.g.a)) && (!((x.g.a)paramd.mUl).mUt))
      {
        localObject = com.tencent.mm.cp.a.Rxa;
        p.g(localObject, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
        if (e.contains((int[])localObject, paramd.packageType))
        {
          Log.i(this.TAG, "onPkgCached, will update plugin(" + paramd.appId + ") to latest in background...");
          d.i((kotlin.g.a.a)new a(this, paramd, parame));
        }
      }
      Object localObject = com.tencent.mm.cp.a.Rxa;
      p.g(localObject, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
      if (e.contains((int[])localObject, paramd.packageType))
      {
        localObject = new mr();
        a((mr)localObject, this.mSX);
        ((mr)localObject).zU(t.bUy());
        ((mr)localObject).zT(paramd.appId);
        ((mr)localObject).wE(parame.mUo.pkgVersion());
        ((mr)localObject).wF(3L);
        ((mr)localObject).bfK();
      }
      AppMethodBeat.o(228683);
    }
    
    public final void bNs() {}
    
    public final void c(x.d paramd, x.e parame)
    {
      AppMethodBeat.i(228687);
      p.h(paramd, "request");
      p.h(parame, "response");
      l.a.a.a(paramd, parame);
      AppMethodBeat.o(228687);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(ac.f paramf, x.d paramd, x.e parame)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
  public static final class g<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(180599);
      int i = kotlin.b.a.a((Comparable)Integer.valueOf(((WxaAttributes.WxaWidgetInfo)paramT2).packageType), (Comparable)Integer.valueOf(((WxaAttributes.WxaWidgetInfo)paramT1).packageType));
      AppMethodBeat.o(180599);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ac
 * JD-Core Version:    0.7.0.1
 */