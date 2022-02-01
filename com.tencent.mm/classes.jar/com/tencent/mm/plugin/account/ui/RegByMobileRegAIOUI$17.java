package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsimple.u;

final class RegByMobileRegAIOUI$17
  implements DialogInterface.OnCancelListener
{
  RegByMobileRegAIOUI$17(RegByMobileRegAIOUI paramRegByMobileRegAIOUI, u paramu) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(305153);
    h.aZW().a(this.qfB);
    AppMethodBeat.o(305153);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.17
 * JD-Core Version:    0.7.0.1
 */