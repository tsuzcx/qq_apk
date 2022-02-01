package com.tencent.mm.plugin.finder.viewmodel.component;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.j;
import androidx.lifecycle.j.a;
import androidx.lifecycle.p;
import androidx.lifecycle.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderFeedMegaVideoBtnAnimUIC$lifecycleObserver$1", "Landroidx/lifecycle/LifecycleObserver;", "onDestroy", "", "onPause", "onResume", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderFeedMegaVideoBtnAnimUIC$lifecycleObserver$1
  implements p
{
  FinderFeedMegaVideoBtnAnimUIC$lifecycleObserver$1(t paramt) {}
  
  @z(Ho=j.a.ON_DESTROY)
  public final void onDestroy()
  {
    AppMethodBeat.i(337655);
    t.g(this.GPw).dead();
    this.GPw.getActivity().getLifecycle().removeObserver((p)this);
    AppMethodBeat.o(337655);
  }
  
  @z(Ho=j.a.ON_PAUSE)
  public final void onPause()
  {
    AppMethodBeat.i(337649);
    t.g(this.GPw).dead();
    t.a(this.GPw, false);
    AppMethodBeat.o(337649);
  }
  
  @z(Ho=j.a.ON_RESUME)
  public final void onResume()
  {
    AppMethodBeat.i(337637);
    t.g(this.GPw).alive();
    t.a(this.GPw, true);
    AppMethodBeat.o(337637);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderFeedMegaVideoBtnAnimUIC.lifecycleObserver.1
 * JD-Core Version:    0.7.0.1
 */