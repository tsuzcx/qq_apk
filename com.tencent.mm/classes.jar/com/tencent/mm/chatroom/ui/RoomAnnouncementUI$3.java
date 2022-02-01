package com.tencent.mm.chatroom.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RoomAnnouncementUI$3
  implements MenuItem.OnMenuItemClickListener
{
  RoomAnnouncementUI$3(RoomAnnouncementUI paramRoomAnnouncementUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(12685);
    this.gxN.setResult(0);
    this.gxN.finish();
    AppMethodBeat.o(12685);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomAnnouncementUI.3
 * JD-Core Version:    0.7.0.1
 */