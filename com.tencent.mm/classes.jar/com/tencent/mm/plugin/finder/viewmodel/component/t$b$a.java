package com.tencent.mm.plugin.finder.viewmodel.component;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderFeedMegaVideoBtnAnimUIC$startAppearAnim$1$2$4", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t$b$a
  extends AnimatorListenerAdapter
{
  t$b$a(View paramView) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(338740);
    StringBuilder localStringBuilder = new StringBuilder("onAnimationEnd: check bg status, width = ").append(this.evk.getWidth()).append(", color = ");
    paramAnimator = this.evk.getBackground();
    if ((paramAnimator instanceof ColorDrawable))
    {
      paramAnimator = (ColorDrawable)paramAnimator;
      if (paramAnimator != null) {
        break label80;
      }
    }
    label80:
    for (paramAnimator = null;; paramAnimator = Integer.toHexString(paramAnimator.getColor()))
    {
      Log.i("FinderFeedMegaVideoBtnAnimUIC", paramAnimator);
      AppMethodBeat.o(338740);
      return;
      paramAnimator = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.t.b.a
 * JD-Core Version:    0.7.0.1
 */