package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.a.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.c.h;

final class LuckyMoneyPrepareUI$20
  implements h
{
  LuckyMoneyPrepareUI$20(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI) {}
  
  public final void br(int paramInt, String paramString)
  {
    AppMethodBeat.i(65848);
    ac.i("MicroMsg.LuckyMoneyPrepareUI", "onSceneEnd() scene:NetScenePrepareLuckyMoney JumpRemind:onNext()");
    if ((bs.jl(paramInt, 2)) && (bs.lr(paramString, "requestwxhb")))
    {
      LuckyMoneyPrepareUI.z(this.uyl);
      AppMethodBeat.o(65848);
      return;
    }
    if (bs.jl(paramInt, 1)) {
      a.b(this.uyl, paramString, 0, true);
    }
    AppMethodBeat.o(65848);
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(65849);
    ac.i("MicroMsg.LuckyMoneyPrepareUI", "onSceneEnd() scene:NetScenePrepareLuckyMoney JumpRemind:onCancel()");
    AppMethodBeat.o(65849);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.20
 * JD-Core Version:    0.7.0.1
 */