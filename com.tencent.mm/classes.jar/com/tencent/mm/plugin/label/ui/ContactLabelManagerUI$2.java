package com.tencent.mm.plugin.label.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.storage.af;

final class ContactLabelManagerUI$2
  implements DialogInterface.OnClickListener
{
  ContactLabelManagerUI$2(ContactLabelManagerUI paramContactLabelManagerUI, af paramaf) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.lBx != null)
    {
      if (this.lBx.field_isTemporary) {
        ContactLabelManagerUI.a(this.lBw, this.lBx.field_labelID);
      }
    }
    else {
      return;
    }
    ContactLabelManagerUI.a(this.lBw, this.lBx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelManagerUI.2
 * JD-Core Version:    0.7.0.1
 */