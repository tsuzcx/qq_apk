package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.service.x;
import com.tencent.mm.plugin.appbrand.service.x.a;
import java.util.ArrayList;

public final class ao
  implements x
{
  public final x.a bJJ()
  {
    AppMethodBeat.i(44663);
    x.a locala = new x.a();
    locala.lxh = new ArrayList(0);
    locala.qOL = -1;
    locala.wording = "";
    if (!h.aHE().kbT)
    {
      AppMethodBeat.o(44663);
      return locala;
    }
    if (!i.bIZ())
    {
      AppMethodBeat.o(44663);
      return locala;
    }
    AppMethodBeat.o(44663);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.ao
 * JD-Core Version:    0.7.0.1
 */