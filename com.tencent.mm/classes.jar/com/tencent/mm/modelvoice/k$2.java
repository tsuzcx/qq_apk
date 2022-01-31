package com.tencent.mm.modelvoice;

import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.sdk.platformtools.ab;

final class k$2
  implements MediaPlayer.OnErrorListener
{
  k$2(k paramk) {}
  
  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(55794);
    ab.i("MicroMsg.SilkPlayer", "onError");
    if ((k.a(this.gad) != null) && (k.b(this.gad))) {
      k.a(this.gad).Mh();
    }
    if (k.f(this.gad) != null) {
      k.f(this.gad).onError();
    }
    try
    {
      k.a(this.gad, -1);
      if (k.c(this.gad) != null)
      {
        ab.i("MicroMsg.SilkPlayer", "mAudioTrack.stop()");
        k.c(this.gad).stop();
        k.c(this.gad).release();
        k.d(this.gad);
      }
      AppMethodBeat.o(55794);
      return false;
    }
    catch (Exception paramMediaPlayer)
    {
      for (;;)
      {
        ab.e("MicroMsg.SilkPlayer", "setErrorListener File[" + k.e(this.gad) + "] ErrMsg[" + paramMediaPlayer.getStackTrace() + "]");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelvoice.k.2
 * JD-Core Version:    0.7.0.1
 */