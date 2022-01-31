package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.u;

final class MobileLoginOrForceReg$11
  implements DialogInterface.OnCancelListener
{
  MobileLoginOrForceReg$11(MobileLoginOrForceReg paramMobileLoginOrForceReg, u paramu) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(125210);
    g.Rc().a(this.gGA);
    AppMethodBeat.o(125210);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg.11
 * JD-Core Version:    0.7.0.1
 */