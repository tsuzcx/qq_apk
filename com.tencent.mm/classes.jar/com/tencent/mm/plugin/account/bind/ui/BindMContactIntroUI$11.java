package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;

final class BindMContactIntroUI$11
  implements DialogInterface.OnClickListener
{
  BindMContactIntroUI$11(BindMContactIntroUI paramBindMContactIntroUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(13425);
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("kintent_hint", this.gtw.getString(2131303496));
    paramDialogInterface.putExtra("from_unbind", true);
    d.b(this.gtw, "account", "com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI", paramDialogInterface, 1);
    AppMethodBeat.o(13425);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI.11
 * JD-Core Version:    0.7.0.1
 */