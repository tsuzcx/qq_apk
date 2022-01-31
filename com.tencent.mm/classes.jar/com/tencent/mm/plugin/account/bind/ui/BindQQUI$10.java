package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.account.bind.a.i;

final class BindQQUI$10
  implements DialogInterface.OnClickListener
{
  BindQQUI$10(BindQQUI paramBindQQUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("kintent_hint", this.fcO.getString(a.i.settings_unbind_set_password_tip));
    paramDialogInterface.putExtra("from_unbind", true);
    d.b(this.fcO, "account", "com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI", paramDialogInterface, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindQQUI.10
 * JD-Core Version:    0.7.0.1
 */