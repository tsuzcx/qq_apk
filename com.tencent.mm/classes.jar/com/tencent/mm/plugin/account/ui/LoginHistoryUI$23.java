package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.m;
import java.util.List;

final class LoginHistoryUI$23
  implements View.OnClickListener
{
  LoginHistoryUI$23(LoginHistoryUI paramLoginHistoryUI, List paramList) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(124930);
    LoginHistoryUI.a(this.gEw, ((m)this.gEz.get(0)).getItemId());
    AppMethodBeat.o(124930);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginHistoryUI.23
 * JD-Core Version:    0.7.0.1
 */