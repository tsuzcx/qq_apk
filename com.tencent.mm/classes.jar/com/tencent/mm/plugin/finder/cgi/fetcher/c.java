package com.tencent.mm.plugin.finder.cgi.fetcher;

import android.arch.lifecycle.ViewModelProvider;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.f.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.aa;
import com.tencent.mm.plugin.finder.cgi.aa.b;
import com.tencent.mm.plugin.finder.cgi.aa.f;
import com.tencent.mm.plugin.finder.cgi.ab.a;
import com.tencent.mm.plugin.finder.cgi.ab.c;
import com.tencent.mm.plugin.finder.cgi.interceptor.d;
import com.tencent.mm.plugin.finder.cgi.interceptor.f;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.as;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.preload.tabPreload.FinderStreamTabPreloadCore;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.h;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bcy;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher;", "Lcom/tencent/mm/plugin/finder/life/SupportLifecycle;", "tabType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "isGetHistory", "", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "getLifeCycleKeeper", "()Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "setLifeCycleKeeper", "(Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;)V", "pageDataBuffer", "Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "getPageDataBuffer", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer;", "getTabType", "()I", "dealSvrInsertWording", "", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "baseFinderFeeds", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "fetch", "callback", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "pullType", "consume", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "isPreloadMore", "unreadList", "fetchHotRelatedList", "feedId", "", "nonceId", "", "isPrefetch", "relatedEntranceInfo", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedEntranceInfo;", "innerFetch", "lb", "interceptAfterStore", "loadedInfo", "interceptors", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "interceptBeforeStore", "uniqueId", "Companion", "plugin-finder_release"})
public final class c
  extends com.tencent.mm.plugin.finder.life.a
{
  public static final a txs;
  public final int dLS;
  public com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> ttK;
  public final bbn ttO;
  private volatile boolean twZ;
  private final com.tencent.mm.plugin.finder.feed.model.internal.l<bo, com.tencent.mm.plugin.finder.feed.model.b> txr;
  
  static
  {
    AppMethodBeat.i(242607);
    txs = new a((byte)0);
    AppMethodBeat.o(242607);
  }
  
  public c(int paramInt, bbn parambbn)
  {
    AppMethodBeat.i(242606);
    this.dLS = paramInt;
    this.ttO = parambbn;
    this.ttK = new com.tencent.mm.vending.e.c();
    this.txr = new com.tencent.mm.plugin.finder.feed.model.internal.l(null, String.valueOf(this.dLS), 1);
    AppMethodBeat.o(242606);
  }
  
  private final void a(final ab.a parama, final int paramInt, final ab.c paramc, com.tencent.mm.bw.b paramb, List<? extends BaseFinderFeed> paramList)
  {
    AppMethodBeat.i(242605);
    if ((paramInt == 0) || (paramInt == 1)) {
      this.twZ = false;
    }
    final boolean bool;
    if (paramb == null) {
      bool = true;
    }
    while (bool)
    {
      Log.i("Finder.TimelineFeedFetcher", "[innerFetch] use tabType=" + this.dLS + " GlobalLastBuffer");
      if (paramInt == 0)
      {
        paramb = g.aAh();
        p.g(paramb, "MMKernel.storage()");
        paramb = paramb.azQ();
        localObject1 = y.vXH;
        paramb.set(y.LK(this.dLS), null);
      }
      paramb = g.aAh();
      p.g(paramb, "MMKernel.storage()");
      paramb = paramb.azQ();
      localObject1 = y.vXH;
      paramb = paramb.get(y.LK(this.dLS), "");
      if (paramb == null)
      {
        parama = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(242605);
        throw parama;
        bool = false;
      }
      else
      {
        paramb = com.tencent.mm.bw.b.cD(Util.decodeHexString((String)paramb));
      }
    }
    int i = this.dLS;
    Object localObject1 = this.ttO;
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
      new aa(i, paramInt, paramb, (bbn)localObject1, paramList).a((f)new com.tencent.mm.plugin.finder.cgi.interceptor.a(), 0).a((f)new d(), 1).a((f)new com.tencent.mm.plugin.finder.cgi.interceptor.c(), 2).a((f)new com.tencent.mm.plugin.finder.cgi.interceptor.b(), 3).a(this.ttK, (aa.b)new d(this, paramc, paramInt, bool, parama));
      AppMethodBeat.o(242605);
      return;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher$fetch$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "pullType", "", "plugin-finder_release"})
  public static final class b
    implements ab.a
  {
    b(ab.a parama) {}
    
    public final void a(com.tencent.mm.plugin.finder.feed.model.b paramb, int paramInt)
    {
      AppMethodBeat.i(242598);
      p.h(paramb, "info");
      if (this.txt.dLS == 4)
      {
        Object localObject = ((Iterable)paramb.tUz).iterator();
        while (((Iterator)localObject).hasNext())
        {
          bo localbo = (bo)((Iterator)localObject).next();
          if ((localbo instanceof BaseFinderFeed))
          {
            h localh = h.vGk;
            h.c(((BaseFinderFeed)localbo).feedObject.getId(), ((BaseFinderFeed)localbo).feedObject);
          }
        }
        localObject = h.vGk;
        h.a(c.a(this.txt), true, "onFetchDone#".concat(String.valueOf(paramInt)));
      }
      this.txo.a(paramb, paramInt);
      AppMethodBeat.o(242598);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListResp;", "kotlin.jvm.PlatformType", "call"})
  public static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    public c(c paramc, boolean paramBoolean, long paramLong, ab.a parama) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher$innerFetch$2", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$Callback;", "isBeginHistory", "", "isResultConsume", "errType", "", "errCode", "resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "onBuildRequest", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderStreamRequest;", "onCgiBack", "errMsg", "", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "interceptors", "", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "plugin-finder_release"})
  public static final class d
    implements aa.b
  {
    d(ab.c paramc, int paramInt, boolean paramBoolean, ab.a parama) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, final aa.f paramf, List<? extends f> paramList)
    {
      AppMethodBeat.i(242603);
      p.h(paramf, "resp");
      p.h(paramList, "interceptors");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramInt == 0)
        {
          Log.i("Finder.TimelineFeedFetcher", "tabType=" + this.txt.dLS + " headWording=" + paramf.LME + " endWording=" + paramf.LMF + " prefetch_last_feed_count=" + paramf.LMI + '}');
          localObject1 = g.aAh();
          p.g(localObject1, "MMKernel.storage()");
          ((e)localObject1).azQ().set(ar.a.Olb, paramf.LME);
          localObject1 = g.aAh();
          p.g(localObject1, "MMKernel.storage()");
          ((e)localObject1).azQ().set(ar.a.Olc, paramf.LMF);
          localObject1 = g.aAh();
          p.g(localObject1, "MMKernel.storage()");
          ((e)localObject1).azQ().set(ar.a.Olf, Integer.valueOf(paramf.LMI));
        }
        if (paramf.LMO != null)
        {
          localObject1 = g.aAh();
          p.g(localObject1, "MMKernel.storage()");
          localObject2 = ((e)localObject1).azQ();
          localObject3 = ar.a.Old;
          localObject1 = paramf.LMO;
          if (localObject1 == null) {
            break label349;
          }
        }
        label349:
        for (Object localObject1 = ((bcy)localObject1).toByteArray();; localObject1 = null)
        {
          ((ao)localObject2).set((ar.a)localObject3, Util.encodeHexString((byte[])localObject1));
          localObject1 = com.tencent.mm.ui.component.a.PRN;
          ((FinderStreamTabPreloadCore)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderStreamTabPreloadCore.class)).JM(this.txt.dLS);
          localObject1 = MMApplicationContext.getResources().getString(2131760625);
          p.g(localObject1, "MMApplicationContext.get…eline_history_header_tip)");
          localObject2 = g.aAh();
          p.g(localObject2, "MMKernel.storage()");
          localObject1 = ((e)localObject2).azQ().get(ar.a.Olb, localObject1);
          if (localObject1 != null) {
            break;
          }
          paramString = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(242603);
          throw paramString;
        }
        localObject1 = (String)localObject1;
        Object localObject2 = MMApplicationContext.getResources().getString(2131760624);
        p.g(localObject2, "MMApplicationContext.get…eline_history_footer_tip)");
        Object localObject3 = g.aAh();
        p.g(localObject3, "MMKernel.storage()");
        localObject2 = ((e)localObject3).azQ().get(ar.a.Olc, localObject2);
        if (localObject2 == null)
        {
          paramString = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(242603);
          throw paramString;
        }
        localObject2 = (String)localObject2;
        localObject3 = paramf.object;
        p.g(localObject3, "resp.`object`");
        Object localObject4 = (Iterable)localObject3;
        localObject3 = (Collection)new ArrayList();
        localObject4 = ((Iterable)localObject4).iterator();
        Object localObject6;
        Object localObject7;
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = ((Iterator)localObject4).next();
          localObject6 = (FinderObject)localObject5;
          localObject7 = y.vXH;
          p.g(localObject6, "it");
          if (y.r((FinderObject)localObject6)) {
            ((Collection)localObject3).add(localObject5);
          }
        }
        localObject4 = (List)localObject3;
        if (((List)localObject4).size() < paramf.object.size())
        {
          Log.e("Finder.TimelineFeedFetcher", "[onCgiBack] has filter some feed. valid=" + ((List)localObject4).size() + " raw=" + paramf.object.size());
          f.a.a(com.tencent.mm.plugin.finder.utils.c.vVc, "finderStreamReturnInvalidFeed", (kotlin.g.a.a)new a(this, (List)localObject4, paramf));
        }
        if (paramf.LMG > 0) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          localObject3 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
          localObject3 = y.vXH;
          localObject5 = (Iterable)com.tencent.mm.plugin.finder.storage.logic.c.a.a((List)localObject4, y.LL(this.txt.dLS), c.a(this.txt));
          localObject3 = (Collection)new ArrayList(j.a((Iterable)localObject5, 10));
          localObject5 = ((Iterable)localObject5).iterator();
          while (((Iterator)localObject5).hasNext())
          {
            localObject6 = (FinderItem)((Iterator)localObject5).next();
            localObject7 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
            ((Collection)localObject3).add(com.tencent.mm.plugin.finder.storage.logic.c.a.s((FinderItem)localObject6));
          }
        }
        Object localObject5 = new LinkedList((Collection)localObject3);
        localObject3 = new com.tencent.mm.plugin.finder.feed.model.b((List)localObject5, paramInt1, paramInt2, paramString);
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject3).dLS = this.txt.dLS;
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject3).ttV = Math.min(paramf.ttV, ((List)localObject4).size());
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject3).kxF = Math.min(paramf.kxF, ((List)localObject4).size());
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject3).ttW = paramf.ttW;
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject3).pullType = paramInt;
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject3).tUI = ((String)localObject1);
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject3).tQU = ((String)localObject2);
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject3).tUC = paramf.continueFlag;
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject3).tUA = ((List)localObject4);
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject3).tUD = paramf.ttX;
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject3).twZ = c.b(this.txt);
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject3).lastBuffer = paramf.lastBuffer;
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject3).preloadInfo = paramf.preloadInfo;
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject3).tUF = paramf.LMM;
        ((com.tencent.mm.plugin.finder.feed.model.b)localObject3).tUB = paramf.tUB;
        if (paramf.LMG != 0) {}
        for (boolean bool2 = true;; bool2 = false)
        {
          ((com.tencent.mm.plugin.finder.feed.model.b)localObject3).isNeedClear = bool2;
          ((com.tencent.mm.plugin.finder.feed.model.b)localObject3).tUH = paramf.tUH;
          c.a((com.tencent.mm.plugin.finder.feed.model.b)localObject3, paramList);
          if (paramInt != 2)
          {
            paramString = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
            paramString = (List)localObject5;
            localObject1 = y.vXH;
            com.tencent.mm.plugin.finder.storage.logic.c.a.b(paramString, y.LL(this.txt.dLS), bool1);
          }
          c.a(this.txt, (com.tencent.mm.plugin.finder.feed.model.b)localObject3, paramList);
          if ((paramInt == 0) || (paramInt == 1))
          {
            paramString = as.uOL;
            as.h(this.txt.dLS, (List)localObject4);
          }
          if (bool)
          {
            paramString = g.aAh();
            p.g(paramString, "MMKernel.storage()");
            paramList = paramString.azQ();
            paramString = y.vXH;
            localObject1 = y.LK(this.txt.dLS);
            if (paramf.lastBuffer != null) {
              break;
            }
            paramString = null;
            paramList.set((ar.a)localObject1, paramString);
          }
          c.a(this.txt, paramf.ttX);
          parama.a((com.tencent.mm.plugin.finder.feed.model.b)localObject3, paramInt);
          AppMethodBeat.o(242603);
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
      paramString = new com.tencent.mm.plugin.finder.feed.model.b((List)new LinkedList(), paramInt1, paramInt2, paramString);
      paramString.dLS = this.txt.dLS;
      paramString.pullType = paramInt;
      paramString.tUC = 1;
      paramString.tUD = paramf.ttX;
      paramString.lastBuffer = paramf.lastBuffer;
      parama.a(paramString, paramInt);
      AppMethodBeat.o(242603);
    }
    
    public final void a(bcz parambcz)
    {
      AppMethodBeat.i(242602);
      p.h(parambcz, "request");
      AppMethodBeat.o(242602);
    }
    
    public final boolean a(dpc paramdpc)
    {
      AppMethodBeat.i(242601);
      p.h(paramdpc, "resp");
      ab.c localc = paramc;
      if (localc != null)
      {
        boolean bool = localc.b(paramdpc);
        AppMethodBeat.o(242601);
        return bool;
      }
      AppMethodBeat.o(242601);
      return false;
    }
    
    public final boolean cXU()
    {
      AppMethodBeat.i(242600);
      boolean bool = c.b(this.txt);
      AppMethodBeat.o(242600);
      return bool;
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<String>
    {
      a(c.d paramd, List paramList, aa.f paramf)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.fetcher.c
 * JD-Core Version:    0.7.0.1
 */