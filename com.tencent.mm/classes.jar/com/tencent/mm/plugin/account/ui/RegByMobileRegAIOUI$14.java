package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.s;

final class RegByMobileRegAIOUI$14
  implements DialogInterface.OnCancelListener
{
  RegByMobileRegAIOUI$14(RegByMobileRegAIOUI paramRegByMobileRegAIOUI, s params) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(128527);
    g.aeS().a(this.ivZ);
    AppMethodBeat.o(128527);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.14
 * JD-Core Version:    0.7.0.1
 */