package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ko;
import com.tencent.mm.plugin.appbrand.appcache.IPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaPluginCodeInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaWidgetInfo;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.protocal.protobuf.bah;
import com.tencent.mm.protocal.protobuf.jy;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.vfs.i;
import d.a.v;
import d.g.a.b;
import d.g.a.m;
import d.g.b.p;
import d.h.a;
import d.o;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.atomic.AtomicBoolean;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor;", "", "()V", "TAG", "", "waitForPkgList", "", "appId", "version", "", "versionType", "requestedModuleNames", "", "pickedModuleInfoList", "", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaWidgetInfo;", "reportQualitySession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "onSuccess", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;", "onProgress", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "onError", "Lkotlin/Function2;", "forceNoEncrypt", "", "reporter", "Lcom/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor$IReporter;", "IReporter", "InnerBatchGetDownloadCgiExecutor", "InnerBatchProgressEmitter", "plugin-appbrand-integration_release"})
public final class l
{
  public static final l lGq;
  
  static
  {
    AppMethodBeat.i(180492);
    lGq = new l();
    AppMethodBeat.o(180492);
  }
  
  public static void a(final String paramString, final int paramInt1, final int paramInt2, final List<String> paramList, final Map<String, ? extends WxaAttributes.WxaWidgetInfo> paramMap, final QualitySession paramQualitySession, final b<? super List<? extends IPkgInfo>, d.z> paramb, b<? super WxaPkgLoadProgress, d.z> paramb1, final m<? super Integer, ? super String, d.z> paramm, boolean paramBoolean, final a parama)
  {
    AppMethodBeat.i(180491);
    p.h(paramString, "appId");
    p.h(paramList, "requestedModuleNames");
    p.h(paramMap, "pickedModuleInfoList");
    p.h(paramQualitySession, "reportQualitySession");
    p.h(paramb, "onSuccess");
    p.h(paramb1, "onProgress");
    p.h(paramm, "onError");
    final h localh = new h(paramString, paramInt1, paramInt2, paramQualitySession);
    localh.alive();
    final HashSet localHashSet = new HashSet();
    Object localObject1 = paramList.iterator();
    label187:
    label249:
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      paramList = (String)((Iterator)localObject1).next();
      paramQualitySession = (WxaAttributes.WxaWidgetInfo)paramMap.get(paramList);
      if (paramQualitySession == null)
      {
        paramString = (Throwable)new IllegalStateException(("Invalid ModuleName(" + paramList + ')').toString());
        AppMethodBeat.o(180491);
        throw paramString;
      }
      int j = paramQualitySession.dnF;
      int i;
      if (j.a.rQ(paramInt2))
      {
        i = paramInt1;
        localHashSet.add(new y.d(paramString, paramList, j, paramInt2, (y.g)new y.g.b(i), paramBoolean));
        paramQualitySession = paramQualitySession.kao;
        paramList = paramQualitySession;
        if (paramQualitySession == null) {
          paramList = (List)v.MKE;
        }
        paramQualitySession = paramList.iterator();
        if (paramQualitySession.hasNext())
        {
          paramList = (WxaAttributes.WxaPluginCodeInfo)paramQualitySession.next();
          p.g(paramList, "plugin");
          p.h(paramList, "$this$toRequestInfo");
          localObject2 = paramList.provider;
          p.g(localObject2, "this.provider");
          if (!paramList.jZT) {
            break label349;
          }
        }
      }
      label349:
      for (paramList = (y.g)new y.g.a(paramList.version, 2);; paramList = (y.g)new y.g.b(paramList.version))
      {
        localHashSet.add(new y.d((String)localObject2, "", 6, 0, paramList, false));
        break label249;
        break;
        i = 0;
        break label187;
      }
    }
    if (localHashSet.size() <= 0)
    {
      paramString = (Throwable)new IllegalStateException("RequestPkgInfoList.size==0".toString());
      AppMethodBeat.o(180491);
      throw paramString;
    }
    paramString = new b(localHashSet.size());
    paramList = new c(paramb1);
    paramMap = new AtomicBoolean(false);
    paramQualitySession = new ConcurrentSkipListSet((Comparator)g.lGE);
    paramb1 = localHashSet.iterator();
    while (paramb1.hasNext())
    {
      localObject1 = (y.d)paramb1.next();
      localObject2 = y.lHJ;
      p.g(localObject1, "request");
      y.b.a((y.d)localObject1, (b)new d(paramQualitySession, (y.d)localObject1, paramString, paramList, localHashSet, localh, paramb, parama), (m)new e(localh, (y.d)localObject1, paramMap, paramm, parama), (b)new f(paramList, (y.d)localObject1), (z)paramString, (y.c)parama);
    }
    AppMethodBeat.o(180491);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor$IReporter;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$IReporter;", "onAllPkgDownloaded", "", "onPkgDownloadError", "request", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "plugin-appbrand-integration_release"})
  public static abstract interface a
    extends y.c
  {
    public abstract void a(y.d paramd);
    
    public abstract void bqY();
    
    @d.l(gfx={1, 1, 16})
    public static final class a
    {
      public static void a(y.d paramd, y.e parame)
      {
        AppMethodBeat.i(189243);
        p.h(paramd, "request");
        p.h(parame, "response");
        p.h(paramd, "request");
        p.h(parame, "response");
        AppMethodBeat.o(189243);
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor$InnerBatchGetDownloadCgiExecutor;", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor;", "maxPossibleRequestCount", "", "(I)V", "requestMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;", "Lkotlin/Pair;", "Lkotlin/Function1;", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "", "Lkotlin/Function3;", "", "Lcom/tencent/mm/plugin/appbrand/launching/CgiCallbackPair;", "Lkotlin/collections/HashMap;", "scene", "decreasePossibleRequestCount", "fireAllRequestsIfNeed", "waitForDownloadUrl", "request", "onSuccess", "onError", "plugin-appbrand-integration_release"})
  static final class b
    implements z
  {
    final HashMap<z.b, o<b<bah[], d.z>, d.g.a.q<Integer, Integer, String, d.z>>> kIV;
    int lGr;
    private int scene;
    
    public b(int paramInt)
    {
      AppMethodBeat.i(180483);
      this.lGr = paramInt;
      this.kIV = new HashMap();
      AppMethodBeat.o(180483);
    }
    
    public final void a(z.b paramb, b<? super bah[], d.z> paramb1, d.g.a.q<? super Integer, ? super Integer, ? super String, d.z> paramq, int paramInt)
    {
      AppMethodBeat.i(180481);
      p.h(paramb, "request");
      p.h(paramb1, "onSuccess");
      p.h(paramq, "onError");
      this.scene = paramInt;
      ((Map)this.kIV).put(paramb, new o(paramb1, paramq));
      bqZ();
      AppMethodBeat.o(180481);
    }
    
    public final void bqZ()
    {
      AppMethodBeat.i(180482);
      if (this.lGr != this.kIV.size())
      {
        AppMethodBeat.o(180482);
        return;
      }
      if (this.kIV.size() <= 0)
      {
        AppMethodBeat.o(180482);
        return;
      }
      w.lHv.a((List)new LinkedList((Collection)this.kIV.keySet()), (b)new a(this), (d.g.a.q)new b(this), this.scene);
      AppMethodBeat.o(180482);
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "batchResp", "Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;", "invoke"})
    static final class a
      extends d.g.b.q
      implements b<jy, d.z>
    {
      a(l.b paramb)
      {
        super();
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "invoke"})
    static final class b
      extends d.g.b.q
      implements d.g.a.q<Integer, Integer, String, d.z>
    {
      b(l.b paramb)
      {
        super();
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor$InnerBatchProgressEmitter;", "", "onProgress", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "", "(Lkotlin/jvm/functions/Function1;)V", "progressMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "Lkotlin/collections/HashMap;", "request", "progress", "onReady", "filePath", "", "plugin-appbrand-integration_release"})
  static final class c
  {
    private final HashMap<y.d, WxaPkgLoadProgress> lGt;
    private final b<WxaPkgLoadProgress, d.z> lGu;
    
    public c(b<? super WxaPkgLoadProgress, d.z> paramb)
    {
      AppMethodBeat.i(180486);
      this.lGu = paramb;
      this.lGt = new HashMap();
      AppMethodBeat.o(180486);
    }
    
    public final void a(y.d paramd, WxaPkgLoadProgress paramWxaPkgLoadProgress)
    {
      AppMethodBeat.i(180484);
      p.h(paramd, "request");
      p.h(paramWxaPkgLoadProgress, "progress");
      synchronized (this.lGt)
      {
        ((Map)this.lGt).put(paramd, paramWxaPkgLoadProgress);
        paramd = (c)this;
        long l2 = 0L;
        long l1 = 0L;
        paramd = paramd.lGt.values();
        p.g(paramd, "progressMap.values");
        paramd = ((Iterable)paramd).iterator();
        while (paramd.hasNext())
        {
          paramWxaPkgLoadProgress = (WxaPkgLoadProgress)paramd.next();
          if (paramWxaPkgLoadProgress == null) {
            break label193;
          }
          l2 += Math.max(paramWxaPkgLoadProgress.jIs, 0L);
          l1 += Math.max(paramWxaPkgLoadProgress.jIt, 0L);
        }
        if (l1 <= 0L) {}
        float f;
        for (int i = 0;; i = a.co(f))
        {
          paramd = new WxaPkgLoadProgress(i, l2, l1);
          if (paramd != null) {
            this.lGu.invoke(paramd);
          }
          AppMethodBeat.o(180484);
          return;
          f = (float)l2 / (float)l1;
        }
        label193:
        paramd = null;
      }
    }
    
    public final void a(y.d paramd, String paramString)
    {
      AppMethodBeat.i(180485);
      p.h(paramd, "request");
      p.h(paramString, "filePath");
      if (this.lGt.size() > 0)
      {
        long l = i.aYo(paramString);
        a(paramd, new WxaPkgLoadProgress(100, l, l));
      }
      AppMethodBeat.o(180485);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "response", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "invoke"})
  static final class d
    extends d.g.b.q
    implements b<y.e, d.z>
  {
    d(ConcurrentSkipListSet paramConcurrentSkipListSet, y.d paramd, l.b paramb, l.c paramc, HashSet paramHashSet, l.h paramh, b paramb1, l.a parama)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "err", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$ERROR;", "errMsg", "", "invoke"})
  static final class e
    extends d.g.b.q
    implements m<y.a, String, d.z>
  {
    e(l.h paramh, y.d paramd, AtomicBoolean paramAtomicBoolean, m paramm, l.a parama)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "progress", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "invoke"})
  static final class f
    extends d.g.b.q
    implements b<WxaPkgLoadProgress, d.z>
  {
    f(l.c paramc, y.d paramd)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "o1", "Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;", "kotlin.jvm.PlatformType", "o2", "compare"})
  static final class g<T>
    implements Comparator<IPkgInfo>
  {
    public static final g lGE;
    
    static
    {
      AppMethodBeat.i(189248);
      lGE = new g();
      AppMethodBeat.o(189248);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor$waitForPkgList$qualityReportListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/KV14609ReportEvent;", "callback", "", "event", "plugin-appbrand-integration_release"})
  public static final class h
    extends c<ko>
  {
    h(String paramString, int paramInt1, int paramInt2, QualitySession paramQualitySession) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.l
 * JD-Core Version:    0.7.0.1
 */