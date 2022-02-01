package com.tencent.mm.plugin.ball.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.a.a.a;
import com.tencent.mm.plugin.ball.f.d;
import com.tencent.mm.sdk.platformtools.ad;

final class FloatMenuView$4
  implements d.b
{
  FloatMenuView$4(FloatMenuView paramFloatMenuView) {}
  
  public final boolean a(final RecyclerView.w paramw, final Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(217347);
    if ((paramw == null) || (paramw.auu == null))
    {
      AppMethodBeat.o(217347);
      return false;
    }
    float f2 = paramw.auu.getMeasuredWidth();
    float f1 = f2;
    if (f2 <= 0.0F) {
      f1 = this.nMn.getMeasuredWidth();
    }
    f2 = f1;
    if (FloatMenuView.c(this.nMn)) {
      f2 = -f1;
    }
    ad.i("MicroMsg.FloatMenuView", "alvinluo animateRemove tranX: %f", new Object[] { Float.valueOf(f2) });
    paramw.auu.animate().alpha(0.0F).translationX(f2).setListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(217345);
        if (paramAnimatorListener != null) {
          paramAnimatorListener.onAnimationCancel(paramAnonymousAnimator);
        }
        AppMethodBeat.o(217345);
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(217344);
        if (paramAnimatorListener != null) {
          paramAnimatorListener.onAnimationEnd(paramAnonymousAnimator);
        }
        long l = 200L;
        if (!d.h(FloatMenuView.d(FloatMenuView.4.this.nMn))) {
          l = 0L;
        }
        h.LTJ.q(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(217342);
            if (((FloatMenuView.4.1.this.amn instanceof a.a)) && (((a.a)FloatMenuView.4.1.this.amn).nFy != null)) {
              FloatMenuView.a(FloatMenuView.4.this.nMn, ((a.a)FloatMenuView.4.1.this.amn).nFy, ((a.a)FloatMenuView.4.1.this.amn).position);
            }
            AppMethodBeat.o(217342);
          }
        }, l);
        AppMethodBeat.o(217344);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(217346);
        if (paramAnimatorListener != null) {
          paramAnimatorListener.onAnimationRepeat(paramAnonymousAnimator);
        }
        AppMethodBeat.o(217346);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(217343);
        if (paramAnimatorListener != null) {
          paramAnimatorListener.onAnimationStart(paramAnonymousAnimator);
        }
        AppMethodBeat.o(217343);
      }
    }).start();
    AppMethodBeat.o(217347);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.view.FloatMenuView.4
 * JD-Core Version:    0.7.0.1
 */