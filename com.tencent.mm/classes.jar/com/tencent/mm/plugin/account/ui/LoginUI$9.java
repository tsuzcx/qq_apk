package com.tencent.mm.plugin.account.ui;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LoginUI$9
  implements TextView.OnEditorActionListener
{
  LoginUI$9(LoginUI paramLoginUI) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(152556);
    if ((paramInt == 6) || (paramInt == 5))
    {
      LoginUI.e(this.gFf);
      AppMethodBeat.o(152556);
      return true;
    }
    AppMethodBeat.o(152556);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginUI.9
 * JD-Core Version:    0.7.0.1
 */