package com.tencent.mm.plugin.account.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

final class LoginPasswordUI$3
  implements TextWatcher
{
  LoginPasswordUI$3(LoginPasswordUI paramLoginPasswordUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    if (this.fnq.fmq.getText().toString().length() > 0)
    {
      this.fnq.fmr.setEnabled(true);
      return;
    }
    this.fnq.fmr.setEnabled(false);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginPasswordUI.3
 * JD-Core Version:    0.7.0.1
 */