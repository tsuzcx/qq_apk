package com.tencent.mm.plugin.appbrand.widget.desktop.half;

import android.support.v7.widget.RecyclerView.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandDesktopHalfView$22
  extends RecyclerView.c
{
  AppBrandDesktopHalfView$22(AppBrandDesktopHalfView paramAppBrandDesktopHalfView) {}
  
  public final void at(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(134182);
    super.at(paramInt1, paramInt2);
    if (AppBrandDesktopHalfView.c(this.jin).getDataCount() <= AppBrandDesktopHalfView.c(this.jin).getCustomCount()) {
      AppBrandDesktopHalfView.c(this.jin).setVisibility(8);
    }
    AppMethodBeat.o(134182);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfView.22
 * JD-Core Version:    0.7.0.1
 */