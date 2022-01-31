package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

final class IPCallCountryCodeSelectUI$4
  implements MenuItem.OnMenuItemClickListener
{
  IPCallCountryCodeSelectUI$4(IPCallCountryCodeSelectUI paramIPCallCountryCodeSelectUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    this.lvu.XM();
    paramMenuItem = new Intent();
    paramMenuItem.putExtra("country_name", IPCallCountryCodeSelectUI.d(this.lvu));
    paramMenuItem.putExtra("couttry_code", IPCallCountryCodeSelectUI.e(this.lvu));
    this.lvu.setResult(100, paramMenuItem);
    this.lvu.finish();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallCountryCodeSelectUI.4
 * JD-Core Version:    0.7.0.1
 */