package com.tencent.mm.plugin.bottle.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

final class BottleConversationUI$10
  implements MenuItem.OnMenuItemClickListener
{
  BottleConversationUI$10(BottleConversationUI paramBottleConversationUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new Intent();
    paramMenuItem.setClass(this.hZr, BottleBeachUI.class);
    this.hZr.startActivity(paramMenuItem);
    this.hZr.finish();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.BottleConversationUI.10
 * JD-Core Version:    0.7.0.1
 */