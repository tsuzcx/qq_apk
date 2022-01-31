package com.tencent.mm.plugin.collect.b;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mm.sdk.platformtools.y;

final class g$a$4
  implements MediaPlayer.OnCompletionListener
{
  g$a$4(String paramString, MediaPlayer paramMediaPlayer, MediaPlayer.OnCompletionListener paramOnCompletionListener) {}
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (paramMediaPlayer == null) {}
    for (int i = -1;; i = paramMediaPlayer.hashCode())
    {
      y.i("MicroMsg.F2fRcvVoiceListener", "play completion mp:%d  path:%s", new Object[] { Integer.valueOf(i), this.dlh });
      if (paramMediaPlayer != null) {
        paramMediaPlayer.release();
      }
      if (this.iHc != null) {
        this.iHc.release();
      }
      if (this.iHe != null) {
        this.iHe.onCompletion(paramMediaPlayer);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.b.g.a.4
 * JD-Core Version:    0.7.0.1
 */