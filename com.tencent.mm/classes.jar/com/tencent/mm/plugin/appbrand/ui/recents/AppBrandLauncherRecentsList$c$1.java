package com.tencent.mm.plugin.appbrand.ui.recents;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class AppBrandLauncherRecentsList$c$1
  implements Runnable
{
  AppBrandLauncherRecentsList$c$1(AppBrandLauncherRecentsList.c paramc, boolean paramBoolean) {}
  
  public final void run()
  {
    int i = 1;
    int j = 0;
    AppMethodBeat.i(133367);
    if ((!AppBrandLauncherRecentsList.b(this.iTB.iTl).isEmpty()) && (AppBrandLauncherRecentsList.b(this.iTB.iTl) != null)) {}
    try
    {
      AppBrandLauncherRecentsList.b(this.iTB.iTl).bR(AppBrandLauncherRecentsList.b(this.iTB.iTl).getItemCount() - 1);
      if (AppBrandLauncherRecentsList.o(this.iTB.iTl) != null)
      {
        Object localObject = AppBrandLauncherRecentsList.o(this.iTB.iTl);
        if ((!this.iTA) && (!AppBrandLauncherRecentsList.b(this.iTB.iTl).isEmpty()))
        {
          localObject = ((e)localObject).iTS;
          if (i == 0) {
            break label159;
          }
          i = j;
          ((View)localObject).setVisibility(i);
        }
      }
      else
      {
        AppMethodBeat.o(133367);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.AppBrandLauncherRecentsList", "adjustListBottomDivider notifyItemChanged e=%s", new Object[] { localException });
        continue;
        i = 0;
        continue;
        label159:
        i = 4;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.c.1
 * JD-Core Version:    0.7.0.1
 */