package com.tencent.mm.plugin.finder.cgi;

import android.arch.lifecycle.ViewModelProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.preload.tabPreload.FinderStreamTabPreloadCore;
import com.tencent.mm.plugin.finder.report.e.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.anu;
import com.tencent.mm.protocal.protobuf.anv;
import com.tencent.mm.protocal.protobuf.aqn;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.ars;
import com.tencent.mm.protocal.protobuf.art;
import com.tencent.mm.protocal.protobuf.asd;
import com.tencent.mm.protocal.protobuf.cvp;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream;", "", "tabType", "", "pullType", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "unreadList", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "(IILcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Ljava/util/List;)V", "callback", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$Callback;", "interceptors", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$OrderInterceptor;", "isPreload", "", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "request", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamRequestEx;", "streamCgi", "com/tencent/mm/plugin/finder/cgi/CgiFinderStream$streamCgi$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$streamCgi$1;", "addInterceptor", "interceptor", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "order", "buildBaseRequest", "", "Lcom/tencent/mm/protocal/protobuf/FinderStreamRequest;", "buildPartialExposeRequest", "buildRedDotRequest", "buildResponse", "Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;", "buildStatsRequest", "buildUnreadRequest", "createFinderStreamResponseEx", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "it", "mergeResp", "streamResponse", "historyResponse", "Lcom/tencent/mm/protocal/protobuf/FinderGetHistoryResponse;", "onCgiBack", "errType", "errCode", "errMsg", "", "resp", "removeInterceptor", "run", "showErrorToast", "tip", "Callback", "Companion", "FinderStreamHistoryCgi", "FinderStreamRequestEx", "FinderStreamResponseEx", "OrderInterceptor", "plugin-finder_release"})
public final class m
{
  public static final c rIm;
  private final int duh;
  private boolean kmY;
  private final com.tencent.mm.bx.b lastBuffer;
  private final int pullType;
  private final List<FinderObject> rHC;
  private b rIg;
  private com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> rIh;
  private final ConcurrentLinkedQueue<g> rIi;
  private final e rIj;
  private final k rIk;
  private final aqy rIl;
  
  static
  {
    AppMethodBeat.i(201057);
    rIm = new c((byte)0);
    AppMethodBeat.o(201057);
  }
  
  public m(int paramInt1, int paramInt2, com.tencent.mm.bx.b paramb, aqy paramaqy, List<? extends FinderObject> paramList)
  {
    AppMethodBeat.i(201056);
    this.duh = paramInt1;
    this.pullType = paramInt2;
    this.lastBuffer = paramb;
    this.rIl = paramaqy;
    this.rHC = paramList;
    this.rIi = new ConcurrentLinkedQueue();
    paramb = com.tencent.mm.plugin.finder.report.e.snY;
    com.tencent.mm.plugin.finder.report.e.b(this.duh, this.pullType, this.rIl);
    this.rIj = new e();
    this.rIk = new k(this);
    AppMethodBeat.o(201056);
  }
  
  private final f a(art paramart)
  {
    AppMethodBeat.i(201055);
    f localf = new f();
    localf.a(this.rIj);
    localf.GpS = paramart.GpS;
    localf.GpR = paramart.GpR;
    localf.object.addAll((Collection)paramart.object);
    localf.GpY.addAll((Collection)paramart.GpY);
    localf.saT = paramart.saT;
    localf.GpT = paramart.GpT;
    localf.GpU = paramart.GpU;
    localf.saW = paramart.saW;
    localf.GpX = paramart.GpX;
    localf.GpV = paramart.GpV;
    localf.Gqa = paramart.Gqa;
    localf.GpW = paramart.GpW;
    localf.GpZ = paramart.GpZ;
    localf.lastBuffer = paramart.lastBuffer;
    localf.rIs = paramart.object.size();
    localf.Gqb = paramart.Gqb;
    localf.rJv = paramart.rJv;
    localf.Gqc = paramart.Gqc;
    localf.sba = paramart.sba;
    AppMethodBeat.o(201055);
    return localf;
  }
  
