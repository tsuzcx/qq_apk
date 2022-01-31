package com.tencent.mm.plugin.appbrand.widget.desktop.half;

import android.support.v7.widget.RecyclerView.a;
import com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView;
import com.tencent.mm.sdk.platformtools.y;

final class AppBrandDesktopHalfView$9
  implements Runnable
{
  AppBrandDesktopHalfView$9(AppBrandDesktopHalfView paramAppBrandDesktopHalfView, int paramInt) {}
  
  public final void run()
  {
    y.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo notifyMoveToFirstAnimation last page need notifyItemRangeChanged");
    AppBrandDesktopHalfView.c(this.hrR).getRecentView().getAdapter().ah(this.kX, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfView.9
 * JD-Core Version:    0.7.0.1
 */