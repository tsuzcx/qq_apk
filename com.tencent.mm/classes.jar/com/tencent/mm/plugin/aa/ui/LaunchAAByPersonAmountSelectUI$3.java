package com.tencent.mm.plugin.aa.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.Map;

final class LaunchAAByPersonAmountSelectUI$3
  implements MenuItem.OnMenuItemClickListener
{
  LaunchAAByPersonAmountSelectUI$3(LaunchAAByPersonAmountSelectUI paramLaunchAAByPersonAmountSelectUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if ((LaunchAAByPersonAmountSelectUI.e(this.eYG) > 0) && (LaunchAAByPersonAmountSelectUI.c(this.eYG) != null) && (LaunchAAByPersonAmountSelectUI.c(this.eYG).size() > LaunchAAByPersonAmountSelectUI.e(this.eYG)))
    {
      com.tencent.mm.ui.base.h.b(this.eYG.mController.uMN, this.eYG.getString(a.i.launch_aa_by_person_number_exceed_limit_alert, new Object[] { Integer.valueOf(LaunchAAByPersonAmountSelectUI.e(this.eYG)) }), "", true);
      com.tencent.mm.plugin.report.service.h.nFQ.f(13722, new Object[] { Integer.valueOf(8) });
      return true;
    }
    LaunchAAByPersonAmountSelectUI.d(this.eYG);
    com.tencent.mm.plugin.report.service.h.nFQ.f(13721, new Object[] { Integer.valueOf(3), Integer.valueOf(4) });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI.3
 * JD-Core Version:    0.7.0.1
 */