package com.tencent.mm.plugin.fav.ui;

import com.tencent.mm.f.b.j.a;
import com.tencent.mm.sdk.platformtools.am;

final class FavPostVoiceUI$4
  implements j.a
{
  FavPostVoiceUI$4(FavPostVoiceUI paramFavPostVoiceUI) {}
  
  public final void onError()
  {
    FavPostVoiceUI.e(this.kcp).stopTimer();
    FavPostVoiceUI.f(this.kcp).stopTimer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavPostVoiceUI.4
 * JD-Core Version:    0.7.0.1
 */