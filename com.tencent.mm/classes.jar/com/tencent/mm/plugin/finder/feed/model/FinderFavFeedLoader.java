package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.finder.cgi.bg;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.a;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.data.k;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aoa;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.sdk.platformtools.ae;
import d.a.j;
import d.g.b.p;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "finderUserName", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isTimeline", "", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Z)V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "hasMore", "getHasMore", "()Z", "setHasMore", "(Z)V", "refObjectId", "", "getRefObjectId", "()J", "setRefObjectId", "(J)V", "totalCount", "", "getTotalCount", "()I", "setTotalCount", "(I)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "onFetchDone", "response", "FavDataFetcher", "FinderFavListResponse", "plugin-finder_release"})
public final class FinderFavFeedLoader
  extends BaseFinderFeedLoader
{
  public int fVS;
  public d.g.a.b<? super IResponse<am>, z> fetchEndCallback;
  public boolean hasMore;
  private final String sjZ;
  final boolean ska;
  
  public FinderFavFeedLoader(String paramString, arn paramarn, boolean paramBoolean)
  {
    super(paramarn);
    AppMethodBeat.i(202805);
    this.sjZ = paramString;
    this.ska = paramBoolean;
    AppMethodBeat.o(202805);
  }
  
  public final g<am> createDataFetch()
  {
    AppMethodBeat.i(202802);
    g localg = (g)new a();
    AppMethodBeat.o(202802);
    return localg;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.b<am> createDataMerger()
  {
    AppMethodBeat.i(202803);
    com.tencent.mm.plugin.finder.feed.model.internal.b localb = (com.tencent.mm.plugin.finder.feed.model.internal.b)new FinderFavFeedLoader.c(this);
    AppMethodBeat.o(202803);
    return localb;
  }
  
  public final void onFetchDone(IResponse<am> paramIResponse)
  {
    AppMethodBeat.i(202804);
    p.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(202804);
      return;
    }
    if ((paramIResponse.getPullType() == 0) && ((paramIResponse instanceof b))) {
      this.fVS = ((b)paramIResponse).fVS;
    }
    this.hasMore = paramIResponse.getHasMore();
    d.g.a.b localb = this.fetchEndCallback;
    if (localb != null)
    {
      localb.invoke(paramIResponse);
      AppMethodBeat.o(202804);
      return;
    }
    AppMethodBeat.o(202804);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader$FavDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdId", "plugin-finder_release"})
  public final class a
    extends a
  {
    public final IResponse<am> callInit()
    {
      Object localObject2 = null;
      AppMethodBeat.i(202799);
      ae.i(getTAG(), "fetchInit initCount ");
      FinderFavFeedLoader.b localb = new FinderFavFeedLoader.b(0, 0, "", 0);
      Object localObject1;
      if (this.skb.ska)
      {
        localObject1 = this.skb.getCache();
        if (localObject1 != null)
        {
          localObject1 = ((e)localObject1).jhZ;
          localb.setIncrementList((List)localObject1);
          e locale = this.skb.getCache();
          localObject1 = localObject2;
          if (locale != null) {
            localObject1 = locale.lastBuffer;
          }
          localb.setLastBuffer((com.tencent.mm.bw.b)localObject1);
        }
      }
      for (;;)
      {
        localObject1 = (IResponse)localb;
        AppMethodBeat.o(202799);
        return localObject1;
        localObject1 = null;
        break;
        localObject1 = k.sLb;
        localb.setIncrementList(k.a.FR(10));
      }
    }
    
    public final IResponse<am> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(202798);
      p.h(paramn, "scene");
      if ((paramn instanceof bg))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          localObject1 = ((bg)paramn).rr.aEV();
          if (localObject1 == null)
          {
            paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
            AppMethodBeat.o(202798);
            throw paramString;
          }
          if (((aoa)localObject1).continueFlag != 0) {}
        }
        Object localObject4;
        for (boolean bool = false;; bool = true)
        {
          localObject1 = (bg)paramn;
          localObject2 = ((bg)localObject1).TAG;
          localObject3 = new StringBuilder("favCount = ");
          localObject4 = ((bg)localObject1).rr.aEV();
          if (localObject4 != null) {
            break;
          }
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
          AppMethodBeat.o(202798);
          throw paramString;
        }
        ae.i((String)localObject2, ((aoa)localObject4).fVS);
        Object localObject1 = ((bg)localObject1).rr.aEV();
        if (localObject1 == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
          AppMethodBeat.o(202798);
          throw paramString;
        }
        localObject1 = new FinderFavFeedLoader.b(paramInt1, paramInt2, paramString, ((aoa)localObject1).fVS);
        Object localObject2 = (Iterable)((bg)paramn).czU();
        paramString = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (FinderObject)((Iterator)localObject2).next();
          localObject4 = FinderItem.sJb;
          localObject3 = FinderItem.a.a((FinderObject)localObject3, 256);
          localObject4 = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
          paramString.add(b.a.j((FinderItem)localObject3));
        }
        ((FinderFavFeedLoader.b)localObject1).setIncrementList((List)paramString);
        paramString = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
        b.a.a(((bg)paramn).czU(), 256, this.skb.getContextObj(), 4);
        if (((bg)paramn).pullType != 2)
        {
          paramString = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
          paramString = ((FinderFavFeedLoader.b)localObject1).getIncrementList();
          if (paramString == null)
          {
            paramString = new v("null cannot be cast to non-null type kotlin.collections.List<com.tencent.mm.plugin.finder.model.BaseFinderFeed>");
            AppMethodBeat.o(202798);
            throw paramString;
          }
          b.a.b(paramString, 256, true);
        }
        localObject2 = getTAG();
        Object localObject3 = new StringBuilder("incrementList size: ");
        paramString = ((FinderFavFeedLoader.b)localObject1).getIncrementList();
        if (paramString != null) {}
        for (paramString = Integer.valueOf(paramString.size());; paramString = null)
        {
          ae.i((String)localObject2, paramString);
          ((FinderFavFeedLoader.b)localObject1).setPullType(((bg)paramn).pullType);
          paramString = ((bg)paramn).rr.aEV();
          if (paramString != null) {
            break;
          }
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
          AppMethodBeat.o(202798);
          throw paramString;
        }
        ((FinderFavFeedLoader.b)localObject1).setLastBuffer(((aoa)paramString).lastBuffer);
        ((FinderFavFeedLoader.b)localObject1).setHasMore(bool);
        paramString = (IResponse)localObject1;
        AppMethodBeat.o(202798);
        return paramString;
      }
      AppMethodBeat.o(202798);
      return null;
    }
    
    public final n genLoadMoreNetScene()
    {
      AppMethodBeat.i(202797);
      Object localObject = new bg(FinderFavFeedLoader.a(this.skb), this.skb.getLastBuffer(), this.skb.getContextObj());
      ((bg)localObject).pullType = 2;
      localObject = (n)localObject;
      AppMethodBeat.o(202797);
      return localObject;
    }
    
    public final n genRefreshNetScene()
    {
      AppMethodBeat.i(202796);
      Object localObject = new bg(FinderFavFeedLoader.a(this.skb), this.skb.getLastBuffer(), this.skb.getContextObj());
      ((bg)localObject).pullType = 0;
      localObject = (n)localObject;
      AppMethodBeat.o(202796);
      return localObject;
    }
    
    public final int getCmdId()
    {
      return 3966;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader$FinderFavListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "totalCount", "(IILjava/lang/String;I)V", "getTotalCount", "()I", "setTotalCount", "(I)V", "plugin-finder_release"})
  public static final class b
    extends IResponse<am>
  {
    int fVS;
    
    public b(int paramInt1, int paramInt2, String paramString, int paramInt3)
    {
      super(paramInt2, paramString);
      this.fVS = paramInt3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderFavFeedLoader
 * JD-Core Version:    0.7.0.1
 */