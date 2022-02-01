package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.extension.reddot.i.b;
import com.tencent.mm.plugin.finder.preload.tabPreload.g.e;
import com.tencent.mm.plugin.finder.preload.tabPreload.g.g;
import com.tencent.mm.plugin.finder.report.o;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.storage.k.a;
import com.tencent.mm.plugin.finder.viewmodel.component.ab;
import com.tencent.mm.plugin.finder.viewmodel.component.aw.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.azc;
import com.tencent.mm.protocal.protobuf.azd;
import com.tencent.mm.protocal.protobuf.bft;
import com.tencent.mm.protocal.protobuf.bfu;
import com.tencent.mm.protocal.protobuf.btc;
import com.tencent.mm.protocal.protobuf.btx;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bwd;
import com.tencent.mm.protocal.protobuf.bwh;
import com.tencent.mm.protocal.protobuf.bwi;
import com.tencent.mm.protocal.protobuf.bwl;
import com.tencent.mm.protocal.protobuf.dvl;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ah;
import kotlin.g.b.ah.a;
import kotlin.g.b.u;
import kotlin.r;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream;", "Lcom/tencent/mm/plugin/datapreloader/IDataFuture;", "", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "tabType", "", "pullType", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "unreadList", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "isPreload", "", "isForPush", "isAuto", "enterSourceType", "(IILcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Ljava/util/List;ZZZI)V", "TAG", "callback", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$Callback;", "config", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$IConfig;", "errorCallback", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$IError;", "interceptors", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/OrderInterceptor;", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "isCancel", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isShowPreloadView", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "request", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamRequestEx;", "getRequest", "()Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamRequestEx;", "streamCgi", "com/tencent/mm/plugin/finder/cgi/CgiFinderStream$streamCgi$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$streamCgi$1;", "getTabType", "()I", "addInterceptor", "interceptor", "order", "buildBaseRequest", "", "Lcom/tencent/mm/protocal/protobuf/FinderStreamRequest;", "buildMachineTabRequest", "buildPartialExposeRequest", "buildRedDotRequest", "buildResponse", "Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;", "buildStatsRequest", "buildUnreadRequest", "cancelTask", "createFinderStreamResponseEx", "it", "getKey", "hitPreloadCache", "value", "mergeResp", "streamResponse", "historyResponse", "Lcom/tencent/mm/protocal/protobuf/FinderGetHistoryResponse;", "onCgiBack", "errType", "errCode", "errMsg", "resp", "removeInterceptor", "requestData", "run", "runTask", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setCallback", "setConfig", "setLifeCycleKeeper", "keeper", "showErrorToast", "tip", "Callback", "FinderStreamHistoryCgi", "FinderStreamRequestEx", "FinderStreamResponseEx", "IConfig", "IError", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aq
  implements com.tencent.mm.plugin.datapreloader.b<String, d>
{
  final boolean AAb;
  final boolean AAc;
  final int AAd;
  private a AAe;
  aq.e AAf;
  f AAg;
  com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> AAh;
  private final ConcurrentLinkedQueue<com.tencent.mm.plugin.finder.cgi.interceptor.h<com.tencent.mm.plugin.finder.cgi.interceptor.g>> AAi;
  final boolean AAj;
  final c AAk;
  private final m AAl;
  final bui Auc;
  private final List<FinderObject> Ayr;
  public final String TAG;
  public final int hJx;
  final com.tencent.mm.bx.b lastBuffer;
  public final AtomicBoolean otq;
  public final int pullType;
  final boolean rsE;
  
  public aq(int paramInt1, int paramInt2, com.tencent.mm.bx.b paramb, bui parambui, List<? extends FinderObject> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt3)
  {
    AppMethodBeat.i(336247);
    this.hJx = paramInt1;
    this.pullType = paramInt2;
    this.lastBuffer = paramb;
    this.Auc = parambui;
    this.Ayr = paramList;
    this.rsE = paramBoolean1;
    this.AAb = paramBoolean2;
    this.AAc = paramBoolean3;
    this.AAd = paramInt3;
    this.AAh = new com.tencent.mm.vending.e.c();
    this.AAi = new ConcurrentLinkedQueue();
    paramb = com.tencent.mm.plugin.finder.storage.d.FAy;
    this.AAj = ((Boolean)com.tencent.mm.plugin.finder.storage.d.eSb().bmg()).booleanValue();
    this.otq = new AtomicBoolean(false);
    com.tencent.mm.plugin.finder.report.s.a(com.tencent.mm.plugin.finder.report.s.Fqv, this.hJx, this.pullType, this.Auc);
    this.TAG = ("Finder.FinderStream#" + this.hJx + '#' + this.pullType + '#' + this.rsE + '@' + hashCode());
    this.AAk = new c();
    this.AAl = new m(this, this.Auc);
    AppMethodBeat.o(336247);
  }
  
  private final void a(int paramInt1, int paramInt2, String paramString, d paramd)
  {
    AppMethodBeat.i(336273);
    Log.i(this.TAG, "onCgiBack tabType=" + this.hJx + " pullType:" + this.pullType);
    Object localObject2 = this.AAf;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("config");
      localObject1 = null;
    }
    ((aq.e)localObject1).dVo();
    localObject1 = com.tencent.mm.plugin.finder.preload.a.EUs;
    localObject1 = paramd.preloadInfo;
    localObject2 = paramd.object;
    kotlin.g.b.s.s(localObject2, "resp.`object`");
    com.tencent.mm.plugin.finder.preload.a.a((btc)localObject1, (List)localObject2, 3901);
    localObject1 = (aq)this;
    Object localObject3 = (Iterable)kotlin.a.p.a((Iterable)((aq)localObject1).AAi, (Comparator)new h());
    localObject2 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((Collection)localObject2).add((com.tencent.mm.plugin.finder.cgi.interceptor.g)((com.tencent.mm.plugin.finder.cgi.interceptor.h)((Iterator)localObject3).next()).AFd);
    }
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (com.tencent.mm.plugin.finder.cgi.interceptor.g)((Iterator)localObject2).next();
      if (((com.tencent.mm.plugin.finder.cgi.interceptor.g)localObject3).a(paramd, ((aq)localObject1).hJx)) {
        Log.w(((aq)localObject1).TAG, kotlin.g.b.s.X("[onCgiBack] Interceptor is interrupted by ", localObject3));
      }
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      localObject1 = com.tencent.mm.plugin.finder.report.s.Fqv;
      com.tencent.mm.plugin.finder.report.s.d(this.hJx, this.Auc);
    }
    paramd.errType = paramInt1;
    paramd.errCode = paramInt2;
    paramd.errMsg = paramString;
    localObject1 = this.AAf;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("config");
      localObject1 = null;
    }
    while (!((aq.e)localObject1).a((esc)paramd))
    {
      localObject2 = this.AAe;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("callback");
        localObject1 = null;
      }
      localObject3 = (Iterable)kotlin.a.p.a((Iterable)this.AAi, (Comparator)new g());
      localObject2 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      for (;;)
      {
        if (((Iterator)localObject3).hasNext())
        {
          ((Collection)localObject2).add((com.tencent.mm.plugin.finder.cgi.interceptor.g)((com.tencent.mm.plugin.finder.cgi.interceptor.h)((Iterator)localObject3).next()).AFd);
          continue;
          break;
        }
      }
      ((a)localObject1).a(paramInt1, paramInt2, paramString, paramd, kotlin.a.p.p((Iterable)localObject2));
      AppMethodBeat.o(336273);
      return;
    }
    if ((this.pullType == 0) || (this.pullType == 1) || (this.pullType == 4))
    {
      paramString = k.aeZF;
      localObject1 = ((com.tencent.mm.plugin.finder.preload.tabPreload.c)k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.preload.tabPreload.c.class)).Rn(this.hJx);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label682;
      }
      if (!(paramd instanceof bwi)) {
        break label677;
      }
      paramString = (bwi)paramd;
      if (paramString != null)
      {
        paramString = a(paramString);
        if (localObject1 != null)
        {
          paramd = g.g.EWG;
          paramInt1 = this.pullType;
          localObject2 = new g.e();
          ((g.e)localObject2).EWw = paramString.dVm().EWw;
          ((g.e)localObject2).pullType = paramString.dVm().pullType;
          localObject3 = ah.aiuX;
          ((com.tencent.mm.plugin.finder.preload.tabPreload.g)localObject1).a(paramString, paramd, paramInt1, (g.e)localObject2);
        }
      }
    }
    for (;;)
    {
      paramString = this.AAg;
      if (paramString != null) {
        paramString.dVp();
      }
      AppMethodBeat.o(336273);
      return;
      label677:
      paramString = null;
      break;
      label682:
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.finder.preload.tabPreload.g)localObject1).a(false, g.g.EWG);
      }
    }
  }
  
  private final void dVj()
  {
    AppMethodBeat.i(336279);
    aq.e locale2 = this.AAf;
    aq.e locale1 = locale2;
    if (locale2 == null)
    {
      kotlin.g.b.s.bIx("config");
      locale1 = null;
    }
    locale1.b(this.AAk);
    com.tencent.mm.plugin.finder.report.s.a(com.tencent.mm.plugin.finder.report.s.Fqv, this.hJx);
    o.FpJ.a(this.hJx, true, this.AAc, 1);
    this.AAl.bFJ();
    AppMethodBeat.o(336279);
  }
  
  public final Object Z(kotlin.d.d<? super d> paramd)
  {
    AppMethodBeat.i(336345);
    kotlin.d.h localh = new kotlin.d.h(kotlin.d.a.b.au(paramd));
    final kotlin.d.d locald = (kotlin.d.d)localh;
    Object localObject = this.AAe;
    if (localObject == null)
    {
      kotlin.g.b.s.bIx("callback");
      localObject = null;
    }
    for (;;)
    {
      final ah.a locala = new ah.a();
      this.AAg = ((f)new j(locala, this, locald));
      this.AAe = ((a)new k((a)localObject, locala, locald));
      run();
      localObject = localh.kli();
      if (localObject == kotlin.d.a.a.aiwj) {
        kotlin.g.b.s.u(paramd, "frame");
      }
      AppMethodBeat.o(336345);
      return localObject;
    }
  }
  
  final d a(bwi parambwi)
  {
    AppMethodBeat.i(336390);
    d locald = new d();
    locald.a(this.AAk);
    locald.aafb = parambwi.aafb;
    locald.aafa = parambwi.aafa;
    locald.object.addAll((Collection)parambwi.object);
    locald.liveObjects.addAll((Collection)parambwi.liveObjects);
    locald.Bez = parambwi.Bez;
    locald.aafc = parambwi.aafc;
    locald.aafd = parambwi.aafd;
    locald.preloadInfo = parambwi.preloadInfo;
    locald.aafg = parambwi.aafg;
    locald.aafe = parambwi.aafe;
    locald.aafi = parambwi.aafi;
    locald.aaff = parambwi.aaff;
    locald.aafh = parambwi.aafh;
    locald.lastBuffer = parambwi.lastBuffer;
    locald.AAs = parambwi.object.size();
    locald.aafj = parambwi.aafj;
    locald.ACr = parambwi.ACr;
    locald.aafk = parambwi.aafk;
    locald.aafm = parambwi.aafm;
    locald.BeF = parambwi.BeF;
    AppMethodBeat.o(336390);
    return locald;
  }
  
  public final aq a(a parama)
  {
    AppMethodBeat.i(336358);
    kotlin.g.b.s.u(parama, "callback");
    this.AAe = parama;
    AppMethodBeat.o(336358);
    return this;
  }
  
  public final aq a(aq.e parame)
  {
    AppMethodBeat.i(336352);
    kotlin.g.b.s.u(parame, "config");
    this.AAf = parame;
    AppMethodBeat.o(336352);
    return this;
  }
  
  public final aq a(com.tencent.mm.plugin.finder.cgi.interceptor.g paramg, int paramInt)
  {
    AppMethodBeat.i(336338);
    kotlin.g.b.s.u(paramg, "interceptor");
    this.AAi.add(new com.tencent.mm.plugin.finder.cgi.interceptor.h(paramg, paramInt));
    AppMethodBeat.o(336338);
    return this;
  }
  
  public final aq a(com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> paramc)
  {
    AppMethodBeat.i(336366);
    kotlin.g.b.s.u(paramc, "keeper");
    this.AAh = paramc;
    AppMethodBeat.o(336366);
    return this;
  }
  
  public final void run()
  {
    Object localObject2 = null;
    d locald = null;
    AppMethodBeat.i(336377);
    Log.i(this.TAG, "run: tabType = " + this.hJx + ", pullType = " + this.pullType);
    com.tencent.mm.plugin.finder.report.s.a(com.tencent.mm.plugin.finder.report.s.Fqv, this.hJx, true, null, 12);
    c localc = this.AAk;
    aq.e locale = this.AAf;
    Object localObject1 = locale;
    if (locale == null)
    {
      kotlin.g.b.s.bIx("config");
      localObject1 = null;
    }
    localc.AAq = ((aq.e)localObject1).dVn();
    if (this.AAk.AAq)
    {
      localObject1 = com.tencent.mm.plugin.finder.report.s.Fqv;
      com.tencent.mm.plugin.finder.report.s.aL(this.hJx, true);
      new b(null, this.lastBuffer).bFJ().a((com.tencent.mm.vending.e.b)this.AAh);
      AppMethodBeat.o(336377);
      return;
    }
    localObject1 = k.aeZF;
    localObject1 = ((com.tencent.mm.plugin.finder.preload.tabPreload.c)k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.preload.tabPreload.c.class)).Rn(this.hJx);
    int i;
    boolean bool;
    if ((this.pullType != 1) && (this.pullType != 0))
    {
      i = 1;
      if ((!this.rsE) && (i == 0)) {
        break label329;
      }
      if (i != 0)
      {
        if (localObject1 != null) {
          break label317;
        }
        bool = false;
        label226:
        if (bool)
        {
          localObject1 = com.tencent.mm.plugin.finder.preload.tabPreload.b.EVP;
          com.tencent.mm.plugin.finder.preload.tabPreload.b.c(0, 3, 2, false, 115);
        }
      }
      localObject1 = this.AAf;
      if (localObject1 != null) {
        break label326;
      }
      kotlin.g.b.s.bIx("config");
      localObject1 = locald;
    }
    label317:
    label326:
    for (;;)
    {
      ((aq.e)localObject1).b(this.AAk);
      com.tencent.mm.plugin.finder.report.s.a(com.tencent.mm.plugin.finder.report.s.Fqv, this.hJx);
      o.FpJ.a(this.hJx, true, this.AAc, 1);
      this.AAl.bFJ();
      AppMethodBeat.o(336377);
      return;
      i = 0;
      break;
      bool = ((com.tencent.mm.plugin.finder.preload.tabPreload.g)localObject1).ta(true);
      break label226;
    }
    label329:
    if ((this.AAd != 1) || (this.hJx != 4))
    {
      if (localObject1 == null) {
        localObject1 = localObject2;
      }
      while (localObject1 == null)
      {
        ((aq)this).dVj();
        AppMethodBeat.o(336377);
        return;
        locald = ((com.tencent.mm.plugin.finder.preload.tabPreload.g)localObject1).Rs(this.pullType);
        localObject1 = localObject2;
        if (locald != null)
        {
          localObject1 = com.tencent.mm.plugin.finder.preload.f.EUC;
          if (com.tencent.mm.plugin.finder.preload.f.eHI()) {
            com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new i(this));
          }
          Log.i(this.TAG, "[run] use preload cache. tabType=" + this.hJx + " pullType=" + this.pullType);
          localObject1 = com.tencent.mm.plugin.finder.report.s.Fqv;
          com.tencent.mm.plugin.finder.report.s.Su(this.hJx);
          a(0, 0, null, locald);
          localObject1 = ah.aiuX;
        }
      }
      AppMethodBeat.o(336377);
      return;
    }
    dVj();
    AppMethodBeat.o(336377);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$Callback;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "interceptors", "", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, aq.d paramd, List<? extends com.tencent.mm.plugin.finder.cgi.interceptor.g> paramList);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamHistoryCgi;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetHistoryResponse;", "streamResp", "Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream;Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;Lcom/tencent/mm/protobuf/ByteString;)V", "resultExt", "Lorg/json/JSONObject;", "getResultExt", "()Lorg/json/JSONObject;", "actionExt", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "isFetchFeedCgi", "", "onCgiEnd", "", "errType", "", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends com.tencent.mm.plugin.findersdk.b.c<azd>
  {
    private bwi AAm;
    private final JSONObject AAn;
    
    public b(com.tencent.mm.bx.b paramb)
    {
      AppMethodBeat.i(336701);
      this.AAm = paramb;
      this.AAn = new JSONObject();
      paramb = new c.a();
      azc localazc = new azc();
      aq.this.AAk.AAp = localazc;
      localazc.YIZ = z.bAW();
      localazc.hJx = aq.this.hJx;
      Object localObject;
      localazc.ZEQ = localObject;
      String str = aq.this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("[request#historyCgi] isPreload=").append(aq.this.rsE).append(" tabType=").append(aq.this.hJx).append(" pullType=").append(aq.this.pullType).append(" lastBuffer=");
      if (localObject == null) {}
      for (this$1 = "null";; this$1 = MD5Util.getMD5String(localObject.Op))
      {
        Log.i(str, aq.this);
        this$1 = bi.ABn;
        localazc.CJv = bi.a(this.Auc);
        paramb.otE = ((com.tencent.mm.bx.a)localazc);
        this$1 = new azd();
        aq.this.setBaseResponse(new kd());
        aq.this.getBaseResponse().akjO = new etl();
        paramb.otF = ((com.tencent.mm.bx.a)aq.this);
        paramb.uri = "/cgi-bin/micromsg-bin/findergethistory";
        paramb.funcId = 3814;
        c(paramb.bEF());
        AppMethodBeat.o(336701);
        return;
      }
    }
    
    public final boolean dVg()
    {
      return true;
    }
    
    public final com.tencent.mm.plugin.findersdk.b.a.b dVi()
    {
      return com.tencent.mm.plugin.findersdk.b.a.b.Hde;
    }
    
    public final JSONObject dVk()
    {
      AppMethodBeat.i(336706);
      JSONObject localJSONObject = new JSONObject();
      aq localaq = aq.this;
      localJSONObject.put("tabType", localaq.hJx);
      localJSONObject.put("pullType", localaq.pullType);
      AppMethodBeat.o(336706);
      return localJSONObject;
    }
    
    public final JSONObject dVl()
    {
      return this.AAn;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamRequestEx;", "Lcom/tencent/mm/protocal/protobuf/FinderStreamRequest;", "()V", "historyRequest", "Lcom/tencent/mm/protocal/protobuf/FinderGetHistoryRequest;", "getHistoryRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderGetHistoryRequest;", "setHistoryRequest", "(Lcom/tencent/mm/protocal/protobuf/FinderGetHistoryRequest;)V", "isBeginHistory", "", "()Z", "setBeginHistory", "(Z)V", "tapTipsId", "", "getTapTipsId", "()Ljava/lang/String;", "setTapTipsId", "(Ljava/lang/String;)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends bwh
  {
    azc AAp;
    boolean AAq;
    public String AAr = "";
    
    public final void avc(String paramString)
    {
      AppMethodBeat.i(336681);
      kotlin.g.b.s.u(paramString, "<set-?>");
      this.AAr = paramString;
      AppMethodBeat.o(336681);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;", "()V", "afterFeedIdHistory", "", "getAfterFeedIdHistory", "()J", "setAfterFeedIdHistory", "(J)V", "continueFlag", "", "getContinueFlag", "()I", "setContinueFlag", "(I)V", "errCode", "getErrCode", "setErrCode", "errMsg", "", "getErrMsg", "()Ljava/lang/String;", "setErrMsg", "(Ljava/lang/String;)V", "errType", "getErrType", "setErrType", "historySize", "getHistorySize", "setHistorySize", "isCgiConsume", "", "()Z", "setCgiConsume", "(Z)V", "isFetchHistory", "setFetchHistory", "requestEx", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamRequestEx;", "getRequestEx", "()Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamRequestEx;", "setRequestEx", "(Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamRequestEx;)V", "streamSize", "getStreamSize", "setStreamSize", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends bwi
  {
    public int AAs;
    public long AAt = -1L;
    public boolean AAu;
    public aq.c AAv;
    public int continueFlag = 1;
    int errCode;
    String errMsg;
    int errType;
    public int qpb = -1;
    
    public final void a(aq.c paramc)
    {
      AppMethodBeat.i(336686);
      kotlin.g.b.s.u(paramc, "<set-?>");
      this.AAv = paramc;
      AppMethodBeat.o(336686);
    }
    
    public final aq.c dVm()
    {
      AppMethodBeat.i(336680);
      aq.c localc = this.AAv;
      if (localc != null)
      {
        AppMethodBeat.o(336680);
        return localc;
      }
      kotlin.g.b.s.bIx("requestEx");
      AppMethodBeat.o(336680);
      return null;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$IError;", "", "onConcurrentError", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface f
  {
    public abstract void dVp();
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k=3, mv={1, 5, 1})
  public static final class g<T>
    implements Comparator
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(336645);
      int i = kotlin.b.a.b((Comparable)Integer.valueOf(((com.tencent.mm.plugin.finder.cgi.interceptor.h)paramT1).order), (Comparable)Integer.valueOf(((com.tencent.mm.plugin.finder.cgi.interceptor.h)paramT2).order));
      AppMethodBeat.o(336645);
      return i;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k=3, mv={1, 5, 1})
  public static final class h<T>
    implements Comparator
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(336655);
      int i = kotlin.b.a.b((Comparable)Integer.valueOf(((com.tencent.mm.plugin.finder.cgi.interceptor.h)paramT1).order), (Comparable)Integer.valueOf(((com.tencent.mm.plugin.finder.cgi.interceptor.h)paramT2).order));
      AppMethodBeat.o(336655);
      return i;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<ah>
  {
    i(aq paramaq)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/cgi/CgiFinderStream$runTask$2$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$IError;", "onConcurrentError", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class j
    implements aq.f
  {
    j(ah.a parama, aq paramaq, kotlin.d.d<? super aq.d> paramd) {}
    
    public final void dVp()
    {
      AppMethodBeat.i(336628);
      if (this.AAw.aiwY)
      {
        AppMethodBeat.o(336628);
        return;
      }
      Log.w(jdField_this.TAG, "runTask: onConcurrentError tabType = " + jdField_this.hJx + ", pullType = " + jdField_this.pullType);
      kotlin.d.d locald = locald;
      aq.d locald1 = new aq.d();
      locald1.errCode = 3;
      Result.Companion localCompanion = Result.Companion;
      locald.resumeWith(Result.constructor-impl(locald1));
      this.AAw.aiwY = true;
      AppMethodBeat.o(336628);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/cgi/CgiFinderStream$runTask$2$2", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$Callback;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "interceptors", "", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class k
    implements aq.a
  {
    k(aq.a parama, ah.a parama1, kotlin.d.d<? super aq.d> paramd) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, aq.d paramd, List<? extends com.tencent.mm.plugin.finder.cgi.interceptor.g> paramList)
    {
      AppMethodBeat.i(336622);
      kotlin.g.b.s.u(paramd, "resp");
      kotlin.g.b.s.u(paramList, "interceptors");
      this.AAx.a(paramInt1, paramInt2, paramString, paramd, paramList);
      if (!locala.aiwY)
      {
        paramString = locald;
        paramList = Result.Companion;
        paramString.resumeWith(Result.constructor-impl(paramd));
      }
      locala.aiwY = true;
      AppMethodBeat.o(336622);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements kotlin.g.a.a<ah>
  {
    l(String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/cgi/CgiFinderStream$streamCgi$1", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;", "resultExt", "Lorg/json/JSONObject;", "getResultExt", "()Lorg/json/JSONObject;", "actionExt", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "isFetchFeedCgi", "", "onCgiEnd", "", "errType", "", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class m
    extends com.tencent.mm.plugin.findersdk.b.c<bwi>
  {
    private final JSONObject AAn;
    
    m(aq paramaq, bui parambui)
    {
      super();
      AppMethodBeat.i(336636);
      this.AAn = new JSONObject();
      parambui = this.AAo;
      paramaq = (bwh)this.AAo.AAk;
      Object localObject1 = bi.ABn;
      paramaq.CJv = bi.a(parambui.Auc);
      paramaq.lastBuffer = parambui.lastBuffer;
      paramaq.pullType = parambui.pullType;
      paramaq.hJx = parambui.hJx;
      parambui = k.aeZF;
      parambui = ((com.tencent.mm.plugin.finder.viewmodel.b)k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.b.class)).dUh();
      paramaq.longitude = ((Number)parambui.bsC).floatValue();
      paramaq.latitude = ((Number)parambui.bsD).floatValue();
      paramaq.aaeM = 1;
      paramaq = this.AAo;
      parambui = (bwh)this.AAo.AAk;
      long l;
      boolean bool1;
      if (((paramaq.pullType == 1) || (paramaq.pullType == 0)) && ((paramaq.hJx == 1) || (paramaq.hJx == 3) || (paramaq.hJx == 4)))
      {
        localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aw.GUC;
        l = aw.a.Vt(paramaq.hJx);
        localObject1 = e.FMN;
        bool1 = e.a.au(paramaq.hJx, l);
        if (!bool1) {
          parambui.aaeO = l;
        }
        Log.i(paramaq.TAG, "[request] tabType=" + paramaq.hJx + " isHistoryFeed=" + bool1 + " partialExposedObjectId=" + parambui.aaeO);
      }
      Object localObject2 = this.AAo;
      parambui = this.AAo.AAk;
      paramaq = ((aq)localObject2).Auc;
      int i;
      label352:
      Object localObject3;
      Object localObject4;
      if ((paramaq != null) && (paramaq.AJo == 15))
      {
        i = 1;
        if (i == 0) {
          break label911;
        }
        Log.i(((aq)localObject2).TAG, "buildRedDotRequest return for commentScene:" + ((aq)localObject2).Auc + ".commentScene");
        aq.a(this.AAo, (bwh)this.AAo.AAk);
        aq.b(this.AAo, (bwh)this.AAo.AAk);
        parambui = this.AAo;
        paramaq = (bwh)this.AAo.AAk;
        if (parambui.hJx == 4)
        {
          localObject1 = parambui.TAG;
          localObject2 = new StringBuilder("buildMachineTabRequest, ");
          localObject3 = ab.GQn;
          Log.i((String)localObject1, ab.fnL() + ", " + parambui.hJx);
          parambui = ab.GQn;
          parambui = ab.fnL();
          if (parambui != null)
          {
            localObject1 = paramaq.aaeV;
            localObject2 = new bwl();
            localObject3 = ((bwl)localObject2).ZIQ;
            localObject4 = new dvl();
            paramaq = parambui.aaef;
            if (paramaq != null) {
              break label1665;
            }
            l = 0L;
            label515:
            ((dvl)localObject4).object_id = l;
            paramaq = parambui.aaef;
            if (paramaq != null) {
              break label1674;
            }
            paramaq = null;
            label533:
            ((dvl)localObject4).object_nonce_id = paramaq;
            paramaq = ah.aiuX;
            ((LinkedList)localObject3).add(localObject4);
            ((bwl)localObject2).JaK = parambui.aaeg;
            ((bwl)localObject2).ZFJ = parambui.jump_type;
            paramaq = ah.aiuX;
            ((LinkedList)localObject1).add(localObject2);
          }
        }
        paramaq = ab.GQn;
        ab.fnM();
        paramaq = this.AAo.AAk;
        parambui = com.tencent.mm.plugin.finder.utils.aw.Gjk;
        paramaq.ZKH = com.tencent.mm.plugin.finder.utils.aw.fgv();
        paramaq = new c.a();
        paramaq.otE = ((com.tencent.mm.bx.a)this.AAo.AAk);
        parambui = new bwi();
        parambui.setBaseResponse(new kd());
        parambui.getBaseResponse().akjO = new etl();
        paramaq.otF = ((com.tencent.mm.bx.a)parambui);
        if (this.AAo.AAb) {
          break label1682;
        }
        paramaq.uri = "/cgi-bin/micromsg-bin/finderstream";
        paramaq.funcId = 3901;
        label695:
        parambui = paramaq.bEF();
        if (this.AAo.AAb) {
          parambui.setIsUserCmd(true);
        }
        localObject1 = this.AAo.TAG;
        localObject2 = new StringBuilder("[CgiFetchFinderTimeline#init] tabType=").append(this.AAo.hJx).append(" pullType=").append(this.AAo.pullType).append(" lastBuffer=");
        paramaq = this.AAo.AAk.lastBuffer;
        if (paramaq != null) {
          break label1699;
        }
        paramaq = null;
        label785:
        localObject2 = ((StringBuilder)localObject2).append(paramaq).append(", ");
        if (this.AAo.AAk.lastBuffer != null) {
          break label1711;
        }
        paramaq = "null";
        localObject2 = ((StringBuilder)localObject2).append(paramaq).append(" longitude=").append(this.AAo.AAk.longitude).append(" latitude=").append(this.AAo.AAk.latitude).append(",speed=");
        paramaq = this.AAo.AAk;
        if (paramaq != null) {
          break label1744;
        }
        paramaq = null;
      }
      for (;;)
      {
        Log.i((String)localObject1, paramaq);
        c(parambui);
        AppMethodBeat.o(336636);
        return;
        i = 0;
        break;
        label911:
        if (((((aq)localObject2).AAd == 1) && (((aq)localObject2).hJx == 4)) || ((((aq)localObject2).pullType != 1) && (((aq)localObject2).pullType != 0) && (((aq)localObject2).pullType != 5) && (((aq)localObject2).pullType != 7) && (((aq)localObject2).pullType != 8) && (((aq)localObject2).pullType != 6) && (((aq)localObject2).pullType != 17) && (((aq)localObject2).pullType != 9))) {
          break label352;
        }
        localObject3 = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager();
        localObject4 = i.Nu(((aq)localObject2).hJx);
        localObject1 = ((i)localObject3).avs((String)localObject4);
        label1045:
        label1141:
        label1146:
        boolean bool2;
        if (localObject1 != null)
        {
          bool1 = true;
          if ((localObject1 == null) || ((((btx)localObject1).object_id == 0L) && (((btx)localObject1).tabTipsByPassInfo == null))) {
            break label1371;
          }
          parambui.EWw = ((btx)localObject1).object_id;
          parambui.aaeN = ((btx)localObject1).object_nonce_id;
          parambui.aaeR = ((btx)localObject1).username;
          parambui.tabTipsByPassInfo = ((btx)localObject1).tabTipsByPassInfo;
          parambui.ZNx = "FinderEntrance";
          kotlin.g.b.s.u(localObject4, "path");
          paramaq = (i.b)((i)localObject3).AQM.get(localObject4);
          if (paramaq != null) {
            break label1363;
          }
          paramaq = "";
          parambui.avc(paramaq);
          paramaq = parambui.CJv;
          if (paramaq != null) {
            break label1639;
          }
          i = 0;
          label1157:
          paramaq = k.a.FKj;
          if ((i & k.a.eZe()) == 0) {
            break label1647;
          }
          bool2 = true;
          label1172:
          paramaq = ((aq)localObject2).TAG;
          localObject2 = new StringBuilder("[buildRedDotRequest] tabType=").append(((aq)localObject2).hJx).append(" machineShowSquareFlag=").append(bool2).append(" entranceCtrlTypeWhenEnter=").append(((i)localObject3).AQH).append(" isEnterRequest=").append(bool1).append(" tab_tips_path=").append(parambui.ZNx).append(" pullType=").append(((aq)localObject2).pullType).append(" tabTipsUsername=").append(parambui.aaeR).append(" tabTipsByPassInfo=");
          if (parambui.tabTipsByPassInfo == null) {
            break label1653;
          }
          bool1 = true;
          label1290:
          parambui = ((StringBuilder)localObject2).append(bool1).append(" objectId=").append(com.tencent.mm.ae.d.hF(parambui.EWw)).append(" request=").append(parambui.hashCode()).append(", isEnterTapTip = ");
          if (localObject1 == null) {
            break label1659;
          }
        }
        label1363:
        label1371:
        label1388:
        label1647:
        label1653:
        label1659:
        for (bool1 = true;; bool1 = false)
        {
          Log.i(paramaq, bool1);
          break;
          bool1 = false;
          break label1045;
          paramaq = paramaq.AQQ;
          break label1141;
          Object localObject5 = ((i)localObject3).Su("FinderEntrance");
          if (localObject5 == null)
          {
            paramaq = null;
            if (paramaq != null) {
              break label1581;
            }
            paramaq = ((i)localObject3).Su((String)localObject4);
            if (paramaq == null) {
              break label1146;
            }
            localObject5 = paramaq.ASz;
            parambui.EWw = ((btx)localObject5).object_id;
            parambui.aaeN = ((btx)localObject5).object_nonce_id;
            parambui.aaeR = ((btx)localObject5).username;
            parambui.tabTipsByPassInfo = ((btx)localObject5).tabTipsByPassInfo;
            parambui.ZNx = ((String)localObject4);
            paramaq = paramaq.field_tipsId;
            kotlin.g.b.s.s(paramaq, "it.field_tipsId");
            parambui.avc(paramaq);
            break label1146;
          }
          paramaq = ((com.tencent.mm.plugin.finder.extension.reddot.p)localObject5).ASz;
          if (paramaq.object_id != 0L)
          {
            i = 1;
            if (i == 0) {
              break label1588;
            }
            if (paramaq != null) {
              break label1593;
            }
          }
          for (paramaq = null;; paramaq = ah.aiuX)
          {
            if (paramaq == null)
            {
              paramaq = ((i)localObject3).Su((String)localObject4);
              if (paramaq != null)
              {
                paramaq = paramaq.ASz;
                parambui.EWw = paramaq.object_id;
                parambui.aaeN = paramaq.object_nonce_id;
                parambui.aaeR = paramaq.username;
                parambui.tabTipsByPassInfo = paramaq.tabTipsByPassInfo;
                parambui.ZNx = ((String)localObject4);
              }
            }
            paramaq = ((com.tencent.mm.plugin.finder.extension.reddot.p)localObject5).field_tipsId;
            kotlin.g.b.s.s(paramaq, "it.field_tipsId");
            parambui.avc(paramaq);
            paramaq = ah.aiuX;
            break label1388;
            break;
            i = 0;
            break label1489;
            paramaq = null;
            break label1493;
            parambui.EWw = paramaq.object_id;
            parambui.aaeN = paramaq.object_nonce_id;
            parambui.aaeR = paramaq.username;
            parambui.tabTipsByPassInfo = paramaq.tabTipsByPassInfo;
            parambui.ZNx = "FinderEntrance";
          }
          i = paramaq.ZEr;
          break label1157;
          bool2 = false;
          break label1172;
          bool1 = false;
          break label1290;
        }
        label1489:
        label1493:
        label1639:
        l = paramaq.id;
        label1581:
        label1588:
        label1593:
        break label515;
        label1665:
        label1674:
        paramaq = paramaq.objectNonceId;
        break label533;
        label1682:
        paramaq.uri = "/cgi-bin/micromsg-bin/finderstreamforpush";
        paramaq.funcId = 4270;
        break label695;
        label1699:
        paramaq = Integer.valueOf(paramaq.Op.length);
        break label785;
        label1711:
        paramaq = this.AAo.AAk.lastBuffer;
        if (paramaq == null) {}
        for (paramaq = null;; paramaq = paramaq.Op)
        {
          paramaq = MD5Util.getMD5String(paramaq);
          break;
        }
        label1744:
        paramaq = paramaq.ZKH;
        if (paramaq == null)
        {
          paramaq = null;
        }
        else
        {
          paramaq = paramaq.ZPF;
          if (paramaq == null) {
            paramaq = null;
          } else {
            paramaq = Integer.valueOf(paramaq.ZPE);
          }
        }
      }
    }
    
    public final boolean dVg()
    {
      return true;
    }
    
    public final com.tencent.mm.plugin.findersdk.b.a.b dVi()
    {
      return com.tencent.mm.plugin.findersdk.b.a.b.Hde;
    }
    
    public final JSONObject dVk()
    {
      AppMethodBeat.i(336648);
      JSONObject localJSONObject = new JSONObject();
      aq localaq = this.AAo;
      localJSONObject.put("tabType", localaq.hJx);
      localJSONObject.put("pullType", localaq.pullType);
      AppMethodBeat.o(336648);
      return localJSONObject;
    }
    
    public final JSONObject dVl()
    {
      return this.AAn;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.aq
 * JD-Core Version:    0.7.0.1
 */