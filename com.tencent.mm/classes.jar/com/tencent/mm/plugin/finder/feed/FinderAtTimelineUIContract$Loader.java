package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.feed.ui.FinderAtTimelineUI;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aob;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.j;
import d.g.b.p;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$Loader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "finderUsername", "", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "fetchEndCallback", "Lkotlin/Function0;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function0;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "getFinderUsername", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onFetchDone", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "AtDataFetcher", "FinderAtTimelineResponse", "plugin-finder_release"})
public final class FinderAtTimelineUIContract$Loader
  extends BaseFinderFeedLoader
{
  private String TAG;
  public d.g.a.a<z> rTm;
  final String rTn;
  
  public FinderAtTimelineUIContract$Loader(String paramString, e parame, aqy paramaqy)
  {
    super(paramaqy);
    AppMethodBeat.i(201671);
    this.rTn = paramString;
    this.TAG = "Finder.FinderAtTimelineLoader";
    AppMethodBeat.o(201671);
  }
  
  public final g<al> createDataFetch()
  {
    AppMethodBeat.i(201669);
    g localg = (g)new a();
    AppMethodBeat.o(201669);
    return localg;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void onFetchDone(IResponse<al> paramIResponse)
  {
    AppMethodBeat.i(201670);
    p.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(201670);
      return;
    }
    if (!paramIResponse.getHasMore())
    {
      paramIResponse = this.rTm;
      if (paramIResponse != null)
      {
        paramIResponse.invoke();
        AppMethodBeat.o(201670);
        return;
      }
    }
    AppMethodBeat.o(201670);
  }
  
  public final void setTAG(String paramString)
  {
    AppMethodBeat.i(201668);
    p.h(paramString, "<set-?>");
    this.TAG = paramString;
    AppMethodBeat.o(201668);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$Loader$AtDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$Loader;)V", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdId", "plugin-finder_release"})
  public final class a
    extends com.tencent.mm.plugin.finder.feed.model.internal.a
  {
    public final IResponse<al> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(201667);
      p.h(paramn, "scene");
      ao localao = (ao)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject1 = localao.rr.aEF();
        if (localObject1 == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetMentionedListResponse");
          AppMethodBeat.o(201667);
          throw paramString;
        }
        if (((aob)localObject1).saU != 0) {}
      }
      for (boolean bool = false;; bool = true)
      {
        localObject1 = localao.rr.aEF();
        if (localObject1 != null) {
          break;
        }
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetMentionedListResponse");
        AppMethodBeat.o(201667);
        throw paramString;
      }
      Object localObject1 = (aob)localObject1;
      if (localObject1 != null) {}
      for (localObject1 = ((aob)localObject1).object;; localObject1 = null)
      {
        localObject1 = new FinderAtTimelineUIContract.Loader.b(((LinkedList)localObject1).size(), paramInt1, paramInt2, paramString);
        paramn = (Iterable)((ao)paramn).cyt();
        paramString = (Collection)new ArrayList(j.a(paramn, 10));
        paramn = paramn.iterator();
        while (paramn.hasNext())
        {
          localObject2 = (FinderObject)paramn.next();
          Object localObject3 = FinderItem.syk;
          localObject2 = FinderItem.a.a((FinderObject)localObject2, 8192);
          localObject3 = FinderAtTimelineUI.sdp;
          ((Map)FinderAtTimelineUI.cCa()).put(Long.valueOf(((FinderItem)localObject2).getId()), localObject2);
          localObject3 = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
          paramString.add(b.a.j((FinderItem)localObject2));
        }
      }
      ((FinderAtTimelineUIContract.Loader.b)localObject1).setIncrementList((List)paramString);
      paramn = getTAG();
      Object localObject2 = new StringBuilder("incrementList size: ");
      paramString = ((FinderAtTimelineUIContract.Loader.b)localObject1).getIncrementList();
      if (paramString != null) {}
      for (paramString = Integer.valueOf(paramString.size());; paramString = null)
      {
        ad.i(paramn, paramString);
        ((FinderAtTimelineUIContract.Loader.b)localObject1).setPullType(localao.pullType);
        paramString = localao.rr.aEF();
        if (paramString != null) {
          break;
        }
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetMentionedListResponse");
        AppMethodBeat.o(201667);
        throw paramString;
      }
      ((FinderAtTimelineUIContract.Loader.b)localObject1).setLastBuffer(((aob)paramString).GmG);
      ((FinderAtTimelineUIContract.Loader.b)localObject1).setHasMore(bool);
      paramString = (IResponse)localObject1;
      AppMethodBeat.o(201667);
      return paramString;
    }
    
    public final n genLoadMoreNetScene()
    {
      AppMethodBeat.i(201666);
      Object localObject = new ao(this.rTo.rTn, this.rTo.getLastBuffer());
      ((ao)localObject).pullType = 2;
      localObject = (n)localObject;
      AppMethodBeat.o(201666);
      return localObject;
    }
    
    public final n genRefreshNetScene()
    {
      AppMethodBeat.i(201665);
      Object localObject = new ao(this.rTo.rTn, this.rTo.getLastBuffer());
      ((ao)localObject).pullType = 1;
      localObject = (n)localObject;
      AppMethodBeat.o(201665);
      return localObject;
    }
    
    public final int getCmdId()
    {
      return 3810;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$Loader$FinderAtTimelineResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "totalCount", "", "errType", "", "errCode", "errMsg", "", "(JIILjava/lang/String;)V", "getTotalCount", "()J", "plugin-finder_release"})
  public static final class b
    extends IResponse<al>
  {
    private final long rTp;
    
    public b(long paramLong, int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
      this.rTp = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.FinderAtTimelineUIContract.Loader
 * JD-Core Version:    0.7.0.1
 */