package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.i.b;
import com.tencent.mm.plugin.appbrand.jsapi.i.c;
import com.tencent.mm.plugin.appbrand.page.ad;
import java.lang.ref.WeakReference;

public final class l
  implements i.b, i.c
{
  final WeakReference<ad> uEU;
  
  public l(ad paramad)
  {
    AppMethodBeat.i(136408);
    this.uEU = new WeakReference(paramad);
    paramad.a(this);
    paramad.a(this);
    AppMethodBeat.o(136408);
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(136409);
    ad localad = (ad)this.uEU.get();
    if (localad != null) {
      o.E(localad);
    }
    AppMethodBeat.o(136409);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(136410);
    ad localad = (ad)this.uEU.get();
    if (localad != null)
    {
      if ((localad.getContext() instanceof ah)) {
        ((ah)localad.getContext()).hideVKB();
      }
      o.E(localad);
      o.F(localad);
      e.C(localad);
      localad.b(this);
      localad.b(this);
      if (localad.tti != null) {
        h.cQR().c(localad.tti);
      }
    }
    AppMethodBeat.o(136410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.l
 * JD-Core Version:    0.7.0.1
 */