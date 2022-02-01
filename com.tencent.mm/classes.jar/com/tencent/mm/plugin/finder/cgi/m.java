package com.tencent.mm.plugin.finder.cgi;

import android.arch.lifecycle.ViewModelProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.interceptor.g;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.preload.tabPreload.FinderStreamTabPreloadCore;
import com.tencent.mm.plugin.finder.report.f.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aoh;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.arc;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.ash;
import com.tencent.mm.protocal.protobuf.asi;
import com.tencent.mm.protocal.protobuf.ass;
import com.tencent.mm.protocal.protobuf.cwj;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import d.a.j;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream;", "", "tabType", "", "pullType", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "unreadList", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "(IILcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Ljava/util/List;)V", "callback", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$Callback;", "interceptors", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/OrderInterceptor;", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "isPreload", "", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "request", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamRequestEx;", "streamCgi", "com/tencent/mm/plugin/finder/cgi/CgiFinderStream$streamCgi$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$streamCgi$1;", "addInterceptor", "interceptor", "order", "buildBaseRequest", "", "Lcom/tencent/mm/protocal/protobuf/FinderStreamRequest;", "buildPartialExposeRequest", "buildRedDotRequest", "buildResponse", "Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;", "buildStatsRequest", "buildUnreadRequest", "createFinderStreamResponseEx", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "it", "mergeResp", "streamResponse", "historyResponse", "Lcom/tencent/mm/protocal/protobuf/FinderGetHistoryResponse;", "onCgiBack", "errType", "errCode", "errMsg", "", "resp", "removeInterceptor", "run", "showErrorToast", "tip", "Callback", "Companion", "FinderStreamHistoryCgi", "FinderStreamRequestEx", "FinderStreamResponseEx", "plugin-finder_release"})
public final class m
{
  public static final c rQx;
  private final int dvm;
  private boolean kqo;
  private final com.tencent.mm.bw.b lastBuffer;
  private final int pullType;
  private final List<FinderObject> rPN;
  private b rQr;
  private com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> rQs;
  private final ConcurrentLinkedQueue<g<com.tencent.mm.plugin.finder.cgi.interceptor.f>> rQt;
  private final e rQu;
  private final j rQv;
  private final arn rQw;
  
  static
  {
    AppMethodBeat.i(201475);
    rQx = new c((byte)0);
    AppMethodBeat.o(201475);
  }
  
  public m(int paramInt1, int paramInt2, com.tencent.mm.bw.b paramb, arn paramarn, List<? extends FinderObject> paramList)
  {
    AppMethodBeat.i(201474);
    this.dvm = paramInt1;
    this.pullType = paramInt2;
    this.lastBuffer = paramb;
    this.rQw = paramarn;
    this.rPN = paramList;
    this.rQt = new ConcurrentLinkedQueue();
    paramb = com.tencent.mm.plugin.finder.report.f.syc;
    com.tencent.mm.plugin.finder.report.f.a(this.dvm, this.pullType, this.rQw);
    this.rQu = new e();
    this.rQv = new j(this);
    AppMethodBeat.o(201474);
  }
  
  private final f a(asi paramasi)
  {
    AppMethodBeat.i(201473);
    f localf = new f();
    localf.a(this.rQu);
    localf.GJo = paramasi.GJo;
    localf.GJn = paramasi.GJn;
    localf.object.addAll((Collection)paramasi.object);
    localf.liveObjects.addAll((Collection)paramasi.liveObjects);
    localf.sjJ = paramasi.sjJ;
    localf.GJp = paramasi.GJp;
    localf.GJq = paramasi.GJq;
    localf.preloadInfo = paramasi.preloadInfo;
    localf.GJt = paramasi.GJt;
    localf.GJr = paramasi.GJr;
    localf.GJv = paramasi.GJv;
    localf.GJs = paramasi.GJs;
    localf.GJu = paramasi.GJu;
    localf.lastBuffer = paramasi.lastBuffer;
    localf.rQD = paramasi.object.size();
    localf.GJw = paramasi.GJw;
    localf.rRJ = paramasi.rRJ;
    localf.GJx = paramasi.GJx;
    localf.sjP = paramasi.sjP;
    AppMethodBeat.o(201473);
    return localf;
  }
  
