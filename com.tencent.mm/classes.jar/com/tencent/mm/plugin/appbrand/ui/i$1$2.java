package com.tencent.mm.plugin.appbrand.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

final class i$1$2
  implements ValueAnimator.AnimatorUpdateListener
{
  i$1$2(i.1 param1) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    i.c(this.hev.heu).setTextColor(Color.argb(Math.round(255.0F * f), 0, 0, 0));
    i.d(this.hev.heu).setAlpha(f);
    i.e(this.hev.heu).setAlpha(f);
    i.e(this.hev.heu).setScaleY(f);
    i.e(this.hev.heu).setScaleX(f);
    if (f == 0.0F)
    {
      i.b(this.hev.heu);
      return;
    }
    this.hev.heu.av(-1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.i.1.2
 * JD-Core Version:    0.7.0.1
 */