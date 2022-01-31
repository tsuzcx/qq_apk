package com.tencent.mm.plugin.appbrand.game.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class b$5
  implements Runnable
{
  b$5(b paramb, d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(143225);
    if (!b.e(this.hvb))
    {
      ab.w("MicroMsg.GameRecorderMgr", "hy: pause failed: not started");
      this.huQ.a(2, 201, "not start yet!", null);
      AppMethodBeat.o(143225);
      return;
    }
    if (b.a(this.hvb) == b.f.hvu)
    {
      ab.w("MicroMsg.GameRecorderMgr", "hy: pause failed: already paused!");
      this.huQ.a(2, 202, "already paused!", null);
      AppMethodBeat.o(143225);
      return;
    }
    b.a(this.hvb, b.f.hvu);
    b.d(this.hvb).b(new b.5.1(this));
    AppMethodBeat.o(143225);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.g.b.5
 * JD-Core Version:    0.7.0.1
 */