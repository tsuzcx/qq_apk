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
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract$Loader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "targetUsername", "", "refObjectId", "", "refObjectNonceId", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;JLjava/lang/String;Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "getRefObjectId", "()J", "getRefObjectNonceId", "()Ljava/lang/String;", "getTargetUsername", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "onFetchDone", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "requestLoadMore", "requestRefresh", "plugin-finder_release"})
public final class h$a
  extends BaseFinderFeedLoader
{
  private com.tencent.mm.bx.b lastBuffer;
  private final String qwI;
  private final long refObjectId;
  private final String refObjectNonceId;
  
  public h$a(String paramString1, long paramLong, String paramString2, com.tencent.mm.plugin.finder.feed.model.internal.b paramb, dzp paramdzp)
  {
    super(null, paramdzp, 1, null);
    AppMethodBeat.i(197903);
    this.qwI = paramString1;
    this.refObjectId = paramLong;
    this.refObjectNonceId = paramString2;
    AppMethodBeat.o(197903);
  }
  
  public final f<Object, Object, i> createDataFetch(dzp paramdzp)
  {
    AppMethodBeat.i(197902);
    paramdzp = (f)new h.c();
    AppMethodBeat.o(197902);
    return paramdzp;
  }
  
  public final void onFetchDone(IResponse<BaseFinderFeed> paramIResponse)
  {
    AppMethodBeat.i(165841);
    k.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if ((paramIResponse instanceof h.f)) {
      this.lastBuffer = paramIResponse.getLastBuffer();
    }
    AppMethodBeat.o(165841);
  }
  
  public final void requestLoadMore()
  {
    AppMethodBeat.i(165840);
    h.e locale = new h.e(this.qwI, this.refObjectId, this.refObjectNonceId, this.lastBuffer, 2);
    ad.i(getTAG(), "requestLoadMore ".concat(String.valueOf(locale)));
    fetchData((j)locale);
    AppMethodBeat.o(165840);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(165839);
    h.e locale = new h.e(this.qwI, this.refObjectId, this.refObjectNonceId, this.lastBuffer, 0);
    ad.i(getTAG(), "requestRefresh ".concat(String.valueOf(locale)));
    fetchData((j)locale);
    AppMethodBeat.o(165839);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.h.a
 * JD-Core Version:    0.7.0.1
 */