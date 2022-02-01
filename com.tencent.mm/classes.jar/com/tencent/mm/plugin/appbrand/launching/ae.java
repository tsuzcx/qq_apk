package com.tencent.mm.plugin.appbrand.launching;

import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.cm.f;
import com.tencent.mm.g.b.a.iv;
import com.tencent.mm.g.b.a.iv.a;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.IPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaWidgetInfo;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.protocal.protobuf.bax;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils;", "", "()V", "TAG", "", "WAGAME_TYPE", "", "getWAGAME_TYPE", "()I", "applyLaunchAheadParallelCgiResponse", "", "instanceId", "canUseSeparatedPlugins", "", "appId", "versionType", "appVersion", "isGame", "acceptedLibReader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "createBatchReporter", "Lcom/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor$IReporter;", "reportQualitySession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "isLaunch", "onPkgMissed", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "singleMapOf", "", "K", "V", "key", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;", "pickAppropriateWidgetInfoList", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaWidgetInfo;", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;", "plugin-appbrand-integration_release"})
public final class ae
{
  private static final int lNk = 1004;
  public static final ae lNl;
  
  static
  {
    AppMethodBeat.i(180606);
    lNl = new ae();
    lNk = 1004;
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
    paramICommLibReader = paramICommLibReader.LE("injectAppSeparatedPlugin");
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
    if (j.a.oQ(paramInt1))
    {
      if ((paramICommLibReader != null) && (a(paramICommLibReader, paramBoolean) == true))
      {
        AppMethodBeat.o(180603);
        return true;
      }
      AppMethodBeat.o(180603);
      return false;
    }
    paramString = ((com.tencent.mm.plugin.appbrand.appcache.b)j.T(com.tencent.mm.plugin.appbrand.appcache.b.class)).aH(paramString, paramInt2);
    switch (af.cqt[paramString.ordinal()])
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "invoke", "()[Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "com/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils$applyLaunchAheadParallelCgiResponse$1$1$interceptResp$1"})
  static final class a
    extends d.g.b.q
    implements d.g.a.a<bax[]>
  {
    a(z.b paramb, HashMap paramHashMap)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
  public static final class b<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(180589);
      int i = d.b.a.a((Comparable)Integer.valueOf(((WxaAttributes.WxaWidgetInfo)paramT2).doK), (Comparable)Integer.valueOf(((WxaAttributes.WxaWidgetInfo)paramT1).doK));
      AppMethodBeat.o(180589);
      return i;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    c(HashMap paramHashMap)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "invoke"})
  static final class d
    extends d.g.b.q
    implements d.g.a.b<y.d, z>
  {
    public static final d lNp;
    
    static
    {
      AppMethodBeat.i(223523);
      lNp = new d();
      AppMethodBeat.o(223523);
    }
    
    d()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils$createBatchReporter$2", "Lcom/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor$IReporter;", "TAG", "", "mIsColdStartUp", "", "mStageList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "com/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils$createBatchReporter$2.PluginInfo", "addPluginStage", "", "stage", "", "provider", "version", "markColdStartUp", "onAllPkgDownloaded", "onPkgCached", "request", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "response", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "onPkgDownloadError", "onPkgDownloadSuccess", "packageType", "onPkgMissed", "reportPkgDownloadStatus", "key", "reportPluginHitRate", "assignFromQualitySession", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualitySplitCodeLibStatisStruct;", "session", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "PluginInfo", "plugin-appbrand-integration_release"})
  public static final class e
    implements l.a
  {
    final String TAG;
    private CopyOnWriteArrayList<a> lNq;
    private volatile boolean lNr;
    
    e(boolean paramBoolean, QualitySession paramQualitySession, d.g.a.b paramb)
    {
      AppMethodBeat.i(223538);
      this.TAG = "MicroMsg.AppBrand.LaunchCheckPkgBatchGetCodeUtils.gameBatchReporter";
      this.lNq = new CopyOnWriteArrayList();
      AppMethodBeat.o(223538);
    }
    
    private final void brZ()
    {
      AppMethodBeat.i(223530);
      if (this.lNr)
      {
        AppMethodBeat.o(223530);
        return;
      }
      this.lNr = true;
      k(1, "", 0);
      AppMethodBeat.o(223530);
    }
    
    private final void k(int paramInt1, String paramString, int paramInt2)
    {
      AppMethodBeat.i(223531);
      com.tencent.mm.sdk.platformtools.ae.i(this.TAG, "addPluginStage stage:%d,provider:%s,version:%d", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2) });
      a locala = new a();
      locala.setProvider(paramString);
      locala.dBK = paramInt1;
      locala.version = paramInt2;
      this.lNq.add(locala);
      AppMethodBeat.o(223531);
    }
    
