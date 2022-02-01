package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.cgi.cu;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.bw;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.protocal.protobuf.ayd;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bzc;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileShopLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "finderUsername", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "fetchEndCallback", "Lkotlin/Function0;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function0;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "getFinderUsername", "()Ljava/lang/String;", "initFeedData", "", "Lcom/tencent/mm/plugin/finder/model/FinderShopFeed;", "getInitFeedData", "()Ljava/util/List;", "setInitFeedData", "(Ljava/util/List;)V", "initLastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getInitLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setInitLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onFetchDone", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "ShopDataFetcher", "ShopResponse", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderProfileShopLoader
  extends BaseFinderFeedLoader
{
  public a<ah> BbB;
  public List<bw> BiP;
  public b BiQ;
  final String finderUsername;
  
  public FinderProfileShopLoader(String paramString, bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(366064);
    this.finderUsername = paramString;
    AppMethodBeat.o(366064);
  }
  
  public final i<cc> createDataFetch()
  {
    AppMethodBeat.i(366072);
    i locali = (i)new a();
    AppMethodBeat.o(366072);
    return locali;
  }
  
  public final void onFetchDone(IResponse<cc> paramIResponse)
  {
    AppMethodBeat.i(366078);
    s.u(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(366078);
      return;
    }
    if (!paramIResponse.getHasMore())
    {
      paramIResponse = this.BbB;
      if (paramIResponse != null) {
        paramIResponse.invoke();
      }
    }
    AppMethodBeat.o(366078);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileShopLoader$ShopDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileShopLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends com.tencent.mm.plugin.finder.feed.model.internal.c
  {
    public a()
    {
      AppMethodBeat.i(365879);
      AppMethodBeat.o(365879);
    }
    
    public final IResponse<cc> callInit()
    {
      AppMethodBeat.i(365906);
      Object localObject = new FinderProfileShopLoader.b(0, 0, "");
      FinderProfileShopLoader localFinderProfileShopLoader = this.BiR;
      ((FinderProfileShopLoader.b)localObject).setIncrementList(localFinderProfileShopLoader.BiP);
      ((FinderProfileShopLoader.b)localObject).setLastBuffer(localFinderProfileShopLoader.BiQ);
      localObject = (IResponse)localObject;
      AppMethodBeat.o(365906);
      return localObject;
    }
    
    public final IResponse<cc> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
    {
      AppMethodBeat.i(365911);
      s.u(paramp, "scene");
      if ((paramp instanceof cu))
      {
        paramString = new FinderProfileShopLoader.b(paramInt1, paramInt2, paramString);
        Object localObject1 = c.c.b(((cu)paramp).oDw.otC);
        if (localObject1 == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetAllWindowProductsResponse");
          AppMethodBeat.o(365911);
          throw paramString;
        }
        if (((ayd)localObject1).BeA == 1) {}
        for (boolean bool = true;; bool = false)
        {
          paramString.setHasMore(bool);
          Object localObject2 = (Iterable)((cu)paramp).dWk();
          localObject1 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((Collection)localObject1).add(new bw((bzc)((Iterator)localObject2).next()));
          }
        }
        paramString.setIncrementList((List)localObject1);
        paramString.setLastBuffer(((cu)paramp).getLastBuffer());
        paramString.setPullType(((cu)paramp).pullType);
        paramString = (IResponse)paramString;
        AppMethodBeat.o(365911);
        return paramString;
      }
      AppMethodBeat.o(365911);
      return null;
    }
    
    public final com.tencent.mm.am.p genLoadMoreNetScene()
    {
      AppMethodBeat.i(365900);
      Object localObject = new cu(this.BiR.finderUsername, this.BiR.getLastBuffer(), this.BiR.getContextObj());
      ((cu)localObject).pullType = 2;
      localObject = (com.tencent.mm.am.p)localObject;
      AppMethodBeat.o(365900);
      return localObject;
    }
    
    public final com.tencent.mm.am.p genRefreshNetScene()
    {
      AppMethodBeat.i(365892);
      Object localObject = new cu(this.BiR.finderUsername, null, this.BiR.getContextObj());
      ((cu)localObject).pullType = 0;
      localObject = (com.tencent.mm.am.p)localObject;
      AppMethodBeat.o(365892);
      return localObject;
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(365887);
      List localList = kotlin.a.p.listOf(Integer.valueOf(5244));
      AppMethodBeat.o(365887);
      return localList;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileShopLoader$ShopResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends IResponse<cc>
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