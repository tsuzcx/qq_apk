package com.tencent.mm.plugin.appbrand.widget.desktop.half;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c;
import com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView.a;
import com.tencent.mm.sdk.platformtools.ab;

final class AppBrandDesktopHalfItemView$11
  implements ConversationAppBrandRecentView.a
{
  AppBrandDesktopHalfItemView$11(AppBrandDesktopHalfItemView paramAppBrandDesktopHalfItemView) {}
  
  public final void a(BaseAppBrandRecentView.c paramc, int paramInt)
  {
    AppMethodBeat.i(134136);
    if ((AppBrandDesktopHalfItemView.g(this.jhV) != null) && (AppBrandDesktopHalfItemView.g(this.jhV).ajQ == paramInt) && (AppBrandDesktopHalfItemView.h(this.jhV)) && (paramc != null) && (paramc.aku != null))
    {
      ab.i("MicroMsg.AppBrandDesktopHalfItemView", "alvinluo ScaleAndAlphaAnimation set to default position: %d", new Object[] { Integer.valueOf(paramInt) });
      AppBrandDesktopHalfItemView.g(this.jhV).jhX = paramc;
      AppBrandDesktopHalfItemView.i(this.jhV);
    }
    AppMethodBeat.o(134136);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfItemView.11
 * JD-Core Version:    0.7.0.1
 */