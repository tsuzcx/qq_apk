package com.tencent.mm.booter.notification.a;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class f$3
  implements MediaPlayer.OnCompletionListener
{
  f$3(f paramf, AudioManager paramAudioManager) {}
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    AppMethodBeat.i(16026);
    ab.i("MicroMsg.Notification.Tool.Sound", "WiredHeadset play sound finish, player: %s", new Object[] { this.ebw.ebt });
    this.ebz.setMode(0);
    if (paramMediaPlayer != null) {
      paramMediaPlayer.release();
    }
    if (this.ebw.ebt != null) {
      this.ebw.ebt.release();
    }
    AppMethodBeat.o(16026);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.booter.notification.a.f.3
 * JD-Core Version:    0.7.0.1
 */