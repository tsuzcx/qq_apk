package com.tencent.mm.modelvoice;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.sdk.platformtools.y;

final class s$1
  implements MediaPlayer.OnCompletionListener
{
  s$1(s params) {}
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    y.d("MicroMsg.VoicePlayer", "OnCompletionListener");
    if ((this.eLj.eLi != null) && (this.eLj.eKt))
    {
      y.d("MicroMsg.VoicePlayer", "OnCompletionListener abandonFocus");
      this.eLj.eLi.zE();
    }
    if (this.eLj.eKz != null)
    {
      y.d("MicroMsg.VoicePlayer", "OnCompletionListener onCompletion");
      this.eLj.eKz.ug();
    }
    try
    {
      y.d("MicroMsg.VoicePlayer", "OnCompletionListener release");
      this.eLj.eLh.release();
      this.eLj.status = 0;
      return;
    }
    catch (Exception paramMediaPlayer)
    {
      y.e("MicroMsg.VoicePlayer", "setCompletion File[" + this.eLj.fileName + "] ErrMsg[" + paramMediaPlayer.getStackTrace() + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvoice.s.1
 * JD-Core Version:    0.7.0.1
 */