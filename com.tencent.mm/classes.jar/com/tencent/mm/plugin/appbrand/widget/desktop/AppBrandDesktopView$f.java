package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class AppBrandDesktopView$f
  extends RecyclerView.v
{
  public AppBrandDesktopView$f(AppBrandDesktopView paramAppBrandDesktopView, View paramView)
  {
    super(paramView);
    AppMethodBeat.i(133850);
    int j = AppBrandDesktopView.q(this.jfg);
    int i = j;
    if (j == 0)
    {
      i = j;
      if (this.aku != null)
      {
        this.aku.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        ab.i("MicroMsg.AppBrandDesktopView", "alvinluo MyAppBrandEmptyViewHolder itemHeight: %d, itemWidth: %d", new Object[] { Integer.valueOf(this.aku.getMeasuredHeight()), Integer.valueOf(this.aku.getMeasuredWidth()) });
        i = this.aku.getMeasuredHeight();
      }
    }
    paramAppBrandDesktopView = new RecyclerView.LayoutParams(-1, -2);
    paramAppBrandDesktopView.setMargins(paramAppBrandDesktopView.leftMargin + AppBrandDesktopView.v(this.jfg), paramAppBrandDesktopView.topMargin - i, paramAppBrandDesktopView.rightMargin + AppBrandDesktopView.v(this.jfg), paramAppBrandDesktopView.bottomMargin);
    ab.i("MicroMsg.AppBrandDesktopView", "alvinluo MyAppBrandEmptyViewHolder topMargin: %d", new Object[] { Integer.valueOf(paramAppBrandDesktopView.topMargin) });
    if (this.aku != null) {
      this.aku.setLayoutParams(paramAppBrandDesktopView);
    }
    AppMethodBeat.o(133850);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.f
 * JD-Core Version:    0.7.0.1
 */