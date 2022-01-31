package com.tencent.mm.plugin.appbrand.widget.desktop.half;

import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.e;
import com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView;
import com.tencent.mm.sdk.platformtools.ab;

final class AppBrandDesktopHalfView$1
  implements AppBrandRecentView.e
{
  AppBrandDesktopHalfView$1(AppBrandDesktopHalfView paramAppBrandDesktopHalfView) {}
  
  public final void qj(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(134160);
    ab.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo refresh RecentData onDone size: %d", new Object[] { Integer.valueOf(paramInt) });
    AppBrandDesktopHalfView.a(this.jin);
    AppBrandDesktopHalfView.b(this.jin);
    if (paramInt <= AppBrandDesktopHalfView.c(this.jin).getRecentView().getCustomItemCount()) {
      AppBrandDesktopHalfView.d(this.jin).setVisibility(8);
    }
    for (;;)
    {
      if (AppBrandDesktopHalfView.f(this.jin) != null)
      {
        AppBrandRecentView.e locale = AppBrandDesktopHalfView.f(this.jin);
        if (paramInt - AppBrandDesktopHalfView.d(this.jin).getRecentView().getCustomItemCount() > 0) {
          i = paramInt - AppBrandDesktopHalfView.d(this.jin).getRecentView().getCustomItemCount();
        }
        locale.qj(i);
      }
      AppMethodBeat.o(134160);
      return;
      if (AppBrandDesktopHalfView.e(this.jin).getVisibility() != 0) {
        AppBrandDesktopHalfView.e(this.jin).setVisibility(0);
      }
      if (AppBrandDesktopHalfView.d(this.jin).getVisibility() != 0) {
        AppBrandDesktopHalfView.d(this.jin).setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfView.1
 * JD-Core Version:    0.7.0.1
 */