package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.b;
import com.tencent.mm.plugin.finder.cgi.bw;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.c;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.bp;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.protocal.protobuf.atn;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.blm;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileShopLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "finderUsername", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "fetchEndCallback", "Lkotlin/Function0;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function0;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "getFinderUsername", "()Ljava/lang/String;", "initFeedData", "", "Lcom/tencent/mm/plugin/finder/model/FinderShopFeed;", "getInitFeedData", "()Ljava/util/List;", "setInitFeedData", "(Ljava/util/List;)V", "initLastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getInitLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setInitLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onFetchDone", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "ShopDataFetcher", "ShopResponse", "plugin-finder_release"})
public final class FinderProfileShopLoader
  extends BaseFinderFeedLoader
{
  final String finderUsername;
  public a<x> xEI;
  public List<bp> xJf;
  public b xJg;
  
  public FinderProfileShopLoader(String paramString, bid parambid)
  {
    super(parambid);
    AppMethodBeat.i(285689);
    this.finderUsername = paramString;
    AppMethodBeat.o(285689);
  }
  
  public final i<bu> createDataFetch()
  {
    AppMethodBeat.i(285687);
    i locali = (i)new a();
    AppMethodBeat.o(285687);
    return locali;
  }
  
  public final void onFetchDone(IResponse<bu> paramIResponse)
  {
    AppMethodBeat.i(285688);
    p.k(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(285688);
      return;
    }
    if (!paramIResponse.getHasMore())
    {
      paramIResponse = this.xEI;
      if (paramIResponse != null)
      {
        paramIResponse.invoke();
        AppMethodBeat.o(285688);
        return;
      }
    }
    AppMethodBeat.o(285688);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileShopLoader$ShopDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileShopLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
  public final class a
    extends c
  {
    public final IResponse<bu> callInit()
    {
      AppMethodBeat.i(260186);
      Object localObject = new FinderProfileShopLoader.b(0, 0, "");
      ((FinderProfileShopLoader.b)localObject).setIncrementList(this.xJh.xJf);
      ((FinderProfileShopLoader.b)localObject).setLastBuffer(this.xJh.xJg);
      localObject = (IResponse)localObject;
      AppMethodBeat.o(260186);
      return localObject;
    }
    
    public final IResponse<bu> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      AppMethodBeat.i(260188);
      p.k(paramq, "scene");
      if ((paramq instanceof bw))
      {
        paramString = new FinderProfileShopLoader.b(paramInt1, paramInt2, paramString);
        Object localObject1 = ((bw)paramq).lKU.bhY();
        if (localObject1 == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetAllWindowProductsResponse");
          AppMethodBeat.o(260188);
          throw paramString;
        }
        if (((atn)localObject1).xFI == 1) {}
        for (boolean bool = true;; bool = false)
        {
          paramString.setHasMore(bool);
          Object localObject2 = (Iterable)((bw)paramq).doz();
          localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((Collection)localObject1).add(new bp((blm)((Iterator)localObject2).next()));
          }
        }
        paramString.setIncrementList((List)localObject1);
        paramString.setLastBuffer(((bw)paramq).getLastBuffer());
        paramString.setPullType(((bw)paramq).pullType);
        paramString = (IResponse)paramString;
        AppMethodBeat.o(260188);
        return paramString;
      }
      AppMethodBeat.o(260188);
      return null;
    }
    
    public final q genLoadMoreNetScene()
    {
      AppMethodBeat.i(260184);
      Object localObject = new bw(this.xJh.finderUsername, this.xJh.getLastBuffer(), this.xJh.getContextObj());
      ((bw)localObject).pullType = 2;
      localObject = (q)localObject;
      AppMethodBeat.o(260184);
      return localObject;
    }
    
    public final q genRefreshNetScene()
    {
      AppMethodBeat.i(260181);
      Object localObject = new bw(this.xJh.finderUsername, null, this.xJh.getContextObj());
      ((bw)localObject).pullType = 0;
      localObject = (q)localObject;
      AppMethodBeat.o(260181);
      return localObject;
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(260179);
      List localList = j.listOf(Integer.valueOf(5244));
      AppMethodBeat.o(260179);
      return localList;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileShopLoader$ShopResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
  public static final class b
    extends IResponse<bu>
  {
    public b(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderProfileShopLoader
 * JD-Core Version:    0.7.0.1
 */