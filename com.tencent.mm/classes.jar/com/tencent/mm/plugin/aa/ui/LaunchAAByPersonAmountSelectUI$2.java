package com.tencent.mm.plugin.aa.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h;
import java.util.Map;

final class LaunchAAByPersonAmountSelectUI$2
  implements MenuItem.OnMenuItemClickListener
{
  LaunchAAByPersonAmountSelectUI$2(LaunchAAByPersonAmountSelectUI paramLaunchAAByPersonAmountSelectUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if ((LaunchAAByPersonAmountSelectUI.c(this.eYG) != null) && (LaunchAAByPersonAmountSelectUI.c(this.eYG).size() > 0)) {
      h.a(this.eYG, this.eYG.getString(a.i.aa_select_contact_back_confirm), null, this.eYG.getString(a.i.aa_select_contact_save), this.eYG.getString(a.i.aa_select_contact_not_save), false, new LaunchAAByPersonAmountSelectUI.2.1(this), new LaunchAAByPersonAmountSelectUI.2.2(this));
    }
    for (;;)
    {
      return true;
      this.eYG.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI.2
 * JD-Core Version:    0.7.0.1
 */