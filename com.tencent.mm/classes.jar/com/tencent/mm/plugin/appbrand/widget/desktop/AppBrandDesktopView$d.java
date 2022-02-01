package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class AppBrandDesktopView$d
  extends RecyclerView.v
{
  public AppBrandDesktopView$d(AppBrandDesktopView paramAppBrandDesktopView, View paramView)
  {
    super(paramView);
    AppMethodBeat.i(49585);
    if ((AppBrandDesktopView.H(paramAppBrandDesktopView) == 0) && (this.arI != null))
    {
      this.arI.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      ad.i("MicroMsg.AppBrandDesktopView", "alvinluo FullEmptyViewHolder itemHeight: %d, itemWidth: %d", new Object[] { Integer.valueOf(this.arI.getMeasuredHeight()), Integer.valueOf(this.arI.getMeasuredWidth()) });
      AppBrandDesktopView.j(paramAppBrandDesktopView, this.arI.getMeasuredHeight());
    }
    AppMethodBeat.o(49585);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.d
 * JD-Core Version:    0.7.0.1
 */