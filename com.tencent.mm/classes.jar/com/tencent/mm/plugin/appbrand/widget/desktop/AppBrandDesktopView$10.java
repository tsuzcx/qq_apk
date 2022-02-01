package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.support.v7.widget.GridLayoutManager.b;
import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandDesktopView$10
  extends GridLayoutManager.b
{
  AppBrandDesktopView$10(AppBrandDesktopView paramAppBrandDesktopView) {}
  
  public final int bW(int paramInt)
  {
    AppMethodBeat.i(49577);
    paramInt = this.lVl.getAdapter().getItemViewType(paramInt);
    if ((paramInt == 3) || (paramInt == 11) || (paramInt == 10) || (paramInt == 2) || (paramInt == 6) || (paramInt == 8) || (paramInt == 9))
    {
      paramInt = this.lVl.amN;
      AppMethodBeat.o(49577);
      return paramInt;
    }
    AppMethodBeat.o(49577);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.10
 * JD-Core Version:    0.7.0.1
 */