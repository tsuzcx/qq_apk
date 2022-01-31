package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

final class RegByMobileSetPwdUI$1$2
  implements DialogInterface.OnClickListener
{
  RegByMobileSetPwdUI$1$2(RegByMobileSetPwdUI.1 param1, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(this.frn.frm, MobileVerifyUI.class);
    paramDialogInterface.putExtra("bindmcontact_mobile", this.fbL);
    paramDialogInterface.putExtra("mobile_verify_purpose", 5);
    this.frn.frm.startActivityForResult(paramDialogInterface, 10001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI.1.2
 * JD-Core Version:    0.7.0.1
 */