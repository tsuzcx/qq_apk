package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.pluginsdk.n;

final class BindMContactVerifyUI$5$2
  implements DialogInterface.OnClickListener
{
  BindMContactVerifyUI$5$2(BindMContactVerifyUI.5 param5) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(13484);
    paramDialogInterface = new Intent();
    paramDialogInterface.addFlags(67108864);
    paramDialogInterface.putExtra("exit_and_restart", true);
    a.gmO.p(paramDialogInterface, this.gtT.gtS);
    AppMethodBeat.o(13484);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMContactVerifyUI.5.2
 * JD-Core Version:    0.7.0.1
 */