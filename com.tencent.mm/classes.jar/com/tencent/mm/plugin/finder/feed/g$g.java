package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.feed.model.internal.j;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.a.a;
import d.g.b.k;
import d.l;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$Loader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "finderUsername", "", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "fetchEndCallback", "Lkotlin/Function0;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function0;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "getFinderUsername", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "onFetchDone", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "requestLoadMore", "requestRefresh", "plugin-finder_release"})
public final class g$g
  extends BaseFinderFeedLoader
{
  private String TAG;
  public a<y> fetchEndCallback;
  private final String finderUsername;
  private com.tencent.mm.bx.b lastBuffer;
  
  public g$g(String paramString, com.tencent.mm.plugin.finder.feed.model.internal.b paramb, dzp paramdzp)
  {
    super(null, paramdzp, 1, null);
    AppMethodBeat.i(197608);
    this.finderUsername = paramString;
    this.TAG = "Finder.FinderAtTimelineLoader";
    AppMethodBeat.o(197608);
  }
  
  public final f<Object, Object, i> createDataFetch(dzp paramdzp)
  {
    AppMethodBeat.i(197604);
    paramdzp = (f)new g.c();
    AppMethodBeat.o(197604);
    return paramdzp;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void onFetchDone(IResponse<BaseFinderFeed> paramIResponse)
  {
    AppMethodBeat.i(197607);
    k.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    paramIResponse.getPullType();
    if ((paramIResponse instanceof g.f)) {
      this.lastBuffer = paramIResponse.getLastBuffer();
    }
    if (!paramIResponse.getHasMore())
    {
      paramIResponse = this.fetchEndCallback;
      if (paramIResponse != null)
      {
        paramIResponse.invoke();
        AppMethodBeat.o(197607);
        return;
      }
    }
    AppMethodBeat.o(197607);
  }
  
  public final void requestLoadMore()
  {
    AppMethodBeat.i(197606);
    g.e locale = new g.e(this.finderUsername, this.lastBuffer, 2);
    ad.i(getTAG(), "requestLoadMore ".concat(String.valueOf(locale)));
    fetchData((j)locale);
    AppMethodBeat.o(197606);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(197605);
    g.e locale = new g.e(this.finderUsername, this.lastBuffer, 1);
    ad.i(getTAG(), "requestLoadMore ".concat(String.valueOf(locale)));
    fetchData((j)locale);
    AppMethodBeat.o(197605);
  }
  
  public final void setTAG(String paramString)
  {
    AppMethodBeat.i(197603);
    k.h(paramString, "<set-?>");
    this.TAG = paramString;
    AppMethodBeat.o(197603);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.g.g
 * JD-Core Version:    0.7.0.1
 */