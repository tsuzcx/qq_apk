package com.tencent.mm.plugin.collect.model;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

final class g$5
  implements MediaPlayer.OnErrorListener
{
  g$5(g paramg, g.b paramb) {}
  
  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(40938);
    ab.e("MicroMsg.F2fRcvVoiceListener", "no need play money error");
    g.f(this.kNf);
    g.e(this.kNf);
    g.d(this.kNf);
    h.qsU.e(14404, new Object[] { Integer.valueOf(3), this.kNe.cpq, Integer.valueOf(7), Integer.valueOf(paramInt1), Integer.valueOf(this.kNe.kNj) });
    AppMethodBeat.o(40938);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.g.5
 * JD-Core Version:    0.7.0.1
 */