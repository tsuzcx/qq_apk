package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.report.j.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.auk;
import com.tencent.mm.protocal.protobuf.aul;
import com.tencent.mm.protocal.protobuf.bhh;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bjv;
import com.tencent.mm.protocal.protobuf.bjw;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.ui.component.g.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream;", "", "tabType", "", "pullType", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "unreadList", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "isPreload", "", "(IILcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Ljava/util/List;Z)V", "callback", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$Callback;", "interceptors", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/OrderInterceptor;", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "request", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamRequestEx;", "streamCgi", "com/tencent/mm/plugin/finder/cgi/CgiFinderStream$streamCgi$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$streamCgi$1;", "addInterceptor", "interceptor", "order", "buildBaseRequest", "", "Lcom/tencent/mm/protocal/protobuf/FinderStreamRequest;", "buildPartialExposeRequest", "buildRedDotRequest", "buildResponse", "Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;", "buildSlideLeftRequest", "buildStatsRequest", "buildUnreadRequest", "createFinderStreamResponseEx", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "it", "mergeResp", "streamResponse", "historyResponse", "Lcom/tencent/mm/protocal/protobuf/FinderGetHistoryResponse;", "onCgiBack", "errType", "errCode", "errMsg", "", "resp", "removeInterceptor", "run", "showErrorToast", "tip", "Callback", "Companion", "FinderStreamHistoryCgi", "FinderStreamRequestEx", "FinderStreamResponseEx", "plugin-finder_release"})
public final class aa
{
  public static final c xbv;
  private final int fEH;
  private final com.tencent.mm.cd.b lastBuffer;
  private final boolean ooW;
  private final int pullType;
  private final List<FinderObject> xam;
  private b xbp;
  private com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> xbq;
  private final ConcurrentLinkedQueue<com.tencent.mm.plugin.finder.cgi.interceptor.g<com.tencent.mm.plugin.finder.cgi.interceptor.f>> xbr;
  private final e xbs;
  private final j xbt;
  private final bid xbu;
  
  static
  {
    AppMethodBeat.i(275465);
    xbv = new c((byte)0);
    AppMethodBeat.o(275465);
  }
  
  public aa(int paramInt1, int paramInt2, com.tencent.mm.cd.b paramb, bid parambid, List<? extends FinderObject> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(275464);
    this.fEH = paramInt1;
    this.pullType = paramInt2;
    this.lastBuffer = paramb;
    this.xbu = parambid;
    this.xam = paramList;
    this.ooW = paramBoolean;
    this.xbr = new ConcurrentLinkedQueue();
    com.tencent.mm.plugin.finder.report.j.a(com.tencent.mm.plugin.finder.report.j.zVy, this.fEH, this.pullType, this.xbu);
    this.xbs = new e();
    this.xbt = new j(this, this.xbu);
    AppMethodBeat.o(275464);
  }
  
  private final f a(bjw parambjw)
  {
    AppMethodBeat.i(275463);
    f localf = new f();
    localf.a(this.xbs);
    localf.SUI = parambjw.SUI;
    localf.SUH = parambjw.SUH;
    localf.object.addAll((Collection)parambjw.object);
    localf.liveObjects.addAll((Collection)parambjw.liveObjects);
    localf.xFH = parambjw.xFH;
    localf.SUJ = parambjw.SUJ;
    localf.SUK = parambjw.SUK;
    localf.preloadInfo = parambjw.preloadInfo;
    localf.SUN = parambjw.SUN;
    localf.SUL = parambjw.SUL;
    localf.SUP = parambjw.SUP;
    localf.SUM = parambjw.SUM;
    localf.SUO = parambjw.SUO;
    localf.lastBuffer = parambjw.lastBuffer;
    localf.xbB = parambjw.object.size();
    localf.SUQ = parambjw.SUQ;
    localf.xcZ = parambjw.xcZ;
    localf.SUR = parambjw.SUR;
    localf.xFN = parambjw.xFN;
    AppMethodBeat.o(275463);
    return localf;
  }
  
