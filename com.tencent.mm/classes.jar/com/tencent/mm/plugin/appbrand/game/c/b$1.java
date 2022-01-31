package com.tencent.mm.plugin.appbrand.game.c;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.View.OnClickListener;

final class b$1
  implements View.OnClickListener
{
  b$1(b paramb) {}
  
  public final void onClick(View paramView)
  {
    paramView = this.gbg;
    if (paramView.gbc)
    {
      localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      localValueAnimator.addUpdateListener(new b.3(paramView));
      localValueAnimator.start();
      paramView.gbc = false;
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    localValueAnimator.addUpdateListener(new b.4(paramView));
    localValueAnimator.start();
    paramView.gbc = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.c.b.1
 * JD-Core Version:    0.7.0.1
 */