package com.tencent.mm.plugin.game.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class GameOverSeaCenterUI$4
  implements View.OnClickListener
{
  GameOverSeaCenterUI$4(GameOverSeaCenterUI paramGameOverSeaCenterUI) {}
  
  public final void onClick(View paramView)
  {
    b.a locala = com.tencent.mm.plugin.game.model.b.aYO();
    int i;
    if (locala.bcw == 2) {
      i = c.o(this.ler.mController.uMN, locala.url, "game_center_library");
    }
    for (;;)
    {
      com.tencent.mm.plugin.game.e.b.a(this.ler.mController.uMN, 10, 1005, 1, i, this.ler.kQh, null);
      return;
      paramView = paramView.getTag();
      if ((paramView != null) && ((paramView instanceof String)) && (!bk.bl((String)paramView)))
      {
        paramView = (String)paramView;
        i = c.o(this.ler.mController.uMN, paramView, "game_center_library");
      }
      else
      {
        paramView = new Intent(this.ler.mController.uMN, GameLibraryUI.class);
        paramView.putExtra("game_report_from_scene", 1005);
        this.ler.startActivity(paramView);
        i = 6;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameOverSeaCenterUI.4
 * JD-Core Version:    0.7.0.1
 */