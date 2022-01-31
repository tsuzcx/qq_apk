package com.tencent.mm.modelvoice;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class l$1
  implements MediaPlayer.OnCompletionListener
{
  l$1(l paraml) {}
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    AppMethodBeat.i(55816);
    if ((this.gas.cih != null) && (this.gas.fZY)) {
      this.gas.cih.Mh();
    }
    try
    {
      this.gas.status = 0;
      this.gas.amp();
      try
      {
        l.a(this.gas);
        AppMethodBeat.o(55816);
        return;
      }
      catch (InterruptedException paramMediaPlayer)
      {
        ab.e("MicroMsg.SpeexPlayer", "exception:%s", new Object[] { bo.l(paramMediaPlayer) });
        AppMethodBeat.o(55816);
        return;
      }
      return;
    }
    catch (Exception paramMediaPlayer)
    {
      ab.e("MicroMsg.SpeexPlayer", "exception:%s", new Object[] { bo.l(paramMediaPlayer) });
      ab.e("MicroMsg.SpeexPlayer", "setCompletion File[" + this.gas.fileName + "] ErrMsg[" + paramMediaPlayer.getStackTrace() + "]");
      AppMethodBeat.o(55816);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvoice.l.1
 * JD-Core Version:    0.7.0.1
 */