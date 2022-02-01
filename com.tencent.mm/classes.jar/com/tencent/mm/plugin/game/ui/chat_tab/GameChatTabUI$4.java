package com.tencent.mm.plugin.game.ui.chat_tab;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.eq;
import com.tencent.mm.game.report.c.a;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class GameChatTabUI$4
  implements View.OnClickListener
{
  GameChatTabUI$4(GameChatTabUI paramGameChatTabUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(204190);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/game/ui/chat_tab/GameChatTabUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    paramView = com.tencent.mm.game.report.c.hhl;
    c.a.a(2L, 201L, 0L, 7L, this.xWW.getIntent().getIntExtra("game_report_from_scene", 0)).bfK();
    com.tencent.mm.plugin.game.e.c.aQ(this.xWW, GameChatTabUI.c(this.xWW));
    a.a(this, "com/tencent/mm/plugin/game/ui/chat_tab/GameChatTabUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(204190);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.chat_tab.GameChatTabUI.4
 * JD-Core Version:    0.7.0.1
 */