package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.IPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaPluginCodeInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaWidgetInfo;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.protocal.protobuf.ack;
import com.tencent.mm.protocal.protobuf.btv;
import com.tencent.mm.protocal.protobuf.kd;
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
import kotlin.a.v;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.h.a;
import kotlin.l;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor;", "", "()V", "TAG", "", "waitForPkgList", "", "appId", "wxaVersionInfo", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;", "versionType", "", "requestedModuleNames", "", "pickedModuleInfoList", "", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaWidgetInfo;", "reportQualitySession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "onSuccess", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;", "onProgress", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "onError", "Lkotlin/Function2;", "forceNoEncrypt", "", "cgiCommRequestSource", "Lcom/tencent/mm/protocal/protobuf/CommRequestSource;", "reporter", "Lcom/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor$IReporter;", "forcedPluginVersions", "IReporter", "InnerBatchGetDownloadCgiExecutor", "InnerBatchProgressEmitter", "plugin-appbrand-integration_release"})
public final class k
{
  public static final k pTF;
  
  static
  {
    AppMethodBeat.i(180492);
    pTF = new k();
    AppMethodBeat.o(180492);
  }
  
  public static void a(final String paramString, final WxaAttributes.WxaVersionInfo paramWxaVersionInfo, int paramInt, final List<String> paramList, Map<String, ? extends WxaAttributes.WxaWidgetInfo> paramMap, QualitySession paramQualitySession, final b<? super List<? extends IPkgInfo>, kotlin.x> paramb, final b<? super WxaPkgLoadProgress, kotlin.x> paramb1, final m<? super Integer, ? super String, kotlin.x> paramm, boolean paramBoolean, ack paramack, final a parama, Map<String, Integer> paramMap1)
  {
    AppMethodBeat.i(268623);
    p.k(paramString, "appId");
    p.k(paramWxaVersionInfo, "wxaVersionInfo");
    p.k(paramList, "requestedModuleNames");
    p.k(paramMap, "pickedModuleInfoList");
    p.k(paramQualitySession, "reportQualitySession");
    p.k(paramb, "onSuccess");
    p.k(paramb1, "onProgress");
    p.k(paramm, "onError");
    p.k(paramack, "cgiCommRequestSource");
    int j = paramWxaVersionInfo.appVersion;
    final k.h localh = new k.h(paramString, j, paramInt, paramQualitySession);
    localh.alive();
    final HashSet localHashSet = new HashSet();
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      paramQualitySession = (String)localIterator.next();
      Object localObject = (WxaAttributes.WxaWidgetInfo)paramMap.get(paramQualitySession);
      if (localObject == null)
      {
        paramString = (Throwable)new IllegalStateException(("Invalid ModuleName(" + paramQualitySession + ')').toString());
        AppMethodBeat.o(268623);
        throw paramString;
      }
      int i = ((WxaAttributes.WxaWidgetInfo)localObject).fyH;
      label221:
      WxaAttributes.WxaPluginCodeInfo localWxaPluginCodeInfo;
      if (j.a.za(paramInt))
      {
        paramList = new w.g.c(j, paramWxaVersionInfo.obN);
        localHashSet.add(new w.d(paramString, paramQualitySession, i, paramInt, (w.g)paramList, paramBoolean));
        paramQualitySession = ((WxaAttributes.WxaWidgetInfo)localObject).obS;
        paramList = paramQualitySession;
        if (paramQualitySession == null) {
          paramList = (List)v.aaAd;
        }
        localObject = paramList.iterator();
        label276:
        if (((Iterator)localObject).hasNext())
        {
          localWxaPluginCodeInfo = (WxaAttributes.WxaPluginCodeInfo)((Iterator)localObject).next();
          p.j(localWxaPluginCodeInfo, "plugin");
          if (paramMap1 == null) {
            break label388;
          }
          paramList = localWxaPluginCodeInfo.provider;
          p.j(paramList, "plugin.provider");
          paramQualitySession = paramMap1.get(paramList);
          paramList = paramQualitySession;
          if (paramQualitySession == null) {
            paramList = Integer.valueOf(-1);
          }
          paramList = (Integer)paramList;
          if (paramList == null) {
            break label388;
          }
        }
      }
      label388:
      for (i = paramList.intValue();; i = -1)
      {
        localHashSet.add(n.a(localWxaPluginCodeInfo, i));
        break label276;
        break;
        paramList = new w.g.c(0);
        break label221;
      }
    }
    if (localHashSet.size() <= 0)
    {
      paramString = (Throwable)new IllegalStateException("RequestPkgInfoList.size==0".toString());
      AppMethodBeat.o(268623);
      throw paramString;
    }
    paramString = new b(localHashSet.size(), paramack);
    paramWxaVersionInfo = new c(paramb1);
    paramList = new AtomicBoolean(false);
    paramMap = new ConcurrentSkipListSet((Comparator)g.pTT);
    paramQualitySession = localHashSet.iterator();
    while (paramQualitySession.hasNext())
    {
      paramb1 = (w.d)paramQualitySession.next();
      paramMap1 = w.pUP;
      p.j(paramb1, "request");
      w.b.a(paramb1, (b)new d(paramMap, paramb1, paramString, paramWxaVersionInfo, localHashSet, localh, paramb, parama), (m)new e(localh, paramb1, paramList, paramm, parama), (b)new f(paramWxaVersionInfo, paramb1), (x)paramString, paramack, (w.c)parama, 32);
    }
    AppMethodBeat.o(268623);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor$IReporter;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$IReporter;", "onAllPkgDownloaded", "", "onPkgDownloadError", "request", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "plugin-appbrand-integration_release"})
  public static abstract interface a
    extends w.c
  {
    public abstract void a(w.d paramd);
    
    public abstract void bZJ();
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor$InnerBatchGetDownloadCgiExecutor;", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor;", "maxPossibleRequestCount", "", "cgiCommRequestSource", "Lcom/tencent/mm/protocal/protobuf/CommRequestSource;", "(ILcom/tencent/mm/protocal/protobuf/CommRequestSource;)V", "requestMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;", "Lkotlin/Pair;", "Lkotlin/Function1;", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "", "Lkotlin/Function3;", "", "Lcom/tencent/mm/plugin/appbrand/launching/CgiCallbackPair;", "Lkotlin/collections/HashMap;", "scene", "decreasePossibleRequestCount", "fireAllRequestsIfNeed", "waitForDownloadUrl", "request", "onSuccess", "onError", "plugin-appbrand-integration_release"})
  static final class b
    implements x
  {
    final HashMap<x.a, o<b<btv[], kotlin.x>, kotlin.g.a.q<Integer, Integer, String, kotlin.x>>> oNr;
    int pTG;
    private final ack pTH;
    private int scene;
    
    public b(int paramInt, ack paramack)
    {
      AppMethodBeat.i(280194);
      this.pTG = paramInt;
      this.pTH = paramack;
      this.oNr = new HashMap();
      AppMethodBeat.o(280194);
    }
    
    public final void a(x.a parama, b<? super btv[], kotlin.x> paramb, kotlin.g.a.q<? super Integer, ? super Integer, ? super String, kotlin.x> paramq, int paramInt, ack paramack)
    {
      AppMethodBeat.i(280191);
      p.k(parama, "request");
      p.k(paramb, "onSuccess");
      p.k(paramq, "onError");
      p.k(paramack, "cgiCommRequestSource");
      this.scene = paramInt;
      ((Map)this.oNr).put(parama, new o(paramb, paramq));
      bZK();
      AppMethodBeat.o(280191);
    }
    
    public final void bZK()
    {
      AppMethodBeat.i(180482);
      if (this.pTG != this.oNr.size())
      {
        AppMethodBeat.o(180482);
        return;
      }
      if (this.oNr.size() <= 0)
      {
        AppMethodBeat.o(180482);
        return;
      }
      u.pUH.a((List)new LinkedList((Collection)this.oNr.keySet()), (b)new a(this), (kotlin.g.a.q)new b(this), this.scene, this.pTH);
      AppMethodBeat.o(180482);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "batchResp", "Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements b<kd, kotlin.x>
    {
      a(k.b paramb)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "invoke"})
    static final class b
      extends kotlin.g.b.q
      implements kotlin.g.a.q<Integer, Integer, String, kotlin.x>
    {
      b(k.b paramb)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor$InnerBatchProgressEmitter;", "", "onProgress", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "", "(Lkotlin/jvm/functions/Function1;)V", "progressMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "Lkotlin/collections/HashMap;", "request", "progress", "onReady", "filePath", "", "plugin-appbrand-integration_release"})
  static final class c
  {
    private final HashMap<w.d, WxaPkgLoadProgress> pTJ;
    private final b<WxaPkgLoadProgress, kotlin.x> pTK;
    
    public c(b<? super WxaPkgLoadProgress, kotlin.x> paramb)
    {
      AppMethodBeat.i(180486);
      this.pTK = paramb;
      this.pTJ = new HashMap();
      AppMethodBeat.o(180486);
    }
    
    public final void a(w.d paramd, WxaPkgLoadProgress paramWxaPkgLoadProgress)
    {
      AppMethodBeat.i(180484);
      p.k(paramd, "request");
      p.k(paramWxaPkgLoadProgress, "progress");
      synchronized (this.pTJ)
      {
        ((Map)this.pTJ).put(paramd, paramWxaPkgLoadProgress);
        paramd = (c)this;
        long l2 = 0L;
        long l1 = 0L;
        paramd = paramd.pTJ.values();
        p.j(paramd, "progressMap.values");
        paramd = ((Iterable)paramd).iterator();
        while (paramd.hasNext())
        {
          paramWxaPkgLoadProgress = (WxaPkgLoadProgress)paramd.next();
          if (paramWxaPkgLoadProgress == null) {
            break label196;
          }
          l2 += Math.max(paramWxaPkgLoadProgress.nHs, 0L);
          l1 += Math.max(paramWxaPkgLoadProgress.nHt, 0L);
        }
        if (l1 <= 0L) {}
        float f;
        for (int i = 0;; i = a.dm(f * 100.0F))
        {
          paramd = new WxaPkgLoadProgress(i, l2, l1);
          if (paramd != null) {
            this.pTK.invoke(paramd);
          }
          AppMethodBeat.o(180484);
          return;
          f = (float)l2 / (float)l1;
        }
        label196:
        paramd = null;
      }
    }
    
    public final void a(w.d paramd, String paramString)
    {
      AppMethodBeat.i(180485);
      p.k(paramd, "request");
      p.k(paramString, "filePath");
      if (this.pTJ.size() > 0)
      {
        long l = com.tencent.mm.vfs.u.bBQ(paramString);
        a(paramd, new WxaPkgLoadProgress(100, l, l));
      }
      AppMethodBeat.o(180485);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "response", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements b<w.e, kotlin.x>
  {
    d(ConcurrentSkipListSet paramConcurrentSkipListSet, w.d paramd, k.b paramb, k.c paramc, HashSet paramHashSet, k.h paramh, b paramb1, k.a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "err", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$ERROR;", "errMsg", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements m<w.a, String, kotlin.x>
  {
    e(k.h paramh, w.d paramd, AtomicBoolean paramAtomicBoolean, m paramm, k.a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "progress", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements b<WxaPkgLoadProgress, kotlin.x>
  {
    f(k.c paramc, w.d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "o1", "Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;", "kotlin.jvm.PlatformType", "o2", "compare"})
  static final class g<T>
    implements Comparator<IPkgInfo>
  {
    public static final g pTT;
    
    static
    {
      AppMethodBeat.i(281797);
      pTT = new g();
      AppMethodBeat.o(281797);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.k
 * JD-Core Version:    0.7.0.1
 */