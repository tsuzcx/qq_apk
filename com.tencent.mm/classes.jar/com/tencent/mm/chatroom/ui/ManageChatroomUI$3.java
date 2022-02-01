package com.tencent.mm.chatroom.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ManageChatroomUI$3
  implements MenuItem.OnMenuItemClickListener
{
  ManageChatroomUI$3(ManageChatroomUI paramManageChatroomUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(194129);
    this.gwA.finish();
    AppMethodBeat.o(194129);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ManageChatroomUI.3
 * JD-Core Version:    0.7.0.1
 */