package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

final class ExdeviceLikeUI$1
  implements MenuItem.OnMenuItemClickListener
{
  ExdeviceLikeUI$1(ExdeviceLikeUI paramExdeviceLikeUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new Intent(this.jDq, ExdeviceRankInfoUI.class);
    paramMenuItem.putExtra("app_username", ExdeviceLikeUI.a(this.jDq));
    paramMenuItem.putExtra("rank_id", "#");
    paramMenuItem.putExtra("key_is_latest", true);
    paramMenuItem.putExtra("device_type", 1);
    this.jDq.startActivity(paramMenuItem);
    this.jDq.finish();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceLikeUI.1
 * JD-Core Version:    0.7.0.1
 */