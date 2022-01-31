package com.tencent.mm.plugin.account.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;

final class MobileInputUI$7
  implements TextWatcher
{
  MobileInputUI$7(MobileInputUI paramMobileInputUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    this.foH.fou.setEnabled(MobileInputUI.f(this.foH));
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileInputUI.7
 * JD-Core Version:    0.7.0.1
 */