package com.tencent.mm.plugin.label.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.af;

final class ContactLabelManagerUI$2
  implements DialogInterface.OnClickListener
{
  ContactLabelManagerUI$2(ContactLabelManagerUI paramContactLabelManagerUI, af paramaf) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(22585);
    if (this.nYJ != null)
    {
      if (this.nYJ.field_isTemporary)
      {
        ContactLabelManagerUI.a(this.nYI, this.nYJ.field_labelID);
        AppMethodBeat.o(22585);
        return;
      }
      ContactLabelManagerUI.a(this.nYI, this.nYJ);
    }
    AppMethodBeat.o(22585);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelManagerUI.2
 * JD-Core Version:    0.7.0.1
 */