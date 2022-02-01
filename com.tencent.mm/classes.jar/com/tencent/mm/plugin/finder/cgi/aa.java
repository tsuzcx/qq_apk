package com.tencent.mm.plugin.finder.cgi;

import android.arch.lifecycle.ViewModelProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.interceptor.g;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.preload.tabPreload.FinderStreamTabPreloadCore;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.report.h.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.asj;
import com.tencent.mm.protocal.protobuf.ask;
import com.tencent.mm.protocal.protobuf.baw;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.protocal.protobuf.bda;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.vending.e.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream;", "", "tabType", "", "pullType", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "unreadList", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "isPreload", "", "(IILcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Ljava/util/List;Z)V", "callback", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$Callback;", "interceptors", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/OrderInterceptor;", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "request", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamRequestEx;", "streamCgi", "com/tencent/mm/plugin/finder/cgi/CgiFinderStream$streamCgi$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$streamCgi$1;", "addInterceptor", "interceptor", "order", "buildBaseRequest", "", "Lcom/tencent/mm/protocal/protobuf/FinderStreamRequest;", "buildPartialExposeRequest", "buildRedDotRequest", "buildResponse", "Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;", "buildStatsRequest", "buildUnreadRequest", "createFinderStreamResponseEx", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "it", "mergeResp", "streamResponse", "historyResponse", "Lcom/tencent/mm/protocal/protobuf/FinderGetHistoryResponse;", "onCgiBack", "errType", "errCode", "errMsg", "", "resp", "removeInterceptor", "run", "showErrorToast", "tip", "Callback", "Companion", "FinderStreamHistoryCgi", "FinderStreamRequestEx", "FinderStreamResponseEx", "plugin-finder_release"})
public final class aa
{
  public static final c ttP;
  private final int dLS;
  private final com.tencent.mm.bw.b lastBuffer;
  private final boolean ltW;
  private final int pullType;
  private final List<FinderObject> tsE;
  private b ttJ;
  private c<com.tencent.mm.vending.e.a> ttK;
  private final ConcurrentLinkedQueue<g<com.tencent.mm.plugin.finder.cgi.interceptor.f>> ttL;
  private final e ttM;
  private final j ttN;
  private final bbn ttO;
  
  static
  {
    AppMethodBeat.i(242278);
    ttP = new c((byte)0);
    AppMethodBeat.o(242278);
  }
  
  public aa(int paramInt1, int paramInt2, com.tencent.mm.bw.b paramb, bbn parambbn, List<? extends FinderObject> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(242277);
    this.dLS = paramInt1;
    this.pullType = paramInt2;
    this.lastBuffer = paramb;
    this.ttO = parambbn;
    this.tsE = paramList;
    this.ltW = paramBoolean;
    this.ttL = new ConcurrentLinkedQueue();
    h.a(h.veu, this.dLS, this.pullType, this.ttO);
    this.ttM = new e();
    this.ttN = new j(this, this.ttO);
    AppMethodBeat.o(242277);
  }
  
  private final f a(bda parambda)
  {
    AppMethodBeat.i(242276);
    f localf = new f();
    localf.a(this.ttM);
    localf.LMF = parambda.LMF;
    localf.LME = parambda.LME;
    localf.object.addAll((Collection)parambda.object);
    localf.liveObjects.addAll((Collection)parambda.liveObjects);
    localf.tUB = parambda.tUB;
    localf.LMG = parambda.LMG;
    localf.LMH = parambda.LMH;
    localf.preloadInfo = parambda.preloadInfo;
    localf.LMK = parambda.LMK;
    localf.LMI = parambda.LMI;
    localf.LMM = parambda.LMM;
    localf.LMJ = parambda.LMJ;
    localf.LML = parambda.LML;
    localf.lastBuffer = parambda.lastBuffer;
    localf.ttV = parambda.object.size();
    localf.LMN = parambda.LMN;
    localf.tvs = parambda.tvs;
    localf.LMO = parambda.LMO;
    localf.tUH = parambda.tUH;
    AppMethodBeat.o(242276);
    return localf;
  }
  
