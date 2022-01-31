package com.tencent.mm.chatroom.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;

final class SelectDelRoomManagerUI$1
  implements MenuItem.OnMenuItemClickListener
{
  SelectDelRoomManagerUI$1(SelectDelRoomManagerUI paramSelectDelRoomManagerUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(104397);
    if (SelectDelRoomManagerUI.a(this.ejz))
    {
      h.a(this.ejz, this.ejz.getString(2131302687), "", new SelectDelRoomManagerUI.1.1(this), new SelectDelRoomManagerUI.1.2(this));
      AppMethodBeat.o(104397);
      return true;
    }
    paramMenuItem = new Intent();
    paramMenuItem.putExtra("Select_Contact", bo.d(SelectDelRoomManagerUI.b(this.ejz), ","));
    this.ejz.setResult(-1, paramMenuItem);
    this.ejz.finish();
    AppMethodBeat.o(104397);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectDelRoomManagerUI.1
 * JD-Core Version:    0.7.0.1
 */