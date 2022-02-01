package com.tencent.mm.plugin.emoji.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class EmojiMineUI$2
  implements MenuItem.OnMenuItemClickListener
{
  EmojiMineUI$2(EmojiMineUI paramEmojiMineUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(108935);
    this.xSy.finish();
    AppMethodBeat.o(108935);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiMineUI.2
 * JD-Core Version:    0.7.0.1
 */