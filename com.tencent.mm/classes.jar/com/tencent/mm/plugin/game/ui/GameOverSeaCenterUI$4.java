package com.tencent.mm.plugin.game.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.model.a;
import com.tencent.mm.plugin.game.model.a.a;
import com.tencent.mm.sdk.platformtools.bo;

final class GameOverSeaCenterUI$4
  implements View.OnClickListener
{
  GameOverSeaCenterUI$4(GameOverSeaCenterUI paramGameOverSeaCenterUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(112131);
    a.a locala = a.bFN();
    int i;
    if (locala.bsY == 2) {
      i = com.tencent.mm.plugin.game.f.c.t(this.nCm.getContext(), locala.url, "game_center_library");
    }
    for (;;)
    {
      com.tencent.mm.game.report.c.a(this.nCm.getContext(), 10, 1005, 1, i, this.nCm.nok, null);
      AppMethodBeat.o(112131);
      return;
      paramView = paramView.getTag();
      if ((paramView != null) && ((paramView instanceof String)) && (!bo.isNullOrNil((String)paramView)))
      {
        paramView = (String)paramView;
        i = com.tencent.mm.plugin.game.f.c.t(this.nCm.getContext(), paramView, "game_center_library");
      }
      else
      {
        paramView = new Intent(this.nCm.getContext(), GameLibraryUI.class);
        paramView.putExtra("game_report_from_scene", 1005);
        this.nCm.startActivity(paramView);
        i = 6;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameOverSeaCenterUI.4
 * JD-Core Version:    0.7.0.1
 */