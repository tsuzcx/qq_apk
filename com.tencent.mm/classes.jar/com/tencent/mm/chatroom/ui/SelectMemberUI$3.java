package com.tencent.mm.chatroom.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SelectMemberUI$3
  implements MenuItem.OnMenuItemClickListener
{
  SelectMemberUI$3(SelectMemberUI paramSelectMemberUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(104411);
    paramMenuItem = new Intent();
    this.ejJ.setResult(0, paramMenuItem);
    this.ejJ.finish();
    AppMethodBeat.o(104411);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectMemberUI.3
 * JD-Core Version:    0.7.0.1
 */