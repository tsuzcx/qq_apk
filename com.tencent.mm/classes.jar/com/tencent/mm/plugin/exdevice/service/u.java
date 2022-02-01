package com.tencent.mm.plugin.exdevice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.model.c;

public final class u
{
  private static u vjC = null;
  private c vjD;
  private f vjE;
  
  public static void a(m paramm)
  {
    AppMethodBeat.i(23696);
    dal().vdz = paramm;
    AppMethodBeat.o(23696);
  }
  
  private static u daj()
  {
    AppMethodBeat.i(23694);
    if (vjC == null) {
      vjC = new u();
    }
    u localu = vjC;
    AppMethodBeat.o(23694);
    return localu;
  }
  
  public static f dak()
  {
    AppMethodBeat.i(23695);
    if (daj().vjE == null) {
      daj().vjE = new f();
    }
    f localf = daj().vjE;
    AppMethodBeat.o(23695);
    return localf;
  }
  
  public static c dal()
  {
    AppMethodBeat.i(23697);
    if (daj().vjD == null) {
      daj().vjD = c.cZa();
    }
    c localc = daj().vjD;
    AppMethodBeat.o(23697);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.u
 * JD-Core Version:    0.7.0.1
 */