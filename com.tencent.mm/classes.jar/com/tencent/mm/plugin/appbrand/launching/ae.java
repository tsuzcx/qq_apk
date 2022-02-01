package com.tencent.mm.plugin.appbrand.launching;

import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.cn.f;
import com.tencent.mm.g.b.a.it;
import com.tencent.mm.g.b.a.it.a;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.IPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.ac;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaWidgetInfo;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.protocal.protobuf.bah;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.e;
import d.g.b.p;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils;", "", "()V", "TAG", "", "WAGAME_TYPE", "", "getWAGAME_TYPE", "()I", "applyLaunchAheadParallelCgiResponse", "", "instanceId", "canUseSeparatedPlugins", "", "appId", "versionType", "appVersion", "isGame", "acceptedLibReader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "createBatchReporter", "Lcom/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor$IReporter;", "reportQualitySession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "isLaunch", "onPkgMissed", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "singleMapOf", "", "K", "V", "key", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;", "pickAppropriateWidgetInfoList", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaWidgetInfo;", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;", "plugin-appbrand-integration_release"})
public final class ae
{
  private static final int lIK = 1004;
  public static final ae lIL;
  
  static
  {
    AppMethodBeat.i(180606);
    lIL = new ae();
    lIK = 1004;
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
  
  private static boolean a(ICommLibReader paramICommLibReader, boolean paramBoolean)
  {
    AppMethodBeat.i(180602);
    if (paramBoolean)
    {
      AppMethodBeat.o(180602);
      return true;
    }
    paramICommLibReader = paramICommLibReader.Le("injectAppSeparatedPlugin");
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
    if (j.a.oN(paramInt1))
    {
      if ((paramICommLibReader != null) && (a(paramICommLibReader, paramBoolean) == true))
      {
        AppMethodBeat.o(180603);
        return true;
      }
      AppMethodBeat.o(180603);
      return false;
    }
    paramString = ((com.tencent.mm.plugin.appbrand.appcache.b)j.T(com.tencent.mm.plugin.appbrand.appcache.b.class)).aG(paramString, paramInt2);
    switch (af.cpQ[paramString.ordinal()])
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "invoke", "()[Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "com/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils$applyLaunchAheadParallelCgiResponse$1$1$interceptResp$1"})
  static final class a
    extends d.g.b.q
    implements d.g.a.a<bah[]>
  {
    a(z.b paramb, HashMap paramHashMap)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
  public static final class b<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(180589);
      int i = d.b.a.a((Comparable)Integer.valueOf(((WxaAttributes.WxaWidgetInfo)paramT2).dnF), (Comparable)Integer.valueOf(((WxaAttributes.WxaWidgetInfo)paramT1).dnF));
      AppMethodBeat.o(180589);
      return i;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    c(HashMap paramHashMap)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "invoke"})
  static final class d
    extends d.g.b.q
    implements d.g.a.b<y.d, z>
  {
    public static final d lIP;
    
    static
    {
      AppMethodBeat.i(189265);
      lIP = new d();
      AppMethodBeat.o(189265);
    }
    
    d()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils$createBatchReporter$2", "Lcom/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor$IReporter;", "TAG", "", "mIsColdStartUp", "", "mStageList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "com/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils$createBatchReporter$2.PluginInfo", "addPluginStage", "", "stage", "", "provider", "version", "markColdStartUp", "onAllPkgDownloaded", "onPkgCached", "request", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "response", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "onPkgDownloadError", "onPkgDownloadSuccess", "packageType", "onPkgMissed", "reportPkgDownloadStatus", "key", "reportPluginHitRate", "assignFromQualitySession", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualitySplitCodeLibStatisStruct;", "session", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "PluginInfo", "plugin-appbrand-integration_release"})
  public static final class e
    implements l.a
  {
    final String TAG;
    private CopyOnWriteArrayList<a> lIQ;
    private volatile boolean lIR;
    
    e(boolean paramBoolean, QualitySession paramQualitySession, d.g.a.b paramb)
    {
      AppMethodBeat.i(189280);
      this.TAG = "MicroMsg.AppBrand.LaunchCheckPkgBatchGetCodeUtils.gameBatchReporter";
      this.lIQ = new CopyOnWriteArrayList();
      AppMethodBeat.o(189280);
    }
    
    private final void bro()
    {
      AppMethodBeat.i(189272);
      if (this.lIR)
      {
        AppMethodBeat.o(189272);
        return;
      }
      this.lIR = true;
      k(1, "", 0);
      AppMethodBeat.o(189272);
    }
    
    private final void k(int paramInt1, String paramString, int paramInt2)
    {
      AppMethodBeat.i(189273);
      ad.i(this.TAG, "addPluginStage stage:%d,provider:%s,version:%d", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2) });
      a locala = new a();
      locala.setProvider(paramString);
      locala.dAF = paramInt1;
      locala.version = paramInt2;
      this.lIQ.add(locala);
      AppMethodBeat.o(189273);
    }
    
    private static void ug(int paramInt)
    {
      AppMethodBeat.i(189274);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(189274);
        return;
        uh(0);
        AppMethodBeat.o(189274);
        return;
        uh(9);
        AppMethodBeat.o(189274);
        return;
        uh(4);
        AppMethodBeat.o(189274);
        return;
        uh(2);
        AppMethodBeat.o(189274);
        return;
        uh(7);
        AppMethodBeat.o(189274);
        return;
        uh(11);
        AppMethodBeat.o(189274);
        return;
        uh(13);
      }
    }
    
