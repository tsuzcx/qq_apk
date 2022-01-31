package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.game.d.bk;
import com.tencent.mm.plugin.game.model.af;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class GameOverSeaCenterUI$6
  implements Runnable
{
  GameOverSeaCenterUI$6(GameOverSeaCenterUI paramGameOverSeaCenterUI, a parama, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(112134);
    if (this.nwA == null) {
      GameOverSeaCenterUI.a(this.nCm, new bk());
    }
    for (;;)
    {
      al.d(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(112133);
          try
          {
            GameOverSeaCenterUI.a(GameOverSeaCenterUI.6.this.nCm, this.nCo, 2);
            if (GameOverSeaCenterUI.a(GameOverSeaCenterUI.6.this.nCm) != null) {
              GameOverSeaCenterUI.a(GameOverSeaCenterUI.6.this.nCm).dismiss();
            }
            ab.i("MicroMsg.GameOverSeaCenterUI", "Server data parsing time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - GameOverSeaCenterUI.6.this.dZo) });
            AppMethodBeat.o(112133);
            return;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              ab.e("MicroMsg.GameOverSeaCenterUI", "GameOverSeaCenterUI crash, %s", new Object[] { localException.getMessage() });
              GameOverSeaCenterUI.6.this.nCm.finish();
            }
          }
        }
      });
      AppMethodBeat.o(112134);
      return;
      GameOverSeaCenterUI.a(this.nCm, (bk)this.nwA);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameOverSeaCenterUI.6
 * JD-Core Version:    0.7.0.1
 */