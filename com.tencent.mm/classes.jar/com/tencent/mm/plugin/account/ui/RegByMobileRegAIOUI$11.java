package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bj;

final class RegByMobileRegAIOUI$11
  implements DialogInterface.OnClickListener
{
  RegByMobileRegAIOUI$11(RegByMobileRegAIOUI paramRegByMobileRegAIOUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(125353);
    RegByMobileRegAIOUI.w(this.gIh);
    RegByMobileRegAIOUI.y(this.gIh).cXw = RegByMobileRegAIOUI.x(this.gIh);
    RegByMobileRegAIOUI.y(this.gIh).cRH = 8L;
    RegByMobileRegAIOUI.y(this.gIh).ake();
    AppMethodBeat.o(125353);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.11
 * JD-Core Version:    0.7.0.1
 */