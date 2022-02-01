package com.tencent.mm.plugin.exdevice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.model.c;

public final class u
{
  private static u pCB = null;
  private c pCC;
  private f pCD;
  
  public static void a(m paramm)
  {
    AppMethodBeat.i(23696);
    chr().pwN = paramm;
    AppMethodBeat.o(23696);
  }
  
  private static u chp()
  {
    AppMethodBeat.i(23694);
    if (pCB == null) {
      pCB = new u();
    }
    u localu = pCB;
    AppMethodBeat.o(23694);
    return localu;
  }
  
  public static f chq()
  {
    AppMethodBeat.i(23695);
    if (chp().pCD == null) {
      chp().pCD = new f();
    }
    f localf = chp().pCD;
    AppMethodBeat.o(23695);
    return localf;
  }
  
  public static c chr()
  {
    AppMethodBeat.i(23697);
    if (chp().pCC == null) {
      chp().pCC = c.cgu();
    }
    c localc = chp().pCC;
    AppMethodBeat.o(23697);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.u
 * JD-Core Version:    0.7.0.1
 */