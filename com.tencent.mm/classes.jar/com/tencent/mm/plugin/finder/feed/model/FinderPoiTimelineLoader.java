package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.ce;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.findersdk.a.y.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.eka;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiTimelineLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "fromScene", "", "getFromScene", "()Ljava/lang/Integer;", "setFromScene", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "fromType", "Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$FinderPoiFromType;", "getFromType", "()Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$FinderPoiFromType;", "setFromType", "(Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$FinderPoiFromType;)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "loadMoreCallback", "getLoadMoreCallback", "setLoadMoreCallback", "location", "Lcom/tencent/mm/protocal/protobuf/SnsLocation;", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/SnsLocation;", "setLocation", "(Lcom/tencent/mm/protocal/protobuf/SnsLocation;)V", "refreshCallback", "getRefreshCallback", "setRefreshCallback", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "onFetchDone", "response", "onFetchInitDone", "initResponse", "onFetchLoadMoreDone", "onFetchRefreshDone", "Companion", "FinderPoiTimelineResponse", "PoiTimelineFetcher", "plugin-finder_release"})
public final class FinderPoiTimelineLoader
  extends BaseFinderFeedLoader
{
  public static final a xIB;
  public kotlin.g.a.b<? super IResponse<bu>, x> fetchEndCallback;
  public boolean hasMore;
  private kotlin.g.a.b<? super IResponse<bu>, x> xGJ;
  private kotlin.g.a.b<? super IResponse<bu>, x> xGK;
  public eka xIr;
  public y.a xIs;
  public Integer xIt;
  
  static
  {
    AppMethodBeat.i(285163);
    xIB = new a((byte)0);
    AppMethodBeat.o(285163);
  }
  
  private FinderPoiTimelineLoader(byte paramByte)
  {
    this();
  }
  
  public FinderPoiTimelineLoader(bid parambid)
  {
    super(parambid);
  }
  
  public final i<bu> createDataFetch()
  {
    AppMethodBeat.i(285157);
    i locali = (i)new c();
    AppMethodBeat.o(285157);
    return locali;
  }
  
  public final void onFetchDone(IResponse<bu> paramIResponse)
  {
    AppMethodBeat.i(285158);
    p.k(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(285158);
      return;
    }
    if (!paramIResponse.getHasMore())
    {
      kotlin.g.a.b localb = this.fetchEndCallback;
      if (localb != null)
      {
        localb.invoke(paramIResponse);
        AppMethodBeat.o(285158);
        return;
      }
    }
    AppMethodBeat.o(285158);
  }
  
  public final void onFetchInitDone(IResponse<bu> paramIResponse)
  {
    AppMethodBeat.i(285159);
    p.k(paramIResponse, "initResponse");
    super.onFetchInitDone(paramIResponse);
    if (!paramIResponse.getHasMore())
    {
      kotlin.g.a.b localb = this.fetchEndCallback;
      if (localb != null)
      {
        localb.invoke(paramIResponse);
        AppMethodBeat.o(285159);
        return;
      }
    }
    AppMethodBeat.o(285159);
  }
  
  public final void onFetchLoadMoreDone(IResponse<bu> paramIResponse)
  {
    AppMethodBeat.i(285161);
    p.k(paramIResponse, "response");
    super.onFetchLoadMoreDone(paramIResponse);
    kotlin.g.a.b localb = this.xGK;
    if (localb != null)
    {
      localb.invoke(paramIResponse);
      AppMethodBeat.o(285161);
      return;
    }
    AppMethodBeat.o(285161);
  }
  
  public final void onFetchRefreshDone(IResponse<bu> paramIResponse)
  {
    AppMethodBeat.i(285160);
    p.k(paramIResponse, "response");
    super.onFetchRefreshDone(paramIResponse);
    kotlin.g.a.b localb = this.xGJ;
    if (localb != null)
    {
      localb.invoke(paramIResponse);
      AppMethodBeat.o(285160);
      return;
    }
    AppMethodBeat.o(285160);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiTimelineLoader$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiTimelineLoader$FinderPoiTimelineResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
  public static final class b
    extends IResponse<bu>
  {
    public b(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiTimelineLoader$PoiTimelineFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiTimelineLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
  public final class c
    extends com.tencent.mm.plugin.finder.feed.model.internal.c
  {
    public final IResponse<bu> callInit()
    {
      Object localObject2 = null;
      AppMethodBeat.i(232647);
      FinderPoiTimelineLoader.b localb = new FinderPoiTimelineLoader.b(0, 0, "");
      Object localObject1 = this.xIC.getCache();
      if (localObject1 != null) {}
      for (localObject1 = ((q)localObject1).mXB;; localObject1 = null)
      {
        localb.setIncrementList((List)localObject1);
        q localq = this.xIC.getCache();
        localObject1 = localObject2;
        if (localq != null) {
          localObject1 = localq.lastBuffer;
        }
        localb.setLastBuffer((com.tencent.mm.cd.b)localObject1);
        localObject1 = (IResponse)localb;
        AppMethodBeat.o(232647);
        return localObject1;
      }
    }
    
    public final IResponse<bu> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
    {
      AppMethodBeat.i(232645);
      p.k(paramq, "scene");
      if ((paramq instanceof ce))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0) && (((ce)paramq).doo() == 0)) {}
        FinderPoiTimelineLoader.b localb;
        for (boolean bool = false;; bool = true)
        {
          localb = new FinderPoiTimelineLoader.b(paramInt1, paramInt2, paramString);
          localObject1 = (Iterable)((ce)paramq).dor();
          paramString = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (FinderObject)((Iterator)localObject1).next();
            Object localObject3 = FinderItem.Companion;
            localObject2 = FinderItem.a.b((FinderObject)localObject2, 33040);
            localObject3 = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
            paramString.add(c.a.a((FinderItem)localObject2));
          }
        }
        localb.setIncrementList((List)paramString);
        paramString = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
        c.a.a(((ce)paramq).dor(), 33040, this.xIC.getContextObj());
        if (((ce)paramq).pullType != 2)
        {
          paramString = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
          paramString = localb.getIncrementList();
          if (paramString == null)
          {
            paramString = new t("null cannot be cast to non-null type kotlin.collections.List<com.tencent.mm.plugin.finder.model.BaseFinderFeed>");
            AppMethodBeat.o(232645);
            throw paramString;
          }
          c.a.b(paramString, 33040, true);
        }
        Object localObject1 = getTAG();
        Object localObject2 = new StringBuilder("incrementList size: ");
        paramString = localb.getIncrementList();
        if (paramString != null) {}
        for (paramString = Integer.valueOf(paramString.size());; paramString = null)
        {
          Log.i((String)localObject1, paramString);
          localb.setPullType(((ce)paramq).pullType);
          localb.setLastBuffer(((ce)paramq).don());
          localb.setHasMore(bool);
          paramString = (IResponse)localb;
          AppMethodBeat.o(232645);
          return paramString;
        }
      }
      AppMethodBeat.o(232645);
      return null;
    }
    
    public final com.tencent.mm.an.q genLoadMoreNetScene()
    {
      AppMethodBeat.i(232641);
      Object localObject = this.xIC.xIr;
      y.a locala = this.xIC.xIs;
      if ((localObject != null) && (locala != null))
      {
        localObject = new ce((eka)localObject, locala, this.xIC.getLastBuffer(), this.xIC.xIt, (byte)0);
        ((ce)localObject).pullType = 2;
      }
      for (;;)
      {
        localObject = (com.tencent.mm.an.q)localObject;
        AppMethodBeat.o(232641);
        return localObject;
        localObject = null;
      }
    }
    
    public final com.tencent.mm.an.q genRefreshNetScene()
    {
      AppMethodBeat.i(232637);
      Object localObject = this.xIC.xIr;
      y.a locala = this.xIC.xIs;
      if ((localObject != null) && (locala != null))
      {
        localObject = new ce((eka)localObject, locala, this.xIC.getLastBuffer(), this.xIC.xIt, (byte)0);
        ((ce)localObject).pullType = 0;
      }
      for (;;)
      {
        localObject = (com.tencent.mm.an.q)localObject;
        AppMethodBeat.o(232637);
        return localObject;
        localObject = null;
      }
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(232633);
      List localList = j.listOf(Integer.valueOf(5225));
      AppMethodBeat.o(232633);
      return localList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderPoiTimelineLoader
 * JD-Core Version:    0.7.0.1
 */