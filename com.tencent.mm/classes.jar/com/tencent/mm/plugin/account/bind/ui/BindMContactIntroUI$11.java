package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.account.bind.a.i;

final class BindMContactIntroUI$11
  implements DialogInterface.OnClickListener
{
  BindMContactIntroUI$11(BindMContactIntroUI paramBindMContactIntroUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("kintent_hint", this.fbF.getString(a.i.settings_unbind_set_password_tip));
    paramDialogInterface.putExtra("from_unbind", true);
    d.b(this.fbF, "account", "com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI", paramDialogInterface, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI.11
 * JD-Core Version:    0.7.0.1
 */