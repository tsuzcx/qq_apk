package com.tencent.mm.plugin.appbrand.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.c.a;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.sdk.platformtools.ak;

final class AppBrandLauncherUI$3
  implements MenuItem.OnMenuItemClickListener
{
  AppBrandLauncherUI$3(AppBrandLauncherUI paramAppBrandLauncherUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(48626);
    ((i)g.ab(i.class)).a(ak.getContext(), new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48625);
        if (AppBrandLauncherUI.b(AppBrandLauncherUI.3.this.mGS) == 13) {}
        for (int i = 52;; i = 201)
        {
          AppBrandLauncherUI localAppBrandLauncherUI = AppBrandLauncherUI.3.this.mGS;
          a locala = a.jYt;
          localAppBrandLauncherUI.startActivityForResult(a.I(AppBrandLauncherUI.3.this.mGS, i), 1);
          AppMethodBeat.o(48625);
          return;
        }
      }
    });
    AppMethodBeat.o(48626);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.3
 * JD-Core Version:    0.7.0.1
 */