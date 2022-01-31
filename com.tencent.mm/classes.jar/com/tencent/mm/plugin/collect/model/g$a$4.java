package com.tencent.mm.plugin.collect.model;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class g$a$4
  implements MediaPlayer.OnCompletionListener
{
  g$a$4(String paramString, MediaPlayer paramMediaPlayer, MediaPlayer.OnCompletionListener paramOnCompletionListener) {}
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    AppMethodBeat.i(40944);
    if (paramMediaPlayer == null) {}
    for (int i = -1;; i = paramMediaPlayer.hashCode())
    {
      ab.i("MicroMsg.F2fRcvVoiceListener", "play completion mp:%d  path:%s", new Object[] { Integer.valueOf(i), this.val$path });
      if (paramMediaPlayer != null) {
        paramMediaPlayer.release();
      }
      if (this.kNg != null) {
        this.kNg.release();
      }
      if (this.kNi != null) {
        this.kNi.onCompletion(paramMediaPlayer);
      }
      AppMethodBeat.o(40944);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.g.a.4
 * JD-Core Version:    0.7.0.1
 */