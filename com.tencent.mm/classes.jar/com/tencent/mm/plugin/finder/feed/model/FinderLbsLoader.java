package com.tencent.mm.plugin.finder.feed.model;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.loader.f.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.ar.c;
import com.tencent.mm.plugin.finder.cgi.fetcher.c.a;
import com.tencent.mm.plugin.finder.cgi.fetcher.c.b;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.r;
import com.tencent.mm.plugin.finder.storage.data.k;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.storage.data.t;
import com.tencent.mm.plugin.finder.storage.q;
import com.tencent.mm.plugin.finder.storage.y;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "onFetchDone", "response", "FinderLbsResponse", "FinderLbsReuqest", "LbsDataFetcher", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLbsLoader
  extends BaseFeedLoader<com.tencent.mm.plugin.finder.model.c>
{
  public kotlin.g.a.b<? super IResponse<com.tencent.mm.plugin.finder.model.c>, ah> fetchEndCallback;
  
  private FinderLbsLoader(byte paramByte)
  {
    this();
  }
  
  public FinderLbsLoader(bui parambui)
  {
    super(parambui);
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.i<com.tencent.mm.plugin.finder.model.c> createDataFetch()
  {
    AppMethodBeat.i(366128);
    com.tencent.mm.plugin.finder.feed.model.internal.i locali = (com.tencent.mm.plugin.finder.feed.model.internal.i)new c();
    AppMethodBeat.o(366128);
    return locali;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.d<com.tencent.mm.plugin.finder.model.c> createDataMerger()
  {
    AppMethodBeat.i(366131);
    com.tencent.mm.plugin.finder.feed.model.internal.d locald = (com.tencent.mm.plugin.finder.feed.model.internal.d)new d(this);
    AppMethodBeat.o(366131);
    return locald;
  }
  
  public final void onFetchDone(IResponse<com.tencent.mm.plugin.finder.model.c> paramIResponse)
  {
    AppMethodBeat.i(366139);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramIResponse);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/model/FinderLbsLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V", this, localb.aYj());
    s.u(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/FinderLbsLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
      AppMethodBeat.o(366139);
      return;
    }
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new e(paramIResponse, this));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/FinderLbsLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
    AppMethodBeat.o(366139);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader$FinderLbsResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends IResponse<com.tencent.mm.plugin.finder.model.c>
  {
    public a(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader$FinderLbsReuqest;", "", "pullType", "", "(I)V", "getPullType", "()I", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    final int pullType;
    
    public b(int paramInt)
    {
      this.pullType = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader$LbsDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader;)V", "callBack", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "getCallBack", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "setCallBack", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;)V", "fetcher", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher;", "taskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "alive", "", "dead", "fetch", "request", "", "callback", "isAuto", "", "fetchInit", "fetchLoadMore", "fetchRefresh", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends com.tencent.mm.plugin.finder.feed.model.internal.i<com.tencent.mm.plugin.finder.model.c>
  {
    private com.tencent.mm.loader.f.h ADY;
    private com.tencent.mm.plugin.finder.cgi.fetcher.c BgK;
    
    public c()
    {
      AppMethodBeat.i(366433);
      AppMethodBeat.o(366433);
    }
    
    public final void alive()
    {
      AppMethodBeat.i(366488);
      super.alive();
      this.BgK = new com.tencent.mm.plugin.finder.cgi.fetcher.c(this.BgL.getContextObj());
      com.tencent.mm.loader.f.h localh = new com.tencent.mm.loader.f.h("FinderFollowTlSingleExecutor");
      localh.start();
      ah localah = ah.aiuX;
      this.ADY = localh;
      new com.tencent.mm.plugin.finder.cgi.fetcher.c(this.BgL.getContextObj());
      AppMethodBeat.o(366488);
    }
    
    public final void dead()
    {
      AppMethodBeat.i(366495);
      super.dead();
      Object localObject = this.BgK;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.finder.cgi.fetcher.c)localObject).AAh;
        if (localObject != null) {
          ((com.tencent.mm.vending.e.c)localObject).dead();
        }
      }
      localObject = this.ADY;
      if (localObject != null) {
        ((com.tencent.mm.loader.f.h)localObject).reset();
      }
      this.ADY = null;
      AppMethodBeat.o(366495);
    }
    
    public final void fetch(final Object paramObject, final com.tencent.mm.plugin.finder.feed.model.internal.h<com.tencent.mm.plugin.finder.model.c> paramh, boolean paramBoolean)
    {
      AppMethodBeat.i(366481);
      s.u(paramh, "callback");
      if ((paramObject instanceof FinderLbsLoader.b))
      {
        com.tencent.mm.loader.f.h localh = this.ADY;
        if (localh != null) {
          localh.a(new g((kotlin.g.a.b)new a(this, paramObject, paramh)));
        }
      }
      AppMethodBeat.o(366481);
    }
    
    public final void fetchInit(com.tencent.mm.plugin.finder.feed.model.internal.h<com.tencent.mm.plugin.finder.model.c> paramh)
    {
      AppMethodBeat.i(366474);
      s.u(paramh, "callback");
      LinkedList localLinkedList = new LinkedList();
      try
      {
        Object localObject1 = k.FNg;
        k.a.Tw(9);
        localLinkedList.addAll((Collection)k.a.aAL(""));
        localObject1 = com.tencent.mm.kernel.h.baE().ban().get(at.a.adcg, "");
        if (localObject1 != null) {
          break label139;
        }
        localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(366474);
        throw ((Throwable)localObject1);
      }
      finally
      {
        Log.printErrStackTrace(getTAG(), localThrowable, "lxl FinderLbsLoader load init data exception", new Object[0]);
      }
      Object localObject2 = new FinderLbsLoader.a(0, 0, "");
      ((FinderLbsLoader.a)localObject2).setPullType(1000);
      ((FinderLbsLoader.a)localObject2).setIncrementList((List)localLinkedList);
      paramh.onFetchDone((IResponse)localObject2);
      AppMethodBeat.o(366474);
      return;
      label139:
      Object localObject3 = Util.decodeHexString((String)localObject2);
      localObject2 = this.BgK;
      label159:
      StringBuilder localStringBuilder;
      if (localObject2 == null)
      {
        localObject2 = null;
        if (localObject2 != null) {
          ((c.b)localObject2).AEm = com.tencent.mm.bx.b.cX((byte[])localObject3);
        }
        localObject3 = getTAG();
        localStringBuilder = new StringBuilder("FinderLbsLoader load init data from FirstPage, size:").append(localLinkedList.size()).append(", lastBuffer:");
        localObject2 = this.BgK;
        if (localObject2 != null) {
          break label242;
        }
        localObject2 = null;
      }
      for (;;)
      {
        Log.i((String)localObject3, Util.encodeHexString((byte[])localObject2));
        break;
        localObject2 = ((com.tencent.mm.plugin.finder.cgi.fetcher.c)localObject2).AEh;
        break label159;
        label242:
        localObject2 = ((com.tencent.mm.plugin.finder.cgi.fetcher.c)localObject2).AEh;
        if (localObject2 == null)
        {
          localObject2 = null;
        }
        else
        {
          localObject2 = ((c.b)localObject2).AEm;
          if (localObject2 == null) {
            localObject2 = null;
          } else {
            localObject2 = ((com.tencent.mm.bx.b)localObject2).toByteArray();
          }
        }
      }
    }
    
    public final void fetchLoadMore(com.tencent.mm.plugin.finder.feed.model.internal.h<com.tencent.mm.plugin.finder.model.c> paramh, boolean paramBoolean)
    {
      AppMethodBeat.i(366461);
      s.u(paramh, "callback");
      FinderLbsLoader.b localb = new FinderLbsLoader.b(2);
      com.tencent.mm.plugin.finder.feed.model.internal.i.fetch$default((com.tencent.mm.plugin.finder.feed.model.internal.i)this, localb, paramh, false, 4, null);
      AppMethodBeat.o(366461);
    }
    
    public final void fetchRefresh(com.tencent.mm.plugin.finder.feed.model.internal.h<com.tencent.mm.plugin.finder.model.c> paramh)
    {
      AppMethodBeat.i(366451);
      s.u(paramh, "callback");
      FinderLbsLoader.b localb = new FinderLbsLoader.b(4);
      com.tencent.mm.plugin.finder.feed.model.internal.i.fetch$default((com.tencent.mm.plugin.finder.feed.model.internal.i)this, localb, paramh, false, 4, null);
      AppMethodBeat.o(366451);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.b<g, ah>
    {
      a(FinderLbsLoader.c paramc, Object paramObject, com.tencent.mm.plugin.finder.feed.model.internal.h<com.tencent.mm.plugin.finder.model.c> paramh)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/model/FinderLbsLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends BaseFeedLoader<com.tencent.mm.plugin.finder.model.c>.a
  {
    d(FinderLbsLoader paramFinderLbsLoader)
    {
      super(false, 1, null);
      AppMethodBeat.i(366446);
      AppMethodBeat.o(366446);
    }
    
    public final void mergeRefresh(final IResponse<com.tencent.mm.plugin.finder.model.c> paramIResponse, final kotlin.g.a.b<? super IResponse<com.tencent.mm.plugin.finder.model.c>, ah> paramb)
    {
      AppMethodBeat.i(366466);
      s.u(paramIResponse, "response");
      Object localObject = RefreshLoadMoreLayout.d.agJr;
      localObject = new RefreshLoadMoreLayout.d(RefreshLoadMoreLayout.d.jMG());
      boolean bool;
      if ((paramIResponse.getErrType() == 0) && (paramIResponse.getErrCode() == 0))
      {
        ((RefreshLoadMoreLayout.d)localObject).agJs = 1;
        if (paramIResponse.getPullType() == 0) {
          break label197;
        }
        bool = true;
        label57:
        ((RefreshLoadMoreLayout.d)localObject).pzq = bool;
        ((RefreshLoadMoreLayout.d)localObject).agJu = paramIResponse.getHasMore();
        if ((((RefreshLoadMoreLayout.d)localObject).actionType == 0) || (((RefreshLoadMoreLayout.d)localObject).actionType == 4) || (((RefreshLoadMoreLayout.d)localObject).actionType == 4)) {
          if ((((RefreshLoadMoreLayout.d)localObject).agJv <= 0) && (this.BgL.getDataListJustForAdapter().size() > 0)) {
            break label202;
          }
        }
      }
      label197:
      label202:
      for (((RefreshLoadMoreLayout.d)localObject).agJt = null;; ((RefreshLoadMoreLayout.d)localObject).agJt = ((CharSequence)MMApplicationContext.getContext().getResources().getString(e.h.finder_tl_no_more_refresh_nomore_nocontent_header)))
      {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this, new r(4, paramIResponse.getIncrementList(), false, 12), (RefreshLoadMoreLayout.d)localObject, this.BgL, paramb, paramIResponse));
        AppMethodBeat.o(366466);
        return;
        ((RefreshLoadMoreLayout.d)localObject).agJt = ((CharSequence)MMApplicationContext.getContext().getResources().getString(e.h.finder_tl_no_more_refresh_nomore_err_header));
        ((RefreshLoadMoreLayout.d)localObject).agJs = -1;
        break;
        bool = false;
        break label57;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(FinderLbsLoader.d paramd, r<com.tencent.mm.plugin.finder.model.c> paramr, RefreshLoadMoreLayout.d<Object> paramd1, FinderLbsLoader paramFinderLbsLoader, kotlin.g.a.b<? super IResponse<com.tencent.mm.plugin.finder.model.c>, ah> paramb, IResponse<com.tencent.mm.plugin.finder.model.c> paramIResponse)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(IResponse<com.tencent.mm.plugin.finder.model.c> paramIResponse, FinderLbsLoader paramFinderLbsLoader)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderLbsLoader
 * JD-Core Version:    0.7.0.1
 */