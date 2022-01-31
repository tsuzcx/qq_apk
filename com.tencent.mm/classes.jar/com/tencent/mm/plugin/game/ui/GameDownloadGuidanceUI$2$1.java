package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.f.c;

final class GameDownloadGuidanceUI$2$1
  implements Runnable
{
  GameDownloadGuidanceUI$2$1(GameDownloadGuidanceUI.2 param2) {}
  
  public final void run()
  {
    AppMethodBeat.i(111880);
    if (this.nyz.nyy.isFinishing())
    {
      AppMethodBeat.o(111880);
      return;
    }
    GameDownloadGuidanceUI.a(this.nyz.nyy, c.en(this.nyz.nyy));
    GameDownloadGuidanceUI.a(this.nyz.nyy).show();
    AppMethodBeat.o(111880);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDownloadGuidanceUI.2.1
 * JD-Core Version:    0.7.0.1
 */