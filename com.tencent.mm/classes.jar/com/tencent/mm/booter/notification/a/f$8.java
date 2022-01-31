package com.tencent.mm.booter.notification.a;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.sdk.platformtools.y;

final class f$8
  implements MediaPlayer.OnErrorListener
{
  f$8(f paramf) {}
  
  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.Notification.Tool.Sound", "play sound error, player: %s", new Object[] { this.dkb.djY });
    if (paramMediaPlayer != null) {
      paramMediaPlayer.release();
    }
    if (this.dkb.djY != null)
    {
      this.dkb.djY.release();
      y.i("MicroMsg.Notification.Tool.Sound", "play sound real error, player: %s,playerIsInit:%s", new Object[] { this.dkb.djY, Boolean.valueOf(this.dkb.djX) });
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.notification.a.f.8
 * JD-Core Version:    0.7.0.1
 */