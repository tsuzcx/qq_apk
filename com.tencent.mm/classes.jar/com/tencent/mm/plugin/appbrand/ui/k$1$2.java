package com.tencent.mm.plugin.appbrand.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

final class k$1$2
  implements ValueAnimator.AnimatorUpdateListener
{
  k$1$2(k.1 param1) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(102322);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    k.b(this.iPs.iPr).setTextColor(Color.argb(Math.round(255.0F * f), 0, 0, 0));
    k.c(this.iPs.iPr).setAlpha(f);
    k.d(this.iPs.iPr).setAlpha(f);
    k.d(this.iPs.iPr).setScaleY(f);
    k.d(this.iPs.iPr).setScaleX(f);
    this.iPs.iPr.K(-1, true);
    AppMethodBeat.o(102322);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.k.1.2
 * JD-Core Version:    0.7.0.1
 */