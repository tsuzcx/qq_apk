package com.tencent.mm.plugin.game.ui;

import android.content.res.Resources;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

final class GameDetailUI2$9
  implements q.a
{
  GameDetailUI2$9(GameDetailUI2 paramGameDetailUI2, String paramString) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (paramBoolean)
    {
      GameDetailUI2.a(this.laq, this.byr, paramString);
      h.bC(this.laq, this.laq.getResources().getString(g.i.confirm_dialog_sent));
      b.a(this.laq.mController.uMN, 12, 1207, 2, 14, GameDetailUI2.f(this.laq), GameDetailUI2.g(this.laq), null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailUI2.9
 * JD-Core Version:    0.7.0.1
 */