package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.appbrand.service.t.a;
import java.util.ArrayList;

public final class ao
  implements t
{
  public final t.a bdg()
  {
    AppMethodBeat.i(44663);
    t.a locala = new t.a();
    locala.hMc = new ArrayList(0);
    locala.mBp = -1;
    locala.dyI = "";
    if (!g.ajP().gDk)
    {
      AppMethodBeat.o(44663);
      return locala;
    }
    if (!i.bcv())
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