package com.tencent.mm.plugin.finder.feed.model;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.cn;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.c;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.feed.model.internal.r;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.plugin.finder.utils.ay;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "targetUsername", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "onFetchDone", "getOnFetchDone", "setOnFetchDone", "getTargetUsername", "()Ljava/lang/String;", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "response", "Companion", "FriendLikeDataFetcher", "LikedTimelineResponse", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderFriendLikeLoader
  extends BaseFinderFeedLoader
{
  public static final a Bgu;
  private static final ConcurrentHashMap<String, List<cc>> Bgw;
  final String ACm;
  public b<? super IResponse<cc>, ah> Bgv;
  public b<? super IResponse<cc>, ah> fetchEndCallback;
  private boolean hasMore;
  
  static
  {
    AppMethodBeat.i(366350);
    Bgu = new a((byte)0);
    Bgw = new ConcurrentHashMap();
    AppMethodBeat.o(366350);
  }
  
  public FinderFriendLikeLoader(String paramString, bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(366342);
    this.ACm = paramString;
    AppMethodBeat.o(366342);
  }
  
  public final i<cc> createDataFetch()
  {
    AppMethodBeat.i(366358);
    i locali = (i)new b();
    AppMethodBeat.o(366358);
    return locali;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.d<cc> createDataMerger()
  {
    AppMethodBeat.i(366365);
    com.tencent.mm.plugin.finder.feed.model.internal.d locald = (com.tencent.mm.plugin.finder.feed.model.internal.d)new d(this);
    AppMethodBeat.o(366365);
    return locald;
  }
  
  public final void onFetchDone(IResponse<cc> paramIResponse)
  {
    AppMethodBeat.i(366376);
    s.u(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(366376);
      return;
    }
    b localb = this.Bgv;
    if (localb != null) {
      localb.invoke(paramIResponse);
    }
    this.hasMore = paramIResponse.getHasMore();
    if (!paramIResponse.getHasMore())
    {
      localb = this.fetchEndCallback;
      if (localb != null) {
        localb.invoke(paramIResponse);
      }
    }
    AppMethodBeat.o(366376);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader$Companion;", "", "()V", "cacheMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader$FriendLikeDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader$LikedTimelineResponse;", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetLikedList;", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends c
  {
    public b()
    {
      AppMethodBeat.i(366097);
      AppMethodBeat.o(366097);
    }
    
    public final IResponse<cc> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
    {
      AppMethodBeat.i(366112);
      s.u(paramp, "scene");
      Object localObject1 = (cn)paramp;
      if (paramInt2 == -4100)
      {
        paramp = ay.Gjp;
        ay.aBZ(this.Bgx.ACm);
      }
      boolean bool;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        if (((cn)localObject1).dVZ() == 1)
        {
          bool = true;
          if (paramInt2 == -4100) {
            break label200;
          }
          paramString = new FinderFriendLikeLoader.c(paramInt1, paramInt2, paramString);
          label79:
          paramp = ((cn)localObject1).ACl;
          if (paramp != null) {
            break label215;
          }
        }
      }
      for (paramp = null;; paramp = (List)paramp)
      {
        paramString.setIncrementList(paramp);
        paramString.setPullType(((cn)localObject1).pullType);
        paramString.setLastBuffer(((cn)localObject1).dVY());
        paramString.setHasMore(bool);
        if (((cn)localObject1).pullType == 0)
        {
          paramp = paramString.getIncrementList();
          if (paramp != null)
          {
            localObject1 = this.Bgx;
            FinderFriendLikeLoader.edS().put(((FinderFriendLikeLoader)localObject1).ACm, paramp);
          }
        }
        paramString = (IResponse)paramString;
        AppMethodBeat.o(366112);
        return paramString;
        bool = false;
        break;
        if (paramInt2 != -4100)
        {
          bool = true;
          break;
        }
        bool = false;
        break;
        label200:
        paramString = new FinderFriendLikeLoader.c(0, 0, "");
        break label79;
        label215:
        Object localObject2 = (Iterable)paramp;
        paramp = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          FinderItem localFinderItem = (FinderItem)((Iterator)localObject2).next();
          d.a locala = com.tencent.mm.plugin.finder.storage.logic.d.FND;
          paramp.add(d.a.a(localFinderItem));
        }
      }
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(366100);
      List localList = kotlin.a.p.listOf(Integer.valueOf(3965));
      AppMethodBeat.o(366100);
      return localList;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader$LikedTimelineResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends IResponse<cc>
  {
    public c(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends BaseFeedLoader<cc>.a
  {
    d(FinderFriendLikeLoader paramFinderFriendLikeLoader)
    {
      super(false, 1, null);
      AppMethodBeat.i(366085);
      AppMethodBeat.o(366085);
    }
    
    public final void mergeRefresh(final IResponse<cc> paramIResponse, final b<? super IResponse<cc>, ah> paramb)
    {
      AppMethodBeat.i(366093);
      s.u(paramIResponse, "response");
      final RefreshLoadMoreLayout.d locald = new RefreshLoadMoreLayout.d(paramIResponse.getPullType());
      if ((paramIResponse.getErrType() == 0) && (paramIResponse.getErrCode() == 0))
      {
        locald.agJt = ((CharSequence)MMApplicationContext.getContext().getResources().getString(e.h.finder_timeline_refresh_nothing_tip));
        locald.agJs = 1;
        if (paramIResponse.getPullType() == 0) {
          break label212;
        }
      }
      label212:
      for (boolean bool = true;; bool = false)
      {
        locald.pzq = bool;
        locald.agJu = paramIResponse.getHasMore();
        if (((locald.actionType == 0) || (locald.actionType == 4)) && (locald.agJv > 0)) {
          locald.agJt = null;
        }
        Log.i(this.Bgx.getTAG(), s.X("[onFetchRefreshDone]  reason=", locald));
        com.tencent.mm.ae.d.uiThread((a)new a(this, new r(7, paramIResponse.getIncrementList(), paramIResponse.isNeedClear(), 8), locald, this.Bgx, paramb, paramIResponse));
        AppMethodBeat.o(366093);
        return;
        locald.agJt = ((CharSequence)MMApplicationContext.getContext().getResources().getString(e.h.finder_touch_to_retry));
        locald.agJs = -1;
        break;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements a<ah>
    {
      a(FinderFriendLikeLoader.d paramd, r<cc> paramr, RefreshLoadMoreLayout.d<Object> paramd1, FinderFriendLikeLoader paramFinderFriendLikeLoader, b<? super IResponse<cc>, ah> paramb, IResponse<cc> paramIResponse)
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