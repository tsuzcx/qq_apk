package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap.a;

final class d$1
  implements ap.a
{
  d$1(d paramd) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(111712);
    if (d.a(this.nvh) != null) {
      d.a(this.nvh).cancel();
    }
    AppMethodBeat.o(111712);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.d.1
 * JD-Core Version:    0.7.0.1
 */