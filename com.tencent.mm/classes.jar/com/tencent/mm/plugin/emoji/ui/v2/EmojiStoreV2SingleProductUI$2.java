package com.tencent.mm.plugin.emoji.ui.v2;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class EmojiStoreV2SingleProductUI$2
  implements MenuItem.OnMenuItemClickListener
{
  EmojiStoreV2SingleProductUI$2(EmojiStoreV2SingleProductUI paramEmojiStoreV2SingleProductUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(53745);
    ab.d("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "on shard click.");
    EmojiStoreV2SingleProductUI.o(this.lrz);
    AppMethodBeat.o(53745);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI.2
 * JD-Core Version:    0.7.0.1
 */