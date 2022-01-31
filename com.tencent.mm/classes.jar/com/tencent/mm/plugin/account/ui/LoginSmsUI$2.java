package com.tencent.mm.plugin.account.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;

final class LoginSmsUI$2
  implements TextWatcher
{
  LoginSmsUI$2(LoginSmsUI paramLoginSmsUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(125016);
    if (this.gEQ.gEj.getText().toString().length() > 0)
    {
      this.gEQ.gDL.setEnabled(true);
      AppMethodBeat.o(125016);
      return;
    }
    this.gEQ.gDL.setEnabled(false);
    AppMethodBeat.o(125016);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginSmsUI.2
 * JD-Core Version:    0.7.0.1
 */