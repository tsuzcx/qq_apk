package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.model.a;
import com.tencent.mm.plugin.game.model.a.a;

final class GameInfoViewForeign$1
  implements View.OnClickListener
{
  GameInfoViewForeign$1(GameInfoViewForeign paramGameInfoViewForeign) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(111992);
    int i;
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof String)))
    {
      paramView = (String)paramView.getTag();
      i = com.tencent.mm.plugin.game.f.c.t(GameInfoViewForeign.a(this.nzY), paramView, "game_center_msgcenter");
    }
    for (;;)
    {
      paramView = com.tencent.mm.game.report.c.S("resource", "5");
      com.tencent.mm.game.report.c.a(GameInfoViewForeign.a(this.nzY), 10, 1001, GameInfoViewForeign.b(this.nzY), i, 0, null, GameInfoViewForeign.c(this.nzY), 0, null, null, paramView);
      AppMethodBeat.o(111992);
      return;
      paramView = a.bFO();
      if (paramView.bsY == 2)
      {
        i = com.tencent.mm.plugin.game.f.c.t(GameInfoViewForeign.a(this.nzY), paramView.url, "game_center_msgcenter");
      }
      else
      {
        paramView = new Intent(GameInfoViewForeign.a(this.nzY), GameMessageUI.class);
        paramView.putExtra("game_report_from_scene", 1001);
        GameInfoViewForeign.a(this.nzY).startActivity(paramView);
        i = 6;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameInfoViewForeign.1
 * JD-Core Version:    0.7.0.1
 */