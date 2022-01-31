package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.f.c;

final class GameCenterUI5$3$1
  implements Runnable
{
  GameCenterUI5$3$1(GameCenterUI5.3 param3) {}
  
  public final void run()
  {
    AppMethodBeat.i(111790);
    if (this.nwD.nwz.isFinishing())
    {
      AppMethodBeat.o(111790);
      return;
    }
    GameCenterUI5.a(this.nwD.nwz, c.en(this.nwD.nwz));
    GameCenterUI5.a(this.nwD.nwz).show();
    AppMethodBeat.o(111790);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCenterUI5.3.1
 * JD-Core Version:    0.7.0.1
 */