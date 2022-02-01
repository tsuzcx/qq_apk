package com.tencent.mm.plugin.collect.model;

import android.media.MediaPlayer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.sdk.platformtools.ac;

final class g$9
  implements Runnable
{
  g$9(MediaPlayer[] paramArrayOfMediaPlayer, Object paramObject) {}
  
  public final void run()
  {
    AppMethodBeat.i(207039);
    this.owN[0] = new k();
    try
    {
      synchronized (this.owO)
      {
        this.owO.notify();
        AppMethodBeat.o(207039);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.F2fRcvVoiceListener", localException, "", new Object[0]);
      AppMethodBeat.o(207039);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.g.9
 * JD-Core Version:    0.7.0.1
 */