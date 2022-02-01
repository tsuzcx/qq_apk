package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;

final class RegByMobileRegAIOUI$16
  implements DialogInterface.OnCancelListener
{
  RegByMobileRegAIOUI$16(RegByMobileRegAIOUI paramRegByMobileRegAIOUI, com.tencent.mm.modelsimple.t paramt) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(221827);
    h.aGY().a(this.nih);
    AppMethodBeat.o(221827);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.16
 * JD-Core Version:    0.7.0.1
 */