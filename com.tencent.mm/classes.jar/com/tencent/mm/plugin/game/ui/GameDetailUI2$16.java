package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class GameDetailUI2$16
  implements View.OnClickListener
{
  GameDetailUI2$16(GameDetailUI2 paramGameDetailUI2) {}
  
  public final void onClick(View paramView)
  {
    if (GameDetailUI2.l(this.laq) == null)
    {
      y.e("MicroMsg.GameDetailUI2", "Null appInfo");
      return;
    }
    if (GameDetailUI2.i(this.laq) == null)
    {
      y.e("MicroMsg.GameDetailUI2", "No DownloadInfo found");
      return;
    }
    GameDetailUI2.i(this.laq).dz(this.laq.mController.uMN);
    GameDetailUI2.m(this.laq).a(GameDetailUI2.l(this.laq), GameDetailUI2.i(this.laq));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailUI2.16
 * JD-Core Version:    0.7.0.1
 */