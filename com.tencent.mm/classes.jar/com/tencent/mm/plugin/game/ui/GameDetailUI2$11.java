package com.tencent.mm.plugin.game.ui;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.plugin.game.g.i;

final class GameDetailUI2$11
  implements View.OnClickListener
{
  GameDetailUI2$11(GameDetailUI2 paramGameDetailUI2) {}
  
  public final void onClick(View paramView)
  {
    if (!GameDetailUI2.d(this.laq))
    {
      GameDetailUI2.b(this.laq).setMaxLines(100);
      GameDetailUI2.c(this.laq).setText(this.laq.getResources().getText(g.i.game_desc_toggle_less));
      GameDetailUI2.a(this.laq, true);
      return;
    }
    GameDetailUI2.b(this.laq).setMaxLines(3);
    GameDetailUI2.c(this.laq).setText(this.laq.getResources().getText(g.i.game_desc_toggle_all));
    GameDetailUI2.a(this.laq, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailUI2.11
 * JD-Core Version:    0.7.0.1
 */