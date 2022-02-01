package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.finder.cgi.ap;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.feed.ui.FinderAtTimelineUI;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aoo;
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
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$Loader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "finderUsername", "", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "fetchEndCallback", "Lkotlin/Function0;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function0;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "getFinderUsername", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onFetchDone", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "AtDataFetcher", "FinderAtTimelineResponse", "plugin-finder_release"})
public final class FinderAtTimelineUIContract$Loader
  extends BaseFinderFeedLoader
{
  private String TAG;
  public d.g.a.a<z> sbQ;
  final String sbR;
  
  public FinderAtTimelineUIContract$Loader(String paramString, e parame, arn paramarn)
  {
    super(paramarn);
    AppMethodBeat.i(202130);
    this.sbR = paramString;
    this.TAG = "Finder.FinderAtTimelineLoader";
    AppMethodBeat.o(202130);
  }
  
  public final g<am> createDataFetch()
  {
    AppMethodBeat.i(202128);
    g localg = (g)new a();
    AppMethodBeat.o(202128);
    return localg;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void onFetchDone(IResponse<am> paramIResponse)
  {
    AppMethodBeat.i(202129);
    p.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(202129);
      return;
    }
    if (!paramIResponse.getHasMore())
    {
      paramIResponse = this.sbQ;
      if (paramIResponse != null)
      {
        paramIResponse.invoke();
        AppMethodBeat.o(202129);
        return;
      }
    }
    AppMethodBeat.o(202129);
  }
  
  public final void setTAG(String paramString)
  {
    AppMethodBeat.i(202127);
    p.h(paramString, "<set-?>");
    this.TAG = paramString;
    AppMethodBeat.o(202127);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$Loader$AtDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$Loader;)V", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdId", "plugin-finder_release"})
  public final class a
    extends com.tencent.mm.plugin.finder.feed.model.internal.a
  {
    public final IResponse<am> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(202126);
      p.h(paramn, "scene");
      ap localap = (ap)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject1 = localap.rr.aEV();
        if (localObject1 == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetMentionedListResponse");
          AppMethodBeat.o(202126);
          throw paramString;
        }
        if (((aoo)localObject1).sjK != 0) {}
      }
      for (boolean bool = false;; bool = true)
      {
        localObject1 = localap.rr.aEV();
        if (localObject1 != null) {
          break;
        }
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetMentionedListResponse");
        AppMethodBeat.o(202126);
        throw paramString;
      }
      Object localObject1 = (aoo)localObject1;
      if (localObject1 != null) {}
      for (localObject1 = ((aoo)localObject1).object;; localObject1 = null)
      {
        localObject1 = new FinderAtTimelineUIContract.Loader.b(((LinkedList)localObject1).size(), paramInt1, paramInt2, paramString);
        paramn = (Iterable)((ap)paramn).czU();
        paramString = (Collection)new ArrayList(j.a(paramn, 10));
        paramn = paramn.iterator();
        while (paramn.hasNext())
        {
          localObject2 = (FinderObject)paramn.next();
          Object localObject3 = FinderItem.sJb;
          localObject2 = FinderItem.a.a((FinderObject)localObject2, 8192);
          localObject3 = FinderAtTimelineUI.smg;
          ((Map)FinderAtTimelineUI.cDM()).put(Long.valueOf(((FinderItem)localObject2).getId()), localObject2);
          localObject3 = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
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
        ae.i(paramn, paramString);
        ((FinderAtTimelineUIContract.Loader.b)localObject1).setPullType(localap.pullType);
        paramString = localap.rr.aEV();
        if (paramString != null) {
          break;
        }
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetMentionedListResponse");
        AppMethodBeat.o(202126);
        throw paramString;
      }
      ((FinderAtTimelineUIContract.Loader.b)localObject1).setLastBuffer(((aoo)paramString).GFN);
      ((FinderAtTimelineUIContract.Loader.b)localObject1).setHasMore(bool);
      paramString = (IResponse)localObject1;
      AppMethodBeat.o(202126);
      return paramString;
    }
    
    public final n genLoadMoreNetScene()
    {
      AppMethodBeat.i(202125);
      Object localObject = new ap(this.sbS.sbR, this.sbS.getLastBuffer());
      ((ap)localObject).pullType = 2;
      localObject = (n)localObject;
      AppMethodBeat.o(202125);
      return localObject;
    }
    
    public final n genRefreshNetScene()
    {
      AppMethodBeat.i(202124);
      Object localObject = new ap(this.sbS.sbR, this.sbS.getLastBuffer());
      ((ap)localObject).pullType = 1;
      localObject = (n)localObject;
      AppMethodBeat.o(202124);
      return localObject;
    }
    
    public final int getCmdId()
    {
      return 3810;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$Loader$FinderAtTimelineResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "totalCount", "", "errType", "", "errCode", "errMsg", "", "(JIILjava/lang/String;)V", "getTotalCount", "()J", "plugin-finder_release"})
  public static final class b
    extends IResponse<am>
  {
    private final long sbT;
    
    public b(long paramLong, int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
      this.sbT = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.FinderAtTimelineUIContract.Loader
 * JD-Core Version:    0.7.0.1
 */