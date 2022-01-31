package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.ipcall.b;
import com.tencent.mm.pluginsdk.m;

final class IPCallAddressUI$2
  implements MenuItem.OnMenuItemClickListener
{
  IPCallAddressUI$2(IPCallAddressUI paramIPCallAddressUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if (IPCallAddressUI.b(this.luB) == 1)
    {
      b.eUR.q(new Intent(), this.luB);
      return true;
    }
    this.luB.finish();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallAddressUI.2
 * JD-Core Version:    0.7.0.1
 */