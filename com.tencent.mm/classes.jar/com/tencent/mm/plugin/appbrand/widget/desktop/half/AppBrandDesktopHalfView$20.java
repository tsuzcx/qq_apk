package com.tencent.mm.plugin.appbrand.widget.desktop.half;

import android.support.v7.widget.RecyclerView.a;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.e;
import com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView;
import com.tencent.mm.sdk.platformtools.ab;

final class AppBrandDesktopHalfView$20
  implements AppBrandRecentView.e
{
  AppBrandDesktopHalfView$20(AppBrandDesktopHalfView paramAppBrandDesktopHalfView) {}
  
  public final void qj(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(134180);
    ab.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo refresh CollectionData onDone size: %d", new Object[] { Integer.valueOf(paramInt) });
    AppBrandDesktopHalfView.j(this.jin);
    AppBrandDesktopHalfView.b(this.jin);
    if (paramInt <= AppBrandDesktopHalfView.c(this.jin).getRecentView().getCustomItemCount()) {
      AppBrandDesktopHalfView.c(this.jin).setVisibility(8);
    }
    for (;;)
    {
      if (AppBrandDesktopHalfView.k(this.jin) != null)
      {
        AppBrandRecentView.e locale = AppBrandDesktopHalfView.k(this.jin);
        if (paramInt - AppBrandDesktopHalfView.c(this.jin).getRecentView().getCustomItemCount() > 0) {
          i = paramInt - AppBrandDesktopHalfView.c(this.jin).getRecentView().getCustomItemCount();
        }
        locale.qj(i);
      }
      i = AppBrandDesktopHalfView.c(this.jin).getRecentView().getAdapter().getItemCount();
      AppBrandDesktopHalfView.c(this.jin).getRecentView().getAdapter().an(paramInt - 1, i - paramInt);
      AppMethodBeat.o(134180);
      return;
      AppBrandDesktopHalfView.e(this.jin).setVisibility(0);
      AppBrandDesktopHalfView.c(this.jin).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfView.20
 * JD-Core Version:    0.7.0.1
 */