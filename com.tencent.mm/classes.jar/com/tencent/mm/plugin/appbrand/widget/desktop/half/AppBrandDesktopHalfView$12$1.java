package com.tencent.mm.plugin.appbrand.widget.desktop.half;

import com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recentview.e.b;
import com.tencent.mm.sdk.platformtools.y;

final class AppBrandDesktopHalfView$12$1
  implements e.b
{
  AppBrandDesktopHalfView$12$1(AppBrandDesktopHalfView.12 param12) {}
  
  public final void arA()
  {
    if ((AppBrandDesktopHalfView.c(this.hrV.hrR) != null) && (AppBrandDesktopHalfView.c(this.hrV.hrR).getPreviewList() != null) && (AppBrandDesktopHalfView.c(this.hrV.hrR).getRecentView() != null) && (AppBrandDesktopHalfView.c(this.hrV.hrR).getRecentView().getAdapter() != null))
    {
      y.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo moveToFirst onScrollEnd notifyItemInserted startIndex: %d", new Object[] { Integer.valueOf(AppBrandDesktopHalfView.l(this.hrV.hrR)) });
      AppBrandDesktopHalfView.a(this.hrV.hrR, this.hrV.hrS);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfView.12.1
 * JD-Core Version:    0.7.0.1
 */