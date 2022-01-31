package com.tencent.mm.booter.notification.a;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mm.sdk.platformtools.y;

final class f$7
  implements MediaPlayer.OnCompletionListener
{
  f$7(f paramf) {}
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    y.i("MicroMsg.Notification.Tool.Sound", "play sound finish, player: %s", new Object[] { this.dkb.djY });
    if (paramMediaPlayer != null) {
      paramMediaPlayer.release();
    }
    if (this.dkb.djY != null)
    {
      this.dkb.djY.release();
      y.i("MicroMsg.Notification.Tool.Sound", "play sound real finish, player: %s,playerIsInit:%s", new Object[] { this.dkb.djY, Boolean.valueOf(this.dkb.djX) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.notification.a.f.7
 * JD-Core Version:    0.7.0.1
 */