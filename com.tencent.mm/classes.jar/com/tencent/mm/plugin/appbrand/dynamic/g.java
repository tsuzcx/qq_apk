package com.tencent.mm.plugin.appbrand.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.ah;

public final class g
{
  private static n.a hnA;
  
  static
  {
    AppMethodBeat.i(10696);
    hnA = new g.1();
    AppMethodBeat.o(10696);
  }
  
  public static void initialize()
  {
    AppMethodBeat.i(10694);
    if (!ah.brt())
    {
      AppMethodBeat.o(10694);
      return;
    }
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().a(hnA);
    AppMethodBeat.o(10694);
  }
  
  public static void release()
  {
    AppMethodBeat.i(10695);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().b(hnA);
    AppMethodBeat.o(10695);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.g
 * JD-Core Version:    0.7.0.1
 */