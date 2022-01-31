package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.af;
import android.util.DisplayMetrics;

final class AppBrandDesktopView$g
  extends af
{
  AppBrandDesktopView$g(AppBrandDesktopView paramAppBrandDesktopView, Context paramContext)
  {
    super(paramContext);
  }
  
  protected final float a(DisplayMetrics paramDisplayMetrics)
  {
    return 300.0F / paramDisplayMetrics.densityDpi;
  }
  
  public final PointF bD(int paramInt)
  {
    return AppBrandDesktopView.e(this.hqv).bD(paramInt);
  }
  
  public final int e(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    return paramInt3 - paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.g
 * JD-Core Version:    0.7.0.1
 */