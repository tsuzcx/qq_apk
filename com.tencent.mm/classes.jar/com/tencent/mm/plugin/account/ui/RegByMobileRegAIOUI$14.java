package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.b.a;

final class RegByMobileRegAIOUI$14
  implements DialogInterface.OnClickListener
{
  RegByMobileRegAIOUI$14(RegByMobileRegAIOUI paramRegByMobileRegAIOUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(305161);
    paramDialogInterface = new StringBuilder();
    h.baC();
    paramDialogInterface = paramDialogInterface.append(b.aZR()).append(",").append(this.qfw.getClass().getName()).append(",RE200_200,");
    h.baC();
    a.z(false, b.Fw("RE200_200") + ",2");
    a.TA("RE200_100");
    AppMethodBeat.o(305161);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.14
 * JD-Core Version:    0.7.0.1
 */