  private final void a(int paramInt1, int paramInt2, String paramString, f paramf)
  {
    AppMethodBeat.i(201052);
    ad.i("Finder.FinderStream", "onCgiBack tabType=" + this.duh + " pullType:" + this.pullType);
    Object localObject1 = com.tencent.mm.plugin.finder.preload.a.skH;
    localObject1 = paramf.saW;
    Object localObject2 = paramf.object;
    p.g(localObject2, "resp.`object`");
    com.tencent.mm.plugin.finder.preload.a.a((aqn)localObject1, (List)localObject2);
    localObject2 = (Iterable)j.a((Iterable)((m)this).rIi, (Comparator)new a());
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((g)((Iterator)localObject2).next()).rIx);
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((com.tencent.mm.plugin.finder.cgi.interceptor.e)((Iterator)localObject1).next()).a(paramf);
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      localObject1 = com.tencent.mm.plugin.finder.report.e.snY;
      com.tencent.mm.plugin.finder.report.e.ES(this.duh);
    }
    localObject1 = this.rIg;
    if (localObject1 == null) {
      p.bcb("callback");
    }
    Object localObject3 = (Iterable)j.a((Iterable)this.rIi, (Comparator)new h());
    localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((Collection)localObject2).add(((g)((Iterator)localObject3).next()).rIx);
    }
    ((b)localObject1).a(paramInt1, paramInt2, paramString, paramf, j.l((Iterable)localObject2));
    AppMethodBeat.o(201052);
  }
  
  public final m a(com.tencent.mm.plugin.finder.cgi.interceptor.e parame, int paramInt)
  {
    AppMethodBeat.i(201051);
    p.h(parame, "interceptor");
    this.rIi.add(new g(parame, paramInt));
    AppMethodBeat.o(201051);
    return this;
  }
  
  public final void a(com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> paramc, b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(201053);
    p.h(paramb, "callback");
    Object localObject = com.tencent.mm.plugin.finder.report.e.snY;
    com.tencent.mm.plugin.finder.report.e.ae(this.duh, true);
    this.kmY = paramBoolean;
    this.rIg = paramb;
    localObject = paramc;
    if (paramc == null) {
      localObject = new com.tencent.mm.vending.e.c();
    }
    this.rIh = ((com.tencent.mm.vending.e.c)localObject);
    this.rIj.rIr = paramb.cxW();
    if (this.rIj.rIr)
    {
      paramc = com.tencent.mm.plugin.finder.report.e.snY;
      com.tencent.mm.plugin.finder.report.e.ag(this.duh, true);
      paramc = new d(null, this.lastBuffer).aED();
      paramb = this.rIh;
      if (paramb == null) {
        p.bcb("lifeCycleKeeper");
      }
      paramc.a((com.tencent.mm.vending.e.b)paramb);
      AppMethodBeat.o(201053);
      return;
    }
    paramc = com.tencent.mm.ui.component.a.KiD;
    paramc = ((FinderStreamTabPreloadCore)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderStreamTabPreloadCore.class)).EQ(this.duh);
    if ((this.pullType != 1) && (this.pullType != 0)) {}
    for (int i = 1; (paramBoolean) || (i != 0); i = 0)
    {
      if ((i != 0) && (paramc != null)) {
        paramc.AB(true);
      }
      paramb.a((ars)this.rIj);
      paramc = com.tencent.mm.plugin.finder.report.e.snY;
      com.tencent.mm.plugin.finder.report.e.af(this.duh, true);
      this.rIk.aED();
      AppMethodBeat.o(201053);
      return;
    }
    if (paramc != null)
    {
      localObject = paramc.Go(this.pullType);
      if (localObject != null)
      {
        paramc = MediaPreloadCore.skO;
        if (MediaPreloadCore.cDb()) {
          com.tencent.mm.ad.c.g((d.g.a.a)new i(this));
        }
        ad.i("Finder.FinderStream", "[run] use preload cache. tabType=" + this.duh + ' ');
        paramc = com.tencent.mm.plugin.finder.report.e.snY;
        paramc = com.tencent.mm.plugin.finder.report.e.EL(this.duh);
        if (paramc != null)
        {
          if ((!paramc.Zn) || (paramc.snZ)) {
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
            paramc.Lkd = 1;
          }
          a(0, 0, null, (f)localObject);
          AppMethodBeat.o(201053);
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
    paramb.a((ars)paramc.rIj);
    paramb = com.tencent.mm.plugin.finder.report.e.snY;
    com.tencent.mm.plugin.finder.report.e.af(paramc.duh, true);
    paramc.rIk.aED();
    AppMethodBeat.o(201053);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class a<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(201037);
      int i = d.b.a.a((Comparable)Integer.valueOf(((m.g)paramT1).order), (Comparable)Integer.valueOf(((m.g)paramT2).order));
      AppMethodBeat.o(201037);
      return i;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$Callback;", "", "isBeginHistory", "", "isResultConsume", "errType", "", "errCode", "resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "onBuildRequest", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderStreamRequest;", "onCgiBack", "errMsg", "", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "interceptors", "", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, m.f paramf, List<? extends com.tencent.mm.plugin.finder.cgi.interceptor.e> paramList);
    
    public abstract void a(ars paramars);
    
    public abstract boolean a(cvp paramcvp);
    
    public abstract boolean cxW();
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class c {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamHistoryCgi;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetHistoryResponse;", "streamResp", "Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream;Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;Lcom/tencent/mm/protobuf/ByteString;)V", "isFetchFeedCgi", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
  public final class d
    extends w<anv>
  {
    private art rIn;
    
    public d(com.tencent.mm.bx.b paramb)
    {
      AppMethodBeat.i(201039);
      this.rIn = paramb;
      paramb = new b.a();
      anu localanu = new anu();
      m.e(m.this).rIp = localanu;
      localanu.Gmz = u.aAu();
      localanu.duh = m.a(m.this);
      Object localObject;
      localanu.GmG = localObject;
      StringBuilder localStringBuilder = new StringBuilder("[request#historyCgi] isPreload=").append(m.c(m.this)).append(" tabType=").append(m.a(m.this)).append(" pullType=").append(m.d(m.this)).append(" lastBuffer=");
      if (localObject == null) {}
      for (this$1 = "null";; this$1 = ai.B(localObject.getBytes()))
      {
        ad.i("Finder.FinderStream", m.this);
        this$1 = v.rIR;
        localanu.Glv = v.a(this.rIl);
        paramb.c((com.tencent.mm.bx.a)localanu);
        this$1 = new anv();
        m.this.setBaseResponse(new BaseResponse());
        m.this.getBaseResponse().ErrMsg = new cwt();
        paramb.d((com.tencent.mm.bx.a)m.this);
        paramb.Dl("/cgi-bin/micromsg-bin/findergethistory");
        paramb.oP(3814);
        c(paramb.aDC());
        AppMethodBeat.o(201039);
        return;
      }
    }
    
    public final boolean cxU()
    {
      return true;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamRequestEx;", "Lcom/tencent/mm/protocal/protobuf/FinderStreamRequest;", "()V", "extInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowEntranceExtInfo;", "getExtInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTipsShowEntranceExtInfo;", "setExtInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderTipsShowEntranceExtInfo;)V", "historyRequest", "Lcom/tencent/mm/protocal/protobuf/FinderGetHistoryRequest;", "getHistoryRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderGetHistoryRequest;", "setHistoryRequest", "(Lcom/tencent/mm/protocal/protobuf/FinderGetHistoryRequest;)V", "isBeginHistory", "", "()Z", "setBeginHistory", "(Z)V", "plugin-finder_release"})
  public static final class e
    extends ars
  {
    anu rIp;
    public asd rIq;
    boolean rIr;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;", "()V", "afterFeedIdHistory", "", "getAfterFeedIdHistory", "()J", "setAfterFeedIdHistory", "(J)V", "continueFlag", "", "getContinueFlag", "()I", "setContinueFlag", "(I)V", "historySize", "getHistorySize", "setHistorySize", "isFetchHistory", "", "()Z", "setFetchHistory", "(Z)V", "requestEx", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamRequestEx;", "getRequestEx", "()Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamRequestEx;", "setRequestEx", "(Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamRequestEx;)V", "streamSize", "getStreamSize", "setStreamSize", "plugin-finder_release"})
  public static final class f
    extends art
  {
    public int continueFlag = 1;
    public int rIs;
    public long rIt = -1L;
    public int rIu = -1;
    public boolean rIv;
    public m.e rIw;
    
    public final void a(m.e parame)
    {
      AppMethodBeat.i(201041);
      p.h(parame, "<set-?>");
      this.rIw = parame;
      AppMethodBeat.o(201041);
    }
    
    public final m.e cxX()
    {
      AppMethodBeat.i(201040);
      m.e locale = this.rIw;
      if (locale == null) {
        p.bcb("requestEx");
      }
      AppMethodBeat.o(201040);
      return locale;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$OrderInterceptor;", "", "interceptor", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "order", "", "(Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;I)V", "getInterceptor", "()Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "getOrder", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
  public static final class g
  {
    final int order;
    final com.tencent.mm.plugin.finder.cgi.interceptor.e rIx;
    
    public g(com.tencent.mm.plugin.finder.cgi.interceptor.e parame, int paramInt)
    {
      AppMethodBeat.i(201044);
      this.rIx = parame;
      this.order = paramInt;
      AppMethodBeat.o(201044);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(201043);
      boolean bool = p.i(this.rIx, paramObject);
      AppMethodBeat.o(201043);
      return bool;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(201042);
      int i = this.rIx.hashCode();
      AppMethodBeat.o(201042);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(201045);
      String str = "OrderInterceptor(interceptor=" + this.rIx + ", order=" + this.order + ")";
      AppMethodBeat.o(201045);
      return str;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class h<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(201046);
      int i = d.b.a.a((Comparable)Integer.valueOf(((m.g)paramT1).order), (Comparable)Integer.valueOf(((m.g)paramT2).order));
      AppMethodBeat.o(201046);
      return i;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/cgi/CgiFinderStream$run$1$1"})
  static final class i
    extends q
    implements d.g.a.a<z>
  {
    i(m paramm)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class j
    extends q
    implements d.g.a.a<z>
  {
    j(String paramString)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/cgi/CgiFinderStream$streamCgi$1", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;", "isFetchFeedCgi", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
  public static final class k
    extends w<art>
  {
    k()
    {
      AppMethodBeat.i(201050);
      m.a(localm, (ars)m.e(localm));
      m.b(localm, (ars)m.e(localm));
      m.a(localm, m.e(localm));
      m.c(localm, (ars)m.e(localm));
      m.d(localm, (ars)m.e(localm));
      Object localObject = new b.a();
      ((b.a)localObject).c((com.tencent.mm.bx.a)m.e(localm));
      ((b.a)localObject).d((com.tencent.mm.bx.a)m.cxV());
      ((b.a)localObject).Dl("/cgi-bin/micromsg-bin/finderstream");
      ((b.a)localObject).oP(3901);
      com.tencent.mm.al.b localb = ((b.a)localObject).aDC();
      StringBuilder localStringBuilder = new StringBuilder("[CgiFetchFinderTimeline#init] tabType=").append(m.a(localm)).append(" pullType=").append(m.d(localm)).append(" lastBuffer=").append(m.e(localm).lastBuffer.size()).append(", ");
      if (m.e(localm).lastBuffer == null)
      {
        localObject = "null";
        ad.i("Finder.FinderStream", (String)localObject + " longitude=" + m.e(localm).dAp + " latitude=" + m.e(localm).dyz);
        c(localb);
        AppMethodBeat.o(201050);
        return;
      }
      localObject = m.e(localm).lastBuffer;
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.bx.b)localObject).getBytes();; localObject = null)
      {
        localObject = ai.B((byte[])localObject);
        break;
      }
    }
    
    public final boolean cxU()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.m
 * JD-Core Version:    0.7.0.1
 */