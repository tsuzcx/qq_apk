package com.tencent.mm.bs;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$6
  implements Animation.AnimationListener
{
  a$6(a parama) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(116311);
    this.whn.whc.getRubbishView().setVisibility(8);
    if (this.whn.whi != null) {
      this.whn.whi.h(Boolean.FALSE);
    }
    AppMethodBeat.o(116311);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bs.a.6
 * JD-Core Version:    0.7.0.1
 */