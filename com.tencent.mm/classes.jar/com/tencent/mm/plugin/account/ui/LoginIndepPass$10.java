package com.tencent.mm.plugin.account.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LoginIndepPass$10
  implements TextWatcher
{
  LoginIndepPass$10(LoginIndepPass paramLoginIndepPass) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(124976);
    LoginIndepPass.b(this.gEE);
    AppMethodBeat.o(124976);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginIndepPass.10
 * JD-Core Version:    0.7.0.1
 */