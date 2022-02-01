package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$10
  implements ValueAnimator.AnimatorUpdateListener
{
  e$10(e parame, ImageView paramImageView, TextView paramTextView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(49874);
    this.rsb.setAlpha(((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    this.rsc.setAlpha(((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    AppMethodBeat.o(49874);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.e.10
 * JD-Core Version:    0.7.0.1
 */