package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.a.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.g;

final class LuckyMoneyNewYearSendUI$12
  implements g
{
  LuckyMoneyNewYearSendUI$12(LuckyMoneyNewYearSendUI paramLuckyMoneyNewYearSendUI) {}
  
  public final void aQ(int paramInt, String paramString)
  {
    AppMethodBeat.i(42821);
    ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "onSceneEnd() scene:NetScenePrepareNewYearLuckyMoney JumpRemind:onNext()");
    if ((bo.hl(paramInt, 2)) && (bo.isEqual(paramString, "requestwxhb")))
    {
      LuckyMoneyNewYearSendUI.w(this.ovl);
      AppMethodBeat.o(42821);
      return;
    }
    if (bo.hl(paramInt, 1)) {
      a.b(this.ovl, paramString, 0, true);
    }
    AppMethodBeat.o(42821);
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(42822);
    ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "onSceneEnd() scene:NetScenePrepareNewYearLuckyMoney JumpRemind:onCancel()");
    AppMethodBeat.o(42822);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUI.12
 * JD-Core Version:    0.7.0.1
 */