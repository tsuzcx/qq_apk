package com.tencent.mm.plugin.location.ui.impl;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MMLoadMoreListView;

final class c$15
  implements Animation.AnimationListener
{
  c$15(c paramc, boolean paramBoolean) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(113611);
    c.c(this.ogD, true);
    if (this.ogF)
    {
      this.ogD.yd(c.d(this.ogD));
      c.d(this.ogD, true);
    }
    for (;;)
    {
      c.s(this.ogD).clearAnimation();
      c.l(this.ogD).clearAnimation();
      c.t(this.ogD).clearAnimation();
      c.c(this.ogD).clearFocus();
      AppMethodBeat.o(113611);
      return;
      this.ogD.yd(c.e(this.ogD));
      c.d(this.ogD, false);
    }
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    AppMethodBeat.i(113610);
    ab.d("MicroMsg.MMPoiMapUI", "newpoi start animation %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    c.c(this.ogD, false);
    c.a(this.ogD, true);
    AppMethodBeat.o(113610);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.c.15
 * JD-Core Version:    0.7.0.1
 */