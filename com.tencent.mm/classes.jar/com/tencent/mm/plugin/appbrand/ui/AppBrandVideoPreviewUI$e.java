package com.tencent.mm.plugin.appbrand.ui;

import a.l;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
final class AppBrandVideoPreviewUI$e
  implements MenuItem.OnMenuItemClickListener
{
  AppBrandVideoPreviewUI$e(AppBrandVideoPreviewUI paramAppBrandVideoPreviewUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(143990);
    this.iPU.onBackPressed();
    AppMethodBeat.o(143990);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandVideoPreviewUI.e
 * JD-Core Version:    0.7.0.1
 */