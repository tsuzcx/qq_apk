package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.u;

final class RegSetInfoUI$7
  implements DialogInterface.OnCancelListener
{
  RegSetInfoUI$7(RegSetInfoUI paramRegSetInfoUI, u paramu) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(125512);
    g.Rc().a(this.gJR);
    g.Rc().b(126, this.gJQ);
    AppMethodBeat.o(125512);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegSetInfoUI.7
 * JD-Core Version:    0.7.0.1
 */