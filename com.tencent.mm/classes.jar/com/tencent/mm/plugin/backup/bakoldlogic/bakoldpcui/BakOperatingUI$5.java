package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

final class BakOperatingUI$5
  implements MenuItem.OnMenuItemClickListener
{
  BakOperatingUI$5(BakOperatingUI paramBakOperatingUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if (BakOperatingUI.a(this.hPc))
    {
      BakOperatingUI.e(this.hPc);
      return false;
    }
    BakOperatingUI.b(this.hPc);
    BakOperatingUI.f(this.hPc);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakOperatingUI.5
 * JD-Core Version:    0.7.0.1
 */