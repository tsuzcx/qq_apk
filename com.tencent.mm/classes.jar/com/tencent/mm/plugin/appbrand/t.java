package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeSuspendingWatchDog;", "", "()V", "TAG", "", "watch", "", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "IDKEY", "SystemLowMemoryListenerImpl", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t
{
  public static final t quN;
  
  static
  {
    AppMethodBeat.i(316637);
    quN = new t();
    AppMethodBeat.o(316637);
  }
  
  public static final void g(w paramw)
  {
    AppMethodBeat.i(316631);
    s.u(paramw, "rt");
    new AppBrandRuntimeSuspendingWatchDog.watch.1(paramw, f.hfK).alive();
    AppMethodBeat.o(316631);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t
 * JD-Core Version:    0.7.0.1
 */