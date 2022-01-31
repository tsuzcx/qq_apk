package com.tencent.mm.plugin.appbrand.menu;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v4.view.t;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$1
  implements Runnable
{
  c$1(c paramc, View paramView1, View paramView2) {}
  
  public final void run()
  {
    AppMethodBeat.i(132198);
    if (!t.aw(this.iqu))
    {
      AppMethodBeat.o(132198);
      return;
    }
    this.iqu.animate().alpha(0.0F).setDuration(1000L).setListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(132197);
        super.onAnimationEnd(paramAnonymousAnimator);
        c.1.this.val$rootView.post(new c.1.1.1(this));
        AppMethodBeat.o(132197);
      }
    });
    AppMethodBeat.o(132198);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.c.1
 * JD-Core Version:    0.7.0.1
 */