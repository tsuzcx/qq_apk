package com.tencent.mm.plugin.account.ui;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LoginUI$11
  implements TextView.OnEditorActionListener
{
  LoginUI$11(LoginUI paramLoginUI) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(305087);
    if ((paramInt == 6) || (paramInt == 5))
    {
      LoginUI.e(this.qbD);
      AppMethodBeat.o(305087);
      return true;
    }
    AppMethodBeat.o(305087);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginUI.11
 * JD-Core Version:    0.7.0.1
 */