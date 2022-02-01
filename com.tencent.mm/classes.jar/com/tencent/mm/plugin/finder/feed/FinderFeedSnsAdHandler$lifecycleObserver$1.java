package com.tencent.mm.plugin.finder.feed;

import androidx.lifecycle.h.a;
import androidx.lifecycle.k;
import androidx.lifecycle.t;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderFeedSnsAdHandler$lifecycleObserver$1", "Landroidx/lifecycle/LifecycleObserver;", "isFirstResume", "", "onPause", "", "onResume", "plugin-finder_release"})
public final class FinderFeedSnsAdHandler$lifecycleObserver$1
  implements k
{
  private boolean wXR;
  
  @t(jl=h.a.ON_PAUSE)
  public final void onPause()
  {
    AppMethodBeat.i(288655);
    RecyclerView localRecyclerView = this.xyD.jLl;
    if (localRecyclerView != null) {
      localRecyclerView.removeCallbacks(p.b(this.xyD));
    }
    p.a(this.xyD, p.d(p.d(this.xyD)));
    p.e(this.xyD);
    AppMethodBeat.o(288655);
  }
  
  @t(jl=h.a.ON_RESUME)
  public final void onResume()
  {
    AppMethodBeat.i(288654);
    if (!this.wXR)
    {
      this.wXR = true;
      AppMethodBeat.o(288654);
      return;
    }
    p.c(this.xyD);
    AppMethodBeat.o(288654);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.FinderFeedSnsAdHandler.lifecycleObserver.1
 * JD-Core Version:    0.7.0.1
 */