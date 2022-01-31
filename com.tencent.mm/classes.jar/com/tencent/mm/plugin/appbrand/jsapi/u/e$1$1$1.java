package com.tencent.mm.plugin.appbrand.jsapi.u;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class e$1$1$1
  implements View.OnCreateContextMenuListener
{
  e$1$1$1(e.1.1 param1) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(17024);
    if (this.ihl.ihk.ihi.ihb != null)
    {
      ab.d("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "show webkit menu");
      e.a(this.ihl.ihk.ihi, paramContextMenu, this.ihl.ihk.ihi.ihb);
      this.ihl.ihk.ihi.ihb = null;
      AppMethodBeat.o(17024);
      return;
    }
    if (this.ihl.ihk.ihi.ihc != null)
    {
      ab.d("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "show IX5 menu");
      e.b(this.ihl.ihk.ihi, paramContextMenu, this.ihl.ihk.ihi.ihc);
      this.ihl.ihk.ihi.ihc = null;
    }
    AppMethodBeat.o(17024);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.e.1.1.1
 * JD-Core Version:    0.7.0.1
 */