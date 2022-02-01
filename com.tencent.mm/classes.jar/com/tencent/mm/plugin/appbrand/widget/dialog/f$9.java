package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class f$9
  extends AnimatorListenerAdapter
{
  f$9(f paramf) {}
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(49873);
    this.oqB.Iac.setAlpha(0.0F);
    this.oqB.Iac.setVisibility(0);
    AppMethodBeat.o(49873);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.f.9
 * JD-Core Version:    0.7.0.1
 */