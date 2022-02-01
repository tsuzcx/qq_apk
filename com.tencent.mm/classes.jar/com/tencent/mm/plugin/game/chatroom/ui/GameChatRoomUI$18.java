package com.tencent.mm.plugin.game.chatroom.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class GameChatRoomUI$18
  implements View.OnClickListener
{
  GameChatRoomUI$18(GameChatRoomUI paramGameChatRoomUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(276042);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/game/chatroom/ui/GameChatRoomUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    GameChatRoomUI.j(this.InB);
    a.a(this, "com/tencent/mm/plugin/game/chatroom/ui/GameChatRoomUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(276042);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.ui.GameChatRoomUI.18
 * JD-Core Version:    0.7.0.1
 */