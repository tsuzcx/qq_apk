package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hr;
import com.tencent.mm.g.a.hr.b;
import com.tencent.mm.plugin.luckymoney.model.k;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.sdk.platformtools.ab;

final class LuckyMoneyDetailUI$20
  implements Runnable
{
  LuckyMoneyDetailUI$20(LuckyMoneyDetailUI paramLuckyMoneyDetailUI, hr paramhr, k paramk) {}
  
  public final void run()
  {
    AppMethodBeat.i(42669);
    if (this.orR.cwP.cwR)
    {
      ab.i("MicroMsg.LuckyMoneyDetailUI", "Get res Ok, path=" + this.orR.cwP.cwS);
      this.otz.getContext();
      x.n(LuckyMoneyDetailUI.N(this.otz), this.orR.cwP.cwS);
      AppMethodBeat.o(42669);
      return;
    }
    ab.i("MicroMsg.LuckyMoneyDetailUI", "Get res fail & load from url.");
    x.b(LuckyMoneyDetailUI.N(this.otz), this.orS.ont, this.orS.onN);
    AppMethodBeat.o(42669);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.20
 * JD-Core Version:    0.7.0.1
 */