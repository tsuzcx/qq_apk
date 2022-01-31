package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.model.z;

final class GameDetailUI2$14$1
  implements Runnable
{
  GameDetailUI2$14$1(GameDetailUI2.14 param14, z paramz) {}
  
  public final void run()
  {
    AppMethodBeat.i(111854);
    GameDetailUI2.a(this.nys.nyn, this.nyq);
    if (GameDetailUI2.h(this.nys.nyn) != null) {
      GameDetailUI2.h(this.nys.nyn).dismiss();
    }
    AppMethodBeat.o(111854);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailUI2.14.1
 * JD-Core Version:    0.7.0.1
 */