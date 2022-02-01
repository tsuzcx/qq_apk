package com.tencent.mm.plugin.finder.view.animation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/view/animation/LikeIconAnimationHelper$startWithAlpha$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
public final class b$e
  implements Animator.AnimatorListener
{
  b$e(View paramView) {}
  
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(168458);
    this.kfz.animate().alpha(0.0F).setStartDelay(300L).withEndAction((Runnable)new a(this)).start();
    AppMethodBeat.o(168458);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(b.e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(168457);
      this.sal.kfz.setScaleX(1.0F);
      this.sal.kfz.setScaleY(1.0F);
      this.sal.kfz.setAlpha(1.0F);
      this.sal.kfz.setVisibility(8);
      AppMethodBeat.o(168457);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.animation.b.e
 * JD-Core Version:    0.7.0.1
 */