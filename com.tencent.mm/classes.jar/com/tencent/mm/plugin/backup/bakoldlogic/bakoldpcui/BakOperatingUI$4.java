package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

final class BakOperatingUI$4
  implements MenuItem.OnMenuItemClickListener
{
  BakOperatingUI$4(BakOperatingUI paramBakOperatingUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if (BakOperatingUI.a(this.hPc)) {
      return true;
    }
    BakOperatingUI.b(this.hPc);
    BakOperatingUI.d(this.hPc);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakOperatingUI.4
 * JD-Core Version:    0.7.0.1
 */