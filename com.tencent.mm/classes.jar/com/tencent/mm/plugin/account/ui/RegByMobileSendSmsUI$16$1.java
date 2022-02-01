package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsimple.v;

final class RegByMobileSendSmsUI$16$1
  implements DialogInterface.OnCancelListener
{
  RegByMobileSendSmsUI$16$1(RegByMobileSendSmsUI.16 param16, v paramv) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(128575);
    h.aGY().a(this.ngm);
    AppMethodBeat.o(128575);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileSendSmsUI.16.1
 * JD-Core Version:    0.7.0.1
 */