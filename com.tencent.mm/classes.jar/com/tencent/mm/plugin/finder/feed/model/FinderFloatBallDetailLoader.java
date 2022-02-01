package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.protocal.protobuf.ayl;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFloatBallDetailLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "firstFeedId", "", "getFirstFeedId", "()J", "setFirstFeedId", "(J)V", "firstNonceId", "", "getFirstNonceId", "()Ljava/lang/String;", "setFirstNonceId", "(Ljava/lang/String;)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "FloatBallDetailDataFetcher", "FloatBallDetailResponse", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderFloatBallDetailLoader
  extends BaseFinderFeedLoader
{
  public long Bgq;
  String Bgr;
  
  public FinderFloatBallDetailLoader(bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(366316);
    this.Bgr = "";
    AppMethodBeat.o(366316);
  }
  
  public final void avV(String paramString)
  {
    AppMethodBeat.i(366325);
    kotlin.g.b.s.u(paramString, "<set-?>");
    this.Bgr = paramString;
    AppMethodBeat.o(366325);
  }
  
  public final i<cc> createDataFetch()
  {
    AppMethodBeat.i(366334);
    i locali = (i)new a();
    AppMethodBeat.o(366334);
    return locali;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.d<cc> createDataMerger()
  {
    AppMethodBeat.i(366343);
    com.tencent.mm.plugin.finder.feed.model.internal.d locald = (com.tencent.mm.plugin.finder.feed.model.internal.d)new c(this);
    AppMethodBeat.o(366343);
    return locald;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFloatBallDetailLoader$FloatBallDetailDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchCgi;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderFloatBallDetailLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "requestCgi", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "resp", "genLoadMoreCgi", "Lcom/tencent/mm/plugin/finder/cgi/CgiGetFinderFeedComment;", "genRefreshCgi", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends com.tencent.mm.plugin.finder.feed.model.internal.b
  {
    public a()
    {
      AppMethodBeat.i(365862);
      AppMethodBeat.o(365862);
    }
    
    public final IResponse<cc> a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.b<? extends esc> paramb, esc paramesc)
    {
      AppMethodBeat.i(365870);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if ((paramesc instanceof ayl)) {}
        for (paramb = (ayl)paramesc; paramb != null; paramb = null)
        {
          paramesc = paramb.feedObject;
          if (paramesc == null) {
            break;
          }
          paramb = this.Bgs;
          Object localObject = FinderItem.Companion;
          paramesc = FinderItem.a.e(paramesc, 1);
          localObject = com.tencent.mm.plugin.finder.storage.logic.d.FND;
          paramesc = d.a.a(paramesc);
          paramesc.ignoreLongTerm = true;
          paramString = new FinderFloatBallDetailLoader.b(paramb, paramInt1, paramInt2, paramString);
          paramString.setIncrementList(p.listOf(paramesc));
          paramString.setPullType(0);
          paramString = (IResponse)paramString;
          AppMethodBeat.o(365870);
          return paramString;
        }
      }
      AppMethodBeat.o(365870);
      return null;
    }
    
    public final IResponse<cc> callInit()
    {
      AppMethodBeat.i(365881);
      FinderFloatBallDetailLoader.b localb = new FinderFloatBallDetailLoader.b(this.Bgs, 0, 0, "");
      localb.setPullType(1000);
      Object localObject = this.Bgs.getCache();
      FinderFloatBallDetailLoader localFinderFloatBallDetailLoader;
      if (localObject != null)
      {
        ArrayList localArrayList = ((s)localObject).pUj;
        if (localArrayList != null)
        {
          localFinderFloatBallDetailLoader = this.Bgs;
          Log.i(getTAG(), kotlin.g.b.s.X("fetchInit: use old data list, size: ", Integer.valueOf(localArrayList.size())));
          localb.setIncrementList((List)localArrayList);
          localObject = localFinderFloatBallDetailLoader.getCache();
          if (localObject != null) {
            break label158;
          }
          localObject = null;
          localb.setLastBuffer((com.tencent.mm.bx.b)localObject);
          localObject = p.ae((List)localArrayList, 0);
          if (!(localObject instanceof BaseFinderFeed)) {
            break label166;
          }
        }
      }
      label158:
      label166:
      for (localObject = (BaseFinderFeed)localObject;; localObject = null)
      {
        if (localObject != null)
        {
          localFinderFloatBallDetailLoader.Bgq = ((BaseFinderFeed)localObject).bZA();
          localFinderFloatBallDetailLoader.avV(((BaseFinderFeed)localObject).feedObject.getObjectNonceId());
        }
        localObject = (IResponse)localb;
        AppMethodBeat.o(365881);
        return localObject;
        localObject = ((s)localObject).lastBuffer;
        break;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFloatBallDetailLoader$FloatBallDetailResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderFloatBallDetailLoader;IILjava/lang/String;)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends IResponse<cc>
  {
    public b(int paramInt, String paramString)
    {
      super(paramString, str);
      AppMethodBeat.i(365890);
      AppMethodBeat.o(365890);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/model/FinderFloatBallDetailLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends BaseFeedLoader<cc>.a
  {
    c(FinderFloatBallDetailLoader paramFinderFloatBallDetailLoader)
    {
      super(false, 1, null);
      AppMethodBeat.i(365885);
      AppMethodBeat.o(365885);
    }
    
    public final void mergeRefresh(final IResponse<cc> paramIResponse, final kotlin.g.a.b<? super IResponse<cc>, ah> paramb)
    {
      AppMethodBeat.i(365893);
      kotlin.g.b.s.u(paramIResponse, "response");
      if ((paramIResponse instanceof FinderFloatBallDetailLoader.b))
      {
        if (paramIResponse.getIncrementList() == null) {
          paramIResponse.setIncrementList((List)ab.aivy);
        }
        com.tencent.mm.ae.d.uiThread((a)new a(this.Bgs, paramIResponse, paramb));
        AppMethodBeat.o(365893);
        return;
      }
      super.mergeRefresh(paramIResponse, paramb);
      AppMethodBeat.o(365893);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements a<ah>
    {
      a(FinderFloatBallDetailLoader paramFinderFloatBallDetailLoader, IResponse<cc> paramIResponse, kotlin.g.a.b<? super IResponse<cc>, ah> paramb)
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