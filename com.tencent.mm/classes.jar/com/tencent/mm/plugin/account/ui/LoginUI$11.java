package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;

final class LoginUI$11
  implements View.OnClickListener
{
  LoginUI$11(LoginUI paramLoginUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(128212);
    d.N(this.iSO, "login_exdevice", ".ui.LoginAsExDeviceUI");
    this.iSO.overridePendingTransition(2130772105, 2130771986);
    AppMethodBeat.o(128212);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginUI.11
 * JD-Core Version:    0.7.0.1
 */