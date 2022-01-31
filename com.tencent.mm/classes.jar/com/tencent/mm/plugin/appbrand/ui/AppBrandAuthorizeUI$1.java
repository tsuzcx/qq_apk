package com.tencent.mm.plugin.appbrand.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandAuthorizeUI$1
  implements MenuItem.OnMenuItemClickListener
{
  AppBrandAuthorizeUI$1(AppBrandAuthorizeUI paramAppBrandAuthorizeUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(132892);
    AppBrandAuthorizeUI.a(this.iLF);
    this.iLF.finish();
    AppMethodBeat.o(132892);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.1
 * JD-Core Version:    0.7.0.1
 */