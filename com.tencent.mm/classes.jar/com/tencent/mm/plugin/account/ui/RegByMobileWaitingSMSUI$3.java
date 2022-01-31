package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RegByMobileWaitingSMSUI$3
  implements DialogInterface.OnClickListener
{
  RegByMobileWaitingSMSUI$3(RegByMobileWaitingSMSUI paramRegByMobileWaitingSMSUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(125477);
    RegByMobileWaitingSMSUI.g(this.gJh);
    this.gJh.finish();
    AppMethodBeat.o(125477);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileWaitingSMSUI.3
 * JD-Core Version:    0.7.0.1
 */