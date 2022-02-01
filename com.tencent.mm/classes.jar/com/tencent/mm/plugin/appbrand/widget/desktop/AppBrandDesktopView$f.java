package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class AppBrandDesktopView$f
  extends RecyclerView.v
{
  public AppBrandDesktopView$f(AppBrandDesktopView paramAppBrandDesktopView, View paramView)
  {
    super(paramView);
    AppMethodBeat.i(49594);
    AppBrandDesktopView.i(this.lVl, AppBrandDesktopView.p(this.lVl));
    if ((AppBrandDesktopView.F(this.lVl) == 0) && (this.arI != null))
    {
      this.arI.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      ad.i("MicroMsg.AppBrandDesktopView", "alvinluo MyAppBrandEmptyViewHolder itemHeight: %d, itemWidth: %d", new Object[] { Integer.valueOf(this.arI.getMeasuredHeight()), Integer.valueOf(this.arI.getMeasuredWidth()) });
      AppBrandDesktopView.i(this.lVl, this.arI.getMeasuredHeight());
    }
    paramAppBrandDesktopView = new RecyclerView.LayoutParams(-1, -2);
    paramAppBrandDesktopView.setMargins(paramAppBrandDesktopView.leftMargin + AppBrandDesktopView.u(this.lVl), paramAppBrandDesktopView.topMargin - AppBrandDesktopView.F(this.lVl), paramAppBrandDesktopView.rightMargin + AppBrandDesktopView.u(this.lVl), paramAppBrandDesktopView.bottomMargin);
    ad.i("MicroMsg.AppBrandDesktopView", "alvinluo MyAppBrandEmptyViewHolder topMargin: %d", new Object[] { Integer.valueOf(paramAppBrandDesktopView.topMargin) });
    if (this.arI != null) {
      this.arI.setLayoutParams(paramAppBrandDesktopView);
    }
    AppMethodBeat.o(49594);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.f
 * JD-Core Version:    0.7.0.1
 */