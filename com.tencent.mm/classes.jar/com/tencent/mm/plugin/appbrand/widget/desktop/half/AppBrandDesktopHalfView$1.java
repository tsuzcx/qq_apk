package com.tencent.mm.plugin.appbrand.widget.desktop.half;

import android.widget.LinearLayout;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.e;
import com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView;
import com.tencent.mm.sdk.platformtools.y;

final class AppBrandDesktopHalfView$1
  implements AppBrandRecentView.e
{
  AppBrandDesktopHalfView$1(AppBrandDesktopHalfView paramAppBrandDesktopHalfView) {}
  
  public final void mH(int paramInt)
  {
    int i = 0;
    y.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo refresh RecentData onDone size: %d", new Object[] { Integer.valueOf(paramInt) });
    AppBrandDesktopHalfView.a(this.hrR);
    AppBrandDesktopHalfView.b(this.hrR);
    if (paramInt <= AppBrandDesktopHalfView.c(this.hrR).getRecentView().getCustomItemCount()) {
      AppBrandDesktopHalfView.d(this.hrR).setVisibility(8);
    }
    for (;;)
    {
      if (AppBrandDesktopHalfView.f(this.hrR) != null)
      {
        AppBrandRecentView.e locale = AppBrandDesktopHalfView.f(this.hrR);
        if (paramInt - AppBrandDesktopHalfView.d(this.hrR).getRecentView().getCustomItemCount() > 0) {
          i = paramInt - AppBrandDesktopHalfView.d(this.hrR).getRecentView().getCustomItemCount();
        }
        locale.mH(i);
      }
      return;
      if (AppBrandDesktopHalfView.e(this.hrR).getVisibility() != 0) {
        AppBrandDesktopHalfView.e(this.hrR).setVisibility(0);
      }
      if (AppBrandDesktopHalfView.d(this.hrR).getVisibility() != 0) {
        AppBrandDesktopHalfView.d(this.hrR).setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfView.1
 * JD-Core Version:    0.7.0.1
 */