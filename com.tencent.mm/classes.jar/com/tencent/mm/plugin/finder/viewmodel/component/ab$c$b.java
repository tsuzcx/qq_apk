package com.tencent.mm.plugin.finder.viewmodel.component;

import android.animation.Animator;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.animation.a;
import com.tencent.mm.plugin.finder.b.f;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$HorizontalVideoPreviewLayout$addPreview$2", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
public final class ab$c$b
  extends a
{
  ab$c$b(View paramView) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(236505);
    p.k(paramAnimator, "animation");
    paramAnimator = this.jLG;
    if (paramAnimator != null)
    {
      paramAnimator = paramAnimator.findViewById(b.f.avatar_iv);
      if (paramAnimator != null)
      {
        paramAnimator.setVisibility(4);
        AppMethodBeat.o(236505);
        return;
      }
    }
    AppMethodBeat.o(236505);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.ab.c.b
 * JD-Core Version:    0.7.0.1
 */