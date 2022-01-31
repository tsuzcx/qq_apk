package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.widget.desktop.a.d.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class AppBrandDesktopDragView$1
  implements d.a
{
  AppBrandDesktopDragView$1(AppBrandDesktopDragView paramAppBrandDesktopDragView) {}
  
  public final float aMW()
  {
    AppMethodBeat.i(133734);
    float f = AppBrandDesktopDragView.a(this.jdT);
    AppMethodBeat.o(133734);
    return f;
  }
  
  public final float aMX()
  {
    AppMethodBeat.i(133735);
    float f = AppBrandDesktopDragView.b(this.jdT);
    AppMethodBeat.o(133735);
    return f;
  }
  
  public final void aPo()
  {
    AppMethodBeat.i(133736);
    ab.d("MicroMsg.AppBrandDesktopDragView", "alvinluo onInsert");
    AppBrandDesktopDragView.a(this.jdT, true);
    AppMethodBeat.o(133736);
  }
  
  public final void aPp()
  {
    AppMethodBeat.i(133737);
    ab.d("MicroMsg.AppBrandDesktopDragView", "alvinluo onCancelInsert");
    AppBrandDesktopDragView.a(this.jdT, false);
    AppMethodBeat.o(133737);
  }
  
  public final Object bo(Object paramObject)
  {
    AppMethodBeat.i(133732);
    if ((paramObject instanceof AppBrandDesktopView.c))
    {
      paramObject = (AppBrandDesktopView.c)paramObject;
      AppBrandDesktopView.c localc = new AppBrandDesktopView.c(1);
      localc.jfk = paramObject.jfk;
      localc.position = paramObject.position;
      AppMethodBeat.o(133732);
      return localc;
    }
    AppMethodBeat.o(133732);
    return paramObject;
  }
  
  public final View cA(View paramView)
  {
    AppMethodBeat.i(133733);
    paramView = paramView.findViewById(2131821540);
    AppMethodBeat.o(133733);
    return paramView;
  }
  
  public final void e(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof AppBrandDesktopView.c)) {
      ((AppBrandDesktopView.c)paramObject).position = paramInt;
    }
  }
  
  public final boolean u(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(133738);
    if ((paramObject2 == null) || (paramObject1 == null))
    {
      AppMethodBeat.o(133738);
      return false;
    }
    if (((paramObject2 instanceof AppBrandDesktopView.c)) && ((paramObject1 instanceof AppBrandDesktopView.c)))
    {
      paramObject2 = (AppBrandDesktopView.c)paramObject2;
      paramObject1 = (AppBrandDesktopView.c)paramObject1;
      if ((paramObject2.jfk != null) && (paramObject1.jfk != null) && (!bo.isNullOrNil(paramObject2.jfk.username)) && (!bo.isNullOrNil(paramObject1.jfk.username)) && (paramObject1.jfk.e(paramObject2.jfk))) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(133738);
        return true;
      }
    }
    AppMethodBeat.o(133738);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopDragView.1
 * JD-Core Version:    0.7.0.1
 */