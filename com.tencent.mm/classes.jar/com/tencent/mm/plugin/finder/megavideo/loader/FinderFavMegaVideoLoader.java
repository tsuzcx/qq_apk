package com.tencent.mm.plugin.finder.megavideo.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.dv;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.c;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.feed.model.internal.r;
import com.tencent.mm.plugin.finder.model.ca;
import com.tencent.mm.plugin.finder.model.cc;
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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderFavMegaVideoLoader;", "Lcom/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader;", "finderUserName", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "megaVideoCount", "", "getMegaVideoCount", "()I", "setMegaVideoCount", "(I)V", "totalCount", "getTotalCount", "setTotalCount", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "onFetchDone", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "FavMegaVideoDataFetcher", "FinderFavMegaVideoListResponse", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderFavMegaVideoLoader
  extends BaseMegaVideoLoader
{
  public int BfD;
  public int lNX;
  private final String zDJ;
  
  public FinderFavMegaVideoLoader(String paramString, bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(342218);
    this.zDJ = paramString;
    AppMethodBeat.o(342218);
  }
  
  public final i<cc> createDataFetch()
  {
    AppMethodBeat.i(342228);
    i locali = (i)new a();
    AppMethodBeat.o(342228);
    return locali;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.d<cc> createDataMerger()
  {
    AppMethodBeat.i(342235);
    com.tencent.mm.plugin.finder.feed.model.internal.d locald = (com.tencent.mm.plugin.finder.feed.model.internal.d)new c(this);
    AppMethodBeat.o(342235);
    return locald;
  }
  
  public final void onFetchDone(IResponse<cc> paramIResponse)
  {
    AppMethodBeat.i(342242);
    kotlin.g.b.s.u(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(342242);
      return;
    }
    if (((paramIResponse instanceof b)) && (paramIResponse.getPullType() == 0))
    {
      this.lNX = ((b)paramIResponse).lNX;
      this.BfD = ((b)paramIResponse).EzH;
    }
    this.hasMore = paramIResponse.getHasMore();
    kotlin.g.a.b localb = this.fetchEndCallback;
    if (localb != null) {
      localb.invoke(paramIResponse);
    }
    AppMethodBeat.o(342242);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderFavMegaVideoLoader$FavMegaVideoDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderFavMegaVideoLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends c
  {
    public a()
    {
      AppMethodBeat.i(342146);
      AppMethodBeat.o(342146);
    }
    
    public final IResponse<cc> callInit()
    {
      Object localObject1 = null;
      AppMethodBeat.i(342182);
      Log.i(getTAG(), "fetchInit");
      FinderFavMegaVideoLoader.b localb = new FinderFavMegaVideoLoader.b(0, 0, "", 0, 0);
      localb.setPullType(1000);
      Object localObject2 = this.EzG.getCache();
      if (localObject2 == null) {}
      do
      {
        if (localObject1 == null)
        {
          localObject1 = k.a.a(k.FNg, 12);
          Log.i(getTAG(), kotlin.g.b.s.X("fetchInit: use first page data list, size: ", Integer.valueOf(((List)localObject1).size())));
          localb.setIncrementList((List)localObject1);
          localb.EzH = ((List)localObject1).size();
        }
        localObject1 = (IResponse)localb;
        AppMethodBeat.o(342182);
        return localObject1;
        localObject2 = ((com.tencent.mm.plugin.finder.feed.model.s)localObject2).pUj;
      } while (localObject2 == null);
      localObject1 = this.EzG;
      Log.i(getTAG(), kotlin.g.b.s.X("fetchInit: use old data list, size: ", Integer.valueOf(((ArrayList)localObject2).size())));
      localb.setIncrementList((List)localObject2);
      localb.EzH = ((ArrayList)localObject2).size();
      localObject1 = ((FinderFavMegaVideoLoader)localObject1).getCache();
      if (localObject1 == null) {}
      for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.finder.feed.model.s)localObject1).lastBuffer)
      {
        localb.setLastBuffer((com.tencent.mm.bx.b)localObject1);
        localObject1 = ah.aiuX;
        break;
      }
    }
    
    public final IResponse<cc> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
    {
      AppMethodBeat.i(342175);
      kotlin.g.b.s.u(paramp, "scene");
      if ((paramp instanceof dv))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0) && (((dv)paramp).dVZ() == 0)) {}
        FinderFavMegaVideoLoader.b localb;
        for (boolean bool = false;; bool = true)
        {
          localb = new FinderFavMegaVideoLoader.b(paramInt1, paramInt2, paramString, ((dv)paramp).dVX(), ((dv)paramp).dWF());
          localb.setPullType(((dv)paramp).pullType);
          localObject = (Iterable)((dv)paramp).dVW();
          paramString = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject, 10));
          localObject = ((Iterable)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            paramString.add(new ca((FinderObject)((Iterator)localObject).next()));
          }
        }
        Object localObject = (List)paramString;
        localb.setIncrementList((List)localObject);
        String str = getTAG();
        paramString = localb.getIncrementList();
        if (paramString == null) {}
        for (paramString = null;; paramString = Integer.valueOf(paramString.size()))
        {
          Log.i(str, kotlin.g.b.s.X("incrementList size: ", paramString));
          localb.setLastBuffer(((dv)paramp).dVY());
          localb.setHasMore(bool);
          paramString = com.tencent.mm.plugin.finder.storage.logic.d.FND;
          d.a.d((List)((dv)paramp).dVW(), this.EzG.getContextObj());
          if (localb.getPullType() == 2) {
            break label396;
          }
          paramString = new LinkedList();
          paramp = ((Iterable)localObject).iterator();
          while (paramp.hasNext())
          {
            localObject = (ca)paramp.next();
            paramString.add(new com.tencent.mm.plugin.finder.storage.data.u(((ca)localObject).bZA(), 1, ((ca)localObject).getFeedObject()));
          }
        }
        if (paramString.size() > 0)
        {
          paramp = k.FNg;
          paramp = z.bAW();
          kotlin.g.b.s.s(paramp, "getMyFinderUsername()");
          k.a.a(12, paramp, paramString);
        }
        Log.i(getTAG(), kotlin.g.b.s.X("FavMegaVideoDataFetcher FinderPage size: ", Integer.valueOf(paramString.size())));
        label396:
        paramString = (IResponse)localb;
        AppMethodBeat.o(342175);
        return paramString;
      }
      AppMethodBeat.o(342175);
      return null;
    }
    
    public final com.tencent.mm.am.p genLoadMoreNetScene()
    {
      AppMethodBeat.i(342163);
      Object localObject = new dv(FinderFavMegaVideoLoader.a(this.EzG), this.EzG.getLastBuffer(), this.EzG.getContextObj(), 1L, (byte)0);
      ((dv)localObject).pullType = 2;
      localObject = (com.tencent.mm.am.p)localObject;
      AppMethodBeat.o(342163);
      return localObject;
    }
    
    public final com.tencent.mm.am.p genRefreshNetScene()
    {
      AppMethodBeat.i(342157);
      Object localObject = new dv(FinderFavMegaVideoLoader.a(this.EzG), this.EzG.getLastBuffer(), this.EzG.getContextObj(), 1L, (byte)0);
      ((dv)localObject).pullType = 0;
      localObject = (com.tencent.mm.am.p)localObject;
      AppMethodBeat.o(342157);
      return localObject;
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(342149);
      List localList = kotlin.a.p.listOf(Integer.valueOf(3966));
      AppMethodBeat.o(342149);
      return localList;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderFavMegaVideoLoader$FinderFavMegaVideoListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "megaVideoTotalCount", "totalCount", "(IILjava/lang/String;II)V", "getMegaVideoTotalCount", "()I", "setMegaVideoTotalCount", "(I)V", "getTotalCount", "setTotalCount", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends IResponse<cc>
  {
    int EzH;
    int lNX;
    
    public b(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4)
    {
      super(paramInt2, paramString);
      this.EzH = paramInt3;
      this.lNX = paramInt4;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/megavideo/loader/FinderFavMegaVideoLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends BaseFeedLoader<cc>.a
  {
    c(FinderFavMegaVideoLoader paramFinderFavMegaVideoLoader)
    {
      super(false, 1, null);
      AppMethodBeat.i(342150);
      AppMethodBeat.o(342150);
    }
    
    public final void mergeRefresh(final IResponse<cc> paramIResponse, final kotlin.g.a.b<? super IResponse<cc>, ah> paramb)
    {
      AppMethodBeat.i(342166);
      kotlin.g.b.s.u(paramIResponse, "response");
      Object localObject = RefreshLoadMoreLayout.d.agJr;
      localObject = new RefreshLoadMoreLayout.d(RefreshLoadMoreLayout.d.jMG());
      com.tencent.mm.ae.d.uiThread((a)new a(this, new r(7, paramIResponse.getIncrementList(), false, 12), (RefreshLoadMoreLayout.d)localObject, this.EzG, paramb, paramIResponse));
      AppMethodBeat.o(342166);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements a<ah>
    {
      a(FinderFavMegaVideoLoader.c paramc, r<cc> paramr, RefreshLoadMoreLayout.d<Object> paramd, FinderFavMegaVideoLoader paramFinderFavMegaVideoLoader, kotlin.g.a.b<? super IResponse<cc>, ah> paramb, IResponse<cc> paramIResponse)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.loader.FinderFavMegaVideoLoader
 * JD-Core Version:    0.7.0.1
 */