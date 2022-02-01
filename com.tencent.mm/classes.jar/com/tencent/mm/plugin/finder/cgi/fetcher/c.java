package com.tencent.mm.plugin.finder.cgi.fetcher;

import android.arch.lifecycle.ViewModelProvider;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wp;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.m;
import com.tencent.mm.plugin.finder.cgi.m.b;
import com.tencent.mm.plugin.finder.cgi.m.f;
import com.tencent.mm.plugin.finder.cgi.n.a;
import com.tencent.mm.plugin.finder.cgi.n.c;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.feed.model.internal.k.a;
import com.tencent.mm.plugin.finder.feed.model.internal.k.c;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.model.x;
import com.tencent.mm.plugin.finder.preload.tabPreload.FinderStreamTabPreloadCore;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.plugin.finder.view.n;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.arr;
import com.tencent.mm.protocal.protobuf.ars;
import com.tencent.mm.protocal.protobuf.cvp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher;", "Lcom/tencent/mm/plugin/finder/life/SupportLifecycle;", "tabType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "isGetHistory", "", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "getLifeCycleKeeper", "()Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "setLifeCycleKeeper", "(Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;)V", "pageDataBuffer", "Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "getPageDataBuffer", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer;", "getTabType", "()I", "dealSvrInsertWording", "", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "baseFinderFeeds", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "fetch", "callback", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "pullType", "consume", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "isPreloadMore", "unreadList", "fetchHotRelatedList", "feedId", "", "nonceId", "", "isPrefetch", "relatedEntranceInfo", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedEntranceInfo;", "innerFetch", "lb", "interceptAfterStore", "loadedInfo", "interceptors", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "interceptBeforeStore", "uniqueId", "Companion", "plugin-finder_release"})
public final class c
  extends com.tencent.mm.plugin.finder.life.a
{
  public static final a rKP;
  public final int duh;
  public com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> rIh;
  public final aqy rIl;
  public final k<al, com.tencent.mm.plugin.finder.feed.model.b> rKO;
  private volatile boolean rKw;
  
  static
  {
    AppMethodBeat.i(201215);
    rKP = new a((byte)0);
    AppMethodBeat.o(201215);
  }
  
  public c(int paramInt, aqy paramaqy)
  {
    AppMethodBeat.i(201214);
    this.duh = paramInt;
    this.rIl = paramaqy;
    this.rIh = new com.tencent.mm.vending.e.c();
    this.rKO = new k(null, String.valueOf(this.duh), 1);
    AppMethodBeat.o(201214);
  }
  
  private final void a(final n.a parama, final int paramInt, final n.c paramc, com.tencent.mm.bx.b paramb, List<? extends BaseFinderFeed> paramList)
  {
    AppMethodBeat.i(201212);
    if ((paramInt == 0) || (paramInt == 1)) {
      this.rKw = false;
    }
    final boolean bool;
    if (paramb == null) {
      bool = true;
    }
    while (bool)
    {
      ad.i("Finder.TimelineFeedFetcher", "[innerFetch] use tabType=" + this.duh + " GlobalLastBuffer");
      if (paramInt == 0)
      {
        paramb = com.tencent.mm.kernel.g.ajC();
        d.g.b.p.g(paramb, "MMKernel.storage()");
        paramb = paramb.ajl();
        localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
        paramb.set(com.tencent.mm.plugin.finder.utils.p.FS(this.duh), null);
      }
      paramb = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(paramb, "MMKernel.storage()");
      paramb = paramb.ajl();
      localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
      paramb = paramb.get(com.tencent.mm.plugin.finder.utils.p.FS(this.duh), "");
      if (paramb == null)
      {
        parama = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(201212);
        throw parama;
        bool = false;
      }
      else
      {
        paramb = com.tencent.mm.bx.b.cj(bt.aRa((String)paramb));
      }
    }
    int i = this.duh;
    Object localObject1 = this.rIl;
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
      m.a(new m(i, paramInt, paramb, (aqy)localObject1, paramList).a((com.tencent.mm.plugin.finder.cgi.interceptor.e)new com.tencent.mm.plugin.finder.cgi.interceptor.a(), 0).a((com.tencent.mm.plugin.finder.cgi.interceptor.e)new com.tencent.mm.plugin.finder.cgi.interceptor.c(), 1).a((com.tencent.mm.plugin.finder.cgi.interceptor.e)new com.tencent.mm.plugin.finder.cgi.interceptor.b(), 2), this.rIh, (m.b)new g(this, paramc, paramInt, bool, parama));
      AppMethodBeat.o(201212);
      return;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher$fetch$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "pullType", "", "plugin-finder_release"})
  public static final class b
    implements n.a
  {
    b(n.a parama) {}
    
    public final void a(com.tencent.mm.plugin.finder.feed.model.b paramb, int paramInt)
    {
      AppMethodBeat.i(201201);
      d.g.b.p.h(paramb, "info");
      k.c localc = new k.c(new LinkedList((Collection)paramb.saR));
      localc.igb = paramb;
      this.rKQ.rKO.a(localc);
      paramb.saZ = this.rKQ.rKO.cBW();
      this.rKL.a(paramb, paramInt);
      paramb = new wp();
      paramb.dKX.duh = this.rKQ.duh;
      paramb.dKX.dKY = this.rKQ.rKO.length;
      n.a(paramb);
      AppMethodBeat.o(201201);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<z>
  {
    c(c paramc)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher$fetch$4", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "pullType", "", "plugin-finder_release"})
  public static final class d
    implements n.a
  {
    d(n.a parama) {}
    
    public final void a(com.tencent.mm.plugin.finder.feed.model.b paramb, int paramInt)
    {
      AppMethodBeat.i(201203);
      d.g.b.p.h(paramb, "info");
      if (this.rKQ.duh == 4)
      {
        Object localObject = ((Iterable)paramb.saR).iterator();
        while (((Iterator)localObject).hasNext())
        {
          al localal = (al)((Iterator)localObject).next();
          if ((localal instanceof BaseFinderFeed))
          {
            com.tencent.mm.plugin.finder.storage.data.g localg = com.tencent.mm.plugin.finder.storage.data.g.szT;
            com.tencent.mm.plugin.finder.storage.data.g.c(((BaseFinderFeed)localal).feedObject.getId(), ((BaseFinderFeed)localal).feedObject);
          }
        }
        localObject = com.tencent.mm.plugin.finder.storage.data.g.szT;
        com.tencent.mm.plugin.finder.storage.data.g.a(c.a(this.rKQ), true, "onFetchDone#".concat(String.valueOf(paramInt)));
      }
      this.rKL.a(paramb, paramInt);
      AppMethodBeat.o(201203);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher$fetch$result$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer$Callback;", "request", "", "plugin-finder_release"})
  public static final class e
    implements k.a
  {
    e(int paramInt, n.c paramc, com.tencent.mm.bx.b paramb) {}
    
    public final void cyR()
    {
      AppMethodBeat.i(201205);
      c.a(this.rKQ, (n.a)new a(this), this.rKI, this.rKG, this.rKR);
      AppMethodBeat.o(201205);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher$fetch$result$1$request$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "pullType", "", "plugin-finder_release"})
    public static final class a
      implements n.a
    {
      public final void a(com.tencent.mm.plugin.finder.feed.model.b paramb, int paramInt)
      {
        AppMethodBeat.i(201204);
        d.g.b.p.h(paramb, "info");
        k.c localc = new k.c(new LinkedList((Collection)paramb.saR));
        localc.igb = paramb;
        this.rKS.rKQ.rKO.a(localc);
        paramb = new wp();
        paramb.dKX.duh = this.rKS.rKQ.duh;
        paramb.dKX.dKY = this.rKS.rKQ.rKO.length;
        n.a(paramb);
        AppMethodBeat.o(201204);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListResp;", "kotlin.jvm.PlatformType", "call"})
  public static final class f<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    public f(c paramc, boolean paramBoolean, long paramLong, n.a parama) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher$innerFetch$2", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$Callback;", "isBeginHistory", "", "isResultConsume", "errType", "", "errCode", "resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "onBuildRequest", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderStreamRequest;", "onCgiBack", "errMsg", "", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "interceptors", "", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "plugin-finder_release"})
  public static final class g
    implements m.b
  {
    g(n.c paramc, int paramInt, boolean paramBoolean, n.a parama) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, m.f paramf, List<? extends com.tencent.mm.plugin.finder.cgi.interceptor.e> paramList)
    {
      AppMethodBeat.i(201210);
      d.g.b.p.h(paramf, "resp");
      d.g.b.p.h(paramList, "interceptors");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramInt == 0)
        {
          ad.i("Finder.TimelineFeedFetcher", "tabType=" + this.rKQ.duh + " headWording=" + paramf.GpR + " endWording=" + paramf.GpS + " prefetch_last_feed_count=" + paramf.GpV + '}');
          localObject1 = com.tencent.mm.kernel.g.ajC();
          d.g.b.p.g(localObject1, "MMKernel.storage()");
          ((com.tencent.mm.kernel.e)localObject1).ajl().set(al.a.IHx, paramf.GpR);
          localObject1 = com.tencent.mm.kernel.g.ajC();
          d.g.b.p.g(localObject1, "MMKernel.storage()");
          ((com.tencent.mm.kernel.e)localObject1).ajl().set(al.a.IHy, paramf.GpS);
          localObject1 = com.tencent.mm.kernel.g.ajC();
          d.g.b.p.g(localObject1, "MMKernel.storage()");
          ((com.tencent.mm.kernel.e)localObject1).ajl().set(al.a.IHB, Integer.valueOf(paramf.GpV));
        }
        if (paramf.Gqc != null)
        {
          localObject1 = com.tencent.mm.kernel.g.ajC();
          d.g.b.p.g(localObject1, "MMKernel.storage()");
          ((com.tencent.mm.kernel.e)localObject1).ajl().set(al.a.IHz, bt.cE(paramf.Gqc.toByteArray()));
          localObject1 = com.tencent.mm.ui.component.a.KiD;
          ((FinderStreamTabPreloadCore)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderStreamTabPreloadCore.class)).Gm(this.rKQ.duh);
        }
        Object localObject1 = aj.getResources().getString(2131759371);
        Object localObject2 = com.tencent.mm.kernel.g.ajC();
        d.g.b.p.g(localObject2, "MMKernel.storage()");
        localObject1 = ((com.tencent.mm.kernel.e)localObject2).ajl().get(al.a.IHx, localObject1);
        if (localObject1 == null)
        {
          paramString = new v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(201210);
          throw paramString;
        }
        localObject1 = (String)localObject1;
        localObject2 = aj.getResources().getString(2131759370);
        Object localObject3 = com.tencent.mm.kernel.g.ajC();
        d.g.b.p.g(localObject3, "MMKernel.storage()");
        localObject2 = ((com.tencent.mm.kernel.e)localObject3).ajl().get(al.a.IHy, localObject2);
        if (localObject2 == null)
        {
          paramString = new v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(201210);
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
          localObject7 = com.tencent.mm.plugin.finder.utils.p.sMo;
          d.g.b.p.g(localObject6, "it");
          if (com.tencent.mm.plugin.finder.utils.p.o((FinderObject)localObject6)) {
            ((Collection)localObject3).add(localObject5);
          }
        }
        localObject3 = (List)localObject3;
        if (((List)localObject3).size() < paramf.object.size()) {
          ad.e("Finder.TimelineFeedFetcher", "[onCgiBack] has filter some feed. valid=" + ((List)localObject3).size() + " raw=" + paramf.object.size());
        }
        if (paramf.GpT > 0) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          localObject4 = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
          localObject4 = com.tencent.mm.plugin.finder.utils.p.sMo;
          localObject5 = (Iterable)b.a.a((List)localObject3, com.tencent.mm.plugin.finder.utils.p.FT(this.rKQ.duh), c.a(this.rKQ), 4);
          localObject4 = (Collection)new ArrayList(j.a((Iterable)localObject5, 10));
          localObject5 = ((Iterable)localObject5).iterator();
          while (((Iterator)localObject5).hasNext())
          {
            localObject6 = (FinderItem)((Iterator)localObject5).next();
            localObject7 = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
            ((Collection)localObject4).add(b.a.j((FinderItem)localObject6));
          }
        }
        Object localObject5 = new LinkedList((Collection)localObject4);
        localObject4 = new com.tencent.mm.plugin.finder.feed.model.b((List)localObject5, paramInt1, paramInt2, paramString);
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject4).duh = this.rKQ.duh;
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject4).rIs = paramf.rIs;
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject4).rIu = paramf.rIu;
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject4).rIt = paramf.rIt;
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject4).pullType = paramInt;
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject4).sbb = ((String)localObject1);
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject4).sbc = ((String)localObject2);
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject4).saU = paramf.continueFlag;
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject4).saS = ((List)localObject3);
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject4).saV = paramf.rIv;
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject4).rKw = c.b(this.rKQ);
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject4).lastBuffer = paramf.lastBuffer;
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject4).saW = paramf.saW;
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject4).saY = paramf.Gqa;
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject4).saT = paramf.saT;
        boolean bool2;
        if (paramf.GpT != 0)
        {
          bool2 = true;
          ((com.tencent.mm.plugin.finder.feed.model.b)localObject4).isNeedClear = bool2;
          ((com.tencent.mm.plugin.finder.feed.model.b)localObject4).sba = paramf.sba;
          c.a((com.tencent.mm.plugin.finder.feed.model.b)localObject4, paramList);
          if (paramInt != 2)
          {
            paramString = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
            paramString = (List)localObject5;
            localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
            b.a.b(paramString, com.tencent.mm.plugin.finder.utils.p.FT(this.rKQ.duh), bool1);
          }
          c.b((com.tencent.mm.plugin.finder.feed.model.b)localObject4, paramList);
          if ((paramInt == 0) || (paramInt == 1))
          {
            paramString = x.skz;
            x.h(this.rKQ.duh, (List)localObject3);
          }
          if (bool)
          {
            paramString = com.tencent.mm.kernel.g.ajC();
            d.g.b.p.g(paramString, "MMKernel.storage()");
            paramList = paramString.ajl();
            paramString = com.tencent.mm.plugin.finder.utils.p.sMo;
            localObject1 = com.tencent.mm.plugin.finder.utils.p.FS(this.rKQ.duh);
            if (paramf.lastBuffer != null) {
              break label1078;
            }
          }
        }
        label1078:
        for (paramString = null;; paramString = bt.cE(paramf.lastBuffer.toByteArray()))
        {
          paramList.set((al.a)localObject1, paramString);
          c.a(this.rKQ, paramf.rIv);
          parama.a((com.tencent.mm.plugin.finder.feed.model.b)localObject4, paramInt);
          AppMethodBeat.o(201210);
          return;
          bool2 = false;
          break;
        }
      }
      paramString = new com.tencent.mm.plugin.finder.feed.model.b((List)new LinkedList(), paramInt1, paramInt2, paramString);
      paramString.duh = this.rKQ.duh;
      paramString.pullType = paramInt;
      paramString.saU = 1;
      paramString.saV = paramf.rIv;
      paramString.lastBuffer = paramf.lastBuffer;
      parama.a(paramString, paramInt);
      AppMethodBeat.o(201210);
    }
    
    public final void a(ars paramars)
    {
      AppMethodBeat.i(201209);
      d.g.b.p.h(paramars, "request");
      AppMethodBeat.o(201209);
    }
    
    public final boolean a(cvp paramcvp)
    {
      AppMethodBeat.i(201208);
      d.g.b.p.h(paramcvp, "resp");
      n.c localc = paramc;
      if (localc != null)
      {
        boolean bool = localc.b(paramcvp);
        AppMethodBeat.o(201208);
        return bool;
      }
      AppMethodBeat.o(201208);
      return false;
    }
    
    public final boolean cxW()
    {
      AppMethodBeat.i(201207);
      boolean bool = c.b(this.rKQ);
      AppMethodBeat.o(201207);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.fetcher.c
 * JD-Core Version:    0.7.0.1
 */