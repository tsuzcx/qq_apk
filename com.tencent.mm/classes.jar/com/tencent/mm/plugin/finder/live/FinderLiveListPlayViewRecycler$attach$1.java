package com.tencent.mm.plugin.finder.live;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.h;
import androidx.lifecycle.h.a;
import androidx.lifecycle.k;
import androidx.lifecycle.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/FinderLiveListPlayViewRecycler$attach$1", "Landroidx/lifecycle/LifecycleObserver;", "onDestroy", "", "plugin-finder_release"})
public final class FinderLiveListPlayViewRecycler$attach$1
  implements k
{
  public FinderLiveListPlayViewRecycler$attach$1(AppCompatActivity paramAppCompatActivity) {}
  
  @t(jl=h.a.ON_DESTROY)
  public final void onDestroy()
  {
    AppMethodBeat.i(289234);
    Log.i("FinderLiveListPlayViewRecycler", "onDestroy activityCount:" + e.a(this.xVb));
    e locale = this.xVb;
    e.a(locale, e.a(locale) - 1);
    if (e.a(this.xVb) == 0) {
      this.xVb.release();
    }
    e.b(this.xVb).remove(Integer.valueOf(this.wYZ.hashCode()));
    this.wYZ.getLifecycle().b((k)this);
    AppMethodBeat.o(289234);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.FinderLiveListPlayViewRecycler.attach.1
 * JD-Core Version:    0.7.0.1
 */