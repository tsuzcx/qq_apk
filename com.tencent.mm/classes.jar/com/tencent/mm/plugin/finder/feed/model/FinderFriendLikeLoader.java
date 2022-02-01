package com.tencent.mm.plugin.finder.feed.model;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.bp;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.utils.am;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a.j;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "targetUsername", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "onFetchDone", "getOnFetchDone", "setOnFetchDone", "getTargetUsername", "()Ljava/lang/String;", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "response", "Companion", "FriendLikeDataFetcher", "LikedTimelineResponse", "plugin-finder_release"})
public final class FinderFriendLikeLoader
  extends BaseFinderFeedLoader
{
  private static final ConcurrentHashMap<String, List<bu>> xHs;
  public static final a xHt;
  public b<? super IResponse<bu>, x> fetchEndCallback;
  private boolean hasMore;
  public b<? super IResponse<bu>, x> xHr;
  final String xcW;
  
  static
  {
    AppMethodBeat.i(291042);
    xHt = new a((byte)0);
    xHs = new ConcurrentHashMap();
    AppMethodBeat.o(291042);
  }
  
  public FinderFriendLikeLoader(String paramString, bid parambid)
  {
    super(parambid);
    AppMethodBeat.i(291041);
    this.xcW = paramString;
    AppMethodBeat.o(291041);
  }
  
  public final i<bu> createDataFetch()
  {
    AppMethodBeat.i(291037);
    i locali = (i)new b();
    AppMethodBeat.o(291037);
    return locali;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.d<bu> createDataMerger()
  {
    AppMethodBeat.i(291038);
    com.tencent.mm.plugin.finder.feed.model.internal.d locald = (com.tencent.mm.plugin.finder.feed.model.internal.d)new d(this);
    AppMethodBeat.o(291038);
    return locald;
  }
  
  public final void onFetchDone(IResponse<bu> paramIResponse)
  {
    AppMethodBeat.i(291039);
    p.k(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(291039);
      return;
    }
    b localb = this.xHr;
    if (localb != null) {
      localb.invoke(paramIResponse);
    }
    this.hasMore = paramIResponse.getHasMore();
    if (!paramIResponse.getHasMore())
    {
      localb = this.fetchEndCallback;
      if (localb != null)
      {
        localb.invoke(paramIResponse);
        AppMethodBeat.o(291039);
        return;
      }
    }
    AppMethodBeat.o(291039);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader$Companion;", "", "()V", "cacheMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader$FriendLikeDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader$LikedTimelineResponse;", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetLikedList;", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
  public final class b
    extends com.tencent.mm.plugin.finder.feed.model.internal.c
  {
    public final IResponse<bu> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
    {
      AppMethodBeat.i(278138);
      p.k(paramq, "scene");
      bp localbp = (bp)paramq;
      if (paramInt2 == -4100)
      {
        paramq = am.AGR;
        am.aFY(this.xHu.xcW);
      }
      boolean bool;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        if (localbp.doo() == 1)
        {
          bool = true;
          if (paramInt2 == -4100) {
            break label194;
          }
        }
      }
      label194:
      for (paramString = new FinderFriendLikeLoader.c(paramInt1, paramInt2, paramString);; paramString = new FinderFriendLikeLoader.c(0, 0, ""))
      {
        paramq = localbp.xcV;
        if (paramq == null) {
          break label293;
        }
        Object localObject = (Iterable)paramq;
        paramq = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          FinderItem localFinderItem = (FinderItem)((Iterator)localObject).next();
          c.a locala = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
          paramq.add(c.a.a(localFinderItem));
        }
        bool = false;
        break;
        if (paramInt2 != -4100)
        {
          bool = true;
          break;
        }
        bool = false;
        break;
      }
      label293:
      for (paramq = (List)paramq;; paramq = null)
      {
        paramString.setIncrementList(paramq);
        paramString.setPullType(localbp.pullType);
        paramString.setLastBuffer(localbp.don());
        paramString.setHasMore(bool);
        if (localbp.pullType == 0)
        {
          paramq = paramString.getIncrementList();
          if (paramq != null) {
            FinderFriendLikeLoader.dus().put(this.xHu.xcW, paramq);
          }
        }
        paramString = (IResponse)paramString;
        AppMethodBeat.o(278138);
        return paramString;
      }
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(278135);
      List localList = j.listOf(Integer.valueOf(3965));
      AppMethodBeat.o(278135);
      return localList;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader$LikedTimelineResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
  public static final class c
    extends IResponse<bu>
  {
    public c(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
  public static final class d
    extends BaseFeedLoader<bu>.a
  {
    d()
    {
      super();
    }
    
    public final void mergeRefresh(final IResponse<bu> paramIResponse, final b<? super IResponse<bu>, x> paramb)
    {
      AppMethodBeat.i(265205);
      p.k(paramIResponse, "response");
      final RefreshLoadMoreLayout.c localc = new RefreshLoadMoreLayout.c(paramIResponse.getPullType());
      Context localContext;
      if ((paramIResponse.getErrType() == 0) && (paramIResponse.getErrCode() == 0))
      {
        localContext = MMApplicationContext.getContext();
        p.j(localContext, "MMApplicationContext.getContext()");
        localc.YNE = ((CharSequence)localContext.getResources().getString(b.j.finder_timeline_refresh_nothing_tip));
        localc.YND = 1;
        if (paramIResponse.getPullType() == 0) {
          break label233;
        }
      }
      label233:
      for (boolean bool = true;; bool = false)
      {
        localc.mCI = bool;
        localc.YNF = paramIResponse.getHasMore();
        if (((localc.actionType == 0) || (localc.actionType == 4)) && (localc.YNG > 0)) {
          localc.YNE = null;
        }
        Log.i(this.xHu.getTAG(), "[onFetchRefreshDone]  reason=".concat(String.valueOf(localc)));
        com.tencent.mm.ae.d.uiThread((a)new a(this, new com.tencent.mm.plugin.finder.feed.model.internal.q(7, paramIResponse.getIncrementList(), paramIResponse.isNeedClear(), 8), localc, paramb, paramIResponse));
        AppMethodBeat.o(265205);
        return;
        localContext = MMApplicationContext.getContext();
        p.j(localContext, "MMApplicationContext.getContext()");
        localc.YNE = ((CharSequence)localContext.getResources().getString(b.j.finder_touch_to_retry));
        localc.YND = -1;
        break;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements a<x>
    {
      a(FinderFriendLikeLoader.d paramd, com.tencent.mm.plugin.finder.feed.model.internal.q paramq, RefreshLoadMoreLayout.c paramc, b paramb, IResponse paramIResponse)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderFriendLikeLoader
 * JD-Core Version:    0.7.0.1
 */