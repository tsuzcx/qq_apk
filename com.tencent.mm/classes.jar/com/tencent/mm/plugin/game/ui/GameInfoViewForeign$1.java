package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.b.a;

final class GameInfoViewForeign$1
  implements View.OnClickListener
{
  GameInfoViewForeign$1(GameInfoViewForeign paramGameInfoViewForeign) {}
  
  public final void onClick(View paramView)
  {
    int i;
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof String)))
    {
      paramView = (String)paramView.getTag();
      i = c.o(GameInfoViewForeign.a(this.lcd), paramView, "game_center_msgcenter");
    }
    for (;;)
    {
      paramView = com.tencent.mm.plugin.game.e.b.dq("resource", "5");
      com.tencent.mm.plugin.game.e.b.a(GameInfoViewForeign.a(this.lcd), 10, 1001, GameInfoViewForeign.b(this.lcd), i, 0, null, GameInfoViewForeign.c(this.lcd), 0, null, null, paramView);
      return;
      paramView = com.tencent.mm.plugin.game.model.b.aYP();
      if (paramView.bcw == 2)
      {
        i = c.o(GameInfoViewForeign.a(this.lcd), paramView.url, "game_center_msgcenter");
      }
      else
      {
        paramView = new Intent(GameInfoViewForeign.a(this.lcd), GameMessageUI.class);
        paramView.putExtra("game_report_from_scene", 1001);
        GameInfoViewForeign.a(this.lcd).startActivity(paramView);
        i = 6;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameInfoViewForeign.1
 * JD-Core Version:    0.7.0.1
 */