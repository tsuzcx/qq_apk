package com.tencent.mm.plugin.game.ui;

import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class GameInstalledView$1$1
  implements Runnable
{
  GameInstalledView$1$1(GameInstalledView.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(111996);
    if (GameInstalledView.a(this.nAo.nAn) == 0)
    {
      GameInstalledView.b(this.nAo.nAn);
      GameInstalledView.c(this.nAo.nAn).addView(this.nAo.val$view, this.nAo.nAn.nAm);
    }
    AppMethodBeat.o(111996);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameInstalledView.1.1
 * JD-Core Version:    0.7.0.1
 */