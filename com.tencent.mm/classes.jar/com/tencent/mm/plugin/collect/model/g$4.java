package com.tencent.mm.plugin.collect.model;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.collect.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.ConcurrentLinkedQueue;

final class g$4
  implements MediaPlayer.OnCompletionListener
{
  g$4(g paramg, g.b paramb) {}
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    AppMethodBeat.i(40937);
    ab.i("MicroMsg.F2fRcvVoiceListener", "no need to play money this time");
    g.f(this.kNf);
    g.e(this.kNf);
    g.d(this.kNf);
    a.bhw();
    h.qsU.e(14404, new Object[] { Integer.valueOf(4), this.kNe.cpq, "", "", Integer.valueOf(this.kNe.kNj) });
    if (!g.g(this.kNf).isEmpty())
    {
      g.h(this.kNf);
      AppMethodBeat.o(40937);
      return;
    }
    g.bhF();
    AppMethodBeat.o(40937);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.g.4
 * JD-Core Version:    0.7.0.1
 */