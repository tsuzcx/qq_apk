package com.tencent.mm.plugin.account.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RegByMobileRegAIOUI$21
  implements TextWatcher
{
  RegByMobileRegAIOUI$21(RegByMobileRegAIOUI paramRegByMobileRegAIOUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(125369);
    RegByMobileRegAIOUI.b(this.gIh);
    AppMethodBeat.o(125369);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(125370);
    AppMethodBeat.o(125370);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.21
 * JD-Core Version:    0.7.0.1
 */