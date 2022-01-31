package com.tencent.mm.plugin.account.ui;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

final class LoginPasswordUI$2
  implements View.OnKeyListener
{
  LoginPasswordUI$2(LoginPasswordUI paramLoginPasswordUI) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((66 == paramInt) && (paramKeyEvent.getAction() == 0))
    {
      this.fnq.XJ();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginPasswordUI.2
 * JD-Core Version:    0.7.0.1
 */