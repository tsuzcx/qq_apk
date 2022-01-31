package com.tencent.mm.plugin.game.ui;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.c;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.ui.base.h;

final class GameDetailUI2$9
  implements q.a
{
  GameDetailUI2$9(GameDetailUI2 paramGameDetailUI2, String paramString) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(111848);
    if (paramBoolean)
    {
      GameDetailUI2.a(this.nyn, this.cat, paramString);
      h.bO(this.nyn, this.nyn.getResources().getString(2131298502));
      c.a(this.nyn.getContext(), 12, 1207, 2, 14, GameDetailUI2.f(this.nyn), GameDetailUI2.g(this.nyn), null);
      AppMethodBeat.o(111848);
      return;
    }
    AppMethodBeat.o(111848);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailUI2.9
 * JD-Core Version:    0.7.0.1
 */