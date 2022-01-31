package com.tencent.mm.plugin.account.ui;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LoginPasswordUI$2
  implements View.OnKeyListener
{
  LoginPasswordUI$2(LoginPasswordUI paramLoginPasswordUI) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(124999);
    if ((66 == paramInt) && (paramKeyEvent.getAction() == 0))
    {
      this.gEJ.arq();
      AppMethodBeat.o(124999);
      return true;
    }
    AppMethodBeat.o(124999);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginPasswordUI.2
 * JD-Core Version:    0.7.0.1
 */