package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;

final class LoginHistoryUI$7
  implements View.OnClickListener
{
  LoginHistoryUI$7(LoginHistoryUI paramLoginHistoryUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(128093);
    d.N(this.iSi, "login_exdevice", ".ui.LoginAsExDeviceUI");
    this.iSi.overridePendingTransition(2130772105, 2130771986);
    AppMethodBeat.o(128093);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginHistoryUI.7
 * JD-Core Version:    0.7.0.1
 */