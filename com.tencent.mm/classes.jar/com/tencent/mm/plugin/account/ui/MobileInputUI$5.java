package com.tencent.mm.plugin.account.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.normsg.a.b;

final class MobileInputUI$5
  implements TextWatcher
{
  MobileInputUI$5(MobileInputUI paramMobileInputUI, boolean[] paramArrayOfBoolean) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(125164);
    this.gGb.gFP.setEnabled(this.gGb.arB());
    AppMethodBeat.o(125164);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(125165);
    if (this.gGc[0] != 0)
    {
      this.gGc[0] = false;
      if (MobileInputUI.e(this.gGb)) {
        b.pgQ.VV("ie_reg_eu");
      }
      if (MobileInputUI.f(this.gGb)) {
        b.pgQ.VV("ie_login");
      }
    }
    if (MobileInputUI.e(this.gGb)) {
      b.pgQ.VW("ie_reg_eu");
    }
    if (MobileInputUI.f(this.gGb)) {
      b.pgQ.VW("ie_login");
    }
    AppMethodBeat.o(125165);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileInputUI.5
 * JD-Core Version:    0.7.0.1
 */