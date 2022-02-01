package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsimple.v;

final class RegByMobileSendSmsUI$11
  implements DialogInterface.OnCancelListener
{
  RegByMobileSendSmsUI$11(RegByMobileSendSmsUI paramRegByMobileSendSmsUI, v paramv) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(128572);
    h.aGY().a(this.ngm);
    h.aGY().b(126, this.nil);
    AppMethodBeat.o(128572);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileSendSmsUI.11
 * JD-Core Version:    0.7.0.1
 */