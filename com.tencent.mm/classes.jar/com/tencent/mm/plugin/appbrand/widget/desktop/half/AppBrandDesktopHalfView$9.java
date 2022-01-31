package com.tencent.mm.plugin.appbrand.widget.desktop.half;

import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView;
import com.tencent.mm.sdk.platformtools.ab;

final class AppBrandDesktopHalfView$9
  implements Runnable
{
  AppBrandDesktopHalfView$9(AppBrandDesktopHalfView paramAppBrandDesktopHalfView, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(134168);
    ab.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo notifyMoveToFirstAnimation last page need notifyItemRangeChanged");
    AppBrandDesktopHalfView.c(this.jin).getRecentView().getAdapter().an(this.lU, 5);
    AppMethodBeat.o(134168);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfView.9
 * JD-Core Version:    0.7.0.1
 */