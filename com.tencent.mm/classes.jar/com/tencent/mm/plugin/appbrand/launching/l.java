package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lf;
import com.tencent.mm.plugin.appbrand.appcache.IPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaPluginCodeInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaWidgetInfo;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.protocal.protobuf.bmm;
import com.tencent.mm.protocal.protobuf.kn;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.vfs.s;
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
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.h.a;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor;", "", "()V", "TAG", "", "waitForPkgList", "", "appId", "version", "", "versionType", "requestedModuleNames", "", "pickedModuleInfoList", "", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaWidgetInfo;", "reportQualitySession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "onSuccess", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;", "onProgress", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "onError", "Lkotlin/Function2;", "forceNoEncrypt", "", "cgiCommRequestSource", "Lcom/tencent/mm/protocal/protobuf/CommRequestSource;", "reporter", "Lcom/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor$IReporter;", "IReporter", "InnerBatchGetDownloadCgiExecutor", "InnerBatchProgressEmitter", "plugin-appbrand-integration_release"})
public final class l
{
  public static final l mSI;
  
  static
  {
    AppMethodBeat.i(180492);
    mSI = new l();
    AppMethodBeat.o(180492);
  }
  
  public static void a(final String paramString, final int paramInt1, final int paramInt2, final List<String> paramList, final Map<String, ? extends WxaAttributes.WxaWidgetInfo> paramMap, final QualitySession paramQualitySession, final b<? super List<? extends IPkgInfo>, kotlin.x> paramb, b<? super WxaPkgLoadProgress, kotlin.x> paramb1, final m<? super Integer, ? super String, kotlin.x> paramm, boolean paramBoolean, acc paramacc, final a parama)
  {
    AppMethodBeat.i(228627);
    p.h(paramString, "appId");
    p.h(paramList, "requestedModuleNames");
    p.h(paramMap, "pickedModuleInfoList");
    p.h(paramQualitySession, "reportQualitySession");
    p.h(paramb, "onSuccess");
    p.h(paramb1, "onProgress");
    p.h(paramm, "onError");
    p.h(paramacc, "cgiCommRequestSource");
    final h localh = new h(paramString, paramInt1, paramInt2, paramQualitySession);
    localh.alive();
    final HashSet localHashSet = new HashSet();
    Object localObject = paramList.iterator();
    if (((Iterator)localObject).hasNext())
    {
      paramList = (String)((Iterator)localObject).next();
      paramQualitySession = (WxaAttributes.WxaWidgetInfo)paramMap.get(paramList);
      if (paramQualitySession == null)
      {
        paramString = (Throwable)new IllegalStateException(("Invalid ModuleName(" + paramList + ')').toString());
        AppMethodBeat.o(228627);
        throw paramString;
      }
      int j = paramQualitySession.packageType;
      if (j.a.vP(paramInt2)) {}
      for (int i = paramInt1;; i = 0)
      {
        localHashSet.add(new x.d(paramString, paramList, j, paramInt2, (x.g)new x.g.b(i), paramBoolean));
        paramQualitySession = paramQualitySession.lhk;
        paramList = paramQualitySession;
        if (paramQualitySession == null) {
          paramList = (List)kotlin.a.v.SXr;
        }
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          paramQualitySession = (WxaAttributes.WxaPluginCodeInfo)paramList.next();
          p.g(paramQualitySession, "plugin");
          localHashSet.add(o.a(paramQualitySession));
        }
        break;
      }
    }
    if (localHashSet.size() <= 0)
    {
      paramString = (Throwable)new IllegalStateException("RequestPkgInfoList.size==0".toString());
      AppMethodBeat.o(228627);
      throw paramString;
    }
    paramString = new b(localHashSet.size(), paramacc);
    paramList = new c(paramb1);
    paramMap = new AtomicBoolean(false);
    paramQualitySession = new ConcurrentSkipListSet((Comparator)g.mSW);
    paramb1 = localHashSet.iterator();
    while (paramb1.hasNext())
    {
      localObject = (x.d)paramb1.next();
      x.b localb = x.mTR;
      p.g(localObject, "request");
      x.b.a((x.d)localObject, (b)new d(paramQualitySession, (x.d)localObject, paramString, paramList, localHashSet, localh, paramb, parama), (m)new e(localh, (x.d)localObject, paramMap, paramm, parama), (b)new f(paramList, (x.d)localObject), (y)paramString, paramacc, (x.c)parama, 32);
    }
    AppMethodBeat.o(228627);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor$IReporter;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$IReporter;", "onAllPkgDownloaded", "", "onPkgDownloadError", "request", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "plugin-appbrand-integration_release"})
  public static abstract interface a
    extends x.c
  {
    public abstract void a(x.d paramd);
    
    public abstract void bNs();
    
    @kotlin.l(hxD={1, 1, 16})
    public static final class a
    {
      public static void a(x.d paramd, x.e parame)
      {
        AppMethodBeat.i(228619);
        p.h(paramd, "request");
        p.h(parame, "response");
        p.h(paramd, "request");
        p.h(parame, "response");
        AppMethodBeat.o(228619);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor$InnerBatchGetDownloadCgiExecutor;", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor;", "maxPossibleRequestCount", "", "cgiCommRequestSource", "Lcom/tencent/mm/protocal/protobuf/CommRequestSource;", "(ILcom/tencent/mm/protocal/protobuf/CommRequestSource;)V", "requestMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;", "Lkotlin/Pair;", "Lkotlin/Function1;", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "", "Lkotlin/Function3;", "", "Lcom/tencent/mm/plugin/appbrand/launching/CgiCallbackPair;", "Lkotlin/collections/HashMap;", "scene", "decreasePossibleRequestCount", "fireAllRequestsIfNeed", "waitForDownloadUrl", "request", "onSuccess", "onError", "plugin-appbrand-integration_release"})
  static final class b
    implements y
  {
    final HashMap<y.b, kotlin.o<b<bmm[], kotlin.x>, kotlin.g.a.q<Integer, Integer, String, kotlin.x>>> lQW;
    int mSJ;
    private final acc mSK;
    private int scene;
    
    public b(int paramInt, acc paramacc)
    {
      AppMethodBeat.i(228621);
      this.mSJ = paramInt;
      this.mSK = paramacc;
      this.lQW = new HashMap();
      AppMethodBeat.o(228621);
    }
    
    public final void a(y.b paramb, b<? super bmm[], kotlin.x> paramb1, kotlin.g.a.q<? super Integer, ? super Integer, ? super String, kotlin.x> paramq, int paramInt, acc paramacc)
    {
      AppMethodBeat.i(228620);
      p.h(paramb, "request");
      p.h(paramb1, "onSuccess");
      p.h(paramq, "onError");
      p.h(paramacc, "cgiCommRequestSource");
      this.scene = paramInt;
      ((Map)this.lQW).put(paramb, new kotlin.o(paramb1, paramq));
      bNt();
      AppMethodBeat.o(228620);
    }
    
    public final void bNt()
    {
      AppMethodBeat.i(180482);
      if (this.mSJ != this.lQW.size())
      {
        AppMethodBeat.o(180482);
        return;
      }
      if (this.lQW.size() <= 0)
      {
        AppMethodBeat.o(180482);
        return;
      }
      v.mTG.a((List)new LinkedList((Collection)this.lQW.keySet()), (b)new a(this), (kotlin.g.a.q)new b(this), this.scene, this.mSK);
      AppMethodBeat.o(180482);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "batchResp", "Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements b<kn, kotlin.x>
    {
      a(l.b paramb)
      {
        super();
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "invoke"})
    static final class b
      extends kotlin.g.b.q
      implements kotlin.g.a.q<Integer, Integer, String, kotlin.x>
    {
      b(l.b paramb)
      {
        super();
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor$InnerBatchProgressEmitter;", "", "onProgress", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "", "(Lkotlin/jvm/functions/Function1;)V", "progressMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "Lkotlin/collections/HashMap;", "request", "progress", "onReady", "filePath", "", "plugin-appbrand-integration_release"})
  static final class c
  {
    private final HashMap<x.d, WxaPkgLoadProgress> mSM;
    private final b<WxaPkgLoadProgress, kotlin.x> mSN;
    
    public c(b<? super WxaPkgLoadProgress, kotlin.x> paramb)
    {
      AppMethodBeat.i(180486);
      this.mSN = paramb;
      this.mSM = new HashMap();
      AppMethodBeat.o(180486);
    }
    
    public final void a(x.d paramd, WxaPkgLoadProgress paramWxaPkgLoadProgress)
    {
      AppMethodBeat.i(180484);
      p.h(paramd, "request");
      p.h(paramWxaPkgLoadProgress, "progress");
      synchronized (this.mSM)
      {
        ((Map)this.mSM).put(paramd, paramWxaPkgLoadProgress);
        paramd = (c)this;
        long l2 = 0L;
        long l1 = 0L;
        paramd = paramd.mSM.values();
        p.g(paramd, "progressMap.values");
        paramd = ((Iterable)paramd).iterator();
        while (paramd.hasNext())
        {
          paramWxaPkgLoadProgress = (WxaPkgLoadProgress)paramd.next();
          if (paramWxaPkgLoadProgress == null) {
            break label196;
          }
          l2 += Math.max(paramWxaPkgLoadProgress.kNs, 0L);
          l1 += Math.max(paramWxaPkgLoadProgress.kNt, 0L);
        }
        if (l1 <= 0L) {}
        float f;
        for (int i = 0;; i = a.cR(f * 100.0F))
        {
          paramd = new WxaPkgLoadProgress(i, l2, l1);
          if (paramd != null) {
            this.mSN.invoke(paramd);
          }
          AppMethodBeat.o(180484);
          return;
          f = (float)l2 / (float)l1;
        }
        label196:
        paramd = null;
      }
    }
    
    public final void a(x.d paramd, String paramString)
    {
      AppMethodBeat.i(180485);
      p.h(paramd, "request");
      p.h(paramString, "filePath");
      if (this.mSM.size() > 0)
      {
        long l = s.boW(paramString);
        a(paramd, new WxaPkgLoadProgress(100, l, l));
      }
      AppMethodBeat.o(180485);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "response", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements b<x.e, kotlin.x>
  {
    d(ConcurrentSkipListSet paramConcurrentSkipListSet, x.d paramd, l.b paramb, l.c paramc, HashSet paramHashSet, l.h paramh, b paramb1, l.a parama)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "err", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$ERROR;", "errMsg", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements m<x.a, String, kotlin.x>
  {
    e(l.h paramh, x.d paramd, AtomicBoolean paramAtomicBoolean, m paramm, l.a parama)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "progress", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements b<WxaPkgLoadProgress, kotlin.x>
  {
    f(l.c paramc, x.d paramd)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "o1", "Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;", "kotlin.jvm.PlatformType", "o2", "compare"})
  static final class g<T>
    implements Comparator<IPkgInfo>
  {
    public static final g mSW;
    
    static
    {
      AppMethodBeat.i(228626);
      mSW = new g();
      AppMethodBeat.o(228626);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor$waitForPkgList$qualityReportListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/KV14609ReportEvent;", "callback", "", "event", "plugin-appbrand-integration_release"})
  public static final class h
    extends IListener<lf>
  {
    h(String paramString, int paramInt1, int paramInt2, QualitySession paramQualitySession) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.l
 * JD-Core Version:    0.7.0.1
 */