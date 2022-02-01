package com.tencent.mm.plugin.emoji.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class EmojiMineUI$1
  implements MenuItem.OnMenuItemClickListener
{
  EmojiMineUI$1(EmojiMineUI paramEmojiMineUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(108934);
    this.pJw.finish();
    AppMethodBeat.o(108934);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiMineUI.1
 * JD-Core Version:    0.7.0.1
 */