package com.tencent.mm.plugin.collect.model;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class g$a$3
  implements MediaPlayer.OnErrorListener
{
  g$a$3(MediaPlayer paramMediaPlayer, MediaPlayer.OnErrorListener paramOnErrorListener) {}
  
  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(40943);
    ab.i("MicroMsg.F2fRcvVoiceListener", "onError, what: %d, extra: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramMediaPlayer != null) {}
    try
    {
      paramMediaPlayer.release();
      if (this.kNg != null) {
        this.kNg.release();
      }
    }
    catch (Exception localException)
    {
      label52:
      break label52;
    }
    if (this.kNh != null) {
      this.kNh.onError(paramMediaPlayer, paramInt1, paramInt2);
    }
    AppMethodBeat.o(40943);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.g.a.3
 * JD-Core Version:    0.7.0.1
 */