package com.tencent.mm.plugin.appbrand.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
final class AppBrandVideoPreviewUI$e
  implements MenuItem.OnMenuItemClickListener
{
  AppBrandVideoPreviewUI$e(AppBrandVideoPreviewUI paramAppBrandVideoPreviewUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(51159);
    this.mGm.onBackPressed();
    AppMethodBeat.o(51159);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandVideoPreviewUI.e
 * JD-Core Version:    0.7.0.1
 */