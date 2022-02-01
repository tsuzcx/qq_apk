package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.ae;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandDesktopView$12
  extends ae
{
  AppBrandDesktopView$12(AppBrandDesktopView paramAppBrandDesktopView, Context paramContext)
  {
    super(paramContext);
  }
  
  public final float a(DisplayMetrics paramDisplayMetrics)
  {
    return 20.0F / paramDisplayMetrics.densityDpi;
  }
  
  public final PointF bZ(int paramInt)
  {
    AppMethodBeat.i(49579);
    PointF localPointF = AppBrandDesktopView.j(this.lVl).bZ(paramInt);
    AppMethodBeat.o(49579);
    return localPointF;
  }
  
  public final int jW()
  {
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.12
 * JD-Core Version:    0.7.0.1
 */