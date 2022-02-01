package com.tencent.mm.plugin.finder.megavideo.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.cn;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.c;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.feed.model.internal.r;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ca;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.k;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderLikeMegaVideoLoader;", "Lcom/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "megaVideoCount", "", "getMegaVideoCount", "()I", "setMegaVideoCount", "(I)V", "totalCount", "getTotalCount", "setTotalCount", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "onFetchDone", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "FinderLikeMegaVideoListResponse", "LikeMegaVideoDataFetcher", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLikeMegaVideoLoader
  extends BaseMegaVideoLoader
{
  public int BfD;
  public int lNX;
  
  public FinderLikeMegaVideoLoader(bui parambui)
  {
    super(parambui);
  }
  
  public final i<cc> createDataFetch()
  {
    AppMethodBeat.i(342197);
    i locali = (i)new b();
    AppMethodBeat.o(342197);
    return locali;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.d<cc> createDataMerger()
  {
    AppMethodBeat.i(342204);
    com.tencent.mm.plugin.finder.feed.model.internal.d locald = (com.tencent.mm.plugin.finder.feed.model.internal.d)new c(this);
    AppMethodBeat.o(342204);
    return locald;
  }
  
  public final void onFetchDone(IResponse<cc> paramIResponse)
  {
    AppMethodBeat.i(342210);
    kotlin.g.b.s.u(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(342210);
      return;
    }
    if (((paramIResponse instanceof a)) && (paramIResponse.getPullType() == 0))
    {
      this.lNX = ((a)paramIResponse).lNX;
      this.BfD = ((a)paramIResponse).EzH;
    }
    this.hasMore = paramIResponse.getHasMore();
    kotlin.g.a.b localb = this.fetchEndCallback;
    if (localb != null) {
      localb.invoke(paramIResponse);
    }
    AppMethodBeat.o(342210);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderLikeMegaVideoLoader$FinderLikeMegaVideoListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "megaVideoTotalCount", "totalCount", "(IILjava/lang/String;II)V", "getMegaVideoTotalCount", "()I", "setMegaVideoTotalCount", "(I)V", "getTotalCount", "setTotalCount", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends IResponse<cc>
  {
    int EzH;
    int lNX;
    
    public a(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4)
    {
      super(paramInt2, paramString);
      this.EzH = paramInt3;
      this.lNX = paramInt4;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderLikeMegaVideoLoader$LikeMegaVideoDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderLikeMegaVideoLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends c
  {
    public b()
    {
      AppMethodBeat.i(342160);
      AppMethodBeat.o(342160);
    }
    
    public final IResponse<cc> callInit()
    {
      Object localObject1 = null;
      AppMethodBeat.i(342199);
      Log.i(getTAG(), "fetchInit");
      FinderLikeMegaVideoLoader.a locala = new FinderLikeMegaVideoLoader.a(0, 0, "", 0, 0);
      locala.setPullType(1000);
      Object localObject2 = this.EzK.getCache();
      if (localObject2 == null) {}
      do
      {
        if (localObject1 == null)
        {
          localObject1 = k.a.a(k.FNg, 11);
          Log.i(getTAG(), kotlin.g.b.s.X("fetchInit: use first page data list, size: ", Integer.valueOf(((List)localObject1).size())));
          locala.setIncrementList((List)localObject1);
          locala.EzH = ((List)localObject1).size();
        }
        localObject1 = (IResponse)locala;
        AppMethodBeat.o(342199);
        return localObject1;
        localObject2 = ((com.tencent.mm.plugin.finder.feed.model.s)localObject2).pUj;
      } while (localObject2 == null);
      localObject1 = this.EzK;
      Log.i(getTAG(), kotlin.g.b.s.X("fetchInit: use old data list, size: ", Integer.valueOf(((ArrayList)localObject2).size())));
      locala.setIncrementList((List)localObject2);
      locala.EzH = ((ArrayList)localObject2).size();
      localObject1 = ((FinderLikeMegaVideoLoader)localObject1).getCache();
      if (localObject1 == null) {}
      for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.finder.feed.model.s)localObject1).lastBuffer)
      {
        locala.setLastBuffer((com.tencent.mm.bx.b)localObject1);
        localObject1 = ah.aiuX;
        break;
      }
    }
    
    public final IResponse<cc> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
    {
      Object localObject1 = null;
      AppMethodBeat.i(342191);
      kotlin.g.b.s.u(paramp, "scene");
      if ((paramp instanceof cn))
      {
        boolean bool;
        FinderLikeMegaVideoLoader.a locala;
        label101:
        Object localObject2;
        List localList;
        if ((paramInt1 == 0) && (paramInt2 == 0) && (((cn)paramp).dVZ() == 0))
        {
          bool = false;
          locala = new FinderLikeMegaVideoLoader.a(paramInt1, paramInt2, paramString, ((cn)paramp).dVX(), ((cn)paramp).getCount());
          locala.setPullType(((cn)paramp).pullType);
          paramString = ((cn)paramp).ACl;
          if (paramString != null) {
            break label246;
          }
          paramString = null;
          locala.setIncrementList(paramString);
          localObject2 = getTAG();
          localList = locala.getIncrementList();
          if (localList != null) {
            break label327;
          }
        }
        for (;;)
        {
          Log.i((String)localObject2, kotlin.g.b.s.X("incrementList size: ", localObject1));
          locala.setLastBuffer(((cn)paramp).dVY());
          locala.setHasMore(bool);
          if (paramString == null) {
            break label355;
          }
          paramp = this.EzK;
          localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
          localObject2 = (Iterable)paramString;
          localObject1 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((Collection)localObject1).add(((ca)((Iterator)localObject2).next()).getFeedObject());
          }
          bool = true;
          break;
          label246:
          localObject2 = (Iterable)paramString;
          paramString = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            paramString.add(new ca(((FinderItem)((Iterator)localObject2).next()).getFeedObject()));
          }
          paramString = (List)paramString;
          break label101;
          label327:
          localObject1 = Integer.valueOf(localList.size());
        }
        d.a.d((List)localObject1, paramp.getContextObj());
        label355:
        if (locala.getPullType() != 2)
        {
          paramp = new LinkedList();
          if (paramString != null)
          {
            paramString = ((Iterable)paramString).iterator();
            while (paramString.hasNext())
            {
              localObject1 = (ca)paramString.next();
              paramp.add(new com.tencent.mm.plugin.finder.storage.data.u(((ca)localObject1).bZA(), 1, ((ca)localObject1).getFeedObject()));
            }
          }
          if (paramp.size() > 0)
          {
            paramString = k.FNg;
            paramString = z.bAW();
            kotlin.g.b.s.s(paramString, "getMyFinderUsername()");
            k.a.a(11, paramString, paramp);
          }
          Log.i(getTAG(), kotlin.g.b.s.X("LikeMegaVideoDataFetcher FinderPage size: ", Integer.valueOf(paramp.size())));
        }
        paramString = (IResponse)locala;
        AppMethodBeat.o(342191);
        return paramString;
      }
      AppMethodBeat.o(342191);
      return null;
    }
    
    public final com.tencent.mm.am.p genLoadMoreNetScene()
    {
      long l2 = 0L;
      AppMethodBeat.i(342177);
      Object localObject = (BaseFinderFeed)this.EzK.getLastItemOfType(BaseFinderFeed.class);
      long l1;
      if (localObject == null) {
        l1 = l2;
      }
      for (;;)
      {
        localObject = (com.tencent.mm.am.p)new cn(l1, this.EzK.getLastBuffer(), 2, null, this.EzK.getContextObj(), 1, false, 72);
        AppMethodBeat.o(342177);
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
    
    public final com.tencent.mm.am.p genRefreshNetScene()
    {
      AppMethodBeat.i(342171);
      com.tencent.mm.am.p localp = (com.tencent.mm.am.p)new cn(0L, this.EzK.getLastBuffer(), 0, null, this.EzK.getContextObj(), 1, false, 72);
      AppMethodBeat.o(342171);
      return localp;
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(342167);
      List localList = kotlin.a.p.listOf(Integer.valueOf(3965));
      AppMethodBeat.o(342167);
      return localList;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/megavideo/loader/FinderLikeMegaVideoLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends BaseFeedLoader<cc>.a
  {
    c(FinderLikeMegaVideoLoader paramFinderLikeMegaVideoLoader)
    {
      super(false, 1, null);
      AppMethodBeat.i(342156);
      AppMethodBeat.o(342156);
    }
    
    public final void mergeRefresh(final IResponse<cc> paramIResponse, final kotlin.g.a.b<? super IResponse<cc>, ah> paramb)
    {
      AppMethodBeat.i(342165);
      kotlin.g.b.s.u(paramIResponse, "response");
      Object localObject = RefreshLoadMoreLayout.d.agJr;
      localObject = new RefreshLoadMoreLayout.d(RefreshLoadMoreLayout.d.jMG());
      com.tencent.mm.ae.d.uiThread((a)new a(this, new r(7, paramIResponse.getIncrementList(), false, 12), (RefreshLoadMoreLayout.d)localObject, this.EzK, paramb, paramIResponse));
      AppMethodBeat.o(342165);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements a<ah>
    {
      a(FinderLikeMegaVideoLoader.c paramc, r<cc> paramr, RefreshLoadMoreLayout.d<Object> paramd, FinderLikeMegaVideoLoader paramFinderLikeMegaVideoLoader, kotlin.g.a.b<? super IResponse<cc>, ah> paramb, IResponse<cc> paramIResponse)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.loader.FinderLikeMegaVideoLoader
 * JD-Core Version:    0.7.0.1
 */