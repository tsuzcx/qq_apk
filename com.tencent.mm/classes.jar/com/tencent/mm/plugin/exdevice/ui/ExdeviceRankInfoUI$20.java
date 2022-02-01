package com.tencent.mm.plugin.exdevice.ui;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.sport.a.d;
import com.tencent.mm.ui.base.u.i;

final class ExdeviceRankInfoUI$20
  implements u.i
{
  ExdeviceRankInfoUI$20(ExdeviceRankInfoUI paramExdeviceRankInfoUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(24230);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(24230);
      return;
      d.rG(16);
      ExdeviceRankInfoUI.m(this.yCI);
      AppMethodBeat.o(24230);
      return;
      d.rG(15);
      ExdeviceRankInfoUI.n(this.yCI);
      AppMethodBeat.o(24230);
      return;
      d.rG(7);
      ExdeviceRankInfoUI.o(this.yCI);
      AppMethodBeat.o(24230);
      return;
      d.rG(36);
      paramMenuItem = new AppBrandStatObject();
      paramMenuItem.scene = 1063;
      ((t)h.ax(t.class)).a(null, "gh_1f9ebf140e39@app", null, 0, 0, null, paramMenuItem);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.20
 * JD-Core Version:    0.7.0.1
 */