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
    AppMethodBeat.i(124977);
    if ((paramInt == 6) || (paramInt == 5))
    {
      LoginIndepPass.a(this.gEE);
      AppMethodBeat.o(124977);
      return true;
    }
    AppMethodBeat.o(124977);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginIndepPass.11
 * JD-Core Version:    0.7.0.1
 */