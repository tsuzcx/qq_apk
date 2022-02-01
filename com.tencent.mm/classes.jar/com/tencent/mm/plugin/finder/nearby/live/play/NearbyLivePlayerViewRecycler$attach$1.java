package com.tencent.mm.plugin.finder.nearby.live.play;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.h;
import androidx.lifecycle.h.a;
import androidx.lifecycle.k;
import androidx.lifecycle.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/nearby/live/play/NearbyLivePlayerViewRecycler$attach$1", "Landroidx/lifecycle/LifecycleObserver;", "onDestroy", "", "plugin-finder-nearby_release"})
public final class NearbyLivePlayerViewRecycler$attach$1
  implements k
{
  NearbyLivePlayerViewRecycler$attach$1(AppCompatActivity paramAppCompatActivity) {}
  
  @t(jl=h.a.ON_DESTROY)
  public final void onDestroy()
  {
    AppMethodBeat.i(200548);
    Log.i("NearbyLivePlayerViewRecycler", "onDestroy activityCount:" + f.a(this.zFI));
    f localf = this.zFI;
    f.a(localf, f.a(localf) - 1);
    if (f.a(this.zFI) == 0) {
      this.zFI.release();
    }
    f.b(this.zFI).remove(Integer.valueOf(this.wYZ.hashCode()));
    this.wYZ.getLifecycle().b((k)this);
    AppMethodBeat.o(200548);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.play.NearbyLivePlayerViewRecycler.attach.1
 * JD-Core Version:    0.7.0.1
 */