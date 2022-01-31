package com.tencent.mm.booter.notification.a;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class f$6
  implements MediaPlayer.OnErrorListener
{
  f$6(f paramf) {}
  
  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(16029);
    ab.i("MicroMsg.Notification.Tool.Sound", "WiredHeadset play sound error, player: %s", new Object[] { this.ebw.ebt });
    if (paramMediaPlayer != null) {
      paramMediaPlayer.release();
    }
    if (this.ebw.ebt != null) {
      this.ebw.ebt.release();
    }
    AppMethodBeat.o(16029);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.notification.a.f.6
 * JD-Core Version:    0.7.0.1
 */