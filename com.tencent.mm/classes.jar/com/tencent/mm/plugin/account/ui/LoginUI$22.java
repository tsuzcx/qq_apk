package com.tencent.mm.plugin.account.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.normsg.a.b;

final class LoginUI$22
  implements TextWatcher
{
  LoginUI$22(LoginUI paramLoginUI) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(128223);
    if (this.iSO.iSM[0] != 0)
    {
      this.iSO.iSM[0] = false;
      b.vor.aop("ie_login_id");
    }
    b.vor.aoq("ie_login_id");
    AppMethodBeat.o(128223);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginUI.22
 * JD-Core Version:    0.7.0.1
 */