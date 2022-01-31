package com.tencent.mm.plugin.appbrand.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Color;
import android.view.View;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class k$1$1
  implements ValueAnimator.AnimatorUpdateListener
{
  k$1$1(k.1 param1, ViewParent paramViewParent) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(102321);
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    int j = Color.argb(i, 255, 255, 255);
    k.a(this.iPs.iPr).setBackgroundColor(j);
    k.a(this.iPs.iPr, j);
    if (i == 0) {
      this.iPs.iPr.post(new k.1.1.1(this));
    }
    AppMethodBeat.o(102321);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.k.1.1
 * JD-Core Version:    0.7.0.1
 */