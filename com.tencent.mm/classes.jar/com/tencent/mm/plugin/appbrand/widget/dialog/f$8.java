package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class f$8
  extends AnimatorListenerAdapter
{
  f$8(f paramf) {}
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(49872);
    this.ngO.ngV.setAlpha(0.0F);
    this.ngO.ngV.setVisibility(0);
    AppMethodBeat.o(49872);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.f.8
 * JD-Core Version:    0.7.0.1
 */