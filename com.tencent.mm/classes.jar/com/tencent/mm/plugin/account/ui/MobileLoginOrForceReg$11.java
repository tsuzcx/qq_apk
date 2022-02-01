package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.u;

final class MobileLoginOrForceReg$11
  implements DialogInterface.OnCancelListener
{
  MobileLoginOrForceReg$11(MobileLoginOrForceReg paramMobileLoginOrForceReg, u paramu) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(128384);
    g.agi().a(this.iUg);
    AppMethodBeat.o(128384);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg.11
 * JD-Core Version:    0.7.0.1
 */