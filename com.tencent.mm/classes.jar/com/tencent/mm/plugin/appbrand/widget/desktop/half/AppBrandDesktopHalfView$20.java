package com.tencent.mm.plugin.appbrand.widget.desktop.half;

import android.support.v7.widget.RecyclerView.a;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.e;
import com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView;
import com.tencent.mm.sdk.platformtools.y;

final class AppBrandDesktopHalfView$20
  implements AppBrandRecentView.e
{
  AppBrandDesktopHalfView$20(AppBrandDesktopHalfView paramAppBrandDesktopHalfView) {}
  
  public final void mH(int paramInt)
  {
    int i = 0;
    y.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo refresh CollectionData onDone size: %d", new Object[] { Integer.valueOf(paramInt) });
    AppBrandDesktopHalfView.j(this.hrR);
    AppBrandDesktopHalfView.b(this.hrR);
    if (paramInt <= AppBrandDesktopHalfView.c(this.hrR).getRecentView().getCustomItemCount()) {
      AppBrandDesktopHalfView.c(this.hrR).setVisibility(8);
    }
    for (;;)
    {
      if (AppBrandDesktopHalfView.k(this.hrR) != null)
      {
        AppBrandRecentView.e locale = AppBrandDesktopHalfView.k(this.hrR);
        if (paramInt - AppBrandDesktopHalfView.c(this.hrR).getRecentView().getCustomItemCount() > 0) {
          i = paramInt - AppBrandDesktopHalfView.c(this.hrR).getRecentView().getCustomItemCount();
        }
        locale.mH(i);
      }
      i = AppBrandDesktopHalfView.c(this.hrR).getRecentView().getAdapter().getItemCount();
      AppBrandDesktopHalfView.c(this.hrR).getRecentView().getAdapter().ah(paramInt - 1, i - paramInt);
      return;
      AppBrandDesktopHalfView.e(this.hrR).setVisibility(0);
      AppBrandDesktopHalfView.c(this.hrR).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfView.20
 * JD-Core Version:    0.7.0.1
 */