package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.s;

final class RegByMobileRegAIOUI$14
  implements DialogInterface.OnCancelListener
{
  RegByMobileRegAIOUI$14(RegByMobileRegAIOUI paramRegByMobileRegAIOUI, s params) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(152596);
    g.Rc().a(this.gIj);
    AppMethodBeat.o(152596);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.14
 * JD-Core Version:    0.7.0.1
 */