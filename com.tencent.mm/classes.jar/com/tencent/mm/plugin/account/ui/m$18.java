package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;

final class m$18
  implements DialogInterface.OnCancelListener
{
  m$18(m paramm, com.tencent.mm.modelsimple.t paramt) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(128317);
    h.aGY().a(this.ndz);
    AppMethodBeat.o(128317);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.m.18
 * JD-Core Version:    0.7.0.1
 */