package com.tencent.mm.plugin.emoji.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

final class EmojiStoreDetailUI$6
  implements MenuItem.OnMenuItemClickListener
{
  EmojiStoreDetailUI$6(EmojiStoreDetailUI paramEmojiStoreDetailUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(176186);
    ac.d("MicroMsg.emoji.EmojiStoreDetailUI", "on shard click.");
    EmojiStoreDetailUI.r(this.phq);
    AppMethodBeat.o(176186);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.6
 * JD-Core Version:    0.7.0.1
 */