  private final void a(int paramInt1, int paramInt2, String paramString, f paramf)
  {
    AppMethodBeat.i(275461);
    Log.i("Finder.FinderStream", "onCgiBack tabType=" + this.fEH + " pullType:" + this.pullType);
    Object localObject1 = com.tencent.mm.plugin.finder.preload.a.zKe;
    localObject1 = paramf.preloadInfo;
    Object localObject2 = paramf.object;
    p.j(localObject2, "resp.`object`");
    com.tencent.mm.plugin.finder.preload.a.a((bhh)localObject1, (List)localObject2, 3901);
    localObject2 = (Iterable)kotlin.a.j.a((Iterable)((aa)this).xbr, (Comparator)new a());
    localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add((com.tencent.mm.plugin.finder.cgi.interceptor.f)((com.tencent.mm.plugin.finder.cgi.interceptor.g)((Iterator)localObject2).next()).xfJ);
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((com.tencent.mm.plugin.finder.cgi.interceptor.f)((Iterator)localObject1).next()).a(paramf);
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      localObject1 = com.tencent.mm.plugin.finder.report.j.zVy;
      com.tencent.mm.plugin.finder.report.j.d(this.fEH, this.xbu);
    }
    localObject1 = this.xbp;
    if (localObject1 == null) {
      p.bGy("callback");
    }
    Object localObject3 = (Iterable)kotlin.a.j.a((Iterable)this.xbr, (Comparator)new g());
    localObject2 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((Collection)localObject2).add((com.tencent.mm.plugin.finder.cgi.interceptor.f)((com.tencent.mm.plugin.finder.cgi.interceptor.g)((Iterator)localObject3).next()).xfJ);
    }
    ((b)localObject1).a(paramInt1, paramInt2, paramString, paramf, kotlin.a.j.p((Iterable)localObject2));
    AppMethodBeat.o(275461);
  }
  
  public final aa a(com.tencent.mm.plugin.finder.cgi.interceptor.f paramf, int paramInt)
  {
    AppMethodBeat.i(275460);
    p.k(paramf, "interceptor");
    this.xbr.add(new com.tencent.mm.plugin.finder.cgi.interceptor.g(paramf, paramInt));
    AppMethodBeat.o(275460);
    return this;
  }
  
  public final void a(com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> paramc, b paramb)
  {
    AppMethodBeat.i(275462);
    p.k(paramb, "callback");
    com.tencent.mm.plugin.finder.report.j.a(com.tencent.mm.plugin.finder.report.j.zVy, this.fEH, true, null, 12);
    this.xbp = paramb;
    Object localObject = paramc;
    if (paramc == null) {
      localObject = new com.tencent.mm.vending.e.c();
    }
    this.xbq = ((com.tencent.mm.vending.e.c)localObject);
    this.xbs.xbA = paramb.dnH();
    if (this.xbs.xbA)
    {
      paramc = com.tencent.mm.plugin.finder.report.j.zVy;
      com.tencent.mm.plugin.finder.report.j.ar(this.fEH, true);
      paramc = new d(null, this.lastBuffer).bhW();
      paramb = this.xbq;
      if (paramb == null) {
        p.bGy("lifeCycleKeeper");
      }
      paramc.a((com.tencent.mm.vending.e.b)paramb);
      AppMethodBeat.o(275462);
      return;
    }
    paramc = com.tencent.mm.ui.component.g.Xox;
    paramc = ((com.tencent.mm.plugin.finder.preload.tabPreload.c)com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.preload.tabPreload.c.class)).OM(this.fEH);
    int i;
    if ((this.pullType != 1) && (this.pullType != 0))
    {
      i = 1;
      if ((!this.ooW) && (i == 0)) {
        break label274;
      }
      if (i != 0) {
        if (paramc == null) {
          break label268;
        }
      }
    }
    label268:
    for (boolean bool = paramc.pV(true);; bool = false)
    {
      if (bool)
      {
        paramc = com.tencent.mm.plugin.finder.preload.tabPreload.b.zLe;
        com.tencent.mm.plugin.finder.preload.tabPreload.b.c(0, 3, 2, false, 115);
      }
      paramb.a((bjv)this.xbs);
      com.tencent.mm.plugin.finder.report.j.a(com.tencent.mm.plugin.finder.report.j.zVy, this.fEH);
      this.xbt.bhW();
      AppMethodBeat.o(275462);
      return;
      i = 0;
      break;
    }
    label274:
    if (paramc != null)
    {
      localObject = paramc.OQ(this.pullType);
      if (localObject != null)
      {
        paramc = com.tencent.mm.plugin.finder.preload.c.zKl;
        if (com.tencent.mm.plugin.finder.preload.c.dMG()) {
          com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new h(this));
        }
        Log.i("Finder.FinderStream", "[run] use preload cache. tabType=" + this.fEH + ' ');
        paramc = com.tencent.mm.plugin.finder.report.j.zVy;
        paramc = com.tencent.mm.plugin.finder.report.j.Ph(this.fEH);
        if (paramc != null)
        {
          if ((!paramc.gX) || (paramc.zVz) || (paramc.zWl != 0)) {
            break label416;
          }
          i = 1;
          if (i == 0) {
            break label421;
          }
        }
        for (;;)
        {
          if (paramc != null) {
            paramc.zWg = 1;
          }
          a(0, 0, null, (f)localObject);
          AppMethodBeat.o(275462);
          return;
          label416:
          i = 0;
          break;
          label421:
          paramc = null;
        }
      }
    }
    paramc = (aa)this;
    paramb.a((bjv)paramc.xbs);
    com.tencent.mm.plugin.finder.report.j.a(com.tencent.mm.plugin.finder.report.j.zVy, paramc.fEH);
    paramc.xbt.bhW();
    AppMethodBeat.o(275462);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class a<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(292314);
      int i = kotlin.b.a.a((Comparable)Integer.valueOf(((com.tencent.mm.plugin.finder.cgi.interceptor.g)paramT1).order), (Comparable)Integer.valueOf(((com.tencent.mm.plugin.finder.cgi.interceptor.g)paramT2).order));
      AppMethodBeat.o(292314);
      return i;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$Callback;", "", "isBeginHistory", "", "isResultConsume", "errType", "", "errCode", "resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "onBuildRequest", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderStreamRequest;", "onCgiBack", "errMsg", "", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "interceptors", "", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, aa.f paramf, List<? extends com.tencent.mm.plugin.finder.cgi.interceptor.f> paramList);
    
    public abstract void a(bjv parambjv);
    
    public abstract boolean a(dyy paramdyy);
    
    public abstract boolean dnH();
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class c {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamHistoryCgi;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetHistoryResponse;", "streamResp", "Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream;Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;Lcom/tencent/mm/protobuf/ByteString;)V", "resultExt", "Lorg/json/JSONObject;", "getResultExt", "()Lorg/json/JSONObject;", "actionExt", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "isFetchFeedCgi", "", "onCgiEnd", "", "errType", "", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
  public final class d
    extends com.tencent.mm.plugin.findersdk.b.c<aul>
  {
    private final JSONObject xbw;
    private bjw xbx;
    
    public d(com.tencent.mm.cd.b paramb)
    {
      AppMethodBeat.i(274831);
      this.xbx = paramb;
      this.xbw = new JSONObject();
      paramb = new d.a();
      auk localauk = new auk();
      aa.e(aa.this).xbz = localauk;
      localauk.RLN = z.bdh();
      localauk.fEH = aa.a(aa.this);
      Object localObject;
      localauk.SDI = localObject;
      StringBuilder localStringBuilder = new StringBuilder("[request#historyCgi] isPreload=").append(aa.c(aa.this)).append(" tabType=").append(aa.a(aa.this)).append(" pullType=").append(aa.d(aa.this)).append(" lastBuffer=");
      if (localObject == null) {}
      for (this$1 = "null";; this$1 = MD5Util.getMD5String(localObject.UH))
      {
        Log.i("Finder.FinderStream", aa.this);
        this$1 = ao.xcj;
        localauk.yjp = ao.a(this.xbu);
        paramb.c((com.tencent.mm.cd.a)localauk);
        this$1 = new aul();
        aa.this.setBaseResponse(new jh());
        aa.this.getBaseResponse().Tef = new eaf();
        paramb.d((com.tencent.mm.cd.a)aa.this);
        paramb.TW("/cgi-bin/micromsg-bin/findergethistory");
        paramb.vD(3814);
        c(paramb.bgN());
        AppMethodBeat.o(274831);
        return;
      }
    }
    
    public final boolean dnD()
    {
      return true;
    }
    
    public final com.tencent.mm.plugin.findersdk.b.a.b dnF()
    {
      return com.tencent.mm.plugin.findersdk.b.a.b.BvU;
    }
    
    public final JSONObject dnI()
    {
      AppMethodBeat.i(274830);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("tabType", aa.a(aa.this));
      localJSONObject.put("pullType", aa.d(aa.this));
      AppMethodBeat.o(274830);
      return localJSONObject;
    }
    
    public final JSONObject dnJ()
    {
      return this.xbw;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamRequestEx;", "Lcom/tencent/mm/protocal/protobuf/FinderStreamRequest;", "()V", "historyRequest", "Lcom/tencent/mm/protocal/protobuf/FinderGetHistoryRequest;", "getHistoryRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderGetHistoryRequest;", "setHistoryRequest", "(Lcom/tencent/mm/protocal/protobuf/FinderGetHistoryRequest;)V", "isBeginHistory", "", "()Z", "setBeginHistory", "(Z)V", "plugin-finder_release"})
  public static final class e
    extends bjv
  {
    boolean xbA;
    auk xbz;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;", "()V", "afterFeedIdHistory", "", "getAfterFeedIdHistory", "()J", "setAfterFeedIdHistory", "(J)V", "continueFlag", "", "getContinueFlag", "()I", "setContinueFlag", "(I)V", "historySize", "getHistorySize", "setHistorySize", "isFetchHistory", "", "()Z", "setFetchHistory", "(Z)V", "requestEx", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamRequestEx;", "getRequestEx", "()Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamRequestEx;", "setRequestEx", "(Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamRequestEx;)V", "streamSize", "getStreamSize", "setStreamSize", "plugin-finder_release"})
  public static final class f
    extends bjw
  {
    public int continueFlag = 1;
    public int nqx = -1;
    public int xbB;
    public long xbC = -1L;
    public boolean xbD;
    public aa.e xbE;
    
    public final void a(aa.e parame)
    {
      AppMethodBeat.i(280442);
      p.k(parame, "<set-?>");
      this.xbE = parame;
      AppMethodBeat.o(280442);
    }
    
    public final aa.e dnK()
    {
      AppMethodBeat.i(280440);
      aa.e locale = this.xbE;
      if (locale == null) {
        p.bGy("requestEx");
      }
      AppMethodBeat.o(280440);
      return locale;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class g<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(277849);
      int i = kotlin.b.a.a((Comparable)Integer.valueOf(((com.tencent.mm.plugin.finder.cgi.interceptor.g)paramT1).order), (Comparable)Integer.valueOf(((com.tencent.mm.plugin.finder.cgi.interceptor.g)paramT2).order));
      AppMethodBeat.o(277849);
      return i;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/cgi/CgiFinderStream$run$1$1"})
  static final class h
    extends q
    implements kotlin.g.a.a<x>
  {
    h(aa paramaa)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<x>
  {
    i(String paramString)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/cgi/CgiFinderStream$streamCgi$1", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;", "resultExt", "Lorg/json/JSONObject;", "getResultExt", "()Lorg/json/JSONObject;", "actionExt", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "isFetchFeedCgi", "", "onCgiEnd", "", "errType", "", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
  public static final class j
    extends com.tencent.mm.plugin.findersdk.b.c<bjw>
  {
    private final JSONObject xbw;
    
    j(bid parambid)
    {
      super();
      AppMethodBeat.i(228365);
      this.xbw = new JSONObject();
      aa.a(parambid, (bjv)aa.e(parambid));
      aa.b(parambid, (bjv)aa.e(parambid));
      aa.a(parambid, aa.e(parambid));
      aa.c(parambid, (bjv)aa.e(parambid));
      aa.d(parambid, (bjv)aa.e(parambid));
      aa.e(parambid, (bjv)aa.e(parambid));
      Object localObject1 = new d.a();
      ((d.a)localObject1).c((com.tencent.mm.cd.a)aa.e(parambid));
      ((d.a)localObject1).d((com.tencent.mm.cd.a)aa.dnG());
      ((d.a)localObject1).TW("/cgi-bin/micromsg-bin/finderstream");
      ((d.a)localObject1).vD(3901);
      com.tencent.mm.an.d locald = ((d.a)localObject1).bgN();
      StringBuilder localStringBuilder = new StringBuilder("[CgiFetchFinderTimeline#init] tabType=").append(aa.a(parambid)).append(" pullType=").append(aa.d(parambid)).append(" lastBuffer=");
      localObject1 = aa.e(parambid).lastBuffer;
      if (localObject1 != null)
      {
        localObject1 = Integer.valueOf(((com.tencent.mm.cd.b)localObject1).UH.length);
        localStringBuilder = localStringBuilder.append(localObject1).append(", ");
        if (aa.e(parambid).lastBuffer != null) {
          break label282;
        }
      }
      for (localObject1 = "null";; localObject1 = MD5Util.getMD5String((byte[])localObject1))
      {
        Log.i("Finder.FinderStream", (String)localObject1 + " longitude=" + aa.e(parambid).longitude + " latitude=" + aa.e(parambid).latitude);
        c(locald);
        AppMethodBeat.o(228365);
        return;
        localObject1 = null;
        break;
        label282:
        com.tencent.mm.cd.b localb = aa.e(parambid).lastBuffer;
        localObject1 = localObject2;
        if (localb != null) {
          localObject1 = localb.UH;
        }
      }
    }
    
    public final boolean dnD()
    {
      return true;
    }
    
    public final com.tencent.mm.plugin.findersdk.b.a.b dnF()
    {
      return com.tencent.mm.plugin.findersdk.b.a.b.BvU;
    }
    
    public final JSONObject dnI()
    {
      AppMethodBeat.i(228340);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("tabType", aa.a(this.xby));
      localJSONObject.put("pullType", aa.d(this.xby));
      AppMethodBeat.o(228340);
      return localJSONObject;
    }
    
    public final JSONObject dnJ()
    {
      return this.xbw;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.aa
 * JD-Core Version:    0.7.0.1
 */