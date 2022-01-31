package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;

public final class j$2
  implements Runnable
{
  public j$2(j paramj) {}
  
  public final void run()
  {
    AppMethodBeat.i(129548);
    if (!g.RG())
    {
      AppMethodBeat.o(129548);
      return;
    }
    if (i.awZ())
    {
      AppMethodBeat.o(129548);
      return;
    }
    j localj = this.hbe;
    t.axy();
    j.a(localj, 2, 0, 7, 0L, true, null);
    AppMethodBeat.o(129548);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.j.2
 * JD-Core Version:    0.7.0.1
 */