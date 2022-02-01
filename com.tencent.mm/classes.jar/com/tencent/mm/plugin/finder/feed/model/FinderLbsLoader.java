package com.tencent.mm.plugin.finder.feed.model;

import android.arch.lifecycle.ViewModelProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.h;
import com.tencent.mm.loader.g.i;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.fetcher.b.a;
import com.tencent.mm.plugin.finder.cgi.n.c;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.storage.data.k;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.storage.m;
import com.tencent.mm.plugin.finder.storage.t;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM.a;
import com.tencent.mm.protocal.protobuf.aqj;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.cwj;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.q;
import d.l;
import d.z;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "onFetchDone", "response", "FinderLbsResponse", "FinderLbsReuqest", "LbsDataFetcher", "plugin-finder_release"})
public final class FinderLbsLoader
  extends BaseFeedLoader<com.tencent.mm.plugin.finder.model.c>
{
  public d.g.a.b<? super IResponse<com.tencent.mm.plugin.finder.model.c>, z> fetchEndCallback;
  final arn rQw;
  
  public FinderLbsLoader(arn paramarn)
  {
    this.rQw = paramarn;
  }
  
  public final g<com.tencent.mm.plugin.finder.model.c> createDataFetch()
  {
    AppMethodBeat.i(202867);
    g localg = (g)new c();
    AppMethodBeat.o(202867);
    return localg;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.b<com.tencent.mm.plugin.finder.model.c> createDataMerger()
  {
    AppMethodBeat.i(202868);
    com.tencent.mm.plugin.finder.feed.model.internal.b localb = (com.tencent.mm.plugin.finder.feed.model.internal.b)new FinderLbsLoader.d(this);
    AppMethodBeat.o(202868);
    return localb;
  }
  
  public final void onFetchDone(final IResponse<com.tencent.mm.plugin.finder.model.c> paramIResponse)
  {
    AppMethodBeat.i(202869);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramIResponse);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/model/FinderLbsLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V", this, localb.ahF());
    d.g.b.p.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/FinderLbsLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
      AppMethodBeat.o(202869);
      return;
    }
    com.tencent.mm.ac.c.h((d.g.a.a)new e(this, paramIResponse));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/FinderLbsLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
    AppMethodBeat.o(202869);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader$FinderLbsResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
  public static final class a
    extends IResponse<com.tencent.mm.plugin.finder.model.c>
  {
    public a(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader$FinderLbsReuqest;", "", "pullType", "", "(I)V", "getPullType", "()I", "plugin-finder_release"})
  public static final class b
  {
    final int pullType;
    
    public b(int paramInt)
    {
      this.pullType = paramInt;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader$LbsDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader;)V", "callBack", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "getCallBack", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "setCallBack", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;)V", "fetcher", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher;", "taskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "alive", "", "dead", "fetch", "request", "", "callback", "fetchInit", "fetchLoadMore", "fetchRefresh", "plugin-finder_release"})
  public final class c
    extends g<com.tencent.mm.plugin.finder.model.c>
  {
    i sdq;
    com.tencent.mm.plugin.finder.cgi.fetcher.b skn;
    
    public final void alive()
    {
      AppMethodBeat.i(202862);
      super.alive();
      this.skn = new com.tencent.mm.plugin.finder.cgi.fetcher.b(this.sko.rQw);
      i locali = new i("FinderFollowTlSingleExecutor");
      locali.start();
      this.sdq = locali;
      new com.tencent.mm.plugin.finder.cgi.fetcher.b(this.sko.rQw);
      AppMethodBeat.o(202862);
    }
    
    public final void dead()
    {
      AppMethodBeat.i(202863);
      super.dead();
      Object localObject = this.skn;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.finder.cgi.fetcher.b)localObject).rQs;
        if (localObject != null) {
          ((com.tencent.mm.vending.e.c)localObject).dead();
        }
      }
      localObject = this.sdq;
      if (localObject != null) {
        ((i)localObject).reset();
      }
      this.sdq = null;
      AppMethodBeat.o(202863);
    }
    
    public final void fetch(final Object paramObject, final f<com.tencent.mm.plugin.finder.model.c> paramf)
    {
      AppMethodBeat.i(202861);
      d.g.b.p.h(paramf, "callback");
      if ((paramObject instanceof FinderLbsLoader.b))
      {
        i locali = this.sdq;
        if (locali != null)
        {
          locali.a(new h((d.g.a.b)new a(this, paramObject, paramf)));
          AppMethodBeat.o(202861);
          return;
        }
      }
      AppMethodBeat.o(202861);
    }
    
    public final void fetchInit(f<com.tencent.mm.plugin.finder.model.c> paramf)
    {
      AppMethodBeat.i(202860);
      d.g.b.p.h(paramf, "callback");
      LinkedList localLinkedList = new LinkedList();
      try
      {
        Object localObject = com.tencent.mm.ui.component.a.KEX;
        localObject = ((FinderHomeTabStateVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).GH(1000);
        if (((FinderHomeTabStateVM.a)localObject).tkB.isEmpty())
        {
          localObject = k.sLb;
          k.a.FQ(9);
          localLinkedList.addAll((Collection)k.a.ajy(""));
          ae.i(getTAG(), "lxl FinderLbsLoader load init data from FirstPage, size:" + localLinkedList.size());
        }
        for (;;)
        {
          localObject = new FinderLbsLoader.a(0, 0, "");
          ((FinderLbsLoader.a)localObject).setPullType(1000);
          ((FinderLbsLoader.a)localObject).setIncrementList((List)localLinkedList);
          paramf.onFetchDone((IResponse)localObject);
          AppMethodBeat.o(202860);
          return;
          localLinkedList.addAll((Collection)((FinderHomeTabStateVM.a)localObject).tkB);
          ae.i(getTAG(), "lxl FinderLbsLoader load init data from tlcache, size:" + localLinkedList.size());
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          ae.printErrStackTrace(getTAG(), localThrowable, "lxl FinderLbsLoader load init data exception", new Object[0]);
        }
      }
    }
    
    public final void fetchLoadMore(f<com.tencent.mm.plugin.finder.model.c> paramf)
    {
      AppMethodBeat.i(202859);
      d.g.b.p.h(paramf, "callback");
      fetch(new FinderLbsLoader.b(2), paramf);
      AppMethodBeat.o(202859);
    }
    
    public final void fetchRefresh(f<com.tencent.mm.plugin.finder.model.c> paramf)
    {
      AppMethodBeat.i(202858);
      d.g.b.p.h(paramf, "callback");
      fetch(new FinderLbsLoader.b(4), paramf);
      AppMethodBeat.o(202858);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
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