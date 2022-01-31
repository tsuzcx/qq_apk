package com.tencent.mm.plugin.appbrand.page;

import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.a.a.a;
import com.tencent.mm.plugin.appbrand.config.a.a.b;

final class at$4
  implements a.a
{
  at$4(at paramat) {}
  
  public final void a(a.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(140877);
    d.i("Luggage.MPPageViewOrientationExtensionImpl", "resetPageOrientation, onOrientationChanged, appId[%s] url[%s] orientation[%s] success[%b]", new Object[] { at.e(this.izc), at.f(this.izc), paramb, Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(140877);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.at.4
 * JD-Core Version:    0.7.0.1
 */