package com.tencent.mm.plugin.exdevice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.model.c;

public final class u
{
  private static u rDS = null;
  private c rDT;
  private f rDU;
  
  public static void a(m paramm)
  {
    AppMethodBeat.i(23696);
    cLy().rxT = paramm;
    AppMethodBeat.o(23696);
  }
  
  private static u cLw()
  {
    AppMethodBeat.i(23694);
    if (rDS == null) {
      rDS = new u();
    }
    u localu = rDS;
    AppMethodBeat.o(23694);
    return localu;
  }
  
  public static f cLx()
  {
    AppMethodBeat.i(23695);
    if (cLw().rDU == null) {
      cLw().rDU = new f();
    }
    f localf = cLw().rDU;
    AppMethodBeat.o(23695);
    return localf;
  }
  
  public static c cLy()
  {
    AppMethodBeat.i(23697);
    if (cLw().rDT == null) {
      cLw().rDT = c.cKq();
    }
    c localc = cLw().rDT;
    AppMethodBeat.o(23697);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.u
 * JD-Core Version:    0.7.0.1
 */