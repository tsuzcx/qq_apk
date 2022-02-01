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
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract$Loader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "targetUsername", "", "refObjectId", "", "refObjectNonceId", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;JLjava/lang/String;Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "getRefObjectId", "()J", "getRefObjectNonceId", "()Ljava/lang/String;", "getTargetUsername", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "onFetchDone", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "requestLoadMore", "requestRefresh", "plugin-finder_release"})
public final class w$a
  extends BaseFinderFeedLoader
{
  private b lastBuffer;
  private final String qYd;
  private final long refObjectId;
  private final String refObjectNonceId;
  
  public w$a(String paramString1, long paramLong, String paramString2, c paramc, anm paramanm)
  {
    super(null, paramanm, 1, null);
    AppMethodBeat.i(201800);
    this.qYd = paramString1;
    this.refObjectId = paramLong;
    this.refObjectNonceId = paramString2;
    AppMethodBeat.o(201800);
  }
  
  public final e<Object, Object, h> createDataFetch(anm paramanm)
  {
    AppMethodBeat.i(201799);
    paramanm = (e)new w.c();
    AppMethodBeat.o(201799);
    return paramanm;
  }
  
  public final void onFetchDone(IResponse<BaseFinderFeed> paramIResponse)
  {
    AppMethodBeat.i(165841);
    k.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if ((paramIResponse instanceof w.f)) {
      this.lastBuffer = paramIResponse.getLastBuffer();
    }
    AppMethodBeat.o(165841);
  }
  
  public final void requestLoadMore()
  {
    AppMethodBeat.i(165840);
    w.e locale = new w.e(this.qYd, this.refObjectId, this.refObjectNonceId, this.lastBuffer, 2);
    ac.i(getTAG(), "requestLoadMore ".concat(String.valueOf(locale)));
    fetchData((i)locale);
    AppMethodBeat.o(165840);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(165839);
    w.e locale = new w.e(this.qYd, this.refObjectId, this.refObjectNonceId, this.lastBuffer, 0);
    ac.i(getTAG(), "requestRefresh ".concat(String.valueOf(locale)));
    fetchData((i)locale);
    AppMethodBeat.o(165839);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.w.a
 * JD-Core Version:    0.7.0.1
 */