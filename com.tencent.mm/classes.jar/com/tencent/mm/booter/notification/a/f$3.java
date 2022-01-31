package com.tencent.mm.booter.notification.a;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mm.sdk.platformtools.y;

final class f$3
  implements MediaPlayer.OnCompletionListener
{
  f$3(f paramf, AudioManager paramAudioManager) {}
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    y.i("MicroMsg.Notification.Tool.Sound", "WiredHeadset play sound finish, player: %s", new Object[] { this.dkb.djY });
    this.dke.setMode(0);
    if (paramMediaPlayer != null) {
      paramMediaPlayer.release();
    }
    if (this.dkb.djY != null) {
      this.dkb.djY.release();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.booter.notification.a.f.3
 * JD-Core Version:    0.7.0.1
 */