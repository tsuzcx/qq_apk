package com.tencent.mm.plugin.fav.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class r$4
  extends AnimatorListenerAdapter
{
  r$4(r paramr) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(107071);
    this.rzd.ryX.setAlpha(0.0F);
    AppMethodBeat.o(107071);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(107070);
    this.rzd.ryX.setAlpha(0.0F);
    AppMethodBeat.o(107070);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.r.4
 * JD-Core Version:    0.7.0.1
 */