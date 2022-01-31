package com.tencent.mm.chatroom.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SeeRoomMemberUI$11
  implements MenuItem.OnMenuItemClickListener
{
  SeeRoomMemberUI$11(SeeRoomMemberUI paramSeeRoomMemberUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(104317);
    this.eja.setResult(0);
    this.eja.finish();
    AppMethodBeat.o(104317);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeRoomMemberUI.11
 * JD-Core Version:    0.7.0.1
 */