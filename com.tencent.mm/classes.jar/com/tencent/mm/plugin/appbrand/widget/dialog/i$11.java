package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class i$11
  implements ValueAnimator.AnimatorUpdateListener
{
  i$11(i parami, ImageView paramImageView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(49875);
    this.uCI.setScaleX(((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    this.uCI.setScaleY(((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    AppMethodBeat.o(49875);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.i.11
 * JD-Core Version:    0.7.0.1
 */