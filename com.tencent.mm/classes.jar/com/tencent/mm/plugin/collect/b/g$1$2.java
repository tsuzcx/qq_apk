package com.tencent.mm.plugin.collect.b;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.ConcurrentLinkedQueue;

final class g$1$2
  implements MediaPlayer.OnErrorListener
{
  g$1$2(g.1 param1) {}
  
  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    y.e("MicroMsg.F2fRcvVoiceListener", "play money error: %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    g.d(this.iHb.iHa);
    g.a(this.iHb.iHa, null);
    h.nFQ.f(14404, new Object[] { Integer.valueOf(3), this.iHb.iGZ.bHZ, Integer.valueOf(7), Integer.valueOf(paramInt1), Integer.valueOf(this.iHb.iGZ.iHf) });
    g.e(this.iHb.iHa);
    if (!g.f(this.iHb.iHa).isEmpty())
    {
      g.g(this.iHb.iHa);
      return false;
    }
    g.aEy();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.b.g.1.2
 * JD-Core Version:    0.7.0.1
 */