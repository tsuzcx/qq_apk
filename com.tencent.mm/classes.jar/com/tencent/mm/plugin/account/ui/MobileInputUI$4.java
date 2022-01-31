package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.normsg.a.b;

final class MobileInputUI$4
  implements View.OnFocusChangeListener
{
  MobileInputUI$4(MobileInputUI paramMobileInputUI, boolean[] paramArrayOfBoolean) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(125163);
    if (paramBoolean)
    {
      this.gGc[0] = true;
      AppMethodBeat.o(125163);
      return;
    }
    if (MobileInputUI.e(this.gGb)) {
      b.pgQ.VX("ie_reg_eu");
    }
    if (MobileInputUI.f(this.gGb)) {
      b.pgQ.VX("ie_login");
    }
    AppMethodBeat.o(125163);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileInputUI.4
 * JD-Core Version:    0.7.0.1
 */