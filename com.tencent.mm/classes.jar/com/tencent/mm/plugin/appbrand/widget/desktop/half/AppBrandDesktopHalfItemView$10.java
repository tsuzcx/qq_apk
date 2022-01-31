package com.tencent.mm.plugin.appbrand.widget.desktop.half;

import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.f;
import com.tencent.mm.plugin.appbrand.widget.recentview.b;
import com.tencent.mm.plugin.appbrand.widget.recentview.c;
import com.tencent.mm.sdk.platformtools.y;

final class AppBrandDesktopHalfItemView$10
  extends c
{
  AppBrandDesktopHalfItemView$10(AppBrandDesktopHalfItemView paramAppBrandDesktopHalfItemView) {}
  
  public final void G(int paramInt, boolean paramBoolean)
  {
    y.i("MicroMsg.AppBrandDesktopHalfItemView", "alvinluo onScrollPageChanged currentPage: %d, isAuto: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if ((AppBrandDesktopHalfItemView.f(this.hry) != null) && (!paramBoolean))
    {
      if (AppBrandDesktopHalfItemView.a(this.hry) != AppBrandRecentView.f.hBX) {
        break label78;
      }
      localb = AppBrandDesktopHalfItemView.f(this.hry);
      y.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo scrollRecentList");
      localb.hCf += 1;
    }
    label78:
    while (AppBrandDesktopHalfItemView.a(this.hry) != AppBrandRecentView.f.hBY) {
      return;
    }
    b localb = AppBrandDesktopHalfItemView.f(this.hry);
    y.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo scrollStarList");
    localb.hCo += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfItemView.10
 * JD-Core Version:    0.7.0.1
 */