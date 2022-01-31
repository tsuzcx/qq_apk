package com.tencent.mm.chatroom.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;

final class SelectDelMemberUI$1
  implements MenuItem.OnMenuItemClickListener
{
  SelectDelMemberUI$1(SelectDelMemberUI paramSelectDelMemberUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(104387);
    h.a(this.ejw, this.ejw.getString(2131302687), "", new SelectDelMemberUI.1.1(this), new SelectDelMemberUI.1.2(this));
    AppMethodBeat.o(104387);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectDelMemberUI.1
 * JD-Core Version:    0.7.0.1
 */