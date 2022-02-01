package com.tencent.mm.plugin.account.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.normsg.a.b;
import com.tencent.mm.sdk.platformtools.ba;

final class RegByMobileRegAIOUI$19
  implements TextWatcher
{
  private ba jpn;
  
  RegByMobileRegAIOUI$19(RegByMobileRegAIOUI paramRegByMobileRegAIOUI, boolean[] paramArrayOfBoolean)
  {
    AppMethodBeat.i(128531);
    this.jpn = new ba();
    AppMethodBeat.o(128531);
  }
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(128532);
    RegByMobileRegAIOUI.b(this.jpj);
    AppMethodBeat.o(128532);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(128533);
    if (this.jpo[0] != 0)
    {
      this.jpo[0] = false;
      b.wtJ.atp("ie_reg");
    }
    b.wtJ.atq("ie_reg");
    AppMethodBeat.o(128533);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.19
 * JD-Core Version:    0.7.0.1
 */