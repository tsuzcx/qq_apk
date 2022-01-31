package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelfriend.a;

final class RegByMobileSendSmsUI$12
  implements DialogInterface.OnClickListener
{
  RegByMobileSendSmsUI$12(RegByMobileSendSmsUI paramRegByMobileSendSmsUI, a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    g.Dk().a(701, this.fqR);
    RegByMobileSendSmsUI.a(this.fqR, this.fqT.getUsername(), this.fqT.NI());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileSendSmsUI.12
 * JD-Core Version:    0.7.0.1
 */