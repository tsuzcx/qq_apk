package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class LoginHistoryUI$22
  implements DialogInterface.OnClickListener
{
  LoginHistoryUI$22(LoginHistoryUI paramLoginHistoryUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(124929);
    ab.i("MicroMsg.LoginHistoryUI", "db dangerous and auto logout");
    LoginHistoryUI.a(this.gEw);
    AppMethodBeat.o(124929);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginHistoryUI.22
 * JD-Core Version:    0.7.0.1
 */