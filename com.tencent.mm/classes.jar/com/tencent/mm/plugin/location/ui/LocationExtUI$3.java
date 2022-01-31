package com.tencent.mm.plugin.location.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

final class LocationExtUI$3
  implements MenuItem.OnMenuItemClickListener
{
  LocationExtUI$3(LocationExtUI paramLocationExtUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new Intent();
    paramMenuItem.putExtra("key_remark_result", LocationExtUI.b(this.lEO));
    paramMenuItem.putExtra("key_tags_result", LocationExtUI.a(this.lEO));
    this.lEO.setResult(-1, paramMenuItem);
    this.lEO.finish();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.LocationExtUI.3
 * JD-Core Version:    0.7.0.1
 */