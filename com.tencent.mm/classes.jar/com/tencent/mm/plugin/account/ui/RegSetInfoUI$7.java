package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.u;

final class RegSetInfoUI$7
  implements DialogInterface.OnCancelListener
{
  RegSetInfoUI$7(RegSetInfoUI paramRegSetInfoUI, u paramu) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(128673);
    g.aiU().a(this.jqK);
    g.aiU().b(126, this.jqJ);
    AppMethodBeat.o(128673);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegSetInfoUI.7
 * JD-Core Version:    0.7.0.1
 */