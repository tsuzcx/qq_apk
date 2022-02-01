package com.tencent.mm.plugin.finder.feed.model;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.finder.cgi.bm;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.feed.model.internal.n;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "isTimeLine", "", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ZLcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "fetchEndCallback", "Lkotlin/Function0;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function0;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "fetchRefreshCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader$LikedTimelineResponse;", "getFetchRefreshCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchRefreshCallback", "(Lkotlin/jvm/functions/Function1;)V", "hasMore", "getHasMore", "()Z", "setHasMore", "(Z)V", "getScene", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "totalCount", "", "getTotalCount", "()I", "setTotalCount", "(I)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "getPageName", "onFetchDone", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "onFetchRefreshDone", "LikedDataFetcher", "LikedTimelineResponse", "plugin-finder_release"})
public final class FinderLikedFeedLoader
  extends BaseFinderFeedLoader
{
  public int gAZ;
  public boolean hasMore;
  final boolean jqK;
  public kotlin.g.a.a<x> tTS;
  public kotlin.g.a.b<? super b, x> tVS;
  private final e tVT;
  
  public FinderLikedFeedLoader(boolean paramBoolean, e parame, bbn parambbn)
  {
    super(parambbn);
    AppMethodBeat.i(244693);
    this.jqK = paramBoolean;
    this.tVT = parame;
    this.hasMore = true;
    AppMethodBeat.o(244693);
  }
  
  public final g<bo> createDataFetch()
  {
    AppMethodBeat.i(244690);
    g localg = (g)new a();
    AppMethodBeat.o(244690);
    return localg;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.b<bo> createDataMerger()
  {
    AppMethodBeat.i(244691);
    com.tencent.mm.plugin.finder.feed.model.internal.b localb = (com.tencent.mm.plugin.finder.feed.model.internal.b)new c(this);
    AppMethodBeat.o(244691);
    return localb;
  }
  
  public final int getPageName()
  {
    return 2;
  }
  
  public final void onFetchDone(IResponse<bo> paramIResponse)
  {
    AppMethodBeat.i(166040);
    p.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(166040);
      return;
    }
    this.hasMore = paramIResponse.getHasMore();
    if (2 == paramIResponse.getPullType()) {}
    for (int i = 1; (i != 0) && (!paramIResponse.getHasMore()); i = 0)
    {
      paramIResponse = this.tTS;
      if (paramIResponse == null) {
        break;
      }
      paramIResponse.invoke();
      AppMethodBeat.o(166040);
      return;
    }
    AppMethodBeat.o(166040);
  }
  
  public final void onFetchRefreshDone(IResponse<bo> paramIResponse)
  {
    AppMethodBeat.i(244692);
    p.h(paramIResponse, "response");
    super.onFetchRefreshDone(paramIResponse);
    if ((paramIResponse instanceof b))
    {
      this.gAZ = ((b)paramIResponse).gAZ;
      kotlin.g.a.b localb = this.tVS;
      if (localb != null)
      {
        localb.invoke(paramIResponse);
        AppMethodBeat.o(244692);
        return;
      }
    }
    AppMethodBeat.o(244692);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader$LikedDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader$LikedTimelineResponse;", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetLikedList;", "getCmdIds", "", "plugin-finder_release"})
  public final class a
    extends com.tencent.mm.plugin.finder.feed.model.internal.a
  {
    public final IResponse<bo> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(244686);
      p.h(paramq, "scene");
      paramq = (bm)paramq;
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramq.cYA() != 1)) {}
      FinderLikedFeedLoader.b localb;
      for (boolean bool = false;; bool = true)
      {
        localb = new FinderLikedFeedLoader.b(paramInt1, paramInt2, paramString, (byte)0);
        paramString = paramq.tvo;
        if (paramString == null) {
          break label214;
        }
        Object localObject = (Iterable)paramString;
        paramString = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          FinderItem localFinderItem = (FinderItem)((Iterator)localObject).next();
          c.a locala = c.vGN;
          paramString.add(c.a.s(localFinderItem));
        }
      }
      label214:
      for (paramString = (List)paramString;; paramString = null)
      {
        localb.setIncrementList(paramString);
        localb.setPullType(paramq.pullType);
        localb.setLastBuffer(paramq.cYz());
        localb.setHasMore(bool);
        localb.gAZ = paramq.getCount();
        localb.tUU = paramq.cYy();
        paramString = (IResponse)localb;
        AppMethodBeat.o(244686);
        return paramString;
      }
    }
    
    public final com.tencent.mm.ak.q genLoadMoreNetScene()
    {
      AppMethodBeat.i(244685);
      Object localObject = (BaseFinderFeed)this.tVU.getLastItemOfType(BaseFinderFeed.class);
      if (localObject != null)
      {
        localObject = ((BaseFinderFeed)localObject).feedObject;
        if (localObject != null)
        {
          localObject = ((FinderItem)localObject).getFeedObject();
          if (localObject == null) {}
        }
      }
      for (long l = ((FinderObject)localObject).displayId;; l = 0L)
      {
        localObject = (com.tencent.mm.ak.q)new bm(l, this.tVU.getLastBuffer(), 2, null, this.tVU.getContextObj(), 0, false, 104);
        AppMethodBeat.o(244685);
        return localObject;
      }
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(244683);
      List localList = j.listOf(Integer.valueOf(3965));
      AppMethodBeat.o(244683);
      return localList;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader$LikedTimelineResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "totalCount", "megaVideoCount", "(IILjava/lang/String;II)V", "getMegaVideoCount", "()I", "setMegaVideoCount", "(I)V", "getTotalCount", "setTotalCount", "plugin-finder_release"})
  public static final class b
    extends IResponse<bo>
  {
    public int gAZ = 0;
    public int tUU = 0;
    
    private b(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
  public static final class c
    extends BaseFeedLoader<bo>.a
  {
    c()
    {
      super();
    }
    
    public final void mergeRefresh(final IResponse<bo> paramIResponse, final kotlin.g.a.b<? super IResponse<bo>, x> paramb)
    {
      int i = 0;
      AppMethodBeat.i(244689);
      p.h(paramIResponse, "response");
      final RefreshLoadMoreLayout.c localc = new RefreshLoadMoreLayout.c(paramIResponse.getPullType());
      Object localObject;
      boolean bool;
      if ((paramIResponse.getErrType() == 0) && (paramIResponse.getErrCode() == 0))
      {
        localObject = MMApplicationContext.getContext();
        p.g(localObject, "MMApplicationContext.getContext()");
        localc.Rmi = ((CharSequence)((Context)localObject).getResources().getString(2131760628));
        localc.Rmh = 1;
        if (paramIResponse.getPullType() == 0) {
          break label291;
        }
        bool = true;
        label86:
        localc.jLE = bool;
        localc.Rmj = paramIResponse.getHasMore();
        if (((localc.actionType == 0) || (localc.actionType == 4)) && (localc.Rmk > 0)) {
          localc.Rmi = null;
        }
        localc.iMa = Integer.valueOf(((FinderLikedFeedLoader.b)paramIResponse).gAZ);
        Log.i(this.tVU.getTAG(), "[onFetchRefreshDone]  reason=".concat(String.valueOf(localc)));
        localObject = paramIResponse.getIncrementList();
        if (localObject != null) {
          i = ((List)localObject).size();
        }
        if (!paramIResponse.getHasMore()) {
          break label302;
        }
        if (i <= this.tVU.getDataList().size()) {
          break label297;
        }
        i = 4;
      }
      for (;;)
      {
        d.h((kotlin.g.a.a)new a(this, new n(i, paramIResponse.getIncrementList(), paramIResponse.isNeedClear(), 8), localc, paramb, paramIResponse));
        AppMethodBeat.o(244689);
        return;
        localObject = MMApplicationContext.getContext();
        p.g(localObject, "MMApplicationContext.getContext()");
        localc.Rmi = ((CharSequence)((Context)localObject).getResources().getString(2131760645));
        localc.Rmh = -1;
        break;
        label291:
        bool = false;
        break label86;
        label297:
        i = 2;
        continue;
        label302:
        if ((this.tVU.getDataList().size() != 0) && (i != 0) && (this.tVU.getDataList().size() > i)) {
          i = 4;
        } else {
          i = 6;
        }
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(FinderLikedFeedLoader.c paramc, n paramn, RefreshLoadMoreLayout.c paramc1, kotlin.g.a.b paramb, IResponse paramIResponse)
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