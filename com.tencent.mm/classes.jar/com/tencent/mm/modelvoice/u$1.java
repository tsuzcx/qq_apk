package com.tencent.mm.modelvoice;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.sdk.platformtools.ab;

final class u$1
  implements MediaPlayer.OnCompletionListener
{
  u$1(u paramu) {}
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    AppMethodBeat.i(55839);
    ab.d("MicroMsg.VoicePlayer", "OnCompletionListener");
    if ((this.gaQ.gaP != null) && (this.gaQ.fZY))
    {
      ab.d("MicroMsg.VoicePlayer", "OnCompletionListener abandonFocus");
      this.gaQ.gaP.Mh();
    }
    if (this.gaQ.gaf != null)
    {
      ab.d("MicroMsg.VoicePlayer", "OnCompletionListener onCompletion");
      this.gaQ.gaf.Es();
    }
    try
    {
      ab.d("MicroMsg.VoicePlayer", "OnCompletionListener release");
      this.gaQ.gaO.release();
      this.gaQ.status = 0;
      AppMethodBeat.o(55839);
      return;
    }
    catch (Exception paramMediaPlayer)
    {
      ab.e("MicroMsg.VoicePlayer", "setCompletion File[" + this.gaQ.fileName + "] ErrMsg[" + paramMediaPlayer.getStackTrace() + "]");
      AppMethodBeat.o(55839);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvoice.u.1
 * JD-Core Version:    0.7.0.1
 */