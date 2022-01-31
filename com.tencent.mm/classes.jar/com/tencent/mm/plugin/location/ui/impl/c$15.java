package com.tencent.mm.plugin.location.ui.impl;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMLoadMoreListView;

final class c$15
  implements Animation.AnimationListener
{
  c$15(c paramc, boolean paramBoolean) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    c.c(this.lJp, true);
    if (this.lJq)
    {
      this.lJp.tb(c.d(this.lJp));
      c.d(this.lJp, true);
    }
    for (;;)
    {
      c.s(this.lJp).clearAnimation();
      c.l(this.lJp).clearAnimation();
      c.t(this.lJp).clearAnimation();
      c.c(this.lJp).clearFocus();
      return;
      this.lJp.tb(c.e(this.lJp));
      c.d(this.lJp, false);
    }
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    y.d("MicroMsg.MMPoiMapUI", "newpoi start animation %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    c.c(this.lJp, false);
    c.a(this.lJp, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.c.15
 * JD-Core Version:    0.7.0.1
 */