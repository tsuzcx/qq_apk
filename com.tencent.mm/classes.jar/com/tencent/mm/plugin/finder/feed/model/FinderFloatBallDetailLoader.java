package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.protocal.protobuf.att;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFloatBallDetailLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "firstFeedId", "", "firstNonceId", "", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "FloatBallDetailDataFetcher", "FloatBallDetailResponse", "plugin-finder_release"})
public final class FinderFloatBallDetailLoader
  extends BaseFinderFeedLoader
{
  private long xHm;
  private String xHn;
  
  public FinderFloatBallDetailLoader(bid parambid)
  {
    super(parambid);
    AppMethodBeat.i(280868);
    this.xHn = "";
    AppMethodBeat.o(280868);
  }
  
  public final i<bu> createDataFetch()
  {
    AppMethodBeat.i(280864);
    i locali = (i)new a();
    AppMethodBeat.o(280864);
    return locali;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.d<bu> createDataMerger()
  {
    AppMethodBeat.i(280867);
    com.tencent.mm.plugin.finder.feed.model.internal.d locald = (com.tencent.mm.plugin.finder.feed.model.internal.d)new c(this);
    AppMethodBeat.o(280867);
    return locald;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFloatBallDetailLoader$FloatBallDetailDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchCgi;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderFloatBallDetailLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "requestCgi", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "resp", "genLoadMoreCgi", "Lcom/tencent/mm/plugin/finder/cgi/CgiGetFinderFeedComment;", "genRefreshCgi", "plugin-finder_release"})
  public final class a
    extends com.tencent.mm.plugin.finder.feed.model.internal.b
  {
    public final IResponse<bu> a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.c<? extends dyy> paramc, dyy paramdyy)
    {
      AppMethodBeat.i(276802);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        if ((paramdyy instanceof att)) {
          break label128;
        }
      }
      label128:
      for (paramc = null;; paramc = paramdyy)
      {
        paramc = (att)paramc;
        if (paramc != null)
        {
          paramc = paramc.feedObject;
          if (paramc != null)
          {
            paramdyy = FinderItem.Companion;
            p.j(paramc, "it");
            paramc = FinderItem.a.b(paramc, 1);
            paramdyy = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
            paramc = c.a.a(paramc);
            paramString = new FinderFloatBallDetailLoader.b(this.xHo, paramInt1, paramInt2, paramString);
            paramString.setIncrementList(j.listOf(paramc));
            paramString.setPullType(0);
            paramString = (IResponse)paramString;
            AppMethodBeat.o(276802);
            return paramString;
          }
        }
        AppMethodBeat.o(276802);
        return null;
      }
    }
    
    public final IResponse<bu> callInit()
    {
      AppMethodBeat.i(276803);
      FinderFloatBallDetailLoader.b localb = new FinderFloatBallDetailLoader.b(this.xHo, 0, 0, "");
      localb.setPullType(1000);
      Object localObject1 = this.xHo.getCache();
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = ((q)localObject1).mXB;
        if (localObject2 != null)
        {
          Log.i(getTAG(), "fetchInit: use old data list, size: " + ((ArrayList)localObject2).size());
          localb.setIncrementList((List)localObject2);
          localObject1 = this.xHo.getCache();
          if (localObject1 == null) {
            break label171;
          }
        }
      }
      label171:
      for (localObject1 = ((q)localObject1).lastBuffer;; localObject1 = null)
      {
        localb.setLastBuffer((com.tencent.mm.cd.b)localObject1);
        localObject2 = j.M((List)localObject2, 0);
        localObject1 = localObject2;
        if (!(localObject2 instanceof BaseFinderFeed)) {
          localObject1 = null;
        }
        localObject1 = (BaseFinderFeed)localObject1;
        if (localObject1 != null)
        {
          FinderFloatBallDetailLoader.a(this.xHo, ((BaseFinderFeed)localObject1).mf());
          FinderFloatBallDetailLoader.a(this.xHo, ((BaseFinderFeed)localObject1).feedObject.getObjectNonceId());
        }
        localObject1 = (IResponse)localb;
        AppMethodBeat.o(276803);
        return localObject1;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFloatBallDetailLoader$FloatBallDetailResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderFloatBallDetailLoader;IILjava/lang/String;)V", "plugin-finder_release"})
  public final class b
    extends IResponse<bu>
  {
    public b(int paramInt, String paramString)
    {
      super(paramString, str);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/model/FinderFloatBallDetailLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
  public static final class c
    extends BaseFeedLoader<bu>.a
  {
    c()
    {
      super();
    }
    
    public final void mergeRefresh(final IResponse<bu> paramIResponse, final kotlin.g.a.b<? super IResponse<bu>, x> paramb)
    {
      AppMethodBeat.i(290678);
      p.k(paramIResponse, "response");
      if ((paramIResponse instanceof FinderFloatBallDetailLoader.b))
      {
        if (paramIResponse.getIncrementList() == null) {
          paramIResponse.setIncrementList((List)v.aaAd);
        }
        com.tencent.mm.ae.d.uiThread((a)new a(this, paramIResponse, paramb));
        AppMethodBeat.o(290678);
        return;
      }
      super.mergeRefresh(paramIResponse, paramb);
      AppMethodBeat.o(290678);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements a<x>
    {
      a(FinderFloatBallDetailLoader.c paramc, IResponse paramIResponse, kotlin.g.a.b paramb)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderFloatBallDetailLoader
 * JD-Core Version:    0.7.0.1
 */