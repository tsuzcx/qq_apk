package com.tencent.mm.plugin.appbrand.aa;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$3
  implements Runnable
{
  b$3(b paramb, d.g.a.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(49338);
    final ViewParent localViewParent = this.mWL.getParent();
    if (!(localViewParent instanceof ViewGroup))
    {
      AppMethodBeat.o(49338);
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 255, 0 });
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(49337);
        int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        int j = Color.argb(i, 0, 0, 0);
        b.b(b.3.this.mWL).setBackgroundColor(j);
        if (i == 0) {
          b.3.this.mWL.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(49336);
              b.3.this.mWL.setVisibility(8);
              ((ViewGroup)b.3.1.this.mGA).removeView(b.3.this.mWL);
              if (b.3.this.mGz != null) {
                b.3.this.mGz.invoke();
              }
              AppMethodBeat.o(49336);
            }
          });
        }
        AppMethodBeat.o(49337);
      }
    });
    localValueAnimator.setStartDelay(Math.round((float)localValueAnimator.getDuration() * 0.8F));
    localValueAnimator.setDuration(Math.round((float)localValueAnimator.getDuration() * 0.2F));
    localValueAnimator.setInterpolator(new android.support.v4.view.b.a());
    localValueAnimator.start();
    AppMethodBeat.o(49338);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.aa.b.3
 * JD-Core Version:    0.7.0.1
 */