package com.tencent.mm.plugin.fav.ui;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.TranslateAnimation;

final class FavPostVoiceUI$3
  implements Runnable
{
  FavPostVoiceUI$3(FavPostVoiceUI paramFavPostVoiceUI) {}
  
  public final void run()
  {
    this.kcp.findViewById(n.e.voice_rcd_hint).setVisibility(0);
    FavPostVoiceUI.d(this.kcp).setVisibility(0);
    this.kcp.findViewById(n.e.fav_post_voice_footer).setVisibility(0);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(300L);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    localTranslateAnimation.setDuration(300L);
    FavPostVoiceUI.d(this.kcp).startAnimation(localAlphaAnimation);
    this.kcp.findViewById(n.e.voice_rcd_hint).startAnimation(localAlphaAnimation);
    this.kcp.findViewById(n.e.fav_post_voice_footer).startAnimation(localTranslateAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavPostVoiceUI.3
 * JD-Core Version:    0.7.0.1
 */