package com.tencent.mm.plugin.finder.viewmodel.component;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/viewmodel/component/FinderFeedMegaVideoBtnAnimUIC$startAppearAnim$1$2$4", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
public final class s$b$d
  extends AnimatorListenerAdapter
{
  s$b$d(View paramView) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    Object localObject1 = null;
    AppMethodBeat.i(283944);
    paramAnimator = new StringBuilder("onAnimationEnd: check bg status, width = ");
    Object localObject2 = this.Bka;
    p.j(localObject2, "bgView");
    StringBuilder localStringBuilder = paramAnimator.append(((View)localObject2).getWidth()).append(", color = ");
    paramAnimator = this.Bka;
    p.j(paramAnimator, "bgView");
    localObject2 = paramAnimator.getBackground();
    paramAnimator = (Animator)localObject2;
    if (!(localObject2 instanceof ColorDrawable)) {
      paramAnimator = null;
    }
    paramAnimator = (ColorDrawable)paramAnimator;
    if (paramAnimator != null) {}
    for (paramAnimator = Integer.toHexString(paramAnimator.getColor());; paramAnimator = localObject1)
    {
      Log.i("FinderFeedMegaVideoBtnAnimUIC", paramAnimator);
      AppMethodBeat.o(283944);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.s.b.d
 * JD-Core Version:    0.7.0.1
 */