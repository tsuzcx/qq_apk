package com.tencent.mm.plugin.account.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import com.tencent.mm.plugin.normsg.a.b;

final class MobileInputUI$6
  implements TextWatcher
{
  MobileInputUI$6(MobileInputUI paramMobileInputUI, boolean[] paramArrayOfBoolean) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    this.foH.fou.setEnabled(MobileInputUI.f(this.foH));
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.foI[0] != 0)
    {
      this.foI[0] = false;
      b.mGK.JV("ie_reg_eu");
    }
    b.mGK.JW("ie_reg_eu");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileInputUI.6
 * JD-Core Version:    0.7.0.1
 */