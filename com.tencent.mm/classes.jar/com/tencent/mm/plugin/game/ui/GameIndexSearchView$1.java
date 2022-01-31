package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.model.a;
import com.tencent.mm.plugin.game.model.a.a;

final class GameIndexSearchView$1
  implements View.OnClickListener
{
  GameIndexSearchView$1(GameIndexSearchView paramGameIndexSearchView, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(111986);
    int i;
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof String)))
    {
      paramView = (String)paramView.getTag();
      i = com.tencent.mm.plugin.game.f.c.t(GameIndexSearchView.a(this.nzS), paramView, "game_center_msgcenter");
    }
    for (;;)
    {
      com.tencent.mm.game.report.c.a(GameIndexSearchView.a(this.nzS), 14, 1401, 1, i, 0, null, this.nvG, 0, null, null, null);
      AppMethodBeat.o(111986);
      return;
      paramView = a.bFO();
      if (paramView.bsY == 2)
      {
        i = com.tencent.mm.plugin.game.f.c.t(GameIndexSearchView.a(this.nzS), paramView.url, "game_center_msgcenter");
      }
      else
      {
        paramView = new Intent(GameIndexSearchView.a(this.nzS), GameSearchUI.class);
        paramView.putExtra("game_report_from_scene", 1001);
        GameIndexSearchView.a(this.nzS).startActivity(paramView);
        i = 6;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameIndexSearchView.1
 * JD-Core Version:    0.7.0.1
 */