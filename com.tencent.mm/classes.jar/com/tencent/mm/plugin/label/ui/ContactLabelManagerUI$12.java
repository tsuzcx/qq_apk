package com.tencent.mm.plugin.label.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.ui.widget.b.a;

final class ContactLabelManagerUI$12
  implements AdapterView.OnItemLongClickListener
{
  ContactLabelManagerUI$12(ContactLabelManagerUI paramContactLabelManagerUI) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ContactLabelManagerUI.f(this.lBw).a(paramView, paramInt, paramLong, this.lBw, this.lBw, ContactLabelManagerUI.d(this.lBw), ContactLabelManagerUI.e(this.lBw));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelManagerUI.12
 * JD-Core Version:    0.7.0.1
 */