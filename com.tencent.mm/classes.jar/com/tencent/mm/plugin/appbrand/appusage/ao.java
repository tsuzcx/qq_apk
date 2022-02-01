package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.s;
import com.tencent.mm.plugin.appbrand.service.s.a;
import java.util.ArrayList;

public final class ao
  implements s
{
  public final s.a bcB()
  {
    AppMethodBeat.i(44663);
    s.a locala = new s.a();
    locala.hJj = new ArrayList(0);
    locala.mws = -1;
    locala.dxD = "";
    if (!g.ajA().gAD)
    {
      AppMethodBeat.o(44663);
      return locala;
    }
    if (!i.bbR())
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