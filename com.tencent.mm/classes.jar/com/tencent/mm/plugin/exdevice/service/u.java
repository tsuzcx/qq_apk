package com.tencent.mm.plugin.exdevice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.model.c;

public final class u
{
  private static u oZq = null;
  private c oZr;
  private f oZs;
  
  public static void a(m paramm)
  {
    AppMethodBeat.i(23696);
    cai().oTC = paramm;
    AppMethodBeat.o(23696);
  }
  
  private static u cag()
  {
    AppMethodBeat.i(23694);
    if (oZq == null) {
      oZq = new u();
    }
    u localu = oZq;
    AppMethodBeat.o(23694);
    return localu;
  }
  
  public static f cah()
  {
    AppMethodBeat.i(23695);
    if (cag().oZs == null) {
      cag().oZs = new f();
    }
    f localf = cag().oZs;
    AppMethodBeat.o(23695);
    return localf;
  }
  
  public static c cai()
  {
    AppMethodBeat.i(23697);
    if (cag().oZr == null) {
      cag().oZr = c.bZl();
    }
    c localc = cag().oZr;
    AppMethodBeat.o(23697);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.u
 * JD-Core Version:    0.7.0.1
 */