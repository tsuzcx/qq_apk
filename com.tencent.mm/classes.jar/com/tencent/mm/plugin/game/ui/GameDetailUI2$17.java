package com.tencent.mm.plugin.game.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;

final class GameDetailUI2$17
  implements View.OnClickListener
{
  GameDetailUI2$17(GameDetailUI2 paramGameDetailUI2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(111858);
    if ((paramView.getTag() instanceof String))
    {
      com.tencent.mm.plugin.game.f.c.a(paramView, this.nyn);
      com.tencent.mm.game.report.c.a(this.nyn.getContext(), 12, 1203, 999, 7, GameDetailUI2.f(this.nyn), GameDetailUI2.g(this.nyn), null);
      AppMethodBeat.o(111858);
      return;
    }
    Object localObject = new GameDetailRankUI.a();
    ((GameDetailRankUI.a)localObject).nxo = GameDetailUI2.n(this.nyn);
    ((GameDetailRankUI.a)localObject).nxp = GameDetailUI2.o(this.nyn);
    ((GameDetailRankUI.a)localObject).nxq = GameDetailUI2.l(this.nyn);
    paramView = v.oQ("rankData");
    v.aae().z(paramView, true).i(GameDetailRankUI.nxm, localObject);
    localObject = new Intent(this.nyn.getContext(), GameDetailRankUI.class);
    ((Intent)localObject).putExtra(GameDetailRankUI.EXTRA_SESSION_ID, paramView);
    this.nyn.startActivity((Intent)localObject);
    com.tencent.mm.game.report.c.a(this.nyn.getContext(), 12, 1203, 999, 6, GameDetailUI2.f(this.nyn), GameDetailUI2.g(this.nyn), null);
    AppMethodBeat.o(111858);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailUI2.17
 * JD-Core Version:    0.7.0.1
 */