package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class GameMessageUI$5
  implements View.OnClickListener
{
  GameMessageUI$5(GameMessageUI paramGameMessageUI) {}
  
  public final void onClick(View paramView)
  {
    if (!bk.bl(GameMessageUI.f(this.lee)))
    {
      int i = c.an(this.lee.mController.uMN, GameMessageUI.f(this.lee));
      b.a(this.lee.mController.uMN, 13, 1302, 1, i, GameMessageUI.g(this.lee), null);
    }
    GameMessageUI.h(this.lee);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameMessageUI.5
 * JD-Core Version:    0.7.0.1
 */