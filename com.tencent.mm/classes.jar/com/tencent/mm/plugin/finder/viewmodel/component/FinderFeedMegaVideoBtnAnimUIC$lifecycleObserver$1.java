package com.tencent.mm.plugin.finder.viewmodel.component;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.h;
import androidx.lifecycle.h.a;
import androidx.lifecycle.k;
import androidx.lifecycle.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/viewmodel/component/FinderFeedMegaVideoBtnAnimUIC$lifecycleObserver$1", "Landroidx/lifecycle/LifecycleObserver;", "onDestroy", "", "onPause", "onResume", "plugin-finder_release"})
public final class FinderFeedMegaVideoBtnAnimUIC$lifecycleObserver$1
  implements k
{
  @t(jl=h.a.ON_DESTROY)
  public final void onDestroy()
  {
    AppMethodBeat.i(287678);
    s.h(this.BjY).dead();
    this.BjY.getActivity().getLifecycle().b((k)this);
    AppMethodBeat.o(287678);
  }
  
  @t(jl=h.a.ON_PAUSE)
  public final void onPause()
  {
    AppMethodBeat.i(287677);
    s.h(this.BjY).dead();
    s.a(this.BjY, false);
    AppMethodBeat.o(287677);
  }
  
  @t(jl=h.a.ON_RESUME)
  public final void onResume()
  {
    AppMethodBeat.i(287676);
    s.h(this.BjY).alive();
    s.a(this.BjY, true);
    AppMethodBeat.o(287676);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderFeedMegaVideoBtnAnimUIC.lifecycleObserver.1
 * JD-Core Version:    0.7.0.1
 */