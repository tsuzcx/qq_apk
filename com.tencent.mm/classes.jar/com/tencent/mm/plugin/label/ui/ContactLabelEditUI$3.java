package com.tencent.mm.plugin.label.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;

final class ContactLabelEditUI$3
  implements DialogInterface.OnCancelListener
{
  ContactLabelEditUI$3(ContactLabelEditUI paramContactLabelEditUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(22541);
    aw.Rc().cancel(635);
    aw.Rc().cancel(637);
    AppMethodBeat.o(22541);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelEditUI.3
 * JD-Core Version:    0.7.0.1
 */