package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.f.c;

final class GameOverSeaCenterUI$2$1
  implements Runnable
{
  GameOverSeaCenterUI$2$1(GameOverSeaCenterUI.2 param2) {}
  
  public final void run()
  {
    AppMethodBeat.i(112126);
    if (this.nCn.nCm.isFinishing())
    {
      AppMethodBeat.o(112126);
      return;
    }
    GameOverSeaCenterUI.a(this.nCn.nCm, c.en(this.nCn.nCm));
    GameOverSeaCenterUI.a(this.nCn.nCm).show();
    AppMethodBeat.o(112126);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameOverSeaCenterUI.2.1
 * JD-Core Version:    0.7.0.1
 */