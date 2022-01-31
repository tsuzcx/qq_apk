package com.tencent.mm.plugin.exdevice.ui;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.j;
import com.tencent.mm.plugin.sport.a.d;
import com.tencent.mm.ui.base.n.d;

final class ExdeviceRankInfoUI$20
  implements n.d
{
  ExdeviceRankInfoUI$20(ExdeviceRankInfoUI paramExdeviceRankInfoUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(20158);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(20158);
      return;
      d.kS(16);
      ExdeviceRankInfoUI.m(this.lPt);
      AppMethodBeat.o(20158);
      return;
      d.kS(15);
      ExdeviceRankInfoUI.n(this.lPt);
      AppMethodBeat.o(20158);
      return;
      d.kS(7);
      ExdeviceRankInfoUI.o(this.lPt);
      AppMethodBeat.o(20158);
      return;
      d.kS(36);
      paramMenuItem = new AppBrandStatObject();
      paramMenuItem.scene = 1063;
      ((j)g.E(j.class)).a(null, "gh_1f9ebf140e39@app", null, 0, 0, null, paramMenuItem);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.20
 * JD-Core Version:    0.7.0.1
 */