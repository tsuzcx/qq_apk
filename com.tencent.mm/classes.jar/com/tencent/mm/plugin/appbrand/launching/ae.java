package com.tencent.mm.plugin.appbrand.launching;

import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.cn.f;
import com.tencent.mm.cn.g;
import com.tencent.mm.g.b.a.gs;
import com.tencent.mm.g.b.a.hp;
import com.tencent.mm.g.b.a.hp.a;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.IPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.ab;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaWidgetInfo;
import com.tencent.mm.plugin.appbrand.report.p;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.awj;
import com.tencent.mm.sdk.platformtools.ac;
import d.a.e;
import d.g.a.m;
import d.g.b.k;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils;", "", "()V", "TAG", "", "WAGAME_TYPE", "", "getWAGAME_TYPE", "()I", "applyLaunchAheadParallelCgiResponse", "", "instanceId", "canUseSeparatedPlugins", "", "appId", "versionType", "appVersion", "isGame", "acceptedLibReader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "createBatchReporter", "Lcom/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor$IReporter;", "reportQualitySession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "isLaunch", "onPkgMissed", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "singleMapOf", "", "K", "V", "key", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;", "pickAppropriateWidgetInfoList", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaWidgetInfo;", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;", "plugin-appbrand-integration_release"})
public final class ae
{
  private static final int llC = 1004;
  public static final ae llD;
  
  static
  {
    AppMethodBeat.i(180606);
    llD = new ae();
    llC = 1004;
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
    paramICommLibReader = paramICommLibReader.HM("injectAppSeparatedPlugin");
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
    if (j.a.on(paramInt1))
    {
      if ((paramICommLibReader != null) && (a(paramICommLibReader, paramBoolean) == true))
      {
        AppMethodBeat.o(180603);
        return true;
      }
      AppMethodBeat.o(180603);
      return false;
    }
    paramString = ((com.tencent.mm.plugin.appbrand.appcache.b)j.T(com.tencent.mm.plugin.appbrand.appcache.b.class)).aE(paramString, paramInt2);
    switch (af.cfA[paramString.ordinal()])
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "invoke", "()[Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "com/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils$applyLaunchAheadParallelCgiResponse$1$1$interceptResp$1"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<awj[]>
  {
    a(z.b paramb, HashMap paramHashMap)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
  public static final class b<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(180589);
      int i = d.b.a.a((Comparable)Integer.valueOf(((WxaAttributes.WxaWidgetInfo)paramT2).dcj), (Comparable)Integer.valueOf(((WxaAttributes.WxaWidgetInfo)paramT1).dcj));
      AppMethodBeat.o(180589);
      return i;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    c(HashMap paramHashMap)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.b<y.d, y>
  {
    public static final d llH;
    
    static
    {
      AppMethodBeat.i(187301);
      llH = new d();
      AppMethodBeat.o(187301);
    }
    
    d()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils$createBatchReporter$2", "Lcom/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor$IReporter;", "TAG", "", "mIsColdStartUp", "", "mStageList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "com/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils$createBatchReporter$2.PluginInfo", "addPluginStage", "", "stage", "", "provider", "version", "markColdStartUp", "onAllPkgDownloaded", "onPkgCached", "request", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "response", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "onPkgDownloadError", "onPkgDownloadSuccess", "packageType", "onPkgMissed", "reportPkgDownloadStatus", "key", "reportPluginHitRate", "assignFromQualitySession", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualitySplitCodeLibStatisStruct;", "session", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "PluginInfo", "plugin-appbrand-integration_release"})
  public static final class e
    implements l.a
  {
    final String TAG;
    private CopyOnWriteArrayList<a> llI;
    private volatile boolean llJ;
    
    e(boolean paramBoolean, QualitySession paramQualitySession, d.g.a.b paramb)
    {
      AppMethodBeat.i(187316);
      this.TAG = "MicroMsg.AppBrand.LaunchCheckPkgBatchGetCodeUtils.gameBatchReporter";
      this.llI = new CopyOnWriteArrayList();
      AppMethodBeat.o(187316);
    }
    
    private final void bnB()
    {
      AppMethodBeat.i(187308);
      if (this.llJ)
      {
        AppMethodBeat.o(187308);
        return;
      }
      this.llJ = true;
      k(1, "", 0);
      AppMethodBeat.o(187308);
    }
    
    private final void k(int paramInt1, String paramString, int paramInt2)
    {
      AppMethodBeat.i(187309);
      ac.i(this.TAG, "addPluginStage stage:%d,provider:%s,version:%d", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2) });
      a locala = new a();
      locala.setProvider(paramString);
      locala.doR = paramInt1;
      locala.version = paramInt2;
      this.llI.add(locala);
      AppMethodBeat.o(187309);
    }
    
    private static void tC(int paramInt)
    {
      AppMethodBeat.i(187310);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(187310);
        return;
        tD(0);
        AppMethodBeat.o(187310);
        return;
        tD(9);
        AppMethodBeat.o(187310);
        return;
        tD(4);
        AppMethodBeat.o(187310);
        return;
        tD(2);
        AppMethodBeat.o(187310);
        return;
        tD(7);
        AppMethodBeat.o(187310);
        return;
        tD(11);
        AppMethodBeat.o(187310);
        return;
        tD(13);
      }
    }
    
    private static void tD(int paramInt)
    {
      AppMethodBeat.i(187311);
      h.wUl.idkeyStat(1027L, paramInt, 1L, false);
      AppMethodBeat.o(187311);
    }
    
    public final void a(y.d paramd)
    {
      AppMethodBeat.i(187313);
      k.h(paramd, "request");
      switch (paramd.dcj)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(187313);
        return;
        tD(1);
        AppMethodBeat.o(187313);
        return;
        tD(10);
        AppMethodBeat.o(187313);
        return;
        tD(5);
        AppMethodBeat.o(187313);
        return;
        tD(3);
        AppMethodBeat.o(187313);
        return;
        tD(8);
        AppMethodBeat.o(187313);
        return;
        tD(12);
        AppMethodBeat.o(187313);
        return;
        tD(14);
      }
    }
    
