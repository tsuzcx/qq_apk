package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.m;
import java.util.List;

final class LoginHistoryUI$27
  implements View.OnClickListener
{
  LoginHistoryUI$27(LoginHistoryUI paramLoginHistoryUI, List paramList) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(128108);
    LoginHistoryUI.a(this.iSi, ((m)this.iSl.get(0)).getItemId());
    AppMethodBeat.o(128108);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginHistoryUI.27
 * JD-Core Version:    0.7.0.1
 */