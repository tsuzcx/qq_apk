package com.tencent.mm.media.g;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.c;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class g$b
  implements Runnable
{
  g$b(g paramg) {}
  
  public final void run()
  {
    AppMethodBeat.i(13042);
    ab.i(g.f(this.eXA), "delay check frameDraw: " + g.o(this.eXA));
    if (!g.o(this.eXA))
    {
      ab.e(g.f(this.eXA), "after " + g.Vc() + " ms, first frame stil not draw!!!");
      c localc = c.eZC;
      c.WE();
    }
    AppMethodBeat.o(13042);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.media.g.g.b
 * JD-Core Version:    0.7.0.1
 */