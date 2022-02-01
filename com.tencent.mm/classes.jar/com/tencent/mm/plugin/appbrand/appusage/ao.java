package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.service.r.a;
import java.util.ArrayList;

public final class ao
  implements r
{
  public final r.a aZd()
  {
    AppMethodBeat.i(44663);
    r.a locala = new r.a();
    locala.hqR = new ArrayList(0);
    locala.lWD = -1;
    locala.dlQ = "";
    if (!g.agP().ggT)
    {
      AppMethodBeat.o(44663);
      return locala;
    }
    if (!i.aYt())
    {
      AppMethodBeat.o(44663);
      return locala;
    }
    AppMethodBeat.o(44663);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.ao
 * JD-Core Version:    0.7.0.1
 */