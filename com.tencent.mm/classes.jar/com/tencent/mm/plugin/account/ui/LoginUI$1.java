package com.tencent.mm.plugin.account.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LoginUI$1
  implements TextWatcher
{
  LoginUI$1(LoginUI paramLoginUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(125026);
    LoginUI.a(this.gFf);
    AppMethodBeat.o(125026);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginUI.1
 * JD-Core Version:    0.7.0.1
 */