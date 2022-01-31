package com.tencent.mm.plugin.label.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;

final class ContactLabelBaseUI$1
  implements DialogInterface.OnCancelListener
{
  ContactLabelBaseUI$1(ContactLabelBaseUI paramContactLabelBaseUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(22536);
    aw.Rc().cancel(636);
    AppMethodBeat.o(22536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelBaseUI.1
 * JD-Core Version:    0.7.0.1
 */