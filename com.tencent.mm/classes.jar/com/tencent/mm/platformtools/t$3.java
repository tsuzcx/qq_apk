package com.tencent.mm.platformtools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class t$3
  implements MediaPlayer.OnCompletionListener
{
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    AppMethodBeat.i(20715);
    try
    {
      paramMediaPlayer.release();
      AppMethodBeat.o(20715);
      return;
    }
    catch (Exception paramMediaPlayer)
    {
      Log.printErrStackTrace("MiroMsg.NotificationUtil", paramMediaPlayer, "", new Object[0]);
      AppMethodBeat.o(20715);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.platformtools.t.3
 * JD-Core Version:    0.7.0.1
 */