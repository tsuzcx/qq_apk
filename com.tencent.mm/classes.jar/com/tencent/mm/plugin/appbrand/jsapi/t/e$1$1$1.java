package com.tencent.mm.plugin.appbrand.jsapi.t;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.sdk.platformtools.y;

final class e$1$1$1
  implements View.OnCreateContextMenuListener
{
  e$1$1$1(e.1.1 param1) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    if (this.gGD.gGC.gGA.gGu != null)
    {
      y.d("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "show webkit menu");
      e.a(this.gGD.gGC.gGA, paramContextMenu, this.gGD.gGC.gGA.gGu);
      this.gGD.gGC.gGA.gGu = null;
    }
    while (this.gGD.gGC.gGA.gGv == null) {
      return;
    }
    y.d("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "show IX5 menu");
    e.b(this.gGD.gGC.gGA, paramContextMenu, this.gGD.gGC.gGA.gGv);
    this.gGD.gGC.gGA.gGv = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.e.1.1.1
 * JD-Core Version:    0.7.0.1
 */