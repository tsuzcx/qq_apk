package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.k;
import com.tencent.mm.api.t.a;
import com.tencent.mm.sdk.platformtools.ab;

final class LuckyMoneyDetailUI$11
  implements t.a
{
  LuckyMoneyDetailUI$11(LuckyMoneyDetailUI paramLuckyMoneyDetailUI) {}
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(42657);
    ab.i("MicroMsg.LuckyMoneyDetailUI", "[onSelectedEmoji] emojiInfo:%s", new Object[] { paramk });
    LuckyMoneyDetailUI.a(this.otz, paramk.Al());
    LuckyMoneyDetailUI.B(this.otz);
    LuckyMoneyDetailUI.s(this.otz);
    AppMethodBeat.o(42657);
  }
  
  public final void onHide()
  {
    AppMethodBeat.i(156736);
    LuckyMoneyDetailUI.s(this.otz);
    AppMethodBeat.o(156736);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.11
 * JD-Core Version:    0.7.0.1
 */