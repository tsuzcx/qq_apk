package com.tencent.mm.plugin.finder.feed.model;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.loader.g.h;
import com.tencent.mm.loader.g.i;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.plugin.finder.cgi.ab.c;
import com.tencent.mm.plugin.finder.cgi.fetcher.b.a;
import com.tencent.mm.plugin.finder.cgi.fetcher.b.b;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.n;
import com.tencent.mm.plugin.finder.storage.data.l.a;
import com.tencent.mm.plugin.finder.storage.o;
import com.tencent.mm.protocal.protobuf.azm;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "onFetchDone", "response", "FinderLbsResponse", "FinderLbsReuqest", "LbsDataFetcher", "plugin-finder_release"})
public final class FinderLbsLoader
  extends BaseFeedLoader<com.tencent.mm.plugin.finder.model.c>
{
  public kotlin.g.a.b<? super IResponse<com.tencent.mm.plugin.finder.model.c>, x> fetchEndCallback;
  
  public FinderLbsLoader(bbn parambbn)
  {
    super(parambbn);
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.g<com.tencent.mm.plugin.finder.model.c> createDataFetch()
  {
    AppMethodBeat.i(244663);
    com.tencent.mm.plugin.finder.feed.model.internal.g localg = (com.tencent.mm.plugin.finder.feed.model.internal.g)new c();
    AppMethodBeat.o(244663);
    return localg;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.b<com.tencent.mm.plugin.finder.model.c> createDataMerger()
  {
    AppMethodBeat.i(244664);
    com.tencent.mm.plugin.finder.feed.model.internal.b localb = (com.tencent.mm.plugin.finder.feed.model.internal.b)new d(this);
    AppMethodBeat.o(244664);
    return localb;
  }
  
  public final void onFetchDone(final IResponse<com.tencent.mm.plugin.finder.model.c> paramIResponse)
  {
    AppMethodBeat.i(244665);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramIResponse);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/model/FinderLbsLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V", this, localb.axR());
    p.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/FinderLbsLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
      AppMethodBeat.o(244665);
      return;
    }
    d.h((kotlin.g.a.a)new e(this, paramIResponse));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/FinderLbsLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
    AppMethodBeat.o(244665);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader$FinderLbsResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
  public static final class a
    extends IResponse<com.tencent.mm.plugin.finder.model.c>
  {
    public a(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader$FinderLbsReuqest;", "", "pullType", "", "(I)V", "getPullType", "()I", "plugin-finder_release"})
  public static final class b
  {
    final int pullType;
    
    public b(int paramInt)
    {
      this.pullType = paramInt;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader$LbsDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader;)V", "callBack", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "getCallBack", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "setCallBack", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;)V", "fetcher", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher;", "taskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "alive", "", "dead", "fetch", "request", "", "callback", "fetchInit", "fetchLoadMore", "fetchRefresh", "plugin-finder_release"})
  public final class c
    extends com.tencent.mm.plugin.finder.feed.model.internal.g<com.tencent.mm.plugin.finder.model.c>
  {
    i tMX;
    com.tencent.mm.plugin.finder.cgi.fetcher.b tVE;
    
    public final void alive()
    {
      AppMethodBeat.i(244658);
      super.alive();
      this.tVE = new com.tencent.mm.plugin.finder.cgi.fetcher.b(this.tVF.getContextObj());
      i locali = new i("FinderFollowTlSingleExecutor");
      locali.start();
      this.tMX = locali;
      new com.tencent.mm.plugin.finder.cgi.fetcher.b(this.tVF.getContextObj());
      AppMethodBeat.o(244658);
    }
    
    public final void dead()
    {
      AppMethodBeat.i(244659);
      super.dead();
      Object localObject = this.tVE;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.finder.cgi.fetcher.b)localObject).ttK;
        if (localObject != null) {
          ((com.tencent.mm.vending.e.c)localObject).dead();
        }
      }
      localObject = this.tMX;
      if (localObject != null) {
        ((i)localObject).reset();
      }
      this.tMX = null;
      AppMethodBeat.o(244659);
    }
    
    public final void fetch(final Object paramObject, final f<com.tencent.mm.plugin.finder.model.c> paramf)
    {
      AppMethodBeat.i(244657);
      p.h(paramf, "callback");
      if ((paramObject instanceof FinderLbsLoader.b))
      {
        i locali = this.tMX;
        if (locali != null)
        {
          locali.a(new h((kotlin.g.a.b)new a(this, paramObject, paramf)));
          AppMethodBeat.o(244657);
          return;
        }
      }
      AppMethodBeat.o(244657);
    }
    
    public final void fetchInit(f<com.tencent.mm.plugin.finder.model.c> paramf)
    {
      AppMethodBeat.i(244656);
      p.h(paramf, "callback");
      LinkedList localLinkedList = new LinkedList();
      try
      {
        Object localObject1 = com.tencent.mm.plugin.finder.storage.data.l.vGw;
        l.a.Lf(9);
        localLinkedList.addAll((Collection)l.a.avF(""));
        localObject1 = com.tencent.mm.kernel.g.aAh();
        p.g(localObject1, "MMKernel.storage()");
        localObject1 = ((e)localObject1).azQ().get(ar.a.OkW, "");
        if (localObject1 != null) {
          break label147;
        }
        localObject1 = new kotlin.t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(244656);
        throw ((Throwable)localObject1);
      }
      catch (Throwable localThrowable)
      {
        Log.printErrStackTrace(getTAG(), localThrowable, "lxl FinderLbsLoader load init data exception", new Object[0]);
      }
      Object localObject2 = new FinderLbsLoader.a(0, 0, "");
      ((FinderLbsLoader.a)localObject2).setPullType(1000);
      ((FinderLbsLoader.a)localObject2).setIncrementList((List)localLinkedList);
      paramf.onFetchDone((IResponse)localObject2);
      AppMethodBeat.o(244656);
      return;
      label147:
      localObject2 = Util.decodeHexString((String)localObject2);
      Object localObject3 = this.tVE;
      if (localObject3 != null)
      {
        localObject3 = ((com.tencent.mm.plugin.finder.cgi.fetcher.b)localObject3).twY;
        if (localObject3 != null) {
          ((b.b)localObject3).txe = com.tencent.mm.bw.b.cD((byte[])localObject2);
        }
      }
      localObject3 = getTAG();
      StringBuilder localStringBuilder = new StringBuilder("FinderLbsLoader load init data from FirstPage, size:").append(localLinkedList.size()).append(", lastBuffer:");
      localObject2 = this.tVE;
      if (localObject2 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.finder.cgi.fetcher.b)localObject2).twY;
        if (localObject2 != null)
        {
          localObject2 = ((b.b)localObject2).txe;
          if (localObject2 == null) {}
        }
      }
      for (localObject2 = ((com.tencent.mm.bw.b)localObject2).toByteArray();; localObject2 = null)
      {
        Log.i((String)localObject3, Util.encodeHexString((byte[])localObject2));
        break;
      }
    }
    
    public final void fetchLoadMore(f<com.tencent.mm.plugin.finder.model.c> paramf)
    {
      AppMethodBeat.i(244655);
      p.h(paramf, "callback");
      fetch(new FinderLbsLoader.b(2), paramf);
      AppMethodBeat.o(244655);
    }
    
    public final void fetchRefresh(f<com.tencent.mm.plugin.finder.model.c> paramf)
    {
      AppMethodBeat.i(244654);
      p.h(paramf, "callback");
      fetch(new FinderLbsLoader.b(4), paramf);
      AppMethodBeat.o(244654);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.b<h, x>
    {
      a(FinderLbsLoader.c paramc, Object paramObject, f paramf)
      {
        super();
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/model/FinderLbsLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
  public static final class d
    extends BaseFeedLoader<com.tencent.mm.plugin.finder.model.c>.a
  {
    d()
    {
      super();
    }
    
    public final void mergeRefresh(final IResponse<com.tencent.mm.plugin.finder.model.c> paramIResponse, final kotlin.g.a.b<? super IResponse<com.tencent.mm.plugin.finder.model.c>, x> paramb)
    {
      AppMethodBeat.i(244661);
      p.h(paramIResponse, "response");
      Object localObject = RefreshLoadMoreLayout.c.Rms;
      localObject = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.hfT());
      boolean bool;
      if ((paramIResponse.getErrType() == 0) && (paramIResponse.getErrCode() == 0))
      {
        ((RefreshLoadMoreLayout.c)localObject).Rmh = 1;
        if (paramIResponse.getPullType() == 0) {
          break label203;
        }
        bool = true;
        label57:
        ((RefreshLoadMoreLayout.c)localObject).jLE = bool;
        ((RefreshLoadMoreLayout.c)localObject).Rmj = paramIResponse.getHasMore();
        if ((((RefreshLoadMoreLayout.c)localObject).actionType == 0) || (((RefreshLoadMoreLayout.c)localObject).actionType == 4) || (((RefreshLoadMoreLayout.c)localObject).actionType == 4)) {
          if ((((RefreshLoadMoreLayout.c)localObject).Rmk <= 0) && (this.tVF.getDataListJustForAdapter().size() > 0)) {
            break label208;
          }
        }
      }
      Context localContext;
      for (((RefreshLoadMoreLayout.c)localObject).Rmi = null;; ((RefreshLoadMoreLayout.c)localObject).Rmi = ((CharSequence)localContext.getResources().getString(2131760636)))
      {
        d.h((kotlin.g.a.a)new a(this, new n(4, paramIResponse.getIncrementList(), false, 12), (RefreshLoadMoreLayout.c)localObject, paramb, paramIResponse));
        AppMethodBeat.o(244661);
        return;
        localContext = MMApplicationContext.getContext();
        p.g(localContext, "MMApplicationContext.getContext()");
        ((RefreshLoadMoreLayout.c)localObject).Rmi = ((CharSequence)localContext.getResources().getString(2131760634));
        ((RefreshLoadMoreLayout.c)localObject).Rmh = -1;
        break;
        label203:
        bool = false;
        break label57;
        label208:
        localContext = MMApplicationContext.getContext();
        p.g(localContext, "MMApplicationContext.getContext()");
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(FinderLbsLoader.d paramd, n paramn, RefreshLoadMoreLayout.c paramc, kotlin.g.a.b paramb, IResponse paramIResponse)
      {
        super();
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<x>
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