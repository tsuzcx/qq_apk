package com.tencent.mm.plugin.label.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.c.a;

final class ContactLabelManagerUI$12
  implements AdapterView.OnItemLongClickListener
{
  ContactLabelManagerUI$12(ContactLabelManagerUI paramContactLabelManagerUI) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(22597);
    ContactLabelManagerUI.f(this.nYI).a(paramView, paramInt, paramLong, this.nYI, this.nYI, ContactLabelManagerUI.d(this.nYI), ContactLabelManagerUI.e(this.nYI));
    AppMethodBeat.o(22597);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelManagerUI.12
 * JD-Core Version:    0.7.0.1
 */