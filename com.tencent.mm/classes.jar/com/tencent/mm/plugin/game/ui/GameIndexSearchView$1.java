package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.b.a;

final class GameIndexSearchView$1
  implements View.OnClickListener
{
  GameIndexSearchView$1(GameIndexSearchView paramGameIndexSearchView, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    int i;
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof String)))
    {
      paramView = (String)paramView.getTag();
      i = c.o(GameIndexSearchView.a(this.lbX), paramView, "game_center_msgcenter");
    }
    for (;;)
    {
      com.tencent.mm.plugin.game.e.b.a(GameIndexSearchView.a(this.lbX), 14, 1401, 1, i, 0, null, this.kXE, 0, null, null, null);
      return;
      paramView = com.tencent.mm.plugin.game.model.b.aYP();
      if (paramView.bcw == 2)
      {
        i = c.o(GameIndexSearchView.a(this.lbX), paramView.url, "game_center_msgcenter");
      }
      else
      {
        paramView = new Intent(GameIndexSearchView.a(this.lbX), GameSearchUI.class);
        paramView.putExtra("game_report_from_scene", 1001);
        GameIndexSearchView.a(this.lbX).startActivity(paramView);
        i = 6;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameIndexSearchView.1
 * JD-Core Version:    0.7.0.1
 */