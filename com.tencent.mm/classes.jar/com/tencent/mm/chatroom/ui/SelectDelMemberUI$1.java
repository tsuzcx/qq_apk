package com.tencent.mm.chatroom.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.base.h;

final class SelectDelMemberUI$1
  implements MenuItem.OnMenuItemClickListener
{
  SelectDelMemberUI$1(SelectDelMemberUI paramSelectDelMemberUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    h.a(this.drO, this.drO.getString(a.i.room_del_this_members_tip), "", new SelectDelMemberUI.1.1(this), new SelectDelMemberUI.1.2(this));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectDelMemberUI.1
 * JD-Core Version:    0.7.0.1
 */