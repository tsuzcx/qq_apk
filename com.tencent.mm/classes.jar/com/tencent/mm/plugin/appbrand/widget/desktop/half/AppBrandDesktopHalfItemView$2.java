package com.tencent.mm.plugin.appbrand.widget.desktop.half;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.support.v7.widget.RecyclerView.v;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c;

final class AppBrandDesktopHalfItemView$2
  implements Animator.AnimatorListener
{
  AppBrandDesktopHalfItemView$2(AppBrandDesktopHalfItemView paramAppBrandDesktopHalfItemView) {}
  
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    if ((AppBrandDesktopHalfItemView.g(this.hry) != null) && (AppBrandDesktopHalfItemView.g(this.hry).hrA != null) && (AppBrandDesktopHalfItemView.g(this.hry).hrA.aie != null) && ((AppBrandDesktopHalfItemView.g(this.hry).hrA instanceof BaseAppBrandRecentView.c))) {
      ((BaseAppBrandRecentView.c)AppBrandDesktopHalfItemView.g(this.hry).hrA).eXr.setVisibility(0);
    }
    AppBrandDesktopHalfItemView.j(this.hry);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfItemView.2
 * JD-Core Version:    0.7.0.1
 */