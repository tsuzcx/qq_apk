package com.tencent.mm.plugin.appbrand.ui.recents;

import android.os.Message;
import android.support.v4.view.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import java.util.ArrayList;

final class AppBrandLauncherRecentsList$8$1
  implements Runnable
{
  AppBrandLauncherRecentsList$8$1(AppBrandLauncherRecentsList.8 param8, ArrayList paramArrayList) {}
  
  public final void run()
  {
    AppMethodBeat.i(133338);
    if ((AppBrandLauncherRecentsList.d(this.iTq.iTl) == null) || (!t.aw(AppBrandLauncherRecentsList.d(this.iTq.iTl))))
    {
      AppMethodBeat.o(133338);
      return;
    }
    if (AppBrandLauncherRecentsList.d(this.iTq.iTl).jd())
    {
      AppBrandLauncherRecentsList.e(this.iTq.iTl).obtainMessage(2, this).sendToTarget();
      AppMethodBeat.o(133338);
      return;
    }
    AppBrandLauncherRecentsList.a(this.iTq.iTl, this.iTp);
    AppMethodBeat.o(133338);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.8.1
 * JD-Core Version:    0.7.0.1
 */