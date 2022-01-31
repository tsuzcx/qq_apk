package com.tencent.mm.plugin.appbrand.widget.desktop.half;

import android.support.v7.widget.RecyclerView.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandDesktopHalfItemView$8
  extends RecyclerView.c
{
  AppBrandDesktopHalfItemView$8(AppBrandDesktopHalfItemView paramAppBrandDesktopHalfItemView) {}
  
  public final void at(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(134132);
    super.at(paramInt1, paramInt2);
    if (AppBrandDesktopHalfItemView.d(this.jhV) != null) {
      AppBrandDesktopHalfItemView.d(this.jhV).at(paramInt1, paramInt2);
    }
    AppMethodBeat.o(134132);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfItemView.8
 * JD-Core Version:    0.7.0.1
 */