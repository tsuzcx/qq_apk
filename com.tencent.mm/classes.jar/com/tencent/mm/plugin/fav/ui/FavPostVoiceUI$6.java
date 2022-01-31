package com.tencent.mm.plugin.fav.ui;

import android.os.Message;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class FavPostVoiceUI$6
  extends ak
{
  FavPostVoiceUI$6(FavPostVoiceUI paramFavPostVoiceUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(74046);
    super.handleMessage(paramMessage);
    this.mxa.bxy();
    FavPostVoiceUI.g(this.mxa).setBackgroundResource(2130840130);
    FavPostVoiceUI.g(this.mxa).setEnabled(true);
    AppMethodBeat.o(74046);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavPostVoiceUI.6
 * JD-Core Version:    0.7.0.1
 */