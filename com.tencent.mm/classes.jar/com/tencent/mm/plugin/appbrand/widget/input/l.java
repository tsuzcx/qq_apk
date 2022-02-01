package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.page.aa;
import java.lang.ref.WeakReference;

public final class l
  implements f.b, f.c
{
  final WeakReference<aa> mCq;
  
  public l(aa paramaa)
  {
    AppMethodBeat.i(136408);
    this.mCq = new WeakReference(paramaa);
    paramaa.a(this);
    paramaa.a(this);
    AppMethodBeat.o(136408);
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(136409);
    aa localaa = (aa)this.mCq.get();
    if (localaa != null) {
      o.x(localaa);
    }
    AppMethodBeat.o(136409);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(136410);
    aa localaa = (aa)this.mCq.get();
    if (localaa != null)
    {
      if ((localaa.getContext() instanceof ad)) {
        ((ad)localaa.getContext()).hideVKB();
      }
      o.x(localaa);
      o.y(localaa);
      e.v(localaa);
      localaa.b(this);
      localaa.b(this);
      if (localaa.lyE != null) {
        h.bzW().c(localaa.lyE);
      }
    }
    AppMethodBeat.o(136410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.l
 * JD-Core Version:    0.7.0.1
 */