package com.tencent.mm.plugin.appbrand.widget.desktop.half;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.support.v7.widget.RecyclerView.v;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c;

final class AppBrandDesktopHalfItemView$2
  implements Animator.AnimatorListener
{
  AppBrandDesktopHalfItemView$2(AppBrandDesktopHalfItemView paramAppBrandDesktopHalfItemView) {}
  
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(134126);
    if ((AppBrandDesktopHalfItemView.g(this.jhV) != null) && (AppBrandDesktopHalfItemView.g(this.jhV).jhX != null) && (AppBrandDesktopHalfItemView.g(this.jhV).jhX.aku != null) && ((AppBrandDesktopHalfItemView.g(this.jhV).jhX instanceof BaseAppBrandRecentView.c))) {
      ((BaseAppBrandRecentView.c)AppBrandDesktopHalfItemView.g(this.jhV).jhX).titleTv.setVisibility(0);
    }
    AppBrandDesktopHalfItemView.j(this.jhV);
    AppMethodBeat.o(134126);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfItemView.2
 * JD-Core Version:    0.7.0.1
 */