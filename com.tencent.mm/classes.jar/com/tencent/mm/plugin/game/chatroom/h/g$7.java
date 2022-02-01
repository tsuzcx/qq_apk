package com.tencent.mm.plugin.game.chatroom.h;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.chatroom.b.b;
import com.tencent.mm.plugin.game.chatroom.c.n;
import com.tencent.mm.sdk.platformtools.Log;

final class g$7
  implements View.OnClickListener
{
  g$7(g paramg) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(212540);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/game/chatroom/piece/GameChatItemVH$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if ((g.f(this.Cvu).getTag() instanceof b.b))
    {
      paramView = (b.b)g.f(this.Cvu).getTag();
      Log.i("GameChatRoom.GameChatItemVH", "retry send msg, cliMsgId:%s", new Object[] { paramView.CrQ });
      g.f(this.Cvu).setVisibility(8);
      g.g(this.Cvu).setVisibility(0);
      paramView = new n(paramView);
      h.aGY().a(paramView, 0);
    }
    a.a(this, "com/tencent/mm/plugin/game/chatroom/piece/GameChatItemVH$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(212540);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.h.g.7
 * JD-Core Version:    0.7.0.1
 */