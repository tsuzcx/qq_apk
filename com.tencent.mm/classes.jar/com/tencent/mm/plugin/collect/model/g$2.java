package com.tencent.mm.plugin.collect.model;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.ConcurrentLinkedQueue;

final class g$2
  implements MediaPlayer.OnErrorListener
{
  g$2(g paramg, g.b paramb) {}
  
  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(40935);
    ab.e("MicroMsg.F2fRcvVoiceListener", "prefix play error");
    g.e(this.kNf);
    g.d(this.kNf);
    g.f(this.kNf);
    h.qsU.e(14404, new Object[] { Integer.valueOf(3), this.kNe.cpq, Integer.valueOf(7), Integer.valueOf(paramInt1), Integer.valueOf(this.kNe.kNj) });
    if (!g.g(this.kNf).isEmpty()) {
      g.h(this.kNf);
    }
    for (;;)
    {
      AppMethodBeat.o(40935);
      return false;
      g.bhF();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.g.2
 * JD-Core Version:    0.7.0.1
 */