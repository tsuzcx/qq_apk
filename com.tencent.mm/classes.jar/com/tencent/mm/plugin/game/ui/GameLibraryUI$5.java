package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.f;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.e.c;

final class GameLibraryUI$5
  implements View.OnClickListener
{
  GameLibraryUI$5(GameLibraryUI paramGameLibraryUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42224);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/game/ui/GameLibraryUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    c.a(paramView, this.xTR);
    f.a(this.xTR, 11, 1110, 999, 7, GameLibraryUI.e(this.xTR), null);
    a.a(this, "com/tencent/mm/plugin/game/ui/GameLibraryUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42224);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameLibraryUI.5
 * JD-Core Version:    0.7.0.1
 */