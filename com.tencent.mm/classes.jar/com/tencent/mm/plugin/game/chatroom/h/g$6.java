package com.tencent.mm.plugin.game.chatroom.h;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class g$6
  implements View.OnClickListener
{
  g$6(g paramg) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(212380);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/game/chatroom/piece/GameChatItemVH$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    this.Cvu.evG();
    a.a(this, "com/tencent/mm/plugin/game/chatroom/piece/GameChatItemVH$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(212380);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.h.g.6
 * JD-Core Version:    0.7.0.1
 */