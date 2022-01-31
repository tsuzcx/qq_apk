package com.tencent.mm.plugin.appbrand.jsapi.q;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.c;

public final class i
  implements a
{
  public static i hYY;
  private a hYZ;
  
  static
  {
    AppMethodBeat.i(126396);
    hYY = new i();
    AppMethodBeat.o(126396);
  }
  
  public i()
  {
    AppMethodBeat.i(126391);
    this.hYZ = new i.1(this);
    AppMethodBeat.o(126391);
  }
  
  private a aEE()
  {
    AppMethodBeat.i(126392);
    if (e.q(a.class) != null)
    {
      locala = (a)e.q(a.class);
      AppMethodBeat.o(126392);
      return locala;
    }
    a locala = this.hYZ;
    AppMethodBeat.o(126392);
    return locala;
  }
  
  public final boolean a(c paramc, ai paramai)
  {
    AppMethodBeat.i(126395);
    boolean bool = aEE().a(paramc, paramai);
    AppMethodBeat.o(126395);
    return bool;
  }
  
  public final int aEB()
  {
    AppMethodBeat.i(126393);
    int i = aEE().aEB();
    AppMethodBeat.o(126393);
    return i;
  }
  
  public final int aEC()
  {
    AppMethodBeat.i(126394);
    int i = aEE().aEC();
    AppMethodBeat.o(126394);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q.i
 * JD-Core Version:    0.7.0.1
 */