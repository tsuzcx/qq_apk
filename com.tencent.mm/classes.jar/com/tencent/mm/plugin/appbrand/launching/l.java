package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.IPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.af;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.appcache.k.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaPluginCodeInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaWidgetInfo;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.protocal.protobuf.aeo;
import com.tencent.mm.protocal.protobuf.ciq;
import com.tencent.mm.protocal.protobuf.kz;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.h.a;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor;", "", "()V", "TAG", "", "waitForPkgList", "", "appId", "wxaVersionInfo", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;", "versionType", "", "requestedModuleNames", "", "pickedModuleInfoList", "", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaWidgetInfo;", "reportQualitySession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "onSuccess", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;", "onProgress", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "onError", "Lkotlin/Function2;", "forceNoEncrypt", "", "cgiCommRequestSource", "Lcom/tencent/mm/protocal/protobuf/CommRequestSource;", "reporter", "Lcom/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor$IReporter;", "forcedPluginVersions", "IReporter", "InnerBatchGetDownloadCgiExecutor", "InnerBatchProgressEmitter", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
{
  public static final l sYJ;
  
  static
  {
    AppMethodBeat.i(180492);
    sYJ = new l();
    AppMethodBeat.o(180492);
  }
  
  private static final int a(IPkgInfo paramIPkgInfo1, IPkgInfo paramIPkgInfo2)
  {
    AppMethodBeat.i(320837);
    boolean bool;
    if (s.p(paramIPkgInfo1.getClass(), paramIPkgInfo2.getClass())) {
      if ((paramIPkgInfo1 instanceof WxaPluginPkgInfo))
      {
        if (paramIPkgInfo2 == null)
        {
          paramIPkgInfo1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo");
          AppMethodBeat.o(320837);
          throw paramIPkgInfo1;
        }
        if ((s.p(((WxaPluginPkgInfo)paramIPkgInfo1).provider, ((WxaPluginPkgInfo)paramIPkgInfo2).provider)) && (((WxaPluginPkgInfo)paramIPkgInfo1).version == ((WxaPluginPkgInfo)paramIPkgInfo2).version)) {
          bool = true;
        }
      }
    }
    while (bool)
    {
      AppMethodBeat.o(320837);
      return 0;
      bool = false;
      continue;
      if ((paramIPkgInfo1 instanceof ModulePkgInfo))
      {
        if (paramIPkgInfo2 == null)
        {
          paramIPkgInfo1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo");
          AppMethodBeat.o(320837);
          throw paramIPkgInfo1;
        }
        bool = ((ModulePkgInfo)paramIPkgInfo1).isAssignable((ModulePkgInfo)paramIPkgInfo2);
      }
      else
      {
        bool = false;
      }
    }
    int i = paramIPkgInfo1.hashCode();
    int j = paramIPkgInfo2.hashCode();
    AppMethodBeat.o(320837);
    return i - j;
  }
  
  public static void a(final String paramString, final WxaAttributes.WxaVersionInfo paramWxaVersionInfo, int paramInt, final List<String> paramList, Map<String, ? extends WxaAttributes.WxaWidgetInfo> paramMap, QualitySession paramQualitySession, final b<? super List<? extends IPkgInfo>, ah> paramb, final b<? super WxaPkgLoadProgress, ah> paramb1, final m<? super Integer, ? super String, ah> paramm, boolean paramBoolean, aeo paramaeo, final a parama, Map<String, Integer> paramMap1)
  {
    AppMethodBeat.i(320826);
    s.u(paramString, "appId");
    s.u(paramWxaVersionInfo, "wxaVersionInfo");
    s.u(paramList, "requestedModuleNames");
    s.u(paramMap, "pickedModuleInfoList");
    s.u(paramQualitySession, "reportQualitySession");
    s.u(paramb, "onSuccess");
    s.u(paramb1, "onProgress");
    s.u(paramm, "onError");
    s.u(paramaeo, "cgiCommRequestSource");
    int j = paramWxaVersionInfo.appVersion;
    final BatchGetCodePkgExecutor.waitForPkgList.qualityReportListener.1 local1 = new BatchGetCodePkgExecutor.waitForPkgList.qualityReportListener.1(paramString, j, paramInt, paramQualitySession, f.hfK);
    local1.alive();
    final HashSet localHashSet = new HashSet();
    boolean bool = az.cAu();
    Iterator localIterator = paramList.iterator();
    int i;
    if (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      paramQualitySession = (WxaAttributes.WxaWidgetInfo)paramMap.get(localObject);
      if (paramQualitySession == null)
      {
        paramString = (Throwable)new IllegalStateException(("Invalid ModuleName(" + (String)localObject + ')').toString());
        AppMethodBeat.o(320826);
        throw paramString;
      }
      i = paramQualitySession.hDq;
      if (k.a.zn(paramInt))
      {
        paramList = new y.g.c(j, paramWxaVersionInfo.rcA);
        label228:
        paramList = new y.d(paramString, (String)localObject, i, paramInt, (y.g)paramList, paramBoolean);
        if ((k.a.zn(paramInt)) && (bool)) {
          n.cfm().d(paramList.cAe().toString(), paramInt, ((y.g.c)paramList.sZU).version, paramQualitySession.rcF, null);
        }
        localObject = ah.aiuX;
        localHashSet.add(paramList);
        paramQualitySession = paramQualitySession.rcG;
        paramList = paramQualitySession;
        if (paramQualitySession == null) {
          paramList = (List)ab.aivy;
        }
        paramQualitySession = paramList.iterator();
        label333:
        if (paramQualitySession.hasNext())
        {
          localObject = (WxaAttributes.WxaPluginCodeInfo)paramQualitySession.next();
          if (((WxaAttributes.WxaPluginCodeInfo)localObject).rci > 0L)
          {
            paramList = (CharSequence)((WxaAttributes.WxaPluginCodeInfo)localObject).qGf;
            if ((paramList != null) && (paramList.length() != 0)) {
              break label494;
            }
          }
        }
      }
      label494:
      for (i = 1;; i = 0)
      {
        if ((i == 0) && (0L == ((at)n.ag(at.class)).eN(((WxaAttributes.WxaPluginCodeInfo)localObject).provider, ((WxaAttributes.WxaPluginCodeInfo)localObject).qGf))) {
          ((at)n.ag(at.class)).j(((WxaAttributes.WxaPluginCodeInfo)localObject).provider, ((WxaAttributes.WxaPluginCodeInfo)localObject).qGf, ((WxaAttributes.WxaPluginCodeInfo)localObject).rci);
        }
        s.s(localObject, "plugin");
        if (paramMap1 != null) {
          break label500;
        }
        i = -1;
        localHashSet.add(o.a((WxaAttributes.WxaPluginCodeInfo)localObject, i));
        break label333;
        break;
        paramList = new y.g.c(0);
        break label228;
      }
      label500:
      paramList = ((WxaAttributes.WxaPluginCodeInfo)localObject).provider;
      s.s(paramList, "plugin.provider");
      paramList = paramMap1.get(paramList);
      if (paramList != null) {
        break label758;
      }
      paramList = Integer.valueOf(-1);
    }
    label758:
    for (;;)
    {
      paramList = (Integer)paramList;
      if (paramList == null)
      {
        i = -1;
        break;
      }
      i = paramList.intValue();
      break;
      if (localHashSet.size() <= 0)
      {
        paramString = (Throwable)new IllegalStateException("RequestPkgInfoList.size==0".toString());
        AppMethodBeat.o(320826);
        throw paramString;
      }
      paramString = new b(localHashSet.size(), paramaeo);
      paramWxaVersionInfo = new c(paramb1);
      paramList = new AtomicBoolean(false);
      paramMap = new ConcurrentSkipListSet(l..ExternalSyntheticLambda0.INSTANCE);
      paramQualitySession = localHashSet.iterator();
      while (paramQualitySession.hasNext())
      {
        paramb1 = (y.d)paramQualitySession.next();
        paramMap1 = y.sZF;
        s.s(paramb1, "request");
        y.b.a(paramb1, (b)new d(paramMap, paramb1, paramString, paramWxaVersionInfo, localHashSet, local1, paramb, parama), (m)new e(local1, paramb1, paramList, paramm, parama), (b)new f(paramWxaVersionInfo, paramb1), (z)paramString, paramaeo, (y.c)parama, 32);
      }
      AppMethodBeat.o(320826);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor$IReporter;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$IReporter;", "onAllPkgDownloaded", "", "onPkgDownloadError", "request", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
    extends y.c
  {
    public abstract void a(y.d paramd);
    
    public abstract void czU();
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor$InnerBatchGetDownloadCgiExecutor;", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor;", "maxPossibleRequestCount", "", "cgiCommRequestSource", "Lcom/tencent/mm/protocal/protobuf/CommRequestSource;", "(ILcom/tencent/mm/protocal/protobuf/CommRequestSource;)V", "requestMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;", "Lkotlin/Pair;", "Lkotlin/Function1;", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "", "Lkotlin/Function3;", "", "Lcom/tencent/mm/plugin/appbrand/launching/CgiCallbackPair;", "Lkotlin/collections/HashMap;", "scene", "decreasePossibleRequestCount", "fireAllRequestsIfNeed", "waitForDownloadUrl", "request", "onSuccess", "onError", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class b
    implements z
  {
    final HashMap<z.a, r<b<ciq[], ah>, q<Integer, Integer, String, ah>>> rRp;
    int sYK;
    private final aeo sYL;
    private int scene;
    
    public b(int paramInt, aeo paramaeo)
    {
      AppMethodBeat.i(321124);
      this.sYK = paramInt;
      this.sYL = paramaeo;
      this.rRp = new HashMap();
      AppMethodBeat.o(321124);
    }
    
    public final void a(z.a parama, b<? super ciq[], ah> paramb, q<? super Integer, ? super Integer, ? super String, ah> paramq, int paramInt, aeo paramaeo)
    {
      AppMethodBeat.i(321132);
      s.u(parama, "request");
      s.u(paramb, "onSuccess");
      s.u(paramq, "onError");
      s.u(paramaeo, "cgiCommRequestSource");
      this.scene = paramInt;
      ((Map)this.rRp).put(parama, new r(paramb, paramq));
      czV();
      AppMethodBeat.o(321132);
    }
    
    public final void czV()
    {
      AppMethodBeat.i(180482);
      if (this.sYK != this.rRp.size())
      {
        AppMethodBeat.o(180482);
        return;
      }
      if (this.rRp.size() <= 0)
      {
        AppMethodBeat.o(180482);
        return;
      }
      w.sZB.a((List)new LinkedList((Collection)this.rRp.keySet()), (b)new a(this), (q)new l.b.b(this), this.scene, this.sYL);
      AppMethodBeat.o(180482);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "batchResp", "Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements b<kz, ah>
    {
      a(l.b paramb)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor$InnerBatchProgressEmitter;", "", "onProgress", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "", "(Lkotlin/jvm/functions/Function1;)V", "progressMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "Lkotlin/collections/HashMap;", "request", "progress", "onReady", "filePath", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class c
  {
    private final b<WxaPkgLoadProgress, ah> sYN;
    private final HashMap<y.d, WxaPkgLoadProgress> sYO;
    
    public c(b<? super WxaPkgLoadProgress, ah> paramb)
    {
      AppMethodBeat.i(180486);
      this.sYN = paramb;
      this.sYO = new HashMap();
      AppMethodBeat.o(180486);
    }
    
    public final void a(y.d paramd, WxaPkgLoadProgress paramWxaPkgLoadProgress)
    {
      AppMethodBeat.i(180484);
      s.u(paramd, "request");
      s.u(paramWxaPkgLoadProgress, "progress");
      synchronized (this.sYO)
      {
        ((Map)this.sYO).put(paramd, paramWxaPkgLoadProgress);
        paramd = (c)this;
        long l2 = 0L;
        long l1 = 0L;
        paramd = paramd.sYO.values();
        s.s(paramd, "progressMap.values");
        paramd = ((Iterable)paramd).iterator();
        while (paramd.hasNext())
        {
          paramWxaPkgLoadProgress = (WxaPkgLoadProgress)paramd.next();
          if (paramWxaPkgLoadProgress == null) {
            break label196;
          }
          l2 += Math.max(paramWxaPkgLoadProgress.qHf, 0L);
          l1 += Math.max(paramWxaPkgLoadProgress.qHg, 0L);
        }
        if (l1 <= 0L) {}
        float f;
        for (int i = 0;; i = a.eH(f * 100.0F))
        {
          paramd = new WxaPkgLoadProgress(i, l2, l1);
          if (paramd != null) {
            this.sYN.invoke(paramd);
          }
          AppMethodBeat.o(180484);
          return;
          f = (float)l2 / (float)l1;
        }
        label196:
        paramd = null;
      }
    }
    
    public final void a(y.d paramd, String paramString)
    {
      AppMethodBeat.i(180485);
      s.u(paramd, "request");
      s.u(paramString, "filePath");
      if (this.sYO.size() > 0)
      {
        long l = com.tencent.mm.vfs.y.bEl(paramString);
        a(paramd, new WxaPkgLoadProgress(100, l, l));
      }
      AppMethodBeat.o(180485);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "response", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements b<y.e, ah>
  {
    d(ConcurrentSkipListSet<IPkgInfo> paramConcurrentSkipListSet, y.d paramd, l.b paramb, l.c paramc, HashSet<y.d> paramHashSet, BatchGetCodePkgExecutor.waitForPkgList.qualityReportListener.1 param1, b<? super List<? extends IPkgInfo>, ah> paramb1, l.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "err", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$ERROR;", "errMsg", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements m<y.a, String, ah>
  {
    e(BatchGetCodePkgExecutor.waitForPkgList.qualityReportListener.1 param1, y.d paramd, AtomicBoolean paramAtomicBoolean, m<? super Integer, ? super String, ah> paramm, l.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "progress", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements b<WxaPkgLoadProgress, ah>
  {
    f(l.c paramc, y.d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.l
 * JD-Core Version:    0.7.0.1
 */