package com.tencent.mm.plugin.facedetect.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$1$1
  implements Animation.AnimationListener
{
  a$1$1(a.1 param1) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(382);
    a.a(this.mla.mkZ).setVisibility(8);
    AppMethodBeat.o(382);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.a.1.1
 * JD-Core Version:    0.7.0.1
 */