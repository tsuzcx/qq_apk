package com.tencent.mm.plugin.appbrand.widget.desktop.half;

import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.desktop.c;
import com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recentview.a;
import com.tencent.mm.plugin.appbrand.widget.recentview.e.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

final class AppBrandDesktopHalfView$6
  implements e.b
{
  AppBrandDesktopHalfView$6(AppBrandDesktopHalfView paramAppBrandDesktopHalfView, a parama) {}
  
  public final void aQl()
  {
    AppMethodBeat.i(134166);
    ab.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo smoothScrollToPosition onScrollEnd and notifyItemInserted");
    AppBrandDesktopHalfView.a(this.jin, (c)AppBrandDesktopHalfView.c(this.jin).getRecentView().getItemAnimator());
    AppBrandDesktopHalfView.n(this.jin).jea = true;
    AppBrandDesktopHalfView.c(this.jin).getPreviewList().add(AppBrandDesktopHalfView.l(this.jin), this.jio);
    AppBrandDesktopHalfView.c(this.jin).getRecentView().getAdapter().bS(AppBrandDesktopHalfView.l(this.jin));
    AppBrandDesktopHalfView.c(this.jin).getRecentView().getAdapter().an(AppBrandDesktopHalfView.c(this.jin).getDataCount(), 5);
    AppBrandDesktopHalfView.c(this.jin).postDelayed(new AppBrandDesktopHalfView.6.1(this), 500L);
    AppMethodBeat.o(134166);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfView.6
 * JD-Core Version:    0.7.0.1
 */