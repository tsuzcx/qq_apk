package com.tencent.mm.chatroom.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RoomCardUI$7
  implements View.OnLongClickListener
{
  RoomCardUI$7(RoomCardUI paramRoomCardUI) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(155172);
    RoomCardUI.a(this.ehp, RoomCardUI.b(this.ehp));
    AppMethodBeat.o(155172);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomCardUI.7
 * JD-Core Version:    0.7.0.1
 */