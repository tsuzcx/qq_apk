package com.tencent.mm.modelvoice;

import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.sdk.platformtools.y;

final class i$2
  implements MediaPlayer.OnErrorListener
{
  i$2(i parami) {}
  
  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.SilkPlayer", "onError");
    if ((i.a(this.eKx) != null) && (i.b(this.eKx))) {
      i.a(this.eKx).zE();
    }
    if (i.f(this.eKx) != null) {
      i.f(this.eKx).onError();
    }
    try
    {
      i.a(this.eKx, -1);
      if (i.c(this.eKx) != null)
      {
        y.i("MicroMsg.SilkPlayer", "mAudioTrack.stop()");
        i.c(this.eKx).stop();
        i.c(this.eKx).release();
        i.d(this.eKx);
      }
      return false;
    }
    catch (Exception paramMediaPlayer)
    {
      for (;;)
      {
        y.e("MicroMsg.SilkPlayer", "setErrorListener File[" + i.e(this.eKx) + "] ErrMsg[" + paramMediaPlayer.getStackTrace() + "]");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvoice.i.2
 * JD-Core Version:    0.7.0.1
 */