    private static void uh(int paramInt)
    {
      AppMethodBeat.i(189275);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1027L, paramInt, 1L, false);
      AppMethodBeat.o(189275);
    }
    
    public final void a(y.d paramd)
    {
      AppMethodBeat.i(189277);
      p.h(paramd, "request");
      switch (paramd.dnF)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(189277);
        return;
        uh(1);
        AppMethodBeat.o(189277);
        return;
        uh(10);
        AppMethodBeat.o(189277);
        return;
        uh(5);
        AppMethodBeat.o(189277);
        return;
        uh(3);
        AppMethodBeat.o(189277);
        return;
        uh(8);
        AppMethodBeat.o(189277);
        return;
        uh(12);
        AppMethodBeat.o(189277);
        return;
        uh(14);
      }
    }
    
    public final void b(y.d paramd)
    {
      AppMethodBeat.i(189279);
      p.h(paramd, "request");
      this.lIT.invoke(paramd);
      int[] arrayOfInt = com.tencent.mm.co.a.LBa;
      p.g(arrayOfInt, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
      if (e.contains(arrayOfInt, paramd.dnF))
      {
        if ((paramd.lIb instanceof y.g.b))
        {
          final int k = ((y.g.b)paramd.lIb).version;
          arrayOfInt = j.aYX().LG(paramd.brh().toString());
          if (arrayOfInt == null)
          {
            bro();
            k(2, paramd.appId, k);
            ug(paramd.dnF);
          }
          label266:
          for (;;)
          {
            com.tencent.mm.cn.g.fSm().i((com.tencent.mm.vending.c.a)new d(paramd, k)).fOb();
            AppMethodBeat.o(189279);
            return;
            Collection localCollection = (Collection)new ArrayList();
            int m = arrayOfInt.length;
            int i = 0;
            if (i < m)
            {
              int n = arrayOfInt[i];
              if (n == ((y.g.b)paramd.lIb).version) {}
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
              bro();
              k(4, paramd.appId, k);
              ug(paramd.dnF);
              break;
            }
          }
        }
        bro();
        k(2, paramd.appId, 0);
        ug(paramd.dnF);
        AppMethodBeat.o(189279);
        return;
      }
      arrayOfInt = com.tencent.mm.co.a.LAY;
      p.g(arrayOfInt, "ConstantsWxaPackageProto…KAGE_TYPES_IN_WIDGET_INFO");
      if (e.contains(arrayOfInt, paramd.dnF))
      {
        bro();
        ug(paramd.dnF);
      }
      AppMethodBeat.o(189279);
    }
    
    public final void b(y.d paramd, final y.e parame)
    {
      AppMethodBeat.i(189278);
      p.h(paramd, "request");
      p.h(parame, "response");
      if (((paramd.lIb instanceof y.g.a)) && (!((y.g.a)paramd.lIb).lIj))
      {
        arrayOfInt = com.tencent.mm.co.a.LBa;
        p.g(arrayOfInt, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
        if (e.contains(arrayOfInt, paramd.dnF))
        {
          ad.i(this.TAG, "onPkgCached, will update plugin(" + paramd.appId + ") to latest in background...");
          c.b(null, (d.g.a.a)new ae.e.b(this, paramd, parame));
        }
      }
      int[] arrayOfInt = com.tencent.mm.co.a.LBa;
      p.g(arrayOfInt, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
      if (e.contains(arrayOfInt, paramd.dnF))
      {
        k(3, paramd.appId, parame.lIe.pkgVersion());
        com.tencent.mm.cn.g.fSm().i((com.tencent.mm.vending.c.a)new c(paramd, parame)).fOb();
      }
      AppMethodBeat.o(189278);
    }
    
    public final void bqY()
    {
      AppMethodBeat.i(189276);
      ad.i(this.TAG, "onAllPkgDownloaded isLaunch:%b", new Object[] { Boolean.valueOf(this.lIS) });
      if ((this.lIR) && (this.lIS) && (this.lIQ != null) && (this.lIQ.size() > 0))
      {
        ad.i(this.TAG, "mStageList size:%d", new Object[] { Integer.valueOf(this.lIQ.size()) });
        Iterator localIterator = this.lIQ.iterator();
        while (localIterator.hasNext())
        {
          a locala = (a)localIterator.next();
          it localit = new it();
          QualitySession localQualitySession = this.lGG;
          localit.rp(localQualitySession.appId);
          localit.oE(localQualitySession.mvi);
          localit.a(it.a.jy(localQualitySession.mtG));
          localit.oF(localQualitySession.apptype);
          localit.rs(localQualitySession.lEv);
          localit.oI(localQualitySession.scene);
          localit.rr(com.tencent.mm.plugin.appbrand.report.q.bxo());
          localit.rq(locala.provider);
          localit.oG(locala.version);
          localit.oH(locala.dAF);
          localit.aLk();
        }
      }
      AppMethodBeat.o(189276);
    }
    
    public final void c(y.d paramd, y.e parame)
    {
      AppMethodBeat.i(189281);
      p.h(paramd, "request");
      p.h(parame, "response");
      l.a.a.a(paramd, parame);
      AppMethodBeat.o(189281);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils$createBatchReporter$2.PluginInfo", "", "(Lcom/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils$createBatchReporter$2;)V", "provider", "", "getProvider", "()Ljava/lang/String;", "setProvider", "(Ljava/lang/String;)V", "stage", "", "getStage", "()I", "setStage", "(I)V", "version", "getVersion", "setVersion", "plugin-appbrand-integration_release"})
    public final class a
    {
      int dAF;
      String provider = "";
      int version;
      
      public final void setProvider(String paramString)
      {
        AppMethodBeat.i(189266);
        p.h(paramString, "<set-?>");
        this.provider = paramString;
        AppMethodBeat.o(189266);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
    static final class c<_Ret, _Var>
      implements com.tencent.mm.vending.c.a<_Ret, _Var>
    {
      c(y.d paramd, y.e parame) {}
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
    static final class d<_Ret, _Var>
      implements com.tencent.mm.vending.c.a<_Ret, _Var>
    {
      d(y.d paramd, int paramInt) {}
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils$createBatchReporter$3", "Lcom/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor$IReporter;", "TAG", "", "onPkgCached", "", "request", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "response", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "onPkgMissed", "assignFromQualitySession", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualitySplitCodeLibStatisStruct;", "session", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "plugin-appbrand-integration_release"})
  public static final class f
    implements l.a
  {
    final String TAG = "MicroMsg.AppBrand.LaunchCheckPkgBatchGetCodeUtils.defaultBatchReporter";
    
    f(QualitySession paramQualitySession, d.g.a.b paramb) {}
    
    private static void a(it paramit, QualitySession paramQualitySession)
    {
      AppMethodBeat.i(189287);
      paramit.rp(paramQualitySession.appId);
      paramit.oE(paramQualitySession.mvi);
      paramit.a(it.a.jy(paramQualitySession.mtG));
      paramit.oF(paramQualitySession.apptype);
      paramit.rs(paramQualitySession.lEv);
      paramit.oI(paramQualitySession.scene);
      AppMethodBeat.o(189287);
    }
    
    public final void a(y.d paramd)
    {
      AppMethodBeat.i(189288);
      p.h(paramd, "request");
      p.h(paramd, "request");
      AppMethodBeat.o(189288);
    }
    
    public final void b(y.d paramd)
    {
      AppMethodBeat.i(189286);
      p.h(paramd, "request");
      this.lIT.invoke(paramd);
      Object localObject = com.tencent.mm.co.a.LBa;
      p.g(localObject, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
      int[] arrayOfInt;
      if (e.contains((int[])localObject, paramd.dnF))
      {
        localObject = new it();
        a((it)localObject, this.lGG);
        ((it)localObject).rr(com.tencent.mm.plugin.appbrand.report.q.bxo());
        ((it)localObject).rq(paramd.appId);
        if (!(paramd.lIb instanceof y.g.b)) {
          break label267;
        }
        ((it)localObject).oG(((y.g.b)paramd.lIb).version);
        arrayOfInt = j.aYX().LG(paramd.brh().toString());
        if (arrayOfInt != null) {
          break label151;
        }
        ((it)localObject).oH(2L);
      }
      for (;;)
      {
        ((it)localObject).aLk();
        AppMethodBeat.o(189286);
        return;
        label151:
        Collection localCollection = (Collection)new ArrayList();
        int k = arrayOfInt.length;
        int i = 0;
        if (i < k)
        {
          int m = arrayOfInt[i];
          if (m == ((y.g.b)paramd.lIb).version) {}
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
          ((it)localObject).oH(4L);
          break;
        }
        label265:
        continue;
        label267:
        ((it)localObject).oG(0L);
        ((it)localObject).oH(2L);
      }
    }
    
    public final void b(y.d paramd, y.e parame)
    {
      AppMethodBeat.i(189285);
      p.h(paramd, "request");
      p.h(parame, "response");
      if (((paramd.lIb instanceof y.g.a)) && (!((y.g.a)paramd.lIb).lIj))
      {
        localObject = com.tencent.mm.co.a.LBa;
        p.g(localObject, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
        if (e.contains((int[])localObject, paramd.dnF))
        {
          ad.i(this.TAG, "onPkgCached, will update plugin(" + paramd.appId + ") to latest in background...");
          c.b(null, (d.g.a.a)new ae.f.a(this, paramd, parame));
        }
      }
      Object localObject = com.tencent.mm.co.a.LBa;
      p.g(localObject, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
      if (e.contains((int[])localObject, paramd.dnF))
      {
        localObject = new it();
        a((it)localObject, this.lGG);
        ((it)localObject).rr(com.tencent.mm.plugin.appbrand.report.q.bxo());
        ((it)localObject).rq(paramd.appId);
        ((it)localObject).oG(parame.lIe.pkgVersion());
        ((it)localObject).oH(3L);
        ((it)localObject).aLk();
      }
      AppMethodBeat.o(189285);
    }
    
    public final void bqY() {}
    
    public final void c(y.d paramd, y.e parame)
    {
      AppMethodBeat.i(189289);
      p.h(paramd, "request");
      p.h(parame, "response");
      l.a.a.a(paramd, parame);
      AppMethodBeat.o(189289);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
  public static final class g<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(180599);
      int i = d.b.a.a((Comparable)Integer.valueOf(((WxaAttributes.WxaWidgetInfo)paramT2).dnF), (Comparable)Integer.valueOf(((WxaAttributes.WxaWidgetInfo)paramT1).dnF));
      AppMethodBeat.o(180599);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ae
 * JD-Core Version:    0.7.0.1
 */