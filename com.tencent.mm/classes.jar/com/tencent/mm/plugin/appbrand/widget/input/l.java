package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.page.v;
import java.lang.ref.WeakReference;

public final class l
  implements f.b, f.c
{
  final WeakReference<v> jkD;
  
  public l(v paramv)
  {
    AppMethodBeat.i(123674);
    this.jkD = new WeakReference(paramv);
    paramv.a(this);
    paramv.a(this);
    AppMethodBeat.o(123674);
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(123675);
    v localv = (v)this.jkD.get();
    if (localv != null) {
      o.q(localv);
    }
    AppMethodBeat.o(123675);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(123676);
    v localv = (v)this.jkD.get();
    if (localv != null)
    {
      if ((localv.getContext() instanceof ad)) {
        ((ad)localv.getContext()).hideVKB();
      }
      o.q(localv);
      o.r(localv);
      e.o(localv);
      localv.b(this);
      localv.b(this);
      if (localv.iuy != null) {
        h.aQF().b(localv.iuy);
      }
    }
    AppMethodBeat.o(123676);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.l
 * JD-Core Version:    0.7.0.1
 */