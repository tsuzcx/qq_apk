package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.a.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.c.h;

final class LuckyMoneyPrepareUI$20
  implements h
{
  LuckyMoneyPrepareUI$20(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI) {}
  
  public final void bv(int paramInt, String paramString)
  {
    AppMethodBeat.i(65848);
    ad.i("MicroMsg.LuckyMoneyPrepareUI", "onSceneEnd() scene:NetScenePrepareLuckyMoney JumpRemind:onNext()");
    if ((bt.jx(paramInt, 2)) && (bt.lQ(paramString, "requestwxhb")))
    {
      LuckyMoneyPrepareUI.z(this.vAO);
      AppMethodBeat.o(65848);
      return;
    }
    if (bt.jx(paramInt, 1)) {
      a.b(this.vAO, paramString, 0, true);
    }
    AppMethodBeat.o(65848);
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(65849);
    ad.i("MicroMsg.LuckyMoneyPrepareUI", "onSceneEnd() scene:NetScenePrepareLuckyMoney JumpRemind:onCancel()");
    AppMethodBeat.o(65849);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.20
 * JD-Core Version:    0.7.0.1
 */