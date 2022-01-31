package com.tencent.mm.plugin.bottle.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

final class BottleBeachUI$2
  implements MenuItem.OnMenuItemClickListener
{
  BottleBeachUI$2(BottleBeachUI paramBottleBeachUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new Intent(this.hZb, BottlePersonalInfoUI.class);
    paramMenuItem.putExtra("is_allow_set", false);
    this.hZb.startActivity(paramMenuItem);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.BottleBeachUI.2
 * JD-Core Version:    0.7.0.1
 */