package com.tencent.mm.chatroom.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class SelectAddRoomManagerUI$1
  implements MenuItem.OnMenuItemClickListener
{
  SelectAddRoomManagerUI$1(SelectAddRoomManagerUI paramSelectAddRoomManagerUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(104370);
    paramMenuItem = new Intent();
    paramMenuItem.putExtra("Select_Contact", bo.d(SelectAddRoomManagerUI.a(this.ejp), ","));
    this.ejp.setResult(-1, paramMenuItem);
    this.ejp.finish();
    this.ejp.hideVKB();
    AppMethodBeat.o(104370);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectAddRoomManagerUI.1
 * JD-Core Version:    0.7.0.1
 */