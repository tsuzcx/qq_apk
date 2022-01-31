package com.tencent.mm.plugin.exdevice.ui;

import android.view.MenuItem;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.ui.base.n.d;

final class ExdeviceRankInfoUI$20
  implements n.d
{
  ExdeviceRankInfoUI$20(ExdeviceRankInfoUI paramExdeviceRankInfoUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return;
    case 1: 
      com.tencent.mm.plugin.sport.b.d.jdMethod_if(16);
      ExdeviceRankInfoUI.m(this.jFV);
      return;
    case 0: 
      com.tencent.mm.plugin.sport.b.d.jdMethod_if(15);
      ExdeviceRankInfoUI.n(this.jFV);
      return;
    case 2: 
      com.tencent.mm.plugin.sport.b.d.jdMethod_if(7);
      ExdeviceRankInfoUI.o(this.jFV);
      return;
    }
    com.tencent.mm.plugin.sport.b.d.jdMethod_if(36);
    paramMenuItem = new AppBrandStatObject();
    paramMenuItem.scene = 1063;
    ((com.tencent.mm.plugin.appbrand.r.d)g.r(com.tencent.mm.plugin.appbrand.r.d.class)).a(null, "gh_1f9ebf140e39@app", null, 0, 0, null, paramMenuItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.20
 * JD-Core Version:    0.7.0.1
 */