package com.tencent.mm.plugin.honey_pay.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.honey_pay.a.d;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.protocal.protobuf.ajl;
import com.tencent.mm.wallet_core.c.p.a;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;

final class HoneyPayCheckPwdUI$2
  implements p.a
{
  HoneyPayCheckPwdUI$2(HoneyPayCheckPwdUI paramHoneyPayCheckPwdUI, d paramd) {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(41835);
    if (this.nIJ.nHe.xaY != null) {
      c.a(this.nII, this.nIJ.nHe.xaY, new HoneyPayCheckPwdUI.2.1(this));
    }
    for (;;)
    {
      this.nII.hideProgress();
      AppMethodBeat.o(41835);
      return;
      if (HoneyPayCheckPwdUI.e(this.nII) != null) {
        HoneyPayCheckPwdUI.e(this.nII).cfK();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI.2
 * JD-Core Version:    0.7.0.1
 */