package com.tencent.mm.plugin.collect.b;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mm.plugin.collect.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.ConcurrentLinkedQueue;

final class g$1$1
  implements MediaPlayer.OnCompletionListener
{
  g$1$1(g.1 param1) {}
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    y.i("MicroMsg.F2fRcvVoiceListener", "play done");
    g.d(this.iHb.iHa);
    g.a(this.iHb.iHa, null);
    g.e(this.iHb.iHa);
    if (a.aEp().iGG) {
      h.nFQ.f(14404, new Object[] { Integer.valueOf(1), this.iHb.iGZ.bHZ, "", "", Integer.valueOf(this.iHb.iGZ.iHf) });
    }
    while (!g.f(this.iHb.iHa).isEmpty())
    {
      g.g(this.iHb.iHa);
      return;
      h.nFQ.f(14404, new Object[] { Integer.valueOf(2), this.iHb.iGZ.bHZ, "", "", Integer.valueOf(this.iHb.iGZ.iHf) });
    }
    g.aEy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.b.g.1.1
 * JD-Core Version:    0.7.0.1
 */