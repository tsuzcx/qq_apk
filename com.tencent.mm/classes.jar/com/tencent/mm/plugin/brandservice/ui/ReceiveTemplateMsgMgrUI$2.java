package com.tencent.mm.plugin.brandservice.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.d;

final class ReceiveTemplateMsgMgrUI$2
  implements DialogInterface.OnCancelListener
{
  ReceiveTemplateMsgMgrUI$2(ReceiveTemplateMsgMgrUI paramReceiveTemplateMsgMgrUI, d paramd) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(14022);
    g.Rc().a(this.jUL);
    AppMethodBeat.o(14022);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.ReceiveTemplateMsgMgrUI.2
 * JD-Core Version:    0.7.0.1
 */