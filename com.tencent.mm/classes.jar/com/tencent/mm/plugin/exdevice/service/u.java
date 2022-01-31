package com.tencent.mm.plugin.exdevice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.model.c;

public final class u
{
  private static u lIF = null;
  private c lIG;
  private f lIH;
  
  public static void a(m paramm)
  {
    AppMethodBeat.i(19628);
    bqA().lCQ = paramm;
    AppMethodBeat.o(19628);
  }
  
  public static c bqA()
  {
    AppMethodBeat.i(19629);
    if (bqy().lIG == null) {
      bqy().lIG = c.bpE();
    }
    c localc = bqy().lIG;
    AppMethodBeat.o(19629);
    return localc;
  }
  
  private static u bqy()
  {
    AppMethodBeat.i(19626);
    if (lIF == null) {
      lIF = new u();
    }
    u localu = lIF;
    AppMethodBeat.o(19626);
    return localu;
  }
  
  public static f bqz()
  {
    AppMethodBeat.i(19627);
    if (bqy().lIH == null) {
      bqy().lIH = new f();
    }
    f localf = bqy().lIH;
    AppMethodBeat.o(19627);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.u
 * JD-Core Version:    0.7.0.1
 */