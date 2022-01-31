package com.tencent.mm.booter.notification.a;

import android.media.MediaPlayer;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class f$1
  extends ah
{
  f$1(f paramf, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    y.i("MicroMsg.Notification.Tool.Sound", "play sound handler, try to stop notify mediaplayer playerIsInit:%s", new Object[] { Boolean.valueOf(this.dkb.djX) });
    try
    {
      if (this.dkb.djY != null)
      {
        if (this.dkb.djY.isPlaying()) {
          this.dkb.djY.stop();
        }
        this.dkb.djY.release();
        this.dkb.djX = false;
        y.i("MicroMsg.Notification.Tool.Sound", "play sound handler, try to stop notify mediaplayer done playerIsInit:%s", new Object[] { Boolean.valueOf(this.dkb.djX) });
      }
      return;
    }
    catch (IllegalStateException paramMessage)
    {
      do
      {
        y.w("MicroMsg.Notification.Tool.Sound", "Exception in playSoundHander,playerIsInit:%s", new Object[] { Boolean.valueOf(this.dkb.djX) });
      } while (this.dkb.djY == null);
      this.dkb.djY.release();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.booter.notification.a.f.1
 * JD-Core Version:    0.7.0.1
 */