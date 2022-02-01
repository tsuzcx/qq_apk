package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.plugin.appbrand.service.z.a;
import java.util.ArrayList;

public final class an
  implements z
{
  public final z.a cjm()
  {
    AppMethodBeat.i(44663);
    z.a locala = new z.a();
    locala.bMQ = new ArrayList(0);
    locala.tTz = -1;
    locala.wording = "";
    if (!com.tencent.mm.kernel.h.baC().mBZ)
    {
      AppMethodBeat.o(44663);
      return locala;
    }
    if (!h.ciD())
    {
      AppMethodBeat.o(44663);
      return locala;
    }
    AppMethodBeat.o(44663);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.an
 * JD-Core Version:    0.7.0.1
 */