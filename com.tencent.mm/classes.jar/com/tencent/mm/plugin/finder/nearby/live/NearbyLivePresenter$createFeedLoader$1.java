package com.tencent.mm.plugin.finder.nearby.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.protocal.protobuf.bid;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter$createFeedLoader$1", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader;", "onFetchDone", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "plugin-finder-nearby_release"})
public final class NearbyLivePresenter$createFeedLoader$1
  extends NearbyLiveFeedLoader
{
  NearbyLivePresenter$createFeedLoader$1(bid parambid, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    super(paramInt1, paramInt2, paramInt3, paramString, str);
  }
  
  public final void onFetchDone(IResponse<bu> paramIResponse)
  {
    AppMethodBeat.i(201336);
    p.k(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    e.a(this.zEv, paramIResponse.getLastBuffer());
    AppMethodBeat.o(201336);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.NearbyLivePresenter.createFeedLoader.1
 * JD-Core Version:    0.7.0.1
 */