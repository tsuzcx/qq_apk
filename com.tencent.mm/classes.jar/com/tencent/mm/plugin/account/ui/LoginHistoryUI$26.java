package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aa;

final class LoginHistoryUI$26
  implements View.OnClickListener
{
  LoginHistoryUI$26(LoginHistoryUI paramLoginHistoryUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(124934);
    paramView = this.gEw.getString(2131306187) + aa.dsG();
    LoginHistoryUI.R(this.gEw, paramView);
    AppMethodBeat.o(124934);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginHistoryUI.26
 * JD-Core Version:    0.7.0.1
 */