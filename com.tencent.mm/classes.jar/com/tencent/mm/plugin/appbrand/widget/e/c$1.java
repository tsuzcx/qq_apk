package com.tencent.mm.plugin.appbrand.widget.e;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$1
  implements ValueAnimator.AnimatorUpdateListener
{
  c$1(c paramc, e parame1, e parame2, double[] paramArrayOfDouble) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(51260);
    if (this.jry.equals(this.jrz))
    {
      AppMethodBeat.o(51260);
      return;
    }
    double d4 = Double.parseDouble(String.valueOf(paramValueAnimator.getAnimatedValue()));
    double d1 = this.jry.x;
    double d2 = (this.jrz.x - this.jry.x) * d4 / this.jrA[0];
    double d3 = this.jry.y;
    d4 = d4 * (this.jrz.y - this.jry.y) / this.jrA[0];
    paramValueAnimator = this.jrB.jrv;
    f localf = this.jrB.jrx;
    e locale = new e(d1 + d2, d4 + d3);
    d1 = locale.x / localf.jrJ;
    paramValueAnimator.setPosition(new LatLng(90.0D - Math.toDegrees(Math.atan(Math.exp(-(0.5D - locale.y / localf.jrJ) * 2.0D * 3.141592653589793D)) * 2.0D), (d1 - 0.5D) * 360.0D));
    AppMethodBeat.o(51260);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.e.c.1
 * JD-Core Version:    0.7.0.1
 */