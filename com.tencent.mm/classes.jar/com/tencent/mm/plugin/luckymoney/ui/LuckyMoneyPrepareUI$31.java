package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.k;
import com.tencent.mm.api.t.a;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.d;

final class LuckyMoneyPrepareUI$31
  implements t.a
{
  LuckyMoneyPrepareUI$31(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI) {}
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(142083);
    ab.i("MicroMsg.LuckyMoneyPrepareUI", "[onSelectedEmoji] emojiInfo:%s", new Object[] { paramk });
    LuckyMoneyPrepareUI.a(this.owL, i.getEmojiStorageMgr().yNn.asP(paramk.Al()));
    LuckyMoneyPrepareUI.b(this.owL, LuckyMoneyPrepareUI.C(this.owL));
    LuckyMoneyPrepareUI.a(this.owL);
    AppMethodBeat.o(142083);
  }
  
  public final void onHide()
  {
    AppMethodBeat.i(156738);
    LuckyMoneyPrepareUI.a(this.owL);
    AppMethodBeat.o(156738);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.31
 * JD-Core Version:    0.7.0.1
 */