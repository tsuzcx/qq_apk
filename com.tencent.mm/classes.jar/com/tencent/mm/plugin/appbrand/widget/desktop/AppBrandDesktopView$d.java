package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class AppBrandDesktopView$d
  extends RecyclerView.v
{
  public AppBrandDesktopView$d(AppBrandDesktopView paramAppBrandDesktopView, View paramView)
  {
    super(paramView);
    AppMethodBeat.i(133841);
    if ((AppBrandDesktopView.F(paramAppBrandDesktopView) == 0) && (this.aku != null))
    {
      this.aku.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      ab.i("MicroMsg.AppBrandDesktopView", "alvinluo FullEmptyViewHolder itemHeight: %d, itemWidth: %d", new Object[] { Integer.valueOf(this.aku.getMeasuredHeight()), Integer.valueOf(this.aku.getMeasuredWidth()) });
      AppBrandDesktopView.h(paramAppBrandDesktopView, this.aku.getMeasuredHeight());
    }
    AppMethodBeat.o(133841);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.d
 * JD-Core Version:    0.7.0.1
 */