package com.tencent.mm.plugin.label.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ContactLabelMemberListUI$4
  implements MenuItem.OnMenuItemClickListener
{
  ContactLabelMemberListUI$4(ContactLabelMemberListUI paramContactLabelMemberListUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(22642);
    paramMenuItem = new Intent();
    paramMenuItem.setClass(this.nZa, ContactLabelEditUI.class);
    paramMenuItem.putExtra("label_id", ContactLabelMemberListUI.c(this.nZa));
    paramMenuItem.putExtra("label_name", ContactLabelMemberListUI.d(this.nZa));
    this.nZa.startActivityForResult(paramMenuItem, 10001);
    AppMethodBeat.o(22642);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelMemberListUI.4
 * JD-Core Version:    0.7.0.1
 */