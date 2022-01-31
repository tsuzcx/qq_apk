package com.tencent.mm.plugin.game.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.g.i;

final class GameLibraryUI$6
  implements View.OnClickListener
{
  GameLibraryUI$6(GameLibraryUI paramGameLibraryUI) {}
  
  public final void onClick(View paramView)
  {
    int i = 6;
    if ((paramView.getTag() instanceof String))
    {
      c.a(paramView, this.lcP);
      i = 7;
    }
    for (;;)
    {
      b.a(this.lcP, 11, 1113, 1, i, GameLibraryUI.e(this.lcP), null);
      return;
      paramView = new Intent(this.lcP, GameCategoryUI.class);
      paramView.putExtra("extra_type", 2);
      paramView.putExtra("extra_category_name", this.lcP.getString(g.i.game_library_more_game));
      paramView.putExtra("game_report_from_scene", 1113);
      this.lcP.startActivity(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameLibraryUI.6
 * JD-Core Version:    0.7.0.1
 */