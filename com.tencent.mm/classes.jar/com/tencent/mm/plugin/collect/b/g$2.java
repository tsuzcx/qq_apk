package com.tencent.mm.plugin.collect.b;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.ConcurrentLinkedQueue;

final class g$2
  implements MediaPlayer.OnErrorListener
{
  g$2(g paramg, g.b paramb) {}
  
  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    y.e("MicroMsg.F2fRcvVoiceListener", "prefix play error");
    g.d(this.iHa);
    g.h(this.iHa);
    g.e(this.iHa);
    h.nFQ.f(14404, new Object[] { Integer.valueOf(3), this.iGZ.bHZ, Integer.valueOf(7), Integer.valueOf(paramInt1), Integer.valueOf(this.iGZ.iHf) });
    if (!g.f(this.iHa).isEmpty())
    {
      g.g(this.iHa);
      return false;
    }
    g.aEy();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.b.g.2
 * JD-Core Version:    0.7.0.1
 */