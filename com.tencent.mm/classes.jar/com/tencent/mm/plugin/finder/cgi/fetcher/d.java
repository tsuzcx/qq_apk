package com.tencent.mm.plugin.finder.cgi.fetcher;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.f.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.aa;
import com.tencent.mm.plugin.finder.cgi.aa.b;
import com.tencent.mm.plugin.finder.cgi.aa.f;
import com.tencent.mm.plugin.finder.cgi.ab.a;
import com.tencent.mm.plugin.finder.cgi.ab.c;
import com.tencent.mm.plugin.finder.feed.model.internal.o;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.au;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bju;
import com.tencent.mm.protocal.protobuf.bjv;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher;", "Lcom/tencent/mm/plugin/finder/life/SupportLifecycle;", "tabType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "guideBarObjId", "", "(ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Ljava/lang/Long;)V", "Ljava/lang/Long;", "isGetHistory", "", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "getLifeCycleKeeper", "()Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "setLifeCycleKeeper", "(Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;)V", "pageDataBuffer", "Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "getPageDataBuffer", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer;", "getTabType", "()I", "dealSvrInsertWording", "", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "baseFinderFeeds", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "fetch", "callback", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "pullType", "consume", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "isPreloadMore", "unreadList", "fetchHotRelatedList", "feedId", "nonceId", "", "isPrefetch", "relatedEntranceInfo", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedEntranceInfo;", "innerFetch", "lb", "interceptAfterStore", "loadedInfo", "interceptors", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "interceptBeforeStore", "uniqueId", "Companion", "plugin-finder_release"})
public final class d
  extends com.tencent.mm.plugin.finder.life.a
{
  public static final a xft;
  public final int fEH;
  public com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> xbq;
  private final bid xbu;
  private volatile boolean xeZ;
  private final o<bu, com.tencent.mm.plugin.finder.feed.model.d> xfr;
  private Long xfs;
  
  static
  {
    AppMethodBeat.i(273577);
    xft = new a((byte)0);
    AppMethodBeat.o(273577);
  }
  
  public d(int paramInt, bid parambid, Long paramLong)
  {
    AppMethodBeat.i(273576);
    this.fEH = paramInt;
    this.xbu = parambid;
    this.xfs = paramLong;
    this.xbq = new com.tencent.mm.vending.e.c();
    this.xfr = new o(null, String.valueOf(this.fEH), 1);
    AppMethodBeat.o(273576);
  }
  
  private final void a(final ab.a parama, final int paramInt, final ab.c paramc, com.tencent.mm.cd.b paramb, List<? extends BaseFinderFeed> paramList)
  {
    AppMethodBeat.i(273575);
    if ((paramInt == 0) || (paramInt == 1)) {
      this.xeZ = false;
    }
    final boolean bool;
    if (paramb == null) {
      bool = true;
    }
    while (bool)
    {
      Log.i("Finder.TimelineFeedFetcher", "[innerFetch] use tabType=" + this.fEH + " GlobalLastBuffer");
      if (paramInt == 0)
      {
        paramb = h.aHG();
        p.j(paramb, "MMKernel.storage()");
        paramb = paramb.aHp();
        localObject1 = aj.AGc;
        paramb.set(aj.QX(this.fEH), null);
      }
      paramb = h.aHG();
      p.j(paramb, "MMKernel.storage()");
      paramb = paramb.aHp();
      localObject1 = aj.AGc;
      paramb = paramb.get(aj.QX(this.fEH), "");
      if (paramb == null)
      {
        parama = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(273575);
        throw parama;
        bool = false;
      }
      else
      {
        paramb = com.tencent.mm.cd.b.cU(Util.decodeHexString((String)paramb));
      }
    }
    int i = this.fEH;
    Object localObject1 = this.xbu;
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
      new aa(i, paramInt, paramb, (bid)localObject1, paramList).a((com.tencent.mm.plugin.finder.cgi.interceptor.f)new com.tencent.mm.plugin.finder.cgi.interceptor.a(), 0).a((com.tencent.mm.plugin.finder.cgi.interceptor.f)new com.tencent.mm.plugin.finder.cgi.interceptor.d(), 1).a((com.tencent.mm.plugin.finder.cgi.interceptor.f)new com.tencent.mm.plugin.finder.cgi.interceptor.c(), 2).a((com.tencent.mm.plugin.finder.cgi.interceptor.f)new com.tencent.mm.plugin.finder.cgi.interceptor.b(), 3).a(this.xbq, (aa.b)new c(this, paramc, paramInt, bool, parama));
      AppMethodBeat.o(273575);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher$fetch$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "pullType", "", "plugin-finder_release"})
  public static final class b
    implements ab.a
  {
    b(ab.a parama) {}
    
    public final void a(com.tencent.mm.plugin.finder.feed.model.d paramd, int paramInt)
    {
      AppMethodBeat.i(234374);
      p.k(paramd, "info");
      this.xfo.a(paramd, paramInt);
      AppMethodBeat.o(234374);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher$innerFetch$2", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$Callback;", "isBeginHistory", "", "isResultConsume", "errType", "", "errCode", "resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "onBuildRequest", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderStreamRequest;", "onCgiBack", "errMsg", "", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "interceptors", "", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "plugin-finder_release"})
  public static final class c
    implements aa.b
  {
    c(ab.c paramc, int paramInt, boolean paramBoolean, ab.a parama) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, final aa.f paramf, List<? extends com.tencent.mm.plugin.finder.cgi.interceptor.f> paramList)
    {
      AppMethodBeat.i(289448);
      p.k(paramf, "resp");
      p.k(paramList, "interceptors");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramInt == 0)
        {
          Log.i("Finder.TimelineFeedFetcher", "tabType=" + this.xfu.fEH + " headWording=" + paramf.SUH + " endWording=" + paramf.SUI + " prefetch_last_feed_count=" + paramf.SUL + '}');
          localObject1 = h.aHG();
          p.j(localObject1, "MMKernel.storage()");
          ((com.tencent.mm.kernel.f)localObject1).aHp().set(ar.a.VzW, paramf.SUH);
          localObject1 = h.aHG();
          p.j(localObject1, "MMKernel.storage()");
          ((com.tencent.mm.kernel.f)localObject1).aHp().set(ar.a.VzX, paramf.SUI);
          localObject1 = h.aHG();
          p.j(localObject1, "MMKernel.storage()");
          ((com.tencent.mm.kernel.f)localObject1).aHp().set(ar.a.VAa, Integer.valueOf(paramf.SUL));
        }
        if (paramf.SUR != null)
        {
          localObject1 = h.aHG();
          p.j(localObject1, "MMKernel.storage()");
          localObject2 = ((com.tencent.mm.kernel.f)localObject1).aHp();
          localObject3 = ar.a.VzY;
          localObject1 = paramf.SUR;
          if (localObject1 == null) {
            break label357;
          }
        }
        label357:
        for (Object localObject1 = ((bju)localObject1).toByteArray();; localObject1 = null)
        {
          ((ao)localObject2).set((ar.a)localObject3, Util.encodeHexString((byte[])localObject1));
          localObject1 = g.Xox;
          ((com.tencent.mm.plugin.finder.preload.tabPreload.c)g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.preload.tabPreload.c.class)).ON(this.xfu.fEH);
          d.c(this.xfu);
          localObject1 = MMApplicationContext.getResources().getString(b.j.finder_timeline_history_header_tip);
          p.j(localObject1, "MMApplicationContext.get…eline_history_header_tip)");
          localObject2 = h.aHG();
          p.j(localObject2, "MMKernel.storage()");
          localObject1 = ((com.tencent.mm.kernel.f)localObject2).aHp().get(ar.a.VzW, localObject1);
          if (localObject1 != null) {
            break;
          }
          paramString = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(289448);
          throw paramString;
        }
        localObject1 = (String)localObject1;
        Object localObject2 = MMApplicationContext.getResources().getString(b.j.finder_timeline_history_footer_tip);
        p.j(localObject2, "MMApplicationContext.get…eline_history_footer_tip)");
        Object localObject3 = h.aHG();
        p.j(localObject3, "MMKernel.storage()");
        localObject2 = ((com.tencent.mm.kernel.f)localObject3).aHp().get(ar.a.VzX, localObject2);
        if (localObject2 == null)
        {
          paramString = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(289448);
          throw paramString;
        }
        localObject2 = (String)localObject2;
        localObject3 = paramf.object;
        p.j(localObject3, "resp.`object`");
        Object localObject4 = (Iterable)localObject3;
        localObject3 = (Collection)new ArrayList();
        localObject4 = ((Iterable)localObject4).iterator();
        Object localObject6;
        Object localObject7;
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = ((Iterator)localObject4).next();
          localObject6 = (FinderObject)localObject5;
          localObject7 = aj.AGc;
          p.j(localObject6, "it");
          if (aj.w((FinderObject)localObject6)) {
            ((Collection)localObject3).add(localObject5);
          }
        }
        localObject4 = (List)localObject3;
        if (((List)localObject4).size() < paramf.object.size())
        {
          Log.e("Finder.TimelineFeedFetcher", "[onCgiBack] has filter some feed. valid=" + ((List)localObject4).size() + " raw=" + paramf.object.size());
          f.a.a(com.tencent.mm.plugin.findersdk.b.BuZ, "finderStreamReturnInvalidFeed", true, (kotlin.g.a.a)new a(this, (List)localObject4, paramf));
        }
        if (paramf.SUJ > 0) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          localObject3 = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
          localObject3 = aj.AGc;
          localObject5 = (Iterable)c.a.a((List)localObject4, aj.QY(this.xfu.fEH), d.d(this.xfu));
          localObject3 = (Collection)new ArrayList(j.a((Iterable)localObject5, 10));
          localObject5 = ((Iterable)localObject5).iterator();
          while (((Iterator)localObject5).hasNext())
          {
            localObject6 = (FinderItem)((Iterator)localObject5).next();
            localObject7 = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
            ((Collection)localObject3).add(c.a.a((FinderItem)localObject6));
          }
        }
        Object localObject5 = new LinkedList((Collection)localObject3);
        localObject3 = new com.tencent.mm.plugin.finder.feed.model.d((List)localObject5, paramInt1, paramInt2, paramString);
        ((com.tencent.mm.plugin.finder.feed.model.d)localObject3).fEH = this.xfu.fEH;
        ((com.tencent.mm.plugin.finder.feed.model.d)localObject3).xbB = Math.min(paramf.xbB, ((List)localObject4).size());
        ((com.tencent.mm.plugin.finder.feed.model.d)localObject3).nqx = Math.min(paramf.nqx, ((List)localObject4).size());
        ((com.tencent.mm.plugin.finder.feed.model.d)localObject3).xbC = paramf.xbC;
        ((com.tencent.mm.plugin.finder.feed.model.d)localObject3).pullType = paramInt;
        ((com.tencent.mm.plugin.finder.feed.model.d)localObject3).xFO = ((String)localObject1);
        ((com.tencent.mm.plugin.finder.feed.model.d)localObject3).xBL = ((String)localObject2);
        ((com.tencent.mm.plugin.finder.feed.model.d)localObject3).xFI = paramf.continueFlag;
        ((com.tencent.mm.plugin.finder.feed.model.d)localObject3).xFG = ((List)localObject4);
        ((com.tencent.mm.plugin.finder.feed.model.d)localObject3).xFJ = paramf.xbD;
        ((com.tencent.mm.plugin.finder.feed.model.d)localObject3).xeZ = d.a(this.xfu);
        ((com.tencent.mm.plugin.finder.feed.model.d)localObject3).lastBuffer = paramf.lastBuffer;
        ((com.tencent.mm.plugin.finder.feed.model.d)localObject3).preloadInfo = paramf.preloadInfo;
        ((com.tencent.mm.plugin.finder.feed.model.d)localObject3).xFL = paramf.SUP;
        ((com.tencent.mm.plugin.finder.feed.model.d)localObject3).xFH = paramf.xFH;
        if (paramf.SUJ != 0) {}
        for (boolean bool2 = true;; bool2 = false)
        {
          ((com.tencent.mm.plugin.finder.feed.model.d)localObject3).isNeedClear = bool2;
          ((com.tencent.mm.plugin.finder.feed.model.d)localObject3).xFN = paramf.xFN;
          d.a((com.tencent.mm.plugin.finder.feed.model.d)localObject3, paramList);
          if (paramInt != 2)
          {
            paramString = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
            paramString = (List)localObject5;
            localObject1 = aj.AGc;
            c.a.b(paramString, aj.QY(this.xfu.fEH), bool1);
          }
          d.a(this.xfu, (com.tencent.mm.plugin.finder.feed.model.d)localObject3, paramList);
          if ((paramInt == 0) || (paramInt == 1))
          {
            paramString = au.zBf;
            au.j(this.xfu.fEH, (List)localObject4);
          }
          if (bool)
          {
            paramString = h.aHG();
            p.j(paramString, "MMKernel.storage()");
            paramList = paramString.aHp();
            paramString = aj.AGc;
            localObject1 = aj.QX(this.xfu.fEH);
            if (paramf.lastBuffer != null) {
              break;
            }
            paramString = null;
            paramList.set((ar.a)localObject1, paramString);
          }
          d.a(this.xfu, paramf.xbD);
          parama.a((com.tencent.mm.plugin.finder.feed.model.d)localObject3, paramInt);
          AppMethodBeat.o(289448);
          return;
        }
        paramString = paramf.lastBuffer;
        if (paramString != null) {}
        for (paramString = paramString.toByteArray();; paramString = null)
        {
          paramString = Util.encodeHexString(paramString);
          break;
        }
      }
      paramString = new com.tencent.mm.plugin.finder.feed.model.d((List)new LinkedList(), paramInt1, paramInt2, paramString);
      paramString.fEH = this.xfu.fEH;
      paramString.pullType = paramInt;
      paramString.xFI = 1;
      paramString.xFJ = paramf.xbD;
      paramString.lastBuffer = paramf.lastBuffer;
      parama.a(paramString, paramInt);
      AppMethodBeat.o(289448);
    }
    
    public final void a(bjv parambjv)
    {
      AppMethodBeat.i(289447);
      p.k(parambjv, "request");
      Long localLong = d.b(this.xfu);
      if (localLong != null)
      {
        parambjv.SUF = ((Number)localLong).longValue();
        AppMethodBeat.o(289447);
        return;
      }
      AppMethodBeat.o(289447);
    }
    
    public final boolean a(dyy paramdyy)
    {
      AppMethodBeat.i(289446);
      p.k(paramdyy, "resp");
      ab.c localc = paramc;
      if (localc != null)
      {
        boolean bool = localc.b(paramdyy);
        AppMethodBeat.o(289446);
        return bool;
      }
      AppMethodBeat.o(289446);
      return false;
    }
    
    public final boolean dnH()
    {
      AppMethodBeat.i(289445);
      boolean bool = d.a(this.xfu);
      AppMethodBeat.o(289445);
      return bool;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<String>
    {
      a(d.c paramc, List paramList, aa.f paramf)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.fetcher.d
 * JD-Core Version:    0.7.0.1
 */