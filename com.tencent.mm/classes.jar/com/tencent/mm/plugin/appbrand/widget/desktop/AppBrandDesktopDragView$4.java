package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.desktop.a.a;

final class AppBrandDesktopDragView$4
  implements a
{
  AppBrandDesktopDragView$4(AppBrandDesktopDragView paramAppBrandDesktopDragView) {}
  
  public final boolean O(RecyclerView.v paramv)
  {
    return paramv.aky == 1;
  }
  
  public final boolean P(RecyclerView.v paramv)
  {
    return false;
  }
  
  public final void a(RecyclerView.v paramv, View paramView, Object paramObject, int paramInt) {}
  
  public final boolean a(RecyclerView.v paramv, Object paramObject)
  {
    return (paramv.aky == 1) || (paramv.aky == 7);
  }
  
  public final View b(RecyclerView paramRecyclerView, RecyclerView.v paramv)
  {
    AppMethodBeat.i(133749);
    paramRecyclerView = this.jdT.a((e)paramv);
    AppMethodBeat.o(133749);
    return paramRecyclerView;
  }
  
  public final void b(int paramInt1, int paramInt2, Object paramObject, boolean paramBoolean)
  {
    AppMethodBeat.i(133750);
    if (AppBrandDesktopDragView.c(this.jdT) != null) {
      AppBrandDesktopDragView.c(this.jdT).g(paramInt1, paramInt2, paramObject);
    }
    AppMethodBeat.o(133750);
  }
  
  public final void bn(Object paramObject)
  {
    AppMethodBeat.i(133751);
    if (((paramObject instanceof AppBrandDesktopView.c)) && (AppBrandDesktopDragView.c(this.jdT) != null)) {
      AppBrandDesktopDragView.c(this.jdT).by(paramObject);
    }
    AppMethodBeat.o(133751);
  }
  
  public final void cz(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopDragView.4
 * JD-Core Version:    0.7.0.1
 */