    private static void um(int paramInt)
    {
      AppMethodBeat.i(223532);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(223532);
        return;
        un(0);
        AppMethodBeat.o(223532);
        return;
        un(9);
        AppMethodBeat.o(223532);
        return;
        un(4);
        AppMethodBeat.o(223532);
        return;
        un(2);
        AppMethodBeat.o(223532);
        return;
        un(7);
        AppMethodBeat.o(223532);
        return;
        un(11);
        AppMethodBeat.o(223532);
        return;
        un(13);
      }
    }
    
    private static void un(int paramInt)
    {
      AppMethodBeat.i(223533);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1027L, paramInt, 1L, false);
      AppMethodBeat.o(223533);
    }
    
    public final void a(y.d paramd)
    {
      AppMethodBeat.i(223535);
      p.h(paramd, "request");
      switch (paramd.doK)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(223535);
        return;
        un(1);
        AppMethodBeat.o(223535);
        return;
        un(10);
        AppMethodBeat.o(223535);
        return;
        un(5);
        AppMethodBeat.o(223535);
        return;
        un(3);
        AppMethodBeat.o(223535);
        return;
        un(8);
        AppMethodBeat.o(223535);
        return;
        un(12);
        AppMethodBeat.o(223535);
        return;
        un(14);
      }
    }
    
    public final void b(y.d paramd)
    {
      AppMethodBeat.i(223537);
      p.h(paramd, "request");
      this.lNt.invoke(paramd);
      int[] arrayOfInt = com.tencent.mm.cn.a.LYa;
      p.g(arrayOfInt, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
      if (e.contains(arrayOfInt, paramd.doK))
      {
        if ((paramd.lMB instanceof y.g.b))
        {
          final int k = ((y.g.b)paramd.lMB).version;
          arrayOfInt = j.aZu().Mj(paramd.brR().toString());
          if (arrayOfInt == null)
          {
            brZ();
            k(2, paramd.appId, k);
            um(paramd.doK);
          }
          label266:
          for (;;)
          {
            com.tencent.mm.cm.g.fWL().i((com.tencent.mm.vending.c.a)new d(paramd, k)).fSw();
            AppMethodBeat.o(223537);
            return;
            Collection localCollection = (Collection)new ArrayList();
            int m = arrayOfInt.length;
            int i = 0;
            if (i < m)
            {
              int n = arrayOfInt[i];
              if (n == ((y.g.b)paramd.lMB).version) {}
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
              brZ();
              k(4, paramd.appId, k);
              um(paramd.doK);
              break;
            }
          }
        }
        brZ();
        k(2, paramd.appId, 0);
        um(paramd.doK);
        AppMethodBeat.o(223537);
        return;
      }
      arrayOfInt = com.tencent.mm.cn.a.LXY;
      p.g(arrayOfInt, "ConstantsWxaPackageProto…KAGE_TYPES_IN_WIDGET_INFO");
      if (e.contains(arrayOfInt, paramd.doK))
      {
        brZ();
        um(paramd.doK);
      }
      AppMethodBeat.o(223537);
    }
    
    public final void b(y.d paramd, final y.e parame)
    {
      AppMethodBeat.i(223536);
      p.h(paramd, "request");
      p.h(parame, "response");
      if (((paramd.lMB instanceof y.g.a)) && (!((y.g.a)paramd.lMB).lMJ))
      {
        arrayOfInt = com.tencent.mm.cn.a.LYa;
        p.g(arrayOfInt, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
        if (e.contains(arrayOfInt, paramd.doK))
        {
          com.tencent.mm.sdk.platformtools.ae.i(this.TAG, "onPkgCached, will update plugin(" + paramd.appId + ") to latest in background...");
          c.b(null, (d.g.a.a)new ae.e.b(this, paramd, parame));
        }
      }
      int[] arrayOfInt = com.tencent.mm.cn.a.LYa;
      p.g(arrayOfInt, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
      if (e.contains(arrayOfInt, paramd.doK))
      {
        k(3, paramd.appId, parame.lME.pkgVersion());
        com.tencent.mm.cm.g.fWL().i((com.tencent.mm.vending.c.a)new c(paramd, parame)).fSw();
      }
      AppMethodBeat.o(223536);
    }
    
    public final void brI()
    {
      AppMethodBeat.i(223534);
      com.tencent.mm.sdk.platformtools.ae.i(this.TAG, "onAllPkgDownloaded isLaunch:%b", new Object[] { Boolean.valueOf(this.lNs) });
      if ((this.lNr) && (this.lNs) && (this.lNq != null) && (this.lNq.size() > 0))
      {
        com.tencent.mm.sdk.platformtools.ae.i(this.TAG, "mStageList size:%d", new Object[] { Integer.valueOf(this.lNq.size()) });
        Iterator localIterator = this.lNq.iterator();
        while (localIterator.hasNext())
        {
          a locala = (a)localIterator.next();
          iv localiv = new iv();
          QualitySession localQualitySession = this.lLg;
          localiv.rK(localQualitySession.appId);
          localiv.oR(localQualitySession.mAf);
          localiv.a(iv.a.jA(localQualitySession.myD));
          localiv.oS(localQualitySession.apptype);
          localiv.rN(localQualitySession.lIU);
          localiv.oV(localQualitySession.scene);
          localiv.rM(com.tencent.mm.plugin.appbrand.report.q.byh());
          localiv.rL(locala.provider);
          localiv.oT(locala.version);
          localiv.oU(locala.dBK);
          localiv.aLH();
        }
      }
      AppMethodBeat.o(223534);
    }
    
    public final void c(y.d paramd, y.e parame)
    {
      AppMethodBeat.i(223539);
      p.h(paramd, "request");
      p.h(parame, "response");
      l.a.a.a(paramd, parame);
      AppMethodBeat.o(223539);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils$createBatchReporter$2.PluginInfo", "", "(Lcom/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils$createBatchReporter$2;)V", "provider", "", "getProvider", "()Ljava/lang/String;", "setProvider", "(Ljava/lang/String;)V", "stage", "", "getStage", "()I", "setStage", "(I)V", "version", "getVersion", "setVersion", "plugin-appbrand-integration_release"})
    public final class a
    {
      int dBK;
      String provider = "";
      int version;
      
      public final void setProvider(String paramString)
      {
        AppMethodBeat.i(223524);
        p.h(paramString, "<set-?>");
        this.provider = paramString;
        AppMethodBeat.o(223524);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
    static final class c<_Ret, _Var>
      implements com.tencent.mm.vending.c.a<_Ret, _Var>
    {
      c(y.d paramd, y.e parame) {}
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
    static final class d<_Ret, _Var>
      implements com.tencent.mm.vending.c.a<_Ret, _Var>
    {
      d(y.d paramd, int paramInt) {}
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils$createBatchReporter$3", "Lcom/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor$IReporter;", "TAG", "", "onPkgCached", "", "request", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "response", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "onPkgMissed", "assignFromQualitySession", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualitySplitCodeLibStatisStruct;", "session", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "plugin-appbrand-integration_release"})
  public static final class f
    implements l.a
  {
    final String TAG = "MicroMsg.AppBrand.LaunchCheckPkgBatchGetCodeUtils.defaultBatchReporter";
    
    f(QualitySession paramQualitySession, d.g.a.b paramb) {}
    
    private static void a(iv paramiv, QualitySession paramQualitySession)
    {
      AppMethodBeat.i(223545);
      paramiv.rK(paramQualitySession.appId);
      paramiv.oR(paramQualitySession.mAf);
      paramiv.a(iv.a.jA(paramQualitySession.myD));
      paramiv.oS(paramQualitySession.apptype);
      paramiv.rN(paramQualitySession.lIU);
      paramiv.oV(paramQualitySession.scene);
      AppMethodBeat.o(223545);
    }
    
    public final void a(y.d paramd)
    {
      AppMethodBeat.i(223546);
      p.h(paramd, "request");
      p.h(paramd, "request");
      AppMethodBeat.o(223546);
    }
    
    public final void b(y.d paramd)
    {
      AppMethodBeat.i(223544);
      p.h(paramd, "request");
      this.lNt.invoke(paramd);
      Object localObject = com.tencent.mm.cn.a.LYa;
      p.g(localObject, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
      int[] arrayOfInt;
      if (e.contains((int[])localObject, paramd.doK))
      {
        localObject = new iv();
        a((iv)localObject, this.lLg);
        ((iv)localObject).rM(com.tencent.mm.plugin.appbrand.report.q.byh());
        ((iv)localObject).rL(paramd.appId);
        if (!(paramd.lMB instanceof y.g.b)) {
          break label267;
        }
        ((iv)localObject).oT(((y.g.b)paramd.lMB).version);
        arrayOfInt = j.aZu().Mj(paramd.brR().toString());
        if (arrayOfInt != null) {
          break label151;
        }
        ((iv)localObject).oU(2L);
      }
      for (;;)
      {
        ((iv)localObject).aLH();
        AppMethodBeat.o(223544);
        return;
        label151:
        Collection localCollection = (Collection)new ArrayList();
        int k = arrayOfInt.length;
        int i = 0;
        if (i < k)
        {
          int m = arrayOfInt[i];
          if (m == ((y.g.b)paramd.lMB).version) {}
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
          ((iv)localObject).oU(4L);
          break;
        }
        label265:
        continue;
        label267:
        ((iv)localObject).oT(0L);
        ((iv)localObject).oU(2L);
      }
    }
    
    public final void b(y.d paramd, y.e parame)
    {
      AppMethodBeat.i(223543);
      p.h(paramd, "request");
      p.h(parame, "response");
      if (((paramd.lMB instanceof y.g.a)) && (!((y.g.a)paramd.lMB).lMJ))
      {
        localObject = com.tencent.mm.cn.a.LYa;
        p.g(localObject, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
        if (e.contains((int[])localObject, paramd.doK))
        {
          com.tencent.mm.sdk.platformtools.ae.i(this.TAG, "onPkgCached, will update plugin(" + paramd.appId + ") to latest in background...");
          c.b(null, (d.g.a.a)new ae.f.a(this, paramd, parame));
        }
      }
      Object localObject = com.tencent.mm.cn.a.LYa;
      p.g(localObject, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
      if (e.contains((int[])localObject, paramd.doK))
      {
        localObject = new iv();
        a((iv)localObject, this.lLg);
        ((iv)localObject).rM(com.tencent.mm.plugin.appbrand.report.q.byh());
        ((iv)localObject).rL(paramd.appId);
        ((iv)localObject).oT(parame.lME.pkgVersion());
        ((iv)localObject).oU(3L);
        ((iv)localObject).aLH();
      }
      AppMethodBeat.o(223543);
    }
    
    public final void brI() {}
    
    public final void c(y.d paramd, y.e parame)
    {
      AppMethodBeat.i(223547);
      p.h(paramd, "request");
      p.h(parame, "response");
      l.a.a.a(paramd, parame);
      AppMethodBeat.o(223547);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
  public static final class g<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(180599);
      int i = d.b.a.a((Comparable)Integer.valueOf(((WxaAttributes.WxaWidgetInfo)paramT2).doK), (Comparable)Integer.valueOf(((WxaAttributes.WxaWidgetInfo)paramT1).doK));
      AppMethodBeat.o(180599);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ae
 * JD-Core Version:    0.7.0.1
 */