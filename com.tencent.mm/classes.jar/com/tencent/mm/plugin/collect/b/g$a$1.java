package com.tencent.mm.plugin.collect.b;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.sdk.platformtools.y;

final class g$a$1
  implements MediaPlayer.OnErrorListener
{
  g$a$1(MediaPlayer paramMediaPlayer, MediaPlayer.OnErrorListener paramOnErrorListener) {}
  
  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.F2fRcvVoiceListener", "onError, what: %d, extra: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramMediaPlayer != null) {}
    try
    {
      paramMediaPlayer.release();
      if (this.iHc != null) {
        this.iHc.release();
      }
    }
    catch (Exception localException)
    {
      label47:
      break label47;
    }
    if (this.iHd != null) {
      this.iHd.onError(paramMediaPlayer, paramInt1, paramInt2);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.b.g.a.1
 * JD-Core Version:    0.7.0.1
 */