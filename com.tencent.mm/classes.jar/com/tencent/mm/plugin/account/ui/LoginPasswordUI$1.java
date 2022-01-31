package com.tencent.mm.plugin.account.ui;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LoginPasswordUI$1
  implements TextView.OnEditorActionListener
{
  LoginPasswordUI$1(LoginPasswordUI paramLoginPasswordUI) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(124998);
    if ((paramInt == 6) || (paramInt == 5))
    {
      this.gEJ.arq();
      AppMethodBeat.o(124998);
      return true;
    }
    AppMethodBeat.o(124998);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginPasswordUI.1
 * JD-Core Version:    0.7.0.1
 */