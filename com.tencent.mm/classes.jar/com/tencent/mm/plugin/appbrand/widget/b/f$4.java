package com.tencent.mm.plugin.appbrand.widget.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class f$4
  extends AnimatorListenerAdapter
{
  f$4(f paramf) {}
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(134256);
    this.jjB.jjz.setAlpha(0.0F);
    this.jjB.jjz.setVisibility(0);
    AppMethodBeat.o(134256);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.b.f.4
 * JD-Core Version:    0.7.0.1
 */