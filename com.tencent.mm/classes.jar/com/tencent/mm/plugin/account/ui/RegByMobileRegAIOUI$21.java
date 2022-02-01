package com.tencent.mm.plugin.account.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.sdk.platformtools.PhoneFormater;

final class RegByMobileRegAIOUI$21
  implements TextWatcher
{
  private PhoneFormater nii;
  
  RegByMobileRegAIOUI$21(RegByMobileRegAIOUI paramRegByMobileRegAIOUI, boolean[] paramArrayOfBoolean)
  {
    AppMethodBeat.i(128531);
    this.nii = new PhoneFormater();
    AppMethodBeat.o(128531);
  }
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(128532);
    RegByMobileRegAIOUI.b(this.nic);
    AppMethodBeat.o(128532);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(128533);
    if (this.nij[0] != 0)
    {
      this.nij[0] = false;
      d.GxJ.aTh("ie_reg");
    }
    d.GxJ.aTi("ie_reg");
    AppMethodBeat.o(128533);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.21
 * JD-Core Version:    0.7.0.1
 */