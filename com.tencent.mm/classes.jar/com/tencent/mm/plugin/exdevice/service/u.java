package com.tencent.mm.plugin.exdevice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.model.c;

public final class u
{
  private static u qmL = null;
  private c qmM;
  private f qmN;
  
  public static void a(m paramm)
  {
    AppMethodBeat.i(23696);
    cnl().qgX = paramm;
    AppMethodBeat.o(23696);
  }
  
  private static u cnj()
  {
    AppMethodBeat.i(23694);
    if (qmL == null) {
      qmL = new u();
    }
    u localu = qmL;
    AppMethodBeat.o(23694);
    return localu;
  }
  
  public static f cnk()
  {
    AppMethodBeat.i(23695);
    if (cnj().qmN == null) {
      cnj().qmN = new f();
    }
    f localf = cnj().qmN;
    AppMethodBeat.o(23695);
    return localf;
  }
  
  public static c cnl()
  {
    AppMethodBeat.i(23697);
    if (cnj().qmM == null) {
      cnj().qmM = c.cmo();
    }
    c localc = cnj().qmM;
    AppMethodBeat.o(23697);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.u
 * JD-Core Version:    0.7.0.1
 */