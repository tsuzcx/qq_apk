package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.b.a;

final class RegByMobileRegAIOUI$13
  implements DialogInterface.OnClickListener
{
  RegByMobileRegAIOUI$13(RegByMobileRegAIOUI paramRegByMobileRegAIOUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(218886);
    paramDialogInterface = new StringBuilder();
    h.aHE();
    paramDialogInterface = paramDialogInterface.append(b.aGR()).append(",").append(this.nic.getClass().getName()).append(",RE200_200,");
    h.aHE();
    a.m(false, b.MN("RE200_200") + ",2");
    a.bkD("RE200_100");
    AppMethodBeat.o(218886);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.13
 * JD-Core Version:    0.7.0.1
 */