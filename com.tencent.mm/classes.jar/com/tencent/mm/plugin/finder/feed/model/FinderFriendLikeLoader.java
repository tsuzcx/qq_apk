package com.tencent.mm.plugin.finder.feed.model;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.finder.cgi.bm;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.feed.model.internal.n;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.utils.aa;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "targetUsername", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "onFetchDone", "getOnFetchDone", "setOnFetchDone", "getTargetUsername", "()Ljava/lang/String;", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "response", "Companion", "FriendLikeDataFetcher", "LikedTimelineResponse", "plugin-finder_release"})
public final class FinderFriendLikeLoader
  extends BaseFinderFeedLoader
{
  private static final ConcurrentHashMap<String, List<bo>> tVA;
  public static final a tVB;
  public kotlin.g.a.b<? super IResponse<bo>, x> fetchEndCallback;
  private boolean hasMore;
  public kotlin.g.a.b<? super IResponse<bo>, x> tVz;
  final String tvp;
  
  static
  {
    AppMethodBeat.i(244650);
    tVB = new a((byte)0);
    tVA = new ConcurrentHashMap();
    AppMethodBeat.o(244650);
  }
  
  public FinderFriendLikeLoader(String paramString, bbn parambbn)
  {
    super(parambbn);
    AppMethodBeat.i(244649);
    this.tvp = paramString;
    AppMethodBeat.o(244649);
  }
  
  public final g<bo> createDataFetch()
  {
    AppMethodBeat.i(244646);
    g localg = (g)new b();
    AppMethodBeat.o(244646);
    return localg;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.b<bo> createDataMerger()
  {
    AppMethodBeat.i(244647);
    com.tencent.mm.plugin.finder.feed.model.internal.b localb = (com.tencent.mm.plugin.finder.feed.model.internal.b)new d(this);
    AppMethodBeat.o(244647);
    return localb;
  }
  
  public final void onFetchDone(IResponse<bo> paramIResponse)
  {
    AppMethodBeat.i(244648);
    p.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(244648);
      return;
    }
    kotlin.g.a.b localb = this.tVz;
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
        AppMethodBeat.o(244648);
        return;
      }
    }
    AppMethodBeat.o(244648);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader$Companion;", "", "()V", "cacheMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader$FriendLikeDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader$LikedTimelineResponse;", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetLikedList;", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
  public final class b
    extends com.tencent.mm.plugin.finder.feed.model.internal.a
  {
    public final IResponse<bo> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(244642);
      p.h(paramq, "scene");
      bm localbm = (bm)paramq;
      if (paramInt2 == -4100)
      {
        paramq = aa.vYi;
        aa.aww(this.tVC.tvp);
      }
      boolean bool;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        if (localbm.cYA() == 1)
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
        paramq = localbm.tvo;
        if (paramq == null) {
          break label293;
        }
        Object localObject = (Iterable)paramq;
        paramq = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          FinderItem localFinderItem = (FinderItem)((Iterator)localObject).next();
          c.a locala = c.vGN;
          paramq.add(c.a.s(localFinderItem));
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
        paramString.setPullType(localbm.pullType);
        paramString.setLastBuffer(localbm.cYz());
        paramString.setHasMore(bool);
        if (localbm.pullType == 0)
        {
          paramq = paramString.getIncrementList();
          if (paramq != null) {
            FinderFriendLikeLoader.ddz().put(this.tVC.tvp, paramq);
          }
        }
        paramString = (IResponse)paramString;
        AppMethodBeat.o(244642);
        return paramString;
      }
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(244639);
      List localList = j.listOf(Integer.valueOf(3965));
      AppMethodBeat.o(244639);
      return localList;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader$LikedTimelineResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
  public static final class c
    extends IResponse<bo>
  {
    public c(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
  public static final class d
    extends BaseFeedLoader<bo>.a
  {
    d()
    {
      super();
    }
    
    public final void mergeRefresh(final IResponse<bo> paramIResponse, final kotlin.g.a.b<? super IResponse<bo>, x> paramb)
    {
      AppMethodBeat.i(244645);
      p.h(paramIResponse, "response");
      final RefreshLoadMoreLayout.c localc = new RefreshLoadMoreLayout.c(paramIResponse.getPullType());
      Context localContext;
      if ((paramIResponse.getErrType() == 0) && (paramIResponse.getErrCode() == 0))
      {
        localContext = MMApplicationContext.getContext();
        p.g(localContext, "MMApplicationContext.getContext()");
        localc.Rmi = ((CharSequence)localContext.getResources().getString(2131760628));
        localc.Rmh = 1;
        if (paramIResponse.getPullType() == 0) {
          break label231;
        }
      }
      label231:
      for (boolean bool = true;; bool = false)
      {
        localc.jLE = bool;
        localc.Rmj = paramIResponse.getHasMore();
        if (((localc.actionType == 0) || (localc.actionType == 4)) && (localc.Rmk > 0)) {
          localc.Rmi = null;
        }
        Log.i(this.tVC.getTAG(), "[onFetchRefreshDone]  reason=".concat(String.valueOf(localc)));
        d.h((kotlin.g.a.a)new a(this, new n(7, paramIResponse.getIncrementList(), paramIResponse.isNeedClear(), 8), localc, paramb, paramIResponse));
        AppMethodBeat.o(244645);
        return;
        localContext = MMApplicationContext.getContext();
        p.g(localContext, "MMApplicationContext.getContext()");
        localc.Rmi = ((CharSequence)localContext.getResources().getString(2131760645));
        localc.Rmh = -1;
        break;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(FinderFriendLikeLoader.d paramd, n paramn, RefreshLoadMoreLayout.c paramc, kotlin.g.a.b paramb, IResponse paramIResponse)
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