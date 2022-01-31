package com.tencent.mm.plugin.masssend.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.masssend.a.f;

final class MassSendMsgUI$15
  implements DialogInterface.OnCancelListener
{
  MassSendMsgUI$15(MassSendMsgUI paramMassSendMsgUI, f paramf) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(153549);
    aw.Rc().a(this.oBE);
    AppMethodBeat.o(153549);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendMsgUI.15
 * JD-Core Version:    0.7.0.1
 */