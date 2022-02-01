package com.tencent.mapsdk.internal;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class rd$3
  implements Animation.AnimationListener
{
  rd$3(rd paramrd) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(226197);
    rd.a(this.a, false);
    AppMethodBeat.o(226197);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    AppMethodBeat.i(226192);
    rd.a(this.a, true);
    AppMethodBeat.o(226192);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mapsdk.internal.rd.3
 * JD-Core Version:    0.7.0.1
 */