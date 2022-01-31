package com.tencent.mm.plugin.game.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.ld;
import com.tencent.mm.g.a.ld.a;

final class aw$5
  implements Runnable
{
  aw$5(aw paramaw, Context paramContext, ld paramld) {}
  
  public final void run()
  {
    AppMethodBeat.i(111467);
    d.b(this.gCk, "game", ".luggage.LuggageGameWebViewUI", this.npv.cBn.intent);
    AppMethodBeat.o(111467);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.aw.5
 * JD-Core Version:    0.7.0.1
 */