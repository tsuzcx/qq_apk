package com.tencent.mm.plugin.appbrand.menu;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.u;

public final class b
  extends a<ad>
{
  public static boolean f(ad paramad)
  {
    AppMethodBeat.i(47614);
    paramad = paramad.getRuntime().aXy();
    if (((paramad instanceof u)) && (((u)paramad).mfP))
    {
      AppMethodBeat.o(47614);
      return true;
    }
    AppMethodBeat.o(47614);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.b
 * JD-Core Version:    0.7.0.1
 */