package com.tencent.mm.plugin.ball.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.f.c.a;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.Log;

final class d$4
  implements c.a
{
  d$4(d paramd, BallInfo paramBallInfo) {}
  
  public final void ha(boolean paramBoolean)
  {
    AppMethodBeat.i(216988);
    if (paramBoolean)
    {
      d.a(this.oXo, this.oVJ);
      AppMethodBeat.o(216988);
      return;
    }
    Log.w("MicroMsg.FloatBallService", "no float window permission");
    AppMethodBeat.o(216988);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.d.4
 * JD-Core Version:    0.7.0.1
 */