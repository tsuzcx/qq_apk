package com.tencent.mm.plugin.appbrand.widget.d;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mapsdk.raster.model.Marker;

final class d$2
  implements ValueAnimator.AnimatorUpdateListener
{
  d$2(d paramd) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    double d = Double.parseDouble(String.valueOf(paramValueAnimator.getAnimatedValue()));
    this.hzy.hzs.setRotation((float)d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.d.d.2
 * JD-Core Version:    0.7.0.1
 */