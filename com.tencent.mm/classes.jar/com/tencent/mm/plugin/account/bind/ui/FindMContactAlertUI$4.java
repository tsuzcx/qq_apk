package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.b.a;

final class FindMContactAlertUI$4
  implements DialogInterface.OnClickListener
{
  FindMContactAlertUI$4(FindMContactAlertUI paramFindMContactAlertUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(109990);
    l.gX(false);
    paramDialogInterface = new StringBuilder();
    h.aHE();
    paramDialogInterface = paramDialogInterface.append(b.aGR()).append(",").append(this.mTC.getClass().getName()).append(",R300_200_phone,");
    h.aHE();
    a.KP(b.MN("R300_200_phone") + ",2");
    FindMContactAlertUI.d(this.mTC);
    AppMethodBeat.o(109990);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI.4
 * JD-Core Version:    0.7.0.1
 */