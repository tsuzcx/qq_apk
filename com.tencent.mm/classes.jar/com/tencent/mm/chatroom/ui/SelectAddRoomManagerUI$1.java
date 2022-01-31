package com.tencent.mm.chatroom.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.bk;

final class SelectAddRoomManagerUI$1
  implements MenuItem.OnMenuItemClickListener
{
  SelectAddRoomManagerUI$1(SelectAddRoomManagerUI paramSelectAddRoomManagerUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new Intent();
    paramMenuItem.putExtra("Select_Contact", bk.c(SelectAddRoomManagerUI.a(this.drH), ","));
    this.drH.setResult(-1, paramMenuItem);
    this.drH.finish();
    this.drH.XM();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectAddRoomManagerUI.1
 * JD-Core Version:    0.7.0.1
 */