package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.aq;
import com.tencent.mm.plugin.wallet_core.id_verify.util.a.a;
import com.tencent.mm.sdk.platformtools.ab;

final class LuckyMoneyNewYearReceiveUI$6
  implements a.a
{
  LuckyMoneyNewYearReceiveUI$6(LuckyMoneyNewYearReceiveUI paramLuckyMoneyNewYearReceiveUI, aq paramaq) {}
  
  public final boolean run(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(42789);
    ab.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "showDisclaimerDialog resultCode=" + paramInt1 + ";errCode=" + paramInt2 + ";errMsg=" + paramString + ";hadAgree = " + paramBoolean);
    if (paramInt1 == 1) {
      this.ouD.finish();
    }
    for (;;)
    {
      AppMethodBeat.o(42789);
      return true;
      if (paramInt1 == 2) {
        LuckyMoneyNewYearReceiveUI.a(this.ouD, this.ouF.msgType, this.ouF.bWu, this.ouF.ojA, this.ouF.cMO, this.ouF.opM);
      } else if ((paramInt1 == 0) && (paramBoolean)) {
        LuckyMoneyNewYearReceiveUI.a(this.ouD, this.ouF.msgType, this.ouF.bWu, this.ouF.ojA, this.ouF.cMO, this.ouF.opM);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearReceiveUI.6
 * JD-Core Version:    0.7.0.1
 */