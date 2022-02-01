package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.p;
import com.tencent.mm.api.z.a;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.f;

final class LuckyMoneyPrepareUI$31
  implements z.a
{
  LuckyMoneyPrepareUI$31(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI) {}
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(65861);
    ad.i("MicroMsg.LuckyMoneyPrepareUI", "[onSelectedEmoji] emojiInfo:%s", new Object[] { paramp });
    LuckyMoneyPrepareUI.a(this.vAO, k.getEmojiStorageMgr().ILn.aUK(paramp.Lb()));
    LuckyMoneyPrepareUI.b(this.vAO, LuckyMoneyPrepareUI.F(this.vAO));
    LuckyMoneyPrepareUI.a(this.vAO);
    AppMethodBeat.o(65861);
  }
  
  public final void onHide()
  {
    AppMethodBeat.i(221333);
    LuckyMoneyPrepareUI.a(this.vAO);
    AppMethodBeat.o(221333);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.31
 * JD-Core Version:    0.7.0.1
 */