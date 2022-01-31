package com.tencent.mm.plugin.game.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class GameLibraryUI$6
  implements View.OnClickListener
{
  GameLibraryUI$6(GameLibraryUI paramGameLibraryUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(112036);
    int i = 6;
    if ((paramView.getTag() instanceof String))
    {
      com.tencent.mm.plugin.game.f.c.a(paramView, this.nAK);
      i = 7;
    }
    for (;;)
    {
      com.tencent.mm.game.report.c.a(this.nAK, 11, 1113, 1, i, GameLibraryUI.e(this.nAK), null);
      AppMethodBeat.o(112036);
      return;
      paramView = new Intent(this.nAK, GameCategoryUI.class);
      paramView.putExtra("extra_type", 2);
      paramView.putExtra("extra_category_name", this.nAK.getString(2131300389));
      paramView.putExtra("game_report_from_scene", 1113);
      this.nAK.startActivity(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameLibraryUI.6
 * JD-Core Version:    0.7.0.1
 */