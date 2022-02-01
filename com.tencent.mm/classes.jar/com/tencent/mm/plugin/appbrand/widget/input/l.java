package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.page.z;
import java.lang.ref.WeakReference;

public final class l
  implements f.b, f.c
{
  final WeakReference<z> nhZ;
  
  public l(z paramz)
  {
    AppMethodBeat.i(136408);
    this.nhZ = new WeakReference(paramz);
    paramz.a(this);
    paramz.a(this);
    AppMethodBeat.o(136408);
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(136409);
    z localz = (z)this.nhZ.get();
    if (localz != null) {
      o.y(localz);
    }
    AppMethodBeat.o(136409);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(136410);
    z localz = (z)this.nhZ.get();
    if (localz != null)
    {
      if ((localz.getContext() instanceof ad)) {
        ((ad)localz.getContext()).hideVKB();
      }
      o.y(localz);
      o.z(localz);
      e.w(localz);
      localz.b(this);
      localz.b(this);
      if (localz.mcJ != null) {
        h.bEQ().c(localz.mcJ);
      }
    }
    AppMethodBeat.o(136410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.l
 * JD-Core Version:    0.7.0.1
 */