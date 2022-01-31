package com.tencent.mm.booter.notification.a;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class f$5
  implements MediaPlayer.OnCompletionListener
{
  f$5(f paramf) {}
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    AppMethodBeat.i(16028);
    ab.i("MicroMsg.Notification.Tool.Sound", "WiredHeadset play sound finish, player: %s", new Object[] { this.ebw.ebt });
    if (paramMediaPlayer != null) {
      paramMediaPlayer.release();
    }
    if (this.ebw.ebt != null) {
      this.ebw.ebt.release();
    }
    AppMethodBeat.o(16028);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.booter.notification.a.f.5
 * JD-Core Version:    0.7.0.1
 */