package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.desktop.a.a;
import com.tencent.mm.sdk.platformtools.ab;

final class AppBrandDesktopDragView$2
  implements a
{
  AppBrandDesktopDragView$2(AppBrandDesktopDragView paramAppBrandDesktopDragView) {}
  
  public final boolean O(RecyclerView.v paramv)
  {
    return paramv.aky == 2;
  }
  
  public final boolean P(RecyclerView.v paramv)
  {
    return (paramv == null) || (paramv.aky == 2) || (paramv.aky == 10) || (paramv.aky == 11);
  }
  
  public final void a(RecyclerView.v paramv, View paramView, Object paramObject, int paramInt)
  {
    AppMethodBeat.i(133740);
    if (paramInt == 6) {
      AppBrandDesktopDragView.b(this.jdT, true);
    }
    for (;;)
    {
      AppBrandDesktopDragView.a(this.jdT, paramv, paramView, paramObject, paramInt);
      AppMethodBeat.o(133740);
      return;
      AppBrandDesktopDragView.b(this.jdT, false);
    }
  }
  
  public final boolean a(RecyclerView.v paramv, Object paramObject)
  {
    AppMethodBeat.i(133743);
    if (AppBrandDesktopDragView.a(this.jdT, paramObject) != 0)
    {
      ab.e("MicroMsg.AppBrandDesktopDragView", "alvinluo checkCanInsert can't insert");
      AppMethodBeat.o(133743);
      return false;
    }
    if ((paramv.aky == 1) || (paramv.aky == 2) || (paramv.aky == 7))
    {
      AppMethodBeat.o(133743);
      return true;
    }
    AppMethodBeat.o(133743);
    return false;
  }
  
  public final View b(RecyclerView paramRecyclerView, RecyclerView.v paramv)
  {
    AppMethodBeat.i(133739);
    if ((paramv instanceof e))
    {
      paramRecyclerView = this.jdT.a((e)paramv);
      AppMethodBeat.o(133739);
      return paramRecyclerView;
    }
    AppMethodBeat.o(133739);
    return null;
  }
  
  public final void b(int paramInt1, int paramInt2, Object paramObject, boolean paramBoolean)
  {
    AppMethodBeat.i(133742);
    if ((paramBoolean) && (AppBrandDesktopDragView.c(this.jdT) != null)) {
      AppBrandDesktopDragView.c(this.jdT).bx(paramObject);
    }
    AppMethodBeat.o(133742);
  }
  
  public final void bn(Object paramObject)
  {
    AppMethodBeat.i(133744);
    if ((paramObject instanceof AppBrandDesktopView.c))
    {
      ((AppBrandDesktopView.c)paramObject).type = 2;
      if (AppBrandDesktopDragView.c(this.jdT) != null) {
        AppBrandDesktopDragView.c(this.jdT).bz(paramObject);
      }
    }
    AppMethodBeat.o(133744);
  }
  
  public final void cz(View paramView)
  {
    AppMethodBeat.i(133741);
    if (paramView != null)
    {
      View localView = paramView.findViewById(2131823387);
      if (localView != null) {
        localView.setVisibility(4);
      }
      paramView = paramView.findViewById(2131825397);
      if (paramView != null) {
        paramView.setVisibility(4);
      }
    }
    AppMethodBeat.o(133741);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopDragView.2
 * JD-Core Version:    0.7.0.1
 */