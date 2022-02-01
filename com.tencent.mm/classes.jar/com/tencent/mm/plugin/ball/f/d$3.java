package com.tencent.mm.plugin.ball.f;

import androidx.j.a.b;
import androidx.j.a.b.c;
import androidx.j.a.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class d$3
  implements b.c
{
  d$3(d.a parama) {}
  
  public final void onGenerated(b paramb)
  {
    AppMethodBeat.i(288269);
    if (paramb != null)
    {
      paramb = paramb.bTd;
      if (paramb != null)
      {
        this.vlZ.onGetColor(paramb.bTp);
        AppMethodBeat.o(288269);
        return;
      }
      Log.i("MicroMsg.FloatBallUtil", "getPrimaryColor, palette generated but swatch is null");
      this.vlZ.onGetColor(this.vma);
      AppMethodBeat.o(288269);
      return;
    }
    Log.i("MicroMsg.FloatBallUtil", "getPrimaryColor, palette generated fail");
    this.vlZ.onGetColor(this.vma);
    AppMethodBeat.o(288269);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.f.d.3
 * JD-Core Version:    0.7.0.1
 */