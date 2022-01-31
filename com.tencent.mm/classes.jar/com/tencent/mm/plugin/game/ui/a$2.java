package com.tencent.mm.plugin.game.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap.a;

final class a$2
  implements ap.a
{
  a$2(a parama) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(111696);
    this.nuL.notifyDataSetChanged();
    AppMethodBeat.o(111696);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.a.2
 * JD-Core Version:    0.7.0.1
 */