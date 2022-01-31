package com.tencent.mm.plugin.exdevice.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sport.a.d;
import com.tencent.mm.sdk.platformtools.bo;

final class ExdeviceRankInfoUI$12$3
  implements Runnable
{
  ExdeviceRankInfoUI$12$3(ExdeviceRankInfoUI.12 param12) {}
  
  public final void run()
  {
    AppMethodBeat.i(20149);
    ExdeviceRankInfoUI.h(this.lPu.lPt);
    if (!bo.isNullOrNil(ExdeviceRankInfoUI.i(this.lPu.lPt))) {
      this.lPu.lPt.addIconOptionMenu(0, 2131230740, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(20148);
          d.kS(11);
          ExdeviceRankInfoUI.j(ExdeviceRankInfoUI.12.3.this.lPu.lPt);
          AppMethodBeat.o(20148);
          return true;
        }
      });
    }
    if (ExdeviceRankInfoUI.k(this.lPu.lPt) != null) {
      ExdeviceRankInfoUI.k(this.lPu.lPt).LS(ExdeviceRankInfoUI.l(this.lPu.lPt));
    }
    AppMethodBeat.o(20149);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.12.3
 * JD-Core Version:    0.7.0.1
 */