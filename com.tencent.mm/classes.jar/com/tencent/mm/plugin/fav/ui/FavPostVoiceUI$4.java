package com.tencent.mm.plugin.fav.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.j.a;
import com.tencent.mm.sdk.platformtools.ap;

final class FavPostVoiceUI$4
  implements j.a
{
  FavPostVoiceUI$4(FavPostVoiceUI paramFavPostVoiceUI) {}
  
  public final void onError()
  {
    AppMethodBeat.i(74044);
    FavPostVoiceUI.e(this.mxa).stopTimer();
    FavPostVoiceUI.f(this.mxa).stopTimer();
    AppMethodBeat.o(74044);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavPostVoiceUI.4
 * JD-Core Version:    0.7.0.1
 */