package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.ae;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandDesktopView$i
  extends ae
{
  AppBrandDesktopView$i(AppBrandDesktopView paramAppBrandDesktopView, Context paramContext)
  {
    super(paramContext);
  }
  
  public final float a(DisplayMetrics paramDisplayMetrics)
  {
    return 300.0F / paramDisplayMetrics.densityDpi;
  }
  
  public final PointF bZ(int paramInt)
  {
    AppMethodBeat.i(49598);
    PointF localPointF = AppBrandDesktopView.j(this.lVl).bZ(paramInt);
    AppMethodBeat.o(49598);
    return localPointF;
  }
  
  public final int e(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    return paramInt3 - paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.i
 * JD-Core Version:    0.7.0.1
 */