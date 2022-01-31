package com.tencent.mm.plugin.appbrand.jsapi.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;

final class a$c
  implements f.b, f.d
{
  private a$c(a parama) {}
  
  public final void onBackground()
  {
    AppMethodBeat.i(131648);
    a.a(this.igQ).onBackground();
    AppMethodBeat.o(131648);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(131649);
    a.a(this.igQ).onForeground();
    AppMethodBeat.o(131649);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.a.c
 * JD-Core Version:    0.7.0.1
 */