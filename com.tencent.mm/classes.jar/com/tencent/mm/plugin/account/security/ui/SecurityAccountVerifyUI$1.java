package com.tencent.mm.plugin.account.security.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

final class SecurityAccountVerifyUI$1
  implements TextWatcher
{
  SecurityAccountVerifyUI$1(SecurityAccountVerifyUI paramSecurityAccountVerifyUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(125597);
    if ((paramEditable != null) && (!Util.isNullOrNil(paramEditable.toString()))) {}
    for (boolean bool = true;; bool = false)
    {
      this.pYF.enableOptionMenu(bool);
      AppMethodBeat.o(125597);
      return;
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.SecurityAccountVerifyUI.1
 * JD-Core Version:    0.7.0.1
 */