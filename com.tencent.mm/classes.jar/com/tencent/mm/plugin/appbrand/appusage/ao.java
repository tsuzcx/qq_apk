package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.x;
import com.tencent.mm.plugin.appbrand.service.x.a;
import java.util.ArrayList;

public final class ao
  implements x
{
  public final x.a byv()
  {
    AppMethodBeat.i(44663);
    x.a locala = new x.a();
    locala.iHf = new ArrayList(0);
    locala.nMt = -1;
    locala.dQx = "";
    if (!g.aAf().hpY)
    {
      AppMethodBeat.o(44663);
      return locala;
    }
    if (!i.bxK())
    {
      AppMethodBeat.o(44663);
      return locala;
    }
    AppMethodBeat.o(44663);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.ao
 * JD-Core Version:    0.7.0.1
 */