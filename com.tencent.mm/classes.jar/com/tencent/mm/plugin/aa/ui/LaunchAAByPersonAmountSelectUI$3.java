package com.tencent.mm.plugin.aa.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

final class LaunchAAByPersonAmountSelectUI$3
  implements MenuItem.OnMenuItemClickListener
{
  LaunchAAByPersonAmountSelectUI$3(LaunchAAByPersonAmountSelectUI paramLaunchAAByPersonAmountSelectUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(40790);
    if ((LaunchAAByPersonAmountSelectUI.e(this.gqx) > 0) && (LaunchAAByPersonAmountSelectUI.c(this.gqx) != null) && (LaunchAAByPersonAmountSelectUI.c(this.gqx).size() > LaunchAAByPersonAmountSelectUI.e(this.gqx)))
    {
      com.tencent.mm.ui.base.h.b(this.gqx.getContext(), this.gqx.getString(2131301037, new Object[] { Integer.valueOf(LaunchAAByPersonAmountSelectUI.e(this.gqx)) }), "", true);
      com.tencent.mm.plugin.report.service.h.qsU.e(13722, new Object[] { Integer.valueOf(8) });
      AppMethodBeat.o(40790);
      return true;
    }
    LaunchAAByPersonAmountSelectUI.d(this.gqx);
    com.tencent.mm.plugin.report.service.h.qsU.e(13721, new Object[] { Integer.valueOf(3), Integer.valueOf(4) });
    AppMethodBeat.o(40790);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI.3
 * JD-Core Version:    0.7.0.1
 */