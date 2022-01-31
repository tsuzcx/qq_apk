package com.tencent.mm.plugin.appbrand.widget.desktop.half;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.f;
import com.tencent.mm.plugin.appbrand.widget.recentview.b;
import com.tencent.mm.plugin.appbrand.widget.recentview.c;
import com.tencent.mm.sdk.platformtools.ab;

final class AppBrandDesktopHalfItemView$10
  extends c
{
  AppBrandDesktopHalfItemView$10(AppBrandDesktopHalfItemView paramAppBrandDesktopHalfItemView) {}
  
  public final void L(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(134135);
    ab.i("MicroMsg.AppBrandDesktopHalfItemView", "alvinluo onScrollPageChanged currentPage: %d, isAuto: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if ((AppBrandDesktopHalfItemView.f(this.jhV) != null) && (!paramBoolean))
    {
      b localb;
      if (AppBrandDesktopHalfItemView.a(this.jhV) == AppBrandRecentView.f.juq)
      {
        localb = AppBrandDesktopHalfItemView.f(this.jhV);
        ab.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo scrollRecentList");
        localb.juy += 1;
        AppMethodBeat.o(134135);
        return;
      }
      if (AppBrandDesktopHalfItemView.a(this.jhV) == AppBrandRecentView.f.jur)
      {
        localb = AppBrandDesktopHalfItemView.f(this.jhV);
        ab.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo scrollStarList");
        localb.juH += 1;
      }
    }
    AppMethodBeat.o(134135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfItemView.10
 * JD-Core Version:    0.7.0.1
 */