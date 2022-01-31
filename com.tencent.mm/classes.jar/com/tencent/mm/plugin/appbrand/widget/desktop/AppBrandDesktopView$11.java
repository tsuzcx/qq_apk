package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.ae;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandDesktopView$11
  extends ae
{
  AppBrandDesktopView$11(AppBrandDesktopView paramAppBrandDesktopView, Context paramContext)
  {
    super(paramContext);
  }
  
  public final PointF bI(int paramInt)
  {
    AppMethodBeat.i(154871);
    PointF localPointF = AppBrandDesktopView.k(this.jfg).bI(paramInt);
    AppMethodBeat.o(154871);
    return localPointF;
  }
  
  public final float c(DisplayMetrics paramDisplayMetrics)
  {
    return 20.0F / paramDisplayMetrics.densityDpi;
  }
  
  public final int iB()
  {
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.11
 * JD-Core Version:    0.7.0.1
 */