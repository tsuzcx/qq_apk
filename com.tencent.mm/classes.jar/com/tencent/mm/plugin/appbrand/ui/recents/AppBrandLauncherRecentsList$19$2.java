package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import java.util.ArrayList;

final class AppBrandLauncherRecentsList$19$2
  implements Runnable
{
  AppBrandLauncherRecentsList$19$2(AppBrandLauncherRecentsList.19 param19, ArrayList paramArrayList) {}
  
  public final void run()
  {
    AppMethodBeat.i(133357);
    if ((AppBrandLauncherRecentsList.d(this.iTz.iTl) == null) || (!AppBrandLauncherRecentsList.d(this.iTz.iTl).isAttachedToWindow()))
    {
      AppMethodBeat.o(133357);
      return;
    }
    if (AppBrandLauncherRecentsList.d(this.iTz.iTl).jd())
    {
      AppBrandLauncherRecentsList.e(this.iTz.iTl).sendMessage(AppBrandLauncherRecentsList.e(this.iTz.iTl).obtainMessage(2, this));
      AppMethodBeat.o(133357);
      return;
    }
    AppBrandLauncherRecentsList.a(this.iTz.iTl, this.iTp);
    AppMethodBeat.o(133357);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.19.2
 * JD-Core Version:    0.7.0.1
 */