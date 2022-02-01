package com.tencent.mm.chatroom.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class RoomCardUI$7
  implements View.OnLongClickListener
{
  RoomCardUI$7(RoomCardUI paramRoomCardUI) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(12697);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/chatroom/ui/RoomCardUI$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
    RoomCardUI.a(this.gyl, RoomCardUI.b(this.gyl));
    a.a(true, this, "com/tencent/mm/chatroom/ui/RoomCardUI$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(12697);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomCardUI.7
 * JD-Core Version:    0.7.0.1
 */