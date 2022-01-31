package com.tencent.mm.plugin.label.ui;

import com.tencent.mm.sdk.platformtools.ah;

final class ContactLabelManagerUI$4$2
  implements Runnable
{
  ContactLabelManagerUI$4$2(ContactLabelManagerUI.4 param4) {}
  
  public final void run()
  {
    ContactLabelManagerUI.a(this.lBz.lBw, ContactLabelManagerUI.b.lBB);
    ContactLabelManagerUI.a locala = ContactLabelManagerUI.k(this.lBz.lBw);
    locala.mData = ContactLabelManagerUI.g(this.lBz.lBw);
    locala.notifyDataSetChanged();
    ContactLabelManagerUI.k(this.lBz.lBw).notifyDataSetInvalidated();
    if ((this.lBz.lBy) && (ContactLabelManagerUI.c(this.lBz.lBw) != null))
    {
      ContactLabelManagerUI.c(this.lBz.lBw).removeMessages(5002);
      ContactLabelManagerUI.c(this.lBz.lBw).sendEmptyMessageDelayed(5003, 400L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelManagerUI.4.2
 * JD-Core Version:    0.7.0.1
 */