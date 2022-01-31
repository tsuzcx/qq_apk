package com.tencent.mm.plugin.fav.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FavPostVoiceUI$8
  implements Animation.AnimationListener
{
  FavPostVoiceUI$8(FavPostVoiceUI paramFavPostVoiceUI) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(74049);
    FavPostVoiceUI.l(this.mxa).post(new FavPostVoiceUI.8.1(this));
    AppMethodBeat.o(74049);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavPostVoiceUI.8
 * JD-Core Version:    0.7.0.1
 */