package com.tencent.mm.plugin.finder.nearby.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.protocal.protobuf.bui;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter$createFeedLoader$1", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader;", "onFetchDone", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class NearbyLivePresenter$createFeedLoader$1
  extends NearbyLiveFeedLoader
{
  NearbyLivePresenter$createFeedLoader$1(e parame, bui parambui, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    super(parambui, paramInt1, paramInt2, paramInt3, paramString);
  }
  
  public final void onFetchDone(IResponse<cc> paramIResponse)
  {
    int i = 1;
    AppMethodBeat.i(340705);
    s.u(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    e.c(paramIResponse);
    e.a(this.EJe, paramIResponse.getLastBuffer());
    NearbyLiveFeedLoader localNearbyLiveFeedLoader = this.EJe.EIZ;
    if ((localNearbyLiveFeedLoader != null) && (localNearbyLiveFeedLoader.isInsertSpecifyOperation(paramIResponse) == true)) {}
    for (;;)
    {
      if (i != 0) {
        e.a(this.EJe, paramIResponse);
      }
      e.d(paramIResponse);
      AppMethodBeat.o(340705);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.NearbyLivePresenter.createFeedLoader.1
 * JD-Core Version:    0.7.0.1
 */