package com.tencent.mm.plugin.fav.ui;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.TranslateAnimation;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FavPostVoiceUI$3
  implements Runnable
{
  FavPostVoiceUI$3(FavPostVoiceUI paramFavPostVoiceUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(74043);
    this.mxa.findViewById(2131824070).setVisibility(0);
    FavPostVoiceUI.d(this.mxa).setVisibility(0);
    this.mxa.findViewById(2131824080).setVisibility(0);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(300L);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    localTranslateAnimation.setDuration(300L);
    FavPostVoiceUI.d(this.mxa).startAnimation(localAlphaAnimation);
    this.mxa.findViewById(2131824070).startAnimation(localAlphaAnimation);
    this.mxa.findViewById(2131824080).startAnimation(localTranslateAnimation);
    AppMethodBeat.o(74043);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavPostVoiceUI.3
 * JD-Core Version:    0.7.0.1
 */