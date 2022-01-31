package com.tencent.mm.plugin.account.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

final class DisasterUI$2
  implements MenuItem.OnMenuItemClickListener
{
  DisasterUI$2(DisasterUI paramDisasterUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(124755);
    h.qsU.e(13939, new Object[] { Integer.valueOf(3) });
    ab.i("MicroMsg.DisasterUI", "summerdiz back");
    this.gCF.finish();
    AppMethodBeat.o(124755);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.DisasterUI.2
 * JD-Core Version:    0.7.0.1
 */