package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.i.b;
import com.tencent.mm.plugin.appbrand.jsapi.i.c;
import com.tencent.mm.plugin.appbrand.page.ac;
import java.lang.ref.WeakReference;

public final class l
  implements i.b, i.c
{
  final WeakReference<ac> orG;
  
  public l(ac paramac)
  {
    AppMethodBeat.i(136408);
    this.orG = new WeakReference(paramac);
    paramac.a(this);
    paramac.a(this);
    AppMethodBeat.o(136408);
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(136409);
    ac localac = (ac)this.orG.get();
    if (localac != null) {
      o.D(localac);
    }
    AppMethodBeat.o(136409);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(136410);
    ac localac = (ac)this.orG.get();
    if (localac != null)
    {
      if ((localac.getContext() instanceof ad)) {
        ((ad)localac.getContext()).hideVKB();
      }
      o.D(localac);
      o.E(localac);
      e.B(localac);
      localac.b(this);
      localac.b(this);
      if (localac.nmX != null) {
        h.cbe().c(localac.nmX);
      }
    }
    AppMethodBeat.o(136410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.l
 * JD-Core Version:    0.7.0.1
 */