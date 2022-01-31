package com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground;

import a.l;
import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/DynamicBackgroundGLSurfaceView$GLRenderer$onDrawFrame$1$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-appbrand-integration_release"})
public final class DynamicBackgroundGLSurfaceView$b$b$1
  implements Animator.AnimatorListener
{
  public final void onAnimationCancel(Animator paramAnimator)
  {
    this.jgN.jgM.jgF = false;
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(135225);
    paramAnimator = DynamicBackgroundGLSurfaceView.b.a(this.jgN.jgM);
    if (paramAnimator != null) {
      paramAnimator.setVisibility(4);
    }
    this.jgN.jgM.jgF = false;
    AppMethodBeat.o(135225);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.DynamicBackgroundGLSurfaceView.b.b.1
 * JD-Core Version:    0.7.0.1
 */