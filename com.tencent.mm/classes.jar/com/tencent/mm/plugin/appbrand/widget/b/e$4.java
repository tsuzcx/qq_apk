package com.tencent.mm.plugin.appbrand.widget.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

final class e$4
  extends AnimatorListenerAdapter
{
  e$4(e parame, View paramView, k paramk) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(77407);
    onAnimationEnd(paramAnimator);
    AppMethodBeat.o(77407);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(77408);
    this.jjs.setVisibility(8);
    e.b(this.jjq).remove(this.jjr);
    e.c(this.jjq);
    this.jjq.post(new e.4.1(this));
    AppMethodBeat.o(77408);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.b.e.4
 * JD-Core Version:    0.7.0.1
 */