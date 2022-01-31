package com.tencent.mm.chatroom.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.h;

final class SelectDelRoomManagerUI$1
  implements MenuItem.OnMenuItemClickListener
{
  SelectDelRoomManagerUI$1(SelectDelRoomManagerUI paramSelectDelRoomManagerUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if (SelectDelRoomManagerUI.a(this.drR))
    {
      h.a(this.drR, this.drR.getString(a.i.room_del_this_members_tip), "", new SelectDelRoomManagerUI.1.1(this), new SelectDelRoomManagerUI.1.2(this));
      return true;
    }
    paramMenuItem = new Intent();
    paramMenuItem.putExtra("Select_Contact", bk.c(SelectDelRoomManagerUI.b(this.drR), ","));
    this.drR.setResult(-1, paramMenuItem);
    this.drR.finish();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectDelRoomManagerUI.1
 * JD-Core Version:    0.7.0.1
 */