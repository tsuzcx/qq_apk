package com.tencent.mm.plugin.appbrand.page;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class r$14
  implements Animation.AnimationListener
{
  r$14(r paramr, Runnable paramRunnable, o paramo) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(141670);
    if (this.val$runnable != null)
    {
      this.iwq.post(new r.14.1(this));
      AppMethodBeat.o(141670);
      return;
    }
    this.iwt.setTag(r.access$1600(), null);
    AppMethodBeat.o(141670);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.r.14
 * JD-Core Version:    0.7.0.1
 */