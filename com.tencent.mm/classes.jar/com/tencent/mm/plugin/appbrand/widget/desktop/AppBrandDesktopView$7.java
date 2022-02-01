package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.support.v7.widget.GridLayoutManager.b;
import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandDesktopView$7
  extends GridLayoutManager.b
{
  AppBrandDesktopView$7(AppBrandDesktopView paramAppBrandDesktopView) {}
  
  public final int bX(int paramInt)
  {
    AppMethodBeat.i(227758);
    paramInt = this.ooe.getAdapter().getItemViewType(paramInt);
    if ((paramInt == 3) || (paramInt == 11) || (paramInt == 10) || (paramInt == 2) || (paramInt == 6) || (paramInt == 8) || (paramInt == 9))
    {
      paramInt = this.ooe.apM;
      AppMethodBeat.o(227758);
      return paramInt;
    }
    AppMethodBeat.o(227758);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.7
 * JD-Core Version:    0.7.0.1
 */