package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class RecentAppBrandViewContainer$3
  implements Animator.AnimatorListener
{
  RecentAppBrandViewContainer$3(RecentAppBrandViewContainer paramRecentAppBrandViewContainer) {}
  
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(133952);
    RecentAppBrandViewContainer.c(this.jgk).setVisibility(8);
    RecentAppBrandViewContainer.c(this.jgk).setScaleX(1.0F);
    RecentAppBrandViewContainer.c(this.jgk).setScaleY(1.0F);
    if ((RecentAppBrandViewContainer.d(this.jgk) != null) && (RecentAppBrandViewContainer.d(this.jgk).getAdapter() != null) && (3 < RecentAppBrandViewContainer.d(this.jgk).getDataCount()))
    {
      paramAnimator = RecentAppBrandViewContainer.d(this.jgk).qe(3);
      if (paramAnimator != null)
      {
        RecentAppBrandViewContainer.d(this.jgk).getShowList().add(3, paramAnimator);
        RecentAppBrandViewContainer.d(this.jgk).getAdapter().bS(3);
      }
    }
    AppMethodBeat.o(133952);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.RecentAppBrandViewContainer.3
 * JD-Core Version:    0.7.0.1
 */