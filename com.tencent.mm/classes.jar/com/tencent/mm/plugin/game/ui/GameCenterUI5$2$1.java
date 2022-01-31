package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.model.ac;
import com.tencent.mm.sdk.platformtools.ab;

final class GameCenterUI5$2$1
  implements Runnable
{
  GameCenterUI5$2$1(GameCenterUI5.2 param2, ac paramac) {}
  
  public final void run()
  {
    AppMethodBeat.i(111788);
    try
    {
      GameCenterUI5.a(this.nwC.nwz, this.nwB, 2);
      if (GameCenterUI5.a(this.nwC.nwz) != null) {
        GameCenterUI5.a(this.nwC.nwz).dismiss();
      }
      ab.i("MicroMsg.GameCenterUI5", "Server data parsing time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - this.nwC.dZo) });
      AppMethodBeat.o(111788);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.GameCenterUI5", "GameCenter crash, %s", new Object[] { localException.getMessage() });
        this.nwC.nwz.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCenterUI5.2.1
 * JD-Core Version:    0.7.0.1
 */