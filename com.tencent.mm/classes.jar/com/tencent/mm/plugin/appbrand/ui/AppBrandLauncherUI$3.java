package com.tencent.mm.plugin.appbrand.ui;

import android.app.ActivityOptions;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Pair;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.d.a;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.sdk.platformtools.aj;

final class AppBrandLauncherUI$3
  implements MenuItem.OnMenuItemClickListener
{
  AppBrandLauncherUI$3(AppBrandLauncherUI paramAppBrandLauncherUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(48626);
    ((i)g.ab(i.class)).a(aj.getContext(), new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48625);
        Bundle localBundle = null;
        if (Build.VERSION.SDK_INT >= 21) {
          localBundle = ActivityOptions.makeSceneTransitionAnimation(AppBrandLauncherUI.3.this.lzJ, new Pair[0]).toBundle();
        }
        if (AppBrandLauncherUI.b(AppBrandLauncherUI.3.this.lzJ) == 13) {}
        for (int i = 52;; i = 201)
        {
          AppBrandLauncherUI localAppBrandLauncherUI = AppBrandLauncherUI.3.this.lzJ;
          a locala = a.jaU;
          localAppBrandLauncherUI.startActivityForResult(a.E(AppBrandLauncherUI.3.this.lzJ, i), 1, localBundle);
          AppMethodBeat.o(48625);
          return;
        }
      }
    });
    AppMethodBeat.o(48626);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.3
 * JD-Core Version:    0.7.0.1
 */