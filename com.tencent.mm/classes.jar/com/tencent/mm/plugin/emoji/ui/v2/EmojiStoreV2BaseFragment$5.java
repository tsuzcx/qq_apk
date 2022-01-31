package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.ui.EmojiMineUI;

final class EmojiStoreV2BaseFragment$5
  implements MenuItem.OnMenuItemClickListener
{
  EmojiStoreV2BaseFragment$5(EmojiStoreV2BaseFragment paramEmojiStoreV2BaseFragment) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(53576);
    paramMenuItem = new Intent();
    paramMenuItem.setClass(this.loZ.thisActivity(), EmojiMineUI.class);
    this.loZ.startActivity(paramMenuItem);
    AppMethodBeat.o(53576);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment.5
 * JD-Core Version:    0.7.0.1
 */