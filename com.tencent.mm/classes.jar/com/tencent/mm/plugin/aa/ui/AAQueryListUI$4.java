package com.tencent.mm.plugin.aa.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.widget.a.d;

final class AAQueryListUI$4
  implements MenuItem.OnMenuItemClickListener
{
  AAQueryListUI$4(AAQueryListUI paramAAQueryListUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new d(this.eXG, 1, false);
    paramMenuItem.phH = new AAQueryListUI.4.1(this);
    paramMenuItem.phI = new AAQueryListUI.4.2(this);
    paramMenuItem.cfU();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AAQueryListUI.4
 * JD-Core Version:    0.7.0.1
 */