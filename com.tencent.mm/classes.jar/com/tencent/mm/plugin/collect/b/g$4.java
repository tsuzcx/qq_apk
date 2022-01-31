package com.tencent.mm.plugin.collect.b;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mm.plugin.collect.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.ConcurrentLinkedQueue;

final class g$4
  implements MediaPlayer.OnCompletionListener
{
  g$4(g paramg, g.b paramb) {}
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    y.i("MicroMsg.F2fRcvVoiceListener", "no need to play money this time");
    g.e(this.iHa);
    g.d(this.iHa);
    g.h(this.iHa);
    a.aEp();
    h.nFQ.f(14404, new Object[] { Integer.valueOf(4), this.iGZ.bHZ, "", "", Integer.valueOf(this.iGZ.iHf) });
    if (!g.f(this.iHa).isEmpty())
    {
      g.g(this.iHa);
      return;
    }
    g.aEy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.b.g.4
 * JD-Core Version:    0.7.0.1
 */