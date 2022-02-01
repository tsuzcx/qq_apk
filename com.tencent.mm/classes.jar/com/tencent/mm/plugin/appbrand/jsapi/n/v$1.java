package com.tencent.mm.plugin.appbrand.jsapi.n;

import android.animation.ArgbEvaluator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.co;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;

final class v$1
  implements Runnable
{
  v$1(v paramv, d paramd, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, double paramDouble) {}
  
  public final void run()
  {
    Object localObject = null;
    AppMethodBeat.i(138232);
    final z localz = co.i(this.kww);
    if (localz == null)
    {
      this.kww.h(this.cjS, this.lfz.e("fail:page don't exist", null));
      AppMethodBeat.o(138232);
      return;
    }
    if (!localz.isRunning())
    {
      AppMethodBeat.o(138232);
      return;
    }
    int i = localz.bvi().getBackgroundColor();
    int j = localz.bvi().getForegroundColor();
    double d = localz.bvi().getBackgroundAlpha();
    if ("linear".equals(this.lfu)) {
      localObject = new LinearInterpolator();
    }
    for (;;)
    {
      ValueAnimator localValueAnimator1 = new ValueAnimator();
      localValueAnimator1.setIntValues(new int[] { i, this.lfv });
      localValueAnimator1.setEvaluator(new ArgbEvaluator());
      localValueAnimator1.setDuration(this.lfw);
      localValueAnimator1.setInterpolator((TimeInterpolator)localObject);
      localValueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(138229);
          localz.sD(((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          AppMethodBeat.o(138229);
        }
      });
      ValueAnimator localValueAnimator2 = new ValueAnimator();
      localValueAnimator2.setIntValues(new int[] { j, this.lfx });
      localValueAnimator2.setEvaluator(new ArgbEvaluator());
      localValueAnimator2.setDuration(this.lfw);
      localValueAnimator2.setInterpolator((TimeInterpolator)localObject);
      localValueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(138230);
          localz.sE(((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          AppMethodBeat.o(138230);
        }
      });
      ValueAnimator localValueAnimator3 = new ValueAnimator();
      localValueAnimator3.setFloatValues(new float[] { (float)d, (float)this.lfy });
      localValueAnimator3.setDuration(this.lfw);
      localValueAnimator3.setInterpolator((TimeInterpolator)localObject);
      localValueAnimator3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(138231);
          double d = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          localz.r(d);
          AppMethodBeat.o(138231);
        }
      });
      localValueAnimator1.start();
      localValueAnimator2.start();
      AppMethodBeat.o(138232);
      return;
      if ("easeIn".equals(this.lfu)) {
        localObject = new AccelerateInterpolator();
      } else if ("easeOut".equals(this.lfu)) {
        localObject = new DecelerateInterpolator();
      } else if ("easeInOut".equals(this.lfu)) {
        localObject = new AccelerateDecelerateInterpolator();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.n.v.1
 * JD-Core Version:    0.7.0.1
 */