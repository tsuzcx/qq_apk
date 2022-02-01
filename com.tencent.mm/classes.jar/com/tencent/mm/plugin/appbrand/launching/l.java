package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jy;
import com.tencent.mm.plugin.appbrand.appcache.IPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaPluginCodeInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaWidgetInfo;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.protocal.protobuf.atf;
import com.tencent.mm.protocal.protobuf.jj;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.vfs.i;
import d.a.v;
import d.aa;
import d.g.a.b;
import d.g.a.m;
import d.g.a.q;
import d.g.b.k;
import d.h.a;
import d.o;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor;", "", "()V", "TAG", "", "waitForPkgList", "", "appId", "version", "", "versionType", "requestedModuleNames", "", "pickedModuleInfoList", "", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaWidgetInfo;", "reportQualitySession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "onSuccess", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;", "onProgress", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "onError", "Lkotlin/Function2;", "forceNoEncrypt", "", "reporter", "Lcom/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor$IReporter;", "IReporter", "InnerBatchGetDownloadCgiExecutor", "InnerBatchProgressEmitter", "plugin-appbrand-integration_release"})
public final class l
{
  public static final l kHP;
  
  static
  {
    AppMethodBeat.i(180492);
    kHP = new l();
    AppMethodBeat.o(180492);
  }
  
