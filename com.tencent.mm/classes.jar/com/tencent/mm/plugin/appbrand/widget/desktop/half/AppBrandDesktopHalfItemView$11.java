package com.tencent.mm.plugin.appbrand.widget.desktop.half;

import com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c;
import com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView.a;
import com.tencent.mm.sdk.platformtools.y;

final class AppBrandDesktopHalfItemView$11
  implements ConversationAppBrandRecentView.a
{
  AppBrandDesktopHalfItemView$11(AppBrandDesktopHalfItemView paramAppBrandDesktopHalfItemView) {}
  
  public final void a(BaseAppBrandRecentView.c paramc, int paramInt)
  {
    if ((AppBrandDesktopHalfItemView.g(this.hry) != null) && (AppBrandDesktopHalfItemView.g(this.hry).ahA == paramInt) && (AppBrandDesktopHalfItemView.h(this.hry)) && (paramc != null) && (paramc.aie != null))
    {
      y.i("MicroMsg.AppBrandDesktopHalfItemView", "alvinluo ScaleAndAlphaAnimation set to default position: %d", new Object[] { Integer.valueOf(paramInt) });
      AppBrandDesktopHalfItemView.g(this.hry).hrA = paramc;
      AppBrandDesktopHalfItemView.i(this.hry);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfItemView.11
 * JD-Core Version:    0.7.0.1
 */