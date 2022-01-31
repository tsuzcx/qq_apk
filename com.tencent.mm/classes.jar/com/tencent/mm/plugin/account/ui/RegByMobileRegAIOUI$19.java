package com.tencent.mm.plugin.account.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.normsg.a.b;
import com.tencent.mm.sdk.platformtools.av;

final class RegByMobileRegAIOUI$19
  implements TextWatcher
{
  private av gIk;
  
  RegByMobileRegAIOUI$19(RegByMobileRegAIOUI paramRegByMobileRegAIOUI, boolean[] paramArrayOfBoolean)
  {
    AppMethodBeat.i(152599);
    this.gIk = new av();
    AppMethodBeat.o(152599);
  }
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(152600);
    RegByMobileRegAIOUI.b(this.gIh);
    AppMethodBeat.o(152600);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(152601);
    if (this.gIl[0] != 0)
    {
      this.gIl[0] = false;
      b.pgQ.VV("ie_reg");
    }
    b.pgQ.VW("ie_reg");
    AppMethodBeat.o(152601);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.19
 * JD-Core Version:    0.7.0.1
 */