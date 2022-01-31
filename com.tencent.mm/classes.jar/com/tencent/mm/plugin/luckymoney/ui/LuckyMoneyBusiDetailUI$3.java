package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hr;
import com.tencent.mm.g.a.hr.b;
import com.tencent.mm.plugin.luckymoney.model.k;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class LuckyMoneyBusiDetailUI$3
  implements Runnable
{
  LuckyMoneyBusiDetailUI$3(LuckyMoneyBusiDetailUI paramLuckyMoneyBusiDetailUI, hr paramhr, k paramk) {}
  
  public final void run()
  {
    AppMethodBeat.i(42585);
    if (this.orR.cwP.cwR)
    {
      ab.i("MicroMsg.LuckyMoneyDetailUI", "Get res Ok, path=" + this.orR.cwP.cwS);
      this.orQ.getContext();
      x.n(LuckyMoneyBusiDetailUI.i(this.orQ), this.orR.cwP.cwS);
      AppMethodBeat.o(42585);
      return;
    }
    ab.i("MicroMsg.LuckyMoneyDetailUI", "Get res fail & load from url.");
    if (!bo.isNullOrNil(this.orS.ont)) {
      x.b(LuckyMoneyBusiDetailUI.i(this.orQ), this.orS.ont, this.orS.onN);
    }
    AppMethodBeat.o(42585);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI.3
 * JD-Core Version:    0.7.0.1
 */