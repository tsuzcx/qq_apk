package com.tencent.mm.plugin.appbrand.widget.desktop.half;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recentview.b;
import com.tencent.mm.sdk.platformtools.ab;

final class AppBrandDesktopHalfView$15
  implements Runnable
{
  AppBrandDesktopHalfView$15(AppBrandDesktopHalfView paramAppBrandDesktopHalfView) {}
  
  public final void run()
  {
    AppMethodBeat.i(134175);
    try
    {
      long l = System.currentTimeMillis();
      b.g(AppBrandDesktopHalfView.d(this.jin).getPreviewList(), AppBrandDesktopHalfView.c(this.jin).getPreviewList());
      ab.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo computeNameDuplicatedResults cost: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(134175);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.AppBrandDesktopHalfView", localException, "alvinluo checkReportNameDuplicated", new Object[0]);
      AppMethodBeat.o(134175);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfView.15
 * JD-Core Version:    0.7.0.1
 */