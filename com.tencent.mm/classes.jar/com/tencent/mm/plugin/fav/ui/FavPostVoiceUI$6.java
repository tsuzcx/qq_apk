package com.tencent.mm.plugin.fav.ui;

import android.os.Message;
import android.widget.Button;
import com.tencent.mm.sdk.platformtools.ah;

final class FavPostVoiceUI$6
  extends ah
{
  FavPostVoiceUI$6(FavPostVoiceUI paramFavPostVoiceUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    this.kcp.aRj();
    FavPostVoiceUI.g(this.kcp).setBackgroundResource(n.d.record_shape_press);
    FavPostVoiceUI.g(this.kcp).setEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavPostVoiceUI.6
 * JD-Core Version:    0.7.0.1
 */