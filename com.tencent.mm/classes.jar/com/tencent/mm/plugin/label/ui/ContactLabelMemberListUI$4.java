package com.tencent.mm.plugin.label.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

final class ContactLabelMemberListUI$4
  implements MenuItem.OnMenuItemClickListener
{
  ContactLabelMemberListUI$4(ContactLabelMemberListUI paramContactLabelMemberListUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new Intent();
    paramMenuItem.setClass(this.lBO, ContactLabelEditUI.class);
    paramMenuItem.putExtra("label_id", ContactLabelMemberListUI.c(this.lBO));
    paramMenuItem.putExtra("label_name", ContactLabelMemberListUI.d(this.lBO));
    this.lBO.startActivityForResult(paramMenuItem, 10001);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelMemberListUI.4
 * JD-Core Version:    0.7.0.1
 */