  private final void a(int paramInt1, int paramInt2, String paramString, f paramf)
  {
    AppMethodBeat.i(242274);
    Log.i("Finder.FinderStream", "onCgiBack tabType=" + this.dLS + " pullType:" + this.pullType);
    Object localObject1 = com.tencent.mm.plugin.finder.preload.a.uTO;
    localObject1 = paramf.preloadInfo;
    Object localObject2 = paramf.object;
    p.g(localObject2, "resp.`object`");
    com.tencent.mm.plugin.finder.preload.a.a((baw)localObject1, (List)localObject2, 3901);
    localObject2 = (Iterable)j.a((Iterable)((aa)this).ttL, (Comparator)new a());
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add((com.tencent.mm.plugin.finder.cgi.interceptor.f)((g)((Iterator)localObject2).next()).txH);
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((com.tencent.mm.plugin.finder.cgi.interceptor.f)((Iterator)localObject1).next()).a(paramf);
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      localObject1 = h.veu;
      h.d(this.dLS, this.ttO);
    }
    localObject1 = this.ttJ;
    if (localObject1 == null) {
      p.btv("callback");
    }
    Object localObject3 = (Iterable)j.a((Iterable)this.ttL, (Comparator)new g());
    localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((Collection)localObject2).add((com.tencent.mm.plugin.finder.cgi.interceptor.f)((g)((Iterator)localObject3).next()).txH);
    }
    ((b)localObject1).a(paramInt1, paramInt2, paramString, paramf, j.p((Iterable)localObject2));
    AppMethodBeat.o(242274);
  }
  
  public final aa a(com.tencent.mm.plugin.finder.cgi.interceptor.f paramf, int paramInt)
  {
    AppMethodBeat.i(242273);
    p.h(paramf, "interceptor");
    this.ttL.add(new g(paramf, paramInt));
    AppMethodBeat.o(242273);
    return this;
  }
  
  public final void a(c<com.tencent.mm.vending.e.a> paramc, b paramb)
  {
    AppMethodBeat.i(242275);
    p.h(paramb, "callback");
    h.a(h.veu, this.dLS, true, null, 12);
    this.ttJ = paramb;
    Object localObject = paramc;
    if (paramc == null) {
      localObject = new c();
    }
    this.ttK = ((c)localObject);
    this.ttM.ttU = paramb.cXU();
    if (this.ttM.ttU)
    {
      paramc = h.veu;
      h.ao(this.dLS, true);
      paramc = new d(null, this.lastBuffer).aYI();
      paramb = this.ttK;
      if (paramb == null) {
        p.btv("lifeCycleKeeper");
      }
      paramc.a((com.tencent.mm.vending.e.b)paramb);
      AppMethodBeat.o(242275);
      return;
    }
    paramc = com.tencent.mm.ui.component.a.PRN;
    paramc = ((FinderStreamTabPreloadCore)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderStreamTabPreloadCore.class)).JL(this.dLS);
    if ((this.pullType != 1) && (this.pullType != 0)) {}
    for (int i = 1; (this.ltW) || (i != 0); i = 0)
    {
      if ((i != 0) && (paramc != null)) {
        paramc.nM(true);
      }
      paramb.a((bcz)this.ttM);
      h.a(h.veu, this.dLS);
      this.ttN.aYI();
      AppMethodBeat.o(242275);
      return;
    }
    if (paramc != null)
    {
      localObject = paramc.JP(this.pullType);
      if (localObject != null)
      {
        paramc = MediaPreloadCore.uTV;
        if (MediaPreloadCore.dlF()) {
          com.tencent.mm.ac.d.h((kotlin.g.a.a)new h(this));
        }
        Log.i("Finder.FinderStream", "[run] use preload cache. tabType=" + this.dLS + ' ');
        paramc = h.veu;
        paramc = h.Kd(this.dLS);
        if (paramc != null)
        {
          if ((!paramc.ZA) || (paramc.vev) || (paramc.vfh != 0)) {
            break label391;
          }
          i = 1;
          if (i == 0) {
            break label396;
          }
        }
        for (;;)
        {
          if (paramc != null) {
            paramc.vfc = 1;
          }
          a(0, 0, null, (f)localObject);
          AppMethodBeat.o(242275);
          return;
          label391:
          i = 0;
          break;
          label396:
          paramc = null;
        }
      }
    }
    paramc = (aa)this;
    paramb.a((bcz)paramc.ttM);
    h.a(h.veu, paramc.dLS);
    paramc.ttN.aYI();
    AppMethodBeat.o(242275);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class a<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(242261);
      int i = kotlin.b.a.a((Comparable)Integer.valueOf(((g)paramT1).order), (Comparable)Integer.valueOf(((g)paramT2).order));
      AppMethodBeat.o(242261);
      return i;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$Callback;", "", "isBeginHistory", "", "isResultConsume", "errType", "", "errCode", "resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "onBuildRequest", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderStreamRequest;", "onCgiBack", "errMsg", "", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "interceptors", "", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, aa.f paramf, List<? extends com.tencent.mm.plugin.finder.cgi.interceptor.f> paramList);
    
    public abstract void a(bcz parambcz);
    
    public abstract boolean a(dpc paramdpc);
    
    public abstract boolean cXU();
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class c {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamHistoryCgi;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetHistoryResponse;", "streamResp", "Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream;Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;Lcom/tencent/mm/protobuf/ByteString;)V", "resultExt", "Lorg/json/JSONObject;", "getResultExt", "()Lorg/json/JSONObject;", "actionExt", "isEnableReport", "Lcom/tencent/mm/plugin/finder/cgi/report/EnableValue;", "isFetchFeedCgi", "", "onCgiEnd", "", "errType", "", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
  public final class d
    extends an<ask>
  {
    private final JSONObject ttQ;
    private bda ttR;
    
    public d(com.tencent.mm.bw.b paramb)
    {
      AppMethodBeat.i(242264);
      this.ttR = paramb;
      this.ttQ = new JSONObject();
      paramb = new d.a();
      asj localasj = new asj();
      aa.e(aa.this).ttT = localasj;
      localasj.LAt = z.aUg();
      localasj.dLS = aa.a(aa.this);
      Object localObject;
      localasj.LDs = localObject;
      StringBuilder localStringBuilder = new StringBuilder("[request#historyCgi] isPreload=").append(aa.c(aa.this)).append(" tabType=").append(aa.a(aa.this)).append(" pullType=").append(aa.d(aa.this)).append(" lastBuffer=");
      if (localObject == null) {}
      for (this$1 = "null";; this$1 = MD5Util.getMD5String(localObject.zy))
      {
        Log.i("Finder.FinderStream", aa.this);
        this$1 = am.tuw;
        localasj.uli = am.a(this.ttO);
        paramb.c((com.tencent.mm.bw.a)localasj);
        this$1 = new ask();
        aa.this.setBaseResponse(new BaseResponse());
        aa.this.getBaseResponse().ErrMsg = new dqi();
        paramb.d((com.tencent.mm.bw.a)aa.this);
        paramb.MB("/cgi-bin/micromsg-bin/findergethistory");
        paramb.sG(3814);
        c(paramb.aXF());
        AppMethodBeat.o(242264);
        return;
      }
    }
    
    public final boolean cXQ()
    {
      return true;
    }
    
    public final com.tencent.mm.plugin.finder.cgi.report.b cXS()
    {
      return com.tencent.mm.plugin.finder.cgi.report.b.tye;
    }
    
    public final JSONObject cXV()
    {
      AppMethodBeat.i(242263);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("tabType", aa.a(aa.this));
      localJSONObject.put("pullType", aa.d(aa.this));
      AppMethodBeat.o(242263);
      return localJSONObject;
    }
    
    public final JSONObject cXW()
    {
      return this.ttQ;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamRequestEx;", "Lcom/tencent/mm/protocal/protobuf/FinderStreamRequest;", "()V", "historyRequest", "Lcom/tencent/mm/protocal/protobuf/FinderGetHistoryRequest;", "getHistoryRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderGetHistoryRequest;", "setHistoryRequest", "(Lcom/tencent/mm/protocal/protobuf/FinderGetHistoryRequest;)V", "isBeginHistory", "", "()Z", "setBeginHistory", "(Z)V", "plugin-finder_release"})
  public static final class e
    extends bcz
  {
    asj ttT;
    boolean ttU;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;", "()V", "afterFeedIdHistory", "", "getAfterFeedIdHistory", "()J", "setAfterFeedIdHistory", "(J)V", "continueFlag", "", "getContinueFlag", "()I", "setContinueFlag", "(I)V", "historySize", "getHistorySize", "setHistorySize", "isFetchHistory", "", "()Z", "setFetchHistory", "(Z)V", "requestEx", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamRequestEx;", "getRequestEx", "()Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamRequestEx;", "setRequestEx", "(Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamRequestEx;)V", "streamSize", "getStreamSize", "setStreamSize", "plugin-finder_release"})
  public static final class f
    extends bda
  {
    public int continueFlag = 1;
    public int kxF = -1;
    public int ttV;
    public long ttW = -1L;
    public boolean ttX;
    public aa.e ttY;
    
    public final void a(aa.e parame)
    {
      AppMethodBeat.i(242266);
      p.h(parame, "<set-?>");
      this.ttY = parame;
      AppMethodBeat.o(242266);
    }
    
    public final aa.e cXX()
    {
      AppMethodBeat.i(242265);
      aa.e locale = this.ttY;
      if (locale == null) {
        p.btv("requestEx");
      }
      AppMethodBeat.o(242265);
      return locale;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class g<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(242267);
      int i = kotlin.b.a.a((Comparable)Integer.valueOf(((g)paramT1).order), (Comparable)Integer.valueOf(((g)paramT2).order));
      AppMethodBeat.o(242267);
      return i;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/cgi/CgiFinderStream$run$1$1"})
  static final class h
    extends q
    implements kotlin.g.a.a<x>
  {
    h(aa paramaa)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<x>
  {
    i(String paramString)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/cgi/CgiFinderStream$streamCgi$1", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;", "resultExt", "Lorg/json/JSONObject;", "getResultExt", "()Lorg/json/JSONObject;", "actionExt", "isEnableReport", "Lcom/tencent/mm/plugin/finder/cgi/report/EnableValue;", "isFetchFeedCgi", "", "onCgiEnd", "", "errType", "", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
  public static final class j
    extends an<bda>
  {
    private final JSONObject ttQ;
    
    j(bbn parambbn)
    {
      super();
      AppMethodBeat.i(242272);
      this.ttQ = new JSONObject();
      aa.a(parambbn, (bcz)aa.e(parambbn));
      aa.b(parambbn, (bcz)aa.e(parambbn));
      aa.a(parambbn, aa.e(parambbn));
      aa.c(parambbn, (bcz)aa.e(parambbn));
      aa.d(parambbn, (bcz)aa.e(parambbn));
      Object localObject1 = new d.a();
      ((d.a)localObject1).c((com.tencent.mm.bw.a)aa.e(parambbn));
      ((d.a)localObject1).d((com.tencent.mm.bw.a)aa.cXT());
      ((d.a)localObject1).MB("/cgi-bin/micromsg-bin/finderstream");
      ((d.a)localObject1).sG(3901);
      com.tencent.mm.ak.d locald = ((d.a)localObject1).aXF();
      StringBuilder localStringBuilder = new StringBuilder("[CgiFetchFinderTimeline#init] tabType=").append(aa.a(parambbn)).append(" pullType=").append(aa.d(parambbn)).append(" lastBuffer=");
      localObject1 = aa.e(parambbn).lastBuffer;
      if (localObject1 != null)
      {
        localObject1 = Integer.valueOf(((com.tencent.mm.bw.b)localObject1).zy.length);
        localStringBuilder = localStringBuilder.append(localObject1).append(", ");
        if (aa.e(parambbn).lastBuffer != null) {
          break label271;
        }
      }
      for (localObject1 = "null";; localObject1 = MD5Util.getMD5String((byte[])localObject1))
      {
        Log.i("Finder.FinderStream", (String)localObject1 + " longitude=" + aa.e(parambbn).dTj + " latitude=" + aa.e(parambbn).latitude);
        c(locald);
        AppMethodBeat.o(242272);
        return;
        localObject1 = null;
        break;
        label271:
        com.tencent.mm.bw.b localb = aa.e(parambbn).lastBuffer;
        localObject1 = localObject2;
        if (localb != null) {
          localObject1 = localb.zy;
        }
      }
    }
    
    public final boolean cXQ()
    {
      return true;
    }
    
    public final com.tencent.mm.plugin.finder.cgi.report.b cXS()
    {
      return com.tencent.mm.plugin.finder.cgi.report.b.tye;
    }
    
    public final JSONObject cXV()
    {
      AppMethodBeat.i(242270);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("tabType", aa.a(this.ttS));
      localJSONObject.put("pullType", aa.d(this.ttS));
      AppMethodBeat.o(242270);
      return localJSONObject;
    }
    
    public final JSONObject cXW()
    {
      return this.ttQ;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.aa
 * JD-Core Version:    0.7.0.1
 */