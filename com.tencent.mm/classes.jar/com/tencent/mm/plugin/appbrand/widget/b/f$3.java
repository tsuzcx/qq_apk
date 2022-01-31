package com.tencent.mm.plugin.appbrand.widget.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class f$3
  extends AnimatorListenerAdapter
{
  f$3(f paramf) {}
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(134255);
    this.jjB.jjy.setAlpha(0.0F);
    this.jjB.jjy.setVisibility(0);
    AppMethodBeat.o(134255);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.b.f.3
 * JD-Core Version:    0.7.0.1
 */