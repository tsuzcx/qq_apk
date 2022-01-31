package com.tencent.mm.plugin.honey_pay.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.wallet_core.c.p.a;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;

final class HoneyPayCheckPwdUI$5
  implements p.a
{
  HoneyPayCheckPwdUI$5(HoneyPayCheckPwdUI paramHoneyPayCheckPwdUI) {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(41839);
    if (HoneyPayCheckPwdUI.e(this.nII) != null) {
      HoneyPayCheckPwdUI.e(this.nII).cfK();
    }
    this.nII.hideProgress();
    AppMethodBeat.o(41839);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI.5
 * JD-Core Version:    0.7.0.1
 */