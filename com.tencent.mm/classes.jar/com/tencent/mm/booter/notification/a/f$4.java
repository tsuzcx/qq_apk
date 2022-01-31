package com.tencent.mm.booter.notification.a;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.sdk.platformtools.y;

final class f$4
  implements MediaPlayer.OnErrorListener
{
  f$4(f paramf, AudioManager paramAudioManager) {}
  
  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.Notification.Tool.Sound", "WiredHeadset play sound error, player: %s", new Object[] { this.dkb.djY });
    this.dke.setMode(0);
    if (paramMediaPlayer != null) {
      paramMediaPlayer.release();
    }
    if (this.dkb.djY != null) {
      this.dkb.djY.release();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.booter.notification.a.f.4
 * JD-Core Version:    0.7.0.1
 */