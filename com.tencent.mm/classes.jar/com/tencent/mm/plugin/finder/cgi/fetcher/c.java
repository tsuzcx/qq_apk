package com.tencent.mm.plugin.finder.cgi.fetcher;

import android.arch.lifecycle.ViewModelProvider;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wt;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.interceptor.f;
import com.tencent.mm.plugin.finder.cgi.m;
import com.tencent.mm.plugin.finder.cgi.m.b;
import com.tencent.mm.plugin.finder.cgi.m.f;
import com.tencent.mm.plugin.finder.cgi.n.a;
import com.tencent.mm.plugin.finder.cgi.n.c;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.feed.model.internal.k.a;
import com.tencent.mm.plugin.finder.feed.model.internal.k.c;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.plugin.finder.preload.tabPreload.FinderStreamTabPreloadCore;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.plugin.finder.view.o;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.asg;
import com.tencent.mm.protocal.protobuf.ash;
import com.tencent.mm.protocal.protobuf.cwj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import d.a.j;
import d.g.b.q;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher;", "Lcom/tencent/mm/plugin/finder/life/SupportLifecycle;", "tabType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "isGetHistory", "", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "getLifeCycleKeeper", "()Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "setLifeCycleKeeper", "(Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;)V", "pageDataBuffer", "Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "getPageDataBuffer", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer;", "getTabType", "()I", "dealSvrInsertWording", "", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "baseFinderFeeds", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "fetch", "callback", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "pullType", "consume", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "isPreloadMore", "unreadList", "fetchHotRelatedList", "feedId", "", "nonceId", "", "isPrefetch", "relatedEntranceInfo", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedEntranceInfo;", "innerFetch", "lb", "interceptAfterStore", "loadedInfo", "interceptors", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "interceptBeforeStore", "uniqueId", "Companion", "plugin-finder_release"})
public final class c
  extends com.tencent.mm.plugin.finder.life.a
{
  public static final a rTb;
  public final int dvm;
  public com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> rQs;
  public final arn rQw;
  private volatile boolean rSI;
  public final k<am, com.tencent.mm.plugin.finder.feed.model.b> rTa;
  
  static
  {
    AppMethodBeat.i(201639);
    rTb = new a((byte)0);
    AppMethodBeat.o(201639);
  }
  
  public c(int paramInt, arn paramarn)
  {
    AppMethodBeat.i(201638);
    this.dvm = paramInt;
    this.rQw = paramarn;
    this.rQs = new com.tencent.mm.vending.e.c();
    this.rTa = new k(null, String.valueOf(this.dvm), 1);
    AppMethodBeat.o(201638);
  }
  
  private final void a(final n.a parama, final int paramInt, final n.c paramc, com.tencent.mm.bw.b paramb, List<? extends BaseFinderFeed> paramList)
  {
    AppMethodBeat.i(201636);
    if ((paramInt == 0) || (paramInt == 1)) {
      this.rSI = false;
    }
    final boolean bool;
    if (paramb == null) {
      bool = true;
    }
    while (bool)
    {
      ae.i("Finder.TimelineFeedFetcher", "[innerFetch] use tabType=" + this.dvm + " GlobalLastBuffer");
      if (paramInt == 0)
      {
        paramb = com.tencent.mm.kernel.g.ajR();
        d.g.b.p.g(paramb, "MMKernel.storage()");
        paramb = paramb.ajA();
        localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
        paramb.set(com.tencent.mm.plugin.finder.utils.p.Gr(this.dvm), null);
      }
      paramb = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(paramb, "MMKernel.storage()");
      paramb = paramb.ajA();
      localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
      paramb = paramb.get(com.tencent.mm.plugin.finder.utils.p.Gr(this.dvm), "");
      if (paramb == null)
      {
        parama = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(201636);
        throw parama;
        bool = false;
      }
      else
      {
        paramb = com.tencent.mm.bw.b.cm(bu.aSx((String)paramb));
      }
    }
    int i = this.dvm;
    Object localObject1 = this.rQw;
    if (paramList != null)
    {
      Object localObject2 = (Iterable)paramList;
      paramList = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        paramList.add(((BaseFinderFeed)((Iterator)localObject2).next()).feedObject.getFeedObject());
      }
    }
    for (paramList = (List)paramList;; paramList = null)
    {
      m.a(new m(i, paramInt, paramb, (arn)localObject1, paramList).a((f)new com.tencent.mm.plugin.finder.cgi.interceptor.a(), 0).a((f)new com.tencent.mm.plugin.finder.cgi.interceptor.c(), 1).a((f)new com.tencent.mm.plugin.finder.cgi.interceptor.b(), 2), this.rQs, (m.b)new g(this, paramc, paramInt, bool, parama));
      AppMethodBeat.o(201636);
      return;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher$fetch$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "pullType", "", "plugin-finder_release"})
  public static final class b
    implements n.a
  {
    b(n.a parama) {}
    
    public final void a(com.tencent.mm.plugin.finder.feed.model.b paramb, int paramInt)
    {
      AppMethodBeat.i(201625);
      d.g.b.p.h(paramb, "info");
      k.c localc = new k.c(new LinkedList((Collection)paramb.sjH));
      localc.iiU = paramb;
      this.rTc.rTa.a(localc);
      paramb.sjO = this.rTc.rTa.cDI();
      this.rSX.a(paramb, paramInt);
      paramb = new wt();
      paramb.dMm.dvm = this.rTc.dvm;
      paramb.dMm.dMn = this.rTc.rTa.length;
      o.a(paramb);
      AppMethodBeat.o(201625);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<z>
  {
    c(c paramc)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher$fetch$4", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "pullType", "", "plugin-finder_release"})
  public static final class d
    implements n.a
  {
    d(n.a parama) {}
    
    public final void a(com.tencent.mm.plugin.finder.feed.model.b paramb, int paramInt)
    {
      AppMethodBeat.i(201627);
      d.g.b.p.h(paramb, "info");
      if (this.rTc.dvm == 4)
      {
        Object localObject = ((Iterable)paramb.sjH).iterator();
        while (((Iterator)localObject).hasNext())
        {
          am localam = (am)((Iterator)localObject).next();
          if ((localam instanceof BaseFinderFeed))
          {
            com.tencent.mm.plugin.finder.storage.data.g localg = com.tencent.mm.plugin.finder.storage.data.g.sKQ;
            com.tencent.mm.plugin.finder.storage.data.g.c(((BaseFinderFeed)localam).feedObject.getId(), ((BaseFinderFeed)localam).feedObject);
          }
        }
        localObject = com.tencent.mm.plugin.finder.storage.data.g.sKQ;
        com.tencent.mm.plugin.finder.storage.data.g.a(c.a(this.rTc), true, "onFetchDone#".concat(String.valueOf(paramInt)));
      }
      this.rSX.a(paramb, paramInt);
      AppMethodBeat.o(201627);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher$fetch$result$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer$Callback;", "request", "", "plugin-finder_release"})
  public static final class e
    implements k.a
  {
    e(int paramInt, n.c paramc, com.tencent.mm.bw.b paramb) {}
    
    public final void cAs()
    {
      AppMethodBeat.i(201629);
      c.a(this.rTc, (n.a)new a(this), this.rSU, this.rSS, this.rTd);
      AppMethodBeat.o(201629);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher$fetch$result$1$request$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "pullType", "", "plugin-finder_release"})
    public static final class a
      implements n.a
    {
      public final void a(com.tencent.mm.plugin.finder.feed.model.b paramb, int paramInt)
      {
        AppMethodBeat.i(201628);
        d.g.b.p.h(paramb, "info");
        k.c localc = new k.c(new LinkedList((Collection)paramb.sjH));
        localc.iiU = paramb;
        this.rTe.rTc.rTa.a(localc);
        paramb = new wt();
        paramb.dMm.dvm = this.rTe.rTc.dvm;
        paramb.dMm.dMn = this.rTe.rTc.rTa.length;
        o.a(paramb);
        AppMethodBeat.o(201628);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListResp;", "kotlin.jvm.PlatformType", "call"})
  public static final class f<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    public f(c paramc, boolean paramBoolean, long paramLong, n.a parama) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher$innerFetch$2", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$Callback;", "isBeginHistory", "", "isResultConsume", "errType", "", "errCode", "resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "onBuildRequest", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderStreamRequest;", "onCgiBack", "errMsg", "", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "interceptors", "", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "plugin-finder_release"})
  public static final class g
    implements m.b
  {
    g(n.c paramc, int paramInt, boolean paramBoolean, n.a parama) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, m.f paramf, List<? extends f> paramList)
    {
      AppMethodBeat.i(201634);
      d.g.b.p.h(paramf, "resp");
      d.g.b.p.h(paramList, "interceptors");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramInt == 0)
        {
          ae.i("Finder.TimelineFeedFetcher", "tabType=" + this.rTc.dvm + " headWording=" + paramf.GJn + " endWording=" + paramf.GJo + " prefetch_last_feed_count=" + paramf.GJr + '}');
          localObject1 = com.tencent.mm.kernel.g.ajR();
          d.g.b.p.g(localObject1, "MMKernel.storage()");
          ((e)localObject1).ajA().set(am.a.Jca, paramf.GJn);
          localObject1 = com.tencent.mm.kernel.g.ajR();
          d.g.b.p.g(localObject1, "MMKernel.storage()");
          ((e)localObject1).ajA().set(am.a.Jcb, paramf.GJo);
          localObject1 = com.tencent.mm.kernel.g.ajR();
          d.g.b.p.g(localObject1, "MMKernel.storage()");
          ((e)localObject1).ajA().set(am.a.Jce, Integer.valueOf(paramf.GJr));
        }
        if (paramf.GJx != null)
        {
          localObject1 = com.tencent.mm.kernel.g.ajR();
          d.g.b.p.g(localObject1, "MMKernel.storage()");
          localObject2 = ((e)localObject1).ajA();
          localObject3 = am.a.Jcc;
          localObject1 = paramf.GJx;
          if (localObject1 == null) {
            break label342;
          }
        }
        label342:
        for (Object localObject1 = ((asg)localObject1).toByteArray();; localObject1 = null)
        {
          ((aj)localObject2).set((am.a)localObject3, bu.cH((byte[])localObject1));
          localObject1 = com.tencent.mm.ui.component.a.KEX;
          ((FinderStreamTabPreloadCore)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderStreamTabPreloadCore.class)).EW(this.rTc.dvm);
          localObject1 = ak.getResources().getString(2131759371);
          localObject2 = com.tencent.mm.kernel.g.ajR();
          d.g.b.p.g(localObject2, "MMKernel.storage()");
          localObject1 = ((e)localObject2).ajA().get(am.a.Jca, localObject1);
          if (localObject1 != null) {
            break;
          }
          paramString = new v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(201634);
          throw paramString;
        }
        localObject1 = (String)localObject1;
        Object localObject2 = ak.getResources().getString(2131759370);
        Object localObject3 = com.tencent.mm.kernel.g.ajR();
        d.g.b.p.g(localObject3, "MMKernel.storage()");
        localObject2 = ((e)localObject3).ajA().get(am.a.Jcb, localObject2);
        if (localObject2 == null)
        {
          paramString = new v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(201634);
          throw paramString;
        }
        localObject2 = (String)localObject2;
        localObject3 = paramf.object;
        d.g.b.p.g(localObject3, "resp.`object`");
        Object localObject4 = (Iterable)localObject3;
        localObject3 = (Collection)new ArrayList();
        localObject4 = ((Iterable)localObject4).iterator();
        Object localObject6;
        Object localObject7;
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = ((Iterator)localObject4).next();
          localObject6 = (FinderObject)localObject5;
          localObject7 = com.tencent.mm.plugin.finder.utils.p.sXz;
          d.g.b.p.g(localObject6, "it");
          if (com.tencent.mm.plugin.finder.utils.p.o((FinderObject)localObject6)) {
            ((Collection)localObject3).add(localObject5);
          }
        }
        localObject4 = (List)localObject3;
        if (((List)localObject4).size() < paramf.object.size()) {
          ae.e("Finder.TimelineFeedFetcher", "[onCgiBack] has filter some feed. valid=" + ((List)localObject4).size() + " raw=" + paramf.object.size());
        }
        if (paramf.GJp > 0) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          localObject3 = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
          localObject3 = com.tencent.mm.plugin.finder.utils.p.sXz;
          localObject5 = (Iterable)b.a.a((List)localObject4, com.tencent.mm.plugin.finder.utils.p.Gs(this.rTc.dvm), c.a(this.rTc), 4);
          localObject3 = (Collection)new ArrayList(j.a((Iterable)localObject5, 10));
          localObject5 = ((Iterable)localObject5).iterator();
          while (((Iterator)localObject5).hasNext())
          {
            localObject6 = (FinderItem)((Iterator)localObject5).next();
            localObject7 = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
            ((Collection)localObject3).add(b.a.j((FinderItem)localObject6));
          }
        }
        Object localObject5 = new LinkedList((Collection)localObject3);
        localObject3 = new com.tencent.mm.plugin.finder.feed.model.b((List)localObject5, paramInt1, paramInt2, paramString);
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject3).dvm = this.rTc.dvm;
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject3).rQD = paramf.rQD;
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject3).rQF = paramf.rQF;
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject3).rQE = paramf.rQE;
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject3).pullType = paramInt;
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject3).sjQ = ((String)localObject1);
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject3).sjR = ((String)localObject2);
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject3).sjK = paramf.continueFlag;
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject3).sjI = ((List)localObject4);
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject3).sjL = paramf.rQG;
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject3).rSI = c.b(this.rTc);
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject3).lastBuffer = paramf.lastBuffer;
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject3).preloadInfo = paramf.preloadInfo;
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject3).sjN = paramf.GJv;
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject3).sjJ = paramf.sjJ;
        if (paramf.GJp != 0) {}
        for (boolean bool2 = true;; bool2 = false)
        {
          ((com.tencent.mm.plugin.finder.feed.model.b)localObject3).isNeedClear = bool2;
          ((com.tencent.mm.plugin.finder.feed.model.b)localObject3).sjP = paramf.sjP;
          c.a((com.tencent.mm.plugin.finder.feed.model.b)localObject3, paramList);
          if (paramInt != 2)
          {
            paramString = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
            paramString = (List)localObject5;
            localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
            b.a.b(paramString, com.tencent.mm.plugin.finder.utils.p.Gs(this.rTc.dvm), bool1);
          }
          c.b((com.tencent.mm.plugin.finder.feed.model.b)localObject3, paramList);
          if ((paramInt == 0) || (paramInt == 1))
          {
            paramString = y.stw;
            y.h(this.rTc.dvm, (List)localObject4);
          }
          if (bool)
          {
            paramString = com.tencent.mm.kernel.g.ajR();
            d.g.b.p.g(paramString, "MMKernel.storage()");
            paramList = paramString.ajA();
            paramString = com.tencent.mm.plugin.finder.utils.p.sXz;
            localObject1 = com.tencent.mm.plugin.finder.utils.p.Gr(this.rTc.dvm);
            if (paramf.lastBuffer != null) {
              break;
            }
            paramString = null;
            paramList.set((am.a)localObject1, paramString);
          }
          c.a(this.rTc, paramf.rQG);
          parama.a((com.tencent.mm.plugin.finder.feed.model.b)localObject3, paramInt);
          AppMethodBeat.o(201634);
          return;
        }
        paramString = paramf.lastBuffer;
        if (paramString != null) {}
        for (paramString = paramString.toByteArray();; paramString = null)
        {
          paramString = bu.cH(paramString);
          break;
        }
      }
      paramString = new com.tencent.mm.plugin.finder.feed.model.b((List)new LinkedList(), paramInt1, paramInt2, paramString);
      paramString.dvm = this.rTc.dvm;
      paramString.pullType = paramInt;
      paramString.sjK = 1;
      paramString.sjL = paramf.rQG;
      paramString.lastBuffer = paramf.lastBuffer;
      parama.a(paramString, paramInt);
      AppMethodBeat.o(201634);
    }
    
    public final void a(ash paramash)
    {
      AppMethodBeat.i(201633);
      d.g.b.p.h(paramash, "request");
      AppMethodBeat.o(201633);
    }
    
    public final boolean a(cwj paramcwj)
    {
      AppMethodBeat.i(201632);
      d.g.b.p.h(paramcwj, "resp");
      n.c localc = paramc;
      if (localc != null)
      {
        boolean bool = localc.b(paramcwj);
        AppMethodBeat.o(201632);
        return bool;
      }
      AppMethodBeat.o(201632);
      return false;
    }
    
    public final boolean czx()
    {
      AppMethodBeat.i(201631);
      boolean bool = c.b(this.rTc);
      AppMethodBeat.o(201631);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.fetcher.c
 * JD-Core Version:    0.7.0.1
 */