package com.tencent.mm.plugin.collect.model;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.collect.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.ConcurrentLinkedQueue;

final class g$6
  implements MediaPlayer.OnCompletionListener
{
  g$6(g paramg, g.b paramb) {}
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    AppMethodBeat.i(40939);
    ab.i("MicroMsg.F2fRcvVoiceListener", "play done");
    g.e(this.kNf);
    g.i(this.kNf);
    g.f(this.kNf);
    if (a.bhw().kMJ) {
      h.qsU.e(14404, new Object[] { Integer.valueOf(1), this.kNe.cpq, "", "", Integer.valueOf(this.kNe.kNj) });
    }
    while (!g.g(this.kNf).isEmpty())
    {
      g.h(this.kNf);
      AppMethodBeat.o(40939);
      return;
      h.qsU.e(14404, new Object[] { Integer.valueOf(2), this.kNe.cpq, "", "", Integer.valueOf(this.kNe.kNj) });
    }
    g.bhF();
    AppMethodBeat.o(40939);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.g.6
 * JD-Core Version:    0.7.0.1
 */