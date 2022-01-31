package com.tencent.mm.plugin.emoji.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

final class EmojiCustomUI$4
  implements MenuItem.OnMenuItemClickListener
{
  EmojiCustomUI$4(EmojiCustomUI paramEmojiCustomUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(53303);
    EmojiCustomUI.a(this.llF, EmojiCustomUI.c.llR);
    h.qsU.e(11596, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(53303);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.4
 * JD-Core Version:    0.7.0.1
 */