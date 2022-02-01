package com.tencent.mm.plugin.collect.model;

import android.media.MediaPlayer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.sdk.platformtools.Log;

final class F2fRcvVoiceListener$9
  implements Runnable
{
  F2fRcvVoiceListener$9(MediaPlayer[] paramArrayOfMediaPlayer, Object paramObject) {}
  
  public final void run()
  {
    AppMethodBeat.i(293522);
    this.wYs[0] = new k();
    try
    {
      synchronized (this.val$lock)
      {
        this.val$lock.notify();
        AppMethodBeat.o(293522);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.F2fRcvVoiceListener", localException, "", new Object[0]);
      AppMethodBeat.o(293522);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.F2fRcvVoiceListener.9
 * JD-Core Version:    0.7.0.1
 */