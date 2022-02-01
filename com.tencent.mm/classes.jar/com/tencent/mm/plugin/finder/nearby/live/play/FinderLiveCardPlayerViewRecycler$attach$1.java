package com.tencent.mm.plugin.finder.nearby.live.play;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.j;
import androidx.lifecycle.j.a;
import androidx.lifecycle.p;
import androidx.lifecycle.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/live/play/FinderLiveCardPlayerViewRecycler$attach$1", "Landroidx/lifecycle/LifecycleObserver;", "onDestroy", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveCardPlayerViewRecycler$attach$1
  implements p
{
  FinderLiveCardPlayerViewRecycler$attach$1(b paramb, AppCompatActivity paramAppCompatActivity) {}
  
  @z(Ho=j.a.ON_DESTROY)
  public final void onDestroy()
  {
    AppMethodBeat.i(341008);
    Log.i("FinderLiveCardPlayerViewRecycler", s.X("onDestroy activityCount:", Integer.valueOf(b.c(this.EKh))));
    b localb = this.EKh;
    b.a(localb, b.c(localb) - 1);
    if (b.c(this.EKh) == 0) {
      this.EKh.release();
    }
    b.d(this.EKh).remove(Integer.valueOf(this.Awh.hashCode()));
    this.Awh.getLifecycle().removeObserver((p)this);
    AppMethodBeat.o(341008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.play.FinderLiveCardPlayerViewRecycler.attach.1
 * JD-Core Version:    0.7.0.1
 */