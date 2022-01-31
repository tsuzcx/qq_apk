package com.tencent.mm.plugin.emoji.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class EmojiSortUI$1
  implements MenuItem.OnMenuItemClickListener
{
  EmojiSortUI$1(EmojiSortUI paramEmojiSortUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(53408);
    this.lmp.finish();
    AppMethodBeat.o(53408);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiSortUI.1
 * JD-Core Version:    0.7.0.1
 */