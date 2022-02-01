package com.tencent.mm.chatroom.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.storage.e;
import com.tencent.mm.sdk.platformtools.Log;

final class GroupToolsManagereUI$6
  implements MenuItem.OnMenuItemClickListener
{
  GroupToolsManagereUI$6(GroupToolsManagereUI paramGroupToolsManagereUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(182173);
    Log.i("MicroMsg.roomtools.GroupToolsManagereUI", "menu click");
    paramMenuItem = GroupToolsManagereUI.a(this.iZY);
    paramMenuItem.field_stickToollist = e.T(paramMenuItem.iXI);
    GroupToolsManagereUI.l(this.iZY);
    AppMethodBeat.o(182173);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.GroupToolsManagereUI.6
 * JD-Core Version:    0.7.0.1
 */