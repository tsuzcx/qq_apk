package com.tencent.mm.modelvoice;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.sdk.platformtools.y;

final class s$2
  implements MediaPlayer.OnErrorListener
{
  s$2(s params) {}
  
  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    y.d("MicroMsg.VoicePlayer", "OnErrorListener");
    if ((this.eLj.eLi != null) && (this.eLj.eKt))
    {
      y.d("MicroMsg.VoicePlayer", "OnErrorListener abandonFocus");
      this.eLj.eLi.zE();
    }
    if (this.eLj.eKA != null)
    {
      y.d("MicroMsg.VoicePlayer", "OnErrorListener onError");
      this.eLj.eKA.onError();
    }
    try
    {
      y.d("MicroMsg.VoicePlayer", "OnErrorListener release");
      this.eLj.eLh.release();
      this.eLj.status = -1;
      return false;
    }
    catch (Exception paramMediaPlayer)
    {
      for (;;)
      {
        y.e("MicroMsg.VoicePlayer", "setErrorListener File[" + this.eLj.fileName + "] ErrMsg[" + paramMediaPlayer.getStackTrace() + "]");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvoice.s.2
 * JD-Core Version:    0.7.0.1
 */