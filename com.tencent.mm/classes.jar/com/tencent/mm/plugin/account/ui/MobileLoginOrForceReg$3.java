package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MobileLoginOrForceReg$3
  implements DialogInterface.OnDismissListener
{
  MobileLoginOrForceReg$3(MobileLoginOrForceReg paramMobileLoginOrForceReg) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(125206);
    MobileLoginOrForceReg.s(this.gGw);
    AppMethodBeat.o(125206);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg.3
 * JD-Core Version:    0.7.0.1
 */