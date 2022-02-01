package com.tencent.mm.plugin.finder.nearby.live;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.je;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.sdk.event.IListener;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter$finderNearbyDataUpdateEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderNearbyDataUpdateEvent;", "callback", "", "event", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class NearbyLivePresenter$finderNearbyDataUpdateEventListener$1
  extends IListener<je>
{
  NearbyLivePresenter$finderNearbyDataUpdateEventListener$1(e parame, f paramf)
  {
    super((q)paramf);
    AppMethodBeat.i(340656);
    AppMethodBeat.o(340656);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<IResponse<cc>, ah>
  {
    a(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.NearbyLivePresenter.finderNearbyDataUpdateEventListener.1
 * JD-Core Version:    0.7.0.1
 */