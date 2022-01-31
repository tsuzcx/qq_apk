package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.a.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.g;

final class LuckyMoneyPrepareUI$20
  implements g
{
  LuckyMoneyPrepareUI$20(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI) {}
  
  public final void aQ(int paramInt, String paramString)
  {
    AppMethodBeat.i(142073);
    ab.i("MicroMsg.LuckyMoneyPrepareUI", "onSceneEnd() scene:NetScenePrepareLuckyMoney JumpRemind:onNext()");
    if ((bo.hl(paramInt, 2)) && (bo.isEqual(paramString, "requestwxhb")))
    {
      LuckyMoneyPrepareUI.x(this.owL);
      AppMethodBeat.o(142073);
      return;
    }
    if (bo.hl(paramInt, 1)) {
      a.b(this.owL, paramString, 0, true);
    }
    AppMethodBeat.o(142073);
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(142074);
    ab.i("MicroMsg.LuckyMoneyPrepareUI", "onSceneEnd() scene:NetScenePrepareLuckyMoney JumpRemind:onCancel()");
    AppMethodBeat.o(142074);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.20
 * JD-Core Version:    0.7.0.1
 */