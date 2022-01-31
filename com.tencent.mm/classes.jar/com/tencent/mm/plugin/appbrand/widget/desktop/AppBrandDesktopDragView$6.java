package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandDesktopDragView$6
  implements Animator.AnimatorListener
{
  AppBrandDesktopDragView$6(AppBrandDesktopDragView paramAppBrandDesktopDragView, View paramView) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(133755);
    AppBrandDesktopDragView.e(this.jdT);
    this.jdU.setVisibility(4);
    AppMethodBeat.o(133755);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(133754);
    AppBrandDesktopDragView.e(this.jdT);
    this.jdU.setVisibility(4);
    AppMethodBeat.o(133754);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopDragView.6
 * JD-Core Version:    0.7.0.1
 */