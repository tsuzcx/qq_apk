package com.tencent.mm.modelvoice;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.sdk.platformtools.ab;

final class u$2
  implements MediaPlayer.OnErrorListener
{
  u$2(u paramu) {}
  
  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(55840);
    ab.d("MicroMsg.VoicePlayer", "OnErrorListener");
    if ((this.gaQ.gaP != null) && (this.gaQ.fZY))
    {
      ab.d("MicroMsg.VoicePlayer", "OnErrorListener abandonFocus");
      this.gaQ.gaP.Mh();
    }
    if (this.gaQ.gag != null)
    {
      ab.d("MicroMsg.VoicePlayer", "OnErrorListener onError");
      this.gaQ.gag.onError();
    }
    try
    {
      ab.d("MicroMsg.VoicePlayer", "OnErrorListener release");
      this.gaQ.gaO.release();
      this.gaQ.status = -1;
      AppMethodBeat.o(55840);
      return false;
    }
    catch (Exception paramMediaPlayer)
    {
      for (;;)
      {
        ab.e("MicroMsg.VoicePlayer", "setErrorListener File[" + this.gaQ.fileName + "] ErrMsg[" + paramMediaPlayer.getStackTrace() + "]");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelvoice.u.2
 * JD-Core Version:    0.7.0.1
 */