package com.tencent.mm.plugin.emoji.ui.v2;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class EmojiStoreV2RewardUI$7
  implements MenuItem.OnMenuItemClickListener
{
  EmojiStoreV2RewardUI$7(EmojiStoreV2RewardUI paramEmojiStoreV2RewardUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(109276);
    this.rlF.onBackPressed();
    AppMethodBeat.o(109276);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI.7
 * JD-Core Version:    0.7.0.1
 */