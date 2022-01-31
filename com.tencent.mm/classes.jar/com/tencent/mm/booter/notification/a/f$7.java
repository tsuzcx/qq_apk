package com.tencent.mm.booter.notification.a;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class f$7
  implements MediaPlayer.OnCompletionListener
{
  f$7(f paramf) {}
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    AppMethodBeat.i(16030);
    ab.i("MicroMsg.Notification.Tool.Sound", "play sound finish, player: %s", new Object[] { this.ebw.ebt });
    if (paramMediaPlayer != null) {
      paramMediaPlayer.release();
    }
    if (this.ebw.ebt != null)
    {
      this.ebw.ebt.release();
      ab.i("MicroMsg.Notification.Tool.Sound", "play sound real finish, player: %s,playerIsInit:%s", new Object[] { this.ebw.ebt, Boolean.valueOf(this.ebw.ebs) });
    }
    AppMethodBeat.o(16030);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.notification.a.f.7
 * JD-Core Version:    0.7.0.1
 */