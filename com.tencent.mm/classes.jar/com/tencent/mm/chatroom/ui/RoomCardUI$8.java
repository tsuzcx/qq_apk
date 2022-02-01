package com.tencent.mm.chatroom.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class RoomCardUI$8
  implements View.OnLongClickListener
{
  RoomCardUI$8(RoomCardUI paramRoomCardUI) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(12697);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/chatroom/ui/RoomCardUI$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
    RoomCardUI.a(this.jin, RoomCardUI.a(this.jin));
    a.a(true, this, "com/tencent/mm/chatroom/ui/RoomCardUI$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(12697);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomCardUI.8
 * JD-Core Version:    0.7.0.1
 */