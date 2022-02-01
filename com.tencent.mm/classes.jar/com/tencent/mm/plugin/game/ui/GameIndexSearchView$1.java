package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.g;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.a.a;

final class GameIndexSearchView$1
  implements View.OnClickListener
{
  GameIndexSearchView$1(GameIndexSearchView paramGameIndexSearchView, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42170);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameIndexSearchView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    int i;
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof String)))
    {
      paramView = (String)paramView.getTag();
      i = c.I(GameIndexSearchView.a(this.IRD), paramView, "game_center_msgcenter");
    }
    for (;;)
    {
      g.a(GameIndexSearchView.a(this.IRD), 14, 1401, 1, i, 0, null, this.INx, 0, null, null, null);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameIndexSearchView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42170);
      return;
      paramView = com.tencent.mm.plugin.game.model.a.fFQ();
      if (paramView.eQp == 2)
      {
        i = c.I(GameIndexSearchView.a(this.IRD), paramView.url, "game_center_msgcenter");
      }
      else
      {
        localObject = new Intent(GameIndexSearchView.a(this.IRD), GameSearchUI.class);
        ((Intent)localObject).putExtra("game_report_from_scene", 1001);
        paramView = GameIndexSearchView.a(this.IRD);
        localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/game/ui/GameIndexSearchView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/game/ui/GameIndexSearchView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        i = 6;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameIndexSearchView.1
 * JD-Core Version:    0.7.0.1
 */