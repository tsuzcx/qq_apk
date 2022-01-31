package com.tencent.mm.modelvoice;

import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class i$1
  implements MediaPlayer.OnCompletionListener
{
  i$1(i parami) {}
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if ((i.a(this.eKx) != null) && (i.b(this.eKx)))
    {
      y.i("MicroMsg.SilkPlayer", "silkPlayer play onCompletion abandonFocus");
      i.a(this.eKx).zE();
    }
    try
    {
      i.a(this.eKx, 0);
      if (i.c(this.eKx) != null)
      {
        y.i("MicroMsg.SilkPlayer", "mAudioTrack.stop()");
        i.c(this.eKx).stop();
        i.c(this.eKx).release();
        i.d(this.eKx);
      }
      return;
    }
    catch (Exception paramMediaPlayer)
    {
      y.e("MicroMsg.SilkPlayer", "exception:%s", new Object[] { bk.j(paramMediaPlayer) });
      y.e("MicroMsg.SilkPlayer", "setCompletion File[" + i.e(this.eKx) + "] ErrMsg[" + paramMediaPlayer.getStackTrace() + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelvoice.i.1
 * JD-Core Version:    0.7.0.1
 */