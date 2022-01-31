package com.tencent.mm.plugin.account.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.plugin.normsg.a.b;
import com.tencent.mm.sdk.platformtools.ar;

final class RegByMobileRegAIOUI$22
  implements TextWatcher
{
  private ar fqH = new ar();
  
  RegByMobileRegAIOUI$22(RegByMobileRegAIOUI paramRegByMobileRegAIOUI, boolean[] paramArrayOfBoolean) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    RegByMobileRegAIOUI.b(this.fqF);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.fqI[0] != 0)
    {
      this.fqI[0] = false;
      b.mGK.JV("ie_reg");
    }
    b.mGK.JW("ie_reg");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.22
 * JD-Core Version:    0.7.0.1
 */