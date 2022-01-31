package com.tencent.mm.plugin.account.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;

final class LoginSmsUI$2
  implements TextWatcher
{
  LoginSmsUI$2(LoginSmsUI paramLoginSmsUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    if (this.fnx.fmP.getText().toString().length() > 0)
    {
      this.fnx.fmr.setEnabled(true);
      return;
    }
    this.fnx.fmr.setEnabled(false);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginSmsUI.2
 * JD-Core Version:    0.7.0.1
 */