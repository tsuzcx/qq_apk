package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;

final class LoginHistoryUI$22
  implements DialogInterface.OnClickListener
{
  LoginHistoryUI$22(LoginHistoryUI paramLoginHistoryUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.i("MicroMsg.LoginHistoryUI", "db dangerous and auto logout");
    LoginHistoryUI.a(this.fnc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginHistoryUI.22
 * JD-Core Version:    0.7.0.1
 */