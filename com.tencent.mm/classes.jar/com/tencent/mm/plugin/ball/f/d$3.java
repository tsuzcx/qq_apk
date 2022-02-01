package com.tencent.mm.plugin.ball.f;

import android.support.v7.d.b;
import android.support.v7.d.b.c;
import android.support.v7.d.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class d$3
  implements b.c
{
  d$3(d.a parama) {}
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(106337);
    if (paramb != null)
    {
      paramb = paramb.abf;
      if (paramb != null)
      {
        this.nIi.ye(paramb.abs);
        AppMethodBeat.o(106337);
        return;
      }
      ad.i("MicroMsg.FloatBallUtil", "getPrimaryColor, palette generated but swatch is null");
      this.nIi.ye(this.nIj);
      AppMethodBeat.o(106337);
      return;
    }
    ad.i("MicroMsg.FloatBallUtil", "getPrimaryColor, palette generated fail");
    this.nIi.ye(this.nIj);
    AppMethodBeat.o(106337);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.f.d.3
 * JD-Core Version:    0.7.0.1
 */