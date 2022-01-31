package com.tencent.mm.plugin.appbrand.ui.recents;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;

final class AppBrandLauncherRecentsList$2
  implements MessageQueue.IdleHandler
{
  AppBrandLauncherRecentsList$2(AppBrandLauncherRecentsList paramAppBrandLauncherRecentsList) {}
  
  public final boolean queueIdle()
  {
    AppMethodBeat.i(133330);
    Looper.myQueue().removeIdleHandler(this);
    if ((!AppBrandLauncherRecentsList.p(this.iTl)) && (AppBrandLauncherRecentsList.d(this.iTl) != null)) {}
    try
    {
      AppBrandLauncherRecentsList.d(this.iTl).setLayoutFrozen(true);
      label43:
      AppMethodBeat.o(133330);
      return false;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      break label43;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.2
 * JD-Core Version:    0.7.0.1
 */