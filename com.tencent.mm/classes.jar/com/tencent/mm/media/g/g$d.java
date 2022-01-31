package com.tencent.mm.media.g;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.c;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class g$d
  implements Runnable
{
  g$d(g paramg) {}
  
  public final void run()
  {
    AppMethodBeat.i(152091);
    ab.i(g.f(this.eXA), "decode end after " + g.Vd() + ", isFinishEncode:" + g.K(this.eXA));
    if (!g.K(this.eXA))
    {
      c localc = c.eZC;
      c.WH();
      g.L(this.eXA);
    }
    AppMethodBeat.o(152091);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.g.g.d
 * JD-Core Version:    0.7.0.1
 */