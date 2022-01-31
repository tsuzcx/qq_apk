package com.tencent.mm.plugin.appbrand.jsapi.l;

import android.animation.ArgbEvaluator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;

final class q$1
  implements Runnable
{
  q$1(q paramq, v paramv, String paramString, int paramInt1, int paramInt2, int paramInt3, double paramDouble) {}
  
  public final void run()
  {
    AppMethodBeat.i(141757);
    if (!this.hVQ.isRunning())
    {
      AppMethodBeat.o(141757);
      return;
    }
    int i = this.hVQ.getActionBar().getBackgroundColor();
    int j = this.hVQ.getActionBar().getForegroundColor();
    double d = this.hVQ.getActionBar().getBackgroundAlpha();
    Object localObject = null;
    if ("linear".equals(this.hVR)) {
      localObject = new LinearInterpolator();
    }
    for (;;)
    {
      ValueAnimator localValueAnimator1 = new ValueAnimator();
      localValueAnimator1.setIntValues(new int[] { i, this.hVS });
      localValueAnimator1.setEvaluator(new ArgbEvaluator());
      localValueAnimator1.setDuration(this.hVT);
      localValueAnimator1.setInterpolator((TimeInterpolator)localObject);
      localValueAnimator1.addUpdateListener(new q.1.1(this));
      ValueAnimator localValueAnimator2 = new ValueAnimator();
      localValueAnimator2.setIntValues(new int[] { j, this.hVU });
      localValueAnimator2.setEvaluator(new ArgbEvaluator());
      localValueAnimator2.setDuration(this.hVT);
      localValueAnimator2.setInterpolator((TimeInterpolator)localObject);
      localValueAnimator2.addUpdateListener(new q.1.2(this));
      ValueAnimator localValueAnimator3 = new ValueAnimator();
      localValueAnimator3.setFloatValues(new float[] { (float)d, (float)this.hVV });
      localValueAnimator3.setDuration(this.hVT);
      localValueAnimator3.setInterpolator((TimeInterpolator)localObject);
      localValueAnimator3.addUpdateListener(new q.1.3(this));
      localValueAnimator1.start();
      localValueAnimator2.start();
      AppMethodBeat.o(141757);
      return;
      if ("easeIn".equals(this.hVR)) {
        localObject = new AccelerateInterpolator();
      } else if ("easeOut".equals(this.hVR)) {
        localObject = new DecelerateInterpolator();
      } else if ("easeInOut".equals(this.hVR)) {
        localObject = new AccelerateDecelerateInterpolator();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.q.1
 * JD-Core Version:    0.7.0.1
 */