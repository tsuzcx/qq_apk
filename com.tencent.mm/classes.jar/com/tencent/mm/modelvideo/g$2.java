package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.sdk.platformtools.ap.a;

final class g$2
  implements ap.a
{
  g$2(g paramg) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(50696);
    if (this.fWg.doScene(g.o(this.fWg), g.f(this.fWg)) == -1)
    {
      g.a(this.fWg, 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
      g.f(this.fWg).onSceneEnd(3, -1, "doScene failed", this.fWg);
    }
    AppMethodBeat.o(50696);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelvideo.g.2
 * JD-Core Version:    0.7.0.1
 */