package com.tencent.mm.plugin.appbrand.ui.recents;

import androidx.lifecycle.j.a;
import androidx.lifecycle.p;
import androidx.lifecycle.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderOrderEntrance$1", "Landroidx/lifecycle/LifecycleObserver;", "onDestroy", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AppBrandLauncherHeaderOrderEntrance$1
  implements p
{
  AppBrandLauncherHeaderOrderEntrance$1(d paramd) {}
  
  @z(Ho=j.a.ON_DESTROY)
  public final void onDestroy()
  {
    AppMethodBeat.i(323103);
    aq localaq = d.a(this.ulk);
    if (localaq != null) {
      ar.a(localaq, null);
    }
    d.b(this.ulk);
    AppMethodBeat.o(323103);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherHeaderOrderEntrance.1
 * JD-Core Version:    0.7.0.1
 */