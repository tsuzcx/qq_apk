package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.sdk.platformtools.ab;

final class GameDetailUI2$16
  implements View.OnClickListener
{
  GameDetailUI2$16(GameDetailUI2 paramGameDetailUI2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(111857);
    if (GameDetailUI2.l(this.nyn) == null)
    {
      ab.e("MicroMsg.GameDetailUI2", "Null appInfo");
      AppMethodBeat.o(111857);
      return;
    }
    if (GameDetailUI2.i(this.nyn) == null)
    {
      ab.e("MicroMsg.GameDetailUI2", "No DownloadInfo found");
      AppMethodBeat.o(111857);
      return;
    }
    GameDetailUI2.i(this.nyn).em(this.nyn.getContext());
    GameDetailUI2.m(this.nyn).a(GameDetailUI2.l(this.nyn), GameDetailUI2.i(this.nyn));
    AppMethodBeat.o(111857);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailUI2.16
 * JD-Core Version:    0.7.0.1
 */