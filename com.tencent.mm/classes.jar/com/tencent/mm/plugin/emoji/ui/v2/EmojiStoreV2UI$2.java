package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.emoji.ui.EmojiMineUI;

final class EmojiStoreV2UI$2
  implements MenuItem.OnMenuItemClickListener
{
  EmojiStoreV2UI$2(EmojiStoreV2UI paramEmojiStoreV2UI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new Intent();
    paramMenuItem.putExtra("10931", 1);
    paramMenuItem.setClass(this.jjl, EmojiMineUI.class);
    this.jjl.startActivity(paramMenuItem);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2UI.2
 * JD-Core Version:    0.7.0.1
 */