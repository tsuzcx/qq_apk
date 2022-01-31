package com.tencent.mm.plugin.emoji.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.c.j;
import com.tencent.mm.plugin.report.service.h;

final class EmojiStoreDetailUI$21
  implements j
{
  EmojiStoreDetailUI$21(EmojiStoreDetailUI paramEmojiStoreDetailUI) {}
  
  public final void gX(long paramLong)
  {
    AppMethodBeat.i(53438);
    h.qsU.kvStat(10930, EmojiStoreDetailUI.a(this.lnA) + "," + paramLong);
    AppMethodBeat.o(53438);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.21
 * JD-Core Version:    0.7.0.1
 */