  private final void a(int paramInt1, int paramInt2, String paramString, f paramf)
  {
    AppMethodBeat.i(201470);
    ae.i("Finder.FinderStream", "onCgiBack tabType=" + this.dvm + " pullType:" + this.pullType);
    Object localObject1 = com.tencent.mm.plugin.finder.preload.a.stE;
    localObject1 = paramf.preloadInfo;
    Object localObject2 = paramf.object;
    p.g(localObject2, "resp.`object`");
    com.tencent.mm.plugin.finder.preload.a.a((arc)localObject1, (List)localObject2, 3901);
    localObject2 = (Iterable)j.a((Iterable)((m)this).rQt, (Comparator)new a());
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add((com.tencent.mm.plugin.finder.cgi.interceptor.f)((g)((Iterator)localObject2).next()).rTp);
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((com.tencent.mm.plugin.finder.cgi.interceptor.f)((Iterator)localObject1).next()).a(paramf);
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      localObject1 = com.tencent.mm.plugin.finder.report.f.syc;
      com.tencent.mm.plugin.finder.report.f.Fo(this.dvm);
    }
    localObject1 = this.rQr;
    if (localObject1 == null) {
      p.bdF("callback");
    }
    Object localObject3 = (Iterable)j.a((Iterable)this.rQt, (Comparator)new g());
    localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((Collection)localObject2).add((com.tencent.mm.plugin.finder.cgi.interceptor.f)((g)((Iterator)localObject3).next()).rTp);
    }
    ((b)localObject1).a(paramInt1, paramInt2, paramString, paramf, j.l((Iterable)localObject2));
    AppMethodBeat.o(201470);
  }
  
  public final m a(com.tencent.mm.plugin.finder.cgi.interceptor.f paramf, int paramInt)
  {
    AppMethodBeat.i(201469);
    p.h(paramf, "interceptor");
    this.rQt.add(new g(paramf, paramInt));
    AppMethodBeat.o(201469);
    return this;
  }
  
  public final void a(com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> paramc, b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(201471);
    p.h(paramb, "callback");
    Object localObject = com.tencent.mm.plugin.finder.report.f.syc;
    com.tencent.mm.plugin.finder.report.f.ah(this.dvm, true);
    this.kqo = paramBoolean;
    this.rQr = paramb;
    localObject = paramc;
    if (paramc == null) {
      localObject = new com.tencent.mm.vending.e.c();
    }
    this.rQs = ((com.tencent.mm.vending.e.c)localObject);
    this.rQu.rQC = paramb.czx();
    if (this.rQu.rQC)
    {
      paramc = com.tencent.mm.plugin.finder.report.f.syc;
      com.tencent.mm.plugin.finder.report.f.aj(this.dvm, true);
      paramc = new d(null, this.lastBuffer).aET();
      paramb = this.rQs;
      if (paramb == null) {
        p.bdF("lifeCycleKeeper");
      }
      paramc.a((com.tencent.mm.vending.e.b)paramb);
      AppMethodBeat.o(201471);
      return;
    }
    paramc = com.tencent.mm.ui.component.a.KEX;
    paramc = ((FinderStreamTabPreloadCore)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderStreamTabPreloadCore.class)).EV(this.dvm);
    if ((this.pullType != 1) && (this.pullType != 0)) {}
    for (int i = 1; (paramBoolean) || (i != 0); i = 0)
    {
      if ((i != 0) && (paramc != null)) {
        paramc.lX(true);
      }
      paramb.a((ash)this.rQu);
      paramc = com.tencent.mm.plugin.finder.report.f.syc;
      com.tencent.mm.plugin.finder.report.f.ai(this.dvm, true);
      this.rQv.aET();
      AppMethodBeat.o(201471);
      return;
    }
    if (paramc != null)
    {
      localObject = paramc.EZ(this.pullType);
      if (localObject != null)
      {
        paramc = MediaPreloadCore.stL;
        if (MediaPreloadCore.cEO()) {
          com.tencent.mm.ac.c.h((d.g.a.a)new h(this));
        }
        ae.i("Finder.FinderStream", "[run] use preload cache. tabType=" + this.dvm + ' ');
        paramc = com.tencent.mm.plugin.finder.report.f.syc;
        paramc = com.tencent.mm.plugin.finder.report.f.Fe(this.dvm);
        if (paramc != null)
        {
          if ((!paramc.Zn) || (paramc.syd)) {
            break label393;
          }
          i = 1;
          if (i == 0) {
            break label399;
          }
        }
        for (;;)
        {
          if (paramc != null) {
            paramc.syC = 1;
          }
          a(0, 0, null, (f)localObject);
          AppMethodBeat.o(201471);
          return;
          label393:
          i = 0;
          break;
          label399:
          paramc = null;
        }
      }
    }
    paramc = (m)this;
    paramb.a((ash)paramc.rQu);
    paramb = com.tencent.mm.plugin.finder.report.f.syc;
    com.tencent.mm.plugin.finder.report.f.ai(paramc.dvm, true);
    paramc.rQv.aET();
    AppMethodBeat.o(201471);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class a<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(201459);
      int i = d.b.a.a((Comparable)Integer.valueOf(((g)paramT1).order), (Comparable)Integer.valueOf(((g)paramT2).order));
      AppMethodBeat.o(201459);
      return i;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$Callback;", "", "isBeginHistory", "", "isResultConsume", "errType", "", "errCode", "resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "onBuildRequest", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderStreamRequest;", "onCgiBack", "errMsg", "", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "interceptors", "", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, m.f paramf, List<? extends com.tencent.mm.plugin.finder.cgi.interceptor.f> paramList);
    
    public abstract void a(ash paramash);
    
    public abstract boolean a(cwj paramcwj);
    
    public abstract boolean czx();
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class c {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamHistoryCgi;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetHistoryResponse;", "streamResp", "Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream;Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;Lcom/tencent/mm/protobuf/ByteString;)V", "isFetchFeedCgi", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
  public final class d
    extends w<aoi>
  {
    private asi rQy;
    
    public d(com.tencent.mm.bw.b paramb)
    {
      AppMethodBeat.i(201461);
      this.rQy = paramb;
      paramb = new b.a();
      aoh localaoh = new aoh();
      m.e(m.this).rQA = localaoh;
      localaoh.GDP = com.tencent.mm.model.v.aAK();
      localaoh.dvm = m.a(m.this);
      Object localObject;
      localaoh.GFN = localObject;
      StringBuilder localStringBuilder = new StringBuilder("[request#historyCgi] isPreload=").append(m.c(m.this)).append(" tabType=").append(m.a(m.this)).append(" pullType=").append(m.d(m.this)).append(" lastBuffer=");
      if (localObject == null) {}
      for (this$1 = "null";; this$1 = aj.B(localObject.getBytes()))
      {
        ae.i("Finder.FinderStream", m.this);
        this$1 = v.rRb;
        localaoh.GDR = v.a(this.rQw);
        paramb.c((com.tencent.mm.bw.a)localaoh);
        this$1 = new aoi();
        m.this.setBaseResponse(new BaseResponse());
        m.this.getBaseResponse().ErrMsg = new cxn();
        paramb.d((com.tencent.mm.bw.a)m.this);
        paramb.DN("/cgi-bin/micromsg-bin/findergethistory");
        paramb.oS(3814);
        c(paramb.aDS());
        AppMethodBeat.o(201461);
        return;
      }
    }
    
    public final boolean czv()
    {
      return true;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamRequestEx;", "Lcom/tencent/mm/protocal/protobuf/FinderStreamRequest;", "()V", "extInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowEntranceExtInfo;", "getExtInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTipsShowEntranceExtInfo;", "setExtInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderTipsShowEntranceExtInfo;)V", "historyRequest", "Lcom/tencent/mm/protocal/protobuf/FinderGetHistoryRequest;", "getHistoryRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderGetHistoryRequest;", "setHistoryRequest", "(Lcom/tencent/mm/protocal/protobuf/FinderGetHistoryRequest;)V", "isBeginHistory", "", "()Z", "setBeginHistory", "(Z)V", "plugin-finder_release"})
  public static final class e
    extends ash
  {
    aoh rQA;
    public ass rQB;
    boolean rQC;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;", "()V", "afterFeedIdHistory", "", "getAfterFeedIdHistory", "()J", "setAfterFeedIdHistory", "(J)V", "continueFlag", "", "getContinueFlag", "()I", "setContinueFlag", "(I)V", "historySize", "getHistorySize", "setHistorySize", "isFetchHistory", "", "()Z", "setFetchHistory", "(Z)V", "requestEx", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamRequestEx;", "getRequestEx", "()Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamRequestEx;", "setRequestEx", "(Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamRequestEx;)V", "streamSize", "getStreamSize", "setStreamSize", "plugin-finder_release"})
  public static final class f
    extends asi
  {
    public int continueFlag = 1;
    public int rQD;
    public long rQE = -1L;
    public int rQF = -1;
    public boolean rQG;
    public m.e rQH;
    
    public final void a(m.e parame)
    {
      AppMethodBeat.i(201463);
      p.h(parame, "<set-?>");
      this.rQH = parame;
      AppMethodBeat.o(201463);
    }
    
    public final m.e czy()
    {
      AppMethodBeat.i(201462);
      m.e locale = this.rQH;
      if (locale == null) {
        p.bdF("requestEx");
      }
      AppMethodBeat.o(201462);
      return locale;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class g<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(201464);
      int i = d.b.a.a((Comparable)Integer.valueOf(((g)paramT1).order), (Comparable)Integer.valueOf(((g)paramT2).order));
      AppMethodBeat.o(201464);
      return i;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/cgi/CgiFinderStream$run$1$1"})
  static final class h
    extends q
    implements d.g.a.a<z>
  {
    h(m paramm)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class i
    extends q
    implements d.g.a.a<z>
  {
    i(String paramString)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/cgi/CgiFinderStream$streamCgi$1", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;", "isFetchFeedCgi", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
  public static final class j
    extends w<asi>
  {
    j()
    {
      AppMethodBeat.i(201468);
      m.a(localm, (ash)m.e(localm));
      m.b(localm, (ash)m.e(localm));
      m.a(localm, m.e(localm));
      m.c(localm, (ash)m.e(localm));
      m.d(localm, (ash)m.e(localm));
      Object localObject1 = new b.a();
      ((b.a)localObject1).c((com.tencent.mm.bw.a)m.e(localm));
      ((b.a)localObject1).d((com.tencent.mm.bw.a)m.czw());
      ((b.a)localObject1).DN("/cgi-bin/micromsg-bin/finderstream");
      ((b.a)localObject1).oS(3901);
      com.tencent.mm.ak.b localb = ((b.a)localObject1).aDS();
      StringBuilder localStringBuilder = new StringBuilder("[CgiFetchFinderTimeline#init] tabType=").append(m.a(localm)).append(" pullType=").append(m.d(localm)).append(" lastBuffer=");
      localObject1 = m.e(localm).lastBuffer;
      if (localObject1 != null)
      {
        localObject1 = Integer.valueOf(((com.tencent.mm.bw.b)localObject1).size());
        localStringBuilder = localStringBuilder.append(localObject1).append(", ");
        if (m.e(localm).lastBuffer != null) {
          break label258;
        }
      }
      for (localObject1 = "null";; localObject1 = aj.B((byte[])localObject1))
      {
        ae.i("Finder.FinderStream", (String)localObject1 + " longitude=" + m.e(localm).dBu + " latitude=" + m.e(localm).dzE);
        c(localb);
        AppMethodBeat.o(201468);
        return;
        localObject1 = null;
        break;
        label258:
        com.tencent.mm.bw.b localb1 = m.e(localm).lastBuffer;
        localObject1 = localObject2;
        if (localb1 != null) {
          localObject1 = localb1.getBytes();
        }
      }
    }
    
    public final boolean czv()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.m
 * JD-Core Version:    0.7.0.1
 */