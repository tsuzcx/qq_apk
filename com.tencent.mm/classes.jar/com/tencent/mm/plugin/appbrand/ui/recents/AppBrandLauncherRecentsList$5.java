package com.tencent.mm.plugin.appbrand.ui.recents;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;

final class AppBrandLauncherRecentsList$5
  implements Runnable
{
  AppBrandLauncherRecentsList$5(AppBrandLauncherRecentsList paramAppBrandLauncherRecentsList) {}
  
  public final void run()
  {
    AppMethodBeat.i(133335);
    if (AppBrandLauncherRecentsList.d(this.iTl).computeVerticalScrollOffset() == 0) {
      AppBrandLauncherRecentsList.d(this.iTl).scrollBy(0, AppBrandLauncherRecentsList.r(this.iTl).getTop());
    }
    AppMethodBeat.o(133335);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.5
 * JD-Core Version:    0.7.0.1
 */