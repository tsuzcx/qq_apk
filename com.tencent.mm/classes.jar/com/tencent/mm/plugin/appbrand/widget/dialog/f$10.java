package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class f$10
  implements ValueAnimator.AnimatorUpdateListener
{
  f$10(f paramf, ImageView paramImageView, TextView paramTextView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(49874);
    this.ngR.setAlpha(((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    this.ngS.setAlpha(((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    AppMethodBeat.o(49874);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.f.10
 * JD-Core Version:    0.7.0.1
 */