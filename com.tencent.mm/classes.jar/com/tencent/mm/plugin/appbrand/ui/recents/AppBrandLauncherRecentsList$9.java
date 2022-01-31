package com.tencent.mm.plugin.appbrand.ui.recents;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.sdk.platformtools.ab;

final class AppBrandLauncherRecentsList$9
  implements Runnable
{
  AppBrandLauncherRecentsList$9(AppBrandLauncherRecentsList paramAppBrandLauncherRecentsList) {}
  
  public final void run()
  {
    AppMethodBeat.i(133340);
    if ((AppBrandLauncherRecentsList.o(this.iTl).aku == null) || (AppBrandLauncherRecentsList.o(this.iTl).aku.getHeight() <= 0) || (AppBrandLauncherRecentsList.d(this.iTl) == null))
    {
      AppMethodBeat.o(133340);
      return;
    }
    try
    {
      AppBrandLauncherRecentsList.d(this.iTl).scrollBy(0, AppBrandLauncherRecentsList.o(this.iTl).aku.getHeight());
      AppMethodBeat.o(133340);
      return;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      ab.e("MicroMsg.AppBrandLauncherRecentsList", "makeFooterFullyVisible scrollBy e=%s", new Object[] { localIndexOutOfBoundsException });
      AppMethodBeat.o(133340);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.9
 * JD-Core Version:    0.7.0.1
 */