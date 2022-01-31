package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.desktop.a.f;

final class AppBrandDesktopDragView$3
  implements f
{
  AppBrandDesktopDragView$3(AppBrandDesktopDragView paramAppBrandDesktopDragView) {}
  
  public final float aMW()
  {
    AppMethodBeat.i(133747);
    float f = AppBrandDesktopDragView.a(this.jdT);
    AppMethodBeat.o(133747);
    return f;
  }
  
  public final float aMX()
  {
    AppMethodBeat.i(133748);
    float f = AppBrandDesktopDragView.b(this.jdT);
    AppMethodBeat.o(133748);
    return f;
  }
  
  public final Object bo(Object paramObject)
  {
    AppMethodBeat.i(133745);
    if ((paramObject instanceof AppBrandDesktopView.c))
    {
      paramObject = (AppBrandDesktopView.c)paramObject;
      AppBrandDesktopView.c localc = new AppBrandDesktopView.c(1);
      localc.jfk = paramObject.jfk;
      AppMethodBeat.o(133745);
      return localc;
    }
    AppMethodBeat.o(133745);
    return paramObject;
  }
  
  public final View cA(View paramView)
  {
    AppMethodBeat.i(133746);
    paramView = paramView.findViewById(2131821540);
    AppMethodBeat.o(133746);
    return paramView;
  }
  
  public final void e(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof AppBrandDesktopView.c)) {
      ((AppBrandDesktopView.c)paramObject).position = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopDragView.3
 * JD-Core Version:    0.7.0.1
 */