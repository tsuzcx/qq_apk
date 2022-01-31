package com.tencent.mm.plugin.appbrand.widget.desktop.half;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recentview.e.b;
import com.tencent.mm.sdk.platformtools.ab;

final class AppBrandDesktopHalfView$5
  implements e.b
{
  AppBrandDesktopHalfView$5(AppBrandDesktopHalfView paramAppBrandDesktopHalfView) {}
  
  public final void aQl()
  {
    AppMethodBeat.i(134164);
    ab.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo smoothScrollToPosition onScrollEnd");
    AppBrandDesktopHalfItemView localAppBrandDesktopHalfItemView = AppBrandDesktopHalfView.c(this.jin);
    if ((localAppBrandDesktopHalfItemView.jhQ != null) && (localAppBrandDesktopHalfItemView.jhQ.ajQ != -1))
    {
      ab.i("MicroMsg.AppBrandDesktopHalfItemView", "alvinluo notifyScaleAndAlphaAnimation targetPage: %d, currentPage: %d", new Object[] { Integer.valueOf(localAppBrandDesktopHalfItemView.jhQ.jhW), Integer.valueOf(localAppBrandDesktopHalfItemView.jeb.getCurrentPage()) });
      localAppBrandDesktopHalfItemView.jhQ.jhX = localAppBrandDesktopHalfItemView.jeb.bQ(localAppBrandDesktopHalfItemView.jhQ.ajQ);
      if (localAppBrandDesktopHalfItemView.jhQ.jhX != null)
      {
        ab.i("MicroMsg.AppBrandDesktopHalfItemView", "alvinluo doScaleAndAlphaAnimation");
        localAppBrandDesktopHalfItemView.jeb.postDelayed(new AppBrandDesktopHalfItemView.3(localAppBrandDesktopHalfItemView), 10L);
      }
    }
    AppMethodBeat.o(134164);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfView.5
 * JD-Core Version:    0.7.0.1
 */