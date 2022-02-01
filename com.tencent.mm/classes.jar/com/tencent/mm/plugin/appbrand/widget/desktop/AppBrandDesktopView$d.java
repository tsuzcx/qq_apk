package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

public final class AppBrandDesktopView$d
  extends RecyclerView.w
{
  public AppBrandDesktopView$d(AppBrandDesktopView paramAppBrandDesktopView, View paramView)
  {
    super(paramView);
    AppMethodBeat.i(49585);
    if ((AppBrandDesktopView.H(paramAppBrandDesktopView) == 0) && (this.asD != null))
    {
      this.asD.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      ac.i("MicroMsg.AppBrandDesktopView", "alvinluo FullEmptyViewHolder itemHeight: %d, itemWidth: %d", new Object[] { Integer.valueOf(this.asD.getMeasuredHeight()), Integer.valueOf(this.asD.getMeasuredWidth()) });
      AppBrandDesktopView.j(paramAppBrandDesktopView, this.asD.getMeasuredHeight());
    }
    AppMethodBeat.o(49585);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.d
 * JD-Core Version:    0.7.0.1
 */