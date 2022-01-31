package com.tencent.mm.booter.notification.a;

import android.media.MediaPlayer;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class f$1
  extends ak
{
  f$1(f paramf, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(16024);
    ab.i("MicroMsg.Notification.Tool.Sound", "play sound handler, try to stop notify mediaplayer playerIsInit:%s", new Object[] { Boolean.valueOf(this.ebw.ebs) });
    try
    {
      if (this.ebw.ebt != null)
      {
        if (this.ebw.ebt.isPlaying()) {
          this.ebw.ebt.stop();
        }
        this.ebw.ebt.release();
        this.ebw.ebs = false;
        ab.i("MicroMsg.Notification.Tool.Sound", "play sound handler, try to stop notify mediaplayer done playerIsInit:%s", new Object[] { Boolean.valueOf(this.ebw.ebs) });
      }
      AppMethodBeat.o(16024);
      return;
    }
    catch (IllegalStateException paramMessage)
    {
      ab.w("MicroMsg.Notification.Tool.Sound", "Exception in playSoundHander,playerIsInit:%s", new Object[] { Boolean.valueOf(this.ebw.ebs) });
      if (this.ebw.ebt != null) {
        this.ebw.ebt.release();
      }
      AppMethodBeat.o(16024);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.booter.notification.a.f.1
 * JD-Core Version:    0.7.0.1
 */