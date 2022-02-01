package com.tencent.mm.plugin.finder.view.sidebar;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/sidebar/FinderSideBar$startContinueAnimation$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "p0", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$e
  implements Animation.AnimationListener
{
  a$e(a<ah> parama) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(344578);
    this.DNa.invoke();
    AppMethodBeat.o(344578);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.sidebar.a.e
 * JD-Core Version:    0.7.0.1
 */