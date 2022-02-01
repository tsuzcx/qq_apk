package com.tencent.mm.plugin.appbrand.ui.recents;

import androidx.lifecycle.h.a;
import androidx.lifecycle.k;
import androidx.lifecycle.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.al;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderOrderEntrance$1", "Landroidx/lifecycle/LifecycleObserver;", "onDestroy", "", "plugin-appbrand-integration_release"})
public final class AppBrandLauncherHeaderOrderEntrance$1
  implements k
{
  @t(jl=h.a.ON_DESTROY)
  public final void onDestroy()
  {
    AppMethodBeat.i(275840);
    ak localak = e.a(this.rda);
    if (localak != null) {
      al.a(localak, null);
    }
    e.b(this.rda);
    AppMethodBeat.o(275840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherHeaderOrderEntrance.1
 * JD-Core Version:    0.7.0.1
 */