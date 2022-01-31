package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;

final class AppBrandLauncherRecentsList$e$2$1
  implements Runnable
{
  AppBrandLauncherRecentsList$e$2$1(AppBrandLauncherRecentsList.e.2 param2) {}
  
  public final void run()
  {
    AppMethodBeat.i(133384);
    h.a(this.iTQ.iTM.iTl.getActivity(), this.iTQ.iTM.iTl.getResources().getString(2131296612, new Object[] { Integer.valueOf(AppBrandLauncherRecentsList.A(this.iTQ.iTM.iTl)) }), "", this.iTQ.iTM.iTl.getResources().getString(2131297018), false, null);
    AppMethodBeat.o(133384);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.e.2.1
 * JD-Core Version:    0.7.0.1
 */