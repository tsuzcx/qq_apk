package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.c;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.a.a;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "fetchEndCallback", "Lkotlin/Function0;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function0;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "getScene", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "onFetchDone", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "requestLoadMore", "requestRefresh", "plugin-finder_release"})
public final class k
  extends BaseFinderFeedLoader
{
  public a<y> fetchEndCallback;
  private b lastBuffer;
  private final c rne;
  
  public k(c paramc, anm paramanm)
  {
    super(null, paramanm, 1, null);
    AppMethodBeat.i(202180);
    this.rne = paramc;
    AppMethodBeat.o(202180);
  }
  
  public final e<Object, Object, h> createDataFetch(anm paramanm)
  {
    AppMethodBeat.i(202179);
    paramanm = (e)new o(paramanm);
    AppMethodBeat.o(202179);
    return paramanm;
  }
  
  public final void onFetchDone(IResponse<BaseFinderFeed> paramIResponse)
  {
    AppMethodBeat.i(166040);
    d.g.b.k.h(paramIResponse, "response");
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
      q localq = new q(l, this.lastBuffer, 2);
      ac.i(getTAG(), "requestLoadMore " + localq.rnv);
      fetchData((i)localq);
      AppMethodBeat.o(166039);
      return;
    }
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(166038);
    q localq = new q(0L, this.lastBuffer, 1);
    ac.i(getTAG(), "requestRefresh ".concat(String.valueOf(localq)));
    fetchData((i)localq);
    AppMethodBeat.o(166038);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.k
 * JD-Core Version:    0.7.0.1
 */