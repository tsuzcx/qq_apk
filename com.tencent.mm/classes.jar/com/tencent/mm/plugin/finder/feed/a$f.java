package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.c;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.a.a;
import d.g.b.k;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$Loader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "finderUsername", "", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "fetchEndCallback", "Lkotlin/Function0;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function0;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "getFinderUsername", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "onFetchDone", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "requestLoadMore", "requestRefresh", "plugin-finder_release"})
public final class a$f
  extends BaseFinderFeedLoader
{
  private String TAG;
  public a<y> fetchEndCallback;
  private b lastBuffer;
  private final String rfC;
  
  public a$f(String paramString, c paramc, anm paramanm)
  {
    super(null, paramanm, 1, null);
    AppMethodBeat.i(201505);
    this.rfC = paramString;
    this.TAG = "Finder.FinderAtTimelineLoader";
    AppMethodBeat.o(201505);
  }
  
  public final e<Object, Object, h> createDataFetch(anm paramanm)
  {
    AppMethodBeat.i(201501);
    paramanm = (e)new a.b();
    AppMethodBeat.o(201501);
    return paramanm;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void onFetchDone(IResponse<BaseFinderFeed> paramIResponse)
  {
    AppMethodBeat.i(201504);
    k.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    paramIResponse.getPullType();
    if ((paramIResponse instanceof a.e)) {
      this.lastBuffer = paramIResponse.getLastBuffer();
    }
    if (!paramIResponse.getHasMore())
    {
      paramIResponse = this.fetchEndCallback;
      if (paramIResponse != null)
      {
        paramIResponse.invoke();
        AppMethodBeat.o(201504);
        return;
      }
    }
    AppMethodBeat.o(201504);
  }
  
  public final void requestLoadMore()
  {
    AppMethodBeat.i(201503);
    a.d locald = new a.d(this.rfC, this.lastBuffer, 2);
    ac.i(getTAG(), "requestLoadMore ".concat(String.valueOf(locald)));
    fetchData((i)locald);
    AppMethodBeat.o(201503);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(201502);
    a.d locald = new a.d(this.rfC, this.lastBuffer, 1);
    ac.i(getTAG(), "requestLoadMore ".concat(String.valueOf(locald)));
    fetchData((i)locald);
    AppMethodBeat.o(201502);
  }
  
  public final void setTAG(String paramString)
  {
    AppMethodBeat.i(201500);
    k.h(paramString, "<set-?>");
    this.TAG = paramString;
    AppMethodBeat.o(201500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.a.f
 * JD-Core Version:    0.7.0.1
 */