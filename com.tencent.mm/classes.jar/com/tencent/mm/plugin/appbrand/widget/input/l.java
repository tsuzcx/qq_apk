package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.h.b;
import com.tencent.mm.plugin.appbrand.jsapi.h.c;
import com.tencent.mm.plugin.appbrand.page.ad;
import java.lang.ref.WeakReference;

public final class l
  implements h.b, h.c
{
  final WeakReference<ad> rtP;
  
  public l(ad paramad)
  {
    AppMethodBeat.i(136408);
    this.rtP = new WeakReference(paramad);
    paramad.a(this);
    paramad.a(this);
    AppMethodBeat.o(136408);
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(136409);
    ad localad = (ad)this.rtP.get();
    if (localad != null) {
      o.D(localad);
    }
    AppMethodBeat.o(136409);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(136410);
    ad localad = (ad)this.rtP.get();
    if (localad != null)
    {
      if ((localad.getContext() instanceof ah)) {
        ((ah)localad.getContext()).hideVKB();
      }
      o.D(localad);
      o.E(localad);
      e.B(localad);
      localad.b(this);
      localad.b(this);
      if (localad.qoF != null) {
        h.cop().c(localad.qoF);
      }
    }
    AppMethodBeat.o(136410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.l
 * JD-Core Version:    0.7.0.1
 */