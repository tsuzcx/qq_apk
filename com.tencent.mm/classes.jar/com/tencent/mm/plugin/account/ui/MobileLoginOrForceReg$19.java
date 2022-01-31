package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.t;

final class MobileLoginOrForceReg$19
  implements DialogInterface.OnCancelListener
{
  MobileLoginOrForceReg$19(MobileLoginOrForceReg paramMobileLoginOrForceReg, t paramt) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(125221);
    g.Rc().a(this.gGF);
    AppMethodBeat.o(125221);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg.19
 * JD-Core Version:    0.7.0.1
 */