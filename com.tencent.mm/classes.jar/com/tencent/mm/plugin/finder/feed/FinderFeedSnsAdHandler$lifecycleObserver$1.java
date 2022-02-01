package com.tencent.mm.plugin.finder.feed;

import androidx.lifecycle.j.a;
import androidx.lifecycle.p;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderFeedSnsAdHandler$lifecycleObserver$1", "Landroidx/lifecycle/LifecycleObserver;", "isFirstResume", "", "onPause", "", "onResume", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderFeedSnsAdHandler$lifecycleObserver$1
  implements p
{
  private boolean AuP;
  
  FinderFeedSnsAdHandler$lifecycleObserver$1(o paramo) {}
  
  @z(Ho=j.a.ON_PAUSE)
  public final void onPause()
  {
    AppMethodBeat.i(363477);
    RecyclerView localRecyclerView = this.AVE.mkw;
    if (localRecyclerView != null) {
      localRecyclerView.removeCallbacks(o.f(this.AVE));
    }
    o.a(this.AVE, o.g(o.g(this.AVE)));
    o.h(this.AVE);
    AppMethodBeat.o(363477);
  }
  
  @z(Ho=j.a.ON_RESUME)
  public final void onResume()
  {
    AppMethodBeat.i(363472);
    if (!this.AuP)
    {
      this.AuP = true;
      AppMethodBeat.o(363472);
      return;
    }
    o.e(this.AVE);
    AppMethodBeat.o(363472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.FinderFeedSnsAdHandler.lifecycleObserver.1
 * JD-Core Version:    0.7.0.1
 */