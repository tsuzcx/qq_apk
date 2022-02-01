package com.tencent.mm.plugin.game.chatroom.i;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class k$16
  implements View.OnClickListener
{
  k$16(k paramk) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(275967);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/game/chatroom/piece/GameChatItemVH$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    this.Imc.fCM();
    a.a(this, "com/tencent/mm/plugin/game/chatroom/piece/GameChatItemVH$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(275967);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.i.k.16
 * JD-Core Version:    0.7.0.1
 */