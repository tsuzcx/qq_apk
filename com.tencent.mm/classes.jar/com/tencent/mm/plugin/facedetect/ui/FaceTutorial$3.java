package com.tencent.mm.plugin.facedetect.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FaceTutorial$3
  implements Runnable
{
  FaceTutorial$3(FaceTutorial paramFaceTutorial) {}
  
  public final void run()
  {
    AppMethodBeat.i(519);
    this.mmE.mkW.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(518);
        FaceTutorial.3.this.mmE.ldP.setVisibility(8);
        AppMethodBeat.o(518);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    this.mmE.ldP.startAnimation(this.mmE.mkW);
    AppMethodBeat.o(519);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceTutorial.3
 * JD-Core Version:    0.7.0.1
 */