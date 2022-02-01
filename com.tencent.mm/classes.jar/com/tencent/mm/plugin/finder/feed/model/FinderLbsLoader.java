package com.tencent.mm.plugin.finder.feed.model;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.h;
import com.tencent.mm.loader.g.i;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.fetcher.b.a;
import com.tencent.mm.plugin.finder.cgi.n.c;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.storage.data.k;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.storage.m;
import com.tencent.mm.plugin.finder.storage.t;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM.a;
import com.tencent.mm.protocal.protobuf.apw;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.cvp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import d.g.b.q;
import d.z;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "onFetchDone", "response", "FinderLbsResponse", "FinderLbsReuqest", "LbsDataFetcher", "plugin-finder_release"})
public final class FinderLbsLoader
  extends BaseFeedLoader<com.tencent.mm.plugin.finder.model.c>
{
  public d.g.a.b<? super IResponse<com.tencent.mm.plugin.finder.model.c>, z> fetchEndCallback;
  final aqy rIl;
  
  public FinderLbsLoader(aqy paramaqy)
  {
    this.rIl = paramaqy;
  }
  
  public final g<com.tencent.mm.plugin.finder.model.c> createDataFetch()
  {
    AppMethodBeat.i(202391);
    g localg = (g)new c();
    AppMethodBeat.o(202391);
    return localg;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.b<com.tencent.mm.plugin.finder.model.c> createDataMerger()
  {
    AppMethodBeat.i(202392);
    com.tencent.mm.plugin.finder.feed.model.internal.b localb = (com.tencent.mm.plugin.finder.feed.model.internal.b)new d(this);
    AppMethodBeat.o(202392);
    return localb;
  }
  
  public final void onFetchDone(final IResponse<com.tencent.mm.plugin.finder.model.c> paramIResponse)
  {
    AppMethodBeat.i(202393);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramIResponse);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/model/FinderLbsLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V", this, localb.ahq());
    d.g.b.p.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/FinderLbsLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
      AppMethodBeat.o(202393);
      return;
    }
    com.tencent.mm.ad.c.g((d.g.a.a)new e(this, paramIResponse));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/FinderLbsLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
    AppMethodBeat.o(202393);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader$FinderLbsResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
  public static final class a
    extends IResponse<com.tencent.mm.plugin.finder.model.c>
  {
    public a(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader$FinderLbsReuqest;", "", "pullType", "", "(I)V", "getPullType", "()I", "plugin-finder_release"})
  public static final class b
  {
    final int pullType;
    
    public b(int paramInt)
    {
      this.pullType = paramInt;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader$LbsDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader;)V", "callBack", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "getCallBack", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "setCallBack", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;)V", "fetcher", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher;", "taskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "alive", "", "dead", "fetch", "request", "", "callback", "fetchInit", "fetchLoadMore", "fetchRefresh", "plugin-finder_release"})
  public final class c
    extends g<com.tencent.mm.plugin.finder.model.c>
  {
    i rUM;
    com.tencent.mm.plugin.finder.cgi.fetcher.b sbw;
    
    public final void alive()
    {
      AppMethodBeat.i(202386);
      super.alive();
      this.sbw = new com.tencent.mm.plugin.finder.cgi.fetcher.b(this.sbx.rIl);
      i locali = new i("FinderFollowTlSingleExecutor");
      locali.start();
      this.rUM = locali;
      new com.tencent.mm.plugin.finder.cgi.fetcher.b(this.sbx.rIl);
      AppMethodBeat.o(202386);
    }
    
    public final void dead()
    {
      AppMethodBeat.i(202387);
      super.dead();
      Object localObject = this.sbw;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.finder.cgi.fetcher.b)localObject).rIh;
        if (localObject != null) {
          ((com.tencent.mm.vending.e.c)localObject).dead();
        }
      }
      localObject = this.rUM;
      if (localObject != null) {
        ((i)localObject).reset();
      }
      this.rUM = null;
      AppMethodBeat.o(202387);
    }
    
    public final void fetch(final Object paramObject, final f<com.tencent.mm.plugin.finder.model.c> paramf)
    {
      AppMethodBeat.i(202385);
      d.g.b.p.h(paramf, "callback");
      if ((paramObject instanceof FinderLbsLoader.b))
      {
        i locali = this.rUM;
        if (locali != null)
        {
          locali.a(new h((d.g.a.b)new a(this, paramObject, paramf)));
          AppMethodBeat.o(202385);
          return;
        }
      }
      AppMethodBeat.o(202385);
    }
    
    public final void fetchInit(f<com.tencent.mm.plugin.finder.model.c> paramf)
    {
      AppMethodBeat.i(202384);
      d.g.b.p.h(paramf, "callback");
      LinkedList localLinkedList = new LinkedList();
      try
      {
        Object localObject = com.tencent.mm.ui.component.a.KiD;
        localObject = ((FinderHomeTabStateVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).Gi(1000);
        if (((FinderHomeTabStateVM.a)localObject).sZn.isEmpty())
        {
          localObject = k.sAe;
          k.a.Ft(9);
          localLinkedList.addAll((Collection)k.a.aiB(""));
          ad.i(getTAG(), "lxl FinderLbsLoader load init data from FirstPage, size:" + localLinkedList.size());
        }
        for (;;)
        {
          localObject = new FinderLbsLoader.a(0, 0, "");
          ((FinderLbsLoader.a)localObject).setPullType(1000);
          ((FinderLbsLoader.a)localObject).setIncrementList((List)localLinkedList);
          paramf.onFetchDone((IResponse)localObject);
          AppMethodBeat.o(202384);
          return;
          localLinkedList.addAll((Collection)((FinderHomeTabStateVM.a)localObject).sZn);
          ad.i(getTAG(), "lxl FinderLbsLoader load init data from tlcache, size:" + localLinkedList.size());
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          ad.printErrStackTrace(getTAG(), localThrowable, "lxl FinderLbsLoader load init data exception", new Object[0]);
        }
      }
    }
    
    public final void fetchLoadMore(f<com.tencent.mm.plugin.finder.model.c> paramf)
    {
      AppMethodBeat.i(202383);
      d.g.b.p.h(paramf, "callback");
      fetch(new FinderLbsLoader.b(2), paramf);
      AppMethodBeat.o(202383);
    }
    
    public final void fetchRefresh(f<com.tencent.mm.plugin.finder.model.c> paramf)
    {
      AppMethodBeat.i(202382);
      d.g.b.p.h(paramf, "callback");
      fetch(new FinderLbsLoader.b(4), paramf);
      AppMethodBeat.o(202382);
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
    static final class a
      extends q
      implements d.g.a.b<h, z>
    {
      a(FinderLbsLoader.c paramc, Object paramObject, f paramf)
      {
        super();
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/model/FinderLbsLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
  public static final class d
    extends BaseFeedLoader<com.tencent.mm.plugin.finder.model.c>.a
  {
    d()
    {
      super();
    }
    
    public final void mergeRefresh(final IResponse<com.tencent.mm.plugin.finder.model.c> paramIResponse, final d.g.a.b<? super IResponse<com.tencent.mm.plugin.finder.model.c>, z> paramb)
    {
      AppMethodBeat.i(202389);
      d.g.b.p.h(paramIResponse, "response");
      Object localObject = RefreshLoadMoreLayout.c.Lrp;
      localObject = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.fQb());
      boolean bool;
      if ((paramIResponse.getErrType() == 0) && (paramIResponse.getErrCode() == 0))
      {
        ((RefreshLoadMoreLayout.c)localObject).Lrg = 1;
        if (paramIResponse.getPullType() == 0) {
          break label203;
        }
        bool = true;
        label57:
        ((RefreshLoadMoreLayout.c)localObject).iLW = bool;
        ((RefreshLoadMoreLayout.c)localObject).Lri = paramIResponse.getHasMore();
        if ((((RefreshLoadMoreLayout.c)localObject).actionType == 0) || (((RefreshLoadMoreLayout.c)localObject).actionType == 4) || (((RefreshLoadMoreLayout.c)localObject).actionType == 4)) {
          if ((((RefreshLoadMoreLayout.c)localObject).Lrj <= 0) && (this.sbx.getDataListJustForAdapter().size() > 0)) {
            break label208;
          }
        }
      }
      Context localContext;
      for (((RefreshLoadMoreLayout.c)localObject).Lrh = null;; ((RefreshLoadMoreLayout.c)localObject).Lrh = ((CharSequence)localContext.getResources().getString(2131766506)))
      {
        com.tencent.mm.ad.c.g((d.g.a.a)new a(this, new com.tencent.mm.plugin.finder.feed.model.internal.l(4, paramIResponse.getIncrementList(), false, 12), (RefreshLoadMoreLayout.c)localObject, paramb, paramIResponse));
        AppMethodBeat.o(202389);
        return;
        localContext = aj.getContext();
        d.g.b.p.g(localContext, "MMApplicationContext.getContext()");
        ((RefreshLoadMoreLayout.c)localObject).Lrh = ((CharSequence)localContext.getResources().getString(2131766505));
        ((RefreshLoadMoreLayout.c)localObject).Lrg = -1;
        break;
        label203:
        bool = false;
        break label57;
        label208:
        localContext = aj.getContext();
        d.g.b.p.g(localContext, "MMApplicationContext.getContext()");
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements d.g.a.a<z>
    {
      a(FinderLbsLoader.d paramd, com.tencent.mm.plugin.finder.feed.model.internal.l paraml, RefreshLoadMoreLayout.c paramc, d.g.a.b paramb, IResponse paramIResponse)
      {
        super();
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements d.g.a.a<z>
  {
    e(FinderLbsLoader paramFinderLbsLoader, IResponse paramIResponse)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderLbsLoader
 * JD-Core Version:    0.7.0.1
 */