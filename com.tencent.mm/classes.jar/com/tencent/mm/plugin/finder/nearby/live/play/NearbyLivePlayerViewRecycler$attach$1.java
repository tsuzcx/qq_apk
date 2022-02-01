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

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/live/play/NearbyLivePlayerViewRecycler$attach$1", "Landroidx/lifecycle/LifecycleObserver;", "onDestroy", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class NearbyLivePlayerViewRecycler$attach$1
  implements p
{
  NearbyLivePlayerViewRecycler$attach$1(g paramg, AppCompatActivity paramAppCompatActivity) {}
  
  @z(Ho=j.a.ON_DESTROY)
  public final void onDestroy()
  {
    AppMethodBeat.i(341027);
    Log.i("NearbyLivePlayerViewRecycler", s.X("onDestroy activityCount:", Integer.valueOf(g.c(this.ELc))));
    g localg = this.ELc;
    g.a(localg, g.c(localg) - 1);
    if (g.c(this.ELc) == 0) {
      this.ELc.release();
    }
    g.d(this.ELc).remove(Integer.valueOf(this.Awh.hashCode()));
    this.Awh.getLifecycle().removeObserver((p)this);
    AppMethodBeat.o(341027);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.play.NearbyLivePlayerViewRecycler.attach.1
 * JD-Core Version:    0.7.0.1
 */