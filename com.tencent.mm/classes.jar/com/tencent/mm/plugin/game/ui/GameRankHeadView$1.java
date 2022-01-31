package com.tencent.mm.plugin.game.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.model.j.a;
import com.tencent.mm.plugin.game.model.k;

final class GameRankHeadView$1
  implements j.a
{
  GameRankHeadView$1(GameRankHeadView paramGameRankHeadView) {}
  
  public final void f(int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(112144);
    if (GameRankHeadView.a(this.nCt) != null)
    {
      GameRankHeadView.b(this.nCt).em(this.nCt.getContext());
      GameRankHeadView.b(this.nCt).bjZ();
      if (paramBoolean) {
        GameRankHeadView.c(this.nCt);
      }
    }
    AppMethodBeat.o(112144);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameRankHeadView.1
 * JD-Core Version:    0.7.0.1
 */