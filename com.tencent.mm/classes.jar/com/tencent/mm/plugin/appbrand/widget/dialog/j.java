package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class j
{
  ValueAnimator animator;
  private int rZx;
  View view;
  
  public j(View paramView)
  {
    this.view = paramView;
  }
  
  final void c(int paramInt, final Runnable paramRunnable)
  {
    AppMethodBeat.i(131496);
    if (this.view == null)
    {
      AppMethodBeat.o(131496);
      return;
    }
    if ((isRunning()) && (this.rZx == paramInt))
    {
      AppMethodBeat.o(131496);
      return;
    }
    this.rZx = paramInt;
    if (((this.view.getBackground() instanceof ColorDrawable)) && (((ColorDrawable)this.view.getBackground()).getColor() == paramInt))
    {
      if (paramRunnable != null) {
        paramRunnable.run();
      }
      if (this.animator != null) {
        this.animator.cancel();
      }
      AppMethodBeat.o(131496);
      return;
    }
    paramRunnable = new AnimatorListenerAdapter()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        j.this.animator = null;
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(131494);
        if (paramRunnable != null) {
          paramRunnable.run();
        }
        j.this.animator = null;
        AppMethodBeat.o(131494);
      }
    };
    if ((this.animator != null) && (this.animator.isStarted()) && (this.animator.isRunning()) && (this.rZx == paramInt))
    {
      this.animator.addListener(paramRunnable);
      AppMethodBeat.o(131496);
      return;
    }
    if (this.animator != null) {
      this.animator.cancel();
    }
    if ((this.view.getBackground() instanceof ColorDrawable)) {}
    for (paramInt = ((ColorDrawable)this.view.getBackground()).getColor();; paramInt = 0)
    {
      this.animator = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.rZx) });
      this.animator.addListener(paramRunnable);
      this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(131495);
          if (j.this.view != null) {
            j.this.view.setBackgroundColor(((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          }
          AppMethodBeat.o(131495);
        }
      });
      this.animator.start();
      AppMethodBeat.o(131496);
      return;
    }
  }
  
  final void cancel()
  {
    AppMethodBeat.i(131497);
    if (this.animator != null) {
      this.animator.cancel();
    }
    AppMethodBeat.o(131497);
  }
  
  final boolean isRunning()
  {
    AppMethodBeat.i(131498);
    if ((this.animator != null) && (this.animator.isRunning()))
    {
      AppMethodBeat.o(131498);
      return true;
    }
    AppMethodBeat.o(131498);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.j
 * JD-Core Version:    0.7.0.1
 */