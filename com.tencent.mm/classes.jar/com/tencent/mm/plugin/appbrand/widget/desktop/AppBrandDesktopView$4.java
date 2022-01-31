package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.support.v7.widget.GridLayoutManager.b;
import android.support.v7.widget.RecyclerView.a;

final class AppBrandDesktopView$4
  extends GridLayoutManager.b
{
  AppBrandDesktopView$4(AppBrandDesktopView paramAppBrandDesktopView) {}
  
  public final int bA(int paramInt)
  {
    paramInt = this.hqv.getAdapter().getItemViewType(paramInt);
    if ((paramInt == 3) || (paramInt == 11) || (paramInt == 10) || (paramInt == 2) || (paramInt == 6) || (paramInt == 8) || (paramInt == 9)) {
      return 4;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.4
 * JD-Core Version:    0.7.0.1
 */