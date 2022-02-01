package com.tencent.mm.plugin.masssend.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.masssend.a.f;

final class MassSendMsgUI$13
  implements DialogInterface.OnCancelListener
{
  MassSendMsgUI$13(MassSendMsgUI paramMassSendMsgUI, f paramf) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(26471);
    bg.azz().a(this.znK);
    AppMethodBeat.o(26471);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendMsgUI.13
 * JD-Core Version:    0.7.0.1
 */