package com.tencent.mm.plugin.exdevice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.model.d;

public final class u
{
  private static u yvA = null;
  private d yvB;
  private f yvC;
  
  public static void a(m paramm)
  {
    AppMethodBeat.i(23696);
    dGE().yps = paramm;
    AppMethodBeat.o(23696);
  }
  
  private static u dGC()
  {
    AppMethodBeat.i(23694);
    if (yvA == null) {
      yvA = new u();
    }
    u localu = yvA;
    AppMethodBeat.o(23694);
    return localu;
  }
  
  public static f dGD()
  {
    AppMethodBeat.i(23695);
    if (dGC().yvC == null) {
      dGC().yvC = new f();
    }
    f localf = dGC().yvC;
    AppMethodBeat.o(23695);
    return localf;
  }
  
  public static d dGE()
  {
    AppMethodBeat.i(23697);
    if (dGC().yvB == null) {
      dGC().yvB = d.dFr();
    }
    d locald = dGC().yvB;
    AppMethodBeat.o(23697);
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.u
 * JD-Core Version:    0.7.0.1
 */