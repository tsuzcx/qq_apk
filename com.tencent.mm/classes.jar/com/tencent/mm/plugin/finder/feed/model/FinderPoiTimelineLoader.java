package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.df;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.c;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.d;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.plugin.findersdk.a.bi.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.fei;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiTimelineLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "fromScene", "", "getFromScene", "()Ljava/lang/Integer;", "setFromScene", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "fromType", "Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$FinderPoiFromType;", "getFromType", "()Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$FinderPoiFromType;", "setFromType", "(Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$FinderPoiFromType;)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "loadMoreCallback", "getLoadMoreCallback", "setLoadMoreCallback", "location", "Lcom/tencent/mm/protocal/protobuf/SnsLocation;", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/SnsLocation;", "setLocation", "(Lcom/tencent/mm/protocal/protobuf/SnsLocation;)V", "refreshCallback", "getRefreshCallback", "setRefreshCallback", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "onFetchDone", "response", "onFetchInitDone", "initResponse", "onFetchLoadMoreDone", "onFetchRefreshDone", "Companion", "FinderPoiTimelineResponse", "PoiTimelineFetcher", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderPoiTimelineLoader
  extends BaseFinderFeedLoader
{
  public static final a BhW;
  private kotlin.g.a.b<? super IResponse<cc>, ah> BfX;
  private kotlin.g.a.b<? super IResponse<cc>, ah> BfY;
  public fei BhH;
  public bi.a BhJ;
  public Integer BhK;
  public kotlin.g.a.b<? super IResponse<cc>, ah> fetchEndCallback;
  public boolean hasMore;
  
  static
  {
    AppMethodBeat.i(366357);
    BhW = new a((byte)0);
    AppMethodBeat.o(366357);
  }
  
  private FinderPoiTimelineLoader(byte paramByte)
  {
    this();
  }
  
  public FinderPoiTimelineLoader(bui parambui)
  {
    super(parambui);
  }
  
  public final i<cc> createDataFetch()
  {
    AppMethodBeat.i(366364);
    i locali = (i)new c();
    AppMethodBeat.o(366364);
    return locali;
  }
  
  public final void onFetchDone(IResponse<cc> paramIResponse)
  {
    AppMethodBeat.i(366374);
    kotlin.g.b.s.u(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(366374);
      return;
    }
    if (!paramIResponse.getHasMore())
    {
      kotlin.g.a.b localb = this.fetchEndCallback;
      if (localb != null) {
        localb.invoke(paramIResponse);
      }
    }
    AppMethodBeat.o(366374);
  }
  
  public final void onFetchInitDone(IResponse<cc> paramIResponse)
  {
    AppMethodBeat.i(366380);
    kotlin.g.b.s.u(paramIResponse, "initResponse");
    super.onFetchInitDone(paramIResponse);
    if (!paramIResponse.getHasMore())
    {
      kotlin.g.a.b localb = this.fetchEndCallback;
      if (localb != null) {
        localb.invoke(paramIResponse);
      }
    }
    AppMethodBeat.o(366380);
  }
  
  public final void onFetchLoadMoreDone(IResponse<cc> paramIResponse)
  {
    AppMethodBeat.i(366390);
    kotlin.g.b.s.u(paramIResponse, "response");
    super.onFetchLoadMoreDone(paramIResponse);
    kotlin.g.a.b localb = this.BfY;
    if (localb != null) {
      localb.invoke(paramIResponse);
    }
    AppMethodBeat.o(366390);
  }
  
  public final void onFetchRefreshDone(IResponse<cc> paramIResponse)
  {
    AppMethodBeat.i(366385);
    kotlin.g.b.s.u(paramIResponse, "response");
    super.onFetchRefreshDone(paramIResponse);
    kotlin.g.a.b localb = this.BfX;
    if (localb != null) {
      localb.invoke(paramIResponse);
    }
    AppMethodBeat.o(366385);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiTimelineLoader$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiTimelineLoader$FinderPoiTimelineResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends IResponse<cc>
  {
    public b(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiTimelineLoader$PoiTimelineFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiTimelineLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends c
  {
    public c()
    {
      AppMethodBeat.i(366244);
      AppMethodBeat.o(366244);
    }
    
    public final IResponse<cc> callInit()
    {
      Object localObject2 = null;
      AppMethodBeat.i(366280);
      FinderPoiTimelineLoader.b localb = new FinderPoiTimelineLoader.b(0, 0, "");
      FinderPoiTimelineLoader localFinderPoiTimelineLoader = this.BhX;
      Object localObject1 = localFinderPoiTimelineLoader.getCache();
      if (localObject1 == null)
      {
        localObject1 = null;
        localb.setIncrementList((List)localObject1);
        localObject1 = localFinderPoiTimelineLoader.getCache();
        if (localObject1 != null) {
          break label82;
        }
      }
      label82:
      for (localObject1 = localObject2;; localObject1 = ((s)localObject1).lastBuffer)
      {
        localb.setLastBuffer((com.tencent.mm.bx.b)localObject1);
        localObject1 = (IResponse)localb;
        AppMethodBeat.o(366280);
        return localObject1;
        localObject1 = ((s)localObject1).pUj;
        break;
      }
    }
    
    public final IResponse<cc> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
    {
      AppMethodBeat.i(366273);
      kotlin.g.b.s.u(paramp, "scene");
      if ((paramp instanceof df))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0) && (((df)paramp).dVZ() == 0)) {}
        FinderPoiTimelineLoader.b localb;
        for (boolean bool = false;; bool = true)
        {
          localb = new FinderPoiTimelineLoader.b(paramInt1, paramInt2, paramString);
          localObject1 = (Iterable)((df)paramp).dWd();
          paramString = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject1, 10));
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (FinderObject)((Iterator)localObject1).next();
            Object localObject3 = FinderItem.Companion;
            localObject2 = FinderItem.a.e((FinderObject)localObject2, 33040);
            localObject3 = d.FND;
            paramString.add(d.a.a((FinderItem)localObject2));
          }
        }
        localb.setIncrementList((List)paramString);
        paramString = d.FND;
        d.a.a(((df)paramp).dWd(), 33040, this.BhX.getContextObj());
        if (((df)paramp).pullType != 2)
        {
          paramString = d.FND;
          paramString = localb.getIncrementList();
          if (paramString == null)
          {
            paramString = new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<com.tencent.mm.plugin.finder.model.BaseFinderFeed>");
            AppMethodBeat.o(366273);
            throw paramString;
          }
          d.a.c(paramString, 33040, true);
        }
        Object localObject1 = getTAG();
        paramString = localb.getIncrementList();
        if (paramString == null) {}
        for (paramString = null;; paramString = Integer.valueOf(paramString.size()))
        {
          Log.i((String)localObject1, kotlin.g.b.s.X("incrementList size: ", paramString));
          localb.setPullType(((df)paramp).pullType);
          localb.setLastBuffer(((df)paramp).dVY());
          localb.setHasMore(bool);
          paramString = (IResponse)localb;
          AppMethodBeat.o(366273);
          return paramString;
        }
      }
      AppMethodBeat.o(366273);
      return null;
    }
    
    public final com.tencent.mm.am.p genLoadMoreNetScene()
    {
      AppMethodBeat.i(366263);
      Object localObject = this.BhX.BhH;
      bi.a locala = this.BhX.BhJ;
      FinderPoiTimelineLoader localFinderPoiTimelineLoader = this.BhX;
      if ((localObject != null) && (locala != null))
      {
        localObject = new df((fei)localObject, locala, localFinderPoiTimelineLoader.getLastBuffer(), localFinderPoiTimelineLoader.BhK, (byte)0);
        ((df)localObject).pullType = 2;
      }
      for (;;)
      {
        localObject = (com.tencent.mm.am.p)localObject;
        AppMethodBeat.o(366263);
        return localObject;
        localObject = null;
      }
    }
    
    public final com.tencent.mm.am.p genRefreshNetScene()
    {
      AppMethodBeat.i(366256);
      Object localObject = this.BhX.BhH;
      bi.a locala = this.BhX.BhJ;
      FinderPoiTimelineLoader localFinderPoiTimelineLoader = this.BhX;
      if ((localObject != null) && (locala != null))
      {
        localObject = new df((fei)localObject, locala, localFinderPoiTimelineLoader.getLastBuffer(), localFinderPoiTimelineLoader.BhK, (byte)0);
        ((df)localObject).pullType = 0;
      }
      for (;;)
      {
        localObject = (com.tencent.mm.am.p)localObject;
        AppMethodBeat.o(366256);
        return localObject;
        localObject = null;
      }
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(366248);
      List localList = kotlin.a.p.listOf(Integer.valueOf(5225));
      AppMethodBeat.o(366248);
      return localList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderPoiTimelineLoader
 * JD-Core Version:    0.7.0.1
 */