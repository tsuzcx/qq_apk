package com.tencent.mm.plugin.collect.model;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.ConcurrentLinkedQueue;

final class g$7
  implements MediaPlayer.OnErrorListener
{
  g$7(g paramg, g.b paramb) {}
  
  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(40940);
    ab.e("MicroMsg.F2fRcvVoiceListener", "play money error: %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    g.e(this.kNf);
    g.i(this.kNf);
    h.qsU.e(14404, new Object[] { Integer.valueOf(3), this.kNe.cpq, Integer.valueOf(7), Integer.valueOf(paramInt1), Integer.valueOf(this.kNe.kNj) });
    g.f(this.kNf);
    if (!g.g(this.kNf).isEmpty()) {
      g.h(this.kNf);
    }
    for (;;)
    {
      AppMethodBeat.o(40940);
      return false;
      g.bhF();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.g.7
 * JD-Core Version:    0.7.0.1
 */