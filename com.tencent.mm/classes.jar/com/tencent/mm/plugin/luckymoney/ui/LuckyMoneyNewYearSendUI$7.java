package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.k;
import com.tencent.mm.api.t.a;
import com.tencent.mm.sdk.platformtools.ab;

final class LuckyMoneyNewYearSendUI$7
  implements t.a
{
  LuckyMoneyNewYearSendUI$7(LuckyMoneyNewYearSendUI paramLuckyMoneyNewYearSendUI) {}
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(42814);
    ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "[onSelectedEmoji] emojiInfo:%s", new Object[] { paramk });
    LuckyMoneyNewYearSendUI.a(this.ovl, paramk);
    LuckyMoneyNewYearSendUI.a(this.ovl);
    AppMethodBeat.o(42814);
  }
  
  public final void onHide()
  {
    AppMethodBeat.i(156737);
    LuckyMoneyNewYearSendUI.a(this.ovl);
    AppMethodBeat.o(156737);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUI.7
 * JD-Core Version:    0.7.0.1
 */