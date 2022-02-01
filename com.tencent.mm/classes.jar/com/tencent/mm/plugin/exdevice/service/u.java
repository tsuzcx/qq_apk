package com.tencent.mm.plugin.exdevice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.model.c;

public final class u
{
  private static u qgg = null;
  private c qgh;
  private f qgi;
  
  public static void a(m paramm)
  {
    AppMethodBeat.i(23696);
    clV().qas = paramm;
    AppMethodBeat.o(23696);
  }
  
  private static u clT()
  {
    AppMethodBeat.i(23694);
    if (qgg == null) {
      qgg = new u();
    }
    u localu = qgg;
    AppMethodBeat.o(23694);
    return localu;
  }
  
  public static f clU()
  {
    AppMethodBeat.i(23695);
    if (clT().qgi == null) {
      clT().qgi = new f();
    }
    f localf = clT().qgi;
    AppMethodBeat.o(23695);
    return localf;
  }
  
  public static c clV()
  {
    AppMethodBeat.i(23697);
    if (clT().qgh == null) {
      clT().qgh = c.ckY();
    }
    c localc = clT().qgh;
    AppMethodBeat.o(23697);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.u
 * JD-Core Version:    0.7.0.1
 */