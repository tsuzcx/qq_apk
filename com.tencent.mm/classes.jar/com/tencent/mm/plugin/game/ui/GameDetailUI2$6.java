package com.tencent.mm.plugin.game.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.model.j.a;
import com.tencent.mm.plugin.game.model.k;

final class GameDetailUI2$6
  implements j.a
{
  GameDetailUI2$6(GameDetailUI2 paramGameDetailUI2) {}
  
  public final void f(int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(111845);
    if (GameDetailUI2.l(this.nyn) != null)
    {
      GameDetailUI2.i(this.nyn).em(this.nyn);
      GameDetailUI2.i(this.nyn).bjZ();
      if (paramBoolean) {
        GameDetailUI2.m(this.nyn).a(GameDetailUI2.j(this.nyn), GameDetailUI2.k(this.nyn), GameDetailUI2.l(this.nyn), GameDetailUI2.i(this.nyn));
      }
    }
    AppMethodBeat.o(111845);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailUI2.6
 * JD-Core Version:    0.7.0.1
 */