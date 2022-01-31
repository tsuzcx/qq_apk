package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aa;

final class LoginUI$24
  implements View.OnClickListener
{
  LoginUI$24(LoginUI paramLoginUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(152569);
    paramView = this.gFf.getString(2131306168, new Object[] { aa.dsG() });
    LoginUI.S(this.gFf, paramView);
    AppMethodBeat.o(152569);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginUI.24
 * JD-Core Version:    0.7.0.1
 */