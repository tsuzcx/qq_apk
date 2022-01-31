package com.tencent.luggage.d;

import com.tencent.luggage.d.a.b;
import com.tencent.luggage.d.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class k$2
  implements c
{
  k$2(k paramk, a parama, com.tencent.luggage.bridge.k paramk1) {}
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(90814);
    if (paramb == b.bzB)
    {
      paramb = this.bzm;
      a locala = this.bzm;
      com.tencent.luggage.bridge.k localk = this.bzo;
      a.a locala1 = new a.a(locala);
      locala1.byE = locala.byD;
      locala1.byF = localk;
      paramb.a(locala1);
      AppMethodBeat.o(90814);
      return;
    }
    this.bzo.a("system:access_denied", null);
    AppMethodBeat.o(90814);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.d.k.2
 * JD-Core Version:    0.7.0.1
 */