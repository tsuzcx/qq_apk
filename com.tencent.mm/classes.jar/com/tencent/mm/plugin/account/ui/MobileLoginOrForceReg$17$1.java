package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.s;

final class MobileLoginOrForceReg$17$1
  implements DialogInterface.OnCancelListener
{
  MobileLoginOrForceReg$17$1(MobileLoginOrForceReg.17 param17, s params) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(125218);
    g.Rc().a(this.gDI);
    AppMethodBeat.o(125218);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg.17.1
 * JD-Core Version:    0.7.0.1
 */