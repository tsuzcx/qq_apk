package com.tencent.mm.chatroom.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RoomRightUI$1
  implements MenuItem.OnMenuItemClickListener
{
  RoomRightUI$1(RoomRightUI paramRoomRightUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(104204);
    this.ehH.hideVKB();
    this.ehH.finish();
    AppMethodBeat.o(104204);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomRightUI.1
 * JD-Core Version:    0.7.0.1
 */