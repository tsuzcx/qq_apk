package com.tencent.mm.chatroom.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SeeRoomManagerUI$3
  implements MenuItem.OnMenuItemClickListener
{
  SeeRoomManagerUI$3(SeeRoomManagerUI paramSeeRoomManagerUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(12826);
    this.fUC.finish();
    AppMethodBeat.o(12826);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeRoomManagerUI.3
 * JD-Core Version:    0.7.0.1
 */