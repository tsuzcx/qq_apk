package com.tencent.mm.plugin.account.ui;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LoginIndepPass$11
  implements TextView.OnEditorActionListener
{
  LoginIndepPass$11(LoginIndepPass paramLoginIndepPass) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(128155);
    if ((paramInt == 6) || (paramInt == 5))
    {
      LoginIndepPass.a(this.qbg);
      AppMethodBeat.o(128155);
      return true;
    }
    AppMethodBeat.o(128155);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginIndepPass.11
 * JD-Core Version:    0.7.0.1
 */