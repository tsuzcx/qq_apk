package com.tencent.mm.modelvoice;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class l$2
  implements MediaPlayer.OnErrorListener
{
  l$2(l paraml) {}
  
  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(55817);
    ab.d("MicroMsg.SpeexPlayer", "onError");
    if ((this.gas.cih != null) && (this.gas.fZY)) {
      this.gas.cih.Mh();
    }
    if (this.gas.gag != null) {
      this.gas.gag.onError();
    }
    for (;;)
    {
      try
      {
        this.gas.status = -1;
        this.gas.amp();
      }
      catch (Exception paramMediaPlayer)
      {
        ab.e("MicroMsg.SpeexPlayer", "setErrorListener File[" + this.gas.fileName + "] ErrMsg[" + paramMediaPlayer.getStackTrace() + "]");
        continue;
      }
      try
      {
        l.a(this.gas);
        AppMethodBeat.o(55817);
        return false;
      }
      catch (InterruptedException paramMediaPlayer)
      {
        ab.e("MicroMsg.SpeexPlayer", "exception:%s", new Object[] { bo.l(paramMediaPlayer) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvoice.l.2
 * JD-Core Version:    0.7.0.1
 */