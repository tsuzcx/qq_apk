package com.tencent.mm.plugin.game.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.f;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.e.c;

final class GameLibraryUI$6
  implements View.OnClickListener
{
  GameLibraryUI$6(GameLibraryUI paramGameLibraryUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42225);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameLibraryUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    if ((paramView.getTag() instanceof String)) {
      c.a(paramView, this.xTR);
    }
    for (int i = 7;; i = 6)
    {
      f.a(this.xTR, 11, 1113, 1, i, GameLibraryUI.e(this.xTR), null);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameLibraryUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42225);
      return;
      localObject = new Intent(this.xTR, GameCategoryUI.class);
      ((Intent)localObject).putExtra("extra_type", 2);
      ((Intent)localObject).putExtra("extra_category_name", this.xTR.getString(2131761236));
      ((Intent)localObject).putExtra("game_report_from_scene", 1113);
      paramView = this.xTR;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/game/ui/GameLibraryUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/game/ui/GameLibraryUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameLibraryUI.6
 * JD-Core Version:    0.7.0.1
 */