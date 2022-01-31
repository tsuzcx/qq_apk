package com.tencent.mm.plugin.appbrand.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Color;
import android.support.v4.view.b.a;
import android.support.v4.view.b.b;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

final class i$1
  implements Runnable
{
  i$1(i parami) {}
  
  public final void run()
  {
    Object localObject = this.heu.getParent();
    if (!(localObject instanceof ViewGroup)) {
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 255, 0 });
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        int j = Color.argb(i, 255, 255, 255);
        i.a(i.1.this.heu).setBackgroundColor(j);
        i.1.this.heu.setStatusBarColor(j);
        if (i == 0)
        {
          i.1.this.heu.post(new Runnable()
          {
            public final void run()
            {
              i.1.this.heu.setVisibility(8);
              ((ViewGroup)i.1.1.this.hcI).removeView(i.1.this.heu);
            }
          });
          i.b(i.1.this.heu);
        }
      }
    });
    localValueAnimator.setStartDelay(Math.round((float)localValueAnimator.getDuration() * 0.8F));
    localValueAnimator.setDuration(Math.round((float)localValueAnimator.getDuration() * 0.2F));
    localValueAnimator.setInterpolator(new a());
    localValueAnimator.start();
    localObject = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    ((ValueAnimator)localObject).setDuration(Math.round((float)((ValueAnimator)localObject).getDuration() * 0.8F));
    ((ValueAnimator)localObject).addUpdateListener(new i.1.2(this));
    ((ValueAnimator)localObject).setInterpolator(new b());
    ((ValueAnimator)localObject).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.i.1
 * JD-Core Version:    0.7.0.1
 */