  public static void a(final String paramString, final int paramInt1, final int paramInt2, final List<String> paramList, final Map<String, ? extends WxaAttributes.WxaWidgetInfo> paramMap, final QualitySession paramQualitySession, final b<? super List<? extends IPkgInfo>, d.y> paramb, b<? super WxaPkgLoadProgress, d.y> paramb1, final m<? super Integer, ? super String, d.y> paramm, final a parama)
  {
    AppMethodBeat.i(196356);
    k.h(paramString, "appId");
    k.h(paramList, "requestedModuleNames");
    k.h(paramMap, "pickedModuleInfoList");
    k.h(paramQualitySession, "reportQualitySession");
    k.h(paramb, "onSuccess");
    k.h(paramb1, "onProgress");
    k.h(paramm, "onError");
    g localg = new g(paramString, paramInt1, paramInt2, paramQualitySession);
    localg.alive();
    final HashSet localHashSet = new HashSet();
    Object localObject1 = paramList.iterator();
    label187:
    label248:
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      paramList = (String)((Iterator)localObject1).next();
      paramQualitySession = (WxaAttributes.WxaWidgetInfo)paramMap.get(paramList);
      if (paramQualitySession == null)
      {
        paramString = (Throwable)new IllegalStateException(("Invalid ModuleName(" + paramList + ')').toString());
        AppMethodBeat.o(196356);
        throw paramString;
      }
      int j = paramQualitySession.deP;
      int i;
      if (j.a.qD(paramInt2))
      {
        i = paramInt1;
        localHashSet.add(new y.d(paramString, paramList, j, paramInt2, (y.g)new y.g.b(i), true));
        paramQualitySession = paramQualitySession.jfQ;
        paramList = paramQualitySession;
        if (paramQualitySession == null) {
          paramList = (List)v.Jgl;
        }
        paramQualitySession = paramList.iterator();
        if (paramQualitySession.hasNext())
        {
          paramList = (WxaAttributes.WxaPluginCodeInfo)paramQualitySession.next();
          k.g(paramList, "plugin");
          k.h(paramList, "$this$toRequestInfo");
          localObject2 = paramList.provider;
          k.g(localObject2, "this.provider");
          if (!paramList.jfv) {
            break label343;
          }
        }
      }
      label343:
      for (paramList = (y.g)new y.g.a();; paramList = (y.g)new y.g.b(paramList.version))
      {
        localHashSet.add(new y.d((String)localObject2, "", 6, 0, paramList, false));
        break label248;
        break;
        i = 0;
        break label187;
      }
    }
    if ((localHashSet.size() <= 0) && (aa.JfW))
    {
      paramString = (Throwable)new AssertionError("RequestPkgInfoList.size==0");
      AppMethodBeat.o(196356);
      throw paramString;
    }
    paramString = new b(localHashSet.size());
    paramList = new c(paramb1);
    paramMap = new AtomicBoolean(false);
    paramQualitySession = new ConcurrentLinkedQueue();
    paramb1 = localHashSet.iterator();
    while (paramb1.hasNext())
    {
      localObject1 = (y.d)paramb1.next();
      localObject2 = y.kJf;
      k.g(localObject1, "request");
      y.b.a((y.d)localObject1, (b)new d(localg, (y.d)localObject1, paramString, paramList, paramQualitySession, localHashSet, paramb, parama), (m)new e(localg, (y.d)localObject1, paramMap, paramm, parama), (b)new f(paramList, (y.d)localObject1), (z)paramString, (y.c)parama);
    }
    AppMethodBeat.o(196356);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor$IReporter;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$IReporter;", "onAllPkgDownloaded", "", "onPkgDownloadError", "request", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "plugin-appbrand-integration_release"})
  public static abstract interface a
    extends y.c
  {
    public abstract void a(y.d paramd);
    
    public abstract void bgs();
    
    @d.l(fvt={1, 1, 16})
    public static final class a
    {
      public static void a(y.d paramd, y.e parame)
      {
        AppMethodBeat.i(196355);
        k.h(paramd, "request");
        k.h(parame, "response");
        k.h(paramd, "request");
        k.h(parame, "response");
        AppMethodBeat.o(196355);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor$InnerBatchGetDownloadCgiExecutor;", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor;", "maxPossibleRequestCount", "", "(I)V", "requestMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;", "Lkotlin/Pair;", "Lkotlin/Function1;", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "", "Lkotlin/Function3;", "", "Lcom/tencent/mm/plugin/appbrand/launching/CgiCallbackPair;", "Lkotlin/collections/HashMap;", "scene", "decreasePossibleRequestCount", "fireAllRequestsIfNeed", "waitForDownloadUrl", "request", "onSuccess", "onError", "plugin-appbrand-integration_release"})
  static final class b
    implements z
  {
    final HashMap<z.b, o<b<atf[], d.y>, q<Integer, Integer, String, d.y>>> jNu;
    int kHQ;
    private int scene;
    
    public b(int paramInt)
    {
      AppMethodBeat.i(180483);
      this.kHQ = paramInt;
      this.jNu = new HashMap();
      AppMethodBeat.o(180483);
    }
    
    public final void a(z.b paramb, b<? super atf[], d.y> paramb1, q<? super Integer, ? super Integer, ? super String, d.y> paramq, int paramInt)
    {
      AppMethodBeat.i(180481);
      k.h(paramb, "request");
      k.h(paramb1, "onSuccess");
      k.h(paramq, "onError");
      this.scene = paramInt;
      ((Map)this.jNu).put(paramb, new o(paramb1, paramq));
      bgt();
      AppMethodBeat.o(180481);
    }
    
    public final void bgt()
    {
      AppMethodBeat.i(180482);
      if (this.kHQ != this.jNu.size())
      {
        AppMethodBeat.o(180482);
        return;
      }
      if (this.jNu.size() <= 0)
      {
        AppMethodBeat.o(180482);
        return;
      }
      w.kIR.a((List)new LinkedList((Collection)this.jNu.keySet()), (b)new a(this), (q)new b(this), this.scene);
      AppMethodBeat.o(180482);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "batchResp", "Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;", "invoke"})
    static final class a
      extends d.g.b.l
      implements b<jj, d.y>
    {
      a(l.b paramb)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "invoke"})
    static final class b
      extends d.g.b.l
      implements q<Integer, Integer, String, d.y>
    {
      b(l.b paramb)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor$InnerBatchProgressEmitter;", "", "onProgress", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "", "(Lkotlin/jvm/functions/Function1;)V", "progressMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "Lkotlin/collections/HashMap;", "request", "progress", "onReady", "filePath", "", "plugin-appbrand-integration_release"})
  static final class c
  {
    private final HashMap<y.d, WxaPkgLoadProgress> kHS;
    private final b<WxaPkgLoadProgress, d.y> kHT;
    
    public c(b<? super WxaPkgLoadProgress, d.y> paramb)
    {
      AppMethodBeat.i(180486);
      this.kHT = paramb;
      this.kHS = new HashMap();
      AppMethodBeat.o(180486);
    }
    
    public final void a(y.d paramd, WxaPkgLoadProgress paramWxaPkgLoadProgress)
    {
      AppMethodBeat.i(180484);
      k.h(paramd, "request");
      k.h(paramWxaPkgLoadProgress, "progress");
      synchronized (this.kHS)
      {
        ((Map)this.kHS).put(paramd, paramWxaPkgLoadProgress);
        paramd = (c)this;
        long l2 = 0L;
        long l1 = 0L;
        paramd = paramd.kHS.values();
        k.g(paramd, "progressMap.values");
        paramd = ((Iterable)paramd).iterator();
        while (paramd.hasNext())
        {
          paramWxaPkgLoadProgress = (WxaPkgLoadProgress)paramd.next();
          if (paramWxaPkgLoadProgress == null) {
            break label193;
          }
          l2 += Math.max(paramWxaPkgLoadProgress.iOn, 0L);
          l1 += Math.max(paramWxaPkgLoadProgress.iOo, 0L);
        }
        if (l1 <= 0L) {}
        float f;
        for (int i = 0;; i = a.bU(f))
        {
          paramd = new WxaPkgLoadProgress(i, l2, l1);
          if (paramd != null) {
            this.kHT.aA(paramd);
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
      k.h(paramd, "request");
      k.h(paramString, "filePath");
      if (this.kHS.size() > 0)
      {
        long l = i.aMN(paramString);
        a(paramd, new WxaPkgLoadProgress(100, l, l));
      }
      AppMethodBeat.o(180485);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "response", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "invoke"})
  static final class d
    extends d.g.b.l
    implements b<y.e, d.y>
  {
    d(l.g paramg, y.d paramd, l.b paramb, l.c paramc, ConcurrentLinkedQueue paramConcurrentLinkedQueue, HashSet paramHashSet, b paramb1, l.a parama)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "err", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$ERROR;", "errMsg", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements m<y.a, String, d.y>
  {
    e(l.g paramg, y.d paramd, AtomicBoolean paramAtomicBoolean, m paramm, l.a parama)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "progress", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "invoke"})
  static final class f
    extends d.g.b.l
    implements b<WxaPkgLoadProgress, d.y>
  {
    f(l.c paramc, y.d paramd)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor$waitForPkgList$qualityReportListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/KV14609ReportEvent;", "callback", "", "event", "plugin-appbrand-integration_release"})
  public static final class g
    extends c<jy>
  {
    g(String paramString, int paramInt1, int paramInt2, QualitySession paramQualitySession) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.l
 * JD-Core Version:    0.7.0.1
 */