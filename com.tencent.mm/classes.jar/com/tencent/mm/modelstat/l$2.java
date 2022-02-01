package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.aa;

final class l$2
  implements Runnable
{
  l$2(l paraml, int paramInt, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(151088);
    switch (this.hXi)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(151088);
      return;
      aa.a(g.agR().ghC + this.hXj, u.axw(), false, true);
      AppMethodBeat.o(151088);
      return;
      aa.a(g.agR().cachePath + this.hXj, u.axw(), false, true);
      AppMethodBeat.o(151088);
      return;
      aa.a(this.hXj, u.axw(), false, true);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(151089);
    String str = super.toString() + "|onPreAddMessage";
    AppMethodBeat.o(151089);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelstat.l.2
 * JD-Core Version:    0.7.0.1
 */