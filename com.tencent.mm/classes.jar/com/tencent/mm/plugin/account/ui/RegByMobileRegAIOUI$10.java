package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;

final class RegByMobileRegAIOUI$10
  implements DialogInterface.OnClickListener
{
  RegByMobileRegAIOUI$10(RegByMobileRegAIOUI paramRegByMobileRegAIOUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(128523);
    paramDialogInterface = new StringBuilder();
    g.agP();
    paramDialogInterface = paramDialogInterface.append(com.tencent.mm.kernel.a.agc()).append(",").append(this.iWa.getClass().getName()).append(",RE200_200,");
    g.agP();
    com.tencent.mm.plugin.b.a.h(false, com.tencent.mm.kernel.a.uc("RE200_200") + ",2");
    com.tencent.mm.plugin.b.a.IL("RE200_100");
    AppMethodBeat.o(128523);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.10
 * JD-Core Version:    0.7.0.1
 */