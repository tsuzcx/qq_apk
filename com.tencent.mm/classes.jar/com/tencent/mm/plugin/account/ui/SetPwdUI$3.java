package com.tencent.mm.plugin.account.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

final class SetPwdUI$3
  implements MenuItem.OnMenuItemClickListener
{
  SetPwdUI$3(SetPwdUI paramSetPwdUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(125568);
    paramMenuItem = this.gKd;
    if ((paramMenuItem.arQ()) && (paramMenuItem.gKc))
    {
      ab.d("MicroMsg.SetPwdUI", "cpan settpassword cancel 11868 1");
      h.qsU.e(11868, new Object[] { Integer.valueOf(1) });
    }
    paramMenuItem.hideVKB();
    paramMenuItem.setResult(0);
    paramMenuItem.finish();
    AppMethodBeat.o(125568);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.SetPwdUI.3
 * JD-Core Version:    0.7.0.1
 */