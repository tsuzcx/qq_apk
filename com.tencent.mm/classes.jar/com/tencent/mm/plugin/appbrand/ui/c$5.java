package com.tencent.mm.plugin.appbrand.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$5
  implements Runnable
{
  c$5(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(132940);
    final ViewParent localViewParent = this.iMp.getParent();
    if (!(localViewParent instanceof ViewGroup))
    {
      AppMethodBeat.o(132940);
      return;
    }
    ViewPropertyAnimator localViewPropertyAnimator = this.iMp.animate();
    localViewPropertyAnimator.setStartDelay(((float)localViewPropertyAnimator.getDuration() * 0.8F));
    localViewPropertyAnimator.setDuration(((float)localViewPropertyAnimator.getDuration() * 1.0F));
    localViewPropertyAnimator.setListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(132939);
        c.5.this.iMp.post(new c.5.1.1(this));
        AppMethodBeat.o(132939);
      }
    });
    localViewPropertyAnimator.alpha(0.0F).start();
    AppMethodBeat.o(132940);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.c.5
 * JD-Core Version:    0.7.0.1
 */