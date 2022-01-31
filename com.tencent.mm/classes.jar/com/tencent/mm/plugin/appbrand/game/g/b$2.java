package com.tencent.mm.plugin.appbrand.game.g;

import com.hilive.mediasdk.MediaSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class b$2
  implements Runnable
{
  b$2(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(143215);
    if (b.a(this.hvb) == b.f.hvs)
    {
      ab.i("MicroMsg.GameRecorderMgr", "hy: trigger uninit");
      MediaSdk.getInstance().uint();
      b.h(this.hvb);
      b.a(this.hvb, b.f.hvr);
      AppMethodBeat.o(143215);
      return;
    }
    ab.w("MicroMsg.GameRecorderMgr", "hy: current not idle. abort uninit");
    AppMethodBeat.o(143215);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.g.b.2
 * JD-Core Version:    0.7.0.1
 */