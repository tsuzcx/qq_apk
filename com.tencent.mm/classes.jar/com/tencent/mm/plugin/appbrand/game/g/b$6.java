package com.tencent.mm.plugin.appbrand.game.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class b$6
  implements Runnable
{
  b$6(b paramb, d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(143227);
    if (!b.e(this.hvb))
    {
      ab.w("MicroMsg.GameRecorderMgr", "hy: resume failed: not started");
      this.huQ.a(2, 301, "not start yet!", null);
      AppMethodBeat.o(143227);
      return;
    }
    if (b.a(this.hvb) == b.f.hvt)
    {
      ab.w("MicroMsg.GameRecorderMgr", "hy: resume failed: already running!");
      this.huQ.a(2, 302, "already running!", null);
      AppMethodBeat.o(143227);
      return;
    }
    b.a(this.hvb, b.f.hvt);
    b.d(this.hvb).c(new b.6.1(this));
    AppMethodBeat.o(143227);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.g.b.6
 * JD-Core Version:    0.7.0.1
 */