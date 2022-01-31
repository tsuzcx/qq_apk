package com.tencent.mm.plugin.masssend.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.masssend.a.f;

final class MassSendMsgUI$12
  implements DialogInterface.OnCancelListener
{
  MassSendMsgUI$12(MassSendMsgUI paramMassSendMsgUI, f paramf) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(22846);
    aw.Rc().a(this.oBE);
    AppMethodBeat.o(22846);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendMsgUI.12
 * JD-Core Version:    0.7.0.1
 */