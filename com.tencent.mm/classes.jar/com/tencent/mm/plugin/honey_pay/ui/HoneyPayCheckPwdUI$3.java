package com.tencent.mm.plugin.honey_pay.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.honey_pay.a.d;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.protocal.protobuf.ajl;
import com.tencent.mm.wallet_core.c.p.a;

final class HoneyPayCheckPwdUI$3
  implements p.a
{
  HoneyPayCheckPwdUI$3(HoneyPayCheckPwdUI paramHoneyPayCheckPwdUI, d paramd) {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(41837);
    HoneyPayCheckPwdUI.a(this.nII, this.nIJ.nHe.xaX);
    if (this.nIJ.nHe.xaY != null)
    {
      c.a(this.nII, this.nIJ.nHe.xaY, new HoneyPayCheckPwdUI.3.1(this));
      this.nII.hideProgress();
      AppMethodBeat.o(41837);
      return;
    }
    HoneyPayCheckPwdUI.d(this.nII);
    AppMethodBeat.o(41837);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI.3
 * JD-Core Version:    0.7.0.1
 */