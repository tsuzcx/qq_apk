package com.tencent.mm.plugin.appbrand.widget.desktop.half;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView;

final class AppBrandDesktopHalfView$6$1
  implements Runnable
{
  AppBrandDesktopHalfView$6$1(AppBrandDesktopHalfView.6 param6) {}
  
  public final void run()
  {
    AppMethodBeat.i(134165);
    if (AppBrandDesktopHalfView.n(this.jip.jin) != null) {
      AppBrandDesktopHalfView.c(this.jip.jin).getRecentView().setItemAnimator(AppBrandDesktopHalfView.n(this.jip.jin));
    }
    AppMethodBeat.o(134165);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfView.6.1
 * JD-Core Version:    0.7.0.1
 */