package com.tencent.mm.plugin.finder.feed.model;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.cn;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.c;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.feed.model.internal.r;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "isTimeLine", "", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ZLcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "fetchEndCallback", "Lkotlin/Function0;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function0;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "fetchRefreshCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader$LikedTimelineResponse;", "getFetchRefreshCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchRefreshCallback", "(Lkotlin/jvm/functions/Function1;)V", "hasMore", "getHasMore", "()Z", "setHasMore", "(Z)V", "getScene", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "totalCount", "", "getTotalCount", "()I", "setTotalCount", "(I)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "getPageName", "onFetchDone", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "onFetchRefreshDone", "LikedDataFetcher", "LikedTimelineResponse", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLikedFeedLoader
  extends BaseFinderFeedLoader
{
  public a<ah> BbB;
  private final g BgY;
  public b<? super b, ah> BgZ;
  public boolean hasMore;
  public int lNX;
  final boolean oZh;
  
  public FinderLikedFeedLoader(boolean paramBoolean, g paramg, bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(366381);
    this.oZh = paramBoolean;
    this.BgY = paramg;
    this.hasMore = true;
    AppMethodBeat.o(366381);
  }
  
  public final i<cc> createDataFetch()
  {
    AppMethodBeat.i(366387);
    i locali = (i)new a();
    AppMethodBeat.o(366387);
    return locali;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.d<cc> createDataMerger()
  {
    AppMethodBeat.i(366391);
    com.tencent.mm.plugin.finder.feed.model.internal.d locald = (com.tencent.mm.plugin.finder.feed.model.internal.d)new c(this);
    AppMethodBeat.o(366391);
    return locald;
  }
  
  public final int getPageName()
  {
    return 2;
  }
  
  public final void onFetchDone(IResponse<cc> paramIResponse)
  {
    AppMethodBeat.i(166040);
    s.u(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(166040);
      return;
    }
    this.hasMore = paramIResponse.getHasMore();
    if (2 == paramIResponse.getPullType()) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (!paramIResponse.getHasMore()))
      {
        paramIResponse = this.BbB;
        if (paramIResponse != null) {
          paramIResponse.invoke();
        }
      }
      AppMethodBeat.o(166040);
      return;
    }
  }
  
  public final void onFetchRefreshDone(IResponse<cc> paramIResponse)
  {
    AppMethodBeat.i(366403);
    s.u(paramIResponse, "response");
    super.onFetchRefreshDone(paramIResponse);
    if ((paramIResponse instanceof b))
    {
      this.lNX = ((b)paramIResponse).lNX;
      b localb = this.BgZ;
      if (localb != null) {
        localb.invoke(paramIResponse);
      }
    }
    AppMethodBeat.o(366403);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader$LikedDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader$LikedTimelineResponse;", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetLikedList;", "getCmdIds", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends c
  {
    public a()
    {
      AppMethodBeat.i(366410);
      AppMethodBeat.o(366410);
    }
    
    public final IResponse<cc> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
    {
      AppMethodBeat.i(366437);
      s.u(paramp, "scene");
      paramp = (cn)paramp;
      boolean bool;
      FinderLikedFeedLoader.b localb;
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramp.dVZ() != 1))
      {
        bool = false;
        localb = new FinderLikedFeedLoader.b(paramInt1, paramInt2, paramString, (byte)0);
        paramString = paramp.ACl;
        if (paramString != null) {
          break label136;
        }
      }
      for (paramString = null;; paramString = (List)paramString)
      {
        localb.setIncrementList(paramString);
        localb.setPullType(paramp.pullType);
        localb.setLastBuffer(paramp.dVY());
        localb.setHasMore(bool);
        localb.lNX = paramp.getCount();
        localb.BfD = paramp.dVX();
        paramString = (IResponse)localb;
        AppMethodBeat.o(366437);
        return paramString;
        bool = true;
        break;
        label136:
        Object localObject = (Iterable)paramString;
        paramString = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject, 10));
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          FinderItem localFinderItem = (FinderItem)((Iterator)localObject).next();
          d.a locala = com.tencent.mm.plugin.finder.storage.logic.d.FND;
          paramString.add(d.a.a(localFinderItem));
        }
      }
    }
    
    public final com.tencent.mm.am.p genLoadMoreNetScene()
    {
      long l2 = 0L;
      AppMethodBeat.i(366426);
      Object localObject = (BaseFinderFeed)this.Bha.getLastItemOfType(BaseFinderFeed.class);
      long l1;
      if (localObject == null) {
        l1 = l2;
      }
      for (;;)
      {
        localObject = (com.tencent.mm.am.p)new cn(l1, this.Bha.getLastBuffer(), 2, null, this.Bha.getContextObj(), 0, false, 104);
        AppMethodBeat.o(366426);
        return localObject;
        localObject = ((BaseFinderFeed)localObject).feedObject;
        l1 = l2;
        if (localObject != null)
        {
          localObject = ((FinderItem)localObject).getFeedObject();
          l1 = l2;
          if (localObject != null) {
            l1 = ((FinderObject)localObject).displayId;
          }
        }
      }
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(366416);
      List localList = kotlin.a.p.listOf(Integer.valueOf(3965));
      AppMethodBeat.o(366416);
      return localList;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader$LikedTimelineResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "totalCount", "megaVideoCount", "(IILjava/lang/String;II)V", "getMegaVideoCount", "()I", "setMegaVideoCount", "(I)V", "getTotalCount", "setTotalCount", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends IResponse<cc>
  {
    public int BfD = 0;
    public int lNX = 0;
    
    private b(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends BaseFeedLoader<cc>.a
  {
    c(FinderLikedFeedLoader paramFinderLikedFeedLoader)
    {
      super(false, 1, null);
      AppMethodBeat.i(366393);
      AppMethodBeat.o(366393);
    }
    
    public final void mergeRefresh(final IResponse<cc> paramIResponse, final b<? super IResponse<cc>, ah> paramb)
    {
      int i = 0;
      AppMethodBeat.i(366406);
      s.u(paramIResponse, "response");
      final RefreshLoadMoreLayout.d locald = new RefreshLoadMoreLayout.d(paramIResponse.getPullType());
      boolean bool;
      label76:
      List localList;
      if ((paramIResponse.getErrType() == 0) && (paramIResponse.getErrCode() == 0))
      {
        locald.agJt = ((CharSequence)MMApplicationContext.getContext().getResources().getString(e.h.finder_timeline_refresh_nothing_tip));
        locald.agJs = 1;
        if (paramIResponse.getPullType() == 0) {
          break label264;
        }
        bool = true;
        locald.pzq = bool;
        locald.agJu = paramIResponse.getHasMore();
        if (((locald.actionType == 0) || (locald.actionType == 4)) && (locald.agJv > 0)) {
          locald.agJt = null;
        }
        locald.extra = Integer.valueOf(((FinderLikedFeedLoader.b)paramIResponse).lNX);
        Log.i(this.Bha.getTAG(), s.X("[onFetchRefreshDone]  reason=", locald));
        localList = paramIResponse.getIncrementList();
        if (localList != null) {
          break label270;
        }
        label166:
        if (!paramIResponse.getHasMore()) {
          break label286;
        }
        if (i <= this.Bha.getDataList().size()) {
          break label281;
        }
        i = 4;
      }
      for (;;)
      {
        com.tencent.mm.ae.d.uiThread((a)new a(this, new r(i, paramIResponse.getIncrementList(), paramIResponse.isNeedClear(), 8), locald, this.Bha, paramb, paramIResponse));
        AppMethodBeat.o(366406);
        return;
        locald.agJt = ((CharSequence)MMApplicationContext.getContext().getResources().getString(e.h.finder_touch_to_retry));
        locald.agJs = -1;
        break;
        label264:
        bool = false;
        break label76;
        label270:
        i = localList.size();
        break label166;
        label281:
        i = 2;
        continue;
        label286:
        if ((this.Bha.getDataList().size() != 0) && (i != 0) && (this.Bha.getDataList().size() > i)) {
          i = 4;
        } else {
          i = 6;
        }
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements a<ah>
    {
      a(FinderLikedFeedLoader.c paramc, r<cc> paramr, RefreshLoadMoreLayout.d<Object> paramd, FinderLikedFeedLoader paramFinderLikedFeedLoader, b<? super IResponse<cc>, ah> paramb, IResponse<cc> paramIResponse)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderLikedFeedLoader
 * JD-Core Version:    0.7.0.1
 */