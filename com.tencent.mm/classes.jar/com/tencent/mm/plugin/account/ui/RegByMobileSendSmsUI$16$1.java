package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.u;

final class RegByMobileSendSmsUI$16$1
  implements DialogInterface.OnCancelListener
{
  RegByMobileSendSmsUI$16$1(RegByMobileSendSmsUI.16 param16, u paramu) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(125411);
    g.Rc().a(this.gGA);
    AppMethodBeat.o(125411);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileSendSmsUI.16.1
 * JD-Core Version:    0.7.0.1
 */