package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

final class AppBrandDesktopView$1
  implements ValueAnimator.AnimatorUpdateListener
{
  AppBrandDesktopView$1(AppBrandDesktopView paramAppBrandDesktopView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.hqv.setPadding(this.hqv.getPaddingLeft(), i, this.hqv.getPaddingRight(), this.hqv.getPaddingBottom());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.1
 * JD-Core Version:    0.7.0.1
 */