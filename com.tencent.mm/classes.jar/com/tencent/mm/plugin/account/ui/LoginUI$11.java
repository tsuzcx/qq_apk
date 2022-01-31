package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;

final class LoginUI$11
  implements View.OnClickListener
{
  LoginUI$11(LoginUI paramLoginUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(152558);
    d.H(this.gFf, "login_exdevice", ".ui.LoginAsExDeviceUI");
    this.gFf.overridePendingTransition(2131034227, 2131034130);
    AppMethodBeat.o(152558);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginUI.11
 * JD-Core Version:    0.7.0.1
 */