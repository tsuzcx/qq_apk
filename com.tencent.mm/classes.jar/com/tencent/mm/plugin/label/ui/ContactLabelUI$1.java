package com.tencent.mm.plugin.label.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ContactLabelUI$1
  implements MenuItem.OnMenuItemClickListener
{
  ContactLabelUI$1(ContactLabelUI paramContactLabelUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(22658);
    this.nZv.onBackPressed();
    AppMethodBeat.o(22658);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelUI.1
 * JD-Core Version:    0.7.0.1
 */