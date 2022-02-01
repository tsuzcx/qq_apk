package com.tencent.mm.plugin.finder.feed.model;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.anx;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import d.a.j;
import d.g.b.p;
import d.g.b.q;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "isTimeLine", "", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ZLcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "fetchEndCallback", "Lkotlin/Function0;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function0;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "fetchRefreshCallback", "Lkotlin/Function1;", "", "getFetchRefreshCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchRefreshCallback", "(Lkotlin/jvm/functions/Function1;)V", "hasMore", "getHasMore", "()Z", "setHasMore", "(Z)V", "getScene", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "totalCount", "getTotalCount", "()I", "setTotalCount", "(I)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "onFetchDone", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "onFetchRefreshDone", "LikedDataFetcher", "LikedTimelineResponse", "plugin-finder_release"})
public final class FinderLikedFeedLoader
  extends BaseFinderFeedLoader
{
  public int fTM;
  public boolean hasMore;
  final boolean isE;
  public d.g.a.a<z> rTm;
  public d.g.a.b<? super Integer, z> sbL;
  private final e sbM;
  
  public FinderLikedFeedLoader(boolean paramBoolean, e parame, aqy paramaqy)
  {
    super(paramaqy);
    AppMethodBeat.i(202420);
    this.isE = paramBoolean;
    this.sbM = parame;
    this.hasMore = true;
    AppMethodBeat.o(202420);
  }
  
  public final g<al> createDataFetch()
  {
    AppMethodBeat.i(202417);
    g localg = (g)new a();
    AppMethodBeat.o(202417);
    return localg;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.b<al> createDataMerger()
  {
    AppMethodBeat.i(202418);
    com.tencent.mm.plugin.finder.feed.model.internal.b localb = (com.tencent.mm.plugin.finder.feed.model.internal.b)new c(this);
    AppMethodBeat.o(202418);
    return localb;
  }
  
  public final void onFetchDone(IResponse<al> paramIResponse)
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
      paramIResponse = this.rTm;
      if (paramIResponse == null) {
        break;
      }
      paramIResponse.invoke();
      AppMethodBeat.o(166040);
      return;
    }
    AppMethodBeat.o(166040);
  }
  
  public final void onFetchRefreshDone(IResponse<al> paramIResponse)
  {
    AppMethodBeat.i(202419);
    p.h(paramIResponse, "response");
    super.onFetchRefreshDone(paramIResponse);
    if ((paramIResponse instanceof b))
    {
      this.fTM = ((b)paramIResponse).count;
      paramIResponse = this.sbL;
      if (paramIResponse != null)
      {
        paramIResponse.invoke(Integer.valueOf(this.fTM));
        AppMethodBeat.o(202419);
        return;
      }
    }
    AppMethodBeat.o(202419);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader$LikedDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader$LikedTimelineResponse;", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetLikedList;", "getCmdId", "plugin-finder_release"})
  public final class a
    extends com.tencent.mm.plugin.finder.feed.model.internal.a
  {
    public final IResponse<al> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(202413);
      p.h(paramn, "scene");
      paramn = (am)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramn.cyq() != 1)) {}
      FinderLikedFeedLoader.b localb;
      Object localObject1;
      Object localObject2;
      for (boolean bool = false;; bool = true)
      {
        localb = new FinderLikedFeedLoader.b(paramInt1, paramInt2, paramString);
        paramString = paramn.rJo;
        if (paramString == null) {
          break label229;
        }
        localObject1 = (Iterable)paramString;
        paramString = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (FinderItem)((Iterator)localObject1).next();
          b.a locala = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
          paramString.add(b.a.j((FinderItem)localObject2));
        }
      }
      label229:
      for (paramString = (List)paramString;; paramString = null)
      {
        localb.setIncrementList(paramString);
        localb.setPullType(paramn.pullType);
        localb.setLastBuffer(paramn.cyp());
        localb.setHasMore(bool);
        paramString = paramn.TAG;
        localObject1 = new StringBuilder("total count = ");
        localObject2 = paramn.rr.aEF();
        if (localObject2 != null) {
          break;
        }
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
        AppMethodBeat.o(202413);
        throw paramString;
      }
      ad.i(paramString, ((anx)localObject2).fTM);
      paramString = paramn.rr.aEF();
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
        AppMethodBeat.o(202413);
        throw paramString;
      }
      localb.count = ((anx)paramString).fTM;
      paramString = (IResponse)localb;
      AppMethodBeat.o(202413);
      return paramString;
    }
    
    public final n genLoadMoreNetScene()
    {
      AppMethodBeat.i(202412);
      Object localObject = (BaseFinderFeed)this.sbN.getLastItemOfType(BaseFinderFeed.class);
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
        localObject = (n)new am(l, this.sbN.getLastBuffer(), 2, this.sbN.getContextObj());
        AppMethodBeat.o(202412);
        return localObject;
      }
    }
    
    public final int getCmdId()
    {
      return 3965;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader$LikedTimelineResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "count", "(IILjava/lang/String;I)V", "getCount", "()I", "setCount", "(I)V", "plugin-finder_release"})
  public static final class b
    extends IResponse<al>
  {
    int count = 0;
    
    public b(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
  public static final class c
    extends BaseFeedLoader<al>.a
  {
    c()
    {
      super();
    }
    
    public final void mergeRefresh(final IResponse<al> paramIResponse, final d.g.a.b<? super IResponse<al>, z> paramb)
    {
      int i = 0;
      AppMethodBeat.i(202416);
      p.h(paramIResponse, "response");
      final RefreshLoadMoreLayout.c localc = new RefreshLoadMoreLayout.c(paramIResponse.getPullType());
      Object localObject;
      boolean bool;
      if ((paramIResponse.getErrType() == 0) && (paramIResponse.getErrCode() == 0))
      {
        localObject = aj.getContext();
        p.g(localObject, "MMApplicationContext.getContext()");
        localc.Lrh = ((CharSequence)((Context)localObject).getResources().getString(2131759373));
        localc.Lrg = 1;
        if (paramIResponse.getPullType() == 0) {
          break label291;
        }
        bool = true;
        label86:
        localc.iLW = bool;
        localc.Lri = paramIResponse.getHasMore();
        if (((localc.actionType == 0) || (localc.actionType == 4)) && (localc.Lrj > 0)) {
          localc.Lrh = null;
        }
        localc.hNZ = Integer.valueOf(((FinderLikedFeedLoader.b)paramIResponse).count);
        ad.i(this.sbN.getTAG(), "[onFetchRefreshDone]  reason=".concat(String.valueOf(localc)));
        localObject = paramIResponse.getIncrementList();
        if (localObject != null) {
          i = ((List)localObject).size();
        }
        if (!paramIResponse.getHasMore()) {
          break label302;
        }
        if (i <= this.sbN.getDataList().size()) {
          break label297;
        }
        i = 4;
      }
      for (;;)
      {
        c.g((d.g.a.a)new a(this, new com.tencent.mm.plugin.finder.feed.model.internal.l(i, paramIResponse.getIncrementList(), paramIResponse.isNeedClear(), 8), localc, paramb, paramIResponse));
        AppMethodBeat.o(202416);
        return;
        localObject = aj.getContext();
        p.g(localObject, "MMApplicationContext.getContext()");
        localc.Lrh = ((CharSequence)((Context)localObject).getResources().getString(2131759383));
        localc.Lrg = -1;
        break;
        label291:
        bool = false;
        break label86;
        label297:
        i = 2;
        continue;
        label302:
        if ((this.sbN.getDataList().size() != 0) && (i != 0) && (this.sbN.getDataList().size() > i)) {
          i = 4;
        } else {
          i = 6;
        }
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements d.g.a.a<z>
    {
      a(FinderLikedFeedLoader.c paramc, com.tencent.mm.plugin.finder.feed.model.internal.l paraml, RefreshLoadMoreLayout.c paramc1, d.g.a.b paramb, IResponse paramIResponse)
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