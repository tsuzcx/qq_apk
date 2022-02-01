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
    g.ajA();
    paramDialogInterface = paramDialogInterface.append(com.tencent.mm.kernel.a.aiO()).append(",").append(this.jpj.getClass().getName()).append(",RE200_200,");
    g.ajA();
    com.tencent.mm.plugin.b.a.i(false, com.tencent.mm.kernel.a.wS("RE200_200") + ",2");
    com.tencent.mm.plugin.b.a.Ma("RE200_100");
    AppMethodBeat.o(128523);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.10
 * JD-Core Version:    0.7.0.1
 */