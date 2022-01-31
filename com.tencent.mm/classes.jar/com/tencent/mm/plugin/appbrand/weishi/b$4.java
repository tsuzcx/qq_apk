package com.tencent.mm.plugin.appbrand.weishi;

import android.animation.ValueAnimator;
import android.support.v4.view.b.a;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$4
  implements Runnable
{
  b$4(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(133629);
    ViewParent localViewParent = this.jaf.getParent();
    if (!(localViewParent instanceof ViewGroup))
    {
      AppMethodBeat.o(133629);
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 255, 0 });
    localValueAnimator.addUpdateListener(new b.4.1(this, localViewParent));
    localValueAnimator.setStartDelay(Math.round((float)localValueAnimator.getDuration() * 0.8F));
    localValueAnimator.setDuration(Math.round((float)localValueAnimator.getDuration() * 0.2F));
    localValueAnimator.setInterpolator(new a());
    localValueAnimator.start();
    AppMethodBeat.o(133629);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.weishi.b.4
 * JD-Core Version:    0.7.0.1
 */