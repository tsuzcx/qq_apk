package com.tencent.mm.plugin.game.ui.message;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.f;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class GameMsgCenterUI$3
  implements View.OnClickListener
{
  GameMsgCenterUI$3(GameMsgCenterUI paramGameMsgCenterUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(183871);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/game/ui/message/GameMsgCenterUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    this.uuA.setCurrentItem(0);
    f.a(this.uuA.getContext(), 13, 1303, 1, 2, GameMsgCenterUI.a(this.uuA), null);
    a.a(this, "com/tencent/mm/plugin/game/ui/message/GameMsgCenterUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(183871);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.message.GameMsgCenterUI.3
 * JD-Core Version:    0.7.0.1
 */