package com.tencent.mm.plugin.appbrand.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.widget.d;
import com.tencent.mm.sdk.platformtools.al;

final class j$2
  implements Animation.AnimationListener
{
  j$2(Runnable paramRunnable, i parami) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(133155);
    if (this.inP != null) {
      al.d(this.inP);
    }
    AppMethodBeat.o(133155);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    AppMethodBeat.i(133156);
    this.gWQ.gPC.setWillNotDraw(false);
    AppMethodBeat.o(133156);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.j.2
 * JD-Core Version:    0.7.0.1
 */