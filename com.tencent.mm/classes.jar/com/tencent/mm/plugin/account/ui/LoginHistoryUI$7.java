package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;

final class LoginHistoryUI$7
  implements View.OnClickListener
{
  LoginHistoryUI$7(LoginHistoryUI paramLoginHistoryUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(124919);
    d.H(this.gEw, "login_exdevice", ".ui.LoginAsExDeviceUI");
    this.gEw.overridePendingTransition(2131034227, 2131034130);
    AppMethodBeat.o(124919);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginHistoryUI.7
 * JD-Core Version:    0.7.0.1
 */