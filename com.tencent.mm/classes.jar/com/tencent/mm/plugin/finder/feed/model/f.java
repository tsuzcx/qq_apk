package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.a.a;
import d.g.b.k;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "fetchEndCallback", "Lkotlin/Function0;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function0;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "getScene", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "onFetchDone", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "requestLoadMore", "requestRefresh", "plugin-finder_release"})
public final class f
  extends BaseFinderFeedLoader
{
  private final com.tencent.mm.plugin.finder.feed.model.internal.b KQj;
  public a<y> fetchEndCallback;
  private com.tencent.mm.bx.b lastBuffer;
  
  public f(com.tencent.mm.plugin.finder.feed.model.internal.b paramb, dzp paramdzp)
  {
    super(null, paramdzp, 1, null);
    AppMethodBeat.i(198270);
    this.KQj = paramb;
    AppMethodBeat.o(198270);
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.f<Object, Object, i> createDataFetch(dzp paramdzp)
  {
    AppMethodBeat.i(198269);
    paramdzp = (com.tencent.mm.plugin.finder.feed.model.internal.f)new j(paramdzp);
    AppMethodBeat.o(198269);
    return paramdzp;
  }
  
  public final void onFetchDone(IResponse<BaseFinderFeed> paramIResponse)
  {
    AppMethodBeat.i(166040);
    k.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    this.lastBuffer = paramIResponse.getLastBuffer();
    if (2 == paramIResponse.getPullType()) {}
    for (int i = 1; (i != 0) && (!paramIResponse.getHasMore()); i = 0)
    {
      paramIResponse = this.fetchEndCallback;
      if (paramIResponse == null) {
        break;
      }
      paramIResponse.invoke();
      AppMethodBeat.o(166040);
      return;
    }
    AppMethodBeat.o(166040);
  }
  
  public final void requestLoadMore()
  {
    AppMethodBeat.i(166039);
    if (getDataList().size() > 0) {}
    for (long l = ((BaseFinderFeed)getDataList().get(getDataList().size() - 1)).feedObject.getFeedObject().displayId;; l = 0L)
    {
      l locall = new l(l, this.lastBuffer, 2);
      ad.i(getTAG(), "requestLoadMore " + locall.qyO);
      fetchData((com.tencent.mm.plugin.finder.feed.model.internal.j)locall);
      AppMethodBeat.o(166039);
      return;
    }
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(166038);
    l locall = new l(0L, this.lastBuffer, 1);
    ad.i(getTAG(), "requestRefresh ".concat(String.valueOf(locall)));
    fetchData((com.tencent.mm.plugin.finder.feed.model.internal.j)locall);
    AppMethodBeat.o(166038);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.f
 * JD-Core Version:    0.7.0.1
 */