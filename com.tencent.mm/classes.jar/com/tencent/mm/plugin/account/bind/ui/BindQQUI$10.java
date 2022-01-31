package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;

final class BindQQUI$10
  implements DialogInterface.OnClickListener
{
  BindQQUI$10(BindQQUI paramBindQQUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(13553);
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("kintent_hint", this.guz.getString(2131303496));
    paramDialogInterface.putExtra("from_unbind", true);
    d.b(this.guz, "account", "com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI", paramDialogInterface, 1);
    AppMethodBeat.o(13553);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindQQUI.10
 * JD-Core Version:    0.7.0.1
 */