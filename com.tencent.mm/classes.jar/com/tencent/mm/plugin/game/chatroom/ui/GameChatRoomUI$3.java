package com.tencent.mm.plugin.game.chatroom.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class GameChatRoomUI$3
  implements View.OnClickListener
{
  GameChatRoomUI$3(GameChatRoomUI paramGameChatRoomUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(275990);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/game/chatroom/ui/GameChatRoomUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    GameChatRoomUI.o(this.InB);
    a.a(this, "com/tencent/mm/plugin/game/chatroom/ui/GameChatRoomUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(275990);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.ui.GameChatRoomUI.3
 * JD-Core Version:    0.7.0.1
 */