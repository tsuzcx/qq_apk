package com.tencent.mm.plugin.appbrand.widget.desktop.half;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recentview.e.b;
import com.tencent.mm.sdk.platformtools.ab;

final class AppBrandDesktopHalfView$12$1
  implements e.b
{
  AppBrandDesktopHalfView$12$1(AppBrandDesktopHalfView.12 param12) {}
  
  public final void aQl()
  {
    AppMethodBeat.i(134171);
    if ((AppBrandDesktopHalfView.c(this.jir.jin) != null) && (AppBrandDesktopHalfView.c(this.jir.jin).getPreviewList() != null) && (AppBrandDesktopHalfView.c(this.jir.jin).getRecentView() != null) && (AppBrandDesktopHalfView.c(this.jir.jin).getRecentView().getAdapter() != null))
    {
      ab.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo moveToFirst onScrollEnd notifyItemInserted startIndex: %d", new Object[] { Integer.valueOf(AppBrandDesktopHalfView.l(this.jir.jin)) });
      AppBrandDesktopHalfView.a(this.jir.jin, this.jir.jio);
    }
    AppMethodBeat.o(134171);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfView.12.1
 * JD-Core Version:    0.7.0.1
 */