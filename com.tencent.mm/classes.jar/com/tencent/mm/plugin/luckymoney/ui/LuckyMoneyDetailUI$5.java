package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.p;
import com.tencent.mm.api.z.a;
import com.tencent.mm.sdk.platformtools.ad;

final class LuckyMoneyDetailUI$5
  implements z.a
{
  LuckyMoneyDetailUI$5(LuckyMoneyDetailUI paramLuckyMoneyDetailUI) {}
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(163716);
    ad.i("MicroMsg.LuckyMoneyDetailUI", "[onSelectedEmoji] emojiInfo:%s", new Object[] { paramp });
    LuckyMoneyDetailUI.a(this.tme, paramp.JS());
    LuckyMoneyDetailUI.A(this.tme);
    LuckyMoneyDetailUI.s(this.tme);
    AppMethodBeat.o(163716);
  }
  
  public final void onHide()
  {
    AppMethodBeat.i(201266);
    LuckyMoneyDetailUI.s(this.tme);
    AppMethodBeat.o(201266);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.5
 * JD-Core Version:    0.7.0.1
 */