    public final void b(y.d paramd)
    {
      AppMethodBeat.i(187315);
      k.h(paramd, "request");
      this.llL.ay(paramd);
      int[] arrayOfInt = com.tencent.mm.co.a.JHW;
      k.g(arrayOfInt, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
      if (e.contains(arrayOfInt, paramd.dcj))
      {
        if ((paramd.lkT instanceof y.g.b))
        {
          final int k = ((y.g.b)paramd.lkT).version;
          arrayOfInt = j.aVC().Io(paramd.bnv().toString());
          if (arrayOfInt == null)
          {
            bnB();
            k(2, paramd.appId, k);
            tC(paramd.dcj);
          }
          label266:
          for (;;)
          {
            g.fBc().i((com.tencent.mm.vending.c.a)new d(paramd, k)).fxo();
            AppMethodBeat.o(187315);
            return;
            Collection localCollection = (Collection)new ArrayList();
            int m = arrayOfInt.length;
            int i = 0;
            if (i < m)
            {
              int n = arrayOfInt[i];
              if (n == ((y.g.b)paramd.lkT).version) {}
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
              bnB();
              k(4, paramd.appId, k);
              tC(paramd.dcj);
              break;
            }
          }
        }
        bnB();
        k(2, paramd.appId, 0);
        tC(paramd.dcj);
        AppMethodBeat.o(187315);
        return;
      }
      arrayOfInt = com.tencent.mm.co.a.JHU;
      k.g(arrayOfInt, "ConstantsWxaPackageProto…KAGE_TYPES_IN_WIDGET_INFO");
      if (e.contains(arrayOfInt, paramd.dcj))
      {
        bnB();
        tC(paramd.dcj);
      }
      AppMethodBeat.o(187315);
    }
    
    public final void b(final y.d paramd, final y.e parame)
    {
      AppMethodBeat.i(187314);
      k.h(paramd, "request");
      k.h(parame, "response");
      if (((paramd.lkT instanceof y.g.a)) && (!((y.g.a)paramd.lkT).llb))
      {
        arrayOfInt = com.tencent.mm.co.a.JHW;
        k.g(arrayOfInt, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
        if (e.contains(arrayOfInt, paramd.dcj))
        {
          ac.i(this.TAG, "onPkgCached, will update plugin(" + paramd.appId + ") to latest in background...");
          c.b(null, (d.g.a.a)new b(this, paramd, parame));
        }
      }
      int[] arrayOfInt = com.tencent.mm.co.a.JHW;
      k.g(arrayOfInt, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
      if (e.contains(arrayOfInt, paramd.dcj))
      {
        k(3, paramd.appId, parame.lkW.pkgVersion());
        g.fBc().i((com.tencent.mm.vending.c.a)new c(paramd, parame)).fxo();
      }
      AppMethodBeat.o(187314);
    }
    
    public final void bnm()
    {
      AppMethodBeat.i(187312);
      ac.i(this.TAG, "onAllPkgDownloaded isLaunch:%b", new Object[] { Boolean.valueOf(this.llK) });
      if ((this.llJ) && (this.llK) && (this.llI != null) && (this.llI.size() > 0))
      {
        ac.i(this.TAG, "mStageList size:%d", new Object[] { Integer.valueOf(this.llI.size()) });
        Iterator localIterator = this.llI.iterator();
        while (localIterator.hasNext())
        {
          a locala = (a)localIterator.next();
          hp localhp = new hp();
          QualitySession localQualitySession = this.ljy;
          localhp.oI(localQualitySession.appId);
          localhp.mG(localQualitySession.lVs);
          localhp.a(hp.a.jb(localQualitySession.lTR));
          localhp.mH(localQualitySession.apptype);
          localhp.oL(localQualitySession.lht);
          localhp.mK(localQualitySession.scene);
          localhp.oK(p.btj());
          localhp.oJ(locala.provider);
          localhp.mI(locala.version);
          localhp.mJ(locala.doR);
          localhp.aHZ();
        }
      }
      AppMethodBeat.o(187312);
    }
    
    public final void c(y.d paramd, y.e parame)
    {
      AppMethodBeat.i(187317);
      k.h(paramd, "request");
      k.h(parame, "response");
      l.a.a.a(paramd, parame);
      AppMethodBeat.o(187317);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils$createBatchReporter$2.PluginInfo", "", "(Lcom/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils$createBatchReporter$2;)V", "provider", "", "getProvider", "()Ljava/lang/String;", "setProvider", "(Ljava/lang/String;)V", "stage", "", "getStage", "()I", "setStage", "(I)V", "version", "getVersion", "setVersion", "plugin-appbrand-integration_release"})
    public final class a
    {
      int doR;
      String provider = "";
      int version;
      
      public final void setProvider(String paramString)
      {
        AppMethodBeat.i(187302);
        k.h(paramString, "<set-?>");
        this.provider = paramString;
        AppMethodBeat.o(187302);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class b
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      b(ae.e parame, y.d paramd, y.e parame1)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
    static final class c<_Ret, _Var>
      implements com.tencent.mm.vending.c.a<_Ret, _Var>
    {
      c(y.d paramd, y.e parame) {}
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
    static final class d<_Ret, _Var>
      implements com.tencent.mm.vending.c.a<_Ret, _Var>
    {
      d(y.d paramd, int paramInt) {}
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgBatchGetCodeUtils$createBatchReporter$3", "Lcom/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor$IReporter;", "TAG", "", "onPkgCached", "", "request", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "response", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "onPkgMissed", "assignFromQualitySession", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualitySplitCodeLibStatisStruct;", "session", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "plugin-appbrand-integration_release"})
  public static final class f
    implements l.a
  {
    final String TAG = "MicroMsg.AppBrand.LaunchCheckPkgBatchGetCodeUtils.defaultBatchReporter";
    
    f(QualitySession paramQualitySession, d.g.a.b paramb) {}
    
    private static void a(hp paramhp, QualitySession paramQualitySession)
    {
      AppMethodBeat.i(187323);
      paramhp.oI(paramQualitySession.appId);
      paramhp.mG(paramQualitySession.lVs);
      paramhp.a(hp.a.jb(paramQualitySession.lTR));
      paramhp.mH(paramQualitySession.apptype);
      paramhp.oL(paramQualitySession.lht);
      paramhp.mK(paramQualitySession.scene);
      AppMethodBeat.o(187323);
    }
    
    public final void a(y.d paramd)
    {
      AppMethodBeat.i(187324);
      k.h(paramd, "request");
      k.h(paramd, "request");
      AppMethodBeat.o(187324);
    }
    
    public final void b(y.d paramd)
    {
      AppMethodBeat.i(187322);
      k.h(paramd, "request");
      this.llL.ay(paramd);
      Object localObject = com.tencent.mm.co.a.JHW;
      k.g(localObject, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
      int[] arrayOfInt;
      if (e.contains((int[])localObject, paramd.dcj))
      {
        localObject = new hp();
        a((hp)localObject, this.ljy);
        ((hp)localObject).oK(p.btj());
        ((hp)localObject).oJ(paramd.appId);
        if (!(paramd.lkT instanceof y.g.b)) {
          break label267;
        }
        ((hp)localObject).mI(((y.g.b)paramd.lkT).version);
        arrayOfInt = j.aVC().Io(paramd.bnv().toString());
        if (arrayOfInt != null) {
          break label151;
        }
        ((hp)localObject).mJ(2L);
      }
      for (;;)
      {
        ((hp)localObject).aHZ();
        AppMethodBeat.o(187322);
        return;
        label151:
        Collection localCollection = (Collection)new ArrayList();
        int k = arrayOfInt.length;
        int i = 0;
        if (i < k)
        {
          int m = arrayOfInt[i];
          if (m == ((y.g.b)paramd.lkT).version) {}
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
          ((hp)localObject).mJ(4L);
          break;
        }
        label265:
        continue;
        label267:
        ((hp)localObject).mI(0L);
        ((hp)localObject).mJ(2L);
      }
    }
    
    public final void b(final y.d paramd, final y.e parame)
    {
      AppMethodBeat.i(187321);
      k.h(paramd, "request");
      k.h(parame, "response");
      if (((paramd.lkT instanceof y.g.a)) && (!((y.g.a)paramd.lkT).llb))
      {
        localObject = com.tencent.mm.co.a.JHW;
        k.g(localObject, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
        if (e.contains((int[])localObject, paramd.dcj))
        {
          ac.i(this.TAG, "onPkgCached, will update plugin(" + paramd.appId + ") to latest in background...");
          c.b(null, (d.g.a.a)new a(this, paramd, parame));
        }
      }
      Object localObject = com.tencent.mm.co.a.JHW;
      k.g(localObject, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
      if (e.contains((int[])localObject, paramd.dcj))
      {
        localObject = new hp();
        a((hp)localObject, this.ljy);
        ((hp)localObject).oK(p.btj());
        ((hp)localObject).oJ(paramd.appId);
        ((hp)localObject).mI(parame.lkW.pkgVersion());
        ((hp)localObject).mJ(3L);
        ((hp)localObject).aHZ();
      }
      AppMethodBeat.o(187321);
    }
    
    public final void bnm() {}
    
    public final void c(y.d paramd, y.e parame)
    {
      AppMethodBeat.i(187325);
      k.h(paramd, "request");
      k.h(parame, "response");
      l.a.a.a(paramd, parame);
      AppMethodBeat.o(187325);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      a(ae.f paramf, y.d paramd, y.e parame)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
  public static final class g<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(180599);
      int i = d.b.a.a((Comparable)Integer.valueOf(((WxaAttributes.WxaWidgetInfo)paramT2).dcj), (Comparable)Integer.valueOf(((WxaAttributes.WxaWidgetInfo)paramT1).dcj));
      AppMethodBeat.o(180599);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ae
 * JD-Core Version:    0.7.0.1
 */