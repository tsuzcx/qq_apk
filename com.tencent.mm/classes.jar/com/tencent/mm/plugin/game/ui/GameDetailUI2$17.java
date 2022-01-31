package com.tencent.mm.plugin.game.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class GameDetailUI2$17
  implements View.OnClickListener
{
  GameDetailUI2$17(GameDetailUI2 paramGameDetailUI2) {}
  
  public final void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof String))
    {
      c.a(paramView, this.laq);
      b.a(this.laq.mController.uMN, 12, 1203, 999, 7, GameDetailUI2.f(this.laq), GameDetailUI2.g(this.laq), null);
      return;
    }
    Object localObject = new GameDetailRankUI.a();
    ((GameDetailRankUI.a)localObject).kZr = GameDetailUI2.n(this.laq);
    ((GameDetailRankUI.a)localObject).kZs = GameDetailUI2.o(this.laq);
    ((GameDetailRankUI.a)localObject).kZt = GameDetailUI2.l(this.laq);
    paramView = u.ij("rankData");
    u.Hc().v(paramView, true).h(GameDetailRankUI.kZp, localObject);
    localObject = new Intent(this.laq.mController.uMN, GameDetailRankUI.class);
    ((Intent)localObject).putExtra(GameDetailRankUI.EXTRA_SESSION_ID, paramView);
    this.laq.startActivity((Intent)localObject);
    b.a(this.laq.mController.uMN, 12, 1203, 999, 6, GameDetailUI2.f(this.laq), GameDetailUI2.g(this.laq), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailUI2.17
 * JD-Core Version:    0.7.0.1
 */