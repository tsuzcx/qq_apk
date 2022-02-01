package com.tencent.mm.plugin.finder.feed.model;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.ab.c;
import com.tencent.mm.plugin.finder.cgi.fetcher.c.a;
import com.tencent.mm.plugin.finder.cgi.fetcher.c.b;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.storage.data.k;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.storage.data.s;
import com.tencent.mm.plugin.finder.storage.w;
import com.tencent.mm.protocal.protobuf.bfl;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.dyy;
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
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "onFetchDone", "response", "FinderLbsResponse", "FinderLbsReuqest", "LbsDataFetcher", "plugin-finder_release"})
public final class FinderLbsLoader
  extends BaseFeedLoader<com.tencent.mm.plugin.finder.model.c>
{
  public kotlin.g.a.b<? super IResponse<com.tencent.mm.plugin.finder.model.c>, x> fetchEndCallback;
  
  private FinderLbsLoader(byte paramByte)
  {
    this();
  }
  
  public FinderLbsLoader(bid parambid)
  {
    super(parambid);
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.i<com.tencent.mm.plugin.finder.model.c> createDataFetch()
  {
    AppMethodBeat.i(269982);
    com.tencent.mm.plugin.finder.feed.model.internal.i locali = (com.tencent.mm.plugin.finder.feed.model.internal.i)new c();
    AppMethodBeat.o(269982);
    return locali;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.d<com.tencent.mm.plugin.finder.model.c> createDataMerger()
  {
    AppMethodBeat.i(269984);
    com.tencent.mm.plugin.finder.feed.model.internal.d locald = (com.tencent.mm.plugin.finder.feed.model.internal.d)new d(this);
    AppMethodBeat.o(269984);
    return locald;
  }
  
  public final void onFetchDone(final IResponse<com.tencent.mm.plugin.finder.model.c> paramIResponse)
  {
    AppMethodBeat.i(269985);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramIResponse);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/model/FinderLbsLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V", this, localb.aFi());
    kotlin.g.b.p.k(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/FinderLbsLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
      AppMethodBeat.o(269985);
      return;
    }
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new e(this, paramIResponse));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/FinderLbsLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
    AppMethodBeat.o(269985);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader$FinderLbsResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
  public static final class a
    extends IResponse<com.tencent.mm.plugin.finder.model.c>
  {
    public a(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader$FinderLbsReuqest;", "", "pullType", "", "(I)V", "getPullType", "()I", "plugin-finder_release"})
  public static final class b
  {
    final int pullType;
    
    public b(int paramInt)
    {
      this.pullType = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader$LbsDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader;)V", "callBack", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "getCallBack", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "setCallBack", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;)V", "fetcher", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher;", "taskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "alive", "", "dead", "fetch", "request", "", "callback", "fetchInit", "fetchLoadMore", "fetchRefresh", "plugin-finder_release"})
  public final class c
    extends com.tencent.mm.plugin.finder.feed.model.internal.i<com.tencent.mm.plugin.finder.model.c>
  {
    private com.tencent.mm.plugin.finder.cgi.fetcher.c xHw;
    private com.tencent.mm.loader.g.i xeM;
    
    public final void alive()
    {
      AppMethodBeat.i(274375);
      super.alive();
      this.xHw = new com.tencent.mm.plugin.finder.cgi.fetcher.c(this.xHx.getContextObj());
      com.tencent.mm.loader.g.i locali = new com.tencent.mm.loader.g.i("FinderFollowTlSingleExecutor");
      locali.start();
      this.xeM = locali;
      new com.tencent.mm.plugin.finder.cgi.fetcher.c(this.xHx.getContextObj());
      AppMethodBeat.o(274375);
    }
    
    public final void dead()
    {
      AppMethodBeat.i(274376);
      super.dead();
      Object localObject = this.xHw;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.finder.cgi.fetcher.c)localObject).xbq;
        if (localObject != null) {
          ((com.tencent.mm.vending.e.c)localObject).dead();
        }
      }
      localObject = this.xeM;
      if (localObject != null) {
        ((com.tencent.mm.loader.g.i)localObject).reset();
      }
      this.xeM = null;
      AppMethodBeat.o(274376);
    }
    
    public final void fetch(final Object paramObject, final com.tencent.mm.plugin.finder.feed.model.internal.h<com.tencent.mm.plugin.finder.model.c> paramh)
    {
      AppMethodBeat.i(274374);
      kotlin.g.b.p.k(paramh, "callback");
      if ((paramObject instanceof FinderLbsLoader.b))
      {
        com.tencent.mm.loader.g.i locali = this.xeM;
        if (locali != null)
        {
          locali.a(new com.tencent.mm.loader.g.h((kotlin.g.a.b)new a(this, paramObject, paramh)));
          AppMethodBeat.o(274374);
          return;
        }
      }
      AppMethodBeat.o(274374);
    }
    
    public final void fetchInit(com.tencent.mm.plugin.finder.feed.model.internal.h<com.tencent.mm.plugin.finder.model.c> paramh)
    {
      AppMethodBeat.i(274373);
      kotlin.g.b.p.k(paramh, "callback");
      LinkedList localLinkedList = new LinkedList();
      try
      {
        Object localObject1 = k.Anu;
        k.a.Qp(9);
        localLinkedList.addAll((Collection)k.a.aES(""));
        localObject1 = com.tencent.mm.kernel.h.aHG();
        kotlin.g.b.p.j(localObject1, "MMKernel.storage()");
        localObject1 = ((f)localObject1).aHp().get(ar.a.VzR, "");
        if (localObject1 != null) {
          break label147;
        }
        localObject1 = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(274373);
        throw ((Throwable)localObject1);
      }
      catch (Throwable localThrowable)
      {
        Log.printErrStackTrace(getTAG(), localThrowable, "lxl FinderLbsLoader load init data exception", new Object[0]);
      }
      Object localObject2 = new FinderLbsLoader.a(0, 0, "");
      ((FinderLbsLoader.a)localObject2).setPullType(1000);
      ((FinderLbsLoader.a)localObject2).setIncrementList((List)localLinkedList);
      paramh.onFetchDone((IResponse)localObject2);
      AppMethodBeat.o(274373);
      return;
      label147:
      localObject2 = Util.decodeHexString((String)localObject2);
      Object localObject3 = this.xHw;
      if (localObject3 != null)
      {
        localObject3 = ((com.tencent.mm.plugin.finder.cgi.fetcher.c)localObject3).xeY;
        if (localObject3 != null) {
          ((c.b)localObject3).xfe = com.tencent.mm.cd.b.cU((byte[])localObject2);
        }
      }
      localObject3 = getTAG();
      StringBuilder localStringBuilder = new StringBuilder("FinderLbsLoader load init data from FirstPage, size:").append(localLinkedList.size()).append(", lastBuffer:");
      localObject2 = this.xHw;
      if (localObject2 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.finder.cgi.fetcher.c)localObject2).xeY;
        if (localObject2 != null)
        {
          localObject2 = ((c.b)localObject2).xfe;
          if (localObject2 == null) {}
        }
      }
      for (localObject2 = ((com.tencent.mm.cd.b)localObject2).toByteArray();; localObject2 = null)
      {
        Log.i((String)localObject3, Util.encodeHexString((byte[])localObject2));
        break;
      }
    }
    
    public final void fetchLoadMore(com.tencent.mm.plugin.finder.feed.model.internal.h<com.tencent.mm.plugin.finder.model.c> paramh)
    {
      AppMethodBeat.i(274372);
      kotlin.g.b.p.k(paramh, "callback");
      fetch(new FinderLbsLoader.b(2), paramh);
      AppMethodBeat.o(274372);
    }
    
    public final void fetchRefresh(com.tencent.mm.plugin.finder.feed.model.internal.h<com.tencent.mm.plugin.finder.model.c> paramh)
    {
      AppMethodBeat.i(274370);
      kotlin.g.b.p.k(paramh, "callback");
      fetch(new FinderLbsLoader.b(4), paramh);
      AppMethodBeat.o(274370);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.b<com.tencent.mm.loader.g.h, x>
    {
      a(FinderLbsLoader.c paramc, Object paramObject, com.tencent.mm.plugin.finder.feed.model.internal.h paramh)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/model/FinderLbsLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
  public static final class d
    extends BaseFeedLoader<com.tencent.mm.plugin.finder.model.c>.a
  {
    d()
    {
      super();
    }
    
    public final void mergeRefresh(final IResponse<com.tencent.mm.plugin.finder.model.c> paramIResponse, final kotlin.g.a.b<? super IResponse<com.tencent.mm.plugin.finder.model.c>, x> paramb)
    {
      AppMethodBeat.i(271674);
      kotlin.g.b.p.k(paramIResponse, "response");
      Object localObject = RefreshLoadMoreLayout.c.YNO;
      localObject = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.ihs());
      boolean bool;
      if ((paramIResponse.getErrType() == 0) && (paramIResponse.getErrCode() == 0))
      {
        ((RefreshLoadMoreLayout.c)localObject).YND = 1;
        if (paramIResponse.getPullType() == 0) {
          break label204;
        }
        bool = true;
        label57:
        ((RefreshLoadMoreLayout.c)localObject).mCI = bool;
        ((RefreshLoadMoreLayout.c)localObject).YNF = paramIResponse.getHasMore();
        if ((((RefreshLoadMoreLayout.c)localObject).actionType == 0) || (((RefreshLoadMoreLayout.c)localObject).actionType == 4) || (((RefreshLoadMoreLayout.c)localObject).actionType == 4)) {
          if ((((RefreshLoadMoreLayout.c)localObject).YNG <= 0) && (this.xHx.getDataListJustForAdapter().size() > 0)) {
            break label209;
          }
        }
      }
      Context localContext;
      for (((RefreshLoadMoreLayout.c)localObject).YNE = null;; ((RefreshLoadMoreLayout.c)localObject).YNE = ((CharSequence)localContext.getResources().getString(b.j.finder_tl_no_more_refresh_nomore_nocontent_header)))
      {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this, new com.tencent.mm.plugin.finder.feed.model.internal.q(4, paramIResponse.getIncrementList(), false, 12), (RefreshLoadMoreLayout.c)localObject, paramb, paramIResponse));
        AppMethodBeat.o(271674);
        return;
        localContext = MMApplicationContext.getContext();
        kotlin.g.b.p.j(localContext, "MMApplicationContext.getContext()");
        ((RefreshLoadMoreLayout.c)localObject).YNE = ((CharSequence)localContext.getResources().getString(b.j.finder_tl_no_more_refresh_nomore_err_header));
        ((RefreshLoadMoreLayout.c)localObject).YND = -1;
        break;
        label204:
        bool = false;
        break label57;
        label209:
        localContext = MMApplicationContext.getContext();
        kotlin.g.b.p.j(localContext, "MMApplicationContext.getContext()");
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(FinderLbsLoader.d paramd, com.tencent.mm.plugin.finder.feed.model.internal.q paramq, RefreshLoadMoreLayout.c paramc, kotlin.g.a.b paramb, IResponse paramIResponse)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
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