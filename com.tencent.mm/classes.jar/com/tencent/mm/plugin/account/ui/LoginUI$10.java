package com.tencent.mm.plugin.account.ui;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LoginUI$10
  implements View.OnKeyListener
{
  LoginUI$10(LoginUI paramLoginUI) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(152557);
    if ((66 == paramInt) && (paramKeyEvent.getAction() == 0))
    {
      LoginUI.e(this.gFf);
      AppMethodBeat.o(152557);
      return true;
    }
    AppMethodBeat.o(152557);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginUI.10
 * JD-Core Version:    0.7.0.1
 */