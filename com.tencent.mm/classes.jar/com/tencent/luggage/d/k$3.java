package com.tencent.luggage.d;

import com.tencent.luggage.bridge.f;
import com.tencent.luggage.bridge.o;
import com.tencent.luggage.d.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class k$3
  implements com.tencent.luggage.d.a.c
{
  k$3(k paramk, c paramc) {}
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(90815);
    if (this.bzp == null)
    {
      com.tencent.luggage.g.d.e("Luggage.LuggageWebCore", "Null Event, Ignore");
      AppMethodBeat.o(90815);
      return;
    }
    if (paramb == b.bzB)
    {
      paramb = this.bzn.byf;
      com.tencent.luggage.bridge.d locald = new com.tencent.luggage.bridge.d(this.bzp.name(), this.bzp.tY());
      paramb.bym.a(locald);
    }
    AppMethodBeat.o(90815);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.d.k.3
 * JD-Core Version:    0.7.0.1
 */