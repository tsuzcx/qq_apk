package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.emoji.ui.EmojiMineUI;

final class a$5
  implements MenuItem.OnMenuItemClickListener
{
  a$5(a parama) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new Intent();
    paramMenuItem.setClass(this.jgg.thisActivity(), EmojiMineUI.class);
    this.jgg.startActivity(paramMenuItem);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.a.5
 * JD-Core Version:    0.7.0.1
 */