package com.tencent.mm.plugin.emoji.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BaseEmojiStoreUI$b
  implements MenuItem.OnMenuItemClickListener
{
  private BaseEmojiStoreUI$b(BaseEmojiStoreUI paramBaseEmojiStoreUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(108788);
    this.pec.finish();
    AppMethodBeat.o(108788);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI.b
 * JD-Core Version:    0.7.0.1
 */