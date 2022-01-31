package com.tencent.mm.plugin.appbrand.widget.e;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$2
  implements ValueAnimator.AnimatorUpdateListener
{
  c$2(c paramc) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(51261);
    double d = Double.parseDouble(String.valueOf(paramValueAnimator.getAnimatedValue()));
    this.jrB.jrv.setRotation((float)d);
    AppMethodBeat.o(51261);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.e.c.2
 * JD-Core Version:    0.7.0.1
 */