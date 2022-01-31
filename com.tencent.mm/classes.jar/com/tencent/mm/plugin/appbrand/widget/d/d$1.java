package com.tencent.mm.plugin.appbrand.widget.d;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;

final class d$1
  implements ValueAnimator.AnimatorUpdateListener
{
  d$1(d paramd, f paramf1, f paramf2, double[] paramArrayOfDouble) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (this.hzv.equals(this.hzw)) {
      return;
    }
    double d4 = Double.parseDouble(String.valueOf(paramValueAnimator.getAnimatedValue()));
    double d1 = this.hzv.x;
    double d2 = (this.hzw.x - this.hzv.x) * d4 / this.hzx[0];
    double d3 = this.hzv.y;
    d4 = d4 * (this.hzw.y - this.hzv.y) / this.hzx[0];
    paramValueAnimator = this.hzy.hzs;
    g localg = this.hzy.hzu;
    f localf = new f(d1 + d2, d4 + d3);
    d1 = localf.x / localg.hzG;
    paramValueAnimator.setPosition(new LatLng(90.0D - Math.toDegrees(Math.atan(Math.exp(-(0.5D - localf.y / localg.hzG) * 2.0D * 3.141592653589793D)) * 2.0D), (d1 - 0.5D) * 360.0D));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.d.d.1
 * JD-Core Version:    0.7.0.1
 */