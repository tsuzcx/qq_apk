package com.tencent.mm.plugin.appbrand.widget.desktop.half;

import android.support.v7.widget.RecyclerView.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandDesktopHalfView$16
  extends RecyclerView.c
{
  AppBrandDesktopHalfView$16(AppBrandDesktopHalfView paramAppBrandDesktopHalfView) {}
  
  public final void at(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(134176);
    super.at(paramInt1, paramInt2);
    if (AppBrandDesktopHalfView.d(this.jin).getDataCount() <= AppBrandDesktopHalfView.d(this.jin).getCustomCount()) {
      AppBrandDesktopHalfView.d(this.jin).setVisibility(8);
    }
    AppMethodBeat.o(134176);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfView.16
 * JD-Core Version:    0.7.0.1
 */