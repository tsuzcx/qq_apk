package com.tencent.mm.plugin.game.chatroom.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.d;
import com.tencent.mm.game.report.d.a;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.chatroom.view.GameChatCommentFooter;

final class GameChatRoomUI$14
  implements View.OnClickListener
{
  GameChatRoomUI$14(GameChatRoomUI paramGameChatRoomUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(210688);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/game/chatroom/ui/GameChatRoomUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    GameChatRoomUI.l(this.Cwp).setVisibility(0);
    paramView = d.jTj;
    d.a.a(1L, 2L, GameChatRoomUI.d(this.Cwp), GameChatRoomUI.e(this.Cwp));
    a.a(this, "com/tencent/mm/plugin/game/chatroom/ui/GameChatRoomUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(210688);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.ui.GameChatRoomUI.14
 * JD-Core Version:    0.7.0.1
 */